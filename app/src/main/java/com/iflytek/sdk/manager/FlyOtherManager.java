package com.iflytek.sdk.manager;

import android.text.TextUtils;
import com.iflytek.sdk.interfaces.IResultListener;
import com.iflytek.utils.log.FLog;

public class FlyOtherManager {
    private static final String TAG = "FlyOtherManager";
    private static FlyOtherManager mInstance;
    private IResultListener mResultListener = null;

    public static FlyOtherManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyQueryManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyOtherManager();
                }
            }
        }
        return mInstance;
    }

    public void setListener(IResultListener iResultListener) {
        String str = TAG;
        FLog.d(str, "setListener l = " + iResultListener);
        this.mResultListener = iResultListener;
    }

    /* access modifiers changed from: protected */
    public IResultListener getListener() {
        return this.mResultListener;
    }

    /* access modifiers changed from: protected */
    public boolean onResult(String str) {
        if (this.mResultListener == null) {
            FLog.d(TAG, "onResult() mResultListener is null");
            return false;
        } else if (!TextUtils.isEmpty(str)) {
            return this.mResultListener.onResultHandle(str);
        } else {
            FLog.d(TAG, "onResult() json is null");
            return false;
        }
    }
}
