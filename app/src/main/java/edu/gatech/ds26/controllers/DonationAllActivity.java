package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;

/**
 * Creates an activity displays all the donations available in a recycler view when the all option
 * is chosen in the search results
 */
public class DonationAllActivity extends AppCompatActivity {

    ArrayList<Donation> donations;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
    private Donation don;
    EditText itemName;
    String stringItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_all);
        recyclerView = findViewById(R.id.recyclerViewDonation);

        itemName = findViewById(R.id.itemNameX);

        donations = (ArrayList<Donation>) DonationList.getInstance().getDonations();

        RecyclerView.Adapter adapter = new DonationAdapter(donations);
        recyclerView.setAdapter(adapter);

    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Item all Activity Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
    /**
     * Sends the user to the search results of the params they chose
     * @param view The current view that the user is in.
     */
    public void onSearchButtonPressed(View view) {
        Log.d("Screen All Screen", "Search All Button");
        DonationList donationList = DonationList.getInstance();
        List<Donation> result = donationList.searchItem(itemName.getText().toString());
        Log.d("Search screen", result.size() + " donations found");
        recyclerView.setAdapter(new DonationAdapter(result));
    }
}
