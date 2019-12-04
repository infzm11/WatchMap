package com.iflytek.sunflower.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Linker {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final String FLYIME_SO_ABI = "armeabi";
    private static final String LIB_DIR = "lib";
    private static final int MAX_TRIES = 5;
    private static final String TAG = "Linker";

    private Linker() {
    }

    public static boolean loadLibrary(Context context, String str, long j, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            j.c(TAG, "loadLibrary | System.loadLibrary error", e);
            File workaroundLibFile = getWorkaroundLibFile(context, str);
            if (!workaroundLibFile.exists() || ((j > 0 && j != workaroundLibFile.length()) || TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase(d.a(workaroundLibFile)))) {
                unpackLibrary(context, str);
            }
            System.load(workaroundLibFile.getAbsolutePath());
            return true;
        } catch (Throwable unused) {
            j.d(TAG, "loadLibrary | System.load error");
            return false;
        }
    }

    public static boolean loadLibrary(Context context, String str) {
        return loadLibrary(context, str, -1, "");
    }

    private static File getWorkaroundLibDir(Context context) {
        return context.getDir(LIB_DIR, 0);
    }

    private static File getWorkaroundLibFile(Context context, String str) {
        return new File(getWorkaroundLibDir(context), System.mapLibraryName(str));
    }

    private static void clearWorkaroundLibDir(Context context, String str) {
        File workaroundLibDir = getWorkaroundLibDir(context);
        if (workaroundLibDir.exists() && workaroundLibDir.isDirectory()) {
            File[] listFiles = workaroundLibDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.getName().contains(str)) {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        closeSilently(r1);
        closeSilently(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (com.iflytek.sunflower.util.a.b() < 9) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        r7.setReadable(true, false);
        r7.setExecutable(true, false);
        r7.setWritable(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        java.lang.Runtime.getRuntime().exec("chmod 777 " + r7.getAbsolutePath());
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c7 A[SYNTHETIC, Splitter:B:71:0x00c7] */
    @android.annotation.TargetApi(9)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void unpackLibrary(android.content.Context r9, java.lang.String r10) {
        /*
            r0 = 0
            android.content.pm.ApplicationInfo r1 = r9.getApplicationInfo()     // Catch:{ all -> 0x00c3 }
            r2 = 0
            r3 = r2
        L_0x0007:
            int r4 = r3 + 1
            r5 = 5
            r6 = 1
            if (r3 >= r5) goto L_0x001c
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001a }
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x001a }
            java.lang.String r8 = r1.sourceDir     // Catch:{ IOException -> 0x001a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x001a }
            r3.<init>(r7, r6)     // Catch:{ IOException -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r3 = r4
            goto L_0x0007
        L_0x001c:
            r3 = r0
        L_0x001d:
            if (r3 != 0) goto L_0x0025
            if (r3 == 0) goto L_0x0024
            r3.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            return
        L_0x0025:
            r1 = r2
        L_0x0026:
            int r4 = r1 + 1
            if (r1 >= r5) goto L_0x00bd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r1.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "lib/armeabi/"
            r1.append(r7)     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = java.lang.System.mapLibraryName(r10)     // Catch:{ all -> 0x00bb }
            r1.append(r7)     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00bb }
            java.util.zip.ZipEntry r1 = r3.getEntry(r1)     // Catch:{ all -> 0x00bb }
            if (r1 != 0) goto L_0x0047
            goto L_0x00bd
        L_0x0047:
            java.io.File r7 = getWorkaroundLibFile(r9, r10)     // Catch:{ all -> 0x00bb }
            clearWorkaroundLibDir(r9, r10)     // Catch:{ all -> 0x00bb }
            boolean r8 = r7.createNewFile()     // Catch:{ IOException -> 0x00b8 }
            if (r8 != 0) goto L_0x0056
            goto L_0x00b8
        L_0x0056:
            java.io.InputStream r1 = r3.getInputStream(r1)     // Catch:{ FileNotFoundException -> 0x00b2, IOException -> 0x00a9, all -> 0x00a0 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009c, all -> 0x009a }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009c, all -> 0x009a }
            copy(r1, r8)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00ab, all -> 0x0097 }
            closeSilently(r1)     // Catch:{ all -> 0x00bb }
            closeSilently(r8)     // Catch:{ all -> 0x00bb }
            int r9 = com.iflytek.sunflower.util.a.b()     // Catch:{ all -> 0x00bb }
            r10 = 9
            if (r9 < r10) goto L_0x007a
            r7.setReadable(r6, r2)     // Catch:{ all -> 0x00bb }
            r7.setExecutable(r6, r2)     // Catch:{ all -> 0x00bb }
            r7.setWritable(r6)     // Catch:{ all -> 0x00bb }
            goto L_0x00bd
        L_0x007a:
            java.lang.Runtime r9 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x00bd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd }
            r10.<init>()     // Catch:{ IOException -> 0x00bd }
            java.lang.String r0 = "chmod 777 "
            r10.append(r0)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r0 = r7.getAbsolutePath()     // Catch:{ IOException -> 0x00bd }
            r10.append(r0)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x00bd }
            r9.exec(r10)     // Catch:{ IOException -> 0x00bd }
            goto L_0x00bd
        L_0x0097:
            r9 = move-exception
            r0 = r8
            goto L_0x00a2
        L_0x009a:
            r9 = move-exception
            goto L_0x00a2
        L_0x009c:
            r8 = r0
            goto L_0x00ab
        L_0x009e:
            r8 = r0
            goto L_0x00b4
        L_0x00a0:
            r9 = move-exception
            r1 = r0
        L_0x00a2:
            closeSilently(r1)     // Catch:{ all -> 0x00bb }
            closeSilently(r0)     // Catch:{ all -> 0x00bb }
            throw r9     // Catch:{ all -> 0x00bb }
        L_0x00a9:
            r1 = r0
            r8 = r1
        L_0x00ab:
            closeSilently(r1)     // Catch:{ all -> 0x00bb }
        L_0x00ae:
            closeSilently(r8)     // Catch:{ all -> 0x00bb }
            goto L_0x00b8
        L_0x00b2:
            r1 = r0
            r8 = r1
        L_0x00b4:
            closeSilently(r1)     // Catch:{ all -> 0x00bb }
            goto L_0x00ae
        L_0x00b8:
            r1 = r4
            goto L_0x0026
        L_0x00bb:
            r9 = move-exception
            goto L_0x00c5
        L_0x00bd:
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ IOException -> 0x00c2 }
        L_0x00c2:
            return
        L_0x00c3:
            r9 = move-exception
            r3 = r0
        L_0x00c5:
            if (r3 == 0) goto L_0x00ca
            r3.close()     // Catch:{ IOException -> 0x00ca }
        L_0x00ca:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.util.Linker.unpackLibrary(android.content.Context, java.lang.String):void");
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
