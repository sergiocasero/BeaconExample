package com.sergiocasero.beaconexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.sergiocasero.beaconexample.R;
import com.sergiocasero.beaconexample.beacon.BeaconNotifier;

import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BeaconConsumer {

    private BeaconManager beaconManager;

    @Bind(R.id.container)
    RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initBeacon();
    }

    private void initBeacon() {
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.bind(this);
    }

    private void initUI() {
        ButterKnife.bind(this);
    }

    public void showMessage(String message) {
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        BeaconNotifier notifier = new BeaconNotifier();
        notifier.setOnDataReceivedCallback(new BeaconNotifier.OnDataReceivedCallback() {
            @Override
            public void onReceived(String message) {
                showMessage(message);
            }

            @Override
            public void onReceived(Intent intent) {

            }
        });

        beaconManager.setRangeNotifier(notifier);
    }
}
