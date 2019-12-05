package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* compiled from: DynamicExceptionHandler */
public class cp implements Thread.UncaughtExceptionHandler {
    private static cp a;
    private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;
    private bh d;

    private cp(Context context, bh bhVar) {
        this.c = context.getApplicationContext();
        this.d = bhVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized cp a(Context context, bh bhVar) {
        cp cpVar;
        synchronized (cp.class) {
            if (a == null) {
                a = new cp(context, bhVar);
            }
            cpVar = a;
        }
        return cpVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Throwable th) {
        String a2 = bi.a(th);
        try {
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if ((a2.contains("amapdynamic") || a2.contains("admic")) && a2.contains("com.amap.api")) {
                bu buVar = new bu(this.c, cq.c());
                if (a2.contains("loc")) {
                    cn.a(buVar, this.c, "loc");
                }
                if (a2.contains("navi")) {
                    cn.a(buVar, this.c, "navi");
                }
                if (a2.contains("sea")) {
                    cn.a(buVar, this.c, "sea");
                }
                if (a2.contains("2dmap")) {
                    cn.a(buVar, this.c, "2dmap");
                }
                if (a2.contains("3dmap")) {
                    cn.a(buVar, this.c, "3dmap");
                }
            } else if (a2.contains("com.autonavi.aps.amapapi.offline")) {
                cn.a(new bu(this.c, cq.c()), this.c, "OfflineLocation");
            } else if (a2.contains("com.data.carrier_v4")) {
                cn.a(new bu(this.c, cq.c()), this.c, "Collection");
            } else if (a2.contains("com.autonavi.aps.amapapi.httpdns") || a2.contains("com.autonavi.httpdns")) {
                cn.a(new bu(this.c, cq.c()), this.c, "HttpDNS");
            }
        } catch (Throwable th2) {
            bl.a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
