package com.iflytek.clientadapter.hmi;

import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import com.iflytek.clientadapter.aidl.PoiInfo;
import java.util.List;

public interface ICHmiListener {
    void onAcceptCall(String str);

    boolean onAther(String str);

    void onAudioFocus(int i);

    void onCallContact(String str);

    void onClosePage(boolean z);

    void onCmd(String str);

    void onContactChoice(String str);

    boolean onDoAction(ActionModel actionModel);

    void onError(int i);

    int onGetBluetoothState();

    int onGetPhoneState();

    void onGlobleWakeup(String str, int i);

    void onHmiWakeup(String str, int i);

    void onInteractionEnd();

    void onInteractionStart();

    void onLaunchApp(String str);

    void onMusicInfo(String str);

    void onOneShotWakeup(String str, int i);

    void onPoiChoice(int i);

    boolean onQuery(String str);

    void onRadioInfo(String str);

    void onRecordEnd();

    void onRecordStart();

    void onRejectCall(String str);

    void onResultText(String str, String str2, int i, int i2);

    void onSelectResult(int i, String str);

    void onShowContact(List<ContactEntity> list);

    void onShowPoi(List<PoiInfo> list);

    void onShowPoiTwice(List<PoiInfo> list, List<PoiInfo> list2);

    void onShowTips(String str);

    void onSyncData();

    void onSysnDataResult(String str, int i);

    void onVolume(int i);
}
