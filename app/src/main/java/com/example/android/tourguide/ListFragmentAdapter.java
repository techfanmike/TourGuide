package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ListFragmentAdapter(Context context, FragmentManager fragMan) {
        super(fragMan);
    }

    @Override
    public Fragment getItem(int tabNumber) {
        Fragment returnVal = null;

        switch (tabNumber) {
            case 0:
                returnVal = new SightsFrag();
                break;
            case 1:
                returnVal = new FoodFrag();
                break;
            case 2:
                returnVal = new ShoppingFrag();
                break;
            default:
                returnVal = null;
                break;
        }

        return returnVal;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String returnVal = "";

        switch (position) {
            case 0:
                returnVal = mContext.getString(R.string.SIGHTS_STRING);
            case 1:
                returnVal = mContext.getString(R.string.FOOD_STRING);
            case 2:
                returnVal = mContext.getString(R.string.SHOPPING_STRING);
        }

        return returnVal;
    }
}