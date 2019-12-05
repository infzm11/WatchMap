package com.loc;

/* compiled from: DownloadManager */
public final class bk {
    private bl a;
    private bn b;

    /* compiled from: DownloadManager */
    public interface a {
        void a(byte[] bArr, long j);

        void b();

        void c();

        void d();
    }

    public bk(bn bnVar) {
        this(bnVar, (byte) 0);
    }

    private bk(bn bnVar, byte b2) {
        this.b = bnVar;
        this.a = new bl(this.b.c, this.b.d, bnVar.e == null ? null : bnVar.e);
        this.a.b();
        this.a.a();
    }

    public final void a(a aVar) {
        this.a.a(this.b.c(), this.b.b(), this.b.b_(), aVar);
    }
}
