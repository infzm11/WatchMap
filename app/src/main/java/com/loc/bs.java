package com.loc;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsManager */
public final class bs {
    private static boolean a = true;

    public static void a(Context context) {
        try {
            if (c(context)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
                stringBuffer.append(" ");
                stringBuffer.append(UUID.randomUUID().toString());
                stringBuffer.append(" ");
                if (stringBuffer.length() == 53) {
                    byte[] a2 = t.a(stringBuffer.toString());
                    byte[] b = b(context);
                    byte[] a3 = bt.a(context, x.g);
                    byte[] bArr = new byte[(b.length + a3.length)];
                    System.arraycopy(b, 0, bArr, 0, b.length);
                    System.arraycopy(a3, 0, bArr, b.length, a3.length);
                    byte[] a4 = a(bArr);
                    byte[] bArr2 = new byte[(a2.length + a4.length)];
                    System.arraycopy(a2, 0, bArr2, 0, a2.length);
                    System.arraycopy(a4, 0, bArr2, a2.length, a4.length);
                    y yVar = new y(t.c(bArr2), "2");
                    bi.a();
                    bi.a(yVar);
                }
            }
        } catch (Throwable th) {
            w.a(th, "sm", "usd");
        }
    }

    public static synchronized void a(final br brVar, final Context context) {
        synchronized (bs.class) {
            z.b().submit(new Runnable() {
                public final void run() {
                    bt.a(context, x.g, brVar.a());
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r3.size() == 0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        com.loc.z.b().submit(new com.loc.bs.AnonymousClass2());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(final java.util.List<com.loc.br> r3, final android.content.Context r4) {
        /*
            java.lang.Class<com.loc.bs> r0 = com.loc.bs.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            int r1 = r3.size()     // Catch:{ Throwable -> 0x000e }
            if (r1 != 0) goto L_0x000e
            goto L_0x001e
        L_0x000c:
            r3 = move-exception
            goto L_0x001c
        L_0x000e:
            java.util.concurrent.ExecutorService r1 = com.loc.z.b()     // Catch:{ all -> 0x000c }
            com.loc.bs$2 r2 = new com.loc.bs$2     // Catch:{ all -> 0x000c }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x000c }
            r1.submit(r2)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)
            return
        L_0x001c:
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bs.a(java.util.List, android.content.Context):void");
    }

    private static byte[] a(byte[] bArr) {
        try {
            return m.a(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] b(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            t.a(byteArrayOutputStream, "1.2.13.6");
            t.a(byteArrayOutputStream, "Android");
            t.a(byteArrayOutputStream, n.r(context));
            t.a(byteArrayOutputStream, n.j(context));
            t.a(byteArrayOutputStream, n.f(context));
            t.a(byteArrayOutputStream, Build.MANUFACTURER);
            t.a(byteArrayOutputStream, Build.MODEL);
            t.a(byteArrayOutputStream, Build.DEVICE);
            t.a(byteArrayOutputStream, n.s(context));
            t.a(byteArrayOutputStream, k.c(context));
            t.a(byteArrayOutputStream, k.d(context));
            t.a(byteArrayOutputStream, k.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                th.printStackTrace();
                return byteArray;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        throw th;
        return bArr;
    }

    private static boolean c(Context context) {
        try {
            if (n.n(context) != 1 || !a || bt.b(context, x.g) < 30) {
                return false;
            }
            long c = bt.c(context, "c.log");
            long time = new Date().getTime();
            if (time - c < 3600000) {
                return false;
            }
            bt.a(context, time, "c.log");
            a = false;
            return true;
        } catch (Throwable th) {
            w.a(th, "sm", "iud");
        }
        return false;
    }
}
