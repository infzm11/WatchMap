package com.amap.api.col.n3;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsManager */
public final class kq {
    private static boolean a = true;

    public static synchronized void a(final kp kpVar, final Context context) {
        synchronized (kq.class) {
            iu.c().submit(new Runnable() {
                public final void run() {
                    kr.a(context, is.g, kpVar.a());
                }
            });
        }
    }

    public static void a(Context context) {
        try {
            if (c(context)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
                stringBuffer.append(" ");
                stringBuffer.append(UUID.randomUUID().toString());
                stringBuffer.append(" ");
                if (stringBuffer.length() == 53) {
                    byte[] a2 = in.a(stringBuffer.toString());
                    byte[] b = b(context);
                    byte[] a3 = kr.a(context, is.g);
                    byte[] bArr = new byte[(b.length + a3.length)];
                    System.arraycopy(b, 0, bArr, 0, b.length);
                    System.arraycopy(a3, 0, bArr, b.length, a3.length);
                    byte[] a4 = a(bArr);
                    byte[] bArr2 = new byte[(a2.length + a4.length)];
                    System.arraycopy(a2, 0, bArr2, 0, a2.length);
                    System.arraycopy(a4, 0, bArr2, a2.length, a4.length);
                    kd.a().a(new it(in.c(bArr2), "2"));
                }
            }
        } catch (Throwable th) {
            ir.a(th, "sm", "usd");
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            return ig.a(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] b(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            in.a(byteArrayOutputStream, "1.2.13.6");
            in.a(byteArrayOutputStream, "Android");
            in.a(byteArrayOutputStream, ih.q(context));
            in.a(byteArrayOutputStream, ih.j(context));
            in.a(byteArrayOutputStream, ih.f(context));
            in.a(byteArrayOutputStream, Build.MANUFACTURER);
            in.a(byteArrayOutputStream, Build.MODEL);
            in.a(byteArrayOutputStream, Build.DEVICE);
            in.a(byteArrayOutputStream, ih.r(context));
            in.a(byteArrayOutputStream, id.c(context));
            in.a(byteArrayOutputStream, id.d(context));
            in.a(byteArrayOutputStream, id.f(context));
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
            if (ih.n(context) != 1 || !a || kr.b(context, is.g) < 30) {
                return false;
            }
            long c = kr.c(context, "c.log");
            long time = new Date().getTime();
            if (time - c < 3600000) {
                return false;
            }
            kr.a(context, time, "c.log");
            a = false;
            return true;
        } catch (Throwable th) {
            ir.a(th, "sm", "iud");
        }
        return false;
    }
}
