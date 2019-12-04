package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.speech.UtilityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class an {
    JSONObject a = new JSONObject();
    long b = 0;
    long c = 0;

    public synchronized String a() {
        cb.a("sessinfo:" + this.a.toString());
        return this.a.toString();
    }

    public void a(ce ceVar) {
        this.c = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        a("app_fau", bt.a(this.c), false);
        a("stmid", ceVar.e("stmid"), false);
        a("wake_id", ceVar.e("wake_id"), false);
        String e = ceVar.e(UtilityConfig.KEY_CALLER_APPID);
        if (!TextUtils.isEmpty(e)) {
            a("app_caller_appid", e, false);
        }
        ce a2 = bp.a((Context) null);
        String e2 = a2.e("app.ver.code");
        if (!TextUtils.isEmpty(e2)) {
            a("app_cver", e2, false);
        }
        String e3 = a2.e("app.ver.name");
        if (!TextUtils.isEmpty(e3)) {
            a("app_cver_name", e3, false);
        }
    }

    public synchronized void a(String str) {
        a(str, SystemClock.elapsedRealtime() - this.b, false);
    }

    public synchronized void a(String str, long j, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (!z) {
                try {
                    this.a.put(str, j);
                } catch (JSONException e) {
                    cb.a((Throwable) e);
                }
            } else {
                JSONArray optJSONArray = this.a.optJSONArray(str);
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                    this.a.put(str, optJSONArray);
                }
                if (optJSONArray != null) {
                    optJSONArray.put(j);
                }
            }
        } else {
            return;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0031
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0031
        L_0x000e:
            if (r4 != 0) goto L_0x0018
            org.json.JSONObject r4 = r1.a     // Catch:{ JSONException -> 0x0016 }
        L_0x0012:
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x002f
        L_0x0016:
            r2 = move-exception
            goto L_0x002c
        L_0x0018:
            org.json.JSONObject r4 = r1.a     // Catch:{ JSONException -> 0x0016 }
            org.json.JSONArray r4 = r4.optJSONArray(r2)     // Catch:{ JSONException -> 0x0016 }
            if (r4 != 0) goto L_0x0028
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0016 }
            r3.<init>()     // Catch:{ JSONException -> 0x0016 }
            org.json.JSONObject r4 = r1.a     // Catch:{ JSONException -> 0x0016 }
            goto L_0x0012
        L_0x0028:
            r4.put(r3)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x002f
        L_0x002c:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0033 }
        L_0x002f:
            monitor-exit(r1)
            return
        L_0x0031:
            monitor-exit(r1)
            return
        L_0x0033:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.an.a(java.lang.String, java.lang.String, boolean):void");
    }
}
