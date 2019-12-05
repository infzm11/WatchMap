package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: AMapLocationClient */
public final class el {
    Context a;
    Inner_3dMap_locationManagerBase b = null;
    Object c = null;
    boolean d = false;
    Object e = null;
    im f = null;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|22|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public el(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.b = r0
            r5.c = r0
            r1 = 0
            r5.d = r1
            r5.e = r0
            r5.f = r0
            com.amap.api.col.n3.im r2 = com.amap.api.col.n3.lh.a()     // Catch:{ Throwable -> 0x0015 }
            r5.f = r2     // Catch:{ Throwable -> 0x0015 }
        L_0x0015:
            if (r6 != 0) goto L_0x0021
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ Throwable -> 0x001f }
            java.lang.String r0 = "Context参数不能为null"
            r6.<init>(r0)     // Catch:{ Throwable -> 0x001f }
            throw r6     // Catch:{ Throwable -> 0x001f }
        L_0x001f:
            r6 = move-exception
            goto L_0x0064
        L_0x0021:
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x001f }
            r5.a = r6     // Catch:{ Throwable -> 0x001f }
            java.lang.String r6 = "com.amap.api.location.AMapLocationClient"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Throwable -> 0x004b }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Throwable -> 0x004b }
            android.content.Context r3 = r5.a     // Catch:{ Throwable -> 0x004b }
            java.lang.String r4 = "com.amap.api.location.APSService"
            r2.<init>(r3, r4)     // Catch:{ Throwable -> 0x004b }
            android.content.Context r3 = r5.a     // Catch:{ Throwable -> 0x0043 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Throwable -> 0x0043 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ServiceInfo r2 = r3.getServiceInfo(r2, r4)     // Catch:{ Throwable -> 0x0043 }
            r0 = r2
        L_0x0043:
            if (r6 == 0) goto L_0x004d
            if (r0 == 0) goto L_0x004d
            r6 = 1
            r5.d = r6     // Catch:{ Throwable -> 0x004b }
            goto L_0x004d
        L_0x004b:
            r5.d = r1     // Catch:{ Throwable -> 0x001f }
        L_0x004d:
            boolean r6 = r5.d     // Catch:{ Throwable -> 0x001f }
            if (r6 == 0) goto L_0x005b
            com.amap.api.location.AMapLocationClient r6 = new com.amap.api.location.AMapLocationClient     // Catch:{ Throwable -> 0x001f }
            android.content.Context r0 = r5.a     // Catch:{ Throwable -> 0x001f }
            r6.<init>(r0)     // Catch:{ Throwable -> 0x001f }
            r5.c = r6     // Catch:{ Throwable -> 0x001f }
            return
        L_0x005b:
            android.content.Context r6 = r5.a     // Catch:{ Throwable -> 0x001f }
            com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase r6 = r5.a((android.content.Context) r6)     // Catch:{ Throwable -> 0x001f }
            r5.b = r6     // Catch:{ Throwable -> 0x001f }
            return
        L_0x0064:
            java.lang.String r0 = "AMapLocationClient"
            java.lang.String r1 = "AMapLocationClient 1"
            com.amap.api.col.n3.lr.a(r6, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.el.<init>(android.content.Context):void");
    }

    private Inner_3dMap_locationManagerBase a(Context context) {
        Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase;
        try {
            inner_3dMap_locationManagerBase = (Inner_3dMap_locationManagerBase) jp.a(context, this.f, in.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), lb.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable unused) {
            inner_3dMap_locationManagerBase = new lb(context);
        }
        return inner_3dMap_locationManagerBase == null ? new lb(context) : inner_3dMap_locationManagerBase;
    }

    public final void a() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            lr.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                lr.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else if (this.d) {
            Object obj = this.c;
            ky kyVar = new ky();
            kyVar.a(inner_3dMap_locationListener);
            ((AMapLocationClient) obj).setLocationListener(kyVar);
        } else {
            this.b.setLocationListener(inner_3dMap_locationListener);
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                lr.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else if (this.d) {
            AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
            kw.a(aMapLocationClientOption, inner_3dMap_locationOption);
            ((AMapLocationClient) this.c).setLocationOption(aMapLocationClientOption);
        } else {
            this.b.setLocationOption(inner_3dMap_locationOption);
        }
    }

    public final void b() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            lr.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public final void c() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
        } catch (Throwable th) {
            lr.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
