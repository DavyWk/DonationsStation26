package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;

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

    public void onBackButtonPressed(View view) {
        Log.d("Location Details Screen", "Back Button");
        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}