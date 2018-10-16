package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

public class LocationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        final int key = (int) getIntent().getSerializableExtra("key");
        LocationList locationList = LocationList.getInstance();

        String details = "";

        //TODO: Learn how to bold the detail headers when it prints on the detail screen.
        for (Location location : locationList.get()){
            if (location.getKey() == key) {
                details = String.format(" Name: %s\n\n" + " Latitude: %s\n\n" +
                                " Longitude: %s\n\n" + " Street Address: %s\n\n" + " City: %s\n\n" +
                                " State: %s\n\n" + " Zip: %s\n\n" + " Type: %s\n\n" +
                                " Phone: %s\n\n" + " Website: %s\n\n",
                        location.getName(), location.getLatitude(), location.getLongitude(),
                        location.getAddress(), location.getCity(), location.getState(),
                        location.getZip(), location.getType(), location.getPhone(),
                        location.getWebsite());
            }
        }
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(details);
    }

    public void onBackButtonPressed(View view) {
        Log.d("Location Details Screen", "Back Button");
        Intent intent = new Intent(this, LocationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
