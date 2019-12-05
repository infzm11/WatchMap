package com.amap.api.col.n3;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TaskManager */
public final class av {
    private static av a;
    private ks b;
    private LinkedHashMap<String, kt> c = new LinkedHashMap<>();
    private boolean d = true;

    public static av a() {
        return c();
    }

    private static synchronized av c() {
        av avVar;
        synchronized (av.class) {
            try {
                if (a == null) {
                    a = new av();
                } else if (a.b == null) {
                    a.b = ks.a(1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            avVar = a;
        }
        return avVar;
    }

    private av() {
        try {
            this.b = ks.a(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(au auVar) {
        synchronized (this.c) {
            ar arVar = (ar) this.c.get(auVar.b());
            if (arVar != null) {
                arVar.b();
                this.c.remove(auVar.b());
            }
        }
    }

    public final void a(au auVar, Context context) throws ic {
        ks ksVar = this.b;
        if (!this.c.containsKey(auVar.b())) {
            ar arVar = new ar((bk) auVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.c) {
                this.c.put(auVar.b(), arVar);
            }
        }
        this.b.a(this.c.get(auVar.b()));
    }

    public final void b() {
        synchronized (this.c) {
            if (this.c.size() > 0) {
                for (Map.Entry next : this.c.entrySet()) {
                    next.getKey();
                    ((ar) next.getValue()).b();
                }
                this.c.clear();
            }
        }
        ks ksVar = this.b;
        ks.a();
        this.b = null;
        a = null;
    }

    public final void b(au auVar) {
        ar arVar = (ar) this.c.get(auVar.b());
        if (arVar != null) {
            synchronized (this.c) {
                arVar.c();
                this.c.remove(auVar.b());
            }
        }
    }
}
