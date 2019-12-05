package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

public class SpatialRelationUtil {
    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng next : list) {
                        arrayList.add(DPoint.obtain(next.latitude, next.longitude));
                        if (next.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint((List<DPoint>) arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 == null || dPoint2 == null || list.size() == 0 || list.size() < 2) {
            return null;
        }
        int i = 0;
        double d = 0.0d;
        DPoint dPoint3 = null;
        while (i < list.size() - 1) {
            if (i == 0) {
                dPoint3 = list2.get(i);
                if (dPoint3.equals(dPoint2)) {
                    return new Pair<>(Integer.valueOf(i), dPoint2);
                }
            }
            int i2 = i + 1;
            DPoint dPoint4 = list2.get(i2);
            if (dPoint4.equals(dPoint2)) {
                return new Pair<>(Integer.valueOf(i2), dPoint2);
            }
            int i3 = i2;
            double d2 = d;
            Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.x, dPoint2.y, dPoint3.x, dPoint3.y, dPoint4.x, dPoint4.y);
            if (pair2 == null) {
                doubleValue = ((Double) pointToSegDist.first).doubleValue();
                pair = new Pair<>(Integer.valueOf(i), pointToSegDist.second);
            } else if (d2 > ((Double) pointToSegDist.first).doubleValue()) {
                doubleValue = ((Double) pointToSegDist.first).doubleValue();
                pair = new Pair<>(Integer.valueOf(i), pointToSegDist.second);
            } else {
                d = d2;
                dPoint3 = dPoint4;
                i = i3;
                list2 = list;
                dPoint2 = dPoint;
            }
            d = doubleValue;
            pair2 = pair;
            dPoint3 = dPoint4;
            i = i3;
            list2 = list;
            dPoint2 = dPoint;
        }
        return pair2;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d3;
        double d8 = d4;
        double d9 = d5;
        double d10 = d6;
        double d11 = d9 - d7;
        double d12 = d - d7;
        double d13 = d10 - d8;
        double d14 = d2 - d8;
        double d15 = (d11 * d12) + (d13 * d14);
        if (d15 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d12 * d12) + (d14 * d14))), new DPoint(d7, d8));
        }
        double d16 = (d11 * d11) + (d13 * d13);
        if (d15 >= d16) {
            double d17 = d - d9;
            double d18 = d2 - d10;
            return new Pair<>(Double.valueOf(Math.sqrt((d17 * d17) + (d18 * d18))), new DPoint(d9, d10));
        }
        double d19 = d15 / d16;
        double d20 = d7 + (d11 * d19);
        double d21 = d8 + (d13 * d19);
        double d22 = d - d20;
        double d23 = d21 - d2;
        return new Pair<>(Double.valueOf(Math.sqrt((d22 * d22) + (d23 * d23))), new DPoint(d20, d21));
    }
}
