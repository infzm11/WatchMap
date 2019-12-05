package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
public abstract class dd<Params, Progress, Result> {
    public static final Executor a;
    public static final Executor b;
    public static final Executor c = Executors.newFixedThreadPool(2, d);
    private static final ThreadFactory d = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> e = new LinkedBlockingQueue(10);
    private static final b f = new b(Looper.getMainLooper());
    private static volatile Executor g = b;
    private final e<Params, Result> h = new e<Params, Result>() {
        public final Result call() throws Exception {
            dd.this.l.set(true);
            Process.setThreadPriority(10);
            return dd.this.c(dd.this.a((Params[]) this.b));
        }
    };
    /* access modifiers changed from: private */
    public final FutureTask<Result> i = new FutureTask<Result>(this.h) {
        /* access modifiers changed from: protected */
        public final void done() {
            try {
                dd.b(dd.this, dd.this.i.get());
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                throw new RuntimeException("An error occured while executing doInBackground()", e.getCause());
            } catch (CancellationException unused2) {
                dd.b(dd.this, (Object) null);
            }
        }
    };
    private volatile d j = d.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean l = new AtomicBoolean();

    /* compiled from: AsyncTask */
    private static class a<Data> {
        final dd a;
        final Data[] b;

        a(dd ddVar, Data... dataArr) {
            this.a = ddVar;
            this.b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.obj != null && (message.obj instanceof a)) {
                a aVar = (a) message.obj;
                switch (message.what) {
                    case 1:
                        dd.c(aVar.a, aVar.b[0]);
                        return;
                    case 2:
                        dd ddVar = aVar.a;
                        Data[] dataArr = aVar.b;
                        dd.b();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: AsyncTask */
    private static class c implements Executor {
        final ArrayDeque<Runnable> a;
        Runnable b;

        private c() {
            this.a = new ArrayDeque<>();
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public final synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                dd.a.execute(this.b);
            }
        }
    }

    /* compiled from: AsyncTask */
    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: AsyncTask */
    private static abstract class e<Params, Result> implements Callable<Result> {
        Params[] b;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    protected static void b() {
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
    }

    static /* synthetic */ void b(dd ddVar, Object obj) {
        if (!ddVar.l.get()) {
            ddVar.c(obj);
        }
    }

    static /* synthetic */ void c(dd ddVar, Object obj) {
        if (ddVar.k.get()) {
            ddVar.b(obj);
        } else {
            ddVar.a(obj);
        }
        ddVar.j = d.FINISHED;
    }

    static {
        Executor executor;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardOldestPolicy());
        a = threadPoolExecutor;
        if (dv.d()) {
            executor = new c((byte) 0);
        } else {
            executor = Executors.newSingleThreadExecutor(d);
        }
        b = executor;
    }

    /* access modifiers changed from: private */
    public Result c(Result result) {
        f.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    public final d a() {
        return this.j;
    }

    public final boolean c() {
        return this.k.get();
    }

    public final boolean d() {
        this.k.set(true);
        return this.i.cancel(true);
    }

    public final dd<Params, Progress, Result> b(Params... paramsArr) {
        return a(g, paramsArr);
    }

    public final dd<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != d.PENDING) {
            switch (this.j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = d.RUNNING;
        this.h.b = paramsArr;
        executor.execute(this.i);
        return this;
    }
}
