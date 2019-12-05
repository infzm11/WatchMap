package com.amap.api.col.n3;

/* compiled from: ThreadTask */
public abstract class kt implements Runnable {
    a q;

    /* compiled from: ThreadTask */
    interface a {
        void a(kt ktVar);

        void b(kt ktVar);
    }

    public abstract void a();

    public final void run() {
        try {
            if (this.q != null) {
                a aVar = this.q;
            }
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && this.q != null) {
                    this.q.a(this);
                }
            }
        } catch (Throwable th) {
            iu.b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public final void e() {
        try {
            if (this.q != null) {
                this.q.b(this);
            }
        } catch (Throwable th) {
            iu.b(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }
}
