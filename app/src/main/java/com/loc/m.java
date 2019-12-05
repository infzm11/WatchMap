package com.loc;

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
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public final class m {

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

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static String a() {
        String str;
        Throwable th;
        try {
            str = String.valueOf(System.currentTimeMillis());
            String str2 = "1";
            try {
                if (!k.a()) {
                    str2 = "0";
                }
                int length = str.length();
                return str.substring(0, length - 2) + str2 + str.substring(length - 1);
            } catch (Throwable th2) {
                th = th2;
                w.a(th, "CI", "TS");
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = null;
            th = th4;
            w.a(th, "CI", "TS");
            return str;
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = k.e(context);
            return p.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            w.a(th, "CI", "Sco");
            return null;
        }
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            t.a(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, t.a(str));
        } else {
            t.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    public static byte[] a(Context context, boolean z) {
        String str;
        try {
            a aVar = new a((byte) 0);
            aVar.a = n.r(context);
            aVar.b = n.j(context);
            String f = n.f(context);
            if (f == null) {
                f = "";
            }
            aVar.c = f;
            aVar.d = k.c(context);
            aVar.e = Build.MODEL;
            aVar.f = Build.MANUFACTURER;
            aVar.g = Build.DEVICE;
            aVar.h = k.b(context);
            aVar.i = k.d(context);
            aVar.j = String.valueOf(Build.VERSION.SDK_INT);
            aVar.k = n.s(context);
            aVar.l = n.q(context);
            aVar.m = n.n(context);
            aVar.n = n.m(context);
            aVar.o = n.t(context);
            aVar.p = n.l(context);
            aVar.q = z ? "" : n.i(context);
            aVar.r = z ? "" : n.h(context);
            if (z) {
                aVar.s = "";
                str = "";
            } else {
                String[] k = n.k(context);
                aVar.s = k[0];
                str = k[1];
            }
            aVar.t = str;
            aVar.w = n.a();
            aVar.x = "";
            aVar.y = new String(u.a(11)) + n.g(context) + new String(u.a(12)) + n.c();
            return a(aVar);
        } catch (Throwable th) {
            w.a(th, "CI", "gz");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cb A[SYNTHETIC, Splitter:B:23:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d7 A[SYNTHETIC, Splitter:B:31:0x00d7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(com.loc.m.a r7) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
            r1.<init>()     // Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
            java.lang.String r2 = r7.a     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.b     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.c     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.d     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.e     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.g     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.h     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.i     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.j     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.k     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.l     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.m     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.n     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.o     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.p     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.q     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.r     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.s     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.t     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.u     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.v     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.w     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.x     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r7 = r7.y     // Catch:{ Throwable -> 0x00bb }
            a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r7)     // Catch:{ Throwable -> 0x00bb }
            byte[] r7 = r1.toByteArray()     // Catch:{ Throwable -> 0x00bb }
            byte[] r7 = com.loc.t.b((byte[]) r7)     // Catch:{ Throwable -> 0x00bb }
            java.security.PublicKey r2 = com.loc.t.c()     // Catch:{ Throwable -> 0x00bb }
            int r3 = r7.length     // Catch:{ Throwable -> 0x00bb }
            r4 = 117(0x75, float:1.64E-43)
            if (r3 <= r4) goto L_0x00ae
            byte[] r3 = new byte[r4]     // Catch:{ Throwable -> 0x00bb }
            r5 = 0
            java.lang.System.arraycopy(r7, r5, r3, r5, r4)     // Catch:{ Throwable -> 0x00bb }
            byte[] r2 = com.loc.o.a((byte[]) r3, (java.security.Key) r2)     // Catch:{ Throwable -> 0x00bb }
            int r3 = r7.length     // Catch:{ Throwable -> 0x00bb }
            r6 = 128(0x80, float:1.794E-43)
            int r3 = r3 + r6
            int r3 = r3 - r4
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x00bb }
            java.lang.System.arraycopy(r2, r5, r3, r5, r6)     // Catch:{ Throwable -> 0x00bb }
            int r2 = r7.length     // Catch:{ Throwable -> 0x00bb }
            int r2 = r2 - r4
            java.lang.System.arraycopy(r7, r4, r3, r6, r2)     // Catch:{ Throwable -> 0x00bb }
            goto L_0x00b2
        L_0x00ae:
            byte[] r3 = com.loc.o.a((byte[]) r7, (java.security.Key) r2)     // Catch:{ Throwable -> 0x00bb }
        L_0x00b2:
            r1.close()     // Catch:{ Throwable -> 0x00b6 }
            return r3
        L_0x00b6:
            r7 = move-exception
            r7.printStackTrace()
            return r3
        L_0x00bb:
            r7 = move-exception
            goto L_0x00c2
        L_0x00bd:
            r7 = move-exception
            r1 = r0
            goto L_0x00d5
        L_0x00c0:
            r7 = move-exception
            r1 = r0
        L_0x00c2:
            java.lang.String r2 = "ci"
            java.lang.String r3 = "gzx"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x00d3
            r1.close()     // Catch:{ Throwable -> 0x00cf }
            return r0
        L_0x00cf:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00d3:
            return r0
        L_0x00d4:
            r7 = move-exception
        L_0x00d5:
            if (r1 == 0) goto L_0x00df
            r1.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00df:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.m.a(com.loc.m$a):byte[]");
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey c = t.c();
        if (c == null) {
            return null;
        }
        byte[] a2 = o.a(encoded, (Key) c);
        byte[] a3 = o.a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            w.a(th, "ci", "aed");
            return "";
        }
    }

    public static String c(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String d(byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        byte[] b = t.b(a(bArr));
        return b != null ? o.a(b) : "";
    }
}
