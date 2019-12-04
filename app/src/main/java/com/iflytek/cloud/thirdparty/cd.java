package com.iflytek.cloud.thirdparty;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.Version;
import com.iflytek.cloud.thirdparty.by;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class cd {
    private static cd a;
    private static Context b;
    /* access modifiers changed from: private */
    public static SharedPreferences c;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public boolean e = false;
    private boolean f = false;
    private boolean g = false;
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public long i = 0;
    /* access modifiers changed from: private */
    public long j = 0;
    /* access modifiers changed from: private */
    public long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 43200;
    private by.a o = new by.a() {
        public void a(SpeechError speechError) {
            boolean unused = cd.this.d = false;
            cb.d("CollectInfo", "" + speechError.getErrorCode());
        }

        public void a(by byVar, byte[] bArr) {
            if (bArr != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EncodingUtils.getString(bu.c(bArr), "utf-8"));
                    cb.d("CollectInfo", "策略请求结果： " + jSONObject.toString());
                    if ("yes".equalsIgnoreCase(jSONObject.optString("is_collect"))) {
                        boolean unused = cd.this.h = true;
                    } else {
                        boolean unused2 = cd.this.h = false;
                    }
                    long unused3 = cd.this.i = (long) (Double.parseDouble(jSONObject.optString("ti_request")) * 3600.0d);
                    long unused4 = cd.this.j = (long) (Double.parseDouble(jSONObject.optString("ti_app_list")) * 3600.0d);
                    long unused5 = cd.this.k = (long) (Double.parseDouble(jSONObject.optString("ti_app_active")) * 3600.0d);
                    SharedPreferences.Editor edit = cd.c.edit();
                    edit.putBoolean("is_collect", cd.this.h);
                    edit.putLong("ti_request", cd.this.i);
                    edit.putLong("ti_app_list", cd.this.j);
                    edit.putLong("ti_app_active", cd.this.k);
                    edit.commit();
                } catch (Throwable th) {
                    boolean unused6 = cd.this.d = false;
                    throw th;
                }
            }
            boolean unused7 = cd.this.d = false;
        }
    };
    private by.a p = new by.a() {
        public void a(SpeechError speechError) {
            boolean unused = cd.this.e = false;
            cb.d("CollectInfo", "" + speechError.getErrorCode());
        }

        public void a(by byVar, byte[] bArr) {
            if (bArr != null) {
                try {
                    String string = EncodingUtils.getString(bu.c(bArr), "utf-8");
                    cb.d("CollectInfo", "上传数据结果返回： " + string);
                } catch (Throwable th) {
                    boolean unused = cd.this.e = false;
                    throw th;
                }
            }
            boolean unused2 = cd.this.e = false;
        }
    };

    private cd(Context context) {
        if (context != null) {
            b = context.getApplicationContext();
            c = b.getSharedPreferences("iflytek_state_" + b.getPackageName(), 0);
            this.h = c.getBoolean("is_collect", false);
            this.i = c.getLong("ti_request", 0);
            this.j = c.getLong("ti_app_list", this.n);
            this.l = c.getLong("list_app_time", 0);
            this.k = c.getLong("ti_app_active", this.n);
            this.m = c.getLong("active_app_time", 0);
        }
    }

    public static cd a(Context context) {
        if (a == null) {
            a = new cd(context);
        }
        return a;
    }

    private static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject2);
            jSONObject3.put("body", jSONObject);
            return jSONObject3;
        } catch (Throwable th) {
            cb.b(th);
            return jSONObject3;
        }
    }

    private static JSONObject a(boolean z, ce ceVar, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry next : ceVar.c().entrySet()) {
            try {
                jSONObject2.put((String) next.getKey(), next.getValue());
            } catch (Throwable th) {
                cb.b(th);
            }
        }
        jSONObject.put(str, jSONObject2);
        return z ? jSONObject : jSONObject2;
    }

    private void a(JSONObject jSONObject) {
        try {
            if (bz.b(b)) {
                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                byte[] b2 = bu.b(bytes);
                by byVar = new by();
                byVar.b(20000);
                byVar.a(1);
                byVar.a("http://scs.openspeech.cn/scs", "cmd=statsdklog&logver=1.0.2&size=" + bytes.length, b2);
                byVar.a(this.p);
                return;
            }
            this.e = false;
        } catch (Throwable th) {
            this.e = false;
            cb.b(th);
        }
    }

    private static JSONObject b(Context context) {
        ce b2 = bp.b(context).clone();
        cg.a(context, b2);
        b2.a("appid", cg.a());
        b2.a("unique_id", ca.a(context));
        b2.a("src", SpeechConstant.MODE_MSC);
        b2.a("ver", Version.getVersion());
        b2.a("lang", Locale.getDefault().getLanguage());
        b2.a("logtime", "" + System.currentTimeMillis());
        JSONObject a2 = a(false, b2, "header");
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.########");
            a2.put("lat", decimalFormat.format((double) br.a(context).a("msc.lat")));
            a2.put("lng", decimalFormat.format((double) br.a(context).a("msc.lng")));
            return a2;
        } catch (Throwable th) {
            cb.b(th);
            return a2;
        }
    }

    private boolean d() {
        try {
            return (System.currentTimeMillis() / 1000) - c.getLong("request_time", 0) > c.getLong("ti_request", 0);
        } catch (Throwable th) {
            cb.b(th);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pver", "3");
            jSONObject.put("type", "app_list");
            jSONObject.put("appid", cg.a());
            jSONObject.put("src", SpeechConstant.MODE_MSC);
            cb.d("CollectInfo", jSONObject.toString());
            if (bz.b(b)) {
                byte[] b2 = bu.b(jSONObject.toString().getBytes("utf-8"));
                by byVar = new by();
                byVar.b(20000);
                byVar.a(1);
                byVar.a("http://data.openspeech.cn/index.php/clientrequest/clientcollect/isCollect", "", b2);
                byVar.a(this.o);
                SharedPreferences.Editor edit = c.edit();
                edit.putLong("request_time", System.currentTimeMillis() / 1000);
                edit.commit();
                return;
            }
            this.d = false;
        } catch (Throwable th) {
            this.d = false;
            cb.b(th);
        }
    }

    private boolean f() {
        if (!this.h) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.f = currentTimeMillis - this.l > this.j;
        this.g = currentTimeMillis - this.m > this.k;
        return this.f || this.g;
    }

    /* access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor edit = c.edit();
        if (this.f) {
            this.l = System.currentTimeMillis() / 1000;
            cb.d("CollectInfo", "lastListAppTime:" + this.l);
            edit.putLong("list_app_time", this.l);
        }
        if (this.g) {
            this.m = System.currentTimeMillis() / 1000;
            cb.d("CollectInfo", "lastActiveAppTime:" + this.m);
            edit.putLong("active_app_time", this.m);
        }
        edit.commit();
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.f) {
                JSONArray h2 = h();
                if (h2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appinfo", h2);
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                }
            }
            if (this.g) {
                JSONArray i2 = i();
                if (i2 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("hisinfo", i2);
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject2);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("log", jSONArray);
            JSONObject a2 = a(jSONObject3, b(b));
            cb.d("CollectInfo", a2.toString());
            a(a2);
        } catch (Throwable th) {
            this.e = false;
            cb.b(th);
        }
    }

    private JSONArray h() {
        try {
            JSONArray jSONArray = new JSONArray();
            PackageManager packageManager = b.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            int size = installedPackages.size();
            for (int i2 = 0; i2 < size; i2++) {
                PackageInfo packageInfo = installedPackages.get(i2);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(packageInfo.packageName, packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            cb.b(th);
            return null;
        }
    }

    private JSONArray i() {
        try {
            JSONArray jSONArray = new JSONArray();
            PackageManager packageManager = b.getPackageManager();
            for (ActivityManager.RecentTaskInfo recentTaskInfo : ((ActivityManager) b.getSystemService("activity")).getRecentTasks(20, 1)) {
                ResolveInfo resolveActivity = packageManager.resolveActivity(recentTaskInfo.baseIntent, 0);
                if (resolveActivity != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(resolveActivity.activityInfo.packageName, resolveActivity.loadLabel(packageManager).toString());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            cb.b(th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.d     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.d = r0     // Catch:{ all -> 0x0023 }
            boolean r0 = r2.d()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001e
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0023 }
            com.iflytek.cloud.thirdparty.cd$1 r1 = new com.iflytek.cloud.thirdparty.cd$1     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            r0.<init>(r1)     // Catch:{ all -> 0x0023 }
            r0.start()     // Catch:{ all -> 0x0023 }
            goto L_0x0021
        L_0x001e:
            r0 = 0
            r2.d = r0     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cd.a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.e     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.e = r0     // Catch:{ all -> 0x0023 }
            boolean r0 = r2.f()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001e
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0023 }
            com.iflytek.cloud.thirdparty.cd$2 r1 = new com.iflytek.cloud.thirdparty.cd$2     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            r0.<init>(r1)     // Catch:{ all -> 0x0023 }
            r0.start()     // Catch:{ all -> 0x0023 }
            goto L_0x0021
        L_0x001e:
            r0 = 0
            r2.e = r0     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cd.b():void");
    }
}
