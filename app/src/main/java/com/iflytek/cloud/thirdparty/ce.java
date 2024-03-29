package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ce {
    HashMap<String, String> a = new HashMap<>();

    public ce() {
    }

    public ce(String str, String[][] strArr) {
        a(str);
        a(strArr);
    }

    public static int b(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public static boolean b(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equals("true") || str.equals("1")) {
            return true;
        }
        if (str.equals("false") || str.equals("0")) {
            return false;
        }
        return z;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("[,\n ]", "|");
    }

    public int a(String str, int i) {
        return b(this.a.get(str), i);
    }

    public void a() {
        this.a.clear();
    }

    public void a(ce ceVar) {
        if (ceVar != null) {
            this.a.putAll(ceVar.c());
        }
    }

    public void a(ce ceVar, String str) {
        if (ceVar != null) {
            a(str, ceVar.e(str));
        }
    }

    public void a(String str) {
        this.a.clear();
        b(str);
    }

    public void a(String str, String str2) {
        a(str, str2, true);
    }

    public void a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (z || !this.a.containsKey(str)) {
                this.a.put(str, str2);
            }
        }
    }

    public void a(String[][] strArr) {
        if (strArr != null) {
            for (String[] strArr2 : strArr) {
                if (this.a.containsKey(strArr2[0])) {
                    String str = this.a.get(strArr2[0]);
                    this.a.remove(strArr2[0]);
                    for (int i = 1; i < strArr2.length; i++) {
                        this.a.put(strArr2[i], str);
                    }
                }
            }
        }
    }

    public boolean a(String str, boolean z) {
        return b(this.a.get(str), z);
    }

    /* renamed from: b */
    public ce clone() {
        ce ceVar = new ce();
        ceVar.a = (HashMap) this.a.clone();
        return ceVar;
    }

    public String b(String str, String str2) {
        String str3 = this.a.get(str);
        return str3 == null ? str2 : str3;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                int indexOf = str2.indexOf("=");
                if (indexOf > 0 && indexOf < str2.length()) {
                    this.a.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                }
            }
        }
    }

    public Boolean c(String str) {
        return Boolean.valueOf(this.a.remove(str) != null);
    }

    public HashMap<String, String> c() {
        return this.a;
    }

    public String d(String str) {
        return this.a.remove(str);
    }

    public void d() {
        for (Map.Entry next : this.a.entrySet()) {
            next.setValue(f((String) next.getValue()));
        }
    }

    public String e(String str) {
        return this.a.get(str);
    }

    public boolean g(String str) {
        return this.a.containsKey(str);
    }

    public String toString() {
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
        String stringBuffer2 = stringBuffer.toString();
        cb.d(stringBuffer2);
        return stringBuffer2;
    }
}
