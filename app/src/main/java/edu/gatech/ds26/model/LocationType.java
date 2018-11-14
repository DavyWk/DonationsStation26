package edu.gatech.ds26.model;

/**
 * This enum gives the location type and tracks the delivery action.
 */
public enum LocationType {
    DROPOFF,
    Store,
    WAREHOUSE;

    /**
     * A switch for the location's type to decide the action for the donation.
     * @param s location type
     * @return enum of the location type
     */
    public static LocationType get(String s) {
        String str = s.toUpperCase();
        switch (str) {
            case "Drop Off":
                return DROPOFF;
            case "STORE":
                return Store;
            case "WAREHOUSE":
                return WAREHOUSE;
        }
        return null;
    }

    @Override
    public String toString() {
        String name = name();
        String nameSubstring = name.substring(1);

        if ("DROPOFF".equals(name)) {
            return "Drop Off";
        }
        return name.charAt(0) + nameSubstring.toLowerCase();
    }
}
