package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public final class an {
    private af a;

    public an(Context context) {
        try {
            this.a = new af(context, af.a((Class<? extends ae>) am.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(String str, Class<? extends ao> cls) {
        this.a.a(ao.c(str), cls);
    }

    public final List<? extends ao> a(int i, Class<? extends ao> cls) {
        try {
            return this.a.b(ao.c(i), cls);
        } catch (Throwable th) {
            w.a(th, "lgd", "bst");
            return null;
        }
    }

    public final void a(ao aoVar) {
        if (aoVar != null) {
            String c = ao.c(aoVar.b());
            List<?> a2 = this.a.a(c, aoVar.getClass(), true);
            if (a2 == null || a2.size() == 0) {
                this.a.b(aoVar);
                return;
            }
            ao aoVar2 = (ao) a2.get(0);
            if (aoVar.a() == 0) {
                aoVar2.b(aoVar2.c() + 1);
            } else {
                aoVar2.b(0);
            }
            this.a.a(c, (Object) aoVar2, true);
        }
    }

    public final void a(String str, Class<? extends ao> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            w.a(th, "lgd", "dl");
        }
    }

    public final void b(ao aoVar) {
        try {
            this.a.a(ao.c(aoVar.b()), (Object) aoVar);
        } catch (Throwable th) {
            w.a(th, "lgd", "ui");
        }
    }

    public final void b(String str, Class<? extends ao> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
