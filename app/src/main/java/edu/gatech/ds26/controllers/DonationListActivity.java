package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;

/**
 * This class creates the donation list within locations.
 */
public class DonationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent i = getIntent();
        Location loc = i.getParcelableExtra("Location");

        DonationList donationListInstance = DonationList.getInstance();

        List<Donation> donations = donationListInstance.getDonations(loc);

        RecyclerView.Adapter adapter = new DonationAdapter(donations);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Redirects to the Add Donation Screen.
     * @param view The current view that the user is in.
     */
    public void onAddDonationButtonPressed(View view) {
        Log.d("Donation List Screen", "Add Donation Button");
        Intent intent = new Intent(this, AddDonationActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Donation List Screen", "Back Button");
        Intent intent = new Intent(this, LocationListActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
}