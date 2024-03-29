package com.amap.api.col.n3;

import android.graphics.Color;
import android.opengl.GLES20;
import com.amap.api.col.n3.cw;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: GLESUtility */
public final class dh {

    /* compiled from: GLESUtility */
    public static class a extends di {
        private static int g = 4;
        protected int a = 5;
        protected int b = 6;
        protected int c = 5;
        protected int d = 0;
        protected int e = 16;
        protected int f = 8;
        private int[] h = new int[1];

        private int[] a(boolean z) {
            return new int[]{12324, this.a, 12323, this.b, 12322, this.c, 12321, this.d, 12325, this.e, 12326, this.f, 12338, z, 12352, g, 12344};
        }

        private c a(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            cVar.a = a(true);
            egl10.eglChooseConfig(eGLDisplay, cVar.a, (EGLConfig[]) null, 0, cVar.b);
            if (cVar.b[0] <= 0) {
                cVar.a = a(false);
                egl10.eglChooseConfig(eGLDisplay, cVar.a, (EGLConfig[]) null, 0, cVar.b);
                if (cVar.b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            c a2 = a(egl10, eGLDisplay);
            if (a2 == null || a2.a == null) {
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[a2.b[0]];
            egl10.eglChooseConfig(eGLDisplay, a2.a, eGLConfigArr, a2.b[0], a2.b);
            EGLConfig a3 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a3 != null) {
                return a3;
            }
            this.a = 8;
            this.b = 8;
            this.c = 8;
            c a4 = a(egl10, eGLDisplay);
            if (a4 == null || a4.a == null) {
                return a3;
            }
            EGLConfig[] eGLConfigArr2 = new EGLConfig[a4.b[0]];
            egl10.eglChooseConfig(eGLDisplay, a4.a, eGLConfigArr2, a4.b[0], a4.b);
            return a(egl10, eGLDisplay, eGLConfigArr2);
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.e && a3 >= this.f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.a && a5 == this.b && a6 == this.c && a7 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.h)) {
                return this.h[0];
            }
            return 0;
        }
    }

    /* compiled from: GLESUtility */
    public static class b extends dj {
        private static int a = 12440;

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{a, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* compiled from: GLESUtility */
    private static class c {
        public int[] a;
        public int[] b;

        private c() {
            this.a = null;
            this.b = new int[1];
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    public static void a(cw.d dVar, int i, int i2, FloatBuffer floatBuffer, float f, FloatBuffer floatBuffer2, int i3, int i4, float[] fArr) {
        b(dVar, 4, i, floatBuffer2, 1.0f, i4, fArr);
        b(dVar, 2, i2, floatBuffer, f, i3, fArr);
    }

    public static void a(cw.d dVar, int i, FloatBuffer floatBuffer, float f, int i2, float[] fArr) {
        b(dVar, 3, i, floatBuffer, f, i2, fArr);
    }

    public static void a(cw.d dVar, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr) {
        cw.d dVar2 = dVar;
        FloatBuffer floatBuffer2 = floatBuffer;
        b(dVar2, 6, i, floatBuffer2, 1.0f, i3, fArr);
        a(dVar2, 2, i2, floatBuffer2, f, 1, i3 - 1, fArr);
    }

    private static void b(cw.d dVar, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr) {
        a(dVar, i, i2, floatBuffer, f, 0, i3, fArr);
    }

    private static void a(cw.d dVar, int i, int i2, FloatBuffer floatBuffer, float f, int i3, int i4, float[] fArr) {
        cw.d dVar2 = dVar;
        if (f != 0.0f && dVar2 != null) {
            GLES20.glUseProgram(dVar2.d);
            GLES20.glEnable(3042);
            GLES20.glDisable(2929);
            GLES20.glBlendFunc(770, 771);
            float[] fArr2 = {((float) Color.red(i2)) / 255.0f, ((float) Color.green(i2)) / 255.0f, ((float) Color.blue(i2)) / 255.0f, ((float) Color.alpha(i2)) / 255.0f};
            GLES20.glLineWidth(f);
            GLES20.glEnableVertexAttribArray(dVar2.b);
            GLES20.glVertexAttribPointer(dVar2.b, 3, 5126, false, 0, floatBuffer);
            GLES20.glUniform4fv(dVar2.c, 1, fArr2, 0);
            GLES20.glUniformMatrix4fv(dVar2.a, 1, false, fArr, 0);
            GLES20.glDrawArrays(i, i3, i4);
            GLES20.glDisableVertexAttribArray(dVar2.b);
            GLES20.glDisable(3042);
            GLES20.glUseProgram(0);
        }
    }

    public static void a(l lVar) {
        lVar.a((dj) new b());
        lVar.a((di) new a());
    }
}
