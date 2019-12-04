package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.speech.UtilityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bg {
    JSONObject a = new JSONObject();
    long b = 0;
    long c = 0;

    public synchronized String a() {
        return this.a.toString();
    }

    public void a(ce ceVar) {
        this.c = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        a("app_start", bt.a(this.c), false);
        String e = ceVar.e(UtilityConfig.KEY_CALLER_APPID);
        if (!TextUtils.isEmpty(e)) {
            a("app_caller_appid", e, false);
        }
        String e2 = bp.a((Context) null).e("app.ver.code");
        if (!TextUtils.isEmpty(e2)) {
            a("app_cver", e2, false);
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

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0035
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0035
        L_0x000e:
            if (r4 != 0) goto L_0x0018
            org.json.JSONObject r4 = r1.a     // Catch:{ JSONException -> 0x0016 }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x0033
        L_0x0016:
            r2 = move-exception
            goto L_0x0030
        L_0x0018:
            org.json.JSONObject r4 = r1.a     // Catch:{ JSONException -> 0x0016 }
            org.json.JSONArray r4 = r4.optJSONArray(r2)     // Catch:{ JSONException -> 0x0016 }
            if (r4 != 0) goto L_0x002a
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0016 }
            r4.<init>()     // Catch:{ JSONException -> 0x0016 }
            org.json.JSONObject r0 = r1.a     // Catch:{ JSONException -> 0x0016 }
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0016 }
        L_0x002a:
            if (r4 == 0) goto L_0x0033
            r4.put(r3)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x0033
        L_0x0030:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0037 }
        L_0x0033:
            monitor-exit(r1)
            return
        L_0x0035:
            monitor-exit(r1)
            return
        L_0x0037:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.bg.a(java.lang.String, java.lang.String, boolean):void");
    }
}
