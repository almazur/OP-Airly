package agh.cs.project2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

// displays measurements and ascii art
public class AsciiDisplay {
    private HashMap<String,Double> currentMeasurements;
    private HashMap<String,String> units;
    private SpecificDateMeasurements[] history;
    private Address address;
    private Integer pollutionLevel;
    private Boolean displayHistory;
    private String currentMeasurementsFrame;
    private String historyMeasurementsFrame;

    // args = hashmap returned by AirDataGetter
    public AsciiDisplay(HashMap<String,Object> args){
        this.displayHistory = (Boolean) args.get("hOption");
        this.address = (Address) args.get("address");
        this.history = (SpecificDateMeasurements[]) args.get("history");
        this.pollutionLevel = ((Measurements) args.get("currentMeasurements")).getPollutionLevel();
        this.currentMeasurements = saveSpecificData((Measurements)args.get("currentMeasurements"));
        this.units = saveUnits();
        this.currentMeasurementsFrame = DisplayFrame.currentMeasurementsFrame.toString();
        this.historyMeasurementsFrame = DisplayFrame.historyMeasurementsFrame.toString();
    }

    public String toString(){
        return this.displayHistory ? (getCurrentMeasurements() + getHistoryMeasurements()) : getCurrentMeasurements();
    }

    private String getCurrentMeasurements(){
        List<String> asciiArtLines = getAsciiArtLines();
        String[] frameLines = currentMeasurementsFrame.split(System.getProperty("line.separator"));
        String addr = address.getRoute() != null ? address.getRoute()+" " : "";
        String streetNum = address.getStreetNumber() != null ? address.getStreetNumber() : "";
        StringBuilder str = new StringBuilder();

        str.append(frameLines[0]).append(System.getProperty("line.separator"))
                .append(replaceAt(frameLines[1],addr + streetNum)).append(System.getProperty("line.separator"))
                .append(replaceAt(frameLines[2],address.getLocality())).append(System.getProperty("line.separator"))
                .append(frameLines[3]).append(System.getProperty("line.separator"));

        int i=4;
        for(String line : asciiArtLines){
            String[] frameParts = frameLines[i].split("#");
            str.append(replaceAt(frameParts[0],getMeasurementValue(frameParts[0]))).
                    append(line).append(frameParts[1]).append(System.getProperty("line.separator"));
            i++;
        }
        str.append(frameLines[frameLines.length-1]).append(System.getProperty("line.separator"));
        return str.toString();
    }
    private String getHistoryMeasurements(){
        Boolean emptyHistory = true;
        for(SpecificDateMeasurements measurement : this.history){
            if(!isEmptySingleHistoryMeasurement(measurement.getMeasurements())) {
                emptyHistory = false;
                break;
            }
        }
        if(emptyHistory) return "No history data";

        StringBuilder str = new StringBuilder();

        for(SpecificDateMeasurements measurement : this.history){
            str.append(getSingleHistoryMeasurement(measurement.getFromDateTime(),measurement.getTillDateTime(),measurement.getMeasurements()));
        }
        return str.toString();
    }
    private String getSingleHistoryMeasurement(String fromDate, String toDate, Measurements measurements){
        String[] frameLines = historyMeasurementsFrame.split(System.getProperty("line.separator"));
        String lineSeparator = System.getProperty("line.separator");

        return replaceAt(frameLines[0], "FROM: " + formatDate(fromDate)
                        + "   TO: " + formatDate(toDate)) + lineSeparator +
                frameLines[1] + lineSeparator +
                replaceAt(frameLines[2], getMeasurementValue(frameLines[2])) + lineSeparator +
                replaceAt(frameLines[3], getMeasurementValue(frameLines[3])) + lineSeparator +
                frameLines[4] + lineSeparator;
    }

    private Boolean isEmptySingleHistoryMeasurement(Measurements measurements){
        return measurements.getPm25() == null && measurements.getPm10() == null;
    }

    private List<String> getAsciiArtLines(){
        if(pollutionLevel == null) return new NoDataAscii(Color.BLACK).getLines();
        if(pollutionLevel>5) return new Mask(Color.DARKRED).getLines();
        else return new Lung(pollutionLevelToColor(pollutionLevel)).getLines();
    }

    private String replaceAt(String line,String strReplacement){
        if(!line.contains("@")) return line;
        String[] lines = line.split("@");
        return lines[0]+ strReplacement + lines[1].substring(strReplacement.length());
    }

    private String getMeasurementValue(String line){
        for(String param:this.currentMeasurements.keySet()){
            if(line.matches(".+"+param+".+")) {
                if(currentMeasurements.get(param)!=null)
                    return formatDouble(currentMeasurements.get(param))+units.get(param);
                return "-";
            }
        }
        return "-";
    }

    private String formatDouble(Double value){
        if (value == null) return "-";
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(value);
    }
    private String formatDate(String date){
        if(!date.matches(".+T.+Z")) return date;
        String[] parts = date.split("T");
        return parts[0]+" "+parts[1].substring(0,parts[1].length()-1);
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
    private HashMap<String,String> saveUnits(){
        HashMap<String,String> units = new HashMap<>();
        units.put("CAQI","");
        units.put("pm2.5"," ug/m3");
        units.put("pm10"," ug/m3");
        units.put("temp","'C");
        units.put("press"," hPa");
        units.put("hum","%");
        return units;
    }

    private Color pollutionLevelToColor(Integer pollutionLevel){
        switch(pollutionLevel){
            case 0: case 1: return Color.DARKGREEN;
            case 2: return Color.GREEN;
            case 3: return Color.YELLOW;
            case 4: return Color.DARKYELLOW;
            case 5: return Color.RED;
            default: return Color.DARKRED;
        }
    }
}
