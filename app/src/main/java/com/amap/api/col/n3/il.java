package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.n3.kf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: SDKCoordinatorDownload */
public final class il extends Thread implements kf.a {
    private static String h = "sodownload";
    private static String i = "sofail";
    private kf a = new kf(this.b);
    private a b;
    private RandomAccessFile c;
    private String d;
    private String e;
    private String f;
    private Context g;

    /* compiled from: SDKCoordinatorDownload */
    private static class a extends kj {
        private String a;

        public final Map<String, String> a() {
            return null;
        }

        public final Map<String, String> b() {
            return null;
        }

        a(String str) {
            this.a = str;
        }

        public final String c() {
            return this.a;
        }
    }

    public il(Context context, String str, String str2, String str3) {
        this.g = context;
        this.f = str3;
        this.d = a(context, str + "temp.so");
        this.e = a(context, "libwgs2gcj.so");
        this.b = new a(str2);
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    public final void a() {
        if (this.b != null && !TextUtils.isEmpty(this.b.c()) && this.b.c().contains("libJni_wgs2gcj.so") && this.b.c().contains(in.a(this.g)) && !new File(this.e).exists()) {
            start();
        }
    }

    public final void run() {
        try {
            File file = new File(a(this.g, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.a.a(this);
        } catch (Throwable th) {
            ir.a(th, "sdl", "run");
            b();
        }
    }

    public final void a(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new RandomAccessFile(file, "rw");
            }
        } catch (FileNotFoundException e2) {
            ir.a((Throwable) e2, "sdl", "oDd");
            b();
        } catch (Throwable th) {
            b();
            ir.a(th, "sdl", "oDd");
            return;
        }
        if (this.c != null) {
            try {
                this.c.seek(j);
                this.c.write(bArr);
            } catch (IOException e3) {
                b();
                ir.a((Throwable) e3, "sdl", "oDd");
            }
        }
    }

    public final void c() {
        b();
    }

    public final void d() {
        try {
            if (this.c != null) {
                this.c.close();
            }
            String a2 = ij.a(this.d);
            if (a2 == null || !a2.equalsIgnoreCase(this.f)) {
                b();
            } else if (new File(this.e).exists()) {
                b();
            } else {
                new File(this.d).renameTo(new File(this.e));
            }
        } catch (Throwable th) {
            b();
            File file = new File(this.e);
            if (file.exists()) {
                file.delete();
            }
            ir.a(th, "sdl", "ofs");
        }
    }

    public final void a(Throwable th) {
        try {
            if (this.c != null) {
                this.c.close();
            }
            b();
            File file = new File(a(this.g, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable th2) {
            ir.a(th2, "sdl", "oe");
        }
    }

    private void b() {
        File file = new File(this.d);
        if (file.exists()) {
            file.delete();
        }
    }
}
