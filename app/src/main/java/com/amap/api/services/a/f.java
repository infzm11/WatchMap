package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchIdHandler */
public class f extends e<y, CloudItemDetail> {
    public f(Context context, y yVar) {
        super(context, yVar);
    }

    public String i() {
        return h.c() + "/datasearch/id?";
    }

    /* renamed from: f */
    public CloudItemDetail a(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private CloudItemDetail b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("datas")) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        if (optJSONArray.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
        CloudItemDetail a = a(jSONObject2);
        a(a, jSONObject2);
        return a;
    }

    /* access modifiers changed from: protected */
    public String g() {
        return ("key=" + az.f(this.d)) + ("&tableid=" + ((y) this.a).a) + "&output=json" + ("&_id=" + ((y) this.a).b);
    }
}
