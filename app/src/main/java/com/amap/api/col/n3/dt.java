package com.amap.api.col.n3;

/* compiled from: ShortArray */
public final class dt {
    public short[] a;
    public int b;
    public boolean c;

    public final int hashCode() {
        return 42;
    }

    public dt() {
        this((byte) 0);
    }

    private dt(byte b2) {
        this.c = true;
        this.a = new short[16];
    }

    public final void a(short s) {
        short[] sArr = this.a;
        if (this.b == sArr.length) {
            sArr = c(Math.max(8, (int) (((float) this.b) * 1.75f)));
        }
        int i = this.b;
        this.b = i + 1;
        sArr[i] = s;
    }

    public final short a(int i) {
        if (i < this.b) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
    }

    public final short[] b(int i) {
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            c(Math.max(8, i2));
        }
        return this.a;
    }

    private short[] c(int i) {
        short[] sArr = new short[i];
        System.arraycopy(this.a, 0, sArr, 0, Math.min(this.b, sArr.length));
        this.a = sArr;
        return sArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dt)) {
            return false;
        }
        dt dtVar = (dt) obj;
        int i = this.b;
        if (i != dtVar.b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.a[i2] != dtVar.a[i2]) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        if (this.b == 0) {
            return "[]";
        }
        short[] sArr = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(sArr[0]);
        for (int i = 1; i < this.b; i++) {
            sb.append(", ");
            sb.append(sArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
