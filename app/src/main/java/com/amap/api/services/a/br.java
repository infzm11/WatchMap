package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;
import java.util.List;

/* compiled from: ExceptionLogProcessor */
public class br extends bs {
    private static boolean b = true;

    /* access modifiers changed from: protected */
    public String a(List<bh> list) {
        return null;
    }

    protected br(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public boolean a(Context context) {
        if (bd.m(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            cf cfVar = new cf(context);
            cg a = cfVar.a();
            if (a == null) {
                return true;
            }
            if (!a.b()) {
                return false;
            }
            a.b(false);
            cfVar.a(a);
            return true;
        }
    }
}
