package com.amap.api.col.n3;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* compiled from: SDKDBOperation */
public final class jk {
    private ja a;
    private Context b;

    public jk(Context context, boolean z) {
        this.b = context;
        this.a = a(this.b, z);
    }

    private static ja a(Context context, boolean z) {
        try {
            return new ja(context, ja.a((Class<? extends iz>) jh.class));
        } catch (Throwable th) {
            if (!z) {
                ir.a(th, "sd", "gdb");
            } else {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(im imVar) {
        if (imVar != null) {
            try {
                boolean z = false;
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = im.a(imVar.a());
                List<im> b2 = this.a.b(a2, im.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        Iterator<im> it = b2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().equals(imVar)) {
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            this.a.a(a2, (Object) imVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(imVar);
            } catch (Throwable th) {
                ir.a(th, "sd", "it");
                th.printStackTrace();
            }
        }
    }

    public final List<im> a() {
        try {
            return this.a.a(im.h(), im.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
