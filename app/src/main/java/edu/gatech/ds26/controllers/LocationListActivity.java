package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

/**
 * This class creates the location list within the app.
 */
public class LocationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewLocation);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LocationList locList = LocationList.getInstance();
        readSDFile();
        List<Location> locations = locList.get();

        RecyclerView.Adapter adapter = new LocationAdapter(locations);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Sends the user to the previous screen when the back button is pressed
     * Automatically runs when the back button is pressed
     * @param view The current view that the user is in.
     */
    public void onBackButtonPressed(View view) {
        Log.d("Location List Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }

    /**
     * Reads the raw data to obtain the locations.
     */
    private void readSDFile() {
        LocationList locationList = LocationList.getInstance();

        try {
             Resources resources = getResources();
            InputStream is = resources.openRawResource(R.raw.location_data);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            line = br.readLine();
            while (line != null) {
                Log.d("LocationList", line);
                locationList.addLocation(Location.parseLocation(line));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            Log.e("LocationList", "error reading assets", e);
        }
    }
}