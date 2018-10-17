package edu.gatech.ds26.controllers;

import android.content.Intent;
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
import java.util.ArrayList;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

public class LocationListActivity extends AppCompatActivity {

    ArrayList<Location> locations;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final int KEY = 0;
    private static final int NAME = 1;
    private static final int LATITUDE = 2;
    private static final int LONGITUDE = 3;
    private static final int STREET_ADDRESS = 4;
    private static final int CITY = 5;
    private static final int STATE = 6;
    private static final int ZIP = 7;
    private static final int TYPE = 8;
    private static final int PHONE = 9;
    private static final int WEBSITE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewLocation);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LocationList locList = LocationList.getInstance();
        if (locList.get().isEmpty()) {
            readSDFile();
        }
        locations = locList.get();

        adapter = new LocationAdapter(locations);
        recyclerView.setAdapter(adapter);
    }

    public void onBackButtonPressed(View view) {
        Log.d("Location List Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    private void readSDFile() {
        LocationList locationList = LocationList.getInstance();

        try {
            InputStream is = getResources().openRawResource(R.raw.location_data);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line

            while ((line = br.readLine()) != null) {
                Log.d("LocationList", line);
                String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[KEY]);
                float latitude = Float.parseFloat(tokens[LATITUDE]);
                float longitude = Float.parseFloat(tokens[LONGITUDE]);
                int zip = Integer.parseInt(tokens[ZIP]);

                locationList.addLocation(new Location(key, tokens[NAME], longitude, latitude, tokens[STREET_ADDRESS],
                        tokens[CITY], tokens[STATE], zip, tokens[TYPE], tokens[PHONE], tokens[WEBSITE]));
            }
            br.close();
        } catch (IOException e) {
            Log.e("LocationList", "error reading assets", e);
        }
    }
}