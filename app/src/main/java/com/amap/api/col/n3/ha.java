package com.amap.api.col.n3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.n3.gt;
import com.amap.api.col.n3.gz;
import com.amap.api.maps.model.MyLocationStyle;

/* compiled from: PoiSearchCore */
public final class ha implements gl {
    private gz.b a;
    private Context b;
    /* access modifiers changed from: private */
    public gz.a c;
    private String d = "zh-CN";
    /* access modifiers changed from: private */
    public Handler e = null;

    public ha(Context context, gz.b bVar) {
        this.b = context.getApplicationContext();
        this.a = bVar;
        this.e = gt.a();
    }

    public final void a(gz.a aVar) {
        this.c = aVar;
    }

    public final gw a(String str) throws gh {
        return (gw) new hb(this.b, str).d();
    }

    public final void b(final String str) {
        new Thread() {
            public final void run() {
                try {
                    Message obtainMessage = gt.a().obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 602;
                    Bundle bundle = new Bundle();
                    gw gwVar = null;
                    try {
                        gw a2 = ha.this.a(str);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            gt.a aVar = new gt.a();
                            aVar.b = ha.this.c;
                            aVar.a = a2;
                            obtainMessage.obj = aVar;
                            obtainMessage.setData(bundle);
                            ha.this.e.sendMessage(obtainMessage);
                        } catch (gh e) {
                            gw gwVar2 = a2;
                            e = e;
                            gwVar = gwVar2;
                            try {
                                gk.a(e, "PoiSearch", "searchPOIIdAsyn");
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.b());
                                gt.a aVar2 = new gt.a();
                                aVar2.b = ha.this.c;
                                aVar2.a = gwVar;
                                obtainMessage.obj = aVar2;
                                obtainMessage.setData(bundle);
                                ha.this.e.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                gt.a aVar3 = new gt.a();
                                aVar3.b = ha.this.c;
                                aVar3.a = gwVar;
                                obtainMessage.obj = aVar3;
                                obtainMessage.setData(bundle);
                                ha.this.e.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            gw gwVar3 = a2;
                            th = th2;
                            gwVar = gwVar3;
                            gt.a aVar32 = new gt.a();
                            aVar32.b = ha.this.c;
                            aVar32.a = gwVar;
                            obtainMessage.obj = aVar32;
                            obtainMessage.setData(bundle);
                            ha.this.e.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (gh e2) {
                        e = e2;
                        gk.a(e, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.b());
                        gt.a aVar22 = new gt.a();
                        aVar22.b = ha.this.c;
                        aVar22.a = gwVar;
                        obtainMessage.obj = aVar22;
                        obtainMessage.setData(bundle);
                        ha.this.e.sendMessage(obtainMessage);
                    }
                } catch (Throwable unused) {
                }
            }
        }.start();
    }
}
