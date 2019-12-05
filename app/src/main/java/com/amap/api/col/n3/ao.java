package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.col.n3.ie;
import com.amap.api.maps.AMapException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineInitHandler */
public final class ao extends bn<String, an> {
    private final String d = "update";
    private final String e = "1";
    private final String f = "0";
    private final String g = "version";

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(JSONObject jSONObject) throws AMapException {
        return b(jSONObject);
    }

    public ao(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(ie.a aVar) {
        return aVar.f;
    }

    /* access modifiers changed from: protected */
    public final String a() {
        return "014";
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapver", this.a);
        return hashMap;
    }

    private static an b(JSONObject jSONObject) throws AMapException {
        an anVar = new an();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                anVar.a(false);
            } else if (optString.equals("1")) {
                anVar.a(true);
            }
            anVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            iu.b(th, "OfflineInitHandler", "loadData parseJson");
        }
        return anVar;
    }
}
