package com.iflytek.cloud;

import android.content.Context;
import com.iflytek.cloud.thirdparty.bi;
import com.iflytek.cloud.thirdparty.bk;
import com.iflytek.cloud.thirdparty.cb;

public class DataDownloader extends bi {
    public DataDownloader(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public boolean b_() {
        return true;
    }

    public int downloadData(SpeechListener speechListener) {
        SpeechError speechError;
        int i;
        try {
            this.e = new bk(this.a, this.c, a("download"));
            ((bk) this.e).a((SpeechListener) new bi.a(speechListener));
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
