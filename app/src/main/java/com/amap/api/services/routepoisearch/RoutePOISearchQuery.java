package com.amap.api.services.routepoisearch;

import com.amap.api.services.a.i;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

public class RoutePOISearchQuery implements Cloneable {
    private LatLonPoint a;
    private LatLonPoint b;
    private int c;
    private RoutePOISearch.RoutePOISearchType d;
    private int e;
    private List<LatLonPoint> f;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.a = latLonPoint;
        this.b = latLonPoint2;
        this.c = i;
        this.d = routePOISearchType;
        if (i2 <= 0) {
            this.e = 250;
        } else if (i2 > 500) {
            this.e = 500;
        } else {
            this.e = i2;
        }
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.f = list;
        this.d = routePOISearchType;
        if (i <= 0) {
            this.e = 250;
        } else if (i > 500) {
            this.e = 500;
        } else {
            this.e = i;
        }
    }

    public LatLonPoint getFrom() {
        return this.a;
    }

    public LatLonPoint getTo() {
        return this.b;
    }

    public int getMode() {
        return this.c;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.d;
    }

    public int getRange() {
        return this.e;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f;
    }

    public RoutePOISearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            i.a(e2, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        if (this.f != null && this.f.size() > 0) {
            return new RoutePOISearchQuery(this.f, this.d, this.e);
        }
        RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.a, this.b, this.c, this.d, this.e);
        return routePOISearchQuery;
    }
}
