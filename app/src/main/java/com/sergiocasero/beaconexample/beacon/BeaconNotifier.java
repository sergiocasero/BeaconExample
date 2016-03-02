package com.sergiocasero.beaconexample.beacon;

import android.content.Intent;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;

/**
 * Created by sergiocasero on 2/3/16.
 */
public class BeaconNotifier implements RangeNotifier {

    private OnDataReceivedCallback onDataReceivedCallback;

    public void setOnDataReceivedCallback(OnDataReceivedCallback onDataReceivedCallback) {
        this.onDataReceivedCallback = onDataReceivedCallback;
    }

    @Override
    public void didRangeBeaconsInRegion(Collection<Beacon> collection, Region region) {
        onDataReceivedCallback.onReceived("hola");
    }

    public interface OnDataReceivedCallback {
        void onReceived(String message);

        void onReceived(Intent intent);
    }
}
