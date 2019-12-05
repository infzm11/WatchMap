package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public final class k {
    static String a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static void a(String str) {
        d = str;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (c(a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(a)) {
                b = false;
                a = null;
                return false;
            } else if (c(d)) {
                b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(d)) {
                    b = false;
                    d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
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
            w.a(th, "AI", "gAN");
        }
    }

    static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
        }
    }

    public static String c(Context context) {
        try {
            if (d != null && !"".equals(d)) {
                return d;
            }
            String packageName = context.getPackageName();
            d = packageName;
            if (!c(packageName)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            w.a(th, "AI", "gpck");
        }
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    z.b(t.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return e == null ? "" : e;
        } catch (Throwable th) {
            w.a(th, "AI", "gAV");
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
            if (c(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            w.a(th, "AI", "gsp");
            return a;
        }
    }

    public static String f(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            w.a(th, "ai", "gKy");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[Catch:{ Throwable -> 0x0056, all -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A[SYNTHETIC, Splitter:B:33:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006a A[SYNTHETIC, Splitter:B:39:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String g(android.content.Context r5) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r5 = com.loc.x.a(r5, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L_0x0014
            java.lang.String r5 = ""
            return r5
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            int r5 = r1.available()     // Catch:{ Throwable -> 0x003b }
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x003b }
            r1.read(r5)     // Catch:{ Throwable -> 0x003b }
            java.lang.String r5 = com.loc.t.a((byte[]) r5)     // Catch:{ Throwable -> 0x003b }
            int r2 = r5.length()     // Catch:{ Throwable -> 0x003b }
            r3 = 32
            if (r2 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            java.lang.String r5 = ""
        L_0x0032:
            r1.close()     // Catch:{ Throwable -> 0x0036 }
            return r5
        L_0x0036:
            r0 = move-exception
            r0.printStackTrace()
            return r5
        L_0x003b:
            r5 = move-exception
            goto L_0x0045
        L_0x003d:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x0068
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L_0x0045:
            java.lang.String r2 = "ai"
            java.lang.String r3 = "gKe"
            com.loc.w.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0067 }
            boolean r5 = r0.exists()     // Catch:{ Throwable -> 0x0056 }
            if (r5 == 0) goto L_0x005a
            r0.delete()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0067 }
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0064:
            java.lang.String r5 = ""
            return r5
        L_0x0067:
            r5 = move-exception
        L_0x0068:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Throwable -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.k.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        if (f == null || f.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
