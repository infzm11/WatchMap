package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;

/* compiled from: CrashLogProcessor */
public class bq extends bs {
    private static boolean b = true;

    /* access modifiers changed from: protected */
    public String a(List<bh> list) {
        return null;
    }

    protected bq(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public boolean a(Context context) {
        if (!b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            cf cfVar = new cf(context);
            cg a = cfVar.a();
            if (a == null) {
                return true;
            }
            if (!a.a()) {
                return false;
            }
            a.a(false);
            cfVar.a(a);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        String a = bi.a(new Date().getTime());
        return bf.c(str + a);
    }
}
