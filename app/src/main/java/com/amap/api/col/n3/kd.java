package com.amap.api.col.n3;

import java.net.URLConnection;

/* compiled from: BaseNetManager */
public class kd {
    private static kd a;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a();
    }

    public static kd a() {
        if (a == null) {
            a = new kd();
        }
        return a;
    }

    public byte[] a(kj kjVar) throws ic {
        try {
            kl a2 = a(kjVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (ic e) {
            throw e;
        } catch (Throwable th) {
            ir.a(th, "bm", "msp");
            throw new ic("未知的错误");
        }
    }

    public static kl b(kj kjVar) throws ic {
        try {
            kl a2 = a(kjVar, false);
            if (a2 != null) {
                return a2;
            }
            return null;
        } catch (ic e) {
            throw e;
        } catch (Throwable th) {
            ir.a(th, "bm", "mp");
            throw new ic("未知的错误");
        }
    }

    protected static void c(kj kjVar) throws ic {
        if (kjVar == null) {
            throw new ic("requeust is null");
        } else if (kjVar.c() == null || "".equals(kjVar.c())) {
            throw new ic("request url is empty");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ ic -> 0x0075, Throwable -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.col.n3.kl a(com.amap.api.col.n3.kj r4, boolean r5) throws com.amap.api.col.n3.ic {
        /*
            c(r4)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.net.Proxy r0 = r4.h     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r0 != 0) goto L_0x0009
            r0 = 0
            goto L_0x000b
        L_0x0009:
            java.net.Proxy r0 = r4.h     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
        L_0x000b:
            com.amap.api.col.n3.kg r1 = new com.amap.api.col.n3.kg     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            int r2 = r4.f     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            int r3 = r4.g     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            r1.<init>(r2, r3, r0, r5)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            byte[] r5 = r4.f()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r5 == 0) goto L_0x0024
            int r5 = r5.length     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r5 != 0) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            java.util.Map r5 = r4.b()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r5 != 0) goto L_0x0029
        L_0x0024:
            java.lang.String r5 = r4.c()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            goto L_0x0045
        L_0x0029:
            java.lang.String r5 = com.amap.api.col.n3.kg.a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            r0.<init>()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.lang.String r2 = r4.c()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            r0.append(r2)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.lang.String r2 = "?"
            r0.append(r2)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            r0.append(r5)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.lang.String r5 = r0.toString()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
        L_0x0045:
            java.util.Map r0 = r4.a()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            byte[] r2 = r4.f()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r2 == 0) goto L_0x0052
            int r3 = r2.length     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r3 != 0) goto L_0x0064
        L_0x0052:
            java.util.Map r4 = r4.b()     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            java.lang.String r4 = com.amap.api.col.n3.kg.a((java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            if (r3 != 0) goto L_0x0064
            byte[] r2 = com.amap.api.col.n3.in.a((java.lang.String) r4)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
        L_0x0064:
            com.amap.api.col.n3.kl r4 = r1.a((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.String>) r0, (byte[]) r2)     // Catch:{ ic -> 0x0075, Throwable -> 0x0069 }
            return r4
        L_0x0069:
            r4 = move-exception
            r4.printStackTrace()
            com.amap.api.col.n3.ic r4 = new com.amap.api.col.n3.ic
            java.lang.String r5 = "未知的错误"
            r4.<init>(r5)
            throw r4
        L_0x0075:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kd.a(com.amap.api.col.n3.kj, boolean):com.amap.api.col.n3.kl");
    }
}
