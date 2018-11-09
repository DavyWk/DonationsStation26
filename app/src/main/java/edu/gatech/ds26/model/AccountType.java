package edu.gatech.ds26.model;

/**
 * This is a enum class that contains the type of each user. Each level has different access to the
 * application's features
 */
public enum AccountType {
    USER,
    LOCATIONEMPLOYEE,
    MANAGER,
    ADMIN;

    /**
     * Returns the type associated with a given user
     * @param s A string that represents the user's type
     * @return The enum type of the user
     */
    public static AccountType get(String s) {
        if (s.toLowerCase().equals("location employee")) {
            return LOCATIONEMPLOYEE;
        } else {
            return AccountType.valueOf(s.toUpperCase());
        }
    }

    @Override
    /**
     * Creates a formatted string for Account Type
     * @return Location Employee or name's first and substring char
     */
    public String toString() {

        if(name().equalsIgnoreCase("locationemployee")) {
            return "Location Employee";
        }
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
