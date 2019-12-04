package com.iflytek.sdk.interfaces;

public interface ITtsUiListener {
    void onError(int i);

    void onInterrupted();

    void onPlayBegin();

    void onPlayCompleted();

    void onProgress(int i, int i2);
}
