package edu.gatech.ds26.model;

class LocationEmployee extends User {
    private Location loc;

    LocationEmployee(String name, String loginId, String password, AccountType type,
                     AccountState state) {
        super(name, loginId, password, type, state);
    }

    LocationEmployee(String name, String loginId, String password, AccountState state) {
        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, state);
    }

    LocationEmployee(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, AccountState.UNLOCKED);
    }
}
