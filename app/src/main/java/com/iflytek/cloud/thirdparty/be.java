package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.cq;
import java.io.IOException;
import java.util.HashSet;

public abstract class be extends Handler implements cq.a {
    protected static final HashSet<be> y = new HashSet<>();
    private ce a = new ce();
    private volatile b b = b.init;
    private HandlerThread c;
    protected int r = 60000;
    public int s = 16000;
    protected Context t = null;
    protected volatile boolean u = false;
    protected long v = 0;
    protected int w = 20000;
    protected final cq x = cq.a((cq.a) this);

    protected enum a {
        max,
        normal
    }

    protected enum b {
        init,
        start,
        recording,
        waitresult,
        exiting,
        exited
    }

    public be(Context context) {
        super(context.getMainLooper());
        this.t = context;
        this.u = false;
    }

    public be(Context context, HandlerThread handlerThread) {
        super(handlerThread.getLooper());
        this.c = handlerThread;
        this.t = context;
        this.u = false;
        y.add(this);
    }

    private void a() {
        Thread thread;
        if (this.c != null && this.c.isAlive()) {
            y();
            if (this.t != null) {
                Looper mainLooper = this.t.getMainLooper();
                if (mainLooper != null) {
                    thread = mainLooper.getThread();
                    if (this.t == null || !this.c.equals(thread)) {
                        this.c.quit();
                        cb.a("quit current Msc Handler thread");
                    }
                    this.c = null;
                }
            }
            thread = null;
            this.c.quit();
            cb.a("quit current Msc Handler thread");
            this.c = null;
        }
        y.remove(this);
    }

    public static boolean u() {
        return y.isEmpty();
    }

    public String A() {
        return x() != null ? this.a.b("engine_type", "cloud") : "cloud";
    }

    public String B() {
        return "local".equalsIgnoreCase(A()) ? e() : f();
    }

    public void C() throws SecurityException {
        cb.a("startBluetooth enter");
        AudioManager audioManager = (AudioManager) this.t.getSystemService("audio");
        audioManager.setBluetoothScoOn(true);
        audioManager.startBluetoothSco();
    }

