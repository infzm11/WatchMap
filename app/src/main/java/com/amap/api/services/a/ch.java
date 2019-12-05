package com.amap.api.services.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.services.a.cn;
import com.amap.api.services.a.cr;
import com.amap.api.services.a.cz;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexDownLoad */
public class ch extends Thread implements cz.a {
    private ci a;
    private cz b;
    private bh c;
    private String d;
    private RandomAccessFile e;
    private Context f;

    public void e() {
    }

    public ch(Context context, ci ciVar, bh bhVar) {
        try {
            this.f = context.getApplicationContext();
            this.c = bhVar;
            if (ciVar != null) {
                this.a = ciVar;
                this.b = new cz(new cm(this.a));
                this.d = cn.a(context, this.a.a);
            }
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    public void a() {
        try {
            start();
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "startDownload()");
        }
    }

    public void run() {
        try {
            if (c()) {
                di diVar = new di(this.f, this.c.a(), this.c.b(), "O008");
                diVar.a("{\"param_int_first\":0}");
                dj.a(diVar, this.f);
                this.b.a(this);
            }
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "run()");
        }
    }

    private boolean a(bu buVar, cr crVar, ci ciVar) {
        String str = ciVar.b;
        String str2 = ciVar.c;
        String str3 = ciVar.d;
        String str4 = ciVar.e;
        if ("errorstatus".equals(crVar.f())) {
            b(buVar);
            return true;
        } else if (!new File(this.d).exists()) {
            return false;
        } else {
            List<cr> b2 = buVar.b(cr.a(cn.a(this.f, str, str2), str, str2, str3), cr.class);
            if (b2 != null && b2.size() > 0) {
                return true;
            }
            try {
                cn.a(this.f, str, this.c.b());
                cn.a(this.f, buVar, this.c, this.d, str3);
                cn.a(this.f, this.c);
            } catch (Throwable th) {
                cs.a(th, "dDownLoad", "processDownloadedFile()");
            }
            return true;
        }
    }

    private boolean a(bu buVar) {
        try {
            List<cr> a2 = cn.a.a(buVar, this.a.b, "used");
            if (a2 == null || a2.size() <= 0 || cs.a(a2.get(0).e(), this.a.d) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "isUsed()");
        }
    }

    private boolean f() {
        bu buVar = new bu(this.f, cq.c());
        if (a(buVar)) {
            return true;
        }
        cr a2 = cn.a.a(buVar, this.a.a);
        if (a2 != null) {
            return a(buVar, a2, this.a);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (this.c != null && this.c.a().equals(this.a.b) && this.c.b().equals(this.a.c)) {
            return true;
        }
        return false;
    }

    private boolean g() {
        return Build.VERSION.SDK_INT >= this.a.g && Build.VERSION.SDK_INT <= this.a.f;
    }

    private boolean a(Context context) {
        return bd.m(context) == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        try {
            if (!b() || !g() || !a(this.f) || f()) {
                return false;
            }
            cn.b(this.f, this.c.a());
            return true;
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public void a(byte[] bArr, long j) {
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
            cs.a(th, "dDownLoad", "onDownload()");
        }
    }

    public void a(Throwable th) {
        try {
            cs.a((Closeable) this.e);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void d() {
        try {
            if (this.e != null) {
                cs.a((Closeable) this.e);
                String b2 = this.a.b();
                if (cs.b(this.d, b2)) {
                    a(b2);
                    di diVar = new di(this.f, this.c.a(), this.c.b(), "O008");
                    diVar.a("{\"param_int_first\":1}");
                    dj.a(diVar, this.f);
                    return;
                }
                new File(this.d).delete();
            }
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "onFinish()");
        }
    }

    private void b(bu buVar) {
        if (!new File(cn.b(this.f, this.c.a(), this.c.b())).exists() && !TextUtils.isEmpty(cn.a(this.f, buVar, this.c))) {
            try {
                cn.a(this.f, this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(String str) {
        String c2 = this.a.c();
        bu buVar = new bu(this.f, cq.c());
        cr.a aVar = new cr.a(this.a.a, str, this.a.b, c2, this.a.d);
        cn.a.a(buVar, aVar.a("copy").a(), cr.a(this.a.a, this.a.b, c2, this.a.d));
        a(this.f, this.a.b);
        try {
            cn.a(this.f, buVar, this.c, this.d, this.a.d);
            cn.a(this.f, this.c);
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "onFinish1");
        }
    }

    private void a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.commit();
        } catch (Throwable th) {
            cs.a(th, "dDownLoad", "clearMarker()");
        }
    }
}
