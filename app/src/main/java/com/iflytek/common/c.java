package com.iflytek.common;

import android.util.Log;
import com.iflytek.cloud.thirdparty.Cdo;

final class c {
    static Cdo a;

    protected static Cdo a() {
        if (a != null) {
            return a;
        }
        try {
            Cdo doVar = (Cdo) Class.forName("com.iflytek.common.push.impl.PushImpl").newInstance();
            a = doVar;
            if (doVar != null) {
                return a;
            }
            return null;
        } catch (Exception unused) {
            Log.e("PushFactory", "getPushInstance not found push instance.");
            return null;
        }
    }
}
