package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DistrictServerHandler */
public class j extends b<DistrictSearchQuery, DistrictResult> {
    public j(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.a).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.a).getPageSize());
        stringBuffer.append("&showChild=");
        stringBuffer.append(((DistrictSearchQuery) this.a).isShowChild());
        if (((DistrictSearchQuery) this.a).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.a).checkKeyWords()) {
            String c = c(((DistrictSearchQuery) this.a).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&key=" + az.f(this.d));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.a, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return districtResult;
            }
            n.a(optJSONArray, arrayList, (DistrictItem) null);
            return districtResult;
        } catch (JSONException e) {
            i.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "DistrictServerHandler", "paseJSONException");
        }
    }

    public String i() {
        return h.a() + "/config/district?";
    }
}
