package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeocodingHandler */
public class l extends b<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public l(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<GeocodeAddress> a(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return n.l(jSONObject);
            }
            return arrayList;
        } catch (JSONException e) {
            i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    public String i() {
        return h.a() + "/geocode/geo?";
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&address=");
        stringBuffer.append(c(((GeocodeQuery) this.a).getLocationName()));
        String city = ((GeocodeQuery) this.a).getCity();
        if (!n.i(city)) {
            String c = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&key=" + az.f(this.d));
        stringBuffer.append("&language=");
        stringBuffer.append(h.d());
        return stringBuffer.toString();
    }
}
