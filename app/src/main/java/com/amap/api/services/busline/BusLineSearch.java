package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.services.a.al;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

public class BusLineSearch {
    private IBusLineSearch a = null;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        try {
            Context context2 = context;
            this.a = (IBusLineSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.BusLineSearchWrapper", al.class, new Class[]{Context.class, BusLineQuery.class}, new Object[]{context, busLineQuery});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new al(context, busLineQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BusLineResult searchBusLine() throws AMapException {
        if (this.a != null) {
            return this.a.searchBusLine();
        }
        return null;
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        if (this.a != null) {
            this.a.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void searchBusLineAsyn() {
        if (this.a != null) {
            this.a.searchBusLineAsyn();
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (this.a != null) {
            this.a.setQuery(busLineQuery);
        }
    }

    public BusLineQuery getQuery() {
        if (this.a != null) {
            return this.a.getQuery();
        }
        return null;
    }
}
