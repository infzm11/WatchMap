package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: ScaleView */
public final class ei extends View {
    private String a = "";
    private int b = 0;
    private k c;
    private Paint d;
    private Paint e;
    private Rect f;
    private Point g;
    private float h = 0.0f;
    private final int[] i = {10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 100, 50, 25, 10, 5};

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
    }

    public ei(Context context, k kVar) {
        super(context);
        this.c = kVar;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.d.setStrokeWidth(2.0f * g.a);
        this.d.setStyle(Paint.Style.STROKE);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.e.setTextSize(20.0f * g.a);
        this.h = (float) dr.b(context);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (this.a != null && !this.a.equals("") && this.b != 0) {
            Point l = this.c.l();
            if (l != null) {
                this.e.getTextBounds(this.a, 0, this.a.length(), this.f);
                int i2 = l.x;
                int height = (l.y - this.f.height()) + 5;
                canvas.drawText(this.a, (float) (((this.b - this.f.width()) / 2) + i2), (float) height, this.e);
                float f2 = (float) i2;
                float height2 = (float) (height + (this.f.height() - 5));
                float f3 = f2;
                canvas.drawLine(f3, height2 - (this.h * 2.0f), f2, height2 + g.a, this.d);
                canvas.drawLine(f3, height2, (float) (this.b + i2), height2, this.d);
                canvas.drawLine((float) (this.b + i2), height2 - (2.0f * this.h), (float) (i2 + this.b), height2 + g.a, this.d);
            }
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b() {
        this.b = 0;
    }

    public final void c() {
        if (this.c != null) {
            try {
                float b2 = this.c.b(1);
                this.g = this.c.r();
                if (this.g != null) {
                    DPoint PixelsToLatLong = VirtualEarthProjection.PixelsToLatLong((long) this.g.x, (long) this.g.y, 20);
                    float t = this.c.t();
                    int i2 = (int) b2;
                    String a2 = dv.a(this.i[i2]);
                    this.b = (int) (((double) this.i[i2]) / (((double) ((float) ((((Math.cos((PixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) b2))))) * ((double) t)));
                    this.a = a2;
                    PixelsToLatLong.recycle();
                    invalidate();
                }
            } catch (Throwable th) {
                iu.b(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }
}
