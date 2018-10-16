package edu.gatech.ds26.model;

import java.util.ArrayList;

public class LocationList {

    private static final LocationList _instance = new LocationList();
    public static LocationList getInstance() { return _instance; }

    private ArrayList<Location> locationList;

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

    public ArrayList<Location> get() {
        return locationList;
    }
}
