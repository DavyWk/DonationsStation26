package edu.gatech.ds26.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
    @author McKennley Wilson
    Checks the authenticate user method
 */
public class UserListTest {

    private UserList userList;
    private User user;

    /**
     * Initializes an instance of the userList and a user
     */
    @Before
    public void setUp() {
        userList = UserList.getInstance();
        user = new User("Bob", "Water1","2340");
        userList.addUser(user);
    }

    /**
     * Tests authenticateUser with an unregistered user
     * have been input
     */
    @Test
    public void UnregisteredUser() {
        boolean test = userList.authenticateUser("Billy","hacker1");
        assertFalse(test);
    }

    /**
     * Tests authenticateUser with a correct user and incorrect password
     * have been input
     */
    @Test
    public void RegisteredUserWrongPassword() {
        boolean test = userList.authenticateUser("Water1","hacker1");
        assertFalse(test);
    }

    /**
     * Tests authenticateUser with a right user and right password
     * have been input
     */
    @Test
    public void RegisteredUserRightPassword() {
        boolean test = userList.authenticateUser("Water1","2340");
        assertTrue(test);
    }

    /**
     * Tests authenticateUser with a null user and password
     * have been input
     */
    @Test
    public void NullUserNullPassword() {
        boolean test = userList.authenticateUser(null,null);
        assertFalse(test);
    }

    /**
     * Tests authenticateUser with an unregistered user and null password
     * have been input
     */
    @Test
    public void UnregisteredUserNullPassword() {
        boolean test = userList.authenticateUser("CodeBreaker",null);
        assertFalse(test);
    }

    /**
     * Tests authenticateUser with an unregistered user and null password
     * have been input
     */
    @Test
    public void RegisteredUserNullPassword() {
        boolean test = userList.authenticateUser("Water1",null);
        assertFalse(test);
    }

}
