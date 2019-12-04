package com.iflytek.sunflower.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        r4 = r2;
        r2 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0063, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0072, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0076, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0057 A[SYNTHETIC, Splitter:B:38:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[Catch:{ IOException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006a A[SYNTHETIC, Splitter:B:47:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0072 A[Catch:{ IOException -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0050 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0050 }
            r2.write(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.finish()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r3 = 19
            if (r5 >= r3) goto L_0x001d
            r2.flush()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
        L_0x001d:
            byte[] r5 = r1.toByteArray()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r0 = 0
        L_0x0022:
            int r3 = r5.length     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            if (r0 >= r3) goto L_0x002f
            byte r3 = r5[r0]     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            r3 = r3 ^ 5
            byte r3 = (byte) r3     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            r5[r0] = r3     // Catch:{ IOException -> 0x0041, all -> 0x0046 }
            int r0 = r0 + 1
            goto L_0x0022
        L_0x002f:
            if (r2 == 0) goto L_0x0037
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            r0 = move-exception
            goto L_0x003d
        L_0x0037:
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0067
        L_0x003d:
            r0.printStackTrace()
            goto L_0x0067
        L_0x0041:
            r0 = move-exception
            r4 = r2
            r2 = r5
            r5 = r0
            goto L_0x004b
        L_0x0046:
            r5 = move-exception
            goto L_0x0068
        L_0x0048:
            r5 = move-exception
            r4 = r2
            r2 = r0
        L_0x004b:
            r0 = r4
            goto L_0x0052
        L_0x004d:
            r5 = move-exception
            r2 = r0
            goto L_0x0068
        L_0x0050:
            r5 = move-exception
            r2 = r0
        L_0x0052:
            r5.printStackTrace()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r5 = move-exception
            goto L_0x0063
        L_0x005d:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0066
        L_0x0063:
            r5.printStackTrace()
        L_0x0066:
            r5 = r2
        L_0x0067:
            return r5
        L_0x0068:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0070
        L_0x006e:
            r0 = move-exception
            goto L_0x0076
        L_0x0070:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0079
        L_0x0076:
            r0.printStackTrace()
        L_0x0079:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.util.d.a(byte[]):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        r7 = r1;
        r1 = r0;
        r0 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0070, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0079, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0084, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0088, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x008d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0091, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0068 A[SYNTHETIC, Splitter:B:41:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0070 A[Catch:{ IOException -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0075 A[Catch:{ IOException -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0080 A[SYNTHETIC, Splitter:B:52:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0088 A[Catch:{ IOException -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x008d A[Catch:{ IOException -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r2 = r1
        L_0x0006:
            int r3 = r8.length
            if (r2 >= r3) goto L_0x0013
            byte r3 = r8[r2]
            r3 = r3 ^ 5
            byte r3 = (byte) r3
            r8[r2] = r3
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0013:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r8)
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0061 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0061 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
        L_0x0026:
            int r5 = r4.length     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            int r5 = r3.read(r4, r1, r5)     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            r6 = -1
            if (r5 == r6) goto L_0x0032
            r8.write(r4, r1, r5)     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            goto L_0x0026
        L_0x0032:
            byte[] r1 = r8.toByteArray()     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            r8.flush()     // Catch:{ IOException -> 0x0050, all -> 0x0056 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0041
        L_0x003f:
            r8 = move-exception
            goto L_0x004c
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x0046:
            if (r8 == 0) goto L_0x007d
            r8.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x007d
        L_0x004c:
            r8.printStackTrace()
            goto L_0x007d
        L_0x0050:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r3
            r3 = r7
            goto L_0x0063
        L_0x0056:
            r0 = move-exception
            goto L_0x007e
        L_0x0058:
            r1 = move-exception
            r7 = r3
            r3 = r0
            r0 = r7
            goto L_0x0063
        L_0x005d:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x007e
        L_0x0061:
            r1 = move-exception
            r3 = r0
        L_0x0063:
            r1.printStackTrace()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r8 = move-exception
            goto L_0x0079
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x006c }
        L_0x0073:
            if (r8 == 0) goto L_0x007c
            r8.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x007c
        L_0x0079:
            r8.printStackTrace()
        L_0x007c:
            r1 = r3
        L_0x007d:
            return r1
        L_0x007e:
            if (r3 == 0) goto L_0x0086
            r3.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0086
        L_0x0084:
            r8 = move-exception
            goto L_0x0091
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x0084 }
        L_0x008b:
            if (r8 == 0) goto L_0x0094
            r8.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0094
        L_0x0091:
            r8.printStackTrace()
        L_0x0094:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.util.d.b(byte[]):byte[]");
    }

    public static synchronized String a(String str) {
        String stringBuffer;
        synchronized (d.class) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    bArr[i] = (byte) charArray[i];
                }
                byte[] digest = instance.digest(bArr);
                StringBuffer stringBuffer2 = new StringBuffer();
                for (byte b : digest) {
                    byte b2 = b & 255;
                    if (b2 < 16) {
                        stringBuffer2.append("0");
                    }
                    stringBuffer2.append(Integer.toHexString(b2));
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return stringBuffer;
    }

    public static String b(String str) {
        return a(str).substring(8, 24);
    }

    public static String a(File file) {
        int i;
        try {
            byte[] bArr = new byte[2048];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            if (randomAccessFile.length() <= 0) {
                randomAccessFile.close();
                return null;
            }
            randomAccessFile.seek(0);
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            randomAccessFile.close();
            char[] cArr = new char[(r0 * 2)];
            int i2 = 0;
            for (byte b : instance.digest()) {
                int i3 = i2 + 1;
                cArr[i2] = a[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = a[b & 15];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException e) {
            j.a("MD5Helper", "md5EncodeFile NoSuchAlgorithmException", e);
            return null;
        } catch (FileNotFoundException e2) {
            j.a("MD5Helper", "md5EncodeFile FileNotFoundException", e2);
            return null;
        } catch (Exception e3) {
            j.a("MD5Helper", "md5EncodeFile IOException", e3);
            return null;
        }
    }
}
