package edu.gatech.ds26.model;

public enum AccountState {
    LOCKED,
    UNLOCKED;

    public static AccountState get(String s) {
        return AccountState.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
