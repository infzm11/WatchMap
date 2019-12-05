package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.ae.route.model.RoutePoi;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Ae8Utils */
public final class eo {
    public static String a = "";
    private static String b = "http://restapi.amap.com";

    public static RoutePoi[] a(List<NaviLatLng> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RoutePoi[] routePoiArr = new RoutePoi[list.size()];
        for (int i = 0; i < list.size(); i++) {
            NaviLatLng naviLatLng = list.get(i);
            RoutePoi routePoi = new RoutePoi();
            routePoi.naviLat = naviLatLng.getLatitude();
            routePoi.naviLon = naviLatLng.getLongitude();
            routePoi.latitude = naviLatLng.getLatitude();
            routePoi.longitude = naviLatLng.getLongitude();
            routePoiArr[i] = routePoi;
        }
        return routePoiArr;
    }

    public static List<NaviLatLng> a(RoutePoi[] routePoiArr) {
        ArrayList arrayList = new ArrayList();
        if (routePoiArr == null || routePoiArr.length <= 0) {
            return arrayList;
        }
        for (RoutePoi routePoi : routePoiArr) {
            arrayList.add(new NaviLatLng(routePoi.latitude, routePoi.longitude));
        }
        return arrayList;
    }

    public static byte[] a(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(2);
            dataOutputStream.writeShort(str.length());
            dataOutputStream.write(str.getBytes("UTF-8"));
            dataOutputStream.writeShort(bArr.length);
            dataOutputStream.write(bArr);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static kl a(Context context, int i, final byte[] bArr) {
        switch (i) {
            case 1:
                a = b + "/v3/ae8/driving";
                break;
            case 2:
                a = b + "/v3/ae8/traffic/show";
                break;
            case 3:
                a = b + "/v3/ae8/traffic/broadcast/login";
                break;
            case 7:
                a = b + "/v3/ae8/intersection/enlarged";
                break;
            case 8:
                "ETA统计==" + a;
                break;
            case 10:
                try {
                    "三维扩大图模块==" + a;
                    break;
                } catch (ic e) {
                    e.printStackTrace();
                    iu.a(hq.a(), a.replace(b, ""), e);
                    return null;
                }
        }
        if (i != 1 && i != 2 && i != 3 && i != 7) {
            return null;
        }
        "request host==" + a;
        AnonymousClass1 r3 = new ke(context, hq.a()) {
            public final Map<String, String> a() {
                return null;
            }

            public final byte[] e() {
                return null;
            }

            public final String c() {
                return eo.a;
            }

            public final byte[] d() {
                return bArr;
            }
        };
        r3.a(2000);
        r3.b(2000);
        ki.b();
        return ki.b(r3);
    }
}
