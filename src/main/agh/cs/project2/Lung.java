package agh.cs.project2;

public class Lung {
    private String asciiArt;
    private Color color;

    Lung(Color color){
        String lineSeparator = System.getProperty("line.separator");
        this.asciiArt = "           ||           " + lineSeparator +
                "           ||           " + lineSeparator +
                "           ||           " + lineSeparator +
                "        __.||.__        " + lineSeparator +
                "      .'##//"+"\\\\"+"##'.      " + lineSeparator +
                "    .'###//||\\\\###'.    " + lineSeparator +
                "   /#####\"#||#\"#####\\   " + lineSeparator +
                "  /########||########\\  " + lineSeparator +
                " /#########''#########\\ " + lineSeparator +
                "|#########/  "+"\\"+"#########|" + lineSeparator +
                "\\#######.'    '.#######/" + lineSeparator +
                " \\####.'        '.####/ " + lineSeparator +
                "   '''            '''   ";
        this.color=color;
    }

    public String toString(){
        return color.getColorCode()+asciiArt+Color.RESET.getColorCode();
    }
}
