package com.loc;

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

/* compiled from: DynamicClassLoader */
final class az extends av {
    private PublicKey g = null;

    az(final Context context, s sVar) throws Exception {
        super(context, sVar);
        final String b = ay.b(context, sVar.a(), sVar.b());
        final String a = ay.a(context);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(a)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
        new File(b);
        String str = a + File.separator + ay.a(r1.getName());
        try {
            if (this.c == null) {
                b();
                this.c = DexFile.loadDex(b, str, 0);
            }
            z.b().submit(new Runnable() {
                public final void run() {
                    try {
                        az.this.a(context, b, a);
                    } catch (Throwable th) {
                        w.a(th, "dLoader", "run()");
                    }
                }
            });
        } catch (Throwable th) {
            w.a(th, "dLoader", "loadFile");
            throw new Exception("load file fail");
        }
    }

    private static void a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream2.read(new byte[8192]) > 0);
                try {
                    bd.a((Closeable) inputStream2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                bd.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w.a(th, "DyLoader", "loadJa");
            bd.a((Closeable) inputStream);
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
            java.security.PublicKey r2 = com.loc.bd.a()     // Catch:{ Throwable -> 0x003a }
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
            com.loc.w.a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0038 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.az.a(java.io.File):boolean");
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
            w.a((Throwable) e, "DyLoader", "check");
            return false;
        }
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
            com.loc.af r0 = new com.loc.af     // Catch:{ Throwable -> 0x00f8 }
            com.loc.bb r1 = com.loc.bb.b()     // Catch:{ Throwable -> 0x00f8 }
            r0.<init>(r11, r1)     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r11 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r11.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.bc r12 = com.loc.ay.a.a(r0, r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0026
            java.lang.String r12 = r12.e()     // Catch:{ Throwable -> 0x00f8 }
            r10.f = r12     // Catch:{ Throwable -> 0x00f8 }
        L_0x0026:
            com.loc.s r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r2 = r10.a((java.io.File) r2)     // Catch:{ Throwable -> 0x00f8 }
            r3 = 0
            if (r2 == 0) goto L_0x004b
            android.content.Context r2 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r4 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r5 = r12.b()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r2 = com.loc.ay.a((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = com.loc.bd.a(r0, r2, r1, r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x004c
        L_0x004b:
            r12 = r3
        L_0x004c:
            if (r12 != 0) goto L_0x0070
            r10.d = r3     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.ay.a((android.content.Context) r12, (com.loc.af) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r1 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.loc.ay.a((android.content.Context) r12, (com.loc.af) r0, (com.loc.s) r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r1 != 0) goto L_0x0070
            r10.f = r12     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r1 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            com.loc.ay.a((android.content.Context) r12, (com.loc.s) r1)     // Catch:{ Throwable -> 0x00f8 }
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
            java.lang.String r13 = com.loc.ay.a((java.lang.String) r13)     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r13 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r13.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = r13.exists()     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0100
            java.lang.String r11 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.loc.ay.a((java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r9 = r10.f     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.loc.ay.a((android.content.Context) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r13 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = com.loc.bd.a(r0, r11, r12, r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.loc.bc r13 = com.loc.ay.a.a(r0, r11)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 == 0) goto L_0x00bd
            goto L_0x00ee
        L_0x00bd:
            java.lang.String r13 = r10.f     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.loc.bc$a r13 = new com.loc.bc$a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r6 = com.loc.p.a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r7 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r8 = r12.b()     // Catch:{ Throwable -> 0x00f8 }
            r4 = r13
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = "useod"
            com.loc.bc$a r12 = r13.a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.bc r12 = r12.a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.loc.bc.b(r11)     // Catch:{ Throwable -> 0x00f8 }
            r0.a((java.lang.Object) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
        L_0x00ed:
            r3 = 1
        L_0x00ee:
            if (r3 != 0) goto L_0x0100
            android.content.Context r11 = r10.a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.s r12 = r10.e     // Catch:{ Throwable -> 0x00f8 }
            com.loc.ay.a((android.content.Context) r11, (com.loc.s) r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x0100
        L_0x00f8:
            r11 = move-exception
            java.lang.String r12 = "dLoader"
            java.lang.String r13 = "verifyD()"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.String) r13)
        L_0x0100:
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            r11.getTime()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.az.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        Class<?> cls2;
        try {
            if (this.c == null) {
                throw new ClassNotFoundException(str);
            }
            cls = null;
            synchronized (this.b) {
                try {
                    cls2 = (Class) this.b.get(str);
                    try {
                    } catch (Throwable th) {
                        Class<?> cls3 = cls2;
                        th = th;
                        cls = cls3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            w.a(th3, "dLoader", "findCl");
            throw new ClassNotFoundException(str);
        }
        if (cls2 != null) {
            return cls2;
        }
        Class<?> loadClass = this.c.loadClass(str, this);
        if (loadClass == null) {
            throw new ClassNotFoundException(str);
        }
        try {
            synchronized (this.b) {
                this.b.put(str, loadClass);
            }
            return loadClass;
        } catch (Throwable th4) {
            w.a(th4, "dLoader", "findCl");
            return loadClass;
        }
    }
}
