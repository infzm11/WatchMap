package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.col.n3.ie;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProtocalHandler */
public abstract class bn<T, V> {
    protected T a;
    protected int b = 3;
    protected Context c;

    /* access modifiers changed from: protected */
    public abstract V a(JSONObject jSONObject) throws AMapException;

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract JSONObject a(ie.a aVar);

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    public bn(Context context, T t) {
        this.c = context;
        this.a = t;
    }

    public final V c() throws AMapException {
        if (this.a != null) {
            return d();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V d() throws com.amap.api.maps.AMapException {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r2
        L_0x0004:
            int r4 = r9.b
            if (r1 >= r4) goto L_0x0053
            android.content.Context r4 = r9.c     // Catch:{ Throwable -> 0x0032 }
            com.amap.api.col.n3.im r5 = com.amap.api.col.n3.dv.f()     // Catch:{ Throwable -> 0x0032 }
            java.lang.String r6 = r9.a()     // Catch:{ Throwable -> 0x0032 }
            java.util.Map r7 = r9.b()     // Catch:{ Throwable -> 0x0032 }
            com.amap.api.col.n3.ie$a r4 = com.amap.api.col.n3.ie.a(r4, r5, r6, r7)     // Catch:{ Throwable -> 0x0032 }
            org.json.JSONObject r3 = r9.a((com.amap.api.col.n3.ie.a) r4)     // Catch:{ Throwable -> 0x002d }
            java.lang.Object r3 = r9.a((org.json.JSONObject) r3)     // Catch:{ Throwable -> 0x002d }
            int r2 = r9.b     // Catch:{ Throwable -> 0x0028 }
            r1 = r2
            r2 = r3
            r3 = r4
            goto L_0x0004
        L_0x0028:
            r2 = move-exception
            r8 = r4
            r4 = r2
            r2 = r3
            goto L_0x0030
        L_0x002d:
            r3 = move-exception
            r8 = r4
            r4 = r3
        L_0x0030:
            r3 = r8
            goto L_0x0033
        L_0x0032:
            r4 = move-exception
        L_0x0033:
            java.lang.String r5 = "ProtocalHandler"
            java.lang.String r6 = "getDataMayThrow AMapException"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r6)
            r4.printStackTrace()
            int r1 = r1 + 1
            int r4 = r9.b
            if (r1 < r4) goto L_0x0004
            if (r3 == 0) goto L_0x0051
            java.lang.String r2 = r3.a
            if (r2 == 0) goto L_0x0051
            com.amap.api.maps.AMapException r0 = new com.amap.api.maps.AMapException
            java.lang.String r1 = r3.a
            r0.<init>(r1)
            throw r0
        L_0x0051:
            r2 = r0
            goto L_0x0004
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bn.d():java.lang.Object");
    }
}
