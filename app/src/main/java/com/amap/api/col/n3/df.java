package com.amap.api.col.n3;

/* compiled from: Bounds */
public final class df {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public df(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d4;
        this.c = d3;
        this.d = d5;
        this.e = (d2 + d3) / 2.0d;
        this.f = (d4 + d5) / 2.0d;
    }

    public final boolean a(double d2, double d3) {
        return this.a <= d2 && d2 <= this.c && this.b <= d3 && d3 <= this.d;
    }

    public final boolean a(df dfVar) {
        return dfVar.a < this.c && this.a < dfVar.c && dfVar.b < this.d && this.b < dfVar.d;
    }
}
