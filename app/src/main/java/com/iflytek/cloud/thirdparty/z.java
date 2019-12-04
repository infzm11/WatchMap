package com.iflytek.cloud.thirdparty;

import java.util.concurrent.ConcurrentLinkedQueue;

public class z {
    private int a;
    private long b;
    private ConcurrentLinkedQueue<byte[]> c;
    private a d;

    class a {
        private int b;
        private int c;
        private byte[] d;

        public a(int i) {
            this.b = i;
            this.d = new byte[i];
        }

        public int a() {
            return this.b - this.c;
        }

        public int a(byte[] bArr, int i) {
            if (bArr == null || i < 0 || i >= bArr.length) {
                return -1;
            }
            int length = bArr.length - i;
            int a2 = a();
            if (length > a2) {
                length = a2;
            }
            System.arraycopy(bArr, i, this.d, this.c, length);
            this.c += length;
            return i + length;
        }

        public boolean b() {
            return this.c == this.b;
        }

        public byte[] c() {
            return this.d;
        }

        public void d() {
            this.d = new byte[this.b];
            this.c = 0;
        }
    }

    public z() {
        this.a = 320;
        this.b = 0;
        this.c = new ConcurrentLinkedQueue<>();
        this.d = new a(this.a);
    }

    public z(int i) {
        this.a = 320;
        this.b = 0;
        this.c = new ConcurrentLinkedQueue<>();
        this.a = i;
        this.d = new a(this.a);
    }

    public void a() {
        this.c.clear();
        this.b = 0;
    }

    public void a(byte[] bArr, int i) {
        int i2 = 0;
        while (i2 != i) {
            i2 = this.d.a(bArr, i2);
            if (this.d.b()) {
                this.c.add(this.d.c());
                this.d.d();
            }
        }
        this.b += (long) i;
    }

    public byte[] a(int i) {
        if (i > this.c.size()) {
            i = this.c.size();
        }
        if (i == 0) {
            return null;
        }
        a aVar = new a(this.a * i);
        for (int i2 = 0; i2 < i; i2++) {
            aVar.a(this.c.poll(), 0);
        }
        return aVar.c();
    }
}
