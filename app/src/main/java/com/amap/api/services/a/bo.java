package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;
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
public class bo extends bl implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory g = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */
    public Context d;

    /* compiled from: SDKLogHandler */
    private static class a implements db {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        public void a() {
            try {
                bm.b(this.a);
            } catch (Throwable th) {
                bl.a(th, "LogNetListener", "onNetCompleted");
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
    public static synchronized com.amap.api.services.a.bo a(android.content.Context r3, com.amap.api.services.a.bh r4) throws com.amap.api.services.a.ay {
        /*
            java.lang.Class<com.amap.api.services.a.bo> r0 = com.amap.api.services.a.bo.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x000f
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x000d }
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
            com.amap.api.services.a.bl r3 = com.amap.api.services.a.bl.a     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.services.a.bo r3 = (com.amap.api.services.a.bo) r3     // Catch:{ Throwable -> 0x0053 }
            monitor-exit(r0)
            return r3
        L_0x0038:
            com.amap.api.services.a.bl r1 = com.amap.api.services.a.bl.a     // Catch:{ Throwable -> 0x0053 }
            if (r1 != 0) goto L_0x0044
            com.amap.api.services.a.bo r1 = new com.amap.api.services.a.bo     // Catch:{ Throwable -> 0x0053 }
            r1.<init>(r3, r4)     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.services.a.bl.a = r1     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0049
        L_0x0044:
            com.amap.api.services.a.bl r1 = com.amap.api.services.a.bl.a     // Catch:{ Throwable -> 0x0053 }
            r2 = 0
            r1.c = r2     // Catch:{ Throwable -> 0x0053 }
        L_0x0049:
            com.amap.api.services.a.bl r1 = com.amap.api.services.a.bl.a     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.services.a.bl r2 = com.amap.api.services.a.bl.a     // Catch:{ Throwable -> 0x0053 }
            boolean r2 = r2.c     // Catch:{ Throwable -> 0x0053 }
            r1.a((android.content.Context) r3, (com.amap.api.services.a.bh) r4, (boolean) r2)     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x000d }
        L_0x0057:
            com.amap.api.services.a.bl r3 = com.amap.api.services.a.bl.a     // Catch:{ all -> 0x000d }
            com.amap.api.services.a.bo r3 = (com.amap.api.services.a.bo) r3     // Catch:{ all -> 0x000d }
            monitor-exit(r0)
            return r3
        L_0x005d:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x000d }
            java.lang.String r4 = "sdk name is invalid"
            r3.<init>(r4)     // Catch:{ all -> 0x000d }
            throw r3     // Catch:{ all -> 0x000d }
        L_0x0065:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bo.a(android.content.Context, com.amap.api.services.a.bh):com.amap.api.services.a.bo");
    }

    public static synchronized bo a() {
        bo boVar;
        synchronized (bo.class) {
            boVar = (bo) bl.a;
        }
        return boVar;
    }

    public static void b(Throwable th, String str, String str2) {
        if (bl.a != null) {
            bl.a.a(th, 1, str, str2);
        }
    }

    public static void a(bh bhVar, String str, String str2, String str3, String str4) {
        if (bl.a != null) {
            bl.a.a(bhVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
        }
    }

    public static void a(bh bhVar, String str, ay ayVar) {
        if (ayVar != null) {
            a(bhVar, str, ayVar.c(), ayVar.d(), ayVar.b());
        }
    }

    public static void b(bh bhVar, String str, String str2) {
        if (bl.a != null) {
            bl.a.a(bhVar, str, str2);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
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
    public void a(bh bhVar, String str, String str2) {
        bm.a(this.d, bhVar, str, str2);
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, int i, String str, String str2) {
        bm.a(this.d, th, i, str, str2);
    }

    /* access modifiers changed from: protected */
    public void a(final Context context, final bh bhVar, final boolean z) {
        try {
            ExecutorService b = b();
            if (b == null) {
                return;
            }
            if (!b.isShutdown()) {
                b.submit(new Runnable() {
                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new ce(context, true).a(bhVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    cf cfVar = new cf(context);
                                    cg cgVar = new cg();
                                    cgVar.c(true);
                                    cgVar.a(true);
                                    cgVar.b(true);
                                    cfVar.a(cgVar);
                                }
                                bm.a(bo.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private bo(Context context, bh bhVar) {
        this.d = context;
        da.a((db) new a(context));
        c();
    }

    private void c() {
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

    public void c(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static synchronized ExecutorService b() {
        ExecutorService executorService;
        synchronized (bo.class) {
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
