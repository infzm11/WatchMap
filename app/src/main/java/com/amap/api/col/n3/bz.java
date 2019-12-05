package com.amap.api.col.n3;

import android.opengl.GLES20;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.col.n3.cw;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: CircleDelegateImp */
public final class bz implements cd {
    private static float u = 4.0075016E7f;
    private static int v = 256;
    private static int w = 20;
    private static double x = 1.0E10d;
    private LatLng a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private String h;
    private k i;
    private FloatBuffer j;
    private int k = 0;
    private boolean l = false;
    private IPoint m = IPoint.obtain();
    private FPoint n = FPoint.obtain();
    private List<BaseHoleOptions> o;
    private int p;
    private int q;
    private FloatBuffer r;
    private FloatBuffer s;
    private cw.d t;

    public final boolean a() {
        return true;
    }

    public final int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public final boolean isAboveMaskLayer() {
        return false;
    }

    public final void setAboveMaskLayer(boolean z) {
    }

    public bz(k kVar) {
        this.i = kVar;
        try {
            this.h = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "CircleDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    public final void remove() throws RemoteException {
        this.i.a(getId());
        this.i.setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.h == null) {
            this.h = this.i.c("Circle");
        }
        return this.h;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.f = f2;
        this.i.g();
        this.i.setRunLowFrame(false);
    }

    public final float getZIndex() throws RemoteException {
        return this.f;
    }

    public final void setVisible(boolean z) throws RemoteException {
        this.g = z;
        this.i.setRunLowFrame(false);
    }

    public final boolean isVisible() throws RemoteException {
        return this.g;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    private void d() {
        if (this.i != null) {
            this.t = (cw.d) this.i.m(3);
        }
    }

    public final void b() throws RemoteException {
        int i2;
        if (this.a != null && this.b > 0.0d && this.g) {
            this.l = false;
            if (this.a != null) {
                float[] fArr = new float[1086];
                double a2 = a(this.a.latitude) * this.b;
                GLMapState c2 = this.i.c();
                c2.geo2Map(this.m.x, this.m.y, this.n);
                fArr[0] = this.n.x;
                fArr[1] = this.n.y;
                fArr[2] = 0.0f;
                int i3 = 0;
                while (i3 < 361) {
                    double d2 = (((double) i3) * 3.141592653589793d) / 180.0d;
                    int sin = (int) (((double) this.m.x) + (Math.sin(d2) * a2));
                    int cos = (int) (((double) this.m.y) + (Math.cos(d2) * a2));
                    c2.geo2Map(sin, cos, this.n);
                    this.n.x = (float) (sin - this.i.getMapConfig().getS_x());
                    this.n.y = (float) (cos - this.i.getMapConfig().getS_y());
                    i3++;
                    int i4 = i3 * 3;
                    fArr[i4] = this.n.x;
                    fArr[i4 + 1] = this.n.y;
                    fArr[i4 + 2] = 0.0f;
                }
                this.k = fArr.length / 3;
                this.j = dv.a(fArr);
            }
            MapConfig mapConfig = this.i.getMapConfig();
            if (this.o != null && this.o.size() > 0) {
                GLES20.glClearStencil(0);
                GLES20.glStencilMask(255);
                GLES20.glClear(1024);
                GLES20.glFlush();
                GLES20.glEnable(2960);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glStencilFunc(512, 1, 255);
                GLES20.glStencilOp(7681, 7680, 7680);
                int i5 = 0;
                while (i5 < this.o.size()) {
                    BaseHoleOptions baseHoleOptions = this.o.get(i5);
                    boolean z = baseHoleOptions instanceof PolygonHoleOptions;
                    if (z) {
                        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
                        ArrayList arrayList = new ArrayList();
                        if (points != null) {
                            LatLng latLng = null;
                            for (LatLng next : points) {
                                if (!next.equals(latLng)) {
                                    IPoint obtain = IPoint.obtain();
                                    this.i.a(next.latitude, next.longitude, obtain);
                                    arrayList.add(obtain);
                                    latLng = next;
                                    i5 = i5;
                                }
                            }
                            i2 = i5;
                            int size = arrayList.size();
                            if (size > 1) {
                                IPoint iPoint = (IPoint) arrayList.get(0);
                                int i6 = size - 1;
                                IPoint iPoint2 = (IPoint) arrayList.get(i6);
                                if (iPoint.x == iPoint2.x && iPoint.y == iPoint2.y) {
                                    arrayList.remove(i6);
                                }
                            }
                        } else {
                            i2 = i5;
                        }
                        if (dv.a((List<IPoint>) arrayList, arrayList.size())) {
                            Collections.reverse(arrayList);
                        }
                        a(arrayList, mapConfig.getS_x(), mapConfig.getS_y());
                    } else {
                        i2 = i5;
                        if (baseHoleOptions instanceof CircleHoleOptions) {
                            this.i.g();
                            a((CircleHoleOptions) baseHoleOptions);
                        }
                    }
                    if (this.r != null && this.p > 0) {
                        if (this.t == null || this.t.b()) {
                            d();
                        }
                        if (z) {
                            dh.a(this.t, -1, this.e, this.r, getStrokeWidth(), this.s, this.p, this.q, this.i.v());
                        } else if (baseHoleOptions instanceof CircleHoleOptions) {
                            dh.a(this.t, -1, -1, this.r, 10.0f, this.p, this.i.v());
                        }
                    }
                    i5 = i2 + 1;
                }
                GLES20.glColorMask(true, true, true, true);
                GLES20.glStencilFunc(517, 1, 255);
                GLES20.glStencilMask(0);
            }
            if (this.j != null && this.k > 0) {
                if (this.t == null || this.t.b()) {
                    d();
                }
                dh.a(this.t, this.e, this.d, this.j, this.c, this.k, this.i.v());
            }
            this.l = true;
        }
    }

    private void e() {
        this.k = 0;
        if (this.j != null) {
            this.j.clear();
        }
        this.i.setRunLowFrame(false);
    }

    public final void setCenter(LatLng latLng) throws RemoteException {
        if (latLng != null) {
            this.a = latLng;
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.m);
            e();
        }
    }

