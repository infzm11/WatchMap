package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: StatisticsEntity */
public class di {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public di(Context context, String str, String str2, String str3) throws ay {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new ay("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public void a(String str) throws ay {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new ay("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        int length = str.length();
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A[SYNTHETIC, Splitter:B:20:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085 A[SYNTHETIC, Splitter:B:26:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a() {
        /*
            r6 = this;
            r0 = 0
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r2.<init>()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            java.lang.String r1 = r6.c     // Catch:{ Throwable -> 0x0067 }
            com.amap.api.services.a.bi.a((java.io.ByteArrayOutputStream) r2, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r1 = r6.d     // Catch:{ Throwable -> 0x0067 }
            com.amap.api.services.a.bi.a((java.io.ByteArrayOutputStream) r2, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r1 = r6.b     // Catch:{ Throwable -> 0x0067 }
            com.amap.api.services.a.bi.a((java.io.ByteArrayOutputStream) r2, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0067 }
            android.content.Context r1 = r6.a     // Catch:{ Throwable -> 0x0067 }
            int r1 = com.amap.api.services.a.bd.m(r1)     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0067 }
            com.amap.api.services.a.bi.a((java.io.ByteArrayOutputStream) r2, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0067 }
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r3 = "SSS"
            r1.<init>(r3)     // Catch:{ Throwable -> 0x0067 }
            java.util.Date r3 = new java.util.Date     // Catch:{ Throwable -> 0x0067 }
            r3.<init>()     // Catch:{ Throwable -> 0x0067 }
            r1.format(r3)     // Catch:{ Throwable -> 0x0067 }
            java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ Throwable -> 0x0067 }
            r3 = 14
            int r1 = r1.get(r3)     // Catch:{ Throwable -> 0x0067 }
            byte[] r1 = r6.a((int) r1)     // Catch:{ Throwable -> 0x0067 }
            r2.write(r1)     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r1 = r6.e     // Catch:{ Throwable -> 0x0067 }
            byte[] r1 = r6.b(r1)     // Catch:{ Throwable -> 0x0067 }
            r2.write(r1)     // Catch:{ Throwable -> 0x0067 }
            java.lang.String r1 = r6.e     // Catch:{ Throwable -> 0x0067 }
            byte[] r1 = com.amap.api.services.a.bi.a((java.lang.String) r1)     // Catch:{ Throwable -> 0x0067 }
            r2.write(r1)     // Catch:{ Throwable -> 0x0067 }
            byte[] r1 = r2.toByteArray()     // Catch:{ Throwable -> 0x0067 }
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ Throwable -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0065:
            r0 = r1
            goto L_0x0081
        L_0x0067:
            r1 = move-exception
            goto L_0x0070
        L_0x0069:
            r0 = move-exception
            r2 = r1
            goto L_0x0083
        L_0x006c:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0070:
            java.lang.String r3 = "StatisticsEntity"
            java.lang.String r4 = "toDatas"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Throwable -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0081:
            return r0
        L_0x0082:
            r0 = move-exception
        L_0x0083:
            if (r2 == 0) goto L_0x008d
            r2.close()     // Catch:{ Throwable -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r1 = move-exception
            r1.printStackTrace()
        L_0x008d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.di.a():byte[]");
    }
}
