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
        String sLowerCase = s.toLowerCase();
        if ("location employee".equals(sLowerCase)) {
            return LOCATIONEMPLOYEE;
        } else {
            return AccountType.valueOf(s.toUpperCase());
        }
    }

    @Override
    public String toString() {
        String name = name();

        if("locationemployee".equalsIgnoreCase(name)) {
            return "Location Employee";
        }

        String nameSubstring = name.substring(1);
        return name.charAt(0) + nameSubstring.toLowerCase();
    }
}
