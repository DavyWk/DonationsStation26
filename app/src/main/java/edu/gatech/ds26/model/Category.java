package edu.gatech.ds26.model;

public enum Category {
    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

    public static Category get(String s) {
        return Category.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
