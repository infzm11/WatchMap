package com.iflytek.sunflower;

import android.content.Context;
import android.content.SharedPreferences;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.util.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("iflytek_state_" + context.getPackageName(), 0);
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("iflytek_online_" + context.getPackageName(), 0);
    }

    public static String c(Context context) {
        return "iflytek_cached_" + context.getPackageName();
    }

    public static String d(Context context) {
        return "iflytek_log_" + context.getPackageName();
    }

    public static long a(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }

    private static boolean a(Context context, File file) {
        long j;
        long length = file.length();
        try {
            j = (long) (b(context).getInt(DataKeys.LOCAL_FILE_SIZE, 2) * 1024 * 1024);
        } catch (Exception unused) {
            j.c("Collector", "get online log_size failed");
            j = 2097152;
        }
        return file.exists() && length > j;
    }

    public static synchronized JSONObject e(Context context) {
        FileInputStream openFileInput;
        synchronized (c.class) {
            String c = c(context);
            try {
                File file = new File(context.getFilesDir(), c);
                if (a(context, file)) {
                    file.delete();
                    j.b("Collector", "delete local file which beyond 2MB");
                    return null;
                }
                openFileInput = context.openFileInput(c);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(openFileInput);
                    char[] cArr = new char[1024];
                    StringWriter stringWriter = new StringWriter();
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 == read) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    String stringWriter2 = stringWriter.toString();
                    openFileInput.close();
                    JSONObject jSONObject = new JSONObject(stringWriter2);
                    if (jSONObject.length() == 0) {
                        return null;
                    }
                    return jSONObject;
                } catch (Throwable th) {
                    j.d("Collector", "read from local file error. ", th);
                    openFileInput.close();
                    return null;
                }
            } catch (FileNotFoundException unused) {
                return null;
            } catch (IOException e) {
                j.d("Collector", "read file occured exception", e);
                return null;
            } catch (JSONException e2) {
                g(context);
                j.d("Collector", "local JSONObject error.", e2);
                return null;
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public static synchronized String f(Context context) {
        FileInputStream openFileInput;
        synchronized (c.class) {
            String d = d(context);
            try {
                File file = new File(context.getFilesDir(), d);
                if (a(context, file)) {
                    file.delete();
                    j.b("Collector", "delete local file which beyond 2MB");
                    return null;
                }
                openFileInput = context.openFileInput(d);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(openFileInput);
                    char[] cArr = new char[1024];
                    StringWriter stringWriter = new StringWriter();
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 != read) {
                            stringWriter.write(cArr, 0, read);
                        } else {
                            String stringWriter2 = stringWriter.toString();
                            openFileInput.close();
                            return stringWriter2;
                        }
                    }
                } catch (Throwable th) {
                    j.d("Collector", "read from local file error. ", th);
                    openFileInput.close();
                    return null;
                }
            } catch (FileNotFoundException unused) {
                return null;
            } catch (IOException e) {
                j.d("Collector", "read file occured exception", e);
                return null;
            } catch (Exception unused2) {
                return null;
            } catch (Throwable th2) {
                openFileInput.close();
                throw th2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            java.lang.Class<com.iflytek.sunflower.c> r0 = com.iflytek.sunflower.c.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0041
            java.lang.String r1 = ""
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x000e
            goto L_0x0041
        L_0x000e:
            java.lang.String r1 = c(r2)     // Catch:{ IOException -> 0x0035 }
            if (r4 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = r1
        L_0x0016:
            r1 = 0
            if (r5 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r5 = r1
        L_0x001b:
            java.io.FileOutputStream r2 = r2.openFileOutput(r4, r5)     // Catch:{ IOException -> 0x0035 }
            byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0035 }
            r2.write(r3)     // Catch:{ IOException -> 0x0035 }
            r2.flush()     // Catch:{ IOException -> 0x0035 }
            r2.close()     // Catch:{ IOException -> 0x0035 }
            java.lang.String r2 = "Collector"
            java.lang.String r3 = "write to file success"
            com.iflytek.sunflower.util.j.a(r2, r3)     // Catch:{ IOException -> 0x0035 }
            monitor-exit(r0)
            return
        L_0x0035:
            java.lang.String r2 = "Collector"
            java.lang.String r3 = "write to file error."
            com.iflytek.sunflower.util.j.d(r2, r3)     // Catch:{ all -> 0x003e }
            monitor-exit(r0)
            return
        L_0x003e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0041:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.c.a(android.content.Context, java.lang.String, java.lang.String, int):void");
    }

    public static void g(Context context) {
        context.deleteFile(c(context));
    }

    public static void a(Context context, String str, Long l) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str, l.longValue());
        edit.commit();
    }
}
