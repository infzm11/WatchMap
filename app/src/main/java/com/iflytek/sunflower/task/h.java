package com.iflytek.sunflower.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iflytek.speech.VoiceWakeuperAidl;
import com.iflytek.sunflower.OnlineConfigListener;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.entity.BootEntity;
import com.iflytek.sunflower.entity.CloseEntity;
import com.iflytek.sunflower.nativecrash.b;
import com.iflytek.sunflower.util.d;
import com.iflytek.sunflower.util.e;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class h extends Thread {
    private Context a;

    public h(Context context) {
        this.a = context.getApplicationContext();
    }

    public void run() {
        try {
            a();
        } catch (Exception e) {
            j.d("Collector", "call onResume error", e);
        }
    }

    private void a() {
        SharedPreferences a2 = c.a(this.a);
        if (a2 == null) {
            j.c("Collector", "sharedpreferences is null");
            return;
        }
        a.b = g.f(this.a);
        try {
            a.o = Integer.parseInt(a2.getString(DataKeys.REPORT_POLICY, "0"));
            a.p = Integer.parseInt(a2.getString(DataKeys.REPORT_INTERVAL, "0")) * 1000;
        } catch (Exception unused) {
        }
        e.a(this.a);
        if (a.l.booleanValue()) {
            new a(this.a).a();
        }
        if (a.m.booleanValue()) {
            try {
                new b(this.a).a();
            } catch (Exception e) {
                j.d("Collector", "e is: " + e);
            }
        }
        if (d(a2)) {
            a(a2);
        } else {
            c(a2);
        }
    }

    private void a(SharedPreferences sharedPreferences) {
        a.g = Long.valueOf(System.currentTimeMillis());
        a.f = a(a.g.longValue());
        j.a("Collector", "Open a new session " + a.f);
        CloseEntity closeEntity = new CloseEntity();
        closeEntity.sid = sharedPreferences.getString(DataKeys.SESSION_ID, (String) null);
        if (closeEntity.sid != null) {
            closeEntity.startTp = sharedPreferences.getLong(DataKeys.END_MILLIS, -1);
            closeEntity.durationLong = sharedPreferences.getLong(DataKeys.DURATION, -1);
            closeEntity.page = e(sharedPreferences);
            com.iflytek.sunflower.e.a(closeEntity);
        }
        com.iflytek.sunflower.e.a(new BootEntity(a.f, a.g.longValue()));
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(DataKeys.SESSION_ID, a.f);
        edit.putLong(DataKeys.START_MILLIS, a.g.longValue());
        edit.putLong(DataKeys.END_MILLIS, a.g.longValue());
        edit.putLong(DataKeys.DURATION, 0);
        edit.putString(DataKeys.ACTIVITIES, "");
        edit.commit();
        new SendTask(this.a).send();
        try {
            b(sharedPreferences);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j = sharedPreferences.getLong(DataKeys.TI_REQUEST, -1);
        long j2 = sharedPreferences.getLong(DataKeys.REQUEST_TIME, -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - j2 > j) {
            new b(this.a, (OnlineConfigListener) null).run();
            edit.putLong(DataKeys.REQUEST_TIME, currentTimeMillis);
            edit.commit();
        } else {
            j.e("Collector", "no need to check policy");
        }
        if (sharedPreferences.getBoolean(DataKeys.IS_COLLECT, false)) {
            HashMap hashMap = new HashMap();
            if (currentTimeMillis - sharedPreferences.getLong(DataKeys.LIST_APP_TIME, -1) > sharedPreferences.getLong(DataKeys.TI_APP_LIST, -1)) {
                hashMap.put(DataKeys.KEY_APPINFO, "true");
                edit.putLong(DataKeys.LIST_APP_TIME, currentTimeMillis);
                edit.commit();
            }
            if (currentTimeMillis - sharedPreferences.getLong(DataKeys.ACTIVE_APP_TIME, -1) > sharedPreferences.getLong(DataKeys.TI_APP_ACTIVE, -1)) {
                hashMap.put(DataKeys.KEY_HISINFO, "true");
                edit.putLong(DataKeys.ACTIVE_APP_TIME, currentTimeMillis);
                edit.commit();
            }
            if (hashMap.size() > 0) {
                hashMap.put(DataKeys.KEY_SEND, "true");
                com.iflytek.sunflower.b.a(this.a).a.execute(new e(this.a, (JSONObject) null, (String) null, hashMap));
                return;
            }
            j.e("Collector", "no need to call upload app ");
            return;
        }
        j.e("Collector", "no need to upload app list");
    }

    private void c(SharedPreferences sharedPreferences) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(DataKeys.START_MILLIS, currentTimeMillis);
        edit.putLong(DataKeys.END_MILLIS, currentTimeMillis);
        edit.commit();
        a.f = sharedPreferences.getString(DataKeys.SESSION_ID, (String) null);
        j.a("Collector", "Extend current session: " + a.f);
    }

    private boolean d(SharedPreferences sharedPreferences) {
        return System.currentTimeMillis() - sharedPreferences.getLong(DataKeys.END_MILLIS, -1) > a.a;
    }

    private static ArrayList<String> e(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(DataKeys.ACTIVITIES, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String[] split = string.split(VoiceWakeuperAidl.PARAMS_SEPARATE);
            for (String add : split) {
                arrayList.add(add);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private String a(long j) {
        String a2 = d.a(g.b(this.a));
        return j + d.b(j + a.b + a2);
    }
}
