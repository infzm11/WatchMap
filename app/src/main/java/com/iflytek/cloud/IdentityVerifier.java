package com.iflytek.cloud;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cj;

public final class IdentityVerifier extends bh {
    private static IdentityVerifier a;
    private cj d = null;
    /* access modifiers changed from: private */
    public InitListener e = null;
    private Handler f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (IdentityVerifier.this.e != null) {
                IdentityVerifier.this.e.onInit(message.what);
            }
        }
    };

    protected IdentityVerifier(Context context, InitListener initListener) {
        this.e = initListener;
        this.d = new cj(context);
        if (initListener != null) {
            Message.obtain(this.f, 0, 0, 0, (Object) null).sendToTarget();
        }
    }

    public static synchronized IdentityVerifier createVerifier(Context context, InitListener initListener) {
        IdentityVerifier identityVerifier;
        synchronized (IdentityVerifier.class) {
            synchronized (b) {
                if (a == null && SpeechUtility.getUtility() != null) {
                    a = new IdentityVerifier(context, initListener);
                }
            }
            identityVerifier = a;
        }
        return identityVerifier;
    }

    public static IdentityVerifier getVerifier() {
        return a;
    }

    public void cancel() {
        if (this.d == null || !this.d.e()) {
            cb.c("IdentityVerifier cancel failed, is not running");
        } else {
            this.d.cancel(false);
        }
    }

    public boolean destroy() {
        cj cjVar = this.d;
        boolean destroy = cjVar != null ? cjVar.destroy() : true;
        if (destroy) {
            destroy = super.destroy();
            if (destroy) {
                synchronized (b) {
                    a = null;
                }
                return destroy;
            }
        }
        return destroy;
    }

    public int execute(String str, String str2, String str3, IdentityListener identityListener) {
        if (this.d == null) {
            cb.c("IdentityVerifier execute failed, is not running");
            return 21001;
        } else if (this.d.setParameter(this.c)) {
            return this.d.a(str, str2, str3, identityListener);
        } else {
            return 20012;
        }
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean isWorking() {
        return this.d != null && this.d.e();
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int startWorking(IdentityListener identityListener) {
        if (this.d == null) {
            return 21001;
        }
        this.d.setParameter(this.c);
        return this.d.a(identityListener);
    }

    public void stopWrite(String str) {
        if (this.d == null || !this.d.e()) {
            cb.c("IdentityVerifier stopListening failed, is not running");
        } else {
            this.d.c(str);
        }
    }

    public int writeData(String str, String str2, byte[] bArr, int i, int i2) {
        if (this.d != null && this.d.e()) {
            return this.d.a(str, str2, bArr, i, i2);
        }
        cb.c("IdentityVerifier writeAudio failed, is not running");
        return 21004;
    }
}
