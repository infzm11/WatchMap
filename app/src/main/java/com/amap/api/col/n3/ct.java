package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;

/* compiled from: TextDelegateImp */
public final class ct implements cl {
    private static int b;
    private int A;
    private int B;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private float[] F = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    int a = 9;
    private float c = 0.0f;
    private float d = 0.0f;
    private int e = 4;
    private int f = 32;
    private FPoint g = FPoint.obtain();
    private int h;
    private Bitmap i;
    private int j;
    private int k;
    private String l;
    private LatLng m;
    private float n = 0.5f;
    private float o = 1.0f;
    private boolean p = true;
    private p q;
    private Object r;
    private String s;
    private int t;
    private int u;
    private int v;
    private Typeface w;
    private float x;
    private Rect y = new Rect();
    private Paint z = new Paint();

    public final IMarkerAction getIMarkerAction() {
        return null;
    }

    public final Rect h() {
        return null;
    }

    public final boolean i() {
        return true;
    }

    public final boolean isInfoWindowShown() {
        return false;
    }

    public final void setAnchor(float f2, float f3) {
    }

    public final void setRotateAngle(float f2) {
        this.d = f2;
        this.c = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        b();
    }

    public final void destroy(boolean z2) {
        try {
            this.D = true;
            if (z2) {
                remove();
            }
            if (this.i != null) {
                this.i.recycle();
                this.i = null;
            }
            this.m = null;
            this.r = null;
        } catch (Throwable th) {
            iu.b(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public ct(TextOptions textOptions, p pVar) throws RemoteException {
        this.q = pVar;
        if (textOptions.getPosition() != null) {
            this.m = textOptions.getPosition();
        }
        setAlign(textOptions.getAlignX(), textOptions.getAlignY());
        this.p = textOptions.isVisible();
        this.s = textOptions.getText();
        this.t = textOptions.getBackgroundColor();
        this.u = textOptions.getFontColor();
        this.v = textOptions.getFontSize();
        this.r = textOptions.getObject();
        this.x = textOptions.getZIndex();
        this.w = textOptions.getTypeface();
        this.l = getId();
        setRotateAngle(textOptions.getRotate());
        a();
        c();
    }

    private void a() {
        if (this.s != null && this.s.trim().length() > 0) {
            try {
                this.z.setTypeface(this.w);
                this.z.setSubpixelText(true);
                this.z.setAntiAlias(true);
                this.z.setStrokeWidth(5.0f);
                this.z.setStrokeCap(Paint.Cap.ROUND);
                this.z.setTextSize((float) this.v);
                this.z.setTextAlign(Paint.Align.CENTER);
                this.z.setColor(this.u);
                Paint.FontMetrics fontMetrics = this.z.getFontMetrics();
                int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i3 = (int) (((((float) i2) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                this.z.getTextBounds(this.s, 0, this.s.length(), this.y);
                Bitmap createBitmap = Bitmap.createBitmap(this.y.width() + 6, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.t);
                canvas.drawText(this.s, (float) (this.y.centerX() + 3), (float) i3, this.z);
                this.i = createBitmap;
                this.j = this.i.getWidth();
                this.k = this.i.getHeight();
            } catch (Throwable th) {
                iu.b(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    public final synchronized boolean remove() {
        b();
        this.p = false;
        return this.q.a((ci) this);
    }

    private void b() {
        if (this.q.b() != null) {
            this.q.b().setRunLowFrame(false);
        }
    }

    public final LatLng getPosition() {
        return this.m;
    }

    public final String getId() {
        if (this.l == null) {
            b++;
            this.l = "Text" + b;
        }
        return this.l;
    }

    public final void setPosition(LatLng latLng) {
        this.m = latLng;
        c();
        b();
    }

    public final void setVisible(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
            b();
        }
    }

    public final boolean isVisible() {
        return this.p;
    }

    public final void setZIndex(float f2) {
        this.x = f2;
        this.q.e();
    }

    public final float getZIndex() {
        return this.x;
    }

    public final float getAnchorU() {
        return this.n;
    }

    public final float getAnchorV() {
        return this.o;
    }

    public final boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    public final int hashCodeRemote() {
        return super.hashCode();
    }

    private boolean c() {
        if (this.m == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        GLMapState.lonlat2Geo(this.m.longitude, this.m.latitude, obtain);
        this.A = obtain.x;
        this.B = obtain.y;
        this.q.b().a(this.m.latitude, this.m.longitude, this.g);
        obtain.recycle();
        return true;
    }

    public final void a(k kVar, float[] fArr, int i2, float f2) {
        if (this.p && !this.D && this.m != null && this.i != null) {
            this.g.x = (float) (this.A - kVar.getMapConfig().getS_x());
            this.g.y = (float) (this.B - kVar.getMapConfig().getS_y());
            try {
                float f3 = ((float) this.j) * f2;
                float f4 = f2 * ((float) this.k);
                float f5 = this.g.x;
                float f6 = this.g.y;
                float s_c = kVar.getMapConfig().getS_c();
                this.F[(this.a * 0) + 0] = f5 - (this.n * f3);
                this.F[(this.a * 0) + 1] = ((1.0f - this.o) * f4) + f6;
                this.F[(this.a * 0) + 2] = f5;
                this.F[(this.a * 0) + 3] = f6;
                this.F[(this.a * 0) + 6] = this.c;
                this.F[(this.a * 0) + 7] = s_c;
                this.F[(this.a * 1) + 0] = ((1.0f - this.n) * f3) + f5;
                this.F[(this.a * 1) + 1] = ((1.0f - this.o) * f4) + f6;
                this.F[(this.a * 1) + 2] = f5;
                this.F[(this.a * 1) + 3] = f6;
                this.F[(this.a * 1) + 6] = this.c;
                this.F[(this.a * 1) + 7] = s_c;
                this.F[(this.a * 2) + 0] = ((1.0f - this.n) * f3) + f5;
                this.F[(this.a * 2) + 1] = f6 - (this.o * f4);
                this.F[(this.a * 2) + 2] = f5;
                this.F[(this.a * 2) + 3] = f6;
                this.F[(this.a * 2) + 6] = this.c;
                this.F[(this.a * 2) + 7] = s_c;
                this.F[(this.a * 3) + 0] = f5 - (f3 * this.n);
                this.F[(this.a * 3) + 1] = f6 - (f4 * this.o);
                this.F[(this.a * 3) + 2] = f5;
                this.F[(this.a * 3) + 3] = f6;
                this.F[(this.a * 3) + 6] = this.c;
                this.F[(3 * this.a) + 7] = s_c;
                System.arraycopy(this.F, 0, fArr, i2, this.F.length);
            } catch (Throwable th) {
                iu.b(th, "TextDelegateImp", "drawMarker");
            }
        }
    }

    public final void a(k kVar) {
        if (!this.E) {
            try {
                if (this.i != null && !this.i.isRecycled()) {
                    if (this.h == 0) {
                        int[] iArr = {0};
                        GLES20.glGenTextures(1, iArr, 0);
                        this.h = iArr[0];
                    }
                    dv.a(this.h, this.i, false);
                    this.E = true;
                    this.i.recycle();
                }
            } catch (Throwable th) {
                iu.b(th, "TextDelegateImp", "loadtexture");
                th.printStackTrace();
            }
        }
    }

    public final void setObject(Object obj) {
        this.r = obj;
    }

    public final Object getObject() {
        return this.r;
    }

    public final int k() {
        try {
            return this.h;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final float getRotateAngle() {
        return this.d;
    }

    public final void setText(String str) throws RemoteException {
        this.s = str;
        d();
    }

    public final String getText() throws RemoteException {
        return this.s;
    }

    public final void setBackgroundColor(int i2) throws RemoteException {
        this.t = i2;
        d();
    }

    public final int getBackgroundColor() throws RemoteException {
        return this.t;
    }

    public final void setFontColor(int i2) throws RemoteException {
        this.u = i2;
        d();
    }

    public final int getFontColor() throws RemoteException {
        return this.u;
    }

    public final void setFontSize(int i2) throws RemoteException {
        this.v = i2;
        d();
    }

    public final int getFontSize() throws RemoteException {
        return this.v;
    }

    public final void setTypeface(Typeface typeface) throws RemoteException {
        this.w = typeface;
        d();
    }

    public final Typeface getTypeface() throws RemoteException {
        return this.w;
    }

    public final void setAlign(int i2, int i3) throws RemoteException {
        this.e = i2;
        if (i2 != 4) {
            switch (i2) {
                case 1:
                    this.n = 0.0f;
                    break;
                case 2:
                    this.n = 1.0f;
                    break;
                default:
                    this.n = 0.5f;
                    break;
            }
        } else {
            this.n = 0.5f;
        }
        this.f = i3;
        if (i3 == 8) {
            this.o = 0.0f;
        } else if (i3 == 16) {
            this.o = 1.0f;
        } else if (i3 != 32) {
            this.o = 0.5f;
        } else {
            this.o = 0.5f;
        }
        b();
    }

    public final int getAlignX() throws RemoteException {
        return this.e;
    }

    public final int getAlignY() {
        return this.f;
    }

    private synchronized void d() {
        a();
        this.E = false;
        b();
    }

    public final boolean j() {
        Rectangle geoRectangle = this.q.b().getMapConfig().getGeoRectangle();
        return geoRectangle != null && geoRectangle.contains(this.A, this.B);
    }

    public final void b(boolean z2) {
        this.C = z2;
    }

    public final boolean l() {
        return this.C;
    }
}
