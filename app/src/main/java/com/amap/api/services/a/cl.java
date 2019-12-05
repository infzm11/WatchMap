package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ClassLoaderFactory */
public class cl {
    private static final cl a = new cl();
    private final Map<String, ck> b = new HashMap();

    private cl() {
    }

    public static cl a() {
        return a;
    }

    /* access modifiers changed from: package-private */
    public synchronized ck a(Context context, bh bhVar) throws Exception {
        ck ckVar;
        if (a(bhVar)) {
            if (context != null) {
                String a2 = bhVar.a();
                ckVar = this.b.get(a2);
                if (ckVar == null) {
                    try {
                        co coVar = new co(context.getApplicationContext(), bhVar, true);
                        try {
                            this.b.put(a2, coVar);
                            cp.a(context, bhVar);
                        } catch (Throwable unused) {
                        }
                        ckVar = coVar;
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        throw new Exception("sdkInfo or context referance is null");
        return ckVar;
    }

    private boolean a(bh bhVar) {
        return bhVar != null && !TextUtils.isEmpty(bhVar.b()) && !TextUtils.isEmpty(bhVar.a());
    }
}
