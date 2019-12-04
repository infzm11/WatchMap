package com.iflytek.sdk.manager;

import android.util.Log;
import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.PoiInfo;
import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.sdk.interfaces.INaviListener;
import com.iflytek.utils.log.FLog;
import java.util.List;

public class FlyNaviManager {
    private static String TAG = "FlyNaviManager";
    private static FlyNaviManager mInstance;
    private INaviListener mListener;

    public static FlyNaviManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyNaviManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyNaviManager();
                }
            }
        }
        return mInstance;
    }

    /* access modifiers changed from: protected */
    public void onShowPoi(List<PoiInfo> list) {
        if (this.mListener != null) {
            this.mListener.onShowPoi(list);
        } else {
            Log.d(TAG, "onShowPoi mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public boolean onDoAction(ActionModel actionModel) {
        if (this.mListener != null) {
            return this.mListener.onDoAction(actionModel);
        }
        Log.d(TAG, "onDoAction mListener is null");
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPoiChoice(int i) {
        if (this.mListener != null) {
            this.mListener.onPoiChoice(i);
        } else {
            Log.d(TAG, "onPoiChoice mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public void onClosePage(boolean z) {
        if (this.mListener != null) {
            this.mListener.onClosePage(z);
        } else {
            Log.d(TAG, "onPoiChoice mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public void onShowPoiTwice(List<PoiInfo> list, List<PoiInfo> list2) {
        if (this.mListener != null) {
            this.mListener.onShowPoiTwice(list, list2);
        } else {
            Log.d(TAG, "onShowPoiTwice mListener is null");
        }
    }

    public void selectNaviItem(PoiInfo poiInfo, int i) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.selectNaviItem(poiInfo, i);
        } else {
            FLog.e(TAG, "cancelInteractUI() chmisession is null");
        }
    }

    public void cancelInteractUI() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.cancelSelector();
        } else {
            FLog.e(TAG, "cancelSelector() chmisession is null");
        }
    }

    public void setListener(INaviListener iNaviListener) {
        this.mListener = iNaviListener;
    }

    public void removeListener() {
        this.mListener = null;
    }
}
