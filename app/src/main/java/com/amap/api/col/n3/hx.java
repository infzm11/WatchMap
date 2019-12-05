package com.amap.api.col.n3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: BasicLBSRestHandler */
public abstract class hx<T, V> extends hw<T, V> {
    public final Map<String, String> b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String e();

    public hx(Context context, T t) {
        super(context, t);
    }

    public final byte[] f() {
        try {
            return e().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 5.4.0");
        hashMap.put("X-INFO", ig.b(this.d));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"5.4.0", "trace"}));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public final String c() {
        String a;
        String str = "&ts=" + a;
        String a2 = ig.a(this.d, a, "key=" + id.f(this.d));
        String str2 = "&scode=" + a2;
        return "http://restapi.amap.com/v3/grasproad?" + r0 + str + str2;
    }
}
