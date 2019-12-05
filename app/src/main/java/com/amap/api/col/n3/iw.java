package com.amap.api.col.n3;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;

/* compiled from: CrashLogProcessor */
public final class iw extends iy {
    private static boolean b = true;

    /* access modifiers changed from: protected */
    public final String a(List<im> list) {
        return null;
    }

    protected iw(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (!b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            jl jlVar = new jl(context);
            jm a = jlVar.a();
            if (a == null) {
                return true;
            }
            if (!a.a()) {
                return false;
            }
            a.a(false);
            jlVar.a(a);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        String a = in.a(new Date().getTime());
        return ij.c(str + a);
    }
}
