package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechError;
import com.iflytek.speech.VoiceWakeuperAidl;

public class bz {
    public static String a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            String lowerCase = networkInfo.getExtraInfo().toLowerCase();
            return TextUtils.isEmpty(lowerCase) ? "none" : !lowerCase.startsWith("3gwap") ? lowerCase.startsWith("uniwap") ? "uniwap" : lowerCase.startsWith("cmwap") ? "cmwap" : lowerCase.startsWith("ctwap") ? "ctwap" : lowerCase.startsWith("ctnet") ? "ctnet" : lowerCase : "uniwap";
        } catch (Exception e) {
            cb.a(e.toString());
            return "none";
        }
    }

    public static void a(Context context) throws SpeechError {
        if (context != null) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
                if (allNetworkInfo != null && allNetworkInfo.length > 0) {
                    int length = allNetworkInfo.length;
                    int i = 0;
                    while (i < length) {
                        NetworkInfo networkInfo = allNetworkInfo[i];
                        if (networkInfo != null && !networkInfo.isConnectedOrConnecting()) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                throw new SpeechError(20001);
            } catch (SecurityException e) {
                cb.a("check network failed: " + e.getLocalizedMessage());
            }
        }
    }

    private static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "none";
            }
            String str = "" + networkInfo.getSubtypeName();
            return str + VoiceWakeuperAidl.PARAMS_SEPARATE + networkInfo.getSubtype();
        } catch (Exception e) {
            cb.a(e.toString());
            return "none";
        }
    }

    public static boolean b(Context context) {
        if (a(context, "android.permission.INTERNET")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }
    }
}
