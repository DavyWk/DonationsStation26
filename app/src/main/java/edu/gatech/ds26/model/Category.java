package edu.gatech.ds26.model;

public enum Category {
    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

    public String getLetter(Category category) {
        if (category == CLOTHING) {
            return "C";
        } else if (category == HAT) {
            return "A";
        } else if (category == KITCHEN) {
            return "K";
        } else if (category == ELECTRONICS) {
            return  "E";
        } else if (category == HOUSEHOLD) {
            return "H";
        } else {
            return "O";
        }
    }

    public String toString(Category category) {
        if (category == CLOTHING) {
            return "Clothing";
        } else if (category == HAT) {
            return "Hat";
        } else if (category == KITCHEN) {
            return "Kitchen";
        } else if (category == ELECTRONICS) {
            return  "Electronics";
        } else if (category == HOUSEHOLD) {
            return "Household";
        } else {
            return "Other";
        }
    }
}
