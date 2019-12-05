package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.services.a.am;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

public class BusStationSearch {
    private IBusStationSearch a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        try {
            Context context2 = context;
            this.a = (IBusStationSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.BusStationSearchWrapper", am.class, new Class[]{Context.class, BusStationQuery.class}, new Object[]{context, busStationQuery});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new am(context, busStationQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BusStationResult searchBusStation() throws AMapException {
        if (this.a != null) {
            return this.a.searchBusStation();
        }
        return null;
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        if (this.a != null) {
            this.a.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void searchBusStationAsyn() {
        if (this.a != null) {
            this.a.searchBusStationAsyn();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (this.a != null) {
            this.a.setQuery(busStationQuery);
        }
    }

    public BusStationQuery getQuery() {
        if (this.a != null) {
            return this.a.getQuery();
        }
        return null;
    }
}
