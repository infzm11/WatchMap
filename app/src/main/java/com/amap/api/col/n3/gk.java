package com.amap.api.col.n3;

/* compiled from: CoreUtil */
public final class gk {
    public static void a(Throwable th, String str, String str2) {
        try {
            iu a = iu.a();
            if (a != null) {
                a.c(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
