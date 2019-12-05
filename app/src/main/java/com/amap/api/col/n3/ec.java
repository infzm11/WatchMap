package com.amap.api.col.n3;

import com.amap.api.col.n3.eb;

/* compiled from: Pool */
public abstract class ec<T extends eb<?>> {
    protected T a;

    public final T a(T t) {
        if (t == null) {
            return null;
        }
        while (t != null) {
            T t2 = t.f;
            t.f = this.a;
            this.a = t;
            t = t2;
        }
        return null;
    }
}
