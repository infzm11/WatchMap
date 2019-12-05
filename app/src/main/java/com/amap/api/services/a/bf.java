package com.amap.api.services.a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class bf {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A[SYNTHETIC, Splitter:B:31:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006d A[SYNTHETIC, Splitter:B:39:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            if (r1 == 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            boolean r5 = r1.isFile()     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            if (r5 == 0) goto L_0x004e
            boolean r5 = r1.exists()     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            if (r5 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x0051, all -> 0x004f }
        L_0x0029:
            int r1 = r3.read(r5)     // Catch:{ Throwable -> 0x004c }
            r4 = -1
            if (r1 == r4) goto L_0x0035
            r4 = 0
            r2.update(r5, r4, r1)     // Catch:{ Throwable -> 0x004c }
            goto L_0x0029
        L_0x0035:
            byte[] r5 = r2.digest()     // Catch:{ Throwable -> 0x004c }
            java.lang.String r5 = com.amap.api.services.a.bi.d((byte[]) r5)     // Catch:{ Throwable -> 0x004c }
            if (r3 == 0) goto L_0x004b
            r3.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r0 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "getMd5FromFile"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x004b:
            return r5
        L_0x004c:
            r5 = move-exception
            goto L_0x0053
        L_0x004e:
            return r0
        L_0x004f:
            r5 = move-exception
            goto L_0x006b
        L_0x0051:
            r5 = move-exception
            r3 = r0
        L_0x0053:
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "getMd5FromFile"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0068
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r5 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "getMd5FromFile"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0068:
            return r0
        L_0x0069:
            r5 = move-exception
            r0 = r3
        L_0x006b:
            if (r0 == 0) goto L_0x0079
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0079
        L_0x0071:
            r0 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "getMd5FromFile"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0079:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bf.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return bi.d(d(str));
    }

    public static String a(byte[] bArr) {
        return bi.d(b(bArr));
    }

    public static String c(String str) {
        return bi.e(e(str));
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            bl.a(th, "MD5", "getMd5Bytes1");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) {
        return a(bArr, "MD5");
    }

    public static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            bl.a(th, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bi.a(str));
        return instance.digest();
    }
}
