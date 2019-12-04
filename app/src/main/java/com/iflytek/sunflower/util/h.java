package com.iflytek.sunflower.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class h {
    HashMap<String, String> a = new HashMap<>();

    public void a() {
        this.a.clear();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                int indexOf = str2.indexOf("=");
                if (indexOf > 0 && indexOf < str2.length()) {
                    this.a.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                }
            }
        }
    }

    /* renamed from: b */
    public h clone() {
        h hVar = new h();
        for (Map.Entry next : this.a.entrySet()) {
            hVar.a((String) next.getKey(), (String) next.getValue());
        }
        return hVar;
    }

    public void a(String str, String str2) {
        a(str, str2, true);
    }

    public HashMap<String, String> c() {
        return this.a;
    }

    public void a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (z || !this.a.containsKey(str)) {
                this.a.put(str, str2);
            }
        }
    }

    public String toString() {
        e();
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : this.a.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) next.getValue());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public String d() {
        e();
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : this.a.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) next.getValue());
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public String b(String str) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        return this.a.get(str);
    }

    public void e() {
        for (Map.Entry next : this.a.entrySet()) {
            String replaceAll = ((String) next.getValue()).replaceAll("[,\n ]", "|");
            if (replaceAll.length() > 124) {
                replaceAll = replaceAll.substring(0, 124);
            }
            next.setValue(replaceAll);
        }
    }
}
