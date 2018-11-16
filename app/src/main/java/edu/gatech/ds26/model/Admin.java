package edu.gatech.ds26.model;

/**
 * Creation of a user who is an admin.
 */
class Admin extends User {


    /**
     * Constructor for admin's login.
     * @param name admin's name
     * @param loginId admin's email or ID
     * @param password admin's password
     */
    Admin(String name, String loginId, String password) {
        this(name, loginId, password, AccountState.UNLOCKED);
    }


    /**
     * Constructor for Admin user
     * @param name the name
     * @param loginId the login id
     * @param password the password
     * @param state the state the account is in
     */
    Admin(String name, String loginId, String password, AccountState state) {
        super(name, loginId, password, AccountType.ADMIN, state);
    }
}
