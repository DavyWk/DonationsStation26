package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;
import edu.gatech.ds26.model.DonationList;
import edu.gatech.ds26.model.Location;
import edu.gatech.ds26.model.LocationList;

public class DonationAdapter extends
        RecyclerView.Adapter<DonationAdapter.ViewHolder> {

    private ArrayList<Donation> mDonations;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View donationView = inflater.inflate(R.layout.donation_adapter_recycler_view, parent, false);



        ViewHolder viewHolder = new ViewHolder(donationView);
        return viewHolder;
    }

    public DonationAdapter() {
        DonationList donations = DonationList.getInstance();
        LocationList locations = LocationList.getInstance();
        Location current = locations.getCurrent();
        mDonations = donations.getDonations(current);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Donation donation = mDonations.get(position);
        DonationList donations = DonationList.getInstance();
        donations.index = position;
        TextView shortDescriptionView = viewHolder.shortDescriptionTextView;
        shortDescriptionView.setText(donation.getShortDescription());
        Button moreInfoButton = viewHolder.detailsButton;
        moreInfoButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Log.d("Donation Adapter", "Clicked on " + position);
                Intent intent = new Intent (context, ItemDetailsActivity.class);
                intent.putExtra("index", position);

                context.startActivity(intent);
            }
        });
    }
    public void onDetailsButtonPressed(View view){
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView shortDescriptionTextView;
        public Button detailsButton;

        public ViewHolder(View view) {
            super(view);
            shortDescriptionTextView = (TextView) view.findViewById(R.id.text_short_description);
            detailsButton = (Button) view.findViewById(R.id.button_detailsDonate);
        }
    }
}