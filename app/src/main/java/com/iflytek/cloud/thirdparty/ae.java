package com.iflytek.cloud.thirdparty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ae {
    private static ae a;
    private Map<String, a> b = new HashMap();
    private String c = "";

    public static class a {
        public Long a;
        public Long b;
        public String c;
        public Map<String, List<ad>> d;
        /* access modifiers changed from: private */
        public float e;

        public a() {
        }

        public a(Long l, Long l2, String str, Map<String, List<ad>> map) {
            this.a = l;
            this.b = l2;
            this.c = str;
            this.d = map;
        }
    }

    private ae() {
    }

    public static ae a() {
        if (a == null) {
            a = new ae();
        }
        return a;
    }

    public Long a(String str) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    public void a(String str, float f) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            float unused = aVar.e = f;
        }
    }

    public void a(String str, long j) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            aVar.b = Long.valueOf(j);
        }
    }

    public void a(String str, a aVar) {
        this.b.put(str, aVar);
    }

    public synchronized void a(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            aVar.c = str2;
        }
    }

    public void a(String str, String str2, ad adVar) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            Map<String, List<ad>> map = aVar.d;
            if (map != null) {
                List list = map.get(str2);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(adVar);
                map.put(str2, list);
            }
        }
    }

    public Long b(String str) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.b;
    }

    public List<ad> b(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return null;
        }
        Map<String, List<ad>> map = aVar.d;
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public void b() {
        this.b.clear();
        this.c = "";
    }

    public float c(String str) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return 0.0f;
        }
        return aVar.e;
    }

    public ad c(String str, String str2) {
        List<ad> b2 = b(str, str2);
        if (b2 == null) {
            return null;
        }
        return b2.get(b2.size() - 1);
    }

    public boolean c() {
        a aVar = this.b.get(this.c);
        return (aVar == null || aVar.d == null || aVar.d.size() != 0) ? false : true;
    }

    public String d(String str) {
        a aVar = this.b.get(str);
        return aVar == null ? "" : aVar.c;
    }

    public boolean d(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return false;
        }
        Map<String, List<ad>> map = aVar.d;
        if (map != null) {
            List<ad> list = map.get(str2);
            if (list != null) {
                for (ad f : list) {
                    if (f.f()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean e(String str) {
        return this.b.containsKey(str);
    }

    public void f(String str) {
        this.b.remove(str);
    }
}
