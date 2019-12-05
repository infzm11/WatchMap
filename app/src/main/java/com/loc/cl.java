package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;

/* compiled from: DNSManager */
public final class cl {
    private static cl c;
    co a;
    volatile int b;
    private Object d;
    private Context e;
    private ExecutorService f;
    private boolean g;
    private boolean h;

    /* compiled from: DNSManager */
    class a implements Runnable {
        co a = null;

        a(co coVar) {
            this.a = coVar;
        }

        public final void run() {
            cl.this.b++;
            cl.this.b(this.a);
            cl clVar = cl.this;
            clVar.b--;
        }
    }

    private cl() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = true;
        this.a = null;
        this.b = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|10|11|(1:13)(1:14)|15|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[Catch:{ Throwable -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046 A[Catch:{ Throwable -> 0x004d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private cl(android.content.Context r10) {
        /*
            r9 = this;
            r9.<init>()
            r0 = 0
            r9.d = r0
            r9.e = r0
            r9.f = r0
            r1 = 0
            r9.g = r1
            r2 = 1
            r9.h = r2
            r9.a = r0
            r9.b = r1
            r9.e = r10
            android.content.Context r10 = r9.e
            boolean r0 = com.loc.cr.x()     // Catch:{ Throwable -> 0x004d }
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            java.lang.String r0 = "HttpDNS"
            java.lang.String r3 = "1.0.0"
            com.loc.s r4 = com.loc.cs.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Throwable -> 0x004d }
            boolean r0 = com.loc.cx.a((android.content.Context) r10, (com.loc.s) r4)     // Catch:{ Throwable -> 0x004d }
            if (r0 == 0) goto L_0x004c
            java.lang.String r5 = "com.autonavi.httpdns.HttpDnsManager"
            r6 = 0
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x0041 }
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r7[r1] = r0     // Catch:{ Throwable -> 0x0041 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0041 }
            r8[r1] = r10     // Catch:{ Throwable -> 0x0041 }
            r3 = r10
            java.lang.Object r0 = com.loc.au.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x0041 }
            r9.d = r0     // Catch:{ Throwable -> 0x0041 }
        L_0x0041:
            java.lang.Object r0 = r9.d     // Catch:{ Throwable -> 0x004d }
            if (r0 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r1 = r2
        L_0x0047:
            java.lang.String r0 = "HttpDns"
            com.loc.cx.a((android.content.Context) r10, (java.lang.String) r0, (int) r1)     // Catch:{ Throwable -> 0x004d }
        L_0x004c:
            return
        L_0x004d:
            r10 = move-exception
            java.lang.String r0 = "DNSManager"
            java.lang.String r1 = "initHttpDns"
            com.loc.cs.a(r10, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cl.<init>(android.content.Context):void");
    }

    public static cl a(Context context) {
        if (c == null) {
            c = new cl(context);
        }
        return c;
    }

    private boolean c() {
        return cr.x() && this.d != null && !e() && cz.b(this.e, "pref", "dns_faile_count_total", 0) < 2;
    }

    private String d() {
        if (!c()) {
            return null;
        }
        try {
            return (String) cv.a(this.d, "getIpByHostAsync", "apilocatesrc.amap.com");
        } catch (Throwable unused) {
            cx.a(this.e, "HttpDns");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e() {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            r3 = 0
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0034 }
            r5 = 14
            if (r4 < r5) goto L_0x000c
            r4 = r1
            goto L_0x000d
        L_0x000c:
            r4 = r0
        L_0x000d:
            if (r4 == 0) goto L_0x0027
            java.lang.String r4 = "http.proxyHost"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch:{ Throwable -> 0x0034 }
            java.lang.String r3 = "http.proxyPort"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch:{ Throwable -> 0x0025 }
            if (r3 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            java.lang.String r3 = "-1"
        L_0x0020:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Throwable -> 0x0025 }
            goto L_0x003c
        L_0x0025:
            r3 = move-exception
            goto L_0x0038
        L_0x0027:
            android.content.Context r4 = r7.e     // Catch:{ Throwable -> 0x0034 }
            java.lang.String r4 = android.net.Proxy.getHost(r4)     // Catch:{ Throwable -> 0x0034 }
            android.content.Context r3 = r7.e     // Catch:{ Throwable -> 0x0025 }
            int r3 = android.net.Proxy.getPort(r3)     // Catch:{ Throwable -> 0x0025 }
            goto L_0x003c
        L_0x0034:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x0038:
            r3.printStackTrace()
            r3 = r2
        L_0x003c:
            if (r4 == 0) goto L_0x0041
            if (r3 == r2) goto L_0x0041
            return r1
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cl.e():boolean");
    }

    public final void a() {
        if (this.g) {
            cz.a(this.e, "pref", "dns_faile_count_total", 0);
        }
    }

    public final void a(co coVar) {
        try {
            this.g = false;
            if (c() && coVar != null) {
                this.a = coVar;
                String c2 = coVar.c();
                if (!c2.substring(0, c2.indexOf(":")).equalsIgnoreCase("https") && !"http://abroad.apilocate.amap.com/mobile/binary".equals(c2)) {
                    String d2 = d();
                    if (this.h && TextUtils.isEmpty(d2)) {
                        this.h = false;
                        d2 = cz.a(this.e, "ip", "last_ip", "");
                    }
                    if (!TextUtils.isEmpty(d2)) {
                        SharedPreferences.Editor edit = this.e.getSharedPreferences("ip", 0).edit();
                        edit.putString("last_ip", d2);
                        cz.a(edit);
                        coVar.g = "http://apilocatesrc.amap.com/mobile/binary".replace("apilocatesrc.amap.com", d2);
                        coVar.b().put("host", "apilocatesrc.amap.com");
                        this.g = true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        try {
            if (c() && this.b <= 5 && this.g) {
                if (this.f == null) {
                    this.f = z.b();
                }
                if (!this.f.isShutdown()) {
                    this.f.submit(new a(this.a));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.loc.cz.a(r8.e, "pref", "dns_faile_count_total", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(com.loc.co r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.String r2 = "http://apilocatesrc.amap.com/mobile/binary"
            r9.g = r2     // Catch:{ Throwable -> 0x003d }
            android.content.Context r2 = r8.e     // Catch:{ Throwable -> 0x003d }
            java.lang.String r3 = "pref"
            java.lang.String r4 = "dns_faile_count_total"
            long r2 = com.loc.cz.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (long) r0)     // Catch:{ Throwable -> 0x003d }
            r4 = 2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0019
            monitor-exit(r8)
            return
        L_0x0019:
            com.loc.bi.a()     // Catch:{ Throwable -> 0x003d }
            r6 = 0
            com.loc.bi.a(r9, r6)     // Catch:{ Throwable -> 0x003d }
            r6 = 1
            long r2 = r2 + r6
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0030
            android.content.Context r9 = r8.e     // Catch:{ Throwable -> 0x003d }
            java.lang.String r4 = "HttpDNS"
            java.lang.String r5 = "dns failed too much"
            com.loc.cy.a(r9, r4, r5)     // Catch:{ Throwable -> 0x003d }
        L_0x0030:
            android.content.Context r9 = r8.e     // Catch:{ Throwable -> 0x003d }
            java.lang.String r4 = "pref"
            java.lang.String r5 = "dns_faile_count_total"
            com.loc.cz.a((android.content.Context) r9, (java.lang.String) r4, (java.lang.String) r5, (long) r2)     // Catch:{ Throwable -> 0x003d }
            monitor-exit(r8)
            return
        L_0x003b:
            r9 = move-exception
            goto L_0x0048
        L_0x003d:
            android.content.Context r9 = r8.e     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "pref"
            java.lang.String r3 = "dns_faile_count_total"
            com.loc.cz.a((android.content.Context) r9, (java.lang.String) r2, (java.lang.String) r3, (long) r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r8)
            return
        L_0x0048:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cl.b(com.loc.co):void");
    }
}
