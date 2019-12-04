package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.record.b;
import com.iflytek.cloud.record.c;
import java.io.IOException;
import java.util.ArrayList;

public class bn extends bi {
    public boolean g = false;
    public boolean h = false;
    public String i = null;
    public SpeechError j = null;
    final Handler k = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            try {
                if (bn.this.o != null) {
                    int i = message.what;
                    if (i != 2) {
                        switch (i) {
                            case 6:
                                bn.this.o.onCompleted((SpeechError) message.obj);
                                return;
                            case 7:
                                Message message2 = (Message) message.obj;
                                if (message2 != null) {
                                    bn.this.o.onEvent(message2.what, message2.arg1, message2.arg2, (Bundle) message2.obj);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        Bundle bundle = (Bundle) message.obj;
                        bn.this.o.onBufferProgress(bundle.getInt("percent"), bundle.getInt("begpos"), bundle.getInt("endpos"), bundle.getString("spellinfo"));
                    }
                }
            } catch (Exception e) {
                cb.c("SpeakSession mUiHandler error:" + e);
            }
        }
    };
    /* access modifiers changed from: private */
    public c l = null;
    /* access modifiers changed from: private */
    public b m = null;
    /* access modifiers changed from: private */
    public SynthesizerListener n = null;
    /* access modifiers changed from: private */
    public SynthesizerListener o = null;
    /* access modifiers changed from: private */
    public a p = null;
    private int q = 0;
    private boolean r = false;
    private bm s = new bm() {
        public void a(SpeechError speechError) {
            bn.this.j = speechError;
            if (speechError == null) {
                bn.this.h = true;
                String str = null;
                if (bn.this.e != null) {
                    str = bn.this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null);
                }
                bn.this.m.a(str);
                if (bn.this.p != null) {
                    bn.this.p.a();
                    cb.a("onCompleted NextSession pause");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, bn.this.e.f());
            Message.obtain(bn.this.u, 7, bundle).sendToTarget();
            if (bn.this.n != null && speechError != null) {
                Message.obtain(bn.this.u, 6, speechError).sendToTarget();
                if (bn.this.l != null) {
                    bn.this.l.e();
                }
            }
        }

        public void a(ArrayList<byte[]> arrayList, int i, int i2, int i3, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("percent", i);
            bundle.putInt("begpos", i2);
            bundle.putInt("endpos", i3);
            bundle.putString("spellinfo", str);
            if (bn.this.n != null) {
                Message.obtain(bn.this.u, 2, bundle).sendToTarget();
            }
            try {
                bn.this.m.a(arrayList, i, i2, i3);
                bn.this.j();
            } catch (IOException e) {
                cb.a((Throwable) e);
                bn.this.j = new SpeechError(20010);
                Message.obtain(bn.this.u, 6, bn.this.j).sendToTarget();
                bn.this.cancel(false);
            }
        }
    };
    private c.a t = new c.a() {
        public void a() {
            if (bn.this.n != null) {
                Message.obtain(bn.this.u, 3).sendToTarget();
            }
        }

        public void a(int i, int i2, int i3) {
            Message.obtain(bn.this.u, 5, i, i2, Integer.valueOf(i3)).sendToTarget();
        }

        public void a(SpeechError speechError) {
            Message.obtain(bn.this.u, 6, speechError).sendToTarget();
            if (bn.this.l != null) {
                bn.this.l.e();
            }
            bn.this.cancel(false);
        }

        public void b() {
            if (bn.this.n != null) {
                Message.obtain(bn.this.u, 4).sendToTarget();
            }
        }

        public void c() {
            Message.obtain(bn.this.u, 6, (Object) null).sendToTarget();
        }
    };
    /* access modifiers changed from: private */
    public Handler u = new Handler(Looper.getMainLooper()) {
        private int b = 0;

        public void handleMessage(Message message) {
            try {
                if (bn.this.n != null) {
                    switch (message.what) {
                        case 1:
                            cb.a("tts-onSpeakBegin");
                            bn.this.n.onSpeakBegin();
                            return;
                        case 2:
                            Bundle bundle = (Bundle) message.obj;
                            int i = bundle.getInt("percent");
                            int i2 = bundle.getInt("begpos");
                            int i3 = bundle.getInt("endpos");
                            String string = bundle.getString("spellinfo");
                            if (bn.this.n != null) {
                                cb.b("tts-onBufferProgress percent: " + i + ", beg: " + i2 + ", endpos: " + i3 + ", spell: " + string);
                                bn.this.n.onBufferProgress(i, i2, i3, string);
                                return;
                            }
                            return;
                        case 3:
                            cb.a("tts-onSpeakPaused");
                            bn.this.n.onSpeakPaused();
                            return;
                        case 4:
                            cb.a("tts-onSpeakResumed");
                            bn.this.n.onSpeakResumed();
                            return;
                        case 5:
                            int intValue = ((Integer) message.obj).intValue();
                            if (bn.this.n != null) {
                                if (this.b != intValue) {
                                    cb.a("tts-onSpeakProgress percent: " + message.arg1 + ", begpos: " + message.arg2 + ", endpos: " + intValue);
                                    this.b = intValue;
                                }
                                bn.this.n.onSpeakProgress(message.arg1, message.arg2, intValue);
                                return;
                            }
                            return;
                        case 6:
                            cb.a("tts-onCompleted");
                            bn.this.n.onCompleted((SpeechError) message.obj);
                            return;
                        case 7:
                            bn.this.n.onEvent(20001, 0, 0, (Bundle) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                cb.c("SpeakSession mUiHandler error:" + e);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean v = true;

    public interface a {
        void a();
    }

    public bn(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!this.r && this.l != null && this.m.a(this.q)) {
            this.r = true;
            this.l.a(this.m, this.t);
            if (this.n != null) {
                Message.obtain(this.u, 1).sendToTarget();
            }
        }
    }

    public synchronized int a(String str, ce ceVar, SynthesizerListener synthesizerListener, boolean z, String str2) {
        int i2;
        i2 = 0;
        try {
            cb.a("tts start:" + System.currentTimeMillis());
            this.n = synthesizerListener;
            this.i = str;
            setParameter(ceVar);
            int a2 = ceVar.a(SpeechConstant.STREAM_TYPE, 3);
            boolean a3 = ceVar.a(SpeechConstant.KEY_REQUEST_FOCUS, true);
            if (z) {
                c cVar = new c(this.a, a2, a3, ce.b(this.c.d(SpeechConstant.TTS_FADING), false), ce.b(this.c.d("tts_buf_fading"), false));
                this.l = cVar;
            }
            this.e = new bl(this.a, ceVar, a("tts"));
            b bVar = new b(this.a, this.e.t(), Math.max(1, ceVar.a("tts_min_audio_len", 0) / 1000) + (str != null ? str.length() : 0), str2, ceVar.a("tts_proc_scale", 100));
            this.m = bVar;
            this.m.a(ce.b(this.c.d("end_with_null"), true));
            this.q = ceVar.a(SpeechConstant.TTS_BUFFER_TIME, 0);
            cb.a("minPlaySec:" + this.q);
            this.r = false;
            ((bl) this.e).a(str, this.s);
            this.g = true;
        } catch (SpeechError e) {
            i2 = e.getErrorCode();
            cb.a((Throwable) e);
        } catch (Throwable th) {
            i2 = 20999;
            cb.a(th);
        }
        return i2;
    }

    public int a(String str, final String str2, ce ceVar, SynthesizerListener synthesizerListener) {
        SpeechError speechError;
        int i2;
        try {
            this.v = ceVar.a("message_main_thread", true);
            this.o = synthesizerListener;
            this.e = new bl(this.a, ceVar, a("tts"));
            b bVar = new b(this.a, this.e.t(), Math.max(1, ceVar.a("tts_min_audio_len", 0) / 1000) + (str != null ? str.length() : 0), str2, ceVar.a("tts_proc_scale", 100));
            this.m = bVar;
            ((bl) this.e).a(str, new bm() {
                public void a(SpeechError speechError) {
                    if (bn.this.o != null && speechError != null) {
                        if (bn.this.v) {
                            Message.obtain(bn.this.k, 6, speechError).sendToTarget();
                        } else {
                            bn.this.o.onCompleted(speechError);
                        }
                    }
                }

                public void a(ArrayList<byte[]> arrayList, int i, int i2, int i3, String str) throws SpeechError {
                    if (!(bn.this.e == null || !bn.this.e.x().a(SpeechConstant.TTS_DATA_NOTIFY, false) || bn.this.o == null || arrayList == null)) {
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            Bundle bundle = new Bundle();
                            bundle.putByteArray(SpeechEvent.KEY_EVENT_TTS_BUFFER, arrayList.get(i4));
                            if (bn.this.v) {
                                Message obtain = Message.obtain();
                                obtain.what = 21001;
                                obtain.arg1 = 0;
                                obtain.arg2 = 0;
                                obtain.obj = bundle;
                                Message.obtain(bn.this.k, 7, 0, 0, obtain).sendToTarget();
                            } else {
                                bn.this.o.onEvent(21001, 0, 0, bundle);
                            }
                        }
                    }
                    try {
                        bn.this.m.a(arrayList, i, i2, i3);
                        if (bn.this.o != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("percent", i);
                            bundle2.putInt("begpos", i2);
                            bundle2.putInt("endpos", i3);
                            bundle2.putString("spellinfo", str);
                            if (bn.this.v) {
                                Message.obtain(bn.this.k, 2, bundle2).sendToTarget();
                            } else {
                                bn.this.o.onBufferProgress(i, i2, i3, str);
                            }
                        }
                        if (i >= 100) {
                            if (bn.this.e == null || !bn.this.e.x().a(SpeechConstant.TTS_DATA_NOTIFY, false)) {
                                String b2 = bn.this.e != null ? bn.this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null) : null;
                                if (bn.this.m.b() == 0) {
                                    throw new SpeechError(10118);
                                } else if (!bn.this.m.a(b2)) {
                                    throw new IOException();
                                }
                            } else {
                                String b3 = bn.this.e.x().b(SpeechConstant.AUDIO_FORMAT, (String) null);
                                if (!TextUtils.isEmpty(str2) && !bn.this.m.a(b3)) {
                                    throw new IOException();
                                }
                            }
                            if (bn.this.o == null) {
                                return;
                            }
                            if (bn.this.v) {
                                Message.obtain(bn.this.k, 6, (Object) null).sendToTarget();
                            } else {
                                bn.this.o.onCompleted((SpeechError) null);
                            }
                        }
                    } catch (IOException e) {
                        cb.a((Throwable) e);
                        if (bn.this.o != null) {
                            if (bn.this.v) {
                                Message.obtain(bn.this.k, 6, new SpeechError(20010)).sendToTarget();
                            } else {
                                try {
                                    bn.this.o.onCompleted(new SpeechError(20010));
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (bn.this.e != null) {
                            bn.this.e.b(false);
                        }
                    }
                }
            });
            return 0;
        } catch (SpeechError e) {
            i2 = e.getErrorCode();
            speechError = e;
            cb.a(speechError);
            return i2;
        } catch (Throwable th) {
            i2 = 20999;
            speechError = th;
            cb.a(speechError);
            return i2;
        }
    }

    public void a(SynthesizerListener synthesizerListener) {
        this.n = synthesizerListener;
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public void a(String str, ce ceVar) {
        setParameter(ceVar);
        this.i = str;
    }

    public void cancel(boolean z) {
        cb.a("SpeakSession cancel notifyError:" + z);
        if (h()) {
            if (this.n != null) {
                this.n.onEvent(21002, 0, 0, (Bundle) null);
            }
            if (this.o != null) {
                this.o.onEvent(21002, 0, 0, (Bundle) null);
            }
            if (z) {
                SpeechError speechError = new SpeechError(20017);
                if (this.n != null) {
                    cb.a("tts-onCompleted-cancel");
                    Message.obtain(this.u, 6, speechError).sendToTarget();
                }
                if (this.o != null) {
                    if (this.v) {
                        Message.obtain(this.k, 6, speechError).sendToTarget();
                    } else {
                        this.o.onCompleted(speechError);
                    }
                }
            }
        }
        this.n = null;
        this.o = null;
        super.cancel(false);
        if (this.l != null) {
            this.l.e();
        }
    }

    public boolean d() {
        return super.d();
    }

    public boolean destroy() {
        synchronized (this.d) {
            cancel(false);
        }
        return true;
    }

    public void e() {
        if (!this.h) {
            a(this.i, this.c, (SynthesizerListener) null, false, this.c.e("tts_next_audio_path"));
        }
    }

    public int f() {
        if (this.m == null || this.l == null) {
            return 4;
        }
        return this.l.a();
    }

    public void g() {
        if (this.m != null && this.l != null) {
            this.l.c();
        }
    }

    public boolean h() {
        if (d()) {
            return true;
        }
        return (f() == 4 || f() == 0) ? false : true;
    }

    public void i() {
        if (this.m == null || this.l == null) {
            this.l = new c(this.a);
            j();
            return;
        }
        this.l.d();
    }
}
