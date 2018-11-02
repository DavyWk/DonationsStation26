package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import android.util.Log;

public class LocationList {

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





}
