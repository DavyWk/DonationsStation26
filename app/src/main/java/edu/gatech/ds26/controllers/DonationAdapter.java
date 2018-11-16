package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.Donation;

/**
 * This class creates the views for how the donations are show in the view list
 */
public class DonationAdapter extends
        RecyclerView.Adapter<DonationAdapter.ViewHolder> {

    private List<Donation> mDonations;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View donationView = inflater.inflate(R.layout.donation_adapter_recycler_view, parent,
                false);

        return new ViewHolder(donationView);
    }

    /**
     * A constructor for creating a list view from a list of donations
     * @param donations A list donations
     */
    public DonationAdapter(List<Donation> donations) {
        if(donations == null){
            mDonations = new ArrayList<>();
        }else {
            mDonations.addAll(donations);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        Donation donation = mDonations.get(position);

        TextView shortDescriptionView = viewHolder.shortDescriptionTextView;
        shortDescriptionView.setText(donation.getShortDescription());
        Button moreInfoButton = viewHolder.detailsButton;
        if (moreInfoButton == null) {
            return; //TODO: this is terrible
        }
        moreInfoButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Log.d("Donation Adapter", "Clicked on " + viewHolder.getAdapterPosition());
                Intent intent = new Intent (context, DonationDetailsActivity.class);

                //this should use viewHolder.getAdapterPosition()
                intent.putExtra("key", viewHolder.getAdapterPosition() + 1);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView shortDescriptionTextView;
        final Button detailsButton;

        /**
         * A constructor for a view holder
         * @param view The current view
         */
        ViewHolder(View view) {
            super(view);
            shortDescriptionTextView = view.findViewById(R.id.text_short_description);
            detailsButton = view.findViewById(R.id.button_details);
        }
    }
// --Commented out by Inspection START (11/14/2018 3:08 PM):
//    public void filterList(List<Donation> filteredList) {
//        mDonations = filteredList;
//        notifyDataSetChanged();
//    }
// --Commented out by Inspection STOP (11/14/2018 3:08 PM)
}