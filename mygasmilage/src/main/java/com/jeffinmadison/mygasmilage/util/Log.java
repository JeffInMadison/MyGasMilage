package com.jeffinmadison.mygasmilage.util;


import com.jeffinmadison.mygasmilage.BuildConfig;

/**
 * Subclass the Android Logging so that when the build is not debug it just returns. Using proguard
 * is probably the better way to do this.
 *
 * Created by Jeff on 10/16/13.
 * Copyright Noble Applications 2013
 */
@SuppressWarnings("UnusedDeclaration")
public class Log {
    private static final String NO_MESSAGE = "no message";

    public static void i(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }

        android.util.Log.i(safeTag, safeMsg);
    }

    public static void e(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }

        android.util.Log.e(safeTag, safeMsg);
    }

    public static void d(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }

        android.util.Log.d(safeTag, safeMsg);
    }

    public static void v(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }

        android.util.Log.v(safeTag, safeMsg);
    }

    public static void w(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }

        android.util.Log.w(safeTag, safeMsg);
    }


    public static int v(String tag, String msg, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }
        return android.util.Log.v(safeTag, safeMsg, tr);
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }
        return android.util.Log.d(safeTag, safeMsg, tr);
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }
        return android.util.Log.i(safeTag, safeMsg, tr);
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }
        return android.util.Log.w(safeTag, safeMsg, tr);
    }

    public static int w(String tag, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        return android.util.Log.w(safeTag, tr);
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        String safeMsg = msg;
        if (StringUtils.isNullOrEmpty(safeMsg)) {
            safeMsg = NO_MESSAGE;
        }
        return android.util.Log.e(safeTag, safeMsg, tr);
    }

    public static int e(String tag, Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return -1;
        }

        String safeTag = tag;
        if (StringUtils.isNullOrEmpty(tag)) {
            safeTag = "";
        }
        return android.util.Log.e(safeTag, "", tr);
    }

    public static String getStackTraceString(Throwable tr) {
        if (!BuildConfig.DEBUG) {
            return "";
        }

        return android.util.Log.getStackTraceString(tr);
    }
}
