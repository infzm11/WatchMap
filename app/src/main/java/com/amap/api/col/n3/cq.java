package com.amap.api.col.n3;

import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.amap.api.col.n3.cw;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: PolygonDelegateImp */
public final class cq implements cj {
    private static int A = 20;
    private static double F = 1.0E10d;
    private static float y = 4.0075016E7f;
    private static int z = 256;
    private int B;
    private int C;
    private FloatBuffer D;
    private FloatBuffer E;
    FPointBounds a = null;
    Rect b = null;
    private k c;
    private float d = 0.0f;
    private boolean e = true;
    private String f;
    private float g;
    private int h;
    private int i;
    private List<LatLng> j;
    private List<IPoint> k = new Vector();
    private List<BaseHoleOptions> l = new Vector();
    private List<FPoint> m = new ArrayList();
    private FloatBuffer n;
    private FloatBuffer o;
    private int p = 0;
    private int q = 0;
    private LatLngBounds r = null;
    private boolean s = false;
    private float t = 0.0f;
    private List<IPoint> u = new ArrayList();
    private Object v = new Object();
    private float w = 0.0f;
    private cw.d x;

    public final boolean isAboveMaskLayer() {
        return false;
    }

    public final void setAboveMaskLayer(boolean z2) {
    }

    public cq(k kVar) {
        this.c = kVar;
        try {
            this.f = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "PolygonDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    public final void remove() throws RemoteException {
        this.c.a(getId());
        this.c.setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.f == null) {
            this.f = this.c.c("Polygon");
        }
        return this.f;
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.v) {
            this.j = list;
            LatLngBounds.Builder builder = LatLngBounds.builder();
            if (this.b == null) {
                this.b = new Rect();
            }
            dv.a(this.b);
            this.k.clear();
            if (list != null) {
                LatLng latLng = null;
                for (LatLng next : list) {
                    if (!next.equals(latLng)) {
                        IPoint obtain = IPoint.obtain();
                        this.c.a(next.latitude, next.longitude, obtain);
                        this.k.add(obtain);
                        dv.b(this.b, obtain.x, obtain.y);
                        builder.include(next);
                        latLng = next;
                    }
                }
                int size = this.k.size();
                if (size > 1) {
                    IPoint iPoint = this.k.get(0);
                    int i2 = size - 1;
                    IPoint iPoint2 = this.k.get(i2);
                    if (iPoint.x == iPoint2.x && iPoint.y == iPoint2.y) {
                        this.k.remove(i2);
                    }
                }
            }
            this.b.sort();
            this.r = builder.build();
            if (this.n != null) {
                this.n.clear();
            }
            if (this.o != null) {
                this.o.clear();
            }
            if (dv.a(this.k, this.k.size())) {
                Collections.reverse(this.k);
            }
            this.p = 0;
            this.q = 0;
            this.c.setRunLowFrame(false);
            this.c.setRunLowFrame(false);
        }
    }

    public final List<LatLng> getPoints() throws RemoteException {
        return this.j;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.d = f2;
        this.c.g();
        this.c.setRunLowFrame(false);
    }

    public final float getZIndex() throws RemoteException {
        return this.d;
    }

    public final void setVisible(boolean z2) throws RemoteException {
        this.e = z2;
        this.c.setRunLowFrame(false);
    }

    public final boolean isVisible() throws RemoteException {
        return this.e;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public final boolean a() {
        return this.c.getMapConfig().getGeoRectangle().isOverlap(this.b);
    }

    private void d() {
        if (this.c != null) {
            this.x = (cw.d) this.c.m(3);
        }
    }

    public final void b() throws RemoteException {
        List<IPoint> list;
        int i2;
        if (this.k != null && this.k.size() != 0) {
            MapConfig mapConfig = this.c.getMapConfig();
            Rectangle geoRectangle = mapConfig.getGeoRectangle();
            IPoint[] clipRect = geoRectangle.getClipRect();
            List<IPoint> list2 = this.k;
            if (a(geoRectangle)) {
                synchronized (this.v) {
                    try {
                        list2 = dv.a(clipRect, this.k);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            MapConfig mapConfig2 = this.c.getMapConfig();
            if (this.l != null && this.l.size() > 0) {
                GLES20.glClearStencil(0);
                GLES20.glStencilMask(255);
                GLES20.glClear(1024);
                GLES20.glFlush();
                GLES20.glEnable(2960);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glStencilFunc(512, 1, 255);
                GLES20.glStencilOp(7681, 7680, 7680);
                int i3 = 0;
                while (i3 < this.l.size()) {
                    BaseHoleOptions baseHoleOptions = this.l.get(i3);
                    boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                    if (z2) {
                        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
                        ArrayList arrayList = new ArrayList();
                        if (points != null) {
                            LatLng latLng = null;
                            for (LatLng next : points) {
                                if (!next.equals(latLng)) {
                                    IPoint obtain = IPoint.obtain();
                                    this.c.a(next.latitude, next.longitude, obtain);
                                    arrayList.add(obtain);
                                    dv.b(this.b, obtain.x, obtain.y);
                                    latLng = next;
                                    i3 = i3;
                                    list2 = list2;
                                }
                            }
                            list = list2;
                            i2 = i3;
                            int size = arrayList.size();
                            if (size > 1) {
                                IPoint iPoint = (IPoint) arrayList.get(0);
                                int i4 = size - 1;
                                IPoint iPoint2 = (IPoint) arrayList.get(i4);
                                if (iPoint.x == iPoint2.x && iPoint.y == iPoint2.y) {
                                    arrayList.remove(i4);
                                }
                            }
                        } else {
                            list = list2;
                            i2 = i3;
                        }
                        if (dv.a((List<IPoint>) arrayList, arrayList.size())) {
                            Collections.reverse(arrayList);
                        }
                        a(arrayList, mapConfig2.getS_x(), mapConfig2.getS_y());
                    } else {
                        list = list2;
                        i2 = i3;
                        if (baseHoleOptions instanceof CircleHoleOptions) {
                            this.c.g();
                            a((CircleHoleOptions) baseHoleOptions);
                        }
                    }
                    if (this.D != null && this.B > 0) {
                        if (this.x == null || this.x.b()) {
                            d();
                        }
                        if (z2) {
                            dh.a(this.x, -1, this.i, this.D, this.g, this.E, this.B, this.C, this.c.v());
                        } else if (baseHoleOptions instanceof CircleHoleOptions) {
                            dh.a(this.x, Color.argb(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 80, 1, 1), Color.argb(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 1, 1, 1), this.D, 10.0f, this.B, this.c.v());
                        }
                    }
                    i3 = i2 + 1;
                    list2 = list;
                }
                List<IPoint> list3 = list2;
                GLES20.glColorMask(true, true, true, true);
                GLES20.glStencilFunc(517, 1, 255);
                GLES20.glStencilMask(0);
            }
            if (list2.size() > 2) {
                b(list2, mapConfig.getS_x(), mapConfig.getS_y());
                if (this.n != null && this.o != null && this.p > 0 && this.q > 0) {
                    if (this.x == null || this.x.b()) {
                        d();
                    }
                    dh.a(this.x, this.h, this.i, this.n, this.g, this.o, this.p, this.q, this.c.v());
                }
            }
            this.s = true;
        }
    }

    private void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double d2 = 3.141592653589793d;
            double d3 = 180.0d;
            double cos = (1.0d / ((double) ((float) ((Math.cos((circleHoleOptions.getCenter().latitude * 3.141592653589793d) / 180.0d) * ((double) y)) / ((double) (z << A)))))) * circleHoleOptions.getRadius();
            GLMapState c2 = this.c.c();
            c2.geo2Map(obtain.x, obtain.y, obtain2);
            int i2 = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d4 = (((double) i2) * d2) / d3;
                int sin = (int) (((double) obtain.x) + (Math.sin(d4) * cos));
                int cos2 = (int) (((double) obtain.y) + (Math.cos(d4) * cos));
                c2.geo2Map(sin, cos2, obtain2);
                obtain2.x = (float) (sin - this.c.getMapConfig().getS_x());
                obtain2.y = (float) (cos2 - this.c.getMapConfig().getS_y());
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = obtain2.x;
                fArr[i3 + 1] = obtain2.y;
                fArr[i3 + 2] = 0.0f;
                d2 = 3.141592653589793d;
                d3 = 180.0d;
            }
            this.B = fArr.length / 3;
            this.D = dv.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
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
                if (F == 1.0E10d) {
                    F = 1.0E8d;
                } else {
                    F = 1.0E10d;
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
            this.B = iPointArr.length;
            this.C = a2.length;
            this.D = dv.a(fArr);
            this.E = dv.a(fArr2);
        }
    }

    private boolean a(Rectangle rectangle) {
        this.w = this.c.h();
        e();
        if (this.w <= 10.0f || rectangle == null) {
            return false;
        }
        try {
            if (rectangle.contains(this.b)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(List<IPoint> list, int i2, int i3) throws RemoteException {
        int i4;
        e();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size >= 2) {
            IPoint iPoint = list.get(0);
            arrayList.add(iPoint);
            IPoint iPoint2 = iPoint;
            int i5 = 1;
            while (true) {
                i4 = size - 1;
                if (i5 >= i4) {
                    break;
                }
                IPoint iPoint3 = list.get(i5);
                if (((float) (iPoint3.x - iPoint2.x)) >= this.t || ((float) (iPoint3.x - iPoint2.x)) <= (-this.t) || ((float) (iPoint3.y - iPoint2.y)) >= this.t || ((float) (iPoint3.y - iPoint2.y)) <= (-this.t)) {
                    arrayList.add(iPoint3);
                    iPoint2 = iPoint3;
                }
                i5++;
            }
            arrayList.add(list.get(i4));
            float[] fArr = new float[(arrayList.size() * 3)];
            IPoint[] iPointArr = new IPoint[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                IPoint iPoint4 = (IPoint) it.next();
                int i7 = i6 * 3;
                fArr[i7] = (float) (iPoint4.x - i2);
                fArr[i7 + 1] = (float) (iPoint4.y - i3);
                fArr[i7 + 2] = 0.0f;
                iPointArr[i6] = iPoint4;
                i6++;
            }
            IPoint[] a2 = a(iPointArr);
            if (a2.length == 0) {
                if (F == 1.0E10d) {
                    F = 1.0E8d;
                } else {
                    F = 1.0E10d;
                }
                a2 = a(iPointArr);
            }
            float[] fArr2 = new float[(3 * a2.length)];
            int i8 = 0;
            for (IPoint iPoint5 : a2) {
                int i9 = i8 * 3;
                fArr2[i9] = (float) (iPoint5.x - i2);
                fArr2[i9 + 1] = (float) (iPoint5.y - i3);
                fArr2[i9 + 2] = 0.0f;
                i8++;
            }
            this.p = iPointArr.length;
            this.q = a2.length;
            this.n = dv.a(fArr);
            this.o = dv.a(fArr2);
        }
    }

    private void e() {
        float h2 = this.c.h();
        if (this.k.size() <= 5000 || h2 > 12.0f) {
            this.t = this.c.c().getMapLenWithWin(10);
            return;
        }
        float f2 = (this.g / 2.0f) + (h2 / 2.0f);
        float f3 = 200.0f;
        if (f2 <= 200.0f) {
            f3 = f2;
        }
        this.t = this.c.c().getMapLenWithWin((int) f3);
    }

    public final void setStrokeWidth(float f2) throws RemoteException {
        this.g = f2;
        this.c.setRunLowFrame(false);
    }

    public final float getStrokeWidth() throws RemoteException {
        return this.g;
    }

    public final void setFillColor(int i2) throws RemoteException {
        this.h = i2;
        this.c.setRunLowFrame(false);
    }

    public final int getFillColor() throws RemoteException {
        return this.h;
    }

    public final void setStrokeColor(int i2) throws RemoteException {
        this.i = i2;
        this.c.setRunLowFrame(false);
    }

    public final int getStrokeColor() throws RemoteException {
        return this.i;
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        this.l = list;
        this.c.setRunLowFrame(false);
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.l;
    }

    private static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * F;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * F;
        }
        dt a2 = new dg().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            iPointArr2[i5].x = (int) (dArr[a2.a(i5) * 2] / F);
            iPointArr2[i5].y = (int) (dArr[(a2.a(i5) * 2) + 1] / F);
        }
        return iPointArr2;
    }

    public final void destroy() {
        try {
            if (this.n != null) {
                this.n.clear();
                this.n = null;
            }
            if (this.o != null) {
                this.o = null;
            }
            if (this.D != null) {
                this.D.clear();
                this.D = null;
            }
            if (this.E != null) {
                this.E.clear();
                this.E = null;
            }
        } catch (Throwable th) {
            iu.b(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final boolean contains(LatLng latLng) throws RemoteException {
        try {
            return dv.a(latLng, getPoints());
        } catch (Throwable th) {
            iu.b(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    public final boolean c() {
        return this.s;
    }
}
