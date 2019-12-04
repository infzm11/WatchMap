package com.iflytek.sunflower.task;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.iflytek.sunflower.a.b;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.util.j;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends Thread {
    private b a;
    private JSONObject b;
    private Context c;
    private String d;
    private HashMap<String, String> e;

    public e(Context context, JSONObject jSONObject, String str, HashMap<String, String> hashMap) {
        try {
            this.c = context.getApplicationContext();
        } catch (Exception e2) {
            j.d("Collector", "LogTask getApplicationcontext failed ", e2);
            this.c = context;
        }
        this.b = jSONObject;
        this.d = str;
        this.e = hashMap;
    }

    public void run() {
        String str = "";
        if (f() != null) {
            try {
                str = "," + r0.toString();
                String d2 = c.d(this.c);
                j.e("Collector", "str = " + str);
                c.a(this.c, str, d2, 32768);
            } catch (Throwable th) {
                j.f("Collector", "send error" + th);
                return;
            }
        }
        a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x011c, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x011e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x011f, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0121, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0122, code lost:
        com.iflytek.sunflower.util.j.f("Collector", "send error" + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0121 A[ExcHandler: Throwable (r6v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r6 = r5.c
            java.lang.String r6 = com.iflytek.sunflower.c.d(r6)
            boolean r0 = r5.c()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Collector"
            java.lang.String r2 = "saveAppInfo"
            com.iflytek.sunflower.util.j.a(r0, r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            org.json.JSONArray r0 = r5.a()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            if (r0 == 0) goto L_0x0049
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r3 = "appinfo"
            r2.put(r3, r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = "ts"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.put(r0, r3)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r3 = ","
            r0.append(r3)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r2 = r2.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r0.append(r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = r0.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            android.content.Context r2 = r5.c     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            com.iflytek.sunflower.c.a(r2, r0, r6, r1)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
        L_0x0049:
            boolean r0 = r5.d()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "Collector"
            java.lang.String r2 = "saveHisInfo"
            com.iflytek.sunflower.util.j.a(r0, r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            org.json.JSONArray r0 = r5.b()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            if (r0 == 0) goto L_0x0089
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r3 = "hisinfo"
            r2.put(r3, r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = "ts"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.put(r0, r3)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r3 = ","
            r0.append(r3)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r2 = r2.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r0.append(r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = r0.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            android.content.Context r2 = r5.c     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            com.iflytek.sunflower.c.a(r2, r0, r6, r1)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
        L_0x0089:
            boolean r0 = r5.e()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            if (r0 == 0) goto L_0x015b
            android.content.Context r0 = r5.c     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = com.iflytek.sunflower.c.f(r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            if (r0 != 0) goto L_0x0098
            return
        L_0x0098:
            java.lang.String r1 = "Collector"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r3 = "message = "
            r2.append(r3)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2.append(r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r2 = r2.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            com.iflytek.sunflower.util.j.e(r1, r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r1.<init>()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r2 = "["
            r1.append(r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r2 = 1
            java.lang.String r0 = r0.substring(r2)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            r1.append(r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = "]"
            r1.append(r0)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r0 = r1.toString()     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            android.content.Context r1 = r5.c     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            java.lang.String r1 = com.iflytek.sunflower.c.d(r1)     // Catch:{ OutOfMemoryError -> 0x013f, JSONException -> 0x0139, Throwable -> 0x0121 }
            boolean r6 = android.text.TextUtils.isEmpty(r1)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            if (r6 != 0) goto L_0x00da
            android.content.Context r6 = r5.c     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r6.deleteFile(r1)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
        L_0x00da:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r6.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            java.lang.String r3 = "log"
            r0.put(r3, r6)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            android.content.Context r6 = r5.c     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            org.json.JSONObject r6 = com.iflytek.sunflower.d.a((android.content.Context) r6)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            org.json.JSONObject r6 = com.iflytek.sunflower.d.a((org.json.JSONObject) r0, (org.json.JSONObject) r6)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            java.lang.String r0 = "Collector"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r3.<init>()     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            java.lang.String r4 = "onlog send: "
            r3.append(r4)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            java.lang.String r4 = r6.toString()     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r3.append(r4)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            java.lang.String r3 = r3.toString()     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            com.iflytek.sunflower.util.j.e(r0, r3)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            com.iflytek.sunflower.a.b r0 = new com.iflytek.sunflower.a.b     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            android.content.Context r3 = r5.c     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r0.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r5.a = r0     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            com.iflytek.sunflower.a.b r0 = r5.a     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            r0.a((org.json.JSONObject) r6, (int) r2)     // Catch:{ OutOfMemoryError -> 0x011e, JSONException -> 0x011c, Throwable -> 0x0121 }
            goto L_0x015b
        L_0x011c:
            r6 = r1
            goto L_0x0139
        L_0x011e:
            r0 = move-exception
            r6 = r1
            goto L_0x0140
        L_0x0121:
            r6 = move-exception
            java.lang.String r0 = "Collector"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send error"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.iflytek.sunflower.util.j.f(r0, r6)
            goto L_0x015b
        L_0x0139:
            android.content.Context r0 = r5.c
            r0.deleteFile(r6)
            goto L_0x015b
        L_0x013f:
            r0 = move-exception
        L_0x0140:
            android.content.Context r1 = r5.c
            r1.deleteFile(r6)
            java.lang.String r6 = "Collector"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "write error"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.iflytek.sunflower.util.j.f(r6, r0)
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.task.e.a(java.lang.String):void");
    }

    private boolean c() {
        if (this.e != null) {
            return Boolean.parseBoolean(this.e.get(DataKeys.KEY_APPINFO));
        }
        return false;
    }

    private boolean d() {
        if (this.e != null) {
            return Boolean.parseBoolean(this.e.get(DataKeys.KEY_HISINFO));
        }
        return false;
    }

    private boolean e() {
        if (this.e != null) {
            return Boolean.parseBoolean(this.e.get(DataKeys.KEY_SEND));
        }
        if (System.currentTimeMillis() - c.a(this.c).getLong(DataKeys.SEND_TIME_LOG, 0) >= a.w) {
            return true;
        }
        if (c.a(this.c, c.d(this.c)) >= a.x) {
            return true;
        }
        return false;
    }

    public JSONArray a() {
        try {
            JSONArray jSONArray = new JSONArray();
            PackageManager packageManager = this.c.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            for (int i = 0; i < installedPackages.size(); i++) {
                PackageInfo packageInfo = installedPackages.get(i);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(packageInfo.packageName, packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray b() {
        try {
            JSONArray jSONArray = new JSONArray();
            PackageManager packageManager = this.c.getPackageManager();
            for (ActivityManager.RecentTaskInfo recentTaskInfo : ((ActivityManager) this.c.getSystemService("activity")).getRecentTasks(20, 1)) {
                ResolveInfo resolveActivity = packageManager.resolveActivity(recentTaskInfo.baseIntent, 0);
                if (resolveActivity != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(resolveActivity.activityInfo.packageName, resolveActivity.loadLabel(packageManager).toString());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONObject f() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("type", this.d);
        } catch (Exception e2) {
            j.d("Collector", "input error " + e2);
        }
        return jSONObject;
    }
}
