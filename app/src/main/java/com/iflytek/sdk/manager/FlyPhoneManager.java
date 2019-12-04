package com.iflytek.sdk.manager;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import com.iflytek.clientadapter.constant.ContactValue;
import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.sdk.interfaces.IPhoneClient;
import com.iflytek.sdk.interfaces.IPhoneListener;
import com.iflytek.utils.log.FLog;
import java.util.List;

public class FlyPhoneManager implements IPhoneClient {
    /* access modifiers changed from: private */
    public static final String TAG = "FlyPhoneManager";
    private static FlyPhoneManager mInstance;
    private IPhoneListener mListener = null;

    public void setNumbersOnePage(int i) {
    }

    public static FlyPhoneManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyPhoneManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyPhoneManager();
                }
            }
        }
        return mInstance;
    }

    public int setBookList(final List<ContactEntity> list) {
        if (list == null || list.size() <= 0 || CHmiSession.getInstance() == null) {
            FLog.e(TAG, "uploadAppName() chmisession is null");
            return 0;
        }
        new Thread(new Runnable() {
            public void run() {
                String access$0 = FlyPhoneManager.TAG;
                FLog.e(access$0, "setBookList() 构建联系人数据库 " + System.currentTimeMillis());
                ContentResolver contentResolver = FlySDKManager.getInstance().getContext().getContentResolver();
                contentResolver.delete(ContactValue.URI_TABLE, (String) null, (String[]) null);
                for (int i = 0; i < list.size(); i++) {
                    ContentValues contentValues = new ContentValues();
                    ContactEntity contactEntity = (ContactEntity) list.get(i);
                    contentValues.put("name", contactEntity.getName());
                    contentValues.put(ContactValue.NUMBER, contactEntity.getNumber());
                    contentResolver.insert(ContactValue.URI_TABLE, contentValues);
                }
                if (FlySDKManager.getInstance().getContext() != null) {
                    FlySDKManager.getInstance().getContext().sendBroadcast(new Intent("com.iflytek.phone.download_finish"));
                }
                String access$02 = FlyPhoneManager.TAG;
                FLog.e(access$02, "setBookList() 构建联系人数据wancheng nnn库 " + System.currentTimeMillis());
            }
        }).start();
        return 0;
    }

    public void setListener(IPhoneListener iPhoneListener) {
        String str = TAG;
        FLog.d(str, "setListener() l = " + iPhoneListener);
        this.mListener = iPhoneListener;
    }

    /* access modifiers changed from: protected */
    public IPhoneListener getListener() {
        return this.mListener;
    }

    /* access modifiers changed from: protected */
    public void onMakeCall(String str) {
        if (this.mListener != null) {
            this.mListener.toCallPhone(str);
        } else {
            FLog.e(TAG, "makeCall() mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public void onListenCall(String str) {
        if (this.mListener != null) {
            this.mListener.toAcceptCall(str);
        } else {
            FLog.e(TAG, "ListenCall() mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public void onHangCall(String str) {
        if (this.mListener != null) {
            this.mListener.toRejectCall(str);
        } else {
            FLog.e(TAG, "HangCall() mListener is null");
        }
    }

    /* access modifiers changed from: protected */
    public boolean onDoAction(ActionModel actionModel) {
        if (this.mListener != null) {
            return this.mListener.onDoActioin(actionModel);
        }
        FLog.e(TAG, "onDoAction() mListener is null");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSysnResult(int i) {
        if (this.mListener != null) {
            this.mListener.onBookResult(i);
        } else {
            FLog.e(TAG, "onSysnResult() mListener is null");
        }
    }

    public int selectItem(ContactEntity contactEntity) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.selectContactItem(contactEntity);
            return 0;
        }
        FLog.e(TAG, "selectItem() chmisession is null");
        return 0;
    }

    public void cancelInteractUI() {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.cancelSelector();
        } else {
            FLog.e(TAG, "cancelInteractUI() chmisession is null");
        }
    }

    public void setCallState(int i) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.setCallState(i);
        } else {
            FLog.e(TAG, "setCallState() chmisession is null");
        }
    }

    public void inCommingCall(String str) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.inCommingCall(str);
        } else {
            FLog.e(TAG, "setCallState() chmisession is null");
        }
    }

    public void doAction(ActionModel actionModel) {
        CHmiSession cHmiSession = FlySDKManager.getInstance().getCHmiSession();
        if (cHmiSession != null) {
            cHmiSession.doAction(actionModel);
        } else {
            FLog.e(TAG, "doAction() chmisession is null");
        }
    }
}
