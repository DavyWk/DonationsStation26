package edu.gatech.ds26.model;

public enum AccountState {
    LOCKED,
    UNLOCKED;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static AccountState get(String s) {
        return AccountState.valueOf(s.toUpperCase());
    }
}
