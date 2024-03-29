package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.a.i;
import java.security.MessageDigest;
import java.util.Locale;

public class SearchUtils {
    public static String getVersion() {
        return "5.3.1";
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(255 & b).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            i.a(th, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getPkgName(Context context) {
        try {
            return context.getApplicationContext().getPackageName();
        } catch (Throwable th) {
            i.a(th, "SearchUtils", "getPkgName");
            return null;
        }
    }
}
