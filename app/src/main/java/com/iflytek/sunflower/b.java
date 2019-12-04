package com.iflytek.sunflower;

import android.content.Context;
import com.iflytek.speech.UtilityConfig;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.entity.PageEntity;
import com.iflytek.sunflower.task.SendTask;
import com.iflytek.sunflower.task.c;
import com.iflytek.sunflower.task.d;
import com.iflytek.sunflower.task.e;
import com.iflytek.sunflower.task.h;
import com.iflytek.sunflower.task.i;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class b {
    private static b b;
    private static Context c;
    public ExecutorService a = Executors.newSingleThreadExecutor();

    private b(Context context) {
        if (context != null) {
            c = context;
        }
    }

    public static b a(Context context) {
        if (b == null) {
            b = new b(context);
        } else {
            c = context;
        }
        return b;
    }

    public void a(String str, String str2) {
        String a2 = l.a(str2);
        if (str.equals("destUrl")) {
            a.y = a2;
        } else if (str.equals("updateConfigUrl")) {
            a.B = a2;
        } else if (str.equals("deviceid")) {
            a.C = a2;
        } else if (str.equals(UtilityConfig.KEY_CALLER_APPID)) {
            a.D = a2;
        } else if (str.equals("net.mac")) {
            a.E = a2;
        } else if (str.equals(DataKeys.KEY_INNERLOG)) {
            j.b(Boolean.parseBoolean(a2));
        } else if (str.equals("duid")) {
            a.F = a2;
        } else if (str.equals(DataKeys.KEY_URL_PARAMS)) {
            a.z.a(a2);
        } else if (str.equals(DataKeys.KEY_URL_PARAMS_ONLOG)) {
            a.A.a(a2);
        } else if (str.equals("lat")) {
            a.G = a2;
        } else if (str.equals("lng")) {
            a.H = a2;
        }
    }

    public synchronized void a(String str, String str2, HashMap<String, String> hashMap, long j) {
        ExecutorService executorService = this.a;
        d dVar = new d(0, str, str2, hashMap, j);
        executorService.execute(dVar);
        if (d()) {
            c();
        }
    }

    private boolean d() {
        if (a.o == 0) {
            return false;
        }
        if (Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(c.a(c).getLong(DataKeys.SEND_TIME, 0)).longValue() > ((long) a.p)) {
            return true;
        }
        return false;
    }

    public void b(String str, String str2, HashMap<String, String> hashMap, long j) {
        ExecutorService executorService = this.a;
        d dVar = new d(1, str, str2, hashMap, j);
        executorService.execute(dVar);
    }

    public void c(String str, String str2, HashMap<String, String> hashMap, long j) {
        ExecutorService executorService = this.a;
        d dVar = new d(2, str, str2, hashMap, j);
        executorService.execute(dVar);
        if (d()) {
            c();
        }
    }

    public synchronized void b(String str, String str2) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.sid = a.f;
        errorEntity.startTp = System.currentTimeMillis();
        errorEntity.msg = g.a(str2);
        errorEntity.errorType = str;
        errorEntity.appver = com.iflytek.sunflower.util.a.a(c).b("app.ver.name");
        this.a.execute(new c(errorEntity));
    }

    public void a() {
        a.h = c.getClass().getName();
        this.a.execute(new h(c));
    }

    public void b() {
        if (!c.getClass().getName().equals(a.h)) {
            j.a("Collector", "onPause called without context from corresponding onResume");
        } else {
            this.a.execute(new com.iflytek.sunflower.task.g(c));
        }
    }

    public void a(final String str) {
        this.a.execute(new Runnable() {
            public void run() {
                try {
                    e.a.push(new PageEntity(str, System.currentTimeMillis()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void b(final String str) {
        this.a.execute(new Runnable() {
            public void run() {
                try {
                    if (e.a.isEmpty() || !e.a.peek().pageName.equals(str)) {
                        j.a("Collector", "onPageEnd called without 'PageName' from corresponding onPageStart");
                        return;
                    }
                    PageEntity pop = e.a.pop();
                    pop.duration = System.currentTimeMillis() - pop.duration;
                    e.a(pop);
                    StringBuilder sb = new StringBuilder();
                    Iterator<PageEntity> it = e.b.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().pageName);
                        sb.append(",");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void a(JSONObject jSONObject, String str, HashMap<String, String> hashMap) {
        this.a.execute(new e(c, jSONObject, str, hashMap));
    }

    public void c() {
        this.a.execute(new SendTask(c));
    }

    public void a(OnlineConfigListener onlineConfigListener) {
        this.a.execute(new i(c, onlineConfigListener));
    }
}
