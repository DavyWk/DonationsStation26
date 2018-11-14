package edu.gatech.ds26.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
    @author Liana Syrkett
    Class used to test the addLocation method in LocationList.
 */
public class LocationListTest {

    private LocationList locationList;
    private Location location;

    /**
     * Creates a new LocationList for each test.
     */
    @Before
    public void setUp() {
        locationList = new LocationList();
    }

    /**
     * Tests addLocation when the location is not null and when the locationList does not already
     * contain the location that is passed into addLocation.
     */
    @Test
    public void addLocation_WhenLocationIsNotNullAndListDoesNotContainLocation_ReturnTrue() {
        location = new Location();

        boolean value = locationList.addLocation(location);
        List list = locationList.get();

        assertTrue(list.contains(location));
        assertTrue(value);
    }

    /**
     * Tests addLocation when the location is null and when the locationList does not already
     * contain the location that is passed into addLocation.
     */
    @Test
    public void addLocation_WhenLocationIsNullAndListDoesNotContainLocation_ReturnFalse() {
        boolean value = locationList.addLocation(location);
        List list = locationList.get();

        assertFalse(list.contains(location));
        assertTrue(list.isEmpty());
        assertFalse(value);
    }

    /**
     * Tests addLocation when the location is not null and when the locationList does already
     * conation the location that is passed into addLocation.
     */
    @Test
    public void addLocation_WhenLocationIsNotNullAndListContainsLocation_ReturnFalse() {
        location = new Location();
        locationList.addLocation(location);

        boolean value = locationList.addLocation(location);
        List list = locationList.get();

        assertTrue(list.contains(location));
        assertFalse(value);
    }
}
