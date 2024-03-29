package com.amap.api.location;

import android.content.Context;
import com.loc.cs;
import com.loc.ct;
import com.loc.da;

public class CoordinateConverter {
    DPoint a = null;
    private Context b;
    private CoordType c = null;
    private DPoint d = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.b = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return da.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return cs.a(d2, d3);
    }

    public synchronized DPoint convert() throws Exception {
        DPoint a2;
        if (this.c == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        } else if (this.d == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        } else {
            if (this.d.getLongitude() <= 180.0d) {
                if (this.d.getLongitude() >= -180.0d) {
                    if (this.d.getLatitude() <= 90.0d) {
                        if (this.d.getLatitude() >= -90.0d) {
                            switch (this.c) {
                                case BAIDU:
                                    a2 = ct.a(this.d);
                                    break;
                                case MAPBAR:
                                    a2 = ct.b(this.b, this.d);
                                    break;
                                case MAPABC:
                                case SOSOMAP:
                                case ALIYUN:
                                case GOOGLE:
                                    a2 = this.d;
                                    break;
                                case GPS:
                                    a2 = ct.a(this.b, this.d);
                                    break;
                            }
                            this.a = a2;
                        }
                    }
                    throw new IllegalArgumentException("请传入合理纬度");
                }
            }
            throw new IllegalArgumentException("请传入合理经度");
        }
        return this.a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            try {
                throw new IllegalArgumentException("传入经纬度对象为空");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            if (dPoint.getLongitude() <= 180.0d) {
                if (dPoint.getLongitude() >= -180.0d) {
                    if (dPoint.getLatitude() <= 90.0d) {
                        if (dPoint.getLatitude() >= -90.0d) {
                            this.d = dPoint;
                        }
                    }
                    throw new IllegalArgumentException("请传入合理纬度");
                }
            }
            throw new IllegalArgumentException("请传入合理经度");
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.c = coordType;
        return this;
    }
}
