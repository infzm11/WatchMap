package com.amap.api.col.n3;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TraceManager */
public class ia implements LocationSource.OnLocationChangedListener, LBSTraceBase {
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public CoordinateConverter b;
    private ExecutorService c;
    /* access modifiers changed from: private */
    public ExecutorService d;
    private long e = 2000;
    private int f = 5;
    /* access modifiers changed from: private */
    public TraceStatusListener g;
    private af h;
    private List<TraceLocation> i = new ArrayList();
    private int j = 0;
    private int k = 0;
    private long l = 0;
    /* access modifiers changed from: private */
    public c m;

    /* compiled from: TraceManager */
    class a implements Runnable {
        private List<TraceLocation> b = new ArrayList();
        private int c;
        private int d;
        private List<TraceLocation> e;
        private String f;
        private TraceListener g;

        public a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.c = i2;
            this.d = i;
            this.e = list;
            this.f = dp.a();
            this.g = traceListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x007e A[Catch:{ InterruptedException -> 0x017d, Throwable -> 0x0197 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r19 = this;
                r1 = r19
                com.amap.api.col.n3.ia r2 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia$c r2 = r2.m     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceListener r3 = r1.g     // Catch:{ Throwable -> 0x0197 }
                r2.a(r3)     // Catch:{ Throwable -> 0x0197 }
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.e     // Catch:{ Throwable -> 0x0197 }
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0079
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.e     // Catch:{ Throwable -> 0x0197 }
                int r2 = r2.size()     // Catch:{ Throwable -> 0x0197 }
                if (r2 != 0) goto L_0x001c
                goto L_0x0079
            L_0x001c:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0197 }
                r2.<init>()     // Catch:{ Throwable -> 0x0197 }
                java.util.List<com.amap.api.trace.TraceLocation> r5 = r1.e     // Catch:{ Throwable -> 0x0197 }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ Throwable -> 0x0197 }
                r6 = r4
            L_0x0028:
                boolean r7 = r5.hasNext()     // Catch:{ Throwable -> 0x0197 }
                if (r7 == 0) goto L_0x007a
                java.lang.Object r7 = r5.next()     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r7 = (com.amap.api.trace.TraceLocation) r7     // Catch:{ Throwable -> 0x0197 }
                if (r7 == 0) goto L_0x0028
                float r8 = r7.getSpeed()     // Catch:{ Throwable -> 0x0197 }
                double r8 = (double) r8     // Catch:{ Throwable -> 0x0197 }
                r10 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 >= 0) goto L_0x0048
                r2.add(r7)     // Catch:{ Throwable -> 0x0197 }
                goto L_0x0028
            L_0x0048:
                int r7 = r2.size()     // Catch:{ Throwable -> 0x0197 }
                if (r7 > r3) goto L_0x0050
            L_0x004e:
                r7 = r4
                goto L_0x0074
            L_0x0050:
                java.lang.Object r8 = r2.get(r4)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r8 = (com.amap.api.trace.TraceLocation) r8     // Catch:{ Throwable -> 0x0197 }
                int r7 = r7 + -1
                java.lang.Object r7 = r2.get(r7)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r7 = (com.amap.api.trace.TraceLocation) r7     // Catch:{ Throwable -> 0x0197 }
                if (r8 == 0) goto L_0x004e
                if (r7 != 0) goto L_0x0063
                goto L_0x004e
            L_0x0063:
                if (r8 == 0) goto L_0x004e
                if (r7 == 0) goto L_0x004e
                long r9 = r7.getTime()     // Catch:{ Throwable -> 0x0197 }
                long r7 = r8.getTime()     // Catch:{ Throwable -> 0x0197 }
                long r9 = r9 - r7
                r7 = 1000(0x3e8, double:4.94E-321)
                long r9 = r9 / r7
                int r7 = (int) r9     // Catch:{ Throwable -> 0x0197 }
            L_0x0074:
                int r6 = r6 + r7
                r2.clear()     // Catch:{ Throwable -> 0x0197 }
                goto L_0x0028
            L_0x0079:
                r6 = r4
            L_0x007a:
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.e     // Catch:{ Throwable -> 0x0197 }
                if (r2 == 0) goto L_0x0186
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.e     // Catch:{ Throwable -> 0x0197 }
                int r2 = r2.size()     // Catch:{ Throwable -> 0x0197 }
                r5 = 2
                if (r2 >= r5) goto L_0x0089
                goto L_0x0186
            L_0x0089:
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.e     // Catch:{ Throwable -> 0x0197 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Throwable -> 0x0197 }
            L_0x008f:
                boolean r7 = r2.hasNext()     // Catch:{ Throwable -> 0x0197 }
                if (r7 == 0) goto L_0x00b9
                java.lang.Object r7 = r2.next()     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r7 = (com.amap.api.trace.TraceLocation) r7     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r7 = r7.copy()     // Catch:{ Throwable -> 0x0197 }
                if (r7 == 0) goto L_0x008f
                double r8 = r7.getLatitude()     // Catch:{ Throwable -> 0x0197 }
                r10 = 0
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 <= 0) goto L_0x008f
                double r8 = r7.getLongitude()     // Catch:{ Throwable -> 0x0197 }
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 <= 0) goto L_0x008f
                java.util.List<com.amap.api.trace.TraceLocation> r8 = r1.b     // Catch:{ Throwable -> 0x0197 }
                r8.add(r7)     // Catch:{ Throwable -> 0x0197 }
                goto L_0x008f
            L_0x00b9:
                java.util.List<com.amap.api.trace.TraceLocation> r2 = r1.b     // Catch:{ Throwable -> 0x0197 }
                int r2 = r2.size()     // Catch:{ Throwable -> 0x0197 }
                int r2 = r2 - r5
                r7 = 500(0x1f4, float:7.0E-43)
                int r2 = r2 / r7
                com.amap.api.col.n3.ib r8 = com.amap.api.col.n3.ib.a()     // Catch:{ Throwable -> 0x0197 }
                java.lang.String r9 = r1.f     // Catch:{ Throwable -> 0x0197 }
                int r10 = r1.d     // Catch:{ Throwable -> 0x0197 }
                r8.a(r9, r10, r2, r6)     // Catch:{ Throwable -> 0x0197 }
                r6 = r4
                r8 = r7
            L_0x00d0:
                if (r6 > r2) goto L_0x0185
                if (r6 != r2) goto L_0x00da
                java.util.List<com.amap.api.trace.TraceLocation> r8 = r1.b     // Catch:{ Throwable -> 0x0197 }
                int r8 = r8.size()     // Catch:{ Throwable -> 0x0197 }
            L_0x00da:
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0197 }
                r14.<init>()     // Catch:{ Throwable -> 0x0197 }
                r9 = r4
            L_0x00e0:
                if (r9 >= r8) goto L_0x0144
                java.util.List<com.amap.api.trace.TraceLocation> r10 = r1.b     // Catch:{ Throwable -> 0x0197 }
                java.lang.Object r10 = r10.remove(r4)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.trace.TraceLocation r10 = (com.amap.api.trace.TraceLocation) r10     // Catch:{ Throwable -> 0x0197 }
                if (r10 == 0) goto L_0x013f
                int r11 = r1.c     // Catch:{ Throwable -> 0x0197 }
                if (r11 == r3) goto L_0x013c
                int r11 = r1.c     // Catch:{ Throwable -> 0x0197 }
                r12 = 3
                if (r11 != r12) goto L_0x0101
                com.amap.api.col.n3.ia r11 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter r11 = r11.b     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter$CoordType r12 = com.amap.api.maps.CoordinateConverter.CoordType.BAIDU     // Catch:{ Throwable -> 0x0197 }
                r11.from(r12)     // Catch:{ Throwable -> 0x0197 }
                goto L_0x0110
            L_0x0101:
                int r11 = r1.c     // Catch:{ Throwable -> 0x0197 }
                if (r11 != r5) goto L_0x0110
                com.amap.api.col.n3.ia r11 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter r11 = r11.b     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter$CoordType r12 = com.amap.api.maps.CoordinateConverter.CoordType.GPS     // Catch:{ Throwable -> 0x0197 }
                r11.from(r12)     // Catch:{ Throwable -> 0x0197 }
            L_0x0110:
                com.amap.api.maps.model.LatLng r11 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0197 }
                double r12 = r10.getLatitude()     // Catch:{ Throwable -> 0x0197 }
                double r3 = r10.getLongitude()     // Catch:{ Throwable -> 0x0197 }
                r11.<init>(r12, r3)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r3 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter r3 = r3.b     // Catch:{ Throwable -> 0x0197 }
                r3.coord(r11)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r3 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.CoordinateConverter r3 = r3.b     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.maps.model.LatLng r3 = r3.convert()     // Catch:{ Throwable -> 0x0197 }
                if (r3 == 0) goto L_0x013c
                double r11 = r3.latitude     // Catch:{ Throwable -> 0x0197 }
                r10.setLatitude(r11)     // Catch:{ Throwable -> 0x0197 }
                double r3 = r3.longitude     // Catch:{ Throwable -> 0x0197 }
                r10.setLongitude(r3)     // Catch:{ Throwable -> 0x0197 }
            L_0x013c:
                r14.add(r10)     // Catch:{ Throwable -> 0x0197 }
            L_0x013f:
                int r9 = r9 + 1
                r3 = 1
                r4 = 0
                goto L_0x00e0
            L_0x0144:
                int r3 = r14.size()     // Catch:{ Throwable -> 0x0197 }
                if (r3 < r5) goto L_0x0181
                int r3 = r14.size()     // Catch:{ Throwable -> 0x0197 }
                if (r3 > r7) goto L_0x0181
                com.amap.api.col.n3.hz r3 = new com.amap.api.col.n3.hz     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r4 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                android.content.Context r12 = r4.a     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r4 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia$c r13 = r4.m     // Catch:{ Throwable -> 0x0197 }
                int r4 = r1.c     // Catch:{ Throwable -> 0x0197 }
                java.lang.String r15 = r1.f     // Catch:{ Throwable -> 0x0197 }
                int r4 = r1.d     // Catch:{ Throwable -> 0x0197 }
                r11 = r3
                r16 = r4
                r17 = r6
                r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r4 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                java.util.concurrent.ExecutorService r4 = r4.d     // Catch:{ Throwable -> 0x0197 }
                r4.execute(r3)     // Catch:{ Throwable -> 0x0197 }
                int r6 = r6 + 1
                r3 = 50
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x017d }
                goto L_0x0181
            L_0x017d:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ Throwable -> 0x0197 }
            L_0x0181:
                r3 = 1
                r4 = 0
                goto L_0x00d0
            L_0x0185:
                return
            L_0x0186:
                com.amap.api.col.n3.ib.a()     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia r2 = com.amap.api.col.n3.ia.this     // Catch:{ Throwable -> 0x0197 }
                com.amap.api.col.n3.ia$c r2 = r2.m     // Catch:{ Throwable -> 0x0197 }
                int r3 = r1.d     // Catch:{ Throwable -> 0x0197 }
                java.lang.String r4 = "轨迹点太少或距离太近,轨迹纠偏失败"
                com.amap.api.col.n3.ib.a((android.os.Handler) r2, (int) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0197 }
                return
            L_0x0197:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ia.a.run():void");
        }
    }

    /* compiled from: TraceManager */
    class b implements TraceListener {
        private final List<TraceLocation> b;

        public final void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }

        public b(List<TraceLocation> list) {
            this.b = list;
        }

        public final void onRequestFailed(int i, String str) {
            ia.this.g.onTraceStatus(this.b, (List<LatLng>) null, str);
        }

        public final void onFinished(int i, List<LatLng> list, int i2, int i3) {
            ia.this.g.onTraceStatus(this.b, list, LBSTraceClient.TRACE_SUCCESS);
        }
    }

    /* compiled from: TraceManager */
    static class c extends Handler {
        private TraceListener a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.a = traceListener;
        }

        public final void handleMessage(Message message) {
            try {
                if (this.a != null) {
                    Bundle data = message.getData();
                    if (data != null) {
                        int i = data.getInt("lineID");
                        switch (message.what) {
                            case 100:
                                this.a.onTraceProcessing(i, message.arg1, (List) message.obj);
                                return;
                            case 101:
                                this.a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                                return;
                            case 102:
                                this.a.onRequestFailed(i, (String) message.obj);
                                return;
                            default:
                                return;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ia(Context context) {
        this.a = context.getApplicationContext();
        this.b = new CoordinateConverter(this.a);
        this.c = Executors.newFixedThreadPool(1);
        this.m = new c(Looper.getMainLooper());
        this.d = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2) + 3);
    }

    public void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
        try {
            a aVar = new a(i2, list, i3, traceListener);
            this.c.execute(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLocationInterval(long j2) {
        this.e = j2;
    }

    public void setTraceStatusInterval(int i2) {
        this.f = Math.max(i2, 2);
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        if (this.a != null) {
            this.l = System.currentTimeMillis();
            this.g = traceStatusListener;
            if (this.h == null) {
                this.h = new af(this.a);
                this.h.a(this.e);
                this.h.activate(this);
            }
        }
    }

    public void onLocationChanged(Location location) {
        if (this.g != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.l >= 30000 && this.g != null) {
                    this.g.onTraceStatus((List<TraceLocation>) null, (List<LatLng>) null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                    this.l = currentTimeMillis;
                }
                if (location.getExtras().getInt(MyLocationStyle.ERROR_CODE) != 0) {
                    "Locate failed [errorCode:\"" + r1 + "\"  errorInfo:" + r0.getString(MyLocationStyle.ERROR_INFO) + "\"]";
                    return;
                }
                synchronized (this.i) {
                    List<TraceLocation> list = this.i;
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    list.add(traceLocation);
                    this.j++;
                    if (this.j == this.f) {
                        this.k += this.j;
                        a(this.k);
                        this.l = System.currentTimeMillis();
                        this.j = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(int i2) {
        ArrayList arrayList = new ArrayList(this.i.subList(0, i2));
        queryProcessedTrace(i2, arrayList, 1, new b(arrayList));
    }

    public void stopTrace() {
        a();
        synchronized (this.i) {
            if (this.i.size() > this.k) {
                int size = ((this.i.size() - this.k) / this.f) + 1;
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 == size - 1) {
                        a(this.i.size());
                    } else {
                        this.k += this.f;
                        a(this.k);
                    }
                }
            }
        }
    }

    private void a() {
        if (this.h != null) {
            this.h.deactivate();
            this.h = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void destroy() {
        /*
            r3 = this;
            r0 = 0
            r3.a()     // Catch:{ Throwable -> 0x003f }
            java.util.concurrent.ExecutorService r1 = r3.c     // Catch:{ Throwable -> 0x003f }
            if (r1 == 0) goto L_0x0017
            java.util.concurrent.ExecutorService r1 = r3.c     // Catch:{ Throwable -> 0x003f }
            boolean r1 = r1.isShutdown()     // Catch:{ Throwable -> 0x003f }
            if (r1 != 0) goto L_0x0017
            java.util.concurrent.ExecutorService r1 = r3.c     // Catch:{ Throwable -> 0x003f }
            r1.shutdownNow()     // Catch:{ Throwable -> 0x003f }
            r3.c = r0     // Catch:{ Throwable -> 0x003f }
        L_0x0017:
            java.util.concurrent.ExecutorService r1 = r3.d     // Catch:{ Throwable -> 0x003f }
            if (r1 == 0) goto L_0x002a
            java.util.concurrent.ExecutorService r1 = r3.d     // Catch:{ Throwable -> 0x003f }
            boolean r1 = r1.isShutdown()     // Catch:{ Throwable -> 0x003f }
            if (r1 != 0) goto L_0x002a
            java.util.concurrent.ExecutorService r1 = r3.d     // Catch:{ Throwable -> 0x003f }
            r1.shutdownNow()     // Catch:{ Throwable -> 0x003f }
            r3.d = r0     // Catch:{ Throwable -> 0x003f }
        L_0x002a:
            java.util.List<com.amap.api.trace.TraceLocation> r1 = r3.i     // Catch:{ Throwable -> 0x003f }
            monitor-enter(r1)     // Catch:{ Throwable -> 0x003f }
            java.util.List<com.amap.api.trace.TraceLocation> r2 = r3.i     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0038
            java.util.List<com.amap.api.trace.TraceLocation> r2 = r3.i     // Catch:{ all -> 0x003c }
            r2.clear()     // Catch:{ all -> 0x003c }
            r3.i = r0     // Catch:{ all -> 0x003c }
        L_0x0038:
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            r3.g = r0     // Catch:{ Throwable -> 0x003f }
            goto L_0x0043
        L_0x003c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ Throwable -> 0x003f }
            throw r2     // Catch:{ Throwable -> 0x003f }
        L_0x003f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0043:
            r3.a = r0
            r3.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ia.destroy():void");
    }
}
