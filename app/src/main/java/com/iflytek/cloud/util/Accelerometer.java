package com.iflytek.cloud.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {
    /* access modifiers changed from: private */
    public static CLOCKWISE_ANGLE c;
    private SensorManager a = null;
    private boolean b = false;
    private SensorEventListener d = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                float f3 = sensorEvent.values[2];
                if (Math.abs(f) > 3.0f || Math.abs(f2) > 3.0f) {
                    CLOCKWISE_ANGLE unused = Accelerometer.c = Math.abs(f) > Math.abs(f2) ? f > 0.0f ? CLOCKWISE_ANGLE.Deg0 : CLOCKWISE_ANGLE.Deg180 : f2 > 0.0f ? CLOCKWISE_ANGLE.Deg90 : CLOCKWISE_ANGLE.Deg270;
                }
            }
        }
    };

    public enum CLOCKWISE_ANGLE {
        Deg0(0),
        Deg90(1),
        Deg180(2),
        Deg270(3);
        
        private int value;

        private CLOCKWISE_ANGLE(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Accelerometer(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
        c = CLOCKWISE_ANGLE.Deg0;
    }

    public static int getDirection() {
        return c.getValue();
    }

    public void start() {
        if (!this.b) {
            this.b = true;
            c = CLOCKWISE_ANGLE.Deg0;
            this.a.registerListener(this.d, this.a.getDefaultSensor(1), 3);
        }
    }

    public void stop() {
        if (this.b) {
            this.b = false;
            this.a.unregisterListener(this.d);
        }
    }
}
