package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;

/**
 * This class contains the item's by location that were donated.
 */
public class DonationLocationItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_location_items);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DonationList donationListInstance = DonationList.getInstance();
        List<Donation> donations = donationListInstance.getDonations();

        RecyclerView.Adapter adapter = new DonationAdapter(donations);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Item Location Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
}
