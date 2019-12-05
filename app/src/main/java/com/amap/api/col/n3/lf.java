package com.amap.api.col.n3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import org.json.JSONObject;

/* compiled from: MapNetLocation */
public final class lf {
    Context a = null;
    boolean b = false;
    String c = null;
    long d = 0;
    WifiInfo e = null;
    boolean f = true;
    int g = 12;
    /* access modifiers changed from: private */
    public lm h = null;
    private ll i = null;
    private a j = null;
    private lo k = null;
    private ConnectivityManager l = null;
    private lq m = null;
    private StringBuilder n = new StringBuilder();
    private Inner_3dMap_locationOption o = null;
    private kx p = null;
    private String q = "00:00:00:00:00:00";

    /* compiled from: MapNetLocation */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(lf lfVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (lf.this.h != null) {
                                lf.this.h.c();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && lf.this.h != null) {
                            lf.this.h.d();
                        }
                    }
                } catch (Throwable th) {
                    lr.a(th, "NetLocation", "onReceive");
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|(1:7)|8|9|(1:11)|12|(1:14)|15|(1:17)|18|(1:20)|21|22|23|(1:25)|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055 A[Catch:{ Throwable -> 0x00cb, Throwable -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073 A[Catch:{ Throwable -> 0x00cb, Throwable -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0080 A[Catch:{ Throwable -> 0x00cb, Throwable -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c A[Catch:{ Throwable -> 0x00cb, Throwable -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[Catch:{ Throwable -> 0x00cb, Throwable -> 0x00d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public lf(android.content.Context r5) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.a = r0
            r4.h = r0
            r4.i = r0
            r4.j = r0
            r4.k = r0
            r4.l = r0
            r4.m = r0
            r1 = 0
            r4.b = r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4.n = r2
            r4.o = r0
            r4.c = r0
            r4.p = r0
            r2 = 0
            r4.d = r2
            r4.e = r0
            r0 = 1
            r4.f = r0
            java.lang.String r2 = "00:00:00:00:00:00"
            r4.q = r2
            r2 = 12
            r4.g = r2
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Throwable -> 0x00d4 }
            r4.a = r5     // Catch:{ Throwable -> 0x00d4 }
            android.content.Context r5 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lu.b((android.content.Context) r5)     // Catch:{ Throwable -> 0x00d4 }
            android.content.Context r5 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            java.lang.String r2 = "android.permission.WRITE_SECURE_SETTINGS"
            int r5 = r5.checkCallingOrSelfPermission(r2)     // Catch:{ Throwable -> 0x004a }
            if (r5 != 0) goto L_0x004a
            r4.b = r0     // Catch:{ Throwable -> 0x004a }
        L_0x004a:
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5 = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption     // Catch:{ Throwable -> 0x00d4 }
            r5.<init>()     // Catch:{ Throwable -> 0x00d4 }
            r4.o = r5     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lm r5 = r4.h     // Catch:{ Throwable -> 0x00d4 }
            if (r5 != 0) goto L_0x006f
            android.content.Context r5 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            java.lang.String r0 = "wifi"
            java.lang.Object r5 = com.amap.api.col.n3.lu.a((android.content.Context) r5, (java.lang.String) r0)     // Catch:{ Throwable -> 0x00d4 }
            android.net.wifi.WifiManager r5 = (android.net.wifi.WifiManager) r5     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lm r0 = new com.amap.api.col.n3.lm     // Catch:{ Throwable -> 0x00d4 }
            android.content.Context r2 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            r0.<init>(r2, r5)     // Catch:{ Throwable -> 0x00d4 }
            r4.h = r0     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lm r5 = r4.h     // Catch:{ Throwable -> 0x00d4 }
            boolean r0 = r4.b     // Catch:{ Throwable -> 0x00d4 }
            r5.a((boolean) r0)     // Catch:{ Throwable -> 0x00d4 }
        L_0x006f:
            com.amap.api.col.n3.ll r5 = r4.i     // Catch:{ Throwable -> 0x00d4 }
            if (r5 != 0) goto L_0x007c
            com.amap.api.col.n3.ll r5 = new com.amap.api.col.n3.ll     // Catch:{ Throwable -> 0x00d4 }
            android.content.Context r0 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            r5.<init>(r0)     // Catch:{ Throwable -> 0x00d4 }
            r4.i = r5     // Catch:{ Throwable -> 0x00d4 }
        L_0x007c:
            com.amap.api.col.n3.lo r5 = r4.k     // Catch:{ Throwable -> 0x00d4 }
            if (r5 != 0) goto L_0x0088
            android.content.Context r5 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lo r5 = com.amap.api.col.n3.lo.a((android.content.Context) r5)     // Catch:{ Throwable -> 0x00d4 }
            r4.k = r5     // Catch:{ Throwable -> 0x00d4 }
        L_0x0088:
            android.net.ConnectivityManager r5 = r4.l     // Catch:{ Throwable -> 0x00d4 }
            if (r5 != 0) goto L_0x0098
            android.content.Context r5 = r4.a     // Catch:{ Throwable -> 0x00d4 }
            java.lang.String r0 = "connectivity"
            java.lang.Object r5 = com.amap.api.col.n3.lu.a((android.content.Context) r5, (java.lang.String) r0)     // Catch:{ Throwable -> 0x00d4 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ Throwable -> 0x00d4 }
            r4.l = r5     // Catch:{ Throwable -> 0x00d4 }
        L_0x0098:
            com.amap.api.col.n3.lq r5 = new com.amap.api.col.n3.lq     // Catch:{ Throwable -> 0x00d4 }
            r5.<init>()     // Catch:{ Throwable -> 0x00d4 }
            r4.m = r5     // Catch:{ Throwable -> 0x00d4 }
            com.amap.api.col.n3.lf$a r5 = r4.j     // Catch:{ Throwable -> 0x00cb }
            if (r5 != 0) goto L_0x00aa
            com.amap.api.col.n3.lf$a r5 = new com.amap.api.col.n3.lf$a     // Catch:{ Throwable -> 0x00cb }
            r5.<init>(r4, r1)     // Catch:{ Throwable -> 0x00cb }
            r4.j = r5     // Catch:{ Throwable -> 0x00cb }
        L_0x00aa:
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ Throwable -> 0x00cb }
            r5.<init>()     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r0 = "android.net.wifi.WIFI_STATE_CHANGED"
            r5.addAction(r0)     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r0 = "android.net.wifi.SCAN_RESULTS"
            r5.addAction(r0)     // Catch:{ Throwable -> 0x00cb }
            android.content.Context r0 = r4.a     // Catch:{ Throwable -> 0x00cb }
            com.amap.api.col.n3.lf$a r2 = r4.j     // Catch:{ Throwable -> 0x00cb }
            r0.registerReceiver(r2, r5)     // Catch:{ Throwable -> 0x00cb }
            com.amap.api.col.n3.lm r5 = r4.h     // Catch:{ Throwable -> 0x00cb }
            r5.b(r1)     // Catch:{ Throwable -> 0x00cb }
            com.amap.api.col.n3.ll r5 = r4.i     // Catch:{ Throwable -> 0x00cb }
            r5.b()     // Catch:{ Throwable -> 0x00cb }
            return
        L_0x00cb:
            r5 = move-exception
            java.lang.String r0 = "NetLocation"
            java.lang.String r1 = "initBroadcastListener"
            com.amap.api.col.n3.lr.a(r5, r0, r1)     // Catch:{ Throwable -> 0x00d4 }
            return
        L_0x00d4:
            r5 = move-exception
            java.lang.String r0 = "NetLocation"
            java.lang.String r1 = "<init>"
            com.amap.api.col.n3.lr.a(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lf.<init>(android.content.Context):void");
    }

    private kx c() throws Exception {
        String str;
        StringBuilder sb;
        kx kxVar = new kx("");
        if (this.h.g()) {
            kxVar.setErrorCode(15);
            return kxVar;
        }
        try {
            if (this.m == null) {
                this.m = new lq();
            }
            this.m.a(this.a, this.o.isNeedAddress(), this.o.isOffset(), this.i, this.h, this.l, this.q, this.c);
            lg lgVar = new lg();
            byte[] bArr = null;
            String str2 = "";
            try {
                try {
                    kl a2 = this.k.a(this.k.a(this.a, this.m.a(), lr.a()));
                    if (a2 != null) {
                        bArr = a2.a;
                        str2 = a2.c;
                    }
                    if (bArr == null || bArr.length == 0) {
                        kxVar.setErrorCode(4);
                        this.n.append("please check the network");
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb2 = this.n;
                            sb2.append(" #csid:" + str2);
                        }
                        kxVar.setLocationDetail(this.n.toString());
                        return kxVar;
                    }
                    String str3 = new String(bArr, "UTF-8");
                    if (str3.contains("\"status\":\"0\"")) {
                        return lgVar.a(str3, this.a, a2);
                    }
                    if (str3.contains("</body></html>")) {
                        kxVar.setErrorCode(5);
                        if (this.h == null || !this.h.a(this.l)) {
                            sb = this.n;
                            str = "request may be intercepted";
                        } else {
                            sb = this.n;
                            str = "make sure you are logged in to the network";
                        }
                        sb.append(str);
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb3 = this.n;
                            sb3.append(" #csid:" + str2);
                        }
                        kxVar.setLocationDetail(this.n.toString());
                        return kxVar;
                    }
                    byte[] a3 = ln.a(bArr);
                    if (a3 == null) {
                        kxVar.setErrorCode(5);
                        this.n.append("decrypt response data error");
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb4 = this.n;
                            sb4.append(" #csid:" + str2);
                        }
                        kxVar.setLocationDetail(this.n.toString());
                        return kxVar;
                    }
                    kx a4 = lgVar.a(a3);
                    if (a4 == null) {
                        kx kxVar2 = new kx("");
                        kxVar2.setErrorCode(5);
                        this.n.append("location is null");
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb5 = this.n;
                            sb5.append(" #csid:" + str2);
                        }
                        kxVar2.setLocationDetail(this.n.toString());
                        return kxVar2;
                    }
                    this.c = a4.a();
                    if (a4.getErrorCode() != 0) {
                        if (!TextUtils.isEmpty(str2)) {
                            a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str2);
                        }
                        return a4;
                    } else if (lh.a(a4)) {
                        JSONObject e2 = a4.e();
                        if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                            if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || GuideControl.CHANGE_PLAY_TYPE_KLHNH.equals(a4.d()) || "24".equals(a4.d()) || "-1".equals(a4.d())) {
                                a4.setLocationType(5);
                            } else {
                                a4.setLocationType(6);
                            }
                            this.n.append(a4.d());
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb6 = this.n;
                                sb6.append(" #csid:" + str2);
                            }
                            a4.setLocationDetail(this.n.toString());
                        }
                        return a4;
                    } else {
                        String b2 = a4.b();
                        a4.setErrorCode(6);
                        StringBuilder sb7 = this.n;
                        StringBuilder sb8 = new StringBuilder("location faile retype:");
                        sb8.append(a4.d());
                        sb8.append(" rdesc:");
                        if (b2 == null) {
                            b2 = "null";
                        }
                        sb8.append(b2);
                        sb7.append(sb8.toString());
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb9 = this.n;
                            sb9.append(" #csid:" + str2);
                        }
                        a4.setLocationDetail(this.n.toString());
                        return a4;
                    }
                } catch (Throwable th) {
                    lr.a(th, "NetLocation", "getApsLoc req");
                    kxVar.setErrorCode(4);
                    this.n.append("please check the network");
                    kxVar.setLocationDetail(this.n.toString());
                    return kxVar;
                }
            } catch (Throwable th2) {
                lr.a(th2, "NetLocation", "getApsLoc buildV4Dot2");
                kxVar.setErrorCode(3);
                StringBuilder sb10 = this.n;
                sb10.append("buildV4Dot2 error " + th2.getMessage());
                kxVar.setLocationDetail(this.n.toString());
                return kxVar;
            }
        } catch (Throwable th3) {
            lr.a(th3, "NetLocation", "getApsLoc");
            StringBuilder sb11 = this.n;
            sb11.append("get parames error:" + th3.getMessage());
            kxVar.setErrorCode(3);
            kxVar.setLocationDetail(this.n.toString());
            return kxVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072 A[SYNTHETIC, Splitter:B:21:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.amap.mapcore.Inner_3dMap_location a() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = r7.n
            int r0 = r0.length()
            r1 = 0
            if (r0 <= 0) goto L_0x0014
            java.lang.StringBuilder r0 = r7.n
            java.lang.StringBuilder r2 = r7.n
            int r2 = r2.length()
            r0.delete(r1, r2)
        L_0x0014:
            long r2 = r7.d
            long r4 = com.amap.api.col.n3.lu.b()
            long r4 = r4 - r2
            r2 = 800(0x320, double:3.953E-321)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r2 = 1
            if (r0 >= 0) goto L_0x003f
            r3 = 0
            com.amap.api.col.n3.kx r0 = r7.p
            boolean r0 = com.amap.api.col.n3.lh.a(r0)
            if (r0 == 0) goto L_0x0037
            long r3 = com.amap.api.col.n3.lu.a()
            com.amap.api.col.n3.kx r0 = r7.p
            long r5 = r0.getTime()
            long r3 = r3 - r5
        L_0x0037:
            r5 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x003f
            r0 = r2
            goto L_0x0040
        L_0x003f:
            r0 = r1
        L_0x0040:
            if (r0 == 0) goto L_0x004d
            com.amap.api.col.n3.kx r0 = r7.p
            boolean r0 = com.amap.api.col.n3.lh.a(r0)
            if (r0 == 0) goto L_0x004d
            com.amap.api.col.n3.kx r0 = r7.p
            return r0
        L_0x004d:
            long r3 = com.amap.api.col.n3.lu.b()
            r7.d = r3
            android.content.Context r0 = r7.a
            if (r0 != 0) goto L_0x0072
            java.lang.StringBuilder r0 = r7.n
            java.lang.String r1 = "context is null"
            r0.append(r1)
            com.autonavi.amap.mapcore.Inner_3dMap_location r0 = new com.autonavi.amap.mapcore.Inner_3dMap_location
            java.lang.String r1 = ""
            r0.<init>((java.lang.String) r1)
            r0.setErrorCode(r2)
            java.lang.StringBuilder r1 = r7.n
            java.lang.String r1 = r1.toString()
            r0.setLocationDetail(r1)
            return r0
        L_0x0072:
            com.amap.api.col.n3.ll r0 = r7.i     // Catch:{ Throwable -> 0x0078 }
            r0.b()     // Catch:{ Throwable -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r0 = move-exception
            java.lang.String r3 = "NetLocation"
            java.lang.String r4 = "getLocation getCgiListParam"
            com.amap.api.col.n3.lr.a(r0, r3, r4)
        L_0x0080:
            com.amap.api.col.n3.lm r0 = r7.h     // Catch:{ Throwable -> 0x0086 }
            r0.b(r2)     // Catch:{ Throwable -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r0 = move-exception
            java.lang.String r2 = "NetLocation"
            java.lang.String r3 = "getLocation getScanResultsParam"
            com.amap.api.col.n3.lr.a(r0, r2, r3)
        L_0x008e:
            com.amap.api.col.n3.kx r0 = r7.c()     // Catch:{ Throwable -> 0x00c7 }
            r7.p = r0     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.kx r0 = r7.p     // Catch:{ Throwable -> 0x00c7 }
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ Throwable -> 0x00c7 }
            int r3 = r2.length     // Catch:{ Throwable -> 0x00c7 }
            if (r3 != 0) goto L_0x00a4
            com.amap.api.col.n3.la r1 = com.amap.api.col.n3.la.a()     // Catch:{ Throwable -> 0x00c7 }
        L_0x009f:
            com.amap.api.col.n3.kx r0 = r1.a(r0)     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x00c4
        L_0x00a4:
            r3 = r2[r1]     // Catch:{ Throwable -> 0x00c7 }
            java.lang.String r4 = "shake"
            boolean r3 = r3.equals(r4)     // Catch:{ Throwable -> 0x00c7 }
            if (r3 == 0) goto L_0x00b3
            com.amap.api.col.n3.la r1 = com.amap.api.col.n3.la.a()     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x009f
        L_0x00b3:
            r1 = r2[r1]     // Catch:{ Throwable -> 0x00c7 }
            java.lang.String r2 = "fusion"
            boolean r1 = r1.equals(r2)     // Catch:{ Throwable -> 0x00c7 }
            if (r1 == 0) goto L_0x00c4
            com.amap.api.col.n3.la.a()     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.kx r0 = com.amap.api.col.n3.la.b(r0)     // Catch:{ Throwable -> 0x00c7 }
        L_0x00c4:
            r7.p = r0     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x00cf
        L_0x00c7:
            r0 = move-exception
            java.lang.String r1 = "NetLocation"
            java.lang.String r2 = "getLocation getScanResultsParam"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
        L_0x00cf:
            com.amap.api.col.n3.kx r0 = r7.p
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lf.a():com.autonavi.amap.mapcore.Inner_3dMap_location");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5) {
        /*
            r4 = this;
            r4.o = r5
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5 = r4.o
            if (r5 != 0) goto L_0x000d
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5 = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption
            r5.<init>()
            r4.o = r5
        L_0x000d:
            com.amap.api.col.n3.lm r5 = r4.h     // Catch:{ Throwable -> 0x001d }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.o     // Catch:{ Throwable -> 0x001d }
            r0.isWifiActiveScan()     // Catch:{ Throwable -> 0x001d }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.o     // Catch:{ Throwable -> 0x001d }
            boolean r0 = r0.isWifiScan()     // Catch:{ Throwable -> 0x001d }
            r5.c(r0)     // Catch:{ Throwable -> 0x001d }
        L_0x001d:
            com.amap.api.col.n3.lo r5 = r4.k     // Catch:{ Throwable -> 0x0034 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.o     // Catch:{ Throwable -> 0x0034 }
            long r0 = r0.getHttpTimeOut()     // Catch:{ Throwable -> 0x0034 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r2 = r4.o     // Catch:{ Throwable -> 0x0034 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationProtocol r2 = r2.getLocationProtocol()     // Catch:{ Throwable -> 0x0034 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationProtocol r3 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS     // Catch:{ Throwable -> 0x0034 }
            boolean r2 = r2.equals(r3)     // Catch:{ Throwable -> 0x0034 }
            r5.a(r0, r2)     // Catch:{ Throwable -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lf.a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption):void");
    }

    public final void b() {
        this.b = false;
        this.c = null;
        try {
            if (!(this.a == null || this.j == null)) {
                this.a.unregisterReceiver(this.j);
            }
            if (this.i != null) {
                this.i.c();
            }
            if (this.h != null) {
                this.h.h();
            }
        } catch (Throwable unused) {
        } finally {
            this.j = null;
        }
    }
}
