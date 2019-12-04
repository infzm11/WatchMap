package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;

public class bc extends bf {
    private MSCSessionInfo c = new MSCSessionInfo();
    private MSCSessionInfo d = new MSCSessionInfo();
    private byte[] e = null;

    private synchronized void a(String str, byte[] bArr, int i) throws SpeechError {
        int QMFVDataWrite = MSC.QMFVDataWrite(this.a, str.getBytes(), bArr, i, this.d);
        this.c.sesstatus = this.d.sesstatus;
        cb.b("QISRAudioWrite length:" + i);
        if (QMFVDataWrite != 0) {
            throw new SpeechError(this.d.errorcode);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.iflytek.cloud.thirdparty.cb.b("getAudioVolume Exception vadret = " + r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            char[] r1 = r4.a     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "volume"
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x002e }
            com.iflytek.msc.MSCSessionInfo r3 = r4.d     // Catch:{ Exception -> 0x002e }
            int r1 = com.iflytek.msc.MSC.QMFVGetParam(r1, r2, r3)     // Catch:{ Exception -> 0x002e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bc.a():int");
    }

    public int a(Context context, String str, be beVar) throws SpeechError, UnsupportedEncodingException {
        String b = cg.b(context, str, beVar);
        cb.d("sessionBegin Params:" + b);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        cc.a("MSCSessionBegin", (String) null);
        synchronized (bc.class) {
            this.a = MSC.QMFVSessionBegin(b.getBytes(beVar.q()), this.c);
        }
        cc.a("SessionBeginEnd", (String) null);
        cb.a("sessionBegin ErrCode:" + this.c.errorcode + " time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        int i = this.c.errorcode;
        if (i == 0 || i == 10129 || i == 10113 || i == 10132) {
            return i;
        }
        throw new SpeechError(i);
    }

    public void a(String str) {
        if (this.a != null) {
            cb.a("sessionEnd enter ");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = MSC.QMFVSessionEnd(this.a, str.getBytes()) == 0;
            cb.a("sessionEnd leavel:" + z + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            this.a = null;
            this.b = null;
        }
    }

    public synchronized void a(StringBuffer stringBuffer, byte[] bArr, int i, boolean z) throws SpeechError {
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
        stringBuffer2.append(",data_status=");
        if (z) {
            stringBuffer2.append(1);
        } else {
            stringBuffer2.append(2);
        }
        cb.d("pushAudioData, param:" + stringBuffer2.toString());
        a(stringBuffer2.toString(), bArr, i);
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
            int r5 = com.iflytek.msc.MSC.QMFVSetParam(r2, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0027 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bc.a(java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public String b() {
        if (this.b == null) {
            this.b = d(SpeechConstant.IST_SESSION_ID);
        }
        return this.b;
    }

    public synchronized void b(String str) throws SpeechError {
        cc.a("LastDataFlag", (String) null);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ssub=" + str);
        stringBuffer.append(",data_status=4");
        cb.a("mfv pushEndFlag, param:" + stringBuffer.toString());
        a(stringBuffer.toString(), new byte[0], 0);
    }

    public synchronized int c(String str) {
        int i;
        i = 0;
        if (this.a == null) {
            return 0;
        }
        try {
            String d2 = d(str);
            if (!TextUtils.isEmpty(d2)) {
                i = Integer.parseInt(new String(d2));
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
        return i;
    }

    public synchronized String d(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            if (MSC.QMFVGetParam(this.a, str.getBytes(), this.c) == 0) {
                return new String(this.c.buffer);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
