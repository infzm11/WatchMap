package com.amap.api.col.n3;

import android.content.Context;
import android.os.Looper;
import java.util.List;

/* compiled from: ExceptionLogProcessor */
public final class ix extends iy {
    private static boolean b = true;

    /* access modifiers changed from: protected */
    public final String a(List<im> list) {
        return null;
    }

    protected ix(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (ih.n(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            jl jlVar = new jl(context);
            jm a = jlVar.a();
            if (a == null) {
                return true;
            }
            if (!a.b()) {
                return false;
            }
            a.b(false);
            jlVar.a(a);
            return true;
        }
    }
}
