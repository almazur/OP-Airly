package agh.cs.project2;

import java.util.HashMap;
import java.util.HashSet;

public class AsciiDisplay {
    private Integer id;
    private Measurements currentMeasurements;
    private SpecificDateMeasurements[] history;
    private Address address;
    private Location location;
    private Boolean displayHistory;
    private String currentMeasurementsFrame;

    AsciiDisplay(HashMap<String,Object> args,Boolean displayHistory){
        this.displayHistory = displayHistory;
        this.id = (Integer) args.get("id");
        this.currentMeasurements = (Measurements) args.get("currentMeasurements");
        this.address = (Address) args.get("address");
        this.location = (Location) args.get("location");
        this.history = (SpecificDateMeasurements[]) args.get("history");
        String lineSeparator = System.getProperty("line.separator");
        this.currentMeasurementsFrame = ".--------------------------------------------------------------------." + lineSeparator +
                "|  [adres]                                                           |" + lineSeparator +
                "|  [miasto]                                                          |" + lineSeparator +
                "|--------------------------------------------------------------------|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|  CAQI: _                                   %|" + lineSeparator +
                "|  pm2.5: _                                  %|" + lineSeparator +
                "|  pm10: _                                   %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|  temp.: _                                  %|" + lineSeparator +
                "|  press.: _                                 %|" + lineSeparator +
                "|  hum.: _                                   %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "|                                            %|" + lineSeparator +
                "'--------------------------------------------------------------------'";
    }

    public String getCurrentMeasurements(){
        String asciiArt = getAsciiArt();
        String[] asciiArtLines = asciiArt.split(System.getProperty("line.separator"));
        for(String line : asciiArtLines) System.out.println(line);
        String[] frameLine = currentMeasurementsFrame.split(System.getProperty("line.separator"));
        StringBuilder str = new StringBuilder();
        str.append(frameLine[0]).append(System.getProperty("line.separator"))
                .append(frameLine[1]).append(System.getProperty("line.separator"))
                .append(frameLine[2]).append(System.getProperty("line.separator"))
                .append(frameLine[3]).append(System.getProperty("line.separator"));
        int i=4;
        for(String line : asciiArtLines){
            System.out.println(str.toString());
            System.out.println("new line: "+frameLine[i].replaceFirst("%",line));
            str.append(frameLine[i].replaceFirst("%",line)).append(System.getProperty("line.separator"));
            i++;
        }
        str.append(frameLine[frameLine.length-1]);
        return str.toString();
    }

    private String getAsciiArt(){
        Integer pollutionLevel = currentMeasurements.getPollutionLevel();
        if(pollutionLevel>5) return new Mask(Color.DARKRED).toString();
        else return new Lung(pollutionLevelToColor(pollutionLevel)).toString();
    }

    private Color pollutionLevelToColor(Integer pollutionLevel){
        switch(pollutionLevel){
            case 0: return Color.DARKGREEN;
            case 1: return Color.GREEN;
            case 2: return Color.YELLOW;
            case 3: return Color.DARKYELLOW;
            case 4: return Color.RED;
            default: return Color.DARKRED;
        }
    }
}
