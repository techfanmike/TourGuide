package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

// fragment to hold sightseeing locations
public class SightsFrag extends Fragment {
    public SightsFrag() {
        ;
    }

    @BindView(R.id.list_view)
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {

        View view = inflater.inflate(R.layout.tour_list_layout, container, false);

        // create an array and populate
        ArrayList<TourListEntry> sightsArray = new ArrayList<TourListEntry>();
        Utility.populateArray(sightsArray, "sights", getResources(), getContext().getPackageName());

        // call the butterknife binding method
        ButterKnife.bind(this, view);

        listView.setAdapter(new TourListEntryAdapter(getActivity(), R.layout.tour_list_item_layout, sightsArray));

        return view;
    }
}
