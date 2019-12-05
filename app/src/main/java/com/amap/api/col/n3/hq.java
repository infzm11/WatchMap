package com.amap.api.col.n3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.TypedValue;
import com.amap.api.col.n3.im;
import com.amap.api.maps.model.LatLng;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: NaviUtil */
public final class hq {
    public static boolean a = false;
    public static boolean b = false;
    private static String[] c = {"com.amap.api.navi", "com.autonavi.tbt", "com.autonavi.wtbt", "com.autonavi.rbt", "com.autonavi.ae.guide", "com.autonavi.ae.route", "com.autonavi.ae.pos"};

    public static im a() {
        try {
            return new im.a("navi", "5.4.0", "AMAP_SDK_Android_NAVI_5.4.0").a(c).a();
        } catch (ic e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Throwable th) {
        th.printStackTrace();
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("exception->");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("@");
            sb.append(stackTraceElement.getFileName());
            sb.append(stackTraceElement.getLineNumber());
            sb.append("#");
            sb.append(stackTraceElement.getClassName());
            sb.append("#");
            sb.append(stackTraceElement.getMethodName());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(android.content.Context r4) {
        /*
            if (r4 != 0) goto L_0x0007
            java.io.File r4 = r4.getFilesDir()
            return r4
        L_0x0007:
            r0 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            java.lang.String r2 = "mounted"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            if (r1 == 0) goto L_0x0025
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            boolean r2 = r1.canWrite()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = "LBS"
            java.io.File r2 = r4.getExternalFilesDir(r2)     // Catch:{ Exception -> 0x0032 }
            goto L_0x002a
        L_0x0025:
            r1 = r0
        L_0x0026:
            java.io.File r2 = r4.getFilesDir()     // Catch:{ Exception -> 0x0032 }
        L_0x002a:
            if (r2 != 0) goto L_0x0031
            java.io.File r4 = r4.getFilesDir()
            return r4
        L_0x0031:
            return r2
        L_0x0032:
            r2 = move-exception
            goto L_0x003b
        L_0x0034:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0047
        L_0x0039:
            r2 = move-exception
            r1 = r0
        L_0x003b:
            r2.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0045
            java.io.File r4 = r4.getFilesDir()
            return r4
        L_0x0045:
            return r0
        L_0x0046:
            r0 = move-exception
        L_0x0047:
            if (r1 != 0) goto L_0x004e
            java.io.File r4 = r4.getFilesDir()
            return r4
        L_0x004e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hq.a(android.content.Context):java.io.File");
    }

    public static int a(Context context, int i) {
        if (i == 0) {
            return 0;
        }
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String a(int i) {
        if (i == 0) {
            return "0米";
        }
        if (i < 100) {
            return i + "米";
        } else if (100 <= i && i < 1000) {
            return i + "米";
        } else if (1000 <= i && i < 10000) {
            return (((double) ((i / 10) * 10)) / 1000.0d) + "公里";
        } else if (10000 > i || i >= 100000) {
            return (i / 1000) + "公里";
        } else {
            return (((double) ((i / 100) * 100)) / 1000.0d) + "公里";
        }
    }

    public static String a(int i, String str, String str2) {
        if (i == 0) {
            return "<font color='" + str + "' ><B>0</B></font><font color ='" + str2 + "'>米</font>";
        } else if (i < 100) {
            return "<font color='" + str + "'><B>" + i + "</B></font><font color ='" + str2 + "'>米</font>";
        } else if (100 <= i && i < 1000) {
            return "<font color='" + str + "'><B>" + ((i / 10) * 10) + "</B></font><font color ='" + str2 + "'>米</font>";
        } else if (1000 <= i && i < 10000) {
            return "<font color='" + str + "'><B>" + (((double) ((i / 10) * 10)) / 1000.0d) + "</B></font><font color ='" + str2 + "'>公里</font>";
        } else if (10000 > i || i >= 100000) {
            return "<font color='" + str + "'><B>" + (i / 1000) + "</B></font><font color ='" + str2 + "'>公里</font>";
        } else {
            return "<font color='" + str + "'><B>" + (((double) ((i / 100) * 100)) / 1000.0d) + "</B></font><font color ='" + str2 + "'>公里</font>";
        }
    }

    public static String a(String str) {
        String str2;
        String str3;
        if (str == null) {
            return "";
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > 2) {
            if (!"00".equals(split[0])) {
                if (split[0].indexOf("0") != -1) {
                    int indexOf = split[0].indexOf("0") + 1;
                    if (indexOf < split[0].length()) {
                        str3 = split[0].substring(indexOf);
                    } else {
                        str3 = split[0];
                    }
                    stringBuffer.append(str3 + "小时");
                } else {
                    stringBuffer.append(split[0] + "小时");
                }
            }
            if (!"00".equals(split[1])) {
                if (split[1].indexOf("0") != -1) {
                    int indexOf2 = split[1].indexOf("0") + 1;
                    if (indexOf2 < split[1].length()) {
                        str2 = split[1].substring(indexOf2);
                    } else {
                        str2 = split[1];
                    }
                    stringBuffer.append(str2 + "分钟");
                } else {
                    stringBuffer.append(split[1] + "分钟");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        String str5;
        if (str == null) {
            return "";
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > 2) {
            if (!"00".equals(split[0])) {
                if (split[0].indexOf("0") != -1) {
                    int indexOf = split[0].indexOf("0");
                    if (indexOf == 0) {
                        int i = indexOf + 1;
                        if (i < split[0].length()) {
                            str5 = split[0].substring(i);
                            stringBuffer.append("<font color='" + str2 + "' ><B>" + str5 + "</B></font><font color ='" + str3 + "'>小时</font>");
                        }
                    }
                    str5 = split[0];
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str5 + "</B></font><font color ='" + str3 + "'>小时</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[0] + "</B></font><font color ='" + str3 + "'>小时</font>");
                }
            }
            if (!"00".equals(split[1])) {
                if (split[1].indexOf("0") != -1) {
                    int indexOf2 = split[1].indexOf("0") + 1;
                    if (indexOf2 < split[1].length()) {
                        str4 = split[1].substring(indexOf2);
                    } else {
                        str4 = split[1];
                    }
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str4 + "</B></font><font color ='" + str3 + "'>分钟</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[1] + "</B></font><font color ='" + str3 + "'>分钟</font>");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String b(int i) {
        int abs = Math.abs(i);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = abs / 3600;
        if (i2 == 0) {
            stringBuffer.append("00:");
        }
        if (i2 > 0) {
            stringBuffer.append(c(i2) + ":");
        }
        int i3 = abs % 3600;
        stringBuffer.append(c((i3 + 59) / 60) + ":");
        stringBuffer.append(c(i3 % 60));
        return stringBuffer.toString();
    }

    private static String c(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return i;
    }

    public static NaviLatLng a(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = 0.0d;
        if (d <= 0.0d || d2 <= 0.0d || d3 <= 0.0d || d4 <= 0.0d) {
            d5 = 0.0d;
        } else {
            d6 = (d + d3) / 2.0d;
            d5 = (d2 + d4) / 2.0d;
        }
        return new NaviLatLng(d6, d5);
    }

    public static NaviLatLng a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2, double d) {
        NaviLatLng naviLatLng3 = new NaviLatLng();
        double a2 = d / ((double) a(naviLatLng, naviLatLng2));
        naviLatLng3.setLatitude(((naviLatLng2.getLatitude() - naviLatLng.getLatitude()) * a2) + naviLatLng.getLatitude());
        naviLatLng3.setLongitude(((naviLatLng2.getLongitude() - naviLatLng.getLongitude()) * a2) + naviLatLng.getLongitude());
        return naviLatLng3;
    }

    public static int a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        double longitude = naviLatLng.getLongitude();
        double latitude = naviLatLng.getLatitude();
        double d = longitude * 0.01745329251994329d;
        double d2 = latitude * 0.01745329251994329d;
        double longitude2 = naviLatLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = naviLatLng2.getLatitude() * 0.01745329251994329d;
        double sin = Math.sin(d);
        double sin2 = Math.sin(d2);
        double cos = Math.cos(d);
        double cos2 = Math.cos(d2);
        double sin3 = Math.sin(longitude2);
        double sin4 = Math.sin(latitude2);
        double cos3 = Math.cos(longitude2);
        double cos4 = Math.cos(latitude2);
        double[] dArr = {(cos * cos2) - (cos3 * cos4), (cos2 * sin) - (cos4 * sin3), sin2 - sin4};
        return (int) (Math.asin(Math.sqrt(((dArr[0] * dArr[0]) + (dArr[1] * dArr[1])) + (dArr[2] * dArr[2])) / 2.0d) * 1.27420015798544E7d);
    }

    public static int b(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static float a(LatLng latLng, LatLng latLng2) {
        try {
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
            double d = (double) iPoint2.x;
            return ((float) ((Math.atan2(((double) iPoint2.y) - ((double) iPoint.y), d - ((double) iPoint.x)) / 3.141592653589793d) * 180.0d)) + 90.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static boolean a(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return false;
        }
        try {
            double longitude = naviLatLng.getLongitude();
            if (longitude <= 180.0d) {
                if (longitude >= 0.0d) {
                    double latitude = naviLatLng.getLatitude();
                    if (latitude < 0.0d || latitude > 90.0d) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
