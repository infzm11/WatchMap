package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
public class v extends u<String, PoiItem> {
    public v(Context context, String str) {
        super(context, str);
    }

    public String i() {
        return h.a() + "/place/detail?";
    }

    /* renamed from: f */
    public PoiItem a(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            i.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            i.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    private PoiItem a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return null;
        }
        return n.d(optJSONObject);
    }

    /* access modifiers changed from: protected */
    public String g() {
        return j();
    }

    private String j() {
        return "id=" + ((String) this.a) + "&output=json" + "&extensions=all" + "&children=1" + "&language=" + ServiceSettings.getInstance().getLanguage() + ("&key=" + az.f(this.d));
    }
}
