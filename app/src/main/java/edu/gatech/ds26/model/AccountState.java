package edu.gatech.ds26.model;

/**
 * This is enum dictates whether or nto an account is locked
 */
public enum AccountState {
    LOCKED,
    UNLOCKED;

    /**
     * This method checks the account state of an object
     * @param s A string representing the account state
     * @return The value of the account
     */
    public static AccountState get(String s) {
        return AccountState.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        String name = name();
        String nameSubstring = name.substring(1);

        return name.charAt(0) + nameSubstring.toLowerCase();
    }
}
