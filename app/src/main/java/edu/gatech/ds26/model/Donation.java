package edu.gatech.ds26.model;

public class Donation {
    private String timeStamp;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private double value;
    private Category category;

    public Donation(String timeStamp, Location location, String shortDescription,
                    String fullDescription, double value, Category category) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Donation() {
        this.timeStamp = "10 am";
        this.location = new Location();
        this.shortDescription = "This is my short description";
        this.fullDescription = "This is my full description";
        this.value = 2.4;
        this.category = Category.HOUSEHOLD;
    }

    private void setAll(String timeStamp, Location location, String shortDescription,
                    String fullDescription, double value, Category category) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
