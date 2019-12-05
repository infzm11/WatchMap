package com.amap.api.col.n3;

/* compiled from: IntArray */
public final class dl {
    public int[] a;
    public int b;
    public boolean c;

    public final int hashCode() {
        return 42;
    }

    public dl() {
        this((byte) 0);
    }

    private dl(byte b2) {
        this.c = true;
        this.a = new int[16];
    }

    public final void a(int i) {
        int[] iArr = this.a;
        if (this.b == iArr.length) {
            iArr = c(Math.max(8, (int) (((float) this.b) * 1.75f)));
        }
        int i2 = this.b;
        this.b = i2 + 1;
        iArr[i2] = i;
    }

    public final int[] b(int i) {
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            c(Math.max(8, i2));
        }
        return this.a;
    }

    private int[] c(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.a, 0, iArr, 0, Math.min(this.b, iArr.length));
        this.a = iArr;
        return iArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dl)) {
            return false;
        }
        dl dlVar = (dl) obj;
        int i = this.b;
        if (i != dlVar.b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.a[i2] != dlVar.a[i2]) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        if (this.b == 0) {
            return "[]";
        }
        int[] iArr = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(iArr[0]);
        for (int i = 1; i < this.b; i++) {
            sb.append(", ");
            sb.append(iArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
