package com.amap.api.col.n3;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SPutils */
public final class hf {
    public static String a(int i) {
        if (i == 6) {
            return "算路失败,终点错误";
        }
        if (i == 17) {
            return "算路失败,请求超出配额";
        }
        if (i == 20) {
            return "算路失败,路线距离太长";
        }
        if (i == 22) {
            return "算路失败,MD5安全码未通过验证";
        }
        switch (i) {
            case 2:
                return "算路失败,网络超时或网络失败";
            case 3:
                return "算路失败,起点错误";
            default:
                switch (i) {
                    case 10:
                        return "算路失败,起点没有找到道路";
                    case 11:
                        return "算路失败,终点没有找到道路";
                    case 12:
                        return "算路失败,途径点没有找到道路";
                    case 13:
                        return "算路失败,key非法或过期";
                    default:
                        return "算路失败,请稍后重试";
                }
        }
    }

    public static void a(Context context, boolean z) {
        a(context, "NAVI_STRATEGY_TAB1", z);
    }

    public static void b(Context context, boolean z) {
        a(context, "NAVI_STRATEGY_TAB2", z);
    }

    public static void c(Context context, boolean z) {
        a(context, "NAVI_STRATEGY_TAB3", z);
    }

    public static void d(Context context, boolean z) {
        a(context, "NAVI_STRATEGY_TAB4", z);
    }

    private static void a(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("NAVI_STRATEGY", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static boolean a(Context context, String str) {
        return context.getSharedPreferences("NAVI_STRATEGY", 0).getBoolean(str, false);
    }
}
