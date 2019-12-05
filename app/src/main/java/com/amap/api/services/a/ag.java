package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: WalkRouteSearchHandler */
public class ag extends b<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public ag(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.WalkRouteQuery) this.a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.WalkRouteQuery) this.a).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public WalkRouteResult a(String str) throws AMapException {
        return n.c(str);
    }

    public String i() {
        return h.a() + "/direction/walking?";
    }
}
