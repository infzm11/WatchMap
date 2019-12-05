package com.amap.api.col.n3;

import android.graphics.BitmapFactory;
import android.support.v4.internal.view.SupportMenu;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: LBSNaviCarOverlay */
public final class fo {
    private boolean a;
    private IPoint b;
    private int c;
    private int d;
    private float e;
    private int f;
    private float g;
    private boolean h;
    private Timer i;
    private float j;
    private int k;
    private fq l;
    private BitmapDescriptor m;
    private BitmapDescriptor n;
    private Marker o;
    private Marker p;
    private Marker q;
    private AMap r;
    private TextureMapView s;
    private boolean t;
    private LatLng u;
    private Polyline v;
    private List<LatLng> w;
    private float x;
    private int y;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bc A[Catch:{ Throwable -> 0x01bc, Throwable -> 0x01c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.amap.api.col.n3.fo r10) {
        /*
            boolean r0 = r10.h
            if (r0 == 0) goto L_0x01d3
            com.amap.api.maps.model.Marker r0 = r10.o
            if (r0 == 0) goto L_0x01d3
            com.amap.api.maps.AMap r0 = r10.r
            if (r0 == 0) goto L_0x01d3
            com.amap.api.maps.model.Marker r0 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            com.autonavi.amap.mapcore.IPoint r0 = r0.getGeoPoint()     // Catch:{ Throwable -> 0x01c8 }
            int r1 = r10.f     // Catch:{ Throwable -> 0x01c8 }
            int r2 = r1 + 1
            r10.f = r2     // Catch:{ Throwable -> 0x01c8 }
            r2 = 20
            if (r1 >= r2) goto L_0x01c7
            com.autonavi.amap.mapcore.IPoint r1 = r10.b     // Catch:{ Throwable -> 0x01c8 }
            int r1 = r1.x     // Catch:{ Throwable -> 0x01c8 }
            int r2 = r10.c     // Catch:{ Throwable -> 0x01c8 }
            int r3 = r10.f     // Catch:{ Throwable -> 0x01c8 }
            int r2 = r2 * r3
            int r1 = r1 + r2
            com.autonavi.amap.mapcore.IPoint r2 = r10.b     // Catch:{ Throwable -> 0x01c8 }
            int r2 = r2.y     // Catch:{ Throwable -> 0x01c8 }
            int r3 = r10.d     // Catch:{ Throwable -> 0x01c8 }
            int r4 = r10.f     // Catch:{ Throwable -> 0x01c8 }
            int r3 = r3 * r4
            int r2 = r2 + r3
            float r3 = r10.g     // Catch:{ Throwable -> 0x01c8 }
            float r4 = r10.e     // Catch:{ Throwable -> 0x01c8 }
            int r5 = r10.f     // Catch:{ Throwable -> 0x01c8 }
            float r5 = (float) r5     // Catch:{ Throwable -> 0x01c8 }
            float r4 = r4 * r5
            float r3 = r3 + r4
            r10.j = r3     // Catch:{ Throwable -> 0x01c8 }
            float r3 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            r4 = 1155596288(0x44e10000, float:1800.0)
            float r3 = r3 % r4
            r10.j = r3     // Catch:{ Throwable -> 0x01c8 }
            if (r1 != 0) goto L_0x0046
            if (r2 == 0) goto L_0x004b
        L_0x0046:
            com.autonavi.amap.mapcore.IPoint r0 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Throwable -> 0x01c8 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x01c8 }
        L_0x004b:
            boolean r1 = r10.a     // Catch:{ Throwable -> 0x01c8 }
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1
            if (r1 == 0) goto L_0x011c
            com.amap.api.col.n3.fq r1 = r10.l     // Catch:{ Throwable -> 0x01c8 }
            int r1 = r1.e()     // Catch:{ Throwable -> 0x01c8 }
            r4 = 0
            r5 = 0
            if (r1 != r3) goto L_0x00d1
            com.amap.api.maps.TextureMapView r1 = r10.s     // Catch:{ Throwable -> 0x01c8 }
            int r1 = r1.getWidth()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = (double) r1     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.col.n3.fq r1 = r10.l     // Catch:{ Throwable -> 0x01c8 }
            double r8 = r1.a()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = r6 * r8
            int r1 = (int) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.TextureMapView r6 = r10.s     // Catch:{ Throwable -> 0x01c8 }
            int r6 = r6.getHeight()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = (double) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.col.n3.fq r8 = r10.l     // Catch:{ Throwable -> 0x01c8 }
            double r8 = r8.b()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = r6 * r8
            int r6 = (int) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r7 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r7.setPositionByPixels(r1, r6)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r7 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r7.setFlat(r5)     // Catch:{ Throwable -> 0x01c8 }
            int r7 = r10.y     // Catch:{ Throwable -> 0x01c8 }
            if (r7 == r3) goto L_0x00a1
            int r7 = r10.y     // Catch:{ Throwable -> 0x01c8 }
            r8 = 2
            if (r7 != r8) goto L_0x008e
            goto L_0x00a1
        L_0x008e:
            com.amap.api.maps.AMap r7 = r10.r     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.CameraUpdate r4 = com.amap.api.maps.CameraUpdateFactory.changeBearingGeoCenter(r4, r0)     // Catch:{ Throwable -> 0x01c8 }
            r7.moveCamera(r4)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r4 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r2 - r7
            r4.setRotateAngle(r7)     // Catch:{ Throwable -> 0x01c8 }
            goto L_0x00b8
        L_0x00a1:
            com.amap.api.maps.AMap r4 = r10.r     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r10.x     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.CameraUpdate r7 = com.amap.api.maps.CameraUpdateFactory.changeBearingGeoCenter(r7, r0)     // Catch:{ Throwable -> 0x01c8 }
            r4.moveCamera(r7)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r4 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r10.x     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r7 - r2
            float r8 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            float r7 = r7 - r8
            float r7 = r7 % r2
            r4.setRotateAngle(r7)     // Catch:{ Throwable -> 0x01c8 }
        L_0x00b8:
            com.amap.api.maps.model.Marker r4 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            if (r4 == 0) goto L_0x0138
            com.amap.api.maps.model.Marker r4 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            r4.setPositionByPixels(r1, r6)     // Catch:{ Throwable -> 0x01c8 }
            boolean r1 = r10.t     // Catch:{ Throwable -> 0x01c8 }
            if (r1 == 0) goto L_0x00cb
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
        L_0x00c7:
            r1.setVisible(r3)     // Catch:{ Throwable -> 0x01c8 }
            goto L_0x0138
        L_0x00cb:
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
        L_0x00cd:
            r1.setVisible(r5)     // Catch:{ Throwable -> 0x01c8 }
            goto L_0x0138
        L_0x00d1:
            com.amap.api.maps.AMap r1 = r10.r     // Catch:{ Throwable -> 0x01c8 }
            float r6 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.CameraUpdate r6 = com.amap.api.maps.CameraUpdateFactory.changeBearingGeoCenter(r6, r0)     // Catch:{ Throwable -> 0x01c8 }
            r1.moveCamera(r6)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.TextureMapView r1 = r10.s     // Catch:{ Throwable -> 0x01c8 }
            int r1 = r1.getWidth()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = (double) r1     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.col.n3.fq r1 = r10.l     // Catch:{ Throwable -> 0x01c8 }
            double r8 = r1.a()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = r6 * r8
            int r1 = (int) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.TextureMapView r6 = r10.s     // Catch:{ Throwable -> 0x01c8 }
            int r6 = r6.getHeight()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = (double) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.col.n3.fq r8 = r10.l     // Catch:{ Throwable -> 0x01c8 }
            double r8 = r8.b()     // Catch:{ Throwable -> 0x01c8 }
            double r6 = r6 * r8
            int r6 = (int) r6     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r7 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r7.setPositionByPixels(r1, r6)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r7 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r7.setRotateAngle(r4)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r4 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r4.setFlat(r5)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r4 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            if (r4 == 0) goto L_0x0138
            com.amap.api.maps.model.Marker r4 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            r4.setPositionByPixels(r1, r6)     // Catch:{ Throwable -> 0x01c8 }
            boolean r1 = r10.t     // Catch:{ Throwable -> 0x01c8 }
            if (r1 == 0) goto L_0x0119
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            goto L_0x00c7
        L_0x0119:
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            goto L_0x00cd
        L_0x011c:
            com.amap.api.maps.model.Marker r1 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r1.setGeoPoint(r0)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r1 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            r1.setFlat(r3)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r1 = r10.o     // Catch:{ Throwable -> 0x01c8 }
            float r3 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            float r3 = r2 - r3
            r1.setRotateAngle(r3)     // Catch:{ Throwable -> 0x01c8 }
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            if (r1 == 0) goto L_0x0138
            com.amap.api.maps.model.Marker r1 = r10.q     // Catch:{ Throwable -> 0x01c8 }
            r1.setGeoPoint(r0)     // Catch:{ Throwable -> 0x01c8 }
        L_0x0138:
            com.amap.api.maps.model.Marker r1 = r10.p     // Catch:{ Throwable -> 0x01c8 }
            if (r1 == 0) goto L_0x0141
            com.amap.api.maps.model.Marker r1 = r10.p     // Catch:{ Throwable -> 0x01c8 }
            r1.setGeoPoint(r0)     // Catch:{ Throwable -> 0x01c8 }
        L_0x0141:
            com.amap.api.maps.model.Marker r1 = r10.p     // Catch:{ Throwable -> 0x01c8 }
            if (r1 == 0) goto L_0x014d
            com.amap.api.maps.model.Marker r1 = r10.p     // Catch:{ Throwable -> 0x01c8 }
            float r3 = r10.j     // Catch:{ Throwable -> 0x01c8 }
            float r2 = r2 - r3
            r1.setRotateAngle(r2)     // Catch:{ Throwable -> 0x01c8 }
        L_0x014d:
            int r1 = r10.k     // Catch:{ Throwable -> 0x01bc }
            r2 = -1
            if (r1 != r2) goto L_0x0153
            return
        L_0x0153:
            com.amap.api.maps.model.LatLng r1 = r10.u     // Catch:{ Throwable -> 0x01bc }
            if (r1 == 0) goto L_0x01b2
            com.autonavi.amap.mapcore.DPoint r1 = new com.autonavi.amap.mapcore.DPoint     // Catch:{ Throwable -> 0x01bc }
            r1.<init>()     // Catch:{ Throwable -> 0x01bc }
            int r1 = r0.x     // Catch:{ Throwable -> 0x01bc }
            long r1 = (long) r1     // Catch:{ Throwable -> 0x01bc }
            int r0 = r0.y     // Catch:{ Throwable -> 0x01bc }
            long r3 = (long) r0     // Catch:{ Throwable -> 0x01bc }
            com.autonavi.amap.mapcore.DPoint r0 = com.amap.api.col.n3.hu.a((long) r1, (long) r3)     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.LatLng r7 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x01bc }
            double r2 = r0.y     // Catch:{ Throwable -> 0x01bc }
            double r4 = r0.x     // Catch:{ Throwable -> 0x01bc }
            r6 = 0
            r1 = r7
            r1.<init>(r2, r4, r6)     // Catch:{ Throwable -> 0x01bc }
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r10.w     // Catch:{ Throwable -> 0x01bc }
            r0.clear()     // Catch:{ Throwable -> 0x01bc }
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r10.w     // Catch:{ Throwable -> 0x01bc }
            r0.add(r7)     // Catch:{ Throwable -> 0x01bc }
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r10.w     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.LatLng r1 = r10.u     // Catch:{ Throwable -> 0x01bc }
            r0.add(r1)     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.Polyline r0 = r10.v     // Catch:{ Throwable -> 0x01bc }
            if (r0 != 0) goto L_0x01aa
            com.amap.api.maps.AMap r0 = r10.r     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.PolylineOptions r1 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x01bc }
            r1.<init>()     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.PolylineOptions r1 = r1.add((com.amap.api.maps.model.LatLng) r7)     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.LatLng r2 = r10.u     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.PolylineOptions r1 = r1.add((com.amap.api.maps.model.LatLng) r2)     // Catch:{ Throwable -> 0x01bc }
            int r2 = r10.k     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.PolylineOptions r1 = r1.color(r2)     // Catch:{ Throwable -> 0x01bc }
            r2 = 1084227584(0x40a00000, float:5.0)
            com.amap.api.maps.model.PolylineOptions r1 = r1.width(r2)     // Catch:{ Throwable -> 0x01bc }
            com.amap.api.maps.model.Polyline r0 = r0.addPolyline(r1)     // Catch:{ Throwable -> 0x01bc }
            r10.v = r0     // Catch:{ Throwable -> 0x01bc }
            return
        L_0x01aa:
            com.amap.api.maps.model.Polyline r0 = r10.v     // Catch:{ Throwable -> 0x01bc }
            java.util.List<com.amap.api.maps.model.LatLng> r10 = r10.w     // Catch:{ Throwable -> 0x01bc }
            r0.setPoints(r10)     // Catch:{ Throwable -> 0x01bc }
            return
        L_0x01b2:
            com.amap.api.maps.model.Polyline r0 = r10.v     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x01bb
            com.amap.api.maps.model.Polyline r10 = r10.v     // Catch:{ Throwable -> 0x01bc }
            r10.remove()     // Catch:{ Throwable -> 0x01bc }
        L_0x01bb:
            return
        L_0x01bc:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ Throwable -> 0x01c8 }
            java.lang.String r0 = "NaviCarOverlay"
            java.lang.String r1 = "drawLeaderLine(IPoint nowPoint"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r10, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x01c8 }
        L_0x01c7:
            return
        L_0x01c8:
            r10 = move-exception
            r10.printStackTrace()
            java.lang.String r0 = "NaviCarOverlay"
            java.lang.String r1 = "drawLeaderLine(IPoint nowPoint"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r10, (java.lang.String) r0, (java.lang.String) r1)
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fo.a(com.amap.api.col.n3.fo):void");
    }

    public fo(TextureMapView textureMapView, fq fqVar) {
        this.a = true;
        this.b = null;
        this.g = 0.0f;
        this.h = false;
        this.j = 0.0f;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.r = null;
        this.t = true;
        this.u = null;
        this.v = null;
        this.w = new ArrayList();
        this.y = 0;
        this.m = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837655));
        this.n = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837686));
        this.s = textureMapView;
        this.l = fqVar;
    }

    public final void a() {
        if (this.p != null) {
            this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.p.getPosition(), (float) this.l.c(), 0.0f, 0.0f)));
            this.o.setRotateAngle(360.0f - this.j);
        }
    }

    public final void b() {
        if (this.p != null) {
            this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.p.getPosition(), (float) this.l.c(), (float) this.l.d(), this.j)));
            this.o.setFlat(false);
            this.o.setRotateAngle(0.0f);
        }
    }

    public final void a(boolean z) {
        this.a = z;
        if (this.o != null && this.r != null && this.q != null && this.p != null) {
            if (!this.a) {
                this.o.setFlat(true);
                this.q.setGeoPoint(this.p.getGeoPoint());
                this.o.setGeoPoint(this.p.getGeoPoint());
                this.o.setRotateAngle(this.p.getRotateAngle());
            } else if (this.l.e() == 1) {
                this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.p.getPosition()).bearing(0.0f).tilt(0.0f).zoom((float) this.l.c()).build()));
                this.o.setPositionByPixels((int) (((double) this.s.getWidth()) * this.l.a()), (int) (((double) this.s.getHeight()) * this.l.b()));
                this.o.setRotateAngle(360.0f - this.j);
                this.o.setFlat(false);
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            } else {
                this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.p.getPosition()).bearing(this.j).tilt((float) this.l.d()).zoom((float) this.l.c()).build()));
                this.o.setPositionByPixels((int) (((double) this.s.getWidth()) * this.l.a()), (int) (((double) this.s.getHeight()) * this.l.b()));
                this.o.setRotateAngle(0.0f);
                this.o.setFlat(false);
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            }
        }
    }

    public final void c() {
        if (this.o != null) {
            this.o.remove();
        }
        if (this.q != null) {
            this.q.remove();
        }
        if (this.p != null) {
            this.p.remove();
        }
        if (this.v != null) {
            this.v.remove();
        }
        this.v = null;
        this.o = null;
        this.q = null;
        this.p = null;
    }

    public final void a(AMap aMap, LatLng latLng, float f2) {
        if (aMap != null && latLng != null && this.m != null) {
            this.r = aMap;
            if (this.o == null) {
                this.o = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.m).position(latLng));
            }
            boolean z = false;
            if (this.p == null) {
                this.p = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.m).position(latLng));
                this.p.setRotateAngle(f2);
                this.p.setVisible(false);
            }
            if (this.q == null) {
                this.q = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.n).position(latLng));
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            }
            this.o.setVisible(true);
            new IPoint();
            IPoint a2 = hu.a(latLng.latitude, latLng.longitude);
            if (this.o != null) {
                IPoint geoPoint = this.p.getGeoPoint();
                if (geoPoint == null || geoPoint.x == 0 || geoPoint.y == 0) {
                    geoPoint = a2;
                }
                this.f = 0;
                this.b = geoPoint;
                this.c = (a2.x - geoPoint.x) / 20;
                this.d = (a2.y - geoPoint.y) / 20;
                this.g = this.p.getRotateAngle();
                if (Float.compare(this.g, f2) == 0) {
                    z = true;
                } else {
                    this.g = 360.0f - this.g;
                }
                float f3 = f2 - this.g;
                if (z) {
                    f3 = 0.0f;
                }
                if (f3 > 180.0f) {
                    f3 -= 360.0f;
                } else if (f3 < -180.0f) {
                    f3 += 360.0f;
                }
                this.e = f3 / 20.0f;
                this.h = true;
            }
            if (this.i == null) {
                this.i = new Timer();
                this.i.schedule(new TimerTask() {
                    public final void run() {
                        try {
                            fo.a(fo.this);
                        } catch (Throwable unused) {
                        }
                    }
                }, 0, 50);
            }
        }
    }

    public final void a(LatLng latLng) {
        this.u = latLng;
    }

    public final void d() {
        if (this.o != null) {
            this.o.remove();
        }
        if (this.p != null) {
            this.p.remove();
        }
        if (this.q != null) {
            this.q.remove();
        }
        this.m = null;
        if (this.i != null) {
            this.i.cancel();
        }
    }

    public final void e() {
        if (this.v != null) {
            this.v.remove();
        }
    }

    public final void f() {
        this.k = SupportMenu.CATEGORY_MASK;
    }

    public final void g() {
        if (this.o != null) {
            int width = (int) (((double) this.s.getWidth()) * this.l.a());
            int height = (int) (((double) this.s.getHeight()) * this.l.b());
            if (this.a) {
                LatLng position = this.p.getPosition();
                if (this.l.e() == 1) {
                    int width2 = (int) (((double) this.s.getWidth()) * this.l.a());
                    int height2 = (int) (((double) this.s.getHeight()) * this.l.b());
                    this.o.setPositionByPixels(width2, height2);
                    this.o.setFlat(false);
                    this.r.moveCamera(CameraUpdateFactory.changeBearing(0.0f));
                    this.o.setRotateAngle(360.0f - this.j);
                    if (this.q != null) {
                        this.q.setPositionByPixels(width2, height2);
                        if (this.t) {
                            this.q.setVisible(true);
                        } else {
                            this.q.setVisible(false);
                        }
                    }
                } else {
                    this.r.moveCamera(CameraUpdateFactory.changeBearing(this.j));
                    this.r.moveCamera(CameraUpdateFactory.changeLatLng(position));
                    this.o.setPositionByPixels(width, height);
                    if (this.q != null) {
                        this.q.setPositionByPixels(width, height);
                        if (!this.t || !this.a) {
                            this.q.setVisible(false);
                        } else {
                            this.q.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    public final void a(float f2) {
        this.x = f2;
    }

    public final void a(int i2) {
        this.y = i2;
    }
}
