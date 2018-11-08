package edu.gatech.ds26.model;

public enum LocationType {
    Dropoff,
    Store,
    WAREHOUSE;

    public static LocationType get(String s) {
        s = s.toUpperCase();
        if (s.equals("Drop Off")) {
            return Dropoff;
        } else if (s.equals("STORE")) {
            return Store;
        } else if (s.equals("WAREHOUSE")) {
            return WAREHOUSE;
        }
        return null;
    }

    @Override
    public String toString() {
        if (name().equals("Dropoff")) {
            return "Drop Off";
        }
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
