package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public final class go extends gj<gp, ArrayList<he>> {
    public final String c() {
        return "http://restapi.amap.com/v3/assistant/inputtips?";
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(String str) throws gh {
        return c(str);
    }

    public go(Context context, gp gpVar) {
        super(context, gpVar);
    }

    private static ArrayList<he> c(String str) throws gh {
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&keywords=");
        stringBuffer.append(b(((gp) this.a).a()));
        String b = ((gp) this.a).b();
        if (!d(b)) {
            String b2 = b(b);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String c = ((gp) this.a).c();
        if (!d(c)) {
            String b3 = b(c);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((gp) this.a).d()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        gs e = ((gp) this.a).e();
        if (e != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(e.a());
            stringBuffer.append(",");
            stringBuffer.append(e.b());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(id.f(this.d));
        return stringBuffer.toString();
    }

    private static boolean d(String str) {
        return str == null || str.equals("");
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    private static ArrayList<he> a(JSONObject jSONObject) throws JSONException {
        ArrayList<he> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            he heVar = new he();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                heVar.b(a(optJSONObject, "name"));
                heVar.c(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                heVar.d(a(optJSONObject, "adcode"));
                heVar.a(a(optJSONObject, "id"));
                heVar.e(a(optJSONObject, "address"));
                heVar.f(a(optJSONObject, "typecode"));
                String a = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a)) {
                    String[] split = a.split(",");
                    if (split.length == 2) {
                        heVar.a(new gs(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(heVar);
            }
        }
        return arrayList;
    }
}
