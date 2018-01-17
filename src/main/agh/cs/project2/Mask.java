package agh.cs.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mask extends Ascii {
    //private String asciiArt;
    //private Color color;

    Mask(Color color){
        super(color);
        String lineSeparator = System.getProperty("line.separator");
        /*this.asciiArt = "       _.--==--._       " + lineSeparator +
                "     .'          '.     " + lineSeparator +
                "    /              \\    " + lineSeparator +
                "   | .---.    .---. |   " + lineSeparator +
                "   ||     \\  /     ||   " + lineSeparator +
                "   (\\     /  \\     /)   " + lineSeparator +
                "    \\ '''      ''' /    " + lineSeparator +
                "     \\            /     " + lineSeparator +
                "      \\ \\      / /      " + lineSeparator +
                "       \\_)    (_/       " + lineSeparator +
                "       __|    |__       " + lineSeparator +
                "      |          |      " + lineSeparator +
                "      |__________|      ";
        */
        this.asciiArt = "       _.--==--._       " + lineSeparator +
                "     .'##########'.     " + lineSeparator +
                "    /##############\\    " + lineSeparator +
                "   |#.---.####.---.#|   " + lineSeparator +
                "   ||     \\##/     ||   " + lineSeparator +
                "   (\\     /##\\     /)   " + lineSeparator +
                "    \\#'''######'''#/    " + lineSeparator +
                "     \\############/     " + lineSeparator +
                "      \\#\\xxxxxx/#/      " + lineSeparator +
                "       \\#)xxxx(#/       " + lineSeparator +
                "       __|xxxx|__       " + lineSeparator +
                "      |xxxxxxxxxx|      " + lineSeparator +
                "      |xxxxxxxxxx|      ";
               /* "      \\#\\@@@@@@/#/      " + lineSeparator +
                "       \\#)@@@@(#/       " + lineSeparator +
                "       __|@@@@|__       " + lineSeparator +
                "      |@@@@@@@@@@|      " + lineSeparator +
                "      |@@@@@@@@@@|      ";*/
        //this.color=color;
    }

    /*public List<String> getLines(){
        List<String> lines = new ArrayList<>(Arrays.asList(this.asciiArt.split(System.getProperty("line.separator"))));
        return lines.stream().map(str->this.color.getColorCode()+str+Color.BLACK.getColorCode()).collect(Collectors.toList());
    }

    public String toString(){
        return color.getColorCode()+asciiArt+Color.BLACK.getColorCode();
    }*/
}
