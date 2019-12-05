package com.amap.api.col.n3;

import com.amap.api.col.n3.im;
import com.autonavi.ae.guide.GuideControl;

/* compiled from: Util */
public final class lh {
    public static final String[] a = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    static im b;
    private static final String[] c = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};

    public static im a() throws ic {
        Class<?> cls;
        String str;
        im.a a2;
        String str2;
        if (b != null) {
            return b;
        }
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                a2 = new im.a("3dmap", str2, "AMAP_SDK_Android_Map_" + str2).a(c);
            } catch (Throwable unused2) {
            }
        } else {
            a2 = new im.a("2dmap", str, "AMAP_SDK_Android_2DMap_" + str).a(a);
        }
        b = a2.a();
        return b;
    }

    public static boolean a(kx kxVar) {
        if (kxVar == null || kxVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_YYQX) || kxVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_BBHX) || kxVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_CLH)) {
            return false;
        }
        double longitude = kxVar.getLongitude();
        double latitude = kxVar.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
