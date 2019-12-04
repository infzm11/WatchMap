package com.iflytek.sunflower.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l {
    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean b(CharSequence charSequence) {
        return !a(charSequence);
    }

    public static boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.contains(str2);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return b(str, "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
    }

    public static String b(String str, String str2) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        matcher.find();
        return matcher.replaceAll("");
    }
}
