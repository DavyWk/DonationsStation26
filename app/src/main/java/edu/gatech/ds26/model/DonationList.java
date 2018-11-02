package edu.gatech.ds26.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DonationList {
    private static final DonationList instance = new DonationList();
    private Map<Location, ArrayList<Donation>> map;

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
        ArrayList<Donation> l = map.get(d);
        return l == null ? false : l.remove(d);
    }

    public ArrayList<Donation> getDonations() {
        ArrayList<Donation> list = new ArrayList<>();
        for (ArrayList<Donation> l : map.values()) {
            list.addAll(l);
        }
        return list;
    }

    public ArrayList<Donation> getDonations(Location l) {
        ArrayList<Donation> ret = map.get(l);
        return ret == null ? new ArrayList<Donation>() : ret;
    }

    public ArrayList<Donation> searchItem(String itemName) {
        ArrayList<Donation> ret = new ArrayList<>();
        for (ArrayList<Donation> l : map.values()) {
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

    public ArrayList<Donation> searchItemByCategory(ItemCategory cat) {
        ArrayList<Donation> ret = new ArrayList<>();
        for (Location l: map.keySet()) {
            ret.addAll(searchItemByCategoryAtLocation(l, cat));
        }
        return ret;
    }

    public ArrayList<Donation> searchItemByCategoryAtLocation(Location loc, ItemCategory cat) {
        ArrayList<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getCategory() == cat) {
                ret.add(d);
            }
        }
        return ret;
    }

}