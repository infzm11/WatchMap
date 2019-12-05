package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsManager */
public class dj {
    private static boolean a = true;

    public static synchronized void a(final di diVar, final Context context) {
        synchronized (dj.class) {
            bo.b().submit(new Runnable() {
                public void run() {
                    dk.a(context, bm.g, 307200, diVar.a());
                }
            });
        }
    }

    private static byte[] b(Context context) {
        byte[] c = c(context);
        byte[] d = d(context);
        byte[] bArr = new byte[(c.length + d.length)];
        System.arraycopy(c, 0, bArr, 0, c.length);
        System.arraycopy(d, 0, bArr, c.length, d.length);
        return a(context, bArr);
    }

    public static void a(Context context) {
        try {
            if (e(context)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
                stringBuffer.append(" ");
                stringBuffer.append(UUID.randomUUID().toString());
                stringBuffer.append(" ");
                if (stringBuffer.length() == 53) {
                    byte[] a2 = bi.a(stringBuffer.toString());
                    byte[] b = b(context);
                    byte[] bArr = new byte[(a2.length + b.length)];
                    System.arraycopy(a2, 0, bArr, 0, a2.length);
                    System.arraycopy(b, 0, bArr, a2.length, b.length);
                    cx.a().a(new bn(bi.c(bArr), "2"));
                }
            }
        } catch (Throwable th) {
            bl.a(th, "StatisticsManager", "updateStaticsData");
        }
    }

    private static byte[] a(Context context, byte[] bArr) {
        try {
            return bc.a(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            bi.a(byteArrayOutputStream, "1.2.13.6");
            bi.a(byteArrayOutputStream, "Android");
            bi.a(byteArrayOutputStream, bd.q(context));
            bi.a(byteArrayOutputStream, bd.i(context));
            bi.a(byteArrayOutputStream, bd.f(context));
            bi.a(byteArrayOutputStream, Build.MANUFACTURER);
            bi.a(byteArrayOutputStream, Build.MODEL);
            bi.a(byteArrayOutputStream, Build.DEVICE);
            bi.a(byteArrayOutputStream, bd.r(context));
            bi.a(byteArrayOutputStream, az.c(context));
            bi.a(byteArrayOutputStream, az.d(context));
            bi.a(byteArrayOutputStream, az.f(context));
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

    private static byte[] d(Context context) {
        return dk.a(context, bm.g, 307200);
    }

    private static boolean e(Context context) {
        try {
            if (bd.m(context) != 1 || !a || dk.a(context, bm.g) < 30) {
                return false;
            }
            long b = dk.b(context, "c.log");
            long time = new Date().getTime();
            if (time - b < 3600000) {
                return false;
            }
            dk.a(context, time, "c.log");
            a = false;
            return true;
        } catch (Throwable th) {
            bl.a(th, "StatisticsManager", "isUpdate");
        }
        return false;
    }
}
