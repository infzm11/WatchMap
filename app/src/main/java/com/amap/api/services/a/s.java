package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NearbySearchHandler */
public class s extends b<NearbySearch.NearbyQuery, NearbySearchResult> {
    private Context i;
    private NearbySearch.NearbyQuery j;

    public s(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.i = context;
        this.j = nearbyQuery;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(az.f(this.i));
        LatLonPoint centerPoint = this.j.getCenterPoint();
        stringBuffer.append("&center=");
        stringBuffer.append(centerPoint.getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(centerPoint.getLatitude());
        stringBuffer.append("&radius=");
        stringBuffer.append(this.j.getRadius());
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.j.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.j.getTimeRange());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.j.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> a = n.a(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a);
            return nearbySearchResult;
        } catch (JSONException e) {
            i.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return h.c() + "/nearby/around";
    }
}
