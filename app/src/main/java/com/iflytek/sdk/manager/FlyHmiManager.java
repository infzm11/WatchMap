package com.iflytek.sdk.manager;

import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.sdk.interfaces.IHmiClient;
import com.iflytek.sdk.interfaces.IHmiUiListener;
import com.iflytek.utils.log.FLog;

public class FlyHmiManager implements IHmiClient {
    private static final String TAG = "FlyHmiManager";
    private static FlyHmiManager mInstance;
    private IHmiUiListener mListener = null;

    public static FlyHmiManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyHmiManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyHmiManager();
                }
            }
        }
        return mInstance;
    }

    public int isInitComplete() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            return cHmiSession.isInitComplete();
        }
        return -1;
    }

    public int setAllowInteraction(int i) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.setAllowInteraction(i);
            return 0;
        }
        FLog.e(TAG, "setAllowInteraction() chmisession is null");
        return -1;
    }

    public int startInteraction() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.startInteraction();
            return 0;
        }
        FLog.e(TAG, "startInteraction() chmisession is null");
        return -1;
    }

    public int cancelInteraction() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.cancelInteraction();
            return 0;
        }
        FLog.e(TAG, "cancelInteraction() chmisession is null");
        return -1;
    }

    public int speakEnd() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.speakEnd();
            return 0;
        }
        FLog.e(TAG, "speakEnd() chmisession is null");
        return -1;
    }

    public void setListener(IHmiUiListener iHmiUiListener) {
        String str = TAG;
        FLog.d(str, "setListener() l = " + iHmiUiListener);
        this.mListener = iHmiUiListener;
    }

    public IHmiUiListener getListener() {
        return this.mListener;
    }

    /* access modifiers changed from: protected */
    public void onInteractionStart() {
        if (this.mListener != null) {
            this.mListener.onInteractionStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onInteractionEnd() {
        if (this.mListener != null) {
            this.mListener.onInteractionEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void onVolume(int i) {
        if (this.mListener != null) {
            this.mListener.onVolume(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onRecordStart() {
        if (this.mListener != null) {
            this.mListener.onRecordStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onRecordEnd() {
        if (this.mListener != null) {
            this.mListener.onRecordEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void onResultText(String str, String str2, int i, int i2) {
        if (this.mListener != null) {
            this.mListener.onResultText(str, str2, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onError(int i, String str) {
        if (this.mListener != null) {
            this.mListener.onError(i, str);
        }
    }

    /* access modifiers changed from: protected */
    public void onShowTips(String str) {
        this.mListener.onShowTips(str);
    }
}
