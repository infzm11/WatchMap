package com.iflytek.clientadapter.mvw;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.IAMvwListener;
import com.iflytek.clientadapter.aidl.IMvwSvc;
import com.iflytek.clientadapter.handler.Dispatch;
import com.iflytek.clientadapter.handler.HandleListener;
import com.iflytek.sdk.interfaces.ISvwUiListener;

public class CMvwSession {
    private static CMvwSession mInstance;
    /* access modifiers changed from: private */
    public String MvwSessionID = null;
    private final int RECONNECT = 1001;
    private final String TAG = "CMvwSession";
    /* access modifiers changed from: private */
    public ISvwUiListener mCMvwListener;
    private Context mContext;
    private IAMvwListener mIMvwListener = new IAMvwListener.Stub() {
        public void onCusWakeup(String str, String str2, int i, String str3, int i2) throws RemoteException {
            if (CMvwSession.this.mCMvwListener != null && CMvwSession.this.MvwSessionID.equals(str)) {
                CMvwSession.this.mCMvwListener.onCusWakeup(str2, i, str3, i2);
            }
        }
    };
    private HandleListener mImvwHandler = new HandleListener() {
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                Log.d("CMvwSession", "---> reConnect");
                CMvwSession.this.initService();
            }
        }
    };
    /* access modifiers changed from: private */
    public IMvwSvc mMvwSvc;
    private ServiceConnection mServiceConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("CMvwSession", "---> onServiceConnected");
            CMvwSession.this.mState = 2;
            CMvwSession.this.mMvwSvc = IMvwSvc.Stub.asInterface(iBinder);
            if (CMvwSession.this.mMvwSvc == null) {
                Log.e("CMvwSession", "get svc failed");
            }
            if (CMvwSession.this.mCMvwListener != null) {
                CMvwSession.this.mCMvwListener.onError(0);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("CMvwSession", "onServiceDisconnected");
            CMvwSession.this.mState = 0;
            CMvwSession.this.mMvwSvc = null;
            if (CMvwSession.this.mCMvwListener != null) {
                CMvwSession.this.mCMvwListener.onError(1);
            }
            CMvwSession.this.reconnect();
        }
    };
    volatile int mState = 0;

    public CMvwSession(Context context) {
        this.mContext = context;
        this.MvwSessionID = getSessionid();
        initService();
    }

    public static CMvwSession getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CMvwSession.class) {
                if (mInstance == null) {
                    mInstance = new CMvwSession(context);
                }
            }
        }
        return mInstance;
    }

    public static CMvwSession getInstance() {
        return mInstance;
    }

    private String getSessionid() {
        return "IFLYTEK_MVW_" + System.currentTimeMillis();
    }

    public int start(String str, String str2, ISvwUiListener iSvwUiListener) {
        this.mCMvwListener = iSvwUiListener;
        if (this.mMvwSvc != null) {
            try {
                return this.mMvwSvc.start(this.MvwSessionID, str, str2, this.mIMvwListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int stop(int i) {
        if (this.mMvwSvc != null) {
            try {
                return this.mMvwSvc.stop(this.MvwSessionID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
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
            java.lang.String r1 = "com.iflytek.clientadapter.mvw.MvwService"
            r0.<init>(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "com.iflytek.autofly.voicecoreservice"
            android.content.Intent r0 = r0.setPackage(r1)     // Catch:{ all -> 0x004f }
            r1 = 1
            r4.mState = r1     // Catch:{ Exception -> 0x0040 }
            android.content.Context r2 = r4.mContext     // Catch:{ Exception -> 0x0040 }
            android.content.ServiceConnection r3 = r4.mServiceConn     // Catch:{ Exception -> 0x0040 }
            boolean r0 = r2.bindService(r0, r3, r1)     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = "CMvwSession"
            java.lang.String r1 = "bindService OK."
            android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x0040 }
            monitor-exit(r4)     // Catch:{ all -> 0x004f }
            return
        L_0x002c:
            java.lang.String r0 = "CMvwSession"
            java.lang.String r2 = "bindService failed"
            android.util.Log.e(r0, r2)     // Catch:{ Exception -> 0x0040 }
            com.iflytek.sdk.interfaces.ISvwUiListener r0 = r4.mCMvwListener     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x003c
            com.iflytek.sdk.interfaces.ISvwUiListener r0 = r4.mCMvwListener     // Catch:{ Exception -> 0x0040 }
            r0.onError(r1)     // Catch:{ Exception -> 0x0040 }
        L_0x003c:
            r4.reconnect()     // Catch:{ Exception -> 0x0040 }
            goto L_0x004a
        L_0x0040:
            r0 = move-exception
            java.lang.String r1 = "CMvwSession"
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
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.mvw.CMvwSession.initService():void");
    }

    /* access modifiers changed from: private */
    public void reconnect() {
        Message message = new Message();
        message.what = 1001;
        Dispatch.getInstance().sendMessageDelayed(message, 1000, "CMvwSession", this.mImvwHandler);
    }
}
