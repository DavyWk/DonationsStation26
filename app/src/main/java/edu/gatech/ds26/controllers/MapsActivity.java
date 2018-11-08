package edu.gatech.ds26.controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override //does this happen when the activity is loaded, or when the app is loaded.
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /* Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // moves the camera to
        */
        //where we want to point to (need to pass in a Location)
        List<Location> locList = LocationList.getInstance().get();
        for (Location loc : locList) {
            LatLng pos = new LatLng(loc.getLatitude(), loc.getLongitude());
            MarkerOptions marker = new MarkerOptions();
            marker.position(pos);
            marker.title(loc.getName());
            marker.snippet(loc.getPhone());
            mMap.addMarker(marker);
        }
    }

    /*TODO:
      Map should have pins for each location (use loc.Latitude and loc.Longitude)
      Clicking a pin should give basic information about each Location (name & phone number)
      LatLng = a location on the map (lat, long)
      use mMap.addMarker(new MarkerOptions().position(pos).title(loc.getName()));
      once a location is selected, we want to move the camera to it
    */
}
