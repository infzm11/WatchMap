package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public final class aq {
    private af a = a(this.b);
    private Context b;

    public aq(Context context) {
        this.b = context;
    }

    private static af a(Context context) {
        try {
            return new af(context, af.a((Class<? extends ae>) am.class));
        } catch (Throwable th) {
            w.a(th, "ud", "gd");
            return null;
        }
    }

    public final ar a() {
        try {
            if (this.a == null) {
                this.a = a(this.b);
            }
            List<ar> b2 = this.a.b("1=1", ar.class);
            if (b2.size() > 0) {
                return b2.get(0);
            }
        } catch (Throwable th) {
            w.a(th, "ud", "gd");
        }
        return null;
    }

    public final void a(ar arVar) {
        if (arVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                List<ar> b2 = this.a.b("1=1", ar.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        this.a.a("1=1", (Object) arVar);
                        return;
                    }
                }
                this.a.a(arVar);
            } catch (Throwable th) {
                w.a(th, "ud", "ug");
            }
        }
    }
}
