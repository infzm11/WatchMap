package com.amap.api.services.a;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public class cc {
    private bu a;

    public cc(Context context) {
        try {
            this.a = new bu(context, bu.a((Class<? extends bt>) cb.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str, Class<? extends cd> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            bl.a(th, "LogDB", "delLog");
        }
    }

    public void b(String str, Class<? extends cd> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(String str, Class<? extends cd> cls) {
        this.a.a(cd.c(str), cls);
    }

    public List<? extends cd> a(int i, Class<? extends cd> cls) {
        try {
            return this.a.b(cd.c(i), cls);
        } catch (Throwable th) {
            bl.a(th, "LogDB", "ByState");
            return null;
        }
    }

    public void a(cd cdVar) {
        if (cdVar != null) {
            String c = cd.c(cdVar.b());
            List<?> a2 = this.a.a(c, cdVar.getClass(), true);
            if (a2 == null || a2.size() == 0) {
                this.a.a(cdVar, true);
                return;
            }
            cd cdVar2 = (cd) a2.get(0);
            if (cdVar.a() == 0) {
                cdVar2.b(cdVar2.c() + 1);
            } else {
                cdVar2.b(0);
            }
            this.a.a(c, (Object) cdVar2, true);
        }
    }

    public void b(cd cdVar) {
        try {
            this.a.a(cd.c(cdVar.b()), (Object) cdVar);
        } catch (Throwable th) {
            bl.a(th, "LogDB", "updateLogInfo");
        }
    }
}
