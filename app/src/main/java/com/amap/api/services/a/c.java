package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: BusRouteSearchHandler */
public class c extends b<RouteSearch.BusRouteQuery, BusRouteResult> {
    public c(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) this.a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) this.a).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.a).getCity();
        if (!n.i(city)) {
            city = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!n.i(((RouteSearch.BusRouteQuery) this.a).getCity())) {
            String c = c(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.BusRouteQuery) this.a).getMode());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.a).getNightFlag());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public BusRouteResult a(String str) throws AMapException {
        return n.a(str);
    }

    public String i() {
        return h.a() + "/direction/transit/integrated?";
    }
}
