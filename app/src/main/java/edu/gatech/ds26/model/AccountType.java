package edu.gatech.ds26.model;

/**
 *  This is an enum class that is associated with each User object. Each account type different
 *  levels of accessibility for app features
 */
public enum AccountType {
    USER,
    LOCATIONEMPLOYEE,
    MANAGER,
    ADMIN;

    /**
     * Returns a char representing the user type
     * @param type The account type of a certain object
     * @return A string containing a single character representing the account type
     */
    public String getLetter(AccountType type) {
        if (type == USER) {
            return "U";
        } else if (type == LOCATIONEMPLOYEE) {
            return "L";
        } else if (type == MANAGER) {
            return "M";
        } else {
            return "A";
        }
    }

    /**
     * Checks a string and returns the account type
     * @param s The string meant to represent a given account type
     * @return An enum of the account type
     */
    public static AccountType get(String s) {
        if (s.equals("Location Employee")) {
            return LOCATIONEMPLOYEE;
        } else {
            return AccountType.valueOf(s.toUpperCase());
        }
    }

    @Override
    public String toString() {

        if(name().equalsIgnoreCase("locationemployee")) {
            return "Location Employee";
        }
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
