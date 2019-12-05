package com.amap.api.services.traffic;

import android.content.Context;
import com.amap.api.services.a.aw;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;

public class TrafficSearch {
    public static int ROAD_LEVEL_CITY_QUICK_WAY = 2;
    public static int ROAD_LEVEL_HIGH_WAY = 1;
    public static int ROAD_LEVEL_HIGH_WAY_BYROAD = 3;
    public static int ROAD_LEVEL_MAIN_WAY = 4;
    public static int ROAD_LEVEL_NONAME_WAY = 6;
    public static int ROAD_LEVEL_NORMAL_WAY = 5;
    private ITrafficSearch a;

    public interface OnTrafficSearchListener {
        void onRoadTrafficSearched(TrafficStatusResult trafficStatusResult, int i);
    }

    public TrafficSearch(Context context) {
        try {
            Context context2 = context;
            this.a = (ITrafficSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.TrafficSearchWrapper", aw.class, new Class[]{Context.class}, new Object[]{context});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new aw(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setTrafficSearchListener(OnTrafficSearchListener onTrafficSearchListener) {
        if (this.a != null) {
            this.a.setTrafficSearchListener(onTrafficSearchListener);
        }
    }

    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        if (this.a != null) {
            return this.a.loadTrafficByRoad(roadTrafficQuery);
        }
        return null;
    }

    public void loadTrafficByRoadAsyn(RoadTrafficQuery roadTrafficQuery) {
        if (this.a != null) {
            this.a.loadTrafficByRoadAsyn(roadTrafficQuery);
        }
    }
}
