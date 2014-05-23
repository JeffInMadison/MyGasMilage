package com.jeffinmadison.mygasmilage.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jeffinmadison.mygasmilage.ApplicationOverride;

import java.util.List;

/**
 * Created by Jeff on 11/6/13.
 * Copyright JeffInMadison 2013
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

    public static String getVersion() {
        PackageManager packageManager = ApplicationOverride.getAppContext().getPackageManager();
        String packageName = ApplicationOverride.getAppContext().getPackageName();

        String versionName = "not available";

        try {
            versionName = packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e);
        }
        return versionName;
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null && activity.getCurrentFocus() != null) {

            // clear focus first (this resolves some weird issues on 2.2, 2.3 devices)
            View focusView = activity.getCurrentFocus();
            focusView.clearFocus();

            inputMethodManager.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
        }
    }

    public static void showSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.SHOW_FORCED);
        }
    }

}
