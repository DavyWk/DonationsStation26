package edu.gatech.ds26.model;

public enum ItemCategory {
    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
