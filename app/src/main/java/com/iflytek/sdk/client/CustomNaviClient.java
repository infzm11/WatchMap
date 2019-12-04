package com.iflytek.sdk.client;

import com.iflytek.clientadapter.aidl.PoiInfo;
import com.iflytek.clientadapter.aidl.RouteInfo;
import java.util.List;

public abstract class CustomNaviClient {
    public static final int BROADCAST_PARTICULAR = 16386;
    public static final int BROADCAST_PITHY = 16385;
    public static final int MODE_AUTO = 8193;
    public static final int MODE_DARK = 8195;
    public static final int MODE_LIGHT = 8194;
    public static final int ROUTE_AVOID_JAM = 16;
    public static final int ROUTE_COST_LESS = 2;
    public static final int ROUTE_DEFAULT = 7;
    public static final int ROUTE_NO_HIGHWAY = 8;
    public static final int ROUTE_SHORT_JOURNEY = 4;
    public static final int ROUTE_SPEED_FAST = 1;
    public static final int SCALE_ENLARGE = 4099;
    public static final int SCALE_MAX = 4100;
    public static final int SCALE_MIN = 4097;
    public static final int SCALE_SHRAINK = 4098;
    public static final int VIEW_2D = 12289;
    public static final int VIEW_3D = 12290;
    public static final int VIEW_HEAD_UP = 12291;
    public static final int VIEW_NORTH_UP = 12292;

    public abstract boolean cancelNavigation();

    public abstract boolean changeBroadcastFrequency(int i);

    public abstract boolean changeMode(int i);

    public abstract boolean changeScale(int i);

    public abstract boolean changeView(int i);

    public abstract boolean changeVolume(int i);

    public abstract void clearPoiInfo();

    public abstract boolean close();

    public abstract PoiInfo getCompanyPoi();

    public abstract PoiInfo getCurrentPoi();

    public abstract RouteInfo getCurrentRouteInfo();

    public abstract int getDistanceLeft();

    public abstract PoiInfo getHomePoi();

    public abstract int getTimeLeft();

    public abstract boolean isNavigationGuide();

    public abstract boolean navigate(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list);

    public abstract boolean navigate(RouteInfo routeInfo);

    public abstract boolean open();

    public abstract List<RouteInfo> planRoute(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list);

    public abstract boolean previewRoute();

    public abstract boolean replanRoute(int i);

    public abstract List<PoiInfo> search(String str, PoiInfo poiInfo, int i);

    public abstract List<PoiInfo> searchByRoute(String str, int i);

    public abstract boolean setCompanyPoi(PoiInfo poiInfo);

    public abstract boolean setHomePoi(PoiInfo poiInfo);

    public abstract boolean showPoi(PoiInfo poiInfo);

    public abstract boolean showTraffic(boolean z);

    public abstract boolean simulateNavigation(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list);

    public abstract boolean simulateNavigation(RouteInfo routeInfo);
}
