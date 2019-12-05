package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.loc.ay;
import com.loc.bc;
import com.loc.bk;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexDownLoad */
public final class as extends Thread implements bk.a {
    private at a;
    private bk b;
    private s c;
    private String d;
    private RandomAccessFile e;
    private Context f;

    public as(Context context, at atVar, s sVar) {
        try {
            this.f = context.getApplicationContext();
            this.c = sVar;
            if (atVar != null) {
                this.a = atVar;
                this.b = new bk(new ax(this.a));
                this.d = ay.a(context, this.a.a);
            }
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    private boolean a(af afVar) {
        try {
            List<bc> a2 = ay.a.a(afVar, this.a.b, "used");
            return a2 != null && a2.size() > 0 && bd.a(a2.get(0).e(), this.a.d) > 0;
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "isUsed()");
        }
    }

    private boolean a(af afVar, bc bcVar, at atVar) {
        String str = atVar.b;
        String str2 = atVar.c;
        String str3 = atVar.d;
        String str4 = atVar.e;
        if ("errorstatus".equals(bcVar.f())) {
            if (!new File(ay.b(this.f, this.c.a(), this.c.b())).exists() && !TextUtils.isEmpty(ay.a(this.f, afVar, this.c))) {
                try {
                    ay.a(this.f, this.c);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return true;
        } else if (!new File(this.d).exists()) {
            return false;
        } else {
            List<bc> b2 = afVar.b(bc.a(ay.a(this.f, str, str2), str, str2, str3), bc.class);
            if (b2 != null && b2.size() > 0) {
                return true;
            }
            try {
                ay.a(this.f, str, this.c.b());
                ay.a(this.f, afVar, this.c, this.d, str3);
                ay.a(this.f, this.c);
                return true;
            } catch (Throwable th2) {
                w.a(th2, "dDownLoad", "processDownloadedFile()");
                return true;
            }
        }
    }

    private boolean e() {
        boolean z;
        try {
            if (this.c != null && this.c.a().equals(this.a.b) && this.c.b().equals(this.a.c)) {
                if (Build.VERSION.SDK_INT >= this.a.g && Build.VERSION.SDK_INT <= this.a.f) {
                    if (n.n(this.f) == 1) {
                        af afVar = new af(this.f, bb.b());
                        if (a(afVar)) {
                            z = true;
                        } else {
                            bc a2 = ay.a.a(afVar, this.a.a);
                            z = a2 != null ? a(afVar, a2, this.a) : false;
                        }
                        if (!z) {
                            ay.b(this.f, this.c.a());
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public final void a() {
        try {
            start();
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "startDownload()");
        }
    }

    public final void a(byte[] bArr, long j) {
        try {
            if (this.e == null) {
                File file = new File(this.d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.e = new RandomAccessFile(file, "rw");
            }
            this.e.seek(j);
            this.e.write(bArr);
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "onDownload()");
        }
    }

    public final void b() {
    }

    public final void c() {
        try {
            if (this.e != null) {
                bd.a((Closeable) this.e);
                String b2 = this.a.b();
                if (bd.b(this.d, b2)) {
                    String str = this.a.c;
                    af afVar = new af(this.f, bb.b());
                    bc.a aVar = new bc.a(this.a.a, b2, this.a.b, str, this.a.d);
                    afVar.a((Object) aVar.a("copy").a(), bc.a(this.a.a, this.a.b, str, this.a.d));
                    SharedPreferences.Editor edit = this.f.getSharedPreferences(this.a.b, 0).edit();
                    edit.clear();
                    edit.commit();
                    try {
                        ay.a(this.f, afVar, this.c, this.d, this.a.d);
                        ay.a(this.f, this.c);
                    } catch (Throwable th) {
                        w.a(th, "dDownLoad", "onFinish1");
                    }
                    br brVar = new br(this.f, this.c.a(), this.c.b(), "O008");
                    brVar.a("{\"param_int_first\":1}");
                    bs.a(brVar, this.f);
                    return;
                }
                try {
                    new File(this.d).delete();
                } catch (Throwable th2) {
                    w.a(th2, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th3) {
            w.a(th3, "dDownLoad", "onFinish()");
        }
    }

    public final void d() {
        try {
            bd.a((Closeable) this.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void run() {
        try {
            if (e()) {
                br brVar = new br(this.f, this.c.a(), this.c.b(), "O008");
                brVar.a("{\"param_int_first\":0}");
                bs.a(brVar, this.f);
                this.b.a(this);
            }
        } catch (Throwable th) {
            w.a(th, "dDownLoad", "run()");
        }
    }
}
