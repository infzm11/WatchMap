package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;

public class dp {
    private String a;
    private String b;
    private String c;
    private String d;
    private TelephonyManager e;

    public dp(Context context) {
        this.e = (TelephonyManager) context.getSystemService("phone");
        a();
        this.d = a(context);
        String str = Build.VERSION.SDK_INT > 7 ? Build.HARDWARE : "";
        this.c = "Android";
        this.b = String.valueOf(a("MANUFACTURER")) + "|" + a("MODEL") + "|" + a("PRODUCT") + "|ANDROID" + Build.VERSION.RELEASE + "|" + this.d + "|" + str;
    }

    private String a(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getOrientation() == 0) {
            i2 = defaultDisplay.getWidth();
            i = defaultDisplay.getHeight();
        } else {
            i2 = defaultDisplay.getHeight();
            i = defaultDisplay.getWidth();
        }
        return i2 + "*" + i;
    }

    private String a(String str) {
        try {
            Field field = Build.class.getField(str);
            return field != null ? field.get(new Build()).toString() : "";
        } catch (Exception e2) {
            dr.a("", "", e2);
            return "";
        }
    }

    public String a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                this.a = this.e.getDeviceId();
                dr.a("", "getIMEI:" + this.a);
            }
        } catch (Exception e2) {
            dr.a("", "", e2);
        }
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
