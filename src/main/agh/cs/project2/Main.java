package agh.cs.project2;


import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            AirDataGetter airDataGetter = new AirDataGetter(args);
            HashMap<String,Object> data = airDataGetter.extractAirData();
            /*HttpConnectionController httpConnectionController = new HttpConnectionController();
            URL url;
            String response;

            //String apiKey ="343bb1201dc248c59b92e7fe286f0bdc";//"343bb1201dc248c59b92e7fe286f0bdc";
            String apiKey = System.getenv("api-key");*/

            //SecurityManager m = new SecurityManager();
            //m.checkPropertyAccess("api-key");

            // dane z najbliższego sensora
            //url = new URL("https://airapi.airly.eu/v1/nearestSensor/measurements?latitude=50.06&longitude=20&maxDistance=1000");
            // dane z konkretnego sensora
            //url = new URL("https://airapi.airly.eu/v1/sensor/measurements?sensorId=515&historyHours=24&historyResolutionHours=1");
            // info o konkretnym sensorze
            //url = new URL("https://airapi.airly.eu/v1/sensors/4");
            // lista sensorów
            //url = new URL("https://airapi.airly.eu/v1/sensors/current?southwestLat=50.05&southwestLong=19.7&northeastLat=50.15&northeastLong=19.8\n");

            /*httpConnectionController.sendGetRequest(url,apiKey);
            response= httpConnectionController.getResponse();
            Integer responseCode = httpConnectionController.getResponseCode();
            httpConnectionController.disconnect();

            //System.out.println(response);
            //System.out.println("RESPONSE: "+httpConnectionController.getContentType());

            ObjectMapper mapper = new ObjectMapper();
            //System.out.println("Response code: " + responseCode);
            if(responseCode==400 || responseCode==500) {
                ErrorResponse errorResponse = mapper.readValue(response, ErrorResponse.class);
                throw new HttpRequestException("Status "+ responseCode+System.getProperty("line.separator")+errorResponse.getErrors()[0].getMessage());
            } else if(responseCode==403 || responseCode == 404 || responseCode == 401){
                if(httpConnectionController.getContentType().contains("application/json;")){
                    JsonNode json = mapper.readTree(response);
                    if (json.has("errors")){
                        ErrorResponse errorResponse = mapper.readValue(response, ErrorResponse.class);
                        throw new HttpRequestException("Status "+ responseCode+System.getProperty("line.separator")+errorResponse.getErrors()[0].getMessage());
                    } else if(json.has("message")){
                        SingleErrorMessage messageStatus403 = mapper.readValue(response, SingleErrorMessage.class);
                        throw new HttpRequestException("Status "+ responseCode+System.getProperty("line.separator")+messageStatus403.getMessage());
                    }
                }
                throw new HttpRequestException("Status "+ responseCode);
            } else {
                //NearestSensorInfo sensor = mapper.readValue(response,NearestSensorInfo.class);
                DetailedMeasurements sensor = mapper.readValue(response,DetailedMeasurements.class);

                //Lung lung = new Lung();
                //lung.setColor("\u001B[33m");
                //System.out.println(lung.toString());
            }*/

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpRequestException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
