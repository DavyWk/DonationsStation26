package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;

/**
 * Creates an activity displays all the donations available in a recycler view when the all option
 * is chosen in the search results
 */
public class DonationAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_all);
        buildRecyclerView();
        editText = findViewById(R.id.textSearchItem);
    }

    /**
     * The regular recycler view with the donations before a search begins.
     */
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewDonation);
        DonationList donationListInstance = DonationList.getInstance();

        ArrayList<Donation> donations = (ArrayList<Donation>) donationListInstance.getDonations();

        RecyclerView.Adapter adapter = new DonationAdapter(donations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Item all Activity Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
    /**
     * Sends the user to the search results of the params they chose
     * @param view The current view that the user is in.
     */
    public void onSearchButtonPressed(View view) {
        Log.d("Screen All Screen", "Search All Button");
        DonationList donationList = DonationList.getInstance();

        Editable editTextText = editText.getText();

        List<Donation> result = donationList.searchItem(editTextText.toString());
        //mDonations.filterList((ArrayList<Donation>) result);
        Log.d("Search screen", result.size() + " donations found");
        recyclerView.setAdapter(new DonationAdapter(result));
    }
}
