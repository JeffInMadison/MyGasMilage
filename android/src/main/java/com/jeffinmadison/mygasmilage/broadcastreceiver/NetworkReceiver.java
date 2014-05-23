package com.jeffinmadison.mygasmilage.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;

import com.jeffinmadison.mygasmilage.ApplicationOverride;

import java.util.WeakHashMap;

/**
 * Created by Jeff on 10/16/13.
 * Copyright JeffInMadison 2013
 */
public class NetworkReceiver extends BroadcastReceiver {
    private static final String TAG = NetworkReceiver.class.getSimpleName();

    private static WeakHashMap<Object, INetworkStateListener> networkListeners = new WeakHashMap<Object, INetworkStateListener>();

    /**
     * Adds a network state listener
     *
     */
    public static void addNetworkStateListener(INetworkStateListener listener) {
        networkListeners.put(listener, listener);
    }

    /**
     * Remove a network state listener
     */
    public static void removeNetworkStateListener(INetworkStateListener listener) {
        networkListeners.remove(listener);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // network state changes, you can process it, information in intent
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo info = ConnectivityManagerCompat.getNetworkInfoFromBroadcast(connectivityManager, intent);
            boolean isConnected = isConnected();

            // Only if the connection status changed do we save the state and call the listeners
            if (isConnected != ApplicationOverride.isOnline()) {
                ApplicationOverride.setOnline(info.isConnected());
                callListeners(isConnected);
            }
        }
    }

    private void callListeners(boolean isConnected) {
        for(Object networkListenerKey : networkListeners.keySet()) {
            INetworkStateListener listener = networkListeners.get(networkListenerKey);
            if(listener != null) {
                listener.networkStateChanged(isConnected);
            }
        }
    }

    public static Boolean isConnected() throws IllegalArgumentException {
        Context context = ApplicationOverride.getAppContext();

        Boolean resultConnected = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                resultConnected = networkInfo.isConnected();
            }
        } catch (Exception ignored) { }

        return resultConnected;
    }
}
