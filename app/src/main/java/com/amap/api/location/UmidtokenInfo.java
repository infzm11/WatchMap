package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.loc.cs;
import com.loc.n;

public class UmidtokenInfo {
    static AMapLocationClient a = null;
    static Handler b = new Handler();
    static String c = null;
    static boolean d = true;
    private static long e = 30000;

    static class a implements AMapLocationListener {
        a() {
        }

        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.a != null) {
                    UmidtokenInfo.b.removeCallbacksAndMessages((Object) null);
                    UmidtokenInfo.a.onDestroy();
                }
            } catch (Throwable th) {
                cs.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return c;
    }

    public static void setLocAble(boolean z) {
        d = z;
    }

    public static void setUmidtoken(Context context, String str) {
        try {
            c = str;
            n.a(str);
            if (a == null && d) {
                a aVar = new a();
                a = new AMapLocationClient(context);
                AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                aMapLocationClientOption.setOnceLocation(true);
                aMapLocationClientOption.setNeedAddress(false);
                a.setLocationOption(aMapLocationClientOption);
                a.setLocationListener(aVar);
                a.startLocation();
                b.postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            if (UmidtokenInfo.a != null) {
                                UmidtokenInfo.a.onDestroy();
                            }
                        } catch (Throwable th) {
                            cs.a(th, "UmidListener", "postDelayed");
                        }
                    }
                }, 30000);
            }
        } catch (Throwable th) {
            cs.a(th, "UmidListener", "setUmidtoken");
        }
    }
}
