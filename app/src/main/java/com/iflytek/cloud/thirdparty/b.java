package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.cloud.SpeechConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static boolean a = false;
    private static String b = "lxd";
    private static int c = 1;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static int g = 1;
    private static int h = 0;
    private static final String i = ("act" + b);
    private static final String j = ("evn" + b);
    private static final String k = ("esp" + b);
    private static final String l = ("err" + b);
    private static final String m = ("sys" + b);
    private static String n = "";
    private static long o = 0;
    private static String p = "";
    private static Object q = new Object();
    private static Object r = new Object();
    private static Object s = new Object();
    private static boolean t = false;
    private static boolean u = false;
    private static String v = "";
    private static ExecutorService w = Executors.newSingleThreadExecutor();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e9, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ea, code lost:
        r3 = r0;
        r0 = r9;
        r9 = r2;
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f8, code lost:
        r3 = r0;
        r0 = r9;
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00fc, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fd, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ff, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0100, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0102, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0103, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0105, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0106, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
        if (r0 != null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0129, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015b, code lost:
        if (r0 == null) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ad, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fc A[ExcHandler: JSONException (e org.json.JSONException), Splitter:B:10:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ff A[ExcHandler: IOException (e java.io.IOException), Splitter:B:10:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0102 A[ExcHandler: ClientProtocolException (e org.apache.http.client.ClientProtocolException), Splitter:B:10:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0105 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013d A[Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a, all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014d A[Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a, all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(android.content.Context r8, java.lang.String r9, org.json.JSONObject r10) {
        /*
            int r0 = c
            r1 = 1
            r2 = 2
            if (r0 == r1) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = "MobileAgentRun"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "run into httppost :"
            r3.<init>(r4)
            r3.append(r9)
            java.lang.String r4 = "####"
            r3.append(r4)
            java.lang.Class r4 = r8.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = "###"
            r3.append(r4)
            java.lang.String r4 = r10.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.iflytek.cloud.thirdparty.c.a(r0, r3)
            r0 = 0
            r3 = 0
            java.lang.String r4 = com.iflytek.cloud.thirdparty.h.h(r8)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r5 = com.iflytek.cloud.thirdparty.h.i(r8)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r6 = "UTF-8"
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r6)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r6.<init>(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r9 = "&appkey="
            r6.append(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r6.append(r4)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r9 = "&channel="
            r6.append(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r6.append(r5)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r9 = "&code="
            r6.append(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r9 = 106(0x6a, float:1.49E-43)
            r6.append(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r9 = r6.toString()     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r4 = "MobileAgentRun"
            java.lang.String r5 = r10.toString()     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            com.iflytek.cloud.thirdparty.c.a(r4, r5)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.lang.String r4 = "MobileAgentRun"
            java.lang.String r5 = "post start"
            com.iflytek.cloud.thirdparty.c.a(r4, r5)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.net.URL r4 = new java.net.URL     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r4.<init>(r9)     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.net.URLConnection r9 = r4.openConnection()     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ ClientProtocolException -> 0x014e, IOException -> 0x013e, JSONException -> 0x012d, Exception -> 0x011a }
            r0 = 10000(0x2710, float:1.4013E-41)
            r9.setReadTimeout(r0)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r9.setDoOutput(r1)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r9.setDoInput(r1)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r9.setUseCaches(r3)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r0 = "POST"
            r9.setRequestMethod(r0)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            com.iflytek.cloud.thirdparty.g r0 = com.iflytek.cloud.thirdparty.g.a()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r4 = r10.toString()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            byte[] r0 = r0.a(r4)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r4 = "Content-length"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r5.<init>()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            int r6 = r0.length     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r5.append(r6)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r5 = r5.toString()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r9.setRequestProperty(r4, r5)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/octet-stream"
            r9.setRequestProperty(r4, r5)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r4 = "Charset"
            java.lang.String r5 = "UTF-8"
            r9.setRequestProperty(r4, r5)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r4.write(r0)     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            r4.close()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            int r0 = r9.getResponseCode()     // Catch:{ ClientProtocolException -> 0x0114, IOException -> 0x0111, JSONException -> 0x010e, Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r3 = "MobileAgentRun"
            java.lang.String r4 = "post end"
            com.iflytek.cloud.thirdparty.c.a(r3, r4)     // Catch:{ ClientProtocolException -> 0x0102, IOException -> 0x00ff, JSONException -> 0x00fc, Exception -> 0x00f7, all -> 0x0105 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r0) goto L_0x00ef
            java.lang.String r3 = "MobileAgent"
            java.lang.String r4 = "send success"
            com.iflytek.cloud.thirdparty.c.a(r3, r4)     // Catch:{ ClientProtocolException -> 0x0102, IOException -> 0x00ff, JSONException -> 0x00fc, Exception -> 0x00e9, all -> 0x0105 }
            r2 = r1
            goto L_0x00ef
        L_0x00e9:
            r2 = move-exception
            r3 = r0
            r0 = r9
            r9 = r2
            r2 = r1
            goto L_0x011b
        L_0x00ef:
            if (r9 == 0) goto L_0x00f4
            r9.disconnect()
        L_0x00f4:
            r3 = r0
            goto L_0x015e
        L_0x00f7:
            r1 = move-exception
            r3 = r0
            r0 = r9
            r9 = r1
            goto L_0x011b
        L_0x00fc:
            r1 = move-exception
            r3 = r0
            goto L_0x010f
        L_0x00ff:
            r1 = move-exception
            r3 = r0
            goto L_0x0112
        L_0x0102:
            r1 = move-exception
            r3 = r0
            goto L_0x0115
        L_0x0105:
            r8 = move-exception
            r0 = r9
            goto L_0x01ab
        L_0x0109:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x011b
        L_0x010e:
            r1 = move-exception
        L_0x010f:
            r0 = r9
            goto L_0x012e
        L_0x0111:
            r1 = move-exception
        L_0x0112:
            r0 = r9
            goto L_0x013f
        L_0x0114:
            r1 = move-exception
        L_0x0115:
            r0 = r9
            goto L_0x014f
        L_0x0117:
            r8 = move-exception
            goto L_0x01ab
        L_0x011a:
            r9 = move-exception
        L_0x011b:
            java.lang.String r1 = "MobileAgentRun"
            java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x0117 }
            com.iflytek.cloud.thirdparty.c.a(r1, r4)     // Catch:{ all -> 0x0117 }
            r9.printStackTrace()     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x015e
        L_0x0129:
            r0.disconnect()
            goto L_0x015e
        L_0x012d:
            r1 = move-exception
        L_0x012e:
            java.lang.String r9 = "MobileAgentRun"
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0117 }
            com.iflytek.cloud.thirdparty.c.a(r9, r2)     // Catch:{ all -> 0x0117 }
            r1.printStackTrace()     // Catch:{ all -> 0x0117 }
            r2 = 3
            if (r0 == 0) goto L_0x015e
            goto L_0x0129
        L_0x013e:
            r1 = move-exception
        L_0x013f:
            java.lang.String r9 = "MobileAgentRun"
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0117 }
            com.iflytek.cloud.thirdparty.c.a(r9, r4)     // Catch:{ all -> 0x0117 }
            r1.printStackTrace()     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x015e
            goto L_0x0129
        L_0x014e:
            r1 = move-exception
        L_0x014f:
            java.lang.String r9 = "MobileAgentRun"
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0117 }
            com.iflytek.cloud.thirdparty.c.a(r9, r4)     // Catch:{ all -> 0x0117 }
            r1.printStackTrace()     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x015e
            goto L_0x0129
        L_0x015e:
            java.lang.String r9 = "MobileAgentHttpPost"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            java.lang.String r1 = "code:"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0187 }
            r0.append(r3)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r1 = "status:  "
            r0.append(r1)     // Catch:{ Exception -> 0x0187 }
            r0.append(r2)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r1 = "  content: "
            r0.append(r1)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r1 = "logJsonAry"
            java.lang.String r10 = r10.getString(r1)     // Catch:{ Exception -> 0x0187 }
            r0.append(r10)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x0187 }
            com.iflytek.cloud.thirdparty.c.a(r9, r10)     // Catch:{ Exception -> 0x0187 }
        L_0x0187:
            java.lang.String r9 = "MobileAgentRun"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "run out httppost :"
            r10.<init>(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r10.append(r8)
            java.lang.String r8 = " resultcode:"
            r10.append(r8)
            r10.append(r2)
            java.lang.String r8 = r10.toString()
            com.iflytek.cloud.thirdparty.c.a(r9, r8)
            return r2
        L_0x01ab:
            if (r0 == 0) goto L_0x01b0
            r0.disconnect()
        L_0x01b0:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.b.a(android.content.Context, java.lang.String, org.json.JSONObject):int");
    }

    protected static SharedPreferences a(Context context) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_event_" + packageName, 0);
    }

    private static String a(Context context, String str, SharedPreferences sharedPreferences) {
        n = "";
        String a2 = h.a(context, str);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("appKey", str);
        edit.putString("sessionId", a2);
        edit.putLong("lastResumeTime", System.currentTimeMillis());
        edit.putString("activities", i(context, "onResume", (String) null));
        long j2 = sharedPreferences.getLong("readFlowRev", 0);
        long[] o2 = h.o(context);
        edit.putLong("readFlowRev", o2[0]);
        long j3 = o2[0] - j2;
        if (j3 < 0) {
            j3 = 0;
        }
        edit.putLong("consumeFlowRev", j3);
        long j4 = sharedPreferences.getLong("readFlowSnd", 0);
        edit.putLong("readFlowSnd", o2[1]);
        long j5 = o2[1] - j4;
        if (j5 < 0) {
            j5 = 0;
        }
        edit.putLong("consumeFlowSnd", j5);
        edit.commit();
        p = a2;
        return a2;
    }

    private static void a(Context context, String str, long j2) {
        synchronized (q) {
            SharedPreferences c2 = c(context);
            int i2 = c2.getInt("uploadcount", 0);
            String str2 = String.valueOf(c2.getString("uploadList", "")) + str + "|";
            if (j2 > 10000) {
                j2 = 1;
            }
            c2.edit().putString("uploadList", str2).commit();
            c2.edit().putLong("uploadpopindex", j2).commit();
            if (str2.split("\\|").length > 30000) {
                String n2 = n(context);
                context.deleteFile(n2);
                j(context, n2);
            } else {
                c2.edit().putInt("uploadcount", i2 + 1).commit();
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (c == 0) {
            Log.i("MobileAgent", "Du have not permission to collect data");
        } else if (str.contains("#")) {
            Log.w("MobileAgent", "the eventId contain illegal char");
        } else {
            h(context, str, str2);
        }
    }

    protected static void a(Context context, boolean z) {
        if (z) {
            c.a("MobileAgentRun", "run into pageact onresumep");
            h(context);
        } else {
            c.a("MobileAgentRun", "run into pageact onpausep");
            i(context);
        }
        c.a("MobileAgentRun", "run out pageact");
    }

    protected static boolean a(Context context, int i2) {
        int i3;
        String str;
        SharedPreferences k2 = k(context);
        if (i2 == 3) {
            i3 = k2.getInt("actionmonth", 0);
            str = "actionday";
        } else if (i2 == 2) {
            i3 = k2.getInt("eventmonth", 0);
            str = "eventday";
        } else {
            i3 = k2.getInt("sysmonth", 0);
            str = "sysday";
        }
        int i4 = k2.getInt(str, 0);
        Date date = new Date();
        return (Integer.valueOf(new SimpleDateFormat("M").format(date)).intValue() == i3 && Integer.valueOf(new SimpleDateFormat("dd").format(date)).intValue() == i4) ? false : true;
    }

    private static boolean a(Context context, SharedPreferences sharedPreferences) {
        SharedPreferences a2 = a(context);
        String string = a2.getString("eventlogs", "");
        if (string.equals("")) {
            return false;
        }
        String string2 = l(context).getString("sessionId", (String) null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SpeechConstant.IST_SESSION_ID, string2);
            jSONObject.put("logJsonAry", string);
            if (!a(context, jSONObject.toString(), 2)) {
                return true;
            }
            a2.edit().putString("eventlogs", "").commit();
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static boolean a(Context context, SharedPreferences sharedPreferences, boolean z) {
        String string = sharedPreferences.getString("sessionId", "");
        String string2 = sharedPreferences.getString("activities", "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SpeechConstant.IST_SESSION_ID, string);
            jSONObject.put("logs", string2);
            if (z) {
                jSONObject.put("flowConsumpRev", sharedPreferences.getLong("consumeFlowRev", 0));
                jSONObject.put("flowConsumpSnd", sharedPreferences.getLong("consumeFlowSnd", 0));
            } else {
                jSONObject.put("flowConsumpRev", 0);
                jSONObject.put("flowConsumpSnd", 0);
            }
            if (!a(context, jSONObject.toString(), 3)) {
                return true;
            }
            sharedPreferences.edit().putString("activities", "").commit();
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    protected static boolean a(Context context, String str) {
        int i2;
        String h2 = h(context, str);
        if (!h2.equals("")) {
            JSONObject d2 = d(context);
            try {
                try {
                    d2.put(SpeechConstant.IST_SESSION_ID, new JSONObject(h2).get(SpeechConstant.IST_SESSION_ID));
                } catch (JSONException unused) {
                    d2.put(SpeechConstant.IST_SESSION_ID, "");
                }
                d2.put("mac", h.g(context));
                try {
                    d2.put("deviceDetail", URLEncoder.encode(h.a(), "UTF-8"));
                } catch (UnsupportedEncodingException unused2) {
                    d2.put("deviceDetail", "");
                }
                try {
                    d2.put("manufacturer", URLEncoder.encode(h.b(), "UTF-8"));
                } catch (UnsupportedEncodingException unused3) {
                    d2.put("manufacturer", "");
                }
                try {
                    d2.put("phoneOs", URLEncoder.encode(h.c(), "UTF-8"));
                } catch (UnsupportedEncodingException unused4) {
                    d2.put("phoneOs", "");
                }
                try {
                    d2.put("accessPoint", URLEncoder.encode(h.l(context), "UTF-8"));
                } catch (UnsupportedEncodingException unused5) {
                    d2.put("accessPoint", "");
                }
                try {
                    d2.put("netWorkType", URLEncoder.encode(h.p(context), "UTF-8"));
                } catch (UnsupportedEncodingException unused6) {
                    d2.put("netWorkType", "");
                }
                d2.put("uuid", v);
                d2.put("deviceId", h.a(context));
                d2.put("cpuRatioMax", h.f());
                d2.put("cpuRatioCur", h.g());
                d2.put("menoryRatio", h.h());
                d2.put("logJsonAry", new JSONArray("[" + h2 + "]"));
                i2 = a(context, "http://da.mmarket.com/mmsdk/mmsdk?func=mmsdk:postactlog", d2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                i2 = 3;
            }
            if (i2 == 1 || i2 == 3) {
                b(context, 3);
                i(context, str);
                Log.i("MobileAgent", "act log sd");
                return true;
            }
            if (i2 == 2) {
            }
            return false;
        }
        b(context, 3);
        i(context, str);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0073 A[SYNTHETIC, Splitter:B:45:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0084 A[SYNTHETIC, Splitter:B:55:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0090 A[SYNTHETIC, Splitter:B:63:0x0090] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean a(android.content.Context r8, java.lang.String r9, int r10) {
        /*
            java.lang.Class<com.iflytek.cloud.thirdparty.b> r0 = com.iflytek.cloud.thirdparty.b.class
            monitor-enter(r0)
            r1 = 3
            r2 = 0
            r3 = 1
            if (r10 != r1) goto L_0x000e
            java.lang.String r10 = i     // Catch:{ all -> 0x000b }
            goto L_0x0024
        L_0x000b:
            r8 = move-exception
            goto L_0x009b
        L_0x000e:
            r1 = 2
            if (r10 != r1) goto L_0x0014
            java.lang.String r10 = j     // Catch:{ all -> 0x000b }
            goto L_0x0024
        L_0x0014:
            r1 = 4
            if (r10 != r1) goto L_0x001a
            java.lang.String r10 = l     // Catch:{ all -> 0x000b }
            goto L_0x0024
        L_0x001a:
            if (r10 != r3) goto L_0x001f
            java.lang.String r10 = m     // Catch:{ all -> 0x000b }
            goto L_0x0024
        L_0x001f:
            r1 = 5
            if (r10 != r1) goto L_0x009d
            java.lang.String r10 = k     // Catch:{ all -> 0x000b }
        L_0x0024:
            java.lang.String r1 = r9.trim()     // Catch:{ all -> 0x000b }
            java.lang.String r4 = ""
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x000b }
            if (r1 != 0) goto L_0x0099
            long r4 = m(r8)     // Catch:{ all -> 0x000b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000b }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x000b }
            r1.<init>(r10)     // Catch:{ all -> 0x000b }
            r6 = 1
            long r6 = r6 + r4
            r1.append(r4)     // Catch:{ all -> 0x000b }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x000b }
            r1 = 0
            java.io.FileOutputStream r4 = r8.openFileOutput(r10, r3)     // Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006a }
            a((android.content.Context) r8, (java.lang.String) r10, (long) r6)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064, all -> 0x0061 }
            byte[] r8 = r9.getBytes()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064, all -> 0x0061 }
            r4.write(r8)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064, all -> 0x0061 }
            if (r4 == 0) goto L_0x0079
            r4.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0079
        L_0x005c:
            r8 = move-exception
        L_0x005d:
            r8.printStackTrace()     // Catch:{ all -> 0x000b }
            goto L_0x0079
        L_0x0061:
            r8 = move-exception
            r1 = r4
            goto L_0x008e
        L_0x0064:
            r1 = r4
            goto L_0x006a
        L_0x0066:
            r1 = r4
            goto L_0x007b
        L_0x0068:
            r8 = move-exception
            goto L_0x008e
        L_0x006a:
            java.lang.String r8 = "MobileAgentRun"
            java.lang.String r9 = "file r/w execption"
            android.util.Log.w(r8, r9)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r8 = move-exception
            goto L_0x005d
        L_0x0079:
            monitor-exit(r0)
            return r3
        L_0x007b:
            java.lang.String r8 = "MobileAgentRun"
            java.lang.String r9 = "can not find log file"
            android.util.Log.w(r8, r9)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x008c
            r1.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x000b }
        L_0x008c:
            monitor-exit(r0)
            return r2
        L_0x008e:
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x000b }
        L_0x0098:
            throw r8     // Catch:{ all -> 0x000b }
        L_0x0099:
            monitor-exit(r0)
            return r2
        L_0x009b:
            monitor-exit(r0)
            throw r8
        L_0x009d:
            monitor-exit(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.b.a(android.content.Context, java.lang.String, int):boolean");
    }

    private static boolean a(SharedPreferences sharedPreferences) {
        return System.currentTimeMillis() - sharedPreferences.getLong("endTime", -1) > 30000;
    }

    protected static SharedPreferences b(Context context) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_event_sp" + packageName, 0);
    }

    protected static void b(Context context, int i2) {
        String str;
        Date date = new Date();
        int parseInt = Integer.parseInt(new SimpleDateFormat("dd").format(date));
        int parseInt2 = Integer.parseInt(new SimpleDateFormat("M").format(date));
        SharedPreferences.Editor edit = k(context).edit();
        if (i2 == 3) {
            edit.putInt("actionmonth", parseInt2);
            str = "actionday";
        } else if (i2 == 2) {
            edit.putInt("eventmonth", parseInt2);
            str = "eventday";
        } else {
            edit.putInt("sysmonth", parseInt2);
            str = "sysday";
        }
        edit.putInt(str, parseInt);
        edit.commit();
    }

    protected static void b(Context context, String str, String str2) {
        synchronized (r) {
            String a2 = h.a(str);
            String a3 = h.a(str2);
            SharedPreferences a4 = a(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a4.getString("eventlogs", ""));
            try {
                stringBuffer.append(URLEncoder.encode(a2, "UTF-8"));
                stringBuffer.append("|");
                stringBuffer.append(URLEncoder.encode(a3, "UTF-8"));
                stringBuffer.append("|");
                stringBuffer.append(1);
                stringBuffer.append("|");
                stringBuffer.append(System.currentTimeMillis());
                stringBuffer.append("\n");
                a4.edit().putString("eventlogs", stringBuffer.toString()).commit();
                a(context, (SharedPreferences) null);
            } catch (UnsupportedEncodingException unused) {
                c.a("MobileAgentRun", "unsupport utf-8,can't onEvent()");
                return;
            }
        }
        b(context, false);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void b(android.content.Context r3, boolean r4) {
        /*
            int r0 = c
            r1 = 1
            if (r0 == r1) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r0 = "MobileAgentRun"
            java.lang.String r1 = "run into strategy"
            com.iflytek.cloud.thirdparty.c.a(r0, r1)
            f(r3)
            boolean r0 = e
            r1 = 0
            if (r0 == 0) goto L_0x001f
            boolean r0 = e
            if (r0 == 0) goto L_0x0048
            boolean r0 = o(r3)
            if (r0 == 0) goto L_0x0048
        L_0x001f:
            int r0 = g
            r2 = 6
            switch(r0) {
                case 1: goto L_0x0040;
                case 2: goto L_0x0033;
                case 3: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0048
        L_0x0026:
            r4 = 3
            boolean r4 = a((android.content.Context) r3, (int) r4)
            if (r4 == 0) goto L_0x0048
            com.iflytek.cloud.thirdparty.d r4 = new com.iflytek.cloud.thirdparty.d
            r4.<init>(r3, r2)
            goto L_0x0045
        L_0x0033:
            if (r4 == 0) goto L_0x0048
            com.iflytek.cloud.thirdparty.d r4 = new com.iflytek.cloud.thirdparty.d
            r4.<init>(r3, r2)
            r4.start()
            f = r1
            goto L_0x0048
        L_0x0040:
            com.iflytek.cloud.thirdparty.d r4 = new com.iflytek.cloud.thirdparty.d
            r4.<init>(r3, r2)
        L_0x0045:
            r4.start()
        L_0x0048:
            f = r1
            java.lang.String r3 = "MobileAgentRun"
            java.lang.String r4 = "run out strategy"
            com.iflytek.cloud.thirdparty.c.a(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.b.b(android.content.Context, boolean):void");
    }

    private static boolean b(Context context, SharedPreferences sharedPreferences) {
        SharedPreferences b2 = b(context);
        String string = b2.getString("eventlogs", "");
        if (string.equals("")) {
            return false;
        }
        String string2 = l(context).getString("sessionId", (String) null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SpeechConstant.IST_SESSION_ID, string2);
            jSONObject.put("logJsonAry", string);
            if (!a(context, jSONObject.toString(), 5)) {
                return true;
            }
            b2.edit().putString("eventlogs", "").commit();
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    protected static boolean b(Context context, String str) {
        try {
            if (a(context, "http://da.mmarket.com/mmsdk/mmsdk?func=mmsdk:postsyslog", new JSONObject(h(context, str))) != 1) {
                return false;
            }
            i(context, str);
            return true;
        } catch (JSONException unused) {
            i(context, str);
            Log.i("MobileAgent", "SDK del a dirty data");
            return false;
        }
    }

    protected static SharedPreferences c(Context context) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_upload_" + packageName, 0);
    }

    protected static void c(Context context, String str, String str2) {
        synchronized (s) {
            String a2 = h.a(str);
            String a3 = h.a(str2);
            SharedPreferences b2 = b(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(b2.getString("eventlogs", ""));
            try {
                stringBuffer.append(URLEncoder.encode(a2, "UTF-8"));
                stringBuffer.append("|");
                stringBuffer.append(URLEncoder.encode(a3, "UTF-8"));
                stringBuffer.append("|");
                stringBuffer.append(1);
                stringBuffer.append("|");
                stringBuffer.append(System.currentTimeMillis());
                stringBuffer.append("\n");
                b2.edit().putString("eventlogs", stringBuffer.toString()).commit();
                if (g == 1 || stringBuffer.toString().getBytes().length > 10000) {
                    b(context, (SharedPreferences) null);
                }
            } catch (UnsupportedEncodingException unused) {
                c.a("MobileAgent", "unsupport utf-8,can't onEvent()");
                return;
            }
        }
        b(context, false);
    }

    protected static boolean c(Context context, String str) {
        String h2 = h(context, str);
        try {
            JSONObject jSONObject = new JSONObject(h2);
            jSONObject.put("pid", 1);
            jSONObject.put("protocolVersion", "3.1.4");
            jSONObject.put("sdkVersion", "3.2.0.2");
            jSONObject.put("cid", h.b(context));
            jSONObject.put("deviceId", h.a(context));
            jSONObject.put("appKey", h.h(context));
            jSONObject.put("packageName", h.j(context));
            jSONObject.put("versionCode", h.m(context));
            jSONObject.put("versionName", h.n(context));
            jSONObject.put("sendTime", System.currentTimeMillis());
            int a2 = a(context, "http://da.mmarket.com/mmsdk/mmsdk?func=mmsdk:posterrlog", jSONObject);
            if (a2 != 1) {
                if (a2 != 3) {
                    if (a2 == 2) {
                    }
                    return false;
                }
            }
            b(context, 3);
            i(context, str);
            Log.i("MobileAgent", "erLog sd");
            c.a("MobileAgent", "send errlog success \n" + h2);
            return true;
        } catch (JSONException unused) {
            i(context, str);
            Log.i("MobileAgent", "SDK del a dirty data");
            return false;
        }
    }

    protected static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pid", 1);
            jSONObject.put("protocolVersion", "3.1.4");
            jSONObject.put("sdkVersion", "3.2.0.2");
            jSONObject.put("cid", h.b(context));
            jSONObject.put("appKey", h.h(context));
            jSONObject.put("packageName", context.getPackageName());
            jSONObject.put("versionCode", h.m(context));
            jSONObject.put("versionName", h.n(context));
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject.put("deviceId", h.a(context));
            jSONObject.put("channel", h.i(context));
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    protected static void d(Context context, String str) {
        k(context).edit().putString(str, "record").commit();
    }

    public static void d(Context context, String str, String str2) {
        if (t) {
            Log.i("MobileAgent", "already init");
            return;
        }
        try {
            if (!a) {
                a = !context.getSharedPreferences("MoblieAgent_debug", 0).getString("debug", "").equals("");
            }
        } catch (Exception unused) {
        }
        c.a("MobileAgentAPI", "run in init[" + str + "," + str2 + "]");
        if (context == null) {
            Log.e("MobileAgent", "Exception occurent in joinDu ,context cann't be null");
        } else if (TextUtils.isEmpty(str) || h.a(str, 50)) {
            Log.e("MobileAgent", "Exception occurent in joinDu ,appID cann't be null or empty");
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            } else if (h.a(str2, 100)) {
                str2 = str2.substring(0, 99);
                Log.e("MobileAgent", "Exception occurent in joinDu ,channelID cann't be null or empty");
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_sys_config", 0);
            sharedPreferences.edit().putString("MOBILE_APPKEY", str).commit();
            sharedPreferences.edit().putString("MOBILE_CHANNEL", str2).commit();
            if (!e(context, "#lxapkmd5")) {
                new Thread(new f(context)).start();
            }
            t = true;
            Log.i("MobileAgent", "finish init SUCCESS " + a);
        }
    }

    protected static void e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pid", 1);
            jSONObject.put("protocolVersion", "3.1.4");
            jSONObject.put("sdkVersion", "3.2.0.2");
            jSONObject.put("cid", h.b(context));
            jSONObject.put("deviceId", h.a(context));
            jSONObject.put("appKey", h.h(context));
            jSONObject.put("packageName", context.getPackageName());
            jSONObject.put("versionCode", h.m(context));
            jSONObject.put("versionName", h.n(context));
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject.put("imsi", h.c(context));
            jSONObject.put("mac", h.g(context));
            jSONObject.put("deviceDetail", URLEncoder.encode(h.a(), "UTF-8"));
            jSONObject.put("manufacturer", URLEncoder.encode(h.b(), "UTF-8"));
            jSONObject.put("phoneOS", URLEncoder.encode(h.c(), "UTF-8"));
            jSONObject.put("screenWidth", h.d(context));
            jSONObject.put("screenHeight", h.e(context));
            jSONObject.put("screenDensity", h.f(context));
            jSONObject.put("carrierName", URLEncoder.encode(h.k(context), "UTF-8"));
            jSONObject.put("accessPoint", h.l(context));
            jSONObject.put("countryCode", h.d());
            jSONObject.put("languageCode", h.e());
            jSONObject.put("channel", URLEncoder.encode(h.i(context), "UTF-8"));
            if (a(context, jSONObject.toString(), 1)) {
                b(context, 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
    }

    protected static boolean e(Context context, String str) {
        return !k(context).getString(str, "").equals("");
    }

    protected static boolean e(Context context, String str, String str2) {
        String str3;
        String str4;
        String h2 = str2 == null ? h(context, str) : str2;
        if (!h2.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(h2);
                String b2 = h.b(context);
                jSONObject.put("pid", 1);
                jSONObject.put("protocolVersion", "3.1.4");
                jSONObject.put("sdkVersion", "3.2.0.2");
                jSONObject.put("cid", b2);
                jSONObject.put("appKey", h.h(context));
                jSONObject.put("packageName", h.j(context));
                jSONObject.put("versionCode", h.m(context));
                jSONObject.put("versionName", h.n(context));
                jSONObject.put("sendTime", System.currentTimeMillis());
                jSONObject.put("mac", h.g(context));
                try {
                    jSONObject.put("deviceDetail", URLEncoder.encode(h.a(), "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                    jSONObject.put("deviceDetail", "");
                }
                try {
                    jSONObject.put("manufacturer", URLEncoder.encode(h.b(), "UTF-8"));
                } catch (UnsupportedEncodingException unused2) {
                    jSONObject.put("manufacturer", "");
                }
                try {
                    jSONObject.put("phoneOs", URLEncoder.encode(h.c(), "UTF-8"));
                } catch (UnsupportedEncodingException unused3) {
                    jSONObject.put("phoneOs", "");
                }
                jSONObject.put("accessPoint", h.l(context));
                jSONObject.put("deviceId", h.a(context));
                try {
                    jSONObject.put("channel", URLEncoder.encode(h.i(context), "UTF-8"));
                } catch (UnsupportedEncodingException unused4) {
                    jSONObject.put("channel", "");
                }
                int a2 = a(context, "http://da.mmarket.com/mmsdk/mmsdk?func=mmsdk:posteventlog", jSONObject);
                if (a2 != 1) {
                    if (a2 != 3) {
                        if (a2 == 2) {
                            Log.w("MobileAgent", "please check your network");
                        }
                        return false;
                    }
                }
                if (str2 == null) {
                    b(context, 3);
                    i(context, str);
                    str3 = "MobileAgent";
                    str4 = "evn log sd";
                } else {
                    str3 = "MobileAgent";
                    str4 = "evnrt log sd";
                }
                Log.i(str3, str4);
                return true;
            } catch (JSONException e2) {
                i(context, str);
                e2.printStackTrace();
                return true;
            }
        } else if (str2 != null) {
            return false;
        } else {
            b(context, 3);
            i(context, str);
            return true;
        }
    }

    protected static void f(Context context) {
        if (f) {
            if (g(context, "updateonlyonwifi").equals("1")) {
                e = true;
            } else {
                e = false;
            }
            String g2 = g(context, "updatedelay");
            if (!g2.equals("0")) {
                h = Integer.parseInt(g2) * 1000;
            }
            int parseInt = Integer.parseInt(g(context, "send_policy"));
            g = parseInt;
            if (parseInt == 0) {
                g = 1;
            }
        }
    }

    protected static void f(Context context, String str) {
        if (!str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("occurtime", System.currentTimeMillis());
                jSONObject2.put("errmsg", URLEncoder.encode(str, "UTF-8"));
                jSONArray.put(jSONObject2);
                jSONObject.put(SpeechConstant.IST_SESSION_ID, p);
                jSONObject.put("errjsonary", jSONArray);
                c.a("MobileAgentRun", "errJso" + jSONObject.toString());
                a(context, jSONObject.toString(), 4);
            } catch (JSONException unused) {
                c.a("MobileAgentRun", "json exception,lost catch Exception");
            } catch (UnsupportedEncodingException unused2) {
                c.a("MobileAgentRun", "unsupport utf-8,lost catch Exception");
            }
        }
    }

    protected static boolean f(Context context, String str, String str2) {
        String str3;
        String str4;
        String h2 = str2 == null ? h(context, str) : str2;
        if (!h2.equals("")) {
            boolean contains = h2.contains("%23lxapkmd5");
            try {
                JSONObject jSONObject = new JSONObject(h2);
                String b2 = h.b(context);
                jSONObject.put("pid", 1);
                jSONObject.put("protocolVersion", "3.1.4");
                jSONObject.put("sdkVersion", "3.2.0.2");
                jSONObject.put("cid", b2);
                jSONObject.put("appKey", h.h(context));
                jSONObject.put("packageName", h.j(context));
                jSONObject.put("versionCode", h.m(context));
                jSONObject.put("versionName", h.n(context));
                jSONObject.put("sendTime", System.currentTimeMillis());
                jSONObject.put("mac", h.g(context));
                try {
                    jSONObject.put("deviceDetail", URLEncoder.encode(h.a(), "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                    jSONObject.put("deviceDetail", "");
                }
                try {
                    jSONObject.put("manufacturer", URLEncoder.encode(h.b(), "UTF-8"));
                } catch (UnsupportedEncodingException unused2) {
                    jSONObject.put("manufacturer", "");
                }
                try {
                    jSONObject.put("phoneOs", URLEncoder.encode(h.c(), "UTF-8"));
                } catch (UnsupportedEncodingException unused3) {
                    jSONObject.put("phoneOs", "");
                }
                jSONObject.put("accessPoint", h.l(context));
                jSONObject.put("deviceId", h.a(context));
                try {
                    jSONObject.put("channel", URLEncoder.encode(h.i(context), "UTF-8"));
                } catch (UnsupportedEncodingException unused4) {
                    jSONObject.put("channel", "");
                }
                int a2 = a(context, "http://da.mmarket.com/mmsdk/mmsdk?func=mmsdk:specposteventlog", jSONObject);
                if (a2 != 1) {
                    if (a2 != 3) {
                        if (a2 == 2) {
                            Log.w("MobileAgent", "please check your network");
                        }
                        return false;
                    }
                }
                if (str2 == null) {
                    b(context, 3);
                    i(context, str);
                    str3 = "MobileAgent";
                    str4 = "evn log sd";
                } else {
                    str3 = "MobileAgent";
                    str4 = "evnrt log sd";
                }
                Log.i(str3, str4);
                if (contains && a2 == 1) {
                    d(context, "#lxapkmd5");
                }
                return true;
            } catch (JSONException e2) {
                i(context, str);
                e2.printStackTrace();
                return true;
            }
        } else if (str2 != null) {
            return false;
        } else {
            b(context, 3);
            i(context, str);
            return true;
        }
    }

    private static String g(Context context, String str) {
        return k(context).getString(str, "0");
    }

    static synchronized void g(Context context) {
        synchronized (b.class) {
            c.a("MobileAgentRun", "run into uploadlist :" + context.getClass().getName());
            if (g == 2) {
                try {
                    Thread.sleep((long) h);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            boolean z = true;
            System.currentTimeMillis();
            while (true) {
                String n2 = n(context);
                if (n2.equals("")) {
                    break;
                } else if (!z) {
                    break;
                } else {
                    if (n2.substring(0, 6).equals(i)) {
                        z = a(context, n2);
                    } else if (n2.substring(0, 6).equals(j)) {
                        z = e(context, n2, (String) null);
                    } else if (n2.substring(0, 6).equals(l)) {
                        z = c(context, n2);
                    } else if (n2.substring(0, 6).equals(m)) {
                        z = b(context, n2);
                    } else if (n2.substring(0, 6).equals(k)) {
                        z = f(context, n2, (String) null);
                    }
                    if (z) {
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a("MobileAgentRun", "finish a task : " + n2);
                }
            }
            c.a("MobileAgentRun", " finish uploadlist ");
            c.a("MobileAgentRun", "run out uploadlist :" + context.getClass().getName());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049 A[SYNTHETIC, Splitter:B:31:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0055 A[SYNTHETIC, Splitter:B:38:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005f A[SYNTHETIC, Splitter:B:44:0x005f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0050=Splitter:B:35:0x0050, B:28:0x0044=Splitter:B:28:0x0044} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String h(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.iflytek.cloud.thirdparty.b> r0 = com.iflytek.cloud.thirdparty.b.class
            monitor-enter(r0)
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileInputStream r6 = r6.openFileInput(r7)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x0043 }
            r7 = 10000(0x2710, float:1.4013E-41)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
        L_0x000e:
            int r2 = r6.read(r7)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            r3 = -1
            if (r2 != r3) goto L_0x0020
            if (r6 == 0) goto L_0x005b
            r6.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x005b
        L_0x001b:
            r6 = move-exception
        L_0x001c:
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
            goto L_0x005b
        L_0x0020:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r4 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            r5 = 0
            r4.<init>(r7, r5, r2)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r2 = r3.toString()     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003a, all -> 0x0038 }
            r1 = r2
            goto L_0x000e
        L_0x0038:
            r7 = move-exception
            goto L_0x005d
        L_0x003a:
            r7 = move-exception
            r2 = r6
            goto L_0x0044
        L_0x003d:
            r7 = move-exception
            r2 = r6
            goto L_0x0050
        L_0x0040:
            r7 = move-exception
            r6 = r2
            goto L_0x005d
        L_0x0043:
            r7 = move-exception
        L_0x0044:
            r7.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x005b
        L_0x004d:
            r6 = move-exception
            goto L_0x001c
        L_0x004f:
            r7 = move-exception
        L_0x0050:
            r7.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005b
        L_0x0059:
            r6 = move-exception
            goto L_0x001c
        L_0x005b:
            monitor-exit(r0)
            return r1
        L_0x005d:
            if (r6 == 0) goto L_0x0067
            r6.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
        L_0x0067:
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.b.h(android.content.Context, java.lang.String):java.lang.String");
    }

    private static void h(Context context) {
        c.a("MobileAgentRun", "run into onresumep :" + context.getClass().getName());
        try {
            c.a("page pro", "do resume start: " + context.getClass().getName());
            b(context, j(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c.a("MobileAgentRun", "run out onresume :" + context.getClass().getName());
    }

    /* access modifiers changed from: private */
    public static void h(Context context, String str, String str2) {
        c.a("MobileAgentAPI", "run in onEvent [" + str + "," + str2 + "]");
        if (context == null) {
            Log.e("MobileAgent", "Exception occurent in onEvent ,context cann't be null");
            return;
        }
        if (TextUtils.isEmpty(str) || h.a(str, 100)) {
            Log.e("MobileAgent", "Exception occurent in onEvent ,channelID cann't be empty or length more than 100");
        }
        if (h.a(str2, 900)) {
            Log.e("MobileAgent", "Exception occurent in onEvent ,channelID cann't be empty or length more than 100");
        }
        new d(context, 11, str, str2).start();
    }

    private static String i(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        if (str.equals("onResume")) {
            o = currentTimeMillis;
        } else if (str.equals("onPause") && n.equals(context.getClass().getName())) {
            long j3 = currentTimeMillis - o;
            if (j3 > 12000000) {
                j2 = 300000;
            } else if (j3 >= 0) {
                j2 = j3;
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(context.getClass().getName());
        stringBuffer.append("|");
        stringBuffer.append(currentTimeMillis);
        stringBuffer.append("|");
        stringBuffer.append(j2);
        stringBuffer.append("|");
        stringBuffer.append(n);
        stringBuffer.append("\n");
        n = context.getClass().getName();
        return stringBuffer.toString();
    }

    private static void i(Context context) {
        c.a("MobileAgentRun", "run into onpausep :" + context.getClass().getName());
        SharedPreferences l2 = l(context);
        String string = l2.getString("activities", (String) null);
        SharedPreferences.Editor edit = l2.edit();
        edit.putLong("endTime", System.currentTimeMillis());
        edit.putString("activities", i(context, "onPause", string));
        edit.commit();
        c.a("MobileAgentRun", "run out onpausep :" + context.getClass().getName());
    }

    private static void i(Context context, String str) {
        if (str != null) {
            context.deleteFile(str);
            j(context, str);
        }
    }

    private static void j(Context context, String str) {
        synchronized (q) {
            SharedPreferences c2 = c(context);
            String string = c2.getString("uploadList", "");
            c2.edit().putString("uploadList", string.replace(String.valueOf(str) + "|", "")).commit();
        }
    }

    private static boolean j(Context context) {
        c.a("MobileAgentRun", "run into sessionpolicy");
        String h2 = h.h(context);
        SharedPreferences l2 = l(context);
        String string = l2.getString("sessionId", (String) null);
        boolean z = false;
        if (a(l2)) {
            if (string != null) {
                a(context, l2, true);
                SharedPreferences.Editor edit = l2.edit();
                Long valueOf = Long.valueOf(l2.getLong("readFlowRev", 0));
                Long valueOf2 = Long.valueOf(l2.getLong("readFlowSnd", 0));
                edit.clear();
                edit.putLong("readFlowRev", valueOf.longValue()).commit();
                edit.putLong("readFlowSnd", valueOf2.longValue()).commit();
            }
            a(context, h2, l2);
            a(context, l2, false);
            if (a(context, 1)) {
                e(context);
            }
            z = true;
        } else {
            String string2 = l2.getString("activities", (String) null);
            SharedPreferences.Editor edit2 = l2.edit();
            edit2.putString("activities", i(context, "onResume", string2));
            edit2.putLong("lastResumeTime", System.currentTimeMillis());
            edit2.commit();
            if (g == 1 || string2.getBytes().length > 10000) {
                a(context, l2, false);
            }
        }
        c.a("MobileAgentRun", "run out sessionpolicy");
        return z;
    }

    private static SharedPreferences k(Context context) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_config_" + packageName, 0);
    }

    private static SharedPreferences l(Context context) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences(String.valueOf(b) + "MoblieAgent_state_" + packageName, 0);
    }

    private static synchronized long m(Context context) {
        long j2;
        synchronized (b.class) {
            j2 = c(context).getLong("uploadpopindex", 0);
        }
        return j2;
    }

    private static String n(Context context) {
        String str;
        synchronized (q) {
            str = "";
            String string = c(context).getString("uploadList", "");
            if (!string.equals("")) {
                str = string.substring(0, string.indexOf("|"));
            }
        }
        return str;
    }

    private static boolean o(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
