package edu.gatech.ds26.model;

import java.io.PrintWriter;

/**
 * This class generates the template for all of the distinct users of the donation tracker.
 */
public class User {

    private final String name;
    private String loginId;
    private String password;
    private AccountType type;
    private AccountState state;

    /**
     * Constructor for User.
     * @param name user's name
     * @param loginId the user's email or ID number
     * @param password user's password
     * @param type user type
     * @param state user's state
     */
    User(String name, String loginId, String password, AccountType type, AccountState state) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.type = type;
        this.state = state;
    }

    /**
     * Constructor for User with an Unlocked state.
     * @param name user's name
     * @param loginId the user's email or ID number
     * @param password user's password
     * @param type user type
     */
    public User(String name, String loginId, String password, AccountType type) {
        this(name, loginId, password, type, AccountState.UNLOCKED);
    }

    /**
     *
     * @param name user's name
     * @param loginId the user's email or ID number
     * @param password user's password
     */
    public User(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.USER, AccountState.UNLOCKED);
    }

    /**
     * Getter for User.
     */
    User() {
        this("Enter name", "Enter login Id", "Enter password");
    }

    /**
     * Getter for login.
     * @param pw user's input
     * @return the password
     */
    public boolean login(String pw) {
        return this.password.equals(pw);
    }

    /**
     * Getter for ID.
     * @param id user's id
     * @return user's id
     */
    public boolean checkID(String id) {
        return this.loginId.equals(id);
    }

// --Commented out by Inspection START (11/14/2018 3:06 PM):
//    /**
//     * Getter for Name.
//     * @return name
//     */
//    public String getName() {
//        return name;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:06 PM)

// --Commented out by Inspection START (11/14/2018 3:06 PM):
//    /**
//     * Setter for LoginID.
//     * @param loginId user's email or ID
//     */
//    public void setLoginId(String loginId) {
//        this.loginId = loginId;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:06 PM)

    /**
     * Getter for LoginID.
     * @return loginID
     */
    public String getLoginId() {
        return loginId;
    }

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Setter for Password.
//     * @param password user's password.
//     */
//    public void setPassword(String password) {
//        this.password =  password;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Getter for Password.
//     * @return password
//     */
//    public String getPassword() {
//        return password;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Setter for user type.
//     * @param type the user's type
//     */
//    public void setType(AccountType type) {
//        this.type = type;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Getter for user type.
//     * @return type
//     */
//    public AccountType getType() { return type; }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Setter for user state
//     * @param state user's state
//     */
//    public void setState(AccountState state) {
//        this.state = state;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Getter for user state
//     * @return state
//     */
//    public AccountState getState() {
//        return state;
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

    /**
     * Creates a new file with user's information.
     * @param writer writes the file
     */
    void saveAsText(PrintWriter writer) {
        writer.println("User:" + "\t" + name + "\t" + loginId+ "\t" + password + "\t" + type + "\t"
                + state);
    }

    /**
     * Open the previously generates file.
     * @param line line from the document.
     * @return loads the user's information.
     */
    public static User loadFromText(String line) {
        String[] tokens = line.split("\t");
        return new User(tokens[1], tokens[2], tokens[3], AccountType.get(tokens[4]),
                AccountState.get(tokens[5]));

    }
}
