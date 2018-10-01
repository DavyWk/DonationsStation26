package edu.gatech.ds26.model;

class Manager extends LocationEmployee {

    Manager(String name, String loginId, String password, AccountType type, AccountState state) {
        super(name, loginId, password, type, state);
    }
    Manager(String name, String loginId, String password, AccountState state) {
        this(name, loginId, password, AccountType.MANAGER, state);
    }
    Manager(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.MANAGER, AccountState.UNLOCKED);
    }
}
