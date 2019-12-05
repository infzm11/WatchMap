package com.amap.api.services.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

/* compiled from: DeviceInfo */
public class bd {
    private static String a = "";
    private static boolean b = false;
    private static String c = null;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = "";
    private static String i = "";

    public static String a() {
        return c;
    }

    public static String a(Context context) {
        try {
            return v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return y(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int c(Context context) {
        try {
            return z(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int d(Context context) {
        try {
            return w(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String e(Context context) {
        try {
            return u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void b() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{40964});
            }
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "setTraficTag");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a A[SYNTHETIC, Splitter:B:46:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String t(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r8 = com.amap.api.services.a.bi.a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            if (r8 == 0) goto L_0x0091
            java.lang.String r8 = "mounted"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            boolean r8 = r8.equals(r1)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            if (r8 == 0) goto L_0x0091
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            r1.<init>()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            r1.append(r8)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.lang.String r8 = "/.UTSystemConfig/Global/Alvin2.xml"
            r1.append(r8)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            r1.<init>(r8)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            org.xmlpull.v1.XmlPullParser r8 = android.util.Xml.newPullParser()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            int r2 = r8.getEventType()     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x009e, all -> 0x0097 }
            java.lang.String r0 = "utf-8"
            r8.setInput(r3, r0)     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            r0 = 0
            r1 = r0
        L_0x0047:
            r4 = 1
            if (r4 == r2) goto L_0x008a
            if (r2 == 0) goto L_0x0085
            switch(r2) {
                case 2: goto L_0x005e;
                case 3: goto L_0x005c;
                case 4: goto L_0x0050;
                default: goto L_0x004f;
            }     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
        L_0x004f:
            goto L_0x0085
        L_0x0050:
            if (r1 == 0) goto L_0x0085
            java.lang.String r8 = r8.getText()     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            if (r3 == 0) goto L_0x005b
            r3.close()     // Catch:{ Throwable -> 0x005b }
        L_0x005b:
            return r8
        L_0x005c:
            r1 = r0
            goto L_0x0085
        L_0x005e:
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            if (r2 <= 0) goto L_0x0085
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            r5 = r1
            r1 = r0
        L_0x006a:
            if (r1 >= r2) goto L_0x0084
            java.lang.String r6 = r8.getAttributeValue(r1)     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            java.lang.String r7 = "UTDID2"
            boolean r7 = r7.equals(r6)     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            if (r7 != 0) goto L_0x0080
            java.lang.String r7 = "UTDID"
            boolean r6 = r7.equals(r6)     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            if (r6 == 0) goto L_0x0081
        L_0x0080:
            r5 = r4
        L_0x0081:
            int r1 = r1 + 1
            goto L_0x006a
        L_0x0084:
            r1 = r5
        L_0x0085:
            int r2 = r8.next()     // Catch:{ Throwable -> 0x008f, all -> 0x008c }
            goto L_0x0047
        L_0x008a:
            r0 = r3
            goto L_0x0091
        L_0x008c:
            r8 = move-exception
            r0 = r3
            goto L_0x0098
        L_0x008f:
            r0 = r3
            goto L_0x009e
        L_0x0091:
            if (r0 == 0) goto L_0x00a1
        L_0x0093:
            r0.close()     // Catch:{ Throwable -> 0x00a1 }
            goto L_0x00a1
        L_0x0097:
            r8 = move-exception
        L_0x0098:
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ Throwable -> 0x009d }
        L_0x009d:
            throw r8
        L_0x009e:
            if (r0 == 0) goto L_0x00a1
            goto L_0x0093
        L_0x00a1:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bd.t(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|(1:9)|10|(2:14|15)|16|17|18|(1:21)(2:22|23)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(android.content.Context r2) {
        /*
            java.lang.String r0 = a     // Catch:{ Throwable -> 0x0036 }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = ""
            java.lang.String r1 = a     // Catch:{ Throwable -> 0x0036 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x0036 }
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = a     // Catch:{ Throwable -> 0x0036 }
            return r0
        L_0x0011:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r0 = a(r2, r0)     // Catch:{ Throwable -> 0x0036 }
            if (r0 == 0) goto L_0x0025
            android.content.ContentResolver r0 = r2.getContentResolver()     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r1 = "mqBRboGZkQPcAkyk"
            java.lang.String r0 = android.provider.Settings.System.getString(r0, r1)     // Catch:{ Throwable -> 0x0036 }
            a = r0     // Catch:{ Throwable -> 0x0036 }
        L_0x0025:
            java.lang.String r0 = a     // Catch:{ Throwable -> 0x0036 }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = ""
            java.lang.String r1 = a     // Catch:{ Throwable -> 0x0036 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x0036 }
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = a     // Catch:{ Throwable -> 0x0036 }
            return r0
        L_0x0036:
            java.lang.String r2 = t(r2)     // Catch:{ Throwable -> 0x003c }
            a = r2     // Catch:{ Throwable -> 0x003c }
        L_0x003c:
            java.lang.String r2 = a
            if (r2 != 0) goto L_0x0043
            java.lang.String r2 = ""
            goto L_0x0045
        L_0x0043:
            java.lang.String r2 = a
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bd.f(android.content.Context):java.lang.String");
    }

    public static String c() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                e = Build.SERIAL;
            }
        } catch (Throwable unused) {
        }
        return e == null ? "" : e;
    }

    private static boolean a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String g(Context context) {
        if (context != null) {
            try {
                if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager != null && wifiManager.isWifiEnabled()) {
                        return wifiManager.getConnectionInfo().getBSSID();
                    }
                    return "";
                }
            } catch (Throwable th) {
                bl.a(th, "DeviceInfo", "getWifiMacs");
                return "";
            }
        }
        return "";
    }

    static String h(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                boolean z = true;
                                int i2 = 0;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                                    }
                                    sb.append(scanResult.BSSID);
                                    i2++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                bl.a(th, "DeviceInfo", "getWifiMacs");
            }
        }
        return sb.toString();
    }

    public static String i(Context context) {
        try {
            if (f != null && !"".equals(f)) {
                return f;
            }
            if (!a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return f;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f = wifiManager.getConnectionInfo().getMacAddress();
            if ("02:00:00:00:00:00".equals(f) || "00:00:00:00:00:00".equals(f)) {
                f = d();
            }
            return f;
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getDeviceMac");
        }
    }

    private static String d() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = t.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e2) {
            bl.a((Throwable) e2, "DeviceInfo", "getMacAddr");
            return "";
        }
    }

    static String[] j(Context context) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                if (a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        int cid = gsmCellLocation.getCid();
                        int lac = gsmCellLocation.getLac();
                        return new String[]{lac + "||" + cid, "gsm"};
                    }
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int systemId = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
                    }
                    return new String[]{"", ""};
                }
            }
            return new String[]{"", ""};
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "cellInfo");
        }
    }

    static String k(Context context) {
        try {
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            TelephonyManager A = A(context);
            if (A == null) {
                return "";
            }
            String networkOperator = A.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(3);
                }
            }
            return "";
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getMNC");
            return "";
        }
    }

    public static int l(Context context) {
        try {
            return z(context);
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getNetWorkType");
            return -1;
        }
    }

    public static int m(Context context) {
        try {
            return w(context);
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getActiveNetWorkType");
            return -1;
        }
    }

    public static NetworkInfo n(Context context) {
        if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return null;
        }
        ConnectivityManager x = x(context);
        if (x == null) {
            return null;
        }
        return x.getActiveNetworkInfo();
    }

    static String o(Context context) {
        try {
            NetworkInfo n = n(context);
            if (n == null) {
                return null;
            }
            return n.getExtraInfo();
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getNetworkExtraInfo");
            return null;
        }
    }

    static String p(Context context) {
        StringBuilder sb;
        try {
            if (g != null && !"".equals(g)) {
                return g;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            g = sb.toString();
            return g;
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getReslution");
        }
    }

    public static String q(Context context) {
        try {
            if (h != null && !"".equals(h)) {
                return h;
            }
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                return h;
            }
            TelephonyManager A = A(context);
            if (A == null) {
                return "";
            }
            h = A.getDeviceId();
            if (h == null) {
                h = "";
            }
            return h;
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getDeviceID");
        }
    }

    public static String r(Context context) {
        try {
            return u(context);
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    static String s(Context context) {
        try {
            return v(context);
        } catch (Throwable th) {
            bl.a(th, "DeviceInfo", "getNetworkOperatorName");
            return "";
        }
    }

    private static String u(Context context) {
        if (i != null && !"".equals(i)) {
            return i;
        }
        if (!a(context, "android.permission.READ_PHONE_STATE")) {
            return i;
        }
        TelephonyManager A = A(context);
        if (A == null) {
            return "";
        }
        i = A.getSubscriberId();
        if (i == null) {
            i = "";
        }
        return i;
    }

    private static String v(Context context) {
        if (!a(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        TelephonyManager A = A(context);
        if (A == null) {
            return "";
        }
        String simOperatorName = A.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? A.getNetworkOperatorName() : simOperatorName;
    }

    private static int w(Context context) {
        if (context == null || !a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return -1;
        }
        ConnectivityManager x = x(context);
        if (x == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = x.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager x(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String y(Context context) {
        String r = r(context);
        if (r == null || r.length() < 5) {
            return "";
        }
        return r.substring(3, 5);
    }

    private static int z(Context context) {
        if (!a(context, "android.permission.READ_PHONE_STATE")) {
            return -1;
        }
        TelephonyManager A = A(context);
        if (A == null) {
            return -1;
        }
        return A.getNetworkType();
    }

    private static TelephonyManager A(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }
}
