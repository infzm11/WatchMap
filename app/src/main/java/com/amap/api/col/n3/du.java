package com.amap.api.col.n3;

import android.content.Context;

/* compiled from: StatisticsUtil */
public final class du {
    public static void a(Context context, boolean z) {
        try {
            String a = a(z);
            kp kpVar = new kp(context, "3dmap", "5.4.0", "O001");
            kpVar.a(a);
            kq.a(kpVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(boolean z) {
        try {
            return "{\"Quest\":" + z + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
