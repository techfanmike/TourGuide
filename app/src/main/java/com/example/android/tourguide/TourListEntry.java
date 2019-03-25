package com.example.android.tourguide;

// data class for the list items
class TourListEntry {
    private String mName = "";
    private String mDescription = "";
    private String mPicture = "";

    public TourListEntry(String name, String description, String picture) {
        mName = name;
        mDescription = description;
        mPicture = picture;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPicture() {
        return mPicture;
    }
}
