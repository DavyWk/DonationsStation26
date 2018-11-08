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
import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;
import edu.gatech.ds26.model.LocationType;

public class LocationListActivity extends AppCompatActivity {

    List<Location> locations;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        recyclerView = findViewById(R.id.recyclerViewLocation);

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