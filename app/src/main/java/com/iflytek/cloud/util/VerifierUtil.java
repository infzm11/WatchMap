package com.iflytek.cloud.util;

import android.graphics.Bitmap;
import com.iflytek.msc.MSC;
import java.util.Random;

public class VerifierUtil {
    public static Bitmap ARGB2Gray(Bitmap bitmap) {
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ALPHA_8);
        if (!a(bitmap, createBitmap)) {
            return null;
        }
        return createBitmap;
    }

    private static boolean a(Bitmap bitmap, Bitmap bitmap2) {
        return MSC.doARGB2Gray(bitmap, bitmap2);
    }

    public static String generateNumberPassword(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        new Random();
        String str = "023456789".charAt(r1.nextInt("023456789".length())) + "";
        stringBuffer.append(str);
        String str2 = str;
        for (int i2 = 0; i2 < i - 1; i2++) {
            while (true) {
                Boolean bool = false;
                while (!bool.booleanValue()) {
                    str2 = "023456789".charAt(r1.nextInt("023456789".length())) + "";
                    if (stringBuffer.indexOf(str2) < 0) {
                        if (Integer.parseInt(stringBuffer.charAt(stringBuffer.length() - 1) + "") * Integer.parseInt(str2) != 10) {
                            bool = true;
                        }
                    }
                }
                break;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public static int getBitmapsize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
