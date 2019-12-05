package com.amap.api.col.n3;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/* compiled from: GLOverlayLayer */
public final class i {
    k a;
    a b = new a();
    private int c = 0;
    /* access modifiers changed from: private */
    public List<ch> d = new Vector(500);
    private List<Integer> e = new Vector();
    private Handler f = new Handler(Looper.getMainLooper());
    private Runnable g = new Runnable() {
        public final synchronized void run() {
            try {
                synchronized (i.this) {
                    if (i.this.d != null && i.this.d.size() > 0) {
                        Collections.sort(i.this.d, i.this.b);
                    }
                }
            } catch (Throwable th) {
                iu.b(th, "MapOverlayImageView", "changeOverlayIndex");
            }
        }
    };

    /* compiled from: GLOverlayLayer */
    static class a implements Serializable, Comparator<Object> {
        a() {
        }

        public final int compare(Object obj, Object obj2) {
            ch chVar = (ch) obj;
            ch chVar2 = (ch) obj2;
            if (chVar == null || chVar2 == null) {
                return 0;
            }
            try {
                if (chVar.getZIndex() > chVar2.getZIndex()) {
                    return 1;
                }
                if (chVar.getZIndex() < chVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Throwable th) {
                iu.b(th, "GLOverlayLayer", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public final synchronized String a(String str) {
        this.c++;
        return str + this.c;
    }

    public i(k kVar) {
        this.a = kVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x003e
            java.lang.String r0 = r5.trim()     // Catch:{ Throwable -> 0x003c }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x003c }
            if (r0 != 0) goto L_0x000e
            goto L_0x003e
        L_0x000e:
            r0 = 0
            java.util.List<com.amap.api.col.n3.ch> r1 = r4.d     // Catch:{ Throwable -> 0x003c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x003c }
        L_0x0015:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x003c }
            if (r2 == 0) goto L_0x002c
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x003c }
            com.amap.api.col.n3.ch r2 = (com.amap.api.col.n3.ch) r2     // Catch:{ Throwable -> 0x003c }
            java.lang.String r3 = r2.getId()     // Catch:{ Throwable -> 0x003c }
            boolean r3 = r5.equals(r3)     // Catch:{ Throwable -> 0x003c }
            if (r3 == 0) goto L_0x0015
            r0 = r2
        L_0x002c:
            java.util.List<com.amap.api.col.n3.ch> r5 = r4.d     // Catch:{ Throwable -> 0x003c }
            r5.clear()     // Catch:{ Throwable -> 0x003c }
            if (r0 == 0) goto L_0x0038
            java.util.List<com.amap.api.col.n3.ch> r5 = r4.d     // Catch:{ Throwable -> 0x003c }
            r5.add(r0)     // Catch:{ Throwable -> 0x003c }
        L_0x0038:
            monitor-exit(r4)
            return
        L_0x003a:
            r5 = move-exception
            goto L_0x0065
        L_0x003c:
            r5 = move-exception
            goto L_0x0048
        L_0x003e:
            java.util.List<com.amap.api.col.n3.ch> r5 = r4.d     // Catch:{ Throwable -> 0x003c }
            r5.clear()     // Catch:{ Throwable -> 0x003c }
            r4.e()     // Catch:{ Throwable -> 0x003c }
            monitor-exit(r4)
            return
        L_0x0048:
            java.lang.String r0 = "GLOverlayLayer"
            java.lang.String r1 = "clear"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r5, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x003a }
            r5.printStackTrace()     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            java.lang.String r1 = "GLOverlayLayer clear erro"
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x003a }
            r0.append(r5)     // Catch:{ all -> 0x003a }
            r0.toString()     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return
        L_0x0065:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.i.b(java.lang.String):void");
    }

    private synchronized void e() {
        this.c = 0;
    }

    public final synchronized void a() {
        try {
            for (ch destroy : this.d) {
                destroy.destroy();
            }
            b((String) null);
        } catch (Throwable th) {
            iu.b(th, "GLOverlayLayer", "destory");
            th.printStackTrace();
            "GLOverlayLayer destory erro" + th.getMessage();
        }
    }

