package com.iflytek.cloud.thirdparty;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.iflytek.common.LaunchService;
import java.util.List;

public class dj {
    private static dk a = null;
    private static int b = -1;

    public static synchronized void a(Context context) {
        synchronized (dj.class) {
            dr.a(context, "============start=============");
            dk a2 = dk.a(context);
            a = a2;
            a2.a();
            if (a.b()) {
                a.a(System.currentTimeMillis());
                dt.a.execute(new dm(context));
            }
            d(context);
        }
    }

    private static void a(Context context, ResolveInfo resolveInfo) {
        try {
            String str = resolveInfo.serviceInfo.packageName;
            if (!a.a(str)) {
                dr.a("LaunchImpl", "startService not need:" + str);
            } else if (!context.getPackageName().equals(str)) {
                Intent intent = new Intent("com.iflytek.common.ACTION_LAUNCH");
                intent.setPackage(str);
                ComponentName startService = context.startService(intent);
                dr.a(context, "start app:" + startService);
            }
        } catch (Exception e) {
            dr.b("LaunchImpl", "", e);
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (dj.class) {
            if (a == null) {
                a = dk.a(context);
            }
            a.a(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        List<ResolveInfo> list;
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.iflytek.common.ACTION_LAUNCH"), 224);
        } catch (Exception e) {
            dr.b("LaunchImpl", "", e);
            list = null;
        }
        if (list == null) {
            dr.b("LaunchImpl", "query action null");
            return;
        }
        for (ResolveInfo a2 : list) {
            a(context, a2);
        }
    }

    private static void d(Context context) {
        if (b != 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, LaunchService.class);
                if (context.startService(intent) != null) {
                    b = 1;
                }
            } catch (Exception unused) {
                b = 0;
                dr.b("LaunchImpl", "start self Service error");
            }
        }
    }
}
