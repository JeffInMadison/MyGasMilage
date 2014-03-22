package com.jeffinmadison.mygasmilage.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.jeffinmadison.mygasmilage.ApplicationOverride;
import com.jeffinmadison.mygasmilage.keyconstant.Keys;

/**
 * Created by Jeff on 10/16/13.
 * Copyright Noble Applications 2013
 */
@SuppressWarnings("UnusedDeclaration")
public class PreferenceUtils {
    private static final String TAG = PreferenceUtils.class.getSimpleName();

    public static void setExampleString(String example) {
        setExampleString(ApplicationOverride.getAppContext(), example);
    }
    public static void setExampleString(Context context, String example) {
        setPrefString(context, Keys.EXAMPLE_KEY, example);
    }

    public static String getExampleString() {
        return getExampleString(ApplicationOverride.getAppContext());
    }
    public static String getExampleString(Context context) {
        return getPrefString(context, Keys.EXAMPLE_KEY);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private static String getPrefString(Context context, String key) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        String result = StringUtils.EMPTY_STRING;
        SharedPreferences prefs = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);

        try {
            result = prefs.getString(key, StringUtils.EMPTY_STRING);
        } catch (Exception e) {
            Log.e(TAG,e);
        }
        return result;
    }

    private static void setPrefString(Context context, String key, String string) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        SharedPreferences settings = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, string);
        editor.apply();
    }

    private static boolean getPrefBoolean(Context context, String key) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        boolean result = false;
        SharedPreferences prefs = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);

        try {
            result = prefs.getBoolean(key, false);
        } catch (Exception e) {
            Log.e(TAG,e);
        }
        return result;
    }

    private static void setPrefBoolean(Context context, String key, Boolean bool) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        SharedPreferences settings = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    private static int getPrefInt(Context context, String key) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        int result = -1;
        SharedPreferences prefs = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);

        try {
            result = prefs.getInt(key, -1);
        } catch (Exception e) {
            Log.e(TAG,e);
        }
        return result;
    }

    private static void setPrefInt(Context context, String key, int value) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }

        SharedPreferences settings = context.getSharedPreferences(Keys.SHARED_PREFERENCES, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}
