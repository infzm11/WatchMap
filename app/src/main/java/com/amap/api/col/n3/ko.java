package com.amap.api.col.n3;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* compiled from: OfflineLocManager */
public class ko {
    static int a = 1000;
    static boolean b = false;

    public static synchronized void a(int i, boolean z) {
        synchronized (ko.class) {
            a = i;
            b = z;
        }
    }

    public static synchronized void a(final kn knVar, final Context context) {
        synchronized (ko.class) {
            iu.c().submit(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:34:0x0069 A[SYNTHETIC, Splitter:B:34:0x0069] */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0073 A[SYNTHETIC, Splitter:B:40:0x0073] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x007e A[SYNTHETIC, Splitter:B:48:0x007e] */
                /* JADX WARNING: Removed duplicated region for block: B:55:0x008a A[SYNTHETIC, Splitter:B:55:0x008a] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r7 = this;
                        java.lang.Class<com.amap.api.col.n3.ko> r0 = com.amap.api.col.n3.ko.class
                        monitor-enter(r0)
                        r1 = 0
                        com.amap.api.col.n3.kn r2 = r3     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        byte[] r2 = r2.a()     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        android.content.Context r3 = r4     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        java.lang.String r4 = com.amap.api.col.n3.is.h     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        java.lang.String r3 = com.amap.api.col.n3.is.a(r3, r4)     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        r4.<init>(r3)     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        r5 = 2097152(0x200000, double:1.0361308E-317)
                        com.amap.api.col.n3.jz r3 = com.amap.api.col.n3.jz.a((java.io.File) r4, (long) r5)     // Catch:{ Throwable -> 0x005e, all -> 0x005b }
                        int r4 = com.amap.api.col.n3.ko.a     // Catch:{ Throwable -> 0x0059 }
                        r3.a((int) r4)     // Catch:{ Throwable -> 0x0059 }
                        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0059 }
                        java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ Throwable -> 0x0059 }
                        com.amap.api.col.n3.jz$a r4 = r3.b((java.lang.String) r4)     // Catch:{ Throwable -> 0x0059 }
                        java.io.OutputStream r5 = r4.a()     // Catch:{ Throwable -> 0x0059 }
                        r5.write(r2)     // Catch:{ Throwable -> 0x0055, all -> 0x0051 }
                        r4.b()     // Catch:{ Throwable -> 0x0055, all -> 0x0051 }
                        r3.d()     // Catch:{ Throwable -> 0x0055, all -> 0x0051 }
                        if (r5 == 0) goto L_0x0046
                        r5.close()     // Catch:{ Throwable -> 0x0042 }
                        goto L_0x0046
                    L_0x0042:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
                    L_0x0046:
                        if (r3 == 0) goto L_0x0079
                        r3.close()     // Catch:{ Throwable -> 0x004c }
                        goto L_0x0079
                    L_0x004c:
                        r1 = move-exception
                    L_0x004d:
                        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
                        goto L_0x0079
                    L_0x0051:
                        r1 = move-exception
                        r2 = r1
                        r1 = r5
                        goto L_0x007c
                    L_0x0055:
                        r1 = move-exception
                        r2 = r1
                        r1 = r5
                        goto L_0x0060
                    L_0x0059:
                        r2 = move-exception
                        goto L_0x0060
                    L_0x005b:
                        r2 = move-exception
                        r3 = r1
                        goto L_0x007c
                    L_0x005e:
                        r2 = move-exception
                        r3 = r1
                    L_0x0060:
                        java.lang.String r4 = "OfflineLocManager"
                        java.lang.String r5 = "applyOfflineLocEntity"
                        com.amap.api.col.n3.ir.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x007b }
                        if (r1 == 0) goto L_0x0071
                        r1.close()     // Catch:{ Throwable -> 0x006d }
                        goto L_0x0071
                    L_0x006d:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
                    L_0x0071:
                        if (r3 == 0) goto L_0x0079
                        r3.close()     // Catch:{ Throwable -> 0x0077 }
                        goto L_0x0079
                    L_0x0077:
                        r1 = move-exception
                        goto L_0x004d
                    L_0x0079:
                        monitor-exit(r0)     // Catch:{ all -> 0x0082 }
                        return
                    L_0x007b:
                        r2 = move-exception
                    L_0x007c:
                        if (r1 == 0) goto L_0x0088
                        r1.close()     // Catch:{ Throwable -> 0x0084 }
                        goto L_0x0088
                    L_0x0082:
                        r1 = move-exception
                        goto L_0x0093
                    L_0x0084:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
                    L_0x0088:
                        if (r3 == 0) goto L_0x0092
                        r3.close()     // Catch:{ Throwable -> 0x008e }
                        goto L_0x0092
                    L_0x008e:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
                    L_0x0092:
                        throw r2     // Catch:{ all -> 0x0082 }
                    L_0x0093:
                        monitor-exit(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ko.AnonymousClass1.run():void");
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bc, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bd, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e1, code lost:
        if (r1.c() == false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e3, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e8, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ba A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dd A[SYNTHETIC, Splitter:B:58:0x00dd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5) {
        /*
            r0 = 0
            boolean r1 = c(r5)     // Catch:{ Throwable -> 0x00c2 }
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00c2 }
            java.lang.String r2 = com.amap.api.col.n3.is.h     // Catch:{ Throwable -> 0x00c2 }
            java.lang.String r2 = com.amap.api.col.n3.is.a(r5, r2)     // Catch:{ Throwable -> 0x00c2 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x00c2 }
            r2 = 2097152(0x200000, double:1.0361308E-317)
            com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.a((java.io.File) r1, (long) r2)     // Catch:{ Throwable -> 0x00c2 }
            java.lang.String r2 = a((com.amap.api.col.n3.jz) r1)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            if (r3 == 0) goto L_0x0026
            r5 = r0
            goto L_0x0050
        L_0x0026:
            java.lang.String r5 = d(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            byte[] r5 = com.amap.api.col.n3.in.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = com.amap.api.col.n3.ig.b((byte[]) r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r3.<init>()     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r4 = "{\"pinfo\":\""
            r3.append(r4)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r3.append(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = "\",\"els\":["
            r3.append(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r3.append(r2)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = "]}"
            r3.append(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = r3.toString()     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
        L_0x0050:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            if (r2 == 0) goto L_0x0067
            if (r1 == 0) goto L_0x0066
            boolean r5 = r1.c()     // Catch:{ Throwable -> 0x0062 }
            if (r5 != 0) goto L_0x0066
            r1.close()     // Catch:{ Throwable -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0066:
            return
        L_0x0067:
            byte[] r5 = com.amap.api.col.n3.in.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            byte[] r5 = com.amap.api.col.n3.in.c((byte[]) r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            com.amap.api.col.n3.it r2 = new com.amap.api.col.n3.it     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r3 = "6"
            r2.<init>(r5, r3)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            com.amap.api.col.n3.kd r5 = com.amap.api.col.n3.kd.a()     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            byte[] r5 = r5.a(r2)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r3.<init>(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = "code"
            boolean r5 = r2.has(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            if (r5 == 0) goto L_0x00a8
            java.lang.String r5 = "code"
            int r5 = r2.getInt(r5)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            r2 = 1
            if (r5 != r2) goto L_0x00a8
            if (r1 == 0) goto L_0x00a9
            r1.e()     // Catch:{ Throwable -> 0x009f, all -> 0x00ba }
            goto L_0x00a9
        L_0x009f:
            r5 = move-exception
            java.lang.String r2 = "StatisticsManager"
            java.lang.String r3 = "getContent"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00bc, all -> 0x00ba }
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            if (r0 == 0) goto L_0x00b9
            boolean r5 = r0.c()     // Catch:{ Throwable -> 0x00b5 }
            if (r5 != 0) goto L_0x00b9
            r0.close()     // Catch:{ Throwable -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00b9:
            return
        L_0x00ba:
            r5 = move-exception
            goto L_0x00db
        L_0x00bc:
            r5 = move-exception
            r0 = r1
            goto L_0x00c3
        L_0x00bf:
            r5 = move-exception
            r1 = r0
            goto L_0x00db
        L_0x00c2:
            r5 = move-exception
        L_0x00c3:
            java.lang.String r1 = "OfflineLocManager"
            java.lang.String r2 = "updateOfflineLocData"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00da
            boolean r5 = r0.c()     // Catch:{ Throwable -> 0x00d6 }
            if (r5 != 0) goto L_0x00da
            r0.close()     // Catch:{ Throwable -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00da:
            return
        L_0x00db:
            if (r1 == 0) goto L_0x00eb
            boolean r0 = r1.c()     // Catch:{ Throwable -> 0x00e7 }
            if (r0 != 0) goto L_0x00eb
            r1.close()     // Catch:{ Throwable -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00eb:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ko.a(android.content.Context):void");
    }

    private static String a(jz jzVar) {
        StringBuilder sb = new StringBuilder();
        try {
            File b2 = jzVar.b();
            if (b2 != null && b2.exists()) {
                boolean z = true;
                for (String str : b2.list()) {
                    if (str.contains(".0")) {
                        String a2 = in.a(kr.a(jzVar, str.split("\\.")[0], false));
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append("{\"log\":\"");
                        sb.append(a2);
                        sb.append("\"}");
                    }
                }
            }
        } catch (Throwable th) {
            ir.a(th, "StatisticsManager", "getContent");
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[Catch:{ Throwable -> 0x0051, all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[SYNTHETIC, Splitter:B:30:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067 A[SYNTHETIC, Splitter:B:38:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long b(android.content.Context r5) {
        /*
            java.lang.String r0 = "f.log"
            java.lang.String r5 = com.amap.api.col.n3.is.a(r5, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L_0x0014
            r0 = 0
            return r0
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x003c, all -> 0x0038 }
            int r5 = r1.available()     // Catch:{ Throwable -> 0x0036 }
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x0036 }
            r1.read(r5)     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r5 = com.amap.api.col.n3.in.a((byte[]) r5)     // Catch:{ Throwable -> 0x0036 }
            long r2 = java.lang.Long.parseLong(r5)     // Catch:{ Throwable -> 0x0036 }
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ Throwable -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0035:
            return r2
        L_0x0036:
            r5 = move-exception
            goto L_0x0040
        L_0x0038:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x0065
        L_0x003c:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L_0x0040:
            java.lang.String r2 = "ol"
            java.lang.String r3 = "gut"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0064 }
            boolean r5 = r0.exists()     // Catch:{ Throwable -> 0x0051 }
            if (r5 == 0) goto L_0x0055
            r0.delete()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0064 }
        L_0x0055:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Throwable -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            long r0 = java.lang.System.currentTimeMillis()
            return r0
        L_0x0064:
            r5 = move-exception
        L_0x0065:
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ Throwable -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ko.b(android.content.Context):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073 A[SYNTHETIC, Splitter:B:39:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007d A[SYNTHETIC, Splitter:B:45:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean c(android.content.Context r9) {
        /*
            java.lang.Class<com.amap.api.col.n3.ko> r0 = com.amap.api.col.n3.ko.class
            monitor-enter(r0)
            r1 = 0
            int r2 = com.amap.api.col.n3.ih.n(r9)     // Catch:{ Throwable -> 0x0088 }
            r3 = 1
            if (r2 == r3) goto L_0x000f
            boolean r2 = b     // Catch:{ Throwable -> 0x0088 }
            if (r2 == 0) goto L_0x0090
        L_0x000f:
            long r4 = b(r9)     // Catch:{ Throwable -> 0x0088 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0088 }
            long r6 = r6 - r4
            r4 = 14400000(0xdbba00, double:7.1145453E-317)
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0021
            monitor-exit(r0)
            return r1
        L_0x0021:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0088 }
            r2 = 0
            java.lang.String r6 = "f.log"
            java.lang.String r9 = com.amap.api.col.n3.is.a(r9, r6)     // Catch:{ Throwable -> 0x0069 }
            java.io.File r6 = new java.io.File     // Catch:{ Throwable -> 0x0069 }
            r6.<init>(r9)     // Catch:{ Throwable -> 0x0069 }
            java.io.File r9 = r6.getParentFile()     // Catch:{ Throwable -> 0x0069 }
            boolean r9 = r9.exists()     // Catch:{ Throwable -> 0x0069 }
            if (r9 != 0) goto L_0x0042
            java.io.File r9 = r6.getParentFile()     // Catch:{ Throwable -> 0x0069 }
            r9.mkdirs()     // Catch:{ Throwable -> 0x0069 }
        L_0x0042:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0069 }
            r9.<init>(r6)     // Catch:{ Throwable -> 0x0069 }
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x0062, all -> 0x005d }
            byte[] r2 = com.amap.api.col.n3.in.a((java.lang.String) r2)     // Catch:{ Throwable -> 0x0062, all -> 0x005d }
            r9.write(r2)     // Catch:{ Throwable -> 0x0062, all -> 0x005d }
            if (r9 == 0) goto L_0x0079
            r9.close()     // Catch:{ Throwable -> 0x0058 }
            goto L_0x0079
        L_0x0058:
            r9 = move-exception
        L_0x0059:
            r9.printStackTrace()     // Catch:{ Throwable -> 0x0088 }
            goto L_0x0079
        L_0x005d:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
            goto L_0x007b
        L_0x0062:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
            goto L_0x006a
        L_0x0067:
            r9 = move-exception
            goto L_0x007b
        L_0x0069:
            r9 = move-exception
        L_0x006a:
            java.lang.String r4 = "OfflineLocManager"
            java.lang.String r5 = "updateLogUpdateTime"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r9, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0079
            r2.close()     // Catch:{ Throwable -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r9 = move-exception
            goto L_0x0059
        L_0x0079:
            monitor-exit(r0)
            return r3
        L_0x007b:
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Throwable -> 0x0088 }
        L_0x0085:
            throw r9     // Catch:{ Throwable -> 0x0088 }
        L_0x0086:
            r9 = move-exception
            goto L_0x0092
        L_0x0088:
            r9 = move-exception
            java.lang.String r2 = "StatisticsManager"
            java.lang.String r3 = "isUpdate"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r9, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0086 }
        L_0x0090:
            monitor-exit(r0)
            return r1
        L_0x0092:
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ko.c(android.content.Context):boolean");
    }

    private static String d(Context context) {
        try {
            return String.format(in.c(new String(ip.a(10))), new Object[]{id.f(context), ih.q(context), ih.j(context), ih.f(context), ih.a(), Build.MANUFACTURER, Build.DEVICE, ih.r(context), id.c(context), Build.MODEL, id.d(context), id.b(context)});
        } catch (Throwable th) {
            ir.a(th, "ol", "gpj");
            return "";
        }
    }
}
