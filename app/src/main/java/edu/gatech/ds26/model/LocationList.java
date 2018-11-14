package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;

/**
 * This class manages the Locations objects contained in the app.
 */
public class LocationList {
    Location current;

    //Should be a set since locations can't be duplicated
    private static final LocationList _instance = new LocationList();
    public static LocationList getInstance() { return _instance; }

    private final List<Location> locationList;

    public LocationList() {
        locationList = new ArrayList<>();
    }

    /**
     * Adding location to the database.
     * @param loc location
     * @return boolean to confirm addition
     */
    public boolean addLocation(Location loc) {
        if (loc == null || locationList.contains(loc)) {
            return  false;
        }
        locationList.add(loc);
        return true;
    }
    /**
     * Removing location to the database.
     * @param loc location
     * @return boolean to confirm removal
     */
    public boolean removeLocation(Location loc) {
        if (loc == null) {
            return false;
        }
        return locationList.remove(loc);
    }

    /**
     * Get location's info.
     * @return location list
     */
    public List<Location> get() {
        return locationList;
    }

    /*boolean equals(Object o) {
        if (o is )
    }*/



}