package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: StatisticsUtil */
public class af {
    static di a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 == null) {
                return;
            }
            if (a2.length() >= 1) {
                if (a == null) {
                    a = new di(context, "sea", "5.3.1", "O002");
                }
                a.a(a2);
                dj.a(a, context);
            }
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{" + "\"RequestPath\":" + "\"" + str + "\"" + "," + "\"ResponseTime\":" + j + "," + "\"Success\":" + z + "}";
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null && aMapException != null) {
            String errorType = aMapException.getErrorType();
            String a2 = a(aMapException);
            if (a2 != null && a2.length() >= 1) {
                bo.a(h.a(true), str, errorType, str2, a2);
            }
        }
    }

    private static String a(AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() == 0) {
            int errorCode = aMapException.getErrorCode();
            if (errorCode == 0) {
                return "4";
            }
            int pow = (int) Math.pow(10.0d, Math.floor(Math.log10((double) errorCode)));
            return ((errorCode % pow) + (4 * pow)) + "";
        }
        return aMapException.getErrorCode() + "";
    }
}
