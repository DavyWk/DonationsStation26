package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

/**
 * This class provides the details about the locations.
 */
public class LocationDetailsActivity extends AppCompatActivity {

    @Override
    /**
     * Initialize activity for Locations's Details.
     * @param savedInstanceState contains the data most recently supplied in.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        final int key = (int) getIntent().getSerializableExtra("key");
        getIntent();
        LocationList locationList = LocationList.getInstance();

        String details = "";

        //TODO: Learn how to bold the detail headers when it prints on the detail screen.
        for (Location location : locationList.get()){
            if (location.getKey() == key) {
                details = location.getDetails(); //this is wrong
            }
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(details);
    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Location Details Screen", "Back Button");
        Intent intent = new Intent(this, LocationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for the View Donations.
     * @param view the button
     */
    public void onViewDonationsButtonPressed(View view) {
        Log.d("Location Details Screen", "View Donations Button");
        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}