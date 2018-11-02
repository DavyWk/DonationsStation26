package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;


public class DonationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        getIntent();
        DonationList donationList = DonationList.getInstance();

        String details = "";

        //TODO: Learn how to bold the detail headers when it prints on the detail screen.
        DonationList donations = DonationList.getInstance();
        LocationList locations = LocationList.getInstance();
        Location current = locations.getCurrent();
        List<Donation> mDonations = donations.getDonations(current);
        Donation ourDonation = mDonations.get(donations.index);
        details = current.getName();
        TextView textView = findViewById(R.id.location);
        textView.setText(details);
        details = ourDonation.getTimeStamp();
        TextView aView = findViewById(R.id.timeStamp);
        aView.setText(details);
        TextView bView = findViewById(R.id.category);
        details = ourDonation.getCategory().toString();
        bView.setText(details);
        TextView cView = findViewById(R.id.value);
        details = String.valueOf(ourDonation.getValue());
        cView.setText(details);
        TextView dView = findViewById(R.id.shortDescription);
        details = ourDonation.getShortDescription();
        dView.setText(details);
        TextView eView = findViewById(R.id.fullDescription);
        details = ourDonation.getFullDescription();
        eView.setText(details);
    }

    public void onBackButtonPressed(View view) {
        Log.d("Location Details Screen", "Back Button");
        Intent intent = new Intent(this, LocationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    public void onAddDonationsButtonPressed(View view) {
        Log.d("Location Details Screen", "View Donations Button");
        Intent intent = new Intent(this, DonationDetailsActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}