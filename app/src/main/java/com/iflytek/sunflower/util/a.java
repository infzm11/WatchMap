package com.iflytek.sunflower.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public class a {
    public static long[] a = {-1, -1};
    public static String[][] b = {new String[]{"os.manufact", Build.MANUFACTURER}, new String[]{"os.model", Build.MODEL}, new String[]{"os.product", Build.PRODUCT}, new String[]{"os.display", Build.DISPLAY}, new String[]{"os.user", Build.USER}};
    private static String[][] c = {new String[]{"os.hardware", "HARDWARE"}};
    private static h d = new h();
    private static boolean e = false;

    public static synchronized h a(Context context) {
        synchronized (a.class) {
            if (e) {
                a(context, d, true);
                h hVar = d;
                return hVar;
            }
            b(context);
            h hVar2 = d;
            return hVar2;
        }
    }

    private static void b(Context context) {
        try {
            d.a();
            d.a("os.system", "Android");
            a(d, context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d.a("os.resolution", displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
            d.a("os.density", "" + displayMetrics.density);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            d.a("os.imei", telephonyManager.getDeviceId());
            d.a("os.imsi", telephonyManager.getSubscriberId());
            d.a("os.version", Build.VERSION.SDK);
            d.a("os.release", Build.VERSION.RELEASE);
            for (int i = 0; i < b.length; i++) {
                d.a(b[i][0], b[i][1]);
            }
            for (int i2 = 0; i2 < c.length; i2++) {
                d.a(c[i2][0], a(c[i2][1]));
            }
            a(context, d, false);
            d.a("net.mac", g.a(context));
            e = true;
        } catch (Exception unused) {
            e = false;
        }
    }

    public static void a(Context context, h hVar, Boolean bool) {
        if (context == null) {
            hVar.a("wap_proxy", "", bool.booleanValue());
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            hVar.a("wap_proxy", "", bool.booleanValue());
            return;
        }
        hVar.a("wap_proxy", k.a(activeNetworkInfo), bool.booleanValue());
        hVar.a("net_subtype", k.b(activeNetworkInfo), bool.booleanValue());
    }

    public static void a(h hVar, Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            hVar.a("app.ver.name", packageInfo.versionName);
            hVar.a("app.ver.code", "" + packageInfo.versionCode);
            hVar.a("app.pkg", applicationInfo.packageName);
            hVar.a("app.path", applicationInfo.dataDir);
            hVar.a("app.name", applicationInfo.loadLabel(context.getPackageManager()).toString());
        } catch (Exception unused) {
        }
    }

    private static String a(String str) {
        try {
            Field field = Build.class.getField(str);
            return field != null ? field.get(new Build()).toString() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }
}
