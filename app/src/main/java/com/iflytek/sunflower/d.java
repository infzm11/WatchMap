package com.iflytek.sunflower;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.speech.UtilityConfig;
import com.iflytek.sunflower.config.Version;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.entity.BootEntity;
import com.iflytek.sunflower.entity.CloseEntity;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.entity.EventEntity;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.h;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import com.iflytek.sunflower.util.m;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static JSONObject a(BootEntity bootEntity, JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SpeechConstant.IST_SESSION_ID, bootEntity.sidString);
            jSONObject2.put("ts", bootEntity.tsLong);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject.has("boot")) {
                jSONArray = jSONObject.getJSONArray("boot");
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
            } else {
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObject2);
            jSONObject.put("boot", jSONArray);
        } catch (JSONException unused) {
            j.d("Collector", "add boot to json error");
        }
        return jSONObject;
    }

    public static JSONObject a(CloseEntity closeEntity, JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SpeechConstant.IST_SESSION_ID, closeEntity.sid);
            jSONObject2.put("ts", closeEntity.startTp);
            jSONObject2.put("dur", closeEntity.durationLong);
            if (l.b(a.I)) {
                jSONObject2.put(AIUIConstant.KEY_UID, a.I);
            }
            JSONArray jSONArray2 = new JSONArray();
            if (closeEntity.page != null) {
                Iterator<String> it = closeEntity.page.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
            }
            jSONObject2.put("page", jSONArray2);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject.has("close")) {
                jSONArray = jSONObject.getJSONArray("close");
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
            } else {
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObject2);
            jSONObject.put("close", jSONArray);
        } catch (JSONException unused) {
            j.d("Collector", "add close to json error");
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject2);
            jSONObject3.put("body", jSONObject);
        } catch (JSONException unused) {
            j.d("Collector", "package to json error");
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context) {
        j.a("Collector", "packHeader start");
        h a = com.iflytek.sunflower.util.a.a(context);
        a.a("lang", a.t);
        a.a("deviceid", a.C);
        a.a("net.mac", g.a(context));
        if (l.b(a.F)) {
            a.a("duid", a.F);
        }
        a.a("appid", g.f(context));
        a.a(UtilityConfig.KEY_CALLER_APPID, a.D);
        a.e = g.g(context);
        a.a("channel", a.e);
        a.a("ver", Version.getVersion());
        a.a("logtime", "" + System.currentTimeMillis());
        String e = e(context);
        if (l.b(e)) {
            a.a("userId", e);
        }
        a.a("carrier", g.c(context));
        a.a("unique_id", m.a(context));
        a.a("src", "sunflower");
        JSONObject a2 = a(false, a, "header");
        int d = d(context);
        if (d != -1) {
            try {
                a2.put("gender", d);
            } catch (JSONException unused) {
            }
        }
        int c = c(context);
        if (c != -1) {
            try {
                a2.put("age", c);
            } catch (JSONException unused2) {
            }
        }
        if (a.r.booleanValue()) {
            try {
                if (TextUtils.isEmpty(a.G) || TextUtils.isEmpty(a.H)) {
                    Location d2 = g.d(context);
                    if (d2 != null) {
                        DecimalFormat decimalFormat = new DecimalFormat("#.########");
                        a2.put("lat", decimalFormat.format(d2.getLatitude()));
                        a2.put("lng", decimalFormat.format(d2.getLongitude()));
                        a2.put("gpstime", d2.getTime());
                    }
                } else {
                    a2.put("lat", a.G);
                    a2.put("lng", a.H);
                }
            } catch (JSONException unused3) {
            } catch (SecurityException e2) {
                j.c("Collector", "get location failed:" + e2);
            }
        }
        long[] b = b(context);
        if (b != null) {
            try {
                if (b.length == 2) {
                    a2.put("dntr", b[0]);
                    a2.put("uptr", b[1]);
                }
            } catch (JSONException unused4) {
            }
        }
        return a2;
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            try {
                jSONObject3.put("event", jSONArray);
            } catch (JSONException unused) {
                j.d("Collector", "mergeEvent error");
            }
            return jSONObject3;
        }
        JSONArray optJSONArray = jSONObject2.optJSONArray("event");
        if (optJSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            try {
                jSONObject2.put("event", jSONArray2);
            } catch (JSONException unused2) {
                j.d("Collector", "mergeEvent error");
            }
            return jSONObject2;
        }
        int i = 0;
        while (i < optJSONArray.length() && !optJSONArray.optJSONObject(i).has(a.f)) {
            i++;
        }
        if (i >= optJSONArray.length()) {
            optJSONArray.put(jSONObject);
        } else {
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a.f);
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                optJSONArray.optJSONObject(i).optJSONArray(a.f).put(optJSONArray2.optJSONObject(i2));
            }
        }
        try {
            jSONObject2.put("event", optJSONArray);
        } catch (JSONException unused3) {
            j.d("Collector", "mergeEvent error");
        }
        return jSONObject2;
    }

    public static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error", jSONArray);
            } catch (JSONException unused) {
                j.d("Collector", "mergeError error");
            }
            return jSONObject2;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("error");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    jSONArray.put(optJSONArray.get(i));
                }
            }
            jSONObject.put("error", jSONArray);
        } catch (JSONException unused2) {
            j.d("Collector", "mergeError error");
        }
        return jSONObject;
    }

    public static JSONObject a(boolean z, h hVar, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry next : hVar.c().entrySet()) {
            try {
                jSONObject2.put((String) next.getKey(), next.getValue());
            } catch (JSONException unused) {
                j.d("Collector", "convert hashParam to json error");
            }
        }
        jSONObject.put(str, jSONObject2);
        return z ? jSONObject : jSONObject2;
    }

    public static JSONObject a(EventEntity eventEntity) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", eventEntity.idString);
        jSONObject.put("ts", eventEntity.startTp);
        if (eventEntity.labelString != null && !"".equals(eventEntity.labelString)) {
            jSONObject.put("label", eventEntity.labelString);
        }
        if (eventEntity.udMap != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : eventEntity.udMap.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
            jSONObject.put("udmap", jSONObject2);
        }
        if (l.b(a.I)) {
            jSONObject.put(AIUIConstant.KEY_UID, a.I);
        }
        jSONObject.put("dur", eventEntity.durationLong);
        return jSONObject;
    }

    public static JSONObject a(ArrayList<EventEntity> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            synchronized (e.c) {
                Iterator<EventEntity> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(it.next()));
                }
            }
            jSONObject.put(a.f, jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            j.d("Collector", "convert event to Json error.");
            e.e();
            return null;
        }
    }

    public static JSONArray b(ArrayList<ErrorEntity> arrayList) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<ErrorEntity> it = arrayList.iterator();
            while (it.hasNext()) {
                ErrorEntity next = it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SpeechConstant.IST_SESSION_ID, next.sid);
                jSONObject.put("ts", next.startTp);
                jSONObject.put("msg", next.msg);
                jSONObject.put("app.ver.name", next.appver);
                jSONObject.put("type", next.errorType);
                if (l.b(a.I)) {
                    jSONObject.put(AIUIConstant.KEY_UID, a.I);
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (JSONException unused) {
            j.d("Collector", "convert error to Json error.");
            e.f();
            return null;
        }
    }

    public static long[] b(Context context) {
        try {
            com.iflytek.sunflower.util.a.a = g.e(context);
            long[] jArr = {com.iflytek.sunflower.util.a.a[0], com.iflytek.sunflower.util.a.a[1]};
            if (jArr[0] > 0) {
                if (jArr[1] > 0) {
                    SharedPreferences a = c.a(context);
                    long j = a.getLong("dntr", -2);
                    long j2 = a.getLong("uptr", -2);
                    if (j2 >= -1) {
                        if (j >= -1) {
                            jArr[0] = jArr[0] - j;
                            jArr[1] = jArr[1] - j2;
                            if (jArr[0] <= 0 || jArr[1] <= 0) {
                                return null;
                            }
                            return jArr;
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Exception unused) {
            j.c("Collector", "sdk less than 2.2 has get no traffic");
            return null;
        }
    }

    private static int c(Context context) {
        return c.a(context).getInt("age", -1);
    }

    private static int d(Context context) {
        return c.a(context).getInt("gender", -1);
    }

    private static String e(Context context) {
        return c.a(context).getString("user_id", "");
    }
}
