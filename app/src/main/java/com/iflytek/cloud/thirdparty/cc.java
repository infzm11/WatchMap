package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import java.util.LinkedHashMap;

public class cc {
    public static LinkedHashMap<String, String> a = new LinkedHashMap<>();
    private static String b = "=";
    private static String c = ":";
    private static String d = ";";
    private static String e = "=========================================================\r\n";
    private static boolean f = false;

    public static synchronized void a(String str, String str2) {
        String str3;
        synchronized (cc.class) {
            if (f) {
                cb.d("appendInfo:" + str + "," + str2);
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str2 + c;
                } else {
                    str3 = "";
                }
                a.put(str, str3 + System.currentTimeMillis());
            }
        }
    }
}
