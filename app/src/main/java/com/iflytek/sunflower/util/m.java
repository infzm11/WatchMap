package com.iflytek.sunflower.util;

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

public class m {
    public static boolean a = true;
    private static final Pattern b = Pattern.compile("[0-3][0-9a-f]{32}");
    private static String c;

    public static synchronized String a(Context context) {
        String str;
        synchronized (m.class) {
            if (c == null) {
                c = b(context);
            }
            str = c;
        }
        return str;
    }

    private static String b(final Context context) {
        String a2 = a(context, "iflytek.deviceid.key");
        if (!a(a2)) {
            return a2;
        }
        final String b2 = b(context, ".2F6E2C5B63F0F83B");
        if (!a(b2)) {
            new Thread(new Runnable() {
                public void run() {
                    m.c(context, "iflytek.deviceid.key", b2);
                }
            }).start();
            return b2;
        }
        final String b3 = b(context, "com.iflytek.id", "pref.deviceid.key", (String) null);
        if (!a(b3)) {
            new Thread(new Runnable() {
                public void run() {
                    m.c(context, "iflytek.deviceid.key", b3);
                    m.d(context, ".2F6E2C5B63F0F83B", b3);
                }
            }).start();
            return b3;
        }
        final String c2 = c(context);
        new Thread(new Runnable() {
            public void run() {
                m.c(context, "iflytek.deviceid.key", c2);
                m.d(context, ".2F6E2C5B63F0F83B", c2);
                m.c(context, "com.iflytek.id", "pref.deviceid.key", c2);
            }
        }).start();
        return c2;
    }

    private static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
            j.a((Throwable) e);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, String str2) {
        try {
            Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e) {
            j.a((Throwable) e);
        }
    }

    private static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 1).getString(str2, str3);
        } catch (Throwable th) {
            j.a(th);
            return str3;
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
            j.a(th);
        }
    }

    private static String b(Context context, String str) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return a(new File(Environment.getExternalStorageDirectory() + "/msc", str));
        } catch (Throwable th) {
            j.a(th);
            return null;
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
            j.a(th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, String str2) {
        a(new File(Environment.getExternalStorageDirectory() + "/msc", str), str2);
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
            j.a(th);
        }
    }

    private static String c(Context context) {
        String d = d(context);
        return "2" + b(d);
    }

    private static String d(Context context) {
        h a2 = a.a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(a2.b("os.imei"));
        sb.append('-');
        sb.append(e(context));
        if (a) {
            sb.append('-');
            sb.append(g.a(context));
        }
        return sb.toString();
    }

    private static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    private static String e(Context context) {
        try {
            if (c(context, "android.permission.READ_PHONE_STATE")) {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            return null;
        } catch (Throwable th) {
            j.a(th);
            return null;
        }
    }

    private static final boolean a(String str) {
        return str == null || "".equals(str.trim()) || !b.matcher(str).matches();
    }

    private static String b(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception unused) {
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
}
