package com.amap.api.col.n3;

import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: AuthRequest */
final class io extends kj {
    private Map<String, String> a = new HashMap();
    private String b;
    private Map<String, String> c = new HashMap();

    io() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Map<String, String> map) {
        this.a.clear();
        this.a.putAll(map);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.b = str;
    }

    /* access modifiers changed from: package-private */
    public final void b(Map<String, String> map) {
        this.c.clear();
        this.c.putAll(map);
    }

    public final String c() {
        return this.b;
    }

    public final Map<String, String> a() {
        return this.a;
    }

    public final Map<String, String> b() {
        return this.c;
    }
}
