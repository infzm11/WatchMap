package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUISetting;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.cloud.thirdparty.ak;
import com.iflytek.cloud.util.AudioDetector;
import com.iflytek.cloud.util.ResourceUtil;
import com.iflytek.cloud.util.VolumeUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ab extends u {
    private int d = 16000;
    /* access modifiers changed from: private */
    public boolean e = true;
    private String f = AudioDetector.TYPE_META;
    private String g = "0.6";
    private String h = "5000";
    private String i = "1000";
    /* access modifiers changed from: private */
    public String j = AIUIConstant.WORK_MODE_INTENT;
    /* access modifiers changed from: private */
    public String k = "cloud";
    private HandlerThread l = new HandlerThread("AIUI:VAD-DetectThread");
    private a m;
    /* access modifiers changed from: private */
    public AudioDetector n;
    /* access modifiers changed from: private */
    public String o = "";
    /* access modifiers changed from: private */
    public aj p = new aj();
    private aj q = new aj();
    /* access modifiers changed from: private */
    public ak.a r;
    private aa s = new aa(15);
    private z t;
    /* access modifiers changed from: private */
    public long u = 0;
    /* access modifiers changed from: private */
    public long v = 0;
    /* access modifiers changed from: private */
    public x w;
    /* access modifiers changed from: private */
    public v x;
    private ce y;
    /* access modifiers changed from: private */
    public boolean z;

    class a extends Handler {
        private aa b = new aa(15);
        private boolean c = true;
        private boolean d = false;

        public a(Looper looper, boolean z) {
            super(looper);
            this.c = z;
            if (ab.this.n != null) {
                ab.this.n.reset();
            }
        }

        private void a(y yVar) {
            String str;
            String str2;
            if (ab.this.e) {
                ab.this.a(Message.obtain(ab.this.b.a(), 6, 1, VolumeUtil.computeVolume(yVar.a, yVar.a())));
            }
            Log.d("VadUnit", "direcetWrite blcok.dts =" + yVar.c);
            if (4 == yVar.c) {
                this.d = false;
                str = "VadUnit";
                str2 = "audio_end found.";
            } else if (!this.d) {
                this.d = true;
                String unused = ab.this.o = al.a("audio");
                yVar.c = 1;
                str = "VadUnit";
                str2 = "audio_start found, stmid=" + ab.this.o;
            } else {
                yVar.c = 2;
                yVar.a("stream_id", ab.this.o, true);
                b(yVar);
            }
            cb.a(str, str2);
            yVar.a("stream_id", ab.this.o, true);
            b(yVar);
        }

        private void b(y yVar) {
            if (1 == yVar.c) {
                ab.this.e();
            }
            if (!AIUIConstant.WORK_MODE_REC_ONLY.equals(ab.this.j)) {
                yVar.a(AIUIConstant.KEY_INTENT_ENGINE_TYPE, ab.this.k, true);
                if (ab.this.x != null) {
                    ab.this.x.a((y) yVar.clone());
                }
                if (ab.this.w != null) {
                    ab.this.w.a(yVar);
                }
            }
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009f, code lost:
            if (r12.d == false) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a1, code lost:
            r12.d = false;
            com.iflytek.cloud.thirdparty.ab.a(r12.a).reset();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01e5, code lost:
            if (r12.d == false) goto L_0x01f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01e8, code lost:
            r13.c = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ea, code lost:
            r13.a("stream_id", com.iflytek.cloud.thirdparty.ab.d(r12.a), true);
            b(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01f8, code lost:
            com.iflytek.cloud.thirdparty.ab.a(r12.a, com.iflytek.cloud.thirdparty.ab.l(r12.a) + (((long) r13.a()) / com.iflytek.cloud.thirdparty.ab.m(r12.a)));
            r12.b.a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0215, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void c(com.iflytek.cloud.thirdparty.y r13) {
            /*
                r12 = this;
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                monitor-enter(r0)
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this     // Catch:{ all -> 0x0216 }
                com.iflytek.cloud.util.AudioDetector r1 = r1.n     // Catch:{ all -> 0x0216 }
                r2 = 0
                if (r1 == 0) goto L_0x003a
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this     // Catch:{ all -> 0x0216 }
                boolean r1 = r1.c     // Catch:{ all -> 0x0216 }
                if (r1 == 0) goto L_0x003a
                int r1 = r13.a()     // Catch:{ all -> 0x0216 }
                if (r1 != 0) goto L_0x0029
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this     // Catch:{ all -> 0x0216 }
                com.iflytek.cloud.util.AudioDetector r1 = r1.n     // Catch:{ all -> 0x0216 }
                r3 = 320(0x140, float:4.48E-43)
                byte[] r4 = new byte[r3]     // Catch:{ all -> 0x0216 }
                com.iflytek.cloud.util.AudioDetector$DetectorResult r1 = r1.detect(r4, r2, r3, r2)     // Catch:{ all -> 0x0216 }
                goto L_0x003b
            L_0x0029:
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this     // Catch:{ all -> 0x0216 }
                com.iflytek.cloud.util.AudioDetector r1 = r1.n     // Catch:{ all -> 0x0216 }
                byte[] r3 = r13.a     // Catch:{ all -> 0x0216 }
                int r4 = r13.a()     // Catch:{ all -> 0x0216 }
                com.iflytek.cloud.util.AudioDetector$DetectorResult r1 = r1.detect(r3, r2, r4, r2)     // Catch:{ all -> 0x0216 }
                goto L_0x003b
            L_0x003a:
                r1 = 0
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0216 }
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                int r0 = r1.error
                if (r0 == 0) goto L_0x0065
                com.iflytek.cloud.thirdparty.ab r13 = com.iflytek.cloud.thirdparty.ab.this
                int r0 = r1.error
                java.lang.String r2 = "Vad error!"
                r13.a(r0, r2)
                java.lang.String r13 = "VadUnit"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Vad error="
                r0.append(r2)
                int r1 = r1.error
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.util.Log.e(r13, r0)
                return
            L_0x0065:
                int r0 = r1.status
                boolean r3 = r12.d
                r4 = 6
                r5 = 4
                r6 = 2
                r7 = 1
                if (r3 == 0) goto L_0x0091
                byte[] r3 = r13.a
                int r8 = r13.a()
                int r3 = com.iflytek.cloud.util.VolumeUtil.computeVolume(r3, r8)
                com.iflytek.cloud.thirdparty.ab r8 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.ab r9 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.t r9 = r9.b
                com.iflytek.cloud.thirdparty.af r9 = r9.a()
                android.os.Message r3 = android.os.Message.obtain(r9, r4, r7, r3)
                r8.a((android.os.Message) r3)
                int r3 = r13.c
                if (r5 != r3) goto L_0x0091
                r0 = r6
            L_0x0091:
                switch(r0) {
                    case 0: goto L_0x01e3;
                    case 1: goto L_0x0142;
                    case 2: goto L_0x00ae;
                    case 3: goto L_0x0096;
                    case 4: goto L_0x00ae;
                    default: goto L_0x0094;
                }
            L_0x0094:
                goto L_0x01f8
            L_0x0096:
                java.lang.String r3 = "VadUnit"
                java.lang.String r8 = "vad_bos timeout."
                com.iflytek.cloud.thirdparty.cb.a(r3, r8)
                boolean r3 = r12.d
                if (r3 != 0) goto L_0x00ae
            L_0x00a1:
                r12.d = r2
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.util.AudioDetector r0 = r0.n
                r0.reset()
                goto L_0x01f8
            L_0x00ae:
                if (r5 != r0) goto L_0x00b8
                java.lang.String r0 = "VadUnit"
                java.lang.String r3 = "speech timeout."
                com.iflytek.cloud.thirdparty.cb.a(r0, r3)
                goto L_0x00e1
            L_0x00b8:
                if (r6 != r0) goto L_0x00e1
                java.lang.String r0 = "VadUnit"
                java.lang.String r3 = "vad_eos found."
                com.iflytek.cloud.thirdparty.cb.a(r0, r3)
                int r0 = r13.a()
                long r8 = (long) r0
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                long r10 = r0.v
                long r8 = r8 / r10
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                long r10 = r0.u
                long r10 = r10 + r8
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r3 = "frame_eos"
                com.iflytek.cloud.thirdparty.ab r8 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r8 = r8.o
                r0.a((long) r10, (java.lang.String) r3, (java.lang.String) r8)
            L_0x00e1:
                boolean r0 = r12.d
                if (r0 != 0) goto L_0x00e6
                return
            L_0x00e6:
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.ab r3 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.t r3 = r3.b
                com.iflytek.cloud.thirdparty.af r3 = r3.a()
                android.os.Message r3 = android.os.Message.obtain(r3, r4, r6, r2)
                r0.a((android.os.Message) r3)
                java.lang.String r0 = "stream_id"
                com.iflytek.cloud.thirdparty.ab r3 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r3 = r3.o
                r13.a(r0, r3, r7)
                java.lang.String r0 = "confidence"
                r3 = 0
                java.lang.String r3 = java.lang.String.valueOf(r3)
                r13.a(r0, r3, r7)
                int r0 = r13.c
                if (r5 == r0) goto L_0x013d
                r13.c = r6
                r12.b(r13)
                com.iflytek.cloud.thirdparty.y r0 = new com.iflytek.cloud.thirdparty.y
                byte[] r3 = new byte[r2]
                java.lang.String r4 = ""
                r0.<init>((byte[]) r3, (java.lang.String) r4)
                r0.c = r5
                java.lang.String r3 = "stream_id"
                com.iflytek.cloud.thirdparty.ab r4 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r4 = r4.o
                r0.a(r3, r4, r7)
                java.lang.String r3 = "confidence"
                float r1 = r1.confidence
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r0.a(r3, r1, r7)
                r12.b(r0)
                goto L_0x00a1
            L_0x013d:
                r12.b(r13)
                goto L_0x00a1
            L_0x0142:
                boolean r0 = r12.d
                if (r0 != 0) goto L_0x01db
                r12.d = r7
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.t r1 = r1.b
                com.iflytek.cloud.thirdparty.af r1 = r1.a()
                android.os.Message r1 = android.os.Message.obtain(r1, r4, r2, r2)
                r0.a((android.os.Message) r1)
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                long r0 = r0.u
                com.iflytek.cloud.thirdparty.aa r2 = r12.b
                long r2 = r2.c()
                com.iflytek.cloud.thirdparty.ab r4 = com.iflytek.cloud.thirdparty.ab.this
                long r4 = r4.v
                long r2 = r2 / r4
                long r0 = r0 - r2
                com.iflytek.cloud.thirdparty.ab r2 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r3 = "audio"
                java.lang.String r3 = com.iflytek.cloud.thirdparty.al.a(r3)
                java.lang.String unused = r2.o = r3
                com.iflytek.cloud.thirdparty.aa r2 = r12.b
                com.iflytek.cloud.thirdparty.y r2 = r2.b()
                r2.c = r7
                java.lang.String r3 = "stream_id"
                com.iflytek.cloud.thirdparty.ab r4 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r4 = r4.o
                r2.a(r3, r4, r7)
                int r3 = r2.a()
                if (r3 <= 0) goto L_0x01af
                java.lang.String r4 = "VadUnit"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r8 = "audio before bos, length="
                r5.append(r8)
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                com.iflytek.cloud.thirdparty.cb.a(r4, r3)
                r12.b(r2)
                r13.c = r6
                goto L_0x01b1
            L_0x01af:
                r13.c = r7
            L_0x01b1:
                com.iflytek.cloud.thirdparty.ab r2 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r3 = "frame_bos"
                com.iflytek.cloud.thirdparty.ab r4 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r4 = r4.o
                r2.a((long) r0, (java.lang.String) r3, (java.lang.String) r4)
                java.lang.String r0 = "VadUnit"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "vad_bos found, stmid="
                r1.append(r2)
                com.iflytek.cloud.thirdparty.ab r2 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r2 = r2.o
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.iflytek.cloud.thirdparty.cb.a(r0, r1)
                goto L_0x01ea
            L_0x01db:
                java.lang.String r0 = "VadUnit"
                java.lang.String r1 = "sub vad_bos found."
                com.iflytek.cloud.thirdparty.cb.a(r0, r1)
                goto L_0x01e8
            L_0x01e3:
                boolean r0 = r12.d
                if (r0 != 0) goto L_0x01e8
                goto L_0x01f8
            L_0x01e8:
                r13.c = r6
            L_0x01ea:
                java.lang.String r0 = "stream_id"
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this
                java.lang.String r1 = r1.o
                r13.a(r0, r1, r7)
                r12.b(r13)
            L_0x01f8:
                com.iflytek.cloud.thirdparty.ab r0 = com.iflytek.cloud.thirdparty.ab.this
                com.iflytek.cloud.thirdparty.ab r1 = com.iflytek.cloud.thirdparty.ab.this
                long r1 = r1.u
                int r3 = r13.a()
                long r3 = (long) r3
                com.iflytek.cloud.thirdparty.ab r5 = com.iflytek.cloud.thirdparty.ab.this
                long r5 = r5.v
                long r3 = r3 / r5
                long r1 = r1 + r3
                long unused = r0.u = r1
                com.iflytek.cloud.thirdparty.aa r0 = r12.b
                r0.a(r13)
                return
            L_0x0216:
                r13 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0216 }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ab.a.c(com.iflytek.cloud.thirdparty.y):void");
        }

        public void a() {
            for (int i = 1; i < 3; i++) {
                removeMessages(i);
            }
        }

        public void b() {
            if (this.b != null) {
                this.b.d();
            }
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    y yVar = (y) message.obj;
                    String a2 = al.a();
                    if (!TextUtils.isEmpty(a2)) {
                        yVar.a("wake_id", a2, false);
                    }
                    if (!this.c || ab.this.z) {
                        a(yVar);
                    } else {
                        c(yVar);
                    }
                    ab.this.p.a(yVar.a, false);
                    if (ab.this.r != null) {
                        try {
                            ab.this.r.a(yVar.a, false);
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    y yVar2 = new y(new byte[0], "");
                    yVar2.c = 4;
                    yVar2.a("stream_id", ab.this.o, true);
                    b(yVar2);
                    return;
                default:
                    return;
            }
        }
    }

    public ab(t tVar) {
        super("VadUnit", tVar);
        this.l.setPriority(10);
        this.l.start();
    }

    private int a(boolean z2) {
        long j2;
        if (this.c) {
            cb.a("VadUnit", "VadUnit is already started.");
            return 0;
        }
        h();
        if (this.n == null) {
            Log.e("VadUnit", "VadUnit start failed, VadDetector is null.");
            return -1;
        }
        if (z2) {
            this.u = 0;
            i();
        }
        this.m = new a(this.l.getLooper(), this.e);
        if (16000 == this.d) {
            this.t = new z(1280);
            j2 = 320;
        } else {
            if (8000 == this.d) {
                this.t = new z(640);
                j2 = 160;
            }
            cb.a("VadUnit", "VadUnit started, vad_engine=" + this.f);
            this.c = true;
            return 0;
        }
        this.v = j2;
        cb.a("VadUnit", "VadUnit started, vad_engine=" + this.f);
        this.c = true;
        return 0;
    }

    /* access modifiers changed from: private */
    public void a(long j2, String str, String str2) {
        try {
            this.q.a((j2 + " " + str + " " + str2 + "\n").getBytes("utf-8"), true);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(String str) {
        if (this.y == null) {
            return false;
        }
        this.y.b(str);
        return this.y.g(AIUIConstant.KEY_AUDIO_ENCODE) && this.y.e(AIUIConstant.KEY_AUDIO_ENCODE).equals(AIUIConstant.AUDIO_ICO_ENCODE);
    }

    private void b(boolean z2) {
        synchronized (this) {
            if (this.c) {
                this.c = false;
                a(this.u, "force_eos", "");
                if (z2) {
                    this.p.c();
                    this.q.c();
                    if (this.r != null) {
                        this.r.f();
                    }
                }
                if (this.m != null) {
                    this.m.a();
                    this.m.obtainMessage(2).sendToTarget();
                }
                if (this.n != null) {
                    this.n.destroy();
                }
                if (this.t != null) {
                    this.t.a();
                }
                cb.a("VadUnit", "VadUnit stopped.");
            }
        }
    }

    private void h() {
        Context b;
        ResourceUtil.RESOURCE_TYPE resource_type;
        e();
        ce d2 = ac.d("vad");
        if (d2 == null) {
            d2 = new ce();
        }
        this.k = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
        this.f = d2.b("engine_type", this.f);
        d2.d("engine_type");
        this.d = ac.a("iat", "sample_rate", 16000);
        this.g = ac.a("vad", "threshold", this.g);
        d2.a("sample_rate", this.d + "", false);
        d2.a(AudioDetector.VAD_ENGINE, this.f, false);
        this.h = d2.b("vad_bos", this.h);
        this.i = d2.b("vad_eos", this.i);
        String e2 = d2.e(AIUIConstant.KEY_RES_TYPE);
        if (!TextUtils.isEmpty(e2)) {
            String e3 = d2.e(AIUIConstant.KEY_RES_PATH);
            String str = "";
            if (AIUIConstant.RES_TYPE_PATH.equals(e2)) {
                b = this.b.b();
                resource_type = ResourceUtil.RESOURCE_TYPE.path;
            } else {
                if (AIUIConstant.RES_TYPE_ASSETS.equals(e2)) {
                    b = this.b.b();
                    resource_type = ResourceUtil.RESOURCE_TYPE.assets;
                }
                d2.d(AIUIConstant.KEY_RES_PATH);
                d2.a(AudioDetector.RES_PATH, str, true);
            }
            str = ResourceUtil.generateResourcePath(b, resource_type, e3);
            d2.d(AIUIConstant.KEY_RES_PATH);
            d2.a(AudioDetector.RES_PATH, str, true);
        }
        this.n = AudioDetector.createDetector(this.b.b(), d2.toString());
        this.y = new ce();
        j();
    }

    private void i() {
        this.p.b();
        this.p.a("all", ".pcm", true);
        this.q.b();
        this.q.a("vad_pos", ".txt", true);
        String a2 = ac.a("log", "allpcm_copy_path", "");
        if (AIUISetting.getSaveDataLog() && !TextUtils.isEmpty(a2)) {
            this.r = ak.a(a2);
            ak.a aVar = this.r;
            aVar.a(FocusType.wake + aj.d() + "-all", ".pcm", true);
        }
    }

    private void j() {
        if (this.n != null) {
            this.n.setParameter("vad_bos", this.h);
            this.n.setParameter("vad_eos", this.i);
            this.n.setParameter("threshold", this.g);
            this.n.setParameter(AudioDetector.REDUCE_FLOW, "0");
        }
    }

    public void a(v vVar) {
        this.x = vVar;
    }

    public void a(x xVar) {
        this.w = xVar;
    }

    public void a(byte[] bArr, String str, int i2, int i3, int i4) {
        if (bArr == null) {
            Log.e("VadUnit", "audio is null.");
        } else if (!this.c || this.m == null) {
            cb.a("VadUnit", "write before start.");
            y yVar = new y(bArr, str);
            yVar.c = i2;
            this.s.a(yVar);
        } else {
            this.z = a(str);
            Log.d("VadUnit", "mIsIcoEncode: " + this.z);
            if (this.z || bArr.length == 0 || bArr.length == 1280) {
                y yVar2 = new y(bArr, str);
                yVar2.c = i2;
                Message.obtain(this.m, 1, yVar2).sendToTarget();
                if (4 == i2 && this.t != null) {
                    this.t.a();
                    Log.d("VadUnit", "AudioFrameBuffer clear");
                    return;
                }
                return;
            }
            if (0 != this.s.c()) {
                cb.a("VadUnit", "audio before start, length=" + this.s.c());
                y b = this.s.b();
                if (this.t != null) {
                    this.t.a(b.a, b.a());
                }
            }
            if (this.t != null) {
                this.t.a(bArr, bArr.length);
                while (true) {
                    byte[] a2 = this.t.a(1);
                    if (a2 != null) {
                        y yVar3 = new y(a2, str);
                        yVar3.c = i2;
                        Message.obtain(this.m, 1, yVar3).sendToTarget();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean a() {
        return this.e != ac.a("vad", "vad_enable", true);
    }

    public int b() {
        return a(true);
    }

    public void c() {
        b(true);
    }

    public void d() {
        b(true);
        a(false);
        cb.a("VadUnit", "VadUnit reset.");
    }

    public void e() {
        this.e = ac.a("vad", "vad_enable", true);
        this.j = ac.a("speech", AIUIConstant.KEY_WORK_MODE, AIUIConstant.WORK_MODE_INTENT);
        this.k = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
    }

    public void f() {
        b(true);
        if (this.l != null) {
            this.l.quit();
        }
    }

    public void g() {
        if (this.m != null) {
            this.m.b();
        }
    }
}
