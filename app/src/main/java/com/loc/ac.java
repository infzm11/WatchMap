package com.loc;

import android.content.Context;
import android.os.Looper;
import java.util.List;

/* compiled from: ExceptionLogProcessor */
public final class ac extends ad {
    private static boolean b = true;

    protected ac(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final String a(List<s> list) {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (n.n(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            ar a = aqVar.a();
            if (a == null) {
                return true;
            }
            if (!a.b()) {
                return false;
            }
            a.b(false);
            aqVar.a(a);
            return true;
        }
    }
}
