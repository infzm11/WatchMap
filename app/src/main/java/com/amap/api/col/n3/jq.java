package com.amap.api.col.n3;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseLoader */
abstract class jq extends ClassLoader {
    protected final Context a;
    protected final Map<String, Class<?>> b = new HashMap();
    protected DexFile c = null;
    volatile boolean d = true;
    protected im e;
    protected String f;

    public jq(Context context, im imVar) {
        super(context.getClassLoader());
        this.a = context;
        this.e = imVar;
    }

    public final boolean a() {
        return this.c != null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        com.amap.api.col.n3.ir.a(r0, "BaseLoader", "releaseDexFile()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            java.util.Map<java.lang.String, java.lang.Class<?>> r0 = r3.b     // Catch:{ Throwable -> 0x0016 }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x0016 }
            java.util.Map<java.lang.String, java.lang.Class<?>> r1 = r3.b     // Catch:{ all -> 0x0013 }
            r1.clear()     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            dalvik.system.DexFile r0 = r3.c     // Catch:{ Throwable -> 0x0016 }
            if (r0 == 0) goto L_0x0012
            dalvik.system.DexFile r0 = r3.c     // Catch:{ Throwable -> 0x0016 }
            r0.close()     // Catch:{ Throwable -> 0x0016 }
        L_0x0012:
            return
        L_0x0013:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x0016 }
            throw r1     // Catch:{ Throwable -> 0x0016 }
        L_0x0016:
            r0 = move-exception
            java.lang.String r1 = "BaseLoader"
            java.lang.String r2 = "releaseDexFile()"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jq.b():void");
    }
}
