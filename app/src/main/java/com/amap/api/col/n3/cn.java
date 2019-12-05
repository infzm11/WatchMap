package com.amap.api.col.n3;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MarkerDelegateImp */
public final class cn implements cf, IAnimation, IMarkerAction {
    private static int f;
    private boolean A = true;
    private int B = 5;
    private boolean C = true;
    private boolean D = true;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    private FPoint I = FPoint.obtain();
    private Point J = new Point();
    private float K;
    private float L;
    private int M = 0;
    private int N = 0;
    private r O;
    private r[] P = null;
    private boolean Q = false;
    private String R;
    private LatLng S;
    private LatLng T;
    private String U;
    private String V;
    private float W = 0.5f;
    private float X = 1.0f;
    private boolean Y = false;
    private boolean Z = true;
    float[] a;
    private p aa;
    private Object ab;
    private boolean ac = false;
    private List<BitmapDescriptor> ad = new CopyOnWriteArrayList();
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = true;
    private int ah = 0;
    private int ai = 20;
    private boolean aj = false;
    private int ak;
    private int al;
    private long am = 0;
    private float an = Float.MAX_VALUE;
    private float ao = Float.MIN_VALUE;
    private float ap = Float.MIN_VALUE;
    private float aq = Float.MAX_VALUE;
    float[] b;
    Rect c = new Rect(0, 0, 0, 0);
    int d = 9;
    GLAnimation e;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private float j = 0.0f;
    private float k = 0.0f;
    private boolean l = false;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q;
    private int r;
    private FPoint s = FPoint.obtain();
    private float[] t = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float u = 0.0f;
    private float v = 1.0f;
    private float w = 1.0f;
    private float x = 1.0f;
    private MarkerOptions y;
    private boolean z = false;

    public final IMarkerAction getIMarkerAction() {
        return this;
    }

    public final void setRotateAngleNotUpdate(float f2) {
    }

    public final void setRotateAngle(float f2) {
        this.y.rotateAngle(f2);
        this.k = f2;
        this.j = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        this.i = true;
        p();
    }

