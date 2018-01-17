package agh.cs.project2;

public class Mask extends Ascii {

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
    }
}
