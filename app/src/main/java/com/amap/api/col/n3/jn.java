package com.amap.api.col.n3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.n3.js;
import com.amap.api.col.n3.jw;
import com.amap.api.col.n3.kf;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexDownLoad */
public final class jn extends Thread implements kf.a {
    private jo a;
    private kf b;
    private im c;
    private String d;
    private RandomAccessFile e;
    private Context f;

    public final void c() {
    }

    public jn(Context context, jo joVar, im imVar) {
        try {
            this.f = context.getApplicationContext();
            this.c = imVar;
            if (joVar != null) {
                this.a = joVar;
                this.b = new kf(new jr(this.a));
                this.d = js.a(context, this.a.a);
            }
        } catch (Throwable th) {
            ir.a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    public final void a() {
        try {
            start();
        } catch (Throwable th) {
            ir.a(th, "dDownLoad", "startDownload()");
        }
    }

    public final void run() {
        try {
            if (b()) {
                kp kpVar = new kp(this.f, this.c.a(), this.c.b(), "O008");
                kpVar.a("{\"param_int_first\":0}");
                kq.a(kpVar, this.f);
                this.b.a(this);
            }
        } catch (Throwable th) {
            ir.a(th, "dDownLoad", "run()");
        }
    }

    private boolean a(ja jaVar, jw jwVar, jo joVar) {
        String str = joVar.b;
        String str2 = joVar.c;
        String str3 = joVar.d;
        String str4 = joVar.e;
        if ("errorstatus".equals(jwVar.f())) {
            if (!new File(js.b(this.f, this.c.a(), this.c.b())).exists() && !TextUtils.isEmpty(js.a(this.f, jaVar, this.c))) {
                try {
                    js.a(this.f, this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return true;
        } else if (!new File(this.d).exists()) {
            return false;
        } else {
            List<jw> b2 = jaVar.b(jw.a(js.a(this.f, str, str2), str, str2, str3), jw.class);
            if (b2 != null && b2.size() > 0) {
                return true;
            }
            try {
                js.a(this.f, str, this.c.b());
                js.a(this.f, jaVar, this.c, this.d, str3);
                js.a(this.f, this.c);
            } catch (Throwable th2) {
                ir.a(th2, "dDownLoad", "processDownloadedFile()");
            }
            return true;
        }
    }

    private boolean a(ja jaVar) {
        try {
            List<jw> a2 = js.a.a(jaVar, this.a.b, "used");
            if (a2 == null || a2.size() <= 0 || jy.a(a2.get(0).e(), this.a.d) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            ir.a(th, "dDownLoad", "isUsed()");
        }
    }

    private boolean b() {
        boolean z;
        try {
            if (this.c != null && this.c.a().equals(this.a.b) && this.c.b().equals(this.a.c)) {
                if (Build.VERSION.SDK_INT >= this.a.g && Build.VERSION.SDK_INT <= this.a.f) {
                    if (ih.n(this.f) == 1) {
                        ja jaVar = new ja(this.f, ju.a());
                        if (a(jaVar)) {
                            z = true;
                        } else {
                            jw a2 = js.a.a(jaVar, this.a.a);
                            z = a2 != null ? a(jaVar, a2, this.a) : false;
                        }
                        if (!z) {
                            js.b(this.f, this.c.a());
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            ir.a(th, "dDownLoad", "isNeedDownload()");
            return false;
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
            ir.a(th, "dDownLoad", "onDownload()");
        }
    }

    public final void a(Throwable th) {
        try {
            jy.a((Closeable) this.e);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void d() {
        try {
            if (this.e != null) {
                jy.a((Closeable) this.e);
                String b2 = this.a.b();
                if (jy.b(this.d, b2)) {
                    String str = this.a.c;
                    ja jaVar = new ja(this.f, ju.a());
                    jw.a aVar = new jw.a(this.a.a, b2, this.a.b, str, this.a.d);
                    jaVar.a((Object) aVar.a("copy").a(), jw.a(this.a.a, this.a.b, str, this.a.d));
                    SharedPreferences.Editor edit = this.f.getSharedPreferences(this.a.b, 0).edit();
                    edit.clear();
                    edit.commit();
                    try {
                        js.a(this.f, jaVar, this.c, this.d, this.a.d);
                        js.a(this.f, this.c);
                    } catch (Throwable th) {
                        ir.a(th, "dDownLoad", "onFinish1");
                    }
                    kp kpVar = new kp(this.f, this.c.a(), this.c.b(), "O008");
                    kpVar.a("{\"param_int_first\":1}");
                    kq.a(kpVar, this.f);
                    return;
                }
                try {
                    new File(this.d).delete();
                } catch (Throwable th2) {
                    ir.a(th2, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th3) {
            ir.a(th3, "dDownLoad", "onFinish()");
        }
    }
}
