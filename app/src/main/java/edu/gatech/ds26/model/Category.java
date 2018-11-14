package edu.gatech.ds26.model;

/**
 * An enum associated with donations that represents the varying types of categories
 */
public enum Category {
    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

    /**
     * Returns the enum for the given category
     * @param s A string meant to represent the category
     * @return An enum representing the category
     */
    public static Category get(String s) {
        return Category.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        String name = name();
        String nameSubstring = name.substring(1);

        return name.charAt(0) + nameSubstring.toLowerCase();
    }
}
