package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.Field;

public class bp {
    public static String[][] a = {new String[]{"=", ":"}, new String[]{",", "_"}};
    public static String[][] b = {new String[]{"os.manufact", Build.MANUFACTURER}, new String[]{"os.model", Build.MODEL}, new String[]{"os.product", Build.PRODUCT}, new String[]{"os.display", Build.DISPLAY}, new String[]{"os.host", Build.HOST}, new String[]{"os.id", Build.ID}, new String[]{"os.device", Build.DEVICE}, new String[]{"os.board", Build.BOARD}, new String[]{"os.brand", Build.BRAND}, new String[]{"os.user", Build.USER}, new String[]{"os.type", Build.TYPE}};
    private static String[][] c = {new String[]{"os.cpu", "CPU_ABI"}, new String[]{"os.cpu2", "CPU_ABI2"}, new String[]{"os.serial", "SERIAL"}, new String[]{"os.hardware", "HARDWARE"}, new String[]{"os.bootloader", "BOOTLOADER"}, new String[]{"os.radio", "RADIO"}};
    private static ce d = new ce();
    private static boolean e = false;
    /* access modifiers changed from: private */
    public static String f;
    private static String g;

    public static synchronized ce a(Context context) {
        synchronized (bp.class) {
            if (e) {
                ce ceVar = d;
                return ceVar;
            }
            g(context);
            ce ceVar2 = d;
            return ceVar2;
        }
    }

    public static String a(String str) {
        String str2;
        cb.d("check and replace src: " + str);
        if (str != null) {
            str2 = str;
            for (int i = 0; i < a.length; i++) {
                str2 = str2.replace(a[i][0], a[i][1]);
            }
        } else {
            str2 = null;
        }
        cb.d("check and replace result: " + str2);
        return str2;
    }

