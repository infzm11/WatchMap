package com.iflytek.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.ce;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

abstract class SpeechModuleAidl<I extends IInterface> implements ISpeechModule {
    private String mBindAction = null;
    private ServiceConnection mConnection = null;
    protected Context mContext = null;
    /* access modifiers changed from: private */
    public InitListener mInitListener = null;
    private HashMap<String, String> mParams = new HashMap<>();
    protected I mService;
    protected Object mSynLock = new Object();
    /* access modifiers changed from: private */
    public Handler mUiHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (SpeechModuleAidl.this.mInitListener != null) {
                SpeechModuleAidl.this.mInitListener.onInit(message.what);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean userDestroy = false;

    public SpeechModuleAidl(Context context, InitListener initListener, String str) {
        this.mContext = context;
        this.mInitListener = initListener;
        this.mBindAction = str;
        bindService();
    }

    /* access modifiers changed from: private */
    public void bindService() {
        if (isActionInstalled(this.mContext, this.mBindAction)) {
            Intent intent = getIntent();
            intent.setAction(this.mBindAction);
            intent.setPackage(UtilityConfig.COMPONENT_PKG);
            this.mConnection = new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (SpeechModuleAidl.this.mSynLock) {
                        Log.d(SpeechModuleAidl.this.getTag(), "init success");
                        SpeechModuleAidl.this.mService = SpeechModuleAidl.this.getService(iBinder);
                        String tag = SpeechModuleAidl.this.getTag();
                        Log.d(tag, "mService :" + SpeechModuleAidl.this.mService);
                        if (SpeechModuleAidl.this.mInitListener != null) {
                            Message.obtain(SpeechModuleAidl.this.mUiHandler, 0, 0, 0, (Object) null).sendToTarget();
                        }
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    Log.d(SpeechModuleAidl.this.getTag(), "onServiceDisconnected");
                    SpeechModuleAidl.this.mService = null;
                    if (!SpeechModuleAidl.this.userDestroy) {
                        try {
                            SpeechModuleAidl.this.bindService();
                        } catch (Exception e) {
                            String tag = SpeechModuleAidl.this.getTag();
                            Log.e(tag, "rebindService error = " + e.toString());
                        }
                    }
                }
            };
            try {
                this.mContext.bindService(intent, this.mConnection, 1);
            } catch (SecurityException e) {
                cb.a((Throwable) e);
            }
        } else if (this.mInitListener != null) {
            Message.obtain(this.mUiHandler, 21001, 0, 0, (Object) null).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public I getService(IBinder iBinder) {
        try {
            String name = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
            String tag = getTag();
            Log.d(tag, "className = " + name);
            return (IInterface) Class.forName(name + "$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
        } catch (ClassNotFoundException | Exception | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            cb.a(e);
            return null;
        }
    }

    public boolean destory() {
        Log.d(getTag(), "destory");
        try {
            this.userDestroy = true;
            if (this.mConnection != null) {
                this.mContext.unbindService(this.mConnection);
                this.mConnection = null;
            }
            return true;
        } catch (IllegalArgumentException e) {
            cb.a((Throwable) e);
            return false;
        }
    }

    public Intent getIntent() {
        Intent intent = new Intent();
        if (!this.mParams.isEmpty()) {
            for (String next : this.mParams.keySet()) {
                intent.putExtra(next, this.mParams.get(next));
            }
            HashMap<String, String> c = new ce(this.mParams.get(SpeechConstant.PARAMS), (String[][]) null).c();
            if (c != null && !c.isEmpty()) {
                for (String next2 : c.keySet()) {
                    intent.putExtra(next2, c.get(next2));
                }
            }
        }
        intent.putExtra(UtilityConfig.KEY_CALLER_APPID, SpeechUtility.getUtility().getParameter("appid"));
        intent.putExtra(UtilityConfig.KEY_CALLER_NAME, UtilityConfig.getCallerInfo(this.mContext, UtilityConfig.KEY_CALLER_NAME));
        intent.putExtra(UtilityConfig.KEY_CALLER_PKG_NAME, UtilityConfig.getCallerInfo(this.mContext, UtilityConfig.KEY_CALLER_PKG_NAME));
        intent.putExtra(UtilityConfig.KEY_CALLER_VER_NAME, UtilityConfig.getCallerInfo(this.mContext, UtilityConfig.KEY_CALLER_VER_NAME));
        intent.putExtra(UtilityConfig.KEY_CALLER_VER_CODE, UtilityConfig.getCallerInfo(this.mContext, UtilityConfig.KEY_CALLER_VER_CODE));
        return intent;
    }

    public String getParameter(String str) {
        return this.mParams.get(str);
    }

    /* access modifiers changed from: protected */
    public final String getTag() {
        return getClass().toString();
    }

    public boolean isActionInstalled(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.getPackageManager().resolveService(new Intent(str), 0) == null) ? false : true;
    }

    public boolean isAvailable() {
        return this.mService != null;
    }

    public int setParameter(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 20012;
        }
        if (TextUtils.isEmpty(str2)) {
            this.mParams.remove(str);
            return 0;
        }
        this.mParams.put(str, str2);
        return 0;
    }
}
