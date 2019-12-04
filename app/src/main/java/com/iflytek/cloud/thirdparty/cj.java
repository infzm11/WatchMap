package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.IdentityListener;
import com.iflytek.cloud.IdentityResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;

public class cj extends bi {
    /* access modifiers changed from: private */
    public boolean g = false;

    private final class a implements IdentityListener {
        /* access modifiers changed from: private */
        public IdentityListener b = null;
        /* access modifiers changed from: private */
        public boolean c = false;
        private Handler d = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (a.this.b != null) {
                    int i = message.what;
                    if (i != 6) {
                        switch (i) {
                            case 0:
                                a.this.b.onError((SpeechError) message.obj);
                                break;
                            case 4:
                                a.this.b.onResult((IdentityResult) message.obj, message.arg1 == 1);
                                if (!a.this.c) {
                                    cj.this.b("ui_frs");
                                    boolean unused = a.this.c = true;
                                }
                                if (1 == message.arg1) {
                                    cj.this.b("ui_lrs");
                                    break;
                                }
                                break;
                        }
                    } else {
                        Message message2 = (Message) message.obj;
                        a.this.b.onEvent(message2.what, message2.arg1, message2.arg2, (Bundle) message2.obj);
                    }
                    super.handleMessage(message);
                }
            }
        };

        public a(IdentityListener identityListener) {
            this.b = identityListener;
        }

        /* access modifiers changed from: protected */
        public void a() {
            ((bd) cj.this.e).a().a();
            bw.b(cj.this.a, Boolean.valueOf(cj.this.g), (AudioManager.OnAudioFocusChangeListener) null);
        }

        public void onError(SpeechError speechError) {
            a();
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

        public void onResult(IdentityResult identityResult, boolean z) {
            if (z) {
                a();
            }
            Handler handler = this.d;
            int i = 1;
            if (!z) {
                i = 0;
            }
            this.d.sendMessage(handler.obtainMessage(4, i, 0, identityResult));
        }
    }

    public cj(Context context) {
        super(context);
    }

    public int a(IdentityListener identityListener) {
        int i;
        synchronized (this.d) {
            i = 0;
            try {
                this.g = this.c.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
                if (this.e != null && this.e.v()) {
                    this.e.b(this.c.a(SpeechConstant.MFV_INTERRUPT_ERROR, false));
                }
                this.e = new bd(this.a, this.c, a("mfv"));
                bw.a(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
                ((bd) this.e).a((IdentityListener) new a(identityListener));
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

    public int a(String str, String str2, String str3, IdentityListener identityListener) {
        setParameter("sst", str2);
        int a2 = a(identityListener);
        if (a2 != 0) {
            return a2;
        }
        int a3 = a(str, str3, (byte[]) null, 0, 0);
        c(str);
        return a3;
    }

    public int a(String str, String str2, byte[] bArr, int i, int i2) {
        synchronized (this.d) {
            if (this.e == null) {
                cb.c("writeAudio error, no active session.");
                return 21004;
            } else if (i2 < 0) {
                cb.c("writeAudio error, length < 0.");
                return 10109;
            } else if (bArr == null || bArr.length >= i2 + i) {
                ((bd) this.e).a(str, str2, bArr, i, i2);
                return 0;
            } else {
                cb.c("writeAudio error, buffer length < offset + length.");
                return 10109;
            }
        }
    }

    public void b(String str) {
        synchronized (this.d) {
            if (this.e != null) {
                ((bd) this.e).k().a(str);
            }
        }
    }

    public void c(String str) {
        synchronized (this.d) {
            if (this.e != null) {
                ((bd) this.e).a(str, true);
            }
        }
    }

    public void cancel(boolean z) {
        bw.b(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
        super.cancel(z);
    }

    public boolean e() {
        return d();
    }
}
