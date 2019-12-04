package com.iflytek.sunflower.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.iflytek.sunflower.OnlineConfigListener;
import com.iflytek.sunflower.a.a;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.util.d;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.h;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.k;
import org.json.JSONObject;

public class b extends f {
    private Context b;

    public b(Context context, OnlineConfigListener onlineConfigListener) {
        super(context, onlineConfigListener);
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        try {
            JSONObject b2 = b();
            if (k.a(this.b)) {
                byte[] bytes = b2.toString().getBytes("utf-8");
                j.a("Collector", "AppListTask data is: " + new String(bytes, "UTF-8"));
                byte[] a = d.a(bytes);
                a aVar = new a();
                aVar.b(20000);
                aVar.a(1);
                aVar.a("http://data.openspeech.cn/index.php/clientrequest/clientcollect/isCollect", "", a);
                aVar.b(this.a);
                return;
            }
            j.f("Collector", "upload app list error, please check net state");
        } catch (Throwable unused) {
            j.f("Collector", "exception occur while upload app list");
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        j.e("Collector", "get app list config result: " + jSONObject.toString());
        Long valueOf = Long.valueOf((long) (Float.parseFloat(jSONObject.optString(DataKeys.TI_APP_ACTIVE)) * 3600.0f));
        Long valueOf2 = Long.valueOf((long) (Float.parseFloat(jSONObject.optString(DataKeys.TI_APP_LIST)) * 3600.0f));
        Long valueOf3 = Long.valueOf((long) (Float.parseFloat(jSONObject.optString(DataKeys.TI_REQUEST)) * 3600.0f));
        Boolean bool = false;
        if ("yes".equalsIgnoreCase(jSONObject.optString(DataKeys.IS_COLLECT))) {
            bool = true;
        }
        SharedPreferences.Editor edit = c.a(this.b).edit();
        edit.putLong(DataKeys.TI_APP_ACTIVE, valueOf.longValue());
        edit.putLong(DataKeys.TI_APP_LIST, valueOf2.longValue());
        edit.putLong(DataKeys.TI_REQUEST, valueOf3.longValue());
        edit.putBoolean(DataKeys.IS_COLLECT, bool.booleanValue());
        edit.commit();
    }

    private JSONObject b() {
        com.iflytek.sunflower.util.a.a(new h(), this.b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "app_list");
            jSONObject.put("appid", g.f(this.b));
            jSONObject.put("pver", "2");
            j.e("Collector", jSONObject.toString());
            return jSONObject;
        } catch (Throwable unused) {
            j.f("Collector", "exception occur while upload app list");
            return null;
        }
    }
}
