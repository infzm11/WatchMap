package com.loc;

import android.content.Context;
import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class w {
    protected static w a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    public static void a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (a != null) {
            a.a(th, 1, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Context context, s sVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(s sVar, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, int i, String str, String str2) {
    }
}
