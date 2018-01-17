package agh.cs.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Ascii {
    protected String asciiArt;
    protected Color color;

    public Ascii(Color color){
        this.color=color;
    }

    public List<String> getLines(){
        List<String> lines = new ArrayList<>(Arrays.asList(this.asciiArt.split(System.getProperty("line.separator"))));
        return lines.stream().map(str->this.color.getColorCode()+str+Color.BLACK.getColorCode()).collect(Collectors.toList());
    }

    public String toString(){
        return color.getColorCode()+asciiArt+Color.BLACK.getColorCode();
    }
}
