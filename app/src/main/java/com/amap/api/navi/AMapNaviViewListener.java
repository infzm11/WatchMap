package com.amap.api.navi;

public interface AMapNaviViewListener {
    void onLockMap(boolean z);

    boolean onNaviBackClick();

    void onNaviCancel();

    void onNaviMapMode(int i);

    void onNaviSetting();

    void onNaviTurnClick();

    void onNaviViewLoaded();

    void onNextRoadClick();

    void onScanViewButtonClick();
}
