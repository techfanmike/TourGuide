package com.example.android.tourguide;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //inject bindings
    @BindView(R.id.pager_view) ViewPager viewPager;
    @BindView(R.id.tab_layout) TabLayout tabLayout;

    private ArrayList<TourListEntry> mSights = null;
    private ArrayList<TourListEntry> mFood = null;
    private ArrayList<TourListEntry> mShopping = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call the butterknife binding method
        ButterKnife.bind(this);

        // instantiate our FragmentPagerAdapter and bind the adapter
        ListFragmentAdapter fragAdapter = new ListFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(fragAdapter);

        // setup the tabs
        tabLayout.setupWithViewPager(viewPager);
    }

    public void populateArray(ArrayList array, String fileName) {
        try {
            // get the handle for the file in the 'raw' folder
            Resources resource = getResources();

            // parameterize
            InputStream is = resource.openRawResource(R.raw.sights);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String line;

            // read a line until done when null returned
            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                array.add(new TourListEntry(splitString[0].trim()));
            }
        } catch (IOException e) {
            ;
        }
    }
}
