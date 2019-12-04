package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;

public final class h {
    public static String a() {
        return a(Build.MODEL);
    }

    public static String a(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = "";
        }
        return a(str);
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            int nextInt = new Random().nextInt(10);
            str2 = String.valueOf(b(String.valueOf(System.currentTimeMillis()) + str + a(context) + g(context) + nextInt).toCharArray(), 8, 16);
        } catch (Exception unused) {
            str2 = "";
        }
        return c(str2);
    }

    protected static String a(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() > 901) {
            str = str.substring(0, 900);
        }
        return str.replace("\\", "").replace("|", "");
    }

    protected static boolean a(String str, int i) {
        return str != null && str.length() > i;
    }

    public static String b() {
        return a(Build.MANUFACTURER);
    }

    public static String b(Context context) {
        try {
            String a = a(context);
            if (a != null && a.length() > 6) {
                return String.valueOf(b(a).toCharArray(), 7, 18);
            }
            String g = g(context);
            if (g != null) {
                if (g.length() >= 9) {
                    return String.valueOf(b(g).toCharArray(), 7, 18);
                }
            }
            String c = c(context);
            if (c != null) {
                if (c.length() != 0) {
                    return String.valueOf(b(c).toCharArray(), 7, 18);
                }
            }
            return String.valueOf(b(a(Build.MODEL)).toCharArray(), 7, 18);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String c() {
        return a("android " + Build.VERSION.RELEASE);
    }

    public static String c(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId != null) {
                    str = subscriberId.trim();
                }
                c.a("MobileUtils", str);
            }
        } catch (Exception unused) {
            str = "";
            Log.i("MobileUtils", "can't not read imsi");
        }
        return c(str);
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int d(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String d() {
        String str;
        try {
            str = Locale.getDefault().getCountry();
        } catch (Exception unused) {
            str = "";
        }
        return c(str);
    }

    public static int e(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String e() {
        String str;
        try {
            str = Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            str = "";
        }
        return c(str);
    }

    public static int f(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String f() {
        String str = "";
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            try {
                while (inputStream2.read(new byte[24]) != -1) {
                    str = String.valueOf(str) + new String(r1);
                }
                try {
                    inputStream2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream2;
                try {
                    e.printStackTrace();
                    str = "";
                    inputStream.close();
                    return str.trim();
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                inputStream.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            str = "";
            inputStream.close();
            return str.trim();
        }
        return str.trim();
    }

    public static String g() {
        FileReader fileReader;
        Exception e;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                String trim = new BufferedReader(fileReader).readLine().trim();
                try {
                    fileReader.close();
                    return trim;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return trim;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        fileReader.close();
                        return "";
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileReader.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            Exception exc = e6;
            fileReader = null;
            e = exc;
            e.printStackTrace();
            fileReader.close();
            return "";
        } catch (Throwable th2) {
            Throwable th3 = th2;
            fileReader = null;
            th = th3;
            fileReader.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r2.equals("") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(android.content.Context r2) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_WIFI_STATE"
            boolean r0 = b(r2, r0)     // Catch:{ Exception -> 0x0032 }
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = "wifi"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x0032 }
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch:{ Exception -> 0x0032 }
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = r2.getMacAddress()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x0022
            java.lang.String r0 = ""
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0032 }
            if (r0 == 0) goto L_0x002d
        L_0x0022:
            java.lang.String r2 = "unknown"
            goto L_0x002d
        L_0x0025:
            java.lang.String r2 = "MobileUtils"
            java.lang.String r0 = "Could not read MAC, forget to include ACCESS_WIFI_STATE permission?"
            android.util.Log.w(r2, r0)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0022
        L_0x002d:
            java.lang.String r2 = c((java.lang.String) r2)
            return r2
        L_0x0032:
            r2 = move-exception
            java.lang.String r0 = "MobileUtils"
            java.lang.String r1 = "Could not read MAC, forget to include ACCESS_WIFI_STATE permission?"
            android.util.Log.w(r0, r1, r2)
            java.lang.String r2 = "unknown"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.h.g(android.content.Context):java.lang.String");
    }

    public static String h() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String trim = readLine.substring(readLine.indexOf(":") + 2, readLine.indexOf("k") - 1).trim();
                        c.a("MobileUtils", trim);
                        String c = c(trim);
                        try {
                            fileReader.close();
                            bufferedReader.close();
                            return c;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return c;
                        }
                    } else {
                        try {
                            fileReader.close();
                            bufferedReader.close();
                            return "";
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return "";
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        fileReader.close();
                        bufferedReader.close();
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileReader.close();
                            bufferedReader.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                e.printStackTrace();
                fileReader.close();
                bufferedReader.close();
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                fileReader.close();
                bufferedReader.close();
                throw th;
            }
        } catch (Exception e7) {
            fileReader = null;
            e = e7;
            bufferedReader = null;
            e.printStackTrace();
            fileReader.close();
            bufferedReader.close();
            return "";
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
            fileReader.close();
            bufferedReader.close();
            throw th;
        }
    }

    public static String h(Context context) {
        try {
            String string = context.getSharedPreferences("lxdMoblieAgent_sys_config", 0).getString("MOBILE_APPKEY", "");
            if (string.equals("")) {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    string = applicationInfo.metaData.getString("MOBILE_APPKEY");
                }
                if (TextUtils.isEmpty(string)) {
                    Log.e("MobileUtils", "the appkey is empty,please init datau.sdk");
                }
                if (TextUtils.isEmpty(string)) {
                    return "00000";
                }
            }
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "00000";
        }
    }

    public static String i(Context context) {
        try {
            String string = context.getSharedPreferences("lxdMoblieAgent_sys_config", 0).getString("MOBILE_CHANNEL", "");
            if (!string.equals("")) {
                return a(string);
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                string = applicationInfo.metaData.getString("MOBILE_CHANNEL");
                if (string == null) {
                    Log.w("MobileUtils", "Could not read MOBILE_CHANNEL meta-data from AndroidManifest.xml.");
                    string = "";
                }
            }
            return a(string);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String j(Context context) {
        String str;
        try {
            str = context.getPackageName();
        } catch (Exception unused) {
            str = "";
        }
        return c(str);
    }

    public static String k(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return c(str);
    }

    public static String l(Context context) {
        try {
            if (!b(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            c.a("MobileUtils", "net type:" + extraInfo);
            return extraInfo.trim();
        } catch (Exception e) {
            Log.w("MobileUtils", "Could not read ACCESSPOINT, forget to include ACCESS_NETSTATE_STATE permission?", e);
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static int m(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String n(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return c(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061 A[SYNTHETIC, Splitter:B:19:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[SYNTHETIC, Splitter:B:28:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b3 A[SYNTHETIC, Splitter:B:54:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c2 A[SYNTHETIC, Splitter:B:63:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[] o(android.content.Context r9) {
        /*
            int r9 = q(r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "proc/uid_stat/"
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r1 = "/tcp_rcv"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "proc/uid_stat/"
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = "/tcp_snd"
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r1 = 500(0x1f4, float:7.0E-43)
            r2 = 0
            r4 = 0
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x006d, all -> 0x005c }
            r5.<init>(r0)     // Catch:{ Exception -> 0x006d, all -> 0x005c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.<init>(r5, r1)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r6 = r0.readLine()     // Catch:{ Exception -> 0x006f, all -> 0x0055 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x006f, all -> 0x0055 }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x006f, all -> 0x0055 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x006f, all -> 0x0055 }
            r5.close()     // Catch:{ Exception -> 0x0050 }
            r0.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0078
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x007f
        L_0x0055:
            r9 = move-exception
            goto L_0x005f
        L_0x0057:
            r9 = move-exception
            r0 = r4
            goto L_0x005f
        L_0x005a:
            r0 = r4
            goto L_0x006f
        L_0x005c:
            r9 = move-exception
            r0 = r4
            r5 = r0
        L_0x005f:
            if (r5 == 0) goto L_0x006c
            r5.close()     // Catch:{ Exception -> 0x0068 }
            r0.close()     // Catch:{ Exception -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006c:
            throw r9
        L_0x006d:
            r0 = r4
            r5 = r0
        L_0x006f:
            if (r5 == 0) goto L_0x007e
            r5.close()     // Catch:{ Exception -> 0x007a }
            r0.close()     // Catch:{ Exception -> 0x007a }
            r6 = r2
        L_0x0078:
            r0 = r4
            goto L_0x0080
        L_0x007a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007e:
            r6 = r2
        L_0x007f:
            r4 = r5
        L_0x0080:
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x00bf, all -> 0x00af }
            r5.<init>(r9)     // Catch:{ Exception -> 0x00bf, all -> 0x00af }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c0, all -> 0x00ad }
            r9.<init>(r5, r1)     // Catch:{ Exception -> 0x00c0, all -> 0x00ad }
            java.lang.String r0 = r9.readLine()     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            r5.close()     // Catch:{ Exception -> 0x00a1 }
            r9.close()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00ce
        L_0x00a1:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00ce
        L_0x00a6:
            r0 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x00b1
        L_0x00ab:
            r0 = r9
            goto L_0x00c0
        L_0x00ad:
            r9 = move-exception
            goto L_0x00b1
        L_0x00af:
            r9 = move-exception
            r5 = r4
        L_0x00b1:
            if (r5 == 0) goto L_0x00be
            r5.close()     // Catch:{ Exception -> 0x00ba }
            r0.close()     // Catch:{ Exception -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00be:
            throw r9
        L_0x00bf:
            r5 = r4
        L_0x00c0:
            if (r5 == 0) goto L_0x00cd
            r5.close()     // Catch:{ Exception -> 0x00c9 }
            r0.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00cd:
            r0 = r2
        L_0x00ce:
            java.lang.String r9 = "MobileUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "indicate flow: "
            r4.<init>(r5)
            r4.append(r6)
            java.lang.String r5 = "  &  "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.iflytek.cloud.thirdparty.c.a(r9, r4)
            r9 = 2
            long[] r9 = new long[r9]
            r4 = 0
            int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00f2
            r6 = r2
        L_0x00f2:
            r9[r4] = r6
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00fa
            r0 = r2
        L_0x00fa:
            r9[r4] = r0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.h.o(android.content.Context):long[]");
    }

    public static String p(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            return typeName.equalsIgnoreCase("WIFI") ? "WIFI" : typeName.equalsIgnoreCase("MOBILE") ? new StringBuilder(String.valueOf(((TelephonyManager) context.getSystemService("phone")).getNetworkType())).toString() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static int q(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 1).uid;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
