package com.amap.api.col.n3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import java.lang.reflect.Constructor;

/* compiled from: MapGPSLocation */
public final class kz {
    Context a;
    LocationManager b;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    Object g = null;
    boolean h = false;
    LocationListener i = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i);
                    kz.this.f = inner_3dMap_location;
                    kz.this.c = lu.b();
                    kz.this.d = true;
                } catch (Throwable th) {
                    lr.a(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equals(str)) {
                    kz.this.d = false;
                }
            } catch (Throwable th) {
                lr.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(3:11|(1:13)(1:15)|14)|16|(2:19|20)(1:21)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ Throwable -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kz(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.c = r0
            r0 = 0
            r5.d = r0
            r5.e = r0
            r1 = 0
            r5.f = r1
            r5.g = r1
            r5.h = r0
            com.amap.api.col.n3.kz$1 r1 = new com.amap.api.col.n3.kz$1
            r1.<init>()
            r5.i = r1
            if (r6 != 0) goto L_0x001d
            return
        L_0x001d:
            r5.a = r6
            r1 = 1
            java.lang.String r2 = "com.amap.api.maps.CoordinateConverter"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Throwable -> 0x002a }
            if (r2 == 0) goto L_0x002a
            r5.h = r1     // Catch:{ Throwable -> 0x002a }
        L_0x002a:
            java.lang.Object r2 = r5.g     // Catch:{ Throwable -> 0x0060 }
            if (r2 != 0) goto L_0x0060
            boolean r2 = r5.h     // Catch:{ Throwable -> 0x0060 }
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = "com.amap.api.maps.CoordinateConverter"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Throwable -> 0x0060 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x0060 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r0] = r4     // Catch:{ Throwable -> 0x0060 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r3)     // Catch:{ Throwable -> 0x0060 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0060 }
            r1[r0] = r6     // Catch:{ Throwable -> 0x0060 }
            java.lang.Object r6 = r2.newInstance(r1)     // Catch:{ Throwable -> 0x0060 }
        L_0x004a:
            r5.g = r6     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0060
        L_0x004d:
            java.lang.String r6 = "com.amap.api.maps2d.CoordinateConverter"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Throwable -> 0x0060 }
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ Throwable -> 0x0060 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r1)     // Catch:{ Throwable -> 0x0060 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0060 }
            java.lang.Object r6 = r6.newInstance(r0)     // Catch:{ Throwable -> 0x0060 }
            goto L_0x004a
        L_0x0060:
            android.location.LocationManager r6 = r5.b
            if (r6 != 0) goto L_0x0070
            android.content.Context r6 = r5.a
            java.lang.String r0 = "location"
            java.lang.Object r6 = r6.getSystemService(r0)
            android.location.LocationManager r6 = (android.location.LocationManager) r6
            r5.b = r6
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kz.<init>(android.content.Context):void");
    }

    public final void a() {
        this.e = false;
        this.d = false;
        this.c = 0;
        this.f = null;
        if (this.b != null && this.i != null) {
            this.b.removeUpdates(this.i);
        }
    }

    public final Inner_3dMap_location b() {
        Object a2;
        Constructor<?> constructor;
        Object[] objArr;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location clone = this.f.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.g != null && lr.a(clone.getLatitude(), clone.getLongitude())) {
                    Long.valueOf(System.currentTimeMillis());
                    Object[] objArr2 = {"GPS"};
                    Class[] clsArr = {String.class};
                    if (this.h) {
                        a2 = ls.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr2, (Class<?>[]) clsArr);
                        constructor = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE});
                        objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                    } else {
                        a2 = ls.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr2, (Class<?>[]) clsArr);
                        constructor = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE});
                        objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                    }
                    Object newInstance = constructor.newInstance(objArr);
                    ls.a(this.g, "coord", newInstance);
                    ls.a(this.g, "from", a2);
                    Object a3 = ls.a(this.g, "convert", new Object[0]);
                    double doubleValue = ((Double) a3.getClass().getDeclaredField("latitude").get(a3)).doubleValue();
                    double doubleValue2 = ((Double) a3.getClass().getDeclaredField("longitude").get(a3)).doubleValue();
                    clone.setLatitude(doubleValue);
                    clone.setLongitude(doubleValue2);
                }
            } catch (Throwable unused) {
            }
        }
        return clone;
    }
}
