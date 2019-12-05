package com.amap.api.services.a;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class ce {
    private bu a;
    private Context b;

    public ce(Context context, boolean z) {
        this.b = context;
        this.a = a(this.b, z);
    }

    private bu a(Context context, boolean z) {
        try {
            return new bu(context, bu.a((Class<? extends bt>) cb.class));
        } catch (Throwable th) {
            if (!z) {
                bl.a(th, "SDKDB", "getDB");
            } else {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void a(bh bhVar) {
        if (bhVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = bh.a(bhVar.a());
                List<bh> b2 = this.a.b(a2, bh.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        if (a(b2, bhVar)) {
                            this.a.a(a2, (Object) bhVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(bhVar);
            } catch (Throwable th) {
                bl.a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }

    private boolean a(List<bh> list, bh bhVar) {
        for (bh equals : list) {
            if (equals.equals(bhVar)) {
                return false;
            }
        }
        return true;
    }

    public List<bh> a() {
        try {
            return this.a.a(bh.g(), bh.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
