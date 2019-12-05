package com.amap.api.col.n3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.TextureView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* compiled from: GLTextureView */
public class j extends TextureView implements TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */
    public static final C0002j a = new C0002j((byte) 0);
    private final WeakReference<j> b = new WeakReference<>(this);
    private i c;
    /* access modifiers changed from: private */
    public GLSurfaceView.Renderer d;
    private boolean e;
    /* access modifiers changed from: private */
    public e f;
    /* access modifiers changed from: private */
    public f g;
    /* access modifiers changed from: private */
    public g h;
    /* access modifiers changed from: private */
    public k i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public boolean l;

    /* compiled from: GLTextureView */
    private abstract class a implements e {
        protected int[] a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            if (j.this.k == 2 || j.this.k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[(length + 2)];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (j.this.k == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                iArr = iArr2;
            }
            this.a = iArr;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.a, (EGLConfig[]) null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    /* compiled from: GLTextureView */
    private class b extends a {
        protected int c = 8;
        protected int d = 8;
        protected int e = 8;
        protected int f = 0;
        protected int g = 16;
        protected int h = 0;
        private int[] j = new int[1];

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
        }

        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j)) {
                return this.j[0];
            }
            return 0;
        }
    }

    /* compiled from: GLTextureView */
    private class c implements f {
        private int b;

        private c() {
            this.b = 12440;
        }

        /* synthetic */ c(j jVar, byte b2) {
            this();
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, j.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (j.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                "display:" + eGLDisplay + " context: " + eGLContext;
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLTextureView */
    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView */
    private static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<j> f;

        public h(WeakReference<j> weakReference) {
            this.f = weakReference;
        }

        public final void a() {
            this.a = (EGL10) EGLContext.getEGL();
            this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.a.eglInitialize(this.b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            j jVar = (j) this.f.get();
            if (jVar == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = jVar.f.chooseConfig(this.a, this.b);
                this.e = jVar.g.createContext(this.a, this.b, this.d);
            }
            if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext", this.a.eglGetError());
            }
            this.c = null;
        }

        public final boolean b() {
            if (this.a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                f();
                j jVar = (j) this.f.get();
                if (jVar != null) {
                    this.c = jVar.h.a(this.a, this.b, this.d, jVar.getSurfaceTexture());
                } else {
                    this.c = null;
                }
                if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                    this.a.eglGetError();
                    return false;
                } else if (this.a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
                    return true;
                } else {
                    b("eglMakeCurrent", this.a.eglGetError());
                    return false;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final GL c() {
            GL gl = this.e.getGL();
            j jVar = (j) this.f.get();
            if (jVar == null) {
                return gl;
            }
            if (jVar.i != null) {
                gl = jVar.i.a();
            }
            if ((jVar.j & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((jVar.j & 1) != 0) {
                i = 1;
            }
            if ((jVar.j & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public final void d() {
            f();
        }

        private void f() {
            if (this.c != null && this.c != EGL10.EGL_NO_SURFACE) {
                this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                j jVar = (j) this.f.get();
                if (jVar != null) {
                    jVar.h.a(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public final void e() {
            if (this.e != null) {
                j jVar = (j) this.f.get();
                if (jVar != null) {
                    jVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            if (this.b != null) {
                this.a.eglTerminate(this.b);
                this.b = null;
            }
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }

    /* compiled from: GLTextureView */
    static class i extends Thread {
        private boolean a;
        /* access modifiers changed from: private */
        public boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private h s;
        private WeakReference<j> t;

        i(WeakReference<j> weakReference) {
            this.t = weakReference;
        }

        public final void run() {
            setName("GLThread " + getId());
            try {
                k();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                j.a.a(this);
                throw th;
            }
            j.a.a(this);
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.s.d();
            }
        }

        private void j() {
            if (this.h) {
                this.s.e();
                this.h = false;
                j.a.c(this);
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0165, code lost:
            if (r1.s.b() == false) goto L_0x017d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0167, code lost:
            r2 = com.amap.api.col.n3.j.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x016b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
            r1.j = true;
            com.amap.api.col.n3.j.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0176, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0177, code lost:
            r10 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x017d, code lost:
            r2 = com.amap.api.col.n3.j.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0181, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
            r1.j = true;
            r1.f = true;
            com.amap.api.col.n3.j.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x018e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0196, code lost:
            if (r11 == false) goto L_0x01a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0198, code lost:
            r2 = (javax.microedition.khronos.opengles.GL10) r1.s.c();
            com.amap.api.col.n3.j.d().a(r2);
            r7 = r2;
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01a9, code lost:
            if (r9 == false) goto L_0x01c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01ab, code lost:
            r2 = (com.amap.api.col.n3.j) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01b3, code lost:
            if (r2 == null) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01b5, code lost:
            com.amap.api.col.n3.j.h(r2).onSurfaceCreated(r7, r1.s.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c0, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c1, code lost:
            if (r12 == false) goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01c3, code lost:
            r2 = (com.amap.api.col.n3.j) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01cb, code lost:
            if (r2 == null) goto L_0x01d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01cd, code lost:
            com.amap.api.col.n3.j.h(r2).onSurfaceChanged(r7, r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x01d4, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x01d5, code lost:
            r2 = (com.amap.api.col.n3.j) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x01dd, code lost:
            if (r2 == null) goto L_0x01e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x01df, code lost:
            com.amap.api.col.n3.j.h(r2).onDrawFrame(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01e6, code lost:
            r2 = r1.s;
            r17 = r4;
            r18 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f8, code lost:
            if (r2.a.eglSwapBuffers(r2.b, r2.c) != false) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x01fa, code lost:
            r2 = r2.a.eglGetError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0201, code lost:
            r2 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0202, code lost:
            if (r2 == 12288) goto L_0x0225;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0206, code lost:
            if (r2 == 12302) goto L_0x0222;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0208, code lost:
            com.amap.api.col.n3.j.h.b("eglSwapBuffers", r2);
            r2 = com.amap.api.col.n3.j.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0211, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0212, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
            r1.f = true;
            com.amap.api.col.n3.j.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x021c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0222, code lost:
            r3 = true;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0225, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0226, code lost:
            r4 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0228, code lost:
            if (r15 == false) goto L_0x022d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x022a, code lost:
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x022d, code lost:
            r5 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0155, code lost:
            if (r8 == null) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x015d, code lost:
            if (r10 == false) goto L_0x0196;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void k() throws java.lang.InterruptedException {
            /*
                r19 = this;
                r1 = r19
                com.amap.api.col.n3.j$h r2 = new com.amap.api.col.n3.j$h
                java.lang.ref.WeakReference<com.amap.api.col.n3.j> r3 = r1.t
                r2.<init>(r3)
                r1.s = r2
                r2 = 0
                r1.h = r2
                r1.i = r2
                r4 = r2
                r5 = r4
                r6 = r5
                r9 = r6
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
                r7 = 0
            L_0x001b:
                r8 = 0
            L_0x001c:
                com.amap.api.col.n3.j$j r16 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0240 }
                monitor-enter(r16)     // Catch:{ all -> 0x0240 }
            L_0x0021:
                boolean r3 = r1.a     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x0037
                monitor-exit(r16)     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a
                monitor-enter(r2)
                r19.i()     // Catch:{ all -> 0x0033 }
                r19.j()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)
                throw r3
            L_0x0037:
                java.util.ArrayList<java.lang.Runnable> r3 = r1.q     // Catch:{ all -> 0x023c }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x023c }
                if (r3 != 0) goto L_0x004c
                java.util.ArrayList<java.lang.Runnable> r3 = r1.q     // Catch:{ all -> 0x023c }
                r8 = 0
                java.lang.Object r3 = r3.remove(r8)     // Catch:{ all -> 0x023c }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x023c }
                r8 = r3
                r3 = 0
                goto L_0x0154
            L_0x004c:
                boolean r3 = r1.d     // Catch:{ all -> 0x023c }
                boolean r2 = r1.c     // Catch:{ all -> 0x023c }
                if (r3 == r2) goto L_0x0060
                boolean r2 = r1.c     // Catch:{ all -> 0x023c }
                boolean r3 = r1.c     // Catch:{ all -> 0x023c }
                r1.d = r3     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r3.notifyAll()     // Catch:{ all -> 0x023c }
                goto L_0x0061
            L_0x0060:
                r2 = 0
            L_0x0061:
                boolean r3 = r1.k     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x006f
                r19.i()     // Catch:{ all -> 0x023c }
                r19.j()     // Catch:{ all -> 0x023c }
                r3 = 0
                r1.k = r3     // Catch:{ all -> 0x023c }
                r6 = 1
            L_0x006f:
                if (r4 == 0) goto L_0x0078
                r19.i()     // Catch:{ all -> 0x023c }
                r19.j()     // Catch:{ all -> 0x023c }
                r4 = 0
            L_0x0078:
                if (r2 == 0) goto L_0x0081
                boolean r3 = r1.i     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x0081
                r19.i()     // Catch:{ all -> 0x023c }
            L_0x0081:
                if (r2 == 0) goto L_0x00a6
                boolean r3 = r1.h     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x00a6
                java.lang.ref.WeakReference<com.amap.api.col.n3.j> r3 = r1.t     // Catch:{ all -> 0x023c }
                java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j r3 = (com.amap.api.col.n3.j) r3     // Catch:{ all -> 0x023c }
                if (r3 != 0) goto L_0x0093
                r3 = 0
                goto L_0x0097
            L_0x0093:
                boolean r3 = r3.l     // Catch:{ all -> 0x023c }
            L_0x0097:
                if (r3 == 0) goto L_0x00a3
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                boolean r3 = r3.a()     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x00a6
            L_0x00a3:
                r19.j()     // Catch:{ all -> 0x023c }
            L_0x00a6:
                if (r2 == 0) goto L_0x00b7
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                boolean r2 = r2.b()     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x00b7
                com.amap.api.col.n3.j$h r2 = r1.s     // Catch:{ all -> 0x023c }
                r2.e()     // Catch:{ all -> 0x023c }
            L_0x00b7:
                boolean r2 = r1.e     // Catch:{ all -> 0x023c }
                if (r2 != 0) goto L_0x00d3
                boolean r2 = r1.g     // Catch:{ all -> 0x023c }
                if (r2 != 0) goto L_0x00d3
                boolean r2 = r1.i     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x00c6
                r19.i()     // Catch:{ all -> 0x023c }
            L_0x00c6:
                r2 = 1
                r1.g = r2     // Catch:{ all -> 0x023c }
                r2 = 0
                r1.f = r2     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r2.notifyAll()     // Catch:{ all -> 0x023c }
            L_0x00d3:
                boolean r2 = r1.e     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x00e5
                boolean r2 = r1.g     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x00e5
                r2 = 0
                r1.g = r2     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r2.notifyAll()     // Catch:{ all -> 0x023c }
            L_0x00e5:
                if (r5 == 0) goto L_0x00f3
                r2 = 1
                r1.p = r2     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r2.notifyAll()     // Catch:{ all -> 0x023c }
                r5 = 0
                r15 = 0
            L_0x00f3:
                boolean r2 = r19.l()     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x0232
                boolean r2 = r1.h     // Catch:{ all -> 0x023c }
                if (r2 != 0) goto L_0x0126
                if (r6 == 0) goto L_0x0101
                r6 = 0
                goto L_0x0126
            L_0x0101:
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                boolean r2 = r2.b(r1)     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x0126
                com.amap.api.col.n3.j$h r2 = r1.s     // Catch:{ RuntimeException -> 0x011c }
                r2.a()     // Catch:{ RuntimeException -> 0x011c }
                r2 = 1
                r1.h = r2     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r2.notifyAll()     // Catch:{ all -> 0x023c }
                r9 = 1
                goto L_0x0126
            L_0x011c:
                r0 = move-exception
                r2 = r0
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r3.c(r1)     // Catch:{ all -> 0x023c }
                throw r2     // Catch:{ all -> 0x023c }
            L_0x0126:
                boolean r2 = r1.h     // Catch:{ all -> 0x023c }
                if (r2 == 0) goto L_0x0135
                boolean r2 = r1.i     // Catch:{ all -> 0x023c }
                if (r2 != 0) goto L_0x0135
                r2 = 1
                r1.i = r2     // Catch:{ all -> 0x023c }
                r2 = 1
                r11 = 1
                r12 = 1
                goto L_0x0136
            L_0x0135:
                r2 = r10
            L_0x0136:
                boolean r3 = r1.i     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x0231
                boolean r3 = r1.r     // Catch:{ all -> 0x023c }
                if (r3 == 0) goto L_0x0149
                int r13 = r1.l     // Catch:{ all -> 0x023c }
                int r14 = r1.m     // Catch:{ all -> 0x023c }
                r3 = 0
                r1.r = r3     // Catch:{ all -> 0x023c }
                r2 = 1
                r12 = 1
                r15 = 1
                goto L_0x014a
            L_0x0149:
                r3 = 0
            L_0x014a:
                r1.o = r3     // Catch:{ all -> 0x023c }
                com.amap.api.col.n3.j$j r10 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r10.notifyAll()     // Catch:{ all -> 0x023c }
                r10 = r2
            L_0x0154:
                monitor-exit(r16)     // Catch:{ all -> 0x023c }
                if (r8 == 0) goto L_0x015d
                r8.run()     // Catch:{ all -> 0x0240 }
                r2 = r3
                goto L_0x001b
            L_0x015d:
                if (r10 == 0) goto L_0x0196
                com.amap.api.col.n3.j$h r2 = r1.s     // Catch:{ all -> 0x0240 }
                boolean r2 = r2.b()     // Catch:{ all -> 0x0240 }
                if (r2 == 0) goto L_0x017d
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0240 }
                monitor-enter(r2)     // Catch:{ all -> 0x0240 }
                r10 = 1
                r1.j = r10     // Catch:{ all -> 0x0179 }
                com.amap.api.col.n3.j$j r10 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0179 }
                r10.notifyAll()     // Catch:{ all -> 0x0179 }
                monitor-exit(r2)     // Catch:{ all -> 0x0179 }
                r10 = r3
                goto L_0x0196
            L_0x0179:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x0240 }
                throw r3     // Catch:{ all -> 0x0240 }
            L_0x017d:
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0240 }
                monitor-enter(r2)     // Catch:{ all -> 0x0240 }
                r3 = 1
                r1.j = r3     // Catch:{ all -> 0x0192 }
                r1.f = r3     // Catch:{ all -> 0x0192 }
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0192 }
                r3.notifyAll()     // Catch:{ all -> 0x0192 }
                monitor-exit(r2)     // Catch:{ all -> 0x0192 }
            L_0x018f:
                r2 = 0
                goto L_0x001c
            L_0x0192:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x0240 }
                throw r3     // Catch:{ all -> 0x0240 }
            L_0x0196:
                if (r11 == 0) goto L_0x01a9
                com.amap.api.col.n3.j$h r2 = r1.s     // Catch:{ all -> 0x0240 }
                javax.microedition.khronos.opengles.GL r2 = r2.c()     // Catch:{ all -> 0x0240 }
                javax.microedition.khronos.opengles.GL10 r2 = (javax.microedition.khronos.opengles.GL10) r2     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0240 }
                r3.a((javax.microedition.khronos.opengles.GL10) r2)     // Catch:{ all -> 0x0240 }
                r7 = r2
                r11 = 0
            L_0x01a9:
                if (r9 == 0) goto L_0x01c1
                java.lang.ref.WeakReference<com.amap.api.col.n3.j> r2 = r1.t     // Catch:{ all -> 0x0240 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j r2 = (com.amap.api.col.n3.j) r2     // Catch:{ all -> 0x0240 }
                if (r2 == 0) goto L_0x01c0
                android.opengl.GLSurfaceView$Renderer r2 = r2.d     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j$h r3 = r1.s     // Catch:{ all -> 0x0240 }
                javax.microedition.khronos.egl.EGLConfig r3 = r3.d     // Catch:{ all -> 0x0240 }
                r2.onSurfaceCreated(r7, r3)     // Catch:{ all -> 0x0240 }
            L_0x01c0:
                r9 = 0
            L_0x01c1:
                if (r12 == 0) goto L_0x01d5
                java.lang.ref.WeakReference<com.amap.api.col.n3.j> r2 = r1.t     // Catch:{ all -> 0x0240 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j r2 = (com.amap.api.col.n3.j) r2     // Catch:{ all -> 0x0240 }
                if (r2 == 0) goto L_0x01d4
                android.opengl.GLSurfaceView$Renderer r2 = r2.d     // Catch:{ all -> 0x0240 }
                r2.onSurfaceChanged(r7, r13, r14)     // Catch:{ all -> 0x0240 }
            L_0x01d4:
                r12 = 0
            L_0x01d5:
                java.lang.ref.WeakReference<com.amap.api.col.n3.j> r2 = r1.t     // Catch:{ all -> 0x0240 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j r2 = (com.amap.api.col.n3.j) r2     // Catch:{ all -> 0x0240 }
                if (r2 == 0) goto L_0x01e6
                android.opengl.GLSurfaceView$Renderer r2 = r2.d     // Catch:{ all -> 0x0240 }
                r2.onDrawFrame(r7)     // Catch:{ all -> 0x0240 }
            L_0x01e6:
                com.amap.api.col.n3.j$h r2 = r1.s     // Catch:{ all -> 0x0240 }
                javax.microedition.khronos.egl.EGL10 r3 = r2.a     // Catch:{ all -> 0x0240 }
                r17 = r4
                javax.microedition.khronos.egl.EGLDisplay r4 = r2.b     // Catch:{ all -> 0x0240 }
                r18 = r5
                javax.microedition.khronos.egl.EGLSurface r5 = r2.c     // Catch:{ all -> 0x0240 }
                boolean r3 = r3.eglSwapBuffers(r4, r5)     // Catch:{ all -> 0x0240 }
                r4 = 12288(0x3000, float:1.7219E-41)
                if (r3 != 0) goto L_0x0201
                javax.microedition.khronos.egl.EGL10 r2 = r2.a     // Catch:{ all -> 0x0240 }
                int r2 = r2.eglGetError()     // Catch:{ all -> 0x0240 }
                goto L_0x0202
            L_0x0201:
                r2 = r4
            L_0x0202:
                if (r2 == r4) goto L_0x0225
                r3 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r3) goto L_0x0222
                java.lang.String r3 = "eglSwapBuffers"
                com.amap.api.col.n3.j.h.b(r3, r2)     // Catch:{ all -> 0x0240 }
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0240 }
                monitor-enter(r2)     // Catch:{ all -> 0x0240 }
                r3 = 1
                r1.f = r3     // Catch:{ all -> 0x021e }
                com.amap.api.col.n3.j$j r4 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x021e }
                r4.notifyAll()     // Catch:{ all -> 0x021e }
                monitor-exit(r2)     // Catch:{ all -> 0x021e }
                goto L_0x0226
            L_0x021e:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x0240 }
                throw r3     // Catch:{ all -> 0x0240 }
            L_0x0222:
                r3 = 1
                r4 = r3
                goto L_0x0228
            L_0x0225:
                r3 = 1
            L_0x0226:
                r4 = r17
            L_0x0228:
                if (r15 == 0) goto L_0x022d
                r5 = r3
                goto L_0x018f
            L_0x022d:
                r5 = r18
                goto L_0x018f
            L_0x0231:
                r10 = r2
            L_0x0232:
                com.amap.api.col.n3.j$j r2 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x023c }
                r2.wait()     // Catch:{ all -> 0x023c }
                r2 = 0
                goto L_0x0021
            L_0x023c:
                r0 = move-exception
                r2 = r0
                monitor-exit(r16)     // Catch:{ all -> 0x0240 }
                throw r2     // Catch:{ all -> 0x0240 }
            L_0x0240:
                r0 = move-exception
                r2 = r0
                com.amap.api.col.n3.j$j r3 = com.amap.api.col.n3.j.a
                monitor-enter(r3)
                r19.i()     // Catch:{ all -> 0x024f }
                r19.j()     // Catch:{ all -> 0x024f }
                monitor-exit(r3)     // Catch:{ all -> 0x024f }
                throw r2
            L_0x024f:
                r0 = move-exception
                r2 = r0
                monitor-exit(r3)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.k():void");
        }

        private boolean l() {
            if (this.d || !this.e || this.f || this.l <= 0 || this.m <= 0) {
                return false;
            }
            return this.o || this.n == 1;
        }

        public final void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (j.a) {
                this.n = i2;
                j.a.notifyAll();
            }
        }

        public final int a() {
            int i2;
            synchronized (j.a) {
                i2 = this.n;
            }
            return i2;
        }

        public final void b() {
            synchronized (j.a) {
                this.o = true;
                j.a.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c() {
            /*
                r2 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r1 = 1
                r2.e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.j = r1     // Catch:{ all -> 0x0030 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.c():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d() {
            /*
                r2 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r1 = 0
                r2.e = r1     // Catch:{ all -> 0x0029 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.g     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.d():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e() {
            /*
                r2 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r1 = 1
                r2.c = r1     // Catch:{ all -> 0x0029 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.d     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void f() {
            /*
                r3 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r1 = 0
                r3.c = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.o = r2     // Catch:{ all -> 0x0032 }
                r3.p = r1     // Catch:{ all -> 0x0032 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.d     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.p     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|21|22|34|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r2.l = r3     // Catch:{ all -> 0x0049 }
                r2.m = r4     // Catch:{ all -> 0x0049 }
                r3 = 1
                r2.r = r3     // Catch:{ all -> 0x0049 }
                r2.o = r3     // Catch:{ all -> 0x0049 }
                r4 = 0
                r2.p = r4     // Catch:{ all -> 0x0049 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0049 }
                r1.notifyAll()     // Catch:{ all -> 0x0049 }
            L_0x0018:
                boolean r1 = r2.b     // Catch:{ all -> 0x0049 }
                if (r1 != 0) goto L_0x0047
                boolean r1 = r2.d     // Catch:{ all -> 0x0049 }
                if (r1 != 0) goto L_0x0047
                boolean r1 = r2.p     // Catch:{ all -> 0x0049 }
                if (r1 != 0) goto L_0x0047
                boolean r1 = r2.h     // Catch:{ all -> 0x0049 }
                if (r1 == 0) goto L_0x0034
                boolean r1 = r2.i     // Catch:{ all -> 0x0049 }
                if (r1 == 0) goto L_0x0034
                boolean r1 = r2.l()     // Catch:{ all -> 0x0049 }
                if (r1 == 0) goto L_0x0034
                r1 = r3
                goto L_0x0035
            L_0x0034:
                r1 = r4
            L_0x0035:
                if (r1 == 0) goto L_0x0047
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x003f }
                r1.wait()     // Catch:{ InterruptedException -> 0x003f }
                goto L_0x0018
            L_0x003f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0049 }
                r1.interrupt()     // Catch:{ all -> 0x0049 }
                goto L_0x0018
            L_0x0047:
                monitor-exit(r0)     // Catch:{ all -> 0x0049 }
                return
            L_0x0049:
                r3 = move-exception
                monitor-exit(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.a(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g() {
            /*
                r2 = this;
                com.amap.api.col.n3.j$j r0 = com.amap.api.col.n3.j.a
                monitor-enter(r0)
                r1 = 1
                r2.a = r1     // Catch:{ all -> 0x0025 }
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.amap.api.col.n3.j$j r1 = com.amap.api.col.n3.j.a     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.j.i.g():void");
        }

        public final void h() {
            this.k = true;
            j.a.notifyAll();
        }

        public final void a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (j.a) {
                this.q.add(runnable);
                j.a.notifyAll();
            }
        }
    }

    /* renamed from: com.amap.api.col.n3.j$j  reason: collision with other inner class name */
    /* compiled from: GLTextureView */
    private static class C0002j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private C0002j() {
        }

        /* synthetic */ C0002j(byte b2) {
            this();
        }

        public final synchronized void a(i iVar) {
            boolean unused = iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public final boolean b(i iVar) {
            if (this.g == iVar || this.g == null) {
                this.g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            if (this.g == null) {
                return false;
            }
            this.g.h();
            return false;
        }

        public final void c(i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public final synchronized boolean a() {
            return this.f;
        }

        public final synchronized boolean b() {
            c();
            return !this.e;
        }

        public final synchronized void a(GL10 gl10) {
            if (!this.d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                if (this.c < 131072) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f = !this.e;
                this.d = true;
            }
        }

        private void c() {
            if (!this.b) {
                this.c = 131072;
                if (this.c >= 131072) {
                    this.e = true;
                }
                this.b = true;
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface k {
        GL a();
    }

    /* compiled from: GLTextureView */
    static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
        }

        public final void close() {
            a();
        }

        public final void flush() {
            a();
        }

        public final void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }

        private void a() {
            if (this.a.length() > 0) {
                this.a.toString();
                this.a.delete(0, this.a.length());
            }
        }
    }

    /* compiled from: GLTextureView */
    private class m extends b {
        public m() {
            super();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public j(Context context) {
        super(context, (AttributeSet) null);
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.c != null) {
                this.c.g();
            }
        } finally {
            super.finalize();
        }
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        a();
        if (this.f == null) {
            this.f = new m();
        }
        if (this.g == null) {
            this.g = new c(this, (byte) 0);
        }
        if (this.h == null) {
            this.h = new d((byte) 0);
        }
        this.d = renderer;
        this.c = new i(this.b);
        this.c.start();
    }

    public final void a(f fVar) {
        a();
        this.g = fVar;
    }

    public final void a(e eVar) {
        a();
        this.f = eVar;
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void requestRender() {
        this.c.b();
    }

    public int getRenderMode() {
        return this.c.a();
    }

    public void b() {
        this.c.e();
    }

    public void c() {
        this.c.f();
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            int a2 = this.c != null ? this.c.a() : 1;
            this.c = new i(this.b);
            if (a2 != 1) {
                this.c.a(a2);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.c != null) {
            this.c.g();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    private void a() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.c();
        onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.d();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }
}
