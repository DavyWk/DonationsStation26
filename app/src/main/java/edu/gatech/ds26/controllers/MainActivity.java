package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import edu.gatech.ds26.R;

/**
 * This class shows the application's main page.
 */
public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    /**
     * Initialize activity for Main Screen.
     * @param savedInstanceState contains the data most recently supplied in.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    /**
     * Button handler for the login.
     * @param view the button
     */
    public void onLogoutPressed(View view) {
        Log.d("Main Screen", "Logout Button");
        Intent intent = new Intent(this, WelcomeActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for the Location List.
     * @param view the button
     */
    public void onLocationListPressed(View view) {
        Log.d("Main Screen", "Location List Button");
        Intent intent = new Intent(this, LocationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for All Donations.
     * @param view the button
     */
    public void onDonationAllPressed(View view) {
        Log.d("Main Screen", "All Donation Button");
        Intent intent = new Intent(this, DonationAllActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for Donation's Location.
     * @param view the button
     */
    public void onDonationLocationPressed(View view) {
        Log.d("Main Screen", "All Donation By Location Button");
        Intent intent = new Intent(this, DonationLocationItem.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for the Categories.
     * @param view the button
     */
    public void onCategoryButtonPressed(View view) {
        Log.d("Main Screen", "Category Item Button");
        Intent intent = new Intent(this, DonationCategoryActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for the Maps.
     * @param view the button
     */
    public void onOpenMapsButtonPressed(View view) {
        Log.d("Main Screen", "Open Maps Button");
        Intent intent = new Intent(this, MapsActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
