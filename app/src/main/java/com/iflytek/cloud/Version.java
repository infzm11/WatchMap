package com.iflytek.cloud;

import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;

public class Version {
    private static String a = "";
    private static String b = "0";

    private static String getModeVersion() {
        return bh.a.MSC == SpeechUtility.DEF_ENGINE_MODE ? GuideControl.CHANGE_PLAY_TYPE_CLH : GuideControl.CHANGE_PLAY_TYPE_BBHX;
    }

    private static String getMscVersion() {
        if ("0".equalsIgnoreCase(b)) {
            try {
                if (MSC.isLoaded()) {
                    MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
                    byte[] QMSPGetVersion = MSC.QMSPGetVersion("ver_msc".getBytes("gb2312"), mSCSessionInfo);
                    if (mSCSessionInfo.errorcode == 0) {
                        String str = new String(QMSPGetVersion, "gb2312");
                        cb.a("get msc full version name: " + str);
                        int lastIndexOf = str.lastIndexOf(".");
                        if (lastIndexOf >= 0) {
                            int i = lastIndexOf + 1;
                            if (str.length() > i) {
                                b = str.substring(i);
                            }
                        }
                    } else {
                        cb.a("get msc version error: " + mSCSessionInfo.errorcode);
                    }
                } else {
                    cb.c("get msc version msc is not load.");
                }
            } catch (Throwable th) {
                cb.c("get msc version exception:");
                cb.a(th);
            }
        }
        return b;
    }

    public static String getVersion() {
        if (TextUtils.isEmpty(a) || "0".equalsIgnoreCase(b)) {
            a = "4." + getModeVersion() + "." + "1125" + "." + getMscVersion();
        }
        return a;
    }
}
