package com.sergiocasero.beaconexample.observer;

import java.util.Observable;

public class NotificationObserver extends Observable {
    private static NotificationObserver instance = new NotificationObserver();

    public static NotificationObserver getInstance() {
        return instance;
    }

    private NotificationObserver() {
        super();
    }

    public void updateValue(Object data) {
        synchronized (this) {
            setChanged();
            notifyObservers(data);
        }
    }
}