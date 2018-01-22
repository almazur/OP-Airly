package agh.cs.project2;

// enum class for frames used to display measurements
public enum DisplayFrame {
    currentMeasurementsFrame,
    historyMeasurementsFrame;

    public String toString (){
        String lineSeparator = System.getProperty("line.separator");
        switch(this){
            case currentMeasurementsFrame: return
                    "+--------------------------------------------------------------------+" + lineSeparator +
                    "|  @                                                                  |" + lineSeparator +
                    "|  @                                                                  |" + lineSeparator +
                    "|--------------------------------------------------------------------|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|  CAQI: @                                    #|" + lineSeparator +
                    "|  pm2.5: @                                   #|" + lineSeparator +
                    "|  pm10: @                                    #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|  temp.: @                                   #|" + lineSeparator +
                    "|  press.: @                                  #|" + lineSeparator +
                    "|  hum.: @                                    #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "|                                            #|" + lineSeparator +
                    "+--------------------------------------------------------------------+";
            case historyMeasurementsFrame: return
                    "|  @                                                                  |" + lineSeparator +
                    "|                                                                    |" + lineSeparator +
                    "|  pm2.5: @                                                           |" + lineSeparator +
                    "|  pm10: @                                                            |" + lineSeparator +
                    "+--------------------------------------------------------------------+";
            default: return "";
        }
    }
}
