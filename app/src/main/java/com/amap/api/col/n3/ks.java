package com.amap.api.col.n3;

import com.amap.api.col.n3.kt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ThreadPool */
public final class ks {
    private static ks a;
    private ExecutorService b;
    private ConcurrentHashMap<kt, Future<?>> c = new ConcurrentHashMap<>();
    private kt.a d = new kt.a() {
        public final void a(kt ktVar) {
            ks.this.a(ktVar, false);
        }

        public final void b(kt ktVar) {
            ks.this.a(ktVar, true);
        }
    };

    public static synchronized ks a(int i) {
        ks ksVar;
        synchronized (ks.class) {
            if (a == null) {
                a = new ks(i);
            }
            ksVar = a;
        }
        return ksVar;
    }

    private ks(int i) {
        try {
            this.b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            iu.b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public final void a(kt ktVar) throws ic {
        try {
            if (b(ktVar) || this.b == null) {
                return;
            }
            if (!this.b.isShutdown()) {
                ktVar.q = this.d;
                try {
                    Future<?> submit = this.b.submit(ktVar);
                    if (submit != null) {
                        a(ktVar, submit);
                    }
                } catch (RejectedExecutionException unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "TPool", "addTask");
            throw new ic("thread pool has exception");
        }
    }

    public static synchronized void a() {
        synchronized (ks.class) {
            try {
                if (a != null) {
                    ks ksVar = a;
                    try {
                        for (Map.Entry<kt, Future<?>> key : ksVar.c.entrySet()) {
                            Future future = ksVar.c.get((kt) key.getKey());
                            if (future != null) {
                                future.cancel(true);
                            }
                        }
                        ksVar.c.clear();
                        ksVar.b.shutdown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        iu.b(th, "TPool", "destroy");
                        th.printStackTrace();
                    }
                    a = null;
                }
            } catch (Throwable th2) {
                iu.b(th2, "TPool", "onDestroy");
                th2.printStackTrace();
            }
        }
    }

    private synchronized boolean b(kt ktVar) {
        boolean z;
        try {
            z = this.c.containsKey(ktVar);
        } catch (Throwable th) {
            iu.b(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    private synchronized void a(kt ktVar, Future<?> future) {
        try {
            this.c.put(ktVar, future);
        } catch (Throwable th) {
            iu.b(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(kt ktVar, boolean z) {
        try {
            Future remove = this.c.remove(ktVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            iu.b(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
