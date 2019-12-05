package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* compiled from: AMapSensorManager */
public final class by implements SensorEventListener {
    SensorManager a = null;
    Sensor b = null;
    Sensor c = null;
    Sensor d = null;
    public boolean e = false;
    public double f = 0.0d;
    public float g = 0.0f;
    double h = 0.0d;
    Handler i = new Handler() {
    };
    double j = 0.0d;
    double k = 0.0d;
    double l = 0.0d;
    double m = 0.0d;
    double[] n = new double[3];
    volatile double o = 0.0d;
    long p = 0;
    long q = 0;
    private Context r = null;
    private float s = 1013.25f;
    private float t = 0.0f;

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|15) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public by(android.content.Context r5) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.r = r0
            r4.a = r0
            r4.b = r0
            r4.c = r0
            r4.d = r0
            r0 = 0
            r4.e = r0
            r0 = 0
            r4.f = r0
            r2 = 0
            r4.g = r2
            r3 = 1149063168(0x447d5000, float:1013.25)
            r4.s = r3
            r4.t = r2
            r4.h = r0
            com.loc.by$1 r2 = new com.loc.by$1
            r2.<init>()
            r4.i = r2
            r4.j = r0
            r4.k = r0
            r4.l = r0
            r4.m = r0
            r2 = 3
            double[] r2 = new double[r2]
            r4.n = r2
            r4.o = r0
            r0 = 0
            r4.p = r0
            r4.q = r0
            r4.r = r5     // Catch:{ Throwable -> 0x006c }
            android.hardware.SensorManager r5 = r4.a     // Catch:{ Throwable -> 0x006c }
            if (r5 != 0) goto L_0x004f
            android.content.Context r5 = r4.r     // Catch:{ Throwable -> 0x006c }
            java.lang.String r0 = "sensor"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ Throwable -> 0x006c }
            android.hardware.SensorManager r5 = (android.hardware.SensorManager) r5     // Catch:{ Throwable -> 0x006c }
            r4.a = r5     // Catch:{ Throwable -> 0x006c }
        L_0x004f:
            android.hardware.SensorManager r5 = r4.a     // Catch:{ Throwable -> 0x0058 }
            r0 = 6
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x0058 }
            r4.b = r5     // Catch:{ Throwable -> 0x0058 }
        L_0x0058:
            android.hardware.SensorManager r5 = r4.a     // Catch:{ Throwable -> 0x0062 }
            r0 = 11
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x0062 }
            r4.c = r5     // Catch:{ Throwable -> 0x0062 }
        L_0x0062:
            android.hardware.SensorManager r5 = r4.a     // Catch:{ Throwable -> 0x006b }
            r0 = 1
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x006b }
            r4.d = r5     // Catch:{ Throwable -> 0x006b }
        L_0x006b:
            return
        L_0x006c:
            r5 = move-exception
            java.lang.String r0 = "AMapSensorManager"
            java.lang.String r1 = "<init>"
            com.loc.cs.a(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.by.<init>(android.content.Context):void");
    }

    public final void a() {
        if (this.a != null && !this.e) {
            this.e = true;
            try {
                if (this.b != null) {
                    this.a.registerListener(this, this.b, 3, this.i);
                }
            } catch (Throwable th) {
                cs.a(th, "AMapSensorManager", "registerListener mPressure");
            }
            try {
                if (this.c != null) {
                    this.a.registerListener(this, this.c, 3, this.i);
                }
            } catch (Throwable th2) {
                cs.a(th2, "AMapSensorManager", "registerListener mRotationVector");
            }
            try {
                if (this.d != null) {
                    this.a.registerListener(this, this.d, 3, this.i);
                }
            } catch (Throwable th3) {
                cs.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ Throwable -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025 A[Catch:{ Throwable -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r2 = this;
            android.hardware.SensorManager r0 = r2.a
            if (r0 == 0) goto L_0x002c
            boolean r0 = r2.e
            if (r0 == 0) goto L_0x002c
            r0 = 0
            r2.e = r0
            android.hardware.Sensor r0 = r2.b     // Catch:{ Throwable -> 0x0016 }
            if (r0 == 0) goto L_0x0016
            android.hardware.SensorManager r0 = r2.a     // Catch:{ Throwable -> 0x0016 }
            android.hardware.Sensor r1 = r2.b     // Catch:{ Throwable -> 0x0016 }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x0016 }
        L_0x0016:
            android.hardware.Sensor r0 = r2.c     // Catch:{ Throwable -> 0x0021 }
            if (r0 == 0) goto L_0x0021
            android.hardware.SensorManager r0 = r2.a     // Catch:{ Throwable -> 0x0021 }
            android.hardware.Sensor r1 = r2.c     // Catch:{ Throwable -> 0x0021 }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x0021 }
        L_0x0021:
            android.hardware.Sensor r0 = r2.d     // Catch:{ Throwable -> 0x002c }
            if (r0 == 0) goto L_0x002c
            android.hardware.SensorManager r0 = r2.a     // Catch:{ Throwable -> 0x002c }
            android.hardware.Sensor r1 = r2.d     // Catch:{ Throwable -> 0x002c }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x002c }
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.by.b():void");
    }

    public final double c() {
        return this.f;
    }

    public final float d() {
        return this.t;
    }

    public final double e() {
        return this.m;
    }

    public final void f() {
        try {
            b();
            this.b = null;
            this.c = null;
            this.a = null;
            this.d = null;
            this.e = false;
        } catch (Throwable th) {
            cs.a(th, "AMapSensorManager", "destroy");
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSensorChanged(android.hardware.SensorEvent r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            android.hardware.Sensor r0 = r12.sensor     // Catch:{ Throwable -> 0x011d }
            int r0 = r0.getType()     // Catch:{ Throwable -> 0x011d }
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0077
            r1 = 6
            if (r0 == r1) goto L_0x0053
            r1 = 11
            if (r0 == r1) goto L_0x0015
            return
        L_0x0015:
            android.hardware.Sensor r0 = r11.c     // Catch:{ Throwable -> 0x0052 }
            if (r0 == 0) goto L_0x0052
            float[] r12 = r12.values     // Catch:{ Throwable -> 0x0052 }
            java.lang.Object r12 = r12.clone()     // Catch:{ Throwable -> 0x0052 }
            float[] r12 = (float[]) r12     // Catch:{ Throwable -> 0x0052 }
            if (r12 == 0) goto L_0x0052
            r0 = 9
            float[] r0 = new float[r0]     // Catch:{ Throwable -> 0x0052 }
            android.hardware.SensorManager.getRotationMatrixFromVector(r0, r12)     // Catch:{ Throwable -> 0x0052 }
            r12 = 3
            float[] r12 = new float[r12]     // Catch:{ Throwable -> 0x0052 }
            android.hardware.SensorManager.getOrientation(r0, r12)     // Catch:{ Throwable -> 0x0052 }
            r12 = r12[r2]     // Catch:{ Throwable -> 0x0052 }
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0052 }
            double r0 = java.lang.Math.toDegrees(r0)     // Catch:{ Throwable -> 0x0052 }
            float r12 = (float) r0     // Catch:{ Throwable -> 0x0052 }
            r11.t = r12     // Catch:{ Throwable -> 0x0052 }
            float r12 = r11.t     // Catch:{ Throwable -> 0x0052 }
            r0 = 0
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x0045
            float r12 = r11.t     // Catch:{ Throwable -> 0x0052 }
        L_0x0043:
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0052 }
            goto L_0x004b
        L_0x0045:
            float r12 = r11.t     // Catch:{ Throwable -> 0x0052 }
            r0 = 1135869952(0x43b40000, float:360.0)
            float r12 = r12 + r0
            goto L_0x0043
        L_0x004b:
            double r0 = java.lang.Math.floor(r0)     // Catch:{ Throwable -> 0x0052 }
            float r12 = (float) r0     // Catch:{ Throwable -> 0x0052 }
            r11.t = r12     // Catch:{ Throwable -> 0x0052 }
        L_0x0052:
            return
        L_0x0053:
            android.hardware.Sensor r0 = r11.b     // Catch:{ Throwable -> 0x0076 }
            if (r0 == 0) goto L_0x0076
            float[] r12 = r12.values     // Catch:{ Throwable -> 0x0076 }
            java.lang.Object r12 = r12.clone()     // Catch:{ Throwable -> 0x0076 }
            float[] r12 = (float[]) r12     // Catch:{ Throwable -> 0x0076 }
            if (r12 == 0) goto L_0x0065
            r0 = r12[r2]     // Catch:{ Throwable -> 0x0076 }
            r11.g = r0     // Catch:{ Throwable -> 0x0076 }
        L_0x0065:
            if (r12 == 0) goto L_0x0076
            float r0 = r11.s     // Catch:{ Throwable -> 0x0076 }
            r12 = r12[r2]     // Catch:{ Throwable -> 0x0076 }
            float r12 = android.hardware.SensorManager.getAltitude(r0, r12)     // Catch:{ Throwable -> 0x0076 }
            float r12 = com.loc.da.a((float) r12)     // Catch:{ Throwable -> 0x0076 }
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0076 }
            r11.f = r0     // Catch:{ Throwable -> 0x0076 }
        L_0x0076:
            return
        L_0x0077:
            android.hardware.Sensor r0 = r11.d     // Catch:{  }
            if (r0 == 0) goto L_0x011d
            float[] r12 = r12.values     // Catch:{  }
            java.lang.Object r12 = r12.clone()     // Catch:{  }
            float[] r12 = (float[]) r12     // Catch:{  }
            double[] r0 = r11.n     // Catch:{  }
            double[] r3 = r11.n     // Catch:{  }
            r4 = r3[r2]     // Catch:{  }
            r6 = 4605380979056443392(0x3fe99999a0000000, double:0.800000011920929)
            double r4 = r4 * r6
            r3 = r12[r2]     // Catch:{  }
            r8 = 1045220556(0x3e4ccccc, float:0.19999999)
            float r3 = r3 * r8
            double r9 = (double) r3     // Catch:{  }
            double r4 = r4 + r9
            r0[r2] = r4     // Catch:{  }
            double[] r0 = r11.n     // Catch:{  }
            double[] r3 = r11.n     // Catch:{  }
            r4 = r3[r1]     // Catch:{  }
            double r4 = r4 * r6
            r3 = r12[r1]     // Catch:{  }
            float r3 = r3 * r8
            double r9 = (double) r3     // Catch:{  }
            double r4 = r4 + r9
            r0[r1] = r4     // Catch:{  }
            double[] r0 = r11.n     // Catch:{  }
            double[] r3 = r11.n     // Catch:{  }
            r4 = 2
            r9 = r3[r4]     // Catch:{  }
            double r6 = r6 * r9
            r3 = r12[r4]     // Catch:{  }
            float r8 = r8 * r3
            double r8 = (double) r8     // Catch:{  }
            double r6 = r6 + r8
            r0[r4] = r6     // Catch:{  }
            r0 = r12[r2]     // Catch:{  }
            double r5 = (double) r0     // Catch:{  }
            double[] r0 = r11.n     // Catch:{  }
            r2 = r0[r2]     // Catch:{  }
            double r5 = r5 - r2
            r11.j = r5     // Catch:{  }
            r0 = r12[r1]     // Catch:{  }
            double r2 = (double) r0     // Catch:{  }
            double[] r0 = r11.n     // Catch:{  }
            r5 = r0[r1]     // Catch:{  }
            double r2 = r2 - r5
            r11.k = r2     // Catch:{  }
            r12 = r12[r4]     // Catch:{  }
            double r0 = (double) r12     // Catch:{  }
            double[] r12 = r11.n     // Catch:{  }
            r2 = r12[r4]     // Catch:{  }
            double r0 = r0 - r2
            r11.l = r0     // Catch:{  }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{  }
            long r2 = r11.p     // Catch:{  }
            long r2 = r0 - r2
            r4 = 100
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x011d
            double r2 = r11.j     // Catch:{  }
            double r4 = r11.j     // Catch:{  }
            double r2 = r2 * r4
            double r4 = r11.k     // Catch:{  }
            double r6 = r11.k     // Catch:{  }
            double r4 = r4 * r6
            double r2 = r2 + r4
            double r4 = r11.l     // Catch:{  }
            double r6 = r11.l     // Catch:{  }
            double r4 = r4 * r6
            double r2 = r2 + r4
            double r2 = java.lang.Math.sqrt(r2)     // Catch:{  }
            long r4 = r11.q     // Catch:{  }
            r6 = 1
            long r4 = r4 + r6
            r11.q = r4     // Catch:{  }
            r11.p = r0     // Catch:{  }
            double r0 = r11.o     // Catch:{  }
            double r0 = r0 + r2
            r11.o = r0     // Catch:{  }
            long r0 = r11.q     // Catch:{  }
            r2 = 30
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x011d
            double r0 = r11.o     // Catch:{  }
            long r2 = r11.q     // Catch:{  }
            double r2 = (double) r2     // Catch:{  }
            double r0 = r0 / r2
            r11.m = r0     // Catch:{  }
            r0 = 0
            r11.o = r0     // Catch:{  }
            r0 = 0
            r11.q = r0     // Catch:{  }
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.by.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
