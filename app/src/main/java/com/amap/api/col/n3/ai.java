package com.amap.api.col.n3;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* compiled from: MultiPointOverlayDelegate */
public final class ai implements IMultiPointOverlay {
    private static int E;
    int A;
    private String B;
    private float[] C;
    private boolean D;
    private ExecutorService F;
    /* access modifiers changed from: private */
    public List<String> G;
    private int H;
    private float[] I;
    BitmapDescriptor a = BitmapDescriptorFactory.defaultMarker();
    BitmapDescriptor b;
    float c;
    float d;
    float e;
    float f;
    float g;
    List<MultiPointItem> h;
    ak i;
    ah j;
    ah k;
    List<MultiPointItem> l;
    IPoint m;
    aj n;
    List<ag> o;
    float[] p;
    float[] q;
    float[] r;
    Rect s;
    ah t;
    ah u;
    int v;
    int w;
    float[] x;
    String y;
    String z;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: float[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ai(com.amap.api.maps.model.MultiPointOverlayOptions r7, com.amap.api.col.n3.aj r8) {
        /*
            r6 = this;
            r6.<init>()
            com.amap.api.maps.model.BitmapDescriptor r0 = com.amap.api.maps.model.BitmapDescriptorFactory.defaultMarker()
            r6.a = r0
            r0 = 0
            r6.b = r0
            r1 = 0
            r6.c = r1
            r6.d = r1
            r6.e = r1
            r1 = 1056964608(0x3f000000, float:0.5)
            r6.f = r1
            r6.g = r1
            r6.i = r0
            r6.j = r0
            com.amap.api.col.n3.ah r2 = new com.amap.api.col.n3.ah
            r3 = 1
            r4 = 0
            r2.<init>(r4, r3, r4, r3)
            r6.k = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6.l = r2
            r2 = 24
            float[] r2 = new float[r2]
            r2 = {-1090519040, -1090519040, 0, 0, 0, 0, -1090519040, 1056964608, 0, 0, 0, 1065353216, 1056964608, 1056964608, 0, 0, 1065353216, 1065353216, 1056964608, -1090519040, 0, 0, 1065353216, 0} // fill-array
            r6.C = r2
            r6.D = r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6.o = r2
            r6.F = r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6.G = r2
            r2 = 3
            r6.H = r2
            int r2 = com.amap.api.col.n3.ag.a
            int r5 = r6.H
            int r2 = r2 * r5
            float[] r2 = new float[r2]
            r6.I = r2
            r2 = 16
            float[] r2 = new float[r2]
            r6.p = r2
            r2 = 4
            float[] r5 = new float[r2]
            r6.q = r5
            float[] r2 = new float[r2]
            r6.r = r2
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r6.s = r2
            r6.t = r0
            r6.u = r0
            r6.v = r4
            r6.w = r4
            r2 = 12
            float[] r5 = new float[r2]
            r6.x = r5
            java.lang.String r5 = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}"
            r6.y = r5
            java.lang.String r5 = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(0,0,1,1.0);\n}"
            r6.z = r5
            r5 = -1
            r6.A = r5
            r6.n = r8
            if (r7 == 0) goto L_0x00a3
            com.amap.api.maps.model.BitmapDescriptor r5 = r7.getIcon()
            if (r5 == 0) goto L_0x0094
            com.amap.api.maps.model.BitmapDescriptor r5 = r7.getIcon()
        L_0x0091:
            r6.b = r5
            goto L_0x0097
        L_0x0094:
            com.amap.api.maps.model.BitmapDescriptor r5 = r6.a
            goto L_0x0091
        L_0x0097:
            float r5 = r7.getAnchorU()
            r6.f = r5
            float r7 = r7.getAnchorV()
            r6.g = r7
        L_0x00a3:
            float[] r7 = r6.C
            if (r7 != 0) goto L_0x00a8
            goto L_0x00e7
        L_0x00a8:
            float[] r7 = r6.C
            java.lang.Object r7 = r7.clone()
            r0 = r7
            float[] r0 = (float[]) r0
            float r7 = r6.f
            float r7 = r7 - r1
            float r5 = r6.g
            float r5 = r5 - r1
            r1 = r0[r4]
            float r1 = r1 + r7
            r0[r4] = r1
            r1 = r0[r3]
            float r1 = r1 - r5
            r0[r3] = r1
            r1 = 6
            r3 = r0[r1]
            float r3 = r3 + r7
            r0[r1] = r3
            r1 = 7
            r3 = r0[r1]
            float r3 = r3 - r5
            r0[r1] = r3
            r1 = r0[r2]
            float r1 = r1 + r7
            r0[r2] = r1
            r1 = 13
            r2 = r0[r1]
            float r2 = r2 - r5
            r0[r1] = r2
            r1 = 18
            r2 = r0[r1]
            float r2 = r2 + r7
            r0[r1] = r2
            r7 = 19
            r1 = r0[r7]
            float r1 = r1 - r5
            r0[r7] = r1
        L_0x00e7:
            com.amap.api.col.n3.ag r7 = new com.amap.api.col.n3.ag
            r7.<init>(r0)
            com.amap.api.col.n3.cw r8 = r8.a()
            r7.a((com.amap.api.col.n3.cw) r8)
            com.amap.api.maps.model.BitmapDescriptor r8 = r6.b
            r7.a((com.amap.api.maps.model.BitmapDescriptor) r8)
            java.util.List<com.amap.api.col.n3.ag> r8 = r6.o
            r8.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ai.<init>(com.amap.api.maps.model.MultiPointOverlayOptions, com.amap.api.col.n3.aj):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009a, code lost:
        com.amap.api.col.n3.iu.b(r9, "MultiPointOverlayDelegate", "addItems");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addItems(java.util.List<com.amap.api.maps.model.MultiPointItem> r9) {
        /*
            r8 = this;
            monitor-enter(r8)     // Catch:{ Throwable -> 0x0099 }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r0 = r8.h     // Catch:{ all -> 0x0096 }
            if (r0 != 0) goto L_0x000c
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0096 }
            r0.<init>()     // Catch:{ all -> 0x0096 }
            r8.h = r0     // Catch:{ all -> 0x0096 }
        L_0x000c:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r0 = r8.h     // Catch:{ all -> 0x0096 }
            r0.clear()     // Catch:{ all -> 0x0096 }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r0 = r8.h     // Catch:{ all -> 0x0096 }
            r0.addAll(r9)     // Catch:{ all -> 0x0096 }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r9 = r8.h     // Catch:{ all -> 0x0096 }
            int r9 = r9.size()     // Catch:{ all -> 0x0096 }
            r0 = 0
            r1 = r0
        L_0x001e:
            if (r1 >= r9) goto L_0x0056
            java.util.List<com.amap.api.maps.model.MultiPointItem> r2 = r8.h     // Catch:{ all -> 0x0096 }
            if (r2 != 0) goto L_0x0026
            monitor-exit(r8)     // Catch:{ all -> 0x0096 }
            return
        L_0x0026:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r2 = r8.h     // Catch:{ all -> 0x0096 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0096 }
            com.amap.api.maps.model.MultiPointItem r2 = (com.amap.api.maps.model.MultiPointItem) r2     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x0053
            com.amap.api.maps.model.LatLng r3 = r2.getLatLng()     // Catch:{ all -> 0x0096 }
            if (r3 == 0) goto L_0x0053
            com.autonavi.amap.mapcore.IPoint r3 = r2.getIPoint()     // Catch:{ all -> 0x0096 }
            if (r3 != 0) goto L_0x0053
            com.autonavi.amap.mapcore.IPoint r3 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ all -> 0x0096 }
            r3.<init>()     // Catch:{ all -> 0x0096 }
            com.amap.api.maps.model.LatLng r4 = r2.getLatLng()     // Catch:{ all -> 0x0096 }
            double r4 = r4.longitude     // Catch:{ all -> 0x0096 }
            com.amap.api.maps.model.LatLng r6 = r2.getLatLng()     // Catch:{ all -> 0x0096 }
            double r6 = r6.latitude     // Catch:{ all -> 0x0096 }
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r4, r6, r3)     // Catch:{ all -> 0x0096 }
            r2.setIPoint(r3)     // Catch:{ all -> 0x0096 }
        L_0x0053:
            int r1 = r1 + 1
            goto L_0x001e
        L_0x0056:
            com.amap.api.col.n3.ak r9 = r8.i     // Catch:{ all -> 0x0096 }
            if (r9 != 0) goto L_0x0067
            com.amap.api.col.n3.ah r9 = r8.a()     // Catch:{ all -> 0x0096 }
            if (r9 == 0) goto L_0x0067
            com.amap.api.col.n3.ak r1 = new com.amap.api.col.n3.ak     // Catch:{ all -> 0x0096 }
            r1.<init>(r9)     // Catch:{ all -> 0x0096 }
            r8.i = r1     // Catch:{ all -> 0x0096 }
        L_0x0067:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r9 = r8.h     // Catch:{ all -> 0x0096 }
            int r9 = r9.size()     // Catch:{ all -> 0x0096 }
        L_0x006d:
            if (r0 >= r9) goto L_0x0091
            java.util.List<com.amap.api.maps.model.MultiPointItem> r1 = r8.h     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0075
            monitor-exit(r8)     // Catch:{ all -> 0x0096 }
            return
        L_0x0075:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r1 = r8.h     // Catch:{ all -> 0x0096 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0096 }
            com.amap.api.maps.model.MultiPointItem r1 = (com.amap.api.maps.model.MultiPointItem) r1     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x008e
            com.autonavi.amap.mapcore.IPoint r2 = r1.getIPoint()     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x008e
            com.amap.api.col.n3.ak r2 = r8.i     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x008e
            com.amap.api.col.n3.ak r2 = r8.i     // Catch:{ all -> 0x0096 }
            r2.a(r1)     // Catch:{ all -> 0x0096 }
        L_0x008e:
            int r0 = r0 + 1
            goto L_0x006d
        L_0x0091:
            monitor-exit(r8)     // Catch:{ all -> 0x0096 }
            r8.b()     // Catch:{ Throwable -> 0x0099 }
            return
        L_0x0096:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ Throwable -> 0x0099 }
            throw r9     // Catch:{ Throwable -> 0x0099 }
        L_0x0099:
            r9 = move-exception
            java.lang.String r0 = "MultiPointOverlayDelegate"
            java.lang.String r1 = "addItems"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r9, (java.lang.String) r0, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ai.addItems(java.util.List):void");
    }

    public final void addItem(MultiPointItem multiPointItem) {
        synchronized (this) {
        }
        b();
    }

    private ah a() {
        if (this.h == null || this.h.size() == 0) {
            return null;
        }
        Iterator<MultiPointItem> it = this.h.iterator();
        MultiPointItem next = it.next();
        int i2 = next.getIPoint().x;
        int i3 = next.getIPoint().x;
        int i4 = next.getIPoint().y;
        int i5 = next.getIPoint().y;
        while (it.hasNext()) {
            MultiPointItem next2 = it.next();
            int i6 = next2.getIPoint().x;
            int i7 = next2.getIPoint().y;
            if (i6 < i2) {
                i2 = i6;
            }
            if (i6 > i3) {
                i3 = i6;
            }
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i5) {
                i5 = i7;
            }
        }
        return new ah(i2, i3, i4, i5);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0281 A[Catch:{ all -> 0x0335, all -> 0x00b4, Throwable -> 0x033b }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02aa A[SYNTHETIC, Splitter:B:55:0x02aa] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0322 A[SYNTHETIC, Splitter:B:72:0x0322] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(com.autonavi.amap.mapcore.MapConfig r35, float[] r36, float[] r37) {
        /*
            r34 = this;
            r1 = r34
            boolean r3 = r1.D     // Catch:{ Throwable -> 0x033b }
            if (r3 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.concurrent.ExecutorService r3 = r1.F     // Catch:{ Throwable -> 0x033b }
            if (r3 != 0) goto L_0x0011
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor()     // Catch:{ Throwable -> 0x033b }
            r1.F = r3     // Catch:{ Throwable -> 0x033b }
        L_0x0011:
            java.util.List<com.amap.api.col.n3.ag> r3 = r1.o     // Catch:{ Throwable -> 0x033b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Throwable -> 0x033b }
        L_0x0017:
            boolean r4 = r3.hasNext()     // Catch:{ Throwable -> 0x033b }
            if (r4 == 0) goto L_0x0053
            java.lang.Object r4 = r3.next()     // Catch:{ Throwable -> 0x033b }
            com.amap.api.col.n3.ag r4 = (com.amap.api.col.n3.ag) r4     // Catch:{ Throwable -> 0x033b }
            if (r4 == 0) goto L_0x0017
            boolean r5 = r4.b()     // Catch:{ Throwable -> 0x033b }
            if (r5 != 0) goto L_0x0017
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x033b }
            r5.<init>()     // Catch:{ Throwable -> 0x033b }
            int r6 = r4.hashCode()     // Catch:{ Throwable -> 0x033b }
            r5.append(r6)     // Catch:{ Throwable -> 0x033b }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x033b }
            java.util.List<java.lang.String> r6 = r1.G     // Catch:{ Throwable -> 0x033b }
            boolean r6 = r6.contains(r5)     // Catch:{ Throwable -> 0x033b }
            if (r6 != 0) goto L_0x0017
            java.util.List<java.lang.String> r6 = r1.G     // Catch:{ Throwable -> 0x033b }
            r6.add(r5)     // Catch:{ Throwable -> 0x033b }
            java.util.concurrent.ExecutorService r6 = r1.F     // Catch:{ Throwable -> 0x033b }
            com.amap.api.col.n3.ai$1 r7 = new com.amap.api.col.n3.ai$1     // Catch:{ Throwable -> 0x033b }
            r7.<init>(r4, r5)     // Catch:{ Throwable -> 0x033b }
            r6.execute(r7)     // Catch:{ Throwable -> 0x033b }
            goto L_0x0017
        L_0x0053:
            java.util.List<com.amap.api.col.n3.ag> r3 = r1.o     // Catch:{ Throwable -> 0x033b }
            int r3 = r3.size()     // Catch:{ Throwable -> 0x033b }
            if (r3 > 0) goto L_0x005c
            return
        L_0x005c:
            com.amap.api.col.n3.ak r3 = r1.i     // Catch:{ Throwable -> 0x033b }
            if (r3 != 0) goto L_0x0061
            return
        L_0x0061:
            float r3 = r35.getS_r()     // Catch:{ Throwable -> 0x033b }
            float r13 = r35.getS_c()     // Catch:{ Throwable -> 0x033b }
            double r4 = r35.getChangeRatio()     // Catch:{ Throwable -> 0x033b }
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r15 = 0
            r12 = 1
            r11 = 0
            if (r4 != 0) goto L_0x0085
            java.util.List<com.amap.api.maps.model.MultiPointItem> r4 = r1.l     // Catch:{ Throwable -> 0x033b }
            int r4 = r4.size()     // Catch:{ Throwable -> 0x033b }
            if (r4 != 0) goto L_0x007f
            goto L_0x0085
        L_0x007f:
            r31 = r3
            r30 = r13
            goto L_0x027d
        L_0x0085:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r4 = r1.l     // Catch:{ Throwable -> 0x033b }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x033b }
            if (r35 == 0) goto L_0x00b8
            com.autonavi.amap.mapcore.Rectangle r5 = r35.getGeoRectangle()     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r5 = r5.getRect()     // Catch:{ all -> 0x00b4 }
            com.amap.api.col.n3.ah r6 = r1.j     // Catch:{ all -> 0x00b4 }
            if (r6 != 0) goto L_0x00a6
            com.amap.api.col.n3.ah r6 = new com.amap.api.col.n3.ah     // Catch:{ all -> 0x00b4 }
            int r7 = r5.left     // Catch:{ all -> 0x00b4 }
            int r8 = r5.right     // Catch:{ all -> 0x00b4 }
            int r9 = r5.top     // Catch:{ all -> 0x00b4 }
            int r5 = r5.bottom     // Catch:{ all -> 0x00b4 }
            r6.<init>(r7, r8, r9, r5)     // Catch:{ all -> 0x00b4 }
            r1.j = r6     // Catch:{ all -> 0x00b4 }
            goto L_0x00b8
        L_0x00a6:
            com.amap.api.col.n3.ah r6 = r1.j     // Catch:{ all -> 0x00b4 }
            int r7 = r5.left     // Catch:{ all -> 0x00b4 }
            int r8 = r5.right     // Catch:{ all -> 0x00b4 }
            int r9 = r5.top     // Catch:{ all -> 0x00b4 }
            int r5 = r5.bottom     // Catch:{ all -> 0x00b4 }
            r6.a(r7, r8, r9, r5)     // Catch:{ all -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r0 = move-exception
            r2 = r0
            goto L_0x0339
        L_0x00b8:
            java.util.List<com.amap.api.maps.model.MultiPointItem> r5 = r1.l     // Catch:{ all -> 0x00b4 }
            r5.clear()     // Catch:{ all -> 0x00b4 }
            float r5 = r35.getMapPerPixelUnitLength()     // Catch:{ all -> 0x00b4 }
            r1.c = r5     // Catch:{ all -> 0x00b4 }
            float r5 = r1.c     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.BitmapDescriptor r6 = r1.b     // Catch:{ all -> 0x00b4 }
            int r6 = r6.getWidth()     // Catch:{ all -> 0x00b4 }
            float r6 = (float) r6     // Catch:{ all -> 0x00b4 }
            float r5 = r5 * r6
            r1.d = r5     // Catch:{ all -> 0x00b4 }
            float r5 = r1.c     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.BitmapDescriptor r6 = r1.b     // Catch:{ all -> 0x00b4 }
            int r6 = r6.getHeight()     // Catch:{ all -> 0x00b4 }
            float r6 = (float) r6     // Catch:{ all -> 0x00b4 }
            float r5 = r5 * r6
            r1.e = r5     // Catch:{ all -> 0x00b4 }
            float r5 = r1.d     // Catch:{ all -> 0x00b4 }
            float r6 = r1.e     // Catch:{ all -> 0x00b4 }
            float r5 = r5 * r6
            r6 = 1098907648(0x41800000, float:16.0)
            float r5 = r5 * r6
            double r5 = (double) r5     // Catch:{ all -> 0x00b4 }
            float r7 = r1.d     // Catch:{ all -> 0x00b4 }
            float r8 = r1.e     // Catch:{ all -> 0x00b4 }
            com.amap.api.col.n3.ah r9 = r1.k     // Catch:{ all -> 0x00b4 }
            if (r9 != 0) goto L_0x00f3
            com.amap.api.col.n3.ah r9 = new com.amap.api.col.n3.ah     // Catch:{ all -> 0x00b4 }
            r9.<init>(r11, r12, r11, r12)     // Catch:{ all -> 0x00b4 }
            r1.k = r9     // Catch:{ all -> 0x00b4 }
        L_0x00f3:
            android.graphics.Rect r9 = r1.s     // Catch:{ all -> 0x00b4 }
            r9.set(r11, r11, r11, r11)     // Catch:{ all -> 0x00b4 }
            com.autonavi.amap.mapcore.IPoint r9 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ all -> 0x00b4 }
            r9.<init>()     // Catch:{ all -> 0x00b4 }
            float r10 = r1.f     // Catch:{ all -> 0x00b4 }
            float r14 = r1.g     // Catch:{ all -> 0x00b4 }
            float[] r12 = r1.p     // Catch:{ all -> 0x00b4 }
            android.opengl.Matrix.setIdentityM(r12, r11)     // Catch:{ all -> 0x00b4 }
            float[] r12 = r1.p     // Catch:{ all -> 0x00b4 }
            r19 = 0
            float r11 = -r3
            r21 = 0
            r22 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r18 = r12
            r20 = r11
            android.opengl.Matrix.rotateM(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.r     // Catch:{ all -> 0x00b4 }
            r12 = 0
            r11[r12] = r15     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.r     // Catch:{ all -> 0x00b4 }
            r12 = 1
            r11[r12] = r15     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.r     // Catch:{ all -> 0x00b4 }
            r12 = 2
            r11[r12] = r15     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.r     // Catch:{ all -> 0x00b4 }
            r12 = 3
            r11[r12] = r15     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.q     // Catch:{ all -> 0x00b4 }
            float r12 = -r7
            float r12 = r12 * r10
            r18 = 0
            r11[r18] = r12     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.q     // Catch:{ all -> 0x00b4 }
            float r18 = r8 * r14
            r17 = 1
            r11[r17] = r18     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.q     // Catch:{ all -> 0x00b4 }
            r16 = 2
            r11[r16] = r15     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.q     // Catch:{ all -> 0x00b4 }
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 3
            r11[r20] = r19     // Catch:{ all -> 0x00b4 }
            float[] r11 = r1.r     // Catch:{ all -> 0x00b4 }
            r25 = 0
            float[] r15 = r1.p     // Catch:{ all -> 0x00b4 }
            r27 = 0
            r30 = r13
            float[] r13 = r1.q     // Catch:{ all -> 0x00b4 }
            r29 = 0
            r24 = r11
            r26 = r15
            r28 = r13
            android.opengl.Matrix.multiplyMV(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r11 = r1.s     // Catch:{ all -> 0x00b4 }
            int r13 = r9.x     // Catch:{ all -> 0x00b4 }
            float r13 = (float) r13     // Catch:{ all -> 0x00b4 }
            float[] r15 = r1.r     // Catch:{ all -> 0x00b4 }
            r20 = 0
            r15 = r15[r20]     // Catch:{ all -> 0x00b4 }
            float r13 = r13 + r15
            int r13 = (int) r13     // Catch:{ all -> 0x00b4 }
            int r15 = r9.y     // Catch:{ all -> 0x00b4 }
            float r15 = (float) r15     // Catch:{ all -> 0x00b4 }
            r31 = r3
            float[] r3 = r1.r     // Catch:{ all -> 0x00b4 }
            r17 = 1
            r3 = r3[r17]     // Catch:{ all -> 0x00b4 }
            float r15 = r15 - r3
            int r3 = (int) r15     // Catch:{ all -> 0x00b4 }
            int r15 = r9.x     // Catch:{ all -> 0x00b4 }
            float r15 = (float) r15     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.r     // Catch:{ all -> 0x00b4 }
            r20 = 0
            r2 = r2[r20]     // Catch:{ all -> 0x00b4 }
            float r15 = r15 + r2
            int r2 = (int) r15     // Catch:{ all -> 0x00b4 }
            int r15 = r9.y     // Catch:{ all -> 0x00b4 }
            float r15 = (float) r15     // Catch:{ all -> 0x00b4 }
            r32 = r5
            float[] r5 = r1.r     // Catch:{ all -> 0x00b4 }
            r6 = 1
            r5 = r5[r6]     // Catch:{ all -> 0x00b4 }
            float r15 = r15 - r5
            int r5 = (int) r15     // Catch:{ all -> 0x00b4 }
            r11.set(r13, r3, r2, r5)     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            float r3 = r19 - r10
            float r7 = r7 * r3
            r3 = 0
            r2[r3] = r7     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 1
            r2[r3] = r18     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 0
            r5 = 2
            r2[r5] = r3     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 3
            r2[r3] = r19     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.r     // Catch:{ all -> 0x00b4 }
            r25 = 0
            float[] r3 = r1.p     // Catch:{ all -> 0x00b4 }
            r27 = 0
            float[] r5 = r1.q     // Catch:{ all -> 0x00b4 }
            r29 = 0
            r24 = r2
            r26 = r3
            r28 = r5
            android.opengl.Matrix.multiplyMV(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r2 = r1.s     // Catch:{ all -> 0x00b4 }
            int r3 = r9.x     // Catch:{ all -> 0x00b4 }
            float r3 = (float) r3     // Catch:{ all -> 0x00b4 }
            float[] r5 = r1.r     // Catch:{ all -> 0x00b4 }
            r6 = 0
            r5 = r5[r6]     // Catch:{ all -> 0x00b4 }
            float r3 = r3 + r5
            int r3 = (int) r3     // Catch:{ all -> 0x00b4 }
            int r5 = r9.y     // Catch:{ all -> 0x00b4 }
            float r5 = (float) r5     // Catch:{ all -> 0x00b4 }
            float[] r6 = r1.r     // Catch:{ all -> 0x00b4 }
            r10 = 1
            r6 = r6[r10]     // Catch:{ all -> 0x00b4 }
            float r5 = r5 - r6
            int r5 = (int) r5     // Catch:{ all -> 0x00b4 }
            r2.union(r3, r5)     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 0
            r2[r3] = r7     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            float r3 = -r8
            float r5 = r19 - r14
            float r3 = r3 * r5
            r5 = 1
            r2[r5] = r3     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r5 = 0
            r6 = 2
            r2[r6] = r5     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r5 = 3
            r2[r5] = r19     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.r     // Catch:{ all -> 0x00b4 }
            r25 = 0
            float[] r5 = r1.p     // Catch:{ all -> 0x00b4 }
            r27 = 0
            float[] r6 = r1.q     // Catch:{ all -> 0x00b4 }
            r29 = 0
            r24 = r2
            r26 = r5
            r28 = r6
            android.opengl.Matrix.multiplyMV(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r2 = r1.s     // Catch:{ all -> 0x00b4 }
            int r5 = r9.x     // Catch:{ all -> 0x00b4 }
            float r5 = (float) r5     // Catch:{ all -> 0x00b4 }
            float[] r6 = r1.r     // Catch:{ all -> 0x00b4 }
            r7 = 0
            r6 = r6[r7]     // Catch:{ all -> 0x00b4 }
            float r5 = r5 + r6
            int r5 = (int) r5     // Catch:{ all -> 0x00b4 }
            int r6 = r9.y     // Catch:{ all -> 0x00b4 }
            float r6 = (float) r6     // Catch:{ all -> 0x00b4 }
            float[] r7 = r1.r     // Catch:{ all -> 0x00b4 }
            r8 = 1
            r7 = r7[r8]     // Catch:{ all -> 0x00b4 }
            float r6 = r6 - r7
            int r6 = (int) r6     // Catch:{ all -> 0x00b4 }
            r2.union(r5, r6)     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r5 = 0
            r2[r5] = r12     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r5 = 1
            r2[r5] = r3     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 0
            r5 = 2
            r2[r5] = r3     // Catch:{ all -> 0x00b4 }
            float[] r2 = r1.q     // Catch:{ all -> 0x00b4 }
            r3 = 3
            r2[r3] = r19     // Catch:{ all -> 0x00b4 }
            float[] r10 = r1.r     // Catch:{ all -> 0x00b4 }
            r11 = 0
            float[] r12 = r1.p     // Catch:{ all -> 0x00b4 }
            r13 = 0
            float[] r14 = r1.q     // Catch:{ all -> 0x00b4 }
            r15 = 0
            android.opengl.Matrix.multiplyMV(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r2 = r1.s     // Catch:{ all -> 0x00b4 }
            int r3 = r9.x     // Catch:{ all -> 0x00b4 }
            float r3 = (float) r3     // Catch:{ all -> 0x00b4 }
            float[] r5 = r1.r     // Catch:{ all -> 0x00b4 }
            r6 = 0
            r5 = r5[r6]     // Catch:{ all -> 0x00b4 }
            float r3 = r3 + r5
            int r3 = (int) r3     // Catch:{ all -> 0x00b4 }
            int r5 = r9.y     // Catch:{ all -> 0x00b4 }
            float r5 = (float) r5     // Catch:{ all -> 0x00b4 }
            float[] r6 = r1.r     // Catch:{ all -> 0x00b4 }
            r7 = 1
            r6 = r6[r7]     // Catch:{ all -> 0x00b4 }
            float r5 = r5 - r6
            int r5 = (int) r5     // Catch:{ all -> 0x00b4 }
            r2.union(r3, r5)     // Catch:{ all -> 0x00b4 }
            com.amap.api.col.n3.ah r2 = r1.k     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r3 = r1.s     // Catch:{ all -> 0x00b4 }
            int r3 = r3.left     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r5 = r1.s     // Catch:{ all -> 0x00b4 }
            int r5 = r5.right     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r6 = r1.s     // Catch:{ all -> 0x00b4 }
            int r6 = r6.top     // Catch:{ all -> 0x00b4 }
            android.graphics.Rect r7 = r1.s     // Catch:{ all -> 0x00b4 }
            int r7 = r7.bottom     // Catch:{ all -> 0x00b4 }
            r2.a(r3, r5, r6, r7)     // Catch:{ all -> 0x00b4 }
            com.amap.api.col.n3.ak r2 = r1.i     // Catch:{ all -> 0x00b4 }
            com.amap.api.col.n3.ah r3 = r1.j     // Catch:{ all -> 0x00b4 }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r5 = r1.l     // Catch:{ all -> 0x00b4 }
            r6 = r32
            r2.a(r3, r5, r6)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
        L_0x027d:
            com.autonavi.amap.mapcore.IPoint r2 = r1.m     // Catch:{ Throwable -> 0x033b }
            if (r2 != 0) goto L_0x0288
            com.autonavi.amap.mapcore.IPoint r2 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Throwable -> 0x033b }
            r2.<init>()     // Catch:{ Throwable -> 0x033b }
            r1.m = r2     // Catch:{ Throwable -> 0x033b }
        L_0x0288:
            com.autonavi.amap.mapcore.IPoint r2 = r1.m     // Catch:{ Throwable -> 0x033b }
            if (r2 == 0) goto L_0x029e
            if (r35 == 0) goto L_0x029e
            com.autonavi.amap.mapcore.IPoint r3 = r1.m     // Catch:{ Throwable -> 0x033b }
            int r4 = r35.getS_x()     // Catch:{ Throwable -> 0x033b }
            r3.x = r4     // Catch:{ Throwable -> 0x033b }
            com.autonavi.amap.mapcore.IPoint r3 = r1.m     // Catch:{ Throwable -> 0x033b }
            int r2 = r35.getS_y()     // Catch:{ Throwable -> 0x033b }
            r3.y = r2     // Catch:{ Throwable -> 0x033b }
        L_0x029e:
            java.util.List<com.amap.api.col.n3.ag> r2 = r1.o     // Catch:{ Throwable -> 0x033b }
            r3 = 0
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Throwable -> 0x033b }
            com.amap.api.col.n3.ag r2 = (com.amap.api.col.n3.ag) r2     // Catch:{ Throwable -> 0x033b }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r3 = r1.l     // Catch:{ Throwable -> 0x033b }
            monitor-enter(r3)     // Catch:{ Throwable -> 0x033b }
            java.util.List<com.amap.api.maps.model.MultiPointItem> r4 = r1.l     // Catch:{ all -> 0x0335 }
            java.util.Iterator r13 = r4.iterator()     // Catch:{ all -> 0x0335 }
            r12 = 0
        L_0x02b1:
            boolean r4 = r13.hasNext()     // Catch:{ all -> 0x0335 }
            if (r4 == 0) goto L_0x031f
            java.lang.Object r4 = r13.next()     // Catch:{ all -> 0x0335 }
            com.amap.api.maps.model.MultiPointItem r4 = (com.amap.api.maps.model.MultiPointItem) r4     // Catch:{ all -> 0x0335 }
            com.autonavi.amap.mapcore.IPoint r4 = r4.getIPoint()     // Catch:{ all -> 0x0335 }
            if (r4 == 0) goto L_0x02b1
            int r5 = r4.x     // Catch:{ all -> 0x0335 }
            com.autonavi.amap.mapcore.IPoint r6 = r1.m     // Catch:{ all -> 0x0335 }
            int r6 = r6.x     // Catch:{ all -> 0x0335 }
            int r5 = r5 - r6
            int r4 = r4.y     // Catch:{ all -> 0x0335 }
            com.autonavi.amap.mapcore.IPoint r6 = r1.m     // Catch:{ all -> 0x0335 }
            int r6 = r6.y     // Catch:{ all -> 0x0335 }
            int r4 = r4 - r6
            if (r2 == 0) goto L_0x0318
            boolean r6 = r2.b()     // Catch:{ all -> 0x0335 }
            if (r6 == 0) goto L_0x0318
            float[] r6 = r1.I     // Catch:{ all -> 0x0335 }
            int r7 = r1.H     // Catch:{ all -> 0x0335 }
            int r7 = r7 * r12
            r11 = 0
            int r7 = r7 + r11
            float r5 = (float) r5     // Catch:{ all -> 0x0335 }
            r6[r7] = r5     // Catch:{ all -> 0x0335 }
            float[] r5 = r1.I     // Catch:{ all -> 0x0335 }
            int r6 = r1.H     // Catch:{ all -> 0x0335 }
            int r6 = r6 * r12
            r14 = 1
            int r6 = r6 + r14
            float r4 = (float) r4     // Catch:{ all -> 0x0335 }
            r5[r6] = r4     // Catch:{ all -> 0x0335 }
            float[] r4 = r1.I     // Catch:{ all -> 0x0335 }
            int r5 = r1.H     // Catch:{ all -> 0x0335 }
            int r5 = r5 * r12
            r15 = 2
            int r5 = r5 + r15
            r16 = 0
            r4[r5] = r16     // Catch:{ all -> 0x0335 }
            int r12 = r12 + 1
            int r4 = com.amap.api.col.n3.ag.a     // Catch:{ all -> 0x0335 }
            if (r12 < r4) goto L_0x0315
            float[] r7 = r1.I     // Catch:{ all -> 0x0335 }
            float r8 = r1.d     // Catch:{ all -> 0x0335 }
            float r9 = r1.e     // Catch:{ all -> 0x0335 }
            r4 = r2
            r5 = r36
            r6 = r37
            r10 = r31
            r17 = r11
            r11 = r30
            r4.a(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0335 }
            r12 = r17
            goto L_0x02b1
        L_0x0315:
            r17 = r11
            goto L_0x02b1
        L_0x0318:
            r14 = 1
            r15 = 2
            r16 = 0
            r17 = 0
            goto L_0x02b1
        L_0x031f:
            monitor-exit(r3)     // Catch:{ all -> 0x0335 }
            if (r12 <= 0) goto L_0x0334
            float[] r7 = r1.I     // Catch:{ Throwable -> 0x033b }
            float r8 = r1.d     // Catch:{ Throwable -> 0x033b }
            float r9 = r1.e     // Catch:{ Throwable -> 0x033b }
            r4 = r2
            r5 = r36
            r6 = r37
            r10 = r31
            r11 = r30
            r4.a(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x033b }
        L_0x0334:
            return
        L_0x0335:
            r0 = move-exception
            r2 = r0
            monitor-exit(r3)     // Catch:{ Throwable -> 0x033b }
            throw r2     // Catch:{ Throwable -> 0x033b }
        L_0x0339:
            monitor-exit(r4)     // Catch:{ Throwable -> 0x033b }
            throw r2     // Catch:{ Throwable -> 0x033b }
        L_0x033b:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "MultiPointOverlayDelegate"
            java.lang.String r4 = "draw"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ai.draw(com.autonavi.amap.mapcore.MapConfig, float[], float[]):void");
    }

    public final MultiPointItem onClick(IPoint iPoint) {
        if (!this.D || this.i == null) {
            return null;
        }
        if (this.t == null) {
            this.t = new ah(0, 1, 0, 1);
        }
        int i2 = (int) (this.c * 8.0f);
        this.t.a(iPoint.x - i2, iPoint.x + i2, iPoint.y - i2, iPoint.y + i2);
        if (this.i != null && this.i.b() != null && !this.i.b().a(this.t)) {
            return null;
        }
        synchronized (this.l) {
            for (int size = this.l.size() - 1; size >= 0; size--) {
                MultiPointItem multiPointItem = this.l.get(size);
                IPoint iPoint2 = multiPointItem.getIPoint();
                if (iPoint2 != null) {
                    if (this.k == null) {
                        return null;
                    }
                    if (this.u == null) {
                        this.u = new ah(0, 1, 0, 1);
                    }
                    this.u.a(iPoint2.x + this.k.a, iPoint2.x + this.k.c, iPoint2.y + this.k.b, iPoint2.y + this.k.d);
                    ah ahVar = this.u;
                    ah ahVar2 = this.t;
                    if (ahVar2 != null && ahVar2.a >= ahVar.a && ahVar2.c <= ahVar.c && ahVar2.b >= ahVar.b && ahVar2.d <= ahVar.d) {
                        return multiPointItem;
                    }
                }
            }
            return null;
        }
    }

    public final void setAnchor(float f2, float f3) {
        this.f = f2;
        this.g = f3;
        b();
    }

    public final String getId() throws RemoteException {
        if (this.B == null) {
            E++;
            this.B = "MultiPointOverlay" + E;
        }
        return this.B;
    }

    public final void remove(boolean z2) {
        this.D = false;
        this.v = 0;
        this.w = 0;
        if (this.a != null) {
            this.a.recycle();
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.l != null) {
            this.l.clear();
        }
        if (this.F != null) {
            this.F.shutdownNow();
            this.F = null;
        }
        if (this.G != null) {
            this.G.clear();
        }
        if (this.o != null) {
            for (ag next : this.o) {
                if (next != null) {
                    next.c();
                }
            }
            this.o.clear();
        }
        if (z2 && this.n != null) {
            this.n.a(this);
        }
        this.n.d();
        this.n = null;
        this.C = null;
    }

    public final void setVisible(boolean z2) {
        if (this.D != z2) {
            b();
        }
        this.D = z2;
    }

    private void b() {
        if (this.n != null) {
            this.n.d();
        }
    }

    public final void destroy(boolean z2) {
        remove(z2);
        if (this.b != null) {
            this.b.recycle();
        }
    }
}
