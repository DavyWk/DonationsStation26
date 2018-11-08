package edu.gatech.ds26.model;

public enum LocationType {
    Dropoff,
    Store,
    WAREHOUSE;

    public static LocationType get(String s) {
        String str = s.toUpperCase();
        if (str.equals("Drop Off")) {
            return Dropoff;
        } else if (str.equals("STORE")) {
            return Store;
        } else if (str.equals("WAREHOUSE")) {
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
