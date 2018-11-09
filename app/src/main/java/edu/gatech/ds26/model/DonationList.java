package edu.gatech.ds26.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

/**
 * This class gives the access to control the donation's list in the database
 */
public class DonationList {
    private static final DonationList instance = new DonationList();
    private final Map<Location, List<Donation>> map;

    private DonationList() {
        map = new HashMap<>();
    }
    public int index;

    /**
     * Constructor for Donation List
     * @return instance of donation
     */
    public static DonationList getInstance() { return instance; }

    /**
     * Add donation from database
     * @param d donation's name
     * @return boolean of donation's addition
     */
    public boolean addDonation(Donation d) {
        if (d == null) { return false; }

        map.putIfAbsent(d.getLocation(), new ArrayList<Donation>()) ;
        map.get(d.getLocation()).add(d);
        return true;
    }

    /**
     * Remove donation from database
     * @param d donation's name
     * @return boolean of donation's removal
     */
    public boolean removeDonation(Donation d) {
        if (d == null) { return false; }
        List<Donation> l = map.get(d.getLocation());
        return l != null && l.remove(d);
    }
    /**
     * Acquire donations from the database
     * @return list of donations
     */
    public List<Donation> getDonations() {
        List<Donation> list = new ArrayList<>();
        for (List<Donation> l : map.values()) {
            list.addAll(l);
        }
        return list;
    }

    /**
     * Acquire donations from the database
     * @param l location
     * @return condition for when the donation is empty
     */
    public List<Donation> getDonations(Location l) {
        List<Donation> ret = map.get(l);
        return ret == null ? new ArrayList<Donation>() : ret;
    }

    /**
     * Search item by name
     * @param itemName item's name
     * @return item in search
     */
    public List<Donation> searchItem(String itemName) {
        List<Donation> ret = new ArrayList<>();
        for (List<Donation> l : map.values()) {
            for (Donation d : l) {
                if (d.getShortDescription().toLowerCase().contains(itemName.toLowerCase())) {
                    ret.add(d);
                }
            }
        }
        return ret;
    }

    //This implements the extra credit for partial match

    /**
     * Search for item by location
     * @param loc location
     * @param itemName item's name
     * @return item in search
     */
    public ArrayList<Donation> searchIemAtLocation(Location loc, String itemName) {
        ArrayList<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getShortDescription().toLowerCase().contains(itemName.toLowerCase())) {
                ret.add(d);
            }
        }
        return ret;
    }

    /**
     * Search for an item by category
     * @param cat category
     * @return item in search
     */
    public List<Donation> searchItemByCategory(Category cat) {
        List<Donation> ret = new ArrayList<>();
        for (Location l: map.keySet()) {
            ret.addAll(searchItemByCategoryAtLocation(l, cat));
        }
        return ret;
    }

    /**
     * Search donation by the category in a location
     * @param loc location
     * @param cat category
     * @return item in search
     */
    public Collection<Donation> searchItemByCategoryAtLocation(Location loc, Category cat) {
        Collection<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getCategory() == cat) {
                ret.add(d);
            }
        }
        return ret;
    }
    /**
     * Creates a new file with donation list's information.
     * @param writer writes the file
     */
    public void saveAsText(PrintWriter writer) {
        for (Donation d : this.getDonations()) {
            d.saveAsText(writer);
        }
    }
    /**
     * Load up the text that contains the database of the donation.
     * @param reader reads the file
     * @throws IOException whenever the document is unavailable/nonexistent
     */
    public void loadFromText(BufferedReader reader) throws IOException {
        map.clear();
        LocationList locList = LocationList.getInstance();
        String line = reader.readLine();
        while (line != null) {
            Donation d = Donation.loadFromText(line);
            Location dLoc = d.getLocation();
            //locList.addLocation(dLoc); //TODO: ideally this would fill up the location list on load
            map.putIfAbsent(dLoc, new ArrayList<Donation>());
            map.get(dLoc).add(d);
            line = reader.readLine();
        }
    }
}