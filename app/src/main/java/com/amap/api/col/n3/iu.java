package com.amap.api.col.n3;

import android.content.Context;
import java.lang.Thread;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler */
public final class iu extends ir implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory g = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */
    public Context d;

    /* compiled from: SDKLogHandler */
    private static class a implements kh {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        public final void a() {
            try {
                is.b(this.a);
            } catch (Throwable th) {
                ir.a(th, "ll", "onc");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:12:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.amap.api.col.n3.iu a(android.content.Context r3, com.amap.api.col.n3.im r4) throws com.amap.api.col.n3.ic {
        /*
            java.lang.Class<com.amap.api.col.n3.iu> r0 = com.amap.api.col.n3.iu.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x000f
            com.amap.api.col.n3.ic r3 = new com.amap.api.col.n3.ic     // Catch:{ all -> 0x000d }
            java.lang.String r4 = "sdk info is null"
            r3.<init>(r4)     // Catch:{ all -> 0x000d }
            throw r3     // Catch:{ all -> 0x000d }
        L_0x000d:
            r3 = move-exception
            goto L_0x0065
        L_0x000f:
            java.lang.String r1 = r4.a()     // Catch:{ all -> 0x000d }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = ""
            java.lang.String r2 = r4.a()     // Catch:{ all -> 0x000d }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x000d }
            if (r1 == 0) goto L_0x0022
            goto L_0x005d
        L_0x0022:
            java.util.Set<java.lang.Integer> r1 = f     // Catch:{ Throwable -> 0x0053 }
            int r2 = r4.hashCode()     // Catch:{ Throwable -> 0x0053 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x0053 }
            boolean r1 = r1.add(r2)     // Catch:{ Throwable -> 0x0053 }
            if (r1 != 0) goto L_0x0038
            com.amap.api.col.n3.ir r3 = com.amap.api.col.n3.ir.a     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.col.n3.iu r3 = (com.amap.api.col.n3.iu) r3     // Catch:{ Throwable -> 0x0053 }
            monitor-exit(r0)
            return r3
        L_0x0038:
            com.amap.api.col.n3.ir r1 = com.amap.api.col.n3.ir.a     // Catch:{ Throwable -> 0x0053 }
            if (r1 != 0) goto L_0x0044
            com.amap.api.col.n3.iu r1 = new com.amap.api.col.n3.iu     // Catch:{ Throwable -> 0x0053 }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.col.n3.ir.a = r1     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0049
        L_0x0044:
            com.amap.api.col.n3.ir r1 = com.amap.api.col.n3.ir.a     // Catch:{ Throwable -> 0x0053 }
            r2 = 0
            r1.c = r2     // Catch:{ Throwable -> 0x0053 }
        L_0x0049:
            com.amap.api.col.n3.ir r1 = com.amap.api.col.n3.ir.a     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.col.n3.ir r2 = com.amap.api.col.n3.ir.a     // Catch:{ Throwable -> 0x0053 }
            boolean r2 = r2.c     // Catch:{ Throwable -> 0x0053 }
            r1.a((android.content.Context) r3, (com.amap.api.col.n3.im) r4, (boolean) r2)     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x000d }
        L_0x0057:
            com.amap.api.col.n3.ir r3 = com.amap.api.col.n3.ir.a     // Catch:{ all -> 0x000d }
            com.amap.api.col.n3.iu r3 = (com.amap.api.col.n3.iu) r3     // Catch:{ all -> 0x000d }
            monitor-exit(r0)
            return r3
        L_0x005d:
            com.amap.api.col.n3.ic r3 = new com.amap.api.col.n3.ic     // Catch:{ all -> 0x000d }
            java.lang.String r4 = "sdk name is invalid"
            r3.<init>(r4)     // Catch:{ all -> 0x000d }
            throw r3     // Catch:{ all -> 0x000d }
        L_0x0065:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.iu.a(android.content.Context, com.amap.api.col.n3.im):com.amap.api.col.n3.iu");
    }

    public static synchronized iu a() {
        iu iuVar;
        synchronized (iu.class) {
            iuVar = (iu) ir.a;
        }
        return iuVar;
    }

    public static void b(Throwable th, String str, String str2) {
        if (ir.a != null) {
            ir.a.a(th, 1, str, str2);
        }
    }

    public static void a(im imVar, String str, String str2, String str3, String str4) {
        if (ir.a != null) {
            ir.a.a(imVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
        }
    }

    public static void a(im imVar, String str, ic icVar) {
        if (icVar != null) {
            a(imVar, str, icVar.c(), icVar.d(), icVar.b());
        }
    }

    public static void b(im imVar, String str, String str2) {
        if (ir.a != null) {
            ir.a.a(imVar, str, str2);
        }
    }

    public static synchronized void b() {
        synchronized (iu.class) {
            try {
                if (e != null) {
                    e.shutdown();
                }
                jz.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(ir.a == null || Thread.getDefaultUncaughtExceptionHandler() != ir.a || ir.a.b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(ir.a.b);
                }
                ir.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            a(th, 0, (String) null, (String) null);
            if (this.b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.b);
                } catch (Throwable unused) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(im imVar, String str, String str2) {
        is.a(this.d, imVar, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th, int i, String str, String str2) {
        is.a(this.d, th, i, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void a(final Context context, final im imVar, final boolean z) {
        try {
            ExecutorService c = c();
            if (c == null) {
                return;
            }
            if (!c.isShutdown()) {
                c.submit(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
                        r0 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
                        r0.printStackTrace();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
                        return;
                     */
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r4 = this;
                            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x0046 }
                            monitor-enter(r0)     // Catch:{ Throwable -> 0x0046 }
                            com.amap.api.col.n3.jk r1 = new com.amap.api.col.n3.jk     // Catch:{ all -> 0x0043 }
                            android.content.Context r2 = r3     // Catch:{ all -> 0x0043 }
                            r3 = 1
                            r1.<init>(r2, r3)     // Catch:{ all -> 0x0043 }
                            com.amap.api.col.n3.im r2 = r4     // Catch:{ all -> 0x0043 }
                            r1.a(r2)     // Catch:{ all -> 0x0043 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                            boolean r0 = r5     // Catch:{ Throwable -> 0x0046 }
                            if (r0 == 0) goto L_0x0042
                            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x0046 }
                            monitor-enter(r0)     // Catch:{ Throwable -> 0x0046 }
                            com.amap.api.col.n3.jl r1 = new com.amap.api.col.n3.jl     // Catch:{ all -> 0x003f }
                            android.content.Context r2 = r3     // Catch:{ all -> 0x003f }
                            r1.<init>(r2)     // Catch:{ all -> 0x003f }
                            com.amap.api.col.n3.jm r2 = new com.amap.api.col.n3.jm     // Catch:{ all -> 0x003f }
                            r2.<init>()     // Catch:{ all -> 0x003f }
                            r2.c(r3)     // Catch:{ all -> 0x003f }
                            r2.a(r3)     // Catch:{ all -> 0x003f }
                            r2.b(r3)     // Catch:{ all -> 0x003f }
                            r1.a((com.amap.api.col.n3.jm) r2)     // Catch:{ all -> 0x003f }
                            monitor-exit(r0)     // Catch:{ all -> 0x003f }
                            com.amap.api.col.n3.iu r0 = com.amap.api.col.n3.iu.this     // Catch:{ Throwable -> 0x0046 }
                            android.content.Context r0 = r0.d     // Catch:{ Throwable -> 0x0046 }
                            com.amap.api.col.n3.is.a((android.content.Context) r0)     // Catch:{ Throwable -> 0x0046 }
                            goto L_0x0042
                        L_0x003f:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ Throwable -> 0x0046 }
                            throw r1     // Catch:{ Throwable -> 0x0046 }
                        L_0x0042:
                            return
                        L_0x0043:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ Throwable -> 0x0046 }
                            throw r1     // Catch:{ Throwable -> 0x0046 }
                        L_0x0046:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.iu.AnonymousClass1.run():void");
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private iu(Context context) {
        this.d = context;
        kg.a((kh) new a(context));
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = this.b.toString();
            if (obj.indexOf("com.amap.api") == -1) {
                if (obj.indexOf("com.loc") == -1) {
                    Thread.setDefaultUncaughtExceptionHandler(this);
                    this.c = true;
                    return;
                }
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static synchronized ExecutorService c() {
        ExecutorService executorService;
        synchronized (iu.class) {
            try {
                if (e == null || e.isShutdown()) {
                    e = Executors.newSingleThreadExecutor(g);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = e;
        }
        return executorService;
    }
}
