package com.iflytek.sunflower.util;

import android.util.Log;

public class j {
    protected static boolean a = false;
    protected static boolean b = false;

    public static void a(boolean z) {
        a = z;
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.d("Sunflower_" + str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            Log.d("Sunflower_" + str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.i("Sunflower_" + str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            Log.i("Sunflower_" + str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.w("Sunflower_" + str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (a) {
            Log.w("Sunflower_" + str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        Log.e("Sunflower_" + str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        Log.e("Sunflower_" + str, str2, th);
    }

    public static void b(boolean z) {
        b = z;
    }

    public static void e(String str, String str2) {
        if (b) {
            Log.i("Sunflower_" + str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (b) {
            Log.e("Sunflower_" + str, str2);
        }
    }

    public static void a(Throwable th) {
        if (b) {
            th.printStackTrace();
        }
    }
}
