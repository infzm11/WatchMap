package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: OffsetUtil */
public final class ab {
    static double a = 3.141592653589793d;
    private static boolean b = false;

    public static LatLng a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        String a2 = il.a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a2) && new File(a2).exists() && !b) {
            try {
                System.load(a2);
                b = true;
            } catch (Throwable unused) {
            }
        }
        DPoint a3 = a(DPoint.obtain(latLng.longitude, latLng.latitude), b);
        LatLng latLng2 = new LatLng(a3.y, a3.x, false);
        a3.recycle();
        return latLng2;
    }

    private static DPoint a(DPoint dPoint, boolean z) {
        try {
            if (!dq.a(dPoint.y, dPoint.x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                if (CoordUtil.convertToGcj(new double[]{dPoint.x, dPoint.y}, dArr) != 0) {
                    dArr = ku.a(dPoint.x, dPoint.y);
                }
                dPoint.recycle();
                return DPoint.obtain(dArr[0], dArr[1]);
            }
            dArr = ku.a(dPoint.x, dPoint.y);
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    public static LatLng b(Context context, LatLng latLng) {
        LatLng latLng2 = latLng;
        try {
            double d = (double) (((long) (latLng2.longitude * 100000.0d)) % 36000000);
            double d2 = (double) (((long) (latLng2.latitude * 100000.0d)) % 36000000);
            double d3 = (double) ((int) ((-a(d, d2)) + d));
            double d4 = (double) ((int) ((-b(d, d2)) + d2));
            int i = -1;
            double d5 = (double) ((int) ((-a(d3, d4)) + d + ((double) (d > 0.0d ? 1 : -1))));
            double d6 = (-b(d5, d4)) + d2;
            if (d2 > 0.0d) {
                i = 1;
            }
            DPoint obtain = DPoint.obtain(d5 / 100000.0d, ((double) ((int) (d6 + ((double) i)))) / 100000.0d);
            LatLng latLng3 = new LatLng(obtain.y, obtain.x, false);
            LatLng a2 = a(context, latLng3);
            obtain.recycle();
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng2;
        }
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static LatLng a(LatLng latLng) {
        LatLng latLng2 = latLng;
        if (latLng2 != null) {
            try {
                double d = latLng2.longitude;
                double d2 = latLng2.latitude;
                double d3 = 0.006401062d;
                double d4 = 0.0060424805d;
                DPoint dPoint = null;
                int i = 0;
                while (i < 2) {
                    DPoint obtain = DPoint.obtain();
                    double d5 = d - d3;
                    double d6 = d2 - d4;
                    DPoint obtain2 = DPoint.obtain();
                    double d7 = d2;
                    double d8 = (d5 * d5) + (d6 * d6);
                    obtain2.x = c((Math.cos(b(d5) + Math.atan2(d6, d5)) * (a(d6) + Math.sqrt(d8))) + 0.0065d);
                    obtain2.y = c((Math.sin(b(d5) + Math.atan2(d6, d5)) * (a(d6) + Math.sqrt(d8))) + 0.006d);
                    double c = c((d5 + d) - obtain2.x);
                    DPoint dPoint2 = obtain;
                    dPoint2.x = c;
                    dPoint2.y = c((d7 + d6) - obtain2.y);
                    d4 = d7 - dPoint2.y;
                    i++;
                    dPoint = dPoint2;
                    d3 = d - dPoint2.x;
                    d2 = d7;
                }
                LatLng latLng3 = new LatLng(dPoint.y, dPoint.x, false);
                dPoint.recycle();
                return latLng3;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng2;
    }

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }
}
