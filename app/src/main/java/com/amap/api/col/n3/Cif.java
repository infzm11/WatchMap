package com.amap.api.col.n3;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* renamed from: com.amap.api.col.n3.if  reason: invalid class name */
/* compiled from: AuthManager */
public final class Cif {
    public static int a = -1;
    public static String b = "";
    private static im c = null;
    private static String d = "http://apiinit.amap.com/v3/log/init";
    private static String e;

    private static boolean b(Context context, im imVar) {
        c = imVar;
        try {
            String str = d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", c.d());
            im imVar2 = c;
            hashMap.put("X-INFO", ig.c(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{c.b(), c.a()}));
            kd a2 = kd.a();
            io ioVar = new io();
            ioVar.a(ik.a(context));
            ioVar.a((Map<String, String>) hashMap);
            ioVar.b(a(context));
            ioVar.a(str);
            return a(a2.a(ioVar));
        } catch (Throwable th) {
            ir.a(th, "Auth", "getAuth");
            return true;
        }
    }

    @Deprecated
    public static synchronized boolean a(Context context, im imVar) {
        boolean b2;
        synchronized (Cif.class) {
            b2 = b(context, imVar);
        }
        return b2;
    }

    public static void a(String str) {
        id.a(str);
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(in.a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            if (a == 0) {
                String str = b;
            }
            return a == 1;
        } catch (JSONException e2) {
            ir.a((Throwable) e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            ir.a(th, "Auth", "lData");
            return false;
        }
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String a2 = ig.a();
            hashMap.put("ts", a2);
            hashMap.put("key", id.f(context));
            hashMap.put("scode", ig.a(context, a2, in.d("resType=json&encode=UTF-8&key=" + id.f(context))));
        } catch (Throwable th) {
            ir.a(th, "Auth", "gParams");
        }
        return hashMap;
    }
}
