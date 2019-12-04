package com.iflytek.sdk.manager;

import android.text.TextUtils;
import com.iflytek.clientadapter.constant.CustomDataType;
import com.iflytek.clientadapter.hmi.CHmiSession;
import com.iflytek.sdk.interfaces.IResultListener;
import com.iflytek.utils.log.FLog;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FlyAppManager {
    private static final String TAG = "FlyAppManager";
    private static FlyAppManager mInstance;
    private List<String> mAppName = null;
    private List<String> mHotName = null;
    private IResultListener mResultListener = null;

    public static FlyAppManager getInstance() {
        if (mInstance == null) {
            synchronized (FlyAppManager.class) {
                if (mInstance == null) {
                    mInstance = new FlyAppManager();
                }
            }
        }
        return mInstance;
    }

    public int uploadAppName(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            this.mHotName = Arrays.asList(strArr);
        }
        if (strArr2 != null) {
            this.mAppName = Arrays.asList(strArr2);
        }
        if (CHmiSession.getInstance() != null) {
            CHmiSession.getInstance().syncSysData(CustomDataType.APPS, strArr);
            return 0;
        }
        FLog.e(TAG, "uploadAppName() chmisession is null");
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
        FLog.d(str2, "OnResult() appjson = " + str);
        if (this.mResultListener == null || TextUtils.isEmpty(str)) {
            FLog.e(TAG, "OnResult() mResultListener is null or json is null");
            return "sucess";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("operation");
            String string2 = jSONObject.getString("name");
            if (this.mHotName != null && this.mAppName != null && this.mHotName.size() == this.mAppName.size() && this.mHotName.contains(string2)) {
                string2 = this.mAppName.get(this.mHotName.indexOf(string2));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("operation", string);
            jSONObject2.put("name", string2);
            this.mResultListener.onResultHandle(jSONObject2.toString());
            return "sucess";
        } catch (JSONException e) {
            e.printStackTrace();
            FLog.e(TAG, "OnResult() json error");
            return "sucess";
        }
    }
}
