package com.loc;

/* compiled from: HashCodeBuilder */
public final class v {
    private final int a;
    private int b;

    public v() {
        this.b = 0;
        this.a = 37;
        this.b = 17;
    }

    private v a(long j) {
        this.b = (this.b * this.a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public final int a() {
        return this.b;
    }

    public final v a(Object obj) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr != null) {
                        while (i < jArr.length) {
                            a(jArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            this.b = (this.b * this.a) + iArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    if (sArr != null) {
                        while (i < sArr.length) {
                            this.b = (this.b * this.a) + sArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    if (cArr != null) {
                        while (i < cArr.length) {
                            this.b = (this.b * this.a) + cArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr != null) {
                        while (i < bArr.length) {
                            this.b = (this.b * this.a) + bArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr != null) {
                        while (i < dArr.length) {
                            a(Double.doubleToLongBits(dArr[i]));
                            i++;
                        }
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr != null) {
                        while (i < fArr.length) {
                            this.b = (this.b * this.a) + Float.floatToIntBits(fArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    if (zArr != null) {
                        while (i < zArr.length) {
                            this.b = (this.b * this.a) + (zArr[i] ^ true ? 1 : 0);
                            i++;
                        }
                    }
                } else {
                    a((Object[]) obj);
                    return this;
                }
            } else {
                this.b = (this.b * this.a) + obj.hashCode();
            }
            return this;
        }
        this.b *= this.a;
        return this;
    }

    public final v a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.a;
            return this;
        }
        for (Object a2 : objArr) {
            a(a2);
        }
        return this;
    }

    public final int hashCode() {
        return this.b;
    }
}
