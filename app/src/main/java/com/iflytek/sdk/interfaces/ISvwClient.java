package com.iflytek.sdk.interfaces;

public interface ISvwClient {
    int start(String str, String str2, ISvwUiListener iSvwUiListener);

    int stop(int i);
}
