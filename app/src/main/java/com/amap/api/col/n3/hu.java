package com.amap.api.col.n3;

import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: VEarthProjection */
public final class hu {
    private static int a = 1;

    private static double a(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    public static IPoint a(double d, double d2) {
        IPoint iPoint = new IPoint();
        double sin = Math.sin((a(d, -85.0511287798d, 85.0511287798d) * 3.141592653589793d) / 180.0d);
        iPoint.x = (int) a((((6378137.0d * ((a(d2, -180.0d, 180.0d) * 3.141592653589793d) / 180.0d)) + 2.0037508342789244E7d) / 0.14929107086948487d) + 0.5d, 0.0d, 2.68435455E8d);
        iPoint.y = (int) a((((double) ((long) (2.0037508342789244E7d - (3189068.0d * Math.log((1.0d + sin) / (1.0d - sin)))))) / 0.14929107086948487d) + 0.5d, 0.0d, 2.68435455E8d);
        return iPoint;
    }

    public static DPoint a(long j, long j2) {
        DPoint dPoint = new DPoint();
        dPoint.y = 1.5707963267948966d - (2.0d * Math.atan(Math.exp((-(2.0037508342789244E7d - (((double) j2) * 0.14929107086948487d))) / 6378137.0d)));
        dPoint.y *= 57.29577951308232d;
        dPoint.x = ((((double) j) * 0.14929107086948487d) - 2.0037508342789244E7d) / 6378137.0d;
        dPoint.x *= 57.29577951308232d;
        return dPoint;
    }
}
