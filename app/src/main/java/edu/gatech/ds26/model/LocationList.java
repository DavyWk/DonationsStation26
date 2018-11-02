package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;

public class LocationList {
    Location current;

    //Should be a set since locations can't be duplicated
    private static final LocationList _instance = new LocationList();
    public static LocationList getInstance() { return _instance; }

    private List<Location> locationList;

    private LocationList() {
        locationList = new ArrayList<>();
    }

    public boolean addLocation(Location loc) {
        if (loc == null) {
            return  false;
        }
        locationList.add(loc);
        return true;
    }

    public List<Location> get() {
        return locationList;
    }

    public Location getCurrent() {
        return current;
    }
    public void setCurrent(Location loc) {
        current = loc;
    }
}