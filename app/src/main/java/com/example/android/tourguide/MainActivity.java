package com.example.android.tourguide;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //inject bindings
    @BindView(R.id.tab_view) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call the butterknife binding method
        ButterKnife.bind(this);

        // instantiate our FragmentPagerAdapter

    }

}
