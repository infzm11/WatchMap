package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;

/* compiled from: ImageCache */
public final class dw {
    /* access modifiers changed from: private */
    public static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
    private jz b;
    private dm<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f;
    /* access modifiers changed from: private */
    public HashMap<String, WeakReference<Bitmap>> g;

    /* compiled from: ImageCache */
    public static class a {
        public int a = 5242880;
        public long b = 10485760;
        public File c;
        public Bitmap.CompressFormat d = dw.a;
        public int e = 100;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;

        public a(Context context, String str) {
            this.c = dw.a(context, str);
        }
    }

    private dw(a aVar) {
        boolean z = true;
        this.f = true;
        this.d = aVar;
        if (this.d.f) {
            if (Build.VERSION.SDK_INT < 11 ? false : z) {
                this.g = new HashMap<>();
            }
            this.c = new dm<String, Bitmap>(this.d.a) {
                /* access modifiers changed from: protected */
                public final /* synthetic */ int b(Object obj) {
                    int a2 = dw.a((Bitmap) obj);
                    if (a2 == 0) {
                        return 1;
                    }
                    return a2;
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ void b(Object obj, Object obj2) {
                    String str = (String) obj;
                    Bitmap bitmap = (Bitmap) obj2;
                    if (dv.d() && dw.this.g != null && bitmap != null && !bitmap.isRecycled()) {
                        dw.this.g.put(str, new WeakReference(bitmap));
                    }
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    public static dw a(a aVar) {
        return new dw(aVar);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A[SYNTHETIC, Splitter:B:23:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.e
            monitor-enter(r0)
            com.amap.api.col.n3.jz r1 = r7.b     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x000f
            com.amap.api.col.n3.jz r1 = r7.b     // Catch:{ all -> 0x0069 }
            boolean r1 = r1.c()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x005f
        L_0x000f:
            com.amap.api.col.n3.dw$a r1 = r7.d     // Catch:{ all -> 0x0069 }
            java.io.File r1 = r1.c     // Catch:{ all -> 0x0069 }
            com.amap.api.col.n3.dw$a r2 = r7.d     // Catch:{ all -> 0x0069 }
            boolean r2 = r2.g     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x005f
            if (r1 == 0) goto L_0x005f
            boolean r2 = r1.exists()     // Catch:{ Throwable -> 0x0027 }
            if (r2 == 0) goto L_0x0024
            r7.a((java.io.File) r1)     // Catch:{ Throwable -> 0x0027 }
        L_0x0024:
            r1.mkdir()     // Catch:{ Throwable -> 0x0027 }
        L_0x0027:
            boolean r2 = com.amap.api.col.n3.dv.c()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x0032
            long r2 = r1.getUsableSpace()     // Catch:{ all -> 0x0069 }
            goto L_0x0047
        L_0x0032:
            android.os.StatFs r2 = new android.os.StatFs     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r1.getPath()     // Catch:{ all -> 0x0069 }
            r2.<init>(r3)     // Catch:{ all -> 0x0069 }
            int r3 = r2.getBlockSize()     // Catch:{ all -> 0x0069 }
            long r3 = (long) r3     // Catch:{ all -> 0x0069 }
            int r2 = r2.getAvailableBlocks()     // Catch:{ all -> 0x0069 }
            long r5 = (long) r2     // Catch:{ all -> 0x0069 }
            long r2 = r3 * r5
        L_0x0047:
            com.amap.api.col.n3.dw$a r4 = r7.d     // Catch:{ all -> 0x0069 }
            long r4 = r4.b     // Catch:{ all -> 0x0069 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x005f
            com.amap.api.col.n3.dw$a r2 = r7.d     // Catch:{ Throwable -> 0x005a }
            long r2 = r2.b     // Catch:{ Throwable -> 0x005a }
            com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.a((java.io.File) r1, (long) r2)     // Catch:{ Throwable -> 0x005a }
            r7.b = r1     // Catch:{ Throwable -> 0x005a }
            goto L_0x005f
        L_0x005a:
            com.amap.api.col.n3.dw$a r1 = r7.d     // Catch:{ all -> 0x0069 }
            r2 = 0
            r1.c = r2     // Catch:{ all -> 0x0069 }
        L_0x005f:
            r1 = 0
            r7.f = r1     // Catch:{ all -> 0x0069 }
            java.lang.Object r1 = r7.e     // Catch:{ all -> 0x0069 }
            r1.notifyAll()     // Catch:{ all -> 0x0069 }
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return
        L_0x0069:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.a():void");
    }

    private void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|(2:34|35)|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r1 != null) goto L_0x0055;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c A[SYNTHETIC, Splitter:B:34:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0068
            if (r6 == 0) goto L_0x0068
            boolean r0 = r6.isRecycled()
            if (r0 == 0) goto L_0x000b
            goto L_0x0068
        L_0x000b:
            com.amap.api.col.n3.dm<java.lang.String, android.graphics.Bitmap> r0 = r4.c
            if (r0 == 0) goto L_0x0014
            com.amap.api.col.n3.dm<java.lang.String, android.graphics.Bitmap> r0 = r4.c
            r0.a(r5, r6)
        L_0x0014:
            java.lang.Object r0 = r4.e
            monitor-enter(r0)
            com.amap.api.col.n3.jz r1 = r4.b     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063
            java.lang.String r5 = c(r5)     // Catch:{ all -> 0x0065 }
            r1 = 0
            com.amap.api.col.n3.jz r2 = r4.b     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            com.amap.api.col.n3.jz$b r2 = r2.a((java.lang.String) r5)     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            if (r2 != 0) goto L_0x004c
            com.amap.api.col.n3.jz r2 = r4.b     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            com.amap.api.col.n3.jz$a r5 = r2.b((java.lang.String) r5)     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            if (r5 == 0) goto L_0x0053
            java.io.OutputStream r2 = r5.a()     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            com.amap.api.col.n3.dw$a r1 = r4.d     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            android.graphics.Bitmap$CompressFormat r1 = r1.d     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            com.amap.api.col.n3.dw$a r3 = r4.d     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            int r3 = r3.e     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r6.compress(r1, r3, r2)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r5.b()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r2.close()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r1 = r2
            goto L_0x0053
        L_0x0047:
            r5 = move-exception
            r1 = r2
            goto L_0x005a
        L_0x004a:
            r1 = r2
            goto L_0x0060
        L_0x004c:
            java.io.InputStream r5 = r2.a()     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
            r5.close()     // Catch:{ Throwable -> 0x0060, all -> 0x0059 }
        L_0x0053:
            if (r1 == 0) goto L_0x0063
        L_0x0055:
            r1.close()     // Catch:{ Throwable -> 0x0063 }
            goto L_0x0063
        L_0x0059:
            r5 = move-exception
        L_0x005a:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Throwable -> 0x005f }
        L_0x005f:
            throw r5     // Catch:{ all -> 0x0065 }
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0055
        L_0x0063:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            return
        L_0x0065:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.a(java.lang.String, android.graphics.Bitmap):void");
    }

    public final Bitmap a(String str) {
        Bitmap bitmap;
        if (dv.d() && this.g != null) {
            WeakReference weakReference = this.g.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.g.remove(str);
                if (bitmap == null && this.c != null) {
                    bitmap = this.c.a(str);
                }
                if (bitmap != null || bitmap.isRecycled()) {
                    return null;
                }
                return bitmap;
            }
        }
        bitmap = null;
        bitmap = this.c.a(str);
        if (bitmap != null) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r6 != null) goto L_0x004d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055 A[SYNTHETIC, Splitter:B:28:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:43:0x0007, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[Catch:{ Throwable -> 0x0059, all -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r6 = c(r6)
            java.lang.Object r0 = r5.e
            monitor-enter(r0)
        L_0x0007:
            boolean r1 = r5.f     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0011
            java.lang.Object r1 = r5.e     // Catch:{ Throwable -> 0x0007 }
            r1.wait()     // Catch:{ Throwable -> 0x0007 }
            goto L_0x0007
        L_0x0011:
            com.amap.api.col.n3.jz r1 = r5.b     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r1 == 0) goto L_0x005d
            com.amap.api.col.n3.jz r1 = r5.b     // Catch:{ Throwable -> 0x0059, all -> 0x0051 }
            com.amap.api.col.n3.jz$b r6 = r1.a((java.lang.String) r6)     // Catch:{ Throwable -> 0x0059, all -> 0x0051 }
            if (r6 == 0) goto L_0x004a
            java.io.InputStream r6 = r6.a()     // Catch:{ Throwable -> 0x0059, all -> 0x0051 }
            if (r6 == 0) goto L_0x004b
            r1 = r6
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            java.io.FileDescriptor r1 = r1.getFD()     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r3.<init>()     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r4 = 1
            r3.inJustDecodeBounds = r4     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            android.graphics.BitmapFactory.decodeFileDescriptor(r1, r2, r3)     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r4 = com.amap.api.col.n3.dy.a(r3, r4, r4)     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r3.inSampleSize = r4     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r4 = 0
            r3.inJustDecodeBounds = r4     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFileDescriptor(r1, r2, r3)     // Catch:{ Throwable -> 0x005a, all -> 0x0048 }
            r2 = r1
            goto L_0x004b
        L_0x0048:
            r1 = move-exception
            goto L_0x0053
        L_0x004a:
            r6 = r2
        L_0x004b:
            if (r6 == 0) goto L_0x005d
        L_0x004d:
            r6.close()     // Catch:{ Throwable -> 0x005d }
            goto L_0x005d
        L_0x0051:
            r1 = move-exception
            r6 = r2
        L_0x0053:
            if (r6 == 0) goto L_0x0058
            r6.close()     // Catch:{ Throwable -> 0x0058 }
        L_0x0058:
            throw r1     // Catch:{ all -> 0x005f }
        L_0x0059:
            r6 = r2
        L_0x005a:
            if (r6 == 0) goto L_0x005d
            goto L_0x004d
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r2
        L_0x005f:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.b(java.lang.String):android.graphics.Bitmap");
    }

    public final void b() {
        if (dv.d() && this.g != null) {
            this.g.clear();
        }
        if (this.c != null) {
            this.c.a();
        }
        synchronized (this.e) {
            this.f = true;
            if (this.b != null && !this.b.c()) {
                try {
                    this.b.e();
                } catch (Throwable unused) {
                }
                this.b = null;
                a();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.e
            monitor-enter(r0)
            com.amap.api.col.n3.jz r1 = r2.b     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000c
            com.amap.api.col.n3.jz r1 = r2.b     // Catch:{ Throwable -> 0x000c }
            r1.d()     // Catch:{ Throwable -> 0x000c }
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.c():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|(3:13|14|(1:16))|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r2 = this;
            boolean r0 = com.amap.api.col.n3.dv.d()
            if (r0 == 0) goto L_0x000f
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = r2.g
            if (r0 == 0) goto L_0x000f
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = r2.g
            r0.clear()
        L_0x000f:
            com.amap.api.col.n3.dm<java.lang.String, android.graphics.Bitmap> r0 = r2.c
            if (r0 == 0) goto L_0x0018
            com.amap.api.col.n3.dm<java.lang.String, android.graphics.Bitmap> r0 = r2.c
            r0.a()
        L_0x0018:
            java.lang.Object r0 = r2.e
            monitor-enter(r0)
            com.amap.api.col.n3.jz r1 = r2.b     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x002f
            com.amap.api.col.n3.jz r1 = r2.b     // Catch:{ Throwable -> 0x002f }
            boolean r1 = r1.c()     // Catch:{ Throwable -> 0x002f }
            if (r1 != 0) goto L_0x002f
            com.amap.api.col.n3.jz r1 = r2.b     // Catch:{ Throwable -> 0x002f }
            r1.e()     // Catch:{ Throwable -> 0x002f }
            r1 = 0
            r2.b = r1     // Catch:{ Throwable -> 0x002f }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.d():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((com.amap.api.col.n3.dv.c() ? android.os.Environment.isExternalStorageRemovable() : true) == false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(android.content.Context r3, java.lang.String r4) {
        /*
            java.io.File r0 = a((android.content.Context) r3)
            java.lang.String r1 = "mounted"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x001e
            boolean r1 = com.amap.api.col.n3.dv.c()
            if (r1 == 0) goto L_0x001b
            boolean r1 = android.os.Environment.isExternalStorageRemovable()
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            if (r1 != 0) goto L_0x0025
        L_0x001e:
            if (r0 == 0) goto L_0x0025
            java.lang.String r3 = r0.getPath()
            goto L_0x002d
        L_0x0025:
            java.io.File r3 = r3.getCacheDir()
            java.lang.String r3 = r3.getPath()
        L_0x002d:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = java.io.File.separator
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dw.a(android.content.Context, java.lang.String):java.io.File");
    }

    private static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(255 & b2);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static int a(Bitmap bitmap) {
        if (dv.e()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static File a(Context context) {
        try {
            if (dv.b()) {
                return context.getExternalCacheDir();
            }
            String str = "/Android/data/" + context.getPackageName() + "/cache/";
            return new File(Environment.getExternalStorageDirectory().getPath() + str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
