package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Facade;
import edu.gatech.ds26.model.Category;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

/**
 * This creates an activity where users can se the fields for a new donation
 */
public class AddDonationActivity extends AppCompatActivity {

    private final LocationList locationList = LocationList.getInstance();
    private final DonationList donationList = DonationList.getInstance();
    private Spinner location;
    private EditText timeStamp;
    private EditText shortDescription;
    private EditText fullDescription;
    private EditText value;
    private Spinner category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        location = findViewById(R.id.location_spinner);
        timeStamp = findViewById(R.id.date_input);
        shortDescription = findViewById(R.id.shortDescriptionInput);
        fullDescription = findViewById(R.id.fullDescriptionInput);
        value = findViewById(R.id.valueInput);
        category = findViewById(R.id.category_spinner);

        //Can't be weakened to SpinnerAdapter because it needs to have type String
        ArrayAdapter<Location> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, locationList.get());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter);

        ArrayAdapter<Category> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Category.values());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter2);

    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Add Donation Screen", "Back Button");
        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Adds the donation to the screen
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onAddDonationButtonPressed(View view) {
        Log.d("Add Donation Screen", "Add Donation Button");
        Donation d = new Donation(timeStamp.getText().toString(),
                (Location) location.getSelectedItem(),
                shortDescription.getText().toString(),
                fullDescription.getText().toString(),
                Float.parseFloat(value.getText().toString()),
                (Category) category.getSelectedItem());

        donationList.addDonation(d);
        Facade.saveDonationList(this);

        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}