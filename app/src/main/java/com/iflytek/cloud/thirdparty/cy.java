package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.util.AudioDetector;
import com.iflytek.msc.MetaVAD;
import java.util.HashMap;
import java.util.Map;

public class cy extends AudioDetector {
    private static final Map<String, String> c = new HashMap();
    private static final Map<String, String> d = new HashMap();
    private ce e = new ce();
    private final AudioDetector.DetectorResult f = new AudioDetector.DetectorResult();
    private MetaVAD.Instance g = new MetaVAD.Instance();
    private String h = "gb2312";
    private boolean i = false;
    private boolean j = true;
    private int k = 0;
    private int l = 0;
    private int m = 2;
    private long n = -1;
    private long o = 0;

    static {
        c.put("vad_bos", "vad_starttimeout");
        c.put("vad_eos", "vad_endtimeout");
        c.put("threshold", "vad_threshold");
        d.put("vad_bos", String.valueOf(2000));
        d.put("vad_eos", String.valueOf(AudioDetector.DEF_EOS));
        d.put("threshold", String.valueOf(0.6f));
    }

    public cy(Context context, String str) {
        super(context, str);
        cb.a("Meta VAD AudioDetector constructor enter, context: " + context + ", param: " + str);
        this.e.a(str);
        try {
            this.h = this.e.b(SpeechConstant.TEXT_ENCODING, this.h);
            String e2 = this.e.e("extra");
            byte[] bArr = null;
            byte[] a = e2 != null ? bt.a(e2, this.h) : null;
            cb.a("MetaVAD.VADInitialize begin.");
            int VADInitialize = MetaVAD.VADInitialize(a);
            if (VADInitialize == 0) {
                this.g.rate = this.e.a("sample_rate", 16000);
                String e3 = this.e.e(AudioDetector.RES_PATH);
                bArr = e3 != null ? bt.a(e3, this.h) : bArr;
                cb.a("MetaVAD.VADLoadResource begin.");
                VADInitialize = MetaVAD.VADLoadResource(this.g.rate, bArr);
                if (VADInitialize == 0) {
                    cb.a("MetaVAD.VADCreateSession begin.");
                    VADInitialize = MetaVAD.VADCreateSession(this.g);
                }
            }
            if (VADInitialize != 0) {
                cb.c("MetaVAD Native error " + VADInitialize);
            }
        } catch (Throwable th) {
            cb.c("Meta VAD AudioDetector constructor exception:");
            cb.a(th);
        }
        cb.a("Meta VAD AudioDetector constructor leave");
    }

    private void a() {
        this.f.buffer = null;
        this.f.end = 0;
        this.f.error = 0;
        this.f.length = 0;
        this.f.offset = 0;
        this.f.quality = 0;
        this.f.start = 0;
        this.f.status = 0;
        this.f.sub = 0;
        this.f.subs.clear();
        this.f.voice = false;
        this.f.volume = 0;
        this.f.confidence = 1.0f;
        if (this.g != null) {
            this.g.a();
        }
        this.k = 0;
    }

    private void a(int i2) {
        int i3 = 2;
        switch (i2) {
            case 0:
            case 6:
                this.f.error = 0;
                this.g.seg = 0;
                break;
            case 1:
            case 2:
                this.f.sub = 1;
                break;
            case 3:
                this.f.sub = 2;
                break;
            case 4:
                AudioDetector.DetectorResult detectorResult = this.f;
                if (!this.i) {
                    i3 = 3;
                }
                detectorResult.status = i3;
                break;
            case 5:
                this.f.sub = 3;
                break;
            default:
                this.f.error = i2;
                break;
        }
        if (!this.i && this.f.sub != 0) {
            this.i = true;
            if (this.f.status == 0) {
                this.f.status = 1;
            }
        }
        if (this.f.status == 0 && c()) {
            this.f.status = 4;
        }
    }

    private void b() {
        if (this.g.seg != 0) {
            Integer num = (Integer) this.f.subs.put(Integer.valueOf(this.g.begin), Integer.valueOf(this.g.end));
            if (num != null) {
                cb.c("update result error: repeat sub begin: " + num);
                int i2 = this.k + 1;
                this.k = i2;
                if (10 <= i2) {
                    this.f.error = 10100;
                    cb.c("update result error: repeat sub reach max count.");
                }
            }
            this.f.sub = 3;
            if (1 == this.g.seg || (this.j && 3 == this.g.seg)) {
                this.f.start = this.g.begin;
                this.l = this.f.start;
            }
            if (3 == this.g.seg) {
                this.f.end = this.g.end;
                this.f.start = this.l;
                this.f.confidence = MetaVAD.VADGetSentConfidence(this.g);
            }
            this.j = false;
        }
        this.f.quality = 0;
        this.f.voice = false;
        this.f.volume = this.g.volume * 4;
    }

