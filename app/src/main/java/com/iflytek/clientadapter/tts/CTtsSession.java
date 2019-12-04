package com.iflytek.clientadapter.tts;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.IATtsListener;
import com.iflytek.clientadapter.aidl.ITtsSvc;
import com.iflytek.clientadapter.handler.Dispatch;
import com.iflytek.clientadapter.handler.HandleListener;
import com.iflytek.sdk.interfaces.ITtsUiListener;
import com.iflytek.utils.log.FLog;

public class CTtsSession {
    private static CTtsSession mInstance;
    private final int RECONNECT = 1001;
    private final String TAG = "CTtsSession";
    private String TtsSessionID = null;
    private IATtsListener mATtsListener = new IATtsListener.Stub() {
        public void onPlayBegin() throws RemoteException {
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onPlayBegin();
            }
        }

        public void onPlayCompleted() throws RemoteException {
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onPlayCompleted();
            }
        }

        public void onInterrupted() throws RemoteException {
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onInterrupted();
            }
        }

        public void onProgress(int i, int i2) throws RemoteException {
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onProgress(i, i2);
            }
        }
    };
    public Context mContext = null;
    /* access modifiers changed from: private */
    public ITtsUiListener mRemoteListener;
    private ServiceConnection mServiceConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("CTtsSession", "---> onServiceConnected");
            CTtsSession.this.mState = 2;
            CTtsSession.this.mTtsSvc = ITtsSvc.Stub.asInterface(iBinder);
            if (CTtsSession.this.mTtsSvc == null) {
                Log.e("CTtsSession", "get svc failed");
            }
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onError(0);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("CTtsSession", "onServiceDisconnected");
            CTtsSession.this.mState = 0;
            CTtsSession.this.mTtsSvc = null;
            if (CTtsSession.this.mRemoteListener != null) {
                CTtsSession.this.mRemoteListener.onError(1);
            }
            CTtsSession.this.reconnect();
        }
    };
    volatile int mState = 0;
    private HandleListener mTtsHandler = new HandleListener() {
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                Log.d("CTtsSession", "---> reConnect");
                CTtsSession.this.initService();
            }
        }
    };
    /* access modifiers changed from: private */
    public ITtsSvc mTtsSvc = null;

    public static CTtsSession getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CTtsSession.class) {
                if (mInstance == null) {
                    mInstance = new CTtsSession(context);
                }
            }
        }
        return mInstance;
    }

    public static CTtsSession getInstance() {
        return mInstance;
    }

    private String getSessionid() {
        return "IFLYTEK_TTS_" + System.currentTimeMillis();
    }

    public CTtsSession(Context context) {
        this.mContext = context;
        this.TtsSessionID = getSessionid();
        initService();
    }

    public int create(int i) {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.create(this.TtsSessionID, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "create() mTtsSvc is null");
            return 0;
        }
    }

    public int setParam(int i, int i2) {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.setParam(this.TtsSessionID, i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "setParam() mTtsSvc is null");
            return 0;
        }
    }

    public int startSpeak(String str, ITtsUiListener iTtsUiListener) {
        this.mRemoteListener = iTtsUiListener;
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.startSpeak(this.TtsSessionID, str, this.mATtsListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "startSpeak() mTtsSvc is null");
            return 0;
        }
    }

    public int stop() {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.stop(this.TtsSessionID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "stop() mTtsSvc is null");
            return 0;
        }
    }

    public int pause() {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.pause(this.TtsSessionID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "pause() mTtsSvc is null");
            return 0;
        }
    }

    public int resume() {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.resume(this.TtsSessionID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "resume() mTtsSvc is null");
            return 0;
        }
    }

    public int destroy() {
        if (this.mTtsSvc != null) {
            try {
                return this.mTtsSvc.destroy(this.TtsSessionID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            FLog.e("CTtsSession", "destroy() mTtsSvc is null");
            return 0;
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
            java.lang.String r1 = "com.iflytek.clientadapter.tts.TtsService"
            r0.<init>(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "com.iflytek.autofly.voicecoreservice"
            android.content.Intent r0 = r0.setPackage(r1)     // Catch:{ all -> 0x004f }
            r1 = 1
            r4.mState = r1     // Catch:{ Exception -> 0x0040 }
            android.content.Context r2 = r4.mContext     // Catch:{ Exception -> 0x0040 }
            android.content.ServiceConnection r3 = r4.mServiceConn     // Catch:{ Exception -> 0x0040 }
            boolean r0 = r2.bindService(r0, r3, r1)     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = "CTtsSession"
            java.lang.String r1 = "bindService OK."
            android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x0040 }
            monitor-exit(r4)     // Catch:{ all -> 0x004f }
            return
        L_0x002c:
            java.lang.String r0 = "CTtsSession"
            java.lang.String r2 = "bindService failed"
            android.util.Log.e(r0, r2)     // Catch:{ Exception -> 0x0040 }
            com.iflytek.sdk.interfaces.ITtsUiListener r0 = r4.mRemoteListener     // Catch:{ Exception -> 0x0040 }
            if (r0 == 0) goto L_0x003c
            com.iflytek.sdk.interfaces.ITtsUiListener r0 = r4.mRemoteListener     // Catch:{ Exception -> 0x0040 }
            r0.onError(r1)     // Catch:{ Exception -> 0x0040 }
        L_0x003c:
            r4.reconnect()     // Catch:{ Exception -> 0x0040 }
            goto L_0x004a
        L_0x0040:
            r0 = move-exception
            java.lang.String r1 = "CTtsSession"
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
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.tts.CTtsSession.initService():void");
    }

    /* access modifiers changed from: private */
    public void reconnect() {
        Message message = new Message();
        message.what = 1001;
        Dispatch.getInstance().sendMessageDelayed(message, 1000, "CTtsSession", this.mTtsHandler);
    }
}
