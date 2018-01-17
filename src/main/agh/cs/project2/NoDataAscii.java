package agh.cs.project2;

public class NoDataAscii extends Ascii{
    //private String asciiArt;
    //private Color color;

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
