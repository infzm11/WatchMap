package com.amap.api.col.n3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class lm {
    static long e;
    static long f;
    static long g;
    static long h;
    WifiManager a;
    Object b = new Object();
    ArrayList<ScanResult> c = new ArrayList<>();
    ArrayList<ScanResult> d = new ArrayList<>();
    Context i;
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    String n = "isScanAlwaysAvailable";
    String o = null;
    TreeMap<Integer, ScanResult> p = null;
    public boolean q = true;
    ConnectivityManager r = null;
    private volatile WifiInfo s = null;

    public lm(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i2) {
        int i3;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            lr.a(e2, "APS", "wifiSigFine");
            i3 = 20;
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && lu.a(wifiInfo.getBSSID());
    }

    public static String i() {
        return String.valueOf(lu.b() - h);
    }

    private List<ScanResult> j() {
        if (this.a != null) {
            try {
                List<ScanResult> scanResults = this.a.getScanResults();
                this.o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                lr.a(th, "WifiManagerWrapper", "getScanResults");
                return null;
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            if (this.a != null) {
                return this.a.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            lr.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ Throwable -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r4 = this;
            boolean r0 = r4.m()
            if (r0 == 0) goto L_0x005b
            long r0 = com.amap.api.col.n3.lu.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = e     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 4900(0x1324, double:2.421E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0049
            android.net.ConnectivityManager r0 = r4.r     // Catch:{ Throwable -> 0x0053 }
            if (r0 != 0) goto L_0x0023
            android.content.Context r0 = r4.i     // Catch:{ Throwable -> 0x0053 }
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = com.amap.api.col.n3.lu.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0053 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Throwable -> 0x0053 }
            r4.r = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0023:
            android.net.ConnectivityManager r0 = r4.r     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r4.a((android.net.ConnectivityManager) r0)     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0038
            long r0 = com.amap.api.col.n3.lu.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = e     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 9900(0x26ac, double:4.8912E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0049
        L_0x0038:
            android.net.wifi.WifiManager r0 = r4.a     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            long r0 = com.amap.api.col.n3.lu.b()     // Catch:{ Throwable -> 0x0053 }
            e = r0     // Catch:{ Throwable -> 0x0053 }
            android.net.wifi.WifiManager r0 = r4.a     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r0.startScan()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0052
            long r0 = com.amap.api.col.n3.lu.b()     // Catch:{ Throwable -> 0x0053 }
            g = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0052:
            return
        L_0x0053:
            r0 = move-exception
            java.lang.String r1 = "APS"
            java.lang.String r2 = "updateWifi"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lm.l():void");
    }

    private boolean m() {
        this.q = this.a == null ? false : lu.c(this.i);
        if (!this.q || !this.l) {
            return false;
        }
        if (g != 0) {
            if (lu.b() - g < 4900 || lu.b() - h < 1500) {
                return false;
            }
            int i2 = ((lu.b() - h) > 4900 ? 1 : ((lu.b() - h) == 4900 ? 0 : -1));
        }
        return true;
    }

    public final ArrayList<ScanResult> a() {
        return this.c;
    }

    public final void a(boolean z) {
        Context context = this.i;
        if (this.a != null && context != null && z && lu.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) ls.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    ls.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                lr.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (lu.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo())) {
                return true;
            }
        } catch (Throwable th) {
            lr.a(th, "WifiManagerWrapper", "wifiAccess");
        }
        return false;
    }

    public final void b() {
        this.s = null;
        synchronized (this.b) {
            this.d.clear();
        }
    }

    public final void b(boolean z) {
        String str;
        if (!z) {
            l();
        } else if (m()) {
            long b2 = lu.b();
            if (b2 - f >= 10000) {
                synchronized (this.b) {
                    this.d.clear();
                }
            }
            l();
            if (b2 - f >= 10000) {
                for (int i2 = 20; i2 > 0 && this.d.isEmpty(); i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
            synchronized (this.b) {
            }
        }
        if (lu.b() - h > 20000) {
            synchronized (this.b) {
                this.d.clear();
            }
        }
        f = lu.b();
        if (this.d.isEmpty()) {
            h = lu.b();
            List<ScanResult> j2 = j();
            if (j2 != null) {
                synchronized (this.b) {
                    this.d.addAll(j2);
                }
            }
        }
        ArrayList<ScanResult> arrayList = this.c;
        ArrayList<ScanResult> arrayList2 = this.d;
        arrayList.clear();
        synchronized (this.b) {
            if (arrayList2 != null) {
                try {
                    if (arrayList2.size() > 0) {
                        arrayList.addAll(arrayList2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.c != null && !this.c.isEmpty()) {
            if (lu.b() - h > 3600000) {
                b();
                this.c.clear();
            }
            if (this.p == null) {
                this.p = new TreeMap<>(Collections.reverseOrder());
            }
            this.p.clear();
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ScanResult scanResult = this.c.get(i3);
                if (lu.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i3);
                        }
                        this.p.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.p.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                }
            }
            this.c.clear();
            for (ScanResult add : this.p.values()) {
                this.c.add(add);
            }
            this.p.clear();
        }
    }

    public final void c() {
        if (this.a != null && lu.b() - h > 4900) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th) {
                lr.a(th, "APS", "onReceive part1");
            }
            if (list != null) {
                synchronized (this.b) {
                    this.d.clear();
                    this.d.addAll(list);
                    h = lu.b();
                }
                return;
            }
            synchronized (this.b) {
                this.d.clear();
            }
        }
    }

    public final void c(boolean z) {
        this.l = z;
        this.m = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r4 = this;
            android.net.wifi.WifiManager r0 = r4.a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 4
            android.net.wifi.WifiManager r1 = r4.a     // Catch:{ Throwable -> 0x0011 }
            if (r1 == 0) goto L_0x0019
            android.net.wifi.WifiManager r1 = r4.a     // Catch:{ Throwable -> 0x0011 }
            int r1 = r1.getWifiState()     // Catch:{ Throwable -> 0x0011 }
            goto L_0x001a
        L_0x0011:
            r1 = move-exception
            java.lang.String r2 = "APS"
            java.lang.String r3 = "onReceive part"
            com.amap.api.col.n3.lr.a(r1, r2, r3)
        L_0x0019:
            r1 = r0
        L_0x001a:
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r4.d
            if (r2 != 0) goto L_0x0025
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4.d = r2
        L_0x0025:
            if (r1 == r0) goto L_0x0033
            switch(r1) {
                case 0: goto L_0x002f;
                case 1: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            return
        L_0x002b:
            r4.b()
            return
        L_0x002f:
            r4.b()
            return
        L_0x0033:
            r4.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lm.d():void");
    }

    public final boolean e() {
        return this.q;
    }

    public final WifiInfo f() {
        this.s = k();
        return this.s;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        b();
        this.c.clear();
    }
}
