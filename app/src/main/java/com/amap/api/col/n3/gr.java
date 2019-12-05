package com.amap.api.col.n3;

import com.iflytek.clientadapter.constant.FocusType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public final class gr {
    public static gw a(JSONObject jSONObject) throws JSONException {
        gw gwVar = new gw(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        gwVar.g(a(jSONObject, "adcode"));
        gwVar.d(a(jSONObject, "pname"));
        gwVar.c(a(jSONObject, "cityname"));
        gwVar.b(a(jSONObject, "adname"));
        gwVar.h(a(jSONObject, "citycode"));
        gwVar.m(a(jSONObject, "pcode"));
        gwVar.l(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a = a(jSONObject, "distance");
            if (!a(a)) {
                try {
                    gwVar.a((int) Float.parseFloat(a));
                } catch (NumberFormatException e) {
                    gk.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    gk.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        gwVar.f(a(jSONObject, "tel"));
        gwVar.e(a(jSONObject, "type"));
        gwVar.a(b(jSONObject, "entr_location"));
        gwVar.b(b(jSONObject, "exit_location"));
        gwVar.i(a(jSONObject, FocusType.website));
        gwVar.j(a(jSONObject, "postcode"));
        gwVar.a(a(jSONObject, "business_area"));
        gwVar.k(a(jSONObject, "email"));
        String a2 = a(jSONObject, "indoor_map");
        int i = 0;
        if (a2 == null || a2.equals("") || a2.equals("0")) {
            gwVar.a(false);
        } else {
            gwVar.a(true);
        }
        gwVar.n(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(b(optJSONObject));
                    }
                }
            }
            gwVar.a((List<hd>) arrayList);
        }
        String str = "";
        String str2 = "";
        if (jSONObject.has("indoor_data")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("indoor_data");
            if (optJSONObject2 != null && optJSONObject2.has("cpid") && optJSONObject2.has("floor")) {
                str = a(optJSONObject2, "cpid");
                i = b(a(optJSONObject2, "floor"));
                str2 = a(optJSONObject2, "truefloor");
            }
        }
        gwVar.a(new gm(str, i, str2));
        String str3 = "";
        String str4 = "";
        if (jSONObject.has("biz_ext")) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("biz_ext");
            if (optJSONObject3 != null) {
                str3 = a(optJSONObject3, "open_time");
                str4 = a(optJSONObject3, "rating");
            }
        }
        gwVar.a(new gx(str3, str4));
        gwVar.o(a(jSONObject, "typecode"));
        gwVar.p(a(jSONObject, "shopid"));
        List<gu> c = c(jSONObject.optJSONObject("deep_info"));
        if (c.size() == 0) {
            c = c(jSONObject);
        }
        gwVar.b(c);
        return gwVar;
    }

    private static hd b(JSONObject jSONObject) throws JSONException {
        hd hdVar = new hd(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        hdVar.a(a(jSONObject, "sname"));
        hdVar.b(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a = a(jSONObject, "distance");
            if (!a(a)) {
                try {
                    hdVar.a((int) Float.parseFloat(a));
                } catch (NumberFormatException e) {
                    gk.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    gk.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return hdVar;
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    private static gs b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        String optString = jSONObject.optString(str);
        if (optString == null || optString.equals("") || optString.equals("[]")) {
            return null;
        }
        String[] split = optString.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new gs(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static boolean a(String str) {
        return str == null || str.equals("");
    }

    private static int b(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            gk.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    private static List<gu> c(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            gu guVar = new gu();
            guVar.a(a(optJSONObject, "title"));
            guVar.b(a(optJSONObject, "url"));
            arrayList.add(guVar);
        }
        return arrayList;
    }
}
