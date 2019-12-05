package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DynamicLoader */
final class jv extends jq {
    private PublicKey g = null;

    jv(final Context context, im imVar) throws Exception {
        super(context, imVar);
        final String b = js.b(context, imVar.a(), imVar.b());
        final String a = js.a(context);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(a)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
        new File(b);
        String str = a + File.separator + js.a(r1.getName());
        try {
            if (this.c == null) {
                b();
                this.c = DexFile.loadDex(b, str, 0);
            }
            iu.c().submit(new Runnable() {
                public final void run() {
                    try {
                        jv.this.a(context, b, a);
                    } catch (Throwable th) {
                        ir.a(th, "dLoader", "run()");
                    }
                }
            });
        } catch (Throwable th) {
            ir.a(th, "dLoader", "loadFile");
            throw new Exception("load file fail");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.amap.api.col.n3.ir.a(r1, "dLoader", "findCl");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0051, code lost:
        com.amap.api.col.n3.ir.a(r0, "dLoader", "findCl");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x005d, code lost:
        throw new java.lang.ClassNotFoundException(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x005e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x005f, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005e A[ExcHandler: ClassNotFoundException (r6v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<?> findClass(java.lang.String r6) throws java.lang.ClassNotFoundException {
        /*
            r5 = this;
            dalvik.system.DexFile r0 = r5.c     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            if (r0 != 0) goto L_0x000a
            java.lang.ClassNotFoundException r0 = new java.lang.ClassNotFoundException     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            r0.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
        L_0x000a:
            r0 = 0
            java.util.Map r1 = r5.b     // Catch:{ Throwable -> 0x0020, ClassNotFoundException -> 0x005e }
            monitor-enter(r1)     // Catch:{ Throwable -> 0x0020, ClassNotFoundException -> 0x005e }
            java.util.Map r2 = r5.b     // Catch:{ all -> 0x001d }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x001d }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            goto L_0x0029
        L_0x0018:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x001e
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            monitor-exit(r1)     // Catch:{ Throwable -> 0x0020, ClassNotFoundException -> 0x005e }
            throw r2     // Catch:{ Throwable -> 0x0020, ClassNotFoundException -> 0x005e }
        L_0x0020:
            r1 = move-exception
            r2 = r0
            java.lang.String r0 = "dLoader"
            java.lang.String r3 = "findCl"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r1, (java.lang.String) r0, (java.lang.String) r3)     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
        L_0x0029:
            if (r2 == 0) goto L_0x002c
            return r2
        L_0x002c:
            dalvik.system.DexFile r0 = r5.c     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            java.lang.Class r0 = r0.loadClass(r6, r5)     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            if (r0 != 0) goto L_0x003a
            java.lang.ClassNotFoundException r0 = new java.lang.ClassNotFoundException     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            r0.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
        L_0x003a:
            java.util.Map r1 = r5.b     // Catch:{ Throwable -> 0x0047, ClassNotFoundException -> 0x005e }
            monitor-enter(r1)     // Catch:{ Throwable -> 0x0047, ClassNotFoundException -> 0x005e }
            java.util.Map r2 = r5.b     // Catch:{ all -> 0x0044 }
            r2.put(r6, r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ Throwable -> 0x0047, ClassNotFoundException -> 0x005e }
            throw r2     // Catch:{ Throwable -> 0x0047, ClassNotFoundException -> 0x005e }
        L_0x0047:
            r1 = move-exception
            java.lang.String r2 = "dLoader"
            java.lang.String r3 = "findCl"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ ClassNotFoundException -> 0x005e, Throwable -> 0x0050 }
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
            java.lang.String r1 = "dLoader"
            java.lang.String r2 = "findCl"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.ClassNotFoundException r0 = new java.lang.ClassNotFoundException
            r0.<init>(r6)
            throw r0
        L_0x005e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jv.findClass(java.lang.String):java.lang.Class");
    }

    private static void a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream2.read(new byte[8192]) > 0);
                try {
                    jy.a((Closeable) inputStream2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                jy.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ir.a(th, "DyLoader", "loadJa");
            jy.a((Closeable) inputStream);
        }
    }

    private boolean a(Certificate[] certificateArr) {
        try {
            if (certificateArr.length <= 0) {
                return false;
            }
            int length = certificateArr.length - 1;
            if (length < 0) {
                return false;
            }
            certificateArr[length].verify(this.g);
            return true;
        } catch (Exception e) {
            ir.a((Throwable) e, "DyLoader", "check");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0044 A[SYNTHETIC, Splitter:B:37:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x004a A[SYNTHETIC, Splitter:B:42:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.security.PublicKey r2 = r4.g     // Catch:{ Throwable -> 0x003a }
            if (r2 != 0) goto L_0x000c
            java.security.PublicKey r2 = com.amap.api.col.n3.jy.a()     // Catch:{ Throwable -> 0x003a }
            r4.g = r2     // Catch:{ Throwable -> 0x003a }
        L_0x000c:
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ Throwable -> 0x003a }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x003a }
            java.lang.String r5 = "classes.dex"
            java.util.jar.JarEntry r5 = r2.getJarEntry(r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            if (r5 != 0) goto L_0x001d
            r2.close()     // Catch:{ Throwable -> 0x001c }
        L_0x001c:
            return r0
        L_0x001d:
            a(r2, r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            java.security.cert.Certificate[] r5 = r5.getCertificates()     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            if (r5 != 0) goto L_0x002a
            r2.close()     // Catch:{ Throwable -> 0x0029 }
        L_0x0029:
            return r0
        L_0x002a:
            boolean r5 = r4.a((java.security.cert.Certificate[]) r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            r2.close()     // Catch:{ Throwable -> 0x0031 }
        L_0x0031:
            return r5
        L_0x0032:
            r5 = move-exception
            r1 = r2
            goto L_0x0048
        L_0x0035:
            r5 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x0038:
            r5 = move-exception
            goto L_0x0048
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            java.lang.String r2 = "DyLoader"
            java.lang.String r3 = "verify"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ Throwable -> 0x0047 }
        L_0x0047:
            return r0
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ Throwable -> 0x004d }
        L_0x004d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jv.a(java.io.File):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f0 A[Catch:{ Throwable -> 0x00f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Exception {
        /*
            r10 = this;
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            r0.getTime()
            com.amap.api.col.n3.ja r0 = new com.amap.api.col.n3.ja     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.ju r1 = com.amap.api.col.n3.ju.a()     // Catch:{ Throwable -> 0x00f8 }
            r0.<init>(r11, r1)     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r11 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r11.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.jw r12 = com.amap.api.col.n3.js.a.a(r0, r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0026
            java.lang.String r12 = r12.e()     // Catch:{ Throwable -> 0x00f8 }
            r10.f = r12     // Catch:{ Throwable -> 0x00f8 }
        L_0x0026:
            com.amap.api.col.n3.im r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r2 = r10.a((java.io.File) r2)     // Catch:{ Throwable -> 0x00f8 }
            r3 = 0
            if (r2 == 0) goto L_0x004b
            android.content.Context r2 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r4 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r5 = r12.b()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r2 = com.amap.api.col.n3.js.a((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = com.amap.api.col.n3.jy.a(r0, r2, r1, r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x004c
        L_0x004b:
            r12 = r3
        L_0x004c:
            if (r12 != 0) goto L_0x0070
            r10.d = r3     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.js.a((android.content.Context) r12, (com.amap.api.col.n3.ja) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r1 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.amap.api.col.n3.js.a((android.content.Context) r12, (com.amap.api.col.n3.ja) r0, (com.amap.api.col.n3.im) r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r1 != 0) goto L_0x0070
            r10.f = r12     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r1 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.js.a((android.content.Context) r12, (com.amap.api.col.n3.im) r1)     // Catch:{ Throwable -> 0x00f8 }
        L_0x0070:
            boolean r12 = r11.exists()     // Catch:{ Throwable -> 0x00f8 }
            if (r12 != 0) goto L_0x0077
            return
        L_0x0077:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f8 }
            r12.<init>()     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = java.io.File.separator     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = com.amap.api.col.n3.js.a((java.lang.String) r13)     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r13 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r13.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = r13.exists()     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0100
            java.lang.String r11 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.amap.api.col.n3.js.a((java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r9 = r10.f     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.amap.api.col.n3.js.a((android.content.Context) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r13 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = com.amap.api.col.n3.jy.a(r0, r11, r12, r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.amap.api.col.n3.jw r13 = com.amap.api.col.n3.js.a.a(r0, r11)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 == 0) goto L_0x00bd
            goto L_0x00ee
        L_0x00bd:
            java.lang.String r13 = r10.f     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.amap.api.col.n3.jw$a r13 = new com.amap.api.col.n3.jw$a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r6 = com.amap.api.col.n3.ij.a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r7 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r8 = r12.b()     // Catch:{ Throwable -> 0x00f8 }
            r4 = r13
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = "useod"
            com.amap.api.col.n3.jw$a r12 = r13.a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.jw r12 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.amap.api.col.n3.jw.b(r11)     // Catch:{ Throwable -> 0x00f8 }
            r0.a((java.lang.Object) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
        L_0x00ed:
            r3 = 1
        L_0x00ee:
            if (r3 != 0) goto L_0x0100
            android.content.Context r11 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.im r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            com.amap.api.col.n3.js.a((android.content.Context) r11, (com.amap.api.col.n3.im) r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x0100
        L_0x00f8:
            r11 = move-exception
            java.lang.String r12 = "dLoader"
            java.lang.String r13 = "verifyD()"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.String) r13)
        L_0x0100:
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            r11.getTime()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jv.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
