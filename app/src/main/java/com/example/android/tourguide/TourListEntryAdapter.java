package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourListEntryAdapter extends ArrayAdapter<TourListEntry> {
    public TourListEntryAdapter(Context context, int resource, ArrayList<TourListEntry> tourList) {
        super(context, resource, tourList);
    }

    // implement a class for the view holder pattern
    static private class ViewHolder {
        private TextView titleName;
        private TextView description;
        private ImageView image;
    }

    // we will only bind with a null convertView
    @BindView(R.id.titleName)
    TextView title;
    @BindView(R.id.DescriptionName)
    TextView description;
    @BindView(R.id.PointImage)
    ImageView image;

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        // instantiate the view holder class
        ViewHolder holder;

        // if a new list, inflate a new list item
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tour_list_item_layout, container, false);

            // call the butterknife binding method
            ButterKnife.bind(this, convertView);

            // assign the view holder variables
            holder = new ViewHolder();
            holder.titleName = title;
            holder.description = description;
            holder.image = image;
            convertView.setTag(holder);
        } else {
            // existing item, so grab the save view holder
            holder = (ViewHolder) convertView.getTag();
        }

        // get a handle to the item in the array indexed by position
        TourListEntry entry = getItem(position);

        // set the text fields
        holder.titleName.setText(entry.getName());
        holder.description.setText(entry.getDescription());

        // get the resource id for the album art image we will bind to the album art UI element
        int resourceID = getContext().getResources().getIdentifier(entry.getPicture(),
                getContext().getResources().getString(R.string.folder_string),
                getContext().getPackageName());
        holder.image.setImageResource(resourceID);

        return convertView;
    }
}