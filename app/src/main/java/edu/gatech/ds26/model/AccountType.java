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
    public String toString() {

        if(name().equalsIgnoreCase("locationemployee")) {
            return "Location Employee";
        }
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
