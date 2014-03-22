package com.jeffinmadison.mygasmilage.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.jeffinmadison.mygasmilage.ApplicationOverride;

import java.util.List;

/**
 * Created by Jeff on 11/6/13.
 * Copyright Noble Applications 2013
 */
@SuppressWarnings("UnusedDeclaration")
public class AppUtils {
    private static final String TAG = AppUtils.class.getSimpleName();

    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        assert packageManager != null;
        List<ResolveInfo> list =
                    packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return list.size() > 0;
    }

    /**
     * Gets strings from manifest set in metadata.
     *
     * @param key the metadata key
     * @return the metadata value String
     */
    public static String getManifestMetadata(String key) {
        String resultString = null;
        try {
            Context appContext = ApplicationOverride.getAppContext();
            String packageName = appContext.getPackageName();
            PackageManager packageManager = appContext.getPackageManager();
            assert packageManager != null;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_ACTIVITIES|PackageManager.GET_META_DATA);
            assert applicationInfo.metaData != null;
            resultString = applicationInfo.metaData.get(key).toString();
        } catch (Exception e) {
            Log.e(TAG, "Failed getting manifest metadata", e);
        }

        return resultString;
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersion() {
        return getAppVersion(ApplicationOverride.getAppContext());
    }

    public static int getAppVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            assert packageManager != null;
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
}
