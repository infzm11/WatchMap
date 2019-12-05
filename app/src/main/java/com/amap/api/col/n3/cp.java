package com.amap.api.col.n3;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: NavigateArrowDelegateImp */
public final class cp implements cg {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    Rect i = null;
    float[] j;
    int k = 0;
    private k l;
    private float m = 10.0f;
    private int n = ViewCompat.MEASURED_STATE_MASK;
    private int o = ViewCompat.MEASURED_STATE_MASK;
    private float p = 0.0f;
    private boolean q = true;
    private String r;
    private List<IPoint> s = new Vector();
    private int t = 0;
    private boolean u = false;
    private Object v = new Object();
    private LatLngBounds w = null;

    public final boolean isAboveMaskLayer() {
        return false;
    }

    public final void setAboveMaskLayer(boolean z) {
    }

    public cp(k kVar) {
        this.l = kVar;
        try {
            this.r = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "NavigateArrowDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    public final void remove() throws RemoteException {
        this.l.a(getId());
        this.l.setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.r == null) {
            this.r = this.l.c("NavigateArrow");
        }
        return this.r;
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.v) {
            this.s.clear();
            if (this.i == null) {
                this.i = new Rect();
            }
            dv.a(this.i);
            if (list != null) {
                LatLng latLng = null;
                for (LatLng next : list) {
                    if (next != null && !next.equals(latLng)) {
                        IPoint obtain = IPoint.obtain();
                        this.l.a(next.latitude, next.longitude, obtain);
                        this.s.add(obtain);
                        dv.b(this.i, obtain.x, obtain.y);
                        latLng = next;
                    }
                }
            }
            this.t = 0;
            this.i.sort();
        }
        this.l.setRunLowFrame(false);
    }

    public final List<LatLng> getPoints() throws RemoteException {
        return d();
    }

    private List<LatLng> d() throws RemoteException {
        ArrayList arrayList;
        if (this.s == null) {
            return null;
        }
        synchronized (this.v) {
            arrayList = new ArrayList();
            for (IPoint next : this.s) {
                if (next != null) {
                    DPoint obtain = DPoint.obtain();
                    this.l.a(next.x, next.y, obtain);
                    arrayList.add(new LatLng(obtain.y, obtain.x));
                    obtain.recycle();
                }
            }
        }
        return arrayList;
    }

    public final void setWidth(float f2) throws RemoteException {
        this.m = f2;
        this.l.setRunLowFrame(false);
    }

    public final float getWidth() throws RemoteException {
        return this.m;
    }

    public final void setTopColor(int i2) throws RemoteException {
        this.n = i2;
        this.a = ((float) Color.alpha(i2)) / 255.0f;
        this.b = ((float) Color.red(i2)) / 255.0f;
        this.c = ((float) Color.green(i2)) / 255.0f;
        this.d = ((float) Color.blue(i2)) / 255.0f;
        this.l.setRunLowFrame(false);
    }

    public final int getTopColor() throws RemoteException {
        return this.n;
    }

    public final void setSideColor(int i2) throws RemoteException {
        this.o = i2;
        this.e = ((float) Color.alpha(i2)) / 255.0f;
        this.f = ((float) Color.red(i2)) / 255.0f;
        this.g = ((float) Color.green(i2)) / 255.0f;
        this.h = ((float) Color.blue(i2)) / 255.0f;
        this.l.setRunLowFrame(false);
    }

    public final int getSideColor() throws RemoteException {
        return this.o;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.p = f2;
        this.l.g();
        this.l.setRunLowFrame(false);
    }

    public final float getZIndex() throws RemoteException {
        return this.p;
    }

    public final void setVisible(boolean z) throws RemoteException {
        this.q = z;
        this.l.setRunLowFrame(false);
    }

    public final boolean isVisible() throws RemoteException {
        return this.q;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public final boolean a() {
        if (this.i == null) {
            return false;
        }
        Rectangle geoRectangle = this.l.getMapConfig().getGeoRectangle();
        if (geoRectangle == null || !geoRectangle.isOverlap(this.i)) {
            return false;
        }
        return true;
    }

    private boolean a(MapConfig mapConfig) throws RemoteException {
        synchronized (this.v) {
            int s_x = mapConfig.getS_x();
            int s_y = mapConfig.getS_y();
            int i2 = 0;
            this.u = false;
            int size = this.s.size();
            if (this.j == null || this.j.length < 3 * size) {
                this.j = new float[(3 * size)];
            }
            this.k = 3 * size;
            for (IPoint next : this.s) {
                int i3 = i2 * 3;
                this.j[i3] = (float) (next.x - s_x);
                this.j[i3 + 1] = (float) (next.y - s_y);
                this.j[i3 + 2] = 0.0f;
                i2++;
            }
            this.t = this.s.size();
        }
        return true;
    }

    public final void b() throws RemoteException {
        if (this.s != null && this.s.size() != 0 && this.m > 0.0f) {
            a(this.l.getMapConfig());
            if (this.j != null && this.t > 0) {
                AMapNativeRenderer.nativeDrawLineByTextureID(this.j, this.k, this.l.c().getMapLenWithWin((int) this.m), this.l.d(), this.b, this.c, this.d, this.a, 0.0f, false, true, true, this.l.v());
            }
            this.u = true;
        }
    }

    public final void destroy() {
        try {
            if (this.j != null) {
                this.j = null;
            }
        } catch (Throwable th) {
            iu.b(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final boolean c() {
        return this.u;
    }
}
