package com.example.android.tourguide;

class TourListEntry {
    private String mName = "";
    private String mDescription = "";

    public TourListEntry(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
