package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.n3.gn;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore */
public final class gq {
    private Context a;
    /* access modifiers changed from: private */
    public gn.a b;
    /* access modifiers changed from: private */
    public Handler c = gt.a();
    /* access modifiers changed from: private */
    public gp d;

    public gq(Context context, gp gpVar) {
        this.a = context.getApplicationContext();
        this.d = gpVar;
    }

    public final void a(gn.a aVar) {
        this.b = aVar;
    }

    /* access modifiers changed from: private */
    public ArrayList<he> a(gp gpVar) throws gh {
        if (gpVar == null) {
            try {
                throw new gh("无效的参数 - IllegalArgumentException");
            } catch (Throwable unused) {
                return null;
            }
        } else {
            if (gpVar.a() != null) {
                if (!gpVar.a().equals("")) {
                    return (ArrayList) new go(this.a, gpVar).d();
                }
            }
            throw new gh("无效的参数 - IllegalArgumentException");
        }
    }
}
