package com.amap.api.services.a;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseClassLoader */
abstract class ck extends ClassLoader {
    protected final Context a;
    protected final Map<String, Class<?>> b = new HashMap();
    protected DexFile c = null;
    volatile boolean d = true;
    protected bh e;
    protected String f;

    public ck(Context context, bh bhVar, boolean z) {
        super(context.getClassLoader());
        this.a = context;
        this.e = bhVar;
    }

    public boolean a() {
        return this.c != null;
    }

    /* access modifiers changed from: protected */
    public void b() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
            if (this.c != null) {
                this.c.close();
            }
        } catch (Throwable th) {
            cs.a(th, "BaseClassLoader", "releaseDexFile()");
        }
    }
}
