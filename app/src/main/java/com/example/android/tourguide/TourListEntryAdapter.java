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

    @BindView(R.id.titleName)
    TextView title;
    @BindView(R.id.DescriptionName)
    TextView description;
    @BindView(R.id.PointImage)
    ImageView image;

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        TourListEntry entry = getItem(position);

        // if a new list, inflate a new list item
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tour_list_item_layout, container, false);
        }

        // call the butterknife binding method
        ButterKnife.bind(this, convertView);

        title.setText(entry.getName());
        description.setText(entry.getDescription());
        image.setImageResource(R.mipmap.image_varsity_foreground);

        return convertView;
    }
}
