package com.iflytek.cloud;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.co;
import com.iflytek.speech.SpeechUnderstanderAidl;
import com.iflytek.speech.SpeechUnderstanderListener;

public class SpeechUnderstander extends bh {
    protected static SpeechUnderstander a;
    private co d = null;
    private SpeechUnderstanderAidl e = null;
    private a f = null;
    /* access modifiers changed from: private */
    public InitListener g = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (SpeechUnderstander.this.g != null) {
                SpeechUnderstander.this.g.onInit(0);
            }
        }
    };

    private final class a implements SpeechUnderstanderListener {
        /* access modifiers changed from: private */
        public SpeechUnderstanderListener a;
        private Handler b;

        public void onBeginOfSpeech() {
            this.b.sendMessage(this.b.obtainMessage(2, 0, 0, (Object) null));
        }

        public void onEndOfSpeech() {
            this.b.sendMessage(this.b.obtainMessage(3, 0, 0, (Object) null));
        }

        public void onError(SpeechError speechError) {
            this.b.sendMessage(this.b.obtainMessage(0, speechError));
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = bundle;
            this.b.sendMessage(this.b.obtainMessage(6, 0, 0, message));
        }

        public void onResult(UnderstanderResult understanderResult) {
            this.b.sendMessage(this.b.obtainMessage(4, understanderResult));
        }

        public void onVolumeChanged(int i, byte[] bArr) {
            this.b.sendMessage(this.b.obtainMessage(1, i, 0, bArr));
        }
    }

    protected SpeechUnderstander(Context context, InitListener initListener) {
        this.g = initListener;
        this.d = new co(context);
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null && utility.a() && utility.getEngineMode() != bh.a.MSC) {
            this.e = new SpeechUnderstanderAidl(context.getApplicationContext(), initListener);
        } else if (initListener != null) {
            Message.obtain(this.h, 0, 0, 0, (Object) null).sendToTarget();
        }
    }

    public static synchronized SpeechUnderstander createUnderstander(Context context, InitListener initListener) {
        SpeechUnderstander speechUnderstander;
        synchronized (SpeechUnderstander.class) {
            synchronized (b) {
                if (a == null && SpeechUtility.getUtility() != null) {
                    a = new SpeechUnderstander(context, initListener);
                }
            }
            speechUnderstander = a;
        }
        return speechUnderstander;
    }

    public static SpeechUnderstander getUnderstander() {
        return a;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null && utility.a() && utility.getEngineMode() != bh.a.MSC) {
            if (this.e != null && !this.e.isAvailable()) {
                this.e.destory();
                this.e = null;
            }
            this.e = new SpeechUnderstanderAidl(context.getApplicationContext(), this.g);
        } else if (this.g != null && this.e != null) {
            this.e.destory();
            this.e = null;
        }
    }

    public void cancel() {
        if (this.d != null && this.d.a()) {
            this.d.a(false);
        } else if (this.e == null || !this.e.isUnderstanding()) {
            cb.c("SpeechUnderstander cancel failed, is not running");
        } else {
            this.e.cancel(this.f.a);
        }
    }

    public boolean destroy() {
        SpeechUnderstanderAidl speechUnderstanderAidl = this.e;
        if (speechUnderstanderAidl != null) {
            speechUnderstanderAidl.destory();
        }
        synchronized (this) {
            this.e = null;
        }
        co coVar = this.d;
        boolean c = coVar != null ? coVar.c() : true;
        if (c) {
            c = super.destroy();
            if (c) {
                synchronized (b) {
                    a = null;
                }
                return c;
            }
        }
        return c;
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean isUnderstanding() {
        if (this.d == null || !this.d.a()) {
            return this.e != null && this.e.isUnderstanding();
        }
        return true;
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int startUnderstanding(SpeechUnderstanderListener speechUnderstanderListener) {
        bh.a a2 = a(SpeechConstant.ENG_NLU, this.e);
        cb.a("start engine mode = " + a2.toString());
        if (this.d == null) {
            return 21001;
        }
        this.d.a(this.c);
        return this.d.a(speechUnderstanderListener);
    }

    public void stopUnderstanding() {
        if (this.d != null && this.d.a()) {
            this.d.b();
        } else if (this.e == null || !this.e.isUnderstanding()) {
            cb.a("SpeechUnderstander stopUnderstanding, is not understanding");
        } else {
            this.e.stopUnderstanding(this.f.a);
        }
    }

    public int writeAudio(byte[] bArr, int i, int i2) {
        if (this.d != null && this.d.a()) {
            return this.d.a(bArr, i, i2);
        }
        if (this.e != null && this.e.isUnderstanding()) {
            return this.e.writeAudio(bArr, i, i2);
        }
        cb.a("SpeechUnderstander writeAudio, is not understanding");
        return 21004;
    }
}
