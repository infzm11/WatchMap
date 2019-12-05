package com.amap.api.col.n3;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class kn {
    private Context a;
    private im b;
    private String c;

    public kn(Context context, im imVar, String str) {
        this.a = context.getApplicationContext();
        this.b = imVar;
        this.c = str;
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() {
        return in.a(ig.b(in.b(in.a(a(this.a, this.b, this.c)))));
    }

    private static String a(Context context, im imVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(imVar.c());
            sb.append("\",\"product\":\"");
            sb.append(imVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(ih.c(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
