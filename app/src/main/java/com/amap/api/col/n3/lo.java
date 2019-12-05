package com.amap.api.col.n3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: LocNetManager */
public final class lo {
    private static lo b;
    kd a = null;
    private Context c = null;
    private int d = 0;
    private int e = lr.f;
    private boolean f = false;

    private lo(Context context) {
        this.c = context;
        this.a = kd.a();
    }

    public static lo a(Context context) {
        if (b == null) {
            b = new lo(context);
        }
        return b;
    }

    public final kl a(lp lpVar) throws Throwable {
        long b2 = lu.b();
        kd kdVar = this.a;
        kl a2 = kd.a(lpVar, this.f);
        this.d = Long.valueOf(lu.b() - b2).intValue();
        return a2;
    }

    public final lp a(Context context, byte[] bArr, String str) {
        try {
            HashMap hashMap = new HashMap();
            lp lpVar = new lp(context, lr.b());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 3.6.0");
                hashMap.put("KEY", id.f(context));
                hashMap.put("enginever", "4.7");
                String a2 = ig.a();
                String a3 = ig.a(context, a2, "key=" + id.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                hashMap.put("encr", "1");
                lpVar.a = hashMap;
                lpVar.m = true;
                lpVar.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"3.6.0", "loc", 3});
                lpVar.j = true;
                lpVar.d = str;
                lpVar.e = lu.a(bArr);
                lpVar.a(ik.a(context));
                HashMap hashMap2 = new HashMap();
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                lpVar.l = hashMap2;
                lpVar.a(this.e);
                lpVar.b(this.e);
                if (!this.f) {
                    return lpVar;
                }
                lpVar.d = lpVar.c().replace("http", "https");
                return lpVar;
            } catch (Throwable unused) {
                return lpVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.f = z;
            this.e = Long.valueOf(j).intValue();
        } catch (Throwable th) {
            lr.a(th, "netmanager", "setOption");
        }
    }
}
