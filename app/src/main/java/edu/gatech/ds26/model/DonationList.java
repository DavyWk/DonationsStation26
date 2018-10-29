package edu.gatech.ds26.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DonationList {
    private static final DonationList instance = new DonationList();
    private Map<Location, List<Donation>> map;

    private DonationList() {
        map = new HashMap<>();
    }

    public static DonationList getInstance() { return instance; }

    public boolean addDonation(Donation d) {
        if (d == null) { return false; }

        map.putIfAbsent(d.getLocation(), new ArrayList<Donation>()) ;
        map.get(d.getLocation()).add(d);
        return true;
    }

    public boolean removeDonation(Donation d) {
        if (d == null) { return false; }
        List<Donation> l = map.get(d);
        return l == null ? false : l.remove(d);
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
    public List<Donation> searchIemAtLocation(Location loc, String itemName) {
        List<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getShortDescription().toLowerCase().contains(itemName.toLowerCase())) {
                ret.add(d);
            }
        }
        return ret;
    }

    public List<Donation> searchItemByCategory(ItemCategory cat) {
        List<Donation> ret = new ArrayList<>();
        for (Location l: map.keySet()) {
            ret.addAll(searchItemByCategoryAtLocation(l, cat));
        }
        return ret;
    }

    public List<Donation> searchItemByCategoryAtLocation(Location loc, ItemCategory cat) {
        List<Donation> ret = new ArrayList<>();
        for (Donation d : getDonations(loc)) {
            if (d.getCategory() == cat) {
                ret.add(d);
            }
        }
        return ret;
    }

}
