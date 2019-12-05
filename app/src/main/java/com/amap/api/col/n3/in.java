package com.amap.api.col.n3;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.amap.api.col.n3.im;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Utils */
public final class in {
    static String a;

    public static Parcel a(IBinder iBinder, int i, Parcel parcel) {
        Parcel parcel2;
        try {
            parcel2 = Parcel.obtain();
            try {
                iBinder.transact(i, parcel, parcel2, 0);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            parcel2 = null;
            ir.a(th, "ConfigManager", "getcpu");
            return parcel2;
        }
        return parcel2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x002f
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ Throwable -> 0x0027 }
            java.lang.Class<android.content.pm.ApplicationInfo> r1 = android.content.pm.ApplicationInfo.class
            java.lang.String r1 = r1.getName()     // Catch:{ Throwable -> 0x0027 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Throwable -> 0x0027 }
            java.lang.String r2 = "primaryCpuAbi"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Throwable -> 0x0027 }
            r2 = 1
            r1.setAccessible(r2)     // Catch:{ Throwable -> 0x0027 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Throwable -> 0x0027 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x0027 }
            goto L_0x0030
        L_0x0027:
            r3 = move-exception
            java.lang.String r1 = "ut"
            java.lang.String r2 = "gct"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r3, (java.lang.String) r1, (java.lang.String) r2)
        L_0x002f:
            r3 = r0
        L_0x0030:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0038
            java.lang.String r3 = android.os.Build.CPU_ABI
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.in.a(android.content.Context):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static im a() throws ic {
        return new im.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            a(byteArrayOutputStream, (byte) length, a(str));
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            byte b2 = b & 255;
            if (b2 < 255 && b2 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (b2 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            ir.a((Throwable) e, "Utils", "writeField");
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String b = ii.b(a(str));
        try {
            return ((char) ((b.length() % 26) + 65)) + b;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        if (str.length() < 2) {
            return "";
        }
        return ii.a(str.substring(1));
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] b() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(ii.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            ir.a(th, "Utils", "getIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0049 A[SYNTHETIC, Splitter:B:33:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[SYNTHETIC, Splitter:B:38:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A[SYNTHETIC, Splitter:B:45:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0069 A[SYNTHETIC, Splitter:B:50:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
            r0 = 0
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            r1.<init>()     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            r3.printStackTrace(r2)     // Catch:{ Throwable -> 0x0035 }
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ Throwable -> 0x0035 }
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            r3.printStackTrace(r2)     // Catch:{ Throwable -> 0x0035 }
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ Throwable -> 0x0035 }
            goto L_0x0012
        L_0x001c:
            java.lang.String r3 = r1.toString()     // Catch:{ Throwable -> 0x0035 }
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ Throwable -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ Throwable -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0034:
            return r3
        L_0x0035:
            r3 = move-exception
            goto L_0x0044
        L_0x0037:
            r3 = move-exception
            r2 = r0
            goto L_0x005d
        L_0x003a:
            r3 = move-exception
            r2 = r0
            goto L_0x0044
        L_0x003d:
            r3 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x005d
        L_0x0041:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x0044:
            r3.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Throwable -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0051:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ Throwable -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005b:
            return r0
        L_0x005c:
            r3 = move-exception
        L_0x005d:
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ Throwable -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0067:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ Throwable -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.in.a(java.lang.Throwable):java.lang.String");
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry next : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) next.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) next.getValue());
                }
            }
        } catch (Throwable th) {
            ir.a(th, "Utils", "assembleParams");
        }
        return stringBuffer.toString();
    }

    public static String b(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
            str = sb.toString();
        } else {
            str = null;
        }
        return d(str);
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            ir.a(th, "Utils", "sortParams");
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ir.a(th, "Utils", "gZip");
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[SYNTHETIC, Splitter:B:38:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007d A[SYNTHETIC, Splitter:B:45:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008b A[SYNTHETIC, Splitter:B:50:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0098
            int r1 = r5.length
            if (r1 != 0) goto L_0x0008
            goto L_0x0098
        L_0x0008:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0052, all -> 0x004e }
            r1.<init>()     // Catch:{ Throwable -> 0x0052, all -> 0x004e }
            java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream     // Catch:{ Throwable -> 0x004b, all -> 0x0048 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x004b, all -> 0x0048 }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ Throwable -> 0x0046 }
            java.lang.String r4 = "log"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0046 }
            r2.putNextEntry(r3)     // Catch:{ Throwable -> 0x0046 }
            r2.write(r5)     // Catch:{ Throwable -> 0x0046 }
            r2.closeEntry()     // Catch:{ Throwable -> 0x0046 }
            r2.finish()     // Catch:{ Throwable -> 0x0046 }
            byte[] r5 = r1.toByteArray()     // Catch:{ Throwable -> 0x0046 }
            if (r2 == 0) goto L_0x0037
            r2.close()     // Catch:{ Throwable -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r0 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip1"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0037:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ Throwable -> 0x003d }
            goto L_0x0079
        L_0x003d:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "zip2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0079
        L_0x0046:
            r5 = move-exception
            goto L_0x0055
        L_0x0048:
            r5 = move-exception
            r2 = r0
            goto L_0x007b
        L_0x004b:
            r5 = move-exception
            r2 = r0
            goto L_0x0055
        L_0x004e:
            r5 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x007b
        L_0x0052:
            r5 = move-exception
            r1 = r0
            r2 = r1
        L_0x0055:
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ Throwable -> 0x0062 }
            goto L_0x006a
        L_0x0062:
            r5 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip1"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)
        L_0x006a:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r5 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "zip2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0078:
            r5 = r0
        L_0x0079:
            return r5
        L_0x007a:
            r5 = move-exception
        L_0x007b:
            if (r2 == 0) goto L_0x0089
            r2.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x0089
        L_0x0081:
            r0 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip1"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0089:
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ Throwable -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "zip2"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0097:
            throw r5
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.in.c(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC, Splitter:B:30:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0060 A[SYNTHETIC, Splitter:B:37:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.PublicKey c() throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        /*
            java.lang.String r0 = "MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="
            r1 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Throwable -> 0x004d, all -> 0x004a }
            byte[] r0 = com.amap.api.col.n3.ii.b((java.lang.String) r0)     // Catch:{ Throwable -> 0x004d, all -> 0x004a }
            r2.<init>(r0)     // Catch:{ Throwable -> 0x004d, all -> 0x004a }
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ Throwable -> 0x0048 }
            java.lang.String r3 = "RSA"
            java.security.KeyFactory r3 = java.security.KeyFactory.getInstance(r3)     // Catch:{ Throwable -> 0x0048 }
            java.security.cert.Certificate r0 = r0.generateCertificate(r2)     // Catch:{ Throwable -> 0x0048 }
            if (r0 == 0) goto L_0x003d
            if (r3 != 0) goto L_0x0021
            goto L_0x003d
        L_0x0021:
            java.security.spec.X509EncodedKeySpec r4 = new java.security.spec.X509EncodedKeySpec     // Catch:{ Throwable -> 0x0048 }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ Throwable -> 0x0048 }
            byte[] r0 = r0.getEncoded()     // Catch:{ Throwable -> 0x0048 }
            r4.<init>(r0)     // Catch:{ Throwable -> 0x0048 }
            java.security.PublicKey r0 = r3.generatePublic(r4)     // Catch:{ Throwable -> 0x0048 }
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ Throwable -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003c:
            return r0
        L_0x003d:
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ Throwable -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0047:
            return r1
        L_0x0048:
            r0 = move-exception
            goto L_0x004f
        L_0x004a:
            r0 = move-exception
            r2 = r1
            goto L_0x005e
        L_0x004d:
            r0 = move-exception
            r2 = r1
        L_0x004f:
            r0.printStackTrace()     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Throwable -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005c:
            return r1
        L_0x005d:
            r0 = move-exception
        L_0x005e:
            if (r2 == 0) goto L_0x0068
            r2.close()     // Catch:{ Throwable -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0068:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.in.c():java.security.PublicKey");
    }

    static String d(byte[] bArr) {
        try {
            return f(bArr);
        } catch (Throwable th) {
            ir.a(th, "Utils", "HexString");
            return null;
        }
    }

    static String e(byte[] bArr) {
        try {
            return f(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x003e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0046 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] g(byte[] r3) throws java.io.IOException, java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            r1.<init>()     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x002f, all -> 0x002d }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x002f, all -> 0x002d }
            r2.write(r3)     // Catch:{ Throwable -> 0x002b, all -> 0x0029 }
            r2.finish()     // Catch:{ Throwable -> 0x002b, all -> 0x0029 }
            byte[] r3 = r1.toByteArray()     // Catch:{ Throwable -> 0x002b, all -> 0x0029 }
            if (r2 == 0) goto L_0x0020
            r2.close()     // Catch:{ Throwable -> 0x001e }
            goto L_0x0020
        L_0x001e:
            r3 = move-exception
            throw r3
        L_0x0020:
            if (r1 == 0) goto L_0x0028
            r1.close()     // Catch:{ Throwable -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r3 = move-exception
            throw r3
        L_0x0028:
            return r3
        L_0x0029:
            r3 = move-exception
            goto L_0x003b
        L_0x002b:
            r3 = move-exception
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            goto L_0x003c
        L_0x002f:
            r3 = move-exception
            r2 = r0
        L_0x0031:
            r0 = r1
            goto L_0x0038
        L_0x0033:
            r3 = move-exception
            r1 = r0
            goto L_0x003c
        L_0x0036:
            r3 = move-exception
            r2 = r0
        L_0x0038:
            throw r3     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r3 = move-exception
            r1 = r0
        L_0x003b:
            r0 = r2
        L_0x003c:
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ Throwable -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            r3 = move-exception
            throw r3
        L_0x0044:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ Throwable -> 0x004a }
            goto L_0x004c
        L_0x004a:
            r3 = move-exception
            throw r3
        L_0x004c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.in.g(byte[]):byte[]");
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        a = sb.toString();
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3 = "";
        String b = ij.b(id.e(context));
        String str4 = "";
        String str5 = "";
        String a2 = id.a(context);
        String str6 = "";
        try {
            if (jSONObject.has("info")) {
                str3 = jSONObject.getString("info");
                "请在高德开放平台官网中搜索\"" + str3 + "\"相关内容进行解决";
            }
            if ("INVALID_USER_SCODE".equals(str3)) {
                if (jSONObject.has("sec_code")) {
                    str4 = jSONObject.getString("sec_code");
                }
                if (jSONObject.has("sec_code_debug")) {
                    str5 = jSONObject.getString("sec_code_debug");
                }
                if (!b.equals(str4)) {
                    boolean equals = b.equals(str5);
                }
            } else if ("INVALID_USER_KEY".equals(str3)) {
                if (jSONObject.has("key")) {
                    str6 = jSONObject.getString("key");
                }
                if (str6.length() > 0) {
                    a2.equals(str6);
                }
            }
        } catch (Throwable unused) {
        }
        String str7 = a;
        String str8 = a;
        e("SHA1Package:" + r1);
        e("key:" + a2);
        e("csid:" + str);
        e("gsid:" + str2);
        e("json:" + jSONObject.toString());
        String str9 = a;
    }

    private static void e(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            "|" + substring + "|";
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        sb.toString();
    }
}
