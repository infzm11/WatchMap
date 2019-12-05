package com.amap.api.col.n3;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDBOperation */
public class bb {
    private static volatile bb a;
    private static ja b;
    private Context c;

    public static bb a(Context context) {
        if (a == null) {
            synchronized (bb.class) {
                if (a == null) {
                    a = new bb(context);
                }
            }
        }
        return a;
    }

    private bb(Context context) {
        this.c = context;
        b = b(this.c);
    }

    private static ja b(Context context) {
        try {
            return new ja(context, ba.a());
        } catch (Throwable th) {
            iu.b(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean b() {
        if (b == null) {
            b = b(this.c);
        }
        return b != null;
    }

    public final ArrayList<aw> a() {
        ArrayList<aw> arrayList = new ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        for (aw add : b.b("", aw.class)) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final synchronized aw a(String str) {
        if (!b()) {
            return null;
        }
        List<aw> b2 = b.b(aw.e(str), aw.class);
        if (b2.size() <= 0) {
            return null;
        }
        return b2.get(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.amap.api.col.n3.aw r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.b()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)
            return
        L_0x0009:
            java.lang.String r0 = r7.g()     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = com.amap.api.col.n3.aw.f(r0)     // Catch:{ all -> 0x0062 }
            com.amap.api.col.n3.ja r1 = b     // Catch:{ all -> 0x0062 }
            r1.a((java.lang.Object) r7, (java.lang.String) r0)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r7.a()     // Catch:{ all -> 0x0062 }
            java.lang.String r7 = r7.e()     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
            int r1 = r0.length()     // Catch:{ all -> 0x0062 }
            if (r1 <= 0) goto L_0x0060
            java.lang.String r1 = com.amap.api.col.n3.ay.a(r7)     // Catch:{ all -> 0x0062 }
            com.amap.api.col.n3.ja r2 = b     // Catch:{ all -> 0x0062 }
            java.lang.Class<com.amap.api.col.n3.ay> r3 = com.amap.api.col.n3.ay.class
            java.util.List r2 = r2.b(r1, r3)     // Catch:{ all -> 0x0062 }
            int r2 = r2.size()     // Catch:{ all -> 0x0062 }
            if (r2 <= 0) goto L_0x003f
            com.amap.api.col.n3.ja r2 = b     // Catch:{ all -> 0x0062 }
            java.lang.Class<com.amap.api.col.n3.ay> r3 = com.amap.api.col.n3.ay.class
            r2.a((java.lang.String) r1, r3)     // Catch:{ all -> 0x0062 }
        L_0x003f:
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x0062 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0062 }
            r1.<init>()     // Catch:{ all -> 0x0062 }
            int r2 = r0.length     // Catch:{ all -> 0x0062 }
            r3 = 0
        L_0x004c:
            if (r3 >= r2) goto L_0x005b
            r4 = r0[r3]     // Catch:{ all -> 0x0062 }
            com.amap.api.col.n3.ay r5 = new com.amap.api.col.n3.ay     // Catch:{ all -> 0x0062 }
            r5.<init>(r7, r4)     // Catch:{ all -> 0x0062 }
            r1.add(r5)     // Catch:{ all -> 0x0062 }
            int r3 = r3 + 1
            goto L_0x004c
        L_0x005b:
            com.amap.api.col.n3.ja r7 = b     // Catch:{ all -> 0x0062 }
            r7.a(r1)     // Catch:{ all -> 0x0062 }
        L_0x0060:
            monitor-exit(r6)
            return
        L_0x0062:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bb.a(com.amap.api.col.n3.aw):void");
    }

    public final synchronized List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a(b.b(ay.a(str), ay.class)));
        return arrayList;
    }

    private static List<String> a(List<ay> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (ay a2 : list) {
                arrayList.add(a2.a());
            }
        }
        return arrayList;
    }

    public final synchronized void c(String str) {
        if (b()) {
            b.a(az.e(str), az.class);
            b.a(ay.a(str), ay.class);
            b.a(ax.a(str), ax.class);
        }
    }

    public final synchronized void b(aw awVar) {
        if (b()) {
            b.a(az.f(awVar.g()), az.class);
            b.a(ay.a(awVar.e()), ay.class);
            b.a(ax.a(awVar.e()), ax.class);
        }
    }

    public final void a(String str, int i, long j, long j2, long j3) {
        if (b()) {
            a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    /* JADX INFO: finally extract failed */
    private synchronized void a(String str, int i, long j, long[] jArr, long[] jArr2) {
        try {
            if (b()) {
                ax axVar = new ax(str, j, i, jArr[0], jArr2[0]);
                b.a((Object) axVar, ax.a(str));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String d(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.b()     // Catch:{ all -> 0x0029 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            java.lang.String r4 = com.amap.api.col.n3.az.f(r4)     // Catch:{ all -> 0x0029 }
            com.amap.api.col.n3.ja r0 = b     // Catch:{ all -> 0x0029 }
            java.lang.Class<com.amap.api.col.n3.az> r2 = com.amap.api.col.n3.az.class
            java.util.List r4 = r0.b(r4, r2)     // Catch:{ all -> 0x0029 }
            int r0 = r4.size()     // Catch:{ all -> 0x0029 }
            if (r0 <= 0) goto L_0x0027
            r0 = 0
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0029 }
            com.amap.api.col.n3.az r4 = (com.amap.api.col.n3.az) r4     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r4.d()     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r3)
            return r1
        L_0x0029:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bb.d(java.lang.String):java.lang.String");
    }
}
