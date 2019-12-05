package com.amap.api.col.n3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;

/* compiled from: SensorEventHelper */
public final class t implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private long c = 0;
    private final int d = 100;
    private float e;
    private Context f;
    private k g;
    private Marker h;
    private boolean i = true;

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public t(Context context, k kVar) {
        this.f = context.getApplicationContext();
        this.g = kVar;
        try {
            this.a = (SensorManager) context.getSystemService("sensor");
            this.b = this.a.getDefaultSensor(3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        if (this.a != null && this.b != null) {
            this.a.registerListener(this, this.b, 3);
        }
    }

    public final void b() {
        if (this.a != null && this.b != null) {
            this.a.unregisterListener(this, this.b);
        }
    }

    public final void a(Marker marker) {
        this.h = marker;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.c >= 100) {
                if (this.g.a() != null && this.g.a().getAnimateionsCount() > 0) {
                    return;
                }
                if (sensorEvent.sensor.getType() == 3) {
                    int i2 = 0;
                    float f2 = sensorEvent.values[0];
                    switch (((WindowManager) this.f.getSystemService("window")).getDefaultDisplay().getRotation()) {
                        case 0:
                            break;
                        case 1:
                            i2 = 90;
                            break;
                        case 2:
                            i2 = 180;
                            break;
                        case 3:
                            i2 = -90;
                            break;
                    }
                    float f3 = (f2 + ((float) i2)) % 360.0f;
                    if (f3 > 180.0f) {
                        f3 -= 360.0f;
                    } else if (f3 < -180.0f) {
                        f3 += 360.0f;
                    }
                    if (Math.abs(this.e - f3) >= 3.0f) {
                        if (Float.isNaN(f3)) {
                            f3 = 0.0f;
                        }
                        this.e = f3;
                        if (this.h != null) {
                            if (this.i) {
                                this.g.a(z.c(this.e));
                                this.h.setRotateAngle(-this.e);
                            } else {
                                this.h.setRotateAngle(360.0f - this.e);
                            }
                        }
                        this.c = System.currentTimeMillis();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
