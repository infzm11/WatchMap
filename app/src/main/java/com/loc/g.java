package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.Iterator;
import java.util.List;

/* compiled from: GPSLocation */
public final class g {
    static long l;
    Handler a;
    LocationManager b;
    AMapLocationClientOption c;
    long d = 0;
    boolean e = false;
    bx f = null;
    int g = 240;
    int h = 80;
    AMapLocation i = null;
    long j = 0;
    float k = 0.0f;
    boolean m = true;
    long n = 0;
    int o = 0;
    LocationListener p = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (g.this.a != null) {
                g.this.a.removeMessages(8);
            }
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    if (da.a(aMapLocation)) {
                        aMapLocation.setLocationType(1);
                        location.getExtras();
                        if (!g.this.e && da.a(aMapLocation)) {
                            cx.a(g.this.t, da.b() - g.this.u, cs.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                            g.this.e = true;
                        }
                        if (da.a(location, g.this.q)) {
                            aMapLocation.setMock(true);
                            if (!g.this.c.isMockEnable()) {
                                if (g.this.o > 3) {
                                    cx.a((String) null, 2152);
                                    aMapLocation.setErrorCode(15);
                                    aMapLocation.setLocationDetail("GPSLocation has been mocked!#1501");
                                    aMapLocation.setLatitude(0.0d);
                                    aMapLocation.setLongitude(0.0d);
                                    aMapLocation.setAltitude(0.0d);
                                    aMapLocation.setSpeed(0.0f);
                                    aMapLocation.setAccuracy(0.0f);
                                    aMapLocation.setBearing(0.0f);
                                    aMapLocation.setExtras((Bundle) null);
                                    g.a(g.this, aMapLocation);
                                    return;
                                }
                                g.this.o++;
                                return;
                            }
                        } else {
                            g.this.o = 0;
                        }
                        aMapLocation.setSatellites(g.this.q);
                        g.b(g.this, aMapLocation);
                        g.c(g.this, aMapLocation);
                        AMapLocation d = g.d(g.this, aMapLocation);
                        g.e(g.this, d);
                        g.this.a(d);
                        g.a(g.this, d, g.this.s);
                        if (da.a(d)) {
                            if (g.this.i != null) {
                                g.this.j = location.getTime() - g.this.i.getTime();
                                g.this.k = da.a(g.this.i, d);
                            }
                            g.this.i = d.clone();
                        }
                        g.a(g.this, d);
                        g.f(g.this, d);
                    }
                } catch (Throwable th) {
                    cs.a(th, "GPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                    g.this.d = 0;
                    g.this.q = 0;
                }
            } catch (Throwable unused) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                try {
                    g.this.d = 0;
                    g.this.q = 0;
                } catch (Throwable unused) {
                }
            }
        }
    };
    int q = 0;
    GpsStatus r = null;
    public AMapLocation s = null;
    /* access modifiers changed from: private */
    public Context t;
    /* access modifiers changed from: private */
    public long u = 0;
    private int v = 0;
    private GpsStatus.Listener w = new GpsStatus.Listener() {
        public final void onGpsStatusChanged(int i) {
            try {
                g.this.r = g.this.b.getGpsStatus(g.this.r);
                int i2 = 0;
                switch (i) {
                    case 1:
                        return;
                    case 2:
                        g.this.q = 0;
                        return;
                    case 3:
                        return;
                    case 4:
                        Iterator<GpsSatellite> it = g.this.r.getSatellites().iterator();
                        int maxSatellites = g.this.r.getMaxSatellites();
                        while (it.hasNext() && i2 < maxSatellites) {
                            if (it.next().usedInFix()) {
                                i2++;
                            }
                        }
                        g.this.q = i2;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                cs.a(th, "GPSLocation", "onGpsStatusChanged");
            }
        }
    };

    public g(Context context, Handler handler) {
        this.t = context;
        this.a = handler;
        this.b = (LocationManager) this.t.getSystemService("location");
        this.f = new bx();
    }

    private void a(int i2, int i3, String str, long j2) {
        if (this.a != null && this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i3);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i2;
            this.a.sendMessageDelayed(obtain, j2);
        }
    }

    static /* synthetic */ void a(g gVar, AMapLocation aMapLocation) {
        if ((aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(gVar.c.getLocationMode())) && da.b() - gVar.n >= gVar.c.getInterval() - 200) {
            gVar.n = da.b();
            if (gVar.a != null) {
                Message obtain = Message.obtain();
                obtain.obj = aMapLocation;
                obtain.what = 2;
                gVar.a.sendMessage(obtain);
            }
        }
    }

    static /* synthetic */ void a(g gVar, AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && gVar.c.isNeedAddress() && da.a(aMapLocation, aMapLocation2) < ((float) gVar.g)) {
            cs.a(aMapLocation, aMapLocation2);
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() == 0) {
                return false;
            }
            return allProviders.contains(GeocodeSearch.GPS);
        } catch (Throwable unused) {
        }
        return false;
    }

    static /* synthetic */ void b(g gVar, AMapLocation aMapLocation) {
        try {
            if (cs.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && gVar.c.isOffset()) {
                DPoint a2 = ct.a(gVar.t, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(a2.getLatitude());
                aMapLocation.setLongitude(a2.getLongitude());
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void c(g gVar, AMapLocation aMapLocation) {
        try {
            if (gVar.q >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (gVar.q == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ AMapLocation d(g gVar, AMapLocation aMapLocation) {
        if (!da.a(aMapLocation) || gVar.v < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return gVar.f.a(aMapLocation);
    }

    static /* synthetic */ void e(g gVar, AMapLocation aMapLocation) {
        if (da.a(aMapLocation)) {
            gVar.d = da.b();
            gVar.v++;
        }
    }

    static /* synthetic */ void f(g gVar, AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() == 0 && !cs.l && !cz.b(gVar.t, "pref", "colde", false)) {
                cs.l = true;
                cz.a(gVar.t, "pref", "colde", true);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|8|(1:10)|11|12|(1:14)|15|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A[Catch:{ Throwable -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[Catch:{ Throwable -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            android.location.LocationManager r0 = r3.b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.location.LocationListener r0 = r3.p     // Catch:{ Throwable -> 0x0010 }
            if (r0 == 0) goto L_0x0010
            android.location.LocationManager r0 = r3.b     // Catch:{ Throwable -> 0x0010 }
            android.location.LocationListener r1 = r3.p     // Catch:{ Throwable -> 0x0010 }
            r0.removeUpdates(r1)     // Catch:{ Throwable -> 0x0010 }
        L_0x0010:
            android.location.GpsStatus$Listener r0 = r3.w     // Catch:{ Throwable -> 0x001b }
            if (r0 == 0) goto L_0x001b
            android.location.LocationManager r0 = r3.b     // Catch:{ Throwable -> 0x001b }
            android.location.GpsStatus$Listener r1 = r3.w     // Catch:{ Throwable -> 0x001b }
            r0.removeGpsStatusListener(r1)     // Catch:{ Throwable -> 0x001b }
        L_0x001b:
            android.os.Handler r0 = r3.a     // Catch:{ Throwable -> 0x0026 }
            if (r0 == 0) goto L_0x0026
            android.os.Handler r0 = r3.a     // Catch:{ Throwable -> 0x0026 }
            r1 = 8
            r0.removeMessages(r1)     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            r0 = 0
            r3.q = r0
            r1 = 0
            r3.u = r1
            r3.n = r1
            r3.d = r1
            r3.v = r0
            r3.o = r0
            com.loc.bx r0 = r3.f
            r0.a()
            r0 = 0
            r3.i = r0
            r3.j = r1
            r0 = 0
            r3.k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.g.a():void");
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.g = bundle.getInt("lMaxGeoDis");
                this.h = bundle.getInt("lMinGeoDis");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    this.s = aMapLocation;
                }
            } catch (Throwable th) {
                cs.a(th, "GPSLocation", "setLastGeoLocation");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapLocation aMapLocation) {
        if (da.a(aMapLocation) && this.a != null && this.c.isNeedAddress()) {
            long b2 = da.b();
            if (this.c.getInterval() <= 8000 || b2 - this.n > this.c.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                if (this.s == null) {
                    this.a.sendMessage(obtain);
                } else if (da.a(aMapLocation, this.s) > ((float) this.h)) {
                    this.a.sendMessage(obtain);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0094, code lost:
        com.loc.cs.a(r9, "GPSLocation", "requestLocationUpdates part2");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        r8.m = false;
        com.loc.cx.a((java.lang.String) null, 2121);
        a(2, 12, r9.getMessage() + "#1201", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c3, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[ExcHandler: SecurityException (r9v3 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:7:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.location.AMapLocationClientOption r9) {
        /*
            r8 = this;
            r8.c = r9
            com.amap.api.location.AMapLocationClientOption r9 = r8.c
            if (r9 != 0) goto L_0x000d
            com.amap.api.location.AMapLocationClientOption r9 = new com.amap.api.location.AMapLocationClientOption
            r9.<init>()
            r8.c = r9
        L_0x000d:
            android.content.Context r9 = r8.t     // Catch:{ Throwable -> 0x001b }
            java.lang.String r0 = "pref"
            java.lang.String r1 = "lagt"
            long r2 = l     // Catch:{ Throwable -> 0x001b }
            long r0 = com.loc.cz.b((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r1, (long) r2)     // Catch:{ Throwable -> 0x001b }
            l = r0     // Catch:{ Throwable -> 0x001b }
        L_0x001b:
            r9 = 1
            r0 = 0
            r8.m = r9     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            if (r9 != 0) goto L_0x002b
            android.content.Context r9 = r8.t     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            android.os.Looper r9 = r9.getMainLooper()     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
        L_0x002b:
            r7 = r9
            long r1 = com.loc.da.b()     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            r8.u = r1     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            android.location.LocationManager r9 = r8.b     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            boolean r9 = a((android.location.LocationManager) r9)     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            if (r9 == 0) goto L_0x0086
            long r1 = com.loc.da.a()     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            long r3 = l     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            long r1 = r1 - r3
            r3 = 259200000(0xf731400, double:1.280618154E-315)
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 < 0) goto L_0x0062
            android.location.LocationManager r9 = r8.b     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            java.lang.String r1 = "gps"
            java.lang.String r2 = "force_xtra_injection"
            r9.sendExtraCommand(r1, r2, r0)     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            long r1 = com.loc.da.a()     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            l = r1     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            android.content.Context r9 = r8.t     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "lagt"
            long r3 = l     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
            com.loc.cz.a((android.content.Context) r9, (java.lang.String) r1, (java.lang.String) r2, (long) r3)     // Catch:{ Throwable -> 0x0062, SecurityException -> 0x009c }
        L_0x0062:
            android.location.LocationManager r1 = r8.b     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            java.lang.String r2 = "gps"
            r3 = 900(0x384, double:4.447E-321)
            r5 = 0
            android.location.LocationListener r6 = r8.p     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            r1.requestLocationUpdates(r2, r3, r5, r6, r7)     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            android.location.LocationManager r9 = r8.b     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            android.location.GpsStatus$Listener r1 = r8.w     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            r9.addGpsStatusListener(r1)     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            r3 = 8
            r4 = 14
            java.lang.String r5 = "no enough satellites#1401"
            com.amap.api.location.AMapLocationClientOption r9 = r8.c     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            long r6 = r9.getHttpTimeOut()     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            r2 = r8
            r2.a(r3, r4, r5, r6)     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            return
        L_0x0086:
            r2 = 8
            r3 = 14
            java.lang.String r4 = "no gps provider#1402"
            r5 = 0
            r1 = r8
            r1.a(r2, r3, r4, r5)     // Catch:{ SecurityException -> 0x009c, Throwable -> 0x0093 }
            return
        L_0x0093:
            r9 = move-exception
            java.lang.String r0 = "GPSLocation"
            java.lang.String r1 = "requestLocationUpdates part2"
            com.loc.cs.a(r9, r0, r1)
            return
        L_0x009c:
            r9 = move-exception
            r1 = 0
            r8.m = r1
            r1 = 2121(0x849, float:2.972E-42)
            com.loc.cx.a((java.lang.String) r0, (int) r1)
            r3 = 2
            r4 = 12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = "#1201"
            r0.append(r9)
            java.lang.String r5 = r0.toString()
            r6 = 0
            r2 = r8
            r2.a(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.g.a(com.amap.api.location.AMapLocationClientOption):void");
    }

    public final AMapLocation b(AMapLocation aMapLocation) {
        if (this.i == null) {
            return aMapLocation;
        }
        if (!this.c.isMockEnable() && this.i.isMock()) {
            return aMapLocation;
        }
        float speed = this.i.getSpeed();
        if (this.j > 0 && this.j < 8 && speed == 0.0f) {
            speed = this.k / ((float) this.j);
        }
        long j2 = 30000;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            if (aMapLocation.getAccuracy() < 200.0f) {
                j2 = speed > 5.0f ? 10000 : 15000;
            } else if (speed > 5.0f) {
                j2 = 20000;
            }
        }
        if (da.b() - this.d < j2) {
            return this.i.clone();
        }
        this.i = null;
        this.j = 0;
        this.k = 0.0f;
        return aMapLocation;
    }

    public final void b(AMapLocationClientOption aMapLocationClientOption) {
        this.c = aMapLocationClientOption;
        if (this.c == null) {
            this.c = new AMapLocationClientOption();
        }
        if (this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.a != null) {
            this.a.removeMessages(8);
        }
    }

    public final boolean b() {
        return da.b() - this.d <= 2800;
    }

    public final void c() {
        this.o = 0;
    }

    @SuppressLint({"NewApi"})
    public final int d() {
        if (this.b == null || !a(this.b)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int i2 = Settings.Secure.getInt(this.t.getContentResolver(), "location_mode", 0);
            if (i2 == 0) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
        } else if (!this.b.isProviderEnabled(GeocodeSearch.GPS)) {
            return 2;
        }
        return !this.m ? 4 : 0;
    }

    public final int e() {
        return this.q;
    }
}
