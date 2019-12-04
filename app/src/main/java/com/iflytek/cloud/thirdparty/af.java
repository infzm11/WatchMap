package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIErrorCode;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUIListener;
import com.iflytek.aiui.AIUIMessage;
import com.iflytek.aiui.Version;

public class af extends Handler {
    private String a = "";
    private int b = 1;
    private Context c;
    private AIUIListener d;
    private ah e;
    private t f;
    private s g;
    private o h;
    private ai i;
    private q j;
    private ag k;
    private String l = "";
    private int m = -1;
    private int n = 5000;
    private String o = "cloud";
    private String p = AIUIConstant.INTERACT_MODE_CONTINUOUS;
    private String q = "auto";

    public af(Context context, Looper looper, String str, AIUIListener aIUIListener) {
        super(looper);
        this.c = context.getApplicationContext();
        this.a = str;
        this.d = aIUIListener;
        this.e = new ah(this);
        this.h = new o(this.e);
        this.i = new ai(this.e);
        this.j = new q(this);
        this.k = new ag(this);
        this.f = new t(this.c, this);
        this.g = new s(this.c, this);
        ao.a(this.e);
    }

    private void a(Message message) {
        if (this.f != null) {
            this.f.a(message);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.os.Message r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r1 = "AIUIScheduler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "wakeup, isoutter="
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)
            if (r12 != 0) goto L_0x0020
            java.lang.Object r0 = r11.obj
            java.lang.String r0 = (java.lang.String) r0
        L_0x001c:
            r10.a((java.lang.String) r0)
            goto L_0x003a
        L_0x0020:
            int r0 = r11.arg1
            com.iflytek.cloud.thirdparty.t r1 = r10.f
            if (r1 == 0) goto L_0x002b
            com.iflytek.cloud.thirdparty.t r1 = r10.f
            r1.a((int) r0)
        L_0x002b:
            org.json.JSONObject r0 = com.iflytek.cloud.thirdparty.am.a((int) r0)
            boolean r1 = com.iflytek.aiui.Version.isMobileVersion()
            if (r1 != 0) goto L_0x003a
            java.lang.String r0 = r0.toString()
            goto L_0x001c
        L_0x003a:
            java.lang.String r0 = "speech"
            java.lang.String r1 = "work_mode"
            java.lang.String r2 = "intent"
            java.lang.String r0 = com.iflytek.cloud.thirdparty.ac.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "intent"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "cloud"
            java.lang.String r1 = r10.o
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            android.content.Context r0 = r10.g()
            boolean r0 = com.iflytek.cloud.thirdparty.bz.b((android.content.Context) r0)
            if (r0 != 0) goto L_0x0068
            r0 = 20001(0x4e21, float:2.8027E-41)
            java.lang.String r1 = "no network."
            r10.a((int) r0, (java.lang.String) r1)
            return
        L_0x0068:
            byte[] r5 = com.iflytek.cloud.thirdparty.o.a
            java.lang.String r0 = "sdk"
            if (r12 == 0) goto L_0x0070
            java.lang.String r0 = "user"
        L_0x0070:
            r8 = r0
            r9 = 3
            boolean r0 = r10.b((int) r9)
            if (r0 != 0) goto L_0x00c8
            android.content.Context r0 = r10.c
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = r10.l
            com.iflytek.cloud.thirdparty.al.a((android.content.Context) r0, (long) r1, (java.lang.String) r3)
            com.iflytek.cloud.thirdparty.t r0 = r10.f
            android.content.Context r0 = r0.b()
            java.lang.String r1 = ""
            java.lang.String r2 = "wake"
            com.iflytek.cloud.thirdparty.aj.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "wakeup"
            java.lang.String r2 = "working"
            java.lang.String r3 = "ready"
            java.lang.String r4 = ""
            java.lang.String r6 = "audio"
            r0 = r10
            r7 = r8
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            java.lang.String r0 = "continuous"
            java.lang.String r1 = r10.p
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = "auto"
            java.lang.String r1 = r10.q
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00c3
            java.lang.String r1 = "cmd"
            java.lang.String r2 = "working"
            java.lang.String r3 = "ready"
            java.lang.String r4 = "clean_history"
            r5 = 0
            java.lang.String r6 = ""
            r0 = r10
            r7 = r8
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x00c3:
            java.lang.String r0 = "wakeup"
            java.lang.String r1 = "ready"
            goto L_0x00e0
        L_0x00c8:
            com.iflytek.cloud.thirdparty.ah r0 = r10.e
            r0.b()
            java.lang.String r1 = "re_wakeup"
            java.lang.String r2 = "working"
            java.lang.String r3 = "working"
            java.lang.String r4 = ""
            java.lang.String r6 = ""
            r0 = r10
            r7 = r8
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            java.lang.String r0 = "wakeup"
            java.lang.String r1 = "working"
        L_0x00e0:
            java.lang.String r2 = com.iflytek.cloud.thirdparty.al.a()
            com.iflytek.cloud.thirdparty.ao.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
            r10.c((int) r9)
            r10.c()
            if (r12 == 0) goto L_0x00f8
            r0 = 14
            android.os.Message r0 = r10.obtainMessage(r0)
            r10.a((android.os.Message) r0)
        L_0x00f8:
            r0 = 1
            android.os.Message r0 = r10.obtainMessage(r0)
            r10.a((android.os.Message) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.af.a(android.os.Message, boolean):void");
    }

    private void a(AIUIEvent aIUIEvent) {
        if (this.d != null) {
            this.d.onEvent(aIUIEvent);
        }
    }

    private void a(AIUIMessage aIUIMessage) {
        if (TextUtils.isEmpty(aIUIMessage.params)) {
            a(10106, "invalid write data params, empty or null.");
            return;
        }
        ce e2 = ac.e(aIUIMessage.params);
        String e3 = e2.e("data_type");
        if ("audio".equals(e3)) {
            if (this.f != null) {
                this.f.a(AIUIConstant.USER, aIUIMessage.data, aIUIMessage.params, 0, aIUIMessage.arg1, aIUIMessage.arg2, e2.a("sample_rate", 96000));
            }
        } else if (!"text".equals(e3)) {
        } else {
            if (!b(3)) {
                a((int) AIUIErrorCode.ERROR_NOT_WORKING, "AIUI not working, please wakeup first.");
            } else if (this.i != null) {
                try {
                    this.i.a(aIUIMessage.params, aIUIMessage.data);
                } catch (n e4) {
                    e4.printStackTrace();
                    a(e4.a(), e4.b());
                }
            }
        }
    }

    private void a(String str) {
        AIUIEvent aIUIEvent = new AIUIEvent(4, 0, 0, str, (Bundle) null);
        a(aIUIEvent);
    }

    private void a(String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        if (this.h != null) {
            try {
                this.h.a(str, str2, str3, str4, bArr, str5, str6);
            } catch (n e2) {
                n nVar = e2;
                nVar.printStackTrace();
                a(nVar.a(), nVar.b());
            }
        }
    }

    private void b(AIUIMessage aIUIMessage) {
        ce e2 = ac.e(aIUIMessage.params);
        if ("audio".equals(e2.e("data_type")) && this.f != null) {
            this.f.a(new byte[0], aIUIMessage.params, 4, aIUIMessage.arg1, aIUIMessage.arg2, e2.a("sample_rate", 96000));
        }
    }

    private void b(boolean z) {
        String str;
        String str2;
        a(3);
        if (AIUIConstant.INTERACT_MODE_CONTINUOUS.equals(this.p)) {
            this.e.b();
        }
        this.f.e();
        if (z) {
            str = "reset";
            str2 = "outer";
        } else {
            str = "reset";
            str2 = "inner";
        }
        ao.a(str, str2, al.a());
        cb.a("AIUIScheduler", "wakeup satatus reset, forced=" + z);
    }

    private boolean b(int i2) {
        return this.b == i2;
    }

    private void c(int i2) {
        this.b = i2;
        o();
    }

    private void c(AIUIMessage aIUIMessage) {
        if ("audio".equals(ac.e(aIUIMessage.params).e("data_type")) && this.f != null) {
            this.f.j();
        }
    }

    private void d(AIUIMessage aIUIMessage) {
        if ("audio".equals(ac.e(aIUIMessage.params).e("data_type")) && this.f != null) {
            this.f.k();
        }
    }

    private void e(AIUIMessage aIUIMessage) {
        String str;
        String str2;
        int i2 = aIUIMessage.msgType;
        switch (i2) {
            case 1:
                cb.a("AIUIScheduler", "CMD_GET_STATE");
                o();
                return;
            case 2:
                a(aIUIMessage);
                return;
            case 3:
                b(aIUIMessage);
                return;
            case 4:
                cb.a("AIUIScheduler", "CMD_RESET");
                l();
                return;
            case 5:
                cb.a("AIUIScheduler", "CMD_START");
                a(false);
                return;
            case 6:
                cb.a("AIUIScheduler", "CMD_STOP");
                b();
                m();
                return;
            case 7:
                cb.a("AIUIScheduler", "CMD_WAKEUP, beam=" + aIUIMessage.arg1);
                a(Message.obtain(this, 1, aIUIMessage.arg1, aIUIMessage.arg2, aIUIMessage.params), true);
                return;
            case 8:
                cb.a("AIUIScheduler", "CMD_RESET_WAKEUP, restType=" + aIUIMessage.arg1 + ", delayTime=" + aIUIMessage.arg2);
                a(3);
                if (1 == aIUIMessage.arg1) {
                    int i3 = aIUIMessage.arg2;
                    if (i3 < 0) {
                        i3 = 0;
                    } else if (i3 > 180000) {
                        i3 = 180000;
                    }
                    sendMessageDelayed(Message.obtain(this, 3, 0, 0, false), (long) i3);
                    return;
                }
                if (b(3)) {
                    AIUIEvent aIUIEvent = new AIUIEvent(5, 1, 0, (String) null, (Bundle) null);
                    a(aIUIEvent);
                    a("reset_wakeup", "ready", "working", "", (byte[]) null, "", AIUIConstant.USER);
                }
                b(true);
                c(2);
                return;
            case 9:
                cb.a("AIUIScheduler", "CMD_SET_BEAM, beam=" + aIUIMessage.arg1);
                if (this.f != null) {
                    this.f.a(aIUIMessage.arg1);
                    return;
                }
                return;
            case 10:
                cb.a("AIUIScheduler", "CMD_SET_PARAMS, params=" + aIUIMessage.params);
                ac.b(aIUIMessage.params);
                i();
                if (this.k != null) {
                    this.k.a();
                }
                Message obtain = Message.obtain();
                obtain.what = 13;
                a(obtain);
                return;
            case 11:
                cb.a("AIUIScheduler", "CMD_UPLOAD_LEXICON");
                if (this.f != null) {
                    this.f.b(aIUIMessage);
                    return;
                }
                return;
            case 12:
                this.j.a(aIUIMessage.params, aIUIMessage.arg1);
                return;
            case 13:
                cb.a("AIUIScheduler", "CMD_SYNC");
                if (this.g != null) {
                    this.g.a(aIUIMessage);
                    return;
                }
                return;
            case 14:
                cb.a("AIUIScheduler", "CMD_START_SAVE");
                f(aIUIMessage);
                return;
            case 15:
                cb.a("AIUIScheduler", "CMD_STOP_SAVE");
                g(aIUIMessage);
                return;
            case 16:
                cb.a("AIUIScheduler", "CMD_BUILD_GRAMMAR");
                if (this.f != null) {
                    this.f.a(aIUIMessage);
                    return;
                }
                return;
            case 17:
                cb.a("AIUIScheduler", "CMD_UPDATE_LOCAL_LEXICON");
                if (this.f != null) {
                    this.f.c(aIUIMessage);
                    return;
                }
                return;
            case 18:
                cb.a("AIUIScheduler", "CMD_START_THROW_AUDIO");
                if (this.f != null) {
                    this.f.d(aIUIMessage);
                    return;
                }
                return;
            case 19:
                cb.a("AIUIScheduler", "CMD_STOP_THROW_AUDIO");
                if (this.f != null) {
                    this.f.l();
                    return;
                }
                return;
            case 20:
                cb.a("AIUIScheduler", "CMD_RESULT_VALIDATION_ACK");
                if (hasMessages(11)) {
                    removeMessages(11);
                    c();
                    str = "AIUIScheduler";
                    str2 = "interact timeout has been reset.";
                } else {
                    str = "AIUIScheduler";
                    str2 = "result ack timeout.";
                }
                cb.a(str, str2);
                return;
            case 21:
                cb.a("AIUIScheduler", "CMD_CLEAN_DIALOG_HISTORY");
                String a2 = o.a(this.b);
                a("cmd", a2, a2, "clean_history", (byte[]) null, "", AIUIConstant.USER);
                return;
            case 22:
                cb.a("AIUIScheduler", "CMD_START_RECORD");
                c(aIUIMessage);
                return;
            case 23:
                cb.a("AIUIScheduler", "CMD_STOP_RECORD");
                d(aIUIMessage);
                return;
            case 24:
                cb.a("AIUIScheduler", "CMD_QUERY_SYNC_STATUS");
                if (this.g != null) {
                    this.g.b(aIUIMessage);
                    return;
                }
                return;
            default:
                switch (i2) {
                    case 1000:
                        if (this.f != null) {
                            this.f.e(aIUIMessage);
                            return;
                        }
                        return;
                    case 1001:
                        if (this.f != null) {
                            this.f.f(aIUIMessage);
                            return;
                        }
                        return;
                    default:
                        return;
                }
        }
    }

    private void f(AIUIMessage aIUIMessage) {
        ce ceVar = new ce();
        ceVar.a(aIUIMessage.params);
        if ("raw_audio".endsWith(ceVar.e("data_type"))) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            a(obtain);
        }
    }

