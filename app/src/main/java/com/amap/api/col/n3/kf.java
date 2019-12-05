package com.amap.api.col.n3;

import java.net.Proxy;

/* compiled from: DownloadManager */
public final class kf {
    private kg a;
    private kj b;

    /* compiled from: DownloadManager */
    public interface a {
        void a(Throwable th);

        void a(byte[] bArr, long j);

        void c();

        void d();
    }

    public kf(kj kjVar) {
        this(kjVar, 0, -1);
    }

    public kf(kj kjVar, long j, long j2) {
        Proxy proxy;
        this.b = kjVar;
        if (kjVar.h == null) {
            proxy = null;
        } else {
            proxy = kjVar.h;
        }
        this.a = new kg(this.b.f, this.b.g, proxy);
        this.a.b(j2);
        this.a.a(j);
    }

    public final void a(a aVar) {
        this.a.a(this.b.c(), this.b.a(), this.b.b(), aVar);
    }

    public final void a() {
        this.a.a();
    }
}
