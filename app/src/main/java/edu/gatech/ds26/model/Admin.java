package edu.gatech.ds26.model;

class Admin extends Manager {

    Admin(String name, String loginId, String password, AccountType type, AccountState state) {
        super(name, loginId, password, type, state);
    }
    Admin(String name, String loginId, String password, AccountState state) {
        this(name, loginId, password, AccountType.ADMIN, state);
    }
    Admin(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.ADMIN, AccountState.UNLOCKED);
    }
}
