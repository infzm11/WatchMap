package com.loc;

import java.net.URLConnection;

/* compiled from: BaseNetManager */
public final class bi {
    private static bi a;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a();
    }

    public static bi a() {
        if (a == null) {
            a = new bi();
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080 A[Catch:{ j -> 0x000d, Throwable -> 0x000a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.loc.bo a(com.loc.bn r4, boolean r5) throws com.loc.j {
        /*
            if (r4 != 0) goto L_0x0010
            com.loc.j r4 = new com.loc.j     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r5 = "requeust is null"
            r4.<init>(r5)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            throw r4     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
        L_0x000a:
            r4 = move-exception
            goto L_0x0091
        L_0x000d:
            r4 = move-exception
            goto L_0x009c
        L_0x0010:
            java.lang.String r0 = r4.c()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = ""
            java.lang.String r1 = r4.c()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            boolean r0 = r0.equals(r1)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r0 == 0) goto L_0x0023
            goto L_0x0089
        L_0x0023:
            java.net.Proxy r0 = r4.e     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r0 != 0) goto L_0x0029
            r0 = 0
            goto L_0x002b
        L_0x0029:
            java.net.Proxy r0 = r4.e     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
        L_0x002b:
            com.loc.bl r1 = new com.loc.bl     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            int r2 = r4.c     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            int r3 = r4.d     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            r1.<init>(r2, r3, r0, r5)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            byte[] r5 = r4.d()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r5 == 0) goto L_0x0044
            int r5 = r5.length     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r5 != 0) goto L_0x003e
            goto L_0x0044
        L_0x003e:
            java.util.Map r5 = r4.b_()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r5 != 0) goto L_0x0049
        L_0x0044:
            java.lang.String r5 = r4.c()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            goto L_0x0065
        L_0x0049:
            java.lang.String r5 = com.loc.bl.a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            r0.<init>()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r2 = r4.c()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            r0.append(r2)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r2 = "?"
            r0.append(r2)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            r0.append(r5)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r5 = r0.toString()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
        L_0x0065:
            java.util.Map r0 = r4.b()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            byte[] r2 = r4.d()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r2 == 0) goto L_0x0072
            int r3 = r2.length     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r3 != 0) goto L_0x0084
        L_0x0072:
            java.util.Map r4 = r4.b_()     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r4 = com.loc.bl.a((java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            if (r3 != 0) goto L_0x0084
            byte[] r2 = com.loc.t.a((java.lang.String) r4)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
        L_0x0084:
            com.loc.bo r4 = r1.a((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.String>) r0, (byte[]) r2)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            return r4
        L_0x0089:
            com.loc.j r4 = new com.loc.j     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            java.lang.String r5 = "request url is empty"
            r4.<init>(r5)     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
            throw r4     // Catch:{ j -> 0x000d, Throwable -> 0x000a }
        L_0x0091:
            r4.printStackTrace()
            com.loc.j r4 = new com.loc.j
            java.lang.String r5 = "未知的错误"
            r4.<init>(r5)
            throw r4
        L_0x009c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bi.a(com.loc.bn, boolean):com.loc.bo");
    }

    public static byte[] a(bn bnVar) throws j {
        try {
            bo a2 = a(bnVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (j e) {
            throw e;
        } catch (Throwable th) {
            w.a(th, "bm", "msp");
            throw new j("未知的错误");
        }
    }
}
