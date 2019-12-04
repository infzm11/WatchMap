package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.record.PcmRecorder;
import com.iflytek.cloud.record.a;
import com.iflytek.cloud.thirdparty.be;
import com.iflytek.msc.MSC;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ax extends be implements PcmRecorder.PcmRecordListener {
    public static int j;
    public static int k;
    private boolean A;
    private int B;
    protected volatile RecognizerListener a;
    protected boolean b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected int f;
    protected boolean g;
    protected aw h;
    protected PcmRecorder i;
    protected String l;
    protected ConcurrentLinkedQueue<byte[]> m;
    protected ArrayList<String> n;
    protected bg o;
    protected int p;
    private boolean q;
    private String z;

    public ax(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, handlerThread);
        this.a = null;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = 1;
        this.g = true;
        this.h = new aw();
        this.i = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new bg();
        this.p = 0;
        this.q = false;
        this.z = null;
        this.A = false;
        this.B = 0;
        this.m = new ConcurrentLinkedQueue<>();
        this.n = new ArrayList<>();
        this.e = false;
        a(ceVar);
    }

    private void a(boolean z2, byte[] bArr) throws SpeechError, UnsupportedEncodingException {
        String str;
        this.v = SystemClock.elapsedRealtime();
        if (bArr == null || bArr.length <= 0) {
            if (this.n.size() <= 0) {
                String e2 = x().e(SpeechConstant.LOCAL_GRAMMAR);
                if (!TextUtils.isEmpty(e2) && !"sms.irf".equals(e2)) {
                    throw new SpeechError(20005);
                } else if (x().a(SpeechConstant.ASR_NOMATCH_ERROR, true)) {
                    throw new SpeechError(10118);
                }
            }
            str = "";
        } else {
            str = new String(bArr, "utf-8");
        }
        try {
            this.x.a(str, z2);
        } catch (Throwable th) {
            cb.c("DC exception:");
            cb.a(th);
        }
        this.n.add(str);
        if (this.a != null && v()) {
            Bundle bundle = new Bundle();
            bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
            this.a.onEvent(20001, 0, 0, bundle);
            if (z2 && x().a("request_audio_url", false)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(SpeechEvent.KEY_EVENT_AUDIO_URL, this.h.d());
                this.a.onEvent(23001, 0, 0, bundle2);
            }
            RecognizerResult recognizerResult = new RecognizerResult(str);
            cc.a("GetNotifyResult", (String) null);
            this.a.onResult(recognizerResult, z2);
        }
        cb.a("msc result time:" + System.currentTimeMillis());
        if (z2) {
            b((SpeechError) null);
        }
    }

    public int a() {
        return this.f;
    }

    public int a(byte[] bArr, int i2, int i3) {
        onRecordBuffer(bArr, i2, i3);
        return 0;
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
        super.a(message);
        int i2 = message.what;
        if (i2 == 7) {
            k();
        } else if (i2 != 9) {
            switch (i2) {
                case 0:
                    h();
                    return;
                case 1:
                    i();
                    return;
                case 2:
                    b(message);
                    return;
                case 3:
                    j();
                    return;
                case 4:
                    c(message);
                    return;
                default:
                    return;
            }
        } else {
            l();
        }
    }

    public synchronized void a(RecognizerListener recognizerListener) {
        this.a = recognizerListener;
        cb.a("startListening called");
        a_();
    }

    /* access modifiers changed from: protected */
    public void a(SpeechError speechError) {
        bg bgVar;
        String str;
        long j2;
        aw awVar;
        String str2;
        cb.a("onSessionEnd");
        n();
        j = this.h.b("upflow");
        k = this.h.b("downflow");
        f();
        if (this.n.size() <= 0 && speechError == null && x().a(SpeechConstant.ASR_NOMATCH_ERROR, true)) {
            speechError = new SpeechError(10118);
        }
        if (speechError != null) {
            bgVar = this.o;
            str = "app_ret";
            j2 = (long) speechError.getErrorCode();
        } else {
            bgVar = this.o;
            str = "app_ret";
            j2 = 0;
        }
        bgVar.a(str, j2, false);
        this.o.a("rec_ustop", this.e ? "1" : "0", false);
        this.h.a("sessinfo", this.o.a());
        cc.a("SessionEndBegin", (String) null);
        if (this.u) {
            awVar = this.h;
            str2 = "user abort";
        } else if (speechError != null) {
            awVar = this.h;
            str2 = "error" + speechError.getErrorCode();
        } else {
            awVar = this.h;
            str2 = "success";
        }
        awVar.a(str2);
        cc.a("SessionEndEnd", (String) null);
        super.a(speechError);
        if (this.a != null) {
            if (this.u) {
                cb.a("RecognizerListener#onCancel");
            } else {
                cb.a("RecognizerListener#onEnd");
                if (speechError != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
                    this.a.onEvent(20001, 0, 0, bundle);
                    this.a.onError(speechError);
                }
            }
        }
        this.a = null;
    }

    public void a(byte[] bArr, int i2) {
        if (this.a != null && v()) {
            this.a.onVolumeChanged(i2, bArr);
            if (this.q) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("data", bArr);
                this.a.onEvent(21003, i2, 0, bundle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z2) throws SpeechError {
        if (!this.c) {
            this.c = true;
            this.o.a("app_fau");
            if (this.a != null) {
                this.a.onEvent(22002, 0, 0, (Bundle) null);
            }
        }
        this.h.a(bArr, bArr.length);
        if (z2) {
            int b2 = this.h.b();
            cb.b("QISRAudioWrite volume:" + b2);
            a(bArr, b2);
        }
    }

    public synchronized boolean a(boolean z2) {
        cb.a("stopRecognize, current status is :" + w() + " usercancel : " + z2);
        this.o.a("app_stop");
        n();
        this.e = z2;
        a(3);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a_() {
        this.o.a(x());
        super.a_();
    }

    public ConcurrentLinkedQueue<byte[]> b() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void b(Message message) throws Exception {
        byte[] bArr = (byte[]) message.obj;
        if (bArr != null && bArr.length != 0) {
            this.m.add(bArr);
            a(bArr, true);
        }
    }

    public void b(boolean z2) {
        if (z2 && v() && this.a != null) {
            this.a.onError(new SpeechError(20017));
        }
        n();
        if (w() == be.b.recording) {
            this.e = true;
        }
        super.b(z2);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.l = x().e(SpeechConstant.CLOUD_GRAMMAR);
        this.f = x().a(SpeechConstant.AUDIO_SOURCE, 1);
        this.g = cg.a(x().e(SpeechConstant.DOMAIN));
        this.p = (((x().a("sample_rate", this.s) / 1000) * 16) / 8) * x().a(SpeechConstant.FILTER_AUDIO_TIME, 0);
        this.r = x().a(SpeechConstant.KEY_SPEECH_TIMEOUT, this.r);
        this.q = x().a(SpeechConstant.NOTIFY_RECORD_DATA, false);
        cb.a("mSpeechTimeOut=" + this.r);
        super.c();
    }

    /* access modifiers changed from: package-private */
    public void c(Message message) throws SpeechError, InterruptedException, UnsupportedEncodingException {
        int i2 = message.arg1;
        byte[] bArr = (byte[]) message.obj;
        if (i2 == 0) {
            if (!this.d) {
                this.d = true;
                this.o.a("app_frs");
            }
            a(false, bArr);
        } else if (i2 != 2 && i2 == 5) {
            if (!this.d) {
                this.d = true;
                this.o.a("app_frs");
            }
            this.o.a("app_lrs");
            a(true, bArr);
        }
    }

    public String e() {
        return this.h.g();
    }

    /* access modifiers changed from: package-private */
    public void errCb(char[] cArr, int i2, byte[] bArr) {
        onError(new SpeechError(i2));
    }

    public String f() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = this.h.c();
        }
        return this.z;
    }

    public String g() {
        String str = null;
        try {
            ce x = x();
            str = (!TextUtils.isEmpty(this.l) || !TextUtils.isEmpty(x != null ? x.e(SpeechConstant.LOCAL_GRAMMAR) : null)) ? "asr" : "iat";
            if (x != null && (x.a("sch", false) || x.a(SpeechConstant.ASR_SCH, false))) {
                return "iat_sch";
            }
        } catch (Exception e2) {
            cb.c("DC get sub type exception:");
            cb.a((Throwable) e2);
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public void h() throws Exception {
        cb.a("start connecting");
        String e2 = x().e("engine_type");
        if (x().a(SpeechConstant.NET_CHECK, true)) {
            if ("cloud".equals(e2)) {
                bz.a(this.t);
            } else if ("mixed".equals(e2) || "mixed".equals(e2)) {
                try {
                    bz.a(this.t);
                } catch (Exception unused) {
                    x().a("engine_type", "local");
                }
            }
        }
        int a2 = x().a("record_read_rate", 40);
        if (this.f != -1 && v()) {
            cb.a("start  record");
            if (this.f == -2) {
                this.i = new a(t(), a2, this.f, x().e(SpeechConstant.ASR_SOURCE_PATH));
            } else {
                this.A = x().a(SpeechConstant.BLUETOOTH, this.A);
                if (this.A) {
                    C();
                }
                this.i = new PcmRecorder(t(), a2, this.f);
                if (hasMessages(3)) {
                    throw new SpeechError(10118);
                }
            }
            this.o.a("rec_open");
            this.i.startRecording(this);
            if (-1 != this.r) {
                a(9, be.a.normal, false, this.r);
            }
        }
        if (this.a != null && this.f > -1) {
            this.a.onBeginOfSpeech();
        }
        this.o.a("app_ssb");
        a(1, be.a.max, false, 0);
    }

    /* access modifiers changed from: protected */
    public void i() throws Exception {
        cc.a("SDKSessionBegin", (String) null);
        int a2 = this.h.a(this.t, this.l, (be) this);
        if (a2 != 0 || this.h.a == null) {
            this.B++;
            if (this.B > 40) {
                throw new SpeechError(a2);
            } else if (v()) {
                Thread.sleep(15);
                a(1, be.a.max, false, 0);
            }
        } else if (v()) {
            MSC.QISRRegisterNotify(this.h.a, "rsltCb", "stusCb", "errCb", this);
            a(be.b.recording);
            if (x().a(SpeechConstant.ASR_NET_PERF, false)) {
                a(7, be.a.max, false, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j() throws SpeechError, IOException, InterruptedException {
        cb.a("recording stop");
        n();
        this.o.a("app_lau");
        this.h.a();
        p();
    }

    public void k() {
        if (v()) {
            int b2 = this.h.b("netperf");
            if (this.a != null) {
                this.a.onEvent(10001, b2, 0, (Bundle) null);
            }
            a(7, be.a.normal, false, 100);
        }
    }

    public void l() {
        if (be.b.recording == w()) {
            cb.a("Msc recognize vadEndCall");
            if (this.a != null) {
                this.a.onEndOfSpeech();
            }
            a(false);
        }
    }

    public boolean m() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public void n() {
        if (this.i != null) {
            this.i.stopRecord(x().a("record_force_stop", false));
            this.i = null;
            this.o.a("rec_close");
            if (this.a != null) {
                this.a.onEvent(22003, 0, 0, (Bundle) null);
            }
            if (this.A) {
                D();
            }
        }
    }

    public bg o() {
        return this.o;
    }

    public void onError(SpeechError speechError) {
        b(speechError);
    }

    public void onRecordBuffer(byte[] bArr, int i2, int i3) {
        if (bArr != null && i3 > 0 && bArr.length >= i3 && i3 > 0 && v()) {
            if (!this.b) {
                this.b = true;
                this.o.a("rec_start");
            }
            if (this.p <= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i2, bArr2, 0, i3);
                d(obtainMessage(2, bArr2));
            } else if (this.p >= i3) {
                this.p -= i3;
            } else {
                byte[] bArr3 = new byte[(i3 - this.p)];
                System.arraycopy(bArr, i2 + this.p, bArr3, 0, i3 - this.p);
                d(obtainMessage(2, bArr3));
                this.p = 0;
            }
        }
    }

    public void onRecordReleased() {
        if (this.i != null && (this.i instanceof a)) {
            a(true);
        }
    }

    public void onRecordStarted(boolean z2) {
        this.o.a("rec_ready");
    }

    /* access modifiers changed from: package-private */
    public void rsltCb(char[] cArr, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            cb.a("MscRecognizer", "rsltCb:" + i3 + "result:" + new String(bArr));
        } else {
            cb.b("MscRecognizer", "rsltCb:" + i3 + "result:null");
        }
        a(obtainMessage(4, i3, 0, bArr), hasMessages(4) ? be.a.normal : be.a.max, false, 0);
    }

    /* access modifiers changed from: package-private */
    public void stusCb(char[] cArr, int i2, int i3, int i4, byte[] bArr) {
        if (i2 == 0 && i3 == 3) {
            cb.a("MscRecognizer", "stusCb:" + i3 + ",type:" + i2);
            l();
        }
    }
}
