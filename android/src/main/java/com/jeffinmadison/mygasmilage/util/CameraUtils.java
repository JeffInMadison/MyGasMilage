package com.jeffinmadison.mygasmilage.util;

import android.content.Context;
import android.content.pm.PackageManager;

import com.jeffinmadison.mygasmilage.ApplicationOverride;

/**
 * Created by Jeff on 11/7/13.
 * Copyright JeffInMadison 2013
 */
public class CameraUtils {

    public boolean deviceHasCamera() {
        return deviceHasCamera(ApplicationOverride.getAppContext());
    }

    public boolean deviceHasCamera(Context context) {

        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


    public boolean deviceHasFrontFacingCamera() {
        return deviceHasFrontFacingCamera(ApplicationOverride.getAppContext());
    }

    public boolean deviceHasFrontFacingCamera(Context context) {

        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }
}
