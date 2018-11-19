package edu.gatech.ds26.model;

/**
 * This class generates the template for all of the locations of the donation tracker.
 */
public class Location {

    private int key;
    private String name;
    private double longitude;
    private double latitude;
    private String city;
    private String address;
    private String state;
    private int zip;
    private LocationType type;
    private String phone;
    private String website;

    /**
     * Constructor for Location.
     * @param key location's key
     * @param name location's name
     * @param longitude location's longitude
     * @param latitude location's latitude
     * @param address location's address
     * @param city location's city
     * @param state location's state
     * @param zip location's zip
     * @param type location's zip
     * @param phone location's phone
     * @param website location's website
     */
    Location(int key, String name, double longitude, double latitude, String address,
                     String city, String state, int zip, LocationType type, String phone,
                     String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
    }

    /**
     * Constructor for Location without parameters.
     */
    public Location(){
        this.key = 4;
        this.name = "NotMyName";
        this.latitude = 5;
        this.longitude = 2;
        this.address = "Georgia Tech Station";
        this.city = "Atlanta";
        this.state = "GA";
        this.zip = 3;
        this.type = LocationType.DROPOFF;
        this.phone = "123456789";
        this.website = "www.lol";
    }

    /**
     * Getter for Key
     * @return key
     */
    public int getKey() {
        return key;
    }

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Key
//     * @param key location's key
//     */
//    public void setKey(int key) {
//        this.key = key;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

    /**
     * Getter for Name
     * @return name
     */
    public String getName() {
        return name;
    }

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Name
//     * @param name location's name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

    /**
     * Getter for Latitude
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Latitude
//     * @param latitude location's latitude
//     */
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

    /**
     * Getter for Longitude
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Longitude
//     * @param longitude location's longitude
//     */
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for Address
//     * @return address
//     */
//    public String getAddress() {
//        return address;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Address
//     * @param address location's address
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for City
//     * @return city
//     */
//    public String getCity() {
//        return city;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for City
//     * @param city location's city
//     */
//    public void setCity(String city) {
//        this.city = city;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for State
//     * @return state
//     */
//    public String getState() {
//        return state;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for State
//     * @param state location's state
//     */
//    public void setState(String state) {
//        this.state = state;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for Zip
//     * @return zip
//     */
//    public int getZip() {
//        return zip;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Zip
//     * @param zip location's zip
//     */
//    public void setZip(int zip) {
//        this.zip = zip;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for Type
//     * @return type
//     */
//    public LocationType getType() {
//        return type;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Type
//     * @param type location's type
//     */
//    public void setType(LocationType type) {
//        this.type = type;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

    /**
     * Getter for Phone.
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Phone
//     * @param phone location's phone
//     */
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Getter for Website
//     * @return website
//     */
//    public String getWebsite() {
//        return website;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

// --Commented out by Inspection START (11/14/2018 3:09 PM):
//    /**
//     * Setter for Website
//     * @param website location's website
//     */
//    public void setWebsite(String website) {
//        this.website = website;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:09 PM)

    //TODO: toString should not include formatting
    @Override
    public String toString() {
        return name;
    }

    /**
     * Getter for Details
     * @return formats the information of the location
     */
    public String getDetails() {
        return String.format(" Name: %s\n\n" + " Latitude: %s\n\n" +
                        " Longitude: %s\n\n" + " Street Address: %s\n\n" + " City: %s\n\n" +
                        " State: %s\n\n" + " Zip: %s\n\n" + " Type: %s\n\n" +
                        " Phone: %s\n\n" + " Website: %s\n\n",
                name, latitude, longitude,
                address, city, state,
                zip, type, phone,
                website);
    }
    //used by reading/saving functions

    /**
     * Creates a formatted string.
     * @return the formatted variable all in caps
     */
    public String toStringEx() {
        String ret = key + "," + name + "," + latitude + "," + longitude + "," + address + "," +
                city + "," + state + "," + zip + "," + type + "," + phone + "," + website;
        return ret.toUpperCase();
    }

    /**
     * Parses Location's information
     * @param loc location
     * @return creates location as a list
     */
    public static Location parseLocation(String loc) {
        final int KEY = 0;
        final int NAME = 1;
        final int LATITUDE = 2;
        final int LONGITUDE = 3;
        final int STREET_ADDRESS = 4;
        final int CITY = 5;
        final int STATE = 6;
        final int ZIP = 7;
        final int TYPE = 8;
        final int PHONE = 9;
        final int WEBSITE = 10;

        String[] tokens = loc.split(",");

        int key = Integer.parseInt(tokens[KEY]);
        float latitude = Float.parseFloat(tokens[LATITUDE]);
        float longitude = Float.parseFloat(tokens[LONGITUDE]);
        int zip = Integer.parseInt(tokens[ZIP]);

        return new Location(key, tokens[NAME], longitude, latitude, tokens[STREET_ADDRESS],
                tokens[CITY], tokens[STATE], zip, LocationType.get(tokens[TYPE]), tokens[PHONE],
                tokens[WEBSITE]);
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (!(o instanceof Location))) {
            return false;
        }

        String name = ((Location)o).getName();

        return name.equalsIgnoreCase(this.name);
    }
}
