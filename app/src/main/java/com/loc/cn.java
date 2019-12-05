package com.loc;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LocNetManager */
public final class cn {
    private static cn b;
    bi a = null;
    private Context c = null;
    private int d = 0;
    private int e = cs.f;
    private boolean f = false;

    private cn(Context context) {
        this.c = context;
        this.a = bi.a();
    }

    public static cn a(Context context) {
        if (b == null) {
            b = new cn(context);
        }
        return b;
    }

    public final int a() {
        return this.d;
    }

    public final bo a(co coVar) throws Throwable {
        long b2 = da.b();
        bi biVar = this.a;
        bo a2 = bi.a(coVar, this.f);
        this.d = Long.valueOf(da.b() - b2).intValue();
        return a2;
    }

    public final co a(Context context, byte[] bArr, String str, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            co coVar = new co(context, cs.b());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 3.6.1");
                hashMap.put("KEY", k.f(context));
                hashMap.put("enginever", "4.7");
                String a2 = m.a();
                String a3 = m.a(context, a2, "key=" + k.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                hashMap.put("encr", "1");
                coVar.f = hashMap;
                String str2 = "loc";
                if (!z) {
                    str2 = "locf";
                }
                coVar.m = true;
                coVar.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"3.6.1", str2, 3});
                coVar.j = z;
                coVar.g = str;
                coVar.h = da.a(bArr);
                coVar.a(q.a(context));
                HashMap hashMap2 = new HashMap();
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                coVar.l = hashMap2;
                coVar.a(this.e);
                coVar.b(this.e);
                if (!this.f) {
                    return coVar;
                }
                coVar.g = coVar.c().replace("http", "https");
                return coVar;
            } catch (Throwable unused) {
                return coVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final String a(byte[] bArr, Context context, String str) {
        HashMap hashMap = new HashMap();
        co coVar = new co(context, cs.b());
        hashMap.clear();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Connection", "Keep-Alive");
        hashMap.put("User-Agent", "AMAP_Location_SDK_Android 3.6.1");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom", "26260A1F00020002");
        hashMap2.put("key", k.f(context));
        String a2 = m.a();
        String a3 = m.a(context, a2, t.b((Map<String, String>) hashMap2));
        hashMap2.put("ts", a2);
        hashMap2.put("scode", a3);
        coVar.m = false;
        coVar.b(bArr);
        coVar.j = true;
        coVar.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"3.6.1", "loc", 3});
        coVar.l = hashMap2;
        coVar.f = hashMap;
        coVar.g = str;
        coVar.a(q.a(context));
        coVar.a(cs.f);
        coVar.b(cs.f);
        try {
            bi biVar = this.a;
            return new String(bi.a(coVar), "utf-8");
        } catch (Throwable th) {
            cs.a(th, "LocNetManager", "post");
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.f = z;
            this.e = Long.valueOf(j).intValue();
        } catch (Throwable th) {
            cs.a(th, "netmanager", "setOption");
        }
    }

    public final String b(byte[] bArr, Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            cm cmVar = new cm();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            cmVar.a = hashMap;
            cmVar.f = str;
            cmVar.g = bArr;
            cmVar.a(q.a(context));
            cmVar.a(cs.f);
            cmVar.b(cs.f);
            bi biVar = this.a;
            return new String(bi.a(cmVar), "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
