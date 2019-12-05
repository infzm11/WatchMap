package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.col.n3.ie;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.iflytek.cloud.SpeechUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineUpdateCityHandler */
public final class at extends bn<String, List<OfflineMapProvince>> {
    private Context d;

    public at(Context context, String str) {
        super(context, str);
    }

    public final void a(Context context) {
        this.d = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.d != null) {
                bj.b(jSONObject.toString(), this.d);
            }
        } catch (Throwable th) {
            iu.b(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            if (this.d != null) {
                return bj.a(jSONObject, this.d);
            }
            return null;
        } catch (JSONException e) {
            iu.b((Throwable) e, "OfflineUpdateCityHandler", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(ie.a aVar) {
        JSONObject jSONObject = aVar.e;
        if (!jSONObject.has(SpeechUtility.TAG_RESOURCE_RESULT)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(SpeechUtility.TAG_RESOURCE_RESULT, new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public final String a() {
        return "013";
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapver", this.a);
        return hashMap;
    }
}
