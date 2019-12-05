package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.loc.bc;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexFileManager */
public final class ay {

    /* compiled from: DexFileManager */
    public static class a {
        public static bc a(af afVar, String str) {
            List<bc> b = afVar.b(bc.b(str), bc.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return b.get(0);
        }

        public static List<bc> a(af afVar, String str, String str2) {
            return afVar.b(bc.b(str, str2), bc.class);
        }
    }

    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    static String a(Context context, af afVar, s sVar) {
        List<bc> b = afVar.b(bc.b(sVar.a(), "copy"), bc.class);
        if (b == null || b.size() == 0) {
            return null;
        }
        bd.a(b);
        int i = 0;
        while (i < b.size()) {
            bc bcVar = b.get(i);
            String a2 = bcVar.a();
            if (bd.a(afVar, a2, a(context, a2), sVar)) {
                try {
                    a(context, afVar, sVar, a(context, bcVar.a()), bcVar.e());
                    return bcVar.e();
                } catch (Throwable th) {
                    w.a(th, "FileManager", "loadAvailableD");
                }
            } else {
                c(context, afVar, bcVar.a());
                i++;
            }
        }
        return null;
    }

    public static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context, String str, String str2) {
        String r = n.r(context);
        return p.b(str + str2 + r) + ".jar";
    }

    static String a(String str) {
        return str + ".o";
    }

    public static void a(Context context, af afVar, s sVar, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        File file;
        FileInputStream fileInputStream2 = null;
        try {
            String a2 = sVar.a();
            String a3 = a(context, a2, sVar.b());
            a(context, afVar, a3);
            fileInputStream = new FileInputStream(new File(str));
            try {
                fileInputStream.read(new byte[32]);
                file = new File(b(context, a2, sVar.b()));
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                try {
                    bd.a((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    bd.a((Closeable) randomAccessFile);
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
                bc.a aVar = new bc.a(a3, p.a(file.getAbsolutePath()), a2, sVar.b(), str2);
                bc a4 = aVar.a("used").a();
                afVar.a((Object) a4, bc.b(a4.a()));
                try {
                    bd.a((Closeable) fileInputStream);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    bd.a((Closeable) randomAccessFile);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
                bd.a((Closeable) fileInputStream);
                bd.a((Closeable) randomAccessFile);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile = null;
            fileInputStream = null;
            bd.a((Closeable) fileInputStream);
            bd.a((Closeable) randomAccessFile);
            throw th;
        }
    }

    static void a(Context context, af afVar, String str) {
        c(context, afVar, str);
        c(context, afVar, a(str));
    }

    public static void a(Context context, s sVar) {
        try {
            String b = b(context, sVar.a(), sVar.b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a2 = a(context, a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a2, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        String str = null;
                        af afVar = new af(context, bb.b());
                        bc a3 = a.a(afVar, file.getName());
                        if (a3 != null) {
                            str = a3.e();
                        }
                        String str2 = str;
                        File file2 = new File(a2);
                        if (!TextUtils.isEmpty(str2) && file2.exists()) {
                            String a4 = p.a(a2);
                            String name = file2.getName();
                            bc.a aVar = new bc.a(name, a4, sVar.a(), sVar.b(), str2);
                            afVar.a((Object) aVar.a("useod").a(), bc.b(name));
                        }
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    c(context, sVar.a(), sVar.b());
                }
            }
        } catch (Throwable th) {
            w.a(th, "BaseClassLoader", "getInstanceByThread()");
        }
    }

    static void a(af afVar, Context context, String str) {
        List<bc> a2 = a.a(afVar, str, "used");
        if (a2 != null && a2.size() > 0) {
            for (bc next : a2) {
                if (next != null && next.c().equals(str)) {
                    a(context, afVar, next.a());
                    List<bc> b = afVar.b(bc.a(str, next.e()), bc.class);
                    if (b != null && b.size() > 0) {
                        bc bcVar = b.get(0);
                        bcVar.c("errorstatus");
                        afVar.a((Object) bcVar, bc.b(bcVar.a()));
                        File file = new File(a(context, bcVar.a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    static void b(Context context, String str) {
        af afVar = new af(context, bb.b());
        List<bc> a2 = a.a(afVar, str, "copy");
        bd.a(a2);
        if (a2 != null) {
            if (a2.size() > 1) {
                int size = a2.size();
                for (int i = 1; i < size; i++) {
                    c(context, afVar, a2.get(i).a());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, af afVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        afVar.a(bc.b(str), bc.class);
    }

    static void c(final Context context, final String str, final String str2) {
        z.b().submit(new Runnable() {
            public final void run() {
                try {
                    af afVar = new af(context, bb.b());
                    List<bc> b2 = afVar.b(bc.a(str), bc.class);
                    if (b2 != null && b2.size() > 0) {
                        for (bc next : b2) {
                            if (!str2.equalsIgnoreCase(next.d())) {
                                ay.c(context, afVar, next.a());
                            }
                        }
                    }
                } catch (Throwable th) {
                    w.a(th, "FileManager", "clearUnSuitableV");
                }
            }
        });
    }
}
