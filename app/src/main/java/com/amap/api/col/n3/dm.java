package com.amap.api.col.n3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LruCache */
public class dm<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* access modifiers changed from: protected */
    public int b(V v) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void b(K k, V v) {
    }

    public dm(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V a(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.f++;
                return v;
            }
            this.g++;
            return null;
        }
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            b(k, put);
        }
        a(this.c);
        return put;
    }

    private void a(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.b >= 0 && this.a.isEmpty()) {
                    int i2 = this.b;
                }
                if (this.b > i) {
                    Map.Entry entry = null;
                    Iterator<Map.Entry<K, V>> it = this.a.entrySet().iterator();
                    while (it.hasNext()) {
                        entry = it.next();
                    }
                    if (entry != null) {
                        key = entry.getKey();
                        value = entry.getValue();
                        this.a.remove(key);
                        this.b -= c(key, value);
                        this.e++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(key, value);
        }
    }

    private int c(K k, V v) {
        int b2 = b(v);
        if (b2 >= 0) {
            return b2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void a() {
        a(-1);
    }

    public final synchronized String toString() {
        int i;
        i = this.f + this.g;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i != 0 ? (100 * this.f) / i : 0)});
    }
}
