package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.cloud.RequestListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.by;
import org.json.JSONObject;

public class ci extends bh {
    by.a a = new by.a() {
        public void a(SpeechError speechError) {
            if (speechError != null) {
                cb.c("upload error. please check net state:" + speechError.getErrorCode());
            } else {
                cb.a("upload succeed");
            }
            if (ci.this.h != null) {
                ci.this.h.onCompleted(speechError);
            }
        }

        public void a(by byVar, byte[] bArr) {
            if (bArr != null) {
                try {
                    String str = new String(bArr, "utf-8");
                    cb.a(str);
                    int parseInt = Integer.parseInt(new JSONObject(str).getString(SpeechUtility.TAG_RESOURCE_RET));
                    if (parseInt != 0) {
                        a(new SpeechError(parseInt, SpeechConstant.ENG_WFR));
                        return;
                    }
                    if (ci.this.h != null) {
                        cc.a("GetNotifyResult", (String) null);
                        ci.this.h.onBufferReceived(bArr);
                    }
                    a((SpeechError) null);
                } catch (Exception unused) {
                    a(new SpeechError(20004));
                }
            }
        }
    };
    private String d = "http://openapi.openspeech.cn/webapi/wfr.do";
    private String e = "pver=1.0";
    private Context f = null;
    private by g = null;
    /* access modifiers changed from: private */
    public RequestListener h;

    public ci(Context context, ce ceVar) {
        this.c = ceVar;
        this.f = context;
        this.g = new by();
    }

    public int a(byte[] bArr, RequestListener requestListener) {
        try {
            this.h = requestListener;
            if (SpeechUtility.getUtility() == null) {
                return 10111;
            }
            String d2 = this.c.d(AIUIConstant.KEY_SERVER_URL);
            if (TextUtils.isEmpty(d2)) {
                d2 = this.d;
            }
            String c = cg.c(this.f, this.c);
            this.g.b(this.c.a(SpeechConstant.NET_TIMEOUT, 20000));
            this.g.a(1);
            this.g.a(d2, this.e, bArr, c);
            this.g.a(this.a);
            cc.a("LastDataFlag", (String) null);
            return 0;
        } catch (Exception unused) {
            return 20999;
        }
    }

    public void a() {
        this.g.a();
        this.g = null;
    }

    public boolean destroy() {
        return super.destroy();
    }
}
