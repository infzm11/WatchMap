package com.iflytek.clientadapter.tts;

public interface ICTtsListener {
    void onError(int i);

    void onInterrupted();

    void onPlayBegin();

    void onPlayCompleted();

    void onProgress(int i, int i2);
}
