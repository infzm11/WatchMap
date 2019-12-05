package com.amap.api.services.a;

import android.content.Context;
import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class bl {
    protected static bl a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    /* access modifiers changed from: protected */
    public void a(Context context, bh bhVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(bh bhVar, String str, String str2) {
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
