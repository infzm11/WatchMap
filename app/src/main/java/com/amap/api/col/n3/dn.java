package com.amap.api.col.n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* compiled from: NativeBufferPool */
public final class dn extends ec<a> {
    private a b;

    /* compiled from: NativeBufferPool */
    static final class a extends eb<a> {
        ByteBuffer a;
        ShortBuffer b;
        FloatBuffer c;
        IntBuffer d;
        int e;

        a() {
        }
    }

    private a b(int i) {
        a aVar = (a) this.a;
        if (aVar == null) {
            aVar = new a();
        } else {
            this.a = aVar.f;
            aVar.f = null;
        }
        if (aVar.e < i) {
            if (i < 32768) {
                i = 32768;
            }
            aVar.a = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            aVar.e = i;
            aVar.b = null;
            aVar.d = null;
            aVar.c = null;
        }
        T t = this.b;
        if (aVar.f != null) {
            throw new IllegalArgumentException("'item' is a list");
        }
        aVar.f = t;
        this.b = aVar;
        return aVar;
    }

    public final void a() {
        a(this.b);
        this.b = null;
    }

    public final ShortBuffer b() {
        a b2 = b(60000);
        if (b2.b == null) {
            b2.a.clear();
            b2.b = b2.a.asShortBuffer();
        } else {
            b2.b.clear();
        }
        return b2.b;
    }

    public final FloatBuffer a(int i) {
        a b2 = b(i * 4);
        if (b2.c == null) {
            b2.a.clear();
            b2.c = b2.a.asFloatBuffer();
        } else {
            b2.c.clear();
        }
        b2.c.clear();
        return b2.c;
    }
}
