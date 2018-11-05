package edu.gatech.ds26.model;

// A location employee is someone who works at one of the dropoff sites and can update the current inventories for his or her location
class LocationEmployee extends User {

    LocationEmployee(String name, String loginId, String password, AccountType type, AccountState state) {
        super(name, loginId, password, type, state);
    }
    LocationEmployee(String name, String loginId, String password, AccountState state) {
        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, state);
    }
    LocationEmployee(String name, String loginId, String password) {
        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, AccountState.UNLOCKED);
    }
}
