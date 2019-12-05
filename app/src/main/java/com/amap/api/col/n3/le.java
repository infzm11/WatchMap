package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import org.json.JSONArray;

/* compiled from: MapLocationService */
public final class le {
    private static int k = 200;
    private static boolean l = true;
    Context a = null;
    kz b = null;
    lf c = null;
    b d = null;
    Handler e = null;
    Handler f = null;
    boolean g = false;
    boolean h = false;
    Inner_3dMap_locationOption i = null;
    Object j = new Object();
    private JSONArray m = null;

    /* compiled from: MapLocationService */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                le.this.b();
            }
        }
    }

    /* compiled from: MapLocationService */
    class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }
    }

    public le(Context context, Handler handler) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                lr.a(th, "LocationService", "<init>");
            }
        } else {
            this.a = context.getApplicationContext();
            this.f = handler;
            this.i = new Inner_3dMap_locationOption();
            e();
            this.d = new b("locServiceAction");
            this.d.setPriority(5);
            this.d.start();
            this.e = new a(this.d.getLooper());
        }
    }

    private void e() {
        try {
            if (this.i == null) {
                this.i = new Inner_3dMap_locationOption();
            }
            if (!this.h) {
                this.b = new kz(this.a);
                this.c = new lf(this.a);
                this.c.a(this.i);
                l = lt.b(this.a, "maploc", "ue");
                int a2 = lt.a(this.a, "maploc", "opn");
                k = a2;
                if (a2 > 500) {
                    k = 500;
                }
                if (k < 30) {
                    k = 30;
                }
                this.h = true;
            }
        } catch (Throwable th) {
            lr.a(th, "LocationService", "init");
        }
    }

    private synchronized void f() {
        try {
            if (this.m != null && this.m.length() > 0) {
                ko.a(new kn(this.a, lr.b(), this.m.toString()), this.a);
                this.m = null;
            }
        } catch (Throwable th) {
            lr.a(th, "LocationService", "writeOfflineLog");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[ExcHandler: SecurityException (unused java.lang.SecurityException), SYNTHETIC, Splitter:B:7:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r10 = this;
            r10.e()     // Catch:{ Throwable -> 0x005a }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r10.i     // Catch:{ Throwable -> 0x005a }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r0 = r0.getLocationMode()     // Catch:{ Throwable -> 0x005a }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r1 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving     // Catch:{ Throwable -> 0x005a }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x005a }
            r1 = 1
            if (r0 != 0) goto L_0x0050
            boolean r0 = r10.g     // Catch:{ Throwable -> 0x005a }
            if (r0 != 0) goto L_0x0050
            r10.g = r1     // Catch:{ Throwable -> 0x005a }
            com.amap.api.col.n3.kz r0 = r10.b     // Catch:{ Throwable -> 0x005a }
            boolean r2 = r0.e     // Catch:{ Throwable -> 0x005a }
            if (r2 != 0) goto L_0x0050
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            if (r2 != 0) goto L_0x002a
            android.content.Context r2 = r0.a     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            android.os.Looper r2 = r2.getMainLooper()     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
        L_0x002a:
            r9 = r2
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            r2.<init>()     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            android.location.LocationManager r3 = r0.b     // Catch:{ Throwable -> 0x0039, SecurityException -> 0x004e }
            java.lang.String r4 = "gps"
            java.lang.String r5 = "force_xtra_injection"
            r3.sendExtraCommand(r4, r5, r2)     // Catch:{ Throwable -> 0x0039, SecurityException -> 0x004e }
        L_0x0039:
            android.location.LocationManager r3 = r0.b     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            java.lang.String r4 = "gps"
            r5 = 800(0x320, double:3.953E-321)
            r7 = 0
            android.location.LocationListener r8 = r0.i     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            r3.requestLocationUpdates(r4, r5, r7, r8, r9)     // Catch:{ SecurityException -> 0x004e, Throwable -> 0x0046 }
            goto L_0x004e
        L_0x0046:
            r2 = move-exception
            java.lang.String r3 = "MAPGPSLocation"
            java.lang.String r4 = "requestLocationUpdates"
            com.amap.api.col.n3.lr.a(r2, r3, r4)     // Catch:{ Throwable -> 0x005a }
        L_0x004e:
            r0.e = r1     // Catch:{ Throwable -> 0x005a }
        L_0x0050:
            android.os.Handler r0 = r10.e     // Catch:{ Throwable -> 0x005a }
            if (r0 == 0) goto L_0x0059
            android.os.Handler r0 = r10.e     // Catch:{ Throwable -> 0x005a }
            r0.sendEmptyMessage(r1)     // Catch:{ Throwable -> 0x005a }
        L_0x0059:
            return
        L_0x005a:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "getLocation"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.le.a():void");
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (this.i == null) {
            this.i = new Inner_3dMap_locationOption();
        }
        if (this.c != null) {
            this.c.a(inner_3dMap_locationOption);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036 A[Catch:{ Throwable -> 0x00be, Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[Catch:{ Throwable -> 0x00be, Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007c A[Catch:{ Throwable -> 0x00be, Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba A[Catch:{ Throwable -> 0x00be, Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r9 = this;
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r9.i     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r0 = r0.getLocationMode()     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r1 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving     // Catch:{ Throwable -> 0x00c7 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x00c7 }
            r1 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r9.g     // Catch:{ Throwable -> 0x00c7 }
            if (r0 == 0) goto L_0x001a
            com.amap.api.col.n3.kz r0 = r9.b     // Catch:{ Throwable -> 0x00c7 }
            r0.a()     // Catch:{ Throwable -> 0x00c7 }
            r9.g = r1     // Catch:{ Throwable -> 0x00c7 }
        L_0x001a:
            com.amap.api.col.n3.kz r0 = r9.b     // Catch:{ Throwable -> 0x00c7 }
            boolean r2 = r0.d     // Catch:{ Throwable -> 0x00c7 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0033
            long r5 = com.amap.api.col.n3.lu.b()     // Catch:{ Throwable -> 0x00c7 }
            long r7 = r0.c     // Catch:{ Throwable -> 0x00c7 }
            long r5 = r5 - r7
            r7 = 10000(0x2710, double:4.9407E-320)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0031
            r0 = r4
            goto L_0x0034
        L_0x0031:
            r0.f = r3     // Catch:{ Throwable -> 0x00c7 }
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x003d
            com.amap.api.col.n3.kz r0 = r9.b     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_location r3 = r0.b()     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x0051
        L_0x003d:
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r9.i     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r0 = r0.getLocationMode()     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationMode r2 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors     // Catch:{ Throwable -> 0x00c7 }
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x00c7 }
            if (r0 != 0) goto L_0x0051
            com.amap.api.col.n3.lf r0 = r9.c     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.Inner_3dMap_location r3 = r0.a()     // Catch:{ Throwable -> 0x00c7 }
        L_0x0051:
            android.os.Handler r0 = r9.f     // Catch:{ Throwable -> 0x00c7 }
            if (r0 == 0) goto L_0x0064
            if (r3 == 0) goto L_0x0064
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Throwable -> 0x00c7 }
            r0.obj = r3     // Catch:{ Throwable -> 0x00c7 }
            r0.what = r4     // Catch:{ Throwable -> 0x00c7 }
            android.os.Handler r2 = r9.f     // Catch:{ Throwable -> 0x00c7 }
            r2.sendMessage(r0)     // Catch:{ Throwable -> 0x00c7 }
        L_0x0064:
            boolean r0 = l     // Catch:{ Throwable -> 0x00be }
            if (r0 != 0) goto L_0x0069
            return
        L_0x0069:
            if (r3 == 0) goto L_0x00c6
            int r0 = r3.getErrorCode()     // Catch:{ Throwable -> 0x00be }
            if (r0 != 0) goto L_0x00bd
            int r0 = r3.getLocationType()     // Catch:{ Throwable -> 0x00be }
            if (r0 == r4) goto L_0x0078
            return
        L_0x0078:
            org.json.JSONArray r0 = r9.m     // Catch:{ Throwable -> 0x00be }
            if (r0 != 0) goto L_0x0083
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Throwable -> 0x00be }
            r0.<init>()     // Catch:{ Throwable -> 0x00be }
            r9.m = r0     // Catch:{ Throwable -> 0x00be }
        L_0x0083:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00be }
            r0.<init>()     // Catch:{ Throwable -> 0x00be }
            java.lang.String r2 = "lon"
            double r4 = r3.getLongitude()     // Catch:{ Throwable -> 0x00be }
            r0.put(r2, r4)     // Catch:{ Throwable -> 0x00be }
            java.lang.String r2 = "lat"
            double r3 = r3.getLatitude()     // Catch:{ Throwable -> 0x00be }
            r0.put(r2, r3)     // Catch:{ Throwable -> 0x00be }
            java.lang.String r2 = "type"
            r0.put(r2, r1)     // Catch:{ Throwable -> 0x00be }
            java.lang.String r1 = "timestamp"
            long r2 = com.amap.api.col.n3.lu.a()     // Catch:{ Throwable -> 0x00be }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x00be }
            org.json.JSONArray r1 = r9.m     // Catch:{ Throwable -> 0x00be }
            org.json.JSONArray r0 = r1.put(r0)     // Catch:{ Throwable -> 0x00be }
            r9.m = r0     // Catch:{ Throwable -> 0x00be }
            org.json.JSONArray r0 = r9.m     // Catch:{ Throwable -> 0x00be }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x00be }
            int r1 = k     // Catch:{ Throwable -> 0x00be }
            if (r0 < r1) goto L_0x00bd
            r9.f()     // Catch:{ Throwable -> 0x00be }
        L_0x00bd:
            return
        L_0x00be:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "recordOfflineLocLog"
            com.amap.api.col.n3.lr.a(r0, r1, r2)     // Catch:{ Throwable -> 0x00c7 }
        L_0x00c6:
            return
        L_0x00c7:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "doGetLocation"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.le.b():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        com.amap.api.col.n3.lr.a(r0, "LocationService", "stopLocation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r3 = this;
            r0 = 0
            r3.g = r0
            java.lang.Object r0 = r3.j     // Catch:{ Throwable -> 0x001e }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x001e }
            android.os.Handler r1 = r3.e     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0010
            android.os.Handler r1 = r3.e     // Catch:{ all -> 0x001b }
            r2 = 1
            r1.removeMessages(r2)     // Catch:{ all -> 0x001b }
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            com.amap.api.col.n3.kz r0 = r3.b     // Catch:{ Throwable -> 0x001e }
            if (r0 == 0) goto L_0x001a
            com.amap.api.col.n3.kz r0 = r3.b     // Catch:{ Throwable -> 0x001e }
            r0.a()     // Catch:{ Throwable -> 0x001e }
        L_0x001a:
            return
        L_0x001b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x001e }
            throw r1     // Catch:{ Throwable -> 0x001e }
        L_0x001e:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "stopLocation"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.le.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        com.amap.api.col.n3.lr.a(r0, "LocationService", "destroy");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r5 = this;
            r5.c()     // Catch:{ Throwable -> 0x0041 }
            java.lang.Object r0 = r5.j     // Catch:{ Throwable -> 0x0041 }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x0041 }
            android.os.Handler r1 = r5.e     // Catch:{ all -> 0x003e }
            r2 = 0
            if (r1 == 0) goto L_0x0010
            android.os.Handler r1 = r5.e     // Catch:{ all -> 0x003e }
            r1.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x003e }
        L_0x0010:
            r5.e = r2     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            com.amap.api.col.n3.le$b r0 = r5.d     // Catch:{ Throwable -> 0x0041 }
            if (r0 == 0) goto L_0x0033
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0041 }
            r1 = 18
            if (r0 < r1) goto L_0x0030
            com.amap.api.col.n3.le$b r0 = r5.d     // Catch:{ Throwable -> 0x002a }
            java.lang.Class<android.os.HandlerThread> r1 = android.os.HandlerThread.class
            java.lang.String r3 = "quitSafely"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x002a }
            com.amap.api.col.n3.ls.a((java.lang.Object) r0, (java.lang.Class<?>) r1, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x002a }
            goto L_0x0033
        L_0x002a:
            com.amap.api.col.n3.le$b r0 = r5.d     // Catch:{ Throwable -> 0x0041 }
        L_0x002c:
            r0.quit()     // Catch:{ Throwable -> 0x0041 }
            goto L_0x0033
        L_0x0030:
            com.amap.api.col.n3.le$b r0 = r5.d     // Catch:{ Throwable -> 0x0041 }
            goto L_0x002c
        L_0x0033:
            r5.d = r2     // Catch:{ Throwable -> 0x0041 }
            com.amap.api.col.n3.lf r0 = r5.c     // Catch:{ Throwable -> 0x0041 }
            r0.b()     // Catch:{ Throwable -> 0x0041 }
            r5.f()     // Catch:{ Throwable -> 0x0041 }
            return
        L_0x003e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x0041 }
            throw r1     // Catch:{ Throwable -> 0x0041 }
        L_0x0041:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "destroy"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.le.d():void");
    }
}
