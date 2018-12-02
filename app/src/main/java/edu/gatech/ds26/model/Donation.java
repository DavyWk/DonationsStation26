package edu.gatech.ds26.model;

import java.io.PrintWriter;

//TODO: Add comment and Photo

/**
 * This is a information holder class representing an object that was donated to a center
 */
public class Donation {
    private String timeStamp;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private float value;
    private Category category;
    //private String comments;
    //private photo;

    /**
     * A constructor for a donation object
     * @param timestamp A string representing when it was donated
     * @param location A location representing which center it was donated to
     * @param shortDescription A short description of the object meant for display purposes
     * @param fullDescription A full description of the object noting any defects and qualities
     * @param value An estimate of the monetary value of the object
     * @param category An enum of representing the type of the object
     */
    public Donation(String timestamp, Location location, String shortDescription,
                    String fullDescription, float value, Category category/*, String comments*/) {
        this.timeStamp = timestamp;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    /**
     * A no-arg constructor for Donation
     */
    /*public Donation() {
        this.timeStamp = "now";
        this.location = new Location();
        this.shortDescription = "short";
        this.fullDescription = "full description";
        this.value = 1.23f;
        this.category = Category.CLOTHING;
    }*/

    //TODO: Move formatting to Activity that uses it, replace "\n\n" with ","
    @Override
    public String toString() {
        return String.format(" Time Stamp: %s\n\n" + " Location: %s\n\n" +
                        " Short Description: %s\n\n" + " Full Description: %s\n\n" +
                        " Value: %s\n\n" + " Category: %s\n\n",
                timeStamp, location.getName(), shortDescription, fullDescription, value, category);
    }

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A getter for the timestamp
//     * @return A string representing the time it was turned in
//     */
//    public String getTimeStamp() {
//        return timeStamp;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A setter for the timestamp
//     * @param timeStamp A string representing when the object was submitted
//     */
//    public void setTimeStamp(String timeStamp) {
//        this.timeStamp = timeStamp;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

    /**
     * A getter for the location
     * @return A location object
     */
    public Location getLocation() {
        return location;
    }

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A getter for the location
//     * @param location A location object
//     */
//    public void setLocation(Location location) {
//        this.location = location;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

    /**
     * A getter for the objects display description
     * @return A string of the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A setter for the short description
//     * @param shortDescription A string representing the short description
//     */
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A getter for the full description
//     * @return A string representing the short description
//     */
//    public String getFullDescription() {
//        return fullDescription;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A setter for the full description
//     * @param fullDescription A string representing the full description
//     */
//    public void setFullDescription(String fullDescription) {
//        this.fullDescription = fullDescription;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A getter for the monetary value
//     * @return A float for the numeric value
//     */
//    public float getValue() {
//        return value;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A setter for the monetary value
//     * @param value A float representing the monetary value
//     */
//    public void setValue(float value) {
//        this.value = value;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

    /**
     * A getter for the category
     * @return An enum representing the item type
     */
    public Category getCategory() {
        return category;
    }

// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    /**
//     * A setter for the category
//     * @param category A Category enum
//     */
//    public void setCategory(Category category) {
//        this.category = category;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)

    /*public void setComment(String comment) { this.comment = comment; }
    public String getComment() { return comment; }*/

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (!(o instanceof Donation))) {
            return false;
        }

        String shortdes = ((Donation)o).getShortDescription();

        return shortdes.equalsIgnoreCase(this.shortDescription);
    }

    @Override
    public int hashCode() {
        return shortDescription.hashCode();
    }
    /**
     * Creates a new file with donation's information.
     * @param writer writes the file
     */
    void saveAsText(PrintWriter writer) { //this follows the CSV format, for easy conversion
        writer.println("Donation:" + "\t" + timeStamp + "\t" + location.toStringEx() + "\t"
                + shortDescription + "\t" + fullDescription + "\t" + value + "\t" + category);
    }

    /**
     * This reads from a text document and creates a donation object from the text on the line
     * @param line The current line in the text document
     * @return A new donation object
     */
    public static Donation loadFromText(String line) {
        String[] tokens = line.split("\t");
        return new Donation(tokens[1], Location.parseLocation(tokens[2]), tokens[3], tokens[4],
                Float.parseFloat(tokens[5]), Category.get(tokens[6]));
    }
}
