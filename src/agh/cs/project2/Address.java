package agh.cs.project2;

public class Address {
    private String streetNumber;
    private String route;
    private String locality;
    private String country;

    // setters and getters for all attributes

    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }

    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
