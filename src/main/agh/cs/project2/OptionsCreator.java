package agh.cs.project2;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class OptionsCreator {
    private Options options;

    OptionsCreator(){
        this.options=new Options();
    }

    public Options getOptions(){
        createOptions();
        return this.options;
    }

    private void createOptions(){

        Option sensorId = Option.builder("i")
                .longOpt("sensor-id")
                .desc("")
                .hasArg()
                .build();

        Option longitude = Option.builder("g")
                .longOpt("longitude")
                .hasArg()
                .desc("")
                .build();

        Option latitude = Option.builder("t")
                .longOpt("latitude")
                .desc("")
                .hasArg()
                .build();

        Option apiKey = Option.builder("k")
                .longOpt("api-key")
                .hasArg()
                .desc("")
                .build();

        Option history = Option.builder("h")
                .longOpt("history")
                .hasArg(false)
                .desc("")
                .build();

        OptionGroup required = new OptionGroup();
        required.setRequired(true);
        required.addOption(longitude);
        required.addOption(sensorId);
        options.addOption(latitude); // always with longitude
        options.addOption(apiKey);
        options.addOption(history);
        options.addOptionGroup(required);
    }
}
