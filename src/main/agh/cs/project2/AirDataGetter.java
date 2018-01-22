package agh.cs.project2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.ParseException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

// gets required air data from server, basing on command line options
public class AirDataGetter {
    private CommandLine cmd;
    private HttpConnectionController httpConnectionController;
    private URL basicDataUrl;
    private URL detailedDataUrl;
    private String apiKey;

    public AirDataGetter(String[] args,CommandLine cmd){
        this.cmd = cmd;
        httpConnectionController = new HttpConnectionController();
        if(cmd.hasOption("k")) apiKey=cmd.getOptionValue("k");
        else apiKey=System.getenv("API_KEY");
    }

    // returns hashmap with needed data used by AsciiDisplay
    public HashMap<String,Object> extractAirData() throws IllegalArgumentException,IOException, HttpRequestException, MissingOptionException {
        HashMap<String,Object> data = new HashMap<>();
        setUrls();
        SensorInfo sensorInfo;

        if(cmd.hasOption("i")){
            System.out.println("Getting data for id...");
            sensorInfo = (SensorInfo) getDataFromUrl(basicDataUrl, SensorInfo.class);
        }
        else{
            System.out.println("Getting data for location...");
            sensorInfo = (SensorInfo) getDataFromUrl(basicDataUrl,NearestSensorInfo.class);
        }
        DetailedMeasurements measurements = (DetailedMeasurements) getDataFromUrl(detailedDataUrl,DetailedMeasurements.class);

        if(sensorInfo.getId() == null) throw new IllegalArgumentException("Data not available");

        data.put("id",sensorInfo.getId());
        data.put("address",sensorInfo.getAddress());
        data.put("location",sensorInfo.getLocation());
        data.put("currentMeasurements",measurements.getCurrentMeasurements());
        data.put("history",measurements.getHistory());
        data.put("hOption",cmd.hasOption("H"));
        return data;
    }

    private Object getDataFromUrl(URL url,Class<?> objectClass) throws IOException, HttpRequestException {
        httpConnectionController.sendGetRequest(url,apiKey);
        String response = httpConnectionController.getResponse();
        Integer responseCode = httpConnectionController.getResponseCode();
        httpConnectionController.disconnect();
        if(!responseCode.equals(200)) handleException(response,responseCode);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response,objectClass);
    }

    private void setUrls() throws MalformedURLException, MissingOptionException {
        if(this.cmd.hasOption("i")){
            detailedDataUrl = new URL("https://airapi.airly.eu/v1/sensor/measurements?sensorId="+cmd.getOptionValue("i")+"&historyHours=24&historyResolutionHours=1");
            basicDataUrl = new URL("https://airapi.airly.eu/v1/sensors/"+cmd.getOptionValue("i"));
        } else if (this.cmd.hasOption("t")){
            detailedDataUrl = new URL("https://airapi.airly.eu/v1/mapPoint/measurements?latitude="+cmd.getOptionValue("t")+"&longitude="+cmd.getOptionValue("g"));
            basicDataUrl = new URL("https://airapi.airly.eu/v1/nearestSensor/measurements?latitude="+cmd.getOptionValue("t")+"&longitude="+cmd.getOptionValue("g")+"&maxDistance=1000");
        } else throw new MissingOptionException("Missing required option: [-t display data for location; requires usage of longitude option]");

    }

    private void handleException(String response,Integer responseCode) throws IOException, HttpRequestException {

        ObjectMapper mapper = new ObjectMapper();
        if(responseCode==400 || responseCode==500) {
            ErrorResponse errorResponse = mapper.readValue(response, ErrorResponse.class);
            throw new HttpRequestException("Status "+ responseCode+System.getProperty("line.separator")+errorResponse.getErrors()[0].getMessage());
        } else if(responseCode==403 || responseCode == 404 || responseCode == 401) {
            if (httpConnectionController.getContentType().contains("application/json;")) {
                JsonNode json = mapper.readTree(response);
                if (json.has("errors")) {
                    ErrorResponse errorResponse = mapper.readValue(response, ErrorResponse.class);
                    throw new HttpRequestException("Status " + responseCode + System.getProperty("line.separator") + errorResponse.getErrors()[0].getMessage());
                } else if (json.has("message")) {
                    SingleErrorMessage singleErrorMessage = mapper.readValue(response, SingleErrorMessage.class);
                    throw new HttpRequestException("Status " + responseCode + System.getProperty("line.separator") + singleErrorMessage.getMessage());
                }
            }
            throw new HttpRequestException("Status " + responseCode);
        }
    }
}
