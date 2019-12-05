package com.amap.api.col.n3;

import android.content.Context;
import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class ir {
    protected static ir a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    /* access modifiers changed from: protected */
    public void a(Context context, im imVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(im imVar, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, int i, String str, String str2) {
    }

    public static void a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (a != null) {
            a.a(th, 1, str, str2);
        }
    }
}
