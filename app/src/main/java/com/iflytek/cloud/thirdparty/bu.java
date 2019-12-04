package com.iflytek.cloud.thirdparty;

import java.security.MessageDigest;

public class bu {
    public static synchronized String a(String str) {
        String stringBuffer;
        synchronized (bu.class) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    bArr[i] = (byte) charArray[i];
                }
                byte[] digest = instance.digest(bArr);
                StringBuffer stringBuffer2 = new StringBuffer();
                for (byte b : digest) {
                    byte b2 = b & 255;
                    if (b2 < 16) {
                        stringBuffer2.append("0");
                    }
                    stringBuffer2.append(Integer.toHexString(b2));
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e) {
                cb.a((Throwable) e);
                return "";
            }
        }
        return stringBuffer;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 5);
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b2, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b4, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String b(java.lang.String r6) {
        /*
            java.lang.Class<com.iflytek.cloud.thirdparty.bu> r0 = com.iflytek.cloud.thirdparty.bu.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r1.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "cut16MD5 start:"
            r1.append(r2)     // Catch:{ all -> 0x00b5 }
            r1.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = a((java.lang.String) r6)     // Catch:{ all -> 0x00b5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r1.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "cut16MD5 start:"
            r1.append(r2)     // Catch:{ all -> 0x00b5 }
            r1.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ all -> 0x00b5 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x00b5 }
            r1.<init>()     // Catch:{ all -> 0x00b5 }
            r2 = 0
            if (r6 == 0) goto L_0x00b3
            int r3 = r6.length()     // Catch:{ all -> 0x00b5 }
            if (r3 != 0) goto L_0x003e
            goto L_0x00b3
        L_0x003e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r3.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "cut16MD5 md5 size is:"
            r3.append(r4)     // Catch:{ all -> 0x00b5 }
            int r4 = r6.length()     // Catch:{ all -> 0x00b5 }
            r3.append(r4)     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ all -> 0x00b5 }
            r3 = 0
        L_0x0057:
            int r4 = r6.length()     // Catch:{ all -> 0x00b5 }
            if (r3 >= r4) goto L_0x0097
            int r4 = r3 % 2
            if (r4 != 0) goto L_0x0080
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r4.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "cut16MD5 result i:"
            r4.append(r5)     // Catch:{ all -> 0x00b5 }
            char r5 = r6.charAt(r3)     // Catch:{ all -> 0x00b5 }
            r4.append(r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r4)     // Catch:{ all -> 0x00b5 }
            char r4 = r6.charAt(r3)     // Catch:{ all -> 0x00b5 }
            r1.append(r4)     // Catch:{ all -> 0x00b5 }
        L_0x0080:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r4.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "cut16MD5 result i = :"
            r4.append(r5)     // Catch:{ all -> 0x00b5 }
            r4.append(r3)     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r4)     // Catch:{ all -> 0x00b5 }
            int r3 = r3 + 1
            goto L_0x0057
        L_0x0097:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r6.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "cut16MD5 result:"
            r6.append(r3)     // Catch:{ all -> 0x00b5 }
            r6.append(r1)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b5 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r6)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00b1
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x00b5 }
        L_0x00b1:
            monitor-exit(r0)
            return r2
        L_0x00b3:
            monitor-exit(r0)
            return r2
        L_0x00b5:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bu.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        r4 = r2;
        r2 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x005f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0063, code lost:
        com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0072, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0076, code lost:
        com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0057 A[SYNTHETIC, Splitter:B:40:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A[Catch:{ IOException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x006a A[SYNTHETIC, Splitter:B:49:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0072 A[Catch:{ IOException -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0050 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0050 }
            r2.write(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.finish()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r3 = 19
            if (r5 >= r3) goto L_0x001d
            r2.flush()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
        L_0x001d:
            byte[] r5 = r1.toByteArray()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r0 = 0
        L_0x0022:
            int r3 = r5.length     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            if (r0 >= r3) goto L_0x002f
            byte r3 = r5[r0]     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            r3 = r3 ^ 5
            byte r3 = (byte) r3     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            r5[r0] = r3     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            int r0 = r0 + 1
            goto L_0x0022
        L_0x002f:
            if (r2 == 0) goto L_0x0037
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            r0 = move-exception
            goto L_0x003d
        L_0x0037:
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ IOException -> 0x0035 }
            return r5
        L_0x003d:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r0)
            return r5
        L_0x0041:
            r0 = move-exception
            r4 = r2
            r2 = r5
            r5 = r0
            goto L_0x004b
        L_0x0046:
            r5 = move-exception
            goto L_0x0068
        L_0x0048:
            r5 = move-exception
            r4 = r2
            r2 = r0
        L_0x004b:
            r0 = r4
            goto L_0x0052
        L_0x004d:
            r5 = move-exception
            r2 = r0
            goto L_0x0068
        L_0x0050:
            r5 = move-exception
            r2 = r0
        L_0x0052:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r5 = move-exception
            goto L_0x0063
        L_0x005d:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0066
        L_0x0063:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r5)
        L_0x0066:
            r5 = r2
        L_0x0067:
            return r5
        L_0x0068:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0070
        L_0x006e:
            r0 = move-exception
            goto L_0x0076
        L_0x0070:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0079
        L_0x0076:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r0)
        L_0x0079:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bu.b(byte[]):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        r7 = r1;
        r1 = r0;
        r0 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0056, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0070, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0075, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0079, code lost:
        com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0084, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0088, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x008d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0091, code lost:
        com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0068 A[SYNTHETIC, Splitter:B:43:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0070 A[Catch:{ IOException -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0075 A[Catch:{ IOException -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0080 A[SYNTHETIC, Splitter:B:54:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0088 A[Catch:{ IOException -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x008d A[Catch:{ IOException -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r2 = r1
        L_0x0006:
            int r3 = r8.length
            if (r2 >= r3) goto L_0x0013
            byte r3 = r8[r2]
            r3 = r3 ^ 5
            byte r3 = (byte) r3
            r8[r2] = r3
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0013:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r8)
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0061 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0061 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
        L_0x0026:
            int r5 = r4.length     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            int r5 = r3.read(r4, r1, r5)     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            r6 = -1
            if (r5 == r6) goto L_0x0032
            r8.write(r4, r1, r5)     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            goto L_0x0026
        L_0x0032:
            byte[] r1 = r8.toByteArray()     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            r8.flush()     // Catch:{ IOException -> 0x0050, all -> 0x0056 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0041
        L_0x003f:
            r8 = move-exception
            goto L_0x004c
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x0046:
            if (r8 == 0) goto L_0x007d
            r8.close()     // Catch:{ IOException -> 0x003f }
            return r1
        L_0x004c:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8)
            return r1
        L_0x0050:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r3
            r3 = r7
            goto L_0x0063
        L_0x0056:
            r0 = move-exception
            goto L_0x007e
        L_0x0058:
            r1 = move-exception
            r7 = r3
            r3 = r0
            r0 = r7
            goto L_0x0063
        L_0x005d:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x007e
        L_0x0061:
            r1 = move-exception
            r3 = r0
        L_0x0063:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r8 = move-exception
            goto L_0x0079
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x006c }
        L_0x0073:
            if (r8 == 0) goto L_0x007c
            r8.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x007c
        L_0x0079:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8)
        L_0x007c:
            r1 = r3
        L_0x007d:
            return r1
        L_0x007e:
            if (r3 == 0) goto L_0x0086
            r3.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0086
        L_0x0084:
            r8 = move-exception
            goto L_0x0091
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x0084 }
        L_0x008b:
            if (r8 == 0) goto L_0x0094
            r8.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0094
        L_0x0091:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8)
        L_0x0094:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bu.c(byte[]):byte[]");
    }
}
