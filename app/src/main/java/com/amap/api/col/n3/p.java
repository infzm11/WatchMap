package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.col.n3.cw;
import com.amap.api.col.n3.ea;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: MapOverlayImageView */
public final class p {
    k a;
    float[] b = new float[180000];
    public cw.c c;
    int d = 0;
    int e = 0;
    /* access modifiers changed from: private */
    public List<ci> f = new ArrayList(500);
    private List<r> g = new ArrayList();
    private List<ci> h = new ArrayList();
    private a i = new a();
    private boolean j = true;
    private IPoint k;
    private cf l;
    private cf m;
    private ea n;
    private dn o;
    private FloatBuffer p;
    private Handler q = new Handler(Looper.getMainLooper());
    private int[] r = new int[1];
    private Runnable s = new Runnable() {
        public final void run() {
            synchronized (p.this.f) {
                p.b(p.this);
            }
        }
    };

    /* compiled from: MapOverlayImageView */
    static class a implements Serializable, Comparator<Object> {
        a() {
        }

        public final int compare(Object obj, Object obj2) {
            ci ciVar = (ci) obj;
            ci ciVar2 = (ci) obj2;
            if (ciVar == null || ciVar2 == null) {
                return 0;
            }
            try {
                if (ciVar.getZIndex() > ciVar2.getZIndex()) {
                    return 1;
                }
                if (ciVar.getZIndex() < ciVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Throwable th) {
                iu.b(th, "MapOverlayImageView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    static /* synthetic */ void b(p pVar) {
        try {
            Collections.sort(pVar.f, pVar.i);
        } catch (Throwable th) {
            iu.b(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    public p(k kVar) {
        this.a = kVar;
        this.n = new ea();
        this.o = new dn();
    }

    public final Marker a(MarkerOptions markerOptions) throws RemoteException {
        Marker marker;
        if (markerOptions == null) {
            return null;
        }
        cn cnVar = new cn(markerOptions, this);
        synchronized (this.f) {
            d(cnVar);
            marker = new Marker(cnVar);
        }
        return marker;
    }

    public final ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() == 1) {
                MarkerOptions markerOptions = arrayList.get(0);
                if (markerOptions != null) {
                    arrayList2.add(a(markerOptions));
                    if (z && markerOptions.getPosition() != null) {
                        this.a.a(z.a(markerOptions.getPosition(), 18.0f));
                    }
                    return arrayList2;
                }
            }
            final LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MarkerOptions markerOptions2 = arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(a(markerOptions2));
                    if (markerOptions2.getPosition() != null) {
                        builder.include(markerOptions2.getPosition());
                    }
                }
            }
            if (z && arrayList2.size() > 0) {
                this.a.getMainHandler().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            p.this.a.a(z.a(builder.build(), 50));
                        } catch (Throwable unused) {
                        }
                    }
                }, 50);
            }
            return arrayList2;
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public final Text a(TextOptions textOptions) throws RemoteException {
        Text text;
        if (textOptions == null) {
            return null;
        }
        synchronized (this.f) {
            ct ctVar = new ct(textOptions, this);
            d(ctVar);
            text = new Text(ctVar);
        }
        return text;
    }

    private void d(ci ciVar) {
        try {
            this.f.add(ciVar);
            e();
        } catch (Throwable th) {
            iu.b(th, "MapOverlayImageView", "addMarker");
        }
    }

