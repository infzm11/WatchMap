package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ao {
    private static ah a;
    private static HashMap<String, a> b = new HashMap<>();

    public static class a {
        public String a;
        public String b;
        public long c;
        public long d;
    }

    private static synchronized void a(long j, String str, String str2, String str3, HashMap<String, String> hashMap, long j2) {
        synchronized (ao.class) {
            cb.a("timelinelog", "eventProcess ts:" + j + " id:" + str + " label:" + str2 + " wakeid:" + str3 + " map:" + hashMap + " duration:" + j2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("ts", Long.valueOf(j));
                jSONObject.putOpt("id", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.putOpt("label", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.putOpt("wake_id", str3);
                }
                jSONObject.putOpt("dur", Long.valueOf(j2));
                if (hashMap != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : hashMap.entrySet()) {
                        jSONObject2.put((String) next.getKey(), next.getValue());
                    }
                    jSONObject.put("udmap", jSONObject2);
                }
            } catch (JSONException e) {
                cb.a((Throwable) e);
            }
            try {
                if (a != null) {
                    a.a("timelinelog", jSONObject.toString());
                } else {
                    cb.a("timelinelog", "do not call onevent before sessionbegin");
                }
            } catch (Exception | UnsatisfiedLinkError e2) {
                cb.a(e2);
            }
        }
        return;
    }

    public static void a(ah ahVar) {
        a = ahVar;
    }

    public static synchronized void a(String str, String str2) {
        synchronized (ao.class) {
            a(System.currentTimeMillis(), str, (String) null, str2, (HashMap<String, String>) null, 0);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (ao.class) {
            a(System.currentTimeMillis(), str, str2, str3, (HashMap<String, String>) null, 0);
        }
    }

    public static synchronized void a(String str, String str2, HashMap<String, String> hashMap) {
        synchronized (ao.class) {
            cb.a("timelinelog", "onEventEnd id:" + str);
            long currentTimeMillis = System.currentTimeMillis();
            if (b.containsKey(str)) {
                a aVar = b.get(str);
                aVar.c = currentTimeMillis - aVar.d;
                a(currentTimeMillis, str, str2, aVar.b, hashMap, aVar.c);
                b.remove(str);
            } else {
                cb.a("timelinelog", "call onEventEnd before onEventBegin");
            }
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (ao.class) {
            cb.a("timelinelog", "onEventBegin id:" + str);
            a aVar = new a();
            aVar.a = str;
            aVar.d = System.currentTimeMillis();
            aVar.b = str2;
            b.put(str, aVar);
        }
    }
}
