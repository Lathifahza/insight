package org.d3ifcool.insightmirror;

import android.app.Application;

import com.uriio.beacons.Beacons;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Beacons.initialize(this);
    }
}
