package com.iflytek.cloud.thirdparty;

public class y implements Cloneable {
    public byte[] a;
    public ce b = null;
    public int c;
    public int d;
    public int e;

    public y(byte[] bArr, ce ceVar) {
        this.a = bArr;
        this.b = ceVar == null ? new ce() : ceVar;
    }

    public y(byte[] bArr, String str) {
        this.a = bArr;
        this.b = ac.e(str);
    }

    public int a() {
        if (this.a == null) {
            return -1;
        }
        return this.a.length;
    }

    public void a(String str, String str2, boolean z) {
        this.b.a(str, str2, z);
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        y yVar;
        CloneNotSupportedException e2;
        try {
            yVar = (y) super.clone();
            try {
                yVar.a = (byte[]) this.a.clone();
                yVar.b = this.b.clone();
                yVar.c = this.c;
                yVar.d = this.d;
                yVar.e = this.e;
                return yVar;
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
                return yVar;
            }
        } catch (CloneNotSupportedException e4) {
            CloneNotSupportedException cloneNotSupportedException = e4;
            yVar = null;
            e2 = cloneNotSupportedException;
            e2.printStackTrace();
            return yVar;
        }
    }
}
