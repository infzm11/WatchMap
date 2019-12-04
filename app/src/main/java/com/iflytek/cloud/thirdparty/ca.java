package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class ca {
    public static boolean a = true;
    private static final Pattern b = Pattern.compile("[0-3][0-9a-f]{32}");
    private static String c;

    public static synchronized String a(Context context) {
        String str;
        synchronized (ca.class) {
            if (c == null) {
                c = b(context);
            }
            str = c;
        }
        return str;
    }

    private static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
            cb.b((Throwable) e);
            return "";
        }
    }

    private static String a(File file) {
        try {
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[33];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr, 0, read);
        } catch (Throwable th) {
            cb.b(th);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b3));
        }
        return sb.toString();
    }

    private static void a(File file, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            if (a(9)) {
                file.getClass().getMethod("setReadable", new Class[]{Boolean.TYPE, Boolean.TYPE}).invoke(file, new Object[]{true, false});
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod 444 " + file.getAbsolutePath());
        } catch (Throwable th) {
            cb.b(th);
        }
    }

    private static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    private static final boolean a(String str) {
        return str == null || "".equals(str.trim()) || !b.matcher(str).matches();
    }

    private static String b(final Context context) {
        Thread thread;
        String a2 = a(context, "iflytek.deviceid.key");
        if (!a(a2)) {
            return a2;
        }
        final String b2 = b(context, ".2F6E2C5B63F0F83B");
        if (!a(b2)) {
            thread = new Thread(new Runnable() {
                public void run() {
                    ca.c(context, "iflytek.deviceid.key", b2);
                }
            });
        } else {
            b2 = b(context, "com.iflytek.id", "pref.deviceid.key", (String) null);
            if (!a(b2)) {
                thread = new Thread(new Runnable() {
                    public void run() {
                        ca.c(context, "iflytek.deviceid.key", b2);
                        ca.d(context, ".2F6E2C5B63F0F83B", b2);
                    }
                });
            } else {
                b2 = c(context);
                thread = new Thread(new Runnable() {
                    public void run() {
                        ca.c(context, "iflytek.deviceid.key", b2);
                        ca.d(context, ".2F6E2C5B63F0F83B", b2);
                        ca.c(context, "com.iflytek.id", "pref.deviceid.key", b2);
                    }
                });
            }
        }
        thread.start();
        return b2;
    }

    private static String b(Context context, String str) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return a(new File(Environment.getExternalStorageDirectory() + "/msc", str));
        } catch (Throwable th) {
            cb.b(th);
            return null;
        }
    }

    private static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 1).getString(str2, str3);
        } catch (Throwable th) {
            cb.b(th);
            return str3;
        }
    }

    private static String b(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(Context context) {
        String d = d(context);
        return "2" + b(d);
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, String str2) {
        try {
            Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e) {
            cb.b((Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 1);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        } catch (Throwable th) {
            cb.b(th);
        }
    }

    private static String d(Context context) {
        ce a2 = bp.a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(a2.e("os.imei"));
        sb.append('-');
        sb.append(a2.e("os.android_id"));
        if (a) {
            sb.append('-');
            sb.append(bp.d(context));
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, String str2) {
        a(new File(Environment.getExternalStorageDirectory() + "/msc", str), str2);
    }
}
