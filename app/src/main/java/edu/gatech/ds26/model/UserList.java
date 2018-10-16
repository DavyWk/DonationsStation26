package edu.gatech.ds26.model;

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
            if (user.getLoginId().equals(loginId) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }
    public boolean verifyUser(String loginId) {
        for (User user: userList) {
            if (user.getLoginId().equals(loginId)) {
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
}
