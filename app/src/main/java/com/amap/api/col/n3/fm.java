package com.amap.api.col.n3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: RideTBTTask */
public final class fm extends fj {
    private fh r;

    public fm(fh fhVar, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr) {
        super(context, str, i, str2, i2, i3, bArr);
        this.r = fhVar;
    }

    public final void a() {
        try {
            kl b = b();
            int a = fk.a("http://restapi.amap.com/v4/direction/bicycling", b);
            if (a < 0) {
                a = 1;
            }
            try {
                if (this.r != null && this.r.e() != null) {
                    if (a == 1) {
                        this.r.e().receiveNetData(this.f, this.g, b.a, b.a.length);
                        this.r.e().setNetRequestState(this.f, this.g, a);
                        return;
                    }
                    this.r.e().setNetRequestState(this.f, this.g, 4);
                    this.r.f().setRouteRequestState(a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (!(this.r == null || this.r.e() == null)) {
                    this.r.e().setNetRequestState(this.f, this.g, 4);
                    this.r.f().setRouteRequestState(2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw th;
        }
    }

    private kl b() {
        try {
            AnonymousClass1 r0 = new kj() {
                public final String c() {
                    return "http://restapi.amap.com/v4/direction/bicycling";
                }

                public final Map<String, String> a() {
                    HashMap hashMap = new HashMap();
                    String b = ig.b(fm.this.j);
                    hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"5.4.0", "navi"}));
                    hashMap.put("X-INFO", b);
                    hashMap.put("logversion", "2.1");
                    return hashMap;
                }

                public final Map<String, String> b() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("origin", fm.this.m + "," + fm.this.n);
                    hashMap.put("destination", fm.this.o + "," + fm.this.p);
                    hashMap.put("output", "bin");
                    hashMap.put("key", id.f(fm.this.j));
                    hashMap.put("enginever", "3.0");
                    String a2 = ig.a();
                    String a3 = ig.a(fm.this.j, ig.a(), in.b((Map<String, String>) hashMap));
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
