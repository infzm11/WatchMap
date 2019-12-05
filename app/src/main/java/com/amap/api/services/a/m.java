package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public class m extends b<InputtipsQuery, ArrayList<Tip>> {
    public m(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<Tip> a(String str) throws AMapException {
        try {
            return n.m(new JSONObject(str));
        } catch (JSONException e) {
            i.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return h.a() + "/assistant/inputtips?";
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&keywords=");
        stringBuffer.append(c(((InputtipsQuery) this.a).getKeyword()));
        String city = ((InputtipsQuery) this.a).getCity();
        if (!n.i(city)) {
            String c = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c);
        }
        String type = ((InputtipsQuery) this.a).getType();
        if (!n.i(type)) {
            String c2 = c(type);
            stringBuffer.append("&type=");
            stringBuffer.append(c2);
        }
        if (((InputtipsQuery) this.a).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.a).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(az.f(this.d));
        stringBuffer.append("&language=");
        stringBuffer.append(h.d());
        return stringBuffer.toString();
    }
}
