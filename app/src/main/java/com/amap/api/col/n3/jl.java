package com.amap.api.col.n3;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public final class jl {
    private ja a = a(this.b);
    private Context b;

    public jl(Context context) {
        this.b = context;
    }

    private static ja a(Context context) {
        try {
            return new ja(context, ja.a((Class<? extends iz>) jh.class));
        } catch (Throwable th) {
            ir.a(th, "ud", "gd");
            return null;
        }
    }

    public final jm a() {
        try {
            if (this.a == null) {
                this.a = a(this.b);
            }
            List<jm> b2 = this.a.b("1=1", jm.class);
            if (b2.size() > 0) {
                return b2.get(0);
            }
            return null;
        } catch (Throwable th) {
            ir.a(th, "ud", "gd");
            return null;
        }
    }

    public final void a(jm jmVar) {
        if (jmVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                List<jm> b2 = this.a.b("1=1", jm.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        this.a.a("1=1", (Object) jmVar);
                        return;
                    }
                }
                this.a.a(jmVar);
            } catch (Throwable th) {
                ir.a(th, "ud", "ug");
            }
        }
    }
}
