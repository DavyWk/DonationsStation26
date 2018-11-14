package edu.gatech.ds26.model;

/**
 * Creation of a user who is an admin.
 */
class Admin extends User {
    /**
     * Constructor for admin.
     * @param name admin's name
     * @param loginId admin's email or ID
     * @param password admin's password
     * @param type admin's type
     * @param state admin's state
     */
    private Admin(String name, String loginId, String password, AccountType type,
                  AccountState state) {
        super(name, loginId, password, type, state);
    }

    /**
     * Constructor for admin's login.
     * @param name admin's name
     * @param loginId admin's email or ID
     * @param password admin's password
     */
    Admin(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.ADMIN, AccountState.UNLOCKED);
    }
}
