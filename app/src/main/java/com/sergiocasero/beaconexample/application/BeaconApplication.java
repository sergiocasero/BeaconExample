package com.sergiocasero.beaconexample.application;

import android.app.Application;
import android.content.Intent;

import com.sergiocasero.beaconexample.beacon.BeaconNotifier;

import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by sergiocasero on 2/3/16.
 */
public class BeaconApplication extends Application implements BeaconConsumer, Observer {

    private BeaconManager beaconManager;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public void onBeaconServiceConnect() {
        BeaconNotifier notifier = new BeaconNotifier();
        beaconManager.setRangeNotifier(notifier);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data instanceof Intent) {
            Intent intent = (Intent) data;
            this.startActivity(intent);
        }
    }
}
