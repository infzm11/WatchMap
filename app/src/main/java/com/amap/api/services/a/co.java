package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.a.cn;
import com.amap.api.services.a.cr;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DynamicClassLoader */
class co extends ck {
    private PublicKey g = null;

    co(Context context, bh bhVar, boolean z) throws Exception {
        super(context, bhVar, z);
        String b = cn.b(context, bhVar.a(), bhVar.b());
        String a = cn.a(context);
        b(b, a);
        new File(b);
        if (z) {
            a(b, a + File.separator + cn.a(r1.getName()));
            b(context, b, a);
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        Class<?> cls2;
        Class<?> loadClass;
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
            cs.a(th3, "dLoader", "findCl");
            throw new ClassNotFoundException(str);
        }
        if (cls2 != null) {
            return cls2;
        }
        loadClass = this.c.loadClass(str, this);
        if (loadClass == null) {
            throw new ClassNotFoundException(str);
        }
        try {
            synchronized (this.b) {
                this.b.put(str, loadClass);
            }
        } catch (Throwable th4) {
            cs.a(th4, "dLoader", "findCl");
        }
        return loadClass;
        return loadClass;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) throws Exception {
        try {
            if (this.c == null) {
                b();
                this.c = DexFile.loadDex(str, str2, 0);
            }
        } catch (Throwable th) {
            cs.a(th, "dLoader", "loadFile");
            throw new Exception("load file fail");
        }
    }

    private void c() {
        if (this.g == null) {
            this.g = cs.a();
        }
    }

    private void a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream2.read(new byte[8192]) > 0);
            } catch (Throwable th) {
                th = th;
                inputStream = inputStream2;
                cs.a((Closeable) inputStream);
                throw th;
            }
            try {
                cs.a((Closeable) inputStream2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            cs.a(th, "DyLoader", "loadJa");
            cs.a((Closeable) inputStream);
        }
    }

    private boolean a(File file, Certificate[] certificateArr) {
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
            cs.a(e, "DyLoader", "check");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0043 A[SYNTHETIC, Splitter:B:37:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0049 A[SYNTHETIC, Splitter:B:42:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            r4.c()     // Catch:{ Throwable -> 0x0039 }
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ Throwable -> 0x0039 }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x0039 }
            java.lang.String r1 = "classes.dex"
            java.util.jar.JarEntry r1 = r2.getJarEntry(r1)     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            if (r1 != 0) goto L_0x0018
            if (r2 == 0) goto L_0x0017
            r2.close()     // Catch:{ Throwable -> 0x0017 }
        L_0x0017:
            return r0
        L_0x0018:
            r4.a((java.util.jar.JarFile) r2, (java.util.jar.JarEntry) r1)     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            java.security.cert.Certificate[] r1 = r1.getCertificates()     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            if (r1 != 0) goto L_0x0027
            if (r2 == 0) goto L_0x0026
            r2.close()     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            return r0
        L_0x0027:
            boolean r5 = r4.a((java.io.File) r5, (java.security.cert.Certificate[]) r1)     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            if (r2 == 0) goto L_0x0030
            r2.close()     // Catch:{ Throwable -> 0x0030 }
        L_0x0030:
            return r5
        L_0x0031:
            r5 = move-exception
            r1 = r2
            goto L_0x0047
        L_0x0034:
            r5 = move-exception
            r1 = r2
            goto L_0x003a
        L_0x0037:
            r5 = move-exception
            goto L_0x0047
        L_0x0039:
            r5 = move-exception
        L_0x003a:
            java.lang.String r2 = "DyLoader"
            java.lang.String r3 = "verify"
            com.amap.api.services.a.cs.a(r5, r2, r3)     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ Throwable -> 0x0046 }
        L_0x0046:
            return r0
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ Throwable -> 0x004c }
        L_0x004c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.co.a(java.io.File):boolean");
    }

    private boolean a(bu buVar, bh bhVar, String str) {
        if (a(new File(str))) {
            return cs.a(buVar, cn.a(this.a, bhVar.a(), bhVar.b()), str, bhVar);
        }
        return false;
    }

    private boolean a(bu buVar, String str, String str2) {
        String a = cn.a(this.a, str);
        if (cs.a(buVar, str, a, this.e)) {
            return true;
        }
        if (cn.a.a(buVar, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f)) {
            cr.a aVar = new cr.a(str, bf.a(a), this.e.a(), this.e.b(), str2);
            cn.a.a(buVar, aVar.a("useod").a(), cr.b(str));
        }
        return true;
    }

    private void b(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
    }

    private void b(final Context context, final String str, final String str2) {
        bo.b().submit(new Runnable() {
            public void run() {
                try {
                    co.this.a(context, str, str2);
                } catch (Throwable th) {
                    cs.a(th, "dLoader", "run()");
                }
            }
        });
    }

    private void a(bu buVar, File file) {
        cr a = cn.a.a(buVar, file.getName());
        if (a != null) {
            this.f = a.e();
        }
    }

    private void b(bu buVar, File file) {
        this.d = false;
        cn.a(this.a, buVar, file.getName());
        String a = cn.a(this.a, buVar, this.e);
        if (!TextUtils.isEmpty(a)) {
            this.f = a;
            cn.a(this.a, this.e);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str, String str2) throws Exception {
        new Date().getTime();
        try {
            bu buVar = new bu(context, cq.c());
            File file = new File(str);
            a(buVar, file);
            if (!a(buVar, this.e, file.getAbsolutePath())) {
                b(buVar, file);
            }
            if (file.exists()) {
                if (new File(str2 + File.separator + cn.a(file.getName())).exists()) {
                    if (!a(buVar, cn.a(file.getName()), this.f)) {
                        cn.a(this.a, this.e);
                    }
                }
                new Date().getTime();
            }
        } catch (Throwable th) {
            cs.a(th, "dLoader", "verifyD()");
        }
    }
}
