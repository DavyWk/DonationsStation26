package edu.gatech.ds26.model;

import android.util.Log;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LocationParser{

    public LocationParser() {
       InputStream is = getClass().getResourceAsStream("LocationData.csv");
        try (BufferedReader br  = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                LocationList.getInstance().addLocation(line);
            }
        } catch (IOException e) {
            Log.e("LocationParser", "Error loading data from csv file", e);
        }
    }
}
