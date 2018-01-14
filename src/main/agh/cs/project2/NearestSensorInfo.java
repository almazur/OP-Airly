package agh.cs.project2;

public class NearestSensorInfo extends SensorInfo {
    private Double airQualityIndex;
    private Double pm25;
    private Double pm10;
    private Double distance;
    //private Integer id;
    //private String name;
    //private String vendor;
    //private Location location;
    //private Integer pollutionLevel;
    //private Address address;
    private String measurementTime;

    // getters and setters for all attributes
    public Double getAirQualityIndex() {
        return airQualityIndex;
    }
    public void setAirQualityIndex(Double airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public Double getPm25() {
        return pm25;
    }
    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getPm10() {
        return pm10;
    }
    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /*public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getPollutionLevel() {
        return pollutionLevel;
    }
    public void setPollutionLevel(Integer pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }*/

    public String getMeasurementTime() {
        return measurementTime;
    }
    public void setMeasurementTime(String measurementTime) {
        this.measurementTime = measurementTime;
    }
}
