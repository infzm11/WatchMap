package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.Version;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.util.ResourceUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ac {
    public static Map<String, ResourceUtil.RESOURCE_TYPE> a = new HashMap();
    private static Map<String, JSONObject> b = new HashMap();

    static {
        a.put(ResourceUtil.RESOURCE_TYPE.assets.name(), ResourceUtil.RESOURCE_TYPE.assets);
        a.put(ResourceUtil.RESOURCE_TYPE.path.name(), ResourceUtil.RESOURCE_TYPE.path);
        a.put(ResourceUtil.RESOURCE_TYPE.res.name(), ResourceUtil.RESOURCE_TYPE.res);
    }

    public static int a(String str, String str2, int i) {
        JSONObject c = c(str);
        return c == null ? i : c.optInt(str2, i);
    }

    public static ce a(ce ceVar) {
        String str;
        String str2;
        String str3;
        ce a2 = a(c("audioparams"));
        if (a2 != null) {
            ceVar.a(a2);
        }
        JSONObject c = c("attach_params");
        if (c != null) {
            ceVar.a("attach_params", c.toString());
        }
        b(ceVar);
        int a3 = ceVar.a("sample_rate", 16000);
        String a4 = a("speech", AIUIConstant.KEY_DATA_SOURCE, "sdk");
        ceVar.a("data_type", "audio", false);
        ceVar.a(AIUIConstant.KEY_DATA_SOURCE, a4, false);
        ceVar.a("data_format", "audio/L16;rate=" + a3, false);
        if (16000 == a3) {
            str = "iat";
            str2 = AIUIConstant.KEY_AUDIO_ENCODE;
            str3 = "speex-wb;10";
        } else {
            str = "iat";
            str2 = AIUIConstant.KEY_AUDIO_ENCODE;
            str3 = "speex;10";
        }
        ceVar.a(AIUIConstant.KEY_AUDIO_ENCODE, a(str, str2, str3), false);
        ceVar.a(i.a);
        return ceVar;
    }

    public static ce a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ce ceVar = new ce();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            ceVar.a(next, jSONObject.optString(next));
        }
        return ceVar;
    }

    public static ResourceUtil.RESOURCE_TYPE a(String str) {
        return a.get(str);
    }

    public static String a() {
        JSONObject c = c("userparams");
        if (c == null) {
            return "";
        }
        try {
            return bq.a(c.toString().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        synchronized (ac.class) {
            JSONObject c = c(str);
            if (c == null) {
                return str3;
            }
            String optString = c.optString(str2, str3);
            return optString;
        }
    }

    public static boolean a(String str, String str2, boolean z) {
        JSONObject c = c(str);
        if (c == null) {
            return z;
        }
        String optString = c.optString(str2);
        return TextUtils.isEmpty(optString) ? z : !"0".equals(optString);
    }

    private static boolean a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return false;
        }
        if (b.containsKey(str)) {
            JSONObject jSONObject2 = b.get(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        b.put(str, jSONObject);
        return true;
    }

    private static String[] a(String str, String str2) {
        String[] split = str.split(str2);
        if (split == null || 2 != split.length) {
            return null;
        }
        return split;
    }

    public static String b() {
        return a("login", "appid", "");
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        String str;
        String c;
        if (jSONObject.has("appid")) {
            str = "appid";
            c = b();
        } else if (!jSONObject.has(AIUIConstant.KEY_UID)) {
            return jSONObject;
        } else {
            str = AIUIConstant.KEY_UID;
            c = c();
        }
        jSONObject.put(str, c);
        return jSONObject;
    }

    public static void b(ce ceVar) {
        if (ceVar != null) {
            ceVar.a("sdk_ver", Version.getVersion());
            ceVar.a("ver_type", Version.getVersionType());
            ceVar.a("dev_lang", "java");
            ceVar.a("os", "android");
        }
    }

    public static void b(String str, String str2, String str3) {
        synchronized (ac.class) {
            JSONObject c = c(str);
            if (c == null) {
                c = new JSONObject();
                a(str, c);
            }
            try {
                c.put(str2, str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    a(next, jSONObject.getJSONObject(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String c() {
        return SpeechUtility.getUtility() != null ? SpeechUtility.getUtility().getParameter(AIUIConstant.KEY_UID) : "";
    }

    public static String c(ce ceVar) {
        ce b2 = ceVar.clone();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            String d = b2.d("dtype");
            String d2 = b2.d("stmid");
            jSONObject3.put("dtype", d);
            jSONObject3.put("stmid", d2);
            if (b2.g("dsrc")) {
                jSONObject3.put("dsrc", b2.d("dsrc"));
            }
            jSONObject3.put("ver_type", Version.getVersionType());
            String a2 = al.a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject3.put("wake_id", a2);
            }
            if (b2.g("scene")) {
                jSONObject3.put("scene", b2.d("scene"));
            }
            if (b2.g("msc.lng")) {
                String d3 = b2.d("msc.lng");
                String d4 = b2.d("msc.lat");
                jSONObject3.put("msc.lng", d3);
                jSONObject3.put("msc.lat", d4);
            }
            if (b2.g("event")) {
                String d5 = b2.d("event");
                String d6 = b2.d("state");
                String d7 = b2.d("last_state");
                String d8 = b2.d("event_only");
                String d9 = b2.d("operation");
                String d10 = b2.d("source");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("name", d5);
                jSONObject4.put("source", d10);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("name", d9);
                jSONObject4.put("operation", jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("name", d6);
                jSONObject6.put("last_state", d7);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("event", jSONObject4);
                jSONObject7.put("state", jSONObject6);
                jSONObject3.put("status", jSONObject7);
                jSONObject3.put("event_only", d8);
                if ("wakeup".equals(d5) || "re_wakeup".equals(d5)) {
                    jSONObject3.put(AIUIConstant.KEY_INTERACT_MODE, a("speech", AIUIConstant.KEY_INTERACT_MODE, AIUIConstant.INTERACT_MODE_CONTINUOUS));
                }
            }
            String d11 = b2.d("userparams");
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject8 = new JSONObject();
            String d12 = b2.d("dtf");
            String d13 = b2.d("dte");
            jSONObject8.put("cnt_id", "0");
            jSONObject8.put("dtf", d12);
            jSONObject8.put("dte", d13);
            jSONArray2.put(jSONObject8);
            HashMap<String, String> c = b2.c();
            Set<String> keySet = c.keySet();
            if (keySet != null && !keySet.isEmpty()) {
                for (String next : keySet) {
                    String str = c.get(next);
                    if (next.equals("pers_param")) {
                        str = f(str);
                    }
                    jSONObject3.put(next, str);
                }
            }
            jSONObject2.put(SpeechConstant.PARAMS, jSONObject3);
            jSONObject2.put("userparams", d11);
            jSONObject2.put(AIUIConstant.KEY_CONTENT, jSONArray2);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static JSONObject c(String str) {
        return b.get(str);
    }

    public static ce d(String str) {
        return a(c(str));
    }

    public static String d(ce ceVar) {
        String e = ceVar.e("stmid");
        String e2 = ceVar.e("dtype");
        String e3 = ceVar.e("dts");
        String e4 = ceVar.e("dtf");
        String e5 = ceVar.e("dte");
        StringBuilder sb = new StringBuilder();
        sb.append("stmid");
        sb.append("=");
        sb.append(e);
        sb.append(",");
        sb.append("dtype");
        sb.append("=");
        sb.append(e2);
        sb.append(",");
        sb.append("dts");
        sb.append("=");
        sb.append(e3);
        sb.append(",");
        sb.append("cnt_id");
        sb.append("=");
        sb.append("0");
        if (!TextUtils.isEmpty(e4)) {
            sb.append(",");
            sb.append("dtf");
            sb.append("=");
            sb.append(e4);
            sb.append(",");
            sb.append("dte");
            sb.append("=");
            sb.append(e5);
        }
        return sb.toString();
    }

    public static ce e(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ce();
        }
        Matcher matcher = Pattern.compile(",[ ]*[\\w\\.:]+=").matcher(str);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (matcher.find()) {
            String substring = str.substring(i, matcher.start());
            int start = matcher.start() + 1;
            String[] a2 = a(substring, "=");
            if (a2 != null) {
                hashMap.put(a2[0], a2[1]);
            }
            i = start;
        }
        String[] a3 = a(str.substring(i), "=");
        if (a3 != null) {
            hashMap.put(a3[0], a3[1]);
        }
        ce ceVar = new ce();
        for (Map.Entry entry : hashMap.entrySet()) {
            ceVar.a(((String) entry.getKey()).trim(), (String) entry.getValue());
        }
        return ceVar;
    }

    private static String f(String str) {
        try {
            return b(new JSONObject(str)).toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }
}
