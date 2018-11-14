package edu.gatech.ds26.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class gives the access to control the user's list in the database
 */
public class UserList {

    private static final UserList _instance = new UserList();
    public static UserList getInstance() { return _instance; }

    /** holds the list of all users */
    private final List<User> userList;
    private User currentUser;

    /**
     * Constructor for UserList
     */
    public UserList() {
        userList = new ArrayList<>();
        userList.add(new User("user", "user1", "1"));
        userList.add(new Admin("admin", "admin1,", "1"));
    }

    /**
     * Validates if user is unique in the list.
     * @param loginId the user's email or ID number
     * @param password user's password
     * @return boolean for authentication
     */
    public boolean authenticateUser(String loginId, String password) {
        for (User user: userList) {
            if (user.checkID(loginId) && user.login(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies the users in the database.
     * @param loginId the user's email or ID number
     * @return boolean for verification
     */
    public boolean verifyUser(String loginId) {
        for (User user: userList) {
            if (user.checkID(loginId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adding users into the database.
     * @param user the user of the app
     * @return boolean to ensure addition
     */
    public boolean addUser(User user) {
        if (verifyUser(user.getLoginId())) {
            return false;
        }
        userList.add(user);
        return true;
    }

    /**
     * A getter for Current User
     * @return current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Save userList into a text file.
     * @param writer writes the file
     */
    public void saveAsText(PrintWriter writer) {
        for (User s : userList) {
            s.saveAsText(writer);
        }
    }

    //there will be one file per thing we have to save, this should load "students.txt"

    /**
     * Load up the text that contains the database of the users.
     * @param reader reads the file
     * @throws IOException whenever the document is unavailable/nonexistent
     */
    public void loadFromText(BufferedReader reader) throws IOException {
        userList.clear();

        String line = reader.readLine();
        while (line != null) {
            userList.add(User.loadFromText(line));
            line = reader.readLine();
        }
        reader.close();
    }
}
