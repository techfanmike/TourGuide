package com.example.android.tourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    ViewHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        ViewHolder holder;

        // if a new list, inflate a new list item
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tour_list_item_layout, container, false);

            // call the butterknife binding method
            ButterKnife.bind(this, convertView);

            holder = new ViewHolder();
            holder.titleName = title;
            holder.description = description;
            holder.image = image;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // get a handle to the item in the array indexed by position
        TourListEntry entry = getItem(position);

        holder.titleName.setText(entry.getName());
        holder.description.setText(entry.getDescription());

        // get the resource id for the album art image we will bind to the album art UI element
        int resourceID = getContext().getResources().getIdentifier(entry.getPicture(), "mipmap",
                getContext().getPackageName());
        holder.image.setImageResource(resourceID);

        return convertView;
    }
}