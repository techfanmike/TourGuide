package com.example.android.tourguide;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// the different fragments load their content, so create a utility to load the content from a text file
public class Utility {
    public static void populateArray(ArrayList<TourListEntry> array, String fileName, Resources resource, String packageName) {
        try {

            // get the resource id for the raw directory
            int resourceID = resource.getIdentifier(fileName , "raw", packageName);

            // instantiate the usual file reading objects
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
            // flagrant optimism;
        }
    }
}
