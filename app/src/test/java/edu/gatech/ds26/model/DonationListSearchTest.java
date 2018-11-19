package edu.gatech.ds26.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests the search functions in the Donation List
 * @author Moetchadjia Davy Waku Kouomou
 */
public class DonationListSearchTest {

    private DonationList list;
    private Donation comp;
    private Donation table;
    private Donation dawg;
    private Location gt;
    private Location uga;
    @Before
    public void setup() {
        list = DonationList.getInstance();
        gt = new Location(0, "Georgia Tech", 0, 0, "2340 Techwood Drive", "Atlanta", "GA",
                30332, LocationType.WAREHOUSE, "404-404-2340", "www.gatech.edu");
        uga = new Location(1, "u(sic)GA", 0, 0, "far away", "Athens", "GA",
                00000, LocationType.WAREHOUSE, "000-000-0000", "www.uga.edu");
        comp = new Donation("now", gt, "computer",
                    "used in CS2110", 4.0f, Category.ELECTRONICS);
        table = new Donation("now", gt,"table", "wooden artifact", 0.0f, Category.HOUSEHOLD);
        dawg = new Donation("now", uga, "animal", "red and black", 0.0f, Category.KITCHEN);
        list.addDonation(comp);
        list.addDonation(table);
        list.addDonation(dawg);
    }

    /**
     * Search by name
     */
    @Test
    public void searchByNameTest() {
        assertTrue(list.searchItem("comp").contains(comp));
        assertTrue(list.searchItem("anim").contains(dawg));
        assertTrue(list.searchItem("buzzzz").size() == 0);
    }

    /**
     * Search by Category
     */
    @Test
    public void searchByCategoryTest() {
        assertTrue(list.searchItemByCategory(Category.ELECTRONICS).contains(comp));
        assertFalse(list.searchItemByCategory(Category.OTHER).contains(comp));
    }

    /**
     * Search at Location
     */
    @Test
    public void searchAtLocationTest() {
        assertTrue(list.searchIemAtLocation(gt, "animal").size() == 0);
        assertTrue(list.searchIemAtLocation(gt, "table").contains(table));
    }
}
