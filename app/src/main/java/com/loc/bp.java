package com.loc;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class bp {
    private Context a;
    private s b;
    private String c;

    public bp(Context context, s sVar, String str) {
        this.a = context.getApplicationContext();
        this.b = sVar;
        this.c = str;
    }

    private static String a(Context context, s sVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(sVar.c());
            sb.append("\",\"product\":\"");
            sb.append(sVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(n.c(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() {
        return t.a(m.b(t.b(t.a(a(this.a, this.b, this.c)))));
    }
}
