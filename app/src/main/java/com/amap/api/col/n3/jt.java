package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* compiled from: DynamicExceptionHandler */
public final class jt implements Thread.UncaughtExceptionHandler {
    private static jt a;
    private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;
    private im d;

    private jt(Context context, im imVar) {
        this.c = context.getApplicationContext();
        this.d = imVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized jt a(Context context, im imVar) {
        jt jtVar;
        synchronized (jt.class) {
            if (a == null) {
                a = new jt(context, imVar);
            }
            jtVar = a;
        }
        return jtVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        ja jaVar;
        Context context;
        String str;
        String a2 = in.a(th);
        try {
            if (!TextUtils.isEmpty(a2)) {
                if ((a2.contains("amapdynamic") || a2.contains("admic")) && a2.contains("com.amap.api")) {
                    ja jaVar2 = new ja(this.c, ju.a());
                    if (a2.contains("loc")) {
                        js.a(jaVar2, this.c, "loc");
                    }
                    if (a2.contains("navi")) {
                        js.a(jaVar2, this.c, "navi");
                    }
                    if (a2.contains("sea")) {
                        js.a(jaVar2, this.c, "sea");
                    }
                    if (a2.contains("2dmap")) {
                        js.a(jaVar2, this.c, "2dmap");
                    }
                    if (a2.contains("3dmap")) {
                        js.a(jaVar2, this.c, "3dmap");
                    }
                } else {
                    if (a2.contains("com.autonavi.aps.amapapi.offline")) {
                        jaVar = new ja(this.c, ju.a());
                        context = this.c;
                        str = "OfflineLocation";
                    } else if (a2.contains("com.data.carrier_v4")) {
                        jaVar = new ja(this.c, ju.a());
                        context = this.c;
                        str = "Collection";
                    } else if (a2.contains("com.autonavi.aps.amapapi.httpdns") || a2.contains("com.autonavi.httpdns")) {
                        jaVar = new ja(this.c, ju.a());
                        context = this.c;
                        str = "HttpDNS";
                    }
                    js.a(jaVar, context, str);
                }
            }
        } catch (Throwable th2) {
            ir.a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
