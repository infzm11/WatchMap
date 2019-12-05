package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.iflytek.cloud.util.AudioDetector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class cg {
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

    public cg(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i2) {
        int i3;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            cs.a(e2, "APS", "wifiSigFine");
            i3 = 20;
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && da.b(wifiInfo.getBSSID());
    }

    public static String k() {
        return String.valueOf(da.b() - h);
    }

    private List<ScanResult> m() {
        if (this.a != null) {
            try {
                List<ScanResult> scanResults = this.a.getScanResults();
                this.o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                cs.a(th, "WifiManagerWrapper", "getScanResults");
                return null;
            }
        }
        return null;
    }

    private WifiInfo n() {
        try {
            if (this.a != null) {
                return this.a.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            cs.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private List<WifiConfiguration> o() {
        if (this.a != null) {
            return this.a.getConfiguredNetworks();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ Throwable -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p() {
        /*
            r4 = this;
            boolean r0 = r4.q()
            if (r0 == 0) goto L_0x005b
            long r0 = com.loc.da.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = e     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 4900(0x1324, double:2.421E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0049
            android.net.ConnectivityManager r0 = r4.r     // Catch:{ Throwable -> 0x0053 }
            if (r0 != 0) goto L_0x0023
            android.content.Context r0 = r4.i     // Catch:{ Throwable -> 0x0053 }
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = com.loc.da.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0053 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Throwable -> 0x0053 }
            r4.r = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0023:
            android.net.ConnectivityManager r0 = r4.r     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r4.a((android.net.ConnectivityManager) r0)     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0038
            long r0 = com.loc.da.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = e     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 9900(0x26ac, double:4.8912E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0049
        L_0x0038:
            android.net.wifi.WifiManager r0 = r4.a     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            long r0 = com.loc.da.b()     // Catch:{ Throwable -> 0x0053 }
            e = r0     // Catch:{ Throwable -> 0x0053 }
            android.net.wifi.WifiManager r0 = r4.a     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r0.startScan()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0052
            long r0 = com.loc.da.b()     // Catch:{ Throwable -> 0x0053 }
            g = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0052:
            return
        L_0x0053:
            r0 = move-exception
            java.lang.String r1 = "APS"
            java.lang.String r2 = "updateWifi"
            com.loc.cs.a(r0, r1, r2)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cg.p():void");
    }

    private boolean q() {
        this.q = this.a == null ? false : da.g(this.i);
        if (!this.q || !this.l) {
            return false;
        }
        if (g != 0) {
            if (da.b() - g < 4900 || da.b() - h < 1500) {
                return false;
            }
            int i2 = ((da.b() - h) > 4900 ? 1 : ((da.b() - h) == 4900 ? 0 : -1));
        }
        return true;
    }

    public final String a() {
        return this.o;
    }

    public final void a(boolean z) {
        Context context = this.i;
        if (this.a != null && context != null && z && da.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) cv.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    cv.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                cs.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final void a(boolean z, boolean z2) {
        this.l = z;
        this.m = z2;
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (da.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo())) {
                return true;
            }
        } catch (Throwable th) {
            cs.a(th, "WifiManagerWrapper", "wifiAccess");
        }
        return false;
    }

    public final ArrayList<ScanResult> b() {
        return this.c;
    }

    public final void b(boolean z) {
        String str;
        if (!z) {
            p();
        } else if (q()) {
            long b2 = da.b();
            if (b2 - f >= 10000) {
                synchronized (this.b) {
                    this.d.clear();
                }
            }
            p();
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
        if (da.b() - h > 20000) {
            synchronized (this.b) {
                this.d.clear();
            }
        }
        f = da.b();
        if (this.d.isEmpty()) {
            h = da.b();
            List<ScanResult> m2 = m();
            if (m2 != null) {
                synchronized (this.b) {
                    this.d.addAll(m2);
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
            if (da.b() - h > 3600000) {
                c();
                this.c.clear();
            }
            if (this.p == null) {
                this.p = new TreeMap<>(Collections.reverseOrder());
            }
            this.p.clear();
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ScanResult scanResult = this.c.get(i3);
                if (da.b(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
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
        this.s = null;
        synchronized (this.b) {
            this.d.clear();
        }
    }

    public final void d() {
        if (this.a != null && da.b() - h > 4900) {
            List<ScanResult> list = null;
            try {
                list = m();
            } catch (Throwable th) {
                cs.a(th, "APS", "onReceive part1");
            }
            if (list != null) {
                synchronized (this.b) {
                    this.d.clear();
                    this.d.addAll(list);
                    h = da.b();
                }
                return;
            }
            synchronized (this.b) {
                this.d.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
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
            com.loc.cs.a(r1, r2, r3)
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
            r4.c()
            return
        L_0x002f:
            r4.c()
            return
        L_0x0033:
            r4.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cg.e():void");
    }

    public final boolean f() {
        return this.q;
    }

    public final WifiInfo g() {
        this.s = n();
        return this.s;
    }

    public final boolean h() {
        return this.j;
    }

    public final String i() {
        int i2 = 0;
        if (this.k == null) {
            this.k = new StringBuilder(AudioDetector.DEF_EOS);
        } else {
            this.k.delete(0, this.k.length());
        }
        this.j = false;
        String str = "";
        this.s = g();
        if (a(this.s)) {
            str = this.s.getBSSID();
        }
        int size = this.c.size();
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = this.c.get(i3).BSSID;
            if (!this.m && !"<unknown ssid>".equals(this.c.get(i3).SSID)) {
                z = true;
            }
            String str3 = "nb";
            if (str.equals(str2)) {
                str3 = "access";
                z2 = true;
            }
            this.k.append(String.format(Locale.US, "#%s,%s", new Object[]{str2, str3}));
        }
        if (this.c.size() == 0) {
            z = true;
        }
        try {
            if (!this.m && !z) {
                List<WifiConfiguration> o2 = o();
                int i4 = 0;
                while (o2 != null) {
                    try {
                        if (i2 >= o2.size()) {
                            break;
                        }
                        if (this.k.toString().contains(o2.get(i2).BSSID)) {
                            i4 = 1;
                        }
                        i2++;
                    } catch (Throwable unused) {
                    }
                }
                i2 = i4;
            }
        } catch (Throwable unused2) {
        }
        if (!this.m && !z && i2 == 0) {
            this.j = true;
        }
        if (!z2 && !TextUtils.isEmpty(str)) {
            StringBuilder sb = this.k;
            sb.append("#");
            sb.append(str);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final void j() {
        c();
        this.c.clear();
    }

    public final boolean l() {
        try {
            List<WifiConfiguration> o2 = o();
            return o2 != null && !o2.isEmpty();
        } catch (Throwable unused) {
            return false;
        }
    }
}
