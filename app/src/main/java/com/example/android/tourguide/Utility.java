package com.example.android.tourguide;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utility {
    public static void populateArray(ArrayList<TourListEntry> array, String fileName, Resources resource, String packageName) {
        try {

            int resourceID = resource.getIdentifier(fileName , "raw", packageName);

            InputStream is = resource.openRawResource(resourceID);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String line;

            // read a line until done when null returned
            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                array.add(new TourListEntry(splitString[0].trim(), splitString[1].trim(), splitString[2].trim()));
            }
        } catch (IOException e) {
            ;
        }
    }
}
