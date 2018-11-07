package edu.gatech.ds26.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static final UserList _instance = new UserList();
    public static UserList getInstance() { return _instance; }

    /** holds the list of all users */
    private List<User> userList;
    private User currentUser;

    private UserList() {
        userList = new ArrayList<>();
        userList.add(new User("user", "user1", "1"));
        userList.add(new Admin("admin", "admin1,", "1"));
    }

    public boolean authenticateUser(String loginId, String password) {
        for (User user: userList) {
            if (user.checkID(loginId) && user.login(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }
    public boolean verifyUser(String loginId) {
        for (User user: userList) {
            if (user.checkID(loginId)) {
                return true;
            }
        }
        return false;
    }

    public boolean addUser(User user) {
        if (verifyUser(user.getLoginId())) {
            return false;
        }
        userList.add(user);
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void saveAsText(PrintWriter writer) {
        for (User s : userList) {
            s.saveAsText(writer);
        }
    }

    //there will be one file per thing we have to save, this should load "students.txt"
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
