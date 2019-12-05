package com.amap.api.maps.model;

import android.graphics.Color;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient {
    private int a;
    private int[] b;
    private float[] c;
    private boolean d;

    private class a {
        /* access modifiers changed from: private */
        public final int b;
        /* access modifiers changed from: private */
        public final int c;
        /* access modifiers changed from: private */
        public final float d;

        /* synthetic */ a(Gradient gradient, int i, int i2, float f, byte b2) {
            this(i, i2, f);
        }

        private a(int i, int i2, float f) {
            this.b = i;
            this.c = i2;
            this.d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private Gradient(int[] iArr, float[] fArr, byte b2) {
        this.d = true;
        if (iArr == null || fArr == null) {
            throw new AMapException("colors and startPoints should not be null");
        }
        try {
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            } else if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            } else {
                for (int i = 1; i < fArr.length; i++) {
                    if (fArr[i] <= fArr[i - 1]) {
                        throw new AMapException("startPoints should be in increasing order");
                    }
                }
                this.a = 1000;
                this.b = new int[iArr.length];
                this.c = new float[fArr.length];
                System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                System.arraycopy(fArr, 0, this.c, 0, fArr.length);
                this.d = true;
            }
        } catch (AMapException e) {
            this.d = false;
            e.getErrorMessage();
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public int[] generateColorMap(double d2) {
        HashMap hashMap = new HashMap();
        if (this.c[0] != 0.0f) {
            a aVar = new a(this, Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0])), this.b[0], ((float) this.a) * this.c[0], (byte) 0);
            hashMap.put(0, aVar);
        }
        for (int i = 1; i < this.b.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (((float) this.a) * this.c[i2]));
            a aVar2 = new a(this, this.b[i2], this.b[i], ((float) this.a) * (this.c[i] - this.c[i2]), (byte) 0);
            hashMap.put(valueOf, aVar2);
        }
        if (this.c[this.c.length - 1] != 1.0f) {
            int length = this.c.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (((float) this.a) * this.c[length]));
            a aVar3 = new a(this, this.b[length], this.b[length], ((float) this.a) * (1.0f - this.c[length]), (byte) 0);
            hashMap.put(valueOf2, aVar3);
        }
        int[] iArr = new int[this.a];
        int i3 = 0;
        a aVar4 = (a) hashMap.get(0);
        for (int i4 = 0; i4 < this.a; i4++) {
            if (hashMap.containsKey(Integer.valueOf(i4))) {
                aVar4 = (a) hashMap.get(Integer.valueOf(i4));
                i3 = i4;
            }
            iArr[i4] = a(aVar4.b, aVar4.c, ((float) (i4 - i3)) / aVar4.d);
        }
        if (d2 != 1.0d) {
            for (int i5 = 0; i5 < this.a; i5++) {
                int i6 = iArr[i5];
                iArr[i5] = Color.argb((int) (((double) Color.alpha(i6)) * d2), Color.red(i6), Color.green(i6), Color.blue(i6));
            }
        }
        return iArr;
    }

    private static int a(int i, int i2, float f) {
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.d;
    }
}
