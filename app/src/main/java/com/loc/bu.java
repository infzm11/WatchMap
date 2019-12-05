package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.iflytek.cloud.util.AudioDetector;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: APS */
public final class bu {
    static int F = -1;
    private static boolean N = false;
    private static int P = -1;
    boolean A = false;
    public boolean B = false;
    int C = 12;
    by D = null;
    boolean E = false;
    bx G = null;
    String H = null;
    LocationManager I = null;
    Handler J = new Handler() {
    };
    IntentFilter K = null;
    private int L = 0;
    private String M = null;
    private String O = null;
    private boolean Q = true;
    Context a = null;
    ConnectivityManager b = null;
    cg c = null;
    cd d = null;
    cf e = null;
    ce f = null;
    ci g = null;
    bv h = null;
    ca i = null;
    ArrayList<ScanResult> j = new ArrayList<>();
    a k = null;
    AMapLocationClientOption l = new AMapLocationClientOption();
    AMapLocationServer m = null;
    long n = 0;
    String o = "00:00:00:00:00:00";
    cq p = null;
    boolean q = false;
    cn r = null;
    StringBuilder s = new StringBuilder();
    boolean t = true;
    boolean u = true;
    boolean v = true;
    boolean w = false;
    WifiInfo x = null;
    boolean y = true;
    StringBuilder z = null;

