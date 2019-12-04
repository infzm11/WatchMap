package com.iflytek.sdk.interfaces;

public interface IConfigClient {
    String getSpeechVersion();

    int setApplication(int i, int i2, String str);

    int setMainUIWakeupKey(String str);

    int setOneShotState(int i);
}
