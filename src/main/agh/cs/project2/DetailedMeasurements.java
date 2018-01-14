package agh.cs.project2;

public class DetailedMeasurements extends Measurements {
    private Measurements currentMeasurements;
    private SpecificDateMeasurements[] forecast;
    private SpecificDateMeasurements[] history;


    // getters and setters for all attributes
    public Measurements getCurrentMeasurements() {
        return currentMeasurements;
    }
    public void setCurrentMeasurements(Measurements currentMeasurements) {
        this.currentMeasurements = currentMeasurements;
    }

    public SpecificDateMeasurements[] getForecast() {
        return forecast;
    }
    public void setForecast(SpecificDateMeasurements[] forecast) {
        this.forecast = forecast;
    }

    public SpecificDateMeasurements[] getHistory() {
        return history;
    }
    public void setHistory(SpecificDateMeasurements[] history) {
        this.history = history;
    }
}
