package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.col.n3.bl;
import com.amap.api.col.n3.kf;
import com.amap.api.maps.AMapException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: NetFileFetch */
public final class bg implements kf.a {
    bh a = null;
    long b = 0;
    long c = 0;
    long d;
    boolean e = true;
    bb f;
    long g = 0;
    a h;
    private Context i;
    private bl j;
    private String k;
    private kf l;
    private bc m;

    /* compiled from: NetFileFetch */
    public interface a {
        void d();
    }

    public bg(bh bhVar, String str, Context context, bl blVar) throws IOException {
        this.f = bb.a(context.getApplicationContext());
        this.a = bhVar;
        this.i = context;
        this.k = str;
        this.j = blVar;
        File file = new File(this.a.b() + this.a.c());
        if (file.exists()) {
            this.e = false;
            this.b = file.length();
            try {
                this.d = e();
                this.c = this.d;
            } catch (IOException unused) {
                if (this.j != null) {
                    this.j.a(bl.a.file_io_exception);
                }
            }
        } else {
            this.b = 0;
            this.c = 0;
        }
    }

    public final void a() {
        try {
            if (dv.c(this.i)) {
                boolean z = false;
                if (Cif.a != 1) {
                    int i2 = 0;
                    while (i2 < 3) {
                        try {
                            if (Cif.a(this.i, dv.f())) {
                                break;
                            }
                            i2++;
                        } catch (Throwable th) {
                            iu.b(th, "SiteFileFetch", "authOffLineDownLoad");
                            th.printStackTrace();
                        }
                    }
                }
                if (Cif.a == 1) {
                    if (new File(this.a.b() + File.separator + this.a.c()).length() >= 10) {
                        z = true;
                    }
                    if (!z) {
                        this.e = true;
                    }
                    if (this.e) {
                        this.d = e();
                        if (!(this.d == -1 || this.d == -2)) {
                            this.c = this.d;
                        }
                        this.b = 0;
                    }
                    if (this.j != null) {
                        this.j.m();
                    }
                    if (this.b >= this.c) {
                        d();
                        return;
                    }
                    bm bmVar = new bm(this.k);
                    bmVar.a(1800000);
                    bmVar.b(1800000);
                    kf kfVar = new kf(bmVar, this.b, this.c);
                    this.l = kfVar;
                    this.m = new bc(this.a.b() + File.separator + this.a.c(), this.b);
                    this.l.a(this);
                } else if (this.j != null) {
                    this.j.a(bl.a.amap_exception);
                }
            } else if (this.j != null) {
                this.j.a(bl.a.network_exception);
            }
        } catch (AMapException e2) {
            iu.b((Throwable) e2, "SiteFileFetch", "download");
            if (this.j != null) {
                this.j.a(bl.a.amap_exception);
            }
        } catch (IOException unused) {
            if (this.j != null) {
                this.j.a(bl.a.file_io_exception);
            }
        }
    }

    private long e() throws IOException {
        int i2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.a()).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", g.d);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 400) {
            PrintStream printStream = System.err;
            printStream.println("Error Code : " + responseCode);
            return -2;
        }
        int i3 = 1;
        while (true) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i3);
            if (headerFieldKey == null) {
                i2 = -1;
                break;
            } else if (headerFieldKey.equalsIgnoreCase("Content-Length")) {
                i2 = Integer.parseInt(httpURLConnection.getHeaderField(headerFieldKey));
                break;
            } else {
                i3++;
            }
        }
        return (long) i2;
    }

    private void f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a != null && currentTimeMillis - this.g > 500) {
            g();
            this.g = currentTimeMillis;
            long j2 = this.b;
            if (this.d > 0 && this.j != null) {
                this.j.a(this.d, j2);
                this.g = System.currentTimeMillis();
            }
        }
    }

    private void g() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public final void b() {
        if (this.l != null) {
            this.l.a();
        }
    }

    public final void c() {
        if (this.j != null) {
            this.j.o();
        }
        g();
    }

    public final void d() {
        f();
        if (this.j != null) {
            this.j.n();
        }
        if (this.m != null) {
            this.m.a();
        }
        if (this.h != null) {
            this.h.d();
        }
    }

    public final void a(Throwable th) {
        if (this.j != null) {
            this.j.a(bl.a.network_exception);
        }
        if (!(th instanceof IOException) && this.m != null) {
            this.m.a();
        }
    }

    public final void a(byte[] bArr, long j2) {
        try {
            this.m.a(bArr);
            this.b = j2;
            f();
        } catch (IOException e2) {
            e2.printStackTrace();
            iu.b((Throwable) e2, "fileAccessI", "fileAccessI.write(byte[] data)");
            if (this.j != null) {
                this.j.a(bl.a.file_io_exception);
            }
            if (this.l != null) {
                this.l.a();
            }
        }
    }

    public final void a(a aVar) {
        this.h = aVar;
    }
}
