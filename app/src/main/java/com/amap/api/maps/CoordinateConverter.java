package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.n3.ab;
import com.amap.api.col.n3.dq;
import com.amap.api.col.n3.iu;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter {
    private Context a;
    private CoordType b = null;
    private LatLng c = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.a = context;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public LatLng convert() {
        LatLng latLng = null;
        if (this.b == null || this.c == null) {
            return null;
        }
        try {
            switch (this.b) {
                case BAIDU:
                    return ab.a(this.c);
                case MAPBAR:
                    return ab.b(this.a, this.c);
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    return this.c;
                case GPS:
                    latLng = ab.a(this.a, this.c);
                    break;
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "CoordinateConverter", "convert");
            return this.c;
        }
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return dq.a(d, d2);
    }
}
