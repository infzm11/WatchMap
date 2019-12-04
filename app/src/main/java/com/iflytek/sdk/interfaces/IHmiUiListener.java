package com.iflytek.sdk.interfaces;

public interface IHmiUiListener {
    void onError(int i, String str);

    void onInteractionEnd();

    void onInteractionStart();

    void onRecordEnd();

    void onRecordStart();

    void onResultText(String str, String str2, int i, int i2);

    void onShowTips(String str);

    void onVolume(int i);
}
