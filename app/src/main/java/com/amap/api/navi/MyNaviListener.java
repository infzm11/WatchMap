package com.amap.api.navi;

import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;

public interface MyNaviListener extends AMapNaviListener {
    void carProjectionChange(AmapCarLocation amapCarLocation);

    void hideModeCross();

    void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo);

    void showModeCross(AMapModelCross aMapModelCross);
}
