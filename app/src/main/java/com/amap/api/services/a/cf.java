package com.amap.api.services.a;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public class cf {
    private bu a = a(this.b);
    private Context b;

    public cf(Context context) {
        this.b = context;
    }

    private bu a(Context context) {
        try {
            return new bu(context, bu.a((Class<? extends bt>) cb.class));
        } catch (Throwable th) {
            bl.a(th, "UpdateLogDB", "getDB");
            return null;
        }
    }

    public cg a() {
        try {
            if (this.a == null) {
                this.a = a(this.b);
            }
            List<cg> b2 = this.a.b("1=1", cg.class);
            if (b2.size() > 0) {
                return b2.get(0);
            }
            return null;
        } catch (Throwable th) {
            bl.a(th, "UpdateLogDB", "getUpdateLog");
            return null;
        }
    }

    public void a(cg cgVar) {
        if (cgVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                List<cg> b2 = this.a.b("1=1", cg.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        this.a.a("1=1", (Object) cgVar);
                        return;
                    }
                }
                this.a.a(cgVar);
            } catch (Throwable th) {
                bl.a(th, "UpdateLogDB", "updateLog");
            }
        }
    }
}
