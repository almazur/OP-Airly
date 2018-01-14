package agh.cs.project2;

public class Lung {
    private String asciiArt;
    private String color;
    private String colorReset;

    Lung(){
        this.asciiArt = "             ||           \n" +
                "             ||           \n" +
                "          __.||.__        \n" +
                "        .'##//\\\\##'.      \n" +
                "      .'###//||\\\\###'.    \n" +
                "     /#####\"#||#\"#####\\   \n" +
                "    /########||########\\  \n" +
                "   /#########''#########\\ \n" +
                "  |#########/  \\#########|\n" +
                "  \\#######.'    '.#######/\n" +
                "   \\####.'        '.####/ \n" +
                "     '''            '''   ";
        this.colorReset="\u001B[0m";
    }

    public void setColor(String color){
        this.color=color;
    }

    public String toString(){
        return this.color+this.asciiArt+this.colorReset;
    }
}
