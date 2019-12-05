package com.loc;

import android.content.Context;
import java.io.File;
import java.util.Date;

/* compiled from: Utils */
public class bt {
    public static String a() {
        return t.a(new Date().getTime());
    }

    public static String a(Context context, s sVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String e = n.e(context);
            sb.append("\"sim\":\"");
            sb.append(e);
            sb.append("\",\"sdkversion\":\"");
            sb.append(sVar.c());
            sb.append("\",\"product\":\"");
            sb.append(sVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(sVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(n.c(context));
            sb.append("\",\"np\":\"");
            sb.append(n.a(context));
            sb.append("\",\"mnc\":\"");
            sb.append(n.b(context));
            sb.append("\",\"ant\":\"");
            sb.append(n.d(context));
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

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC, Splitter:B:33:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0063 A[SYNTHETIC, Splitter:B:40:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0041=Splitter:B:20:0x0041, B:30:0x0052=Splitter:B:30:0x0052} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r1, long r2, java.lang.String r4) {
        /*
            java.lang.String r1 = com.loc.x.a(r1, r4)
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            java.io.File r1 = r4.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x001a
            java.io.File r1 = r4.getParentFile()
            r1.mkdirs()
        L_0x001a:
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003e, all -> 0x003a }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003e, all -> 0x003a }
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            byte[] r1 = com.loc.t.a((java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r0.write(r1)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ Throwable -> 0x0031 }
            return
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            return
        L_0x0036:
            r1 = move-exception
            goto L_0x0041
        L_0x0038:
            r1 = move-exception
            goto L_0x0052
        L_0x003a:
            r2 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0061
        L_0x003e:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x0041:
            r1.printStackTrace()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ Throwable -> 0x004a }
            return
        L_0x004a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x004e:
            return
        L_0x004f:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x0052:
            r1.printStackTrace()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x005f
            r0.close()     // Catch:{ Throwable -> 0x005b }
            return
        L_0x005b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005f:
            return
        L_0x0060:
            r1 = move-exception
        L_0x0061:
            if (r0 == 0) goto L_0x006b
            r0.close()     // Catch:{ Throwable -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r2 = move-exception
            r2.printStackTrace()
        L_0x006b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bt.a(android.content.Context, long, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c A[SYNTHETIC, Splitter:B:40:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086 A[SYNTHETIC, Splitter:B:46:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091 A[SYNTHETIC, Splitter:B:54:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009b A[SYNTHETIC, Splitter:B:60:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
            if (r7 == 0) goto L_0x00a7
            int r0 = r7.length
            if (r0 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.Class<com.loc.bt> r0 = com.loc.bt.class
            monitor-enter(r0)
            java.util.Random r1 = new java.util.Random     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r2 = 0
            java.lang.String r5 = com.loc.x.a(r5, r6)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            java.io.File r6 = new java.io.File     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            r3 = 307200(0x4b000, double:1.51777E-318)
            com.loc.be r5 = com.loc.be.a((java.io.File) r6, (long) r3)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006c }
            r6.<init>()     // Catch:{ Throwable -> 0x006c }
            r3 = 100
            int r1 = r1.nextInt(r3)     // Catch:{ Throwable -> 0x006c }
            java.lang.String r1 = java.lang.Integer.toString(r1)     // Catch:{ Throwable -> 0x006c }
            r6.append(r1)     // Catch:{ Throwable -> 0x006c }
            long r3 = java.lang.System.nanoTime()     // Catch:{ Throwable -> 0x006c }
            java.lang.String r1 = java.lang.Long.toString(r3)     // Catch:{ Throwable -> 0x006c }
            r6.append(r1)     // Catch:{ Throwable -> 0x006c }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x006c }
            com.loc.be$a r6 = r5.b((java.lang.String) r6)     // Catch:{ Throwable -> 0x006c }
            java.io.OutputStream r1 = r6.a()     // Catch:{ Throwable -> 0x006c }
            r1.write(r7)     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            r6.b()     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            r5.d()     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ Throwable -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00a4 }
        L_0x005b:
            if (r5 == 0) goto L_0x008c
            r5.close()     // Catch:{ Throwable -> 0x0061 }
            goto L_0x008c
        L_0x0061:
            r5 = move-exception
        L_0x0062:
            r5.printStackTrace()     // Catch:{ all -> 0x00a4 }
            goto L_0x008c
        L_0x0066:
            r6 = move-exception
            r2 = r1
            goto L_0x008f
        L_0x0069:
            r6 = move-exception
            r2 = r1
            goto L_0x0073
        L_0x006c:
            r6 = move-exception
            goto L_0x0073
        L_0x006e:
            r6 = move-exception
            r5 = r2
            goto L_0x008f
        L_0x0071:
            r6 = move-exception
            r5 = r2
        L_0x0073:
            java.lang.String r7 = "sui"
            java.lang.String r1 = "wdc"
            com.loc.w.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r1)     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x0084
            r2.close()     // Catch:{ Throwable -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00a4 }
        L_0x0084:
            if (r5 == 0) goto L_0x008c
            r5.close()     // Catch:{ Throwable -> 0x008a }
            goto L_0x008c
        L_0x008a:
            r5 = move-exception
            goto L_0x0062
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            return
        L_0x008e:
            r6 = move-exception
        L_0x008f:
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ Throwable -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00a4 }
        L_0x0099:
            if (r5 == 0) goto L_0x00a3
            r5.close()     // Catch:{ Throwable -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x00a4 }
        L_0x00a3:
            throw r6     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bt.a(android.content.Context, java.lang.String, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007d A[SYNTHETIC, Splitter:B:40:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098 A[SYNTHETIC, Splitter:B:53:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a7 A[SYNTHETIC, Splitter:B:61:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r7, java.lang.String r8) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            byte[] r2 = new byte[r1]
            java.lang.String r7 = com.loc.x.a(r7, r8)
            r8 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0086, Throwable -> 0x006b }
            r3.<init>(r7)     // Catch:{ IOException -> 0x0086, Throwable -> 0x006b }
            r4 = 307200(0x4b000, double:1.51777E-318)
            com.loc.be r3 = com.loc.be.a((java.io.File) r3, (long) r4)     // Catch:{ IOException -> 0x0086, Throwable -> 0x006b }
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
            byte[] r5 = a((com.loc.be) r3, (java.lang.String) r5, (boolean) r6)     // Catch:{ IOException -> 0x0065, Throwable -> 0x0062, all -> 0x0060 }
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
            return r7
        L_0x005b:
            r8 = move-exception
            r8.printStackTrace()
            return r7
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
            goto L_0x0087
        L_0x0068:
            r7 = move-exception
            r3 = r8
            goto L_0x009d
        L_0x006b:
            r7 = move-exception
        L_0x006c:
            java.lang.String r1 = "sui"
            java.lang.String r3 = "gec"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0068 }
            r0.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007b:
            if (r8 == 0) goto L_0x009b
            r8.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x009b
        L_0x0081:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x009b
        L_0x0086:
            r7 = move-exception
        L_0x0087:
            java.lang.String r1 = "sui"
            java.lang.String r3 = "gec"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0068 }
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0096:
            if (r8 == 0) goto L_0x009b
            r8.close()     // Catch:{ Throwable -> 0x0081 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bt.a(android.content.Context, java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0053, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0054, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0056, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0057, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0086, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0087, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0090, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0091, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:26:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x006c A[SYNTHETIC, Splitter:B:59:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0076 A[SYNTHETIC, Splitter:B:64:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0082 A[SYNTHETIC, Splitter:B:72:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x008c A[SYNTHETIC, Splitter:B:77:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(com.loc.be r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            r1 = 0
            com.loc.be$b r2 = r4.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x0061, all -> 0x005e }
            if (r2 != 0) goto L_0x0015
            if (r2 == 0) goto L_0x0014
            r2.close()     // Catch:{ Throwable -> 0x0010 }
            return r0
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
            return r0
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
            return r1
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
            com.loc.w.a((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ Throwable -> 0x007a }
            return r0
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bt.a(com.loc.be, java.lang.String, boolean):byte[]");
    }

    public static int b(Context context, String str) {
        try {
            File file = new File(x.a(context, str));
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            w.a(th, "sui", "gfn");
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A[Catch:{ Throwable -> 0x0053, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006e A[SYNTHETIC, Splitter:B:45:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007e A[SYNTHETIC, Splitter:B:54:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0085 A[SYNTHETIC, Splitter:B:59:0x0085] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long c(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r6 = com.loc.x.a(r6, r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r7.exists()
            r0 = 0
            if (r6 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x0062, Throwable -> 0x003e, all -> 0x003a }
            r2.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x0062, Throwable -> 0x003e, all -> 0x003a }
            int r6 = r2.available()     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            r2.read(r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            java.lang.String r6 = com.loc.t.a((byte[]) r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036, Throwable -> 0x0034 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ Throwable -> 0x002f }
            return r3
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
            goto L_0x0065
        L_0x0038:
            r6 = move-exception
            goto L_0x0075
        L_0x003a:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto L_0x0083
        L_0x003e:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0042:
            java.lang.String r3 = "sm"
            java.lang.String r4 = "gut"
            com.loc.w.a((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0082 }
            boolean r6 = r7.exists()     // Catch:{ Throwable -> 0x0053 }
            if (r6 == 0) goto L_0x0057
            r7.delete()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0082 }
        L_0x0057:
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Throwable -> 0x005d }
            return r0
        L_0x005d:
            r6 = move-exception
            r6.printStackTrace()
            return r0
        L_0x0062:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0065:
            java.lang.String r7 = "sm"
            java.lang.String r3 = "gut"
            com.loc.w.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Throwable -> 0x005d }
            return r0
        L_0x0072:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0075:
            java.lang.String r7 = "sm"
            java.lang.String r3 = "gut"
            com.loc.w.a((java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Throwable -> 0x005d }
        L_0x0081:
            return r0
        L_0x0082:
            r6 = move-exception
        L_0x0083:
            if (r2 == 0) goto L_0x008d
            r2.close()     // Catch:{ Throwable -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bt.c(android.content.Context, java.lang.String):long");
    }
}
