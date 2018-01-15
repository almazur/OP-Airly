package agh.cs.project2;

public class Mask {
    private String asciiArt;
    private Color color;

    Mask(Color color){
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
        this.color=color;
    }

    public String toString(){
        return color.getColorCode()+asciiArt+Color.RESET.getColorCode();
    }
}
