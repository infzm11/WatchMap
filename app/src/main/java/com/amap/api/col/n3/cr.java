package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.col.n3.cw;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: PolylineDelegateImp */
public final class cr implements ck {
    private boolean A = false;
    private boolean B = false;
    private boolean C = true;
    private int D = 0;
    private int E = 0;
    private int F = ViewCompat.MEASURED_STATE_MASK;
    private int G = 0;
    private float H = 10.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O = 1.0f;
    private float P = 0.0f;
    private float[] Q;
    private int[] R;
    private int[] S;
    private double T = 5.0d;
    private boolean U = false;
    private final int V = 2;
    private FPointBounds W = null;
    private PolylineOptions X;
    private int Y = 0;
    private int Z = 2;
    Rect a = null;
    private cw.d aa;
    int b = 0;
    int c = 0;
    ArrayList<FPoint> d = new ArrayList<>();
    long e = 0;
    private i f;
    private String g;
    private List<IPoint> h = new ArrayList();
    private List<FPoint> i = new ArrayList();
    private List<LatLng> j = new ArrayList();
    private List<BitmapDescriptor> k = new ArrayList();
    private List<r> l = new ArrayList();
    private List<Integer> m = new ArrayList();
    private List<Integer> n = new ArrayList();
    private List<Integer> o = new ArrayList();
    private List<Integer> p = new ArrayList();
    private FloatBuffer q;
    private BitmapDescriptor r = null;
    private LatLngBounds s = null;
    private Object t = new Object();
    private boolean u = true;
    private boolean v = true;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = true;

    public final void setGeodesic(boolean z2) throws RemoteException {
        this.w = z2;
        this.f.c().setRunLowFrame(false);
    }

    public final boolean isGeodesic() {
        return this.w;
    }

    public final void setDottedLine(boolean z2) {
        if (this.D == 2 || this.D == 0) {
            this.x = z2;
            if (z2 && this.v) {
                this.D = 2;
            }
            this.f.c().setRunLowFrame(false);
        }
    }

    public final boolean isDottedLine() {
        return this.x;
    }

