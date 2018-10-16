package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;
//TODO: read file + io
public class LocationList {

    private static final LocationList _instance = new LocationList();
    public static LocationList getInstance() { return _instance; }

    private List<Location> locationList;

    private LocationList() {
        locationList = new ArrayList<>();
    }
    //add location
    //remove

    public boolean addLocation(String locationString) {
        Location loc = parseLocation(locationString);
        return addLocation(loc);
    }

    public boolean addLocation(Location loc) {
        if (loc == null) {
            return  false;
        }
        locationList.add(loc);
        return true;
    }

    public Location parseLocation(String locationString) {
        String[] split = locationString.split(",");
        if (split.length != 11) {
            return null;
        }
        int key = Integer.parseInt(split[0]);
        String name = split[1];
        double latitude = Double.parseDouble(split[2]);
        double longitude = Double.parseDouble(split[3]);
        String address = split[4];
        String city = split[5];
        String state = split[6];
        int zip = Integer.parseInt(split[7]);
        String type = split[8];
        String phone = split[9];
        String website = split[10];

        return new Location(key, name, latitude, longitude, address, city, state,
                zip, type, phone, website);
    }

    public List<Location> get() {
        return locationList;
    }
}
