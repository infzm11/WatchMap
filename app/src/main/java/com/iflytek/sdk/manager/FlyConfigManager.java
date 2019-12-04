package com.iflytek.sdk.manager;

import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.sdk.interfaces.IConfigClient;
import com.iflytek.utils.log.FLog;

public class FlyConfigManager implements IConfigClient {
    private static final String TAG = "FlyConfigManager";
    private static FlyConfigManager mInstance;

    public static FlyConfigManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyConfigManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyConfigManager();
                }
            }
        }
        return mInstance;
    }

    public int setMainUIWakeupKey(String str) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            return cHmiSession.setHmiKeyWords(str);
        }
        FLog.e(TAG, "setHmiWakeupKey() chmisession is null");
        return -1;
    }

    public int setOneShotState(int i) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            return cHmiSession.setOneShotState(i);
        }
        FLog.e(TAG, "setOneShotState() chmisession is null");
        return -1;
    }

    public int setApplication(int i, int i2, String str) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            return cHmiSession.setApplication(i, i2, str);
        }
        FLog.e(TAG, "setApplication() chmisession is null");
        return -1;
    }

    public String getSpeechVersion() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            return cHmiSession.getVersionInfo();
        }
        FLog.e(TAG, "getSpeechVersion() chmisession is null");
        return "false";
    }
}
