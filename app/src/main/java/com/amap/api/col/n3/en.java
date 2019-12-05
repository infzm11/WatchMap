package com.amap.api.col.n3;

import android.content.Context;
import android.content.SharedPreferences;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.ae.route.model.RoutePoi;

/* compiled from: AE8Temp */
public final class en {
    private static RoutePoi[] a = new RoutePoi[0];
    private static RoutePoi[] b = new RoutePoi[0];
    private static RoutePoi[] c = new RoutePoi[0];
    private static int d;
    private static NaviLatLng e = new NaviLatLng();
    private static float f;
    private static double g;

    public static boolean a() {
        return a != null && c != null && c.length > 0 && a.length > 0;
    }

    public static void a(float f2, double d2) {
        f = f2;
        g = d2;
    }

    public static float b() {
        return f;
    }

    public static double c() {
        return g;
    }

    public static RoutePoi[] d() {
        return a;
    }

    public static void a(RoutePoi[] routePoiArr) {
        a = routePoiArr;
    }

    public static RoutePoi[] e() {
        return b;
    }

    public static void b(RoutePoi[] routePoiArr) {
        b = routePoiArr;
    }

    public static RoutePoi[] f() {
        return c;
    }

    public static void c(RoutePoi[] routePoiArr) {
        c = routePoiArr;
    }

    public static int g() {
        return d;
    }

    public static void a(int i) {
        d = i;
    }

    public static NaviLatLng a(Context context) {
        if (e != null && e.getLatitude() >= 1.0d && e.getLongitude() >= 1.0d) {
            return e;
        }
        NaviLatLng c2 = c(context);
        e = c2;
        return c2;
    }

    public static void a(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            e = naviLatLng;
        }
    }

    public static void b(Context context) {
        try {
            if (e != null) {
                double longitude = e.getLongitude();
                double latitude = e.getLatitude();
                SharedPreferences.Editor edit = context.getSharedPreferences("SDK_API", 0).edit();
                edit.putFloat("CURRENT_LOCATION_LON", (float) longitude);
                edit.putFloat("CURRENT_LOCATION_LAT", (float) latitude);
                edit.apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static NaviLatLng c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SDK_API", 0);
            return new NaviLatLng((double) sharedPreferences.getFloat("CURRENT_LOCATION_LAT", 39.908695f), (double) sharedPreferences.getFloat("CURRENT_LOCATION_LON", 116.39747f));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
