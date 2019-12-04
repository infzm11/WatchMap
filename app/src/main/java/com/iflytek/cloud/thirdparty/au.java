package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.thirdparty.bf;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class au extends bf {
    private MSCSessionInfo c = new MSCSessionInfo();
    private MSCSessionInfo d = new MSCSessionInfo();
    private byte[] e = null;

    private synchronized void a(byte[] bArr, int i, int i2) throws SpeechError {
        cb.b("QISEAudioWrite enter, length: " + i);
        int QISEAudioWrite = MSC.QISEAudioWrite(this.a, bArr, i, i2, this.d);
        cb.b("QISEAudioWrite leave: " + QISEAudioWrite);
        this.c.sesstatus = this.d.sesstatus;
        if (QISEAudioWrite != 0) {
            throw new SpeechError(this.d.errorcode);
        }
    }

    public int a(Context context, String str, be beVar) throws SpeechError, UnsupportedEncodingException {
        this.a = null;
        String e2 = cg.e(context, beVar);
        cc.a("MSCSessionBegin", (String) null);
        cb.a("QISESessionBegin enter");
        if (TextUtils.isEmpty(str)) {
            this.a = MSC.QISESessionBegin(e2.getBytes(beVar.q()), (byte[]) null, this.c);
        } else {
            this.a = MSC.QISESessionBegin(e2.getBytes(beVar.q()), str.getBytes(beVar.q()), this.c);
            cb.a("sessionBegin userModelId:" + str);
        }
        cb.a("QISESessionBegin leave: " + this.c.errorcode);
        cc.a("SessionBeginEnd", (String) null);
        int i = this.c.errorcode;
        if (i == 0 || i == 10129 || i == 10113 || i == 10132) {
            return i;
        }
        throw new SpeechError(i);
    }

    public synchronized void a() throws SpeechError {
        cc.a("LastDataFlag", (String) null);
        cb.a("IseSession pushEndFlag");
        a(new byte[0], 0, 4);
    }

    public void a(String str) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str)) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            cb.a("ISESessionEnd enter ");
            long currentTimeMillis = System.currentTimeMillis();
            int QISESessionEnd = MSC.QISESessionEnd(this.a, str.getBytes());
            cb.a("ISESessionEnd leave: " + QISESessionEnd + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            this.a = null;
            this.b = null;
        }
    }

    public synchronized void a(byte[] bArr, int i) throws SpeechError {
        a(bArr, i, 2);
    }

    public synchronized void a(byte[] bArr, byte[] bArr2) throws SpeechError {
        cb.a("QISETextPut enter");
        int QISETextPut = MSC.QISETextPut(this.a, bArr, bArr2);
        cb.a("QISETextPut leave: " + QISETextPut);
        if (QISETextPut != 0) {
            throw new SpeechError(QISETextPut);
        }
    }

    public synchronized int b() {
        return this.d.epstatues;
    }

    public synchronized String b(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            if (MSC.QISEGetParam(this.a, str.getBytes(), this.c) == 0) {
                return new String(this.c.buffer);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.iflytek.cloud.thirdparty.cb.b("getAudioVolume Exception vadret = " + r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int c() {
        /*
            r4 = this;
            monitor-enter(r4)
            char[] r0 = r4.a     // Catch:{ all -> 0x0049 }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r4)
            return r1
        L_0x0008:
            char[] r0 = r4.a     // Catch:{ Throwable -> 0x0032 }
            java.lang.String r2 = "volume"
            byte[] r2 = r2.getBytes()     // Catch:{ Throwable -> 0x0032 }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Throwable -> 0x0032 }
            int r0 = com.iflytek.msc.MSC.QISEGetParam(r0, r2, r3)     // Catch:{ Throwable -> 0x0032 }
            if (r0 != 0) goto L_0x002c
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0033 }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Throwable -> 0x0033 }
            byte[] r3 = r3.buffer     // Catch:{ Throwable -> 0x0033 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0033 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x0033 }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x0033 }
            int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ Throwable -> 0x0033 }
            r1 = r2
            goto L_0x0047
        L_0x002c:
            java.lang.String r2 = "VAD CHECK FALSE"
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r2)     // Catch:{ Throwable -> 0x0033 }
            goto L_0x0047
        L_0x0032:
            r0 = r1
        L_0x0033:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "getAudioVolume Exception vadret = "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0049 }
            com.iflytek.cloud.thirdparty.cb.b((java.lang.String) r0)     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r4)
            return r1
        L_0x0049:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.au.c():int");
    }

    public byte[] d() {
        return this.e;
    }

    public bf.a e() throws SpeechError {
        Date date = new Date();
        this.e = MSC.QISEGetResult(this.a, this.c);
        Date date2 = new Date();
        StringBuilder sb = new StringBuilder();
        sb.append("QISRGetResult leave: ");
        sb.append(this.e != null);
        sb.append(" time:");
        sb.append(date2.getTime() - date.getTime());
        cb.b(sb.toString());
        int i = this.c.errorcode;
        if (i == 0) {
            int i2 = this.c.rsltstatus;
            if (i2 == 0) {
                cb.a("ResultStatus: hasResult" + i2);
                return bf.a.hasResult;
            } else if (i2 == 2) {
                cb.b("ResultStatus: noResult" + i2);
                return bf.a.noResult;
            } else if (i2 != 5) {
                cb.a("IseSession getResult get unmatched result status: " + i2);
                return bf.a.noResult;
            } else {
                cb.a("ResultStatus: resultOver" + i2);
                return bf.a.resultOver;
            }
        } else {
            cb.c("Result: error " + i);
            throw new SpeechError(i);
        }
    }

    /* access modifiers changed from: protected */
    public String f() {
        if (this.b == null) {
            this.b = b(SpeechConstant.IST_SESSION_ID);
        }
        return this.b;
    }
}
