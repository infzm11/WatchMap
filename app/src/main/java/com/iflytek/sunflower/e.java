package com.iflytek.sunflower;

import com.iflytek.sunflower.entity.BootEntity;
import com.iflytek.sunflower.entity.CloseEntity;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.entity.EventEntity;
import com.iflytek.sunflower.entity.PageEntity;
import com.iflytek.sunflower.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class e {
    public static Stack<PageEntity> a = new Stack<>();
    public static ArrayList<PageEntity> b = new ArrayList<>();
    public static Object c = new Object();
    private static ArrayList<BootEntity> d = new ArrayList<>();
    private static ArrayList<EventEntity> e = new ArrayList<>();
    private static HashMap<String, EventEntity> f = new HashMap<>();
    private static ArrayList<CloseEntity> g = new ArrayList<>();
    private static ArrayList<ErrorEntity> h = new ArrayList<>();

    public static void a(EventEntity eventEntity) {
        f.put(eventEntity.idString, eventEntity);
    }

    public static void b(EventEntity eventEntity) {
        if (f.containsKey(eventEntity.idString)) {
            EventEntity eventEntity2 = f.get(eventEntity.idString);
            eventEntity2.durationLong = eventEntity.startTp - eventEntity2.startTp;
            c(eventEntity2);
            f.remove(eventEntity.idString);
            return;
        }
        j.a("Collector", "Call onEventEnd before onEventBegin");
    }

    public static void a(BootEntity bootEntity) {
        d.add(bootEntity);
    }

    public static void c(EventEntity eventEntity) {
        synchronized (c) {
            try {
                j.b("Collector", "Add an event:" + d.a(eventEntity).toString());
            } catch (Throwable th) {
                j.a("Collector", "Add an event error", th);
            }
            e.add(eventEntity);
        }
    }

    public static void a(CloseEntity closeEntity) {
        g.add(closeEntity);
    }

    public static void a(ErrorEntity errorEntity) {
        h.add(errorEntity);
    }

    public static void a(PageEntity pageEntity) {
        b.add(pageEntity);
    }

    public static ArrayList<EventEntity> a() {
        return e;
    }

    public static ArrayList<ErrorEntity> b() {
        return h;
    }

    public static ArrayList<BootEntity> c() {
        return d;
    }

    public static ArrayList<CloseEntity> d() {
        return g;
    }

    public static void e() {
        synchronized (c) {
            e.clear();
        }
    }

    public static void f() {
        h.clear();
    }

    public static void g() {
        b.clear();
    }

    public static void h() {
        d.clear();
    }

    public static void i() {
        g.clear();
    }

    public static void j() {
        e();
        f();
        h();
        i();
    }

    public static int k() {
        return 0 + d.size() + g.size() + e.size() + h.size();
    }
}
