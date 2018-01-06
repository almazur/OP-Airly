package agh.cs.project2;

public class NotCurrentMeasurements {
    private String fromDateTime;
    private CurrentMeasurements currentMeasurements;
    private String tillDateTime;


    // getters and setters for all attributes
    public String getFromDateTime() {
        return fromDateTime;
    }
    public void setFromDateTime(String fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public CurrentMeasurements getCurrentMeasurements() {
        return currentMeasurements;
    }
    public void setCurrentMeasurements(CurrentMeasurements currentMeasurements) {
        this.currentMeasurements = currentMeasurements;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }
    public void setTillDateTime(String tillDateTime) {
        this.tillDateTime = tillDateTime;
    }
}
