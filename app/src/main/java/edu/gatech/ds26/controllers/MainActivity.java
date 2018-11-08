package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import edu.gatech.ds26.R;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    /**
     * Button handler for the login
     *
     * @param view the button
     */
    public void onLogoutPressed(View view) {
        Log.d("Main Screen", "Logout Button");
        Intent intent = new Intent(this, WelcomeActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    public void onLocationListPressed(View view) {
        Log.d("Main Screen", "Location List Button");
        Intent intent = new Intent(this, LocationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
    public void onDonationAllPressed(View view) {
        Log.d("Main Screen", "All Donation Button");
        Intent intent = new Intent(this, DonationAllActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
    public void onDonationLocationPressed(View view) {
        Log.d("Main Screen", "All Donation By Location Button");
        Intent intent = new Intent(this, DonationLocationItem.class);
        view.getContext().startActivity(intent);
        finish();
    }
    public void onCategoryButtonPressed(View view) {
        Log.d("Main Screen", "Category Item Button");
        Intent intent = new Intent(this, DonationCategoryActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
