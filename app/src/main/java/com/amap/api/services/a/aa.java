package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler */
public class aa extends b<RegeocodeQuery, RegeocodeAddress> {
    public aa(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    public String i() {
        return h.a() + "/geocode/regeo?";
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public RegeocodeAddress a(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(n.a(optJSONObject, "formatted_address"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            if (optJSONObject2 != null) {
                n.a(optJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(n.c(optJSONObject));
            JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
            if (optJSONArray != null) {
                n.b(optJSONArray, regeocodeAddress);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
            if (optJSONArray2 != null) {
                n.a(optJSONArray2, regeocodeAddress);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
            if (optJSONArray3 != null) {
                n.c(optJSONArray3, regeocodeAddress);
            }
            return regeocodeAddress;
        } catch (JSONException e) {
            i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&location=");
        stringBuffer.append(((RegeocodeQuery) this.a).getPoint().getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(((RegeocodeQuery) this.a).getPoint().getLatitude());
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.a).getPoiType())) {
            stringBuffer.append("&poitype=");
            stringBuffer.append(((RegeocodeQuery) this.a).getPoiType());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append((int) ((RegeocodeQuery) this.a).getRadius());
        stringBuffer.append("&coordsys=");
        stringBuffer.append(((RegeocodeQuery) this.a).getLatLonType());
        stringBuffer.append("&key=" + az.f(this.d));
        stringBuffer.append("&language=");
        stringBuffer.append(h.d());
        return stringBuffer.toString();
    }
}
