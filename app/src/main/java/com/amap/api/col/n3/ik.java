package com.amap.api.col.n3;

import android.content.Context;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil */
public final class ik {
    public static Proxy a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return a(context, new URI("http://restapi.amap.com"));
            }
            return b(context);
        } catch (Throwable th) {
            ir.a(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r4 == -1) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00aa, code lost:
        if (r4 == -1) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0151 A[SYNTHETIC, Splitter:B:109:0x0151] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0156 A[SYNTHETIC, Splitter:B:112:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0164 A[Catch:{ Throwable -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017e A[SYNTHETIC, Splitter:B:125:0x017e] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b9 A[SYNTHETIC, Splitter:B:62:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00df A[SYNTHETIC, Splitter:B:75:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f5 A[Catch:{ all -> 0x017b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy b(android.content.Context r11) {
        /*
            boolean r0 = c(r11)
            r1 = 0
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = "content://telephony/carriers/preferapn"
            android.net.Uri r3 = android.net.Uri.parse(r0)
            android.content.ContentResolver r2 = r11.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = 80
            r8 = 0
            r9 = 1
            r10 = -1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ SecurityException -> 0x00e4, Throwable -> 0x00cf, all -> 0x00cb }
            if (r2 == 0) goto L_0x00b5
            boolean r3 = r2.moveToFirst()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x00b5
            java.lang.String r3 = "apn"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x0038
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            java.lang.String r3 = r3.toLowerCase(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        L_0x0038:
            if (r3 == 0) goto L_0x007b
            java.lang.String r4 = "ctwap"
            boolean r4 = r3.contains(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r4 == 0) goto L_0x007b
            java.lang.String r3 = a()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            int r4 = b()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SecurityException -> 0x0077, Throwable -> 0x0072 }
            if (r5 != 0) goto L_0x005b
            java.lang.String r5 = "null"
            boolean r5 = r3.equals(r5)     // Catch:{ SecurityException -> 0x0077, Throwable -> 0x0072 }
            if (r5 != 0) goto L_0x005b
            r5 = r3
            r3 = r9
            goto L_0x005d
        L_0x005b:
            r5 = r1
            r3 = r8
        L_0x005d:
            if (r3 != 0) goto L_0x006e
            java.lang.String r3 = "QMTAuMC4wLjIwMA=="
            java.lang.String r3 = com.amap.api.col.n3.in.c((java.lang.String) r3)     // Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
            goto L_0x006f
        L_0x0066:
            r11 = move-exception
            r0 = r4
            r3 = r5
            goto L_0x00d3
        L_0x006b:
            r3 = move-exception
            goto L_0x00e8
        L_0x006e:
            r3 = r5
        L_0x006f:
            if (r4 != r10) goto L_0x00ad
            goto L_0x00b7
        L_0x0072:
            r11 = move-exception
            r3 = r1
            r0 = r4
            goto L_0x00d3
        L_0x0077:
            r3 = move-exception
            r5 = r1
            goto L_0x00e8
        L_0x007b:
            if (r3 == 0) goto L_0x00b5
            java.lang.String r4 = "wap"
            boolean r3 = r3.contains(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x00b5
            java.lang.String r3 = a()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            int r4 = b()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SecurityException -> 0x0077, Throwable -> 0x0072 }
            if (r5 != 0) goto L_0x009e
            java.lang.String r5 = "null"
            boolean r5 = r3.equals(r5)     // Catch:{ SecurityException -> 0x0077, Throwable -> 0x0072 }
            if (r5 != 0) goto L_0x009e
            r5 = r3
            r3 = r9
            goto L_0x00a0
        L_0x009e:
            r5 = r1
            r3 = r8
        L_0x00a0:
            if (r3 != 0) goto L_0x00a9
            java.lang.String r3 = "QMTAuMC4wLjE3Mg=="
            java.lang.String r3 = com.amap.api.col.n3.in.c((java.lang.String) r3)     // Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
            goto L_0x00aa
        L_0x00a9:
            r3 = r5
        L_0x00aa:
            if (r4 != r10) goto L_0x00ad
            goto L_0x00b7
        L_0x00ad:
            r0 = r4
            goto L_0x00b7
        L_0x00af:
            r11 = move-exception
            r3 = r1
            goto L_0x00d2
        L_0x00b2:
            r3 = move-exception
            r5 = r1
            goto L_0x00e7
        L_0x00b5:
            r3 = r1
            r0 = r10
        L_0x00b7:
            if (r2 == 0) goto L_0x0154
            r2.close()     // Catch:{ Throwable -> 0x00be }
            goto L_0x0154
        L_0x00be:
            r11 = move-exception
            java.lang.String r2 = "ProxyUtil"
            java.lang.String r4 = "getHostProxy2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r2, (java.lang.String) r4)
            r11.printStackTrace()
            goto L_0x0154
        L_0x00cb:
            r11 = move-exception
            r2 = r1
            goto L_0x017c
        L_0x00cf:
            r11 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d2:
            r0 = r10
        L_0x00d3:
            java.lang.String r4 = "ProxyUtil"
            java.lang.String r5 = "getHostProxy1"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x017b }
            r11.printStackTrace()     // Catch:{ all -> 0x017b }
            if (r2 == 0) goto L_0x0154
            r2.close()     // Catch:{ Throwable -> 0x00be }
            goto L_0x0154
        L_0x00e4:
            r3 = move-exception
            r2 = r1
            r5 = r2
        L_0x00e7:
            r4 = r10
        L_0x00e8:
            java.lang.String r6 = "pu"
            java.lang.String r7 = "ghp"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r3, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x017b }
            java.lang.String r11 = com.amap.api.col.n3.ih.o(r11)     // Catch:{ all -> 0x017b }
            if (r11 == 0) goto L_0x014d
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x017b }
            java.lang.String r11 = r11.toLowerCase(r3)     // Catch:{ all -> 0x017b }
            java.lang.String r3 = a()     // Catch:{ all -> 0x017b }
            int r4 = b()     // Catch:{ all -> 0x017b }
            java.lang.String r6 = "ctwap"
            int r6 = r11.indexOf(r6)     // Catch:{ all -> 0x017b }
            if (r6 == r10) goto L_0x012a
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x017b }
            if (r11 != 0) goto L_0x011b
            java.lang.String r11 = "null"
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x017b }
            if (r11 != 0) goto L_0x011b
            r11 = r9
            goto L_0x011d
        L_0x011b:
            r3 = r5
            r11 = r8
        L_0x011d:
            if (r11 != 0) goto L_0x0125
            java.lang.String r11 = "QMTAuMC4wLjIwMA=="
            java.lang.String r3 = com.amap.api.col.n3.in.c((java.lang.String) r11)     // Catch:{ all -> 0x017b }
        L_0x0125:
            if (r4 != r10) goto L_0x0128
            goto L_0x014f
        L_0x0128:
            r0 = r4
            goto L_0x014f
        L_0x012a:
            java.lang.String r6 = "wap"
            int r11 = r11.indexOf(r6)     // Catch:{ all -> 0x017b }
            if (r11 == r10) goto L_0x014d
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x017b }
            if (r11 != 0) goto L_0x0142
            java.lang.String r11 = "null"
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x017b }
            if (r11 != 0) goto L_0x0142
            r11 = r9
            goto L_0x0144
        L_0x0142:
            r3 = r5
            r11 = r8
        L_0x0144:
            if (r11 != 0) goto L_0x014f
            java.lang.String r11 = "QMTAuMC4wLjE3Mg=="
            java.lang.String r3 = com.amap.api.col.n3.in.c((java.lang.String) r11)     // Catch:{ all -> 0x017b }
            goto L_0x014f
        L_0x014d:
            r0 = r4
            r3 = r5
        L_0x014f:
            if (r2 == 0) goto L_0x0154
            r2.close()     // Catch:{ Throwable -> 0x00be }
        L_0x0154:
            if (r3 == 0) goto L_0x0162
            int r11 = r3.length()     // Catch:{ Throwable -> 0x0160 }
            if (r11 <= 0) goto L_0x0162
            if (r0 == r10) goto L_0x0162
            r8 = r9
            goto L_0x0162
        L_0x0160:
            r11 = move-exception
            goto L_0x0170
        L_0x0162:
            if (r8 == 0) goto L_0x018e
            java.net.Proxy r11 = new java.net.Proxy     // Catch:{ Throwable -> 0x0160 }
            java.net.Proxy$Type r2 = java.net.Proxy.Type.HTTP     // Catch:{ Throwable -> 0x0160 }
            java.net.InetSocketAddress r0 = java.net.InetSocketAddress.createUnresolved(r3, r0)     // Catch:{ Throwable -> 0x0160 }
            r11.<init>(r2, r0)     // Catch:{ Throwable -> 0x0160 }
            return r11
        L_0x0170:
            java.lang.String r0 = "pu"
            java.lang.String r2 = "gp2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
            r11.printStackTrace()
            goto L_0x018e
        L_0x017b:
            r11 = move-exception
        L_0x017c:
            if (r2 == 0) goto L_0x018d
            r2.close()     // Catch:{ Throwable -> 0x0182 }
            goto L_0x018d
        L_0x0182:
            r0 = move-exception
            java.lang.String r1 = "ProxyUtil"
            java.lang.String r2 = "getHostProxy2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            r0.printStackTrace()
        L_0x018d:
            throw r11
        L_0x018e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ik.b(android.content.Context):java.net.Proxy");
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            ir.a(th, "pe", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static Proxy a(Context context, URI uri) {
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    return null;
                }
                Proxy proxy = select.get(0);
                if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                ir.a(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static boolean c(Context context) {
        return ih.n(context) == 0;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            ir.a(th, "pu", "gdp");
            return -1;
        }
    }
}
