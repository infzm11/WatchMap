package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public final class a {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(Context context) {
        FileInputStream fileInputStream;
        File b = b(context);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(b);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String a2 = a(instance.digest());
                        try {
                            fileInputStream.close();
                            return a2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return a2;
                        }
                    } else {
                        instance.update(bArr, 0, read);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            try {
                e.printStackTrace();
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            fileInputStream.close();
            throw th;
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            cArr[i] = a[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = a[b & 15];
        }
        return new String(cArr);
    }

    private static File b(Context context) {
        try {
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            Log.i("MainActivity", str);
            return new File(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
