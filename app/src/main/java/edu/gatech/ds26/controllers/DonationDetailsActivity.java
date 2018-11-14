package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;

/**
 * This class provides the details about the donations given the center.
 */
public class DonationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        DonationList donationList = DonationList.getInstance();

        String details = "";

        //TODO: Learn how to bold the detail headers when it prints on the detail screen.
        for (Donation donation : donationList.getDonations()){
            details = donation.toString();
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
        Log.d("Donation Details Screen", "Back Button");
        Intent intent = new Intent(this, DonationListActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }

    /**
     * Redirects to the Add Donation Screen.
     * @param view The current view that the user is in.
     */
    public void onAddDonationsButtonPressed(View view) {
        Log.d("Location Details Screen", "View Donations Button");
        Intent intent = new Intent(this, DonationDetailsActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
}