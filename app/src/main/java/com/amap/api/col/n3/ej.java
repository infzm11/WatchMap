package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

/* compiled from: WaterMarkerView */
public final class ej extends View {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Paint e = new Paint();
    private boolean f = false;
    private int g = 0;
    private int h = 0;
    private k i;
    private int j = 0;
    private int k = 10;
    private int l = 0;
    private int m = 0;
    private int n = 10;
    private int o = 8;
    private int p = 0;
    private boolean q = false;
    private float r = 0.0f;
    private float s = 0.0f;
    private boolean t = true;

    public final void a() {
        try {
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            this.a = null;
            this.b = null;
            if (this.c != null) {
                this.c.recycle();
                this.c = null;
            }
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
            this.e = null;
        } catch (Throwable th) {
            iu.b(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3 A[SYNTHETIC, Splitter:B:32:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd A[SYNTHETIC, Splitter:B:37:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC, Splitter:B:45:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e4 A[SYNTHETIC, Splitter:B:50:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ej(android.content.Context r6, com.amap.api.col.n3.k r7) {
        /*
            r5 = this;
            r5.<init>(r6)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r5.e = r0
            r0 = 0
            r5.f = r0
            r5.g = r0
            r5.h = r0
            r5.j = r0
            r1 = 10
            r5.k = r1
            r5.l = r0
            r5.m = r0
            r5.n = r1
            r1 = 8
            r5.o = r1
            r5.p = r0
            r5.q = r0
            r0 = 0
            r5.r = r0
            r5.s = r0
            r0 = 1
            r5.t = r0
            r5.i = r7
            r7 = 0
            android.content.res.AssetManager r1 = com.amap.api.col.n3.dr.a(r6)     // Catch:{ Throwable -> 0x00b3, all -> 0x00ae }
            java.lang.String r2 = "ap.data"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ Throwable -> 0x00b3, all -> 0x00ae }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            r5.c = r2     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            android.graphics.Bitmap r2 = r5.c     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            float r3 = com.amap.api.col.n3.g.a     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            android.graphics.Bitmap r2 = com.amap.api.col.n3.dv.a((android.graphics.Bitmap) r2, (float) r3)     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            r5.a = r2     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            r1.close()     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            android.content.res.AssetManager r6 = com.amap.api.col.n3.dr.a(r6)     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            java.lang.String r2 = "ap1.data"
            java.io.InputStream r6 = r6.open(r2)     // Catch:{ Throwable -> 0x00a9, all -> 0x00a4 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ Throwable -> 0x00a2 }
            r5.d = r7     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Bitmap r7 = r5.d     // Catch:{ Throwable -> 0x00a2 }
            float r2 = com.amap.api.col.n3.g.a     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Bitmap r7 = com.amap.api.col.n3.dv.a((android.graphics.Bitmap) r7, (float) r2)     // Catch:{ Throwable -> 0x00a2 }
            r5.b = r7     // Catch:{ Throwable -> 0x00a2 }
            r6.close()     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Bitmap r7 = r5.b     // Catch:{ Throwable -> 0x00a2 }
            int r7 = r7.getWidth()     // Catch:{ Throwable -> 0x00a2 }
            r5.h = r7     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Bitmap r7 = r5.b     // Catch:{ Throwable -> 0x00a2 }
            int r7 = r7.getHeight()     // Catch:{ Throwable -> 0x00a2 }
            r5.g = r7     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Paint r7 = r5.e     // Catch:{ Throwable -> 0x00a2 }
            r7.setAntiAlias(r0)     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Paint r7 = r5.e     // Catch:{ Throwable -> 0x00a2 }
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r7.setColor(r0)     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Paint r7 = r5.e     // Catch:{ Throwable -> 0x00a2 }
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.STROKE     // Catch:{ Throwable -> 0x00a2 }
            r7.setStyle(r0)     // Catch:{ Throwable -> 0x00a2 }
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ Throwable -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0097:
            if (r6 == 0) goto L_0x00d6
            r6.close()     // Catch:{ Throwable -> 0x009d }
            return
        L_0x009d:
            r6 = move-exception
            r6.printStackTrace()
            return
        L_0x00a2:
            r7 = move-exception
            goto L_0x00b7
        L_0x00a4:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto L_0x00d8
        L_0x00a9:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto L_0x00b7
        L_0x00ae:
            r6 = move-exception
            r1 = r7
            r7 = r6
            r6 = r1
            goto L_0x00d8
        L_0x00b3:
            r6 = move-exception
            r1 = r7
            r7 = r6
            r6 = r1
        L_0x00b7:
            java.lang.String r0 = "WaterMarkerView"
            java.lang.String r2 = "create"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r7, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00d7 }
            r7.printStackTrace()     // Catch:{ all -> 0x00d7 }
            if (r1 == 0) goto L_0x00cb
            r1.close()     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00cb:
            if (r6 == 0) goto L_0x00d6
            r6.close()     // Catch:{ Throwable -> 0x00d1 }
            return
        L_0x00d1:
            r6 = move-exception
            r6.printStackTrace()
            return
        L_0x00d6:
            return
        L_0x00d7:
            r7 = move-exception
        L_0x00d8:
            if (r1 == 0) goto L_0x00e2
            r1.close()     // Catch:{ Throwable -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e2:
            if (r6 == 0) goto L_0x00ec
            r6.close()     // Catch:{ Throwable -> 0x00e8 }
            goto L_0x00ec
        L_0x00e8:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ec:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ej.<init>(android.content.Context, com.amap.api.col.n3.k):void");
    }

    public final Point b() {
        return new Point(this.k, this.l - 2);
    }

    public final void a(int i2) {
        this.m = 0;
        this.j = i2;
        c();
    }

    public final void b(int i2) {
        this.m = 1;
        this.o = i2;
        c();
    }

    public final void c(int i2) {
        this.m = 1;
        this.n = i2;
        c();
    }

    public final float d(int i2) {
        switch (i2) {
            case 0:
                return this.r;
            case 1:
                return 1.0f - this.r;
            case 2:
                return 1.0f - this.s;
            default:
                return 0.0f;
        }
    }

    public final void a(int i2, float f2) {
        this.m = 2;
        this.p = i2;
        float max = Math.max(0.0f, Math.min(f2, 1.0f));
        switch (i2) {
            case 0:
                this.r = max;
                this.t = true;
                break;
            case 1:
                this.r = 1.0f - max;
                this.t = false;
                break;
            case 2:
                this.s = 1.0f - max;
                break;
        }
        c();
    }

    public final void c() {
        if (getWidth() != 0 && getHeight() != 0) {
            d();
            postInvalidate();
        }
    }

    public final void onDraw(Canvas canvas) {
        try {
            if (getWidth() == 0) {
                return;
            }
            if (getHeight() != 0) {
                if (this.b != null) {
                    if (!this.q) {
                        d();
                        this.q = true;
                    }
                    canvas.drawBitmap(this.f ? this.b : this.a, (float) this.k, (float) this.l, this.e);
                }
            }
        } catch (Throwable th) {
            iu.b(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    private void d() {
        int width;
        switch (this.m) {
            case 0:
                if (this.j != 1) {
                    if (this.j != 2) {
                        this.n = 10;
                        this.o = 8;
                        break;
                    } else {
                        width = (getWidth() - this.h) - 10;
                    }
                } else {
                    width = (getWidth() - this.h) / 2;
                }
                this.n = width;
                this.o = 8;
            case 2:
                this.n = (int) (this.t ? ((float) getWidth()) * this.r : (((float) getWidth()) * this.r) - ((float) this.h));
                this.o = (int) (((float) getHeight()) * this.s);
                break;
        }
        this.k = this.n;
        this.l = (getHeight() - this.o) - this.g;
        if (this.k < 0) {
            this.k = 0;
        }
        if (this.l < 0) {
            this.l = 0;
        }
    }
}
