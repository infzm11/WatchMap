package com.amap.api.col.n3;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.model.LatLng;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;

/* compiled from: ArcDelegateImp */
public final class by implements cc {
    float a;
    float b;
    float c;
    float d;
    private LatLng e;
    private LatLng f;
    private LatLng g;
    private float h = 10.0f;
    private int i = ViewCompat.MEASURED_STATE_MASK;
    private float j = 0.0f;
    private boolean k = true;
    private String l;
    private k m;
    private float[] n;
    private int o = 0;
    private boolean p = false;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;

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

    public by(k kVar) {
        this.m = kVar;
        try {
            this.l = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "ArcDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    public final void remove() throws RemoteException {
        this.m.a(getId());
        this.m.setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.l == null) {
            this.l = this.m.c("Arc");
        }
        return this.l;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.m.g();
        this.m.setRunLowFrame(false);
    }

    public final float getZIndex() throws RemoteException {
        return this.j;
    }

    public final void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.m.setRunLowFrame(false);
    }

    public final boolean isVisible() throws RemoteException {
        return this.k;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    private boolean d() throws RemoteException {
        if (this.e == null || this.f == null || this.g == null || !this.k) {
            return false;
        }
        try {
            this.p = false;
            GLMapState c2 = this.m.c();
            if (!(Math.abs(((this.e.latitude - this.f.latitude) * (this.f.longitude - this.g.longitude)) - ((this.e.longitude - this.f.longitude) * (this.f.latitude - this.g.latitude))) >= 1.0E-6d)) {
                FPoint[] fPointArr = new FPoint[3];
                this.n = new float[(fPointArr.length * 3)];
                FPoint obtain = FPoint.obtain();
                this.m.a(this.e.latitude, this.e.longitude, obtain);
                fPointArr[0] = obtain;
                FPoint obtain2 = FPoint.obtain();
                this.m.a(this.f.latitude, this.f.longitude, obtain2);
                fPointArr[1] = obtain2;
                FPoint obtain3 = FPoint.obtain();
                this.m.a(this.g.latitude, this.g.longitude, obtain3);
                fPointArr[2] = obtain3;
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = i2 * 3;
                    this.n[i3] = fPointArr[i2].x;
                    this.n[i3 + 1] = fPointArr[i2].y;
                    this.n[i3 + 2] = 0.0f;
                }
                this.o = fPointArr.length;
                return true;
            }
            IPoint obtain4 = IPoint.obtain();
            this.m.a(this.e.latitude, this.e.longitude, obtain4);
            IPoint obtain5 = IPoint.obtain();
            this.m.a(this.f.latitude, this.f.longitude, obtain5);
            IPoint obtain6 = IPoint.obtain();
            this.m.a(this.g.latitude, this.g.longitude, obtain6);
            double d2 = (double) obtain4.x;
            double d3 = (double) obtain4.y;
            double d4 = (double) obtain5.x;
            GLMapState gLMapState = c2;
            double d5 = (double) obtain5.y;
            IPoint iPoint = obtain4;
            double d6 = (double) obtain6.x;
            IPoint iPoint2 = obtain6;
            double d7 = (double) obtain6.y;
            double d8 = d7 - d3;
            double d9 = d5 * d5;
            double d10 = d3 * d3;
            double d11 = d4 * d4;
            double d12 = d2 * d2;
            double d13 = d5 - d3;
            double d14 = d7 * d7;
            double d15 = d6 * d6;
            double d16 = d4 - d2;
            double d17 = d6 - d2;
            double d18 = d5;
            double d19 = (((((d9 - d10) + d11) - d12) * d8) + ((((d10 - d14) + d12) - d15) * d13)) / (((2.0d * d16) * d8) - ((2.0d * d17) * d13));
            double d20 = d4;
            double d21 = (((((d11 - d12) + d9) - d10) * d17) + ((((d12 - d15) + d10) - d14) * d16)) / (((d13 * 2.0d) * d17) - ((2.0d * d8) * d16));
            double d22 = d2 - d19;
            double d23 = d3 - d21;
            this.q = Math.sqrt((d22 * d22) + (d23 * d23));
            IPoint iPoint3 = iPoint2;
            IPoint iPoint4 = iPoint;
            IPoint iPoint5 = obtain5;
            this.r = a(d19, d21, d2, d3);
            double a2 = a(d19, d21, d20, d18);
            this.s = a(d19, d21, d6, d7);
            if (this.r < this.s) {
                if (a2 <= this.r || a2 >= this.s) {
                    this.s -= 6.283185307179586d;
                }
            } else if (a2 <= this.s || a2 >= this.r) {
                this.s += 6.283185307179586d;
            }
            iPoint4.recycle();
            iPoint5.recycle();
            iPoint3.recycle();
            DPoint obtain7 = DPoint.obtain(d19, d21);
            int abs = (int) ((Math.abs(this.s - this.r) * 180.0d) / 3.141592653589793d);
            double d24 = (this.s - this.r) / ((double) abs);
            FPoint[] fPointArr2 = new FPoint[(abs + 1)];
            this.n = new float[(3 * fPointArr2.length)];
            for (int i4 = 0; i4 <= abs; i4++) {
                if (i4 == abs) {
                    FPoint obtain8 = FPoint.obtain();
                    this.m.a(this.g.latitude, this.g.longitude, obtain8);
                    fPointArr2[i4] = obtain8;
                } else {
                    fPointArr2[i4] = a(gLMapState, (((double) i4) * d24) + this.r, obtain7.x, obtain7.y);
                }
                fPointArr2[i4] = a(gLMapState, (((double) i4) * d24) + this.r, obtain7.x, obtain7.y);
                int i5 = i4 * 3;
                this.n[i5] = fPointArr2[i4].x;
                this.n[i5 + 1] = fPointArr2[i4].y;
                this.n[i5 + 2] = 0.0f;
            }
            obtain7.recycle();
            this.o = fPointArr2.length;
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            iu.b(th2, "ArcDelegateImp", "calMapFPoint");
            th2.printStackTrace();
            return false;
        }
    }

    private FPoint a(GLMapState gLMapState, double d2, double d3, double d4) {
        double cos = Math.cos(d2) * this.q;
        FPoint obtain = FPoint.obtain();
        gLMapState.geo2Map((int) (d3 + cos), (int) (d4 + ((-Math.sin(d2)) * this.q)), obtain);
        return obtain;
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = (d3 - d5) / this.q;
        if (Math.abs(d6) > 1.0d) {
            d6 = Math.signum(d6);
        }
        double asin = Math.asin(d6);
        return asin >= 0.0d ? d4 < d2 ? 3.141592653589793d - Math.abs(asin) : asin : d4 < d2 ? 3.141592653589793d - asin : asin + 6.283185307179586d;
    }

    public final void b() throws RemoteException {
        if (this.e != null && this.f != null && this.g != null && this.k) {
            d();
            if (this.n != null && this.o > 0) {
                float mapLenWithWin = this.m.c().getMapLenWithWin((int) this.h);
                this.m.c().getMapLenWithWin(1);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.n, this.n.length, mapLenWithWin, this.m.d(), this.b, this.c, this.d, this.a, 0.0f, false, true, false, this.m.v());
            }
            this.p = true;
        }
    }

    public final void setStrokeWidth(float f2) throws RemoteException {
        this.h = f2;
        this.m.setRunLowFrame(false);
    }

    public final float getStrokeWidth() throws RemoteException {
        return this.h;
    }

    public final void setStrokeColor(int i2) throws RemoteException {
        this.i = i2;
        this.a = ((float) Color.alpha(i2)) / 255.0f;
        this.b = ((float) Color.red(i2)) / 255.0f;
        this.c = ((float) Color.green(i2)) / 255.0f;
        this.d = ((float) Color.blue(i2)) / 255.0f;
        this.m.setRunLowFrame(false);
    }

    public final int getStrokeColor() throws RemoteException {
        return this.i;
    }

    public final void destroy() {
        try {
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            iu.b(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final boolean c() {
        return this.p;
    }

    public final void a(LatLng latLng) {
        this.e = latLng;
    }

    public final void b(LatLng latLng) {
        this.f = latLng;
    }

    public final void c(LatLng latLng) {
        this.g = latLng;
    }
}
