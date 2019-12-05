package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.a.cr;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexFileManager */
public class cn {

    /* compiled from: DexFileManager */
    public static class a {
        public static void a(bu buVar, cr crVar, String str) {
            buVar.a((Object) crVar, str);
        }

        public static cr a(bu buVar, String str) {
            List<cr> b = buVar.b(cr.b(str), cr.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return b.get(0);
        }

        public static List<cr> a(bu buVar, String str, String str2) {
            return buVar.b(cr.b(str, str2), cr.class);
        }
    }

    static String a(String str) {
        return str + ".o";
    }

    static String a(Context context, String str, String str2) {
        String q = bd.q(context);
        return bf.b(str + str2 + q) + ".jar";
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    public static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    public static void a(Context context, bh bhVar) {
        try {
            String b = b(context, bhVar.a(), bhVar.b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a2 = a(context, a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a2, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        a(context, file, a2, bhVar);
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    c(context, bhVar.a(), bhVar.b());
                }
            }
        } catch (Throwable th) {
            cs.a(th, "BaseClassLoader", "getInstanceByThread()");
        }
    }

    static void b(Context context, String str) {
        bu buVar = new bu(context, cq.c());
        List<cr> a2 = a.a(buVar, str, "copy");
        cs.a(a2);
        if (a2 != null) {
            if (a2.size() > 1) {
                int size = a2.size();
                for (int i = 1; i < size; i++) {
                    c(context, buVar, a2.get(i).a());
                }
            }
        }
    }

    static void a(Context context, bu buVar, String str) {
        c(context, buVar, str);
        c(context, buVar, a(str));
    }

    static void c(final Context context, final String str, final String str2) {
        bo.b().submit(new Runnable() {
            public void run() {
                try {
                    bu buVar = new bu(context, cq.c());
                    List<cr> b2 = buVar.b(cr.a(str), cr.class);
                    if (b2 != null && b2.size() > 0) {
                        for (cr next : b2) {
                            if (!str2.equalsIgnoreCase(next.d())) {
                                cn.c(context, buVar, next.a());
                            }
                        }
                    }
                } catch (Throwable th) {
                    cs.a(th, "FileManager", "clearUnSuitableV");
                }
            }
        });
    }

    static void a(bu buVar, Context context, String str) {
        List<cr> a2 = a.a(buVar, str, "used");
        if (a2 != null && a2.size() > 0) {
            for (cr next : a2) {
                if (next != null && next.c().equals(str)) {
                    a(context, buVar, next.a());
                    List<cr> b = buVar.b(cr.a(str, next.e()), cr.class);
                    if (b != null && b.size() > 0) {
                        cr crVar = b.get(0);
                        crVar.c("errorstatus");
                        a.a(buVar, crVar, cr.b(crVar.a()));
                        File file = new File(a(context, crVar.a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, bu buVar, bh bhVar, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        File file;
        FileInputStream fileInputStream2 = null;
        try {
            String a2 = bhVar.a();
            String a3 = a(context, a2, bhVar.b());
            a(context, buVar, a3);
            fileInputStream = new FileInputStream(new File(str));
            try {
                fileInputStream.read(new byte[32]);
                file = new File(b(context, a2, bhVar.b()));
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                try {
                    cs.a((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    cs.a((Closeable) randomAccessFile);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                int i = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    if (read == 1024) {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr2);
                    }
                    i += read;
                }
                cr.a aVar = new cr.a(a3, bf.a(file.getAbsolutePath()), a2, bhVar.b(), str2);
                cr a4 = aVar.a("used").a();
                a.a(buVar, a4, cr.b(a4.a()));
                try {
                    cs.a((Closeable) fileInputStream);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    cs.a((Closeable) randomAccessFile);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
                cs.a((Closeable) fileInputStream);
                cs.a((Closeable) randomAccessFile);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile = null;
            fileInputStream = null;
            cs.a((Closeable) fileInputStream);
            cs.a((Closeable) randomAccessFile);
            throw th;
        }
    }

    static String a(Context context, bu buVar, bh bhVar) {
        List<cr> b = buVar.b(cr.b(bhVar.a(), "copy"), cr.class);
        if (b == null || b.size() == 0) {
            return null;
        }
        cs.a(b);
        int i = 0;
        while (i < b.size()) {
            cr crVar = b.get(i);
            if (cs.a(context, buVar, crVar.a(), bhVar)) {
                try {
                    a(context, buVar, bhVar, a(context, crVar.a()), crVar.e());
                    return crVar.e();
                } catch (Throwable th) {
                    cs.a(th, "FileManager", "loadAvailableD");
                }
            } else {
                c(context, buVar, crVar.a());
                i++;
            }
        }
        return null;
    }

    static void a(Context context, File file, bh bhVar) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            c(context, bhVar.a(), bhVar.b());
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, bu buVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        buVar.a(cr.b(str), cr.class);
    }

    private static void a(Context context, File file, String str, bh bhVar) {
        bu buVar = new bu(context, cq.c());
        cr a2 = a.a(buVar, file.getName());
        String e = a2 != null ? a2.e() : null;
        File file2 = new File(str);
        if (!TextUtils.isEmpty(e) && file2.exists()) {
            String a3 = bf.a(str);
            String name = file2.getName();
            cr.a aVar = new cr.a(name, a3, bhVar.a(), bhVar.b(), e);
            a.a(buVar, aVar.a("useod").a(), cr.b(name));
        }
    }
}
