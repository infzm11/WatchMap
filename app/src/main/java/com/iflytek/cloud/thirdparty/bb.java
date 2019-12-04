package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.SystemClock;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.thirdparty.bf;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class bb extends bf {
    private MSCSessionInfo c = new MSCSessionInfo();
    private MSCSessionInfo d = new MSCSessionInfo();
    private MSCSessionInfo e = new MSCSessionInfo();
    private byte[] f = null;

    private synchronized void a(byte[] bArr, int i, int i2) throws SpeechError {
        int QISVAudioWrite = MSC.QISVAudioWrite(this.a, (char[]) null, bArr, i, i2, this.c);
        cb.b("QISVAudioWrite error:" + QISVAudioWrite);
        if (QISVAudioWrite != 0) {
            throw new SpeechError(QISVAudioWrite);
        }
    }

    public int a(Context context, be beVar) throws UnsupportedEncodingException, SpeechError {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String e2 = beVar.x().e(SpeechConstant.ISV_VID);
        String b = cg.b(context, beVar);
        cb.a("sendRequest enter ");
        cc.a("LastDataFlag", (String) null);
        char[] QISVQueDelModel = MSC.QISVQueDelModel(e2 == null ? null : e2.getBytes(beVar.q()), b.getBytes(beVar.q()), this.e);
        cc.a("GetNotifyResult", (String) null);
        MSC.QISVQueDelModelRelease(QISVQueDelModel);
        int i = this.e.errorcode != 0 ? this.e.errorcode : "true".equals(new String(this.e.buffer)) ? 0 : -1;
        cb.a("sendRequest leave:" + i + " time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        if (i == 0 || -1 == i) {
            return i;
        }
        throw new SpeechError(i);
    }

    public int a(Context context, String str, be beVar) throws SpeechError, UnsupportedEncodingException {
        String b = cg.b(context, beVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        cc.a("MSCSessionBegin", (String) null);
        cb.a("QISVSessionBegin begin");
        this.a = MSC.QISVSessionBegin(b.getBytes(beVar.q()), str == null ? null : str.getBytes(beVar.q()), this.c);
        cc.a("SessionBeginEnd", (String) null);
        cb.a("QISVSessionBegin ret: " + this.c.errorcode + " time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        int i = this.c.errorcode;
        if (i == 0 || i == 10129 || i == 10113 || i == 10132) {
            return 0;
        }
        throw new SpeechError(i);
    }

    public synchronized void a() throws SpeechError {
        cc.a("LastDataFlag", (String) null);
        cb.a("IsvSession pushEndFlag");
        a(new byte[0], 0, 4);
    }

    public void a(String str) {
        if (this.a != null) {
            cb.a("isv sessionEnd enter ");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = MSC.QISVSessionEnd(this.a, str.getBytes()) == 0;
            cb.a("isv sessionEnd leave:" + z + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            this.a = null;
            this.b = null;
        }
    }

    public synchronized void a(byte[] bArr, int i) throws SpeechError {
        a(bArr, i, 2);
    }

    public synchronized String b(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            if (MSC.QISVGetParam(this.a, str.getBytes(), this.c) == 0) {
                return new String(this.c.buffer);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized boolean b() {
        return this.c.epstatues >= 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.iflytek.cloud.thirdparty.cb.b("getAudioVolume Exception vadret = " + r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int c() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            char[] r1 = r4.a     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "volume"
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x002e }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Exception -> 0x002e }
            int r1 = com.iflytek.msc.MSC.QISVGetParam(r1, r2, r3)     // Catch:{ Exception -> 0x002e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bb.c():int");
    }

    public byte[] d() {
        return this.f;
    }

    public bf.a e() throws SpeechError {
        Date date = new Date();
        this.f = MSC.QISVGetResult(this.a, (char[]) null, this.c);
        Date date2 = new Date();
        StringBuilder sb = new StringBuilder();
        sb.append("QISVGetResult leavel:");
        sb.append(this.f != null);
        sb.append(" time:");
        sb.append(date2.getTime() - date.getTime());
        cb.b(sb.toString());
        int i = this.c.errorcode;
        if (i == 0) {
            int i2 = this.c.rsltstatus;
            if (i2 != 5) {
                switch (i2) {
                    case 0:
                        break;
                    case 1:
                        cb.a("ResultStatus: noResult" + i2);
                        throw new SpeechError(20005);
                }
            }
            if (this.f != null) {
                cb.a("ResultStatus: hasResult" + i2);
                return bf.a.hasResult;
            }
            return bf.a.noResult;
        }
        cb.c("Result: error errorcode is " + i);
        throw new SpeechError(i);
    }

    /* access modifiers changed from: protected */
    public String f() {
        if (this.b == null) {
            this.b = b(SpeechConstant.IST_SESSION_ID);
        }
        return this.b;
    }
}
