package edu.gatech.ds26.model;

/**
 * This is a public enum class that indicates the current state of a user
 * Currently the security feature is unimplemented
 * V 1.0
 */
public enum AccountState {
    LOCKED,
    UNLOCKED;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    /**
     *
     * @param s A string parameter
     * @return Returns whether the indicated account is locked or unlocked
     */
    public static AccountState get(String s) {
        return AccountState.valueOf(s.toUpperCase());
    }
}
