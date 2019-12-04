package com.iflytek.sunflower.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iflytek.speech.VoiceWakeuperAidl;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.d;
import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.entity.EventEntity;
import com.iflytek.sunflower.entity.PageEntity;
import com.iflytek.sunflower.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class g extends Thread {
    private Context a;

    public g(Context context) {
        try {
            this.a = context.getApplicationContext();
        } catch (Exception e) {
            j.d("Collector", "PauseTask getApplicationcontext failed", e);
            this.a = context;
        }
    }

    public void run() {
        try {
            a();
        } catch (Exception e) {
            j.d("Collector", "call onPause error", e);
        }
    }

    public void a() {
        SharedPreferences.Editor editor;
        SharedPreferences a2 = c.a(this.a);
        if (a2 == null) {
            j.c("Collector", "sharedpreferences is null");
            return;
        }
        a.f = a2.getString(DataKeys.SESSION_ID, (String) null);
        long j = a2.getLong(DataKeys.START_MILLIS, -1);
        if (j == -1 || a.f == null) {
            j.c("Collector", "onPause called before onResume");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a2.edit();
        if (a.j.booleanValue()) {
            editor = a(a2, e.b, j, currentTimeMillis);
            e.g();
        } else {
            editor = a(a2, (ArrayList<PageEntity>) null, j, currentTimeMillis);
        }
        editor.putLong(DataKeys.START_MILLIS, -1);
        editor.putLong(DataKeys.END_MILLIS, currentTimeMillis);
        editor.commit();
        JSONObject e = c.e(this.a);
        ArrayList<EventEntity> a3 = e.a();
        if (a3.size() != 0) {
            e = d.b(d.a(a3), e);
            e.e();
        }
        ArrayList<ErrorEntity> b = e.b();
        if (b.size() != 0) {
            e = d.a(d.b(b), e);
            e.f();
        }
        if (e != null) {
            try {
                c.a(this.a, e.toString(), (String) null, 0);
            } catch (Throwable th) {
                j.d("Collector", "pasue write to file error", th);
            }
        }
    }

    public SharedPreferences.Editor a(SharedPreferences sharedPreferences, ArrayList<PageEntity> arrayList, long j, long j2) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        long j3 = j2 - j;
        long j4 = sharedPreferences2.getLong(DataKeys.DURATION, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (a.j.booleanValue()) {
            if (arrayList.size() > 0) {
                String string = sharedPreferences2.getString(DataKeys.ACTIVITIES, "");
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(string)) {
                    sb.append(string);
                    sb.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                }
                Iterator<PageEntity> it = arrayList.iterator();
                while (it.hasNext()) {
                    PageEntity next = it.next();
                    sb.append(String.format("[\"%s\",%d]", new Object[]{next.pageName, Long.valueOf(next.duration)}));
                    sb.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                }
                sb.deleteCharAt(sb.length() - 1);
                edit.remove(DataKeys.ACTIVITIES);
                edit.putString(DataKeys.ACTIVITIES, sb.toString());
            }
            j.a("Collector", "collect page info down");
        } else {
            String string2 = sharedPreferences2.getString(DataKeys.ACTIVITIES, "");
            String str = a.h;
            if (!TextUtils.isEmpty(string2)) {
                string2 = string2 + VoiceWakeuperAidl.PARAMS_SEPARATE;
            }
            edit.remove(DataKeys.ACTIVITIES);
            edit.putString(DataKeys.ACTIVITIES, string2 + String.format("[\"%s\",%d]", new Object[]{str, Long.valueOf(j3)}));
        }
        edit.putLong(DataKeys.DURATION, j4 + j3);
        edit.commit();
        String string3 = sharedPreferences2.getString(DataKeys.ACTIVITIES, "");
        j.b("Collector", "page sp:" + string3);
        return edit;
    }
}
