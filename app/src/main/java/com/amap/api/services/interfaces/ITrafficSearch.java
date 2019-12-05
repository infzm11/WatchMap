package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;

public interface ITrafficSearch {
    TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException;

    void loadTrafficByRoadAsyn(RoadTrafficQuery roadTrafficQuery);

    void setTrafficSearchListener(TrafficSearch.OnTrafficSearchListener onTrafficSearchListener);
}
