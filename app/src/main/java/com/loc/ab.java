package com.loc;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;

/* compiled from: CrashLogProcessor */
public final class ab extends ad {
    private static boolean b = true;

    protected ab(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        String a = t.a(new Date().getTime());
        return p.c(str + a);
    }

    /* access modifiers changed from: protected */
    public final String a(List<s> list) {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (!b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            ar a = aqVar.a();
            if (a == null) {
                return true;
            }
            if (!a.a()) {
                return false;
            }
            a.a(false);
            aqVar.a(a);
            return true;
        }
    }
}
