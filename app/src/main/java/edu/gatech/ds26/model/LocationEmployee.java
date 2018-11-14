package edu.gatech.ds26.model;

/**
 * Creation of a user who is an location employee.
 */
class LocationEmployee extends User {

    /**
     * Constructor for location employee.
     * @param name location employee's name
     * @param loginId location employee's email or ID
     * @param password location employee's password
     * @param type location employee's type
     * @param state location employee's state
     */
    LocationEmployee(String name, String loginId, String password, AccountType type,
                     AccountState state) {
        super(name, loginId, password, type, state);
    }

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Constructor for location employee with the designated user type
//     * @param name location employee's name
//     * @param loginId location employee's email or ID
//     * @param password location employee's password
//     * @param state location employee's state
//     */
//    LocationEmployee(String name, String loginId, String password, AccountState state) {
//        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, state);
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)

// --Commented out by Inspection START (11/14/2018 3:07 PM):
//    /**
//     * Constructor for location employee's login
//     * @param name location employee's name
//     * @param loginId location employee's email or ID
//     * @param password location employee's password
//     */
//    LocationEmployee(String name, String loginId, String password) {
//        this(name, loginId, password, AccountType.LOCATIONEMPLOYEE, AccountState.UNLOCKED);
//    }
// --Commented out by Inspection STOP (11/14/2018 3:07 PM)
}