    /* compiled from: APS */
    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (bu.this.c != null) {
                                bu.this.c.d();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            if (bu.this.c != null) {
                                bu.this.c.e();
                            }
                        } else if (action.equals("android.intent.action.SCREEN_ON")) {
                            if (bu.this.f != null) {
                                bu.this.f.a(true);
                            }
                        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                            if (bu.this.f != null) {
                                bu.this.f.a(false);
                                bu.this.f.c();
                            }
                        } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") && bu.this.f != null) {
                            bu.this.f.d();
                        }
                    }
                } catch (Throwable th) {
                    cs.a(th, "APS", "onReceive");
                }
            }
        }
    }

    private static AMapLocationServer a(int i2, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i2);
        aMapLocationServer.setLocationDetail(str);
        if (i2 == 15) {
            cx.a((String) null, 2151);
        }
        return aMapLocationServer;
    }

    private AMapLocationServer a(AMapLocationServer aMapLocationServer, bo boVar) {
        if (boVar != null) {
            try {
                if (boVar.a != null) {
                    if (boVar.a.length != 0) {
                        cp cpVar = new cp();
                        String str = new String(boVar.a, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            AMapLocationServer a2 = cpVar.a(str, this.a, boVar);
                            try {
                                a2.g(this.z.toString());
                                return a2;
                            } catch (Throwable th) {
                                AMapLocationServer aMapLocationServer2 = a2;
                                th = th;
                                aMapLocationServer = aMapLocationServer2;
                                aMapLocationServer.setErrorCode(4);
                                cs.a(th, "APS", "checkResponseEntity");
                                StringBuilder sb = this.s;
                                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                                aMapLocationServer.setLocationDetail(this.s.toString());
                                return aMapLocationServer;
                            }
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            aMapLocationServer.setErrorCode(5);
                            if (this.c == null || !this.c.a(this.b)) {
                                this.s.append("请求可能被劫持了#0502");
                                cx.a((String) null, (int) GLMapStaticValue.AM_PARAMETERNAME_MAP_TEXTSCALE);
                            } else {
                                this.s.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                cx.a((String) null, (int) GLMapStaticValue.AM_PARAMETERNAME_MAP_VALUE);
                            }
                            aMapLocationServer.setLocationDetail(this.s.toString());
                            return aMapLocationServer;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aMapLocationServer.setErrorCode(4);
                cs.a(th, "APS", "checkResponseEntity");
                StringBuilder sb2 = this.s;
                sb2.append("check response exception ex is" + th.getMessage() + "#0403");
                aMapLocationServer.setLocationDetail(this.s.toString());
                return aMapLocationServer;
            }
        }
        aMapLocationServer.setErrorCode(4);
        this.s.append("网络异常,请求异常#0403");
        aMapLocationServer.g(this.z.toString());
        aMapLocationServer.setLocationDetail(this.s.toString());
        if (boVar != null) {
            cx.a(boVar.d, 2041);
        }
        return aMapLocationServer;
    }

    @SuppressLint({"NewApi"})
    private AMapLocationServer a(boolean z2, boolean z3) {
        int i2;
        StringBuilder sb;
        String str;
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        cp cpVar = new cp();
        try {
            if (this.p == null) {
                this.p = new cq();
            }
            if (this.l == null) {
                this.l = new AMapLocationClientOption();
            }
            this.p.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.d, this.c, this.b, this.i, this.o, this.f.f(), this.H);
            this.e.a(this.d);
            byte[] a2 = this.p.a();
            this.n = da.b();
            try {
                cs.d(this.a);
                co a3 = this.r.a(this.a, a2, cs.a(), z3);
                cl.a(this.a).a(a3);
                bo a4 = this.r.a(a3);
                String str2 = "";
                if (a4 != null) {
                    cl.a(this.a).a();
                    aMapLocationServer.a((long) this.r.a());
                    if (!TextUtils.isEmpty(a4.c)) {
                        StringBuilder sb2 = this.s;
                        sb2.append("#csid:" + a4.c);
                    }
                    str2 = a4.d;
                    aMapLocationServer.g(this.z.toString());
                }
                if (!z2) {
                    AMapLocationServer a5 = a(aMapLocationServer, a4);
                    if (a5 != null) {
                        return a5;
                    }
                    byte[] a6 = ch.a(a4.a);
                    if (a6 == null) {
                        aMapLocationServer.setErrorCode(5);
                        this.s.append("解密数据失败#0503");
                        aMapLocationServer.setLocationDetail(this.s.toString());
                        cx.a(str2, (int) GLMapStaticValue.AM_PARAMETERNAME_RESTORED_MAPMODESTATE);
                        return aMapLocationServer;
                    }
                    aMapLocationServer = cpVar.a(aMapLocationServer, a6);
                    if (!da.a(aMapLocationServer)) {
                        this.M = aMapLocationServer.b();
                        cx.a(str2, !TextUtils.isEmpty(this.M) ? 2062 : 2061);
                        aMapLocationServer.setErrorCode(6);
                        StringBuilder sb3 = this.s;
                        StringBuilder sb4 = new StringBuilder("location faile retype:");
                        sb4.append(aMapLocationServer.d());
                        sb4.append(" rdesc:");
                        sb4.append(TextUtils.isEmpty(this.M) ? "" : this.M);
                        sb4.append("#0601");
                        sb3.append(sb4.toString());
                        aMapLocationServer.g(this.z.toString());
                        aMapLocationServer.setLocationDetail(this.s.toString());
                        return aMapLocationServer;
                    }
                    if (this.i != null) {
                        ca caVar = this.i;
                        String d2 = aMapLocationServer.d();
                        float accuracy = aMapLocationServer.getAccuracy();
                        try {
                            if (!"-1".equals(d2) || accuracy > 5.0f) {
                                caVar.a();
                            } else {
                                caVar.b();
                            }
                        } catch (Throwable th) {
                            cs.a(th, "BeaconManager", "checkLocationType");
                        }
                    }
                    if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
                        if ("-5".equals(aMapLocationServer.d()) || "1".equals(aMapLocationServer.d()) || "2".equals(aMapLocationServer.d()) || GuideControl.CHANGE_PLAY_TYPE_KLHNH.equals(aMapLocationServer.d()) || "24".equals(aMapLocationServer.d()) || "-1".equals(aMapLocationServer.d())) {
                            aMapLocationServer.setLocationType(5);
                        } else {
                            aMapLocationServer.setLocationType(6);
                        }
                    }
                    aMapLocationServer.setOffset(this.u);
                    aMapLocationServer.a(this.t);
                }
                aMapLocationServer.e("new");
                aMapLocationServer.setLocationDetail(this.s.toString());
                this.H = aMapLocationServer.a();
                return aMapLocationServer;
            } catch (Throwable th2) {
                cl.a(this.a).b();
                cs.a(th2, "APS", "getApsLoc req");
                cx.a("/mobile/binary", th2);
                if (!da.d(this.a)) {
                    sb = this.s;
                    str = "网络异常，未连接到网络，请连接网络#0401";
                } else {
                    if (th2 instanceof j) {
                        j jVar = (j) th2;
                        if (jVar.a().contains("网络异常状态码")) {
                            StringBuilder sb5 = this.s;
                            sb5.append("网络异常，状态码错误#0404");
                            sb5.append(jVar.e());
                            i2 = 4;
                            AMapLocationServer a7 = a(i2, this.s.toString());
                            a7.g(this.z.toString());
                            return a7;
                        } else if (jVar.e() == 23 || Math.abs((da.b() - this.n) - this.l.getHttpTimeOut()) < 500) {
                            sb = this.s;
                            str = "网络异常，连接超时#0402";
                        }
                    }
                    sb = this.s;
                    str = "网络异常,请求异常#0403";
                }
                sb.append(str);
                i2 = 4;
                AMapLocationServer a72 = a(i2, this.s.toString());
                a72.g(this.z.toString());
                return a72;
            }
        } catch (Throwable th3) {
            StringBuilder sb6 = this.s;
            sb6.append("get parames error:" + th3.getMessage() + "#0301");
            cx.a((String) null, 2031);
            i2 = 3;
            AMapLocationServer a722 = a(i2, this.s.toString());
            a722.g(this.z.toString());
            return a722;
        }
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(AudioDetector.DEF_EOS);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.k());
        sb.append(this.c.i());
        return sb;
    }

    public static void b(Context context) {
        try {
            if (P == -1 || cr.h(context)) {
                P = 1;
                cr.a(context);
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "initAuth");
        }
    }

    private void b(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            this.m = aMapLocationServer;
        }
        if (this.e != null) {
            if (aMapLocationServer != null) {
                this.e.a(aMapLocationServer.toJson(1));
            }
            this.e.c();
        }
    }

    private void l() {
        try {
            if (this.k == null) {
                this.k = new a();
            }
            if (this.K == null) {
                this.K = new IntentFilter();
                this.K.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.K.addAction("android.net.wifi.SCAN_RESULTS");
                this.K.addAction("android.intent.action.SCREEN_ON");
                this.K.addAction("android.intent.action.SCREEN_OFF");
                this.K.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.registerReceiver(this.k, this.K, (String) null, this.J);
        } catch (Throwable th) {
            cs.a(th, "APS", "initBroadcastListener");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02a9, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02b1, code lost:
        if (r0.startsWith("#") != false) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02b3, code lost:
        r0 = "#" + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return com.loc.da.h() + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x019e, code lost:
        if (r11.y == false) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e2, code lost:
        if (r11.y == false) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01e5, code lost:
        r1 = "cgi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01e8, code lost:
        r1 = "cgiwifi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ea, code lost:
        r0.append(r1);
        r0 = r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m() {
        /*
            r11 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "network"
            com.loc.cd r2 = r11.d
            int r2 = r2.e()
            com.loc.cd r3 = r11.d
            com.loc.cc r3 = r3.c()
            r4 = 0
            if (r3 != 0) goto L_0x012c
            java.util.ArrayList<android.net.wifi.ScanResult> r5 = r11.j
            if (r5 == 0) goto L_0x001f
            java.util.ArrayList<android.net.wifi.ScanResult> r5 = r11.j
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x012c
        L_0x001f:
            android.net.ConnectivityManager r1 = r11.b
            if (r1 != 0) goto L_0x002f
            android.content.Context r1 = r11.a
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = com.loc.da.a((android.content.Context) r1, (java.lang.String) r2)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            r11.b = r1
        L_0x002f:
            android.content.Context r1 = r11.a
            boolean r1 = com.loc.da.f(r1)
            r2 = 2121(0x849, float:2.972E-42)
            r3 = 12
            if (r1 != 0) goto L_0x0048
            r11.C = r3
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "定位权限被禁用,请授予应用定位权限#1201"
            r1.append(r3)
            com.loc.cx.a((java.lang.String) r4, (int) r2)
            return r0
        L_0x0048:
            com.loc.cd r1 = r11.d
            java.lang.String r1 = r1.i()
            com.loc.cg r5 = r11.c
            java.lang.String r5 = r5.a()
            com.loc.cg r6 = r11.c
            android.net.ConnectivityManager r7 = r11.b
            boolean r6 = r6.a((android.net.ConnectivityManager) r7)
            if (r6 != 0) goto L_0x0117
            com.loc.cg r6 = r11.c
            boolean r6 = r6.l()
            if (r6 != 0) goto L_0x0117
            if (r5 == 0) goto L_0x006a
            goto L_0x0117
        L_0x006a:
            if (r1 == 0) goto L_0x0087
            r11.C = r3
            com.loc.cg r1 = r11.c
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x007e
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204"
        L_0x007a:
            r1.append(r3)
            goto L_0x0083
        L_0x007e:
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205"
            goto L_0x007a
        L_0x0083:
            com.loc.cx.a((java.lang.String) r4, (int) r2)
            return r0
        L_0x0087:
            int r1 = com.loc.da.c()
            r5 = 24
            if (r1 < r5) goto L_0x00b6
            android.location.LocationManager r1 = r11.I
            if (r1 != 0) goto L_0x009f
            android.content.Context r1 = r11.a
            java.lang.String r5 = "location"
            java.lang.Object r1 = com.loc.da.a((android.content.Context) r1, (java.lang.String) r5)
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            r11.I = r1
        L_0x009f:
            android.location.LocationManager r1 = r11.I
            java.lang.String r5 = "gps"
            boolean r1 = r1.isProviderEnabled(r5)
            if (r1 != 0) goto L_0x00b6
            r11.C = r3
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "设置中GPS开关未打开，请在设置中打开GPS定位开关#1206"
            r1.append(r3)
            com.loc.cx.a((java.lang.String) r4, (int) r2)
            return r0
        L_0x00b6:
            android.content.Context r1 = r11.a
            boolean r1 = com.loc.da.a((android.content.Context) r1)
            if (r1 == 0) goto L_0x00d7
            com.loc.cg r1 = r11.c
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x00d7
            r1 = 18
            r11.C = r1
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801"
            r1.append(r2)
            r1 = 2132(0x854, float:2.988E-42)
            com.loc.cx.a((java.lang.String) r4, (int) r1)
            return r0
        L_0x00d7:
            com.loc.cg r1 = r11.c
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x00f8
            com.loc.cd r1 = r11.d
            boolean r1 = r1.l()
            if (r1 != 0) goto L_0x00f8
            r1 = 19
            r11.C = r1
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901"
            r1.append(r2)
            r1 = 2133(0x855, float:2.989E-42)
            com.loc.cx.a((java.lang.String) r4, (int) r1)
            return r0
        L_0x00f8:
            com.loc.cg r1 = r11.c
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0108
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关在发起定位#1301"
        L_0x0104:
            r1.append(r2)
            goto L_0x010d
        L_0x0108:
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "获取到的基站与WIFI为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302"
            goto L_0x0104
        L_0x010d:
            r1 = 13
            r11.C = r1
            r1 = 2131(0x853, float:2.986E-42)
            com.loc.cx.a((java.lang.String) r4, (int) r1)
            return r0
        L_0x0117:
            r11.C = r3
            if (r1 == 0) goto L_0x0123
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202"
        L_0x011f:
            r1.append(r3)
            goto L_0x0128
        L_0x0123:
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r3 = "获取到的基站为空，并且获取WIFI权限被禁用,请在安全软件中打开应用的定位权限#1203"
            goto L_0x011f
        L_0x0128:
            com.loc.cx.a((java.lang.String) r4, (int) r2)
            return r0
        L_0x012c:
            com.loc.cg r5 = r11.c
            android.net.wifi.WifiInfo r5 = r5.g()
            r11.x = r5
            com.loc.cg r5 = r11.c
            android.net.wifi.WifiInfo r5 = r11.x
            boolean r5 = com.loc.cg.a((android.net.wifi.WifiInfo) r5)
            r11.y = r5
            switch(r2) {
                case 0: goto L_0x01f3;
                case 1: goto L_0x01a1;
                case 2: goto L_0x0153;
                default: goto L_0x0141;
            }
        L_0x0141:
            r1 = 11
            r11.C = r1
            r1 = 2111(0x83f, float:2.958E-42)
            com.loc.cx.a((java.lang.String) r4, (int) r1)
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "get cgi failure#1101"
            r1.append(r2)
            goto L_0x02a5
        L_0x0153:
            if (r3 == 0) goto L_0x02a5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r3.a
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.b
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.g
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.h
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.i
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "#"
            r0.append(r1)
            java.util.ArrayList<android.net.wifi.ScanResult> r1 = r11.j
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x01e8
            boolean r1 = r11.y
            if (r1 == 0) goto L_0x01e5
            goto L_0x01e8
        L_0x01a1:
            if (r3 == 0) goto L_0x02a5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r3.a
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.b
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.c
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.d
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "#"
            r0.append(r1)
            java.util.ArrayList<android.net.wifi.ScanResult> r1 = r11.j
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x01e8
            boolean r1 = r11.y
            if (r1 == 0) goto L_0x01e5
            goto L_0x01e8
        L_0x01e5:
            java.lang.String r1 = "cgi"
            goto L_0x01ea
        L_0x01e8:
            java.lang.String r1 = "cgiwifi"
        L_0x01ea:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x02a5
        L_0x01f3:
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r11.j
            boolean r2 = r2.isEmpty()
            r3 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0204
            boolean r2 = r11.y
            if (r2 == 0) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r2 = r5
            goto L_0x0205
        L_0x0204:
            r2 = r3
        L_0x0205:
            boolean r6 = r11.y
            r7 = 2021(0x7e5, float:2.832E-42)
            r8 = 2
            if (r6 == 0) goto L_0x0221
            java.util.ArrayList<android.net.wifi.ScanResult> r6 = r11.j
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0221
            r11.C = r8
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201"
            r1.append(r2)
            com.loc.cx.a((java.lang.String) r4, (int) r7)
            return r0
        L_0x0221:
            java.util.ArrayList<android.net.wifi.ScanResult> r6 = r11.j
            int r6 = r6.size()
            r9 = 2022(0x7e6, float:2.833E-42)
            if (r6 != r3) goto L_0x0261
            r11.C = r8
            boolean r6 = r11.y
            if (r6 != 0) goto L_0x023c
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202"
            r1.append(r2)
            com.loc.cx.a((java.lang.String) r4, (int) r9)
            return r0
        L_0x023c:
            java.util.ArrayList<android.net.wifi.ScanResult> r6 = r11.j
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            java.lang.String r6 = r6.BSSID
            com.loc.cg r10 = r11.c
            android.net.wifi.WifiInfo r10 = r10.g()
            java.lang.String r10 = r10.getBSSID()
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x0261
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202"
            r1.append(r2)
            com.loc.cx.a((java.lang.String) r4, (int) r7)
            return r0
        L_0x0261:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r6 = "#%s#"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r1
            java.lang.String r0 = java.lang.String.format(r0, r6, r3)
            if (r2 == 0) goto L_0x0281
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "wifi"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x02a5
        L_0x0281:
            java.lang.String r2 = "network"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02a5
            java.lang.String r0 = ""
            r11.C = r8
            com.loc.cg r1 = r11.c
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x029d
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203"
        L_0x0299:
            r1.append(r2)
            goto L_0x02a2
        L_0x029d:
            java.lang.StringBuilder r1 = r11.s
            java.lang.String r2 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204"
            goto L_0x0299
        L_0x02a2:
            com.loc.cx.a((java.lang.String) r4, (int) r9)
        L_0x02a5:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x02d4
            java.lang.String r1 = "#"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x02c1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "#"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x02c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.loc.da.h()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x02d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bu.m():java.lang.String");
    }

    private boolean n() {
        this.j = this.c.b();
        return this.j == null || this.j.size() <= 0;
    }

    public final AMapLocationServer a(double d2, double d3) {
        try {
            String a2 = this.r.a(("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8"), this.a, "http://restapi.amap.com/v3/geocode/regeo");
            new cp();
            if (!a2.contains("\"status\":\"1\"")) {
                return null;
            }
            AMapLocationServer a3 = cp.a(a2);
            a3.setLatitude(d2);
            a3.setLongitude(d3);
            return a3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AMapLocationServer a(AMapLocationServer aMapLocationServer, String... strArr) {
        this.G.a(this.v);
        if (strArr == null || strArr.length == 0 || strArr[0].equals("shake")) {
            return this.G.a(aMapLocationServer);
        }
        if (strArr[0].equals("fusion")) {
            bx bxVar = this.G;
        }
        return aMapLocationServer;
    }

    public final AMapLocationServer a(boolean z2) {
        if (this.a == null) {
            this.s.append("context is null#0101");
            cx.a((String) null, 2011);
            return a(1, this.s.toString());
        } else if (this.c.h()) {
            return a(15, "networkLocation has been mocked!#1502");
        } else {
            a();
            if (TextUtils.isEmpty(this.O)) {
                return a(this.C, this.s.toString());
            }
            AMapLocationServer a2 = a(false, z2);
            if (da.a(a2)) {
                this.g.a(this.z.toString());
                this.g.a(this.d.c());
                b(a2);
                return a2;
            }
            String sb = this.z.toString();
            this.e.a(this.a);
            cf cfVar = this.e;
            ci ciVar = this.g;
            String str = this.O;
            AMapLocationClientOption aMapLocationClientOption = this.l;
            Context context = this.a;
            return cfVar.a(ciVar, str, sb, aMapLocationClientOption, m(), a2);
        }
    }

    public final void a() {
        this.r = cn.a(this.a);
        if (this.r != null) {
            try {
                this.r.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS));
            } catch (Throwable unused) {
            }
        }
        if (this.b == null) {
            this.b = (ConnectivityManager) da.a(this.a, "connectivity");
        }
        if (this.p == null) {
            this.p = new cq();
        }
    }

    public final void a(Context context) {
        try {
            if (this.a == null) {
                this.G = new bx();
                this.a = context.getApplicationContext();
                cr.e(this.a);
                da.b(this.a);
                if (this.c == null) {
                    this.c = new cg(this.a, (WifiManager) da.a(this.a, "wifi"));
                }
                if (this.d == null) {
                    this.d = new cd(this.a);
                }
                if (this.e == null) {
                    this.e = new cf();
                }
                if (this.f == null) {
                    this.f = new ce();
                }
                if (this.g == null) {
                    this.g = new ci();
                }
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "initBase");
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.l = aMapLocationClientOption;
        if (this.l == null) {
            this.l = new AMapLocationClientOption();
        }
        if (this.c != null) {
            cg cgVar = this.c;
            this.l.isWifiActiveScan();
            cgVar.a(this.l.isWifiScan(), this.l.isMockEnable());
        }
        if (this.r != null) {
            this.r.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS));
        }
        if (this.g != null) {
            this.g.a(this.l);
        }
        try {
            z4 = this.l.isNeedAddress();
            try {
                z3 = this.l.isOffset();
                try {
                    z2 = this.l.isLocationCacheEnable();
                    try {
                        this.w = this.l.isOnceLocationLatest();
                        this.E = this.l.isSensorEnable();
                        if (!(z3 == this.u && z4 == this.t && z2 == this.v)) {
                            if (this.g != null) {
                                this.g.a();
                            }
                            b((AMapLocationServer) null);
                            this.Q = false;
                            if (this.G != null) {
                                this.G.a();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    z2 = true;
                }
            } catch (Throwable unused3) {
                z3 = true;
                z2 = z3;
                this.u = z3;
                this.t = z4;
                this.v = z2;
            }
        } catch (Throwable unused4) {
            z4 = true;
            z3 = true;
            z2 = z3;
            this.u = z3;
            this.t = z4;
            this.v = z2;
        }
        this.u = z3;
        this.t = z4;
        this.v = z2;
    }

    public final void a(AMapLocationServer aMapLocationServer) {
        if (da.a(aMapLocationServer)) {
            this.g.a(this.O, this.z, aMapLocationServer, this.a, true);
        }
    }

    public final void b() {
        if (this.i == null) {
            this.i = new ca(this.a);
        }
        if (this.D == null) {
            this.D = new by(this.a);
        }
        if (this.h == null) {
            this.h = new bv(this.a);
        }
        this.e.a(this.a);
        l();
        this.c.b(false);
        this.j = this.c.b();
        this.d.a(false, n());
        this.g.a(this.a);
        this.h.b();
        try {
            if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SECURE_SETTINGS") == 0) {
                this.q = true;
            }
        } catch (Throwable unused) {
        }
        this.B = true;
    }

    public final void c() {
        if (this.s.length() > 0) {
            this.s.delete(0, this.s.length());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer d() throws java.lang.Throwable {
        /*
            r18 = this;
            r1 = r18
            r18.c()
            android.content.Context r2 = r1.a
            r3 = 1
            if (r2 != 0) goto L_0x001c
            java.lang.StringBuilder r2 = r1.s
            java.lang.String r4 = "context is null#0101"
            r2.append(r4)
            java.lang.StringBuilder r2 = r1.s
            java.lang.String r2 = r2.toString()
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = a((int) r3, (java.lang.String) r2)
            return r2
        L_0x001c:
            int r2 = r1.L
            int r2 = r2 + r3
            r1.L = r2
            int r2 = r1.L
            r4 = 0
            if (r2 != r3) goto L_0x0060
            com.loc.ce r2 = r1.f
            r2.e()
            com.loc.cg r2 = r1.c
            if (r2 == 0) goto L_0x0036
            com.loc.cg r2 = r1.c
            boolean r5 = r1.q
            r2.a((boolean) r5)
        L_0x0036:
            com.loc.ce r2 = r1.f
            r2.a()
            com.loc.cf r2 = r1.e
            r2.a()
            java.lang.String r2 = r1.o
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0055
            java.lang.String r2 = r1.o
            java.lang.String r5 = "00:00:00:00:00:00"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0055
            java.lang.String r2 = r1.o
            goto L_0x005e
        L_0x0055:
            android.content.Context r2 = r1.a
            java.lang.String r2 = com.loc.cz.a((android.content.Context) r2)
            r1.o = r2
            r2 = r4
        L_0x005e:
            r1.o = r2
        L_0x0060:
            long r5 = r1.n
            boolean r2 = r1.Q
            r7 = 0
            r9 = 0
            if (r2 != 0) goto L_0x006d
            r1.Q = r3
        L_0x006b:
            r2 = r9
            goto L_0x0094
        L_0x006d:
            long r10 = com.loc.da.b()
            long r10 = r10 - r5
            r5 = 800(0x320, double:3.953E-321)
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x006b
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 == 0) goto L_0x008c
            long r5 = com.loc.da.a()
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            long r10 = r2.getTime()
            long r5 = r5 - r10
            goto L_0x008d
        L_0x008c:
            r5 = r7
        L_0x008d:
            r10 = 10000(0x2710, double:4.9407E-320)
            int r2 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x006b
            r2 = r3
        L_0x0094:
            if (r2 == 0) goto L_0x00b7
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 == 0) goto L_0x00b7
            boolean r2 = r1.v
            if (r2 == 0) goto L_0x00b4
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            long r2 = r2.getTime()
            boolean r2 = com.loc.cr.b((long) r2)
            if (r2 == 0) goto L_0x00b4
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            r3 = 2
            r2.setLocationType(r3)
        L_0x00b4:
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            return r2
        L_0x00b7:
            com.loc.by r2 = r1.D
            if (r2 == 0) goto L_0x00ca
            boolean r2 = r1.E
            if (r2 == 0) goto L_0x00c5
            com.loc.by r2 = r1.D
            r2.a()
            goto L_0x00ca
        L_0x00c5:
            com.loc.by r2 = r1.D
            r2.b()
        L_0x00ca:
            com.loc.cg r2 = r1.c     // Catch:{ Throwable -> 0x00d8 }
            r2.b(r3)     // Catch:{ Throwable -> 0x00d8 }
            com.loc.cg r2 = r1.c     // Catch:{ Throwable -> 0x00d8 }
            java.util.ArrayList r2 = r2.b()     // Catch:{ Throwable -> 0x00d8 }
            r1.j = r2     // Catch:{ Throwable -> 0x00d8 }
            goto L_0x00e1
        L_0x00d8:
            r0 = move-exception
            r2 = r0
            java.lang.String r5 = "APS"
            java.lang.String r6 = "getLocation getScanResultsParam"
            com.loc.cs.a(r2, r5, r6)
        L_0x00e1:
            com.loc.cd r2 = r1.d     // Catch:{ Throwable -> 0x00eb }
            boolean r5 = r18.n()     // Catch:{ Throwable -> 0x00eb }
            r2.a((boolean) r9, (boolean) r5)     // Catch:{ Throwable -> 0x00eb }
            goto L_0x00f4
        L_0x00eb:
            r0 = move-exception
            r2 = r0
            java.lang.String r5 = "APS"
            java.lang.String r6 = "getLocation getCgiListParam"
            com.loc.cs.a(r2, r5, r6)
        L_0x00f4:
            java.lang.String r2 = r18.m()
            r1.O = r2
            java.lang.String r2 = r1.O
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0129
            com.loc.bv r2 = r1.h
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r2.e()
            r1.m = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            if (r2 == 0) goto L_0x011c
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            java.lang.StringBuilder r3 = r1.s
            java.lang.String r3 = r3.toString()
            r2.setLocationDetail(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            return r2
        L_0x011c:
            int r2 = r1.C
            java.lang.StringBuilder r3 = r1.s
            java.lang.String r3 = r3.toString()
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = a((int) r2, (java.lang.String) r3)
            return r2
        L_0x0129:
            com.loc.cf r2 = r1.e
            com.amap.api.location.AMapLocationClientOption r5 = r1.l
            java.lang.String r6 = r1.O
            r2.a((com.amap.api.location.AMapLocationClientOption) r5, (java.lang.String) r6)
            java.lang.String r2 = r1.o
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0144
            java.lang.String r2 = r1.o
            java.lang.String r5 = "00:00:00:00:00:00"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x01a0
        L_0x0144:
            com.loc.cg r2 = r1.c
            android.net.wifi.WifiInfo r2 = r2.g()
            if (r2 == 0) goto L_0x01a0
            android.content.Context r2 = r1.a
            java.lang.String r2 = com.loc.n.j(r2)
            r1.o = r2
            android.content.Context r2 = r1.a
            java.lang.String r5 = r1.o
            boolean r6 = N
            if (r6 != 0) goto L_0x0194
            if (r2 == 0) goto L_0x0192
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0192
            java.lang.String r6 = "pref"
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r6, r9)
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ Throwable -> 0x0176 }
            java.lang.String r5 = com.loc.o.a((byte[]) r5)     // Catch:{ Throwable -> 0x0176 }
            r4 = r5
            goto L_0x017f
        L_0x0176:
            r0 = move-exception
            r5 = r0
            java.lang.String r6 = "SPUtil"
            java.lang.String r10 = "setSmac"
            com.loc.cs.a(r5, r6, r10)
        L_0x017f:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0192
            java.lang.String r5 = "smac"
            android.content.SharedPreferences$Editor r2 = r2.edit()
            android.content.SharedPreferences$Editor r2 = r2.putString(r5, r4)
            r2.commit()
        L_0x0192:
            N = r3
        L_0x0194:
            java.lang.String r2 = r1.o
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x01a0
            java.lang.String r2 = "00:00:00:00:00:00"
            r1.o = r2
        L_0x01a0:
            java.lang.StringBuilder r2 = r1.z
            java.lang.StringBuilder r2 = r1.a((java.lang.StringBuilder) r2)
            r1.z = r2
            com.loc.cg r2 = r1.c
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x01b9
            r2 = 15
            java.lang.String r3 = "networkLocation has been mocked!#1502"
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = a((int) r2, (java.lang.String) r3)
            return r2
        L_0x01b9:
            long r4 = r1.n
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x01c1
        L_0x01bf:
            r12 = r3
            goto L_0x01d0
        L_0x01c1:
            long r4 = com.loc.da.b()
            long r6 = r1.n
            long r4 = r4 - r6
            r6 = 20000(0x4e20, double:9.8813E-320)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x01cf
            goto L_0x01bf
        L_0x01cf:
            r12 = r9
        L_0x01d0:
            com.loc.ci r10 = r1.g
            com.loc.cd r11 = r1.d
            com.autonavi.aps.amapapi.model.AMapLocationServer r13 = r1.m
            com.loc.cg r14 = r1.c
            java.lang.StringBuilder r15 = r1.z
            java.lang.String r2 = r1.O
            android.content.Context r4 = r1.a
            r16 = r2
            r17 = r4
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r10.a(r11, r12, r13, r14, r15, r16, r17)
            boolean r4 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r4 == 0) goto L_0x01f0
        L_0x01ec:
            r1.b((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            goto L_0x021e
        L_0x01f0:
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.a((boolean) r9, (boolean) r3)
            r1.m = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 == 0) goto L_0x021e
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            java.lang.String r3 = "new"
            r2.e(r3)
            com.loc.ci r2 = r1.g
            java.lang.StringBuilder r3 = r1.z
            java.lang.String r3 = r3.toString()
            r2.a((java.lang.String) r3)
            com.loc.ci r2 = r1.g
            com.loc.cd r3 = r1.d
            com.loc.cc r3 = r3.c()
            r2.a((com.loc.cc) r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            goto L_0x01ec
        L_0x021e:
            com.loc.ci r3 = r1.g
            java.lang.String r4 = r1.O
            java.lang.StringBuilder r5 = r1.z
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r1.m
            android.content.Context r7 = r1.a
            r8 = 1
            r3.a(r4, r5, r6, r7, r8)
            com.loc.cf r2 = r1.e
            android.content.Context r3 = r1.a
            java.lang.String r3 = r1.O
            com.autonavi.aps.amapapi.model.AMapLocationServer r4 = r1.m
            r2.a((java.lang.String) r3, (com.autonavi.aps.amapapi.model.AMapLocationServer) r4)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 != 0) goto L_0x025d
            com.loc.cf r10 = r1.e
            com.loc.ci r11 = r1.g
            java.lang.String r12 = r1.O
            java.lang.StringBuilder r2 = r1.z
            java.lang.String r13 = r2.toString()
            com.amap.api.location.AMapLocationClientOption r14 = r1.l
            android.content.Context r2 = r1.a
            java.lang.String r15 = r18.m()
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            r16 = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r10.a(r11, r12, r13, r14, r15, r16)
            r1.m = r2
        L_0x025d:
            java.lang.StringBuilder r2 = r1.z
            java.lang.StringBuilder r3 = r1.z
            int r3 = r3.length()
            r2.delete(r9, r3)
            boolean r2 = r1.E
            if (r2 == 0) goto L_0x0290
            com.loc.by r2 = r1.D
            if (r2 == 0) goto L_0x0290
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            com.loc.by r3 = r1.D
            double r3 = r3.c()
            r2.setAltitude(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            com.loc.by r3 = r1.D
            float r3 = r3.d()
            r2.setBearing(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            com.loc.by r3 = r1.D
            double r3 = r3.e()
            float r3 = (float) r3
            goto L_0x029f
        L_0x0290:
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            r3 = 0
            r2.setAltitude(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            r3 = 0
            r2.setBearing(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
        L_0x029f:
            r2.setSpeed(r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r1.m
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bu.d():com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void e() {
        try {
            a(this.a);
            a(this.l);
            Context context = this.a;
            i();
            a(a(true, true));
        } catch (Throwable th) {
            cs.a(th, "APS", "doFusionLocation");
        }
    }

    @SuppressLint({"NewApi"})
    public final void f() {
        this.H = null;
        this.A = false;
        this.B = false;
        if (this.f != null) {
            this.f.b();
            this.f.a = null;
        }
        if (this.h != null) {
            this.h.a();
        }
        if (this.g != null) {
            this.g.b(this.a);
        }
        if (this.G != null) {
            this.G.a();
        }
        da.g();
        try {
            if (!(this.a == null || this.k == null)) {
                this.a.unregisterReceiver(this.k);
            }
        } catch (Throwable th) {
            this.k = null;
            throw th;
        }
        this.k = null;
        if (this.d != null) {
            this.d.g();
        }
        if (this.c != null) {
            this.c.j();
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.D != null) {
            this.D.f();
        }
        this.m = null;
        this.a = null;
        if (this.e != null) {
            this.e.b();
        }
        this.z = null;
        if (this.i != null) {
            this.i.d();
        }
    }

    public final void g() {
        try {
            if (this.h != null) {
                this.h.c();
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "bindAMapService");
        }
    }

    public final void h() {
        try {
            if (this.h != null) {
                this.h.d();
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "bindOtherService");
        }
    }

    public final void i() {
        try {
            if (!this.A) {
                if (this.O != null) {
                    this.O = null;
                }
                if (this.z != null) {
                    this.z.delete(0, this.z.length());
                }
                if (this.w) {
                    l();
                }
                this.c.b(this.w);
                this.j = this.c.b();
                this.d.a(true, n());
                this.O = m();
                if (!TextUtils.isEmpty(this.O)) {
                    this.z = a(this.z);
                }
                this.A = true;
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "initFirstLocateParam");
        }
    }

    public final AMapLocationServer j() {
        int i2;
        String sb;
        if (this.c.h()) {
            i2 = 15;
            sb = "networkLocation has been mocked!#1502";
        } else if (TextUtils.isEmpty(this.O)) {
            i2 = this.C;
            sb = this.s.toString();
        } else {
            AMapLocationServer a2 = this.g.a(this.a, this.O, this.z, true);
            if (da.a(a2)) {
                b(a2);
            }
            return a2;
        }
        return a(i2, sb);
    }

    public final void k() {
        this.f.a(this.a, this.r, this.c, this.l, this.b);
    }
}
