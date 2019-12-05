package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.ServiceAreaInfo;

public class AMapServiceAreaInfo {
    private String name;
    private int remainDist;
    private int type;

    public AMapServiceAreaInfo(ServiceAreaInfo serviceAreaInfo) {
        try {
            this.remainDist = serviceAreaInfo.remainDist;
            this.type = serviceAreaInfo.type;
            this.name = serviceAreaInfo.name;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getRemainDist() {
        return this.remainDist;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
