package com.amap.api.services.a;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public class cj {
    public static <T> T a(Context context, bh bhVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws ay {
        T a = a(b(context, bhVar), str, clsArr, objArr);
        if (a != null) {
            return a;
        }
        T a2 = a(cls, clsArr, objArr);
        if (a2 != null) {
            return a2;
        }
        throw new ay("获取对象错误");
    }

    public static boolean a(Context context, bh bhVar) {
        try {
            File file = new File(cn.b(context, bhVar.a(), bhVar.b()));
            if (file.exists()) {
                return true;
            }
            cn.a(context, file, bhVar);
            return false;
        } catch (Throwable th) {
            cs.a(th, "IFactory", "isdowned");
            return false;
        }
    }

    private static ck b(Context context, bh bhVar) {
        try {
            if (a(context, bhVar)) {
                return cl.a().a(context, bhVar);
            }
            return null;
        } catch (Throwable th) {
            cs.a(th, "IFactory", "gIns1");
            return null;
        }
    }

    private static boolean a(ck ckVar) {
        return ckVar != null && ckVar.a() && ckVar.d;
    }

    private static <T> T a(ck ckVar, String str, Class[] clsArr, Object[] objArr) {
        try {
            if (!a(ckVar)) {
                return null;
            }
            Class loadClass = ckVar.loadClass(str);
            if (loadClass == null) {
                return null;
            }
            Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            cs.a(th, "IFactory", "getWrap");
            return null;
        }
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
            cs.a(th, "IFactory", "gIns2()");
            return null;
        }
    }
}
