package edu.gatech.ds26.model;

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

    public Location(int key, String name, double longitude, double latitude, String address,
                     String city, String state, int zip, LocationType type, String phone, String website) {
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


    public Location(){
        this.key = 4;
        this.name = "Liana";
        this.latitude = 500;
        this.longitude = 2;
        this.address = "GATECH station";
        this.city = "Atlanta";
        this.state = "GA";
        this.zip = 30332;
        this.type = LocationType.Dropoff;
        this.phone = "123456789";
        this.website = "www.lol";
    }

    private void setAll(int key, String name, double latitude, double longitude, String address,
                        String city, String state, int zip, LocationType type, String phone, String website){
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
  
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String toString() {
        return String.format(" Name: %s\n\n" + " Latitude: %s\n\n" +
                        " Longitude: %s\n\n" + " Street Address: %s\n\n" + " City: %s\n\n" +
                        " State: %s\n\n" + " Zip: %s\n\n" + " Type: %s\n\n" +
                        " Phone: %s\n\n" + " Website: %s\n\n",
                name, latitude, longitude,
                address, city, state,
                zip, type, phone,
                website);
    }

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
                tokens[CITY], tokens[STATE], zip, LocationType.get(tokens[TYPE]), tokens[PHONE], tokens[WEBSITE]);
    }
}
