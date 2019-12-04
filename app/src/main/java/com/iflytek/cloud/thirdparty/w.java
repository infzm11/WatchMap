package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIErrorCode;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUISetting;
import com.iflytek.cae.jni.CAEJni;
import com.iflytek.cloud.thirdparty.ak;
import com.iflytek.cloud.thirdparty.at;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class w extends u implements ar {
    /* access modifiers changed from: private */
    public static final String n = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/AIUI/clearhistory/");
    private String d;
    private String e;
    private String f;
    private int g = 1536;
    /* access modifiers changed from: private */
    public ap h;
    private ab i;
    private boolean j = false;
    private boolean k = false;
    private ak.a l;
    private b m;

    class a extends Handler {
        private ConcurrentLinkedQueue<byte[]> b = new ConcurrentLinkedQueue<>();
        private ak.a c = ak.a(w.n);

        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            synchronized (this) {
                this.b.clear();
                removeMessages(1);
            }
            if (this.c != null) {
                this.c.c();
            }
        }

        public void a(byte[] bArr) {
            synchronized (this) {
                if (bArr != null) {
                    try {
                        this.b.add(bArr);
                        sendEmptyMessage(1);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                byte[] poll = this.b.poll();
                if (poll != null && poll.length != 0) {
                    long size = (long) ((this.b.size() * poll.length) / 1024);
                    if (size >= 10) {
                        Log.d("CaeUnit", "blocked raw audio size=" + size + "KB");
                    }
                    if (w.this.h != null) {
                        w.this.h.a(poll, poll.length);
                    }
                    if (5000 <= size) {
                        this.b.clear();
                        if (this.c != null) {
                            this.c.a("", ".txt");
                            this.c.b(new Date().toString() + " cleared 5000KB raw audio.\n\n");
                        }
                    }
                }
            }
        }
    }

    class b {
        private a b;
        private HandlerThread c = new HandlerThread("AIUI:CAE-WriteRawAudioThread");

        public b() {
        }

        public void a() {
            this.c.start();
            this.b = new a(this.c.getLooper());
        }

        public void a(byte[] bArr) {
            if (this.b != null) {
                this.b.a(bArr);
            }
        }

        public void b() {
            if (this.b != null) {
                this.c.quit();
                this.b.a();
            }
        }
    }

    public w(t tVar) {
        super("CaeUnit", tVar);
    }

    private void a(byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("audio", (byte[]) bArr.clone());
        Message obtain = Message.obtain();
        obtain.what = 9;
        AIUIEvent aIUIEvent = new AIUIEvent(9, 0, 0, (String) null, bundle);
        obtain.obj = aIUIEvent;
        a(obtain);
    }

    public void a(int i2) {
        if (this.h != null) {
            this.h.a(i2);
        }
    }

    public void a(int i2, byte[] bArr, byte[] bArr2) {
        if (this.h != null) {
            this.h.a(i2, bArr, bArr2);
        }
    }

    public void a(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (i2 == 0) {
            af a2 = this.b.a();
            if (a2 != null) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("plain", bArr);
                AIUIEvent aIUIEvent = new AIUIEvent(1000, 0, 0, "", bundle);
                Message obtain = Message.obtain();
                obtain.what = 10;
                obtain.obj = aIUIEvent;
                a2.sendMessage(obtain);
            }
        }
    }

    public void a(ab abVar) {
        this.i = abVar;
    }

    public void a(aq aqVar) {
        this.j = false;
        a(aqVar.a(), "CAE error!");
        Log.e("CaeUnit", "error=" + aqVar.a());
    }

    public void a(String str) {
        cb.a("CaeUnit", "wakeup, wakeInfo=" + str);
        if (this.j && this.i != null) {
            this.i.d();
        }
        this.j = true;
        if (this.b != null) {
            this.b.a(str);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            a(obtain);
        }
    }

    public void a(byte[] bArr, int i2, int i3, int i4) {
        if (this.i != null) {
            if (this.k) {
                a(bArr);
            }
            this.i.a(bArr, "", 0, 0, 0);
        }
    }

    public void a(byte[] bArr, String str, int i2, int i3, int i4) {
        if (bArr == null) {
            Log.e("CaeUnit", "audio is null.");
            return;
        }
        if (this.l != null) {
            if (2147483648L <= this.l.e()) {
                i();
                this.l.c("");
            }
            try {
                this.l.a(bArr, false);
            } catch (IOException e2) {
                e2.printStackTrace();
                a(AIUIErrorCode.ERROR_IO_EXCEPTION, e2.getMessage());
            }
        }
        if (this.m != null) {
            this.m.a(bArr);
        }
    }

    public boolean a() {
        String a2 = ac.a("ivw", AIUIConstant.KEY_RES_TYPE, "");
        String a3 = ac.a("ivw", AIUIConstant.KEY_RES_PATH, "");
        if (this.d.equals(a2) && this.e.equals(a3)) {
            return false;
        }
        cb.a("CaeUnit", "critical params changed.");
        return true;
    }

    public int b() {
        String str;
        String str2;
        if (this.c) {
            str = "CaeUnit";
            str2 = "CaeUnit was already started.";
        } else {
            e();
            this.h = ap.a(this.f, at.a(this.b.b(), at.a.valueOf(this.d), this.e), this.g);
            if (this.h == null) {
                return -1;
            }
            this.h.a((ar) this);
            JSONObject c = ac.c("ivw");
            if (c != null) {
                JSONObject optJSONObject = c.optJSONObject(AIUIConstant.KEY_CAE_PARAMS);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.h.a(next, optJSONObject.optString(next));
                    }
                }
            }
            this.j = false;
            this.l = ak.a(AIUISetting.getRawAudioPath());
            this.m = new b();
            this.m.a();
            this.c = true;
            str = "CaeUnit";
            str2 = "CaeUnit started.";
        }
        cb.a(str, str2);
        return 0;
    }

    public void b(int i2) {
        this.k = true;
        if (!this.j && this.h != null) {
            this.h.a(i2);
        }
    }

    public void c() {
        cb.a("CaeUnit", "destroy cae engine.");
        if (this.h != null) {
            this.h.b();
        }
        cb.a("CaeUnit", "cae engine has been destroyed.");
        if (this.m != null) {
            this.m.b();
        }
        this.j = false;
        this.c = false;
        this.k = false;
    }

    public void d() {
        c();
        b();
        cb.a("CaeUnit", "CaeUnit reset.");
    }

    public void e() {
        this.d = ac.a("ivw", AIUIConstant.KEY_RES_TYPE, AIUIConstant.RES_TYPE_ASSETS);
        this.e = ac.a("ivw", AIUIConstant.KEY_RES_PATH, "");
        this.f = ac.a("ivw", AIUIConstant.KEY_LIB_CAE, "");
        this.g = ac.a("ivw", "audio_throw_size", this.g);
    }

    public void f() {
        if (this.h != null && !this.k) {
            this.h.a();
        }
        this.j = false;
    }

    public int g() {
        if (CAEJni.a()) {
            return ap.c();
        }
        return -1;
    }

    public void h() {
        if (this.l != null) {
            this.l.c("");
        }
    }

    public void i() {
        if (this.l != null) {
            this.l.d();
        }
    }

    public void j() {
        this.k = false;
        if (!this.j && this.h != null) {
            this.h.a();
        }
    }
}
