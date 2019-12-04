package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.util.AudioDetector;
import com.iflytek.msc.VAD;
import java.util.HashMap;
import java.util.Map;

public class cx extends AudioDetector {
    private static final Map<String, Integer> c = new HashMap();
    private static final Map<String, Integer> d = new HashMap();
    private ce e = new ce();
    private long f = 0;
    private AudioDetector.DetectorResult g = new AudioDetector.DetectorResult();
    private VAD.VadData h = new VAD.VadData();
    private byte[] i = new byte[32768];
    private byte[] j = new byte[32784];
    private boolean k = true;
    private int l = 2;
    private long m = -1;
    private long n = 0;

    static {
        c.put("vad_bos", 0);
        c.put("vad_eos", 1);
        c.put(AudioDetector.SUB_TIMEOUT, 3);
        c.put(AudioDetector.EARLY_START, 4);
        d.put("vad_bos", 2000);
        d.put("vad_eos", Integer.valueOf(AudioDetector.DEF_EOS));
        d.put(AudioDetector.SUB_TIMEOUT, 20000);
        d.put(AudioDetector.EARLY_START, 1);
    }

    public cx(Context context, String str) {
        super(context, str);
        cb.a("AudioDetector constructor enter, context: " + context + ", param: " + str);
        this.e.a(str);
        try {
            this.f = VAD.Initialize(this.e.a("sample_rate", 16000));
            cb.a("VAD Initialize ret: " + this.f);
        } catch (Throwable th) {
            cb.c("AudioDetector constructor exception");
            cb.a(th);
        }
        this.h.wavData = this.j;
    }

    private void a() {
        this.g.buffer = null;
        this.g.end = 0;
        this.g.error = 0;
        this.g.length = 0;
        this.g.offset = 0;
        this.g.quality = 0;
        this.g.start = 0;
        this.g.status = 0;
        this.g.sub = 0;
        this.g.voice = false;
        this.g.volume = 0;
        this.h.audioQuality = 0;
        this.h.endByte = 0;
        this.h.endRemainFrameNum = 0;
        this.h.firstOutByte = 0;
        this.h.inSpeech = 0;
        this.h.startByte = 0;
        this.h.startRemainFrameNum = 0;
        this.h.status = 0;
        this.h.volumeLevel = 0;
        this.h.waitPauseOrEnd = 0;
        this.h.waitStart = 0;
        this.h.wavData = this.j;
        this.h.wavDataSize = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r4.g.status = 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x002b
            r2 = 2
            r3 = 3
            switch(r5) {
                case 5: goto L_0x0026;
                case 6: goto L_0x0021;
                case 7: goto L_0x001c;
                case 8: goto L_0x0017;
                case 9: goto L_0x0013;
                case 10: goto L_0x000e;
                case 11: goto L_0x002b;
                default: goto L_0x0009;
            }
        L_0x0009:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r4.g
            r2.error = r5
            goto L_0x002f
        L_0x000e:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.status = r3
            goto L_0x002f
        L_0x0013:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.sub = r3
        L_0x0017:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.status = r2
            goto L_0x002f
        L_0x001c:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.sub = r3
            goto L_0x002f
        L_0x0021:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.sub = r2
            goto L_0x002f
        L_0x0026:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.sub = r1
            goto L_0x002f
        L_0x002b:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.error = r0
        L_0x002f:
            boolean r5 = r4.k
            if (r5 == 0) goto L_0x0045
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            int r5 = r5.sub
            if (r5 == 0) goto L_0x0045
            r4.k = r0
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            int r5 = r5.status
            if (r5 != 0) goto L_0x0045
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r5.status = r1
        L_0x0045:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            int r5 = r5.status
            if (r5 != 0) goto L_0x0056
            boolean r5 = r4.c()
            if (r5 == 0) goto L_0x0056
            com.iflytek.cloud.util.AudioDetector$DetectorResult r5 = r4.g
            r0 = 4
            r5.status = r0
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cx.a(int):void");
    }

    private void b() {
        this.g.buffer = this.h.wavData;
        this.g.end = this.h.endByte;
        this.g.length = this.h.wavDataSize;
        boolean z = false;
        this.g.offset = 0;
        this.g.quality = this.h.audioQuality;
        this.g.start = this.h.startByte;
        AudioDetector.DetectorResult detectorResult = this.g;
        if (1 == this.h.inSpeech) {
            z = true;
        }
        detectorResult.voice = z;
        this.g.volume = this.h.volumeLevel;
    }

