package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class da {
    static String a;
    static WifiManager b;
    private static int c;
    private static String[] d;
    private static Hashtable<String, Long> e = new Hashtable<>();
    private static SparseArray<String> f;
    private static SimpleDateFormat g;
    private static String[] h = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    public static double a(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static float a(float f2) {
        return (float) (((double) ((long) (((double) f2) * 100.0d))) / 100.0d);
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static float a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i) {
        return -113 + (2 * i);
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            cs.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static String a(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        if (g == null) {
            try {
                g = new SimpleDateFormat(str, Locale.CHINA);
            } catch (Throwable th) {
                cs.a(th, "Utils", "formatUTC");
            }
        } else {
            g.applyPattern(str);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        return g == null ? "NULL" : g.format(Long.valueOf(j));
    }

    public static boolean a(long j, long j2) {
        if (g == null) {
            try {
                g = new SimpleDateFormat("yyyyMMddHH", Locale.CHINA);
            } catch (Throwable th) {
                cs.a(th, "Utils", "isSameDay part1");
            }
        } else {
            g.applyPattern("yyyyMMddHH");
        }
        try {
            if (g != null) {
                return g.format(Long.valueOf(j)).equals(g.format(Long.valueOf(j2)));
            }
        } catch (Throwable th2) {
            cs.a(th2, "Utils", "isSameHour");
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? c(context, "android.provider.Settings$System") : c(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "2.0.201501131131"
            java.lang.String r2 = "."
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)
            if (r6 == 0) goto L_0x006e
            r2 = 1
            r3 = 0
            boolean r4 = r6.isOpen()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            if (r4 != 0) goto L_0x001d
            return r1
        L_0x001d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.<init>()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r5 = "SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '"
            r4.append(r5)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = r7.trim()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.append(r7)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.append(r0)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = "' "
            r4.append(r7)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = r4.toString()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            android.database.Cursor r6 = r6.rawQuery(r7, r3)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            if (r6 == 0) goto L_0x0051
            boolean r7 = r6.moveToFirst()     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r7 == 0) goto L_0x0051
            int r7 = r6.getInt(r1)     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r7 <= 0) goto L_0x0051
            r7 = r2
            goto L_0x0052
        L_0x004e:
            r7 = move-exception
            r3 = r6
            goto L_0x0060
        L_0x0051:
            r7 = r1
        L_0x0052:
            int r0 = r4.length()     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            r4.delete(r1, r0)     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r6 == 0) goto L_0x006d
            r6.close()
            return r7
        L_0x005f:
            r7 = move-exception
        L_0x0060:
            if (r3 == 0) goto L_0x0065
            r3.close()
        L_0x0065:
            throw r7
        L_0x0066:
            r6 = r3
        L_0x0067:
            if (r6 == 0) goto L_0x006c
            r6.close()
        L_0x006c:
            r7 = r2
        L_0x006d:
            return r7
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.da.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public static boolean a(Location location, int i) {
        Bundle extras = location.getExtras();
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        return i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean a(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && !aMapLocationServer.d().equals(GuideControl.CHANGE_PLAY_TYPE_YYQX) && !aMapLocationServer.d().equals(GuideControl.CHANGE_PLAY_TYPE_BBHX) && !aMapLocationServer.d().equals(GuideControl.CHANGE_PLAY_TYPE_CLH)) {
            return b((AMapLocation) aMapLocationServer);
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return false;
        }
        return ",202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,901,".contains("," + str + ",");
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("#");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(",nb") || split[i].contains(",access")) {
                arrayList.add(split[i]);
            }
        }
        String[] split2 = str2.toString().split("#");
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < split2.length; i4++) {
            if (split2[i4].contains(",nb") || split2[i4].contains(",access")) {
                i2++;
                if (arrayList.contains(split2[i4])) {
                    i3++;
                }
            }
        }
        return ((double) (i3 * 2)) >= ((double) (arrayList.size() + i2)) * 0.618d;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return t.a(jSONObject, str);
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (255 & i);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        try {
            return t.b(bArr);
        } catch (Throwable th) {
            cs.a(th, "Utils", "gz");
            return null;
        }
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            cs.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr[0] = "0";
        }
        if (strArr[0].equals("0") || strArr[1].equals("0")) {
            return (!strArr[0].equals("0") || !strArr[1].equals("0") || d == null) ? strArr : d;
        }
        d = strArr;
        return strArr;
    }

    public static double b(double d2) {
        return ((double) ((long) (d2 * 100.0d))) / 100.0d;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
            default:
                return "其他错误";
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(cs.g)) {
            return cs.g;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(k.c(context), 64);
        } catch (Throwable th) {
            cs.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(cs.h)) {
                cs.h = null;
            }
        } catch (Throwable th2) {
            cs.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c2 = k.c(context);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!TextUtils.isEmpty(cs.h)) {
            sb.append(",");
            sb.append(cs.h);
        }
        String sb2 = sb.toString();
        cs.g = sb2;
        return sb2;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (f == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            f = sparseArray;
            sparseArray.append(0, "UNKWN");
            f.append(1, "GPRS");
            f.append(2, "EDGE");
            f.append(3, "UMTS");
            f.append(4, "CDMA");
            f.append(5, "EVDO_0");
            f.append(6, "EVDO_A");
            f.append(7, "1xRTT");
            f.append(8, "HSDPA");
            f.append(9, "HSUPA");
            f.append(10, "HSPA");
            f.append(11, "IDEN");
            f.append(12, "EVDO_B");
            f.append(13, "LTE");
            f.append(14, "EHRPD");
            f.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return f.get(i, "UNKWN");
    }

    public static String b(byte[] bArr) {
        return t.f(bArr);
    }

    public static boolean b(long j, long j2) {
        if (g == null) {
            try {
                g = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            } catch (Throwable th) {
                cs.a(th, "Utils", "isSameDay part1");
            }
        } else {
            g.applyPattern("yyyyMMdd");
        }
        try {
            if (g != null) {
                return g.format(Long.valueOf(j)).equals(g.format(Long.valueOf(j2)));
            }
        } catch (Throwable th2) {
            cs.a(th2, "Utils", "isSameDay");
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && !str.equals("00:00:00:00:00:00") && !str.contains(" :");
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static double c(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static int c() {
        if (c > 0) {
            return c;
        }
        try {
            return cv.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static NetworkInfo c(Context context) {
        try {
            return n.o(context);
        } catch (Throwable th) {
            cs.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static boolean c(long j, long j2) {
        if (!b(j, j2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        if (i > 12) {
            if (i2 > 12) {
                return true;
            }
        } else if (i2 <= 12) {
            return true;
        }
        return false;
    }

    private static boolean c(Context context, String str) throws Throwable {
        return ((Integer) cv.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) cv.a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] c(String str) {
        return a(Integer.parseInt(str), (byte[]) null);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        bArr2[0] = 0;
        for (int i = 1; i <= bArr.length; i++) {
            bArr2[i] = bArr[bArr.length - i];
        }
        return bArr2;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c2 = c(context);
            return c2 != null && c2.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    public static byte[] d(String str) {
        return b(Integer.parseInt(str), (byte[]) null);
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 10, bArr2, 0, Math.min(26, bArr.length) - 10);
        return bArr2;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static boolean e(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(k.c(context))) {
                    if (next.importance != 100) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            cs.a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static int f() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean f(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String checkCallingOrSelfPermission : h) {
                if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) != 0) {
                    return false;
                }
            }
        } else {
            Application application = (Application) context;
            for (String str : h) {
                try {
                    i = cv.b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void g() {
        e.clear();
    }

    @SuppressLint({"NewApi"})
    public static boolean g(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (b == null) {
            b = (WifiManager) a(context, "wifi");
        }
        try {
            z = b.isWifiEnabled();
        } catch (Throwable unused) {
            z = false;
        }
        if (!z && c() > 17) {
            try {
                return String.valueOf(cv.a(b, "isScanAlwaysAvailable", new Object[0])).equals("true");
            } catch (Throwable unused2) {
            }
        }
        return z;
    }

    public static String h() {
        try {
            return o.a("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "amap" + File.separator + "openamaplocationsdk" + File.separator;
    }
}
