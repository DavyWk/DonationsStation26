package edu.gatech.ds26.model;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This class is used to implement the database for the project.
 */
public class Facade {
//TODO: Change all hardcoded file names into constants.

    /**
     * Retrieves a list of users
     * @param c global information
     */
    public static void loadUserList(Context c) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(
                    c.getFilesDir(), "users.txt")));
            UserList userListInstance = UserList.getInstance();

            userListInstance.loadFromText(br);
            br.close();
        } catch (FileNotFoundException fne) {
            Log.e("Facade", "No users.txt found");
        } catch (IOException e) {
            Log.e("Facade", "Exception closing the writer");
            e.printStackTrace();
        }
    }

    /**
     * Saves a user list into a text file.
     * @param c global information
     */
    public static void saveUserList(Context c) {
        try {
            PrintWriter writer = new PrintWriter(new File(c.getFilesDir(), "users.txt"));
            UserList userListInstance = UserList.getInstance();

            userListInstance.saveAsText(writer);
            writer.close();
        } catch (IOException e) {
            Log.e("Facade", "Error saving user list");
            e.printStackTrace();
        }
    }

    /**
     * Load up the text that contains the database of the donation.
     * @param c global information
     */
    public static void loadDonationList(Context c) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(
                    c.getFilesDir(), "donations.txt")));
            DonationList donationListInstance = DonationList.getInstance();

            donationListInstance.loadFromText(br);
            br.close();
        } catch (FileNotFoundException fne) {
            Log.e("Facade", "No items.txt found");
        } catch (IOException e) {
            Log.e("Facade", "Error loading donations list");
            e.printStackTrace();
        }
    }

    /**
     * Saves a donation list into a text file.
     * @param c global information
     */
    public static void saveDonationList(Context c) {
        try {
            PrintWriter writer = new PrintWriter(new File(c.getFilesDir(), "donations.txt"));
            DonationList donationListInstance = DonationList.getInstance();

            donationListInstance.saveAsText(writer);
            writer.close();
        } catch (IOException e) {
            Log.e("Facade", "Error saving donation list");
            e.printStackTrace();
        }
    }
}
