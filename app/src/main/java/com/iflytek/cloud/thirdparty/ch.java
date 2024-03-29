package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.util.VerifierUtil;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ch {
    private boolean a;
    private MSCSessionInfo b;

    public ch(Context context, String str) {
        try {
            if (SpeechUtility.getUtility() == null) {
                throw new SpeechError(10111);
            }
            this.a = false;
            a(str);
        } catch (SpeechError e) {
            cb.c(e.getPlainDescription(true));
        }
    }

    private String a(byte[] bArr, MSCSessionInfo mSCSessionInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (mSCSessionInfo.errorcode == 0) {
                jSONObject = new JSONObject(new String(bArr));
            }
            jSONObject.put(SpeechUtility.TAG_RESOURCE_RET, mSCSessionInfo.errorcode);
        } catch (JSONException unused) {
            cb.c("face result add errorinfo exception");
        }
        return jSONObject.toString();
    }

    private void a(String str) {
        if (MSC.isLoaded()) {
            cb.a("MSC isLoaded：" + MSC.isLoaded());
            this.b = new MSCSessionInfo();
            cc.a("MSCSessionBegin", (String) null);
            if (!TextUtils.isEmpty(str)) {
                MSC.QIFDInit(str.getBytes(), this.b);
            } else {
                MSC.QIFDInit((byte[]) null, this.b);
            }
            cc.a("SessionBeginEnd", (String) null);
            if (this.b.errorcode != 0) {
                cb.c("QIFDINIT INIT FAIL, ERRORCODE:" + this.b.errorcode);
                return;
            }
            cb.a("QIFDINIT INIT SUCCESS");
        }
    }

    public String a(Bitmap bitmap) {
        if (bitmap != null && Bitmap.Config.ARGB_8888.equals(bitmap.getConfig())) {
            return b(VerifierUtil.ARGB2Gray(bitmap));
        }
        cb.c("Method detectARGB:null parameter or not ARGB bitmap");
        return null;
    }

    public String a(byte[] bArr, int i, int i2, int i3, int i4) {
        if (bArr == null || i <= 0 || i2 <= 0 || i4 < 0 || i4 > 3) {
            cb.c("Method trackNV21:invalid parameters");
            return null;
        }
        this.b = new MSCSessionInfo();
        cc.a("LastDataFlag", (String) null);
        byte[] QIFDMultitracker = MSC.QIFDMultitracker(bArr, bArr.length, i, i2, i3, i4, this.b);
        cc.a("GetNotifyResult", (String) null);
        return a(QIFDMultitracker, this.b);
    }

    public void a() {
        if (!this.a) {
            cb.a("QIFDFINIT");
            cc.a("SessionEndBegin", (String) null);
            int QIFDFini = MSC.QIFDFini();
            cb.a("MSC.QIFDFini result is " + QIFDFini);
            cc.a("SessionEndEnd", (String) null);
            this.a = true;
        }
    }

    public String b(Bitmap bitmap) {
        if (bitmap == null || !Bitmap.Config.ALPHA_8.equals(bitmap.getConfig())) {
            cb.c("Method detectGray:null parameter or not gray bitmap");
            return null;
        }
        this.b = new MSCSessionInfo();
        cc.a("LastDataFlag", (String) null);
        byte[] QIFDFacedetect = MSC.QIFDFacedetect(bitmap, VerifierUtil.getBitmapsize(bitmap), this.b);
        cc.a("GetNotifyResult", (String) null);
        return a(QIFDFacedetect, this.b);
    }
}
