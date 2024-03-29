package agh.cs.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// common class for all ascii arts
public abstract class Ascii {
    protected String asciiArt;
    private Color color;

    public Ascii(Color color){
        this.color=color;
    }

    public List<String> getLines(){
        List<String> lines = new ArrayList<>(Arrays.asList(this.asciiArt.split(System.getProperty("line.separator"))));
        return lines.stream().map(str->this.color.getColorCode()+str+Color.RESET.getColorCode()).collect(Collectors.toList());
    }

    public String toString(){
        return color.getColorCode()+asciiArt+Color.RESET.getColorCode();
    }
}
