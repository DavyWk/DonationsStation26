package edu.gatech.ds26.model;

/**
 * Creation of a user who is an manager.
 */
class Manager extends LocationEmployee {
    /**
     * Constructor for manager.
     * @param name manager's name
     * @param loginId manager's email or ID
     * @param password manager's password
     * @param type manager's type
     * @param state manager's state
     */
    Manager(String name, String loginId, String password, AccountType type, AccountState state) {
        super(name, loginId, password, type, state);
    }

    /**
     * Constructor for manager with the designated user type
     * @param name manager's name
     * @param loginId manager's email or ID
     * @param password manager's password
     * @param state manager's state
     */
    Manager(String name, String loginId, String password, AccountState state) {
        this(name, loginId, password, AccountType.MANAGER, state);
    }

    /**
     * Constructor for manager's login information.
     * @param name manager's name
     * @param loginId manager's email or ID
     * @param password manager's password
     */
    Manager(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.MANAGER, AccountState.UNLOCKED);
    }
}
