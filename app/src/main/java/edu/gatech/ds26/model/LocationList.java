package edu.gatech.ds26.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * This class manages the Locations objects contained in the app.
 */
public class LocationList {

    //Should be a set since locations can't be duplicated
    private static final LocationList _instance = new LocationList();

    /**
     * Returns an instance of the LocationList
     * @return instance of LocationList
     */
    public static LocationList getInstance() {
        return _instance;
    }

    private final List<Location> locationList;

    /**
     * Constructor for LocationList.
     */
    public LocationList() {
        locationList = new ArrayList<>();
    }

    /**
     * Adding location to the database.
     * @param loc location
     * @return boolean to confirm addition
     */
    public boolean addLocation(Location loc) {
        if ((loc == null) || (locationList.contains(loc))) {
            return  false;
        }
        locationList.add(loc);
        return true;
    }

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Removing location to the database.
//     * @param loc location
//     * @return boolean to confirm removal
//     */
//    public boolean removeLocation(Location loc) {
//        if (loc == null) {
//            return false;
//        }
//        return locationList.remove(loc);
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

    /**
     * Get location's info.
     * @return location list
     */
    public List<Location> get() {
        return Collections.unmodifiableList(locationList);
    }

    /*boolean equals(Object o) {
        if (o is )
    }*/



}