    public final boolean a(ci ciVar) {
        boolean remove;
        synchronized (this.f) {
            try {
                if (this.m != null && this.m.getId().equals(ciVar.getId())) {
                    this.m = null;
                }
                b(ciVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            remove = this.f.remove(ciVar);
        }
        return remove;
    }

    public final void a(cf cfVar) {
        try {
            if (this.m != null) {
                if (cfVar == null || !cfVar.getId().equals(this.m.getId())) {
                    this.m.b(false);
                } else {
                    return;
                }
            }
            if (this.f.contains(cfVar)) {
                cfVar.b(true);
                this.m = cfVar;
            }
        } catch (Throwable th) {
            iu.b(th, "MapOverlayImageView", "set2Top");
        }
    }

    public final void b(cf cfVar) {
        if (this.k == null) {
            this.k = IPoint.obtain();
        }
        Rect h2 = cfVar.h();
        this.k = IPoint.obtain(h2.left + (h2.width() / 2), h2.top);
        this.l = cfVar;
        try {
            this.a.a(this.l);
        } catch (Throwable th) {
            iu.b(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    public final void b(ci ciVar) {
        try {
            if (ciVar.isInfoWindowShown()) {
                this.a.j();
                this.l = null;
            } else if (this.l != null && this.l.getId() == ciVar.getId()) {
                this.l = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0118, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r13 = this;
            com.amap.api.col.n3.k r0 = r13.a     // Catch:{ Throwable -> 0x011f }
            com.autonavi.amap.mapcore.MapConfig r0 = r0.getMapConfig()     // Catch:{ Throwable -> 0x011f }
            float r0 = r0.getMapPerPixelUnitLength()     // Catch:{ Throwable -> 0x011f }
            java.util.List<com.amap.api.col.n3.ci> r1 = r13.f     // Catch:{ Throwable -> 0x011f }
            monitor-enter(r1)     // Catch:{ Throwable -> 0x011f }
            java.util.List<com.amap.api.col.n3.r> r2 = r13.g     // Catch:{ all -> 0x011c }
            monitor-enter(r2)     // Catch:{ all -> 0x011c }
            com.amap.api.col.n3.k r3 = r13.a     // Catch:{ all -> 0x0119 }
            int r3 = r3.f()     // Catch:{ all -> 0x0119 }
            r4 = 0
            r5 = r4
        L_0x0018:
            java.util.List<com.amap.api.col.n3.r> r6 = r13.g     // Catch:{ all -> 0x0119 }
            int r6 = r6.size()     // Catch:{ all -> 0x0119 }
            r7 = 1
            if (r5 >= r6) goto L_0x0054
            java.util.List<com.amap.api.col.n3.r> r6 = r13.g     // Catch:{ all -> 0x0119 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x0119 }
            com.amap.api.col.n3.r r6 = (com.amap.api.col.n3.r) r6     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0051
            r6.h()     // Catch:{ all -> 0x0119 }
            int r8 = r6.i()     // Catch:{ all -> 0x0119 }
            if (r8 != 0) goto L_0x0051
            int r8 = r6.f()     // Catch:{ all -> 0x0119 }
            if (r8 != r3) goto L_0x0044
            com.amap.api.col.n3.ea r7 = r13.n     // Catch:{ all -> 0x0119 }
            java.lang.String r6 = r6.j()     // Catch:{ all -> 0x0119 }
            r7.a(r6)     // Catch:{ all -> 0x0119 }
            goto L_0x0051
        L_0x0044:
            int[] r8 = r13.r     // Catch:{ all -> 0x0119 }
            int r6 = r6.f()     // Catch:{ all -> 0x0119 }
            r8[r4] = r6     // Catch:{ all -> 0x0119 }
            int[] r6 = r13.r     // Catch:{ all -> 0x0119 }
            android.opengl.GLES20.glDeleteTextures(r7, r6, r4)     // Catch:{ all -> 0x0119 }
        L_0x0051:
            int r5 = r5 + 1
            goto L_0x0018
        L_0x0054:
            monitor-exit(r2)     // Catch:{ all -> 0x0119 }
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.f     // Catch:{ all -> 0x011c }
            int r2 = r2.size()     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x005f
            monitor-exit(r1)     // Catch:{ all -> 0x011c }
            return
        L_0x005f:
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.h     // Catch:{ all -> 0x011c }
            r2.clear()     // Catch:{ all -> 0x011c }
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.f     // Catch:{ all -> 0x011c }
            int r2 = r2.size()     // Catch:{ all -> 0x011c }
            r3 = r4
        L_0x006b:
            if (r3 >= r2) goto L_0x00a0
            java.util.List<com.amap.api.col.n3.ci> r5 = r13.f     // Catch:{ all -> 0x011c }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x011c }
            com.amap.api.col.n3.ci r5 = (com.amap.api.col.n3.ci) r5     // Catch:{ all -> 0x011c }
            boolean r6 = r5.isVisible()     // Catch:{ all -> 0x011c }
            if (r6 == 0) goto L_0x009d
            boolean r6 = r5.l()     // Catch:{ all -> 0x011c }
            if (r6 != 0) goto L_0x009d
            boolean r6 = r5.i()     // Catch:{ all -> 0x011c }
            r13.j = r6     // Catch:{ all -> 0x011c }
            boolean r6 = r5.j()     // Catch:{ all -> 0x011c }
            if (r6 != 0) goto L_0x0093
            boolean r6 = r5.isInfoWindowShown()     // Catch:{ all -> 0x011c }
            if (r6 == 0) goto L_0x009d
        L_0x0093:
            java.util.List<com.amap.api.col.n3.ci> r6 = r13.h     // Catch:{ Throwable -> 0x0099 }
            r6.add(r5)     // Catch:{ Throwable -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x011c }
        L_0x009d:
            int r3 = r3 + 1
            goto L_0x006b
        L_0x00a0:
            com.amap.api.col.n3.cf r2 = r13.m     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x00b3
            com.amap.api.col.n3.cf r2 = r13.m     // Catch:{ all -> 0x011c }
            boolean r2 = r2.isVisible()     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x00b3
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.h     // Catch:{ all -> 0x011c }
            com.amap.api.col.n3.cf r3 = r13.m     // Catch:{ all -> 0x011c }
            r2.add(r3)     // Catch:{ all -> 0x011c }
        L_0x00b3:
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.h     // Catch:{ all -> 0x011c }
            int r2 = r2.size()     // Catch:{ all -> 0x011c }
            if (r2 <= 0) goto L_0x0117
            java.util.List<com.amap.api.col.n3.ci> r2 = r13.h     // Catch:{ all -> 0x011c }
            int r2 = r2.size()     // Catch:{ all -> 0x011c }
            r3 = r4
            r5 = r3
            r6 = r5
            r8 = r6
            r9 = r8
        L_0x00c6:
            if (r3 >= r2) goto L_0x0112
            java.util.List<com.amap.api.col.n3.ci> r10 = r13.h     // Catch:{ all -> 0x011c }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ all -> 0x011c }
            com.amap.api.col.n3.ci r10 = (com.amap.api.col.n3.ci) r10     // Catch:{ all -> 0x011c }
            monitor-enter(r10)     // Catch:{ all -> 0x011c }
            com.amap.api.col.n3.k r11 = r13.a     // Catch:{ all -> 0x010f }
            r10.a(r11)     // Catch:{ all -> 0x010f }
            if (r3 != 0) goto L_0x00dd
            int r6 = r10.k()     // Catch:{ all -> 0x010f }
            goto L_0x00ea
        L_0x00dd:
            int r11 = r10.k()     // Catch:{ all -> 0x010f }
            if (r11 == r6) goto L_0x00ea
            r13.a(r6, r5, r8, r9)     // Catch:{ all -> 0x010f }
            r5 = r4
            r8 = r5
            r9 = r8
            r6 = r11
        L_0x00ea:
            com.amap.api.col.n3.k r11 = r13.a     // Catch:{ all -> 0x010f }
            float[] r12 = r13.b     // Catch:{ all -> 0x010f }
            r10.a(r11, r12, r9, r0)     // Catch:{ all -> 0x010f }
            int r11 = r10.k()     // Catch:{ all -> 0x010f }
            if (r11 == r6) goto L_0x00fe
            r13.a(r6, r5, r8, r9)     // Catch:{ all -> 0x010f }
            r5 = r4
            r8 = r9
            r6 = r11
            r9 = r5
        L_0x00fe:
            int r9 = r9 + 36
            int r5 = r5 + r7
            r11 = 5000(0x1388, float:7.006E-42)
            if (r5 != r11) goto L_0x010b
            r13.a(r6, r5, r8, r9)     // Catch:{ all -> 0x010f }
            r5 = r4
            r8 = r5
            r9 = r8
        L_0x010b:
            monitor-exit(r10)     // Catch:{ all -> 0x010f }
            int r3 = r3 + 1
            goto L_0x00c6
        L_0x010f:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x011c }
            throw r0     // Catch:{ all -> 0x011c }
        L_0x0112:
            if (r5 <= 0) goto L_0x0117
            r13.a(r6, r5, r8, r9)     // Catch:{ all -> 0x011c }
        L_0x0117:
            monitor-exit(r1)     // Catch:{ all -> 0x011c }
            return
        L_0x0119:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011c }
            throw r0     // Catch:{ all -> 0x011c }
        L_0x011c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ Throwable -> 0x011f }
            throw r0     // Catch:{ Throwable -> 0x011f }
        L_0x011f:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.p.a():void");
    }

    private void a(int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        if (i7 != 0 && i6 != 0) {
            this.p = this.o.a(i7 * 36);
            this.p.put(this.b, i4, i5);
            this.p.flip();
            int i8 = 5000;
            int i9 = i7 > 5000 ? 5000 : i7;
            int i10 = 6;
            if (this.d == 0) {
                int[] iArr = new int[2];
                GLES20.glGenBuffers(2, iArr, 0);
                this.d = iArr[0];
                this.e = iArr[1];
                ShortBuffer b2 = this.o.b();
                short[] sArr = new short[30000];
                int i11 = 0;
                while (i11 < i8) {
                    int i12 = i10 * i11;
                    int i13 = 4 * i11;
                    short s2 = (short) (i13 + 0);
                    sArr[i12 + 0] = s2;
                    sArr[i12 + 1] = (short) (i13 + 1);
                    short s3 = (short) (i13 + 2);
                    sArr[i12 + 2] = s3;
                    sArr[i12 + 3] = s2;
                    sArr[i12 + 4] = s3;
                    sArr[i12 + 5] = (short) (i13 + 3);
                    i11++;
                    i8 = 5000;
                    i10 = 6;
                }
                b2.put(sArr);
                b2.flip();
                GLES20.glBindBuffer(34963, this.e);
                GLES20.glBufferData(34963, 60000, b2, 35044);
            }
            GLES20.glBindBuffer(34962, this.d);
            GLES20.glBufferData(34962, i9 * 36 * 4, this.p, 35044);
            FloatBuffer floatBuffer = this.p;
            MapConfig mapConfig = this.a.getMapConfig();
            if (!(i6 == 0 || floatBuffer == null || i7 == 0)) {
                if ((this.c == null || this.c.b()) && this.c == null && this.a != null) {
                    this.c = (cw.c) this.a.m(1);
                }
                GLES20.glUseProgram(this.c.d);
                GLES20.glUniform1f(this.c.h, mapConfig.getS_r());
                GLES20.glEnableVertexAttribArray(this.c.b);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.b, 4, 5126, false, 36, 0);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                GLES20.glBindTexture(3553, i6);
                GLES20.glEnableVertexAttribArray(this.c.c);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 36, 16);
                GLES20.glEnableVertexAttribArray(this.c.g);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.g, 3, 5126, false, 36, 24);
                GLES20.glUniformMatrix4fv(this.c.a, 1, false, this.a != null ? this.a.v() : new float[16], 0);
                GLES20.glBindBuffer(34963, this.e);
                GLES20.glDrawElements(4, 6 * i7, 5123, 0);
                GLES20.glBindBuffer(34962, 0);
                GLES20.glBindBuffer(34963, 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glDisableVertexAttribArray(this.c.b);
                GLES20.glDisableVertexAttribArray(this.c.c);
                GLES20.glDisable(3042);
                GLES20.glUseProgram(0);
            }
            this.o.a();
        }
    }

    public final synchronized boolean a(Bitmap bitmap, r rVar) {
        ea.c a2 = this.n.a(bitmap.getWidth(), bitmap.getHeight(), rVar.j());
        if (a2 == null) {
            return false;
        }
        rVar.b(((float) a2.a) / ((float) this.n.a()));
        rVar.a(((float) a2.b) / ((float) this.n.b()));
        rVar.c(((float) (a2.a + a2.c)) / ((float) this.n.a()));
        rVar.d(((float) (a2.b + a2.d)) / ((float) this.n.b()));
        return true;
    }

    public final k b() {
        return this.a;
    }

    public final cf c() {
        return this.l;
    }

    public final cf a(MotionEvent motionEvent) {
        synchronized (this.f) {
            int size = this.f.size() - 1;
            while (size >= 0) {
                ci ciVar = this.f.get(size);
                if (!(ciVar instanceof cn) || !dv.a(ciVar.h(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    size--;
                } else {
                    this.l = (cf) ciVar;
                    cf cfVar = this.l;
                    return cfVar;
                }
            }
            return null;
        }
    }

    public final boolean b(MotionEvent motionEvent) throws RemoteException {
        boolean z;
        synchronized (this.f) {
            z = false;
            int size = this.f.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                ci ciVar = this.f.get(size);
                if ((ciVar instanceof cn) && ciVar.isVisible() && ((cn) ciVar).isClickable()) {
                    Rect h2 = ciVar.h();
                    boolean a2 = dv.a(h2, (int) motionEvent.getX(), (int) motionEvent.getY());
                    if (a2) {
                        this.k = IPoint.obtain(h2.left + (h2.width() / 2), h2.top);
                        this.l = (cf) ciVar;
                        z = a2;
                        break;
                    }
                }
                size--;
            }
        }
        return z;
    }

    public final List<Marker> d() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList();
            try {
                for (ci next : this.f) {
                    if ((next instanceof cn) && next.j()) {
                        arrayList.add(new Marker((IMarker) next));
                    }
                }
            } catch (Throwable th) {
                iu.b(th, "MapOverlayImageView", "getMapScreenMarkers");
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void e() {
        this.q.removeCallbacks(this.s);
        this.q.postDelayed(this.s, 10);
    }

    public final boolean c(ci ciVar) {
        boolean contains;
        synchronized (this.f) {
            contains = this.f.contains(ciVar);
        }
        return contains;
    }

    /* access modifiers changed from: protected */
    public final int f() {
        int size;
        synchronized (this.f) {
            size = this.f.size();
        }
        return size;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0012
            java.lang.String r1 = r7.trim()     // Catch:{ Throwable -> 0x0010 }
            int r1 = r1.length()     // Catch:{ Throwable -> 0x0010 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0012
        L_0x000e:
            r1 = r0
            goto L_0x0013
        L_0x0010:
            r7 = move-exception
            goto L_0x005d
        L_0x0012:
            r1 = 1
        L_0x0013:
            r2 = 0
            r6.l = r2     // Catch:{ Throwable -> 0x0010 }
            r6.k = r2     // Catch:{ Throwable -> 0x0010 }
            r6.m = r2     // Catch:{ Throwable -> 0x0010 }
            java.util.List<com.amap.api.col.n3.ci> r3 = r6.f     // Catch:{ Throwable -> 0x0010 }
            monitor-enter(r3)     // Catch:{ Throwable -> 0x0010 }
            java.util.List<com.amap.api.col.n3.ci> r4 = r6.h     // Catch:{ all -> 0x005a }
            r4.clear()     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x002a
            java.util.List<com.amap.api.col.n3.ci> r7 = r6.f     // Catch:{ all -> 0x005a }
            r7.clear()     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x002a:
            java.util.List<com.amap.api.col.n3.ci> r1 = r6.f     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
        L_0x0030:
            if (r0 >= r1) goto L_0x004c
            java.util.List<com.amap.api.col.n3.ci> r4 = r6.f     // Catch:{ all -> 0x005a }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x005a }
            com.amap.api.col.n3.ci r4 = (com.amap.api.col.n3.ci) r4     // Catch:{ all -> 0x005a }
            java.lang.String r5 = r4.getId()     // Catch:{ all -> 0x005a }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x0046
            r2 = r4
            goto L_0x0049
        L_0x0046:
            r4.remove()     // Catch:{ all -> 0x005a }
        L_0x0049:
            int r0 = r0 + 1
            goto L_0x0030
        L_0x004c:
            java.util.List<com.amap.api.col.n3.ci> r7 = r6.f     // Catch:{ all -> 0x005a }
            r7.clear()     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0058
            java.util.List<com.amap.api.col.n3.ci> r7 = r6.f     // Catch:{ all -> 0x005a }
            r7.add(r2)     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r3)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ Throwable -> 0x0010 }
            throw r7     // Catch:{ Throwable -> 0x0010 }
        L_0x005d:
            java.lang.String r0 = "MapOverlayImageView"
            java.lang.String r1 = "clear"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r7, (java.lang.String) r0, (java.lang.String) r1)
            r7.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.p.a(java.lang.String):void");
    }

    public final void a(r rVar) {
        synchronized (this.g) {
            if (rVar != null) {
                try {
                    this.g.add(rVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g() {
        try {
            for (ci next : this.f) {
                if (next != null) {
                    next.destroy(false);
                }
            }
            a((String) null);
        } catch (Throwable th) {
            iu.b(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            "MapOverlayImageView clear erro" + th.getMessage();
        }
    }
}
