package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: MapLocationManagerResultHandler */
public final class ld extends Handler {
    lb a = null;

    public ld(Looper looper, lb lbVar) {
        super(looper);
        this.a = lbVar;
    }

    public ld(lb lbVar) {
        this.a = lbVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                if (this.a != null) {
                    this.a.a((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                lr.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
