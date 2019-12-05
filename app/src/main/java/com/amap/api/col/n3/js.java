package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.n3.jw;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexFileManager */
public final class js {

    /* compiled from: DexFileManager */
    public static class a {
        public static jw a(ja jaVar, String str) {
            List<jw> b = jaVar.b(jw.b(str), jw.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return b.get(0);
        }

        public static List<jw> a(ja jaVar, String str, String str2) {
            return jaVar.b(jw.b(str, str2), jw.class);
        }
    }

    static String a(String str) {
        return str + ".o";
    }

    static String a(Context context, String str, String str2) {
        String q = ih.q(context);
        return ij.b(str + str2 + q) + ".jar";
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    static void a(Context context, im imVar) {
        try {
            String b = b(context, imVar.a(), imVar.b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a2 = a(context, a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a2, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        String str = null;
                        ja jaVar = new ja(context, ju.a());
                        jw a3 = a.a(jaVar, file.getName());
                        if (a3 != null) {
                            str = a3.e();
                        }
                        String str2 = str;
                        File file2 = new File(a2);
                        if (!TextUtils.isEmpty(str2) && file2.exists()) {
                            String a4 = ij.a(a2);
                            String name = file2.getName();
                            jw.a aVar = new jw.a(name, a4, imVar.a(), imVar.b(), str2);
                            jaVar.a((Object) aVar.a("useod").a(), jw.b(name));
                        }
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    c(context, imVar.a(), imVar.b());
                }
            }
        } catch (Throwable th) {
            ir.a(th, "BaseLoader", "getInstanceByThread()");
        }
    }

    static void b(Context context, String str) {
        ja jaVar = new ja(context, ju.a());
        List<jw> a2 = a.a(jaVar, str, "copy");
        jy.a(a2);
        if (a2 != null) {
            if (a2.size() > 1) {
                int size = a2.size();
                for (int i = 1; i < size; i++) {
                    c(context, jaVar, a2.get(i).a());
                }
            }
        }
    }

    static void a(Context context, ja jaVar, String str) {
        c(context, jaVar, str);
        c(context, jaVar, a(str));
    }

    static void c(final Context context, final String str, final String str2) {
        iu.c().submit(new Runnable() {
            public final void run() {
                try {
                    ja jaVar = new ja(context, ju.a());
                    List<jw> b2 = jaVar.b(jw.a(str), jw.class);
                    if (b2 != null && b2.size() > 0) {
                        for (jw next : b2) {
                            if (!str2.equalsIgnoreCase(next.d())) {
                                js.c(context, jaVar, next.a());
                            }
                        }
                    }
                } catch (Throwable th) {
                    ir.a(th, "FileManager", "clearUnSuitableV");
                }
            }
        });
    }

    static void a(ja jaVar, Context context, String str) {
        List<jw> a2 = a.a(jaVar, str, "used");
        if (a2 != null && a2.size() > 0) {
            for (jw next : a2) {
                if (next != null && next.c().equals(str)) {
                    a(context, jaVar, next.a());
                    List<jw> b = jaVar.b(jw.a(str, next.e()), jw.class);
                    if (b != null && b.size() > 0) {
                        jw jwVar = b.get(0);
                        jwVar.c("errorstatus");
                        jaVar.a((Object) jwVar, jw.b(jwVar.a()));
                        File file = new File(a(context, jwVar.a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    static void a(Context context, ja jaVar, im imVar, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        File file;
        FileInputStream fileInputStream2 = null;
        try {
            String a2 = imVar.a();
            String a3 = a(context, a2, imVar.b());
            a(context, jaVar, a3);
            fileInputStream = new FileInputStream(new File(str));
            try {
                fileInputStream.read(new byte[32]);
                file = new File(b(context, a2, imVar.b()));
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                try {
                    jy.a((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    jy.a((Closeable) randomAccessFile);
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
                jw.a aVar = new jw.a(a3, ij.a(file.getAbsolutePath()), a2, imVar.b(), str2);
                jw a4 = aVar.a("used").a();
                jaVar.a((Object) a4, jw.b(a4.a()));
                try {
                    jy.a((Closeable) fileInputStream);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    jy.a((Closeable) randomAccessFile);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
                jy.a((Closeable) fileInputStream);
                jy.a((Closeable) randomAccessFile);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile = null;
            fileInputStream = null;
            jy.a((Closeable) fileInputStream);
            jy.a((Closeable) randomAccessFile);
            throw th;
        }
    }

    static String a(Context context, ja jaVar, im imVar) {
        List<jw> b = jaVar.b(jw.b(imVar.a(), "copy"), jw.class);
        if (b == null || b.size() == 0) {
            return null;
        }
        jy.a(b);
        int i = 0;
        while (i < b.size()) {
            jw jwVar = b.get(i);
            String a2 = jwVar.a();
            if (jy.a(jaVar, a2, a(context, a2), imVar)) {
                try {
                    a(context, jaVar, imVar, a(context, jwVar.a()), jwVar.e());
                    return jwVar.e();
                } catch (Throwable th) {
                    ir.a(th, "FileManager", "loadAvailableD");
                }
            } else {
                c(context, jaVar, jwVar.a());
                i++;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void c(Context context, ja jaVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        jaVar.a(jw.b(str), jw.class);
    }
}
