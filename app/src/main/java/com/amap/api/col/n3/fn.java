package com.amap.api.col.n3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: WalkTBTTask */
public final class fn extends fj {
    private fi r;

    public fn(fi fiVar, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr) {
        super(context, str, i, str2, i2, i3, bArr);
        this.r = fiVar;
    }

    public final void a() {
        try {
            kl b = b();
            int a = fk.a("http://restapi.amap.com/v3/direction/walking", b);
            if (a < 0) {
                a = 1;
            }
            try {
                if (this.r != null && this.r.f() != null) {
                    if (a == 1) {
                        this.r.f().receiveNetData(this.f, this.g, b.a, b.a.length);
                        this.r.f().setNetRequestState(this.f, this.g, a);
                        return;
                    }
                    this.r.f().setNetRequestState(this.f, this.g, 4);
                    this.r.a().setRouteRequestState(a);
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return;
        }
        throw th;
    }

    private kl b() {
        try {
            AnonymousClass1 r0 = new kj() {
                public final String c() {
                    return "http://restapi.amap.com/v3/direction/walking";
                }

                public final Map<String, String> a() {
                    HashMap hashMap = new HashMap();
                    String b = ig.b(fn.this.j);
                    hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"5.4.0", "navi"}));
                    hashMap.put("X-INFO", b);
                    hashMap.put("logversion", "2.1");
                    return hashMap;
                }

                public final Map<String, String> b() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("origin", fn.this.m + "," + fn.this.n);
                    hashMap.put("destination", fn.this.o + "," + fn.this.p);
                    hashMap.put("output", "binary");
                    hashMap.put("enginever", "3.0");
                    hashMap.put("key", id.f(fn.this.j));
                    String a2 = ig.a();
                    String a3 = ig.a(fn.this.j, a2, in.b((Map<String, String>) hashMap));
                    hashMap.put("ts", a2);
                    hashMap.put("scode", a3);
                    return hashMap;
                }
            };
            ki.b();
            return ki.e(r0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
