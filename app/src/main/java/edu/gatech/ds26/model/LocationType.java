package edu.gatech.ds26.model;

public enum LocationType {
    Dropoff,
    Store,
    Warehouse;

    public static LocationType get(String s) {
        if (s.equals("Drop Off")) {
            return Dropoff;
        } else if (s.equals("Store")) {
            return Store;
        } else if (s.equals("Warehouse")) {
            return Warehouse;
        }
        return null;
    }
    public String toString() {
        if (name().equals("Dropoff")) {
            return "Drop Off";
        }
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
