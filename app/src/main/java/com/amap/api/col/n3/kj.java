package com.amap.api.col.n3;

import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class kj {
    int f = 20000;
    int g = 20000;
    Proxy h = null;

    public abstract Map<String, String> a();

    public abstract Map<String, String> b();

    public abstract String c();

    public byte[] f() {
        return null;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void a(Proxy proxy) {
        this.h = proxy;
    }
}
