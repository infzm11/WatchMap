package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BusSearchServerHandler */
public class d<T> extends b<T, Object> {
    private int i = 0;
    private List<String> j = new ArrayList();
    private List<SuggestionCity> k = new ArrayList();

    public d(Context context, T t) {
        super(context, t);
    }

    public String i() {
        String str = "";
        if (!(this.a instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) this.a).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else if (((BusLineQuery) this.a).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME) {
            str = "linename";
        }
        return h.a() + "/bus/" + str + "?";
    }

    /* access modifiers changed from: protected */
    public Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.k = n.a(optJSONObject);
                this.j = n.b(optJSONObject);
            }
            this.i = jSONObject.optInt("count");
            if (this.a instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.a, this.i, this.k, this.j, n.i(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.a, this.i, this.k, this.j, n.e(jSONObject));
        } catch (Exception e) {
            i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (this.a instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.a;
            sb.append("&extensions=all");
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(c(((BusLineQuery) this.a).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!n.i(city)) {
                    String c = c(city);
                    sb.append("&city=");
                    sb.append(c);
                }
                sb.append("&keywords=" + c(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.a;
            String city2 = busStationQuery.getCity();
            if (!n.i(city2)) {
                String c2 = c(city2);
                sb.append("&city=");
                sb.append(c2);
            }
            sb.append("&keywords=" + c(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + az.f(this.d));
        return sb.toString();
    }
}
