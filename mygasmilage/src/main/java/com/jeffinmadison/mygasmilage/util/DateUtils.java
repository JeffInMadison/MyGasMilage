package com.jeffinmadison.mygasmilage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jeff on 11/7/13.
 * Copyright Noble Applications 2013
 */
public class DateUtils {

    // TODO This was copied from old code base is it still the right way to do it?

    private static final ThreadLocal<SimpleDateFormat> DATE_FMT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("M/d/yy");
        }
    };

    private static final ThreadLocal<SimpleDateFormat> LONG_DATE_FMT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("EEEE, MMMM d");
        }
    };

    private static final ThreadLocal<SimpleDateFormat> TIME_DATE_FMT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("h:mm a");
        }
    };

    private static final ThreadLocal<SimpleDateFormat> DATE_TIME_DATE_FMT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("M/d/yy h:mm a");
        }
    };

    private static final ThreadLocal<SimpleDateFormat> TIME_FMT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("MMM d, yyyy hh:mm a");
        }
    };

    public static String formatSimpleDate(Date date) {
        return DATE_FMT.get().format(date);
    }

    public static String formatDate(Date date) {
        return DATE_FMT.get().format(date);
    }

    public static String formatLongDate(Date date) {
        return LONG_DATE_FMT.get().format(date);
    }

    public static String formatTimeDate(Date date) {
        return TIME_DATE_FMT.get().format(date);
    }

    public static String formatDateTimeDate(Date date) {
        return DATE_TIME_DATE_FMT.get().format(date);
    }

    public static String formatTime(Date date) {
        return TIME_FMT.get().format(date);
    }

}
