package com.iflytek.cloud;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cp;
import com.iflytek.msc.MSC;
import com.iflytek.speech.TextUnderstanderAidl;
import com.iflytek.speech.TextUnderstanderListener;

public class TextUnderstander extends bh {
    private static TextUnderstander e;
    private cp a = null;
    private TextUnderstanderAidl d = null;
    private a f = null;
    /* access modifiers changed from: private */
    public InitListener g = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (TextUnderstander.this.g != null) {
                TextUnderstander.this.g.onInit(0);
            }
        }
    };

    private final class a implements TextUnderstanderListener {
        /* access modifiers changed from: private */
        public TextUnderstanderListener a;
        private Handler b;

        public void onError(SpeechError speechError) {
            this.b.sendMessage(this.b.obtainMessage(0, speechError));
        }

        public void onResult(UnderstanderResult understanderResult) {
            this.b.sendMessage(this.b.obtainMessage(4, understanderResult));
        }
    }

    protected TextUnderstander(Context context, InitListener initListener) {
        this.g = initListener;
        if (MSC.isLoaded()) {
            this.a = new cp(context);
        }
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null && utility.a() && utility.getEngineMode() != bh.a.MSC) {
            this.d = new TextUnderstanderAidl(context.getApplicationContext(), initListener);
        } else if (initListener != null) {
            Message.obtain(this.h, 0, 0, 0, (Object) null).sendToTarget();
        }
    }

    public static synchronized TextUnderstander createTextUnderstander(Context context, InitListener initListener) {
        TextUnderstander textUnderstander;
        synchronized (TextUnderstander.class) {
            synchronized (b) {
                if (e == null && SpeechUtility.getUtility() != null) {
                    e = new TextUnderstander(context, initListener);
                }
            }
            textUnderstander = e;
        }
        return textUnderstander;
    }

    public static TextUnderstander getTextUnderstander() {
        return e;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null && utility.a() && utility.getEngineMode() != bh.a.MSC) {
            if (this.d != null && !this.d.isAvailable()) {
                this.d.destory();
                this.d = null;
            }
            this.d = new TextUnderstanderAidl(context.getApplicationContext(), this.g);
        } else if (this.g != null && this.d != null) {
            this.d.destory();
            this.d = null;
        }
    }

    public void cancel() {
        if (this.a != null) {
            this.a.cancel(false);
        } else if (this.d != null) {
            this.d.cancel(this.f.a);
        } else {
            cb.c("TextUnderstander cancel failed, is not running");
        }
    }

    public boolean destroy() {
        TextUnderstanderAidl textUnderstanderAidl = this.d;
        if (textUnderstanderAidl != null) {
            textUnderstanderAidl.destory();
        }
        cp cpVar = this.a;
        boolean destroy = cpVar != null ? cpVar.destroy() : true;
        if (destroy) {
            destroy = super.destroy();
            if (destroy) {
                this.d = null;
                synchronized (b) {
                    e = null;
                }
                return destroy;
            }
        }
        return destroy;
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean isUnderstanding() {
        if (this.a == null || !this.a.e()) {
            return this.d != null && this.d.isUnderstanding();
        }
        return true;
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int understandText(String str, TextUnderstanderListener textUnderstanderListener) {
        bh.a a2 = a(SpeechConstant.ENG_NLU, this.d);
        cb.a("start engine mode = " + a2.toString());
        if (this.a == null) {
            return 21001;
        }
        this.a.setParameter(this.c);
        return this.a.a(str, textUnderstanderListener);
    }
}
