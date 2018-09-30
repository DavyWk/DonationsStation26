package edu.gatech.ds26.model;

class Admin extends Manager {

    Admin(String loginName, String password, AccountType type, AccountState state) {
        super(loginName, password, type, state);
    }
    Admin(String loginName, String password, AccountState state) {
        this(loginName, password, AccountType.ADMIN, state);
    }
    Admin(String loginName, String password) {
        this(loginName, password, AccountType.ADMIN, AccountState.UNLOCKED);
    }
}
