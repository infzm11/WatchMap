package com.amap.api.navi;

import com.amap.api.maps.model.Poi;
import java.util.List;

public class AmapNaviParams {
    private Poi end;
    private AmapPageType mPageType = AmapPageType.ROUTE;
    private AmapNaviType mType = AmapNaviType.DRIVER;
    private Poi start;
    private List<Poi> wayPoints;

    public AmapNaviParams(Poi poi) {
        this.end = poi;
    }

    public AmapNaviParams(Poi poi, List<Poi> list, Poi poi2, AmapNaviType amapNaviType) {
        this.start = poi;
        this.wayPoints = list;
        this.end = poi2;
        this.mType = amapNaviType;
    }

    public AmapNaviParams(Poi poi, List<Poi> list, Poi poi2, AmapNaviType amapNaviType, AmapPageType amapPageType) {
        this.start = poi;
        this.wayPoints = list;
        this.end = poi2;
        this.mType = amapNaviType;
        this.mPageType = amapPageType;
    }

    public AmapNaviType getNaviType() {
        return this.mType;
    }

    public AmapPageType getPageType() {
        return this.mPageType;
    }

    public Poi getEnd() {
        return this.end;
    }

    public Poi getStart() {
        return this.start;
    }

    public List<Poi> getWays() {
        return this.wayPoints;
    }
}
