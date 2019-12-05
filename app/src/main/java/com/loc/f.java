package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.amap.api.location.APSServiceBase;

/* compiled from: APSServiceCore */
public class f implements APSServiceBase {
    e a = null;
    Context b = null;
    Messenger c = null;

    public f(Context context) {
        this.b = context.getApplicationContext();
        this.a = new e(this.b);
    }

    public IBinder onBind(Intent intent) {
        this.a.b(intent);
        this.a.a(intent);
        this.c = new Messenger(this.a.b());
        return this.c.getBinder();
    }

    public void onCreate() {
        try {
            e.f();
            this.a.j = da.b();
            this.a.k = da.a();
            this.a.a();
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "onCreate");
        }
    }

    public void onDestroy() {
        try {
            if (this.a != null) {
                this.a.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "onDestroy");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }
}
