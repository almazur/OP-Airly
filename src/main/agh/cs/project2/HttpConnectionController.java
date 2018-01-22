package agh.cs.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// controls everything related to http request
public class HttpConnectionController {
    private HttpURLConnection connection;
    private Integer responseCode;

    public HttpConnectionController(){
        this.connection=null;
    }

    public void sendGetRequest(URL url,String apiKey) throws IOException {

        this.connection = (HttpURLConnection) url.openConnection();
        this.connection.setRequestMethod("GET");

        this.connection.setRequestProperty("Accept", "application/json");
        this.connection.setRequestProperty("apikey", apiKey);
        this.connection.setUseCaches(false);
        this.responseCode = this.connection.getResponseCode();
    }

    public String getResponse() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        String output;

        if (200 == this.responseCode) br = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
        else if (this.connection.getErrorStream() != null) {
            br = new BufferedReader(new InputStreamReader(this.connection.getErrorStream()));
        } else return "";
        while ((output = br.readLine()) != null) sb.append(output);
        return sb.toString();
    }

    public Integer getResponseCode(){
        return this.responseCode;
    }
    public String getContentType(){
        return this.connection.getContentType();
    }

    public void disconnect(){
        if(this.connection!=null) this.connection.disconnect();
    }
}
