package com.amap.api.col.n3;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiPointOverlayManagerLayer */
public final class aj {
    cw a;
    private List<IMultiPointOverlay> b = new ArrayList();
    private AMap.OnMultiPointClickListener c;
    private k d;

    public aj(k kVar) {
        this.d = kVar;
    }

    public final cw a() {
        this.a = this.d.w();
        return this.a;
    }

    public final synchronized void b() {
        this.c = null;
        try {
            synchronized (this.b) {
                for (IMultiPointOverlay destroy : this.b) {
                    destroy.destroy(false);
                }
                this.b.clear();
            }
        } catch (Throwable th) {
            iu.b(th, "MultiPointOverlayManagerLayer", "destory");
            th.printStackTrace();
        }
    }

    public final synchronized void c() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
        } catch (Throwable th) {
            iu.b(th, "MultiPointOverlayManagerLayer", "clear");
            th.printStackTrace();
        }
    }

    public final synchronized IMultiPointOverlay a(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        ai aiVar = new ai(multiPointOverlayOptions, this);
        synchronized (this.b) {
            this.b.add(aiVar);
        }
        return aiVar;
    }

    public final void a(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        try {
            synchronized (this.b) {
                for (IMultiPointOverlay draw : this.b) {
                    draw.draw(mapConfig, fArr, fArr2);
                }
            }
        } catch (Throwable th) {
            iu.b(th, "MultiPointOverlayManagerLayer", "draw");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.autonavi.amap.mapcore.IPoint r5) {
        /*
            r4 = this;
            com.amap.api.maps.AMap$OnMultiPointClickListener r0 = r4.c
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.List<com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay> r0 = r4.b
            monitor-enter(r0)
            java.util.List<com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay> r2 = r4.b     // Catch:{ all -> 0x0031 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0031 }
        L_0x000f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0031 }
            com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay r3 = (com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay) r3     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x000f
            com.amap.api.maps.model.MultiPointItem r3 = r3.onClick(r5)     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x000f
            com.amap.api.maps.AMap$OnMultiPointClickListener r5 = r4.c     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x002d
            com.amap.api.maps.AMap$OnMultiPointClickListener r5 = r4.c     // Catch:{ all -> 0x0031 }
            boolean r1 = r5.onPointClick(r3)     // Catch:{ all -> 0x0031 }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r1
        L_0x002f:
            monitor-exit(r0)
            return r1
        L_0x0031:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.aj.a(com.autonavi.amap.mapcore.IPoint):boolean");
    }

    public final void a(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.c = onMultiPointClickListener;
    }

    public final void d() {
        if (this.d != null) {
            this.d.setRunLowFrame(false);
        }
    }

    public final void a(ai aiVar) {
        this.b.remove(aiVar);
    }
}
