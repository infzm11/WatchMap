package com.amap.api.col.n3;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
public final class hb extends gv<String, gw> {
    public final /* synthetic */ Object a(String str) throws gh {
        return c(str);
    }

    public hb(Context context, String str) {
        super(context, str);
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(hc.a().c() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3");
        sb.append("/place/detail?");
        return sb.toString();
    }

    private static gw c(String str) throws gh {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("pois");
            if (optJSONArray == null) {
                return null;
            }
            if (optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject == null) {
                return null;
            }
            return gr.a(optJSONObject);
        } catch (JSONException e) {
            gk.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Throwable th) {
            gk.a(th, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return "id=" + ((String) this.a) + "&output=json" + "&extensions=all" + "&children=1" + "&language=" + hc.a().b() + ("&key=" + id.f(this.d));
    }
}
