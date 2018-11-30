package org.d3ifcool.insightmirror;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uriio.beacons.model.iBeacon;

import java.io.UnsupportedEncodingException;

public class PathActivity extends AppCompatActivity {

    iBeacon mBeacon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
    }

    private void startBroadcast() throws UnsupportedEncodingException {
        String uuid = "1db80df9-4599-43af-93c0-5c1d00f2a895";

        mBeacon = new iBeacon(uuid.getBytes("UTF-8"), 200, 100);
        mBeacon.start();
    }

    private void stopBroadcast() {
        if (mBeacon != null) {
            mBeacon.stop();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            startBroadcast();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopBroadcast();
    }
}
