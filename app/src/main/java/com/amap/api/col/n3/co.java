package com.amap.api.col.n3;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: MyLocationOverlay */
public final class co {
    a a = null;
    ValueAnimator b;
    Animator.AnimatorListener c = new Animator.AnimatorListener() {
        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            co.this.f();
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (co.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    co.this.g.setCenter(latLng);
                    co.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private k e;
    /* access modifiers changed from: private */
    public Marker f;
    /* access modifiers changed from: private */
    public Circle g;
    private MyLocationStyle h = new MyLocationStyle();
    private LatLng i;
    private double j;
    private Context k;
    private t l;
    private int m = 4;
    private boolean n = false;
    private final String o = "location_map_gps_locked.png";
    private final String p = "location_map_gps_3d.png";
    private BitmapDescriptor q = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;

    /* compiled from: MyLocationOverlay */
    public class a implements TypeEvaluator {
        public a() {
        }

        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = (double) f;
            return new LatLng(latLng.latitude + ((latLng2.latitude - latLng.latitude) * d), latLng.longitude + (d * (latLng2.longitude - latLng.longitude)));
        }
    }

    public co(k kVar, Context context) {
        this.k = context.getApplicationContext();
        this.e = kVar;
        this.l = new t(this.k, kVar);
        a(4, true);
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(this.h.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            g();
            if (this.f != null || this.g != null) {
                this.l.a(this.f);
                a(this.h.getMyLocationType(), false);
            }
        } catch (Throwable th) {
            iu.b(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final MyLocationStyle a() {
        return this.h;
    }

    private void a(int i2, boolean z) {
        this.m = i2;
        this.n = false;
        this.s = false;
        this.r = false;
        this.u = false;
        this.v = false;
        switch (this.m) {
            case 1:
                this.r = true;
                this.s = true;
                this.t = true;
                break;
            case 2:
                this.r = true;
                this.t = true;
                break;
            case 3:
                this.r = true;
                break;
            case 4:
                this.r = true;
                this.u = true;
                break;
            case 5:
                this.u = true;
                break;
            case 7:
                break;
        }
        this.v = true;
        if (this.u || this.v) {
            if (this.v) {
                this.l.a(true);
                if (!z) {
                    try {
                        this.e.a(z.a(17.0f));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                b(45.0f);
            } else {
                this.l.a(false);
            }
            this.l.a();
            if (this.f != null) {
                this.f.setFlat(true);
                return;
            }
            return;
        }
        if (this.f != null) {
            this.f.setFlat(false);
        }
        if (this.e != null) {
            try {
                this.e.a(z.c(0.0f));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        b(0.0f);
        this.l.b();
    }

    private void b(float f2) {
        if (this.e != null) {
            try {
                this.e.a(z.b(f2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Location location) {
        ValueAnimator valueAnimator;
        long j2;
        if (location != null) {
            a(this.h.isMyLocationShowing());
            if (this.h.isMyLocationShowing()) {
                this.i = new LatLng(location.getLatitude(), location.getLongitude());
                this.j = (double) location.getAccuracy();
                if (this.f == null && this.g == null) {
                    g();
                }
                if (this.g != null) {
                    try {
                        if (this.j != -1.0d) {
                            this.g.setRadius(this.j);
                        }
                    } catch (Throwable th) {
                        iu.b(th, "MyLocationOverlay", "setCentAndRadius");
                        th.printStackTrace();
                    }
                }
                float bearing = location.getBearing();
                if (this.t) {
                    float f2 = bearing % 360.0f;
                    if (f2 > 180.0f) {
                        f2 -= 360.0f;
                    } else if (f2 < -180.0f) {
                        f2 += 360.0f;
                    }
                    if (this.f != null) {
                        this.f.setRotateAngle(-f2);
                    }
                }
                if (!this.i.equals(this.f.getPosition())) {
                    LatLng latLng = this.i;
                    LatLng position = this.f.getPosition();
                    if (position == null) {
                        position = new LatLng(0.0d, 0.0d);
                    }
                    if (this.a == null) {
                        this.a = new a();
                    }
                    if (this.b == null) {
                        this.b = ValueAnimator.ofObject(new a(), new Object[]{position, latLng});
                        this.b.addListener(this.c);
                        this.b.addUpdateListener(this.d);
                    } else {
                        this.b.setObjectValues(new Object[]{position, latLng});
                        this.b.setEvaluator(this.a);
                    }
                    if (position.latitude == 0.0d && position.longitude == 0.0d) {
                        valueAnimator = this.b;
                        j2 = 1;
                    } else {
                        valueAnimator = this.b;
                        j2 = 1000;
                    }
                    valueAnimator.setDuration(j2);
                    this.b.start();
                    return;
                }
                f();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.i == null || !this.r) {
            return;
        }
        if (!this.s || !this.n) {
            this.n = true;
            try {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.i.longitude, this.i.latitude, obtain);
                this.e.b(z.a((Point) obtain));
            } catch (Throwable th) {
                iu.b(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x014f A[Catch:{ Throwable -> 0x0166 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r5 = this;
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h
            if (r0 != 0) goto L_0x0017
            com.amap.api.maps.model.MyLocationStyle r0 = new com.amap.api.maps.model.MyLocationStyle
            r0.<init>()
            r5.h = r0
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h
            java.lang.String r1 = "location_map_gps_locked.png"
            com.amap.api.maps.model.BitmapDescriptor r1 = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            r0.myLocationIcon(r1)
            goto L_0x0036
        L_0x0017:
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h
            com.amap.api.maps.model.BitmapDescriptor r0 = r0.getMyLocationIcon()
            if (r0 == 0) goto L_0x002b
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h
            com.amap.api.maps.model.BitmapDescriptor r0 = r0.getMyLocationIcon()
            android.graphics.Bitmap r0 = r0.getBitmap()
            if (r0 != 0) goto L_0x0036
        L_0x002b:
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h
            java.lang.String r1 = "location_map_gps_locked.png"
            com.amap.api.maps.model.BitmapDescriptor r1 = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            r0.myLocationIcon(r1)
        L_0x0036:
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            if (r0 != 0) goto L_0x004d
            com.amap.api.col.n3.k r0 = r5.e     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.CircleOptions r1 = new com.amap.api.maps.model.CircleOptions     // Catch:{ Throwable -> 0x0166 }
            r1.<init>()     // Catch:{ Throwable -> 0x0166 }
            r2 = 1065353216(0x3f800000, float:1.0)
            com.amap.api.maps.model.CircleOptions r1 = r1.zIndex(r2)     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.Circle r0 = r0.addCircle(r1)     // Catch:{ Throwable -> 0x0166 }
            r5.g = r0     // Catch:{ Throwable -> 0x0166 }
        L_0x004d:
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            r1 = 1
            if (r0 == 0) goto L_0x00b6
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            float r0 = r0.getStrokeWidth()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r2 = r2.getStrokeWidth()     // Catch:{ Throwable -> 0x0166 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x006d
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r2 = r2.getStrokeWidth()     // Catch:{ Throwable -> 0x0166 }
            r0.setStrokeWidth(r2)     // Catch:{ Throwable -> 0x0166 }
        L_0x006d:
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            int r0 = r0.getFillColor()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            int r2 = r2.getRadiusFillColor()     // Catch:{ Throwable -> 0x0166 }
            if (r0 == r2) goto L_0x0086
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            int r2 = r2.getRadiusFillColor()     // Catch:{ Throwable -> 0x0166 }
            r0.setFillColor(r2)     // Catch:{ Throwable -> 0x0166 }
        L_0x0086:
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            int r0 = r0.getStrokeColor()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            int r2 = r2.getStrokeColor()     // Catch:{ Throwable -> 0x0166 }
            if (r0 == r2) goto L_0x009f
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            int r2 = r2.getStrokeColor()     // Catch:{ Throwable -> 0x0166 }
            r0.setStrokeColor(r2)     // Catch:{ Throwable -> 0x0166 }
        L_0x009f:
            com.amap.api.maps.model.LatLng r0 = r5.i     // Catch:{ Throwable -> 0x0166 }
            if (r0 == 0) goto L_0x00aa
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.LatLng r2 = r5.i     // Catch:{ Throwable -> 0x0166 }
            r0.setCenter(r2)     // Catch:{ Throwable -> 0x0166 }
        L_0x00aa:
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            double r2 = r5.j     // Catch:{ Throwable -> 0x0166 }
            r0.setRadius(r2)     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.Circle r0 = r5.g     // Catch:{ Throwable -> 0x0166 }
            r0.setVisible(r1)     // Catch:{ Throwable -> 0x0166 }
        L_0x00b6:
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            r2 = 0
            if (r0 != 0) goto L_0x00cc
            com.amap.api.col.n3.k r0 = r5.e     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MarkerOptions r3 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0166 }
            r3.<init>()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MarkerOptions r3 = r3.visible(r2)     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.Marker r0 = r0.addMarker(r3)     // Catch:{ Throwable -> 0x0166 }
            r5.f = r0     // Catch:{ Throwable -> 0x0166 }
        L_0x00cc:
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            if (r0 == 0) goto L_0x015b
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            float r0 = r0.getAnchorU()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r3 = r3.getAnchorU()     // Catch:{ Throwable -> 0x0166 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00f0
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            float r0 = r0.getAnchorV()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r3 = r3.getAnchorV()     // Catch:{ Throwable -> 0x0166 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0101
        L_0x00f0:
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r3 = r3.getAnchorU()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r4 = r5.h     // Catch:{ Throwable -> 0x0166 }
            float r4 = r4.getAnchorV()     // Catch:{ Throwable -> 0x0166 }
            r0.setAnchor(r3, r4)     // Catch:{ Throwable -> 0x0166 }
        L_0x0101:
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ Throwable -> 0x0166 }
            if (r0 == 0) goto L_0x0142
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ Throwable -> 0x0166 }
            int r0 = r0.size()     // Catch:{ Throwable -> 0x0166 }
            if (r0 != 0) goto L_0x0116
            goto L_0x0142
        L_0x0116:
            com.amap.api.maps.model.MyLocationStyle r0 = r5.h     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.BitmapDescriptor r0 = r0.getMyLocationIcon()     // Catch:{ Throwable -> 0x0166 }
            if (r0 == 0) goto L_0x014b
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ Throwable -> 0x0166 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.BitmapDescriptor r0 = (com.amap.api.maps.model.BitmapDescriptor) r0     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ Throwable -> 0x0166 }
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x0166 }
            if (r0 != 0) goto L_0x014b
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ Throwable -> 0x0166 }
        L_0x013e:
            r0.setIcon(r2)     // Catch:{ Throwable -> 0x0166 }
            goto L_0x014b
        L_0x0142:
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.h     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ Throwable -> 0x0166 }
            goto L_0x013e
        L_0x014b:
            com.amap.api.maps.model.LatLng r0 = r5.i     // Catch:{ Throwable -> 0x0166 }
            if (r0 == 0) goto L_0x015b
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.LatLng r2 = r5.i     // Catch:{ Throwable -> 0x0166 }
            r0.setPosition(r2)     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.Marker r0 = r5.f     // Catch:{ Throwable -> 0x0166 }
            r0.setVisible(r1)     // Catch:{ Throwable -> 0x0166 }
        L_0x015b:
            r5.f()     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.col.n3.t r0 = r5.l     // Catch:{ Throwable -> 0x0166 }
            com.amap.api.maps.model.Marker r1 = r5.f     // Catch:{ Throwable -> 0x0166 }
            r0.a((com.amap.api.maps.model.Marker) r1)     // Catch:{ Throwable -> 0x0166 }
            return
        L_0x0166:
            r0 = move-exception
            java.lang.String r1 = "MyLocationOverlay"
            java.lang.String r2 = "myLocStyle"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.co.g():void");
    }

    public final void b() throws RemoteException {
        if (this.g != null) {
            try {
                this.e.a(this.g.getId());
            } catch (Throwable th) {
                iu.b(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        if (this.f != null) {
            this.f.remove();
            this.f = null;
            this.l.a((Marker) null);
        }
        if (this.l != null) {
            this.l.b();
            this.l = null;
        }
    }

    private void a(boolean z) {
        if (!(this.g == null || this.g.isVisible() == z)) {
            this.g.setVisible(z);
        }
        if (this.f != null && this.f.isVisible() != z) {
            this.f.setVisible(z);
        }
    }

    public final void a(float f2) {
        if (this.f != null) {
            this.f.setRotateAngle(f2);
        }
    }

    public final String c() {
        if (this.f != null) {
            return this.f.getId();
        }
        return null;
    }

    public final String d() throws RemoteException {
        if (this.g != null) {
            return this.g.getId();
        }
        return null;
    }

    public final void e() {
        this.g = null;
        this.f = null;
    }
}
