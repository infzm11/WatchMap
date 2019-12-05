package com.amap.api.location;

public interface LocationManagerBase {
    AMapLocation getLastKnownLocation();

    boolean isStarted();

    void onDestroy();

    void setLocationListener(AMapLocationListener aMapLocationListener);

    void setLocationOption(AMapLocationClientOption aMapLocationClientOption);

    void startAssistantLocation();

    void startLocation();

    void stopAssistantLocation();

    void stopLocation();

    void unRegisterLocationListener(AMapLocationListener aMapLocationListener);
}
