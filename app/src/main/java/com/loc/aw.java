package com.loc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ClassLoaderFactory */
public final class aw {
    private static final aw a = new aw();
    private final Map<String, av> b = new HashMap();

    private aw() {
    }

    public static aw a() {
        return a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.loc.av a(android.content.Context r5, com.loc.s r6) throws java.lang.Exception {
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
            goto L_0x004b
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0043
            if (r5 != 0) goto L_0x0021
            goto L_0x0043
        L_0x0021:
            java.lang.String r0 = r6.a()     // Catch:{ all -> 0x0019 }
            java.util.Map<java.lang.String, com.loc.av> r1 = r4.b     // Catch:{ all -> 0x0019 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0019 }
            com.loc.av r1 = (com.loc.av) r1     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0041
            com.loc.az r2 = new com.loc.az     // Catch:{ Throwable -> 0x0041 }
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ Throwable -> 0x0041 }
            r2.<init>(r3, r6)     // Catch:{ Throwable -> 0x0041 }
            java.util.Map<java.lang.String, com.loc.av> r1 = r4.b     // Catch:{ Throwable -> 0x0040 }
            r1.put(r0, r2)     // Catch:{ Throwable -> 0x0040 }
            com.loc.ba.a(r5, r6)     // Catch:{ Throwable -> 0x0040 }
        L_0x0040:
            r1 = r2
        L_0x0041:
            monitor-exit(r4)
            return r1
        L_0x0043:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x0019 }
            java.lang.String r6 = "sdkInfo or context referance is null"
            r5.<init>(r6)     // Catch:{ all -> 0x0019 }
            throw r5     // Catch:{ all -> 0x0019 }
        L_0x004b:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.aw.a(android.content.Context, com.loc.s):com.loc.av");
    }
}
