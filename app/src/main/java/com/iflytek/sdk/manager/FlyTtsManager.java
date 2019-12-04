package com.iflytek.sdk.manager;

import android.content.Context;
import com.iflytek.clientadapter.tts.CTtsSession;
import com.iflytek.sdk.interfaces.ITtsClient;
import com.iflytek.sdk.interfaces.ITtsUiListener;
import com.iflytek.utils.log.FLog;

public class FlyTtsManager implements ITtsClient {
    private static final String TAG = "FlyTtsManager";
    private static Context mContext;

    private static class TtsManagerSingleton {
        /* access modifiers changed from: private */
        public static FlyTtsManager INST = new FlyTtsManager();

        private TtsManagerSingleton() {
        }
    }

    public static FlyTtsManager getInstance() {
        return TtsManagerSingleton.INST;
    }

    public static FlyTtsManager getInstance(Context context) {
        mContext = context;
        CTtsSession.getInstance(context);
        return TtsManagerSingleton.INST;
    }

    public int create(int i) {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.create(i);
        }
        FLog.e(TAG, "create() chmisession is null");
        return -1;
    }

    public int destroy() {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.destroy();
        }
        FLog.e(TAG, "destroy() chmisession is null");
        return -1;
    }

    public int setParam(int i, int i2) {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.setParam(i, i2);
        }
        FLog.e(TAG, "setParam() chmisession is null");
        return -1;
    }

    public int speak(String str, ITtsUiListener iTtsUiListener) {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.startSpeak(str, iTtsUiListener);
        }
        FLog.e(TAG, "speak() chmisession is null");
        return -1;
    }

    public int stop() {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.stop();
        }
        FLog.e(TAG, "stop() chmisession is null");
        return -1;
    }

    public int pause() {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.pause();
        }
        FLog.e(TAG, "pause() chmisession is null");
        return -1;
    }

    public int resume() {
        CTtsSession cTtsSession = getCTtsSession();
        if (cTtsSession != null) {
            return cTtsSession.resume();
        }
        FLog.e(TAG, "resume() chmisession is null");
        return -1;
    }

    /* access modifiers changed from: protected */
    public CTtsSession getCTtsSession() {
        CTtsSession instance = CTtsSession.getInstance();
        return (instance != null || mContext == null) ? instance : CTtsSession.getInstance(mContext);
    }
}
