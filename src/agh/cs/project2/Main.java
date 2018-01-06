package agh.cs.project2;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
//343bb1201dc248c59b92e7fe286f0bdc
        try {
            HTTPRequestController httpRequestController = new HTTPRequestController();
            URL url;
            String response;

            // dane z najbliższego sensora
            url = new URL("https://airapi.airly.eu/v1/nearestSensor/measurements?latitude=50.06&longitude=20&maxDistance=1000");
            // dane z konkretnego sensora
            //url = new URL("https://airapi.airly.eu/v1/sensor/measurements?sensorId=515&historyHours=0&historyResolutionHours=0");
            // info o konkretnym sensorze
            //url = new URL("https://airapi.airly.eu/v1/sensors/515");
            // lista sensorów
            //url = new URL("https://airapi.airly.eu/v1/sensors/current?southwestLat=50.05&southwestLong=19.7&northeastLat=50.15&northeastLong=19.8\n");

            httpRequestController.sendGetRequest(url);
            response=httpRequestController.getResponse();
            httpRequestController.disconnect();

            System.out.println(response);

            //ObjectMapper mapper = new ObjectMapper();
            //SensorMeasurements sensor = mapper.readValue(response,SensorMeasurements.class);
            //ParticularSensor sensor = mapper.readValue(response,ParticularSensor.class);

            //Lung lung = new Lung();
            //lung.setColor("\u001B[33m");
            //System.out.println(lung.toString());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
