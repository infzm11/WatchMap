package com.iflytek.cloud.thirdparty;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class cz {
    protected Context a;
    private dg b;
    private String[] c = null;
    private String[] d = null;
    private HashMap<String, String> e = new HashMap<>();
    private HashMap<String, String> f = new HashMap<>();
    private List<dd> g = new ArrayList();
    private HashMap<String, String> h = new HashMap<>();

    public cz(Context context, dg dgVar) {
        this.b = dgVar;
        this.a = context;
    }

    private void b() {
        if (this.f.size() > 0) {
            this.f = null;
            this.f = new HashMap<>();
        }
        if (this.h.size() > 0) {
            this.h = null;
            this.h = new HashMap<>();
        }
        if (this.e.size() > 0) {
            this.e = null;
            this.e = new HashMap<>();
        }
        if (this.c != null && this.c.length > 0) {
            this.c = null;
        }
    }

    public String[] a() {
        b();
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> d2 = this.b.d();
        List<dd> e2 = this.b.e();
        for (String next : d2.keySet()) {
            String str = d2.get(next);
            HashMap<String, String> hashMap = this.e;
            hashMap.put(next + "p", str);
            arrayList.add(str);
            if (str.contains("\u0000")) {
                this.h.put(str.replace("\u0000", " "), str);
            }
        }
        for (dd next2 : e2) {
            String a2 = next2.a();
            String c2 = next2.c();
            String b2 = next2.b();
            HashMap<String, String> hashMap2 = this.f;
            hashMap2.put(a2 + "s", c2);
            HashMap<String, String> hashMap3 = this.e;
            hashMap3.put(a2 + "s", b2);
            arrayList.add(b2);
            if (b2.contains("\u0000")) {
                this.h.put(b2.replace("\u0000", " "), b2);
            }
            this.g.add(next2);
        }
        HashSet hashSet = new HashSet(arrayList);
        this.c = (String[]) hashSet.toArray(new String[hashSet.size()]);
        return this.c;
    }
}
