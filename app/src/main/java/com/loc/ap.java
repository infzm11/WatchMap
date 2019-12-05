package com.loc;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* compiled from: SDKDBOperation */
public final class ap {
    private af a;
    private Context b;

    public ap(Context context, boolean z) {
        this.b = context;
        this.a = a(this.b, z);
    }

    private static af a(Context context, boolean z) {
        try {
            return new af(context, af.a((Class<? extends ae>) am.class));
        } catch (Throwable th) {
            if (!z) {
                w.a(th, "sd", "gdb");
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final List<s> a() {
        try {
            return this.a.a(s.g(), s.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void a(s sVar) {
        if (sVar != null) {
            try {
                boolean z = false;
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = s.a(sVar.a());
                List<s> b2 = this.a.b(a2, s.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        Iterator<s> it = b2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().equals(sVar)) {
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            this.a.a(a2, (Object) sVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(sVar);
            } catch (Throwable th) {
                w.a(th, "sd", "it");
                th.printStackTrace();
            }
        }
    }
}
