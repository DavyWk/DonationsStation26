package edu.gatech.ds26.model;

class Manager extends LocationEmployee {

    Manager(String loginName, String password, AccountType type, AccountState state) {
        super(loginName, password, type, state);
    }
    Manager(String loginName, String password, AccountState state) {
        this(loginName, password, AccountType.MANAGER, state);
    }
    Manager(String loginName, String password) {
        this(loginName, password, AccountType.MANAGER, AccountState.UNLOCKED);
    }
}
