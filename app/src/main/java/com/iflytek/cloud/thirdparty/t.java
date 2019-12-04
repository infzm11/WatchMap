package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUIMessage;
import com.iflytek.aiui.Version;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class t extends r {
    private String d = "sdk";
    /* access modifiers changed from: private */
    public String e = AIUIConstant.AUDIO_CAPTOR_ALSA;
    private String f = "cae";
    private String g = "cloud";
    /* access modifiers changed from: private */
    public boolean h = false;
    private String i;
    /* access modifiers changed from: private */
    public w j;
    /* access modifiers changed from: private */
    public ab k;
    /* access modifiers changed from: private */
    public x l;
    /* access modifiers changed from: private */
    public v m;
    /* access modifiers changed from: private */
    public j n;
    private k o = new k() {
        public void a() {
            af a2 = t.this.a();
            if (a2 != null) {
                AIUIEvent aIUIEvent = new AIUIEvent(11, 0, 0, "", (Bundle) null);
                Message.obtain(a2, 10, aIUIEvent).sendToTarget();
            }
            if (AIUIConstant.AUDIO_CAPTOR_SYSTEM.equals(t.this.e) && t.this.k != null) {
                t.this.k.g();
            }
        }

        public void a(int i, String str) {
            t.this.a(i, str);
        }

        public void a(byte[] bArr, int i, Bundle bundle) {
            t.this.a("sdk", bArr, "data_type=audio", 0, 0, 0, t.this.n.a());
        }

        public void b() {
            af a2 = t.this.a();
            if (a2 != null) {
                AIUIEvent aIUIEvent = new AIUIEvent(12, 0, 0, "", (Bundle) null);
                Message.obtain(a2, 10, aIUIEvent).sendToTarget();
            }
            t.this.a(new byte[0], "data_type=audio", 4, 0, 0, t.this.n.a());
        }
    };
    private a p;
    private HandlerThread q = new HandlerThread("AIUI:SpeechModuleThread");

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    t.this.n();
                    t.this.p();
                    t.this.q();
                    return;
                case 2:
                    t.this.r();
                    t.this.s();
                    return;
                case 3:
                    if (t.this.j != null) {
                        t.this.j.a(message.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (t.this.j != null) {
                        t.this.j.h();
                        return;
                    }
                    return;
                case 5:
                    if (t.this.j != null) {
                        t.this.j.i();
                        return;
                    }
                    return;
                case 6:
                    if (t.this.m != null) {
                        t.this.m.a((String) message.obj);
                        return;
                    }
                    return;
                case 7:
                    if (t.this.l != null) {
                        t.this.l.a((String) message.obj);
                        return;
                    }
                    return;
                case 8:
                    if (t.this.m != null) {
                        t.this.m.b((String) message.obj);
                        return;
                    }
                    return;
                case 9:
                    if (t.this.j != null) {
                        t.this.j.b(message.arg1);
                        return;
                    }
                    return;
                case 10:
                    if (t.this.j != null) {
                        t.this.j.j();
                        return;
                    }
                    return;
                case 11:
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) message.obj, "utf-8"));
                        t.this.a(1, jSONObject.getString("dev_id").getBytes("utf-8"), jSONObject.getString("ver").getBytes("utf-8"));
                        return;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 12:
                    t.this.a(0, (byte[]) message.obj, (byte[]) null);
                    return;
                case 13:
                    if (t.this.h) {
                        t.this.c();
                        t.this.m();
                        return;
                    }
                    return;
                case 14:
                    if (t.this.k != null) {
                        t.this.k.d();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public t(Context context, af afVar) {
        super(context, afVar);
        this.q.start();
        this.p = new a(this.q.getLooper());
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.c != null) {
            this.c.a(i2, str);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, byte[] bArr, byte[] bArr2) {
        if (this.j != null) {
            this.j.a(i2, bArr, bArr2);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (AIUIConstant.USER.equals(this.d)) {
            this.n.c();
        }
        if (this.k != null && this.k.a()) {
            this.k.d();
        }
        if ("cae".equals(this.f)) {
            if (this.j == null) {
                if (this.k != null) {
                    this.k.d();
                }
                this.j = new w(this);
                this.j.a(this.k);
                int b = this.j.b();
                if (b != 0) {
                    a(b, "start CaeUnit error.");
                }
            } else if (this.j.a()) {
                this.j.d();
            }
        } else if (!"ivw".equals(this.f) && "off".equals(this.f) && this.j != null) {
            this.j.f();
            if (this.k != null) {
                this.k.d();
            }
        }
        if ("cloud".equals(this.g)) {
            s();
        } else if (this.m == null) {
            this.m = new v(this);
            if (this.k != null) {
                this.k.a(this.m);
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (this.k != null) {
            this.k.b();
        }
    }

    private void o() {
        if (this.k != null) {
            this.k.c();
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        if (this.l != null) {
            this.l.b();
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        if (this.m != null) {
            this.m.b();
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        if (this.l != null) {
            this.l.c();
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        if (this.m != null) {
            this.m.c();
        }
    }

    public void a(int i2) {
        Message.obtain(this.p, 3, i2, 0).sendToTarget();
    }

    public synchronized void a(Message message) {
        this.p.sendMessage(message);
    }

    public void a(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 6, aIUIMessage.params).sendToTarget();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(String str, byte[] bArr, String str2, int i2, int i3, int i4, int i5) {
        if (this.d.equals(str)) {
            a(bArr, str2, i2, i3, i4, i5);
        }
    }

    public void a(byte[] bArr, String str, int i2, int i3, int i4, int i5) {
        if (96000 == i5) {
            if (this.j != null) {
                this.j.a(bArr, str, i2, i3, i4);
            }
        } else if (this.k != null) {
            this.k.a(bArr, str, i2, i3, i4);
        }
    }

    public void b(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 7, aIUIMessage.params).sendToTarget();
    }

    public void c() {
        this.b = ac.d("iat");
        this.e = ac.a("speech", AIUIConstant.KEY_AUDIO_CAPTOR, AIUIConstant.AUDIO_CAPTOR_ALSA);
        this.d = ac.a("speech", AIUIConstant.KEY_DATA_SOURCE, "sdk");
        this.f = ac.a("speech", AIUIConstant.KEY_WAKEUP_MODE, "cae");
        this.g = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
        if (Version.isMobileVersion()) {
            this.e = AIUIConstant.AUDIO_CAPTOR_SYSTEM;
            this.f = "off";
        }
    }

    public void c(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 8, aIUIMessage.params).sendToTarget();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d() throws com.iflytek.cloud.thirdparty.n {
        /*
            r3 = this;
            r3.c()
            java.lang.String r0 = "alsa"
            java.lang.String r1 = r3.e
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0017
            com.iflytek.cloud.thirdparty.l r0 = new com.iflytek.cloud.thirdparty.l
            com.iflytek.cloud.thirdparty.k r1 = r3.o
            r0.<init>(r1)
        L_0x0014:
            r3.n = r0
            goto L_0x0029
        L_0x0017:
            java.lang.String r0 = "system"
            java.lang.String r1 = r3.e
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            com.iflytek.cloud.thirdparty.m r0 = new com.iflytek.cloud.thirdparty.m
            com.iflytek.cloud.thirdparty.k r1 = r3.o
            r0.<init>(r1)
            goto L_0x0014
        L_0x0029:
            java.lang.String r0 = "sdk"
            java.lang.String r1 = r3.d
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0050
            java.lang.String r0 = "alsa"
            java.lang.String r2 = r3.e
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0045
            com.iflytek.cloud.thirdparty.j r0 = r3.n
            int r0 = r0.b()
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            if (r0 == 0) goto L_0x0050
            com.iflytek.cloud.thirdparty.n r1 = new com.iflytek.cloud.thirdparty.n
            java.lang.String r2 = "AlsaCaptor start error."
            r1.<init>(r0, r2)
            throw r1
        L_0x0050:
            com.iflytek.cloud.thirdparty.ab r0 = r3.k
            if (r0 != 0) goto L_0x0081
            com.iflytek.cloud.thirdparty.ab r0 = new com.iflytek.cloud.thirdparty.ab
            r0.<init>(r3)
            r3.k = r0
            com.iflytek.cloud.thirdparty.x r0 = new com.iflytek.cloud.thirdparty.x
            r0.<init>(r3)
            r3.l = r0
            java.lang.String r0 = "cloud"
            java.lang.String r2 = r3.g
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0073
            com.iflytek.cloud.thirdparty.v r0 = new com.iflytek.cloud.thirdparty.v
            r0.<init>(r3)
            r3.m = r0
        L_0x0073:
            com.iflytek.cloud.thirdparty.ab r0 = r3.k
            com.iflytek.cloud.thirdparty.x r2 = r3.l
            r0.a((com.iflytek.cloud.thirdparty.x) r2)
            com.iflytek.cloud.thirdparty.ab r0 = r3.k
            com.iflytek.cloud.thirdparty.v r2 = r3.m
            r0.a((com.iflytek.cloud.thirdparty.v) r2)
        L_0x0081:
            java.lang.String r0 = "cae"
            java.lang.String r2 = r3.f
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00a9
            com.iflytek.cloud.thirdparty.w r0 = new com.iflytek.cloud.thirdparty.w
            r0.<init>(r3)
            r3.j = r0
            com.iflytek.cloud.thirdparty.w r0 = r3.j
            com.iflytek.cloud.thirdparty.ab r2 = r3.k
            r0.a((com.iflytek.cloud.thirdparty.ab) r2)
            com.iflytek.cloud.thirdparty.w r0 = r3.j
            int r0 = r0.b()
            if (r0 == 0) goto L_0x00bb
            com.iflytek.cloud.thirdparty.n r1 = new com.iflytek.cloud.thirdparty.n
            java.lang.String r2 = "CaeUnit start error."
            r1.<init>(r0, r2)
            throw r1
        L_0x00a9:
            java.lang.String r0 = "ivw"
            java.lang.String r2 = r3.f
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00b4
            goto L_0x00bb
        L_0x00b4:
            java.lang.String r0 = "off"
            java.lang.String r2 = r3.f
            r0.equals(r2)
        L_0x00bb:
            r0 = 1
            r3.h = r0
            java.lang.String r0 = "SpeechModule"
            java.lang.String r2 = "SpeechModule started."
            com.iflytek.cloud.thirdparty.cb.a(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.t.d():int");
    }

    public void d(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 9, aIUIMessage.arg1, 0).sendToTarget();
    }

    public void e() {
        al.b();
        this.i = "";
        if (AIUIConstant.AUDIO_CAPTOR_SYSTEM.equals(this.e) && this.n != null) {
            this.n.c();
        }
        if (this.j != null) {
            this.j.f();
        }
        o();
        r();
        s();
    }

    public void e(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 11, aIUIMessage.data).sendToTarget();
    }

    public void f() {
        if (this.n != null) {
            this.n.c();
        }
        if (this.j != null) {
            this.j.c();
        }
        if (this.k != null) {
            this.k.c();
        }
        if (this.l != null) {
            this.l.c();
        }
        this.h = false;
        cb.a("SpeechModule", "SpeechModule stopped.");
    }

    public void f(AIUIMessage aIUIMessage) {
        Message.obtain(this.p, 12, aIUIMessage.data).sendToTarget();
    }

    public void g() {
        if (this.h) {
            f();
        }
        if (this.k != null) {
            this.k.f();
        }
        if (this.l != null) {
            this.l.f();
        }
        if (this.m != null) {
            this.m.f();
        }
        if (this.q != null) {
            this.q.quit();
        }
    }

    public String h() {
        return this.i;
    }

    public int i() {
        int g2 = this.j != null ? this.j.g() : -1;
        cb.a("SpeechModule", "mic_type=" + g2);
        return g2;
    }

    public void j() {
        if (this.n != null) {
            int b = this.n.b();
            if (b != 0) {
                a(b, "start audio captor error.");
            }
        }
    }

    public void k() {
        if (this.n != null) {
            this.n.c();
        }
    }

    public void l() {
        Message.obtain(this.p, 10).sendToTarget();
    }
}
