package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import edu.gatech.ds26.R;

public class AddDonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
    }

    public void onBackButtonPressed(View view) {
        Log.d("Add Donation Screen", "Back Button");
        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
