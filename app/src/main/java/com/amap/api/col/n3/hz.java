package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TraceHandler */
public final class hz extends hx<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> i;
    private Handler j = null;
    private int k = 0;
    private int l = 0;
    private String m;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(String str) throws hv {
        return b(str);
    }

    public hz(Context context, Handler handler, List<TraceLocation> list, String str, int i2, int i3) {
        super(context, list);
        this.i = list;
        this.j = handler;
        this.l = i2;
        this.k = i3;
        this.m = str;
    }

    /* access modifiers changed from: protected */
    public final String e() {
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            TraceLocation traceLocation = this.i.get(i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i2 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j3 = time - j2;
                        if (j3 >= 1000) {
                            jSONObject.put("tm", j3 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j2 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.e = c() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    private static List<LatLng> b(String str) throws hv {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("points");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void run() {
        new ArrayList();
        try {
            try {
                ib.a().a(this.m, this.k, (List<LatLng>) (List) d());
                ib.a().a(this.m).a(this.j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (hv e) {
            ib.a();
            ib.a(this.j, this.l, e.a());
        }
    }
}
