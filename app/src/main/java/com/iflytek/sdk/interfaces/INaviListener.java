package com.iflytek.sdk.interfaces;

import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.PoiInfo;
import java.util.List;

public interface INaviListener {
    void onClosePage(boolean z);

    boolean onDoAction(ActionModel actionModel);

    void onPoiChoice(int i);

    void onShowPoi(List<PoiInfo> list);

    void onShowPoiTwice(List<PoiInfo> list, List<PoiInfo> list2);
}
