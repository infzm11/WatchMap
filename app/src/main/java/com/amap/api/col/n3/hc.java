package com.amap.api.col.n3;

/* compiled from: ServiceSettings */
public final class hc {
    private static hc c;
    private String a = "zh-CN";
    private int b = 1;
    private int d = 20000;
    private int e = 20000;

    private hc() {
    }

    public static hc a() {
        if (c == null) {
            c = new hc();
        }
        return c;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }
}
