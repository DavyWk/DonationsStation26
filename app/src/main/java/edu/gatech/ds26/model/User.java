package edu.gatech.ds26.model;

import android.os.Parcel;
import android.os.Parcelable;

// A user is anyone who wants to use the system to view inventory or locations.
// They cannot actually alter any information
public class User {

    private String name;
    private String loginId;
    private String password;
    private AccountType type;
    private AccountState state;
    private String id; // UXX, LXX, MXX, AXX
    protected static int IDCOUNTER;

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
        this("Enter name", "Enter login Id", "Enter password", AccountType.USER, AccountState.UNLOCKED);
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
}
