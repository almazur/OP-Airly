package agh.cs.project2;

import java.util.HashMap;
import java.util.HashSet;

public class AsciiDisplay {
    private Integer id;
    private Measurements currentMeasurements;
    private SpecificDateMeasurements[] history;
    private Address address;
    private Location location;
    private Boolean displayHistory;

    AsciiDisplay(HashMap<String,Object> args,Boolean displayHistory){
        this.displayHistory = displayHistory;
        this.id = (Integer) args.get("id");
        this.currentMeasurements = (Measurements) args.get("currentMeasurements");
        this.address = (Address) args.get("address");
        this.location = (Location) args.get("location");
        this.history = (SpecificDateMeasurements[]) args.get("history");
    }
}
