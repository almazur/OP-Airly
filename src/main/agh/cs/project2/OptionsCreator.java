package agh.cs.project2;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

// creates options for command line parser
public class OptionsCreator {
    private Options options;

    public OptionsCreator(){
        this.options=new Options();
    }

    public Options getOptions(){
        createOptions();
        return this.options;
    }

    private void createOptions(){

        Option sensorId = Option.builder("i")
                .longOpt("sensorId")
                .desc("display data for sensor of given ID")
                .hasArg()
                .build();

        Option longitude = Option.builder("g")
                .longOpt("longitude")
                .hasArg()
                .desc("display data for location; requires usage of latitude option")
                .build();

        Option latitude = Option.builder("t")
                .longOpt("latitude")
                .desc("display data for location; requires usage of longitude option")
                .hasArg()
                .build();

        Option apiKey = Option.builder("k")
                .longOpt("apiKey")
                .hasArg()
                .desc("authentication key; if not given, environment variable 'API_KEY' must exist")
                .build();

        Option history = Option.builder("H")
                .longOpt("history")
                .hasArg(false)
                .desc("display history measurements")
                .build();

        Option help = Option.builder("h")
                .longOpt("help")
                .hasArg(false)
                .desc("display help")
                .build();

       OptionGroup required = new OptionGroup();
        required.setRequired(true);
        required.addOption(longitude);
        required.addOption(sensorId);
        required.addOption(help);
        options.addOption(latitude);
        options.addOption(apiKey);
        options.addOption(history);
        options.addOptionGroup(required);
    }
}
