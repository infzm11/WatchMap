package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: RideRouteSearchHandler */
public class ab extends b<RouteSearch.RideRouteQuery, RideRouteResult> {
    public ab(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.RideRouteQuery) this.a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.RideRouteQuery) this.a).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RideRouteResult a(String str) throws AMapException {
        return n.o(str);
    }

    public String i() {
        return h.b() + "/direction/bicycling?";
    }
}
