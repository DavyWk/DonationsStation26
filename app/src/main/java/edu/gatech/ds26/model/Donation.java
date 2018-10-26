package edu.gatech.ds26.model;

import java.util.Date;

public class Donation {
    private Date timeStamp;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private float value;
    private ItemCategory category;
    //private String comments;
    //private photo//

    public Donation(Date timestamp, Location location, String shortDescription, String fullDescription,
                    float value, ItemCategory category/*, String comments*/) {
        this.timeStamp = timestamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
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

    public ItemCategory getCategory() {
        return category;
    }
    public void setCategory(ItemCategory category) {
        this.category = category;
    }
  
    /*public void setComment(String comment) { this.comment = comment; }
    public String getComment() { return comment; }*/
}
