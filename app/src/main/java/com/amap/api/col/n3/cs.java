package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;

/* compiled from: PopupOverlay */
public final class cs implements ad, ch, IInfoWindowManager {
    private float A = 0.0f;
    private float B = 0.0f;
    private int C;
    private boolean D = true;
    private Bitmap E = null;
    private Bitmap F = null;
    private Bitmap G = null;
    private Bitmap H = null;
    private boolean I = false;
    /* access modifiers changed from: private */
    public GLAnimation J;
    private GLAnimation K;
    /* access modifiers changed from: private */
    public boolean L = false;
    private boolean M = true;
    k a = null;
    float[] b = new float[12];
    a c;
    float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    long e = 0;
    long f = Long.MAX_VALUE;
    long g = 100;
    ae h;
    private Context i;
    private cf j;
    private boolean k = false;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private FPoint p;
    private FloatBuffer q = null;
    private String r;
    private boolean s = true;
    private FloatBuffer t;
    private float u = 0.5f;
    private float v = 1.0f;
    private boolean w;
    private Bitmap x;
    private Bitmap y;
    private Rect z = new Rect();

    /* compiled from: PopupOverlay */
    static class a extends cv {
        int a;
        int b;
        int c;

        a(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    public final boolean a() {
        return false;
    }

    public final void b() throws RemoteException {
    }

    public final boolean c() {
        return false;
    }

    public final float getZIndex() {
        return 0.0f;
    }

    public final boolean isAboveMaskLayer() {
        return false;
    }

    public final void remove() throws RemoteException {
    }

    public final void setAboveMaskLayer(boolean z2) {
    }

    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    public final void setInfoWindowBackColor(int i2) {
    }

    public final void setInfoWindowBackEnable(boolean z2) {
    }

    public final void setInfoWindowBackScale(float f2, float f3) {
    }

    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    public final void setZIndex(float f2) {
    }

    public final void startAnimation() {
    }

    private synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    public cs(k kVar, Context context) {
        this.i = context;
        this.a = kVar;
        this.r = getId();
    }

    private int d() {
        try {
            return this.x.getWidth();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private int e() {
        try {
            return this.x.getHeight();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final String getId() {
        if (this.r == null) {
            this.r = "PopupOverlay";
        }
        return this.r;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0099, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(android.graphics.Bitmap r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x009a
            boolean r0 = r6.isRecycled()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 == 0) goto L_0x000b
            goto L_0x009a
        L_0x000b:
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 == 0) goto L_0x001d
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r0 = r0.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r1 = r6.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != r1) goto L_0x001d
            monitor-exit(r5)
            return
        L_0x001d:
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r1 = 0
            if (r0 == 0) goto L_0x008f
            android.graphics.Bitmap r0 = r5.E     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != 0) goto L_0x003c
            android.graphics.Bitmap r0 = r5.F     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != 0) goto L_0x003c
            android.graphics.Bitmap r0 = r5.G     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != 0) goto L_0x003c
            android.graphics.Bitmap r0 = r5.H     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != 0) goto L_0x003c
            android.graphics.Bitmap r0 = r5.y     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r5.a((android.graphics.Bitmap) r0)     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r5.y = r0     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            goto L_0x008f
        L_0x003c:
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r2 = r5.E     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r3 = 1
            if (r2 == 0) goto L_0x0050
            int r2 = r0.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r4 = r5.E     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r4 = r4.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 != r4) goto L_0x0050
            goto L_0x0084
        L_0x0050:
            android.graphics.Bitmap r2 = r5.G     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 == 0) goto L_0x0061
            int r2 = r0.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r4 = r5.G     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r4 = r4.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 != r4) goto L_0x0061
            goto L_0x0084
        L_0x0061:
            android.graphics.Bitmap r2 = r5.F     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 == 0) goto L_0x0072
            int r2 = r0.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r4 = r5.F     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r4 = r4.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 != r4) goto L_0x0072
            goto L_0x0084
        L_0x0072:
            android.graphics.Bitmap r2 = r5.H     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r2 == 0) goto L_0x0083
            int r0 = r0.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r2 = r5.H     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            int r2 = r2.hashCode()     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            if (r0 != r2) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r3 = r1
        L_0x0084:
            if (r3 != 0) goto L_0x008f
            android.graphics.Bitmap r0 = r5.y     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r5.a((android.graphics.Bitmap) r0)     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            android.graphics.Bitmap r0 = r5.x     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r5.y = r0     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
        L_0x008f:
            r5.I = r1     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            r5.x = r6     // Catch:{ Throwable -> 0x0098, all -> 0x0095 }
            monitor-exit(r5)
            return
        L_0x0095:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0098:
            monitor-exit(r5)
            return
        L_0x009a:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cs.b(android.graphics.Bitmap):void");
    }

    public final void setVisible(boolean z2) {
        if (!this.s && z2) {
            this.w = true;
        }
        this.s = z2;
    }

    public final boolean isVisible() {
        return this.s;
    }

    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() {
        return super.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cf, code lost:
        if (java.lang.Double.isNaN(r4.scale_y) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0110, code lost:
        if (java.lang.Double.isNaN(r4.scale_y) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r25, int r26) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            boolean r4 = r1.s
            if (r4 == 0) goto L_0x02b9
            com.autonavi.amap.mapcore.FPoint r4 = r1.p
            if (r4 == 0) goto L_0x02b9
            android.graphics.Bitmap r4 = r1.x
            if (r4 != 0) goto L_0x0014
            goto L_0x02b9
        L_0x0014:
            com.amap.api.col.n3.ae r4 = r1.h
            r5 = 0
            if (r4 == 0) goto L_0x0030
            com.amap.api.col.n3.ae r4 = r1.h
            long r7 = r4.c()
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0027
            long r7 = r1.f
            goto L_0x0031
        L_0x0027:
            long r9 = r1.g
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x0031
            long r7 = r1.g
            goto L_0x0031
        L_0x0030:
            r7 = r5
        L_0x0031:
            long r9 = java.lang.System.currentTimeMillis()
            long r11 = r1.e
            long r11 = r9 - r11
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0050
            long r7 = r1.e
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x004e
            com.amap.api.col.n3.cf r4 = r1.j     // Catch:{ RemoteException -> 0x0049 }
            r1.a((com.amap.api.col.n3.cf) r4)     // Catch:{ RemoteException -> 0x0049 }
            goto L_0x004e
        L_0x0049:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()
        L_0x004e:
            r1.e = r9
        L_0x0050:
            android.graphics.Bitmap r4 = r1.x
            r4.isRecycled()
            boolean r4 = r1.I
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x009f
            android.graphics.Bitmap r4 = r1.x
            boolean r4 = r4.isRecycled()
            if (r4 != 0) goto L_0x009f
            int r4 = r1.C     // Catch:{ Throwable -> 0x0092 }
            if (r4 == 0) goto L_0x0071
            int[] r4 = new int[r5]     // Catch:{ Throwable -> 0x0092 }
            int r7 = r1.C     // Catch:{ Throwable -> 0x0092 }
            r4[r6] = r7     // Catch:{ Throwable -> 0x0092 }
            android.opengl.GLES20.glDeleteTextures(r5, r4, r6)     // Catch:{ Throwable -> 0x0092 }
            goto L_0x007c
        L_0x0071:
            int[] r4 = new int[r5]     // Catch:{ Throwable -> 0x0092 }
            r4[r6] = r6     // Catch:{ Throwable -> 0x0092 }
            android.opengl.GLES20.glGenTextures(r5, r4, r6)     // Catch:{ Throwable -> 0x0092 }
            r4 = r4[r6]     // Catch:{ Throwable -> 0x0092 }
            r1.C = r4     // Catch:{ Throwable -> 0x0092 }
        L_0x007c:
            android.graphics.Bitmap r4 = r1.x     // Catch:{ Throwable -> 0x0092 }
            if (r4 == 0) goto L_0x009f
            android.graphics.Bitmap r4 = r1.x     // Catch:{ Throwable -> 0x0092 }
            boolean r4 = r4.isRecycled()     // Catch:{ Throwable -> 0x0092 }
            if (r4 != 0) goto L_0x009f
            int r4 = r1.C     // Catch:{ Throwable -> 0x0092 }
            android.graphics.Bitmap r7 = r1.x     // Catch:{ Throwable -> 0x0092 }
            com.amap.api.col.n3.dv.a((int) r4, (android.graphics.Bitmap) r7, (boolean) r6)     // Catch:{ Throwable -> 0x0092 }
            r1.I = r5     // Catch:{ Throwable -> 0x0092 }
            goto L_0x009f
        L_0x0092:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "PopupOverlay"
            java.lang.String r4 = "drawMarker"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
            r2.printStackTrace()
            return
        L_0x009f:
            boolean r4 = r1.M
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x00dc
            com.autonavi.amap.mapcore.animation.GLAnimation r4 = r1.K
            if (r4 == 0) goto L_0x00dc
            com.autonavi.amap.mapcore.animation.GLAnimation r4 = r1.K
            boolean r4 = r4.hasEnded()
            if (r4 != 0) goto L_0x00dc
            r1.L = r5
            com.autonavi.amap.mapcore.animation.GLTransformation r4 = new com.autonavi.amap.mapcore.animation.GLTransformation
            r4.<init>()
            com.autonavi.amap.mapcore.animation.GLAnimation r8 = r1.K
            long r9 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r8.getTransformation(r9, r4)
            double r8 = r4.scale_x
            boolean r8 = java.lang.Double.isNaN(r8)
            if (r8 != 0) goto L_0x0119
            double r8 = r4.scale_y
            boolean r8 = java.lang.Double.isNaN(r8)
            if (r8 != 0) goto L_0x0119
        L_0x00d1:
            double r8 = r4.scale_x
            float r8 = (float) r8
            r1.A = r8
            double r8 = r4.scale_y
            float r4 = (float) r8
            r1.B = r4
            goto L_0x0119
        L_0x00dc:
            com.autonavi.amap.mapcore.animation.GLAnimation r4 = r1.J
            if (r4 == 0) goto L_0x0113
            com.autonavi.amap.mapcore.animation.GLAnimation r4 = r1.J
            boolean r4 = r4.hasEnded()
            if (r4 != 0) goto L_0x0113
            r1.M = r6
            r1.L = r5
            int r4 = r1.n
            r1.l = r4
            int r4 = r1.o
            r1.m = r4
            com.autonavi.amap.mapcore.animation.GLTransformation r4 = new com.autonavi.amap.mapcore.animation.GLTransformation
            r4.<init>()
            com.autonavi.amap.mapcore.animation.GLAnimation r8 = r1.J
            long r9 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r8.getTransformation(r9, r4)
            double r8 = r4.scale_x
            boolean r8 = java.lang.Double.isNaN(r8)
            if (r8 != 0) goto L_0x0119
            double r8 = r4.scale_y
            boolean r8 = java.lang.Double.isNaN(r8)
            if (r8 != 0) goto L_0x0119
            goto L_0x00d1
        L_0x0113:
            r1.A = r7
            r1.B = r7
            r1.L = r6
        L_0x0119:
            com.amap.api.col.n3.k r4 = r1.a
            com.autonavi.ae.gmap.GLMapState r4 = r4.c()
            com.autonavi.amap.mapcore.FPoint r8 = r1.p
            if (r8 == 0) goto L_0x0213
            if (r4 != 0) goto L_0x0127
            goto L_0x0213
        L_0x0127:
            com.autonavi.amap.mapcore.IPoint r8 = com.autonavi.amap.mapcore.IPoint.obtain()
            com.autonavi.amap.mapcore.FPoint r11 = r1.p
            float r11 = r11.x
            com.autonavi.amap.mapcore.FPoint r12 = r1.p
            float r12 = r12.y
            r4.map2Win(r11, r12, r8)
            int r4 = r24.d()
            int r11 = r24.e()
            int r12 = r8.x
            int r13 = r1.l
            int r12 = r12 + r13
            float r12 = (float) r12
            float r13 = (float) r4
            float r14 = r1.u
            float r13 = r13 * r14
            float r12 = r12 - r13
            int r12 = (int) r12
            int r13 = r8.y
            int r14 = r1.m
            int r13 = r13 + r14
            float r13 = (float) r13
            float r14 = (float) r11
            float r15 = r1.v
            float r15 = r7 - r15
            float r14 = r14 * r15
            float r13 = r13 + r14
            int r13 = (int) r13
            r8.recycle()
            int r8 = r12 - r4
            if (r8 > r2) goto L_0x0213
            int r4 = -r4
            r8 = 2
            int r4 = r4 * r8
            if (r12 < r4) goto L_0x0213
            int r4 = -r11
            int r4 = r4 * r8
            if (r13 < r4) goto L_0x0213
            int r4 = r13 - r11
            if (r4 <= r3) goto L_0x016e
            goto L_0x0213
        L_0x016e:
            android.graphics.Bitmap r4 = r1.x
            if (r4 != 0) goto L_0x0174
            goto L_0x0213
        L_0x0174:
            android.graphics.Bitmap r4 = r1.x
            int r4 = r4.getWidth()
            android.graphics.Bitmap r11 = r1.x
            int r11 = r11.getHeight()
            java.nio.FloatBuffer r14 = r1.t
            r15 = 8
            if (r14 != 0) goto L_0x0191
            float[] r14 = new float[r15]
            r14 = {0, 1065353216, 1065353216, 1065353216, 1065353216, 0, 0, 0} // fill-array
            java.nio.FloatBuffer r14 = com.amap.api.col.n3.dv.a((float[]) r14)
            r1.t = r14
        L_0x0191:
            float r14 = r1.A
            float r14 = r7 - r14
            double r9 = (double) r14
            r16 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r9 = r9 * r16
            double r7 = (double) r4
            double r9 = r9 * r7
            int r7 = (int) r9
            float[] r8 = r1.b
            int r9 = r12 + r7
            float r10 = (float) r9
            r8[r6] = r10
            android.graphics.Rect r8 = r1.z
            r8.left = r9
            float[] r8 = r1.b
            int r9 = r3 - r13
            float r14 = (float) r9
            r8[r5] = r14
            float[] r8 = r1.b
            r16 = 0
            r17 = 2
            r8[r17] = r16
            float[] r8 = r1.b
            r17 = 3
            int r12 = r12 + r4
            int r4 = r12 - r7
            float r4 = (float) r4
            r8[r17] = r4
            float[] r7 = r1.b
            r8 = 4
            r7[r8] = r14
            android.graphics.Rect r7 = r1.z
            int r8 = r13 - r11
            r7.top = r8
            float[] r7 = r1.b
            r8 = 5
            r7[r8] = r16
            float[] r7 = r1.b
            r8 = 6
            r7[r8] = r4
            android.graphics.Rect r4 = r1.z
            r4.right = r12
            float[] r4 = r1.b
            r7 = 7
            int r9 = r9 + r11
            float r8 = (float) r9
            r4[r7] = r8
            android.graphics.Rect r4 = r1.z
            r4.bottom = r13
            float[] r4 = r1.b
            r4[r15] = r16
            float[] r4 = r1.b
            r7 = 9
            r4[r7] = r10
            float[] r4 = r1.b
            r7 = 10
            r4[r7] = r8
            float[] r4 = r1.b
            r7 = 11
            r4[r7] = r16
            java.nio.FloatBuffer r4 = r1.q
            if (r4 != 0) goto L_0x0208
            float[] r4 = r1.b
            java.nio.FloatBuffer r4 = com.amap.api.col.n3.dv.a((float[]) r4)
        L_0x0205:
            r1.q = r4
            goto L_0x0211
        L_0x0208:
            float[] r4 = r1.b
            java.nio.FloatBuffer r7 = r1.q
            java.nio.FloatBuffer r4 = com.amap.api.col.n3.dv.a((float[]) r4, (java.nio.FloatBuffer) r7)
            goto L_0x0205
        L_0x0211:
            r4 = r5
            goto L_0x0214
        L_0x0213:
            r4 = r6
        L_0x0214:
            if (r4 == 0) goto L_0x02b8
            float[] r4 = r1.d
            android.opengl.Matrix.setIdentityM(r4, r6)
            float[] r7 = r1.d
            r8 = 0
            r9 = 0
            float r10 = (float) r2
            r11 = 0
            float r12 = (float) r3
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            android.opengl.Matrix.orthoM(r7, r8, r9, r10, r11, r12, r13, r14)
            int r2 = r1.C
            java.nio.FloatBuffer r12 = r1.q
            java.nio.FloatBuffer r3 = r1.t
            if (r12 == 0) goto L_0x02b2
            if (r3 == 0) goto L_0x02b2
            if (r2 != 0) goto L_0x0237
            goto L_0x02b2
        L_0x0237:
            com.amap.api.col.n3.cs$a r4 = r1.c
            if (r4 != 0) goto L_0x0244
            com.amap.api.col.n3.cs$a r4 = new com.amap.api.col.n3.cs$a
            java.lang.String r7 = "texture.glsl"
            r4.<init>(r7)
            r1.c = r4
        L_0x0244:
            com.amap.api.col.n3.cs$a r4 = r1.c
            int r4 = r4.d
            android.opengl.GLES20.glUseProgram(r4)
            r4 = 3042(0xbe2, float:4.263E-42)
            android.opengl.GLES20.glEnable(r4)
            r7 = 771(0x303, float:1.08E-42)
            android.opengl.GLES20.glBlendFunc(r5, r7)
            r7 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glBlendColor(r7, r7, r7, r7)
            r13 = 3553(0xde1, float:4.979E-42)
            android.opengl.GLES20.glBindTexture(r13, r2)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.b
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r7 = r2.b
            r8 = 3
            r9 = 5126(0x1406, float:7.183E-42)
            r10 = 0
            r11 = 12
            android.opengl.GLES20.glVertexAttribPointer(r7, r8, r9, r10, r11, r12)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.c
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.c
            r19 = 2
            r20 = 5126(0x1406, float:7.183E-42)
            r21 = 0
            r22 = 8
            r18 = r2
            r23 = r3
            android.opengl.GLES20.glVertexAttribPointer(r18, r19, r20, r21, r22, r23)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.a
            float[] r3 = r1.d
            android.opengl.GLES20.glUniformMatrix4fv(r2, r5, r6, r3, r6)
            r2 = 4
            r3 = 6
            android.opengl.GLES20.glDrawArrays(r3, r6, r2)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.b
            android.opengl.GLES20.glDisableVertexAttribArray(r2)
            com.amap.api.col.n3.cs$a r2 = r1.c
            int r2 = r2.c
            android.opengl.GLES20.glDisableVertexAttribArray(r2)
            android.opengl.GLES20.glBindTexture(r13, r6)
            android.opengl.GLES20.glUseProgram(r6)
            android.opengl.GLES20.glDisable(r4)
        L_0x02b2:
            boolean r2 = r1.w
            if (r2 == 0) goto L_0x02b8
            r1.w = r6
        L_0x02b8:
            return
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cs.a(int, int):void");
    }

    public final void setInfoWindowAppearAnimation(Animation animation) {
        if (this.K == null || !this.K.equals(animation.glAnimation)) {
            this.J = animation.glAnimation;
            return;
        }
        try {
            this.J = animation.glAnimation.clone();
        } catch (Throwable th) {
            iu.b(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    public final void setInfoWindowDisappearAnimation(Animation animation) {
        if (this.J == null || !this.J.equals(animation.glAnimation)) {
            this.K = animation.glAnimation;
            return;
        }
        try {
            this.K = animation.glAnimation.clone();
        } catch (Throwable th) {
            iu.b(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    private void b(int i2, int i3) throws RemoteException {
        if (this.L) {
            this.n = i2;
            this.o = i3;
            return;
        }
        this.l = i2;
        this.m = i3;
        this.n = i2;
        this.o = i3;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            b(this.E);
        } else {
            b(this.G);
        }
    }

    private void f() {
        if (this.D || this.x == null) {
            b(this.E);
        } else if (this.K != null) {
            this.M = false;
            this.L = true;
            this.K.startNow();
            this.K.setAnimationListener(new Animation.AnimationListener() {
                final /* synthetic */ boolean a = true;

                public final void onAnimationStart() {
                }

                public final void onAnimationEnd() {
                    if (cs.this.J != null) {
                        boolean unused = cs.this.L = true;
                        cs.this.J.startNow();
                        cs.this.a(this.a);
                    }
                }
            });
        } else {
            if (this.J != null) {
                this.L = true;
                this.J.startNow();
            }
            a(true);
        }
        this.D = true;
    }

    public final void destroy() {
        if (this.k) {
            try {
                g();
                if (this.t != null) {
                    this.t.clear();
                    this.t = null;
                }
                if (this.q != null) {
                    this.q.clear();
                    this.q = null;
                }
                this.p = null;
                this.C = 0;
            } catch (Throwable th) {
                iu.b(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    private void g() {
        if (this.x != null) {
            Bitmap bitmap = this.x;
            if (bitmap != null) {
                bitmap.recycle();
                this.x = null;
            }
        }
        if (this.y != null && !this.y.isRecycled()) {
            this.y.recycle();
            this.y = null;
        }
        if (this.E != null && !this.E.isRecycled()) {
            this.E.recycle();
        }
        if (this.F != null && !this.F.isRecycled()) {
            this.F.recycle();
        }
        if (this.G != null && !this.G.isRecycled()) {
            this.G.recycle();
        }
        if (this.H != null && !this.H.isRecycled()) {
            this.H.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00be, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.amap.api.col.n3.cf r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            boolean r0 = r3.isInfoWindowEnable()     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r2)
            return
        L_0x000d:
            com.amap.api.col.n3.cf r0 = r2.j     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0024
            com.amap.api.col.n3.cf r0 = r2.j     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r3.getId()     // Catch:{ all -> 0x00cc }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x0024
            r2.b_()     // Catch:{ all -> 0x00cc }
        L_0x0024:
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00ca
            r2.j = r3     // Catch:{ all -> 0x00cc }
            r0 = 1
            r3.a(r0)     // Catch:{ all -> 0x00cc }
            r2.setVisible(r0)     // Catch:{ all -> 0x00cc }
            com.amap.api.maps.model.Marker r3 = new com.amap.api.maps.model.Marker     // Catch:{ Throwable -> 0x00bf }
            com.amap.api.col.n3.cf r0 = r2.j     // Catch:{ Throwable -> 0x00bf }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x00bf }
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            if (r0 == 0) goto L_0x00bd
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.view.View r0 = r0.a((com.amap.api.maps.model.Marker) r3)     // Catch:{ Throwable -> 0x00bf }
            android.graphics.Bitmap r0 = r2.a((android.view.View) r0)     // Catch:{ Throwable -> 0x00bf }
            if (r0 != 0) goto L_0x0063
            com.amap.api.col.n3.ae r1 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.view.View r1 = r1.b((com.amap.api.maps.model.Marker) r3)     // Catch:{ Throwable -> 0x00bf }
            if (r1 == 0) goto L_0x0063
            android.graphics.drawable.Drawable r0 = r1.getBackground()     // Catch:{ Throwable -> 0x00bf }
            if (r0 != 0) goto L_0x005f
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.graphics.drawable.Drawable r0 = r0.e()     // Catch:{ Throwable -> 0x00bf }
            r1.setBackground(r0)     // Catch:{ Throwable -> 0x00bf }
        L_0x005f:
            android.graphics.Bitmap r0 = r2.a((android.view.View) r1)     // Catch:{ Throwable -> 0x00bf }
        L_0x0063:
            if (r0 == 0) goto L_0x0072
            boolean r1 = r0.isRecycled()     // Catch:{ Throwable -> 0x00bf }
            if (r1 != 0) goto L_0x0072
            android.graphics.Bitmap r1 = r2.E     // Catch:{ Throwable -> 0x00bf }
            r2.a((android.graphics.Bitmap) r1)     // Catch:{ Throwable -> 0x00bf }
            r2.E = r0     // Catch:{ Throwable -> 0x00bf }
        L_0x0072:
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.view.View r0 = r0.c((com.amap.api.maps.model.Marker) r3)     // Catch:{ Throwable -> 0x00bf }
            android.graphics.Bitmap r0 = r2.a((android.view.View) r0)     // Catch:{ Throwable -> 0x00bf }
            if (r0 == 0) goto L_0x008b
            boolean r1 = r0.isRecycled()     // Catch:{ Throwable -> 0x00bf }
            if (r1 != 0) goto L_0x008b
            android.graphics.Bitmap r1 = r2.F     // Catch:{ Throwable -> 0x00bf }
            r2.a((android.graphics.Bitmap) r1)     // Catch:{ Throwable -> 0x00bf }
            r2.F = r0     // Catch:{ Throwable -> 0x00bf }
        L_0x008b:
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.view.View r0 = r0.d((com.amap.api.maps.model.Marker) r3)     // Catch:{ Throwable -> 0x00bf }
            android.graphics.Bitmap r0 = r2.a((android.view.View) r0)     // Catch:{ Throwable -> 0x00bf }
            if (r0 == 0) goto L_0x00a4
            boolean r1 = r0.isRecycled()     // Catch:{ Throwable -> 0x00bf }
            if (r1 != 0) goto L_0x00a4
            android.graphics.Bitmap r1 = r2.G     // Catch:{ Throwable -> 0x00bf }
            r2.a((android.graphics.Bitmap) r1)     // Catch:{ Throwable -> 0x00bf }
            r2.G = r0     // Catch:{ Throwable -> 0x00bf }
        L_0x00a4:
            com.amap.api.col.n3.ae r0 = r2.h     // Catch:{ Throwable -> 0x00bf }
            android.view.View r3 = r0.e(r3)     // Catch:{ Throwable -> 0x00bf }
            android.graphics.Bitmap r3 = r2.a((android.view.View) r3)     // Catch:{ Throwable -> 0x00bf }
            if (r3 == 0) goto L_0x00bd
            boolean r0 = r3.isRecycled()     // Catch:{ Throwable -> 0x00bf }
            if (r0 != 0) goto L_0x00bd
            android.graphics.Bitmap r0 = r2.H     // Catch:{ Throwable -> 0x00bf }
            r2.a((android.graphics.Bitmap) r0)     // Catch:{ Throwable -> 0x00bf }
            r2.H = r3     // Catch:{ Throwable -> 0x00bf }
        L_0x00bd:
            monitor-exit(r2)
            return
        L_0x00bf:
            r3 = move-exception
            java.lang.String r0 = "PopupOverlay"
            java.lang.String r1 = "getInfoWindow"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00cc }
            r3.printStackTrace()     // Catch:{ all -> 0x00cc }
        L_0x00ca:
            monitor-exit(r2)
            return
        L_0x00cc:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cs.a(com.amap.api.col.n3.cf):void");
    }

    private Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.i != null) {
            LinearLayout linearLayout = new LinearLayout(this.i);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return dv.a(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3 A[Catch:{ Throwable -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ Throwable -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A[Catch:{ Throwable -> 0x0106 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_() {
        /*
            r11 = this;
            com.amap.api.col.n3.cf r0 = r11.j     // Catch:{ Throwable -> 0x0106 }
            r1 = 0
            if (r0 == 0) goto L_0x0102
            com.amap.api.col.n3.cf r0 = r11.j     // Catch:{ Throwable -> 0x0106 }
            boolean r0 = r0.j()     // Catch:{ Throwable -> 0x0106 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0102
        L_0x000f:
            r0 = 1
            r11.setVisible(r0)     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.cf r2 = r11.j     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r2 = r2.h()     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.cf r3 = r11.j     // Catch:{ Throwable -> 0x0106 }
            int r3 = r3.e()     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.cf r4 = r11.j     // Catch:{ Throwable -> 0x0106 }
            int r4 = r4.c()     // Catch:{ Throwable -> 0x0106 }
            int r3 = r3 + r4
            com.amap.api.col.n3.cf r4 = r11.j     // Catch:{ Throwable -> 0x0106 }
            int r4 = r4.f()     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.cf r5 = r11.j     // Catch:{ Throwable -> 0x0106 }
            int r5 = r5.d()     // Catch:{ Throwable -> 0x0106 }
            int r4 = r4 + r5
            int r4 = r4 + 2
            boolean r5 = r11.L     // Catch:{ Throwable -> 0x0106 }
            if (r5 == 0) goto L_0x0045
            android.graphics.Bitmap r5 = r11.x     // Catch:{ Throwable -> 0x0106 }
            if (r5 != 0) goto L_0x0101
            android.graphics.Bitmap r5 = r11.E     // Catch:{ Throwable -> 0x0106 }
            if (r5 != 0) goto L_0x0045
            android.graphics.Bitmap r5 = r11.G     // Catch:{ Throwable -> 0x0106 }
            if (r5 == 0) goto L_0x0101
        L_0x0045:
            com.amap.api.col.n3.cf r5 = r11.j     // Catch:{ Throwable -> 0x0106 }
            com.autonavi.amap.mapcore.interfaces.IMarkerAction r5 = r5.getIMarkerAction()     // Catch:{ Throwable -> 0x0106 }
            if (r5 == 0) goto L_0x0057
            boolean r6 = r5.isInfoWindowEnable()     // Catch:{ Throwable -> 0x0106 }
            if (r6 != 0) goto L_0x0057
            r11.setVisible(r1)     // Catch:{ Throwable -> 0x0106 }
            return
        L_0x0057:
            r11.setVisible(r0)     // Catch:{ Throwable -> 0x0106 }
            if (r5 == 0) goto L_0x00f3
            boolean r0 = r5.isInfoWindowAutoOverturn()     // Catch:{ Throwable -> 0x0106 }
            if (r0 == 0) goto L_0x00f3
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r5 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r5 = r5.left     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r6 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r6 = r6.top     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r7 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r7 = r7.right     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r8 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r8 = r8.top     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Bitmap r9 = r11.E     // Catch:{ Throwable -> 0x0106 }
            if (r9 == 0) goto L_0x0088
            android.graphics.Bitmap r9 = r11.E     // Catch:{ Throwable -> 0x0106 }
            boolean r9 = r9.isRecycled()     // Catch:{ Throwable -> 0x0106 }
            if (r9 == 0) goto L_0x0081
            goto L_0x0088
        L_0x0081:
            android.graphics.Bitmap r9 = r11.E     // Catch:{ Throwable -> 0x0106 }
            int r9 = r9.getHeight()     // Catch:{ Throwable -> 0x0106 }
            goto L_0x0089
        L_0x0088:
            r9 = r1
        L_0x0089:
            int r8 = r8 + r9
            r0.<init>(r5, r6, r7, r8)     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r5 = new android.graphics.Rect     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r6 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r6 = r6.left     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r7 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r7 = r7.top     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r8 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r8 = r8.right     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Rect r9 = r11.z     // Catch:{ Throwable -> 0x0106 }
            int r9 = r9.top     // Catch:{ Throwable -> 0x0106 }
            android.graphics.Bitmap r10 = r11.G     // Catch:{ Throwable -> 0x0106 }
            if (r10 == 0) goto L_0x00b3
            android.graphics.Bitmap r10 = r11.G     // Catch:{ Throwable -> 0x0106 }
            boolean r10 = r10.isRecycled()     // Catch:{ Throwable -> 0x0106 }
            if (r10 == 0) goto L_0x00ac
            goto L_0x00b3
        L_0x00ac:
            android.graphics.Bitmap r10 = r11.G     // Catch:{ Throwable -> 0x0106 }
            int r10 = r10.getHeight()     // Catch:{ Throwable -> 0x0106 }
            goto L_0x00b4
        L_0x00b3:
            r10 = r1
        L_0x00b4:
            int r9 = r9 + r10
            r5.<init>(r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0106 }
            boolean r6 = r11.D     // Catch:{ Throwable -> 0x0106 }
            if (r6 == 0) goto L_0x00cb
            int r2 = r2.height()     // Catch:{ Throwable -> 0x0106 }
            int r0 = r0.height()     // Catch:{ Throwable -> 0x0106 }
            int r2 = r2 + r0
            int r2 = r2 + 2
            r5.offset(r1, r2)     // Catch:{ Throwable -> 0x0106 }
            goto L_0x00da
        L_0x00cb:
            int r2 = r2.height()     // Catch:{ Throwable -> 0x0106 }
            int r5 = r0.height()     // Catch:{ Throwable -> 0x0106 }
            int r2 = r2 + r5
            int r2 = r2 + 2
            int r2 = -r2
            r0.offset(r1, r2)     // Catch:{ Throwable -> 0x0106 }
        L_0x00da:
            com.amap.api.col.n3.k r0 = r11.a     // Catch:{ Throwable -> 0x0106 }
            r0.o()     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.k r0 = r11.a     // Catch:{ Throwable -> 0x0106 }
            r0.o()     // Catch:{ Throwable -> 0x0106 }
            r11.f()     // Catch:{ Throwable -> 0x0106 }
            com.amap.api.col.n3.cf r0 = r11.j     // Catch:{ Throwable -> 0x0106 }
            com.autonavi.amap.mapcore.FPoint r0 = r0.a()     // Catch:{ Throwable -> 0x0106 }
            r11.p = r0     // Catch:{ Throwable -> 0x0106 }
            r11.b(r3, r4)     // Catch:{ Throwable -> 0x0106 }
            return
        L_0x00f3:
            com.amap.api.col.n3.cf r0 = r11.j     // Catch:{ Throwable -> 0x0106 }
            com.autonavi.amap.mapcore.FPoint r0 = r0.a()     // Catch:{ Throwable -> 0x0106 }
            r11.p = r0     // Catch:{ Throwable -> 0x0106 }
            r11.b(r3, r4)     // Catch:{ Throwable -> 0x0106 }
            r11.f()     // Catch:{ Throwable -> 0x0106 }
        L_0x0101:
            return
        L_0x0102:
            r11.setVisible(r1)     // Catch:{ Throwable -> 0x0106 }
            return
        L_0x0106:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cs.a_():void");
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.s || this.j == null || !dv.a(this.z, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    public final synchronized void b_() {
        setVisible(false);
        g();
    }

    public final void a(ae aeVar) {
        this.h = aeVar;
    }
}
