package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: OfflineLocManager */
public class dh {
    static int a = 1000;
    static boolean b = false;

    /* JADX WARNING: Removed duplicated region for block: B:40:0x008f A[SYNTHETIC, Splitter:B:40:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b A[SYNTHETIC, Splitter:B:45:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5) {
        /*
            r0 = 0
            boolean r1 = c(r5)     // Catch:{ Throwable -> 0x0085 }
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0085 }
            java.lang.String r2 = com.amap.api.services.a.bm.h     // Catch:{ Throwable -> 0x0085 }
            java.lang.String r2 = com.amap.api.services.a.bm.a((android.content.Context) r5, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0085 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0085 }
            r2 = 2097152(0x200000, double:1.0361308E-317)
            r4 = 1
            com.amap.api.services.a.ct r1 = com.amap.api.services.a.ct.a(r1, r4, r4, r2)     // Catch:{ Throwable -> 0x0085 }
            java.lang.String r5 = a((android.content.Context) r5, (com.amap.api.services.a.ct) r1)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            if (r2 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0035
            boolean r5 = r1.c()     // Catch:{ Throwable -> 0x0031 }
            if (r5 != 0) goto L_0x0035
            r1.close()     // Catch:{ Throwable -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0035:
            return
        L_0x0036:
            byte[] r5 = com.amap.api.services.a.bi.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            byte[] r5 = com.amap.api.services.a.bi.c((byte[]) r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            com.amap.api.services.a.bn r2 = new com.amap.api.services.a.bn     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            java.lang.String r3 = "6"
            r2.<init>(r5, r3)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            com.amap.api.services.a.cx r5 = com.amap.api.services.a.cx.a()     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            byte[] r5 = r5.a(r2)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            r3.<init>(r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            java.lang.String r5 = "code"
            boolean r5 = r2.has(r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            if (r5 == 0) goto L_0x006b
            java.lang.String r5 = "code"
            int r5 = r2.getInt(r5)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            if (r5 != r4) goto L_0x006b
            b((com.amap.api.services.a.ct) r1)     // Catch:{ Throwable -> 0x007f, all -> 0x007d }
            goto L_0x006c
        L_0x006b:
            r0 = r1
        L_0x006c:
            if (r0 == 0) goto L_0x0098
            boolean r5 = r0.c()     // Catch:{ Throwable -> 0x0078 }
            if (r5 != 0) goto L_0x0098
            r0.close()     // Catch:{ Throwable -> 0x0078 }
            goto L_0x0098
        L_0x0078:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0098
        L_0x007d:
            r5 = move-exception
            goto L_0x0099
        L_0x007f:
            r5 = move-exception
            r0 = r1
            goto L_0x0086
        L_0x0082:
            r5 = move-exception
            r1 = r0
            goto L_0x0099
        L_0x0085:
            r5 = move-exception
        L_0x0086:
            java.lang.String r1 = "OfflineLocManager"
            java.lang.String r2 = "updateOfflineLocData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x0098
            boolean r5 = r0.c()     // Catch:{ Throwable -> 0x0078 }
            if (r5 != 0) goto L_0x0098
            r0.close()     // Catch:{ Throwable -> 0x0078 }
        L_0x0098:
            return
        L_0x0099:
            if (r1 == 0) goto L_0x00a9
            boolean r0 = r1.c()     // Catch:{ Throwable -> 0x00a5 }
            if (r0 != 0) goto L_0x00a9
            r1.close()     // Catch:{ Throwable -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dh.a(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A[SYNTHETIC, Splitter:B:23:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC, Splitter:B:26:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r2, long r3) {
        /*
            r0 = 0
            java.lang.String r1 = "f.log"
            java.lang.String r2 = com.amap.api.services.a.bm.a((android.content.Context) r2, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0042 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0042 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0042 }
            java.io.File r2 = r1.getParentFile()     // Catch:{ Throwable -> 0x0042 }
            boolean r2 = r2.exists()     // Catch:{ Throwable -> 0x0042 }
            if (r2 != 0) goto L_0x001d
            java.io.File r2 = r1.getParentFile()     // Catch:{ Throwable -> 0x0042 }
            r2.mkdirs()     // Catch:{ Throwable -> 0x0042 }
        L_0x001d:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0042 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0042 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            byte[] r3 = com.amap.api.services.a.bi.a((java.lang.String) r3)     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            r2.write(r3)     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ Throwable -> 0x0033 }
            goto L_0x004f
        L_0x0033:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x004f
        L_0x0038:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0050
        L_0x003c:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0043
        L_0x0040:
            r2 = move-exception
            goto L_0x0050
        L_0x0042:
            r2 = move-exception
        L_0x0043:
            java.lang.String r3 = "OfflineLocManager"
            java.lang.String r4 = "updateLogUpdateTime"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x004f
            r0.close()     // Catch:{ Throwable -> 0x0033 }
        L_0x004f:
            return
        L_0x0050:
            if (r0 == 0) goto L_0x005a
            r0.close()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dh.a(android.content.Context, long):void");
    }

    private static String a(ct ctVar) {
        StringBuilder sb = new StringBuilder();
        try {
            File b2 = ctVar.b();
            if (b2 != null && b2.exists()) {
                boolean z = true;
                for (String str : b2.list()) {
                    if (str.contains(".0")) {
                        String a2 = bi.a(dk.a(ctVar, str.split("\\.")[0], false));
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append("{\"log\":\"");
                        sb.append(a2);
                        sb.append("\"}");
                    }
                }
            }
        } catch (Throwable th) {
            bl.a(th, "StatisticsManager", "getContent");
        }
        return sb.toString();
    }

    private static void b(ct ctVar) {
        if (ctVar != null) {
            try {
                ctVar.e();
            } catch (Throwable th) {
                bl.a(th, "StatisticsManager", "getContent");
            }
        }
    }

    private static String a(Context context, ct ctVar) {
        String a2 = a(ctVar);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String d = d(context);
        return "{\"pinfo\":\"" + d + "\",\"els\":[" + a2 + "]}";
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[SYNTHETIC, Splitter:B:31:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069 A[SYNTHETIC, Splitter:B:39:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long b(android.content.Context r5) {
        /*
            java.lang.String r0 = "f.log"
            java.lang.String r5 = com.amap.api.services.a.bm.a((android.content.Context) r5, (java.lang.String) r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L_0x0014
            r0 = 0
            return r0
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            int r5 = r1.available()     // Catch:{ Throwable -> 0x0036 }
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x0036 }
            r1.read(r5)     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r5 = com.amap.api.services.a.bi.a((byte[]) r5)     // Catch:{ Throwable -> 0x0036 }
            long r2 = java.lang.Long.parseLong(r5)     // Catch:{ Throwable -> 0x0036 }
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ Throwable -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0035:
            return r2
        L_0x0036:
            r5 = move-exception
            goto L_0x0040
        L_0x0038:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x0067
        L_0x003c:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L_0x0040:
            java.lang.String r2 = "OfflineLocManager"
            java.lang.String r3 = "getUpdateTime"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0057
            boolean r5 = r0.exists()     // Catch:{ Throwable -> 0x0053 }
            if (r5 == 0) goto L_0x0057
            r0.delete()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0066 }
        L_0x0057:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ Throwable -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0061:
            long r0 = java.lang.System.currentTimeMillis()
            return r0
        L_0x0066:
            r5 = move-exception
        L_0x0067:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ Throwable -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dh.b(android.content.Context):long");
    }

    private static synchronized boolean c(Context context) {
        synchronized (dh.class) {
            try {
                if (bd.m(context) == 1 || b) {
                    if (System.currentTimeMillis() - b(context) < 14400000) {
                        return false;
                    }
                    a(context, System.currentTimeMillis());
                    return true;
                }
            } catch (Throwable th) {
                bl.a(th, "StatisticsManager", "isUpdate");
            }
        }
        return false;
    }

    private static String d(Context context) {
        return bc.b(context, bi.a(e(context)));
    }

    private static String e(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"");
            sb.append(az.f(context));
            sb.append("\",\"platform\":\"android\",\"diu\":\"");
            sb.append(bd.q(context));
            sb.append("\",\"mac\":\"");
            sb.append(bd.i(context));
            sb.append("\",\"tid\":\"");
            sb.append(bd.f(context));
            sb.append("\",\"umidt\":\"");
            sb.append(bd.a());
            sb.append("\",\"manufacture\":\"");
            sb.append(Build.MANUFACTURER);
            sb.append("\",\"device\":\"");
            sb.append(Build.DEVICE);
            sb.append("\",\"sim\":\"");
            sb.append(bd.r(context));
            sb.append("\",\"pkg\":\"");
            sb.append(az.c(context));
            sb.append("\",\"model\":\"");
            sb.append(Build.MODEL);
            sb.append("\",\"appversion\":\"");
            sb.append(az.d(context));
            sb.append("\",\"appname\":\"");
            sb.append(az.b(context));
            sb.append("\"");
        } catch (Throwable th) {
            bl.a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }
}
