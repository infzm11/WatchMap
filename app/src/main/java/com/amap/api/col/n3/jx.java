package com.amap.api.col.n3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LoaderFactory */
public final class jx {
    private static final jx a = new jx();
    private final Map<String, jq> b = new HashMap();

    private jx() {
    }

    public static jx a() {
        return a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.amap.api.col.n3.jq a(android.content.Context r5, com.amap.api.col.n3.im r6) throws java.lang.Exception {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 == 0) goto L_0x001b
            java.lang.String r0 = r6.b()     // Catch:{ all -> 0x0019 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = r6.a()     // Catch:{ all -> 0x0019 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x0019:
            r5 = move-exception
            goto L_0x0043
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0045
            if (r5 != 0) goto L_0x0021
            goto L_0x0045
        L_0x0021:
            java.lang.String r0 = r6.a()     // Catch:{ all -> 0x0019 }
            java.util.Map<java.lang.String, com.amap.api.col.n3.jq> r1 = r4.b     // Catch:{ all -> 0x0019 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0019 }
            com.amap.api.col.n3.jq r1 = (com.amap.api.col.n3.jq) r1     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0041
            com.amap.api.col.n3.jv r2 = new com.amap.api.col.n3.jv     // Catch:{ Throwable -> 0x0041 }
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ Throwable -> 0x0041 }
            r2.<init>(r3, r6)     // Catch:{ Throwable -> 0x0041 }
            java.util.Map<java.lang.String, com.amap.api.col.n3.jq> r1 = r4.b     // Catch:{ Throwable -> 0x0040 }
            r1.put(r0, r2)     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.col.n3.jt.a(r5, r6)     // Catch:{ Throwable -> 0x0040 }
        L_0x0040:
            r1 = r2
        L_0x0041:
            monitor-exit(r4)
            return r1
        L_0x0043:
            monitor-exit(r4)
            throw r5
        L_0x0045:
            r5 = 0
            monitor-exit(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jx.a(android.content.Context, com.amap.api.col.n3.im):com.amap.api.col.n3.jq");
    }
}
