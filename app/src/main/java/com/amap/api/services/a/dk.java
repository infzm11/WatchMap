package com.amap.api.services.a;

import android.content.Context;
import java.io.File;
import java.util.Date;

/* compiled from: Utils */
public class dk {
    static byte[] a(ct ctVar, String str) {
        return a(ctVar, str, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0053, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0056, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0057, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0086, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0087, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0090, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0091, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:24:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x006c A[SYNTHETIC, Splitter:B:56:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0076 A[SYNTHETIC, Splitter:B:61:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0082 A[SYNTHETIC, Splitter:B:68:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x008c A[SYNTHETIC, Splitter:B:73:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(com.amap.api.services.a.ct r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            byte[] r1 = new byte[r0]
            r2 = 0
            com.amap.api.services.a.ct$b r3 = r4.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x0061, all -> 0x005e }
            if (r3 != 0) goto L_0x0015
            if (r3 == 0) goto L_0x0014
            r3.close()     // Catch:{ Throwable -> 0x0010 }
            goto L_0x0014
        L_0x0010:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0014:
            return r1
        L_0x0015:
            java.io.InputStream r0 = r3.a(r0)     // Catch:{ Throwable -> 0x005c }
            if (r0 != 0) goto L_0x0030
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0025:
            if (r3 == 0) goto L_0x002f
            r3.close()     // Catch:{ Throwable -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            return r1
        L_0x0030:
            int r2 = r0.available()     // Catch:{ Throwable -> 0x0059, all -> 0x0056 }
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x0059, all -> 0x0056 }
            r0.read(r2)     // Catch:{ Throwable -> 0x0053, all -> 0x0056 }
            if (r6 == 0) goto L_0x003e
            r4.c((java.lang.String) r5)     // Catch:{ Throwable -> 0x0053, all -> 0x0056 }
        L_0x003e:
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ Throwable -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0052:
            return r2
        L_0x0053:
            r4 = move-exception
            r1 = r2
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r2 = r0
            goto L_0x0080
        L_0x0059:
            r4 = move-exception
        L_0x005a:
            r2 = r0
            goto L_0x0063
        L_0x005c:
            r4 = move-exception
            goto L_0x0063
        L_0x005e:
            r4 = move-exception
            r3 = r2
            goto L_0x0080
        L_0x0061:
            r4 = move-exception
            r3 = r2
        L_0x0063:
            java.lang.String r5 = "Utils"
            java.lang.String r6 = "readSingleLog"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0074:
            if (r3 == 0) goto L_0x007e
            r3.close()     // Catch:{ Throwable -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007e:
            return r1
        L_0x007f:
            r4 = move-exception
        L_0x0080:
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ Throwable -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008a:
            if (r3 == 0) goto L_0x0094
            r3.close()     // Catch:{ Throwable -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0094:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dk.a(com.amap.api.services.a.ct, java.lang.String, boolean):byte[]");
    }

    public static String a() {
        return bi.a(new Date().getTime());
    }

    public static String a(Context context, bh bhVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String e = bd.e(context);
            sb.append("\"sim\":\"");
            sb.append(e);
            sb.append("\",\"sdkversion\":\"");
            sb.append(bhVar.c());
            sb.append("\",\"product\":\"");
            sb.append(bhVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(bhVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(bd.c(context));
            sb.append("\",\"np\":\"");
            sb.append(bd.a(context));
            sb.append("\",\"mnc\":\"");
            sb.append(bd.b(context));
            sb.append("\",\"ant\":\"");
            sb.append(bd.d(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078 A[SYNTHETIC, Splitter:B:38:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[SYNTHETIC, Splitter:B:43:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090 A[SYNTHETIC, Splitter:B:50:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009a A[SYNTHETIC, Splitter:B:55:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a6 A[SYNTHETIC, Splitter:B:61:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b0 A[SYNTHETIC, Splitter:B:66:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r6, java.lang.String r7, int r8) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            byte[] r2 = new byte[r1]
            java.lang.String r6 = com.amap.api.services.a.bm.a((android.content.Context) r6, (java.lang.String) r7)
            r7 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0086, Throwable -> 0x006e }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0086, Throwable -> 0x006e }
            long r4 = (long) r8     // Catch:{ IOException -> 0x0086, Throwable -> 0x006e }
            r8 = 1
            com.amap.api.services.a.ct r8 = com.amap.api.services.a.ct.a(r3, r8, r8, r4)     // Catch:{ IOException -> 0x0086, Throwable -> 0x006e }
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            if (r7 == 0) goto L_0x004a
            boolean r6 = r7.exists()     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            if (r6 == 0) goto L_0x004a
            java.lang.String[] r6 = r7.list()     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            r3 = r1
        L_0x002b:
            if (r3 >= r7) goto L_0x004a
            r4 = r6[r3]     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            java.lang.String r5 = ".0"
            boolean r5 = r4.contains(r5)     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            if (r5 != 0) goto L_0x0038
            goto L_0x0047
        L_0x0038:
            java.lang.String r5 = "\\."
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            r4 = r4[r1]     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            byte[] r4 = a((com.amap.api.services.a.ct) r8, (java.lang.String) r4)     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            r0.write(r4)     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x002b
        L_0x004a:
            byte[] r6 = r0.toByteArray()     // Catch:{ IOException -> 0x0068, Throwable -> 0x0065, all -> 0x0063 }
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0058:
            if (r8 == 0) goto L_0x00a3
            r8.close()     // Catch:{ Throwable -> 0x005e }
            goto L_0x00a3
        L_0x005e:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x00a3
        L_0x0063:
            r6 = move-exception
            goto L_0x00a4
        L_0x0065:
            r6 = move-exception
            r7 = r8
            goto L_0x006f
        L_0x0068:
            r6 = move-exception
            r7 = r8
            goto L_0x0087
        L_0x006b:
            r6 = move-exception
            r8 = r7
            goto L_0x00a4
        L_0x006e:
            r6 = move-exception
        L_0x006f:
            java.lang.String r8 = "Statistics.Utils"
            java.lang.String r1 = "getContent"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0080
            r0.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0080:
            if (r7 == 0) goto L_0x00a2
            r7.close()     // Catch:{ Throwable -> 0x009e }
            goto L_0x00a2
        L_0x0086:
            r6 = move-exception
        L_0x0087:
            java.lang.String r8 = "Statistics.Utils"
            java.lang.String r1 = "getContent"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0098
            r0.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0098:
            if (r7 == 0) goto L_0x00a2
            r7.close()     // Catch:{ Throwable -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a2:
            r6 = r2
        L_0x00a3:
            return r6
        L_0x00a4:
            if (r0 == 0) goto L_0x00ae
            r0.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ae:
            if (r8 == 0) goto L_0x00b8
            r8.close()     // Catch:{ Throwable -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00b8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dk.a(android.content.Context, java.lang.String, int):byte[]");
    }

    public static int a(Context context, String str) {
        try {
            File file = new File(bm.a(context, str));
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            bl.a(th, "Statistics.Utils", "getFileNum");
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A[SYNTHETIC, Splitter:B:39:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087 A[SYNTHETIC, Splitter:B:45:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC, Splitter:B:53:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009c A[SYNTHETIC, Splitter:B:59:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, java.lang.String r6, int r7, byte[] r8) {
        /*
            if (r8 == 0) goto L_0x00a8
            int r0 = r8.length
            if (r0 != 0) goto L_0x0007
            goto L_0x00a8
        L_0x0007:
            java.lang.Class<com.amap.api.services.a.dk> r0 = com.amap.api.services.a.dk.class
            monitor-enter(r0)
            java.util.Random r1 = new java.util.Random     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            r2 = 0
            java.lang.String r5 = com.amap.api.services.a.bm.a((android.content.Context) r5, (java.lang.String) r6)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            java.io.File r6 = new java.io.File     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            long r3 = (long) r7     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            r5 = 1
            com.amap.api.services.a.ct r5 = com.amap.api.services.a.ct.a(r6, r5, r5, r3)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006d }
            r6.<init>()     // Catch:{ Throwable -> 0x006d }
            r7 = 100
            int r7 = r1.nextInt(r7)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ Throwable -> 0x006d }
            r6.append(r7)     // Catch:{ Throwable -> 0x006d }
            long r3 = java.lang.System.nanoTime()     // Catch:{ Throwable -> 0x006d }
            java.lang.String r7 = java.lang.Long.toString(r3)     // Catch:{ Throwable -> 0x006d }
            r6.append(r7)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x006d }
            com.amap.api.services.a.ct$a r6 = r5.b((java.lang.String) r6)     // Catch:{ Throwable -> 0x006d }
            r7 = 0
            java.io.OutputStream r7 = r6.a((int) r7)     // Catch:{ Throwable -> 0x006d }
            r7.write(r8)     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            r6.a()     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            r5.d()     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            if (r7 == 0) goto L_0x005c
            r7.close()     // Catch:{ Throwable -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x005c:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch:{ Throwable -> 0x0062 }
            goto L_0x008d
        L_0x0062:
            r5 = move-exception
        L_0x0063:
            r5.printStackTrace()     // Catch:{ all -> 0x00a5 }
            goto L_0x008d
        L_0x0067:
            r6 = move-exception
            r2 = r7
            goto L_0x0090
        L_0x006a:
            r6 = move-exception
            r2 = r7
            goto L_0x0074
        L_0x006d:
            r6 = move-exception
            goto L_0x0074
        L_0x006f:
            r6 = move-exception
            r5 = r2
            goto L_0x0090
        L_0x0072:
            r6 = move-exception
            r5 = r2
        L_0x0074:
            java.lang.String r7 = "Statistics.Utils"
            java.lang.String r8 = "writeToDiskLruCache"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x0085:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch:{ Throwable -> 0x008b }
            goto L_0x008d
        L_0x008b:
            r5 = move-exception
            goto L_0x0063
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return
        L_0x008f:
            r6 = move-exception
        L_0x0090:
            if (r2 == 0) goto L_0x009a
            r2.close()     // Catch:{ Throwable -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x009a:
            if (r5 == 0) goto L_0x00a4
            r5.close()     // Catch:{ Throwable -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x00a4:
            throw r6     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            throw r5
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dk.a(android.content.Context, java.lang.String, int, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A[SYNTHETIC, Splitter:B:33:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006b A[SYNTHETIC, Splitter:B:41:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007b A[SYNTHETIC, Splitter:B:49:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0087 A[SYNTHETIC, Splitter:B:56:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r6 = com.amap.api.services.a.bm.a((android.content.Context) r6, (java.lang.String) r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r7.exists()
            r0 = 0
            if (r6 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x005f, Throwable -> 0x003e, all -> 0x003a }
            r2.<init>(r7)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x005f, Throwable -> 0x003e, all -> 0x003a }
            int r6 = r2.available()     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            r2.read(r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            java.lang.String r6 = com.amap.api.services.a.bi.a((byte[]) r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ Throwable -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0033:
            return r3
        L_0x0034:
            r6 = move-exception
            goto L_0x0042
        L_0x0036:
            r6 = move-exception
            goto L_0x0062
        L_0x0038:
            r6 = move-exception
            goto L_0x0072
        L_0x003a:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto L_0x0085
        L_0x003e:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0042:
            java.lang.String r3 = "StatisticsManager"
            java.lang.String r4 = "getUpdateTime"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0084 }
            if (r7 == 0) goto L_0x0059
            boolean r6 = r7.exists()     // Catch:{ Throwable -> 0x0055 }
            if (r6 == 0) goto L_0x0059
            r7.delete()     // Catch:{ Throwable -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0084 }
        L_0x0059:
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ Throwable -> 0x007f }
            goto L_0x0083
        L_0x005f:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0062:
            java.lang.String r7 = "StatisticsManager"
            java.lang.String r3 = "getUpdateTime"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ Throwable -> 0x007f }
            goto L_0x0083
        L_0x006f:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0072:
            java.lang.String r7 = "StatisticsManager"
            java.lang.String r3 = "getUpdateTime"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ Throwable -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0083:
            return r0
        L_0x0084:
            r6 = move-exception
        L_0x0085:
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ Throwable -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dk.b(android.content.Context, java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041 A[SYNTHETIC, Splitter:B:20:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0048=Splitter:B:24:0x0048, B:17:0x003c=Splitter:B:17:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r1, long r2, java.lang.String r4) {
        /*
            java.lang.String r1 = com.amap.api.services.a.bm.a((android.content.Context) r1, (java.lang.String) r4)
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            java.io.File r1 = r4.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x001a
            java.io.File r1 = r4.getParentFile()
            r1.mkdirs()
        L_0x001a:
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0039, all -> 0x0035 }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0039, all -> 0x0035 }
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            byte[] r1 = com.amap.api.services.a.bi.a((java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            r0.write(r1)     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0031:
            r1 = move-exception
            goto L_0x003c
        L_0x0033:
            r1 = move-exception
            goto L_0x0048
        L_0x0035:
            r2 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0057
        L_0x0039:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x003c:
            r1.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0045:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x0048:
            r1.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0055:
            return
        L_0x0056:
            r1 = move-exception
        L_0x0057:
            if (r0 == 0) goto L_0x0061
            r0.close()     // Catch:{ Throwable -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0061:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.dk.a(android.content.Context, long, java.lang.String):void");
    }
}
