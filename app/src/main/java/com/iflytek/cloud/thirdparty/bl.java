package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.thirdparty.be;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bl extends be {
    public static int a;
    public static int b;
    private String c;
    private bo d;
    private bm e;
    private ArrayList<byte[]> f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private final JSONObject l;
    private JSONArray m;
    private int n;
    private int o;
    private String p;
    private int q;

    public bl(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, handlerThread);
        this.c = "";
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = 0;
        this.l = new JSONObject();
        this.m = null;
        this.n = -1;
        this.o = 100;
        this.p = null;
        this.q = 0;
        this.d = new bo();
        this.f = new ArrayList<>();
        a(ceVar);
    }

    private void i() throws SpeechError, JSONException {
        int min = Math.min(this.o - 1, (this.g * this.o) / this.c.length());
        if (this.j) {
            this.l.put("audio_len", this.k);
        }
        if (this.m != null) {
            this.l.put("spell_info", this.m);
            this.m = null;
        }
        this.e.a(this.f, min, this.h, this.g, this.l.length() > 0 ? this.l.toString() : null);
        this.f = new ArrayList<>();
        this.h = Math.min(this.g + 1, this.c.length() - 1);
    }

    /* access modifiers changed from: protected */
    public void a() throws Exception {
        cb.a("tts msg start:" + System.currentTimeMillis());
        String e2 = x().e("engine_type");
        boolean a2 = x().a(SpeechConstant.NET_CHECK, true);
        if (("cloud".equals(e2) || SpeechConstant.TYPE_DISTRIBUTED.equals(e2)) && a2) {
            bz.a(this.t);
        }
        a(1);
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
        int i2 = message.what;
        if (i2 != 5) {
            switch (i2) {
                case 0:
                    a();
                    return;
                case 1:
                    b();
                    return;
                default:
                    return;
            }
        } else {
            h();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.iflytek.cloud.SpeechError r5) {
        /*
            r4 = this;
            com.iflytek.cloud.thirdparty.bo r0 = r4.d
            java.lang.String r1 = "upflow"
            int r0 = r0.b(r1)
            a = r0
            com.iflytek.cloud.thirdparty.bo r0 = r4.d
            java.lang.String r1 = "downflow"
            int r0 = r0.b(r1)
            b = r0
            r4.f()
            java.lang.String r0 = "SessionEndBegin"
            r1 = 0
            com.iflytek.cloud.thirdparty.cc.a(r0, r1)
            com.iflytek.cloud.thirdparty.bm r0 = r4.e
            if (r0 != 0) goto L_0x0029
            com.iflytek.cloud.thirdparty.bo r0 = r4.d
            java.lang.String r2 = "user abort"
        L_0x0025:
            r0.a((java.lang.String) r2)
            goto L_0x0063
        L_0x0029:
            if (r5 == 0) goto L_0x005e
            com.iflytek.cloud.thirdparty.bo r0 = r4.d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error"
            r2.append(r3)
            int r3 = r5.getErrorCode()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.a((java.lang.String) r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "QTts Error Code = "
            r0.append(r2)
            int r2 = r5.getErrorCode()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r0)
            goto L_0x0063
        L_0x005e:
            com.iflytek.cloud.thirdparty.bo r0 = r4.d
            java.lang.String r2 = "success"
            goto L_0x0025
        L_0x0063:
            java.lang.String r0 = "SessionEndEnd"
            com.iflytek.cloud.thirdparty.cc.a(r0, r1)
            super.a((com.iflytek.cloud.SpeechError) r5)
            com.iflytek.cloud.thirdparty.bm r0 = r4.e
            if (r0 == 0) goto L_0x0083
            boolean r0 = r4.u
            if (r0 == 0) goto L_0x0079
            java.lang.String r5 = "MscSynthesizer#onCancel"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r5)
            return
        L_0x0079:
            java.lang.String r0 = "MscSynthesizer#onEnd"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r0)
            com.iflytek.cloud.thirdparty.bm r0 = r4.e
            r0.a(r5)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bl.a(com.iflytek.cloud.SpeechError):void");
    }

    public void a(String str, bm bmVar) {
        this.c = str;
        this.e = bmVar;
        if (str == null || TextUtils.isEmpty(str)) {
            b(new SpeechError(20009));
            return;
        }
        this.i = x().a(SpeechConstant.TTS_SPELL_INFO, false);
        this.j = x().a("audio_info", this.j);
        a_();
    }

    /* access modifiers changed from: protected */
    public void b() throws Exception {
        cc.a("SDKSessionBegin", (String) null);
        int a2 = this.d.a(this.t, (String) null, this);
        if (a2 == 0) {
            byte[] bytes = this.c.getBytes(r());
            if ("unicode".equals(r())) {
                byte[] bArr = new byte[(bytes.length - 2)];
                System.arraycopy(bytes, 2, bArr, 0, bytes.length - 2);
                this.d.a(bArr);
            } else {
                this.d.a(bytes);
            }
            a(be.b.waitresult);
            a(5);
            p();
            return;
        }
        this.q++;
        if (this.q > 40) {
            throw new SpeechError(a2);
        } else if (v()) {
            a(1, be.a.normal, false, 15);
        }
    }

    public void b(boolean z) {
        if (z && v() && this.e != null) {
            this.e.a(new SpeechError(20017));
        }
        super.b(z);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.n = x().a(SpeechConstant.TTS_BUFFER_TIME, this.n);
        this.o = x().a("tts_proc_scale", this.o);
        super.c();
    }

    public String e() {
        return this.d.g();
    }

    public String f() {
        if (TextUtils.isEmpty(this.p)) {
            this.p = this.d.e();
        }
        return this.p;
    }

    public String g() {
        return "tts";
    }

    /* access modifiers changed from: protected */
    public void h() throws Exception {
        cc.a("GetNotifyResult", (String) null);
        if (!this.d.d()) {
            byte[] a2 = this.d.a();
            f();
            if (a2 == null || this.e == null) {
                a(5, be.a.normal, false, 10);
                return;
            }
            this.k += a2.length;
            int b2 = (this.d.b() / 2) - 1;
            if (b2 < 0) {
                cb.a("get audio index value error: " + b2);
                b2 = 0;
            }
            if (this.i) {
                String c2 = this.d.c();
                if (!TextUtils.isEmpty(c2)) {
                    if (this.m == null) {
                        this.m = new JSONArray();
                    }
                    this.m.put(c2);
                }
            }
            if (this.n < 0 && this.g != 0 && b2 != this.g && this.f.size() > 0) {
                cb.b("tts msc get audio beg=" + this.h + ", end=" + this.g);
                i();
            }
            p();
            this.g = b2;
            this.f.add(a2);
            if (this.n >= 0) {
                i();
            }
            a(5, be.a.normal, false, 0);
            return;
        }
        cb.a("tts msc get last audio");
        if (this.e != null) {
            if (this.j) {
                this.l.put("audio_len", this.k);
            }
            if (this.m != null) {
                this.l.put("spell_info", this.m);
                this.m = null;
            }
            this.e.a(this.f, this.o, this.h, this.c.length() - 1, this.l.length() > 0 ? this.l.toString() : null);
        }
        b((SpeechError) null);
    }

    public String r() {
        return x().b(SpeechConstant.TEXT_ENCODING, "unicode");
    }
}