    public static void a(ce ceVar, Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            ceVar.a("app.ver.name", packageInfo.versionName);
            ceVar.a("app.ver.code", "" + packageInfo.versionCode);
            ceVar.a("app.pkg", applicationInfo.packageName);
            ceVar.a("app.path", applicationInfo.dataDir);
            ceVar.a("app.name", applicationInfo.loadLabel(context.getPackageManager()).toString());
        } catch (Exception unused) {
        }
    }

    public static ce b(Context context) {
        ce a2 = a(context);
        ce ceVar = new ce();
        ceVar.a(a2, "app.name");
        ceVar.a(a2, "app.path");
        ceVar.a(a2, "app.pkg");
        ceVar.a(a2, "app.ver.name");
        ceVar.a(a2, "app.ver.code");
        ceVar.a(a2, "os.system");
        ceVar.a(a2, "os.resolution");
        ceVar.a(a2, "os.density");
        ceVar.a(a2, "net.mac");
        ceVar.a(a2, "os.imei");
        ceVar.a(a2, "os.imsi");
        ceVar.a(a2, "os.version");
        ceVar.a(a2, "os.release");
        ceVar.a(a2, "os.incremental");
        ceVar.a(a2, "os.android_id");
        ceVar.a(a2, "carrier");
        ceVar.a(a2, b[0][0]);
        ceVar.a(a2, b[1][0]);
        ceVar.a(a2, b[2][0]);
        ceVar.a(a2, b[3][0]);
        return ceVar;
    }

    public static String c(Context context) {
        try {
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            return !TextUtils.isEmpty(networkOperatorName) ? networkOperatorName : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String c(String str) {
        try {
            Field field = Build.class.getField(str);
            return field != null ? field.get(new Build()).toString() : EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static String d(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable unused) {
            cb.a("Failed to get mac Info");
            return "";
        }
    }

    public static String e(final Context context) {
        if (TextUtils.isEmpty(f)) {
            try {
                new Handler(context.getMainLooper(), new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        if (message.what != 1) {
                            return false;
                        }
                        String unused = bp.f = new WebView(context).getSettings().getUserAgentString();
                        cb.d("user agent: " + bp.f);
                        return false;
                    }
                }).sendEmptyMessage(1);
            } catch (Throwable th) {
                cb.a(th);
            }
        }
        cb.d("get user agent: " + f);
        return f;
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(g)) {
            try {
                int i = context.getResources().getConfiguration().screenLayout & 15;
                g = i >= 3 ? "tablet" : i >= 1 ? "handset" : "unknow";
            } catch (Throwable th) {
                cb.a(th);
            }
        }
        cb.d("get device type: " + g);
        return g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.iflytek.cloud.thirdparty.cb.a("Failed to get sbid Info");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010b, code lost:
        r6 = "Failed to get prop Info";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        com.iflytek.cloud.thirdparty.cb.a("Failed to get did Info");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(android.content.Context r6) {
        /*
            r0 = 0
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "os.system"
            java.lang.String r3 = "Android"
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            a(r1, r6)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r3 = "os.resolution"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.<init>()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r5 = r1.widthPixels     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.append(r5)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r5 = "*"
            r4.append(r5)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r5 = r1.heightPixels     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.append(r5)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r2.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r3 = "os.density"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.<init>()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            float r1 = r1.density     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.append(r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r2.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Throwable -> 0x0069, Exception -> 0x010b }
            java.lang.String r3 = "os.imei"
            java.lang.String r4 = r1.getDeviceId()     // Catch:{ Throwable -> 0x0069, Exception -> 0x010b }
            r2.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0069, Exception -> 0x010b }
            goto L_0x006e
        L_0x0069:
            java.lang.String r2 = "Failed to get did Info"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r2)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
        L_0x006e:
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Throwable -> 0x007a, Exception -> 0x010b }
            java.lang.String r3 = "os.imsi"
            java.lang.String r1 = r1.getSubscriberId()     // Catch:{ Throwable -> 0x007a, Exception -> 0x010b }
            r2.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ Throwable -> 0x007a, Exception -> 0x010b }
            goto L_0x007f
        L_0x007a:
            java.lang.String r1 = "Failed to get sbid Info"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
        L_0x007f:
            android.content.ContentResolver r1 = r6.getContentResolver()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            if (r2 != 0) goto L_0x0096
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r3 = "os.android_id"
            r2.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
        L_0x0096:
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "os.version"
            java.lang.String r3 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "os.release"
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "os.incremental"
            java.lang.String r3 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1 = r0
        L_0x00b2:
            java.lang.String[][] r2 = b     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r2 = r2.length     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r3 = 1
            if (r1 >= r2) goto L_0x00cc
            com.iflytek.cloud.thirdparty.ce r2 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String[][] r4 = b     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4 = r4[r1]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4 = r4[r0]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String[][] r5 = b     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r5 = r5[r1]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r3 = r5[r3]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r2.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00cc:
            r1 = r0
        L_0x00cd:
            java.lang.String[][] r2 = c     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r2 = r2.length     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            if (r1 >= r2) goto L_0x00ea
            java.lang.String[][] r2 = c     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r2 = r2[r1]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r2 = r2[r3]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = c((java.lang.String) r2)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r4 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String[][] r5 = c     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r5 = r5[r1]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r5 = r5[r0]     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r4.a((java.lang.String) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            int r1 = r1 + 1
            goto L_0x00cd
        L_0x00ea:
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "net.mac"
            java.lang.String r4 = d(r6)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r1 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            java.lang.String r2 = "carrier"
            java.lang.String r6 = c((android.content.Context) r6)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r1.a((java.lang.String) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            com.iflytek.cloud.thirdparty.ce r6 = d     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            r6.d()     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            e = r3     // Catch:{ Exception -> 0x010b, Throwable -> 0x0108 }
            return
        L_0x0108:
            java.lang.String r6 = "Failed to get property Info"
            goto L_0x010d
        L_0x010b:
            java.lang.String r6 = "Failed to get prop Info"
        L_0x010d:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r6)
            e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bp.g(android.content.Context):void");
    }
}
