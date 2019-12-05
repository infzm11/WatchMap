package com.amap.api.col.n3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: NaviSensorHelper */
public final class ff {
    private Context a;
    private Sensor b;
    private SensorManager c;
    private HandlerThread d;
    /* access modifiers changed from: private */
    public a e;
    private Timer f;
    /* access modifiers changed from: private */
    public float g = 0.0f;
    /* access modifiers changed from: private */
    public int h = 0;
    /* access modifiers changed from: private */
    public boolean i = false;
    private SensorEventListener j = new SensorEventListener() {
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            if (Math.abs(f - ff.this.g) > 3.0f) {
                float unused = ff.this.g = f;
                boolean unused2 = ff.this.i = true;
                ",lastDirection=" + ff.this.g + ",lastAccuracy=" + ff.this.h;
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            if (sensor.getType() == 3) {
                int unused = ff.this.h = i;
            }
        }
    };

    /* compiled from: NaviSensorHelper */
    public interface a {
        void a(boolean z, float f);
    }

    public ff(Context context) {
        this.a = context;
    }

    public final void a(a aVar) {
        this.e = aVar;
    }

    public final void a() {
        try {
            this.c = (SensorManager) this.a.getSystemService("sensor");
            this.b = this.c.getDefaultSensor(3);
            this.d = new HandlerThread(getClass().getName() + "_NaviSensorThread");
            this.d.start();
            this.c.registerListener(this.j, this.b, 1, new Handler(this.d.getLooper()));
            if (this.f == null) {
                this.f = new Timer();
                this.f.schedule(new TimerTask() {
                    public final void run() {
                        try {
                            Thread.currentThread().getName() + ",lastDirection=" + ff.this.g;
                            if (ff.this.e != null) {
                                a d = ff.this.e;
                                boolean e = ff.this.i;
                                int unused = ff.this.h;
                                d.a(e, ff.this.g);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }, 0, 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            this.a = null;
            this.b = null;
            if (this.c != null) {
                this.c.unregisterListener(this.j);
                this.c = null;
            }
            if (this.d != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.d.quitSafely();
                } else {
                    this.d.quit();
                }
                this.d = null;
            }
            this.e = null;
            if (this.f != null) {
                this.f.cancel();
                this.f = null;
            }
            this.i = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
