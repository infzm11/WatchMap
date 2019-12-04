package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.GrammarListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.util.AudioDetector;

public class cm extends bi {
    private boolean g = false;

    private final class a implements GrammarListener {
        /* access modifiers changed from: private */
        public GrammarListener b = null;
        private Handler c = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (a.this.b != null) {
                    switch (message.what) {
                        case 0:
                            a.this.b.onBuildFinish((String) null, (SpeechError) message.obj);
                            break;
                        case 1:
                            a.this.b.onBuildFinish((String) message.obj, (SpeechError) null);
                            break;
                    }
                    super.handleMessage(message);
                }
            }
        };

        public a(GrammarListener grammarListener) {
            this.b = grammarListener;
        }

        public void onBuildFinish(String str, SpeechError speechError) {
            this.c.sendMessage(speechError != null ? this.c.obtainMessage(0, speechError) : this.c.obtainMessage(1, str));
        }
    }

    private final class b implements LexiconListener {
        /* access modifiers changed from: private */
        public LexiconListener b = null;
        private Handler c = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (b.this.b != null) {
                    switch (message.what) {
                        case 0:
                            b.this.b.onLexiconUpdated((String) null, (SpeechError) message.obj);
                            break;
                        case 1:
                            b.this.b.onLexiconUpdated((String) message.obj, (SpeechError) null);
                            break;
                    }
                    super.handleMessage(message);
                }
            }
        };

        public b(LexiconListener lexiconListener) {
            this.b = lexiconListener;
        }

        public void onLexiconUpdated(String str, SpeechError speechError) {
            this.c.sendMessage(speechError != null ? this.c.obtainMessage(0, speechError) : this.c.obtainMessage(1, str));
        }
    }

    private final class c implements RecognizerListener {
        /* access modifiers changed from: private */
        public RecognizerListener b = null;
        /* access modifiers changed from: private */
        public boolean c = false;
        private Handler d = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (c.this.b != null) {
                    int i = message.what;
                    if (i != 6) {
                        switch (i) {
                            case 0:
                                c.this.b.onError((SpeechError) message.obj);
                                break;
                            case 1:
                                c.this.b.onVolumeChanged(message.arg1, (byte[]) message.obj);
                                break;
                            case 2:
                                c.this.b.onBeginOfSpeech();
                                break;
                            case 3:
                                c.this.b.onEndOfSpeech();
                                break;
                            case 4:
                                c.this.b.onResult((RecognizerResult) message.obj, message.arg1 == 1);
                                if (!c.this.c) {
                                    cm.this.b("ui_frs");
                                    boolean unused = c.this.c = true;
                                }
                                if (1 == message.arg1) {
                                    cm.this.b("ui_lrs");
                                    break;
                                }
                                break;
                        }
                    } else {
                        Message message2 = (Message) message.obj;
                        c.this.b.onEvent(message2.what, message2.arg1, message2.arg2, (Bundle) message2.obj);
                    }
                    super.handleMessage(message);
                }
            }
        };

        public c(RecognizerListener recognizerListener) {
            this.b = recognizerListener;
        }

        public void onBeginOfSpeech() {
            cb.a("onBeginOfSpeech");
            this.d.sendMessage(this.d.obtainMessage(2, 0, 0, (Object) null));
        }

        public void onEndOfSpeech() {
            this.d.sendMessage(this.d.obtainMessage(3, 0, 0, (Object) null));
        }

        public void onError(SpeechError speechError) {
            cm.this.f();
            this.d.sendMessage(this.d.obtainMessage(0, speechError));
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = bundle;
            this.d.sendMessage(this.d.obtainMessage(6, 0, 0, message));
        }

        public void onResult(RecognizerResult recognizerResult, boolean z) {
            if (z) {
                cm.this.f();
            }
            Handler handler = this.d;
            int i = 1;
            if (!z) {
                i = 0;
            }
            this.d.sendMessage(handler.obtainMessage(4, i, 0, recognizerResult));
        }

        public void onVolumeChanged(int i, byte[] bArr) {
            this.d.sendMessage(this.d.obtainMessage(1, i, 0, bArr));
        }
    }

    public cm(Context context) {
        super(context);
    }

    public int a(RecognizerListener recognizerListener) {
        int i;
        synchronized (this.d) {
            i = 0;
            try {
                this.g = this.c.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
                if (this.e != null && this.e.v()) {
                    this.e.b(this.c.a(SpeechConstant.ASR_INTERRUPT_ERROR, false));
                }
                this.e = h() ? new ay(this.a, this.c, a("iat")) : new ax(this.a, this.c, a("iat"));
                bw.a(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
                ((ax) this.e).a((RecognizerListener) new c(recognizerListener));
            } catch (SpeechError e) {
                i = e.getErrorCode();
                cb.a((Throwable) e);
            } catch (Throwable th) {
                i = 20999;
                cb.a(th);
            }
        }
        return i;
    }

    public int a(String str, String str2, GrammarListener grammarListener) {
        if (TextUtils.isEmpty(str2)) {
            return 20009;
        }
        if (TextUtils.isEmpty(str) || grammarListener == null) {
            return 20012;
        }
        new aw().a(str, str2, (GrammarListener) new a(grammarListener), this.c);
        return 0;
    }

    public int a(String str, String str2, LexiconListener lexiconListener) {
        if (TextUtils.isEmpty(str2)) {
            return 20009;
        }
        if (TextUtils.isEmpty(str) || lexiconListener == null) {
            return 20012;
        }
        aw awVar = new aw();
        this.c.a(SpeechConstant.SUBJECT, "uup", false);
        String parameter = getParameter(SpeechConstant.LEXICON_TYPE);
        if (TextUtils.isEmpty(parameter)) {
            parameter = str;
        }
        this.c.a("data_type", parameter, false);
        awVar.a(str, str2, (LexiconListener) new b(lexiconListener), this.c);
        return 0;
    }

    public int a(byte[] bArr, int i, int i2) {
        synchronized (this.d) {
            if (this.e == null) {
                cb.a("writeAudio error, no active session.");
                return 21004;
            }
            if (bArr != null) {
                if (bArr.length > 0) {
                    if (bArr.length < i2 + i) {
                        cb.a("writeAudio error,buffer length < length.");
                        return 10109;
                    } else if (((ax) this.e).a() != -1) {
                        return 10106;
                    } else {
                        int a2 = ((ax) this.e).a(bArr, i, i2);
                        return a2;
                    }
                }
            }
            cb.a("writeAudio error,buffer is null.");
            return 10109;
        }
    }

    public void b(String str) {
        synchronized (this.d) {
            if (this.e != null) {
                ((ax) this.e).o().a(str);
            }
        }
    }

    public void cancel(boolean z) {
        synchronized (this.d) {
            f();
            super.cancel(z);
        }
    }

    public void e() {
        synchronized (this.d) {
            if (this.e != null) {
                ((ax) this.e).a(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this.e != null) {
            String e = this.e.x().e(SpeechConstant.ASR_AUDIO_PATH);
            if (!TextUtils.isEmpty(e) && bv.a(((ax) this.e).b(), e)) {
                bv.a(this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null), e, this.e.x().a("sample_rate", this.e.s));
            }
        }
        bw.b(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
    }

    public boolean g() {
        return d();
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return TextUtils.isEmpty(this.c.e("bos_dispose")) ? AudioDetector.TYPE_META.equalsIgnoreCase(this.c.e(AudioDetector.VAD_ENGINE)) : this.c.a("bos_dispose", false);
    }
}
