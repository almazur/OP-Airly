package agh.cs.project2;

public class ParticularSensor extends CurrentMeasurements {
    private CurrentMeasurements currentCurrentMeasurements;
    private NotCurrentMeasurements[] forecast;
    private NotCurrentMeasurements[] history;


    // getters and setters for all attributes
    public CurrentMeasurements getCurrentCurrentMeasurements() {
        return currentCurrentMeasurements;
    }
    public void setCurrentCurrentMeasurements(CurrentMeasurements currentCurrentMeasurements) {
        this.currentCurrentMeasurements = currentCurrentMeasurements;
    }

    public NotCurrentMeasurements[] getForecast() {
        return forecast;
    }
    public void setForecast(NotCurrentMeasurements[] forecast) {
        this.forecast = forecast;
    }

    public NotCurrentMeasurements[] getHistory() {
        return history;
    }
    public void setHistory(NotCurrentMeasurements[] history) {
        this.history = history;
    }
}
