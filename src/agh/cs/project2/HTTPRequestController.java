package agh.cs.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequestController {
    private HttpURLConnection connection;

    HTTPRequestController(){
        this.connection=null;
    }

    public void sendGetRequest(URL url) throws IOException {
        this.connection = (HttpURLConnection) url.openConnection();
        this.connection.setRequestMethod("GET");

        this.connection.setRequestProperty("Accept", "application/json");
        this.connection.setRequestProperty("apikey", "343bb1201dc248c59b92e7fe286f0bdc");
        this.connection.setUseCaches(false); //?
        this.connection.setDoOutput(true);
    }

    public String getResponse() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        String output;

        if (200 <= this.connection.getResponseCode() && this.connection.getResponseCode() <= 299)
            br = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
        else br = new BufferedReader(new InputStreamReader(this.connection.getErrorStream()));

        while ((output = br.readLine()) != null) sb.append(output);

        return sb.toString();
    }

    public void disconnect(){
        if(this.connection!=null) this.connection.disconnect();
    }
}
