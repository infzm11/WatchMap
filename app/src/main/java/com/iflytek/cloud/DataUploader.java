package com.iflytek.cloud;

import android.content.Context;
import com.iflytek.cloud.thirdparty.bi;
import com.iflytek.cloud.thirdparty.bk;
import com.iflytek.cloud.thirdparty.cb;

public class DataUploader extends bi {
    public DataUploader(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public boolean b_() {
        return true;
    }

    public int uploadData(SpeechListener speechListener, String str, byte[] bArr) {
        int i;
        SpeechError speechError;
        try {
            this.e = new bk(this.a, this.c, a("upload"));
            ((bk) this.e).a(new bi.a(speechListener), str, bArr);
            return 0;
        } catch (SpeechError e) {
            i = e.getErrorCode();
            speechError = e;
            cb.a(speechError);
            return i;
        } catch (Throwable th) {
            i = 20999;
            speechError = th;
            cb.a(speechError);
            return i;
        }
    }
}
