package com.iflytek.cloud;

import android.content.Context;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cl;

public class SpeechEvaluator extends bh {
    private static SpeechEvaluator a;
    private cl d = null;

    protected SpeechEvaluator(Context context, InitListener initListener) {
        this.d = new cl(context);
    }

    public static SpeechEvaluator createEvaluator(Context context, InitListener initListener) {
        synchronized (b) {
            if (a == null && SpeechUtility.getUtility() != null) {
                a = new SpeechEvaluator(context, (InitListener) null);
            }
        }
        return a;
    }

    public static SpeechEvaluator getEvaluator() {
        return a;
    }

    public void cancel() {
        if (this.d != null && this.d.g()) {
            this.d.cancel(false);
        }
    }

    public boolean destroy() {
        cl clVar = this.d;
        boolean destroy = clVar != null ? clVar.destroy() : true;
        if (destroy) {
            destroy = super.destroy();
            if (destroy) {
                synchronized (b) {
                    a = null;
                }
                return destroy;
            }
        }
        return destroy;
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean isEvaluating() {
        return this.d != null && this.d.g();
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int startEvaluating(String str, String str2, EvaluatorListener evaluatorListener) {
        if (this.d == null) {
            return 21001;
        }
        this.d.setParameter(this.c);
        return this.d.a(str, str2, evaluatorListener);
    }

    public int startEvaluating(byte[] bArr, String str, EvaluatorListener evaluatorListener) {
        if (this.d == null) {
            return 21001;
        }
        this.d.setParameter(this.c);
        return this.d.a(bArr, str, evaluatorListener);
    }

    public void stopEvaluating() {
        if (this.d == null || !this.d.g()) {
            cb.c("SpeechEvaluator stopEvaluating failed, is not running");
        } else {
            this.d.e();
        }
    }

    public boolean writeAudio(byte[] bArr, int i, int i2) {
        if (this.d != null && this.d.g()) {
            return this.d.a(bArr, i, i2);
        }
        cb.c("SpeechEvaluator writeAudio failed, is not running");
        return false;
    }
}
