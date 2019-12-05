package com.amap.api.services.district;

import android.content.Context;
import com.amap.api.services.a.ao;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistrictSearch;

public class DistrictSearch {
    private IDistrictSearch a;

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        try {
            Context context2 = context;
            this.a = (IDistrictSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.DistrictSearchWrapper", ao.class, new Class[]{Context.class}, new Object[]{context});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ao(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public DistrictSearchQuery getQuery() {
        if (this.a != null) {
            return this.a.getQuery();
        }
        return null;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        if (this.a != null) {
            this.a.setQuery(districtSearchQuery);
        }
    }

    public DistrictResult searchDistrict() throws AMapException {
        if (this.a != null) {
            return this.a.searchDistrict();
        }
        return null;
    }

    public void searchDistrictAsyn() {
        if (this.a != null) {
            this.a.searchDistrictAsyn();
        }
    }

    public void searchDistrictAnsy() {
        if (this.a != null) {
            this.a.searchDistrictAnsy();
        }
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        if (this.a != null) {
            this.a.setOnDistrictSearchListener(onDistrictSearchListener);
        }
    }
}
