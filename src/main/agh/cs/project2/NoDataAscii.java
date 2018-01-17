package agh.cs.project2;

public class NoDataAscii extends Ascii{

    NoDataAscii(Color color){
        super(color);
        String lineSeparator = System.getProperty("line.separator");
        this.asciiArt = "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        " + lineSeparator +
                "                        ";
    }
}
