package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public final class au {
    public static <T> T a(Context context, s sVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws j {
        T a = a(b(context, sVar), str, clsArr, objArr);
        if (a != null) {
            return a;
        }
        T a2 = a(cls, clsArr, objArr);
        if (a2 != null) {
            return a2;
        }
        throw new j("获取对象错误");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0014 A[Catch:{ Throwable -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(com.loc.av r2, java.lang.String r3, java.lang.Class[] r4, java.lang.Object[] r5) {
        /*
            r0 = 1
            if (r2 == 0) goto L_0x0011
            boolean r1 = r2.a()     // Catch:{ Throwable -> 0x000f }
            if (r1 == 0) goto L_0x0011
            boolean r1 = r2.d     // Catch:{ Throwable -> 0x000f }
            if (r1 == 0) goto L_0x0011
            r1 = r0
            goto L_0x0012
        L_0x000f:
            r2 = move-exception
            goto L_0x0026
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x002d
            java.lang.Class r2 = r2.loadClass(r3)     // Catch:{ Throwable -> 0x000f }
            if (r2 == 0) goto L_0x002d
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ Throwable -> 0x000f }
            r2.setAccessible(r0)     // Catch:{ Throwable -> 0x000f }
            java.lang.Object r2 = r2.newInstance(r5)     // Catch:{ Throwable -> 0x000f }
            return r2
        L_0x0026:
            java.lang.String r3 = "IFactory"
            java.lang.String r4 = "getWrap"
            com.loc.w.a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x002d:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.au.a(com.loc.av, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    private static <T> T a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            w.a(th, "IFactory", "gIns2()");
            return null;
        }
    }

    public static void a(Context context, at atVar, s sVar) {
        if (atVar != null) {
            try {
                if (!TextUtils.isEmpty(atVar.a()) && !TextUtils.isEmpty(atVar.b()) && !TextUtils.isEmpty(atVar.c)) {
                    new as(context, atVar, sVar).a();
                }
            } catch (Throwable th) {
                w.a(th, "IFactory", "dDownload()");
            }
        }
    }

    public static void a(final Context context, final String str) {
        try {
            z.b().submit(new Runnable() {
                public final void run() {
                    try {
                        ay.a(new af(context, bb.b()), context, str);
                    } catch (Throwable th) {
                        w.a(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            w.a(th, "InstanceFactory", "rollBack");
        }
    }

    public static boolean a(Context context, s sVar) {
        try {
            File file = new File(ay.b(context, sVar.a(), sVar.b()));
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (!file.exists() && parentFile != null && parentFile.exists()) {
                ay.c(context, sVar.a(), sVar.b());
            }
            return false;
        } catch (Throwable th) {
            w.a(th, "IFactory", "isdowned");
            return false;
        }
    }

    private static av b(Context context, s sVar) {
        try {
            if (a(context, sVar)) {
                return aw.a().a(context, sVar);
            }
        } catch (Throwable th) {
            w.a(th, "IFactory", "gIns1");
        }
        return null;
    }
}
