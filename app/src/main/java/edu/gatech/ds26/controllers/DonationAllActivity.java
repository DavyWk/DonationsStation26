package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;

public class DonationAllActivity extends AppCompatActivity {

    List<Donation> donations;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
    private Donation don;
    private DonationList donationList = DonationList.getInstance();
    EditText itemName;
    String stringItemName;
    private Map<Location, ArrayList<Donation>> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_all);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDonation);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemName = (EditText) findViewById(R.id.itemName);

        donations = DonationList.getInstance().getDonations();

        adapter = new DonationAdapter(donations);
        recyclerView.setAdapter(adapter);
    }

    public void onBackButtonPressed(View view) {
        Log.d("Item all Activity Screen", "Back Button");
        Intent intent = new Intent(this, MainActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
    public void onSearchButtonPressed(View view) {
        Log.d("Screen All Screen", "Search All Button");
        donationList.searchItem(itemName.getText().toString());
        Intent intent = new Intent(this, DonationListActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
