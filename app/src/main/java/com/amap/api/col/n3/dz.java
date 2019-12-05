package com.amap.api.col.n3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.col.n3.cu;
import com.amap.api.col.n3.dw;
import java.lang.ref.WeakReference;

/* compiled from: ImageWorker */
public abstract class dz {
    /* access modifiers changed from: private */
    public dw a;
    private dw.a b;
    protected boolean c = false;
    protected Resources d;
    /* access modifiers changed from: private */
    public boolean e = false;
    /* access modifiers changed from: private */
    public final Object f = new Object();

    /* compiled from: ImageWorker */
    public class a extends dd<Boolean, Void, Bitmap> {
        private final WeakReference<cu.a> e;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void a(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            try {
                if (c() || dz.this.e) {
                    bitmap = null;
                }
                cu.a e2 = e();
                if (bitmap != null && !bitmap.isRecycled() && e2 != null) {
                    e2.a(bitmap);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void b(Object obj) {
            super.b((Bitmap) obj);
            synchronized (dz.this.f) {
                try {
                    dz.this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public a(cu.a aVar) {
            this.e = new WeakReference<>(aVar);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b1, code lost:
            r6.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b4, code lost:
            return null;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap a(java.lang.Boolean... r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                r6 = r6[r0]     // Catch:{ Throwable -> 0x00b0 }
                boolean r6 = r6.booleanValue()     // Catch:{ Throwable -> 0x00b0 }
                java.lang.ref.WeakReference<com.amap.api.col.n3.cu$a> r0 = r5.e     // Catch:{ Throwable -> 0x00b0 }
                java.lang.Object r0 = r0.get()     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.cu$a r0 = (com.amap.api.col.n3.cu.a) r0     // Catch:{ Throwable -> 0x00b0 }
                if (r0 != 0) goto L_0x0013
                return r1
            L_0x0013:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00b0 }
                r2.<init>()     // Catch:{ Throwable -> 0x00b0 }
                int r3 = r0.a     // Catch:{ Throwable -> 0x00b0 }
                r2.append(r3)     // Catch:{ Throwable -> 0x00b0 }
                java.lang.String r3 = "-"
                r2.append(r3)     // Catch:{ Throwable -> 0x00b0 }
                int r3 = r0.b     // Catch:{ Throwable -> 0x00b0 }
                r2.append(r3)     // Catch:{ Throwable -> 0x00b0 }
                java.lang.String r3 = "-"
                r2.append(r3)     // Catch:{ Throwable -> 0x00b0 }
                int r3 = r0.c     // Catch:{ Throwable -> 0x00b0 }
                r2.append(r3)     // Catch:{ Throwable -> 0x00b0 }
                java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.dz r3 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                java.lang.Object r3 = r3.f     // Catch:{ Throwable -> 0x00b0 }
                monitor-enter(r3)     // Catch:{ Throwable -> 0x00b0 }
            L_0x003c:
                com.amap.api.col.n3.dz r4 = com.amap.api.col.n3.dz.this     // Catch:{ all -> 0x00ad }
                boolean r4 = r4.c     // Catch:{ all -> 0x00ad }
                if (r4 == 0) goto L_0x0052
                boolean r4 = r5.c()     // Catch:{ all -> 0x00ad }
                if (r4 != 0) goto L_0x0052
                com.amap.api.col.n3.dz r4 = com.amap.api.col.n3.dz.this     // Catch:{ all -> 0x00ad }
                java.lang.Object r4 = r4.f     // Catch:{ all -> 0x00ad }
                r4.wait()     // Catch:{ all -> 0x00ad }
                goto L_0x003c
            L_0x0052:
                monitor-exit(r3)     // Catch:{ all -> 0x00ad }
                com.amap.api.col.n3.dz r3 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.dw r3 = r3.a     // Catch:{ Throwable -> 0x00b0 }
                if (r3 == 0) goto L_0x007a
                boolean r3 = r5.c()     // Catch:{ Throwable -> 0x00b0 }
                if (r3 != 0) goto L_0x007a
                com.amap.api.col.n3.cu$a r3 = r5.e()     // Catch:{ Throwable -> 0x00b0 }
                if (r3 == 0) goto L_0x007a
                com.amap.api.col.n3.dz r3 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                boolean r3 = r3.e     // Catch:{ Throwable -> 0x00b0 }
                if (r3 != 0) goto L_0x007a
                com.amap.api.col.n3.dz r3 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.dw r3 = r3.a     // Catch:{ Throwable -> 0x00b0 }
                android.graphics.Bitmap r3 = r3.b(r2)     // Catch:{ Throwable -> 0x00b0 }
                goto L_0x007b
            L_0x007a:
                r3 = r1
            L_0x007b:
                if (r6 == 0) goto L_0x0099
                if (r3 != 0) goto L_0x0099
                boolean r6 = r5.c()     // Catch:{ Throwable -> 0x00b0 }
                if (r6 != 0) goto L_0x0099
                com.amap.api.col.n3.cu$a r6 = r5.e()     // Catch:{ Throwable -> 0x00b0 }
                if (r6 == 0) goto L_0x0099
                com.amap.api.col.n3.dz r6 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                boolean r6 = r6.e     // Catch:{ Throwable -> 0x00b0 }
                if (r6 != 0) goto L_0x0099
                com.amap.api.col.n3.dz r6 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                android.graphics.Bitmap r3 = r6.a((java.lang.Object) r0)     // Catch:{ Throwable -> 0x00b0 }
            L_0x0099:
                if (r3 == 0) goto L_0x00ac
                com.amap.api.col.n3.dz r6 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.dw r6 = r6.a     // Catch:{ Throwable -> 0x00b0 }
                if (r6 == 0) goto L_0x00ac
                com.amap.api.col.n3.dz r6 = com.amap.api.col.n3.dz.this     // Catch:{ Throwable -> 0x00b0 }
                com.amap.api.col.n3.dw r6 = r6.a     // Catch:{ Throwable -> 0x00b0 }
                r6.a((java.lang.String) r2, (android.graphics.Bitmap) r3)     // Catch:{ Throwable -> 0x00b0 }
            L_0x00ac:
                return r3
            L_0x00ad:
                r6 = move-exception
                monitor-exit(r3)     // Catch:{ Throwable -> 0x00b0 }
                throw r6     // Catch:{ Throwable -> 0x00b0 }
            L_0x00b0:
                r6 = move-exception
                r6.printStackTrace()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dz.a.a(java.lang.Boolean[]):android.graphics.Bitmap");
        }

        private cu.a e() {
            cu.a aVar = (cu.a) this.e.get();
            if (this == dz.c(aVar)) {
                return aVar;
            }
            return null;
        }
    }

    /* compiled from: ImageWorker */
    protected class b extends dd<Object, Void, Void> {
        protected b() {
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public Void a(Object... objArr) {
            try {
                switch (objArr[0].intValue()) {
                    case 0:
                        dz.this.c();
                        return null;
                    case 1:
                        dz.this.b();
                        return null;
                    case 2:
                        dz.this.d();
                        return null;
                    case 3:
                        dz.this.e();
                        return null;
                    default:
                        return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap a(Object obj);

    protected dz(Context context) {
        this.d = context.getResources();
    }

    public final void a(boolean z, cu.a aVar) {
        if (aVar != null) {
            Bitmap bitmap = null;
            try {
                if (this.a != null) {
                    bitmap = this.a.a(aVar.a + "-" + aVar.b + "-" + aVar.c);
                }
                if (bitmap != null) {
                    aVar.a(bitmap);
                    return;
                }
                a aVar2 = new a(aVar);
                aVar.j = aVar2;
                aVar2.a(dd.c, (Params[]) new Boolean[]{Boolean.valueOf(z)});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(dw.a aVar) {
        this.b = aVar;
        this.a = dw.a(this.b);
        new b().b((Params[]) new Object[]{1});
    }

    /* access modifiers changed from: protected */
    public final dw a() {
        return this.a;
    }

    public static void a(cu.a aVar) {
        a c2 = c(aVar);
        if (c2 != null) {
            c2.d();
        }
    }

    /* access modifiers changed from: private */
    public static a c(cu.a aVar) {
        if (aVar != null) {
            return aVar.j;
        }
        return null;
    }

    public final void a(boolean z) {
        synchronized (this.f) {
            this.c = z;
            if (!this.c) {
                try {
                    this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (this.a != null) {
            this.a.a();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.a != null) {
            this.a.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (this.a != null) {
            this.a.c();
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        if (this.a != null) {
            this.a.d();
            this.a = null;
        }
    }

    public final void f() {
        new b().b((Params[]) new Object[]{0});
    }

    public final void g() {
        new b().b((Params[]) new Object[]{3});
    }
}
