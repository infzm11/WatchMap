package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DriveRouteSearchHandler */
public class k extends b<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public k(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.d));
        if (((RouteSearch.DriveRouteQuery) this.a).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getFrom()));
            if (!n.i(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getTo()));
            if (!n.i(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getDestinationPoiID());
            }
            if (!n.i(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getOriginType());
            }
            if (!n.i(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getDestinationType());
            }
            if (!n.i(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.DriveRouteQuery) this.a).getMode());
        stringBuffer.append("&extensions=all");
        if (((RouteSearch.DriveRouteQuery) this.a).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.a).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.a).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.a).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(c(((RouteSearch.DriveRouteQuery) this.a).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public DriveRouteResult a(String str) throws AMapException {
        return n.b(str);
    }

    public String i() {
        return h.a() + "/direction/driving?";
    }
}
