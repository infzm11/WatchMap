package com.iflytek.sunflower.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.iflytek.speech.VoiceWakeuperAidl;

public class k {
    public static String a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            String lowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (l.a((CharSequence) lowerCase)) {
                return "";
            }
            if (lowerCase.startsWith("3gwap")) {
                return "uniwap";
            }
            if (lowerCase.startsWith("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.startsWith("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.startsWith("ctwap")) {
                return "ctwap";
            }
            return lowerCase.startsWith("ctnet") ? "ctnet" : lowerCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(Context context) {
        if (!a(context, "android.permission.INTERNET")) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String b(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "";
            }
            String str = "" + networkInfo.getSubtypeName();
            return str + VoiceWakeuperAidl.PARAMS_SEPARATE + networkInfo.getSubtype();
        } catch (Exception unused) {
            return "";
        }
    }
}
