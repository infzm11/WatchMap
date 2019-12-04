package com.iflytek.sunflower.task;

import android.text.TextUtils;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.EventEntity;
import com.iflytek.sunflower.util.c;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.util.HashMap;
import java.util.Map;

public class d extends Thread {
    private EventEntity a;
    private int b;

    public d(int i, String str, String str2, HashMap<String, String> hashMap, long j) {
        this.b = i;
        EventEntity eventEntity = new EventEntity();
        eventEntity.sid = a.f;
        eventEntity.idString = str;
        eventEntity.labelString = str2;
        eventEntity.udMap = hashMap;
        eventEntity.durationLong = j;
        eventEntity.startTp = System.currentTimeMillis();
        if (a.J && l.b(a.I)) {
            eventEntity.uid = a.I;
        }
        this.a = eventEntity;
    }

    public void run() {
        try {
            if (a(this.a.idString, this.a.labelString, this.a.udMap, this.a.durationLong).booleanValue()) {
                if (TextUtils.isEmpty(a.f)) {
                    j.c("Collector", "Can't call onEvent before onResume");
                    return;
                }
                switch (this.b) {
                    case 0:
                        a();
                        return;
                    case 1:
                        b();
                        return;
                    case 2:
                        c();
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            j.d("Collector", "call onEvent error:" + e);
        }
    }

    private void a() {
        e.c(this.a);
    }

    private void b() {
        e.a(this.a);
    }

    private void c() {
        e.b(this.a);
    }

    private Boolean a(String str, String str2, HashMap<String, String> hashMap, long j) {
        try {
            if (TextUtils.isEmpty(str)) {
                j.c("Collector", "invalid event id");
                return false;
            }
            if (c.a(str, a.u)) {
                if (str.getBytes().length != 0) {
                    if (str2 == null || c.a(str2, a.u)) {
                        if (hashMap != null) {
                            if (hashMap.size() > a.v) {
                                j.c("Collector", "invalid event map, size large than " + a.v);
                                return false;
                            }
                            for (Map.Entry next : hashMap.entrySet()) {
                                if (c.a((String) next.getKey(), a.u)) {
                                    if (!c.a((String) next.getValue(), a.u)) {
                                    }
                                }
                                j.c("Collector", "invalid event map " + String.format("invalid key:<%s> or value:<%s> ", new Object[]{next.getKey(), next.getValue()}));
                                return false;
                            }
                        }
                        return true;
                    }
                    j.c("Collector", "invalid event label");
                    return false;
                }
            }
            j.c("Collector", "invalid event id");
            return false;
        } catch (Exception e) {
            j.c("Collector", "invalid event param" + e);
            return false;
        }
    }
}
