package edu.gatech.ds26.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
    Liana Syrkett wrote the tests for LocationList.addLocation.
 */

public class LocationListTest {

    LocationList locationList;
    Location location;

    @Before
    public void setUp() {
        locationList = new LocationList();
        location = new Location();
    }

    @Test
    public void addLocation_WhenLocationIsNotNullAndListDoesNotContainLocation_ReturnTrue() {
        boolean value = locationList.addLocation(location);

        assertTrue(locationList.get().contains(location));
        assertTrue(value);
    }

    @Test
    public void addLocation_WhenLocationIsNullAndListDoesNotContainLocation_ReturnFalse() {
        location = null;

        boolean value = locationList.addLocation(location);

        assertFalse(locationList.get().contains(location));
        assertTrue(locationList.get().isEmpty());
        assertFalse(value);
    }

    @Test
    public void addLocation_WhenLocationIsNotNullAndListContainsLocation_ReturnFalse() {
        locationList.addLocation(location);

        boolean value = locationList.addLocation(location);

        assertTrue(locationList.get().contains(location));
        assertFalse(value);
    }
}
