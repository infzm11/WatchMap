package com.iflytek.sdk.interfaces;

public interface IInteractionNeed {
    int AbandonAudioFocus();

    int GetBluetoothState();

    int RequestAudioFocus();

    String getLocation();
}
