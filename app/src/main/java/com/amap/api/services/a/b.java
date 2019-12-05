package com.amap.api.services.a;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BasicLBSRestHandler */
public abstract class b<T, V> extends a<T, V> {
    public Map<String, String> d() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String g();

    public b(Context context, T t) {
        super(context, t);
    }

    public byte[] h() {
        try {
            String g = g();
            String b = b(g);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(g);
            String a = bc.a();
            stringBuffer.append("&ts=" + a);
            stringBuffer.append("&scode=" + bc.a(this.d, a, b));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            i.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 5.3.1");
        hashMap.put("X-INFO", bc.a(this.d, o.a, (Map<String, String>) null, false));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"5.3.1", "sea"}));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public String b(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String d : split) {
            stringBuffer.append(d(d));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    /* access modifiers changed from: protected */
    public String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