    private synchronized ch d(String str) throws RemoteException {
        for (ch next : this.d) {
            if (next != null && next.getId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final synchronized ck a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        cr crVar = new cr(this, polylineOptions);
        a((ch) crVar);
        return crVar;
    }

    public final synchronized cg a(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        cp cpVar = new cp(this.a);
        cpVar.setTopColor(navigateArrowOptions.getTopColor());
        cpVar.setPoints(navigateArrowOptions.getPoints());
        cpVar.setVisible(navigateArrowOptions.isVisible());
        cpVar.setWidth(navigateArrowOptions.getWidth());
        cpVar.setZIndex(navigateArrowOptions.getZIndex());
        a((ch) cpVar);
        return cpVar;
    }

    public final synchronized cj a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        cq cqVar = new cq(this.a);
        cqVar.setFillColor(polygonOptions.getFillColor());
        cqVar.setPoints(polygonOptions.getPoints());
        cqVar.setHoleOptions(polygonOptions.getHoleOptions());
        cqVar.setVisible(polygonOptions.isVisible());
        cqVar.setStrokeWidth(polygonOptions.getStrokeWidth());
        cqVar.setZIndex(polygonOptions.getZIndex());
        cqVar.setStrokeColor(polygonOptions.getStrokeColor());
        a((ch) cqVar);
        return cqVar;
    }

    public final synchronized cd a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        bz bzVar = new bz(this.a);
        bzVar.setFillColor(circleOptions.getFillColor());
        bzVar.setCenter(circleOptions.getCenter());
        bzVar.setVisible(circleOptions.isVisible());
        bzVar.setHoleOptions(circleOptions.getHoleOptions());
        bzVar.setStrokeWidth(circleOptions.getStrokeWidth());
        bzVar.setZIndex(circleOptions.getZIndex());
        bzVar.setStrokeColor(circleOptions.getStrokeColor());
        bzVar.setRadius(circleOptions.getRadius());
        a((ch) bzVar);
        return bzVar;
    }

    public final synchronized cc a(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        by byVar = new by(this.a);
        byVar.setStrokeColor(arcOptions.getStrokeColor());
        byVar.a(arcOptions.getStart());
        byVar.b(arcOptions.getPassed());
        byVar.c(arcOptions.getEnd());
        byVar.setVisible(arcOptions.isVisible());
        byVar.setStrokeWidth(arcOptions.getStrokeWidth());
        byVar.setZIndex(arcOptions.getZIndex());
        a((ch) byVar);
        return byVar;
    }

    public final synchronized ce a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        cb cbVar = new cb(this.a);
        cbVar.a(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        cbVar.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        cbVar.setImage(groundOverlayOptions.getImage());
        cbVar.setPosition(groundOverlayOptions.getLocation());
        cbVar.setPositionFromBounds(groundOverlayOptions.getBounds());
        cbVar.setBearing(groundOverlayOptions.getBearing());
        cbVar.setTransparency(groundOverlayOptions.getTransparency());
        cbVar.setVisible(groundOverlayOptions.isVisible());
        cbVar.setZIndex(groundOverlayOptions.getZIndex());
        a((ch) cbVar);
        return cbVar;
    }

    private void a(ch chVar) throws RemoteException {
        this.d.add(chVar);
        b();
    }

    public final synchronized boolean c(String str) throws RemoteException {
        ch d2 = d(str);
        if (d2 == null) {
            return false;
        }
        return this.d.remove(d2);
    }

    public final synchronized void b() {
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 10);
    }

    public final synchronized void a(boolean z, int i) {
        try {
            for (Integer intValue : this.e) {
                GLES20.glDeleteTextures(1, new int[]{intValue.intValue()}, 0);
            }
            this.e.clear();
            int size = this.d.size();
            for (ch next : this.d) {
                if (next.isVisible()) {
                    if (size > 20) {
                        if (next.a()) {
                            if (z) {
                                if (next.getZIndex() <= ((float) i)) {
                                    next.b();
                                }
                            } else if (next.getZIndex() > ((float) i)) {
                                next.b();
                            }
                        }
                    } else if (z) {
                        if (next.getZIndex() <= ((float) i)) {
                            next.b();
                        }
                    } else if (next.getZIndex() > ((float) i)) {
                        next.b();
                    }
                }
            }
        } catch (Throwable th) {
            iu.b(th, "GLOverlayLayer", "draw");
            th.printStackTrace();
        }
    }

    public final void a(Integer num) {
        if (num.intValue() != 0) {
            this.e.add(num);
        }
    }

    public final synchronized ch a(LatLng latLng) {
        for (ch next : this.d) {
            if (next != null && next.c() && (next instanceof ck) && ((ck) next).a(latLng)) {
                return next;
            }
        }
        return null;
    }

    public final k c() {
        return this.a;
    }

    public final float[] d() {
        if (this.a != null) {
            return this.a.v();
        }
        return new float[16];
    }
}
