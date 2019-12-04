package com.iflytek.sdk.manager;

import android.text.TextUtils;
import com.iflytek.clientadapter.constant.CustomDataType;
import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.sdk.interfaces.IResultListener;
import com.iflytek.utils.log.FLog;
import org.json.JSONException;
import org.json.JSONObject;

public class FlyCmdManager {
    private static final String TAG = "FlyCmdManager";
    private static FlyCmdManager mInstance;
    private IResultListener mResultListener = null;

    public static FlyCmdManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyCmdManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyCmdManager();
                }
            }
        }
        return mInstance;
    }

    public int uploadCmd(String[] strArr) {
        String str = TAG;
        FLog.d(str, "uploadCmd cmd = " + strArr);
        if (CHmiSession.getInstance() != null) {
            CHmiSession.getInstance().syncSysData(CustomDataType.HOTWORDS, strArr);
            return 0;
        }
        FLog.e(TAG, "uploadCmd() chmisession is null");
        return 0;
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
    public String onResult(String str) {
        String str2 = TAG;
        FLog.d(str2, "OnResult() json = " + str);
        if (this.mResultListener == null || TextUtils.isEmpty(str)) {
            FLog.e(TAG, "OnResult() mResultListener is null or json is null");
            return "sucess";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(SpeechConstant.ISE_CATEGORY);
            String optString2 = jSONObject.optString("operation");
            String optString3 = jSONObject.optString("name");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SpeechConstant.ISE_CATEGORY, optString);
            jSONObject2.put("operation", optString2);
            jSONObject2.put("name", optString3);
            this.mResultListener.onResultHandle(str.toString());
            return "sucess";
        } catch (JSONException e) {
            e.printStackTrace();
            FLog.e(TAG, "OnResult() json error");
            return "sucess";
        }
    }
}
