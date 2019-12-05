package com.amap.api.col.n3;

import android.content.Context;
import java.io.File;
import java.util.Date;

/* compiled from: Utils */
public class kr {
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0053, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0056, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0057, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0086, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0087, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r2.close();
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
    static byte[] a(com.amap.api.col.n3.jz r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            r1 = 0
            com.amap.api.col.n3.jz$b r2 = r4.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x0061, all -> 0x005e }
            if (r2 != 0) goto L_0x0015
            if (r2 == 0) goto L_0x0014
            r2.close()     // Catch:{ Throwable -> 0x0010 }
            goto L_0x0014
        L_0x0010:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0014:
            return r0
        L_0x0015:
            java.io.InputStream r3 = r2.a()     // Catch:{ Throwable -> 0x005c }
            if (r3 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x0025
            r3.close()     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0025:
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Throwable -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            int r1 = r3.available()     // Catch:{ Throwable -> 0x0059, all -> 0x0056 }
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x0059, all -> 0x0056 }
            r3.read(r1)     // Catch:{ Throwable -> 0x0053, all -> 0x0056 }
            if (r6 == 0) goto L_0x003e
            r4.c((java.lang.String) r5)     // Catch:{ Throwable -> 0x0053, all -> 0x0056 }
        L_0x003e:
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ Throwable -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0052:
            return r1
        L_0x0053:
            r4 = move-exception
            r0 = r1
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r1 = r3
            goto L_0x0080
        L_0x0059:
            r4 = move-exception
        L_0x005a:
            r1 = r3
            goto L_0x0063
        L_0x005c:
            r4 = move-exception
            goto L_0x0063
        L_0x005e:
            r4 = move-exception
            r2 = r1
            goto L_0x0080
        L_0x0061:
            r4 = move-exception
            r2 = r1
        L_0x0063:
            java.lang.String r5 = "Utils"
            java.lang.String r6 = "readSingleLog"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ Throwable -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007e:
            return r0
        L_0x007f:
            r4 = move-exception
        L_0x0080:
            if (r1 == 0) goto L_0x008a
            r1.close()     // Catch:{ Throwable -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008a:
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ Throwable -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0094:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kr.a(com.amap.api.col.n3.jz, java.lang.String, boolean):byte[]");
    }

    public static String a() {
        return in.a(new Date().getTime());
    }

    public static String a(Context context, im imVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String e = ih.e(context);
            sb.append("\"sim\":\"");
            sb.append(e);
            sb.append("\",\"sdkversion\":\"");
            sb.append(imVar.c());
            sb.append("\",\"product\":\"");
            sb.append(imVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(imVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(ih.c(context));
            sb.append("\",\"np\":\"");
            sb.append(ih.a(context));
            sb.append("\",\"mnc\":\"");
            sb.append(ih.b(context));
            sb.append("\",\"ant\":\"");
            sb.append(ih.d(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007d A[SYNTHETIC, Splitter:B:38:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0093 A[SYNTHETIC, Splitter:B:49:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a7 A[SYNTHETIC, Splitter:B:59:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r7, java.lang.String r8) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            byte[] r2 = new byte[r1]
            java.lang.String r7 = com.amap.api.col.n3.is.a(r7, r8)
            r8 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0081, Throwable -> 0x006b }
            r3.<init>(r7)     // Catch:{ IOException -> 0x0081, Throwable -> 0x006b }
            r4 = 307200(0x4b000, double:1.51777E-318)
            com.amap.api.col.n3.jz r3 = com.amap.api.col.n3.jz.a((java.io.File) r3, (long) r4)     // Catch:{ IOException -> 0x0081, Throwable -> 0x006b }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            boolean r7 = r8.exists()     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            if (r7 == 0) goto L_0x0049
            java.lang.String[] r7 = r8.list()     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            int r8 = r7.length     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r4 = r1
        L_0x002a:
            if (r4 >= r8) goto L_0x0049
            r5 = r7[r4]     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r6 = ".0"
            boolean r6 = r5.contains(r6)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            if (r6 == 0) goto L_0x0046
            java.lang.String r6 = "\\."
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r5 = r5[r1]     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r6 = 1
            byte[] r5 = a((com.amap.api.col.n3.jz) r3, (java.lang.String) r5, (boolean) r6)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r0.write(r5)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
        L_0x0046:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x0049:
            byte[] r7 = r0.toByteArray()     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
            r0.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0055:
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ Throwable -> 0x005b }
            goto L_0x009c
        L_0x005b:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x009c
        L_0x0060:
            r7 = move-exception
            goto L_0x009d
        L_0x0062:
            r7 = move-exception
            r8 = r3
            goto L_0x006c
        L_0x0065:
            r7 = move-exception
            r8 = r3
            goto L_0x0082
        L_0x0068:
            r7 = move-exception
            r3 = r8
            goto L_0x009d
        L_0x006b:
            r7 = move-exception
        L_0x006c:
            java.lang.String r1 = "sui"
            java.lang.String r3 = "gec"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0068 }
            r0.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007b:
            if (r8 == 0) goto L_0x009b
            r8.close()     // Catch:{ Throwable -> 0x0097 }
            goto L_0x009b
        L_0x0081:
            r7 = move-exception
        L_0x0082:
            java.lang.String r1 = "sui"
            java.lang.String r3 = "gec"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0068 }
            r0.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0091:
            if (r8 == 0) goto L_0x009b
            r8.close()     // Catch:{ Throwable -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009b:
            r7 = r2
        L_0x009c:
            return r7
        L_0x009d:
            r0.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a5:
            if (r3 == 0) goto L_0x00af
            r3.close()     // Catch:{ Throwable -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00af:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kr.a(android.content.Context, java.lang.String):byte[]");
    }

    public static int b(Context context, String str) {
        try {
            File file = new File(is.a(context, str));
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            ir.a(th, "sui", "gfn");
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A[SYNTHETIC, Splitter:B:39:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087 A[SYNTHETIC, Splitter:B:45:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC, Splitter:B:53:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009c A[SYNTHETIC, Splitter:B:59:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
            if (r7 == 0) goto L_0x00a8
            int r0 = r7.length
            if (r0 != 0) goto L_0x0007
            goto L_0x00a8
        L_0x0007:
            java.lang.Class<com.amap.api.col.n3.kr> r0 = com.amap.api.col.n3.kr.class
            monitor-enter(r0)
            java.util.Random r1 = new java.util.Random     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            r2 = 0
            java.lang.String r5 = com.amap.api.col.n3.is.a(r5, r6)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            java.io.File r6 = new java.io.File     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            r3 = 307200(0x4b000, double:1.51777E-318)
            com.amap.api.col.n3.jz r5 = com.amap.api.col.n3.jz.a((java.io.File) r6, (long) r3)     // Catch:{ Throwable -> 0x0072, all -> 0x006f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006d }
            r6.<init>()     // Catch:{ Throwable -> 0x006d }
            r3 = 100
            int r1 = r1.nextInt(r3)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r1 = java.lang.Integer.toString(r1)     // Catch:{ Throwable -> 0x006d }
            r6.append(r1)     // Catch:{ Throwable -> 0x006d }
            long r3 = java.lang.System.nanoTime()     // Catch:{ Throwable -> 0x006d }
            java.lang.String r1 = java.lang.Long.toString(r3)     // Catch:{ Throwable -> 0x006d }
            r6.append(r1)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x006d }
            com.amap.api.col.n3.jz$a r6 = r5.b((java.lang.String) r6)     // Catch:{ Throwable -> 0x006d }
            java.io.OutputStream r1 = r6.a()     // Catch:{ Throwable -> 0x006d }
            r1.write(r7)     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            r6.b()     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            r5.d()     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ Throwable -> 0x0058 }
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
            r2 = r1
            goto L_0x0090
        L_0x006a:
            r6 = move-exception
            r2 = r1
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
            java.lang.String r7 = "sui"
            java.lang.String r1 = "wdc"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r1)     // Catch:{ all -> 0x008f }
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
            monitor-exit(r0)
            throw r5
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kr.a(android.content.Context, java.lang.String, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[Catch:{ Throwable -> 0x0051, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[SYNTHETIC, Splitter:B:31:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[SYNTHETIC, Splitter:B:39:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0077 A[SYNTHETIC, Splitter:B:47:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0083 A[SYNTHETIC, Splitter:B:54:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long c(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r6 = com.amap.api.col.n3.is.a(r6, r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r7.exists()
            r0 = 0
            if (r6 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x005b, Throwable -> 0x003c, all -> 0x0038 }
            r2.<init>(r7)     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x005b, Throwable -> 0x003c, all -> 0x0038 }
            int r6 = r2.available()     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, Throwable -> 0x0032 }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, Throwable -> 0x0032 }
            r2.read(r6)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, Throwable -> 0x0032 }
            java.lang.String r6 = com.amap.api.col.n3.in.a((byte[]) r6)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, Throwable -> 0x0032 }
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, Throwable -> 0x0032 }
            r2.close()     // Catch:{ Throwable -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0031:
            return r3
        L_0x0032:
            r6 = move-exception
            goto L_0x0040
        L_0x0034:
            r6 = move-exception
            goto L_0x005e
        L_0x0036:
            r6 = move-exception
            goto L_0x006e
        L_0x0038:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto L_0x0081
        L_0x003c:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0040:
            java.lang.String r3 = "sm"
            java.lang.String r4 = "gut"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0080 }
            boolean r6 = r7.exists()     // Catch:{ Throwable -> 0x0051 }
            if (r6 == 0) goto L_0x0055
            r7.delete()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0080 }
        L_0x0055:
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ Throwable -> 0x007b }
            goto L_0x007f
        L_0x005b:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x005e:
            java.lang.String r7 = "sm"
            java.lang.String r3 = "gut"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ Throwable -> 0x007b }
            goto L_0x007f
        L_0x006b:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x006e:
            java.lang.String r7 = "sm"
            java.lang.String r3 = "gut"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ Throwable -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007f:
            return r0
        L_0x0080:
            r6 = move-exception
        L_0x0081:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ Throwable -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kr.c(android.content.Context, java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0055 A[SYNTHETIC, Splitter:B:34:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0062 A[SYNTHETIC, Splitter:B:42:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0050=Splitter:B:31:0x0050, B:20:0x003f=Splitter:B:20:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r1, long r2, java.lang.String r4) {
        /*
            java.lang.String r1 = com.amap.api.col.n3.is.a(r1, r4)
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            java.io.File r1 = r4.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x001a
            java.io.File r1 = r4.getParentFile()
            r1.mkdirs()
        L_0x001a:
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x003c, all -> 0x0038 }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x003c, all -> 0x0038 }
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034 }
            byte[] r1 = com.amap.api.col.n3.in.a((java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034 }
            r0.write(r1)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034 }
            r0.close()     // Catch:{ Throwable -> 0x002f }
            return
        L_0x002f:
            r1 = move-exception
            r1.printStackTrace()
            return
        L_0x0034:
            r1 = move-exception
            goto L_0x003f
        L_0x0036:
            r1 = move-exception
            goto L_0x0050
        L_0x0038:
            r2 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0060
        L_0x003c:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x003f:
            r1.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ Throwable -> 0x0048 }
            return
        L_0x0048:
            r1 = move-exception
            r1.printStackTrace()
            return
        L_0x004d:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x0050:
            r1.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ Throwable -> 0x0059 }
            return
        L_0x0059:
            r1 = move-exception
            r1.printStackTrace()
            return
        L_0x005e:
            return
        L_0x005f:
            r1 = move-exception
        L_0x0060:
            if (r0 == 0) goto L_0x006a
            r0.close()     // Catch:{ Throwable -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r2 = move-exception
            r2.printStackTrace()
        L_0x006a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.kr.a(android.content.Context, long, java.lang.String):void");
    }
}
