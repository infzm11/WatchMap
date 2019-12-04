package com.iflytek.sdk.interfaces;

public interface IHmiClient {
    int cancelInteraction();

    IHmiUiListener getListener();

    int isInitComplete();

    int setAllowInteraction(int i);

    void setListener(IHmiUiListener iHmiUiListener);

    int speakEnd();

    int startInteraction();
}
