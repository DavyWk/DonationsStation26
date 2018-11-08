package edu.gatech.ds26.model;

public enum AccountType {
    USER,
    LOCATIONEMPLOYEE,
    MANAGER,
    ADMIN;

    public static AccountType get(String s) {
        if (s.toLowerCase().equals("location employee")) {
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
