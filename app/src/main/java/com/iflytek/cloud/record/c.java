package com.iflytek.cloud.record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.thirdparty.cb;

public class c {
    /* access modifiers changed from: private */
    public boolean A = false;
    private boolean B = false;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public Handler D = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (c.this.f != null) {
                        c.this.f.a((SpeechError) message.obj);
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (c.this.f != null) {
                        c.this.f.a();
                        return;
                    }
                    return;
                case 2:
                    if (c.this.f != null) {
                        c.this.f.b();
                        return;
                    }
                    return;
                case 3:
                    if (c.this.f != null) {
                        c.this.f.a(message.arg1, message.arg2, c.this.C);
                        return;
                    }
                    return;
                case 4:
                    if (c.this.f != null) {
                        c.this.f.c();
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            a unused = c.this.f = null;
        }
    };
    AudioManager.OnAudioFocusChangeListener a = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            if (i == -2 || i == -3 || i == -1) {
                cb.a("PcmPlayer", "pause start");
                if (c.this.c()) {
                    cb.a("PcmPlayer", "pause success");
                    boolean unused = c.this.l = true;
                    if (c.this.f != null) {
                        c.this.f.a();
                    }
                }
            } else if (i == 1) {
                cb.a("PcmPlayer", "resume start");
                if (c.this.l) {
                    boolean unused2 = c.this.l = false;
                    if (c.this.d()) {
                        cb.a("PcmPlayer", "resume success");
                        if (c.this.f != null) {
                            c.this.f.b();
                        }
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public AudioTrack b = null;
    /* access modifiers changed from: private */
    public b c = null;
    /* access modifiers changed from: private */
    public Context d = null;
    /* access modifiers changed from: private */
    public b e = null;
    /* access modifiers changed from: private */
    public a f = null;
    /* access modifiers changed from: private */
    public volatile int g = 0;
    /* access modifiers changed from: private */
    public int h = 3;
    /* access modifiers changed from: private */
    public boolean i = true;
    private int j;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    private Object m = new Object();
    /* access modifiers changed from: private */
    public Object n = this;
    private final int o = 2;
    private final int p = 500;
    private final int q = 50;
    /* access modifiers changed from: private */
    public int r = 1600;
    private final float s = 1.0f;
    private final float t = 0.0f;
    private final float u = 0.1f;
    /* access modifiers changed from: private */
    public int v = (this.r * 10);
    private float w = 0.0f;
    /* access modifiers changed from: private */
    public float x = 1.0f;
    private float y = 0.1f;
    /* access modifiers changed from: private */
    public boolean z = false;

    public interface a {
        void a();

        void a(int i, int i2, int i3);

        void a(SpeechError speechError);

        void b();

        void c();
    }

    private class b extends Thread {
        private int b;

        private b() {
            this.b = c.this.h;
        }

        public int a() {
            return this.b;
        }

        public void a(int i) {
            this.b = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:113:0x02d4, code lost:
            if (com.iflytek.cloud.record.c.d(r9.a) == false) goto L_0x02ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x02d6, code lost:
            com.iflytek.cloud.thirdparty.bw.b(com.iflytek.cloud.record.c.e(r9.a), java.lang.Boolean.valueOf(com.iflytek.cloud.record.c.f(r9.a)), r9.a.a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x02ee, code lost:
            com.iflytek.cloud.thirdparty.bw.b(com.iflytek.cloud.record.c.e(r9.a), java.lang.Boolean.valueOf(com.iflytek.cloud.record.c.f(r9.a)), (android.media.AudioManager.OnAudioFocusChangeListener) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0301, code lost:
            com.iflytek.cloud.record.c.a(r9.a, (com.iflytek.cloud.record.c.b) null);
            com.iflytek.cloud.thirdparty.cb.a("PcmPlayer", "player stopped");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x030d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x025b, code lost:
            if (com.iflytek.cloud.record.c.d(r9.a) != false) goto L_0x02d6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                r0 = 0
                r1 = 4
                r2 = 0
                java.lang.String r3 = "PcmPlayer"
                java.lang.String r4 = "start player"
                com.iflytek.cloud.thirdparty.cb.a(r3, r4)     // Catch:{ Exception -> 0x0293 }
                java.lang.String r3 = "PcmPlayer"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0293 }
                r4.<init>()     // Catch:{ Exception -> 0x0293 }
                java.lang.String r5 = "mAudioFocus= "
                r4.append(r5)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r5 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r5 = r5.i     // Catch:{ Exception -> 0x0293 }
                r4.append(r5)     // Catch:{ Exception -> 0x0293 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.thirdparty.cb.a(r3, r4)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.i     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x0046
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.content.Context r3 = r3.d     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r4 = r4.k     // Catch:{ Exception -> 0x0293 }
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r5 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioManager$OnAudioFocusChangeListener r5 = r5.a     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.thirdparty.bw.a(r3, r4, r5)     // Catch:{ Exception -> 0x0293 }
                goto L_0x0059
            L_0x0046:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.content.Context r3 = r3.d     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r4 = r4.k     // Catch:{ Exception -> 0x0293 }
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.thirdparty.bw.a(r3, r4, r2)     // Catch:{ Exception -> 0x0293 }
            L_0x0059:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                r3.c()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                java.lang.Object r3 = r3.n     // Catch:{ Exception -> 0x0293 }
                monitor-enter(r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x028d }
                int r4 = r4.g     // Catch:{ all -> 0x028d }
                r5 = 3
                r6 = 2
                if (r4 == r1) goto L_0x0080
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x028d }
                int r4 = r4.g     // Catch:{ all -> 0x028d }
                if (r4 == r5) goto L_0x0080
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x028d }
                int unused = r4.g = r6     // Catch:{ all -> 0x028d }
            L_0x0080:
                monitor-exit(r3)     // Catch:{ all -> 0x028d }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.f()     // Catch:{ Exception -> 0x0293 }
            L_0x0086:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.k()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.g     // Catch:{ Exception -> 0x0293 }
                r7 = 5
                r4 = 1
                if (r3 == r6) goto L_0x00e4
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.g     // Catch:{ Exception -> 0x0293 }
                if (r3 == r4) goto L_0x00e4
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.z     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x00a7
                goto L_0x00e4
            L_0x00a7:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.g     // Catch:{ Exception -> 0x0293 }
                if (r3 != r5) goto L_0x00d5
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.getPlayState()     // Catch:{ Exception -> 0x0293 }
                if (r6 == r3) goto L_0x00d1
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                r3.pause()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.z     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x00d1
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.i()     // Catch:{ Exception -> 0x0293 }
            L_0x00d1:
                sleep(r7)     // Catch:{ Exception -> 0x0293 }
                goto L_0x0086
            L_0x00d5:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.g     // Catch:{ Exception -> 0x0293 }
                if (r1 != r3) goto L_0x0086
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.i()     // Catch:{ Exception -> 0x0293 }
                goto L_0x0221
            L_0x00e4:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.g()     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x01f9
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.a((int) r4, (int) r6)     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x010f
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.os.Handler r3 = r3.D     // Catch:{ Exception -> 0x0293 }
                android.os.Message r3 = android.os.Message.obtain(r3, r6)     // Catch:{ Exception -> 0x0293 }
                r3.sendToTarget()     // Catch:{ Exception -> 0x0293 }
                java.lang.String r3 = "BUFFERING to PLAYING  fading "
                com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.f()     // Catch:{ Exception -> 0x0293 }
            L_0x010f:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.d()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r4 = r4.c     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b$a r4 = r4.e()     // Catch:{ Exception -> 0x0293 }
                if (r4 == 0) goto L_0x013b
                com.iflytek.cloud.record.c r7 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r8 = r4.d     // Catch:{ Exception -> 0x0293 }
                int unused = r7.C = r8     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r7 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.os.Handler r7 = r7.D     // Catch:{ Exception -> 0x0293 }
                int r4 = r4.c     // Catch:{ Exception -> 0x0293 }
                android.os.Message r3 = android.os.Message.obtain(r7, r5, r3, r4)     // Catch:{ Exception -> 0x0293 }
                r3.sendToTarget()     // Catch:{ Exception -> 0x0293 }
            L_0x013b:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.getPlayState()     // Catch:{ Exception -> 0x0293 }
                if (r3 == r5) goto L_0x0150
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                r3.play()     // Catch:{ Exception -> 0x0293 }
            L_0x0150:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.A     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x01d5
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.h()     // Catch:{ Exception -> 0x0293 }
                r4 = 1036831949(0x3dcccccd, float:0.1)
                if (r3 != 0) goto L_0x0194
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r7 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r7 = r7.v     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.b(r7)     // Catch:{ Exception -> 0x0293 }
                if (r3 != 0) goto L_0x0194
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                float r3 = r3.x     // Catch:{ Exception -> 0x0293 }
                r7 = 0
                float r3 = r3 - r7
                float r3 = java.lang.Math.abs(r3)     // Catch:{ Exception -> 0x0293 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 < 0) goto L_0x0194
                java.lang.String r3 = "no more size  fading "
                com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.g()     // Catch:{ Exception -> 0x0293 }
                goto L_0x01d5
            L_0x0194:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r3 = r3.g     // Catch:{ Exception -> 0x0293 }
                if (r6 != r3) goto L_0x01d5
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.h()     // Catch:{ Exception -> 0x0293 }
                if (r3 != 0) goto L_0x01ba
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r7 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r7 = r7.v     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.b(r7)     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x01d5
            L_0x01ba:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                float r3 = r3.x     // Catch:{ Exception -> 0x0293 }
                r7 = 1065353216(0x3f800000, float:1.0)
                float r3 = r3 - r7
                float r3 = java.lang.Math.abs(r3)     // Catch:{ Exception -> 0x0293 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 < 0) goto L_0x01d5
                java.lang.String r3 = "has buffer  fading "
                com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.f()     // Catch:{ Exception -> 0x0293 }
            L_0x01d5:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.z     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x01e2
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                r3.h()     // Catch:{ Exception -> 0x0293 }
            L_0x01e2:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r4 = r4.b     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r7 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int r7 = r7.r     // Catch:{ Exception -> 0x0293 }
                r3.a(r4, r7)     // Catch:{ Exception -> 0x0293 }
                goto L_0x0086
            L_0x01f9:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.b r3 = r3.c     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.f()     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x0262
                java.lang.String r3 = "play stoped"
                com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                int unused = r3.g = r1     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.os.Handler r3 = r3.D     // Catch:{ Exception -> 0x0293 }
                android.os.Message r3 = android.os.Message.obtain(r3, r1)     // Catch:{ Exception -> 0x0293 }
                r3.sendToTarget()     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean unused = r3.z = r0     // Catch:{ Exception -> 0x0293 }
            L_0x0221:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x0232
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.media.AudioTrack r3 = r3.b     // Catch:{ Exception -> 0x0293 }
                r3.stop()     // Catch:{ Exception -> 0x0293 }
            L_0x0232:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                java.lang.Object r0 = r0.n
                monitor-enter(r0)
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x025f }
                int unused = r3.g = r1     // Catch:{ all -> 0x025f }
                monitor-exit(r0)     // Catch:{ all -> 0x025f }
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r0 = r0.b
                if (r0 == 0) goto L_0x0255
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r0 = r0.b
                r0.release()
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack unused = r0.b = r2
            L_0x0255:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                boolean r0 = r0.i
                if (r0 == 0) goto L_0x02ee
                goto L_0x02d6
            L_0x025f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x025f }
                throw r1
            L_0x0262:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.z     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x0271
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean unused = r3.z = r0     // Catch:{ Exception -> 0x0293 }
                goto L_0x0086
            L_0x0271:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                boolean r3 = r3.a((int) r6, (int) r4)     // Catch:{ Exception -> 0x0293 }
                if (r3 == 0) goto L_0x00d1
                java.lang.String r3 = "play onpaused!"
                com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0293 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ Exception -> 0x0293 }
                android.os.Handler r3 = r3.D     // Catch:{ Exception -> 0x0293 }
                android.os.Message r3 = android.os.Message.obtain(r3, r4)     // Catch:{ Exception -> 0x0293 }
                r3.sendToTarget()     // Catch:{ Exception -> 0x0293 }
                goto L_0x00d1
            L_0x028d:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x028d }
                throw r4     // Catch:{ Exception -> 0x0293 }
            L_0x0290:
                r0 = move-exception
                goto L_0x0311
            L_0x0293:
                r3 = move-exception
                com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x0290 }
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x0290 }
                android.os.Handler r3 = r3.D     // Catch:{ all -> 0x0290 }
                com.iflytek.cloud.SpeechError r4 = new com.iflytek.cloud.SpeechError     // Catch:{ all -> 0x0290 }
                r5 = 20011(0x4e2b, float:2.8041E-41)
                r4.<init>((int) r5)     // Catch:{ all -> 0x0290 }
                android.os.Message r0 = android.os.Message.obtain(r3, r0, r4)     // Catch:{ all -> 0x0290 }
                r0.sendToTarget()     // Catch:{ all -> 0x0290 }
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                java.lang.Object r0 = r0.n
                monitor-enter(r0)
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x030e }
                int unused = r3.g = r1     // Catch:{ all -> 0x030e }
                monitor-exit(r0)     // Catch:{ all -> 0x030e }
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r0 = r0.b
                if (r0 == 0) goto L_0x02ce
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r0 = r0.b
                r0.release()
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack unused = r0.b = r2
            L_0x02ce:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                boolean r0 = r0.i
                if (r0 == 0) goto L_0x02ee
            L_0x02d6:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.content.Context r0 = r0.d
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                boolean r1 = r1.k
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this
                android.media.AudioManager$OnAudioFocusChangeListener r3 = r3.a
                com.iflytek.cloud.thirdparty.bw.b(r0, r1, r3)
                goto L_0x0301
            L_0x02ee:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                android.content.Context r0 = r0.d
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                boolean r1 = r1.k
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                com.iflytek.cloud.thirdparty.bw.b(r0, r1, r2)
            L_0x0301:
                com.iflytek.cloud.record.c r0 = com.iflytek.cloud.record.c.this
                com.iflytek.cloud.record.c.b unused = r0.e = r2
                java.lang.String r0 = "PcmPlayer"
                java.lang.String r1 = "player stopped"
                com.iflytek.cloud.thirdparty.cb.a(r0, r1)
                return
            L_0x030e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x030e }
                throw r1
            L_0x0311:
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this
                java.lang.Object r3 = r3.n
                monitor-enter(r3)
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this     // Catch:{ all -> 0x0374 }
                int unused = r4.g = r1     // Catch:{ all -> 0x0374 }
                monitor-exit(r3)     // Catch:{ all -> 0x0374 }
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r1 = r1.b
                if (r1 == 0) goto L_0x0334
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack r1 = r1.b
                r1.release()
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                android.media.AudioTrack unused = r1.b = r2
            L_0x0334:
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                boolean r1 = r1.i
                if (r1 == 0) goto L_0x0354
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                android.content.Context r1 = r1.d
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this
                boolean r3 = r3.k
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                com.iflytek.cloud.record.c r4 = com.iflytek.cloud.record.c.this
                android.media.AudioManager$OnAudioFocusChangeListener r4 = r4.a
                com.iflytek.cloud.thirdparty.bw.b(r1, r3, r4)
                goto L_0x0367
            L_0x0354:
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                android.content.Context r1 = r1.d
                com.iflytek.cloud.record.c r3 = com.iflytek.cloud.record.c.this
                boolean r3 = r3.k
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                com.iflytek.cloud.thirdparty.bw.b(r1, r3, r2)
            L_0x0367:
                com.iflytek.cloud.record.c r1 = com.iflytek.cloud.record.c.this
                com.iflytek.cloud.record.c.b unused = r1.e = r2
                java.lang.String r1 = "PcmPlayer"
                java.lang.String r2 = "player stopped"
                com.iflytek.cloud.thirdparty.cb.a(r1, r2)
                throw r0
            L_0x0374:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0374 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.record.c.b.run():void");
        }
    }

    public c(Context context) {
        this.d = context;
    }

    public c(Context context, int i2, boolean z2, boolean z3, boolean z4) {
        this.d = context;
        this.h = i2;
        this.k = z2;
        this.B = z3;
        this.A = z4;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, int i3) {
        boolean z2;
        synchronized (this.n) {
            if (i2 == this.g) {
                this.g = i3;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    private void j() throws Exception {
        cb.a("PcmPlayer", "createAudio start");
        int a2 = this.c.a();
        this.j = AudioTrack.getMinBufferSize(a2, 2, 2);
        this.r = (a2 / 1000) * 2 * 50;
        this.v = this.r * 10;
        if (this.b != null) {
            b();
        }
        cb.a("PcmPlayer", "createAudio || mStreamType = " + this.h + ", buffer size: " + this.j);
        AudioTrack audioTrack = new AudioTrack(this.h, a2, 2, 2, this.j * 2, 1);
        this.b = audioTrack;
        if (this.j == -2 || this.j == -1) {
            throw new Exception();
        }
        cb.a("PcmPlayer", "createAudio end");
    }

    /* access modifiers changed from: private */
    public void k() throws Exception {
        b bVar = this.e;
        if (this.b == null || !(bVar == null || bVar.a() == this.h)) {
            cb.a("PcmPlayer", "prepAudioPlayer || audiotrack is null or stream type is change.");
            j();
            if (bVar != null) {
                bVar.a(this.h);
            }
        }
    }

    public int a() {
        return this.g;
    }

    public boolean a(b bVar, a aVar) {
        boolean z2;
        cb.a("PcmPlayer", "play mPlaytate= " + this.g + ",mAudioFocus= " + this.i);
        synchronized (this.n) {
            if (this.g == 4 || this.g == 0 || this.g == 3 || this.e == null) {
                this.c = bVar;
                this.f = aVar;
                this.e = new b();
                this.e.start();
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public void b() {
        synchronized (this.m) {
            if (this.b != null) {
                if (this.b.getPlayState() == 3) {
                    this.b.stop();
                }
                this.b.release();
                this.b = null;
            }
            cb.a("PcmPlayer", "mAudioTrack released");
        }
    }

    public boolean c() {
        if (this.g == 4 || this.g == 3) {
            return false;
        }
        cb.a("pause start fade out");
        g();
        this.g = 3;
        return true;
    }

    public boolean d() {
        boolean a2 = a(3, 2);
        if (a2) {
            cb.a("resume start fade in");
            f();
        }
        return a2;
    }

    public void e() {
        if (4 != this.g) {
            cb.a("stop start fade out");
            g();
        }
        synchronized (this.n) {
            this.g = 4;
        }
    }

    public void f() {
        if (this.B) {
            synchronized (this.n) {
                cb.a("start fade in");
                this.z = true;
                this.x = 1.0f;
                this.y = 0.1f;
            }
        }
    }

    public void g() {
        if (this.B) {
            synchronized (this.n) {
                cb.a("start fade out");
                this.z = true;
                this.x = 0.0f;
                this.y = -0.1f;
            }
        }
    }

    public void h() {
        if (this.B) {
            synchronized (this.n) {
                if (Math.abs(this.x - this.w) < 0.1f) {
                    this.w = this.x;
                    this.z = false;
                    cb.a("fading finish");
                } else {
                    this.w += this.y;
                }
            }
            this.b.setStereoVolume(this.w, this.w);
            return;
        }
        this.z = false;
    }

    public void i() {
        cb.a("fading set silence");
        synchronized (this.n) {
            if (Math.abs(0.0f - this.x) < 0.1f) {
                this.w = 0.0f;
                this.z = false;
            }
        }
        this.b.setStereoVolume(this.w, this.w);
    }
}
