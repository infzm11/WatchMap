package com.amap.api.services.a;

import java.net.Proxy;

/* compiled from: DownloadManager */
public class cz {
    private da a;
    private dd b;

    /* compiled from: DownloadManager */
    public interface a {
        void a(Throwable th);

        void a(byte[] bArr, long j);

        void d();

        void e();
    }

    public cz(dd ddVar) {
        this(ddVar, 0, -1);
    }

    public cz(dd ddVar, long j, long j2) {
        Proxy proxy;
        this.b = ddVar;
        if (ddVar.h == null) {
            proxy = null;
        } else {
            proxy = ddVar.h;
        }
        this.a = new da(this.b.f, this.b.g, proxy);
        this.a.b(j2);
        this.a.a(j);
    }

    public void a(a aVar) {
        this.a.a(this.b.i(), this.b.e(), this.b.d(), aVar);
    }
}
