package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficStatusResult;

/* compiled from: RoadTrafficSearchHandler */
public class ac extends b<RoadTrafficQuery, TrafficStatusResult> {
    public ac(Context context, RoadTrafficQuery roadTrafficQuery) {
        super(context, roadTrafficQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&name=");
        stringBuffer.append(((RoadTrafficQuery) this.a).getName());
        stringBuffer.append("&adcode=");
        stringBuffer.append(((RoadTrafficQuery) this.a).getAdCode());
        stringBuffer.append("&level=");
        stringBuffer.append(((RoadTrafficQuery) this.a).getLevel());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public TrafficStatusResult a(String str) throws AMapException {
        return n.p(str);
    }

    public String i() {
        return h.a() + "/traffic/status/road?";
    }
}
