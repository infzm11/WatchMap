package com.iflytek.sunflower.entity;

import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UserEntity {
    private final String a = "UserEntity";
    public String uId;
    public String uMail;
    public Map<String, String> uMap;
    public String uName;
    public String uNumber;
    public String uType;

    public void setUmap(Map<String, String> map) {
        this.uMap = map;
    }

    public void setuId(String str) {
        this.uId = str;
    }

    public void setuMail(String str) {
        this.uMail = str;
    }

    public void setuName(String str) {
        this.uName = str;
    }

    public void setUNumber(String str) {
        this.uNumber = str;
    }

    public void setUtype(String str) {
        this.uType = str;
    }

    public String toString() {
        JSONObject compose2Json = compose2Json();
        return compose2Json != null ? compose2Json.toString() : "";
    }

    public JSONObject compose2Json() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uType", this.uType);
            jSONObject.put("uMail", this.uMail);
            jSONObject.put("uName", this.uName);
            jSONObject.put("uId", this.uId);
            jSONObject.put("uNumber", this.uNumber);
            if (this.uMap != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : this.uMap.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                jSONObject.put("uMap", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e) {
            j.d("UserEntity", "compose2Json failed:" + e);
            return null;
        }
    }

    public HashMap<String, String> compose2Map() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!l.b(this.uType) || !l.b(this.uId)) {
            j.d("UserEntity", "uId or type was null");
            return null;
        }
        hashMap.put("uType", this.uType);
        hashMap.put("uId", this.uId);
        if (l.b(this.uName)) {
            hashMap.put("uName", this.uName);
        }
        if (l.b(this.uMail)) {
            hashMap.put("uMail", this.uMail);
        }
        if (l.b(this.uNumber)) {
            hashMap.put("uNumber", this.uNumber);
        }
        if (this.uMap != null) {
            for (Map.Entry next : this.uMap.entrySet()) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return hashMap;
    }
}
