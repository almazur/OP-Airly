package agh.cs.project2;

public class SensorInfo {
    private Address address;
    private Integer id;
    private Location location;
    private String name;
    private Double pollutionLevel;
    private String vendor;

    //setters and getters for all attributes
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPollutionLevel() {
        return pollutionLevel;
    }
    public void setPollutionLevel(Double pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
