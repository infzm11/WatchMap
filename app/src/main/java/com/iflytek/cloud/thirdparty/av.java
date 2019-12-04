package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.EvaluatorListener;
import com.iflytek.cloud.EvaluatorResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.record.PcmRecorder;
import com.iflytek.cloud.record.a;
import com.iflytek.cloud.thirdparty.be;
import com.iflytek.cloud.thirdparty.bf;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class av extends be implements PcmRecorder.PcmRecordListener {
    public static int a;
    public static int b;
    private static Boolean l = false;
    private String A;
    private boolean B;
    long c;
    protected int d;
    protected au e;
    protected PcmRecorder f;
    protected bg g;
    protected String h;
    protected byte[] i;
    protected String j;
    protected String k;
    private volatile EvaluatorListener m;
    private ConcurrentLinkedQueue<byte[]> n;
    private ConcurrentLinkedQueue<byte[]> o;
    private ArrayList<String> p;
    private boolean q;
    private bf.a z;

    public av(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, handlerThread);
        this.m = null;
        this.c = 0;
        this.d = 1;
        this.e = new au();
        this.f = null;
        this.g = new bg();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.z = bf.a.noResult;
        this.A = null;
        this.B = false;
        this.o = new ConcurrentLinkedQueue<>();
        this.n = new ConcurrentLinkedQueue<>();
        this.p = new ArrayList<>();
        this.q = false;
        a(ceVar);
    }

    private void a(byte[] bArr, int i2) {
        if (this.m != null && v()) {
            this.m.onVolumeChanged(i2, bArr);
        }
    }

    private void a(byte[] bArr, boolean z2) throws SpeechError {
        this.e.a(bArr, bArr.length);
        if (!z2) {
            return;
        }
        if (this.e.b() == 3) {
            j();
        } else {
            a(bArr, this.e.c());
        }
    }

    private void d(boolean z2) throws SpeechError, UnsupportedEncodingException {
        this.v = SystemClock.elapsedRealtime();
        if (this.e.d() != null && this.e.d().length > 0) {
            String str = new String(this.e.d(), "utf-8");
            this.p.add(str);
            try {
                this.x.a(str, z2);
            } catch (Throwable th) {
                cb.c("DC exception:");
                cb.a(th);
            }
        }
        c(z2);
    }

    private void h() throws SpeechError, IOException, InterruptedException {
        cb.a("--->onStoped: in");
        if (!v()) {
            k();
        }
        this.e.a();
        p();
        cb.a("--->onStoped: out");
    }

    private void i() throws SpeechError, UnsupportedEncodingException {
        boolean z2;
        bf.a e2 = this.e.e();
        this.z = e2;
        switch (e2) {
            case noResult:
                return;
            case hasResult:
                z2 = false;
                break;
            case resultOver:
                z2 = true;
                break;
            default:
                return;
        }
        d(z2);
    }

    private void j() {
        if (be.b.recording == w()) {
            cb.a("Ise Msc vadEndCall");
            a(false);
            if (this.m != null) {
                this.m.onEndOfSpeech();
            }
        }
    }

    private void k() {
        if (this.f != null) {
            this.f.stopRecord(x().a("record_force_stop", false));
            this.f = null;
            if (this.B) {
                D();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() throws Exception {
        cb.a("--->onStart: in");
        if (x().a(SpeechConstant.NET_CHECK, true)) {
            bz.a(this.t);
        }
        int a2 = x().a("record_read_rate", 40);
        this.d = x().a(SpeechConstant.AUDIO_SOURCE, 1);
        if (this.d != -1 && v()) {
            cb.a("start  record");
            if (this.d == -2) {
                this.f = new a(t(), a2, this.d, x().e(SpeechConstant.ISE_SOURCE_PATH));
            } else {
                this.B = x().a(SpeechConstant.BLUETOOTH, this.B);
                if (this.B) {
                    C();
                }
                this.f = new PcmRecorder(t(), a2, this.d);
            }
            this.f.startRecording(this);
        }
        if (!(w() == be.b.exiting || this.m == null)) {
            this.m.onBeginOfSpeech();
        }
        removeMessages(9);
        if (-1 != this.r) {
            a(9, be.a.normal, false, this.r);
        }
        a(1, be.a.max, false, 0);
        cb.a("--->onStart: out");
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
        super.a(message);
        int i2 = message.what;
        if (i2 == 7) {
            return;
        }
        if (i2 != 9) {
            switch (i2) {
                case 0:
                    a();
                    return;
                case 1:
                    b();
                    return;
                case 2:
                    b(message);
                    return;
                case 3:
                    h();
                    return;
                case 4:
                    c(message);
                    return;
                default:
                    return;
            }
        } else {
            cb.a("--->on timeout vad");
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void a(SpeechError speechError) {
        au auVar;
        String str;
        cb.a("--->onEnd: in");
        k();
        f();
        cc.a("SessionEndBegin", (String) null);
        if (this.u) {
            auVar = this.e;
            str = "user abort";
        } else if (speechError != null) {
            auVar = this.e;
            str = "error" + speechError.getErrorCode();
        } else {
            auVar = this.e;
            str = "success";
        }
        auVar.a(str);
        cc.a("SessionEndEnd", (String) null);
        super.a(speechError);
        if (this.m != null && !this.u) {
            cb.a("VerifyListener#onEnd");
            if (speechError != null) {
                Bundle bundle = new Bundle();
                bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
                this.m.onEvent(20001, 0, 0, bundle);
                this.m.onError(speechError);
            }
        }
        this.m = null;
        cb.a("--->onEnd: out");
    }

    public synchronized void a(String str, String str2, EvaluatorListener evaluatorListener) {
        l = false;
        this.j = str;
        this.h = str2;
        this.k = x().e(SpeechConstant.ISE_USER_MODEL_ID);
        this.m = evaluatorListener;
        cb.a("startListening called");
        a_();
    }

    public synchronized void a(byte[] bArr, String str, EvaluatorListener evaluatorListener) {
        l = true;
        this.i = bArr;
        this.h = str;
        this.k = x().e(SpeechConstant.ISE_USER_MODEL_ID);
        this.m = evaluatorListener;
        cb.a("startListening called");
        a_();
    }

    public synchronized boolean a(boolean z2) {
        if (w() != be.b.recording) {
            cb.a("stopRecognize fail  status is :" + w());
            return false;
        }
        if (this.f != null) {
            this.f.stopRecord(x().a("record_force_stop", false));
        }
        this.q = z2;
        a(3);
        return true;
    }

    /* access modifiers changed from: protected */
    public void b() throws Exception {
        byte[] bArr = null;
        if (this.e.a == null) {
            cc.a("SDKSessionBegin", (String) null);
            this.e.a(this.t, this.k, (be) this);
        }
        byte[] a2 = l.booleanValue() ? "1".equals(x().e(SpeechConstant.TEXT_BOM)) ? bt.a(this.i) : this.i : "1".equals(x().e(SpeechConstant.TEXT_BOM)) ? bt.a(this.j) : this.j.getBytes("gb2312");
        au auVar = this.e;
        if (!TextUtils.isEmpty(this.h)) {
            bArr = this.h.getBytes("gb2312");
        }
        auVar.a(a2, bArr);
        a(be.b.recording);
        a(4, be.a.normal, false, 20);
    }

    /* access modifiers changed from: protected */
    public void b(Message message) throws Exception {
        cb.a("proc_Msg_Record_Data");
        byte[] bArr = (byte[]) message.obj;
        if (bArr != null && bArr.length != 0) {
            if (!TextUtils.isEmpty(x().e(SpeechConstant.ISE_AUDIO_PATH))) {
                this.n.add(bArr);
            }
            a(bArr, true);
        }
    }

    public void b(boolean z2) {
        if (z2 && v() && this.m != null) {
            this.m.onError(new SpeechError(20017));
        }
        k();
        super.b(z2);
    }

    /* access modifiers changed from: protected */
    public void c() {
        String str;
        String str2;
        ce ceVar;
        this.r = x().a(SpeechConstant.KEY_SPEECH_TIMEOUT, -1);
        cb.a("mSpeechTimeOut=" + this.r);
        if (!"utf-8".equals(x().e(SpeechConstant.TEXT_ENCODING)) || !Locale.CHINA.toString().equalsIgnoreCase(x().e("language"))) {
            ceVar = x();
            str2 = SpeechConstant.TEXT_BOM;
            str = "0";
        } else {
            ceVar = x();
            str2 = SpeechConstant.TEXT_BOM;
            str = "1";
        }
        ceVar.a(str2, str, false);
        super.c();
    }

    /* access modifiers changed from: package-private */
    public void c(Message message) throws SpeechError, InterruptedException, UnsupportedEncodingException {
        i();
        if (bf.a.noResult == this.z) {
            a(4, be.a.normal, false, 20);
        } else if (bf.a.hasResult == this.z) {
            a(4);
        }
    }

    public void c(boolean z2) throws SpeechError, UnsupportedEncodingException {
        cb.a("msc result time:" + System.currentTimeMillis());
        EvaluatorResult evaluatorResult = new EvaluatorResult(new String(this.e.d(), x().b("rse", "gb2312")));
        if (this.m != null) {
            Bundle bundle = new Bundle();
            bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
            this.m.onEvent(20001, 0, 0, bundle);
            cc.a("GetNotifyResult", (String) null);
            this.m.onResult(evaluatorResult, z2);
        }
        if (z2) {
            b((SpeechError) null);
        }
    }

    public ConcurrentLinkedQueue<byte[]> d() {
        while (true) {
            byte[] poll = this.o.poll();
            if (poll == null) {
                return this.n;
            }
            this.n.add(poll);
        }
    }

    public String e() {
        return this.e.g();
    }

    public String f() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = this.e.f();
        }
        return this.A;
    }

    public String g() {
        return "ise";
    }

    public void onError(SpeechError speechError) {
        b(speechError);
    }

    public void onRecordBuffer(byte[] bArr, int i2, int i3) {
        if (be.b.recording != w()) {
            cb.c("onRecordBuffer statuts not recording");
        } else if (i3 > 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            d(obtainMessage(2, bArr2));
        }
    }

    public void onRecordReleased() {
        if (this.f != null && (this.f instanceof a)) {
            a(true);
        }
    }

    public void onRecordStarted(boolean z2) {
    }
}
