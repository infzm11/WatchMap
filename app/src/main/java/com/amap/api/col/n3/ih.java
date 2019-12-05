package com.amap.api.col.n3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
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
public final class ih {
    static String a = "";
    static boolean b = false;
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
            String r = r(context);
            if (r != null) {
                if (r.length() >= 5) {
                    return r.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int c(Context context) {
        try {
            return y(context);
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
            ir.a(th, "dI", "sag");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[SYNTHETIC, Splitter:B:45:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String t(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r8 = com.amap.api.col.n3.in.a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            if (r8 == 0) goto L_0x008f
            java.lang.String r8 = "mounted"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            boolean r8 = r8.equals(r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            if (r8 == 0) goto L_0x008f
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.<init>()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.append(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = "/.UTSystemConfig/Global/Alvin2.xml"
            r1.append(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.<init>(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            org.xmlpull.v1.XmlPullParser r8 = android.util.Xml.newPullParser()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            int r2 = r8.getEventType()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r0 = "utf-8"
            r8.setInput(r3, r0)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r0 = 0
            r1 = r0
        L_0x0047:
            r4 = 1
            if (r4 == r2) goto L_0x0088
            if (r2 == 0) goto L_0x0083
            switch(r2) {
                case 2: goto L_0x005c;
                case 3: goto L_0x005a;
                case 4: goto L_0x0050;
                default: goto L_0x004f;
            }     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
        L_0x004f:
            goto L_0x0083
        L_0x0050:
            if (r1 == 0) goto L_0x0083
            java.lang.String r8 = r8.getText()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r3.close()     // Catch:{ Throwable -> 0x0059 }
        L_0x0059:
            return r8
        L_0x005a:
            r1 = r0
            goto L_0x0083
        L_0x005c:
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r2 <= 0) goto L_0x0083
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r5 = r1
            r1 = r0
        L_0x0068:
            if (r1 >= r2) goto L_0x0082
            java.lang.String r6 = r8.getAttributeValue(r1)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            java.lang.String r7 = "UTDID2"
            boolean r7 = r7.equals(r6)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r7 != 0) goto L_0x007e
            java.lang.String r7 = "UTDID"
            boolean r6 = r7.equals(r6)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r6 == 0) goto L_0x007f
        L_0x007e:
            r5 = r4
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0068
        L_0x0082:
            r1 = r5
        L_0x0083:
            int r2 = r8.next()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            goto L_0x0047
        L_0x0088:
            r0 = r3
            goto L_0x008f
        L_0x008a:
            r8 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x008d:
            r0 = r3
            goto L_0x009c
        L_0x008f:
            if (r0 == 0) goto L_0x009f
        L_0x0091:
            r0.close()     // Catch:{ Throwable -> 0x009f }
            goto L_0x009f
        L_0x0095:
            r8 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            r0.close()     // Catch:{ Throwable -> 0x009b }
        L_0x009b:
            throw r8
        L_0x009c:
            if (r0 == 0) goto L_0x009f
            goto L_0x0091
        L_0x009f:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ih.t(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|(1:9)|10|(2:14|15)|16|17|18|(1:21)(2:22|23)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[RETURN] */
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
            return r2
        L_0x0043:
            java.lang.String r2 = a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ih.f(android.content.Context):java.lang.String");
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

    public static String g(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), in.c(new String(ip.a(13))));
            d = string;
            return string == null ? "" : d;
        } catch (Throwable unused) {
            return d;
        }
    }

    private static boolean a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String h(Context context) {
        if (context != null) {
            try {
                if (a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager != null && wifiManager.isWifiEnabled()) {
                        return wifiManager.getConnectionInfo().getBSSID();
                    }
                    return "";
                }
            } catch (Throwable th) {
                ir.a(th, "dI", "gcW");
                return "";
            }
        }
        return "";
    }

    static String i(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
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
                ir.a(th, "dI", "gWs");
            }
        }
        return sb.toString();
    }

    public static String j(Context context) {
        try {
            if (f != null && !"".equals(f)) {
                return f;
            }
            if (!a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return f;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f = wifiManager.getConnectionInfo().getMacAddress();
            if (in.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(f) || in.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(f)) {
                f = d();
            }
            return f;
        } catch (Throwable th) {
            ir.a(th, "dI", "gDc");
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
            ir.a((Throwable) e2, "dI", "gMr");
            return "";
        }
    }

    static String[] k(Context context) {
        try {
            if (a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (a(context, in.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
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
            ir.a(th, "dI", "cf");
        }
    }

    static String l(Context context) {
        try {
            if (!a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return "";
            }
            TelephonyManager z = z(context);
            if (z == null) {
                return "";
            }
            String networkOperator = z.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(3);
                }
            }
            return "";
        } catch (Throwable th) {
            ir.a(th, "dI", "gNC");
            return "";
        }
    }

    public static int m(Context context) {
        try {
            return y(context);
        } catch (Throwable th) {
            ir.a(th, "dI", "gNT");
            return -1;
        }
    }

    public static int n(Context context) {
        try {
            return w(context);
        } catch (Throwable th) {
            ir.a(th, "dI", "gAT");
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[Catch:{ Throwable -> 0x0022 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[Catch:{ Throwable -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String o(android.content.Context r3) {
        /*
            r0 = 0
            java.lang.String r1 = "AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"
            java.lang.String r1 = com.amap.api.col.n3.in.c((java.lang.String) r1)     // Catch:{ Throwable -> 0x0022 }
            boolean r1 = a(r3, r1)     // Catch:{ Throwable -> 0x0022 }
            if (r1 != 0) goto L_0x000f
        L_0x000d:
            r3 = r0
            goto L_0x001a
        L_0x000f:
            android.net.ConnectivityManager r3 = x(r3)     // Catch:{ Throwable -> 0x0022 }
            if (r3 != 0) goto L_0x0016
            goto L_0x000d
        L_0x0016:
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()     // Catch:{ Throwable -> 0x0022 }
        L_0x001a:
            if (r3 != 0) goto L_0x001d
            return r0
        L_0x001d:
            java.lang.String r3 = r3.getExtraInfo()     // Catch:{ Throwable -> 0x0022 }
            goto L_0x002b
        L_0x0022:
            r3 = move-exception
            java.lang.String r1 = "dI"
            java.lang.String r2 = "gne"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r3, (java.lang.String) r1, (java.lang.String) r2)
            r3 = r0
        L_0x002b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ih.o(android.content.Context):java.lang.String");
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
            ir.a(th, "dI", "gR");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.os.Parcel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.os.Parcel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3 A[SYNTHETIC, Splitter:B:32:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00df A[Catch:{ all -> 0x00db, Throwable -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0161 A[SYNTHETIC, Splitter:B:59:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016c A[Catch:{ all -> 0x00db, Throwable -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x017b A[Catch:{ Throwable -> 0x0180 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:56:0x015c=Splitter:B:56:0x015c, B:29:0x00ce=Splitter:B:29:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String q(android.content.Context r9) {
        /*
            java.lang.String r0 = h     // Catch:{ Throwable -> 0x0180 }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = ""
            java.lang.String r1 = h     // Catch:{ Throwable -> 0x0180 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x0180 }
            if (r0 != 0) goto L_0x0011
            java.lang.String r9 = h     // Catch:{ Throwable -> 0x0180 }
            return r9
        L_0x0011:
            java.lang.String r0 = "WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="
            java.lang.String r0 = com.amap.api.col.n3.in.c((java.lang.String) r0)     // Catch:{ Throwable -> 0x0180 }
            boolean r0 = a(r9, r0)     // Catch:{ Throwable -> 0x0180 }
            if (r0 != 0) goto L_0x0020
            java.lang.String r9 = h     // Catch:{ Throwable -> 0x0180 }
            return r9
        L_0x0020:
            java.lang.String r0 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r1 = 0
            byte[] r2 = com.amap.api.col.n3.ip.a(r1)     // Catch:{ Throwable -> 0x0173 }
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r0 = com.amap.api.col.n3.in.c((java.lang.String) r0)     // Catch:{ Throwable -> 0x0173 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r3 = 1
            byte[] r4 = com.amap.api.col.n3.ip.a(r3)     // Catch:{ Throwable -> 0x0173 }
            r2.<init>(r4)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r2 = com.amap.api.col.n3.in.c((java.lang.String) r2)     // Catch:{ Throwable -> 0x0173 }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Throwable -> 0x0173 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch:{ Throwable -> 0x0173 }
            java.lang.reflect.Method r2 = r0.getMethod(r2, r4)     // Catch:{ Throwable -> 0x0173 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0173 }
            r5 = 21
            r6 = 6
            r7 = 0
            if (r4 <= r5) goto L_0x00e6
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r8 = 2
            byte[] r8 = com.amap.api.col.n3.ip.a(r8)     // Catch:{ Throwable -> 0x0173 }
            r5.<init>(r8)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r5 = com.amap.api.col.n3.in.c((java.lang.String) r5)     // Catch:{ Throwable -> 0x0173 }
            r4[r1] = r5     // Catch:{ Throwable -> 0x0173 }
            java.lang.Object r0 = r2.invoke(r0, r4)     // Catch:{ Throwable -> 0x0173 }
            android.os.IBinder r0 = (android.os.IBinder) r0     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r2 = 4
            byte[] r2 = com.amap.api.col.n3.ip.a(r2)     // Catch:{ Throwable -> 0x0173 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r1 = com.amap.api.col.n3.in.c((java.lang.String) r1)     // Catch:{ Throwable -> 0x0173 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            byte[] r4 = com.amap.api.col.n3.ip.a(r6)     // Catch:{ Throwable -> 0x0173 }
            r2.<init>(r4)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r2 = com.amap.api.col.n3.in.c((java.lang.String) r2)     // Catch:{ Throwable -> 0x0173 }
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Throwable -> 0x0173 }
            r2.setAccessible(r3)     // Catch:{ Throwable -> 0x0173 }
            int r1 = r2.getInt(r1)     // Catch:{ Throwable -> 0x0173 }
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            r4 = 7
            byte[] r4 = com.amap.api.col.n3.ip.a(r4)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            java.lang.String r3 = com.amap.api.col.n3.in.c((java.lang.String) r3)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            r2.writeInterfaceToken(r3)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            java.lang.String r9 = com.amap.api.col.n3.id.c((android.content.Context) r9)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            r2.writeString(r9)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            android.os.Parcel r9 = com.amap.api.col.n3.in.a((android.os.IBinder) r0, (int) r1, (android.os.Parcel) r2)     // Catch:{ Throwable -> 0x00cc, all -> 0x00ca }
            if (r9 == 0) goto L_0x00c1
            r9.readException()     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r0 = r9.readString()     // Catch:{ Throwable -> 0x00bf }
            r7 = r0
            goto L_0x00c1
        L_0x00bf:
            r0 = move-exception
            goto L_0x00ce
        L_0x00c1:
            if (r9 == 0) goto L_0x00c6
            r9.recycle()     // Catch:{ Throwable -> 0x0173 }
        L_0x00c6:
            r2.recycle()     // Catch:{ Throwable -> 0x0173 }
            goto L_0x00d7
        L_0x00ca:
            r0 = move-exception
            goto L_0x00dd
        L_0x00cc:
            r0 = move-exception
            r9 = r7
        L_0x00ce:
            r0.printStackTrace()     // Catch:{ all -> 0x00db }
            if (r9 == 0) goto L_0x00c6
            r9.recycle()     // Catch:{ Throwable -> 0x0173 }
            goto L_0x00c6
        L_0x00d7:
            h = r7     // Catch:{ Throwable -> 0x0173 }
            goto L_0x0177
        L_0x00db:
            r0 = move-exception
            r7 = r9
        L_0x00dd:
            if (r7 == 0) goto L_0x00e2
            r7.recycle()     // Catch:{ Throwable -> 0x0173 }
        L_0x00e2:
            r2.recycle()     // Catch:{ Throwable -> 0x0173 }
            throw r0     // Catch:{ Throwable -> 0x0173 }
        L_0x00e6:
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r5 = 3
            byte[] r5 = com.amap.api.col.n3.ip.a(r5)     // Catch:{ Throwable -> 0x0173 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r4 = com.amap.api.col.n3.in.c((java.lang.String) r4)     // Catch:{ Throwable -> 0x0173 }
            r9[r1] = r4     // Catch:{ Throwable -> 0x0173 }
            java.lang.Object r9 = r2.invoke(r0, r9)     // Catch:{ Throwable -> 0x0173 }
            android.os.IBinder r9 = (android.os.IBinder) r9     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r0 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            r1 = 5
            byte[] r1 = com.amap.api.col.n3.ip.a(r1)     // Catch:{ Throwable -> 0x0173 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r0 = com.amap.api.col.n3.in.c((java.lang.String) r0)     // Catch:{ Throwable -> 0x0173 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Throwable -> 0x0173 }
            byte[] r2 = com.amap.api.col.n3.ip.a(r6)     // Catch:{ Throwable -> 0x0173 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r1 = com.amap.api.col.n3.in.c((java.lang.String) r1)     // Catch:{ Throwable -> 0x0173 }
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ Throwable -> 0x0173 }
            r1.setAccessible(r3)     // Catch:{ Throwable -> 0x0173 }
            int r0 = r1.getInt(r0)     // Catch:{ Throwable -> 0x0173 }
            android.os.Parcel r1 = android.os.Parcel.obtain()     // Catch:{ Throwable -> 0x0173 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            r3 = 8
            byte[] r3 = com.amap.api.col.n3.ip.a(r3)     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            java.lang.String r2 = com.amap.api.col.n3.in.c((java.lang.String) r2)     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            r1.writeInterfaceToken(r2)     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            android.os.Parcel r9 = com.amap.api.col.n3.in.a((android.os.IBinder) r9, (int) r0, (android.os.Parcel) r1)     // Catch:{ Throwable -> 0x015a, all -> 0x0158 }
            if (r9 == 0) goto L_0x014f
            r9.readException()     // Catch:{ Throwable -> 0x014d }
            java.lang.String r0 = r9.readString()     // Catch:{ Throwable -> 0x014d }
            r7 = r0
            goto L_0x014f
        L_0x014d:
            r0 = move-exception
            goto L_0x015c
        L_0x014f:
            if (r9 == 0) goto L_0x0154
            r9.recycle()     // Catch:{ Throwable -> 0x0173 }
        L_0x0154:
            r1.recycle()     // Catch:{ Throwable -> 0x0173 }
            goto L_0x0165
        L_0x0158:
            r0 = move-exception
            goto L_0x016a
        L_0x015a:
            r0 = move-exception
            r9 = r7
        L_0x015c:
            r0.printStackTrace()     // Catch:{ all -> 0x0168 }
            if (r9 == 0) goto L_0x0154
            r9.recycle()     // Catch:{ Throwable -> 0x0173 }
            goto L_0x0154
        L_0x0165:
            h = r7     // Catch:{ Throwable -> 0x0173 }
            goto L_0x0177
        L_0x0168:
            r0 = move-exception
            r7 = r9
        L_0x016a:
            if (r7 == 0) goto L_0x016f
            r7.recycle()     // Catch:{ Throwable -> 0x0173 }
        L_0x016f:
            r1.recycle()     // Catch:{ Throwable -> 0x0173 }
            throw r0     // Catch:{ Throwable -> 0x0173 }
        L_0x0173:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ Throwable -> 0x0180 }
        L_0x0177:
            java.lang.String r9 = h     // Catch:{ Throwable -> 0x0180 }
            if (r9 != 0) goto L_0x0188
            java.lang.String r9 = ""
            h = r9     // Catch:{ Throwable -> 0x0180 }
            goto L_0x0188
        L_0x0180:
            r9 = move-exception
            java.lang.String r0 = "dI"
            java.lang.String r1 = "gd"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r9, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0188:
            java.lang.String r9 = h
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ih.q(android.content.Context):java.lang.String");
    }

    public static String r(Context context) {
        try {
            return u(context);
        } catch (Throwable th) {
            ir.a(th, "dI", "gSd");
            return "";
        }
    }

    static String s(Context context) {
        try {
            return v(context);
        } catch (Throwable th) {
            ir.a(th, "dI", "gNNa");
            return "";
        }
    }

    private static String u(Context context) {
        if (i != null && !"".equals(i)) {
            return i;
        }
        if (!a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return i;
        }
        TelephonyManager z = z(context);
        if (z == null) {
            return "";
        }
        String subscriberId = z.getSubscriberId();
        i = subscriberId;
        if (subscriberId == null) {
            i = "";
        }
        return i;
    }

    private static String v(Context context) {
        if (!a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager z = z(context);
        if (z == null) {
            return "";
        }
        String simOperatorName = z.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? z.getNetworkOperatorName() : simOperatorName;
    }

    private static int w(Context context) {
        if (context == null || !a(context, in.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
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

    private static int y(Context context) {
        if (!a(context, in.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return -1;
        }
        TelephonyManager z = z(context);
        if (z == null) {
            return -1;
        }
        return z.getNetworkType();
    }

    private static TelephonyManager z(Context context) {
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
