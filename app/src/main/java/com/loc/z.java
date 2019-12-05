package com.loc;

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
public final class z extends w implements Thread.UncaughtExceptionHandler {
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
    private static class a implements bm {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        public final void a() {
            try {
                x.b(this.a);
            } catch (Throwable th) {
                w.a(th, "ll", "onc");
            }
        }
    }

    private z(Context context) {
        this.d = context;
        bl.a((bm) new a(context));
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
    public static synchronized com.loc.z a(android.content.Context r3, com.loc.s r4) throws com.loc.j {
        /*
            java.lang.Class<com.loc.z> r0 = com.loc.z.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x000f
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x000d }
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
            com.loc.w r3 = com.loc.w.a     // Catch:{ Throwable -> 0x0053 }
            com.loc.z r3 = (com.loc.z) r3     // Catch:{ Throwable -> 0x0053 }
            monitor-exit(r0)
            return r3
        L_0x0038:
            com.loc.w r1 = com.loc.w.a     // Catch:{ Throwable -> 0x0053 }
            if (r1 != 0) goto L_0x0044
            com.loc.z r1 = new com.loc.z     // Catch:{ Throwable -> 0x0053 }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x0053 }
            com.loc.w.a = r1     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0049
        L_0x0044:
            com.loc.w r1 = com.loc.w.a     // Catch:{ Throwable -> 0x0053 }
            r2 = 0
            r1.c = r2     // Catch:{ Throwable -> 0x0053 }
        L_0x0049:
            com.loc.w r1 = com.loc.w.a     // Catch:{ Throwable -> 0x0053 }
            com.loc.w r2 = com.loc.w.a     // Catch:{ Throwable -> 0x0053 }
            boolean r2 = r2.c     // Catch:{ Throwable -> 0x0053 }
            r1.a((android.content.Context) r3, (com.loc.s) r4, (boolean) r2)     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x000d }
        L_0x0057:
            com.loc.w r3 = com.loc.w.a     // Catch:{ all -> 0x000d }
            com.loc.z r3 = (com.loc.z) r3     // Catch:{ all -> 0x000d }
            monitor-exit(r0)
            return r3
        L_0x005d:
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x000d }
            java.lang.String r4 = "sdk name is invalid"
            r3.<init>(r4)     // Catch:{ all -> 0x000d }
            throw r3     // Catch:{ all -> 0x000d }
        L_0x0065:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.z.a(android.content.Context, com.loc.s):com.loc.z");
    }

    public static synchronized void a() {
        synchronized (z.class) {
            try {
                if (e != null) {
                    e.shutdown();
                }
                be.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(w.a == null || Thread.getDefaultUncaughtExceptionHandler() != w.a || w.a.b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(w.a.b);
                }
                w.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void a(s sVar, String str, j jVar) {
        if (jVar != null) {
            a(sVar, str, jVar.c(), jVar.d(), jVar.b());
        }
    }

    public static void a(s sVar, String str, String str2, String str3, String str4) {
        if (w.a != null) {
            w.a.a(sVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
        }
    }

    public static synchronized ExecutorService b() {
        ExecutorService executorService;
        synchronized (z.class) {
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

    public static void b(s sVar, String str, String str2) {
        if (w.a != null) {
            w.a.a(sVar, str, str2);
        }
    }

    public static void b(Throwable th, String str, String str2) {
        if (w.a != null) {
            w.a.a(th, 1, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(final Context context, final s sVar, final boolean z) {
        try {
            ExecutorService b = b();
            if (b != null && !b.isShutdown()) {
                b.submit(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
                        r0 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
                        r0.printStackTrace();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
                        return;
                     */
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r4 = this;
                            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x0046 }
                            monitor-enter(r0)     // Catch:{ Throwable -> 0x0046 }
                            com.loc.ap r1 = new com.loc.ap     // Catch:{ all -> 0x0043 }
                            android.content.Context r2 = r3     // Catch:{ all -> 0x0043 }
                            r3 = 1
                            r1.<init>(r2, r3)     // Catch:{ all -> 0x0043 }
                            com.loc.s r2 = r4     // Catch:{ all -> 0x0043 }
                            r1.a(r2)     // Catch:{ all -> 0x0043 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                            boolean r0 = r5     // Catch:{ Throwable -> 0x0046 }
                            if (r0 == 0) goto L_0x0042
                            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x0046 }
                            monitor-enter(r0)     // Catch:{ Throwable -> 0x0046 }
                            com.loc.aq r1 = new com.loc.aq     // Catch:{ all -> 0x003f }
                            android.content.Context r2 = r3     // Catch:{ all -> 0x003f }
                            r1.<init>(r2)     // Catch:{ all -> 0x003f }
                            com.loc.ar r2 = new com.loc.ar     // Catch:{ all -> 0x003f }
                            r2.<init>()     // Catch:{ all -> 0x003f }
                            r2.c(r3)     // Catch:{ all -> 0x003f }
                            r2.a(r3)     // Catch:{ all -> 0x003f }
                            r2.b(r3)     // Catch:{ all -> 0x003f }
                            r1.a((com.loc.ar) r2)     // Catch:{ all -> 0x003f }
                            monitor-exit(r0)     // Catch:{ all -> 0x003f }
                            com.loc.z r0 = com.loc.z.this     // Catch:{ Throwable -> 0x0046 }
                            android.content.Context r0 = r0.d     // Catch:{ Throwable -> 0x0046 }
                            com.loc.x.a((android.content.Context) r0)     // Catch:{ Throwable -> 0x0046 }
                            return
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
                        throw new UnsupportedOperationException("Method not decompiled: com.loc.z.AnonymousClass1.run():void");
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(s sVar, String str, String str2) {
        x.a(this.d, sVar, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th, int i, String str, String str2) {
        x.a(this.d, th, i, str, str2);
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
}
