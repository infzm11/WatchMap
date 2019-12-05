package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LastLocationManager */
public final class h {
    static cj b;
    static long g;
    String a = null;
    cj c = null;
    cj d = null;
    af e = null;
    long f = 0;
    boolean h = false;
    private Context i;

    public h(Context context) {
        this.i = context.getApplicationContext();
    }

    private void e() {
        if (b == null || da.b() - g > 180000) {
            cj f2 = f();
            g = da.b();
            if (f2 != null && da.a(f2.a())) {
                b = f2;
            }
        }
    }

    private cj f() {
        cj cjVar;
        Throwable th;
        String str;
        byte[] b2;
        byte[] d2;
        String str2 = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
            if (this.e == null) {
                return null;
            }
            List<cj> b3 = this.e.b("_id=1", cj.class);
            if (b3 == null || b3.size() <= 0) {
                cjVar = null;
            } else {
                cjVar = b3.get(0);
                try {
                    byte[] b4 = o.b(cjVar.c());
                    if (b4 != null && b4.length > 0) {
                        byte[] d3 = ch.d(b4, this.a);
                        if (d3 != null && d3.length > 0) {
                            str = new String(d3, "UTF-8");
                            b2 = o.b(cjVar.b());
                            if (b2 != null && b2.length > 0) {
                                d2 = ch.d(b2, this.a);
                                if (d2 != null && d2.length > 0) {
                                    str2 = new String(d2, "UTF-8");
                                }
                            }
                            cjVar.a(str2);
                            str2 = str;
                        }
                    }
                    str = null;
                    b2 = o.b(cjVar.b());
                    d2 = ch.d(b2, this.a);
                    str2 = new String(d2, "UTF-8");
                    cjVar.a(str2);
                    str2 = str;
                } catch (Throwable th2) {
                    th = th2;
                    cs.a(th, "LastLocationManager", "readLastFix");
                    return cjVar;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                AMapLocation aMapLocation = new AMapLocation("");
                cs.a(aMapLocation, new JSONObject(str2));
                if (da.b(aMapLocation)) {
                    cjVar.a(aMapLocation);
                    return cjVar;
                }
            }
            return cjVar;
        } catch (Throwable th3) {
            th = th3;
            cjVar = null;
            cs.a(th, "LastLocationManager", "readLastFix");
            return cjVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (com.loc.da.a(b.b(), r9) != false) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054 A[Catch:{ Throwable -> 0x0071 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r8, java.lang.String r9, long r10) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return r8
        L_0x0003:
            int r0 = r8.getErrorCode()
            if (r0 == 0) goto L_0x0079
            int r0 = r8.getLocationType()
            r1 = 1
            if (r0 == r1) goto L_0x0079
            int r0 = r8.getErrorCode()
            r2 = 7
            if (r0 != r2) goto L_0x0018
            return r8
        L_0x0018:
            r7.e()     // Catch:{ Throwable -> 0x0071 }
            com.loc.cj r0 = b     // Catch:{ Throwable -> 0x0071 }
            if (r0 == 0) goto L_0x0070
            com.loc.cj r0 = b     // Catch:{ Throwable -> 0x0071 }
            com.amap.api.location.AMapLocation r0 = r0.a()     // Catch:{ Throwable -> 0x0071 }
            if (r0 != 0) goto L_0x0028
            return r8
        L_0x0028:
            r0 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x0071 }
            if (r2 == 0) goto L_0x0045
            long r2 = com.loc.da.b()     // Catch:{ Throwable -> 0x0071 }
            com.loc.cj r9 = b     // Catch:{ Throwable -> 0x0071 }
            long r4 = r9.d()     // Catch:{ Throwable -> 0x0071 }
            long r2 = r2 - r4
            r4 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0052
            int r9 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r9 > 0) goto L_0x0052
            goto L_0x0051
        L_0x0045:
            com.loc.cj r10 = b     // Catch:{ Throwable -> 0x0071 }
            java.lang.String r10 = r10.b()     // Catch:{ Throwable -> 0x0071 }
            boolean r9 = com.loc.da.a((java.lang.String) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0071 }
            if (r9 == 0) goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            if (r0 == 0) goto L_0x0079
            com.loc.cj r9 = b     // Catch:{ Throwable -> 0x0071 }
            com.amap.api.location.AMapLocation r9 = r9.a()     // Catch:{ Throwable -> 0x0071 }
            r10 = 9
            r9.setLocationType(r10)     // Catch:{ Throwable -> 0x006b }
            r9.setFixLastLocation(r1)     // Catch:{ Throwable -> 0x006b }
            java.lang.String r8 = r8.getLocationDetail()     // Catch:{ Throwable -> 0x006b }
            r9.setLocationDetail(r8)     // Catch:{ Throwable -> 0x006b }
            r8 = r9
            return r8
        L_0x006b:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x0072
        L_0x0070:
            return r8
        L_0x0071:
            r9 = move-exception
        L_0x0072:
            java.lang.String r10 = "LastLocationManager"
            java.lang.String r11 = "fixLastLocation"
            com.loc.cs.a(r9, r10, r11)
        L_0x0079:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.h.a(com.amap.api.location.AMapLocation, java.lang.String, long):com.amap.api.location.AMapLocation");
    }

    public final void a() {
        if (!this.h) {
            try {
                if (this.a == null) {
                    this.a = ch.a("MD5", n.r(this.i));
                }
                if (this.e == null) {
                    this.e = new af(this.i, af.a((Class<? extends ae>) ck.class), da.i());
                }
            } catch (Throwable th) {
                cs.a(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.h = true;
        }
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.i == null || aMapLocation == null || !da.a(aMapLocation) || aMapLocation.getLocationType() == 2 || aMapLocation.isMock() || aMapLocation.isFixLastLocation()) {
            return false;
        }
        cj cjVar = new cj();
        cjVar.a(aMapLocation);
        if (aMapLocation.getLocationType() == 1) {
            cjVar.a((String) null);
        } else {
            cjVar.a(str);
        }
        try {
            b = cjVar;
            g = da.b();
            this.c = cjVar;
            return (this.d == null || da.a(this.d.a(), cjVar.a()) > 500.0f) && da.b() - this.f > 30000;
        } catch (Throwable th) {
            cs.a(th, "LastLocationManager", "setLastFix");
        }
    }

    public final AMapLocation b() {
        e();
        if (b != null && da.a(b.a())) {
            return b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f = 0;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            cs.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        String str;
        try {
            a();
            if (this.c != null && da.a(this.c.a()) && this.e != null && this.c != this.d && this.c.d() == 0) {
                String str2 = this.c.a().toStr();
                String b2 = this.c.b();
                this.d = this.c;
                String str3 = null;
                if (!TextUtils.isEmpty(str2)) {
                    str = o.a(ch.c(str2.getBytes("UTF-8"), this.a));
                    if (!TextUtils.isEmpty(b2)) {
                        str3 = o.a(ch.c(b2.getBytes("UTF-8"), this.a));
                    }
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    cj cjVar = new cj();
                    cjVar.b(str);
                    cjVar.a(da.b());
                    cjVar.a(str3);
                    this.e.a((Object) cjVar, "_id=1");
                    this.f = da.b();
                    if (b != null) {
                        b.a(da.b());
                    }
                }
            }
        } catch (Throwable th) {
            cs.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
