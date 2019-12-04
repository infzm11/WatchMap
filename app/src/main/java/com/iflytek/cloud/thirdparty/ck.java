package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.DataDownloader;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechListener;
import com.iflytek.cloud.VerifierListener;
import com.iflytek.cloud.VerifierResult;
import com.iflytek.cloud.thirdparty.az;
import java.util.Random;

public class ck extends bi {
    /* access modifiers changed from: private */
    public boolean g = false;

    private final class a implements VerifierListener {
        /* access modifiers changed from: private */
        public VerifierListener b = null;
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
                            a.this.b.onResult((VerifierResult) message.obj);
                            break;
                        case 5:
                            Message message2 = (Message) message.obj;
                            a.this.b.onEvent(message2.what, message2.arg1, message2.arg2, (Bundle) message2.obj);
                            break;
                    }
                    super.handleMessage(message);
                }
            }
        };

        public a(VerifierListener verifierListener) {
            this.b = verifierListener;
        }

        /* access modifiers changed from: protected */
        public void a() {
            String e = ck.this.e.x().e(SpeechConstant.ISV_AUDIO_PATH);
            if (!TextUtils.isEmpty(e) && bv.a(((ba) ck.this.e).j(), e)) {
                bv.a(ck.this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null), e, ck.this.e.x().a("sample_rate", ck.this.e.s));
            }
            bw.b(ck.this.a, Boolean.valueOf(ck.this.g), (AudioManager.OnAudioFocusChangeListener) null);
        }

        public void onBeginOfSpeech() {
            this.c.sendMessage(this.c.obtainMessage(2, 0, 0, (Object) null));
        }

        public void onEndOfSpeech() {
            this.c.sendMessage(this.c.obtainMessage(3, 0, 0, (Object) null));
        }

        public void onError(SpeechError speechError) {
            a();
            this.c.sendMessage(this.c.obtainMessage(0, speechError));
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            obtain.obj = bundle;
            Message.obtain(this.c, 5, obtain).sendToTarget();
        }

        public void onResult(VerifierResult verifierResult) {
            a();
            this.c.sendMessage(this.c.obtainMessage(4, verifierResult));
        }

        public void onVolumeChanged(int i, byte[] bArr) {
            this.c.sendMessage(this.c.obtainMessage(1, i, 0, bArr));
        }
    }

    public ck(Context context) {
        super(context);
    }

    public int a(VerifierListener verifierListener) {
        int i;
        synchronized (this.d) {
            i = 0;
            try {
                this.g = this.c.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
                if (this.e != null && this.e.v()) {
                    this.e.b(this.c.a(SpeechConstant.ISV_INTERRUPT_ERROR, false));
                }
                this.e = new ba(this.a, this.c, a("verify"));
                bw.a(this.a, Boolean.valueOf(this.g), (AudioManager.OnAudioFocusChangeListener) null);
                ((ba) this.e).a((VerifierListener) new a(verifierListener));
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

    public int a(String str, String str2, SpeechListener speechListener) {
        int i;
        synchronized (this.d) {
            try {
                this.c.a("cmd", str);
                this.c.a(SpeechConstant.AUTH_ID, str2);
                new az(this.a, a("manager")).a(this.c, new az.a(speechListener));
                i = 0;
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
                    } else if (((ba) this.e).k() != -1) {
                        return 10106;
                    } else {
                        ((ba) this.e).onRecordBuffer(bArr, i, i2);
                        return 0;
                    }
                }
            }
            cb.a("writeAudio error,buffer is null.");
            return 10109;
        }
    }

    public String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        new Random();
        String str = "023456789".charAt(r1.nextInt("023456789".length())) + "";
        stringBuffer.append(str);
        String str2 = str;
        for (int i2 = 0; i2 < i - 1; i2++) {
            while (true) {
                Boolean bool = false;
                while (!bool.booleanValue()) {
                    str2 = "023456789".charAt(r1.nextInt("023456789".length())) + "";
                    if (stringBuffer.indexOf(str2) < 0) {
                        if (Integer.parseInt(stringBuffer.charAt(stringBuffer.length() - 1) + "") * Integer.parseInt(str2) != 10) {
                            bool = true;
                        }
                    }
                }
                break;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public void a(SpeechListener speechListener) {
        DataDownloader dataDownloader = new DataDownloader(this.a);
        dataDownloader.setParameter(this.c);
        dataDownloader.downloadData(speechListener);
    }

    public void e() {
        synchronized (this.d) {
            if (this.e != null) {
                ((ba) this.e).a();
            }
        }
    }

    public boolean f() {
        return d();
    }
}
