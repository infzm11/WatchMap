package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class al {
    private static Map<String, Long> a = new HashMap();
    private static String b = "";
    private static Object c = new Object();
    private static Object d = new Object();

    public static String a() {
        String str;
        synchronized (d) {
            str = b;
        }
        return str;
    }

    public static String a(Context context, long j, String str) {
        String str2;
        synchronized (d) {
            String a2 = ca.a(context);
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append(bu.a(j + str + a2).substring(8, 24));
            b = sb.toString();
            str2 = b;
        }
        return str2;
    }

    public static String a(String str) {
        String format;
        synchronized (c) {
            long j = 1;
            if (a.containsKey(str)) {
                j = (a.get(str).longValue() + 1) & 65535;
            }
            a.put(str, Long.valueOf(j));
            format = String.format(Locale.ENGLISH, "%s-%d", new Object[]{str, Long.valueOf(j)});
        }
        return format;
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        try {
            String substring = String.format("%x", new Object[]{Long.valueOf(System.currentTimeMillis() - 1285862400000L)}).substring(0, 8);
            if (!TextUtils.isEmpty(str3)) {
                str4 = String.format("%08x", new Object[]{Long.valueOf(Long.parseLong(str3.substring(1)))});
            } else {
                str4 = "00000000";
            }
            String substring2 = str4.substring(2, 6);
            String substring3 = str4.substring(6, 8);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(str);
            stringBuffer.append("@");
            stringBuffer.append("ch");
            stringBuffer.append(substring2);
            stringBuffer.append(substring);
            stringBuffer.append("460d");
            stringBuffer.append(substring3);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void b() {
        synchronized (d) {
            b = "";
        }
    }
}
