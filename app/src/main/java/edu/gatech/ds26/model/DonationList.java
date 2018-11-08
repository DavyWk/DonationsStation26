package edu.gatech.ds26.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DonationList {
    private static final DonationList instance = new DonationList();
    private final Map<Location, List<Donation>> map;

    private DonationList() {
        map = new HashMap<>();
    }
    public int index;

    public static DonationList getInstance() { return instance; }

    public boolean addDonation(Donation d) {
        if (d == null) { return false; }

        map.putIfAbsent(d.getLocation(), new ArrayList<Donation>()) ;
        map.get(d.getLocation()).add(d);
        return true;
    }

    public boolean removeDonation(Donation d) {
        if (d == null) { return false; }
        List<Donation> l = map.get(d.getLocation());
        return l != null && l.remove(d);
    }

    public List<Donation> getDonations() {
        List<Donation> list = new ArrayList<>();
        for (List<Donation> l : map.values()) {
            list.addAll(l);
        }
        return list;
    }

    public List<Donation> getDonations(Location l) {
        List<Donation> ret = map.get(l);
        return ret == null ? new ArrayList<Donation>() : ret;
    }

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
    public ArrayList<Donation> searchIemAtLocation(Location loc, String itemName) {
        ArrayList<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getShortDescription().toLowerCase().contains(itemName.toLowerCase())) {
                ret.add(d);
            }
        }
        return ret;
    }

    public List<Donation> searchItemByCategory(Category cat) {
        List<Donation> ret = new ArrayList<>();
        for (Location l: map.keySet()) {
            ret.addAll(searchItemByCategoryAtLocation(l, cat));
        }
        return ret;
    }

    public List<Donation> searchItemByCategoryAtLocation(Location loc, Category cat) {
        List<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getCategory() == cat) {
                ret.add(d);
            }
        }
        return ret;
    }

    public void saveAsText(PrintWriter writer) {
        for (Donation d : this.getDonations()) {
            d.saveAsText(writer);
        }
    }

    public void loadFromText(BufferedReader reader) throws IOException {
        map.clear();

        String line = reader.readLine();
        while (line != null) {
            Donation d = Donation.loadFromText(line);
            Location dLoc = d.getLocation();
            map.putIfAbsent(dLoc, new ArrayList<Donation>());
            map.get(dLoc).add(d);
            line = reader.readLine();
        }
    }
}