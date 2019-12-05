package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.navi.IGpsCallback;

/* compiled from: InternalLocation */
public final class fd {
    public el a = null;
    /* access modifiers changed from: private */
    public IGpsCallback b;

    public fd(Context context) {
        this.a = new el(context);
    }

    public final void a(IGpsCallback iGpsCallback) {
        this.b = iGpsCallback;
    }
}
