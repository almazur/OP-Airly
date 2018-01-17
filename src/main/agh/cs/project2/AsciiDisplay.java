package agh.cs.project2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AsciiDisplay {
    private HashMap<String,Double> currentMeasurements;
    private Measurements measurements;
    private SpecificDateMeasurements[] history;
    private Address address;
    private Integer pollutionLevel;
    private Boolean displayHistory;
    private Integer id;
    private String currentMeasurementsFrame;

    public AsciiDisplay(HashMap<String,Object> args,Boolean displayHistory){
        this.displayHistory = displayHistory;
        this.id = (Integer) args.get("id");
        this.measurements=(Measurements)args.get("currentMeasurements");
        this.currentMeasurements = saveSpecificData((Measurements)args.get("currentMeasurements"));
        this.address = (Address) args.get("address");
        this.pollutionLevel = ((Measurements) args.get("currentMeasurements")).getPollutionLevel();
        this.history = (SpecificDateMeasurements[]) args.get("history");
        String lineSeparator = System.getProperty("line.separator");
        this.currentMeasurementsFrame = ".--------------------------------------------------------------------." + lineSeparator +
                "|  @                                                                 |" + lineSeparator +
                "|  @                                                                 |" + lineSeparator +
                "|--------------------------------------------------------------------|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|  CAQI: @                                   #|" + lineSeparator +
                "|  pm2.5: @                                  #|" + lineSeparator +
                "|  pm10: @                                   #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|  temp.: @                                  #|" + lineSeparator +
                "|  press.: @                                 #|" + lineSeparator +
                "|  hum.: @                                   #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "|                                            #|" + lineSeparator +
                "'--------------------------------------------------------------------'";
    }

    public String getCurrentMeasurements(){
        List<String> asciiArtLines = getAsciiArtLines();
        String[] frameLines = currentMeasurementsFrame.split(System.getProperty("line.separator"));
        StringBuilder str = new StringBuilder();

        str.append(frameLines[0]).append(System.getProperty("line.separator"))
                .append(replaceAt(frameLines[1],address.getRoute()+" "+address.getStreetNumber())).append(System.getProperty("line.separator"))
                .append(replaceAt(frameLines[2],address.getLocality()+"(id: "+id+")")).append(System.getProperty("line.separator"))
                .append(frameLines[3]).append(System.getProperty("line.separator"));
        int i=4;

        for(String line : asciiArtLines){
            String[] frameParts = frameLines[i].split("#");
            //System.out.println(replaceAt(frameParts[0],getMeasurementValue(frameParts[0])));
            str.append(replaceAt(frameParts[0],getMeasurementValue(frameParts[0]))).
                    append(line).append(frameParts[1]).append(System.getProperty("line.separator"));
            i++;
        }
        str.append(frameLines[frameLines.length-1]);
        return str.toString();
    }

    private List<String> getAsciiArtLines(){
        if(pollutionLevel == null) return new NoDataAscii(Color.BLACK).getLines();
        if(pollutionLevel>5) return new Mask(Color.DARKRED).getLines();
        else return new Lung(pollutionLevelToColor(pollutionLevel)).getLines();
    }

    private String replaceAt(String line,String strReplacement){
        if(!line.contains("@")) return line;
        String[] lines = line.split("@");
        return lines[0]+ strReplacement + lines[1].substring(strReplacement.length()-1);
    }

    private String getMeasurementValue(String line){
                DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for(String param:this.currentMeasurements.keySet()){
            if(line.matches(".+"+param+".+")) {
                if(currentMeasurements.get(param)!=null) return df.format(currentMeasurements.get(param));
                return "-";
            }
        }
        return " ";
    }

    private HashMap<String,Double> saveSpecificData(Measurements measurements){
        HashMap<String,Double> data = new HashMap<>();
        data.put("CAQI",measurements.getAirQualityIndex());
        data.put("pm2.5",measurements.getPm25());
        data.put("pm10",measurements.getPm10());
        data.put("temp",measurements.getTemperature());
        data.put("press",measurements.getPressure());
        data.put("hum",measurements.getHumidity());
        return data;
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
