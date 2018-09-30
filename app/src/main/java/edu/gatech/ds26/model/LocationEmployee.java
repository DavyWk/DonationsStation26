package edu.gatech.ds26.model;

// A location employee is someone who works at one of the dropoff sites and can update the current inventories for his or her location
class LocationEmployee extends User {

    LocationEmployee(String loginName, String password, AccountType type, AccountState state) {
        super(loginName, password, type, state);
    }
    LocationEmployee(String loginName, String password, AccountState state) {
        this(loginName, password, AccountType.LOCATIONEMPLOYEE, state);
    }
    LocationEmployee(String loginName, String password) {
        this(loginName, password, AccountType.LOCATIONEMPLOYEE, AccountState.UNLOCKED);
    }
}
