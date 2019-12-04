package com.iflytek.sdk.interfaces;

public interface ITtsClient {
    int create(int i);

    int destroy();

    int pause();

    int resume();

    int setParam(int i, int i2);

    int speak(String str, ITtsUiListener iTtsUiListener);

    int stop();
}
