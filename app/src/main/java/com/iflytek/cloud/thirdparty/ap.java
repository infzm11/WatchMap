package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cae.jni.CAEJni;
import java.io.UnsupportedEncodingException;

public class ap {
    private static ap a = null;
    private static int b = 0;
    /* access modifiers changed from: private */
    public static int c = 1024;
    private boolean d = false;
    /* access modifiers changed from: private */
    public ar e;
    private a f;
    private Handler g = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    String str = (String) message.obj;
                    if (ap.this.e != null) {
                        ap.this.e.a(str);
                        return;
                    }
                    return;
                case 2:
                    Bundle bundle = (Bundle) message.obj;
                    byte[] byteArray = bundle.getByteArray("audioData");
                    int i = bundle.getInt("dataLen");
                    int i2 = bundle.getInt("param1");
                    int i3 = bundle.getInt("param2");
                    if (ap.this.e != null) {
                        ap.this.e.a(byteArray, i, i2, i3);
                        return;
                    }
                    return;
                case 3:
                    aq aqVar = (aq) message.obj;
                    if (ap.this.e != null) {
                        ap.this.e.a(aqVar);
                        return;
                    }
                    return;
                case 4:
                    Bundle bundle2 = (Bundle) message.obj;
                    int i4 = bundle2.getInt("type");
                    byte[] byteArray2 = bundle2.getByteArray("param1Array");
                    byte[] byteArray3 = bundle2.getByteArray("param2Array");
                    byte[] byteArray4 = bundle2.getByteArray("param3Array");
                    if (ap.this.e != null) {
                        ap.this.e.a(i4, byteArray2, byteArray3, byteArray4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private CAEJni.a h = new CAEJni.a();

    class a extends Thread {
        private boolean b = false;

        public a() {
            super("CAE-Read16kAudioThread");
            setPriority(10);
        }

        public void a() {
            interrupt();
            this.b = true;
        }

        public void run() {
            super.run();
            while (!this.b) {
                byte[] bArr = new byte[ap.c];
                int CAERead16kAudio = CAEJni.CAERead16kAudio(bArr);
                if (CAERead16kAudio == 0) {
                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (ap.this.e != null) {
                    ap.this.e.a(bArr, CAERead16kAudio, 0, 0);
                }
            }
        }
    }

    private ap() {
        if (this.f == null) {
            this.f = new a();
        }
    }

    public static ap a(String str, String str2, int i) {
        CAEJni.a(str);
        if (TextUtils.isEmpty(str2)) {
            a = null;
            as.b("Ivw resouce path is empty!");
            return null;
        }
        c = i;
        synchronized (ap.class) {
            if (a == null) {
                a = new ap();
                int CAENew = CAEJni.CAENew(str2, "ivwCb", "audioCb", "", a);
                if (CAENew == 0) {
                    a.e();
                    as.a("CAE engine create success. handle=" + b);
                } else {
                    as.b("CAE engine create fail. error=" + CAENew);
                    a = null;
                    b = 0;
                }
            } else {
                as.b("CAE engine has already existed!");
            }
        }
        return a;
    }

    public static int c() {
        if (CAEJni.a()) {
            return CAEJni.CAEGetChannel();
        }
        return -1;
    }

    private void e() {
        if (this.f != null) {
            this.f.start();
        }
    }

    private void f() {
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
    }

    public void a() {
        synchronized (ap.class) {
            if (b != 0) {
                int CAEReset = CAEJni.CAEReset(b);
                if (CAEReset != 0) {
                    this.g.obtainMessage(3, new aq(CAEReset, "")).sendToTarget();
                    as.b("CAE engine reset fail. error=" + CAEReset);
                    b();
                } else {
                    this.d = false;
                    as.a("CAE engine reset sucess.");
                }
            } else {
                as.b("CAE engine is destroyed, invalid call!");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r5 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        com.iflytek.cloud.thirdparty.as.a("CAE engine setRealBeam fail. error=" + r5);
        r4.g.obtainMessage(3, new com.iflytek.cloud.thirdparty.aq(r5, "")).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5) {
        /*
            r4 = this;
            java.lang.Class<com.iflytek.cloud.thirdparty.ap> r0 = com.iflytek.cloud.thirdparty.ap.class
            monitor-enter(r0)
            int r1 = b     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x000e
            java.lang.String r5 = "CAE engine is destroyed, invalid call!"
            com.iflytek.cloud.thirdparty.as.b(r5)     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x000e:
            int r1 = b     // Catch:{ all -> 0x003a }
            int r5 = com.iflytek.cae.jni.CAEJni.CAESetRealBeam(r1, r5)     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x0039
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "CAE engine setRealBeam fail. error="
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.iflytek.cloud.thirdparty.as.a((java.lang.String) r0)
            android.os.Handler r0 = r4.g
            r1 = 3
            com.iflytek.cloud.thirdparty.aq r2 = new com.iflytek.cloud.thirdparty.aq
            java.lang.String r3 = ""
            r2.<init>(r5, r3)
            android.os.Message r5 = r0.obtainMessage(r1, r2)
            r5.sendToTarget()
        L_0x0039:
            return
        L_0x003a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ap.a(int):void");
    }

    public void a(int i, byte[] bArr, byte[] bArr2) {
        synchronized (ap.class) {
            if (b != 0) {
                int CAESendMsg = CAEJni.CAESendMsg(b, i, bArr, bArr2);
                if (CAESendMsg != 0) {
                    this.g.obtainMessage(3, new aq(CAESendMsg, "")).sendToTarget();
                    as.b("Send message error. error=" + CAESendMsg);
                    b();
                }
            } else {
                as.b("CAE engine is destroyed, invalid call!");
            }
        }
    }

    public void a(ar arVar) {
        this.e = arVar;
    }

    public void a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            as.b("key or val is empty.");
            return;
        }
        synchronized (ap.class) {
            if (b != 0) {
                try {
                    CAEJni.CAESetWParam(b, str.getBytes("utf-8"), str2.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    str3 = "key or value is not utf-8 encoded!";
                }
            } else {
                str3 = "CAE engine is destroyed, invalid call!";
                as.b(str3);
            }
        }
    }

    public void a(byte[] bArr, int i) {
        synchronized (ap.class) {
            if (b != 0) {
                int CAEAudioWrite = CAEJni.CAEAudioWrite(b, bArr, i);
                if (CAEAudioWrite != 0) {
                    this.g.obtainMessage(3, new aq(CAEAudioWrite, "")).sendToTarget();
                    as.b("Write audio error. error=" + CAEAudioWrite);
                    b();
                }
            } else {
                as.b("CAE engine is destroyed, invalid call!");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r1 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        com.iflytek.cloud.thirdparty.as.a("CAE engine destroy fail. error=" + r1);
        r5.g.obtainMessage(3, new com.iflytek.cloud.thirdparty.aq(r1, "")).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r5 = this;
            java.lang.Class<com.iflytek.cloud.thirdparty.ap> r0 = com.iflytek.cloud.thirdparty.ap.class
            monitor-enter(r0)
            int r1 = b     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0009:
            com.iflytek.cloud.thirdparty.ap r1 = a     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0012
            com.iflytek.cloud.thirdparty.ap r1 = a     // Catch:{ all -> 0x005b }
            r1.f()     // Catch:{ all -> 0x005b }
        L_0x0012:
            int r1 = b     // Catch:{ all -> 0x005b }
            int r1 = com.iflytek.cae.jni.CAEJni.CAEDestroy(r1)     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0026
            r2 = 0
            b = r2     // Catch:{ all -> 0x005b }
            r2 = 0
            a = r2     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "CAE engine destroy sucess."
        L_0x0022:
            com.iflytek.cloud.thirdparty.as.a((java.lang.String) r2)     // Catch:{ all -> 0x005b }
            goto L_0x0035
        L_0x0026:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "CAE engine destroy, error="
            r2.<init>(r3)     // Catch:{ all -> 0x005b }
            r2.append(r1)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005b }
            goto L_0x0022
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x005a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "CAE engine destroy fail. error="
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.iflytek.cloud.thirdparty.as.a((java.lang.String) r0)
            android.os.Handler r0 = r5.g
            r2 = 3
            com.iflytek.cloud.thirdparty.aq r3 = new com.iflytek.cloud.thirdparty.aq
            java.lang.String r4 = ""
            r3.<init>(r1, r4)
            android.os.Message r0 = r0.obtainMessage(r2, r3)
            r0.sendToTarget()
        L_0x005a:
            return
        L_0x005b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ap.b():void");
    }
}
