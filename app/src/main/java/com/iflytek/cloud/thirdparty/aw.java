package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.GrammarListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;

public class aw extends bf {
    private static GrammarListener f;
    private static LexiconListener g;
    private MSCSessionInfo c = new MSCSessionInfo();
    private MSCSessionInfo d = new MSCSessionInfo();
    private byte[] e = null;
    private String h = "";

    private synchronized void a(byte[] bArr, int i, int i2) throws SpeechError {
        int QISRAudioWrite = MSC.QISRAudioWrite(this.a, bArr, i, i2, this.d);
        this.c.sesstatus = this.d.sesstatus;
        cb.b("QISRAudioWrite length:" + i);
        if (QISRAudioWrite != 0) {
            throw new SpeechError(this.d.errorcode);
        }
    }

    public int a(Context context, String str, be beVar) throws SpeechError, UnsupportedEncodingException {
        String a = cg.a(context, str, beVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        cb.a("QISRSessionBegin begin, grammar: " + str);
        synchronized (aw.class) {
            cc.a("MSCSessionBegin", (String) null);
            this.a = TextUtils.isEmpty(str) ? MSC.QISRSessionBegin((byte[]) null, a.getBytes(beVar.q()), this.c) : MSC.QISRSessionBegin(str.getBytes(beVar.q()), a.getBytes(beVar.q()), this.c);
            cc.a("SessionBeginEnd", (String) null);
        }
        cb.a("QISRSessionBegin end: " + this.c.errorcode + " time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        int i = this.c.errorcode;
        if (i == 0 || i == 10129 || i == 10113 || i == 10132) {
            return i;
        }
        throw new SpeechError(i);
    }

    public int a(String str, String str2, GrammarListener grammarListener, ce ceVar) {
        f = grammarListener;
        String ceVar2 = ceVar.toString();
        String b = ceVar.b(SpeechConstant.TEXT_ENCODING, "utf-8");
        String b2 = ceVar.b("pte", "utf-8");
        try {
            byte[] bytes = str2.getBytes(b);
            cc.a("LastDataFlag", (String) null);
            cb.a("QISRBuildGrammar begin, garmmar: " + str2);
            int QISRBuildGrammar = MSC.QISRBuildGrammar(str.getBytes(b2), bytes, bytes.length, ceVar2.getBytes(b2), "grammarCallBack", this);
            cb.a("QISRBuildGrammar leave: " + QISRBuildGrammar);
            return QISRBuildGrammar;
        } catch (UnsupportedEncodingException e2) {
            cb.a((Throwable) e2);
            return 20012;
        }
    }

    public int a(String str, String str2, LexiconListener lexiconListener, ce ceVar) {
        g = lexiconListener;
        this.h = str;
        ceVar.a(SpeechConstant.TEXT_ENCODING, "utf-8", false);
        String b = ceVar.b(SpeechConstant.TEXT_ENCODING, "utf-8");
        String b2 = ceVar.b("pte", "utf-8");
        String ceVar2 = ceVar.toString();
        try {
            byte[] bytes = str2.getBytes(b);
            cb.a("QISRUpdateLexicon begin, name: " + str + "content: " + str2);
            cc.a("LastDataFlag", (String) null);
            int QISRUpdateLexicon = MSC.QISRUpdateLexicon(str.getBytes(b2), bytes, bytes.length, ceVar2.getBytes(b2), "lexiconCallBack", this);
            cb.a("QISRUpdateLexicon leave: " + QISRUpdateLexicon);
            return QISRUpdateLexicon;
        } catch (UnsupportedEncodingException e2) {
            cb.a((Throwable) e2);
            return 20012;
        }
    }

    public synchronized void a() throws SpeechError {
        cc.a("LastDataFlag", (String) null);
        cb.a("IsrSession pushEndFlag");
        a(new byte[0], 0, 4);
    }

    public void a(String str) {
        if (this.a != null) {
            cb.a("sessionEnd enter ");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = MSC.QISRSessionEnd(this.a, str.getBytes()) == 0;
            cb.a("sessionEnd leavel:" + z + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            this.a = null;
            this.b = null;
        }
    }

    public synchronized void a(byte[] bArr, int i) throws SpeechError {
        a(bArr, i, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0033 }
            r1 = 0
            if (r0 != 0) goto L_0x0031
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0031
            char[] r0 = r4.a     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r0 = -1
            char[] r2 = r4.a     // Catch:{ UnsupportedEncodingException -> 0x0027 }
            java.lang.String r3 = "utf-8"
            byte[] r5 = r5.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x0027 }
            java.lang.String r3 = "utf-8"
            byte[] r6 = r6.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x0027 }
            int r5 = com.iflytek.msc.MSC.QISRSetParam(r2, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r5 = move-exception
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0033 }
            r5 = r0
        L_0x002c:
            if (r5 != 0) goto L_0x002f
            r1 = 1
        L_0x002f:
            monitor-exit(r4)
            return r1
        L_0x0031:
            monitor-exit(r4)
            return r1
        L_0x0033:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.aw.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.iflytek.cloud.thirdparty.cb.b("getAudioVolume Exception vadret = " + r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int b() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            char[] r1 = r4.a     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "volume"
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x002e }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Exception -> 0x002e }
            int r1 = com.iflytek.msc.MSC.QISRGetParam(r1, r2, r3)     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0026
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x002f }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Exception -> 0x002f }
            byte[] r3 = r3.buffer     // Catch:{ Exception -> 0x002f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x002f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002f }
            int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x002f }
            r0 = r2
            goto L_0x0043
        L_0x0026:
            java.lang.String r2 = "VAD CHECK FALSE"
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x0043
        L_0x002c:
            r0 = move-exception
            goto L_0x0045
        L_0x002e:
            r1 = r0
        L_0x002f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r2.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "getAudioVolume Exception vadret = "
            r2.append(r3)     // Catch:{ all -> 0x002c }
            r2.append(r1)     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x002c }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r1)     // Catch:{ all -> 0x002c }
        L_0x0043:
            monitor-exit(r4)
            return r0
        L_0x0045:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.aw.b():int");
    }

    public synchronized int b(String str) {
        int i;
        i = 0;
        if (this.a == null) {
            return 0;
        }
        try {
            String c2 = c(str);
            if (!TextUtils.isEmpty(c2)) {
                i = Integer.parseInt(new String(c2));
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public String c() {
        if (this.b == null) {
            this.b = c(SpeechConstant.IST_SESSION_ID);
        }
        return this.b;
    }

    public synchronized String c(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            if (MSC.QISRGetParam(this.a, str.getBytes(), this.c) == 0) {
                return new String(this.c.buffer);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String d() {
        return c(SpeechEvent.KEY_EVENT_AUDIO_URL);
    }

    /* access modifiers changed from: package-private */
    public int grammarCallBack(int i, char[] cArr) {
        cb.a("grammarCallBack begin, errorCode: " + i);
        SpeechError speechError = null;
        cc.a("GetNotifyResult", (String) null);
        if (f != null) {
            if (i != 0) {
                GrammarListener grammarListener = f;
                if (i != 0) {
                    speechError = new SpeechError(i);
                }
                grammarListener.onBuildFinish("", speechError);
            } else {
                f.onBuildFinish(String.valueOf(cArr), (SpeechError) null);
            }
        }
        cb.a("grammarCallBack begin, leave");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int lexiconCallBack(int i, char[] cArr) {
        cb.a("lexiconCallBack begin, errorCode: " + i);
        SpeechError speechError = null;
        cc.a("GetNotifyResult", (String) null);
        if (g != null) {
            if (i != 0) {
                LexiconListener lexiconListener = g;
                String str = this.h;
                if (i != 0) {
                    speechError = new SpeechError(i);
                }
                lexiconListener.onLexiconUpdated(str, speechError);
            } else {
                g.onLexiconUpdated(this.h, (SpeechError) null);
            }
        }
        cb.a("lexiconCallBack leave");
        return 0;
    }
}
