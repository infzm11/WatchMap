package com.amap.api.navi;

import com.amap.api.navi.model.AMapNaviLocation;

public interface INaviInfoCallback {
    void onArriveDestination(boolean z);

    void onCalculateRouteFailure(int i);

    void onCalculateRouteSuccess(int[] iArr);

    void onGetNavigationText(String str);

    void onInitNaviFailure();

    void onLocationChange(AMapNaviLocation aMapNaviLocation);

    void onStartNavi(int i);

    void onStopSpeaking();
}
