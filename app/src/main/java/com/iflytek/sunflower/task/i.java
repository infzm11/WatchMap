package com.iflytek.sunflower.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.sunflower.OnlineConfigListener;
import com.iflytek.sunflower.a.a;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.Version;
import com.iflytek.sunflower.util.d;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.h;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.k;
import org.json.JSONObject;

public class i extends f {
    private Context b;
    /* access modifiers changed from: private */
    public OnlineConfigListener c;
    private Handler d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (i.this.c != null) {
                i.this.c.onDataReceived((JSONObject) message.obj);
            }
            super.handleMessage(message);
        }
    };

    public i(Context context, OnlineConfigListener onlineConfigListener) {
        super(context, onlineConfigListener);
        this.b = context;
        this.c = onlineConfigListener;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        try {
            JSONObject b2 = b();
            if (k.a(this.b)) {
                byte[] bytes = b2.toString().getBytes("utf-8");
                j.a("Collector", "updateConfig data is: " + new String(bytes, "UTF-8"));
                byte[] a = d.a(bytes);
                a aVar = new a();
                aVar.b(20000);
                aVar.a(1);
                j.e("Collector", "URL_UPDATE_PARAM:" + com.iflytek.sunflower.config.a.B);
                aVar.a(com.iflytek.sunflower.config.a.B, "", a);
                aVar.b(this.a);
                return;
            }
            j.d("Collector", "update online config error please check net state");
        } catch (Exception unused) {
            j.d("Collector", "exception occur while update online config");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|7|8|(7:10|(2:13|11)|21|14|(1:16)|17|24)(1:23)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0073 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x007b A[Catch:{ Throwable -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r5) {
        /*
            r4 = this;
            super.a(r5)
            java.lang.String r0 = "Collector"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00d9 }
            r1.<init>()     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = "get online config result: "
            r1.append(r2)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = r5.toString()     // Catch:{ Throwable -> 0x00d9 }
            r1.append(r2)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x00d9 }
            com.iflytek.sunflower.util.j.b(r0, r1)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r0 = "Yes"
            java.lang.String r1 = "config_update"
            java.lang.String r1 = r5.optString(r1)     // Catch:{ Throwable -> 0x00d9 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Throwable -> 0x00d9 }
            if (r0 == 0) goto L_0x00d1
            android.content.Context r0 = r4.b     // Catch:{ Throwable -> 0x00d9 }
            android.content.SharedPreferences r0 = com.iflytek.sunflower.c.a(r0)     // Catch:{ Throwable -> 0x00d9 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r1 = com.iflytek.sunflower.config.DataKeys.LAST_CONFIG_TIME     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = com.iflytek.sunflower.config.DataKeys.LAST_CONFIG_TIME     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Throwable -> 0x00d9 }
            r0.putString(r1, r2)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r1 = com.iflytek.sunflower.config.DataKeys.REPORT_POLICY     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = com.iflytek.sunflower.config.DataKeys.REPORT_POLICY     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Throwable -> 0x00d9 }
            r0.putString(r1, r2)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r1 = com.iflytek.sunflower.config.DataKeys.REPORT_INTERVAL     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = com.iflytek.sunflower.config.DataKeys.REPORT_INTERVAL     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Throwable -> 0x00d9 }
            r0.putString(r1, r2)     // Catch:{ Throwable -> 0x00d9 }
            r0.commit()     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r0 = com.iflytek.sunflower.config.DataKeys.REPORT_POLICY     // Catch:{ Exception -> 0x0073 }
            java.lang.String r0 = r5.optString(r0)     // Catch:{ Exception -> 0x0073 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0073 }
            com.iflytek.sunflower.config.a.o = r0     // Catch:{ Exception -> 0x0073 }
            java.lang.String r0 = com.iflytek.sunflower.config.DataKeys.REPORT_INTERVAL     // Catch:{ Exception -> 0x0073 }
            java.lang.String r0 = r5.optString(r0)     // Catch:{ Exception -> 0x0073 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0073 }
            int r0 = r0 * 1000
            com.iflytek.sunflower.config.a.p = r0     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            java.lang.String r0 = com.iflytek.sunflower.config.DataKeys.ONLINE_PARAMS     // Catch:{ Throwable -> 0x00d9 }
            org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ Throwable -> 0x00d9 }
            if (r5 == 0) goto L_0x00e1
            android.content.Context r0 = r4.b     // Catch:{ Throwable -> 0x00d9 }
            android.content.SharedPreferences r0 = com.iflytek.sunflower.c.b(r0)     // Catch:{ Throwable -> 0x00d9 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Throwable -> 0x00d9 }
            r0.clear()     // Catch:{ Throwable -> 0x00d9 }
            r0.commit()     // Catch:{ Throwable -> 0x00d9 }
            java.util.Iterator r1 = r5.keys()     // Catch:{ Throwable -> 0x00d9 }
        L_0x008f:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x00d9 }
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r3 = r5.getString(r2)     // Catch:{ Throwable -> 0x00d9 }
            r0.putString(r2, r3)     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x008f
        L_0x00a3:
            r0.commit()     // Catch:{ Throwable -> 0x00d9 }
            com.iflytek.sunflower.OnlineConfigListener r0 = r4.c     // Catch:{ Throwable -> 0x00d9 }
            if (r0 == 0) goto L_0x00b6
            android.os.Message r0 = new android.os.Message     // Catch:{ Throwable -> 0x00d9 }
            r0.<init>()     // Catch:{ Throwable -> 0x00d9 }
            r0.obj = r5     // Catch:{ Throwable -> 0x00d9 }
            android.os.Handler r1 = r4.d     // Catch:{ Throwable -> 0x00d9 }
            r1.sendMessage(r0)     // Catch:{ Throwable -> 0x00d9 }
        L_0x00b6:
            java.lang.String r0 = "Collector"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00d9 }
            r1.<init>()     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r2 = "get online config params:"
            r1.append(r2)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x00d9 }
            r1.append(r5)     // Catch:{ Throwable -> 0x00d9 }
            java.lang.String r5 = r1.toString()     // Catch:{ Throwable -> 0x00d9 }
            com.iflytek.sunflower.util.j.b(r0, r5)     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x00e1
        L_0x00d1:
            java.lang.String r5 = "Collector"
            java.lang.String r0 = "no online config update."
            com.iflytek.sunflower.util.j.b(r5, r0)     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x00e1
        L_0x00d9:
            r5 = move-exception
            java.lang.String r0 = "Collector"
            java.lang.String r1 = "update online config failed"
            com.iflytek.sunflower.util.j.c(r0, r1, r5)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.task.i.a(org.json.JSONObject):void");
    }

    private JSONObject b() {
        h hVar = new h();
        com.iflytek.sunflower.util.a.a(hVar, this.b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "online_config");
            jSONObject.put("appid", g.f(this.b));
            jSONObject.put("app.ver.code", hVar.b("app.ver.code"));
            jSONObject.put("app.pkg", hVar.b("app.pkg"));
            jSONObject.put("ver", Version.getVersion());
            jSONObject.put("deviceid", g.b(this.b));
            jSONObject.put("channel", g.g(this.b));
            jSONObject.put(DataKeys.REPORT_POLICY, c.a(this.b).getString(DataKeys.REPORT_POLICY, ""));
            jSONObject.put(DataKeys.LAST_CONFIG_TIME, c.a(this.b).getString(DataKeys.LAST_CONFIG_TIME, "-1"));
            j.b("Collector", jSONObject.toString());
            return jSONObject;
        } catch (Throwable unused) {
            j.c("Collector", "exception occur while updateOnlineConfig");
            return null;
        }
    }
}
