package com.iflytek.cloud;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cn;
import com.iflytek.cloud.util.ResourceUtil;
import com.iflytek.speech.SpeechSynthesizerAidl;
import com.iflytek.speech.SynthesizerListener;

public class SpeechSynthesizer extends bh {
    private static SpeechSynthesizer d;
    InitListener a = null;
    private cn e = null;
    private SpeechSynthesizerAidl f = null;
    private a g = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (SpeechSynthesizer.this.a != null) {
                SpeechSynthesizer.this.a.onInit(0);
            }
        }
    };

    private final class a implements SynthesizerListener {
        private SynthesizerListener a;
        /* access modifiers changed from: private */
        public SynthesizerListener b;
        private Handler c;

        public void onBufferProgress(int i, int i2, int i3, String str) {
            if (this.a != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("percent", i);
                bundle.putInt("begpos", i2);
                bundle.putInt("endpos", i3);
                bundle.putString("spellinfo", str);
                if (this.a != null) {
                    Message.obtain(this.c, 2, bundle).sendToTarget();
                }
            }
        }

        public void onCompleted(SpeechError speechError) {
            if (this.a != null) {
                Message.obtain(this.c, 6, speechError).sendToTarget();
            }
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
            if (this.a != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.arg1 = 0;
                obtain.arg2 = 0;
                obtain.obj = bundle;
                Message.obtain(this.c, 7, 0, 0, obtain).sendToTarget();
            }
        }

        public void onSpeakBegin() {
            if (this.a != null) {
                Message.obtain(this.c, 1).sendToTarget();
            }
        }

        public void onSpeakPaused() {
            if (this.a != null) {
                Message.obtain(this.c, 3).sendToTarget();
            }
        }

        public void onSpeakProgress(int i, int i2, int i3) {
            if (this.a != null) {
                Message.obtain(this.c, 5, i, i2, Integer.valueOf(i3)).sendToTarget();
            }
        }

        public void onSpeakResumed() {
            if (this.a != null) {
                Message.obtain(this.c, 4).sendToTarget();
            }
        }
    }

    protected SpeechSynthesizer(Context context, InitListener initListener) {
        this.a = initListener;
        this.e = new cn(context);
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility == null || !utility.a() || utility.getEngineMode() == bh.a.MSC) {
            Message.obtain(this.h, 0, 0, 0, (Object) null).sendToTarget();
        } else {
            this.f = new SpeechSynthesizerAidl(context.getApplicationContext(), initListener);
        }
    }

    public static SpeechSynthesizer createSynthesizer(Context context, InitListener initListener) {
        synchronized (b) {
            if (d == null && SpeechUtility.getUtility() != null) {
                d = new SpeechSynthesizer(context, initListener);
            }
        }
        return d;
    }

    public static SpeechSynthesizer getSynthesizer() {
        return d;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null && utility.a() && utility.getEngineMode() != bh.a.MSC) {
            if (this.f != null && !this.f.isAvailable()) {
                this.f.destory();
                this.f = null;
            }
            this.f = new SpeechSynthesizerAidl(context.getApplicationContext(), this.a);
        } else if (this.a != null && this.f != null) {
            this.f.destory();
            this.f = null;
        }
    }

    public boolean destroy() {
        SpeechSynthesizerAidl speechSynthesizerAidl = this.f;
        if (speechSynthesizerAidl != null) {
            speechSynthesizerAidl.destory();
        }
        cn cnVar = this.e;
        boolean destroy = cnVar != null ? cnVar.destroy() : true;
        if (destroy) {
            destroy = super.destroy();
            if (destroy) {
                synchronized (b) {
                    d = null;
                }
                SpeechUtility utility = SpeechUtility.getUtility();
                if (utility != null) {
                    cb.a("Destory tts engine.");
                    utility.setParameter(ResourceUtil.ENGINE_DESTROY, "engine_destroy=tts");
                    return destroy;
                }
            }
        }
        return destroy;
    }

    public String getParameter(String str) {
        if (SpeechConstant.LOCAL_SPEAKERS.equals(str) && this.f != null) {
            return this.f.getParameter(str);
        }
        if (!SpeechConstant.TTS_PLAY_STATE.equals(str) || this.e == null) {
            return super.getParameter(str);
        }
        return "" + this.e.h();
    }

    public boolean isSpeaking() {
        if (this.e == null || !this.e.g()) {
            return this.f != null && this.f.isSpeaking();
        }
        return true;
    }

    public void pauseSpeaking() {
        if (this.e != null && this.e.g()) {
            this.e.e();
        } else if (this.f != null && this.f.isSpeaking() && this.g != null) {
            this.f.pauseSpeaking(this.g.b);
        }
    }

    public void resumeSpeaking() {
        if (this.e != null && this.e.g()) {
            this.e.f();
        } else if (this.f != null && this.f.isSpeaking() && this.g != null) {
            this.f.resumeSpeaking(this.g.b);
        }
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int startSpeaking(String str, SynthesizerListener synthesizerListener) {
        cb.a("stop all current session in new session");
        stopSpeaking();
        a("tts", this.f);
        if (this.e == null) {
            return 21001;
        }
        this.e.setParameter(this.c);
        this.c.c(SpeechConstant.NEXT_TEXT);
        return this.e.a(str, synthesizerListener);
    }

    public void stopSpeaking() {
        if (this.e != null && this.e.g()) {
            this.e.a(false);
        }
        if (this.f != null && this.f.isSpeaking() && this.g != null) {
            this.f.stopSpeaking(this.g.b);
        }
    }

    public int synthesizeToUri(String str, String str2, SynthesizerListener synthesizerListener) {
        if (this.e != null) {
            return this.e.a(str, str2, synthesizerListener);
        }
        return 21001;
    }
}
