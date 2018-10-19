package edu.gatech.ds26.model;

import java.util.Date;

public class Donation {
    private Date timestamp;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private float value;
    private ItemCategory category;
    //private String comments;
    //private photo//

    public Donation(Date timestamp, Location location, String shortDescription, String fullDescription,
                    float value, ItemCategory category/*, String comments*/) {
        this.timestamp = timestamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Date getTimestamp() { return timestamp; }
    public void setTimeStamp(Date timestamp) { this.timestamp = timestamp; }

    public void setLocation(Location location) { this.location = location; }
    public Location getLocation() { return location; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public String getShortDescription() { return this.shortDescription; }

    public void setFullDescription(String fullDescription) { this.fullDescription = fullDescription; }
    public String getFullDescription() { return this.fullDescription; }

    public void setValue(float value) { this.value = value; }
    public float getValue() { return value; }

    public void setCategory(ItemCategory category) { this.category = category; }
    public ItemCategory getCategory() { return category; }

    /*public void setComment(String comment) { this.comment = comment; }
    public String getComment() { return comment; }*/
}