    private boolean c() {
        return 0 < this.m && this.m <= this.n;
    }

    public boolean destroy() {
        boolean z;
        cb.a("destroy enter");
        synchronized (b) {
            if (0 != this.f) {
                try {
                    VAD.Uninitialize(this.f);
                    cb.a("VAD Uninitialize");
                    this.f = 0;
                } catch (Throwable th) {
                    cb.c("destroy exception");
                    cb.a(th);
                    z = false;
                }
            }
            z = true;
        }
        a = null;
        cb.a("destroy leave");
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0145, code lost:
        if (r5.g.error == 0) goto L_0x0147;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.iflytek.cloud.util.AudioDetector.DetectorResult detect(byte[] r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d1 }
            r1.<init>()     // Catch:{ all -> 0x01d1 }
            java.lang.String r2 = "detect enter, buffer: "
            r1.append(r2)     // Catch:{ all -> 0x01d1 }
            r1.append(r6)     // Catch:{ all -> 0x01d1 }
            java.lang.String r2 = ", offset: "
            r1.append(r2)     // Catch:{ all -> 0x01d1 }
            r1.append(r7)     // Catch:{ all -> 0x01d1 }
            java.lang.String r2 = ", length: "
            r1.append(r2)     // Catch:{ all -> 0x01d1 }
            r1.append(r8)     // Catch:{ all -> 0x01d1 }
            java.lang.String r2 = ", isLast: "
            r1.append(r2)     // Catch:{ all -> 0x01d1 }
            r1.append(r9)     // Catch:{ all -> 0x01d1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d1 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r1)     // Catch:{ all -> 0x01d1 }
            r5.a()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r1 = 0
            long r3 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0047
            java.lang.String r6 = "detect error: handle is invalid!"
            com.iflytek.cloud.thirdparty.cb.c(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7 = 21003(0x520b, float:2.9431E-41)
            r6.error = r7     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            goto L_0x01c8
        L_0x0047:
            if (r6 == 0) goto L_0x014c
            if (r8 <= 0) goto L_0x014c
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r1 < r8) goto L_0x014c
            if (r7 < 0) goto L_0x014c
            int r1 = r6.length     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r1 = r1 - r7
            if (r1 >= r8) goto L_0x0058
            goto L_0x014c
        L_0x0058:
            byte[] r1 = r5.i     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r2 = 0
            java.lang.System.arraycopy(r6, r7, r1, r2, r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r6.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = "buffer length: "
            r6.append(r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r6.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            byte[] r1 = r5.i     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.msc.VAD$VadData r2 = r5.h     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.CalcVolumLevel(r6, r1, r8, r2)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r1 = "VAD CalcVolumLevel ret: "
            r7.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r7 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.error = r6     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            byte[] r1 = r5.i     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.AppendData(r6, r1, r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r1 = "VAD AppendData ret: "
            r7.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            boolean r7 = r5.k     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r7 != 0) goto L_0x00c0
            long r1 = r5.n     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            long r7 = (long) r8     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            long r1 = r1 + r7
            r5.n = r1     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
        L_0x00c0:
            r5.a(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.msc.VAD$VadData r8 = r5.h     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.FetchData(r6, r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r8 = "VAD FetchData ret: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r5.a(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
            r6 = 2
            com.iflytek.cloud.util.AudioDetector$DetectorResult r7 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r7 = r7.status     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 == r7) goto L_0x00fe
            r6 = 3
            com.iflytek.cloud.util.AudioDetector$DetectorResult r7 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r7 = r7.status     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 == r7) goto L_0x00fe
            if (r9 == 0) goto L_0x0141
        L_0x00fe:
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.EndAudioData(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r8 = "VAD EndAudioData ret: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r5.a(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x0141
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.msc.VAD$VadData r8 = r5.h     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.GetLastSpeechPos(r6, r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r8 = "VAD GetLastSpeechPos ret: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r7 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.error = r6     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
        L_0x0141:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
        L_0x0147:
            r5.b()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            goto L_0x01c8
        L_0x014c:
            if (r9 == 0) goto L_0x019c
            long r6 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = com.iflytek.msc.VAD.EndAudioData(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r8 = "VAD EndAudioData ret: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r5.a(r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            long r7 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.msc.VAD$VadData r9 = r5.h     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r7 = com.iflytek.msc.VAD.GetLastSpeechPos(r7, r9)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r6.error = r7     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r6.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r7 = "VAD GetLastSpeechPos ret: "
            r6.append(r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r7 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r7 = r7.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r6.append(r7)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r6)     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            int r6 = r6.error     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            if (r6 != 0) goto L_0x01c8
            goto L_0x0147
        L_0x019c:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            r7 = 20012(0x4e2c, float:2.8043E-41)
            r6.error = r7     // Catch:{ UnsatisfiedLinkError -> 0x01b6, Throwable -> 0x01a3 }
            goto L_0x01c8
        L_0x01a3:
            r6 = move-exception
            java.lang.String r7 = "detect exception"
            com.iflytek.cloud.thirdparty.cb.c(r7)     // Catch:{ all -> 0x01d1 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x01d1 }
            r5.a()     // Catch:{ all -> 0x01d1 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ all -> 0x01d1 }
            r7 = 20999(0x5207, float:2.9426E-41)
            r6.error = r7     // Catch:{ all -> 0x01d1 }
            goto L_0x01c8
        L_0x01b6:
            r6 = move-exception
            java.lang.String r7 = "detect exception"
            com.iflytek.cloud.thirdparty.cb.c(r7)     // Catch:{ all -> 0x01d1 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x01d1 }
            r5.a()     // Catch:{ all -> 0x01d1 }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g     // Catch:{ all -> 0x01d1 }
            r7 = 20021(0x4e35, float:2.8055E-41)
            r6.error = r7     // Catch:{ all -> 0x01d1 }
        L_0x01c8:
            monitor-exit(r0)     // Catch:{ all -> 0x01d1 }
            java.lang.String r6 = "detect leave"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r6)
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.g
            return r6
        L_0x01d1:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01d1 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cx.detect(byte[], int, int, boolean):com.iflytek.cloud.util.AudioDetector$DetectorResult");
    }

    public void reset() {
        cb.a("reset enter");
        synchronized (b) {
            if (0 != this.f) {
                try {
                    VAD.Reset(this.f);
                    cb.a("VAD Reset");
                    this.k = true;
                    this.n = 0;
                } catch (Throwable th) {
                    cb.c("reset exception");
                    cb.a(th);
                }
            }
        }
        cb.a("reset leave");
    }

    public void setParameter(String str, String str2) {
        String str3;
        long j2;
        cb.a("setParameter enter, key: " + str + ", value: " + str2);
        synchronized (b) {
            try {
                if (!TextUtils.isEmpty(str) && c.containsKey(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.e.a(str, str2);
                    } else {
                        this.e.d(str);
                    }
                    int a = this.e.a(str, d.get(str).intValue());
                    int SetParam = VAD.SetParam(this.f, c.get(str).intValue(), a);
                    str3 = "VAD SetParameter key=" + r6 + ", value=" + a + ", ret: " + SetParam;
                } else if (SpeechConstant.KEY_SPEECH_TIMEOUT.equalsIgnoreCase(str)) {
                    try {
                        j2 = Long.parseLong(str2);
                    } catch (NumberFormatException unused) {
                        j2 = -1;
                    }
                    cb.a("SetParameter speech timeout value:" + j2);
                    if (0 < j2) {
                        this.m = (((long) (this.e.a("sample_rate", 16000) * this.l)) * j2) / 1000;
                        str3 = "SetParameter BytesOfSpeechTimeout: " + this.m;
                    } else {
                        this.m = -1;
                    }
                } else {
                    int SetParam2 = VAD.SetParam(this.f, Integer.parseInt(str), Integer.parseInt(str2));
                    str3 = "VAD SetParameter key=" + r6 + ", value=" + r7 + ", ret: " + SetParam2;
                }
                cb.a(str3);
            } catch (Throwable th) {
                cb.c("setParameter exception");
                cb.a(th);
            }
        }
        cb.a("setParameter leave.");
    }
}
