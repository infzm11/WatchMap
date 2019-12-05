package com.amap.api.services.a;

/* compiled from: ThreadTask */
public abstract class dm implements Runnable {
    a d;

    /* compiled from: ThreadTask */
    interface a {
        void a(dm dmVar);

        void b(dm dmVar);
    }

    public abstract void a();

    public final void run() {
        try {
            if (this.d != null) {
                this.d.a(this);
            }
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && this.d != null) {
                    this.d.b(this);
                }
            }
        } catch (Throwable th) {
            bo.b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
