package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GeoFenceNetManager */
public final class b {
    bi a;

    public b() {
        this.a = null;
        this.a = bi.a();
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap();
            cm cmVar = new cm();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 3.6.1");
            String a2 = m.a();
            String a3 = m.a(context, a2, t.b(map));
            map.put("ts", a2);
            map.put("scode", a3);
            cmVar.b(map);
            cmVar.a((Map<String, String>) hashMap);
            cmVar.a(str);
            cmVar.a(q.a(context));
            cmVar.a(cs.f);
            cmVar.b(cs.f);
            bi biVar = this.a;
            return new String(bi.a(cmVar), "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, String> b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("key", k.f(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> b = b(context, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        b.put("extensions", "all");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> b = b(context, str2, str3, str4, str5, (String) null, (String) null, (String) null);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> b = b(context, str2, str3, (String) null, str4, str5, str6, str7);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }
}
