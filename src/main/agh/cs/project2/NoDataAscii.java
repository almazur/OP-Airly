package agh.cs.project2;

// displayed when pollution level is unknown
public class NoDataAscii extends Ascii{

    NoDataAscii(Color color){
        super(color);
        String lineSeparator = System.getProperty("line.separator");
        this.asciiArt = "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "        No data         " + lineSeparator +
                "          . .           " + lineSeparator +
                "           ^            " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        ";
    }
}
