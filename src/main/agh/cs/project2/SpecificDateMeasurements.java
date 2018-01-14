package agh.cs.project2;

// forecast and history measurements
public class SpecificDateMeasurements {
    private String fromDateTime;
    private Measurements measurements;
    private String tillDateTime;


    // getters and setters for all attributes
    public String getFromDateTime() {
        return fromDateTime;
    }
    public void setFromDateTime(String fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Measurements getMeasurements() {
        return measurements;
    }
    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }
    public void setTillDateTime(String tillDateTime) {
        this.tillDateTime = tillDateTime;
    }
}
