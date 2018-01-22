package agh.cs.project2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.HashMap;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) {
        try {
            Options options = new OptionsCreator().getOptions();
            CommandLine cmd = new DefaultParser().parse(options,args);
            if(cmd.hasOption("h")) {
                String header = "Display air data and history data for location or specific sensor";
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("app -g <arg> -t <arg> | -h | -i <arg> [-H] [-k <arg>] [-t <arg>]", header, options, "", false);
            } else {
                AirDataGetter airDataGetter = new AirDataGetter(args, cmd);
                HashMap<String, Object> data = airDataGetter.extractAirData();
                AsciiDisplay asciiDisplay = new AsciiDisplay(data);
                System.out.println(asciiDisplay.toString());
            }

        } catch (ProtocolException | MalformedURLException | HttpRequestException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("type -h or --help for help");
        }
    }
}