    public final void destroy(boolean z2) {
        try {
            this.Q = true;
            if (z2) {
                remove();
            }
            int i2 = 0;
            if (this.aa != null) {
                int i3 = 0;
                while (this.P != null && i3 < this.P.length) {
                    r rVar = this.P[i3];
                    if (rVar != null) {
                        this.aa.a(rVar);
                        this.aa.b().b(rVar.j());
                    }
                    i3++;
                }
            }
            while (this.ad != null && i2 < this.ad.size()) {
                this.ad.get(i2).recycle();
                i2++;
            }
            this.S = null;
            this.ab = null;
            this.P = null;
        } catch (Throwable th) {
            iu.b(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    private synchronized void m() {
        if (this.ad != null) {
            this.ad.clear();
        }
    }

    private synchronized void a(ArrayList<BitmapDescriptor> arrayList) {
        m();
        if (arrayList != null) {
            Iterator<BitmapDescriptor> it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor next = it.next();
                if (next != null) {
                    this.ad.add(next);
                }
            }
        }
        if (this.ad.size() > 0) {
            this.M = this.ad.get(0).getWidth();
            this.N = this.ad.get(0).getHeight();
            return;
        }
        this.ad.add(BitmapDescriptorFactory.defaultMarker());
        this.M = this.ad.get(0).getWidth();
        this.N = this.ad.get(0).getHeight();
    }

    public cn(MarkerOptions markerOptions, p pVar) {
        this.aa = pVar;
        setMarkerOptions(markerOptions);
    }

    private int n() {
        try {
            return this.M;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private int o() {
        try {
            return this.N;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final Rect h() {
        if (this.t == null) {
            this.c.set(0, 0, 0, 0);
            return this.c;
        }
        try {
            GLMapState c2 = this.aa.b().c();
            int n2 = n();
            int o2 = o();
            IPoint obtain = IPoint.obtain();
            c2.map2Win(this.s.x, this.s.y, obtain);
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.j, 0.0f, 0.0f, 1.0f);
            if (this.l) {
                Matrix.rotateM(this.a, 0, this.aa.b().getMapConfig().getS_c(), 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(this.a, 0, this.aa.b().getMapConfig().getS_r(), 0.0f, 0.0f, 1.0f);
            }
            float[] fArr = new float[4];
            float f2 = (float) (-n2);
            this.b[0] = this.W * f2;
            float f3 = (float) o2;
            this.b[1] = this.X * f3;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.set((int) (((float) obtain.x) + fArr[0]), (int) (((float) obtain.y) - fArr[1]), (int) (((float) obtain.x) + fArr[0]), (int) (((float) obtain.y) - fArr[1]));
            float f4 = (float) n2;
            this.b[0] = (1.0f - this.W) * f4;
            this.b[1] = f3 * this.X;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (((float) obtain.x) + fArr[0]), (int) (((float) obtain.y) - fArr[1]));
            this.b[0] = f4 * (1.0f - this.W);
            float f5 = (float) (-o2);
            this.b[1] = (1.0f - this.X) * f5;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (((float) obtain.x) + fArr[0]), (int) (((float) obtain.y) - fArr[1]));
            this.b[0] = f2 * this.W;
            this.b[1] = f5 * (1.0f - this.X);
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (((float) obtain.x) + fArr[0]), (int) (((float) obtain.y) - fArr[1]));
            this.o = this.c.centerX() - obtain.x;
            this.p = this.c.top - obtain.y;
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            Throwable th2 = th;
            iu.b(th2, "MarkerDelegateImp", "getRect");
            th2.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    public final boolean remove() {
        p();
        this.Z = false;
        if (this.aa != null) {
            return this.aa.a((ci) this);
        }
        return false;
    }

    private void p() {
        if (this.aa.b() != null) {
            this.aa.b().setRunLowFrame(false);
        }
    }

    public final LatLng getPosition() {
        if (!this.aj || this.s == null) {
            return this.S;
        }
        DPoint obtain = DPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        q();
        this.aa.b().a(this.s.x, this.s.y, obtain2);
        GLMapState.geo2LonLat(obtain2.x, obtain2.y, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain2.recycle();
        obtain.recycle();
        return latLng;
    }

    public final String getId() {
        if (this.R == null) {
            f++;
            this.R = "Marker" + f;
        }
        return this.R;
    }

    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            iu.b((Throwable) new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.S = latLng;
        IPoint obtain = IPoint.obtain();
        if (this.ae) {
            try {
                double[] a2 = ku.a(latLng.longitude, latLng.latitude);
                this.T = new LatLng(a2[1], a2[0]);
                GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
            } catch (Throwable unused) {
                this.T = latLng;
            }
        } else {
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        }
        this.q = obtain.x;
        this.r = obtain.y;
        this.aj = false;
        q();
        p();
        this.i = true;
        obtain.recycle();
    }

    public final void setTitle(String str) {
        this.U = str;
        p();
        this.y.title(str);
    }

    public final String getTitle() {
        return this.U;
    }

    public final void setSnippet(String str) {
        this.V = str;
        p();
        this.y.snippet(str);
    }

    public final String getSnippet() {
        return this.V;
    }

    public final void setDraggable(boolean z2) {
        this.Y = z2;
        this.y.draggable(z2);
        p();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void setIcons(java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002b
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r0 = r2.ad     // Catch:{ Throwable -> 0x001c }
            if (r0 != 0) goto L_0x0008
            goto L_0x002b
        L_0x0008:
            r2.a((java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor>) r3)     // Catch:{ Throwable -> 0x001c }
            r3 = 0
            r2.af = r3     // Catch:{ Throwable -> 0x001c }
            r2.g = r3     // Catch:{ Throwable -> 0x001c }
            r2.E = r3     // Catch:{ Throwable -> 0x001c }
            r2.p()     // Catch:{ Throwable -> 0x001c }
            r3 = 1
            r2.i = r3     // Catch:{ Throwable -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            goto L_0x0029
        L_0x001c:
            r3 = move-exception
            java.lang.String r0 = "MarkerDelegateImp"
            java.lang.String r1 = "setIcons"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x001a }
            r3.printStackTrace()     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return
        L_0x0029:
            monitor-exit(r2)
            throw r3
        L_0x002b:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cn.setIcons(java.util.ArrayList):void");
    }

    public final synchronized ArrayList<BitmapDescriptor> getIcons() {
        if (this.ad == null || this.ad.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        for (BitmapDescriptor add : this.ad) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.ad != null) {
                    synchronized (this) {
                        this.ad.clear();
                        this.ad.add(bitmapDescriptor);
                        this.E = false;
                        this.af = false;
                        this.g = false;
                        p();
                        this.i = true;
                        this.M = bitmapDescriptor.getWidth();
                        this.N = bitmapDescriptor.getHeight();
                    }
                }
            } catch (Throwable th) {
                iu.b(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    public final boolean isDraggable() {
        return this.Y;
    }

    public final boolean isRemoved() {
        try {
            return !this.aa.c(this);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void showInfoWindow() {
        if (this.Z && isInfoWindowEnable()) {
            this.aa.b((cf) this);
            p();
        }
    }

    public final void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.aa.b((ci) this);
            p();
            this.h = false;
        }
        this.i = false;
    }

    public final void a(boolean z2) {
        this.h = z2;
        this.i = true;
    }

    public final boolean isInfoWindowShown() {
        return this.h;
    }

    public final void setVisible(boolean z2) {
        if (this.Z != z2) {
            this.y.visible(z2);
            this.Z = z2;
            if (!z2) {
                this.G = false;
                if (isInfoWindowShown()) {
                    this.aa.b((ci) this);
                }
            }
            p();
        }
    }

    public final boolean isVisible() {
        return this.Z;
    }

    public final void setAnchor(float f2, float f3) {
        if (this.W != f2 || this.X != f3) {
            this.y.anchor(f2, f3);
            this.W = f2;
            this.X = f3;
            this.i = true;
            p();
        }
    }

    public final float getAnchorU() {
        return this.W;
    }

    public final float getAnchorV() {
        return this.X;
    }

    public final boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    public final int hashCodeRemote() {
        return super.hashCode();
    }

    private boolean q() {
        try {
            if (!(this.aa == null || this.aa.b() == null)) {
                if (this.aa.b().c() != null) {
                    if (this.s == null) {
                        this.s = FPoint.obtain();
                    }
                    if (this.aj) {
                        this.aa.b().a(this.ak, this.al, (PointF) this.s);
                        return true;
                    }
                    this.aa.b().a(this.r, this.q, this.s);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void a(k kVar, float[] fArr, int i2, float f2) {
        if (this.Q) {
            return;
        }
        if ((this.S != null || this.aj) && this.ad != null) {
            this.s.x = (float) (this.q - kVar.getMapConfig().getS_x());
            this.s.y = (float) (this.r - kVar.getMapConfig().getS_y());
            try {
                if (!this.g) {
                    this.am = System.currentTimeMillis();
                    this.g = true;
                }
                if (!this.aj || !this.D) {
                    k kVar2 = kVar;
                } else {
                    kVar.a(this.ak, this.al, (PointF) this.s);
                }
                if (this.H || this.e == null || this.e.hasEnded()) {
                    this.v = 1.0f;
                    this.w = 1.0f;
                    this.H = true;
                } else {
                    p();
                    GLTransformation gLTransformation = new GLTransformation();
                    this.e.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
                    if (!Double.isNaN(gLTransformation.scale_x) && !Double.isNaN(gLTransformation.scale_y)) {
                        this.v = (float) gLTransformation.scale_x;
                        this.w = (float) gLTransformation.scale_y;
                    }
                    if (!Double.isNaN(gLTransformation.rotate)) {
                        setRotateAngle((float) gLTransformation.rotate);
                    }
                    if (!Double.isNaN(gLTransformation.x) && !Double.isNaN(gLTransformation.y)) {
                        double d2 = gLTransformation.x;
                        double d3 = gLTransformation.y;
                        if (this.aj) {
                            FPoint obtain = FPoint.obtain();
                            this.aa.b().c().win2Map((int) d2, (int) d3, obtain);
                            IPoint obtain2 = IPoint.obtain();
                            this.aa.b().c().map2Geo(obtain.x, obtain.y, obtain2);
                            a(obtain2.x, obtain2.y);
                            obtain.recycle();
                            obtain2.recycle();
                            this.aj = true;
                        } else {
                            a((int) d2, (int) d3);
                        }
                    }
                    if (!Double.isNaN(gLTransformation.alpha)) {
                        this.x = (float) gLTransformation.alpha;
                    }
                    this.i = true;
                }
                float n2 = ((float) ((int) (this.v * ((float) n())))) * f2;
                float o2 = ((float) ((int) (this.w * ((float) o())))) * f2;
                float f3 = this.s.x;
                float f4 = this.s.y;
                float s_c = kVar.getMapConfig().getS_c();
                float f5 = this.j;
                float f6 = 0.0f;
                if (this.l) {
                    f5 -= kVar.getMapConfig().getS_r();
                    s_c = 0.0f;
                }
                float f7 = this.x;
                if (f7 >= 0.0f) {
                    f6 = f7;
                }
                if (f6 > 1.0f) {
                    f6 = 1.0f;
                }
                this.t[(this.d * 0) + 0] = f3 - (this.W * n2);
                this.t[(this.d * 0) + 1] = ((1.0f - this.X) * o2) + f4;
                this.t[(this.d * 0) + 2] = f3;
                this.t[(this.d * 0) + 3] = f4;
                this.t[(this.d * 0) + 6] = f5;
                this.t[(this.d * 0) + 7] = s_c;
                this.t[(this.d * 0) + 8] = f6;
                this.t[(this.d * 1) + 0] = ((1.0f - this.W) * n2) + f3;
                this.t[(this.d * 1) + 1] = ((1.0f - this.X) * o2) + f4;
                this.t[(this.d * 1) + 2] = f3;
                this.t[(this.d * 1) + 3] = f4;
                this.t[(this.d * 1) + 6] = f5;
                this.t[(this.d * 1) + 7] = s_c;
                this.t[(this.d * 1) + 8] = f6;
                this.t[(this.d * 2) + 0] = ((1.0f - this.W) * n2) + f3;
                this.t[(this.d * 2) + 1] = f4 - (this.X * o2);
                this.t[(this.d * 2) + 2] = f3;
                this.t[(this.d * 2) + 3] = f4;
                this.t[(this.d * 2) + 6] = f5;
                this.t[(this.d * 2) + 7] = s_c;
                this.t[(this.d * 2) + 8] = f6;
                this.t[(this.d * 3) + 0] = f3 - (n2 * this.W);
                this.t[(this.d * 3) + 1] = f4 - (o2 * this.X);
                this.t[(this.d * 3) + 2] = f3;
                this.t[(this.d * 3) + 3] = f4;
                this.t[(this.d * 3) + 6] = f5;
                this.t[(this.d * 3) + 7] = s_c;
                this.t[(this.d * 3) + 8] = f6;
                if (this.ad != null && this.ad.size() > 0) {
                    this.ah++;
                    if (this.ah >= this.ai * this.ad.size()) {
                        this.ah = 0;
                    }
                    if (this.ai == 0) {
                        this.ai = 1;
                    }
                    this.O = this.P[this.ah / this.ai];
                    if (!this.ag) {
                        p();
                    }
                }
                if (!this.E || !this.ag) {
                    this.t[(0 * this.d) + 4] = this.O.b();
                    this.t[(0 * this.d) + 5] = this.O.d();
                    this.t[(this.d * 1) + 4] = this.O.c();
                    this.t[(this.d * 1) + 5] = this.O.d();
                    this.t[(this.d * 2) + 4] = this.O.c();
                    this.t[(2 * this.d) + 5] = this.O.a();
                    this.t[(this.d * 3) + 4] = this.O.b();
                    this.t[(3 * this.d) + 5] = this.O.a();
                    this.E = true;
                }
            } catch (Throwable th) {
                iu.b(th, "MarkerDelegateImp", "drawMarker");
                return;
            }
            if (this.P != null && this.P.length > 0) {
                System.arraycopy(this.t, 0, fArr, i2, this.t.length);
            }
            if (this.i && isInfoWindowShown()) {
                this.aa.b().k();
                if (System.currentTimeMillis() - this.am > 1000) {
                    this.i = false;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ Throwable -> 0x00ce, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[Catch:{ Throwable -> 0x00ce, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.col.n3.k r12) {
        /*
            r11 = this;
            boolean r0 = r11.af
            if (r0 != 0) goto L_0x00da
            monitor-enter(r11)
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r0 = r11.ad     // Catch:{ Throwable -> 0x00ce }
            if (r0 == 0) goto L_0x00c7
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r0 = r11.ad     // Catch:{ Throwable -> 0x00ce }
            int r0 = r0.size()     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.r[] r0 = new com.amap.api.col.n3.r[r0]     // Catch:{ Throwable -> 0x00ce }
            r11.P = r0     // Catch:{ Throwable -> 0x00ce }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x00ce }
            r1 = 12
            r2 = 1
            r3 = 0
            if (r0 < r1) goto L_0x001d
            r0 = r2
            goto L_0x001e
        L_0x001d:
            r0 = r3
        L_0x001e:
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r1 = r11.ad     // Catch:{ Throwable -> 0x00ce }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x00ce }
            r4 = r3
        L_0x0025:
            boolean r5 = r1.hasNext()     // Catch:{ Throwable -> 0x00ce }
            if (r5 == 0) goto L_0x00b6
            java.lang.Object r5 = r1.next()     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.maps.model.BitmapDescriptor r5 = (com.amap.api.maps.model.BitmapDescriptor) r5     // Catch:{ Throwable -> 0x00ce }
            r6 = 0
            if (r0 == 0) goto L_0x003f
            com.amap.api.col.n3.r r6 = r12.a((com.amap.api.maps.model.BitmapDescriptor) r5)     // Catch:{ Throwable -> 0x00ce }
            if (r6 == 0) goto L_0x003f
            int r7 = r6.f()     // Catch:{ Throwable -> 0x00ce }
            goto L_0x0040
        L_0x003f:
            r7 = r3
        L_0x0040:
            if (r6 != 0) goto L_0x0047
            com.amap.api.col.n3.r r6 = new com.amap.api.col.n3.r     // Catch:{ Throwable -> 0x00ce }
            r6.<init>(r5, r7)     // Catch:{ Throwable -> 0x00ce }
        L_0x0047:
            if (r7 != 0) goto L_0x00ab
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ Throwable -> 0x00ce }
            if (r5 == 0) goto L_0x00ab
            boolean r7 = r5.isRecycled()     // Catch:{ Throwable -> 0x00ce }
            if (r7 != 0) goto L_0x00ab
            int r7 = r5.getWidth()     // Catch:{ Throwable -> 0x00ce }
            r11.M = r7     // Catch:{ Throwable -> 0x00ce }
            int r7 = r5.getHeight()     // Catch:{ Throwable -> 0x00ce }
            r11.N = r7     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.p r7 = r11.aa     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.k r7 = r7.b()     // Catch:{ Throwable -> 0x00ce }
            int r7 = r7.f()     // Catch:{ Throwable -> 0x00ce }
            if (r7 != 0) goto L_0x007d
            int r7 = r()     // Catch:{ Throwable -> 0x00ce }
            r6.a((int) r7)     // Catch:{ Throwable -> 0x00ce }
            if (r0 == 0) goto L_0x0079
            r12.a((com.amap.api.col.n3.r) r6)     // Catch:{ Throwable -> 0x00ce }
        L_0x0079:
            com.amap.api.col.n3.dv.a((int) r7, (android.graphics.Bitmap) r5, (boolean) r3)     // Catch:{ Throwable -> 0x00ce }
            goto L_0x00ab
        L_0x007d:
            com.amap.api.col.n3.p r8 = r11.aa     // Catch:{ Throwable -> 0x00ce }
            boolean r8 = r8.a((android.graphics.Bitmap) r5, (com.amap.api.col.n3.r) r6)     // Catch:{ Throwable -> 0x00ce }
            if (r8 == 0) goto L_0x009c
            float r8 = r6.b()     // Catch:{ Throwable -> 0x00ce }
            r9 = 1140850688(0x44000000, float:512.0)
            float r8 = r8 * r9
            int r8 = (int) r8     // Catch:{ Throwable -> 0x00ce }
            float r9 = r6.a()     // Catch:{ Throwable -> 0x00ce }
            r10 = 1149239296(0x44800000, float:1024.0)
            float r9 = r9 * r10
            int r9 = (int) r9     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.dv.a((int) r7, (android.graphics.Bitmap) r5, (int) r8, (int) r9)     // Catch:{ Throwable -> 0x00ce }
            r6.a((int) r7)     // Catch:{ Throwable -> 0x00ce }
            goto L_0x00a6
        L_0x009c:
            int r7 = r()     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.dv.a((int) r7, (android.graphics.Bitmap) r5, (boolean) r3)     // Catch:{ Throwable -> 0x00ce }
            r6.a((int) r7)     // Catch:{ Throwable -> 0x00ce }
        L_0x00a6:
            if (r0 == 0) goto L_0x00ab
            r12.a((com.amap.api.col.n3.r) r6)     // Catch:{ Throwable -> 0x00ce }
        L_0x00ab:
            r6.g()     // Catch:{ Throwable -> 0x00ce }
            com.amap.api.col.n3.r[] r5 = r11.P     // Catch:{ Throwable -> 0x00ce }
            r5[r4] = r6     // Catch:{ Throwable -> 0x00ce }
            int r4 = r4 + 1
            goto L_0x0025
        L_0x00b6:
            java.util.List<com.amap.api.maps.model.BitmapDescriptor> r12 = r11.ad     // Catch:{ Throwable -> 0x00ce }
            int r12 = r12.size()     // Catch:{ Throwable -> 0x00ce }
            if (r12 != r2) goto L_0x00c1
            r11.ag = r2     // Catch:{ Throwable -> 0x00ce }
            goto L_0x00c3
        L_0x00c1:
            r11.ag = r3     // Catch:{ Throwable -> 0x00ce }
        L_0x00c3:
            r11.E = r3     // Catch:{ Throwable -> 0x00ce }
            r11.af = r2     // Catch:{ Throwable -> 0x00ce }
        L_0x00c7:
            r11.q()     // Catch:{ all -> 0x00cc }
            monitor-exit(r11)     // Catch:{ all -> 0x00cc }
            return
        L_0x00cc:
            r12 = move-exception
            goto L_0x00d8
        L_0x00ce:
            r12 = move-exception
            java.lang.String r0 = "MarkerDelegateImp"
            java.lang.String r1 = "loadtexture"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r12, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00cc }
            monitor-exit(r11)     // Catch:{ all -> 0x00cc }
            return
        L_0x00d8:
            monitor-exit(r11)
            throw r12
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cn.a(com.amap.api.col.n3.k):void");
    }

    private static int r() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public final boolean i() {
        return this.ag;
    }

    public final void setPeriod(int i2) {
        if (i2 <= 1) {
            this.ai = 1;
        } else {
            this.ai = i2;
        }
    }

    public final void setObject(Object obj) {
        this.ab = obj;
    }

    public final Object getObject() {
        return this.ab;
    }

    public final void setPerspective(boolean z2) {
        this.ac = z2;
    }

    public final boolean isPerspective() {
        return this.ac;
    }

    public final int k() {
        try {
            if (this.ad != null) {
                if (this.ad.size() > 0) {
                    return this.O.f();
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final int getPeriod() {
        return this.ai;
    }

    public final LatLng b() {
        if (!this.aj) {
            return this.ae ? this.T : this.S;
        }
        this.aa.b().c().win2Map(this.ak, this.al, this.s);
        DPoint obtain = DPoint.obtain();
        this.aa.b().b(this.ak, this.al, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.y);
        obtain.recycle();
        return latLng;
    }

    public final void set2Top() {
        this.aa.a((cf) this);
    }

    public final void setFlat(boolean z2) throws RemoteException {
        this.l = z2;
        p();
        this.y.setFlat(z2);
    }

    public final boolean isFlat() {
        return this.l;
    }

    public final float getRotateAngle() {
        p();
        return this.k;
    }

    public final int c() {
        return this.m;
    }

    public final int d() {
        return this.n;
    }

    public final void setPositionByPixels(int i2, int i3) {
        this.ak = i2;
        this.al = i3;
        this.aj = true;
        q();
        p();
        this.i = true;
    }

    public final int e() {
        return this.o;
    }

    public final int f() {
        return this.p;
    }

    public final FPoint a() {
        return this.s;
    }

    public final boolean g() {
        return this.aj;
    }

    public final void setZIndex(float f2) {
        this.u = f2;
        this.y.zIndex(f2);
        this.aa.e();
    }

    public final float getZIndex() {
        return this.u;
    }

    public final boolean j() {
        FPoint fPoint;
        float f2;
        FPoint fPoint2;
        float f3;
        if (this.aj) {
            return true;
        }
        if (this.s != null) {
            if (!this.H) {
                return true;
            }
            this.J.x = this.q;
            this.J.y = this.r;
            if (this.aa.b().getMapConfig().getGeoRectangle().contains(this.q, this.r)) {
                return true;
            }
            s();
            this.I.x = this.s.x;
            this.I.y = this.s.y;
            FPoint[] mapRect = this.aa.b().getMapConfig().getMapRect();
            if (mapRect != null) {
                s();
                if (this.K > 0.0f && this.L > 0.0f && mapRect.length == 4) {
                    this.an = Math.min(mapRect[0].x, mapRect[1].x);
                    this.an = Math.min(this.an, mapRect[2].x);
                    this.an = Math.min(this.an, mapRect[3].x);
                    this.ao = Math.max(mapRect[0].x, mapRect[1].x);
                    this.ao = Math.max(this.ao, mapRect[2].x);
                    this.ao = Math.max(this.ao, mapRect[3].x);
                    this.aq = Math.min(mapRect[0].y, mapRect[1].y);
                    this.aq = Math.min(this.aq, mapRect[2].y);
                    this.aq = Math.min(this.aq, mapRect[3].y);
                    this.ap = Math.max(mapRect[0].y, mapRect[1].y);
                    this.ap = Math.max(this.ap, mapRect[2].y);
                    this.ap = Math.max(this.ap, mapRect[3].y);
                    if (this.s.x < (this.an + this.ao) / 2.0f) {
                        fPoint = this.I;
                        f2 = this.s.x + (this.K / 2.0f);
                    } else {
                        fPoint = this.I;
                        f2 = this.s.x - (this.K / 2.0f);
                    }
                    fPoint.x = f2;
                    if (this.s.y < (this.aq + this.ap) / 2.0f) {
                        fPoint2 = this.I;
                        f3 = this.s.y;
                    } else {
                        fPoint2 = this.I;
                        f3 = this.s.y - this.L;
                    }
                    fPoint2.y = f3;
                }
            }
            if (dv.a(this.I, mapRect)) {
                return true;
            }
        }
        return false;
    }

    public final void setGeoPoint(IPoint iPoint) {
        this.aj = false;
        a(iPoint.x, iPoint.y);
    }

    private void a(int i2, int i3) {
        this.q = i2;
        this.r = i3;
        DPoint obtain = DPoint.obtain();
        GLMapState.geo2LonLat(this.q, this.r, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x, false);
        this.S = latLng;
        this.aa.b().c().geo2Map(this.q, this.r, this.s);
        obtain.recycle();
        p();
    }

    public final IPoint getGeoPoint() {
        IPoint obtain = IPoint.obtain();
        if (this.aj) {
            this.aa.b().a(this.ak, this.al, obtain);
            return obtain;
        }
        obtain.set(this.q, this.r);
        return obtain;
    }

    public final void setAnimation(Animation animation) {
        if (this != null) {
            setAnimation(animation == null ? null : animation.glAnimation);
        }
    }

    public final void setAnimation(GLAnimation gLAnimation) {
        if (gLAnimation != null) {
            this.e = gLAnimation;
        }
    }

    public final boolean startAnimation() {
        if (this.e != null) {
            if (this.e instanceof GLAnimationSet) {
                GLAnimationSet gLAnimationSet = (GLAnimationSet) this.e;
                for (GLAnimation next : gLAnimationSet.getAnimations()) {
                    a(next);
                    next.setDuration(gLAnimationSet.getDuration());
                }
            } else {
                a(this.e);
            }
            this.H = false;
            this.e.start();
            p();
        }
        return false;
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            if (this.aj) {
                this.S = getPosition();
                setPosition(this.S);
                this.aj = true;
            }
            if (this.aj) {
                GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
                gLTranslateAnimation.mFromXDelta = (double) this.ak;
                gLTranslateAnimation.mFromYDelta = (double) this.al;
                IPoint obtain = IPoint.obtain();
                this.aa.b().b(gLTranslateAnimation.mToYDelta, gLTranslateAnimation.mToXDelta, obtain);
                gLTranslateAnimation.mToXDelta = (double) obtain.x;
                gLTranslateAnimation.mToYDelta = (double) obtain.y;
                obtain.recycle();
                return;
            }
            GLTranslateAnimation gLTranslateAnimation2 = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation2.mFromXDelta = (double) this.q;
            gLTranslateAnimation2.mFromYDelta = (double) this.r;
            IPoint obtain2 = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation2.mToXDelta, gLTranslateAnimation2.mToYDelta, obtain2);
            gLTranslateAnimation2.mToXDelta = (double) obtain2.x;
            gLTranslateAnimation2.mToYDelta = (double) obtain2.y;
            obtain2.recycle();
        }
    }

    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        if (this.e != null) {
            this.e.setAnimationListener(animationListener);
        }
    }

    public final float getAlpha() {
        return this.x;
    }

    public final void setAlpha(float f2) {
        this.x = f2;
        this.y.alpha(f2);
    }

    public final int getDisplayLevel() {
        return this.B;
    }

    public final MarkerOptions getOptions() {
        return this.y;
    }

    public final void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null) {
            this.y = markerOptions;
            this.S = this.y.getPosition();
            IPoint obtain = IPoint.obtain();
            this.ae = this.y.isGps();
            if (this.y.getPosition() != null) {
                if (this.ae) {
                    try {
                        double[] a2 = ku.a(this.y.getPosition().longitude, this.y.getPosition().latitude);
                        this.T = new LatLng(a2[1], a2[0]);
                        GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
                    } catch (Throwable th) {
                        iu.b(th, "MarkerDelegateImp", "create");
                        this.T = this.y.getPosition();
                    }
                } else {
                    GLMapState.lonlat2Geo(this.S.longitude, this.S.latitude, obtain);
                }
            }
            this.q = obtain.x;
            this.r = obtain.y;
            this.W = this.y.getAnchorU();
            this.X = this.y.getAnchorV();
            this.m = this.y.getInfoWindowOffsetX();
            this.n = this.y.getInfoWindowOffsetY();
            this.ai = this.y.getPeriod();
            this.u = this.y.getZIndex();
            this.F = this.y.isBelowMaskLayer();
            q();
            a(this.y.getIcons());
            this.Z = this.y.isVisible();
            this.V = this.y.getSnippet();
            this.U = this.y.getTitle();
            this.Y = this.y.isDraggable();
            this.R = getId();
            this.ac = this.y.isPerspective();
            this.l = this.y.isFlat();
            this.F = this.y.isBelowMaskLayer();
            this.x = this.y.getAlpha();
            setRotateAngle(this.y.getRotateAngle());
            this.B = this.y.getDisplayLevel();
            this.z = this.y.isInfoWindowAutoOverturn();
            this.A = this.y.isInfoWindowEnable();
            this.a = new float[16];
            this.b = new float[4];
            obtain.recycle();
        }
    }

    public final boolean isClickable() {
        return this.C;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.z;
    }

    public final boolean isInfoWindowEnable() {
        return this.A;
    }

    public final void b(boolean z2) {
        this.G = z2;
    }

    public final boolean l() {
        return this.G;
    }

    public final void setInfoWindowEnable(boolean z2) {
        this.A = z2;
        if (!z2) {
            hideInfoWindow();
        }
        this.y.infoWindowEnable(z2);
    }

    public final void setAutoOverturnInfoWindow(boolean z2) {
        this.z = z2;
        this.y.autoOverturnInfoWindow(z2);
    }

    public final void setClickable(boolean z2) {
        this.C = z2;
    }

    public final void setDisplayLevel(int i2) {
        this.B = i2;
        this.y.displayLevel(i2);
    }

    public final void setFixingPointEnable(boolean z2) {
        this.D = z2;
        if (!z2) {
            boolean z3 = this.aj;
            this.S = getPosition();
            setPosition(this.S);
            if (z3) {
                this.aj = true;
            }
        } else if (this.aj && this.S != null) {
            IPoint obtain = IPoint.obtain();
            this.aa.b().c().map2Win(this.s.x, this.s.y, obtain);
            this.ak = obtain.x;
            this.al = obtain.y;
            obtain.recycle();
        }
    }

    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    public final void setBelowMaskLayer(boolean z2) {
        this.F = z2;
    }

    private void s() {
        if (this.aa.b() != null && this.aa.b().getMapConfig() != null) {
            this.K = this.aa.b().getMapConfig().getMapPerPixelUnitLength() * ((float) n());
            this.L = this.aa.b().getMapConfig().getMapPerPixelUnitLength() * ((float) o());
        }
    }
}
