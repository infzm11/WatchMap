package com.amap.api.services.a;

import com.amap.api.services.a.dm;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: ThreadPool */
public final class dl {
    private static dl a;
    private ExecutorService b;
    private ConcurrentHashMap<dm, Future<?>> c = new ConcurrentHashMap<>();
    private dm.a d = new dm.a() {
        public void a(dm dmVar) {
        }

        public void b(dm dmVar) {
            dl.this.a(dmVar, false);
        }
    };

    public static synchronized dl a(int i) {
        dl dlVar;
        synchronized (dl.class) {
            if (a == null) {
                a = new dl(i);
            }
            dlVar = a;
        }
        return dlVar;
    }

    private dl(int i) {
        try {
            this.b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            bo.b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(dm dmVar, boolean z) {
        try {
            Future remove = this.c.remove(dmVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            bo.b(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
        return;
    }
}
