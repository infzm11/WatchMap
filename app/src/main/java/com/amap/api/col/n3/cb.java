package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.amap.api.col.n3.cw;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GroundOverlayDelegateImp */
public final class cb implements ce {
    FPointBounds a = null;
    float[] b = null;
    int c = 10000;
    cw.b d;
    private k e;
    private BitmapDescriptor f;
    private LatLng g;
    private float h;
    private float i;
    private LatLngBounds j;
    private float k;
    private float l;
    private boolean m = true;
    private float n = 0.0f;
    private float o = 1.0f;
    private float p = 0.5f;
    private float q = 0.5f;
    private String r;
    private FloatBuffer s = null;
    private FloatBuffer t;
    private int u;
    private boolean v = false;
    private boolean w = false;
    private List<Float> x = new ArrayList();
    private List<Float> y = new ArrayList();

    public final boolean a() {
        return true;
    }

    public final boolean isAboveMaskLayer() {
        return false;
    }

    public final void setAboveMaskLayer(boolean z) {
    }

    public cb(k kVar) {
        this.e = kVar;
        try {
            this.r = getId();
        } catch (RemoteException e2) {
            iu.b((Throwable) e2, "GroundOverlayDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    public final void remove() throws RemoteException {
        this.e.a(getId());
        this.e.setRunLowFrame(false);
    }

    public final String getId() throws RemoteException {
        if (this.r == null) {
            this.r = this.e.c("GroundOverlay");
        }
        return this.r;
    }

    public final void setZIndex(float f2) throws RemoteException {
        this.l = f2;
        this.e.g();
        this.e.setRunLowFrame(false);
    }

    public final float getZIndex() throws RemoteException {
        return this.l;
    }

    public final void setVisible(boolean z) throws RemoteException {
        this.m = z;
        this.e.setRunLowFrame(false);
    }

    public final boolean isVisible() throws RemoteException {
        return this.m;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    private boolean d() throws RemoteException {
        this.w = false;
        if (this.g == null) {
            f();
            return true;
        } else if (this.j == null) {
            e();
            return true;
        } else {
            g();
            return true;
        }
    }

    private void e() {
        if (this.g != null) {
            double cos = ((double) this.h) / ((6371000.79d * Math.cos(this.g.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
            double d2 = ((double) this.i) / 111194.94043265979d;
            try {
                this.j = new LatLngBounds(new LatLng(this.g.latitude - (((double) (1.0f - this.q)) * d2), this.g.longitude - (((double) this.p) * cos)), new LatLng(this.g.latitude + (((double) this.q) * d2), this.g.longitude + (((double) (1.0f - this.p)) * cos)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            g();
        }
    }

    private void f() {
        if (this.j != null) {
            LatLng latLng = this.j.southwest;
            LatLng latLng2 = this.j.northeast;
            this.g = new LatLng(latLng.latitude + (((double) (1.0f - this.q)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.p) * (latLng2.longitude - latLng.longitude)));
            this.h = (float) (Math.cos(this.g.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
            this.i = (float) (6371000.79d * (latLng2.latitude - latLng.latitude) * 0.01745329251994329d);
            g();
        }
    }

    /* JADX INFO: finally extract failed */
    private synchronized void g() {
        IPoint iPoint;
        synchronized (this) {
            try {
                if (this.j != null) {
                    this.b = new float[16];
                    IPoint obtain = IPoint.obtain();
                    IPoint obtain2 = IPoint.obtain();
                    IPoint obtain3 = IPoint.obtain();
                    IPoint obtain4 = IPoint.obtain();
                    GLMapState.lonlat2Geo(this.j.southwest.longitude, this.j.southwest.latitude, obtain);
                    GLMapState.lonlat2Geo(this.j.northeast.longitude, this.j.southwest.latitude, obtain2);
                    GLMapState.lonlat2Geo(this.j.northeast.longitude, this.j.northeast.latitude, obtain3);
                    GLMapState.lonlat2Geo(this.j.southwest.longitude, this.j.northeast.latitude, obtain4);
                    if (this.k != 0.0f) {
                        double d2 = (double) (obtain2.x - obtain.x);
                        double d3 = (double) (obtain2.y - obtain3.y);
                        DPoint obtain5 = DPoint.obtain();
                        obtain5.x = ((double) obtain.x) + (((double) this.p) * d2);
                        obtain5.y = ((double) obtain.y) - (((double) (1.0f - this.q)) * d3);
                        DPoint dPoint = obtain5;
                        double d4 = d3;
                        double d5 = d2;
                        iPoint = obtain4;
                        a(obtain5, 0.0d, 0.0d, d2, d4, obtain);
                        a(dPoint, d5, 0.0d, d5, d4, obtain2);
                        a(dPoint, d5, d4, d5, d4, obtain3);
                        a(dPoint, 0.0d, d4, d5, d4, iPoint);
                        dPoint.recycle();
                    } else {
                        iPoint = obtain4;
                    }
                    this.b[0] = (float) (obtain.x / this.c);
                    this.b[1] = (float) (obtain.y / this.c);
                    this.b[2] = (float) (obtain.x % this.c);
                    this.b[3] = (float) (obtain.y % this.c);
                    this.b[4] = (float) (obtain2.x / this.c);
                    this.b[5] = (float) (obtain2.y / this.c);
                    this.b[6] = (float) (obtain2.x % this.c);
                    this.b[7] = (float) (obtain2.y % this.c);
                    this.b[8] = (float) (obtain3.x / this.c);
                    this.b[9] = (float) (obtain3.y / this.c);
                    this.b[10] = (float) (obtain3.x % this.c);
                    this.b[11] = (float) (obtain3.y % this.c);
                    IPoint iPoint2 = iPoint;
                    this.b[12] = (float) (iPoint2.x / this.c);
                    this.b[13] = (float) (iPoint2.y / this.c);
                    this.b[14] = (float) (iPoint2.x % this.c);
                    this.b[15] = (float) (iPoint2.y % this.c);
                    if (this.s == null) {
                        this.s = dv.a(this.b);
                    } else {
                        this.s = dv.a(this.b, this.s);
                    }
                    iPoint2.recycle();
                    obtain.recycle();
                    obtain2.recycle();
                    obtain3.recycle();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(DPoint dPoint, double d2, double d3, double d4, double d5, IPoint iPoint) {
        double d6 = d2 - (d4 * ((double) this.p));
        double d7 = (d5 * ((double) (1.0f - this.q))) - d3;
        double d8 = ((double) (-this.k)) * 0.01745329251994329d;
        iPoint.x = (int) (dPoint.x + (Math.cos(d8) * d6) + (Math.sin(d8) * d7));
        iPoint.y = (int) (dPoint.y + ((d7 * Math.cos(d8)) - (d6 * Math.sin(d8))));
    }

    public final void b() throws RemoteException {
        if (!this.m) {
            return;
        }
        if ((this.g != null || this.j != null) && this.f != null) {
            if (this.b == null) {
                d();
            }
            if (!this.v) {
                Bitmap bitmap = this.f.getBitmap();
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (this.u == 0) {
                        int[] iArr = {0};
                        GLES20.glGenTextures(1, iArr, 0);
                        this.u = iArr[0];
                    } else {
                        GLES20.glDeleteTextures(1, new int[]{this.u}, 0);
                    }
                    dv.a(this.u, bitmap, false);
                }
                this.v = true;
            }
            if (this.h != 0.0f || this.i != 0.0f) {
                int i2 = this.u;
                FloatBuffer floatBuffer = this.s;
                FloatBuffer floatBuffer2 = this.t;
                if (!(this.b == null || floatBuffer == null || floatBuffer2 == null)) {
                    if ((this.d == null || this.d.b()) && this.e != null) {
                        this.d = (cw.b) this.e.m(2);
                    }
                    GLES20.glUseProgram(this.d.d);
                    GLES20.glEnable(3042);
                    GLES20.glBlendFunc(1, 771);
                    GLES20.glBlendColor(this.o * 1.0f, this.o * 1.0f, this.o * 1.0f, this.o);
                    GLES20.glBindTexture(3553, i2);
                    GLES20.glEnableVertexAttribArray(this.d.b);
                    GLES20.glVertexAttribPointer(this.d.b, 4, 5126, false, 16, floatBuffer);
                    GLES20.glEnableVertexAttribArray(this.d.c);
                    GLES20.glVertexAttribPointer(this.d.c, 2, 5126, false, 8, floatBuffer2);
                    GLES20.glUniform4f(this.d.g, (float) (this.e.getMapConfig().getS_x() / this.c), (float) (this.e.getMapConfig().getS_y() / this.c), (float) (this.e.getMapConfig().getS_x() % this.c), (float) (this.e.getMapConfig().getS_y() % this.c));
                    GLES20.glUniform4f(this.d.h, this.o * 1.0f, this.o * 1.0f, this.o * 1.0f, this.o);
                    GLES20.glUniformMatrix4fv(this.d.a, 1, false, this.e.v(), 0);
                    GLES20.glDrawArrays(6, 0, 4);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glDisableVertexAttribArray(this.d.b);
                    GLES20.glDisableVertexAttribArray(this.d.c);
                    GLES20.glDisable(3042);
                    GLES20.glUseProgram(0);
                }
                this.w = true;
            }
        }
    }

    public final void destroy() {
        try {
            remove();
            if (this.f != null) {
                Bitmap bitmap = this.f.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.f = null;
                }
            }
            if (this.t != null) {
                this.t.clear();
                this.t = null;
            }
            if (this.s != null) {
                this.s.clear();
                this.s = null;
            }
            this.g = null;
            this.j = null;
        } catch (Throwable th) {
            iu.b(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final void setPosition(LatLng latLng) throws RemoteException {
        this.g = latLng;
        e();
        this.e.setRunLowFrame(false);
    }

    public final LatLng getPosition() throws RemoteException {
        return this.g;
    }

    public final void setDimensions(float f2) throws RemoteException {
        if (!this.v || this.h == f2) {
            this.h = f2;
            this.i = f2;
        } else {
            this.h = f2;
            this.i = f2;
            e();
        }
        this.e.setRunLowFrame(false);
    }

    public final void setDimensions(float f2, float f3) throws RemoteException {
        if (!this.v || this.h == f2 || this.i == f3) {
            this.h = f2;
            this.i = f3;
        } else {
            this.h = f2;
            this.i = f3;
            e();
        }
        this.e.setRunLowFrame(false);
    }

    public final float getWidth() throws RemoteException {
        return this.h;
    }

    public final float getHeight() throws RemoteException {
        return this.i;
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        this.j = latLngBounds;
        f();
        this.e.setRunLowFrame(false);
    }

    public final LatLngBounds getBounds() throws RemoteException {
        return this.j;
    }

    public final void setBearing(float f2) throws RemoteException {
        float f3 = ((f2 % 360.0f) + 360.0f) % 360.0f;
        if (((double) Math.abs(this.k - f3)) > 1.0E-7d) {
            this.k = f3;
            g();
        }
        this.e.setRunLowFrame(false);
    }

    public final float getBearing() throws RemoteException {
        return this.k;
    }

    public final void setTransparency(float f2) throws RemoteException {
        this.n = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.o = 1.0f - f2;
        this.e.setRunLowFrame(false);
    }

    public final float getTransparency() throws RemoteException {
        return this.n;
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null && !bitmapDescriptor.getBitmap().isRecycled()) {
            this.f = bitmapDescriptor;
            if (!(this.f == null && (this.f == null || this.f.getBitmap() == null))) {
                int width = this.f.getWidth();
                int height = this.f.getHeight();
                int height2 = this.f.getBitmap().getHeight();
                float width2 = ((float) width) / ((float) this.f.getBitmap().getWidth());
                float f2 = ((float) height) / ((float) height2);
                this.t = dv.a(new float[]{0.0f, f2, width2, f2, width2, 0.0f, 0.0f, 0.0f});
            }
            if (this.v) {
                this.v = false;
            }
            this.e.setRunLowFrame(false);
        }
    }

    public final void a(float f2, float f3) throws RemoteException {
        this.p = f2;
        this.q = f3;
        this.e.setRunLowFrame(false);
    }

    public final boolean c() {
        return this.w;
    }
}