    private void g(AIUIMessage aIUIMessage) {
        ce ceVar = new ce();
        ceVar.a(aIUIMessage.params);
        if ("raw_audio".endsWith(ceVar.e("data_type"))) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            a(obtain);
        }
    }

    private void i() {
        this.l = ac.b();
        this.m = ac.a("interact", AIUIConstant.KEY_INTERACT_TIMEOUT, 10000);
        this.o = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
        this.n = ac.a("interact", AIUIConstant.KEY_RESULT_TIMEOUT, this.n);
        this.p = ac.a("speech", AIUIConstant.KEY_INTERACT_MODE, AIUIConstant.INTERACT_MODE_CONTINUOUS);
        this.q = ac.a("global", AIUIConstant.KEY_CLEAN_DIALOG_HISTORY, "auto");
        if (-1 != this.m) {
            if (this.m < 10000) {
                this.m = 10000;
            } else if (this.m > 180000) {
                this.m = 180000;
            }
        }
        if (Version.isMobileVersion()) {
            this.p = ac.a("speech", AIUIConstant.KEY_INTERACT_MODE, AIUIConstant.INTERACT_MODE_ONESHOT);
        }
    }

    private int j() {
        ce d2 = ac.d("aiui_ssb");
        if (d2 == null) {
            d2 = new ce();
        }
        d2.a("delay_init", "0");
        d2.a("rslt_timeout", this.n + "");
        try {
            if (this.e.a(d2) != 0) {
                return 0;
            }
            this.e.a("resultCb", "statusCb", "errorCb", "syncDataCb", "pushCb", this.k);
            return 0;
        } catch (n e2) {
            a(e2.a(), e2.b());
            return -1;
        }
    }

    private void k() {
        try {
            this.e.a();
        } catch (n e2) {
            a(e2.a(), e2.b());
        }
    }

    private void l() {
        a(3);
        m();
        a(false);
        cb.a("AIUIScheduler", "AIUIScheduler reset.");
    }

    private synchronized void m() {
        String str = "";
        if (b(2)) {
            str = "ready";
        } else if (b(3)) {
            str = "working";
        }
        a("stop", "idle", str, "", (byte[]) null, "", "sdk");
        ao.a("stop", (String) null);
        this.f.f();
        k();
        c(1);
        cb.a("AIUIScheduler", "AIUIScheduler stopped.");
    }

    private void n() {
        if (-1 != this.m) {
            a(3, (long) this.m);
        }
    }

    private void o() {
        AIUIEvent aIUIEvent = new AIUIEvent(3, this.b, 0, (String) null, (Bundle) null);
        if (3 == this.b && this.f != null) {
            aIUIEvent.info = this.f.h();
        }
        a(aIUIEvent);
    }

    public synchronized int a(boolean z) {
        if (!b(1)) {
            cb.a("AIUIScheduler", "AIUIScheduler was already started.");
            return 0;
        }
        if (z) {
            if (!ac.b(this.a)) {
                a(10106, "invalid params json format.");
                return -1;
            }
        }
        this.k.a();
        this.k.b();
        i();
        if (j() != 0) {
            return -1;
        }
        try {
            if (this.f.d() == 0) {
                c(2);
            }
            this.j.a(this.f.i());
            a("start", "ready", "idle", "", (byte[]) null, "", "sdk");
            ao.a("start", (String) null);
            cb.a("AIUIScheduler", "AIUIScheduler started.");
            return 0;
        } catch (n e2) {
            a(e2.a(), e2.b());
            return -1;
        }
    }

    public void a() {
        b();
        m();
        if (this.f != null) {
            this.f.g();
        }
    }

    public void a(int i2) {
        removeMessages(i2);
    }

    public void a(int i2, int i3, int i4, Object obj, long j2) {
        Message obtain = Message.obtain(this, i2, i3, i4);
        obtain.obj = obj;
        sendMessageDelayed(obtain, j2);
    }

    public void a(int i2, long j2) {
        sendMessageDelayed(Message.obtain(this, i2), j2);
    }

    public void a(int i2, String str) {
        AIUIEvent aIUIEvent = new AIUIEvent(2, i2, 0, str, (Bundle) null);
        sendMessage(obtainMessage(7, aIUIEvent));
    }

    public void b() {
        cb.a("AIUIScheduler", "clear all messages.");
        for (int i2 = 1; i2 < 13; i2++) {
            removeMessages(i2);
        }
    }

    public void c() {
        cb.a("AIUIScheduler", "reset interact timeout.");
        a(3);
        n();
    }

    public String d() {
        return this.p;
    }

    public ah e() {
        return this.e;
    }

    public ag f() {
        return this.k;
    }

    public Context g() {
        return this.c;
    }

    public String h() {
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        a((com.iflytek.aiui.AIUIEvent) r0.obj);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        b(false);
        c(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r18) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            int r1 = r0.what
            r2 = 3
            r3 = 5
            r4 = 1
            r9 = 0
            r10 = 2
            switch(r1) {
                case 1: goto L_0x0174;
                case 2: goto L_0x0143;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00aa;
                case 5: goto L_0x0095;
                case 6: goto L_0x0070;
                case 7: goto L_0x004f;
                case 8: goto L_0x0095;
                case 9: goto L_0x0047;
                case 10: goto L_0x0095;
                case 11: goto L_0x002a;
                case 12: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            return
        L_0x000f:
            java.lang.String r0 = "AIUIScheduler"
            java.lang.String r1 = "lost connection to server for long time, reset AIUI session."
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            com.iflytek.cloud.thirdparty.ah r0 = r8.e
            if (r0 == 0) goto L_0x0177
            r17.k()
            r17.j()
            com.iflytek.cloud.thirdparty.ag r0 = r8.k
            if (r0 == 0) goto L_0x0177
            com.iflytek.cloud.thirdparty.ag r0 = r8.k
            r0.b()
            return
        L_0x002a:
            int r0 = r0.arg1
            r1 = 11
            switch(r0) {
                case 0: goto L_0x0036;
                case 1: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            return
        L_0x0032:
            r8.removeMessages(r1)
            return
        L_0x0036:
            r8.removeMessages(r1)
            android.os.Message r0 = android.os.Message.obtain()
            r0.what = r1
            r0.arg1 = r4
            r1 = 5000(0x1388, double:2.4703E-320)
            r8.sendMessageDelayed(r0, r1)
            return
        L_0x0047:
            java.lang.Object r0 = r0.obj
            com.iflytek.aiui.AIUIEvent r0 = (com.iflytek.aiui.AIUIEvent) r0
            r8.a((com.iflytek.aiui.AIUIEvent) r0)
            return
        L_0x004f:
            java.lang.Object r0 = r0.obj
            com.iflytek.aiui.AIUIEvent r0 = (com.iflytek.aiui.AIUIEvent) r0
            r8.a((com.iflytek.aiui.AIUIEvent) r0)
            r1 = 11216(0x2bd0, float:1.5717E-41)
            int r0 = r0.arg1
            if (r1 != r0) goto L_0x0177
            com.iflytek.aiui.AIUIMessage r0 = new com.iflytek.aiui.AIUIMessage
            r3 = 6
            r4 = 0
            r5 = 0
            java.lang.String r6 = ""
            r7 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            android.os.Message r0 = r8.obtainMessage(r10, r0)
            r8.sendMessage(r0)
            return
        L_0x0070:
            com.iflytek.aiui.AIUIEvent r7 = new com.iflytek.aiui.AIUIEvent
            r2 = 6
            int r3 = r0.arg1
            int r4 = r0.arg2
            r5 = 0
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r8.a((com.iflytek.aiui.AIUIEvent) r7)
            int r0 = r0.arg1
            if (r10 != r0) goto L_0x0177
            java.lang.String r0 = "oneshot"
            java.lang.String r1 = r8.p
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0177
        L_0x008e:
            r8.b((boolean) r9)
            r8.c((int) r10)
            return
        L_0x0095:
            int r1 = r0.what
            if (r3 != r1) goto L_0x0047
            java.lang.String r1 = "continuous"
            java.lang.String r3 = r8.p
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0047
            boolean r1 = r8.b((int) r2)
            if (r1 != 0) goto L_0x0047
            return
        L_0x00aa:
            boolean r0 = r8.b((int) r2)
            if (r0 == 0) goto L_0x0177
            r17.c()
            return
        L_0x00b4:
            java.lang.Object r1 = r0.obj
            if (r1 == 0) goto L_0x00c0
            java.lang.Object r1 = r0.obj
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r4 = r1.booleanValue()
        L_0x00c0:
            if (r4 == 0) goto L_0x00e3
            com.iflytek.cloud.thirdparty.ah r1 = r8.e
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x00d4
            com.iflytek.cloud.thirdparty.ae r1 = com.iflytek.cloud.thirdparty.ae.a()
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x00e3
        L_0x00d4:
            r1 = 3
            r2 = 0
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r9)
            int r0 = r8.n
            long r5 = (long) r0
            r0 = r8
            r0.a(r1, r2, r3, r4, r5)
            return
        L_0x00e3:
            boolean r1 = r8.b((int) r10)
            if (r1 == 0) goto L_0x00ea
            return
        L_0x00ea:
            int r0 = r0.arg1
            r1 = 10
            if (r1 == r0) goto L_0x0115
            com.iflytek.aiui.AIUIEvent r0 = new com.iflytek.aiui.AIUIEvent
            r3 = 10
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r8.a((com.iflytek.aiui.AIUIEvent) r0)
            r1 = 3
            r2 = 10
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r9)
            r5 = 10000(0x2710, double:4.9407E-320)
            r0 = r8
            r0.a(r1, r2, r3, r4, r5)
            java.lang.String r0 = "AIUIScheduler"
            java.lang.String r1 = "prepare to sleep, sleep after 10000ms"
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            return
        L_0x0115:
            java.lang.String r0 = "AIUIScheduler"
            java.lang.String r1 = "interact timeout, reset wakeup."
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            com.iflytek.cloud.thirdparty.ah r0 = r8.e
            r0.b()
            java.lang.String r1 = "sleep"
            java.lang.String r2 = "ready"
            java.lang.String r3 = "working"
            java.lang.String r4 = ""
            r5 = 0
            java.lang.String r6 = ""
            java.lang.String r7 = "sdk"
            r0 = r8
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            com.iflytek.aiui.AIUIEvent r0 = new com.iflytek.aiui.AIUIEvent
            r12 = 5
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            r8.a((com.iflytek.aiui.AIUIEvent) r0)
            goto L_0x008e
        L_0x0143:
            java.lang.Object r0 = r0.obj
            com.iflytek.aiui.AIUIMessage r0 = (com.iflytek.aiui.AIUIMessage) r0
            int r1 = r0.msgType
            if (r3 == r1) goto L_0x0170
            int r1 = r0.msgType
            if (r4 == r1) goto L_0x0170
            com.iflytek.cloud.thirdparty.ah r1 = r8.e
            boolean r1 = r1.c()
            if (r1 != 0) goto L_0x0170
            java.lang.String r1 = "AIUIScheduler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AIUISession has not began yet. ignore msgType="
            r2.append(r3)
            int r0 = r0.msgType
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
            return
        L_0x0170:
            r8.e(r0)
            return
        L_0x0174:
            r8.a((android.os.Message) r0, (boolean) r9)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.af.handleMessage(android.os.Message):void");
    }
}
