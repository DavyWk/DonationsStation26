package edu.gatech.ds26.controllers;

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

    List<Donation> donations;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_location_items);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        donations = DonationList.getInstance().getDonations();

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
        view.getContext().startActivity(intent);
        finish();
    }
}
