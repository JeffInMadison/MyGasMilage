package com.jeffinmadison.mygasmilage;

import android.app.Application;
import android.content.Context;

import com.jeffinmadison.mygasmilage.broadcastreceiver.INetworkStateListener;
import com.jeffinmadison.mygasmilage.broadcastreceiver.NetworkReceiver;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by Jeff on 10/16/13.
 * Copyright Noble Applications 2013
 */

// TODO FormKey should one day be an endpoint that ACRA can Post a form to.
@ReportsCrashes(formKey = "",
                mailTo = "crashes@NobleApplications.com ",
                mode = ReportingInteractionMode.SILENT)
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

        // The following line triggers the initialization of ACRA
        if (BuildConfig.DEBUG) {
            ACRA.init(this);
        }

//        TestFlight.takeOff(this, "3c4fa9a4-08a7-47c3-81f9-c532e8e723aa");

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
