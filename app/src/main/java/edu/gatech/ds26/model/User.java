package edu.gatech.ds26.model;

// A user is anyone who wants to use the system to view inventory or locations.
// They cannot actually alter any information
class User {

    private String loginName;
    private String password;
    private AccountType type;
    private AccountState state;
    private String id; // UXX, LXX, MXX, AXX
    protected static int IDCOUNTER;

    User(String loginName, String password, AccountType type, AccountState state) {
        this.loginName = loginName;
        this.password = password;
        this.type = type;
        this.state = state;
    }

    User(String loginName, String password, AccountType type) {
        this(loginName, password, type, AccountState.UNLOCKED);
    }
    User(String loginName, String password) {
        this(loginName, password, AccountType.USER, AccountState.UNLOCKED);
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setPassword(String password) {
        this.password =  password;
    }

    public String getPassword() {
        return password;
    }

    public void setState(AccountState state) {
        this.state = state;
    }
    public AccountState getState() {
        return state;
    }
}
