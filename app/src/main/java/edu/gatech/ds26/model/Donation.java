package edu.gatech.ds26.model;

import android.util.Log;

import java.io.PrintWriter;

public class Donation {
    private String timeStamp;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private float value;
    private Category category;
    //private String comments;
    //private photo//

    public Donation(String timestamp, Location location, String shortDescription, String fullDescription,
                    float value, Category category/*, String comments*/) {
        this.timeStamp = timestamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Donation() {
        this.timeStamp = "now";
        this.location = new Location();
        this.shortDescription = "short";
        this.fullDescription = "full description";
        this.value = 1.23f;
        this.category = Category.CLOTHING;
    }

    public String toString() {
        return String.format(" Time Stamp: %s\n\n" + " Location: %s\n\n" +
                        " Short Description: %s\n\n" + " Full Description: %s\n\n" +
                        " Value: %s\n\n" + " Category: %s\n\n",
                timeStamp, location.getName(), shortDescription, fullDescription, value, category);
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

    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
  
    /*public void setComment(String comment) { this.comment = comment; }
    public String getComment() { return comment; }*/

    void saveAsText(PrintWriter writer) { //this follows the CSV format, for easy conversion
        Log.d("Donation", "Saving donation");
        //TODO: We need to check that Donation descriptions don't contain tabs
        writer.println("Donation:" + "\t" + timeStamp + "\t" + location.toStringEx() + "\t" + shortDescription + "\t" + fullDescription
        + "\t" + value + "\t" + category);
    }

    public static Donation loadFromText(String line) {
        Log.d("Donation", "Retrieving donation");
        String[] tokens = line.split("\t");
        return new Donation(tokens[1], Location.parseLocation(tokens[2]), tokens[3], tokens[4],
                Float.parseFloat(tokens[5]), Category.get(tokens[6]));
    }
}
