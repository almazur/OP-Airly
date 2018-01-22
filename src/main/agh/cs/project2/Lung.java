package agh.cs.project2;

// ascii Lung
public class Lung extends Ascii{

    public Lung(Color color){
        super(color);
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
    }
}
