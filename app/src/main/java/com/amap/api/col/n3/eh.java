package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Marker;
import com.autonavi.ae.gmap.listener.MapWidgetListener;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: MapOverlayViewGroup */
public final class eh extends ViewGroup implements ad {
    ae a;
    int b;
    int c;
    private k d;
    private Context e;
    private ej f;
    private eg g;
    /* access modifiers changed from: private */
    public ee h;
    /* access modifiers changed from: private */
    public ei i;
    private ed j;
    private ef k;
    /* access modifiers changed from: private */
    public ek l;
    /* access modifiers changed from: private */
    public View m;
    private cf n;
    /* access modifiers changed from: private */
    public Drawable o = null;
    private boolean p;
    private View q;
    private boolean r;

    /* compiled from: MapOverlayViewGroup */
    public static class a extends ViewGroup.LayoutParams {
        public FPoint a = null;
        public int b = 0;
        public int c = 0;
        public int d = 51;

        public a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.a = fPoint;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }
    }

    public eh(Context context, k kVar) {
        super(context);
        int i2 = 1;
        this.p = true;
        this.b = 0;
        this.c = 0;
        try {
            this.d = kVar;
            this.e = context;
            setBackgroundColor(-1);
            this.f = new ej(context, this.d);
            this.i = new ei(context, this.d);
            this.j = new ed(context);
            this.k = new ef(context);
            this.l = new ek(context, this.d);
            this.g = new eg(context, this.d);
            this.h = new ee(context, this.d);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.d.m() != null) {
                addView(this.d.m(), 0, layoutParams);
            } else {
                i2 = 0;
            }
            addView(this.j, i2, layoutParams);
            addView(this.f, layoutParams);
            addView(this.i, layoutParams);
            addView(this.k, new ViewGroup.LayoutParams(-2, -2));
            a aVar = new a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83);
            addView(this.l, aVar);
            a aVar2 = new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83);
            addView(this.g, aVar2);
            a aVar3 = new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51);
            addView(this.h, aVar3);
            this.h.setVisibility(8);
            this.d.a((MapWidgetListener) new MapWidgetListener() {
                public final void setFrontViewVisibility(boolean z) {
                }

                public final void invalidateScaleView() {
                    if (eh.this.i != null) {
                        eh.this.i.post(new Runnable() {
                            public final void run() {
                                eh.this.i.c();
                            }
                        });
                    }
                }

                public final void invalidateCompassView() {
                    if (eh.this.h != null) {
                        eh.this.h.post(new Runnable() {
                            public final void run() {
                                eh.this.h.b();
                            }
                        });
                    }
                }

                public final void invalidateZoomController(final float f) {
                    if (eh.this.l != null) {
                        eh.this.l.post(new Runnable() {
                            public final void run() {
                                eh.this.l.a(f);
                            }
                        });
                    }
                }
            });
            if (!this.d.i().isMyLocationButtonEnabled()) {
                this.g.setVisibility(8);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (this.k != null && z && this.d.n()) {
            this.k.a(true);
        }
    }

    public final void b(boolean z) {
        if (this.l != null) {
            this.l.a(z);
        }
    }

    public final void c(boolean z) {
        if (this.g != null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public final void d(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }

    public final void e(boolean z) {
        if (this.i != null) {
            ei eiVar = this.i;
            if (z) {
                eiVar.setVisibility(0);
                eiVar.c();
                return;
            }
            eiVar.a("");
            eiVar.b();
            eiVar.setVisibility(8);
        }
    }

    public final void f(boolean z) {
        if (this.f != null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public final void a(float f2) {
        if (this.l != null) {
            this.l.a(f2);
        }
    }

    public final void a(int i2) {
        if (this.l != null) {
            this.l.a(i2);
        }
    }

    public final void b(int i2) {
        if (this.f != null) {
            this.f.a(i2);
            this.f.postInvalidate();
            k();
        }
    }

    private void k() {
        if (this.i != null && this.i.getVisibility() == 0) {
            this.i.postInvalidate();
        }
    }

    public final void c(int i2) {
        if (this.f != null) {
            this.f.b(i2);
            k();
        }
    }

    public final void d(int i2) {
        if (this.f != null) {
            this.f.c(i2);
            k();
        }
    }

    public final float e(int i2) {
        if (this.f == null) {
            return 0.0f;
        }
        k();
        return this.f.d(i2);
    }

    public final void a(int i2, float f2) {
        if (this.f != null) {
            this.f.a(i2, f2);
            k();
        }
    }

    public final void a(ae aeVar) {
        this.a = aeVar;
    }

    public final Point c() {
        if (this.f == null) {
            return null;
        }
        return this.f.b();
    }

    public final ed d() {
        return this.j;
    }

    public final ef e() {
        return this.k;
    }

    public final eg f() {
        return this.g;
    }

    public final ee g() {
        return this.h;
    }

    public final ej h() {
        return this.f;
    }

    public final void a(CameraPosition cameraPosition) {
        if (g.c != 1 && this.d.i().isLogoEnable()) {
            if (cameraPosition.zoom >= 10.0f && !dq.a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                this.f.setVisibility(8);
            } else if (this.d.p() == -1) {
                this.f.setVisibility(0);
            }
        }
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        try {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a aVar = (a) childAt.getLayoutParams();
                        int[] iArr = new int[2];
                        a(childAt, aVar.width, aVar.height, iArr);
                        if (childAt instanceof ek) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = getWidth() - iArr[0];
                            i9 = getHeight();
                            i10 = aVar.d;
                        } else if (childAt instanceof eg) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = getWidth() - iArr[0];
                            i9 = iArr[1];
                            i10 = aVar.d;
                        } else if (childAt instanceof ee) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = 0;
                            i9 = 0;
                            i10 = aVar.d;
                        } else if (aVar.a != null) {
                            IPoint obtain = IPoint.obtain();
                            this.d.c().map2Win(aVar.a.x, aVar.a.y, obtain);
                            obtain.x += aVar.b;
                            obtain.y += aVar.c;
                            a(childAt, iArr[0], iArr[1], obtain.x, obtain.y, aVar.d);
                            obtain.recycle();
                        }
                        a(childAt, i6, i7, i8, i9, i10);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        int[] iArr2 = new int[2];
                        a(childAt, layoutParams.width, layoutParams.height, iArr2);
                        if (childAt instanceof ef) {
                            a(childAt, iArr2[0], iArr2[1], 20, (this.d.l().y - 80) - iArr2[1], 51);
                        } else {
                            a(childAt, iArr2[0], iArr2[1], 0, 0, 51);
                        }
                    }
                }
            }
            this.f.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(cf cfVar) {
        if (cfVar != null) {
            try {
                if ((this.a == null || !this.a.a() || cfVar.getTitle() != null || cfVar.getSnippet() != null) && cfVar.isInfoWindowEnable()) {
                    if (this.n != null && !this.n.getId().equals(cfVar.getId())) {
                        b_();
                    }
                    if (this.a != null) {
                        this.n = cfVar;
                        cfVar.a(true);
                        this.r = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private View b(cf cfVar) throws RemoteException {
        Throwable th;
        View view;
        Marker marker = new Marker(cfVar);
        try {
            if (this.o == null) {
                this.o = Cdo.a(this.e, "infowindow_bg.9.png");
            }
        } catch (Throwable th2) {
            iu.b(th2, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
            th2.printStackTrace();
        }
        View view2 = null;
        try {
            if (this.r) {
                view = this.a.a(marker);
                if (view == null) {
                    try {
                        view = this.a.b(marker);
                    } catch (Throwable th3) {
                        th = th3;
                        iu.b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                        th.printStackTrace();
                        return view;
                    }
                }
                this.q = view;
                this.r = false;
            } else {
                view = this.q;
            }
            if (view != null) {
                view2 = view;
            } else if (!this.a.a()) {
                return null;
            } else {
                view2 = this.a.a(marker);
            }
            if (view2.getBackground() != null) {
                return view2;
            }
            view2.setBackground(this.o);
            return view2;
        } catch (Throwable th4) {
            view = view2;
            th = th4;
            iu.b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
            th.printStackTrace();
            return view;
        }
    }

    public final void a_() {
        int i2;
        try {
            if (this.n == null || !this.n.j()) {
                if (this.m != null && this.m.getVisibility() == 0) {
                    this.m.setVisibility(8);
                }
            } else if (this.p) {
                int e2 = this.n.e() + this.n.c();
                int f2 = this.n.f() + this.n.d() + 2;
                View b2 = b(this.n);
                if (b2 != null) {
                    if (b2 != null) {
                        if (this.m != null) {
                            if (b2 != this.m) {
                                this.m.clearFocus();
                                removeView(this.m);
                            }
                        }
                        this.m = b2;
                        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                        this.m.setDrawingCacheEnabled(true);
                        this.m.setDrawingCacheQuality(0);
                        this.n.h();
                        int i3 = -2;
                        if (layoutParams != null) {
                            i3 = layoutParams.width;
                            i2 = layoutParams.height;
                        } else {
                            i2 = -2;
                        }
                        a aVar = new a(i3, i2, this.n.a(), e2, f2, 81);
                        addView(this.m, aVar);
                    }
                    if (this.m != null) {
                        a aVar2 = (a) this.m.getLayoutParams();
                        if (aVar2 != null) {
                            aVar2.a = this.n.a();
                            aVar2.b = e2;
                            aVar2.c = f2;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        this.b = e2;
                        this.c = f2;
                        if (this.a.a()) {
                            this.a.a(this.n.getTitle(), this.n.getSnippet());
                        }
                        if (this.m.getVisibility() == 8) {
                            this.m.setVisibility(0);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            iu.b(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    public final void b_() {
        if (this.d != null && this.d.getMainHandler() != null) {
            this.d.getMainHandler().post(new Runnable() {
                public final void run() {
                    if (eh.this.m != null) {
                        eh.this.m.clearFocus();
                        eh.this.removeView(eh.this.m);
                        dv.a(eh.this.m.getBackground());
                        dv.a(eh.this.o);
                        View unused = eh.this.m = null;
                    }
                }
            });
            if (this.n != null) {
                this.n.a(false);
            }
            this.n = null;
            this.b = 0;
            this.c = 0;
        }
    }

    private void a(View view, int i2, int i3, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            view.measure(0, 0);
        }
        if (i2 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i2 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i2;
        }
        if (i3 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i3 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i3;
        }
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i6 & 7;
        int i8 = i6 & 112;
        if (i7 == 5) {
            i4 -= i2;
        } else if (i7 == 1) {
            i4 -= i2 / 2;
        }
        if (i8 == 80) {
            i5 -= i3;
        } else if (i8 == 17) {
            i5 -= i3 / 2;
        } else if (i8 == 16) {
            i5 = (i5 / 2) - (i3 / 2);
        }
        view.layout(i4, i5, i4 + i2, i5 + i3);
        if (view instanceof l) {
            this.d.a(i2, i3);
        }
    }

    public final void i() {
        b_();
        dv.a(this.o);
        if (this.l != null) {
            this.l.a();
        }
        if (this.i != null) {
            this.i.a();
        }
        if (this.f != null) {
            this.f.a();
        }
        if (this.g != null) {
            this.g.a();
        }
        if (this.h != null) {
            this.h.a();
        }
        if (this.k != null) {
            this.k.a();
        }
        removeAllViews();
        this.q = null;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.m == null || this.n == null || !dv.a(new Rect(this.m.getLeft(), this.m.getTop(), this.m.getRight(), this.m.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    public final void a(Canvas canvas) {
        if (this.m != null && this.n != null) {
            Bitmap drawingCache = this.m.getDrawingCache(true);
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) this.m.getLeft(), (float) this.m.getTop(), new Paint());
            }
        }
    }

    public final void j() {
        this.b = 0;
        this.c = 0;
    }
}
