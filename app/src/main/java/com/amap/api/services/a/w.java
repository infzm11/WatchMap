package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler */
public class w extends u<z, PoiResult> {
    private int i = 0;
    private List<String> j = new ArrayList();
    private List<SuggestionCity> k = new ArrayList();

    private String a(boolean z) {
        return z ? "distance" : "weight";
    }

    public w(Context context, z zVar) {
        super(context, zVar);
    }

    public String i() {
        String str = h.a() + "/place";
        if (((z) this.a).b == null) {
            return str + "/text?";
        } else if (((z) this.a).b.getShape().equals("Bound")) {
            return str + "/around?";
        } else if (!((z) this.a).b.getShape().equals("Rectangle") && !((z) this.a).b.getShape().equals("Polygon")) {
            return str;
        } else {
            return str + "/polygon?";
        }
    }

    /* renamed from: f */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        ArrayList<PoiItem> arrayList2 = new ArrayList<>();
        if (str == null) {
            return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList2);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.i = jSONObject.optInt("count");
            arrayList = n.c(jSONObject);
            try {
                if (!jSONObject.has("suggestion")) {
                    return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
                if (optJSONObject == null) {
                    return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
                }
                this.k = n.a(optJSONObject);
                this.j = n.b(optJSONObject);
                return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
            } catch (JSONException e) {
                e = e;
                i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
            } catch (Exception e2) {
                e = e2;
                i.a(e, "PoiSearchKeywordHandler", "paseJSONException");
                return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
            }
        } catch (JSONException e3) {
            e = e3;
            arrayList = arrayList2;
            i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
        } catch (Exception e4) {
            e = e4;
            arrayList = arrayList2;
            i.a(e, "PoiSearchKeywordHandler", "paseJSONException");
            return PoiResult.createPagedResult(((z) this.a).a, ((z) this.a).b, this.j, this.k, ((z) this.a).a.getPageSize(), this.i, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((z) this.a).b != null) {
            if (((z) this.a).b.getShape().equals("Bound")) {
                double a = i.a(((z) this.a).b.getCenter().getLongitude());
                double a2 = i.a(((z) this.a).b.getCenter().getLatitude());
                sb.append("&location=");
                sb.append(a + "," + a2);
                sb.append("&radius=");
                sb.append(((z) this.a).b.getRange());
                sb.append("&sortrule=");
                sb.append(a(((z) this.a).b.isDistanceSort()));
            } else if (((z) this.a).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((z) this.a).b.getLowerLeft();
                LatLonPoint upperRight = ((z) this.a).b.getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + VoiceWakeuperAidl.PARAMS_SEPARATE + a6 + "," + a5);
            } else if (((z) this.a).b.getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((z) this.a).b.getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    sb.append("&polygon=" + i.a(polyGonList));
                }
            }
        }
        String city = ((z) this.a).a.getCity();
        if (!e(city)) {
            String c = c(city);
            sb.append("&city=");
            sb.append(c);
        }
        String c2 = c(((z) this.a).a.getQueryString());
        sb.append("&keywords=" + c2);
        sb.append("&language=");
        sb.append(h.d());
        sb.append("&offset=" + ((z) this.a).a.getPageSize());
        sb.append("&page=" + ((z) this.a).a.getPageNum());
        String building = ((z) this.a).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=" + ((z) this.a).a.getBuilding());
        }
        String c3 = c(((z) this.a).a.getCategory());
        sb.append("&types=" + c3);
        sb.append("&extensions=all");
        sb.append("&key=" + az.f(this.d));
        if (((z) this.a).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((z) this.a).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (((z) this.a).b == null && ((z) this.a).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(a(((z) this.a).a.isDistanceSort()));
            double a7 = i.a(((z) this.a).a.getLocation().getLongitude());
            double a8 = i.a(((z) this.a).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }
}
