package edu.gatech.ds26.model;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Facade {
//TOOD: Change all hardcoded file names into constants.
    public static void loadUserList(Context c) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(c.getFilesDir(), "users.txt")));
            UserList.getInstance().loadFromText(br);
            br.close();
        } catch (FileNotFoundException fne) {
            Log.d("Facade", "No users.txt found");
        } catch (IOException e) {
            Log.d("Facade", "Exception closing the writer");
            e.printStackTrace();
        }
    }

    public static void saveUserList(Context c) {
        try {
            PrintWriter writer = new PrintWriter(new File(c.getFilesDir(), "users.txt"));
            UserList.getInstance().saveAsText(writer);
            writer.close();
        } catch (IOException e) {
            Log.d("Facade", "Error saving user list");
            e.printStackTrace();
        }
    }

    public static void loadDonationList(Context c) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(c.getFilesDir(), "donations.txt")));
            DonationList.getInstance().loadFromText(br);
            br.close();
        } catch (FileNotFoundException fne) {
            Log.d("Facade", "No items.txt found");
        } catch (IOException e) {
            Log.d("Facade", "Error loading donations list");
            e.printStackTrace();
        }
    }

    public static void saveDonationList(Context c) {
        try {
            PrintWriter writer = new PrintWriter(new File(c.getFilesDir(), "donations.txt"));
            DonationList.getInstance().saveAsText(writer);
            writer.close();
        } catch (IOException e) {
            Log.d("Facade", "Error saving donation list");
            e.printStackTrace();;
        }
    }
}
