package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.IdentityListener;
import com.iflytek.cloud.IdentityResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.be;
import com.iflytek.msc.MSC;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bd extends be {
    public static int f = 0;
    public static int g = 0;
    private static final String k = "bd";
    protected volatile IdentityListener a;
    protected boolean b;
    protected boolean c;
    protected boolean d;
    protected bc e;
    protected String h;
    protected bg i;
    long j;
    private boolean l;
    private bs m;
    private HashMap<String, ce> n;
    private HashMap<String, StringBuffer> o;
    private HashMap<String, Boolean> p;
    private String q;
    private int z;

    public bd(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, handlerThread);
        this.l = true;
        this.a = null;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new bc();
        this.h = null;
        this.i = new bg();
        this.n = null;
        this.o = null;
        this.q = null;
        this.z = 0;
        this.j = 0;
        this.m = new bs();
        this.d = false;
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.p = new HashMap<>();
        a(ceVar);
    }

    private void a(boolean z2, byte[] bArr) throws SpeechError, UnsupportedEncodingException {
        this.v = SystemClock.elapsedRealtime();
        if (bArr == null || bArr.length <= 0) {
            throw new SpeechError(10118);
        }
        String replace = new String(bArr, "utf-8").replace("\"return\"", "\"ret\"");
        this.h = replace;
        if (this.a != null && v()) {
            Bundle bundle = new Bundle();
            bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
            this.a.onEvent(20001, 0, 0, bundle);
            IdentityResult identityResult = new IdentityResult(replace);
            cc.a("GetNotifyResult", (String) null);
            this.a.onResult(identityResult, z2);
        }
        cb.a("msc result time:" + System.currentTimeMillis());
        if (z2) {
            b((SpeechError) null);
        }
    }

    private void e(Message message) throws SpeechError, IOException, InterruptedException {
        cb.a("recording stop");
        this.i.a("app_lau");
        this.p.put((String) message.obj, true);
        this.e.b((String) message.obj);
        p();
    }

    public bs a() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
        super.a(message);
        int i2 = message.what;
        if (i2 == 7) {
            i();
        } else if (i2 != 9) {
            switch (i2) {
                case 0:
                    b();
                    return;
                case 1:
                    h();
                    return;
                case 2:
                    b(message);
                    return;
                case 3:
                    e(message);
                    return;
                case 4:
                    c(message);
                    return;
                default:
                    return;
            }
        } else {
            j();
        }
    }

    public synchronized void a(IdentityListener identityListener) {
        this.a = identityListener;
        cb.a("startWorking called");
        a_();
    }

    /* access modifiers changed from: protected */
    public void a(SpeechError speechError) {
        bg bgVar;
        String str;
        long j2;
        bc bcVar;
        String str2;
        cb.a("onSessionEnd");
        f = this.e.c("upflow");
        g = this.e.c("downflow");
        f();
        if (this.h == null && speechError == null && x().a(SpeechConstant.ASR_NOMATCH_ERROR, true)) {
            speechError = new SpeechError(10118);
        }
        if (speechError != null) {
            bgVar = this.i;
            str = "app_ret";
            j2 = (long) speechError.getErrorCode();
        } else {
            bgVar = this.i;
            str = "app_ret";
            j2 = 0;
        }
        bgVar.a(str, j2, false);
        this.i.a("rec_ustop", this.d ? "1" : "0", false);
        this.e.a("sessinfo", this.i.a());
        cc.a("SessionEndBegin", (String) null);
        if (this.u) {
            bcVar = this.e;
            str2 = "user abort";
        } else if (speechError != null) {
            bcVar = this.e;
            str2 = "error" + speechError.getErrorCode();
        } else {
            bcVar = this.e;
            str2 = "success";
        }
        bcVar.a(str2);
        cc.a("SessionEndEnd", (String) null);
        super.a(speechError);
        if (this.a != null) {
            if (!this.u && speechError != null) {
                this.a.onError(speechError);
            }
            this.a.onEvent(SpeechEvent.EVENT_SESSION_END, 0, 0, (Bundle) null);
        }
        this.a = null;
    }

    public void a(String str, String str2, byte[] bArr, int i2, int i3) {
        if (!this.n.containsKey(str)) {
            ce ceVar = new ce();
            ceVar.a(str2);
            ceVar.a("sst", x().e("sst"), false);
            ceVar.a("mver", "2.0", false);
            ceVar.a("ssub", str);
            this.l = ceVar.a("vad_enable", true);
            this.n.put(str, ceVar);
            this.o.put(str, new StringBuffer(ceVar.toString()));
        }
        if (v()) {
            if (!this.b) {
                this.b = true;
                this.i.a("rec_start");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ssub", str);
            byte[] bArr2 = null;
            if (bArr != null) {
                bArr2 = new byte[i3];
                System.arraycopy(bArr, i2, bArr2, 0, i3);
            }
            hashMap.put("data", bArr2);
            d(obtainMessage(2, hashMap));
        }
    }

    /* access modifiers changed from: protected */
    public void a(StringBuffer stringBuffer, byte[] bArr, boolean z2, boolean z3) throws SpeechError {
        this.e.a(stringBuffer, bArr, bArr == null ? 0 : bArr.length, z2);
        if (z3) {
            int a2 = this.e.a();
            cb.b("QISRAudioWrite volume:" + a2);
            a(bArr, a2);
        }
    }

    public void a(byte[] bArr, int i2) {
        if (this.a != null && v()) {
            this.a.onEvent(SpeechEvent.EVENT_VOLUME, i2, 0, (Bundle) null);
        }
    }

    public synchronized boolean a(String str, boolean z2) {
        cb.a("stopRecognize, current status is :" + w() + " usercancel : " + z2);
        this.i.a("app_stop");
        this.d = z2;
        d(obtainMessage(3, str));
        return true;
    }

    /* access modifiers changed from: protected */
    public void a_() {
        this.i.a(x());
        super.a_();
    }

    /* access modifiers changed from: protected */
    public void b() throws Exception {
        cb.a("start connecting");
        a(1, be.a.max, false, 0);
    }

    /* access modifiers changed from: protected */
    public void b(Message message) throws Exception {
        HashMap hashMap = (HashMap) message.obj;
        byte[] bArr = (byte[]) hashMap.get("data");
        String str = (String) hashMap.get("ssub");
        StringBuffer stringBuffer = this.o.get(str);
        String e2 = this.n.get(str).e(SpeechConstant.MFV_DATA_PATH);
        if (!TextUtils.isEmpty(e2) && bArr != null) {
            this.m.a(e2, bArr);
        }
        Boolean bool = this.p.get(str);
        if (bool == null) {
            bool = true;
        }
        if (!SpeechConstant.ENG_IVP.equals(str) || !this.l) {
            a(stringBuffer, bArr, bool.booleanValue(), false);
        } else {
            a(stringBuffer, bArr, bool.booleanValue(), true);
        }
        if (bool.booleanValue()) {
            this.p.put(str, false);
        }
    }

    public void b(boolean z2) {
        if (z2 && v() && this.a != null) {
            cb.a("cancel");
            this.a.onError(new SpeechError(20017));
        }
        if (w() == be.b.recording) {
            this.d = true;
        }
        super.b(z2);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.r = x().a(SpeechConstant.KEY_SPEECH_TIMEOUT, this.r);
        cb.a("mSpeechTimeOut=" + this.r);
        super.c();
    }

    /* access modifiers changed from: package-private */
    public void c(Message message) throws SpeechError, InterruptedException, UnsupportedEncodingException {
        int i2 = message.arg1;
        byte[] bArr = (byte[]) message.obj;
        if (i2 == 0) {
            if (!this.c) {
                this.c = true;
                this.i.a("app_frs");
            }
            a(false, bArr);
        } else if (i2 != 2 && i2 == 5) {
            if (!this.c) {
                this.c = true;
                this.i.a("app_frs");
            }
            this.i.a("app_lrs");
            a(true, bArr);
        }
    }

    public String e() {
        return this.e.g();
    }

    /* access modifiers changed from: package-private */
    public void errCb(char[] cArr, int i2, byte[] bArr) {
        String str = k;
        cb.a(str, "clientSessionID:" + new String(cArr) + "errorcode:" + i2);
        Bundle bundle = new Bundle();
        bundle.putString(SpeechEvent.KEY_EVENT_SESSION_ID, f());
        this.a.onEvent(20001, 0, 0, bundle);
        b(new SpeechError(i2));
    }

    public String f() {
        if (TextUtils.isEmpty(this.q)) {
            this.q = this.e.b();
        }
        return this.q;
    }

    public String g() {
        return "mfv";
    }

    /* access modifiers changed from: protected */
    public void h() throws Exception {
        if (x().a(SpeechConstant.NET_CHECK, true)) {
            bz.a(this.t);
        }
        cc.a("SDKSessionBegin", (String) null);
        this.i.a("app_ssb");
        int a2 = this.e.a(this.t, (String) null, (be) this);
        if (a2 != 0 || this.e.a == null) {
            this.z++;
            if (this.z > 40) {
                throw new SpeechError(a2);
            } else if (v()) {
                Thread.sleep(15);
                a(1, be.a.max, false, 0);
            }
        } else if (v()) {
            MSC.QMFVRegisterNotify(this.e.a, "rsltCb", "stusCb", "errCb", this);
            a(be.b.recording);
            if (x().a(SpeechConstant.ASR_NET_PERF, false)) {
                a(7, be.a.max, false, 0);
            }
        }
    }

    public void i() {
        if (v()) {
            int c2 = this.e.c("netperf");
            if (this.a != null) {
                this.a.onEvent(10001, c2, 0, (Bundle) null);
            }
            a(7, be.a.normal, false, 100);
        }
    }

    public void j() {
        if (be.b.recording == w()) {
            cb.a("mfv msc vadEndCall");
            if (this.a != null) {
                this.a.onEvent(SpeechEvent.EVENT_VAD_EOS, 0, 0, (Bundle) null);
            }
            a(SpeechConstant.ENG_IVP, false);
        }
    }

    public bg k() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void rsltCb(char[] cArr, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            String str = k;
            cb.a(str, "rsltCb:" + i3 + "result:" + new String(bArr));
        } else {
            String str2 = k;
            cb.b(str2, "rsltCb:" + i3 + "result:null");
        }
        a(obtainMessage(4, i3, 0, bArr), hasMessages(4) ? be.a.normal : be.a.max, false, 0);
    }

    /* access modifiers changed from: package-private */
    public void stusCb(char[] cArr, int i2, int i3, byte[] bArr, int i4) {
        String str = k;
        cb.a(str, "stusCb:" + i3 + ",type:" + i2);
        if (i2 == 0 && 3 == i3) {
            j();
        }
        if (1 == i2) {
            String[] split = x().b(SpeechConstant.MFV_SCENES, "").split("\\|");
            if (split == null || split.length >= 2) {
                try {
                    String str2 = new String(bArr, "utf-8");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sub", str2);
                    jSONObject.put("sret", i3);
                    jSONObject.put(SpeechUtility.TAG_RESOURCE_RET, i3);
                    jSONObject.put("sst", this.n.get(str2).e("sst"));
                    if (this.a != null) {
                        this.a.onResult(new IdentityResult(jSONObject.toString()), true);
                    }
                } catch (UnsupportedEncodingException | JSONException e2) {
                    cb.a(e2);
                }
            }
        }
    }
}
