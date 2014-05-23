package com.jeffinmadison.mygasmilage;

import android.app.Application;
import android.content.Context;

import com.jeffinmadison.mygasmilage.broadcastreceiver.INetworkStateListener;
import com.jeffinmadison.mygasmilage.broadcastreceiver.NetworkReceiver;

/**
 * Created by Jeff on 10/16/13.
 * Copyright JeffInMadison 2013
 */

public class ApplicationOverride extends Application implements INetworkStateListener {
    private static final String TAG = ApplicationOverride.class.getSimpleName();
    private static Context appContext;
    private static boolean sOnline;

    public static Context getAppContext() {
        return ApplicationOverride.appContext;
    }

    public static boolean isOnline() {
        return sOnline;
    }

    public static void setOnline(boolean online) {
        sOnline = online;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationOverride.appContext = getApplicationContext();

//        if (BuildConfig.DEBUG) {
//            Picasso.with(this).setDebugging(true);
//        }

        // When we launch the app we set whether we are online.
        setOnline(NetworkReceiver.isConnected());

        // Then register for network state changes.
        NetworkReceiver.addNetworkStateListener(this);
    }

    @Override
    public void networkStateChanged(boolean isOnline) {
        setOnline(isOnline);
    }
}