    public void D() {
        cb.a("stopBluetooth enter");
        try {
            AudioManager audioManager = (AudioManager) this.t.getSystemService("audio");
            audioManager.setBluetoothScoOn(false);
            audioManager.stopBluetoothSco();
        } catch (Throwable th) {
            cb.a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        a(obtainMessage(i), a.normal, false, 0);
    }

    /* access modifiers changed from: protected */
    public void a(int i, a aVar, boolean z, int i2) {
        a(obtainMessage(i), aVar, z, i2);
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Message r3, com.iflytek.cloud.thirdparty.be.a r4, boolean r5, int r6) {
        /*
            r2 = this;
            com.iflytek.cloud.thirdparty.be$b r0 = r2.w()
            com.iflytek.cloud.thirdparty.be$b r1 = com.iflytek.cloud.thirdparty.be.b.exited
            if (r0 == r1) goto L_0x003e
            com.iflytek.cloud.thirdparty.be$b r0 = r2.w()
            com.iflytek.cloud.thirdparty.be$b r1 = com.iflytek.cloud.thirdparty.be.b.exiting
            if (r0 != r1) goto L_0x0011
            goto L_0x003e
        L_0x0011:
            int r0 = r3.what
            if (r0 == 0) goto L_0x0023
            r1 = 3
            if (r0 == r1) goto L_0x0020
            r1 = 21
            if (r0 == r1) goto L_0x001d
            goto L_0x0028
        L_0x001d:
            com.iflytek.cloud.thirdparty.be$b r0 = com.iflytek.cloud.thirdparty.be.b.exiting
            goto L_0x0025
        L_0x0020:
            com.iflytek.cloud.thirdparty.be$b r0 = com.iflytek.cloud.thirdparty.be.b.waitresult
            goto L_0x0025
        L_0x0023:
            com.iflytek.cloud.thirdparty.be$b r0 = com.iflytek.cloud.thirdparty.be.b.start
        L_0x0025:
            r2.a((com.iflytek.cloud.thirdparty.be.b) r0)
        L_0x0028:
            if (r5 == 0) goto L_0x002f
            int r5 = r3.what
            r2.removeMessages(r5)
        L_0x002f:
            com.iflytek.cloud.thirdparty.be$a r5 = com.iflytek.cloud.thirdparty.be.a.max
            if (r4 != r5) goto L_0x0039
            if (r6 > 0) goto L_0x0039
            r2.sendMessageAtFrontOfQueue(r3)
            return
        L_0x0039:
            long r4 = (long) r6
            r2.sendMessageDelayed(r3, r4)
            return
        L_0x003e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "send msg failed while status is "
            r3.append(r4)
            com.iflytek.cloud.thirdparty.be$b r4 = r2.w()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.be.a(android.os.Message, com.iflytek.cloud.thirdparty.be$a, boolean, int):void");
    }

    /* access modifiers changed from: protected */
    public void a(SpeechError speechError) {
        a(b.exited);
        y();
        cd.a(this.t).b();
    }

    /* access modifiers changed from: protected */
    public synchronized void a(b bVar) {
        cb.a("curStatus=" + this.b + ",setStatus=" + bVar);
        if (this.b != b.exited) {
            if (this.b != b.exiting || bVar == b.exited) {
                cb.a("setStatus success=" + bVar);
                this.b = bVar;
                this.v = SystemClock.elapsedRealtime();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ce ceVar) {
        this.a = ceVar.clone();
        c();
    }

    /* access modifiers changed from: protected */
    public void a_() {
        try {
            this.x.b();
        } catch (Throwable th) {
            cb.c("DC exception:");
            cb.a(th);
        }
        a(0, a.max, false, 0);
    }

    /* access modifiers changed from: protected */
    public synchronized void b(SpeechError speechError) {
        if (speechError != null) {
            y();
        }
        try {
            this.x.a(speechError);
        } catch (Throwable th) {
            cb.c("DC exception:");
            cb.a(th);
        }
        d(obtainMessage(21, speechError));
    }

    public void b(boolean z) {
        this.u = true;
        y();
        b((SpeechError) null);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.w = this.a.a(SpeechConstant.NET_TIMEOUT, this.w);
        this.s = this.a.a("sample_rate", this.s);
    }

    /* access modifiers changed from: protected */
    public void d(Message message) {
        a(message, a.normal, false, 0);
    }

    public abstract String e();

    public abstract String f();

    public void handleMessage(Message message) {
        SpeechError e;
        StringBuilder sb;
        if (message.what != 21) {
            try {
                if (message.what == 8) {
                    throw new SpeechError(20002);
                } else if (SpeechUtility.getUtility() == null && 1 == message.what) {
                    cb.c("SDK is not init while session begin");
                    throw new SpeechError(20015);
                } else {
                    a(message);
                }
            } catch (IOException e2) {
                cb.a((Throwable) e2);
                e = new SpeechError(20010);
                if (e != null) {
                    sb = new StringBuilder();
                    sb.append(z());
                    sb.append(" occur Error = ");
                    sb.append(e.toString());
                    cb.a(sb.toString());
                    b(e);
                }
            } catch (SpeechError e3) {
                e = e3;
                cb.a((Throwable) e);
                if (e != null) {
                    sb = new StringBuilder();
                    sb.append(z());
                    sb.append(" occur Error = ");
                    sb.append(e.toString());
                    cb.a(sb.toString());
                    b(e);
                }
            } catch (Exception e4) {
                cb.a((Throwable) e4);
                SpeechError speechError = new SpeechError(e4);
                if (speechError != null) {
                    cb.a(z() + " occur Error = " + speechError.toString());
                    b(speechError);
                }
            } catch (UnsatisfiedLinkError e5) {
                cb.a((Throwable) e5);
                e = new SpeechError(20021);
                if (e != null) {
                    sb = new StringBuilder();
                    sb.append(z());
                    sb.append(" occur Error = ");
                    sb.append(e.toString());
                    cb.a(sb.toString());
                    b(e);
                }
            } catch (Throwable th) {
                cb.a(th);
                e = new SpeechError(20999);
                if (e != null) {
                    sb = new StringBuilder();
                    sb.append(z());
                    sb.append(" occur Error = ");
                    sb.append(e.toString());
                    cb.a(sb.toString());
                    b(e);
                }
            }
        } else {
            a((SpeechError) message.obj);
            a();
        }
    }

    public boolean m() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void p() {
        removeMessages(8);
        a(8, a.normal, false, this.w);
    }

    public String q() {
        return this.a.b("pte", "utf-8");
    }

    public String r() {
        return this.a.b(SpeechConstant.TEXT_ENCODING, "utf-8");
    }

    public String s() {
        return this.a.b("rse", "utf-8");
    }

    public int t() {
        return this.s;
    }

    public boolean v() {
        return (this.b == b.exited || this.b == b.exiting || this.b == b.init) ? false : true;
    }

    /* access modifiers changed from: protected */
    public synchronized b w() {
        return this.b;
    }

    public ce x() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void y() {
        cb.a("clear all message");
        for (int i = 0; i < 20; i++) {
            removeMessages(i);
        }
    }

    /* access modifiers changed from: protected */
    public String z() {
        return getClass().toString();
    }
}
