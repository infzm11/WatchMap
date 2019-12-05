package com.amap.api.services.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public class az {
    static String a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    bo.b(bi.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (b(a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(a)) {
                b = false;
                a = null;
                return false;
            } else if (b(d)) {
                b = true;
                return true;
            } else if (TextUtils.isEmpty(d)) {
                return true;
            } else {
                b = false;
                d = null;
                return false;
            }
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static String b(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager packageManager = context.getPackageManager();
            c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return c;
        } catch (Throwable th) {
            bl.a(th, "AppInfo", "getApplicationName");
        }
    }

    public static String c(Context context) {
        try {
            if (d != null && !"".equals(d)) {
                return d;
            }
            d = context.getPackageName();
            if (!b(d)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            bl.a(th, "AppInfo", "getpckn");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return e == null ? "" : e;
        } catch (Throwable th) {
            bl.a(th, "AppInfo", "getApplicationVersion");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(255 & b2).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            a = stringBuffer.toString();
            return a;
        } catch (Throwable th) {
            bl.a(th, "AppInfo", "getpck");
            return a;
        }
    }

    static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
        }
    }

    public static String f(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            bl.a(th, "AppInfo", "getKey");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[SYNTHETIC, Splitter:B:26:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060 A[SYNTHETIC, Splitter:B:34:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e A[SYNTHETIC, Splitter:B:40:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String g(android.content.Context r5) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r5 = com.amap.api.services.a.bm.a((android.content.Context) r5, (java.lang.String) r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L_0x0014
            java.lang.String r5 = ""
            return r5
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0043, all -> 0x003f }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0043, all -> 0x003f }
            int r5 = r1.available()     // Catch:{ Throwable -> 0x003d }
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x003d }
            r1.read(r5)     // Catch:{ Throwable -> 0x003d }
            java.lang.String r5 = com.amap.api.services.a.bi.a((byte[]) r5)     // Catch:{ Throwable -> 0x003d }
            int r2 = r5.length()     // Catch:{ Throwable -> 0x003d }
            r3 = 32
            if (r2 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            java.lang.String r5 = ""
        L_0x0032:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ Throwable -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003c:
            return r5
        L_0x003d:
            r5 = move-exception
            goto L_0x0047
        L_0x003f:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x006c
        L_0x0043:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L_0x0047:
            java.lang.String r2 = "AppInfo"
            java.lang.String r3 = "getKeyFromFile"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x005e
            boolean r5 = r0.exists()     // Catch:{ Throwable -> 0x005a }
            if (r5 == 0) goto L_0x005e
            r0.delete()     // Catch:{ Throwable -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x006b }
        L_0x005e:
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ Throwable -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0068:
            java.lang.String r5 = ""
            return r5
        L_0x006b:
            r5 = move-exception
        L_0x006c:
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0076:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.az.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        if (f == null || f.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            f = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            if (f == null) {
                f = g(context);
            }
        }
        return f;
    }
}
