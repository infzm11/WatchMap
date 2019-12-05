package com.amap.api.col.n3;

/* compiled from: IBounds */
public final class ah {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public ah(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i3;
        this.c = i2;
        this.d = i4;
        this.e = (i + i2) / 2;
        this.f = (i3 + i4) / 2;
    }

    public final boolean a(int i, int i2) {
        return this.a <= i && i <= this.c && this.b <= i2 && i2 <= this.d;
    }

    public final boolean a(ah ahVar) {
        if (ahVar == null) {
            return false;
        }
        return ahVar.a < this.c && this.a < ahVar.c && ahVar.b < this.d && this.b < ahVar.d;
    }
}
