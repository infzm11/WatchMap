package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlayOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* compiled from: TileOverlayView */
public final class u {
    List<cm> a = new ArrayList();
    a b = new a();
    List<Integer> c = new ArrayList();
    cu d = null;
    float[] e = new float[16];
    private k f;
    private Context g;

    /* compiled from: TileOverlayView */
    static class a implements Serializable, Comparator<Object> {
        a() {
        }

        public final int compare(Object obj, Object obj2) {
            cm cmVar = (cm) obj;
            cm cmVar2 = (cm) obj2;
            if (cmVar == null || cmVar2 == null) {
                return 0;
            }
            try {
                if (cmVar.getZIndex() > cmVar2.getZIndex()) {
                    return 1;
                }
                if (cmVar.getZIndex() < cmVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Throwable th) {
                iu.b(th, "TileOverlayView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public u(Context context, k kVar) {
        this.f = kVar;
        this.g = context;
        TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new de() {
            public final String a(int i, int i2, int i3) {
                try {
                    return String.format(Locale.US, "http://grid.amap.com/grid/%d/%d/%d?dpiType=webrd&lang=zh_cn&pack=%s&ds=0", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), g.b});
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        tileProvider.memCacheSize(10485760);
        tileProvider.diskCacheSize(20480);
        this.d = new cu(tileProvider, this, (byte) 0);
    }

    public final k a() {
        return this.f;
    }

    public final void b() {
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                cm cmVar = this.a.get(i);
                if (cmVar != null) {
                    cmVar.destroy(false);
                }
            }
            this.a.clear();
        }
    }

    public final void c() {
        synchronized (this.a) {
            Collections.sort(this.a, this.b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.maps.model.TileOverlay a(com.amap.api.maps.model.TileOverlayOptions r4) throws android.os.RemoteException {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0036
            com.amap.api.maps.model.TileProvider r1 = r4.getTileProvider()
            if (r1 != 0) goto L_0x000a
            goto L_0x0036
        L_0x000a:
            com.amap.api.col.n3.cu r1 = new com.amap.api.col.n3.cu     // Catch:{ Throwable -> 0x0031 }
            r1.<init>(r4, r3)     // Catch:{ Throwable -> 0x0031 }
            java.util.List<com.amap.api.col.n3.cm> r4 = r3.a     // Catch:{ Throwable -> 0x0031 }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x0031 }
            r3.a((com.amap.api.col.n3.cm) r1)     // Catch:{ all -> 0x002e }
            java.util.List<com.amap.api.col.n3.cm> r2 = r3.a     // Catch:{ all -> 0x002e }
            r2.add(r1)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            r3.c()     // Catch:{ Throwable -> 0x0031 }
            r4 = 1
            r1.a(r4)     // Catch:{ Throwable -> 0x0031 }
            com.amap.api.col.n3.k r4 = r3.f     // Catch:{ Throwable -> 0x0031 }
            r2 = 0
            r4.setRunLowFrame(r2)     // Catch:{ Throwable -> 0x0031 }
            com.amap.api.maps.model.TileOverlay r4 = new com.amap.api.maps.model.TileOverlay     // Catch:{ Throwable -> 0x0031 }
            r4.<init>(r1)     // Catch:{ Throwable -> 0x0031 }
            return r4
        L_0x002e:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ Throwable -> 0x0031 }
            throw r1     // Catch:{ Throwable -> 0x0031 }
        L_0x0031:
            r4 = move-exception
            r4.printStackTrace()
            return r0
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.u.a(com.amap.api.maps.model.TileOverlayOptions):com.amap.api.maps.model.TileOverlay");
    }

    public final boolean a(cm cmVar) {
        boolean remove;
        synchronized (this.a) {
            remove = this.a.remove(cmVar);
        }
        return remove;
    }

    public final void a(boolean z) {
        try {
            if (g.c == 0) {
                CameraPosition cameraPosition = this.f.getCameraPosition();
                if (cameraPosition == null || cameraPosition.zoom <= 10.0f || !cameraPosition.isAbroad || this.f.getMapType() != 1) {
                    if (this.d != null) {
                        this.d.b();
                    }
                } else if (this.d != null) {
                    this.d.a(z);
                }
            }
            synchronized (this.a) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    cm cmVar = this.a.get(i);
                    if (cmVar != null && cmVar.isVisible()) {
                        cmVar.a(z);
                    }
                }
            }
        } catch (Throwable th) {
            iu.b(th, "TileOverlayView", "refresh");
        }
    }

    public final void b(boolean z) {
        if (this.d != null) {
            this.d.b(z);
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                cm cmVar = this.a.get(i);
                if (cmVar != null) {
                    cmVar.b(z);
                }
            }
        }
    }

    public final Context d() {
        return this.g;
    }

    public final void a(int i) {
        this.c.add(Integer.valueOf(i));
    }

    public final float[] e() {
        if (this.f != null) {
            return this.f.v();
        }
        return this.e;
    }
}
