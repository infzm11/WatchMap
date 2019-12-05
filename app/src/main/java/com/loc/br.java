package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: StatisticsEntity */
public final class br {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public br(Context context, String str, String str2, String str3) throws j {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new j("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public final void a(String str) throws j {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new j("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[SYNTHETIC, Splitter:B:34:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa A[SYNTHETIC, Splitter:B:40:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
            r8 = this;
            r0 = 0
            byte[] r1 = new byte[r0]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0094 }
            r3.<init>()     // Catch:{ Throwable -> 0x0094 }
            java.lang.String r2 = r8.c     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            com.loc.t.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            java.lang.String r2 = r8.d     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            com.loc.t.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            java.lang.String r2 = r8.b     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            com.loc.t.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            android.content.Context r2 = r8.a     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r2 = com.loc.n.n(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            com.loc.t.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x002e, all -> 0x008c }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            int r2 = (int) r4
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            r4 = 4
            byte[] r4 = new byte[r4]     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r5 = r2 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r4[r0] = r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r5 = r2 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r6 = 1
            r4[r6] = r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r5 = r2 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r7 = 2
            r4[r7] = r5     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r5 = 3
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r4[r5] = r2     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r3.write(r4)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            java.lang.String r2 = r8.e     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            if (r4 == 0) goto L_0x0060
            byte[] r0 = new byte[r7]     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r0 = {0, 0} // fill-array     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            goto L_0x0071
        L_0x0060:
            int r2 = r2.length()     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r4 = r2 / 256
            byte r4 = (byte) r4     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            int r2 = r2 % 256
            byte r2 = (byte) r2     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            byte[] r5 = new byte[r7]     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r5[r0] = r4     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r5[r6] = r2     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r0 = r5
        L_0x0071:
            r3.write(r0)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            java.lang.String r0 = r8.e     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            byte[] r0 = com.loc.t.a((java.lang.String) r0)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            r3.write(r0)     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            byte[] r0 = r3.toByteArray()     // Catch:{ Throwable -> 0x008e, all -> 0x008c }
            if (r3 == 0) goto L_0x00a7
            r3.close()     // Catch:{ Throwable -> 0x0087 }
            return r0
        L_0x0087:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        L_0x008c:
            r0 = move-exception
            goto L_0x00a8
        L_0x008e:
            r0 = move-exception
            r2 = r3
            goto L_0x0095
        L_0x0091:
            r0 = move-exception
            r3 = r2
            goto L_0x00a8
        L_0x0094:
            r0 = move-exception
        L_0x0095:
            java.lang.String r3 = "se"
            java.lang.String r4 = "tds"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x00a6
            r2.close()     // Catch:{ Throwable -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a6:
            r0 = r1
        L_0x00a7:
            return r0
        L_0x00a8:
            if (r3 == 0) goto L_0x00b2
            r3.close()     // Catch:{ Throwable -> 0x00ae }
            goto L_0x00b2
        L_0x00ae:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.br.a():byte[]");
    }
}
