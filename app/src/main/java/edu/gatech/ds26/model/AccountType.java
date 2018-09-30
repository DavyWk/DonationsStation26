package edu.gatech.ds26.model;

public enum AccountType {
    USER,
    LOCATIONEMPLOYEE,
    MANAGER,
    ADMIN;

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
    public String toString(AccountType type) {
        if (type == USER) {
            return "User";
        } else if (type == LOCATIONEMPLOYEE) {
            return "Location Employee";
        } else if (type == MANAGER) {
            return "Manager";
        } else {
            return "Administrator";
        }
    }
}
