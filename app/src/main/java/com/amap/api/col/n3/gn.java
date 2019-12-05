package com.amap.api.col.n3;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.iflytek.cloud.SpeechUtility;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Inputtips */
public final class gn {
    private gq a = null;

    /* compiled from: Inputtips */
    public interface a {
        void a(List<he> list, int i);
    }

    public gn(Context context, gp gpVar) {
        if (this.a == null) {
            try {
                this.a = new gq(context, gpVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(a aVar) {
        if (this.a != null) {
            this.a.a(aVar);
        }
    }

    public final void a() {
        if (this.a != null) {
            try {
                new Thread() {
                    public final void run() {
                        Message obtainMessage;
                        try {
                            obtainMessage = gt.a().obtainMessage();
                            obtainMessage.obj = gq.this.b;
                            obtainMessage.arg1 = 5;
                            try {
                                ArrayList a2 = gq.this.a(gq.this.d);
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList(SpeechUtility.TAG_RESOURCE_RESULT, a2);
                                obtainMessage.setData(bundle);
                                obtainMessage.what = 1000;
                                gq.this.c.sendMessage(obtainMessage);
                            } catch (gh e) {
                                obtainMessage.what = e.b();
                                gq.this.c.sendMessage(obtainMessage);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
            } catch (Throwable unused) {
            }
        }
    }
}
