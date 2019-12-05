package com.loc;

import android.content.Context;

/* compiled from: RollBackDynamic */
public final class cy {
    static boolean a = false;
    static boolean b = false;
    static boolean c = false;
    static boolean d = false;
    static int e = 0;
    static int f = 0;
    static boolean g = true;
    static boolean h = false;

    public static void a(Context context) {
        try {
            if (e(context) && !a) {
                cz.a(context, "loc", "startMark", cz.b(context, "loc", "startMark", 0) + 1);
                a = true;
            }
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "AddStartMark");
        }
    }

    private static void a(Context context, int i) {
        try {
            if (e(context)) {
                cz.a(context, "loc", "endMark", i);
                cz.a(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "resetMark");
        }
    }

    public static void a(Context context, s sVar) {
        if (!d) {
            c = au.a(context, sVar);
            d = true;
            if (!c && cs.c()) {
                au.a(context, "loc");
                cx.a("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            au.a(context, str);
            cx.a("dexrollbackstatistics", "RollBack because of " + str2);
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }

    public static void b(Context context) {
        try {
            if (e(context) && !b) {
                cz.a(context, "loc", "endMark", cz.b(context, "loc", "endMark", 0) + 1);
                b = true;
            }
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "AddEndMark");
        }
    }

    public static boolean c(Context context) {
        try {
            if (!e(context)) {
                return false;
            }
            if (h) {
                return g;
            }
            if (e == 0) {
                e = cz.b(context, "loc", "startMark", 0);
            }
            if (f == 0) {
                f = cz.b(context, "loc", "endMark", 0);
            }
            if (!a && !b) {
                if (e < f) {
                    a(context, 0);
                    g = true;
                }
                if (e - f > 0 && e > 99) {
                    a(context, 0);
                    g = true;
                }
                if (e - f > 0 && e < 99) {
                    a(context, -2);
                    g = false;
                }
                if (e - f > 0 && f < 0) {
                    a(context, "loc", "checkMark");
                    g = false;
                }
            }
            cz.a(context, "loc", "isload", g);
            h = true;
            return g;
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "checkMark");
        }
    }

    public static boolean d(Context context) {
        try {
            if (!e(context)) {
                return false;
            }
            return cz.b(context, "loc", "isload", false);
        } catch (Throwable th) {
            cs.a(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }

    private static boolean e(Context context) {
        if (!d) {
            a(context, cs.b());
        }
        return c;
    }
}
