package edu.gatech.ds26.model;

/**
 * This enum gives the location type and tracks the delivery action.
 */
public enum LocationType {
    Dropoff,
    Store,
    WAREHOUSE;

    /**
     * A switch for the location's type to decide the action for the donation.
     * @param s location type
     * @return enum of the location type
     */
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
