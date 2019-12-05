package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public class bc {

    /* compiled from: ClientInfo */
    private static class a {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;

        private a() {
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = az.e(context);
            return bf.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            bl.a(th, "CInfo", "Scode");
            return null;
        }
    }

    public static String a() {
        String str;
        Throwable th;
        try {
            str = String.valueOf(System.currentTimeMillis());
            String str2 = "1";
            try {
                if (!az.a()) {
                    str2 = "0";
                }
                int length = str.length();
                return str.substring(0, length - 2) + str2 + str.substring(length - 1);
            } catch (Throwable th2) {
                th = th2;
                bl.a(th, "CInfo", "getTS");
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = null;
            th = th4;
            bl.a(th, "CInfo", "getTS");
            return str;
        }
    }

    public static byte[] a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey b = bi.b(context);
        if (b == null) {
            return null;
        }
        byte[] a2 = be.a(encoded, (Key) b);
        byte[] a3 = be.a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        return bArr2;
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return b(context, b(context, z));
        } catch (Throwable th) {
            bl.a(th, "CInfo", "getGZipXInfo");
            return null;
        }
    }

    @Deprecated
    public static String a(Context context, bh bhVar, Map<String, String> map, boolean z) {
        try {
            return a(context, b(context, z));
        } catch (Throwable th) {
            bl.a(th, "CInfo", "rsaLocClineInfo");
            return null;
        }
    }

    public static String b(Context context, byte[] bArr) {
        try {
            return d(context, bArr);
        } catch (Throwable th) {
            bl.a(th, "CInfo", "AESData");
            return "";
        }
    }

    public static byte[] c(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey b = bi.b(context);
        if (bArr.length <= 117) {
            return be.a(bArr, (Key) b);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = be.a(bArr2, (Key) b);
        byte[] bArr3 = new byte[((bArr.length + 128) - 117)];
        System.arraycopy(a2, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    private static String a(Context context, a aVar) {
        return be.a(b(context, aVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2 A[SYNTHETIC, Splitter:B:20:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[SYNTHETIC, Splitter:B:27:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(android.content.Context r3, com.amap.api.services.a.bc.a r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0097, all -> 0x0094 }
            r1.<init>()     // Catch:{ Throwable -> 0x0097, all -> 0x0094 }
            java.lang.String r2 = r4.a     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.b     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.c     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.d     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.e     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.f     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.g     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.h     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.i     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.j     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.k     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.l     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.m     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.n     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.o     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.p     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.q     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.r     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.s     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.t     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.u     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.v     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.w     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r2 = r4.x     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r4 = r4.y     // Catch:{ Throwable -> 0x0092 }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0092 }
            byte[] r3 = a((android.content.Context) r3, (java.io.ByteArrayOutputStream) r1)     // Catch:{ Throwable -> 0x0092 }
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ Throwable -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0091:
            return r3
        L_0x0092:
            r3 = move-exception
            goto L_0x0099
        L_0x0094:
            r3 = move-exception
            r1 = r0
            goto L_0x00ac
        L_0x0097:
            r3 = move-exception
            r1 = r0
        L_0x0099:
            java.lang.String r4 = "CInfo"
            java.lang.String r2 = "InitXInfo"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00aa
            r1.close()     // Catch:{ Throwable -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r3 = move-exception
            r3.printStackTrace()
        L_0x00aa:
            return r0
        L_0x00ab:
            r3 = move-exception
        L_0x00ac:
            if (r1 == 0) goto L_0x00b6
            r1.close()     // Catch:{ Throwable -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00b6:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bc.b(android.content.Context, com.amap.api.services.a.bc$a):byte[]");
    }

    private static byte[] a(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return c(context, bi.b(byteArrayOutputStream.toByteArray()));
    }

    static String d(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        byte[] b = bi.b(a(context, bArr));
        return b != null ? be.a(b) : "";
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                b = -1;
            } else {
                b = (byte) str.getBytes().length;
            }
            bi.a(byteArrayOutputStream, b, bi.a(str));
            return;
        }
        bi.a(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    public static String e(Context context, byte[] bArr) {
        try {
            return d(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static a b(Context context, boolean z) {
        a aVar = new a();
        aVar.a = bd.q(context);
        aVar.b = bd.i(context);
        String f = bd.f(context);
        if (f == null) {
            f = "";
        }
        aVar.c = f;
        aVar.d = az.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = az.b(context);
        aVar.i = az.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = bd.r(context);
        aVar.l = bd.p(context);
        aVar.m = bd.m(context) + "";
        aVar.n = bd.l(context) + "";
        aVar.o = bd.s(context);
        aVar.p = bd.k(context);
        if (z) {
            aVar.q = "";
        } else {
            aVar.q = bd.h(context);
        }
        if (z) {
            aVar.r = "";
        } else {
            aVar.r = bd.g(context);
        }
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] j = bd.j(context);
            aVar.s = j[0];
            aVar.t = j[1];
        }
        aVar.w = bd.a();
        return aVar;
    }
}
