package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: OffsetUtil */
public final class ct {
    static double a = 3.141592653589793d;

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint a(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return a(context, new DPoint(d2, d));
    }

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String a2 = r.a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a2) && new File(a2).exists() && !CoordUtil.isLoadedSo()) {
            try {
                System.load(a2);
                CoordUtil.setLoadedSo(true);
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                cs.a(th, "OffsetUtil", "offset");
            }
        }
        return a(dPoint, CoordUtil.isLoadedSo());
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint == null) {
            return dPoint;
        }
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        DPoint dPoint2 = null;
        int i = 0;
        while (i < 2) {
            try {
                double longitude = dPoint.getLongitude();
                double latitude = dPoint.getLatitude();
                DPoint dPoint3 = new DPoint();
                double d3 = longitude - d;
                double d4 = latitude - d2;
                DPoint dPoint4 = new DPoint();
                double d5 = latitude;
                double d6 = (d3 * d3) + (d4 * d4);
                int i2 = i;
                dPoint4.setLongitude(c((Math.cos(b(d3) + Math.atan2(d4, d3)) * (a(d4) + Math.sqrt(d6))) + 0.0065d));
                dPoint4.setLatitude(c((Math.sin(b(d3) + Math.atan2(d4, d3)) * (a(d4) + Math.sqrt(d6))) + 0.006d));
                dPoint2 = dPoint3;
                dPoint2.setLongitude(c((longitude + d3) - dPoint4.getLongitude()));
                dPoint2.setLatitude(c((d5 + d4) - dPoint4.getLatitude()));
                d = dPoint.getLongitude() - dPoint2.getLongitude();
                d2 = dPoint.getLatitude() - dPoint2.getLatitude();
                i = i2 + 1;
            } catch (Throwable th) {
                cs.a(th, "OffsetUtil", "B2G");
                return dPoint;
            }
        }
        return dPoint2;
    }

    private static DPoint a(DPoint dPoint, boolean z) {
        double longitude;
        double latitude;
        try {
            if (!cs.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                        longitude = dPoint.getLongitude();
                        latitude = dPoint.getLatitude();
                    }
                } catch (Throwable th) {
                    cs.a(th, "OffsetUtil", "cover part1");
                    longitude = dPoint.getLongitude();
                    latitude = dPoint.getLatitude();
                }
                return new DPoint(dArr[1], dArr[0]);
            }
            longitude = dPoint.getLongitude();
            latitude = dPoint.getLatitude();
            dArr = db.a(longitude, latitude);
            return new DPoint(dArr[1], dArr[0]);
        } catch (Throwable th2) {
            cs.a(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            double longitude = (double) (((long) (dPoint.getLongitude() * 100000.0d)) % 36000000);
            double latitude = (double) (((long) (dPoint.getLatitude() * 100000.0d)) % 36000000);
            double d = (double) ((int) ((-a(longitude, latitude)) + longitude));
            double d2 = (double) ((int) ((-b(longitude, latitude)) + latitude));
            int i = 1;
            double d3 = (double) ((int) ((-a(d, d2)) + longitude + ((double) (longitude > 0.0d ? 1 : -1))));
            double d4 = (-b(d3, d2)) + latitude;
            if (latitude <= 0.0d) {
                i = -1;
            }
            return a(context, new DPoint(((double) ((int) (d4 + ((double) i)))) / 100000.0d, d3 / 100000.0d));
        } catch (Throwable th) {
            cs.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }
}
