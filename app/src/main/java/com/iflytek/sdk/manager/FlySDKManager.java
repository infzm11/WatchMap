package com.iflytek.sdk.manager;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import com.iflytek.clientadapter.aidl.PoiInfo;
import com.iflytek.clientadapter.constant.CustomDataType;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.clientadapter.hmi.ICHmiListener;
import com.iflytek.clientadapter.mvw.CMvwSession;
import com.iflytek.sdk.interfaces.IInitListener;
import com.iflytek.sdk.interfaces.IInteractionNeed;
import com.iflytek.sdk.interfaces.IPhoneListener;
import com.iflytek.sdk.interfaces.IWakupListener;
import java.util.List;

public class FlySDKManager {
    private static final String TAG = "FlySDKManager";
    private static FlySDKManager mInstance;
    private Context mContext;
    private ICHmiListener mHmiListener = new ICHmiListener() {
        public void onAudioFocus(int i) {
        }

        public void onContactChoice(String str) {
        }

        public int onGetPhoneState() {
            return 0;
        }

        public void onMusicInfo(String str) {
        }

        public void onRadioInfo(String str) {
        }

        public void onSyncData() {
        }

        public void onGlobleWakeup(String str, int i) {
            if (FlySDKManager.this.mWakeupListener != null) {
                FlySDKManager.this.mWakeupListener.onGlobalWakeup(str, i);
            }
        }

        public void onHmiWakeup(String str, int i) {
            if (FlySDKManager.this.mWakeupListener != null) {
                FlySDKManager.this.mWakeupListener.onMainUIWakeup(str, i);
            }
        }

        public void onOneShotWakeup(String str, int i) {
            if (FlySDKManager.this.mWakeupListener != null) {
                FlySDKManager.this.mWakeupListener.onOneshotWakeup(str, i);
            }
        }

        public void onCmd(String str) {
            FlyCmdManager.getInstance().onResult(str);
        }

        public boolean onQuery(String str) {
            return FlyQueryManager.getInstance().onResult(str);
        }

        public boolean onAther(String str) {
            return FlyOtherManager.getInstance().onResult(str);
        }

        public void onError(int i) {
            FlyHmiManager.getInstance().onError(i, (String) null);
            if (FlySDKManager.this.mInitListener == null) {
                return;
            }
            if (i == 0) {
                FlySDKManager.this.mInitListener.onSuccess();
            } else {
                FlySDKManager.this.mInitListener.onError(i, (String) null);
            }
        }

        public void onLaunchApp(String str) {
            FlyAppManager.getInstance().onResult(str);
        }

        public void onSelectResult(int i, String str) {
            IPhoneListener listener = FlyPhoneManager.getInstance().getListener();
            if (listener != null) {
                listener.onSelectItem(i);
            }
        }

        public void onShowContact(List<ContactEntity> list) {
            IPhoneListener listener = FlyPhoneManager.getInstance().getListener();
            if (listener != null) {
                listener.onShowList(list);
            }
        }

        public void onCallContact(String str) {
            FlyPhoneManager.getInstance().onMakeCall(str);
        }

        public void onAcceptCall(String str) {
            FlyPhoneManager.getInstance().onListenCall(str);
        }

        public void onRejectCall(String str) {
            FlyPhoneManager.getInstance().onHangCall(str);
        }

        public void onShowPoi(List<PoiInfo> list) {
            FlyNaviManager.getInstance().onShowPoi(list);
        }

        public void onVolume(int i) {
            FlyHmiManager.getInstance().onVolume(i);
        }

        public void onRecordStart() {
            FlyHmiManager.getInstance().onRecordStart();
        }

        public void onRecordEnd() {
            FlyHmiManager.getInstance().onRecordEnd();
        }

        public void onInteractionStart() {
            FlyHmiManager.getInstance().onInteractionStart();
        }

        public void onInteractionEnd() {
            FlyHmiManager.getInstance().onInteractionEnd();
        }

        public void onPoiChoice(int i) {
            FlyNaviManager.getInstance().onPoiChoice(i);
        }

        public void onClosePage(boolean z) {
            FlyNaviManager.getInstance().onClosePage(z);
        }

        public void onResultText(String str, String str2, int i, int i2) {
            FlyHmiManager.getInstance().onResultText(str, str2, i, i2);
        }

        public boolean onDoAction(ActionModel actionModel) {
            if (actionModel == null || TextUtils.isEmpty(actionModel.getFocus())) {
                return true;
            }
            if (FocusType.telephone.equals(actionModel.getFocus())) {
                return FlyPhoneManager.getInstance().onDoAction(actionModel);
            }
            if (FocusType.map.equals(actionModel.getFocus())) {
                return FlyNaviManager.getInstance().onDoAction(actionModel);
            }
            return true;
        }

        public int onGetBluetoothState() {
            if (FlySDKManager.this.mInteractionNeed != null) {
                return FlySDKManager.this.mInteractionNeed.GetBluetoothState();
            }
            return 0;
        }

        public void onShowPoiTwice(List<PoiInfo> list, List<PoiInfo> list2) {
            FlyNaviManager.getInstance().onShowPoiTwice(list, list2);
        }

        public void onShowTips(String str) {
            FlyHmiManager.getInstance().onShowTips(str);
        }

        public void onSysnDataResult(String str, int i) {
            if (CustomDataType.CONTACT.equals(str)) {
                FlyPhoneManager.getInstance().onSysnResult(i);
            } else {
                CustomDataType.SONGS.equals(str);
            }
        }
    };
    /* access modifiers changed from: private */
    public IInitListener mInitListener = null;
    /* access modifiers changed from: private */
    public IInteractionNeed mInteractionNeed = null;
    /* access modifiers changed from: private */
    public IWakupListener mWakeupListener = null;

    public static FlySDKManager getInstance() {
        if (mInstance == null) {
            synchronized (CMvwSession.class) {
                if (mInstance == null) {
                    mInstance = new FlySDKManager();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context, IInitListener iInitListener, IWakupListener iWakupListener, IInteractionNeed iInteractionNeed) {
        this.mContext = context;
        this.mInitListener = iInitListener;
        this.mWakeupListener = iWakupListener;
        FlySvwManager.getInstance(this.mContext);
        FlyTtsManager.getInstance(this.mContext);
        CHmiSession.getInstance(this.mContext).init(this.mHmiListener);
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public CHmiSession getCHmiSession() {
        CHmiSession instance = CHmiSession.getInstance();
        return (instance != null || this.mContext == null) ? instance : CHmiSession.getInstance(this.mContext);
    }
}
