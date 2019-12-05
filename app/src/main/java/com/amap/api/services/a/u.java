package com.amap.api.services.a;

import android.content.Context;

/* compiled from: PoiHandler */
abstract class u<T, V> extends b<T, V> {
    public u(Context context, T t) {
        super(context, t);
    }

    /* access modifiers changed from: protected */
    public boolean e(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
