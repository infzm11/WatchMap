package com.iflytek.sdk.manager;

import android.content.Context;
import com.iflytek.clientadapter.mvw.CMvwSession;
import com.iflytek.sdk.interfaces.ISvwClient;
import com.iflytek.sdk.interfaces.ISvwUiListener;
import com.iflytek.utils.log.FLog;

public class FlySvwManager implements ISvwClient {
    private static final String TAG = FlyTtsManager.class.getSimpleName();
    private static Context mContext;

    private static class SvwManagerSingleton {
        /* access modifiers changed from: private */
        public static FlySvwManager INST = new FlySvwManager();

        private SvwManagerSingleton() {
        }
    }

    public static FlySvwManager getInstance() {
        return SvwManagerSingleton.INST;
    }

    public static FlySvwManager getInstance(Context context) {
        mContext = context;
        CMvwSession.getInstance(mContext);
        return SvwManagerSingleton.INST;
    }

    public int start(String str, String str2, ISvwUiListener iSvwUiListener) {
        CMvwSession cMvwSession = getCMvwSession();
        if (cMvwSession != null) {
            return cMvwSession.start(str, str2, iSvwUiListener);
        }
        FLog.e(TAG, "setAllowInteraction() chmisession is null");
        return -1;
    }

    public int stop(int i) {
        CMvwSession cMvwSession = getCMvwSession();
        if (cMvwSession != null) {
            return cMvwSession.stop(i);
        }
        FLog.e(TAG, "setAllowInteraction() chmisession is null");
        return -1;
    }

    /* access modifiers changed from: protected */
    public CMvwSession getCMvwSession() {
        CMvwSession instance = CMvwSession.getInstance();
        return (instance != null || mContext == null) ? instance : CMvwSession.getInstance(mContext);
    }
}
