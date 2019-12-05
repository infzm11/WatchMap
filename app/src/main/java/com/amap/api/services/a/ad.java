package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RoutePOISearchHandler */
public class ad extends b<RoutePOISearchQuery, RoutePOISearchResult> {
    public ad(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&range=");
        stringBuffer.append("" + ((RoutePOISearchQuery) this.a).getRange());
        String str2 = "";
        try {
            switch (((RoutePOISearchQuery) this.a).getSearchType()) {
                case TypeGasStation:
                    str = "0101";
                    break;
                case TypeMaintenanceStation:
                    str = "0300";
                    break;
                case TypeATM:
                    str = "1603";
                    break;
                case TypeToilet:
                    str = "2003";
                    break;
                case TypeFillingStation:
                    str = "0103";
                    break;
                case TypeServiceArea:
                    str = "180301";
                    break;
            }
            str2 = str;
        } catch (Exception unused) {
        }
        if (((RoutePOISearchQuery) this.a).getPolylines() == null || ((RoutePOISearchQuery) this.a).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.a).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.a).getTo()));
            stringBuffer.append("&strategy=");
            stringBuffer.append("" + ((RoutePOISearchQuery) this.a).getMode());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.a).getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList;
        ArrayList<RoutePOIItem> arrayList2 = new ArrayList<>();
        try {
            arrayList = n.w(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            arrayList = arrayList2;
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.a);
    }

    public String i() {
        return h.a() + "/place/route?";
    }
}
