package com.amap.api.col.n3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.n3.gn;
import com.amap.api.col.n3.gz;
import com.amap.api.maps.model.MyLocationStyle;
import com.iflytek.cloud.SpeechUtility;
import java.util.ArrayList;

/* compiled from: MessageHandler */
public final class gt extends Handler {
    private static gt a;

    /* compiled from: MessageHandler */
    public static class a {
        public gw a;
        public gz.a b;
    }

    /* compiled from: MessageHandler */
    public static class b {
        public gy a;
        public gz.a b;
    }

    public static synchronized gt a() {
        gt gtVar;
        synchronized (gt.class) {
            if (a == null) {
                if (Looper.myLooper() != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        a = new gt();
                    }
                }
                a = new gt(Looper.getMainLooper());
            }
            gtVar = a;
        }
        return gtVar;
    }

    gt() {
    }

    private gt(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            switch (message.arg1) {
                case 5:
                    gn.a aVar = (gn.a) message.obj;
                    if (aVar != null) {
                        ArrayList arrayList = null;
                        if (message.what == 1000) {
                            arrayList = message.getData().getParcelableArrayList(SpeechUtility.TAG_RESOURCE_RESULT);
                        }
                        aVar.a(arrayList, message.what);
                        return;
                    }
                    return;
                case 6:
                    if (message.what == 600) {
                        b bVar = (b) message.obj;
                        if (bVar != null && bVar.b != null) {
                            Bundle data = message.getData();
                            if (data != null) {
                                data.getInt(MyLocationStyle.ERROR_CODE);
                                gy gyVar = bVar.a;
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (message.what == 602) {
                        a aVar2 = (a) message.obj;
                        if (aVar2 != null) {
                            gz.a aVar3 = aVar2.b;
                            Bundle data2 = message.getData();
                            if (data2 != null) {
                                aVar3.a(aVar2.a, data2.getInt(MyLocationStyle.ERROR_CODE));
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } catch (Throwable unused) {
        }
    }
}
