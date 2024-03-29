package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;

public class bo extends bf {
    private MSCSessionInfo c = new MSCSessionInfo();

    public int a(Context context, String str, be beVar) throws SpeechError, UnsupportedEncodingException {
        this.a = null;
        String d = cg.d(context, beVar);
        cb.a("QTTSSessionBegin enter");
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bytes = d.getBytes(beVar.q());
        cc.a("MSCSessionBegin", (String) null);
        synchronized (bo.class) {
            this.a = MSC.QTTSSessionBegin(bytes, this.c);
        }
        cc.a("SessionBeginEnd", (String) null);
        cb.a("QTTSSessionBegin leave:" + (System.currentTimeMillis() - currentTimeMillis) + " ErrorCode:" + this.c.errorcode);
        int i = this.c.errorcode;
        if (i == 0 || i == 10129 || i == 10113 || i == 10132) {
            return i;
        }
        throw new SpeechError(i);
    }

    public void a(String str) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str)) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            cb.a("QTTSSessionEnd enter");
            int QTTSSessionEnd = MSC.QTTSSessionEnd(this.a, str.getBytes());
            cb.a("QTTSSessionEnd leavel:" + QTTSSessionEnd);
            this.a = null;
            this.b = null;
        }
    }

    public synchronized void a(byte[] bArr) throws SpeechError {
        cb.a("QTTSTextPut enter");
        cc.a("LastDataFlag", (String) null);
        int QTTSTextPut = MSC.QTTSTextPut(this.a, bArr);
        cb.a("QTTSTextPut leavel:" + QTTSTextPut);
        if (QTTSTextPut != 0) {
            throw new SpeechError(QTTSTextPut);
        }
    }

    public synchronized byte[] a() throws SpeechError {
        byte[] QTTSAudioGet;
        if (this.a == null) {
            throw new SpeechError(20003);
        }
        cb.b("QTTSAudioGet enter");
        QTTSAudioGet = MSC.QTTSAudioGet(this.a, this.c);
        StringBuilder sb = new StringBuilder();
        sb.append("QTTSAudioGet leave:");
        sb.append(this.c.errorcode);
        sb.append("value len = ");
        sb.append(QTTSAudioGet == null ? 0 : QTTSAudioGet.length);
        cb.b(sb.toString());
        int i = this.c.errorcode;
        if (i != 0) {
            throw new SpeechError(i);
        }
        return QTTSAudioGet;
    }

    public int b() {
        try {
            return Integer.parseInt(c("ced"));
        } catch (Exception unused) {
            return 0;
        }
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
        } catch (Exception unused) {
        }
        return i;
    }

    public String c() {
        try {
            char[] QTTSAudioInfo = MSC.QTTSAudioInfo(this.a);
            if (QTTSAudioInfo != null && QTTSAudioInfo.length > 0) {
                return new String(QTTSAudioInfo);
            }
        } catch (Exception e) {
            cb.a((Throwable) e);
        }
        return "";
    }

    public synchronized String c(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            if (MSC.QTTSGetParam(this.a, str.getBytes(), this.c) == 0) {
                return new String(this.c.buffer);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized boolean d() {
        return 2 == this.c.sesstatus;
    }

    /* access modifiers changed from: protected */
    public String e() {
        if (this.b == null) {
            this.b = c(SpeechConstant.IST_SESSION_ID);
        }
        return this.b;
    }
}
