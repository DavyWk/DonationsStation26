package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;

/**
 * This class creates the donation list within locations.
 */
public class DonationListActivity extends AppCompatActivity {

    List<Donation> donations;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    /**
     * Initialize activity for Donation List.
     * @param savedInstanceState contains the data most recently supplied in.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
        recyclerView = findViewById(R.id.recyclerViewDonation);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent i = getIntent();
        Location loc = i.getParcelableExtra("Location");
        donations = DonationList.getInstance().getDonations(loc);

        adapter = new DonationAdapter((ArrayList<Donation>) donations);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Redirects to the Add Donation Screen.
     * @param view The current view that the user is in.
     */
    public void onAddDonationButtonPressed(View view) {
        Log.d("Donation List Screen", "Add Donation Button");
        Intent intent = new Intent(this, AddDonationActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Donation List Screen", "Back Button");
        Intent intent = new Intent(this, LocationDetailsActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}