    public cr(i iVar, PolylineOptions polylineOptions) {
        this.f = iVar;
        setOptions(polylineOptions);
        try {
            this.g = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "PolylineDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private static void a(List<IPoint> list, List<IPoint> list2, double d2) {
        List<IPoint> list3 = list;
        if (list3.size() == 3) {
            int i2 = 0;
            int i3 = 0;
            while (i3 <= 10) {
                float f2 = (float) i3;
                float f3 = f2 / 10.0f;
                IPoint obtain = IPoint.obtain();
                double d3 = 1.0d - ((double) f3);
                double d4 = d3 * d3;
                double d5 = ((double) (2.0f * f3)) * d3;
                float f4 = f3 * f3;
                double d6 = (((double) list3.get(i2).x) * d4) + (((double) list3.get(1).x) * d5 * d2) + ((double) (((float) list3.get(2).x) * f4));
                double d7 = (((double) list3.get(i2).y) * d4) + (((double) list3.get(1).y) * d5 * d2) + ((double) (((float) list3.get(2).y) * f4));
                double d8 = d4 + (d5 * d2) + ((double) f4);
                obtain.x = (int) (d6 / d8);
                obtain.y = (int) (d7 / d8);
                list2.add(obtain);
                i3 = (int) (1.0f + f2);
                i2 = 0;
            }
        }
    }

    public final void remove() throws RemoteException {
        this.f.c(getId());
        setVisible(false);
        this.f.c().setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.g == null) {
            this.g = this.f.a("Polyline");
        }
        return this.g;
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        Object obj;
        Throwable th;
        LatLngBounds.Builder builder;
        LatLng latLng;
        Iterator<LatLng> it;
        cr crVar = this;
        List<LatLng> list2 = list;
        try {
            crVar.j = list2;
            Object obj2 = crVar.t;
            synchronized (obj2) {
                try {
                    ArrayList arrayList = new ArrayList();
                    LatLngBounds.Builder builder2 = LatLngBounds.builder();
                    if (list2 != null) {
                        LatLng latLng2 = null;
                        Iterator<LatLng> it2 = list.iterator();
                        while (it2.hasNext()) {
                            LatLng next = it2.next();
                            if (!crVar.w) {
                                try {
                                    IPoint obtain = IPoint.obtain();
                                    crVar.f.c().a(next.latitude, next.longitude, obtain);
                                    arrayList.add(obtain);
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj = obj2;
                                }
                            } else {
                                if (latLng2 != null) {
                                    if (Math.abs(next.longitude - latLng2.longitude) < 0.01d) {
                                        IPoint obtain2 = IPoint.obtain();
                                        crVar.f.c().a(latLng2.latitude, latLng2.longitude, obtain2);
                                        arrayList.add(obtain2);
                                        builder2.include(latLng2);
                                        IPoint obtain3 = IPoint.obtain();
                                        crVar.f.c().a(next.latitude, next.longitude, obtain3);
                                        arrayList.add(obtain3);
                                    } else {
                                        obj = obj2;
                                        double abs = (Math.abs(latLng2.longitude - next.longitude) * 3.141592653589793d) / 180.0d;
                                        LatLng latLng3 = r12;
                                        LatLng latLng4 = new LatLng((next.latitude + latLng2.latitude) / 2.0d, (next.longitude + latLng2.longitude) / 2.0d, false);
                                        builder2.include(latLng2).include(latLng3).include(next);
                                        int i2 = latLng3.latitude > 0.0d ? -1 : 1;
                                        IPoint obtain4 = IPoint.obtain();
                                        crVar.f.c().a(latLng2.latitude, latLng2.longitude, obtain4);
                                        IPoint obtain5 = IPoint.obtain();
                                        crVar.f.c().a(next.latitude, next.longitude, obtain5);
                                        IPoint obtain6 = IPoint.obtain();
                                        crVar.f.c().a(latLng3.latitude, latLng3.longitude, obtain6);
                                        double d2 = abs * 0.5d;
                                        double cos = Math.cos(d2);
                                        it = it2;
                                        latLng = next;
                                        builder = builder2;
                                        double hypot = Math.hypot((double) (obtain4.x - obtain5.x), (double) (obtain4.y - obtain5.y)) * 0.5d * Math.tan(d2);
                                        IPoint obtain7 = IPoint.obtain();
                                        double d3 = (double) (obtain5.x - obtain4.x);
                                        double d4 = (double) (obtain5.y - obtain4.y);
                                        double d5 = cos;
                                        try {
                                            obtain7.y = (int) (((((double) i2) * hypot) / Math.sqrt(((d4 * d4) / (d3 * d3)) + 1.0d)) + ((double) obtain6.y));
                                            obtain7.x = (int) (((((double) (obtain6.y - obtain7.y)) * d4) / d3) + ((double) obtain6.x));
                                            ArrayList arrayList2 = new ArrayList();
                                            arrayList2.add(obtain4);
                                            arrayList2.add(obtain7);
                                            arrayList2.add(obtain5);
                                            a(arrayList2, arrayList, d5);
                                            obtain4.recycle();
                                            obtain7.recycle();
                                            obtain5.recycle();
                                            obj2 = obj;
                                            it2 = it;
                                            latLng2 = latLng;
                                            builder2 = builder;
                                            crVar = this;
                                            List<LatLng> list3 = list;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                }
                                obj = obj2;
                                builder = builder2;
                                it = it2;
                                latLng = next;
                                obj2 = obj;
                                it2 = it;
                                latLng2 = latLng;
                                builder2 = builder;
                                crVar = this;
                                List<LatLng> list32 = list;
                            }
                            builder2.include(next);
                            obj = obj2;
                            builder = builder2;
                            it = it2;
                            latLng = next;
                            obj2 = obj;
                            it2 = it;
                            latLng2 = latLng;
                            builder2 = builder;
                            crVar = this;
                            List<LatLng> list322 = list;
                        }
                    }
                    obj = obj2;
                    LatLngBounds.Builder builder3 = builder2;
                    crVar.h = arrayList;
                    crVar.G = 0;
                    if (crVar.h.size() > 0) {
                        crVar.s = builder3.build();
                    }
                    if (crVar.a == null) {
                        crVar.a = new Rect();
                    }
                    dv.a(crVar.a);
                    for (IPoint next2 : crVar.h) {
                        dv.b(crVar.a, next2.x, next2.y);
                    }
                    crVar.a.sort();
                    crVar.f.c().setRunLowFrame(false);
                    crVar.z = true;
                    crVar.f.c().setRunLowFrame(false);
                    crVar.X.setPoints(list);
                } catch (Throwable th4) {
                    th = th4;
                    obj = obj2;
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            iu.b(th6, "PolylineDelegateImp", "setPoints");
            crVar.h.clear();
            th6.printStackTrace();
        }
    }

    public final List<LatLng> getPoints() throws RemoteException {
        return this.j;
    }

    public final void setWidth(float f2) throws RemoteException {
        this.H = f2;
        this.f.c().setRunLowFrame(false);
        this.X.width(f2);
    }

    public final float getWidth() throws RemoteException {
        return this.H;
    }

    public final void setColor(int i2) {
        if (this.D == 0 || this.D == 2) {
            this.F = i2;
            this.K = ((float) Color.alpha(i2)) / 255.0f;
            this.L = ((float) Color.red(i2)) / 255.0f;
            this.M = ((float) Color.green(i2)) / 255.0f;
            this.N = ((float) Color.blue(i2)) / 255.0f;
            if (this.v) {
                if (this.x) {
                    this.D = 2;
                } else {
                    this.D = 0;
                }
            }
            this.f.c().setRunLowFrame(false);
        }
        this.X.color(i2);
    }

    public final int getColor() throws RemoteException {
        return this.F;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.I = f2;
        this.f.b();
        this.f.c().setRunLowFrame(false);
        if (this.X != null) {
            this.X.zIndex(f2);
        }
    }

    public final float getZIndex() throws RemoteException {
        return this.I;
    }

    public final void setVisible(boolean z2) throws RemoteException {
        this.u = z2;
        this.f.c().setRunLowFrame(false);
        if (this.X != null) {
            this.X.visible(z2);
        }
    }

    public final boolean isVisible() throws RemoteException {
        return this.u;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public final boolean a() {
        Rectangle geoRectangle = this.f.c().getMapConfig().getGeoRectangle();
        if (this.a == null || geoRectangle == null || geoRectangle.isOverlap(this.a)) {
            return true;
        }
        return false;
    }

    private boolean d() throws RemoteException {
        synchronized (this.t) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.i.clear();
            int i2 = 0;
            this.B = false;
            this.Q = new float[(3 * this.h.size())];
            this.b = this.Q.length;
            for (IPoint next : this.h) {
                FPoint3 fPoint3 = new FPoint3();
                this.f.c().a(next.y, next.x, (FPoint) fPoint3);
                int i3 = i2 * 3;
                this.Q[i3] = fPoint3.x;
                this.Q[i3 + 1] = fPoint3.y;
                this.Q[i3 + 2] = 0.0f;
                if (this.m != null && this.m.size() > i2) {
                    fPoint3.setColorIndex(this.m.get(i2).intValue());
                } else if (this.n != null && this.n.size() > i2) {
                    fPoint3.setColorIndex(this.n.get(i2).intValue());
                }
                this.i.add(fPoint3);
                builder.include(fPoint3);
                i2++;
            }
            this.W = builder.build();
        }
        if (!this.C) {
            this.q = dv.a(this.Q);
        }
        this.G = this.h.size();
        e();
        return true;
    }

    private void e() {
        if (this.G <= 5000 || this.J > 12.0f) {
            this.P = this.f.c().c().getMapLenWithWin(10);
            return;
        }
        float f2 = (this.H / 2.0f) + (this.J / 2.0f);
        if (f2 > 200.0f) {
            f2 = 200.0f;
        }
        this.P = this.f.c().c().getMapLenWithWin((int) f2);
    }

    private void a(List<FPoint> list) throws RemoteException {
        int i2;
        this.d.clear();
        int size = list.size();
        if (size >= 2) {
            int i3 = 0;
            FPoint fPoint = list.get(0);
            this.d.add(fPoint);
            FPoint fPoint2 = fPoint;
            int i4 = 1;
            while (true) {
                i2 = size - 1;
                if (i4 >= i2) {
                    break;
                }
                FPoint fPoint3 = list.get(i4);
                if (i4 != 1) {
                    if (!(Math.abs(fPoint3.x - fPoint2.x) >= this.P || Math.abs(fPoint3.y - fPoint2.y) >= this.P)) {
                        this.d.remove(this.d.size() - 1);
                        this.d.add(fPoint3);
                        i4++;
                    }
                }
                this.d.add(fPoint3);
                fPoint2 = fPoint3;
                i4++;
            }
            this.d.add(list.get(i2));
            int size2 = this.d.size() * 3;
            this.b = size2;
            if (this.Q == null || this.Q.length < this.b) {
                this.Q = new float[size2];
            }
            if (this.D == 5 || this.D == 3) {
                int[] iArr = new int[this.d.size()];
                ArrayList arrayList = new ArrayList();
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < size2 / 3; i7++) {
                    FPoint3 fPoint32 = (FPoint3) this.d.get(i7);
                    int i8 = i7 * 3;
                    this.Q[i8] = fPoint32.x;
                    this.Q[i8 + 1] = fPoint32.y;
                    this.Q[i8 + 2] = 0.0f;
                    int i9 = fPoint32.colorIndex;
                    if (i7 == 0) {
                        arrayList.add(Integer.valueOf(i9));
                    } else if (i9 == i5) {
                    } else {
                        if (i9 == -1) {
                            i9 = i5;
                        }
                        arrayList.add(Integer.valueOf(i9));
                    }
                    iArr[i6] = i7;
                    i6++;
                    i5 = i9;
                }
                this.R = new int[arrayList.size()];
                System.arraycopy(iArr, 0, this.R, 0, this.R.length);
                this.o = arrayList;
                this.p = arrayList;
                return;
            }
            Iterator<FPoint> it = this.d.iterator();
            while (it.hasNext()) {
                FPoint next = it.next();
                int i10 = i3 * 3;
                this.Q[i10] = next.x;
                this.Q[i10 + 1] = next.y;
                this.Q[i10 + 2] = 0.0f;
                i3++;
            }
        }
    }

    public final void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.e >= 16) {
            this.e = nanoTime;
            if (bitmapDescriptor != null) {
                synchronized (this) {
                    this.v = false;
                    this.y = false;
                    this.D = 1;
                    this.r = bitmapDescriptor;
                    this.f.c().setRunLowFrame(false);
                    if (this.X != null) {
                        this.X.setCustomTexture(bitmapDescriptor);
                    }
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x024c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x024f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x029f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a0, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0316, code lost:
        r20 = r2.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x031a, code lost:
        com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineByTextureID(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x033a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x033d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03eb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03ee, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0474, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0477, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016f, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:148:0x02d3, B:165:0x0332, B:211:0x03e3, B:237:0x046c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:56:0x0159, B:61:0x0164, B:104:0x0244] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:148:0x02d3=Splitter:B:148:0x02d3, B:198:0x0396=Splitter:B:198:0x0396} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() throws android.os.RemoteException {
        /*
            r21 = this;
            r1 = r21
            java.util.List<com.autonavi.amap.mapcore.IPoint> r2 = r1.h
            if (r2 == 0) goto L_0x04eb
            java.util.List<com.autonavi.amap.mapcore.IPoint> r2 = r1.h
            int r2 = r2.size()
            if (r2 == 0) goto L_0x04eb
            float r2 = r1.H
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0017
            goto L_0x04eb
        L_0x0017:
            com.amap.api.col.n3.i r2 = r1.f
            com.amap.api.col.n3.k r2 = r2.c()
            if (r2 != 0) goto L_0x0020
            return
        L_0x0020:
            java.lang.Object r2 = r1.t
            monitor-enter(r2)
            com.amap.api.col.n3.i r3 = r1.f     // Catch:{ all -> 0x04e7 }
            com.amap.api.col.n3.k r3 = r3.c()     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch:{ all -> 0x04e7 }
            int r3 = r3.getS_x()     // Catch:{ all -> 0x04e7 }
            com.amap.api.col.n3.i r4 = r1.f     // Catch:{ all -> 0x04e7 }
            com.amap.api.col.n3.k r4 = r4.c()     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.MapConfig r4 = r4.getMapConfig()     // Catch:{ all -> 0x04e7 }
            int r4 = r4.getS_y()     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x04e7 }
            int r5 = r5.size()     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.IPoint> r6 = r1.h     // Catch:{ all -> 0x04e7 }
            int r6 = r6.size()     // Catch:{ all -> 0x04e7 }
            r7 = 0
            if (r5 != r6) goto L_0x0080
            java.util.List<com.autonavi.amap.mapcore.IPoint> r5 = r1.h     // Catch:{ all -> 0x04e7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x04e7 }
            r6 = r7
        L_0x0055:
            boolean r8 = r5.hasNext()     // Catch:{ all -> 0x04e7 }
            if (r8 == 0) goto L_0x00cc
            java.lang.Object r8 = r5.next()     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.IPoint r8 = (com.autonavi.amap.mapcore.IPoint) r8     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r9 = r1.i     // Catch:{ all -> 0x04e7 }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.FPoint r9 = (com.autonavi.amap.mapcore.FPoint) r9     // Catch:{ all -> 0x04e7 }
            int r10 = r8.x     // Catch:{ all -> 0x04e7 }
            int r10 = r10 - r3
            float r10 = (float) r10     // Catch:{ all -> 0x04e7 }
            r9.x = r10     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r9 = r1.i     // Catch:{ all -> 0x04e7 }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.FPoint r9 = (com.autonavi.amap.mapcore.FPoint) r9     // Catch:{ all -> 0x04e7 }
            int r8 = r8.y     // Catch:{ all -> 0x04e7 }
            int r8 = r8 - r4
            float r8 = (float) r8     // Catch:{ all -> 0x04e7 }
            r9.y = r8     // Catch:{ all -> 0x04e7 }
            int r6 = r6 + 1
            goto L_0x0055
        L_0x0080:
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x04e7 }
            r5.clear()     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.IPoint> r5 = r1.h     // Catch:{ all -> 0x04e7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x04e7 }
            r6 = r7
        L_0x008c:
            boolean r8 = r5.hasNext()     // Catch:{ all -> 0x04e7 }
            if (r8 == 0) goto L_0x00cc
            java.lang.Object r8 = r5.next()     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.IPoint r8 = (com.autonavi.amap.mapcore.IPoint) r8     // Catch:{ all -> 0x04e7 }
            com.autonavi.amap.mapcore.FPoint3 r9 = new com.autonavi.amap.mapcore.FPoint3     // Catch:{ all -> 0x04e7 }
            r9.<init>()     // Catch:{ all -> 0x04e7 }
            java.util.List<java.lang.Integer> r10 = r1.m     // Catch:{ all -> 0x04e7 }
            if (r10 == 0) goto L_0x00b8
            java.util.List<java.lang.Integer> r10 = r1.m     // Catch:{ all -> 0x04e7 }
            int r10 = r10.size()     // Catch:{ all -> 0x04e7 }
            if (r10 <= r6) goto L_0x00b8
            java.util.List<java.lang.Integer> r10 = r1.m     // Catch:{ all -> 0x04e7 }
            java.lang.Object r10 = r10.get(r6)     // Catch:{ all -> 0x04e7 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x04e7 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x04e7 }
            r9.setColorIndex(r10)     // Catch:{ all -> 0x04e7 }
        L_0x00b8:
            int r10 = r8.x     // Catch:{ all -> 0x04e7 }
            int r10 = r10 - r3
            float r10 = (float) r10     // Catch:{ all -> 0x04e7 }
            r9.x = r10     // Catch:{ all -> 0x04e7 }
            int r8 = r8.y     // Catch:{ all -> 0x04e7 }
            int r8 = r8 - r4
            float r8 = (float) r8     // Catch:{ all -> 0x04e7 }
            r9.y = r8     // Catch:{ all -> 0x04e7 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r8 = r1.i     // Catch:{ all -> 0x04e7 }
            r8.add(r9)     // Catch:{ all -> 0x04e7 }
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00cc:
            monitor-exit(r2)     // Catch:{ all -> 0x04e7 }
            boolean r2 = r1.z
            if (r2 == 0) goto L_0x00d6
            r21.d()
            r1.z = r7
        L_0x00d6:
            float[] r2 = r1.Q
            r3 = 1
            if (r2 == 0) goto L_0x04e4
            int r2 = r1.G
            if (r2 <= 0) goto L_0x04e4
            boolean r2 = r1.C
            if (r2 == 0) goto L_0x04a4
            com.amap.api.col.n3.i r2 = r1.f
            com.amap.api.col.n3.k r2 = r2.c()
            com.autonavi.amap.mapcore.MapConfig r2 = r2.getMapConfig()
            com.amap.api.col.n3.i r4 = r1.f
            com.amap.api.col.n3.k r4 = r4.c()
            com.autonavi.ae.gmap.GLMapState r4 = r4.c()
            float r5 = r1.H
            int r5 = (int) r5
            float r10 = r4.getMapLenWithWin(r5)
            int r4 = r1.D
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 12
            r11 = 2
            switch(r4) {
                case 0: goto L_0x0414;
                case 1: goto L_0x0369;
                case 2: goto L_0x02a6;
                case 3: goto L_0x020f;
                case 4: goto L_0x01c1;
                case 5: goto L_0x010c;
                default: goto L_0x010a;
            }
        L_0x010a:
            goto L_0x04e4
        L_0x010c:
            boolean r4 = r1.y
            if (r4 != 0) goto L_0x0151
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r4 = r1.k     // Catch:{ Throwable -> 0x0146 }
            if (r4 == 0) goto L_0x0151
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r4 = r1.k     // Catch:{ Throwable -> 0x0146 }
            int r4 = r4.size()     // Catch:{ Throwable -> 0x0146 }
            int[] r4 = new int[r4]     // Catch:{ Throwable -> 0x0146 }
            r1.S = r4     // Catch:{ Throwable -> 0x0146 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0146 }
            if (r4 < r9) goto L_0x0124
            r4 = r3
            goto L_0x0125
        L_0x0124:
            r4 = r7
        L_0x0125:
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r5 = r1.k     // Catch:{ Throwable -> 0x0146 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Throwable -> 0x0146 }
            r6 = r7
        L_0x012c:
            boolean r9 = r5.hasNext()     // Catch:{ Throwable -> 0x0146 }
            if (r9 == 0) goto L_0x0143
            java.lang.Object r9 = r5.next()     // Catch:{ Throwable -> 0x0146 }
            com.amap.api.maps.model.BitmapDescriptor r9 = (com.amap.api.maps.model.BitmapDescriptor) r9     // Catch:{ Throwable -> 0x0146 }
            int r9 = r1.a(r4, r9)     // Catch:{ Throwable -> 0x0146 }
            int[] r12 = r1.S     // Catch:{ Throwable -> 0x0146 }
            r12[r6] = r9     // Catch:{ Throwable -> 0x0146 }
            int r6 = r6 + 1
            goto L_0x012c
        L_0x0143:
            r1.y = r3     // Catch:{ Throwable -> 0x0146 }
            goto L_0x0151
        L_0x0146:
            r0 = move-exception
            r2 = r0
            java.lang.String r4 = "MarkerDelegateImp"
            java.lang.String r5 = "loadtexture"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x04e4
        L_0x0151:
            com.autonavi.amap.mapcore.Rectangle r2 = r2.getGeoRectangle()
            com.autonavi.amap.mapcore.FPoint[] r2 = r2.getClipMapRect()
            java.util.List<com.autonavi.amap.mapcore.FPoint> r4 = r1.i     // Catch:{ Throwable -> 0x029f }
            boolean r5 = r1.a((com.autonavi.amap.mapcore.FPoint[]) r2)     // Catch:{ Throwable -> 0x029f }
            if (r5 == 0) goto L_0x0170
            java.lang.Object r4 = r1.t     // Catch:{ Throwable -> 0x029f }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x029f }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x016c }
            java.util.List r2 = com.amap.api.col.n3.dv.b((com.autonavi.amap.mapcore.FPoint[]) r2, (java.util.List<com.autonavi.amap.mapcore.FPoint>) r5)     // Catch:{ all -> 0x016c }
            monitor-exit(r4)     // Catch:{ all -> 0x016c }
            goto L_0x0171
        L_0x016c:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ Throwable -> 0x029f }
            throw r2     // Catch:{ Throwable -> 0x029f }
        L_0x0170:
            r2 = r4
        L_0x0171:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x029f }
            if (r4 < r11) goto L_0x04e4
            r1.a((java.util.List<com.autonavi.amap.mapcore.FPoint>) r2)     // Catch:{ Throwable -> 0x029f }
            java.util.List<java.lang.Integer> r2 = r1.o     // Catch:{ Throwable -> 0x029f }
            int r2 = r2.size()     // Catch:{ Throwable -> 0x029f }
            int[] r11 = new int[r2]     // Catch:{ Throwable -> 0x029f }
            r2 = r7
        L_0x0183:
            int r4 = r11.length     // Catch:{ Throwable -> 0x029f }
            if (r2 >= r4) goto L_0x019e
            java.util.List<java.lang.Integer> r4 = r1.o     // Catch:{ Throwable -> 0x029f }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Throwable -> 0x029f }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Throwable -> 0x029f }
            int r4 = r4.intValue()     // Catch:{ Throwable -> 0x029f }
            if (r4 >= 0) goto L_0x0195
            r4 = r7
        L_0x0195:
            int[] r5 = r1.S     // Catch:{ Throwable -> 0x029f }
            r4 = r5[r4]     // Catch:{ Throwable -> 0x029f }
            r11[r2] = r4     // Catch:{ Throwable -> 0x029f }
            int r2 = r2 + 1
            goto L_0x0183
        L_0x019e:
            int[] r2 = r1.R     // Catch:{ Throwable -> 0x029f }
            if (r2 == 0) goto L_0x01a3
            r7 = r3
        L_0x01a3:
            r2 = r3 & r7
            if (r2 == 0) goto L_0x04e4
            float[] r2 = r1.Q     // Catch:{ Throwable -> 0x029f }
            int r9 = r1.b     // Catch:{ Throwable -> 0x029f }
            int r12 = r11.length     // Catch:{ Throwable -> 0x029f }
            int[] r13 = r1.R     // Catch:{ Throwable -> 0x029f }
            int[] r4 = r1.R     // Catch:{ Throwable -> 0x029f }
            int r14 = r4.length     // Catch:{ Throwable -> 0x029f }
            float r4 = r1.O     // Catch:{ Throwable -> 0x029f }
            float r15 = r8 - r4
            com.amap.api.col.n3.i r4 = r1.f     // Catch:{ Throwable -> 0x029f }
            float[] r16 = r4.d()     // Catch:{ Throwable -> 0x029f }
            r8 = r2
            com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineByMultiTextureID(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Throwable -> 0x029f }
            goto L_0x04e4
        L_0x01c1:
            java.util.List<java.lang.Integer> r2 = r1.n
            int r2 = r2.size()
            int[] r11 = new int[r2]
        L_0x01c9:
            java.util.List<java.lang.Integer> r2 = r1.n
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x01e2
            java.util.List<java.lang.Integer> r2 = r1.n
            java.lang.Object r2 = r2.get(r7)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r11[r7] = r2
            int r7 = r7 + 1
            goto L_0x01c9
        L_0x01e2:
            r21.d()     // Catch:{ RemoteException -> 0x01e6 }
            goto L_0x01ea
        L_0x01e6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01ea:
            float[] r8 = r1.Q
            float[] r2 = r1.Q
            int r9 = r2.length
            java.util.List<java.lang.Integer> r2 = r1.n
            int r12 = r2.size()
            int[] r13 = r1.R
            int[] r2 = r1.R
            int r14 = r2.length
            com.amap.api.col.n3.i r2 = r1.f
            com.amap.api.col.n3.k r2 = r2.c()
            int r15 = r2.d()
            com.amap.api.col.n3.i r2 = r1.f
            float[] r16 = r2.d()
            com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawGradientColorLine(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x04e4
        L_0x020f:
            java.util.List<java.lang.Integer> r4 = r1.n
            int r4 = r4.size()
            int[] r4 = new int[r4]
            r5 = r7
        L_0x0218:
            java.util.List<java.lang.Integer> r6 = r1.n
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0231
            java.util.List<java.lang.Integer> r6 = r1.n
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0218
        L_0x0231:
            com.autonavi.amap.mapcore.Rectangle r2 = r2.getGeoRectangle()
            com.autonavi.amap.mapcore.FPoint[] r2 = r2.getClipMapRect()
            java.util.List<com.autonavi.amap.mapcore.FPoint> r4 = r1.i     // Catch:{ Throwable -> 0x029f }
            boolean r5 = r1.a((com.autonavi.amap.mapcore.FPoint[]) r2)     // Catch:{ Throwable -> 0x029f }
            if (r5 == 0) goto L_0x0250
            java.lang.Object r4 = r1.t     // Catch:{ Throwable -> 0x029f }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x029f }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x024c }
            java.util.List r2 = com.amap.api.col.n3.dv.b((com.autonavi.amap.mapcore.FPoint[]) r2, (java.util.List<com.autonavi.amap.mapcore.FPoint>) r5)     // Catch:{ all -> 0x024c }
            monitor-exit(r4)     // Catch:{ all -> 0x024c }
            goto L_0x0251
        L_0x024c:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ Throwable -> 0x029f }
            throw r2     // Catch:{ Throwable -> 0x029f }
        L_0x0250:
            r2 = r4
        L_0x0251:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x029f }
            if (r4 < r11) goto L_0x04e4
            r1.a((java.util.List<com.autonavi.amap.mapcore.FPoint>) r2)     // Catch:{ Throwable -> 0x029f }
            java.util.List<java.lang.Integer> r2 = r1.p     // Catch:{ Throwable -> 0x029f }
            int r2 = r2.size()     // Catch:{ Throwable -> 0x029f }
            int[] r12 = new int[r2]     // Catch:{ Throwable -> 0x029f }
            r2 = r7
        L_0x0263:
            int r4 = r12.length     // Catch:{ Throwable -> 0x029f }
            if (r2 >= r4) goto L_0x0277
            java.util.List<java.lang.Integer> r4 = r1.p     // Catch:{ Throwable -> 0x029f }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Throwable -> 0x029f }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Throwable -> 0x029f }
            int r4 = r4.intValue()     // Catch:{ Throwable -> 0x029f }
            r12[r2] = r4     // Catch:{ Throwable -> 0x029f }
            int r2 = r2 + 1
            goto L_0x0263
        L_0x0277:
            int[] r2 = r1.R     // Catch:{ Throwable -> 0x029f }
            if (r2 == 0) goto L_0x027c
            r7 = r3
        L_0x027c:
            r2 = r3 & r7
            if (r2 == 0) goto L_0x04e4
            float[] r8 = r1.Q     // Catch:{ Throwable -> 0x029f }
            int r9 = r1.b     // Catch:{ Throwable -> 0x029f }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x029f }
            com.amap.api.col.n3.k r2 = r2.c()     // Catch:{ Throwable -> 0x029f }
            int r11 = r2.d()     // Catch:{ Throwable -> 0x029f }
            int r13 = r12.length     // Catch:{ Throwable -> 0x029f }
            int[] r14 = r1.R     // Catch:{ Throwable -> 0x029f }
            int[] r2 = r1.R     // Catch:{ Throwable -> 0x029f }
            int r15 = r2.length     // Catch:{ Throwable -> 0x029f }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x029f }
            float[] r16 = r2.d()     // Catch:{ Throwable -> 0x029f }
            com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineByMultiColor(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Throwable -> 0x029f }
            goto L_0x04e4
        L_0x029f:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            goto L_0x04e4
        L_0x02a6:
            boolean r4 = r1.y
            if (r4 != 0) goto L_0x02d3
            monitor-enter(r21)
            com.amap.api.maps.model.BitmapDescriptor r4 = r1.r     // Catch:{ Throwable -> 0x02c5 }
            if (r4 == 0) goto L_0x02c0
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x02c5 }
            if (r4 < r9) goto L_0x02b5
            r4 = r3
            goto L_0x02b6
        L_0x02b5:
            r4 = r7
        L_0x02b6:
            com.amap.api.maps.model.BitmapDescriptor r8 = r1.r     // Catch:{ Throwable -> 0x02c5 }
            int r4 = r1.a(r4, r8)     // Catch:{ Throwable -> 0x02c5 }
            r1.E = r4     // Catch:{ Throwable -> 0x02c5 }
            r1.y = r3     // Catch:{ Throwable -> 0x02c5 }
        L_0x02c0:
            monitor-exit(r21)
            goto L_0x02d3
        L_0x02c2:
            r0 = move-exception
            r2 = r0
            goto L_0x02d1
        L_0x02c5:
            r0 = move-exception
            r2 = r0
            java.lang.String r4 = "MarkerDelegateImp"
            java.lang.String r5 = "loadtexture"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x02c2 }
            monitor-exit(r21)     // Catch:{ all -> 0x02c2 }
            goto L_0x04e4
        L_0x02d1:
            monitor-exit(r21)
            throw r2
        L_0x02d3:
            java.util.List<com.autonavi.amap.mapcore.FPoint> r4 = r1.i     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r8 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r8 = r8.c()     // Catch:{ Throwable -> 0x04e4 }
            if (r8 != 0) goto L_0x02df
            goto L_0x04e4
        L_0x02df:
            double r8 = r2.getChangeRatio()     // Catch:{ Throwable -> 0x04e4 }
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x031f
            float[] r5 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            if (r5 == 0) goto L_0x031f
            int r5 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r5 = r5 + r3
            r1.Y = r5     // Catch:{ Throwable -> 0x04e4 }
            int r5 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r6 = r1.Z     // Catch:{ Throwable -> 0x04e4 }
            if (r5 <= r6) goto L_0x031f
            float[] r8 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r2 = r2.c()     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r2.e()     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            r16 = 0
            r17 = 1
            r18 = 1
            r19 = 0
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
        L_0x0316:
            float[] r20 = r2.d()     // Catch:{ Throwable -> 0x04e4 }
        L_0x031a:
            com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineByTextureID(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x04e4 }
            goto L_0x04e4
        L_0x031f:
            r1.Y = r7     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.Rectangle r2 = r2.getGeoRectangle()     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.FPoint[] r2 = r2.getClipMapRect()     // Catch:{ Throwable -> 0x04e4 }
            boolean r5 = r1.a((com.autonavi.amap.mapcore.FPoint[]) r2)     // Catch:{ Throwable -> 0x04e4 }
            if (r5 == 0) goto L_0x033e
            java.lang.Object r4 = r1.t     // Catch:{ Throwable -> 0x04e4 }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x04e4 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x033a }
            java.util.List r2 = com.amap.api.col.n3.dv.a((com.autonavi.amap.mapcore.FPoint[]) r2, (java.util.List<com.autonavi.amap.mapcore.FPoint>) r5)     // Catch:{ all -> 0x033a }
            monitor-exit(r4)     // Catch:{ all -> 0x033a }
            goto L_0x033f
        L_0x033a:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ Throwable -> 0x04e4 }
            throw r2     // Catch:{ Throwable -> 0x04e4 }
        L_0x033e:
            r2 = r4
        L_0x033f:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x04e4 }
            if (r4 < r11) goto L_0x04e4
            r1.a((java.util.List<com.autonavi.amap.mapcore.FPoint>) r2)     // Catch:{ Throwable -> 0x04e4 }
            float[] r8 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r2 = r2.c()     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r2.e()     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            r16 = 0
            r17 = 1
            r18 = 1
            r19 = 0
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            goto L_0x0316
        L_0x0369:
            boolean r4 = r1.y
            if (r4 != 0) goto L_0x0396
            monitor-enter(r21)
            com.amap.api.maps.model.BitmapDescriptor r4 = r1.r     // Catch:{ Throwable -> 0x0388 }
            if (r4 == 0) goto L_0x0383
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0388 }
            if (r4 < r9) goto L_0x0378
            r4 = r3
            goto L_0x0379
        L_0x0378:
            r4 = r7
        L_0x0379:
            com.amap.api.maps.model.BitmapDescriptor r9 = r1.r     // Catch:{ Throwable -> 0x0388 }
            int r4 = r1.a(r4, r9)     // Catch:{ Throwable -> 0x0388 }
            r1.E = r4     // Catch:{ Throwable -> 0x0388 }
            r1.y = r3     // Catch:{ Throwable -> 0x0388 }
        L_0x0383:
            monitor-exit(r21)
            goto L_0x0396
        L_0x0385:
            r0 = move-exception
            r2 = r0
            goto L_0x0394
        L_0x0388:
            r0 = move-exception
            r2 = r0
            java.lang.String r4 = "MarkerDelegateImp"
            java.lang.String r5 = "loadtexture"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0385 }
            monitor-exit(r21)     // Catch:{ all -> 0x0385 }
            goto L_0x04e4
        L_0x0394:
            monitor-exit(r21)
            throw r2
        L_0x0396:
            double r12 = r2.getChangeRatio()     // Catch:{ Throwable -> 0x04e4 }
            int r4 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x03ce
            float[] r4 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            if (r4 == 0) goto L_0x03ce
            int r4 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r4 = r4 + r3
            r1.Y = r4     // Catch:{ Throwable -> 0x04e4 }
            int r4 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r5 = r1.Z     // Catch:{ Throwable -> 0x04e4 }
            if (r4 <= r5) goto L_0x03ce
            float[] r2 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r1.E     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            float r4 = r1.O     // Catch:{ Throwable -> 0x04e4 }
            float r16 = r8 - r4
            r17 = 0
            r18 = 0
            r19 = 0
            com.amap.api.col.n3.i r4 = r1.f     // Catch:{ Throwable -> 0x04e4 }
        L_0x03c7:
            float[] r20 = r4.d()     // Catch:{ Throwable -> 0x04e4 }
            r8 = r2
            goto L_0x031a
        L_0x03ce:
            r1.Y = r7     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.Rectangle r2 = r2.getGeoRectangle()     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.FPoint[] r2 = r2.getClipMapRect()     // Catch:{ Throwable -> 0x04e4 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r4 = r1.i     // Catch:{ Throwable -> 0x04e4 }
            boolean r5 = r1.a((com.autonavi.amap.mapcore.FPoint[]) r2)     // Catch:{ Throwable -> 0x04e4 }
            if (r5 == 0) goto L_0x03ef
            java.lang.Object r4 = r1.t     // Catch:{ Throwable -> 0x04e4 }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x04e4 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x03eb }
            java.util.List r2 = com.amap.api.col.n3.dv.a((com.autonavi.amap.mapcore.FPoint[]) r2, (java.util.List<com.autonavi.amap.mapcore.FPoint>) r5)     // Catch:{ all -> 0x03eb }
            monitor-exit(r4)     // Catch:{ all -> 0x03eb }
            goto L_0x03f0
        L_0x03eb:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ Throwable -> 0x04e4 }
            throw r2     // Catch:{ Throwable -> 0x04e4 }
        L_0x03ef:
            r2 = r4
        L_0x03f0:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x04e4 }
            if (r4 < r11) goto L_0x04e4
            r1.a((java.util.List<com.autonavi.amap.mapcore.FPoint>) r2)     // Catch:{ Throwable -> 0x04e4 }
            float[] r2 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r1.E     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            float r4 = r1.O     // Catch:{ Throwable -> 0x04e4 }
            float r16 = r8 - r4
            r17 = 0
            r18 = 0
            r19 = 0
            com.amap.api.col.n3.i r4 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            goto L_0x03c7
        L_0x0414:
            java.util.List<com.autonavi.amap.mapcore.FPoint> r4 = r1.i     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r8 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r8 = r8.c()     // Catch:{ Throwable -> 0x04e4 }
            if (r8 != 0) goto L_0x0420
            goto L_0x04e4
        L_0x0420:
            double r8 = r2.getChangeRatio()     // Catch:{ Throwable -> 0x04e4 }
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0459
            float[] r5 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            if (r5 == 0) goto L_0x0459
            int r5 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r5 = r5 + r3
            r1.Y = r5     // Catch:{ Throwable -> 0x04e4 }
            int r5 = r1.Y     // Catch:{ Throwable -> 0x04e4 }
            int r6 = r1.Z     // Catch:{ Throwable -> 0x04e4 }
            if (r5 <= r6) goto L_0x0459
            float[] r8 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r2 = r2.c()     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r2.d()     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            r16 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            goto L_0x0316
        L_0x0459:
            r1.Y = r7     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.Rectangle r2 = r2.getGeoRectangle()     // Catch:{ Throwable -> 0x04e4 }
            com.autonavi.amap.mapcore.FPoint[] r2 = r2.getClipMapRect()     // Catch:{ Throwable -> 0x04e4 }
            boolean r5 = r1.a((com.autonavi.amap.mapcore.FPoint[]) r2)     // Catch:{ Throwable -> 0x04e4 }
            if (r5 == 0) goto L_0x0478
            java.lang.Object r4 = r1.t     // Catch:{ Throwable -> 0x04e4 }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x04e4 }
            java.util.List<com.autonavi.amap.mapcore.FPoint> r5 = r1.i     // Catch:{ all -> 0x0474 }
            java.util.List r2 = com.amap.api.col.n3.dv.a((com.autonavi.amap.mapcore.FPoint[]) r2, (java.util.List<com.autonavi.amap.mapcore.FPoint>) r5)     // Catch:{ all -> 0x0474 }
            monitor-exit(r4)     // Catch:{ all -> 0x0474 }
            goto L_0x0479
        L_0x0474:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ Throwable -> 0x04e4 }
            throw r2     // Catch:{ Throwable -> 0x04e4 }
        L_0x0478:
            r2 = r4
        L_0x0479:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x04e4 }
            if (r4 < r11) goto L_0x04e4
            r1.a((java.util.List<com.autonavi.amap.mapcore.FPoint>) r2)     // Catch:{ Throwable -> 0x04e4 }
            float[] r8 = r1.Q     // Catch:{ Throwable -> 0x04e4 }
            int r9 = r1.b     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            com.amap.api.col.n3.k r2 = r2.c()     // Catch:{ Throwable -> 0x04e4 }
            int r11 = r2.d()     // Catch:{ Throwable -> 0x04e4 }
            float r12 = r1.L     // Catch:{ Throwable -> 0x04e4 }
            float r13 = r1.M     // Catch:{ Throwable -> 0x04e4 }
            float r14 = r1.N     // Catch:{ Throwable -> 0x04e4 }
            float r15 = r1.K     // Catch:{ Throwable -> 0x04e4 }
            r16 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            com.amap.api.col.n3.i r2 = r1.f     // Catch:{ Throwable -> 0x04e4 }
            goto L_0x0316
        L_0x04a4:
            java.nio.FloatBuffer r2 = r1.q
            if (r2 != 0) goto L_0x04b0
            float[] r2 = r1.Q
            java.nio.FloatBuffer r2 = com.amap.api.col.n3.dv.a((float[]) r2)
            r1.q = r2
        L_0x04b0:
            com.amap.api.col.n3.cw$d r2 = r1.aa
            if (r2 == 0) goto L_0x04bc
            com.amap.api.col.n3.cw$d r2 = r1.aa
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x04d1
        L_0x04bc:
            com.amap.api.col.n3.i r2 = r1.f
            if (r2 == 0) goto L_0x04d1
            com.amap.api.col.n3.i r2 = r1.f
            com.amap.api.col.n3.k r2 = r2.c()
            if (r2 == 0) goto L_0x04d1
            r4 = 3
            com.amap.api.col.n3.cv r2 = r2.m(r4)
            com.amap.api.col.n3.cw$d r2 = (com.amap.api.col.n3.cw.d) r2
            r1.aa = r2
        L_0x04d1:
            com.amap.api.col.n3.cw$d r4 = r1.aa
            int r5 = r1.F
            java.nio.FloatBuffer r6 = r1.q
            float r7 = r1.H
            int r8 = r1.G
            com.amap.api.col.n3.i r2 = r1.f
            float[] r9 = r2.d()
            com.amap.api.col.n3.dh.a(r4, r5, r6, r7, r8, r9)
        L_0x04e4:
            r1.B = r3
            return
        L_0x04e7:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)
            throw r3
        L_0x04eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cr.b():void");
    }

    private int a(boolean z2, BitmapDescriptor bitmapDescriptor) {
        r rVar;
        if (z2) {
            rVar = this.f.c().a(bitmapDescriptor);
            if (rVar != null) {
                return rVar.f();
            }
        } else {
            rVar = null;
        }
        int i2 = 0;
        if (rVar == null) {
            rVar = new r(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i2 = iArr[0];
            if (z2) {
                this.f.c().a(rVar);
            }
            this.l.add(rVar);
            dv.a(i2, bitmap, true);
        }
        return i2;
    }

    private boolean a(FPoint[] fPointArr) {
        this.J = this.f.c().h();
        e();
        if (this.J <= 10.0f) {
            return false;
        }
        try {
            if (this.f.c() == null) {
                return false;
            }
            if (!dv.a(this.W.northeast, fPointArr) || !dv.a(this.W.southwest, fPointArr)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void destroy() {
        try {
            remove();
            if (this.l != null && this.l.size() > 0) {
                for (int i2 = 0; i2 < this.l.size(); i2++) {
                    r rVar = this.l.get(i2);
                    if (rVar != null) {
                        this.f.a(Integer.valueOf(rVar.f()));
                        this.f.c().b(rVar.j());
                    }
                }
            }
            if (this.Q != null) {
                this.Q = null;
            }
            if (this.q != null) {
                this.q.clear();
                this.q = null;
            }
            if (this.k != null && this.k.size() > 0) {
                for (BitmapDescriptor recycle : this.k) {
                    recycle.recycle();
                }
            }
            if (this.r != null) {
                this.r.recycle();
            }
            if (this.n != null) {
                this.n.clear();
                this.n = null;
            }
            if (this.m != null) {
                this.m.clear();
                this.m = null;
            }
            if (this.j != null) {
                this.j.clear();
                this.j = null;
            }
            this.X = null;
        } catch (Throwable th) {
            iu.b(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final boolean c() {
        return this.B;
    }

    public final LatLng getNearestLatLng(LatLng latLng) {
        if (latLng == null || this.j == null || this.j.size() == 0) {
            return null;
        }
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (i2 < this.j.size()) {
            try {
                if (i2 == 0) {
                    f2 = AMapUtils.calculateLineDistance(latLng, this.j.get(i2));
                } else {
                    float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.j.get(i2));
                    if (f2 > calculateLineDistance) {
                        i3 = i2;
                        f2 = calculateLineDistance;
                    }
                }
                i2++;
            } catch (Throwable th) {
                iu.b(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return this.j.get(i3);
    }

    public final boolean a(LatLng latLng) {
        int i2;
        double d2;
        double d3;
        LatLng latLng2 = latLng;
        float[] fArr = new float[this.Q.length];
        System.arraycopy(this.Q, 0, fArr, 0, this.Q.length);
        if (fArr.length / 3 < 2) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                if (i3 >= this.Q.length) {
                    break;
                }
                float f2 = this.Q[i3];
                int i4 = i3 + 1;
                arrayList.add(FPoint.obtain(f2, this.Q[i4]));
                i3 = i4 + 1 + 1;
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            double mapLenWithWin = (double) this.f.c().c().getMapLenWithWin(((int) this.H) / 4);
            double mapLenWithWin2 = (double) this.f.c().c().getMapLenWithWin((int) this.T);
            IPoint obtain = IPoint.obtain();
            this.f.c().a(latLng2.latitude, latLng2.longitude, obtain);
            FPoint obtain2 = FPoint.obtain();
            this.f.c().a(obtain.y, obtain.x, obtain2);
            obtain.recycle();
            FPoint fPoint = null;
            int i5 = 0;
            for (i2 = 1; i5 < arrayList.size() - i2; i2 = 1) {
                if (i5 == 0) {
                    fPoint = (FPoint) arrayList.get(i5);
                }
                int i6 = i5 + 1;
                FPoint fPoint2 = (FPoint) arrayList.get(i6);
                double d4 = (double) obtain2.x;
                double d5 = (double) obtain2.y;
                double d6 = mapLenWithWin2;
                double d7 = (double) fPoint.x;
                FPoint fPoint3 = obtain2;
                double d8 = (double) fPoint.y;
                int i7 = i6;
                double d9 = (double) fPoint2.x;
                FPoint fPoint4 = fPoint2;
                double d10 = (double) fPoint2.y;
                double d11 = d9 - d7;
                double d12 = d4 - d7;
                double d13 = d10 - d8;
                double d14 = d5 - d8;
                double d15 = (d11 * d12) + (d13 * d14);
                if (d15 <= 0.0d) {
                    d2 = Math.sqrt((d12 * d12) + (d14 * d14));
                } else {
                    double d16 = (d11 * d11) + (d13 * d13);
                    if (d15 >= d16) {
                        double d17 = d4 - d9;
                        double d18 = d5 - d10;
                        d3 = (d17 * d17) + (d18 * d18);
                    } else {
                        double d19 = d15 / d16;
                        double d20 = d4 - (d7 + (d11 * d19));
                        double d21 = (d8 + (d13 * d19)) - d5;
                        d3 = (d20 * d20) + (d21 * d21);
                    }
                    d2 = Math.sqrt(d3);
                }
                if ((d6 + mapLenWithWin) - d2 >= 0.0d) {
                    arrayList.clear();
                    return true;
                }
                mapLenWithWin2 = d6;
                obtain2 = fPoint3;
                i5 = i7;
                fPoint = fPoint4;
            }
            arrayList.clear();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void setTransparency(float f2) {
        this.O = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.f.c().setRunLowFrame(false);
    }

    private List<Integer> b(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue = list.get(i4).intValue();
            if (i4 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i2) {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i3] = i4;
            i3++;
            i2 = intValue;
        }
        this.R = new int[arrayList.size()];
        System.arraycopy(iArr, 0, this.R, 0, this.R.length);
        return arrayList;
    }

    private void f() {
        this.y = false;
        this.E = 0;
        if (this.S != null) {
            Arrays.fill(this.S, 0);
        }
    }

    public final void setAboveMaskLayer(boolean z2) {
        this.U = z2;
    }

    public final boolean isAboveMaskLayer() {
        return this.U;
    }

    public final void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.X = polylineOptions;
            try {
                setColor(polylineOptions.getColor());
                setGeodesic(polylineOptions.isGeodesic());
                setDottedLine(polylineOptions.isDottedLine());
                this.U = polylineOptions.isAboveMaskLayer();
                setVisible(polylineOptions.isVisible());
                setWidth(polylineOptions.getWidth());
                setZIndex(polylineOptions.getZIndex());
                this.C = polylineOptions.isUseTexture();
                this.f.c().setRunLowFrame(false);
                setTransparency(polylineOptions.getTransparency());
                if (polylineOptions.getColorValues() != null) {
                    List<Integer> colorValues = polylineOptions.getColorValues();
                    if (colorValues != null) {
                        if (colorValues.size() != 0) {
                            this.n = colorValues;
                            if (colorValues.size() > 1) {
                                this.v = false;
                                this.p = b(colorValues);
                                this.D = 3;
                                this.f.c().setRunLowFrame(false);
                            } else {
                                setColor(colorValues.get(0).intValue());
                            }
                        }
                    }
                    boolean isUseGradient = polylineOptions.isUseGradient();
                    if (isUseGradient && this.n != null && this.n.size() > 1) {
                        this.A = isUseGradient;
                        this.D = 4;
                        this.f.c().setRunLowFrame(false);
                    }
                }
                if (polylineOptions.getCustomTexture() != null) {
                    setCustomTexture(polylineOptions.getCustomTexture());
                    f();
                }
                if (polylineOptions.getCustomTextureList() != null) {
                    List<BitmapDescriptor> customTextureList = polylineOptions.getCustomTextureList();
                    if (customTextureList != null) {
                        if (customTextureList.size() != 0) {
                            if (customTextureList.size() > 1) {
                                this.v = false;
                                this.D = 5;
                                this.k = customTextureList;
                                this.f.c().setRunLowFrame(false);
                            } else {
                                setCustomTexture(customTextureList.get(0));
                            }
                        }
                    }
                    List<Integer> customTextureIndex = polylineOptions.getCustomTextureIndex();
                    if (customTextureIndex != null) {
                        if (customTextureIndex.size() != 0) {
                            this.m = customTextureIndex;
                            this.o = b(customTextureIndex);
                        }
                    }
                    f();
                }
                setPoints(polylineOptions.getPoints());
            } catch (RemoteException e2) {
                iu.b((Throwable) e2, "PolylineDelegateImp", "setOptions");
                e2.printStackTrace();
            }
        }
    }

    public final PolylineOptions getOptions() {
        return this.X;
    }
}
