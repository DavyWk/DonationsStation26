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
import edu.gatech.ds26.model.Location;

/**
 * This class updates the list of location as new information comes from the database.
 */
public class LocationAdapter extends
        RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private final List<Location> mLocations;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View locationView = inflater.inflate(R.layout.location_adapter_recycler_view, parent, false);


        return new ViewHolder(locationView);
    }

    /**
     * A constructor for creating a list view from a list of locations
     * @param locations A list locations
     */
    public LocationAdapter(List<Location> locations) {
        if(locations == null){
            mLocations = new ArrayList<>();
        }else {
            mLocations = locations;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        Location location = mLocations.get(position);

        TextView nameView = viewHolder.nameTextView;
        nameView.setText(location.getName());
        Button moreInfoButton = viewHolder.detailsButton;
        moreInfoButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Log.d("Location Adapter", "Clicked on " + viewHolder.getAdapterPosition());
                Intent intent = new Intent (context, LocationDetailsActivity.class);
                intent.putExtra("key", viewHolder.getAdapterPosition() + 1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLocations.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameTextView;
        final Button detailsButton;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.text_name);
            detailsButton = view.findViewById(R.id.button_details);
        }
    }
}