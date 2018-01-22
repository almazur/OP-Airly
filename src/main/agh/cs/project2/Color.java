package agh.cs.project2;

// enum class with ansi escape codes for colors
public enum Color {
    DARKGREEN("\u001B[32m"),
    GREEN("\u001B[92m"),
    YELLOW("\u001B[93m"),
    DARKYELLOW("\u001B[33m"),
    RED("\u001B[91m"),
    DARKRED("\u001B[31m"),
    BLACK("\u001B[30m"),
    RESET("\u001B[0m");

    private String colorCode;
    Color(String colorCode){
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
