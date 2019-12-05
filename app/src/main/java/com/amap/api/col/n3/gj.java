package com.amap.api.col.n3;

import android.content.Context;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BasicLBSRestHandler */
public abstract class gj<T, V> extends gi<T, V> {
    public final Map<String, String> b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String e();

    public gj(Context context, T t) {
        super(context, t);
    }

    public final byte[] f() {
        try {
            String e = e();
            String[] split = e.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String c : split) {
                stringBuffer.append(c(c));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            String str = stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : e;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(e);
            String a = ig.a();
            stringBuffer3.append("&ts=" + a);
            stringBuffer3.append("&scode=" + ig.a(this.d, a, str));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP_SDK_Android_NAVI_5.4.0");
        Context context = this.d;
        hq.a();
        hashMap.put("X-INFO", ig.c(context));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"5.4.0", "navi"}));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    protected static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable unused) {
            return "";
        }
    }
}
