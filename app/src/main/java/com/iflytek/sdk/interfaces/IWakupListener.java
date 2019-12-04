package com.iflytek.sdk.interfaces;

public interface IWakupListener {
    void onGlobalWakeup(String str, int i);

    void onMainUIWakeup(String str, int i);

    void onOneshotWakeup(String str, int i);
}
