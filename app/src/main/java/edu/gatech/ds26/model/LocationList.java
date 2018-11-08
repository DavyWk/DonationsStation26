package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;

public class LocationList {
    Location current;

    //Should be a set since locations can't be duplicated
    private static final LocationList _instance = new LocationList();
    public static LocationList getInstance() { return _instance; }

    private final List<Location> locationList;

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

    public boolean removeLocation(Location loc) {
        if (loc == null) {
            return false;
        }
        return locationList.remove(loc);
    }

    public List<Location> get() {
        return locationList;
    }





}