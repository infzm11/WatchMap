package com.iflytek.clientadapter.hmi;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import com.iflytek.clientadapter.aidl.IAHmiListener;
import com.iflytek.clientadapter.aidl.IHmiSvc;
import com.iflytek.clientadapter.aidl.PoiInfo;
import com.iflytek.clientadapter.handler.Dispatch;
import com.iflytek.clientadapter.handler.HandleListener;
import com.iflytek.clientadapter.mvw.CMvwSession;
import java.util.List;

public class CHmiSession {
    private static CHmiSession mInstance;
    private final int RECONNECT = 1001;
    private final String TAG = "CHmiSession";
    private Context mContext;
    /* access modifiers changed from: private */
    public IHmiSvc mHmiSvc;
    private HandleListener mHmiwHandler = new HandleListener() {
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                Log.d("CHmiSession", "---> reConnect");
                CHmiSession.this.initService();
            }
        }
    };
    /* access modifiers changed from: private */
    public IAHmiListener mIHmiListener = new IAHmiListener.Stub() {
        public void onGlobleWakeup(String str, int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onGlobleWakeup(str, i);
            }
        }

        public void onHmiWakeup(String str, int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onHmiWakeup(str, i);
            }
        }

        public void onOneShotWakeup(String str, int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onOneShotWakeup(str, i);
            }
        }

        public void onAudioFocus(int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onAudioFocus(i);
            }
        }

        public void onLaunchApp(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onLaunchApp(str);
            }
        }

        public void onSelectResult(int i, String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onSelectResult(i, str);
            }
        }

        public void onShowContact(List<ContactEntity> list) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onShowContact(list);
            }
        }

        public void onContactChoice(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onCallContact(str);
            }
        }

        public void onCallContact(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onCallContact(str);
            }
        }

        public void onAcceptCall(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onAcceptCall(str);
            }
        }

        public void onRejectCall(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onRejectCall(str);
            }
        }

        public int onGetPhoneState() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                return CHmiSession.this.mRemoteListener.onGetPhoneState();
            }
            return 0;
        }

        public void onShowPoi(List<PoiInfo> list) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onShowPoi(list);
            }
        }

        public void onMusicInfo(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onMusicInfo(str);
            }
        }

        public void onRadioInfo(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onRadioInfo(str);
            }
        }

        public void onCmd(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onCmd(str);
            }
        }

        public boolean onQuery(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                return CHmiSession.this.mRemoteListener.onQuery(str);
            }
            return false;
        }

        public boolean onAther(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener == null) {
                return false;
            }
            CHmiSession.this.mRemoteListener.onAther(str);
            return false;
        }

        public void onVolume(int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onVolume(i);
            }
        }

        public void onRecordStart() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onRecordStart();
            }
        }

        public void onRecordEnd() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onRecordEnd();
            }
        }

        public void onResultText(String str, String str2, int i, int i2) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onResultText(str, str2, i, i2);
            }
        }

        public void onError(int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onError(i);
            }
        }

        public void onInteractionStart() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onInteractionStart();
            }
        }

        public void onInteractionEnd() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onInteractionEnd();
            }
        }

        public void onSyncData() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onSyncData();
            }
        }

        public boolean onDoAction(ActionModel actionModel) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                return CHmiSession.this.mRemoteListener.onDoAction(actionModel);
            }
            return true;
        }

        public int onGetBluetoothState() throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                return CHmiSession.this.mRemoteListener.onGetBluetoothState();
            }
            return 0;
        }

        public void onShowPoiTwice(List<PoiInfo> list, List<PoiInfo> list2) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onShowPoiTwice(list, list2);
            }
        }

        public void onShowTips(String str) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onShowTips(str);
            }
        }

        public void onPoiChoice(int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onPoiChoice(i);
            }
        }

        public void onClosePage(boolean z) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onClosePage(z);
            }
        }

        public void onSysnDataResult(String str, int i) throws RemoteException {
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onSysnDataResult(str, i);
            }
        }
    };
    /* access modifiers changed from: private */
    public ICHmiListener mRemoteListener;
    private ServiceConnection mServiceConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("CHmiSession", "---> onServiceConnected");
            CHmiSession.this.mState = 2;
            CHmiSession.this.mHmiSvc = IHmiSvc.Stub.asInterface(iBinder);
            if (CHmiSession.this.mHmiSvc == null) {
                Log.e("CHmiSession", "get svc failed");
                return;
            }
            try {
                CHmiSession.this.mHmiSvc.init(CHmiSession.this.mIHmiListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("CHmiSession", "onServiceDisconnected");
            CHmiSession.this.mState = 0;
            CHmiSession.this.mHmiSvc = null;
            if (CHmiSession.this.mRemoteListener != null) {
                CHmiSession.this.mRemoteListener.onError(1);
            }
            CHmiSession.this.reconnect();
        }
    };
    volatile int mState = 0;

    public CHmiSession(Context context) {
        this.mContext = context;
        initService();
    }

    public static CHmiSession getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CMvwSession.class) {
                if (mInstance == null) {
                    mInstance = new CHmiSession(context);
                }
            }
        }
        return mInstance;
    }

    public static CHmiSession getInstance() {
        return mInstance;
    }

    public void init(ICHmiListener iCHmiListener) {
        this.mRemoteListener = iCHmiListener;
    }

    public String getVersionInfo() {
        if (this.mHmiSvc == null) {
            return "false";
        }
        try {
            return this.mHmiSvc.getVersionInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return "false";
        }
    }

    public void syncSysData(String str, String[] strArr) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.syncSysData(str, strArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int isInitComplete() {
        if (this.mHmiSvc == null) {
            return -2;
        }
        try {
            return this.mHmiSvc.isInitComplete();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public void setAllowInteraction(int i) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.setAllowInteraction(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void listSelectResult(int i) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.listSelectResult(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void startInteraction() {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.startInteraction();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelInteraction() {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.cancelInteraction();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void speakEnd() {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.speakEnd();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int setHmiKeyWords(String str) {
        if (this.mHmiSvc == null) {
            return -2;
        }
        try {
            return this.mHmiSvc.setHmiKeyWords(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public int setOneShotState(int i) {
        if (this.mHmiSvc == null) {
            return -2;
        }
        try {
            return this.mHmiSvc.setOneShotState(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public int setApplication(int i, int i2, String str) {
        if (this.mHmiSvc == null) {
            return -2;
        }
        try {
            return this.mHmiSvc.setApplication(i, i2, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public void cancelSelector() {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.cancelSelector();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectContactItem(ContactEntity contactEntity) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.selectContactItem(contactEntity);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void inCommingCall(String str) {
        if (this.mHmiSvc != null) {
            try {
                Log.d("CHmiSession", "number:---" + str);
                this.mHmiSvc.inCommingCall(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCallState(int i) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.setCallState(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectNaviItem(PoiInfo poiInfo, int i) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.selectNaviItem(poiInfo, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void doAction(ActionModel actionModel) {
        if (this.mHmiSvc != null) {
            try {
                this.mHmiSvc.doAction(actionModel);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initService() {
        /*
            r4 = this;
            int r0 = r4.mState
            if (r0 != 0) goto L_0x0052
            monitor-enter(r4)
            int r0 = r4.mState     // Catch:{ all -> 0x004f }
            if (r0 != 0) goto L_0x004d
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "com.iflytek.clientadapter.hmi.HmiService"
            r0.<init>(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "com.iflytek.autofly.voicecoreservice"
            android.content.Intent r0 = r0.setPackage(r1)     // Catch:{ all -> 0x004f }
            r1 = 1
            r4.mState = r1     // Catch:{ Exception -> 0x0040 }
            android.content.Context r2 = r4.mContext     // Catch:{ Exception -> 0x0040 }
            android.content.ServiceConnection r3 = r4.mServiceConn     // Catch:{ Exception -> 0x0040 }
            boolean r0 = r2.bindService(r0, r3, r1)     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = "CHmiSession"
            java.lang.String r1 = "bindService OK."
            android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x0040 }
            monitor-exit(r4)     // Catch:{ all -> 0x004f }
            return
        L_0x002c:
            java.lang.String r0 = "CHmiSession"
            java.lang.String r2 = "bindService failed"
            android.util.Log.e(r0, r2)     // Catch:{ Exception -> 0x0040 }
            com.iflytek.clientadapter.hmi.ICHmiListener r0 = r4.mRemoteListener     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x003c
            com.iflytek.clientadapter.hmi.ICHmiListener r0 = r4.mRemoteListener     // Catch:{ Exception -> 0x0040 }
            r0.onError(r1)     // Catch:{ Exception -> 0x0040 }
        L_0x003c:
            r4.reconnect()     // Catch:{ Exception -> 0x0040 }
            goto L_0x004a
        L_0x0040:
            r0 = move-exception
            java.lang.String r1 = "CHmiSession"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004f }
            android.util.Log.e(r1, r0)     // Catch:{ all -> 0x004f }
        L_0x004a:
            r0 = 0
            r4.mState = r0     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r4)     // Catch:{ all -> 0x004f }
            goto L_0x0052
        L_0x004f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004f }
            throw r0
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.hmi.CHmiSession.initService():void");
    }

    /* access modifiers changed from: private */
    public void reconnect() {
        Message message = new Message();
        message.what = 1001;
        Dispatch.getInstance().sendMessageDelayed(message, 1000, "CHmiSession", this.mHmiwHandler);
    }
}
