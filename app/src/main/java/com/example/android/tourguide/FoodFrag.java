package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFrag extends Fragment {
    public FoodFrag() {;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {

        View view = inflater.inflate(R.layout.tour_list_layout, container, false);

        // create an array and populate
        ArrayList<TourListEntry> foodArray = new ArrayList<TourListEntry>();
        Utility.populateArray(foodArray, "food", getResources());

        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(new TourListEntryAdapter(getActivity(), R.layout.tour_list_item_layout, foodArray));

        return view;
    }
}