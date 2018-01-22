package agh.cs.project2;

// ascii gas mask
public class Mask extends Ascii {

    public Mask(Color color){
        super(color);
        String lineSeparator = System.getProperty("line.separator");
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
    }
}
