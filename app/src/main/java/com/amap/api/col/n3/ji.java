package com.amap.api.col.n3;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public final class ji {
    private ja a;

    public ji(Context context) {
        try {
            this.a = new ja(context, ja.a((Class<? extends iz>) jh.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str, Class<? extends jj> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            ir.a(th, "lgd", "dl");
        }
    }

    public final void b(String str, Class<? extends jj> cls) {
        try {
            c(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(String str, Class<? extends jj> cls) {
        this.a.a(jj.c(str), cls);
    }

    public final List<? extends jj> a(int i, Class<? extends jj> cls) {
        try {
            return this.a.b(jj.c(i), cls);
        } catch (Throwable th) {
            ir.a(th, "lgd", "bst");
            return null;
        }
    }

    public final void a(jj jjVar) {
        if (jjVar != null) {
            String c = jj.c(jjVar.b());
            List<?> a2 = this.a.a(c, jjVar.getClass(), true);
            if (a2 == null || a2.size() == 0) {
                this.a.b(jjVar);
                return;
            }
            jj jjVar2 = (jj) a2.get(0);
            if (jjVar.a() == 0) {
                jjVar2.b(jjVar2.c() + 1);
            } else {
                jjVar2.b(0);
            }
            this.a.a(c, (Object) jjVar2, true);
        }
    }

    public final void b(jj jjVar) {
        try {
            this.a.a(jj.c(jjVar.b()), (Object) jjVar);
        } catch (Throwable th) {
            ir.a(th, "lgd", "ui");
        }
    }
}
