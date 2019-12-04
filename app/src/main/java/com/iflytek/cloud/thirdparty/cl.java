package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.EvaluatorListener;
import com.iflytek.cloud.EvaluatorResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;

public class cl extends bi {
    private boolean g = false;

    private final class a implements EvaluatorListener {
        /* access modifiers changed from: private */
        public EvaluatorListener b = null;
        private Handler c = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (a.this.b != null) {
                    switch (message.what) {
                        case 0:
                            a.this.b.onError((SpeechError) message.obj);
                            break;
                        case 1:
                            a.this.b.onVolumeChanged(message.arg1, (byte[]) message.obj);
                            break;
                        case 2:
                            a.this.b.onBeginOfSpeech();
                            break;
                        case 3:
                            a.this.b.onEndOfSpeech();
                            break;
                        case 4:
                            EvaluatorListener a2 = a.this.b;
                            EvaluatorResult evaluatorResult = (EvaluatorResult) message.obj;
                            boolean z = true;
                            if (message.arg1 != 1) {
                                z = false;
                            }
                            a2.onResult(evaluatorResult, z);
                            break;
                        case 6:
                            Message message2 = (Message) message.obj;
                            a.this.b.onEvent(message2.what, message2.arg1, message2.arg2, (Bundle) message2.obj);
                            break;
                    }
                    super.handleMessage(message);
                }
            }
        };

        public a(EvaluatorListener evaluatorListener) {
            this.b = evaluatorListener;
        }

        public void onBeginOfSpeech() {
            cb.a("onBeginOfSpeech");
            this.c.sendMessage(this.c.obtainMessage(2, 0, 0, (Object) null));
        }

        public void onEndOfSpeech() {
            this.c.sendMessage(this.c.obtainMessage(3, 0, 0, (Object) null));
        }

        public void onError(SpeechError speechError) {
            cl.this.f();
            this.c.sendMessage(this.c.obtainMessage(0, speechError));
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = bundle;
            Message.obtain(this.c, 6, message).sendToTarget();
        }

        public void onResult(EvaluatorResult evaluatorResult, boolean z) {
            if (z) {
                cl.this.f();
            }
            Handler handler = this.c;
            int i = 1;
            if (!z) {
                i = 0;
            }
            this.c.sendMessage(handler.obtainMessage(4, i, 0, evaluatorResult));
        }

        public void onVolumeChanged(int i, byte[] bArr) {
            this.c.sendMessage(this.c.obtainMessage(1, i, 0, bArr));
        }
    }

    public cl(Context context) {
        super(context);
    }

    public int a(String str, String str2, EvaluatorListener evaluatorListener) {
        int i;
        synchronized (this.d) {
            i = 0;
            try {
                this.g = this.c.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
                if (this.e != null && this.e.v()) {
                    this.e.b(this.c.a(SpeechConstant.ISE_INTERRUPT_ERROR, false));
                }
                this.e = new av(this.a, this.c, a(SpeechConstant.ENG_EVA));
                bw.a(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
                ((av) this.e).a(str, str2, (EvaluatorListener) new a(evaluatorListener));
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

    public int a(byte[] bArr, String str, EvaluatorListener evaluatorListener) {
        int i;
        synchronized (this.d) {
            i = 0;
            try {
                this.g = this.c.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
                if (this.e != null && this.e.v()) {
                    this.e.b(this.c.a(SpeechConstant.ISE_INTERRUPT_ERROR, false));
                }
                this.e = new av(this.a, this.c, a(SpeechConstant.ENG_EVA));
                bw.a(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
                ((av) this.e).a(bArr, str, (EvaluatorListener) new a(evaluatorListener));
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

    public boolean a(byte[] bArr, int i, int i2) {
        synchronized (this.d) {
            if (this.e == null) {
                cb.a("writeAudio error, no active session.");
                return false;
            }
            if (bArr != null) {
                if (bArr.length > 0) {
                    if (bArr.length < i2 + i) {
                        cb.a("writeAudio error,buffer length < length.");
                        return false;
                    }
                    ((av) this.e).onRecordBuffer(bArr, i, i2);
                    return true;
                }
            }
            cb.a("writeAudio error,buffer is null.");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean b_() {
        return super.b_();
    }

    public void cancel(boolean z) {
        synchronized (this.d) {
            f();
        }
        super.cancel(z);
    }

    public void e() {
        synchronized (this.d) {
            if (this.e != null) {
                ((av) this.e).a(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this.e != null) {
            String e = this.e.x().e(SpeechConstant.ISE_AUDIO_PATH);
            if (!TextUtils.isEmpty(e) && bv.a(((av) this.e).d(), e)) {
                bv.a(this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null), e, this.e.x().a("sample_rate", this.e.s));
            }
        }
        bw.b(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
    }

    public boolean g() {
        return d();
    }
}
