package com.iflytek.utils.log;

import android.util.Log;

public class FLog {
    protected static boolean mLoggingEnabled = true;

    public static void setDebugLogging(boolean z) {
        mLoggingEnabled = z;
    }

    public static int v(String str, String str2) {
        if (mLoggingEnabled) {
            return Log.v(str, str2);
        }
        return 0;
    }

    public static int v(String str, String str2, Throwable th) {
        if (mLoggingEnabled) {
            return Log.v(str, str2, th);
        }
        return 0;
    }

    public static int d(String str, String str2) {
        if (mLoggingEnabled) {
            return Log.d(str, str2);
        }
        return 0;
    }

    public static int d(String str, String str2, Throwable th) {
        if (mLoggingEnabled) {
            return Log.d(str, str2, th);
        }
        return 0;
    }

    public static int i(String str, String str2) {
        if (mLoggingEnabled) {
            return Log.i(str, str2);
        }
        return 0;
    }

    public static int i(String str, String str2, Throwable th) {
        if (mLoggingEnabled) {
            return Log.i(str, str2, th);
        }
        return 0;
    }

    public static int w(String str, String str2) {
        if (mLoggingEnabled) {
            return Log.w(str, str2);
        }
        return 0;
    }

    public static int w(String str, String str2, Throwable th) {
        if (mLoggingEnabled) {
            return Log.w(str, str2, th);
        }
        return 0;
    }

    public static int w(String str, Throwable th) {
        if (mLoggingEnabled) {
            return Log.w(str, th);
        }
        return 0;
    }

    public static int e(String str, String str2) {
        if (mLoggingEnabled) {
            return Log.e(str, str2);
        }
        return 0;
    }

    public static int e(String str, String str2, Throwable th) {
        if (mLoggingEnabled) {
            return Log.e(str, str2, th);
        }
        return 0;
    }
}
