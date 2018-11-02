package edu.gatech.ds26.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import android.util.Log;

// A user is anyone who wants to use the system to view inventory or locations.
// They cannot actually alter any information
public class User {

    private String name;
    private String loginId;
    private String password;
    private AccountType type;
    private AccountState state;

    public User(String name, String loginId, String password, AccountType type, AccountState state) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.type = type;
        this.state = state;
    }

    public User(String name, String loginId, String password, AccountType type) {
        this(name, loginId, password, type, AccountState.UNLOCKED);
    }

    public User(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.USER, AccountState.UNLOCKED);
    }

    public User() {
        this("Enter name", "Enter login Id", "Enter password");
    }

    public boolean login(String pw) {
        return this.password.equals(pw);
    }

    public boolean checkID(String id) {
        return this.loginId.equals(id);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getLoginId() {
        return loginId;
    }

    public void setPassword(String password) {
        this.password =  password;
    }
    public String getPassword() {
        return password;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
    public AccountType getType() { return type; }

    public void setState(AccountState state) {
        this.state = state;
    }
    public AccountState getState() {
        return state;
    }

    void saveAsText(PrintWriter writer) {
        Log.d("User", "Saving user");
        writer.println("User:" + "\t" + name + "\t" + loginId+ "\t" + password + "\t" + type + "\t" + state);
    }

    public static User loadFromText(String line) {
        Log.d("User", "Retrieving user");
        String[] tokens = line.split("\t");
        return new User(tokens[1], tokens[2], tokens[3], AccountType.get(tokens[4]), AccountState.get(tokens[5]));

    }
}