    private boolean c() {
        return 0 < this.n && this.n <= this.o;
    }

    public boolean destroy() {
        boolean z;
        int i2;
        cb.a("destroy enter");
        synchronized (b) {
            z = false;
            try {
                boolean z2 = true;
                if (this.g != null) {
                    if (0 != this.g.handle) {
                        cb.a("destroy MetaVAD.VADDestroySession begin");
                        i2 = MetaVAD.VADDestroySession(this.g);
                        cb.a("destroy MetaVAD.VADDestroySession ret=" + i2);
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        this.g.handle = 0;
                        cb.a("destroy MetaVAD.VADDelResource begin");
                        int VADDelResource = MetaVAD.VADDelResource(this.g.rate);
                        cb.a("destroy MetaVAD.VADDelResource ret=" + VADDelResource);
                        cb.a("destroy MetaVAD.VADUninitialize begin");
                        i2 = MetaVAD.VADUninitialize();
                        cb.a("destroy MetaVAD.VADUninitialize ret=" + i2);
                    }
                    if (i2 != 0) {
                        z2 = false;
                    }
                    if (z2) {
                        this.g = null;
                        a = null;
                    }
                }
                z = z2;
            } catch (Throwable th) {
                cb.c("destroy exception:");
                cb.a(th);
            }
        }
        cb.a("destroy leave: " + z);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0114, code lost:
        com.iflytek.cloud.thirdparty.cb.a("detect get last seg or error.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080 A[Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.iflytek.cloud.util.AudioDetector.DetectorResult detect(byte[] r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "detect enter, buffer: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ", offset: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", length: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ", isLast: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r0)
            java.lang.Object r0 = b
            monitor-enter(r0)
            r5.a()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.msc.MetaVAD$Instance r1 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r1 == 0) goto L_0x006f
            r1 = 0
            com.iflytek.msc.MetaVAD$Instance r3 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            long r3 = r3.handle     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0041
            goto L_0x006f
        L_0x0041:
            if (r6 == 0) goto L_0x0066
            if (r8 <= 0) goto L_0x0066
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r1 < r8) goto L_0x0066
            if (r7 < 0) goto L_0x0066
            int r1 = r6.length     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r1 = r1 - r7
            if (r1 >= r8) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r1.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r2 = "detect buffer length: "
            r1.append(r2)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r1.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            goto L_0x007a
        L_0x0066:
            if (r9 != 0) goto L_0x007a
            com.iflytek.cloud.util.AudioDetector$DetectorResult r1 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2 = 20012(0x4e2c, float:2.8043E-41)
            r1.error = r2     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            goto L_0x007a
        L_0x006f:
            java.lang.String r1 = "detect error: vad instance null, or handle is invalid!"
            com.iflytek.cloud.thirdparty.cb.c(r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r1 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2 = 21003(0x520b, float:2.9431E-41)
            r1.error = r2     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
        L_0x007a:
            com.iflytek.cloud.util.AudioDetector$DetectorResult r1 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r1 = r1.error     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r1 != 0) goto L_0x0141
            com.iflytek.msc.MetaVAD$Instance r1 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r9 = com.iflytek.msc.MetaVAD.VADAppendPCM(r1, r6, r7, r8, r9)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r1.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r2 = "MetaVAD VADAppendPCM ret: "
            r1.append(r2)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r1.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            boolean r1 = r5.i     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r1 == 0) goto L_0x00a4
            long r1 = r5.o     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            long r3 = (long) r8     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            long r1 = r1 + r3
            r5.o = r1     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
        L_0x00a4:
            r5.a(r9)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r9 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r9 = r9.error     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r9 != 0) goto L_0x0141
            r9 = 5
            r1 = r9
        L_0x00af:
            if (r9 != r1) goto L_0x0141
            com.iflytek.msc.MetaVAD$Instance r1 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r1 = com.iflytek.msc.MetaVAD.VADGetSeg(r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r3 = "MetaVAD VADGetSeg ret: "
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r3 = ", seg status: "
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.msc.MetaVAD$Instance r3 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r3 = r3.seg     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r3 = ", seg begin: "
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.msc.MetaVAD$Instance r3 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r3 = r3.begin     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r3 = ", seg end: "
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.msc.MetaVAD$Instance r3 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r3 = r3.end     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            java.lang.String r2 = r2.toString()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r2)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r5.a(r1)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r2 = r2.error     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r2 != 0) goto L_0x0107
            r5.b()     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.buffer = r6     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.length = r8     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            r2.offset = r7     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
        L_0x0107:
            r2 = 3
            com.iflytek.msc.MetaVAD$Instance r3 = r5.g     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r3 = r3.seg     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r2 == r3) goto L_0x0114
            com.iflytek.cloud.util.AudioDetector$DetectorResult r2 = r5.f     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            int r2 = r2.error     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            if (r2 == 0) goto L_0x00af
        L_0x0114:
            java.lang.String r6 = "detect get last seg or error."
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r6)     // Catch:{ UnsatisfiedLinkError -> 0x012f, Throwable -> 0x011c }
            goto L_0x0141
        L_0x011a:
            r6 = move-exception
            goto L_0x014a
        L_0x011c:
            r6 = move-exception
            java.lang.String r7 = "detect exception"
            com.iflytek.cloud.thirdparty.cb.c(r7)     // Catch:{ all -> 0x011a }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x011a }
            r5.a()     // Catch:{ all -> 0x011a }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.f     // Catch:{ all -> 0x011a }
            r7 = 20999(0x5207, float:2.9426E-41)
            r6.error = r7     // Catch:{ all -> 0x011a }
            goto L_0x0141
        L_0x012f:
            r6 = move-exception
            java.lang.String r7 = "detect exception"
            com.iflytek.cloud.thirdparty.cb.c(r7)     // Catch:{ all -> 0x011a }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x011a }
            r5.a()     // Catch:{ all -> 0x011a }
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.f     // Catch:{ all -> 0x011a }
            r7 = 20021(0x4e35, float:2.8055E-41)
            r6.error = r7     // Catch:{ all -> 0x011a }
        L_0x0141:
            monitor-exit(r0)     // Catch:{ all -> 0x011a }
            java.lang.String r6 = "detect leave"
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r6)
            com.iflytek.cloud.util.AudioDetector$DetectorResult r6 = r5.f
            return r6
        L_0x014a:
            monitor-exit(r0)     // Catch:{ all -> 0x011a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cy.detect(byte[], int, int, boolean):com.iflytek.cloud.util.AudioDetector$DetectorResult");
    }

    public void reset() {
        cb.a("reset enter");
        synchronized (b) {
            if (this.g == null || 0 == this.g.handle) {
                cb.c("setParameter error: vad instance is null, or invalid handle.");
            } else {
                try {
                    cb.a("reset MetaVAD.VADResetSession begin");
                    int VADResetSession = MetaVAD.VADResetSession(this.g);
                    cb.a("reset MetaVAD.VADResetSession return " + VADResetSession);
                    this.g.a();
                    this.j = true;
                    this.i = false;
                    this.o = 0;
                    this.l = 0;
                } catch (Throwable th) {
                    cb.c("reset exception:");
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
            if (this.g == null || 0 == this.g.handle) {
                cb.c("setParameter error: vad instance is null, or invalid handle.");
            } else {
                try {
                    if (AudioDetector.RESET_SENTENCE.equalsIgnoreCase(str)) {
                        int VADResetSentence = MetaVAD.VADResetSentence(this.g);
                        str3 = "VAD VADResetSentence ret: " + VADResetSentence;
                    } else if (!TextUtils.isEmpty(str) && c.containsKey(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            this.e.a(str, str2);
                        } else {
                            this.e.d(str);
                        }
                        String b = this.e.b(str, d.get(str));
                        int VADSetParam = MetaVAD.VADSetParam(this.g, bt.a(c.get(str), this.h), bt.a(b, this.h));
                        str3 = "VAD SetParameter key=" + r8 + ", value=" + b + ", ret: " + VADSetParam;
                    } else if (!TextUtils.isEmpty(str)) {
                        if (SpeechConstant.KEY_SPEECH_TIMEOUT.equalsIgnoreCase(str)) {
                            j2 = Long.parseLong(str2);
                            cb.a("SetParameter speech timeout value:" + j2);
                            if (0 < j2) {
                                this.n = (((long) (this.g.rate * this.m)) * j2) / 1000;
                                str3 = "SetParameter BytesOfSpeechTimeout: " + this.n;
                            } else {
                                this.n = -1;
                            }
                        } else {
                            int VADSetParam2 = MetaVAD.VADSetParam(this.g, bt.a(str, this.h), bt.a(str2, this.h));
                            str3 = "VAD SetParameter name=" + str + ", value=" + str2 + ", ret: " + VADSetParam2;
                        }
                    }
                } catch (NumberFormatException e2) {
                    cb.a((Throwable) e2);
                    j2 = -1;
                } catch (Throwable th) {
                    cb.c("setParameter exception");
                    cb.a(th);
                }
                cb.a(str3);
            }
        }
        cb.a("setParameter leave.");
    }
}