    public final LatLng getCenter() throws RemoteException {
        return this.a;
    }

    public final void setRadius(double d2) throws RemoteException {
        this.b = d2;
        e();
    }

    public final double getRadius() throws RemoteException {
        return this.b;
    }

    public final void setStrokeWidth(float f2) throws RemoteException {
        this.c = f2;
        this.i.setRunLowFrame(false);
    }

    public final float getStrokeWidth() throws RemoteException {
        return this.c;
    }

    public final void setStrokeColor(int i2) throws RemoteException {
        this.d = i2;
        this.i.setRunLowFrame(false);
    }

    public final int getStrokeColor() throws RemoteException {
        return this.d;
    }

    public final void setFillColor(int i2) throws RemoteException {
        this.e = i2;
        this.i.setRunLowFrame(false);
    }

    public final int getFillColor() throws RemoteException {
        return this.e;
    }

    private static double a(double d2) {
        return 1.0d / ((double) ((float) ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * ((double) u)) / ((double) (v << w)))));
    }

    public final void destroy() {
        try {
            this.a = null;
            if (this.j != null) {
                this.j.clear();
                this.j = null;
            }
            if (this.r != null) {
                this.r.clear();
                this.r = null;
            }
            if (this.s != null) {
                this.s.clear();
                this.s = null;
            }
        } catch (Throwable th) {
            iu.b(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final boolean contains(LatLng latLng) throws RemoteException {
        return this.b >= ((double) AMapUtils.calculateLineDistance(this.a, latLng));
    }

    public final boolean c() {
        return this.l;
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        this.o = list;
    }

    public final List<BaseHoleOptions> getHoleOptions() throws RemoteException {
        return this.o;
    }

    private static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * x;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * x;
        }
        dt a2 = new dg().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            iPointArr2[i5].x = (int) (dArr[a2.a(i5) * 2] / x);
            iPointArr2[i5].y = (int) (dArr[(a2.a(i5) * 2) + 1] / x);
        }
        return iPointArr2;
    }

    private void a(List<IPoint> list, int i2, int i3) throws RemoteException {
        if (list.size() >= 2) {
            float[] fArr = new float[(list.size() * 3)];
            IPoint[] iPointArr = new IPoint[list.size()];
            int i4 = 0;
            for (IPoint next : list) {
                int i5 = i4 * 3;
                fArr[i5] = (float) (next.x - i2);
                fArr[i5 + 1] = (float) (next.y - i3);
                fArr[i5 + 2] = 0.0f;
                iPointArr[i4] = next;
                i4++;
            }
            IPoint[] a2 = a(iPointArr);
            if (a2.length == 0) {
                if (x == 1.0E10d) {
                    x = 1.0E8d;
                } else {
                    x = 1.0E10d;
                }
                a2 = a(iPointArr);
            }
            float[] fArr2 = new float[(3 * a2.length)];
            int i6 = 0;
            for (IPoint iPoint : a2) {
                int i7 = i6 * 3;
                fArr2[i7] = (float) (iPoint.x - i2);
                fArr2[i7 + 1] = (float) (iPoint.y - i3);
                fArr2[i7 + 2] = 0.0f;
                i6++;
            }
            this.p = iPointArr.length;
            this.q = a2.length;
            this.r = dv.a(fArr);
            this.s = dv.a(fArr2);
        }
    }

    private void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double a2 = a(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            GLMapState c2 = this.i.c();
            c2.geo2Map(obtain.x, obtain.y, obtain2);
            int i2 = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                int sin = (int) (((double) obtain.x) + (Math.sin(d2) * a2));
                int cos = (int) (((double) obtain.y) + (Math.cos(d2) * a2));
                c2.geo2Map(sin, cos, obtain2);
                obtain2.x = (float) (sin - this.i.getMapConfig().getS_x());
                obtain2.y = (float) (cos - this.i.getMapConfig().getS_y());
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = obtain2.x;
                fArr[i3 + 1] = obtain2.y;
                fArr[i3 + 2] = 0.0f;
            }
            this.p = fArr.length / 3;
            this.r = dv.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
