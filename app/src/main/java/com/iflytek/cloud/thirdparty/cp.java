package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechListener;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;
import com.iflytek.cloud.thirdparty.bi;
import com.iflytek.msc.MSC;
import java.io.UnsupportedEncodingException;

public class cp extends bi {

    private class a implements SpeechListener {
        private TextUnderstanderListener b;

        public a(TextUnderstanderListener textUnderstanderListener) {
            this.b = textUnderstanderListener;
        }

        public void onBufferReceived(byte[] bArr) {
            if (bArr != null) {
                try {
                    this.b.onResult(new UnderstanderResult(new String(bArr, "utf-8")));
                } catch (UnsupportedEncodingException | NullPointerException e) {
                    cb.a(e);
                }
            }
        }

        public void onCompleted(SpeechError speechError) {
            if (this.b != null && speechError != null) {
                this.b.onError(speechError);
            }
        }

        public void onEvent(int i, Bundle bundle) {
        }
    }

    public cp(Context context) {
        super(context);
    }

    public int a(String str, TextUnderstanderListener textUnderstanderListener) {
        int i;
        SpeechError speechError;
        int i2;
        try {
            if (TextUtils.isEmpty(getParameter(SpeechConstant.ASR_SCH))) {
                setParameter(SpeechConstant.ASR_SCH, "1");
            }
            if (TextUtils.isEmpty(getParameter(SpeechConstant.NLP_VERSION))) {
                setParameter(SpeechConstant.NLP_VERSION, MSC.isIflyVersion() ? "3.0" : "2.0");
            }
            if (TextUtils.isEmpty(getParameter(SpeechConstant.RESULT_TYPE))) {
                setParameter(SpeechConstant.RESULT_TYPE, "json");
            }
            if (d()) {
                i2 = 21005;
            } else {
                this.e = new bk(this.a, this.c, a("textunderstand"));
                ((bk) this.e).a((SpeechListener) new bi.a(new a(textUnderstanderListener)), str);
                i2 = 0;
            }
            return i2;
        } catch (SpeechError e) {
            i = e.getErrorCode();
            speechError = e;
            cb.a(speechError);
            return i;
        } catch (Throwable th) {
            i = 20999;
            speechError = th;
            cb.a(speechError);
            return i;
        }
    }

    public void cancel(boolean z) {
        super.cancel(z);
    }

    public boolean destroy() {
        return super.destroy();
    }

    public boolean e() {
        return d();
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }
}
