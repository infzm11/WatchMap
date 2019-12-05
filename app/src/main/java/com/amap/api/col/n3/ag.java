package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.amap.api.col.n3.cw;
import com.amap.api.maps.model.BitmapDescriptor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: FakeInstanceMultiPoint */
public final class ag {
    public static int a = 200;
    float[] b = null;
    int c = 0;
    int d = 0;
    private int e = 6;
    private boolean f = false;
    private boolean g = false;
    private BitmapDescriptor h;
    private FloatBuffer i;
    private FloatBuffer j;
    private ShortBuffer k;
    private int l = 0;
    private cw.a m;
    private cw n;

    public ag(float[] fArr) {
        this.b = fArr;
    }

    public final void a() {
        if (this.b != null && !this.f) {
            float[] fArr = this.b;
            if (fArr != null) {
                if (this.i == null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * a * 4);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    this.i = allocateDirect.asFloatBuffer();
                }
                this.i.clear();
                for (int i2 = 0; i2 < a; i2++) {
                    int i3 = 0;
                    for (float f2 : fArr) {
                        if (i3 % this.e == 3) {
                            this.i.put((float) i2);
                        } else {
                            this.i.put(f2);
                        }
                        i3++;
                    }
                }
                this.i.position(0);
                if (this.k == null) {
                    ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(a * 6 * 2);
                    allocateDirect2.order(ByteOrder.nativeOrder());
                    this.k = allocateDirect2.asShortBuffer();
                    short[] sArr = new short[(a * 6)];
                    for (int i4 = 0; i4 < a; i4++) {
                        int i5 = 6 * i4;
                        int i6 = 4 * i4;
                        short s = (short) (i6 + 0);
                        sArr[i5 + 0] = s;
                        sArr[i5 + 1] = (short) (i6 + 1);
                        short s2 = (short) (i6 + 2);
                        sArr[i5 + 2] = s2;
                        sArr[i5 + 3] = s;
                        sArr[i5 + 4] = s2;
                        sArr[i5 + 5] = (short) (i6 + 3);
                    }
                    this.k.put(sArr);
                    this.k.flip();
                }
                this.f = true;
            }
        }
    }

    public final void a(BitmapDescriptor bitmapDescriptor) {
        this.h = bitmapDescriptor;
    }

    public final boolean b() {
        return this.f;
    }

    public final void a(float[] fArr, float[] fArr2, float[] fArr3, float f2, float f3, float f4, float f5, int i2) {
        int i3 = i2;
        if (!this.g && this.h != null) {
            Bitmap bitmap = this.h.getBitmap();
            if (bitmap != null) {
                if (this.l == 0) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    this.l = iArr[0];
                }
                if (this.l != 0) {
                    GLES20.glBindTexture(3553, this.l);
                    GLES20.glTexParameterf(3553, 10241, 9728.0f);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    if (this.l != 0) {
                        this.g = true;
                    }
                }
            }
        }
        if (this.l != 0) {
            if (this.m == null || this.m.b()) {
                try {
                    if (this.n != null) {
                        this.m = (cw.a) this.n.a(4);
                    }
                } catch (Throwable unused) {
                    a = 1;
                    if (this.n != null) {
                        this.m = (cw.a) this.n.a(4);
                    }
                }
            }
            if (this.c == 0) {
                int[] iArr2 = new int[2];
                GLES20.glGenBuffers(2, iArr2, 0);
                this.c = iArr2[0];
                this.d = iArr2[1];
                GLES20.glBindBuffer(34962, this.c);
                GLES20.glBufferData(34962, this.i.limit() * 4, this.i, 35044);
                GLES20.glBindBuffer(34963, this.d);
                GLES20.glBufferData(34963, a * 6 * 2, this.k, 35044);
                a("bindVbo");
                this.i.clear();
                this.i = null;
            }
            GLES20.glUseProgram(this.m.d);
            GLES20.glUniform4f(this.m.j, f2, f3, f4, f5);
            GLES20.glUniform3fv(this.m.i, i3, fArr3, 0);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glBindTexture(3553, this.l);
            GLES20.glEnableVertexAttribArray(this.m.c);
            GLES20.glBindBuffer(34962, this.c);
            GLES20.glVertexAttribPointer(this.m.c, 4, 5126, false, this.e * 4, 0);
            GLES20.glEnableVertexAttribArray(this.m.h);
            GLES20.glVertexAttribPointer(this.m.h, 2, 5126, false, this.e * 4, 16);
            GLES20.glUniformMatrix4fv(this.m.g, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.m.k, 1, false, fArr2, 0);
            GLES20.glBindBuffer(34963, this.d);
            GLES20.glDrawElements(4, 6 * i3, 5123, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisableVertexAttribArray(this.m.c);
            GLES20.glDisableVertexAttribArray(this.m.h);
            GLES20.glUseProgram(0);
        }
    }

    public final void c() {
        if (this.i != null) {
            this.i.clear();
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.k != null) {
            this.k.clear();
        }
        if (this.h != null) {
            this.h.recycle();
        }
        GLES20.glDeleteBuffers(2, new int[]{this.c, this.d}, 0);
        if (this.l != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.l}, 0);
        }
        this.c = 0;
        this.d = 0;
        this.b = null;
        this.f = false;
        this.g = false;
        this.c = 0;
        this.d = 0;
        this.n = null;
    }

    public final void a(cw cwVar) {
        this.n = cwVar;
    }

    private static synchronized void a(String str) {
        synchronized (ag.class) {
            if (GLES20.glGetError() != 0) {
                str + ": glError " + r1;
                throw new RuntimeException(str + ": glError " + r1);
            }
        }
    }
}
