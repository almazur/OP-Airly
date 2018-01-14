package agh.cs.project2;

public class Measurements {
    private Double airQualityIndex;
    private Double humidity;
    private String measurementTime;
    private Double pm1;
    private Double pm10;
    private Double pm25;
    private Integer pollutionLevel;
    private Double pressure;
    private Double temperature;
    private Double windDirection;
    private Double windSpeed;


    // getters and setters for all attributes
    public Double getAirQualityIndex() {
        return airQualityIndex;
    }
    public void setAirQualityIndex(Double airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public Double getHumidity() {
        return humidity;
    }
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getMeasurementTime() {
        return measurementTime;
    }
    public void setMeasurementTime(String measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Double getPm1() {
        return pm1;
    }
    public void setPm1(Double pm1) {
        this.pm1 = pm1;
    }

    public Double getPm10() {
        return pm10;
    }
    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getPm25() {
        return pm25;
    }
    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Integer getPollutionLevel() {
        return pollutionLevel;
    }
    public void setPollutionLevel(Integer pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    public Double getPressure() {
        return pressure;
    }
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTemperature() {
        return temperature;
    }
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
