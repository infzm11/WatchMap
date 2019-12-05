package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.amap.api.col.n3.cw;
import com.amap.api.col.n3.dd;
import com.amap.api.col.n3.dw;
import com.amap.api.col.n3.dz;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TileOverlayDelegateImp */
public final class cu implements cm {
    private static int h;
    cw.e a;
    private u b;
    private TileProvider c;
    private Float d;
    private boolean e;
    private boolean f;
    private k g;
    private int i;
    private int j;
    private int k;
    private dx l;
    private List<a> m;
    private boolean n;
    private b o;
    private String p;
    private FloatBuffer q;

    /* compiled from: TileOverlayDelegateImp */
    public static class a implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public IPoint e;
        public int f = 0;
        public boolean g = false;
        public FloatBuffer h = null;
        public Bitmap i = null;
        public dz.a j = null;
        public int k = 0;
        private final int l = 3;
        private k m;
        private u n;
        private dx o;

        public a(int i2, int i3, int i4, int i5, k kVar, u uVar, dx dxVar) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.m = kVar;
            this.n = uVar;
            this.o = dxVar;
        }

        private a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
            this.k = 0;
            this.n = aVar.n;
            this.m = aVar.m;
            this.o = aVar.o;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = (IPoint) this.e.clone();
                aVar.h = this.h.asReadOnlyBuffer();
                this.k = 0;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            return new a(this);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public final int hashCode() {
            return (this.a * 7) + (this.b * 11) + (this.c * 13) + this.d;
        }

        public final String toString() {
            return this.a + "-" + this.b + "-" + this.c + "-" + this.d;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void a(android.graphics.Bitmap r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                r0 = 3
                r1 = 1
                if (r5 == 0) goto L_0x0039
                boolean r2 = r5.isRecycled()     // Catch:{ all -> 0x0037 }
                if (r2 != 0) goto L_0x0039
                r2 = 0
                r4.j = r2     // Catch:{ Throwable -> 0x0018 }
                r4.i = r5     // Catch:{ Throwable -> 0x0018 }
                com.amap.api.col.n3.k r5 = r4.m     // Catch:{ Throwable -> 0x0018 }
                r2 = 0
                r5.setRunLowFrame(r2)     // Catch:{ Throwable -> 0x0018 }
                monitor-exit(r4)
                return
            L_0x0018:
                r5 = move-exception
                java.lang.String r2 = "TileOverlayDelegateImp"
                java.lang.String r3 = "setBitmap"
                com.amap.api.col.n3.iu.b((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0037 }
                r5.printStackTrace()     // Catch:{ all -> 0x0037 }
                int r5 = r4.k     // Catch:{ all -> 0x0037 }
                if (r5 >= r0) goto L_0x0035
                int r5 = r4.k     // Catch:{ all -> 0x0037 }
                int r5 = r5 + r1
                r4.k = r5     // Catch:{ all -> 0x0037 }
                com.amap.api.col.n3.dx r5 = r4.o     // Catch:{ all -> 0x0037 }
                if (r5 == 0) goto L_0x0035
                com.amap.api.col.n3.dx r5 = r4.o     // Catch:{ all -> 0x0037 }
                r5.a(r1, r4)     // Catch:{ all -> 0x0037 }
            L_0x0035:
                monitor-exit(r4)
                return
            L_0x0037:
                r5 = move-exception
                goto L_0x004d
            L_0x0039:
                int r5 = r4.k     // Catch:{ all -> 0x0037 }
                if (r5 >= r0) goto L_0x004b
                int r5 = r4.k     // Catch:{ all -> 0x0037 }
                int r5 = r5 + r1
                r4.k = r5     // Catch:{ all -> 0x0037 }
                com.amap.api.col.n3.dx r5 = r4.o     // Catch:{ all -> 0x0037 }
                if (r5 == 0) goto L_0x004b
                com.amap.api.col.n3.dx r5 = r4.o     // Catch:{ all -> 0x0037 }
                r5.a(r1, r4)     // Catch:{ all -> 0x0037 }
            L_0x004b:
                monitor-exit(r4)
                return
            L_0x004d:
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cu.a.a(android.graphics.Bitmap):void");
        }

        public final void a() {
            try {
                dz.a(this);
                if (this.g) {
                    this.n.a(this.f);
                }
                this.g = false;
                this.f = 0;
                if (this.i != null && !this.i.isRecycled()) {
                    this.i.recycle();
                }
                this.i = null;
                if (this.h != null) {
                    this.h.clear();
                }
                this.h = null;
                this.j = null;
                this.k = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    private static class b extends dd<Void, Void, List<a>> {
        private int d;
        private boolean e;
        private int f = 256;
        private int g = 256;
        private int h = 0;
        private WeakReference<k> i;
        private List<a> j;
        private boolean k;
        private WeakReference<u> l;
        private WeakReference<dx> m;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object a(Object[] objArr) {
            return e();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void a(Object obj) {
            List list = (List) obj;
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        int i2 = this.d;
                        boolean z = this.e;
                        List<a> list2 = this.j;
                        boolean z2 = this.k;
                        this.l.get();
                        boolean unused = cu.b((k) this.i.get(), list, i2, z, list2, z2, (dx) this.m.get());
                        list.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public b(boolean z, k kVar, int i2, int i3, int i4, List<a> list, boolean z2, u uVar, dx dxVar) {
            this.e = z;
            this.i = new WeakReference<>(kVar);
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.j = list;
            this.k = z2;
            this.l = new WeakReference<>(uVar);
            this.m = new WeakReference<>(dxVar);
        }

        private List<a> e() {
            try {
                k kVar = (k) this.i.get();
                if (kVar == null) {
                    return null;
                }
                int mapWidth = kVar.getMapWidth();
                int mapHeight = kVar.getMapHeight();
                this.d = (int) kVar.h();
                if (mapWidth > 0) {
                    if (mapHeight > 0) {
                        return cu.a(kVar, this.d, this.f, this.g, this.h, (u) this.l.get(), (dx) this.m.get());
                    }
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.ArrayList a(com.amap.api.col.n3.k r29, int r30, int r31, int r32, int r33, com.amap.api.col.n3.u r34, com.amap.api.col.n3.dx r35) {
        /*
            com.autonavi.ae.gmap.GLMapState r2 = r29.c()
            com.autonavi.amap.mapcore.MapConfig r3 = r29.getMapConfig()
            com.autonavi.amap.mapcore.Rectangle r3 = r3.getGeoRectangle()
            android.graphics.Rect r3 = r3.getRect()
            com.autonavi.amap.mapcore.IPoint r4 = com.autonavi.amap.mapcore.IPoint.obtain()
            com.autonavi.amap.mapcore.IPoint r5 = com.autonavi.amap.mapcore.IPoint.obtain()
            int r6 = r3.left
            r4.x = r6
            int r6 = r3.top
            r4.y = r6
            int r6 = r4.x
            r7 = 2147483647(0x7fffffff, float:NaN)
            int r6 = java.lang.Math.min(r7, r6)
            int r8 = r4.x
            r9 = 0
            int r8 = java.lang.Math.max(r9, r8)
            int r10 = r4.y
            int r7 = java.lang.Math.min(r7, r10)
            int r10 = r4.y
            int r10 = java.lang.Math.max(r9, r10)
            int r11 = r3.right
            r4.x = r11
            int r11 = r3.top
            r4.y = r11
            int r11 = r4.x
            int r6 = java.lang.Math.min(r6, r11)
            int r11 = r4.x
            int r8 = java.lang.Math.max(r8, r11)
            int r11 = r4.y
            int r7 = java.lang.Math.min(r7, r11)
            int r11 = r4.y
            int r10 = java.lang.Math.max(r10, r11)
            int r11 = r3.left
            r4.x = r11
            int r11 = r3.bottom
            r4.y = r11
            int r11 = r4.x
            int r6 = java.lang.Math.min(r6, r11)
            int r11 = r4.x
            int r8 = java.lang.Math.max(r8, r11)
            int r11 = r4.y
            int r7 = java.lang.Math.min(r7, r11)
            int r11 = r4.y
            int r10 = java.lang.Math.max(r10, r11)
            int r11 = r3.right
            r4.x = r11
            int r3 = r3.bottom
            r4.y = r3
            int r3 = r4.x
            int r3 = java.lang.Math.min(r6, r3)
            int r6 = r4.x
            int r6 = java.lang.Math.max(r8, r6)
            int r8 = r4.y
            int r7 = java.lang.Math.min(r7, r8)
            int r8 = r4.y
            int r8 = java.lang.Math.max(r10, r8)
            int r18 = 20 - r30
            r19 = 1
            int r10 = r19 << r18
            int r11 = r10 * r31
            int r3 = r3 - r11
            int r10 = r10 * r32
            int r7 = r7 - r10
            r2.getGeoCenter(r5)
            int r2 = r5.x
            int r2 = r2 >> r18
            int r2 = r2 / r31
            int r10 = r5.y
            int r10 = r10 >> r18
            int r20 = r10 / r32
            int r10 = r2 << r18
            int r15 = r10 * r31
            int r10 = r20 << r18
            int r14 = r10 * r32
            com.amap.api.col.n3.cu$a r13 = new com.amap.api.col.n3.cu$a
            r10 = r13
            r11 = r2
            r12 = r20
            r9 = r13
            r13 = r30
            r21 = r7
            r7 = r14
            r14 = r33
            r22 = r8
            r8 = r15
            r15 = r29
            r16 = r34
            r17 = r35
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            com.autonavi.amap.mapcore.IPoint r7 = com.autonavi.amap.mapcore.IPoint.obtain(r8, r7)
            r9.e = r7
            r4.recycle()
            r5.recycle()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r9)
            r5 = r19
        L_0x00ef:
            int r7 = r2 - r5
            r8 = r7
            r9 = 0
        L_0x00f3:
            int r15 = r2 + r5
            if (r8 > r15) goto L_0x01a2
            int r12 = r20 + r5
            com.autonavi.amap.mapcore.IPoint r15 = new com.autonavi.amap.mapcore.IPoint
            int r10 = r8 << r18
            int r14 = r10 * r31
            int r10 = r12 << r18
            int r10 = r10 * r32
            r15.<init>(r14, r10)
            int r10 = r15.x
            if (r10 >= r6) goto L_0x0153
            int r10 = r15.x
            if (r10 <= r3) goto L_0x0153
            int r10 = r15.y
            r13 = r22
            if (r10 >= r13) goto L_0x0149
            int r10 = r15.y
            r11 = r21
            if (r10 <= r11) goto L_0x0140
            if (r9 != 0) goto L_0x011e
            r9 = r19
        L_0x011e:
            com.amap.api.col.n3.cu$a r10 = new com.amap.api.col.n3.cu$a
            r23 = r10
            r24 = r2
            r2 = r11
            r11 = r8
            r25 = r9
            r9 = r13
            r13 = r30
            r26 = r7
            r7 = r14
            r14 = r33
            r0 = r15
            r15 = r29
            r16 = r34
            r17 = r35
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r10.e = r0
            r4.add(r10)
            goto L_0x015f
        L_0x0140:
            r24 = r2
            r26 = r7
            r0 = r9
            r2 = r11
            r9 = r13
            r7 = r14
            goto L_0x015d
        L_0x0149:
            r24 = r2
            r26 = r7
            r0 = r9
            r9 = r13
            r7 = r14
            r2 = r21
            goto L_0x015d
        L_0x0153:
            r24 = r2
            r26 = r7
            r0 = r9
            r7 = r14
            r2 = r21
            r9 = r22
        L_0x015d:
            r25 = r0
        L_0x015f:
            int r12 = r20 - r5
            com.autonavi.amap.mapcore.IPoint r0 = new com.autonavi.amap.mapcore.IPoint
            int r10 = r12 << r18
            int r10 = r10 * r32
            r0.<init>(r7, r10)
            int r7 = r0.x
            if (r7 >= r6) goto L_0x0194
            int r7 = r0.x
            if (r7 <= r3) goto L_0x0194
            int r7 = r0.y
            if (r7 >= r9) goto L_0x0194
            int r7 = r0.y
            if (r7 <= r2) goto L_0x0194
            if (r25 != 0) goto L_0x017e
            r25 = r19
        L_0x017e:
            com.amap.api.col.n3.cu$a r7 = new com.amap.api.col.n3.cu$a
            r10 = r7
            r11 = r8
            r13 = r30
            r14 = r33
            r15 = r29
            r16 = r34
            r17 = r35
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r7.e = r0
            r4.add(r7)
        L_0x0194:
            int r8 = r8 + 1
            r21 = r2
            r22 = r9
            r2 = r24
            r9 = r25
            r7 = r26
            goto L_0x00f3
        L_0x01a2:
            r24 = r2
            r26 = r7
            r0 = r9
            r2 = r21
            r9 = r22
            int r7 = r20 + r5
            int r7 = r7 + -1
        L_0x01af:
            int r8 = r20 - r5
            if (r7 <= r8) goto L_0x0234
            com.autonavi.amap.mapcore.IPoint r8 = new com.autonavi.amap.mapcore.IPoint
            int r10 = r15 << r18
            int r10 = r10 * r31
            int r11 = r7 << r18
            int r14 = r11 * r32
            r8.<init>(r10, r14)
            int r10 = r8.x
            if (r10 >= r6) goto L_0x01f2
            int r10 = r8.x
            if (r10 <= r3) goto L_0x01f2
            int r10 = r8.y
            if (r10 >= r9) goto L_0x01f2
            int r10 = r8.y
            if (r10 <= r2) goto L_0x01f2
            if (r0 != 0) goto L_0x01d4
            r0 = r19
        L_0x01d4:
            com.amap.api.col.n3.cu$a r13 = new com.amap.api.col.n3.cu$a
            r10 = r13
            r11 = r15
            r12 = r7
            r27 = r0
            r0 = r13
            r13 = r30
            r1 = r14
            r14 = r33
            r22 = r15
            r15 = r29
            r16 = r34
            r17 = r35
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r0.e = r8
            r4.add(r0)
            goto L_0x01f7
        L_0x01f2:
            r1 = r14
            r22 = r15
            r27 = r0
        L_0x01f7:
            com.autonavi.amap.mapcore.IPoint r0 = new com.autonavi.amap.mapcore.IPoint
            int r8 = r26 << r18
            int r8 = r8 * r31
            r0.<init>(r8, r1)
            int r1 = r0.x
            if (r1 >= r6) goto L_0x022c
            int r1 = r0.x
            if (r1 <= r3) goto L_0x022c
            int r1 = r0.y
            if (r1 >= r9) goto L_0x022c
            int r1 = r0.y
            if (r1 <= r2) goto L_0x022c
            if (r27 != 0) goto L_0x0214
            r27 = r19
        L_0x0214:
            com.amap.api.col.n3.cu$a r1 = new com.amap.api.col.n3.cu$a
            r10 = r1
            r11 = r26
            r12 = r7
            r13 = r30
            r14 = r33
            r15 = r29
            r16 = r34
            r17 = r35
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r1.e = r0
            r4.add(r1)
        L_0x022c:
            r0 = r27
            int r7 = r7 + -1
            r15 = r22
            goto L_0x01af
        L_0x0234:
            if (r0 == 0) goto L_0x0240
            int r5 = r5 + 1
            r21 = r2
            r22 = r9
            r2 = r24
            goto L_0x00ef
        L_0x0240:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cu.a(com.amap.api.col.n3.k, int, int, int, int, com.amap.api.col.n3.u, com.amap.api.col.n3.dx):java.util.ArrayList");
    }

    public cu(TileOverlayOptions tileOverlayOptions, u uVar) {
        this.f = false;
        this.i = 256;
        this.j = 256;
        this.k = -1;
        this.m = new ArrayList();
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.b = uVar;
        this.c = tileOverlayOptions.getTileProvider();
        this.i = this.c.getTileWidth();
        this.j = this.c.getTileHeight();
        this.q = dv.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        this.d = Float.valueOf(tileOverlayOptions.getZIndex());
        this.e = tileOverlayOptions.isVisible();
        this.p = getId();
        this.g = this.b.a();
        this.k = Integer.parseInt(this.p.substring(11));
        try {
            dw.a aVar = new dw.a(this.b.d(), this.p);
            aVar.f = tileOverlayOptions.getMemoryCacheEnabled();
            aVar.g = tileOverlayOptions.getDiskCacheEnabled();
            aVar.a = tileOverlayOptions.getMemCacheSize();
            long diskCacheSize = tileOverlayOptions.getDiskCacheSize();
            if (diskCacheSize <= 0) {
                aVar.g = false;
            }
            aVar.b = diskCacheSize;
            String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
            if (diskCacheDir != null && !diskCacheDir.equals("")) {
                aVar.c = new File(diskCacheDir);
            }
            this.l = new dx(this.b.d(), this.i, this.j);
            this.l.a(this.c);
            this.l.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public cu(TileOverlayOptions tileOverlayOptions, u uVar, byte b2) {
        this(tileOverlayOptions, uVar);
        this.f = true;
    }

    public final void remove() {
        this.b.a((cm) this);
        this.g.setRunLowFrame(false);
    }

    public final void destroy(boolean z) {
        if (this.o != null && this.o.a() == dd.d.RUNNING) {
            this.o.d();
        }
        synchronized (this.m) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a();
            }
            this.m.clear();
        }
        if (this.l != null) {
            this.l.g();
            this.l.a(true);
            this.l.a((TileProvider) null);
        }
        if (z) {
            remove();
        }
    }

    public final void clearTileCache() {
        if (this.l != null) {
            this.l.f();
        }
    }

    public final String getId() {
        if (this.p == null) {
            h++;
            this.p = "TileOverlay" + h;
        }
        return this.p;
    }

    public final void setZIndex(float f2) {
        this.d = Float.valueOf(f2);
        this.b.c();
    }

    public final float getZIndex() {
        return this.d.floatValue();
    }

    public final void setVisible(boolean z) {
        this.e = z;
        this.g.setRunLowFrame(false);
        if (z) {
            a(true);
        }
    }

    public final boolean isVisible() {
        return this.e;
    }

    public final boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    public final int hashCodeRemote() {
        return super.hashCode();
    }

    public final void a() {
        if (this.m != null) {
            synchronized (this.m) {
                try {
                    if (this.m.size() != 0) {
                        int size = this.m.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            a aVar = this.m.get(i2);
                            if (!aVar.g) {
                                IPoint iPoint = aVar.e;
                                if (!(aVar.i == null || aVar.i.isRecycled() || iPoint == null)) {
                                    aVar.f = dv.a(aVar.i);
                                    if (aVar.f != 0) {
                                        aVar.g = true;
                                    }
                                    aVar.i = null;
                                }
                            }
                            if (aVar.g) {
                                GLMapState c2 = this.g.c();
                                int i3 = this.i;
                                int i4 = this.j;
                                int i5 = aVar.e.x;
                                int i6 = 1 << (20 - ((int) ((float) aVar.c)));
                                int i7 = i4 * i6;
                                int i8 = aVar.e.y + i7;
                                FPoint obtain = FPoint.obtain();
                                c2.geo2Map(i5, i8, obtain);
                                FPoint obtain2 = FPoint.obtain();
                                int i9 = (i6 * i3) + i5;
                                c2.geo2Map(i9, i8, obtain2);
                                FPoint obtain3 = FPoint.obtain();
                                int i10 = i8 - i7;
                                c2.geo2Map(i9, i10, obtain3);
                                FPoint obtain4 = FPoint.obtain();
                                c2.geo2Map(i5, i10, obtain4);
                                float[] fArr = {obtain.x, obtain.y, 0.0f, obtain2.x, obtain2.y, 0.0f, obtain3.x, obtain3.y, 0.0f, obtain4.x, obtain4.y, 0.0f};
                                aVar.h = aVar.h == null ? dv.a(fArr) : dv.a(fArr, aVar.h);
                                obtain.recycle();
                                obtain4.recycle();
                                obtain2.recycle();
                                obtain3.recycle();
                                int i11 = aVar.f;
                                FloatBuffer floatBuffer = aVar.h;
                                FloatBuffer floatBuffer2 = this.q;
                                if (!(floatBuffer == null || floatBuffer2 == null)) {
                                    if (i11 != 0) {
                                        if (!((this.a != null && !this.a.b()) || this.b == null || this.b.a() == null)) {
                                            this.a = (cw.e) this.b.a().m(0);
                                        }
                                        GLES20.glUseProgram(this.a.d);
                                        GLES20.glEnable(3042);
                                        GLES20.glBlendFunc(1, 771);
                                        GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
                                        GLES20.glBindTexture(3553, i11);
                                        GLES20.glEnableVertexAttribArray(this.a.b);
                                        GLES20.glVertexAttribPointer(this.a.b, 3, 5126, false, 12, floatBuffer);
                                        GLES20.glEnableVertexAttribArray(this.a.c);
                                        GLES20.glVertexAttribPointer(this.a.c, 2, 5126, false, 8, floatBuffer2);
                                        GLES20.glUniformMatrix4fv(this.a.a, 1, false, this.b.e(), 0);
                                        GLES20.glDrawArrays(6, 0, 4);
                                        GLES20.glDisableVertexAttribArray(this.a.b);
                                        GLES20.glDisableVertexAttribArray(this.a.c);
                                        GLES20.glBindTexture(3553, 0);
                                        GLES20.glUseProgram(0);
                                        GLES20.glDisable(3042);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b() {
        if (this.m != null) {
            synchronized (this.m) {
                this.m.clear();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d0, code lost:
        if (com.amap.api.col.n3.dq.a((double) ((float) (57.29577951308232d * ((2.0d * java.lang.Math.atan(java.lang.Math.exp((((double) ((float) ((((((double) ((-r10) * 256)) * r12) + 2.003750834E7d) * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((((((double) (r9 * 256)) * r12) - 2.003750834E7d) * 180.0d) / 2.003750834E7d))) == false) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(com.amap.api.col.n3.k r20, java.util.List<com.amap.api.col.n3.cu.a> r21, int r22, boolean r23, java.util.List<com.amap.api.col.n3.cu.a> r24, boolean r25, com.amap.api.col.n3.dx r26) {
        /*
            r1 = r21
            r2 = r22
            r3 = r24
            r4 = r26
            r5 = 0
            if (r1 != 0) goto L_0x000c
            return r5
        L_0x000c:
            if (r3 != 0) goto L_0x000f
            return r5
        L_0x000f:
            monitor-enter(r24)
            java.util.Iterator r6 = r24.iterator()     // Catch:{ all -> 0x00e8 }
        L_0x0014:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x00e8 }
            r8 = 1
            if (r7 == 0) goto L_0x004b
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00e8 }
            com.amap.api.col.n3.cu$a r7 = (com.amap.api.col.n3.cu.a) r7     // Catch:{ all -> 0x00e8 }
            java.util.Iterator r9 = r21.iterator()     // Catch:{ all -> 0x00e8 }
        L_0x0025:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x00e8 }
            if (r10 == 0) goto L_0x0044
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00e8 }
            com.amap.api.col.n3.cu$a r10 = (com.amap.api.col.n3.cu.a) r10     // Catch:{ all -> 0x00e8 }
            boolean r11 = r7.equals(r10)     // Catch:{ all -> 0x00e8 }
            if (r11 == 0) goto L_0x0025
            boolean r11 = r7.g     // Catch:{ all -> 0x00e8 }
            if (r11 == 0) goto L_0x0025
            boolean r9 = r7.g     // Catch:{ all -> 0x00e8 }
            r10.g = r9     // Catch:{ all -> 0x00e8 }
            int r9 = r7.f     // Catch:{ all -> 0x00e8 }
            r10.f = r9     // Catch:{ all -> 0x00e8 }
            goto L_0x0045
        L_0x0044:
            r8 = r5
        L_0x0045:
            if (r8 != 0) goto L_0x0014
            r7.a()     // Catch:{ all -> 0x00e8 }
            goto L_0x0014
        L_0x004b:
            r24.clear()     // Catch:{ all -> 0x00e8 }
            monitor-exit(r24)     // Catch:{ all -> 0x00e8 }
            float r6 = r20.getMaxZoomLevel()
            int r6 = (int) r6
            if (r2 > r6) goto L_0x00e7
            float r6 = r20.getMinZoomLevel()
            int r6 = (int) r6
            if (r2 >= r6) goto L_0x005f
            goto L_0x00e7
        L_0x005f:
            int r2 = r21.size()
            if (r2 > 0) goto L_0x0066
            return r5
        L_0x0066:
            if (r5 >= r2) goto L_0x00e6
            java.lang.Object r6 = r1.get(r5)
            com.amap.api.col.n3.cu$a r6 = (com.amap.api.col.n3.cu.a) r6
            if (r6 == 0) goto L_0x00e1
            if (r25 == 0) goto L_0x00d2
            int r9 = r6.c
            r10 = 10
            if (r9 < r10) goto L_0x00e1
            int r9 = r6.a
            int r10 = r6.b
            int r11 = r6.c
            r12 = 4684618790526082299(0x41031bf8456d5cfb, double:156543.0339)
            int r11 = r8 << r11
            double r14 = (double) r11
            double r12 = r12 / r14
            int r9 = r9 * 256
            double r14 = (double) r9
            double r14 = r14 * r12
            r16 = 4716143987917890519(0x41731bf84570a3d7, double:2.003750834E7)
            double r14 = r14 - r16
            int r9 = -r10
            int r9 = r9 * 256
            double r9 = (double) r9
            double r9 = r9 * r12
            double r9 = r9 + r16
            r11 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r14 = r14 * r11
            double r14 = r14 / r16
            float r13 = (float) r14
            double r9 = r9 * r11
            double r9 = r9 / r16
            float r9 = (float) r9
            r14 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r9 = (double) r9
            r18 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r9 = r9 * r18
            double r9 = r9 / r11
            double r9 = java.lang.Math.exp(r9)
            double r9 = java.lang.Math.atan(r9)
            double r16 = r16 * r9
            r9 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r16 = r16 - r9
            double r14 = r14 * r16
            float r9 = (float) r14
            double r9 = (double) r9
            double r11 = (double) r13
            boolean r9 = com.amap.api.col.n3.dq.a(r9, r11)
            if (r9 != 0) goto L_0x00e1
        L_0x00d2:
            r3.add(r6)
            boolean r9 = r6.g
            if (r9 != 0) goto L_0x00e1
            if (r4 == 0) goto L_0x00e1
            r9 = r23
            r4.a(r9, r6)
            goto L_0x00e3
        L_0x00e1:
            r9 = r23
        L_0x00e3:
            int r5 = r5 + 1
            goto L_0x0066
        L_0x00e6:
            return r8
        L_0x00e7:
            return r5
        L_0x00e8:
            r0 = move-exception
            r1 = r0
            monitor-exit(r24)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.cu.b(com.amap.api.col.n3.k, java.util.List, int, boolean, java.util.List, boolean, com.amap.api.col.n3.dx):boolean");
    }

    public final void a(boolean z) {
        if (!this.n) {
            if (this.o != null && this.o.a() == dd.d.RUNNING) {
                this.o.d();
            }
            b bVar = new b(z, this.g, this.i, this.j, this.k, this.m, this.f, this.b, this.l);
            this.o = bVar;
            this.o.b((Params[]) new Void[0]);
        }
    }

    public final void b(boolean z) {
        if (this.n != z) {
            this.n = z;
            if (this.l != null) {
                this.l.a(z);
            }
        }
    }
}
