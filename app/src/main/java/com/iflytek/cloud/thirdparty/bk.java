package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechListener;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.be;
import java.io.IOException;

public class bk extends be {
    private SpeechListener a = null;
    private bj b = new bj();
    private String c = null;

    private class a {
        private byte[] b = null;
        private String c = "";

        public a(byte[] bArr, String str) {
            this.b = bArr;
            this.c = str;
        }

        public byte[] a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    public bk(Context context, ce ceVar) {
        super(context);
        a(ceVar);
    }

    public bk(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, handlerThread);
        a(ceVar);
    }

    public SpeechError a(String str, String str2) {
        StringBuilder sb;
        this.c = "auth";
        try {
            bj.a(this.t, str, str2, (be) this);
            return null;
        } catch (SpeechError e) {
            e = e;
            cb.a((Throwable) e);
            if (e != null) {
                sb = new StringBuilder();
                sb.append(z());
                sb.append(" occur Error = ");
                sb.append(e.toString());
                cb.a(sb.toString());
                return e;
            }
            return e;
        } catch (IOException e2) {
            cb.a((Throwable) e2);
            e = new SpeechError(20010);
            if (e != null) {
                sb = new StringBuilder();
                sb.append(z());
                sb.append(" occur Error = ");
                sb.append(e.toString());
                cb.a(sb.toString());
                return e;
            }
            return e;
        } catch (Exception e3) {
            cb.a((Throwable) e3);
            e = new SpeechError(21003);
            if (e != null) {
                sb = new StringBuilder();
                sb.append(z());
                sb.append(" occur Error = ");
                sb.append(e.toString());
                cb.a(sb.toString());
                return e;
            }
            return e;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Message message) throws Throwable, SpeechError {
        byte[] bArr;
        super.a(message);
        if (SpeechUtility.getUtility() == null) {
            cb.c("MscCommon process while utility is null!");
            b(new SpeechError(20015));
            return;
        }
        switch (message.what) {
            case 10:
                a aVar = (a) message.obj;
                if (aVar.a() != null && aVar.a().length > 0) {
                    bArr = this.b.a(this.t, aVar.b(), aVar.a(), (be) this);
                    break;
                } else {
                    throw new SpeechError(20009);
                }
            case 11:
                bArr = this.b.a(this.t, this);
                break;
            case 12:
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(str)) {
                    a(be.b.waitresult);
                    bArr = this.b.a(this.t, this, str);
                    try {
                        this.x.a(bArr == null ? null : new String(bArr), true);
                        break;
                    } catch (Throwable th) {
                        cb.c("DC exception:");
                        cb.a(th);
                        break;
                    }
                } else {
                    throw new SpeechError(20009);
                }
            default:
                bArr = null;
                break;
        }
        if (bArr == null) {
            throw new SpeechError(20004);
        }
        if (this.a != null && !this.u) {
            this.a.onBufferReceived(bArr);
        }
        b((SpeechError) null);
    }

    /* access modifiers changed from: protected */
    public void a(SpeechError speechError) {
        super.a(speechError);
        if (this.a != null && !this.u) {
            this.a.onCompleted(speechError);
        }
    }

    public void a(SpeechListener speechListener) {
        this.a = speechListener;
        a(11);
    }

    public void a(SpeechListener speechListener, String str) {
        a(be.b.start);
        this.c = "sch";
        this.a = speechListener;
        try {
            this.x.b();
        } catch (Throwable th) {
            cb.c("DC exception:");
            cb.a(th);
        }
        d(obtainMessage(12, str));
    }

    public void a(SpeechListener speechListener, String str, byte[] bArr) {
        this.c = "uup";
        this.a = speechListener;
        d(obtainMessage(10, new a(bArr, str)));
    }

    public String e() {
        return null;
    }

    public String f() {
        return null;
    }

    public String g() {
        return this.c;
    }
}
