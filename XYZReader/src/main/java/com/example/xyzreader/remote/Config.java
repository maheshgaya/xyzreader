package com.example.xyzreader.remote;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    private static final String TAG = Config.class.getSimpleName();
    public static final URL BASE_URL;

    static {
        URL url = null;
        try {
            url = new URL("https://dl.dropboxusercontent.com/u/231329/xyzreader_data/data.json" );
        } catch (MalformedURLException ignored) {
            Log.e(TAG, "static initializer: ", ignored);
            ignored.printStackTrace();
        }

        BASE_URL = url;
    }
}
