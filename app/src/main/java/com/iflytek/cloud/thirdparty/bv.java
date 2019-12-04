package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.record.d;
import java.io.File;
import java.io.IOException;

public class bv {
    private static String a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str = absolutePath + "msclib/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        a = str;
        return a;
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC, Splitter:B:32:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004e A[SYNTHETIC, Splitter:B:37:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.os.MemoryFile r8, long r9, java.lang.String r11) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0052
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 == 0) goto L_0x000a
            return r0
        L_0x000a:
            r1 = 0
            a((java.lang.String) r11)     // Catch:{ Exception -> 0x0042 }
            b(r11)     // Catch:{ Exception -> 0x0042 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0042 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0042 }
            r11 = 65536(0x10000, float:9.18355E-41)
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r1 = r0
        L_0x001b:
            long r3 = (long) r1     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x0033
            long r3 = r9 - r3
            r5 = 65536(0x10000, double:3.2379E-319)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002a
            r3 = r5
        L_0x002a:
            int r3 = (int) r3     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r8.readBytes(r11, r1, r0, r3)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r2.write(r11, r0, r3)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            int r1 = r1 + r3
            goto L_0x001b
        L_0x0033:
            r0 = 1
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ Exception -> 0x004b }
            return r0
        L_0x003a:
            r8 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x003d:
            r8 = move-exception
            r1 = r2
            goto L_0x0043
        L_0x0040:
            r8 = move-exception
            goto L_0x004c
        L_0x0042:
            r8 = move-exception
        L_0x0043:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r8)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            return r0
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            throw r8
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bv.a(android.os.MemoryFile, long, java.lang.String):boolean");
    }

    public static boolean a(String str, int i) {
        try {
            d dVar = new d(new File(str), i);
            dVar.b();
            dVar.c();
            return true;
        } catch (IOException e) {
            cb.a((Throwable) e);
            return false;
        }
    }

    public static boolean a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || "pcm".equals(str)) {
            return true;
        }
        if ("wav".equals(str)) {
            return a(str2, i);
        }
        cb.c("format not supported");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC, Splitter:B:19:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC, Splitter:B:24:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.concurrent.ConcurrentLinkedQueue<byte[]> r2, java.lang.String r3) {
        /*
            r0 = 0
            b(r3)     // Catch:{ Exception -> 0x002a }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002a }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
        L_0x000d:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            if (r3 == 0) goto L_0x001d
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r1.write(r3)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            goto L_0x000d
        L_0x001d:
            r1.close()     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r2 = 1
            return r2
        L_0x0022:
            r2 = move-exception
            goto L_0x003a
        L_0x0024:
            r2 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x0027:
            r2 = move-exception
            r1 = r0
            goto L_0x003a
        L_0x002a:
            r2 = move-exception
        L_0x002b:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r2 = move-exception
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r2)
        L_0x0038:
            r2 = 0
            return r2
        L_0x003a:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r3 = move-exception
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r3)
        L_0x0044:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bv.a(java.util.concurrent.ConcurrentLinkedQueue, java.lang.String):boolean");
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!str.endsWith("/")) {
                file = file.getParentFile();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }
}
