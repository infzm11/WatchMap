package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.a.q;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: RoutePOISearchCore */
public class at implements IRoutePOISearch {
    private RoutePOISearchQuery a;
    private Context b;
    /* access modifiers changed from: private */
    public RoutePOISearch.OnRoutePOISearchListener c;
    /* access modifiers changed from: private */
    public Handler d = null;

    public at(Context context, RoutePOISearchQuery routePOISearchQuery) {
        this.b = context;
        this.a = routePOISearchQuery;
        this.d = q.a();
    }

    public void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    public void searchRoutePOIAsyn() {
        new Thread() {
            public void run() {
                RoutePOISearchResult routePOISearchResult;
                AMapException e;
                q.j jVar;
                Message obtainMessage = at.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                try {
                    routePOISearchResult = at.this.searchRoutePOI();
                    try {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                        jVar = new q.j();
                    } catch (AMapException e2) {
                        e = e2;
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            jVar = new q.j();
                            jVar.b = at.this.c;
                            jVar.a = routePOISearchResult;
                            obtainMessage.obj = jVar;
                            obtainMessage.setData(bundle);
                            at.this.d.sendMessage(obtainMessage);
                        } catch (Throwable th) {
                            th = th;
                            q.j jVar2 = new q.j();
                            jVar2.b = at.this.c;
                            jVar2.a = routePOISearchResult;
                            obtainMessage.obj = jVar2;
                            obtainMessage.setData(bundle);
                            at.this.d.sendMessage(obtainMessage);
                            throw th;
                        }
                    }
                } catch (AMapException e3) {
                    AMapException aMapException = e3;
                    routePOISearchResult = null;
                    e = aMapException;
                    bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    jVar = new q.j();
                    jVar.b = at.this.c;
                    jVar.a = routePOISearchResult;
                    obtainMessage.obj = jVar;
                    obtainMessage.setData(bundle);
                    at.this.d.sendMessage(obtainMessage);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    routePOISearchResult = null;
                    th = th3;
                    q.j jVar22 = new q.j();
                    jVar22.b = at.this.c;
                    jVar22.a = routePOISearchResult;
                    obtainMessage.obj = jVar22;
                    obtainMessage.setData(bundle);
                    at.this.d.sendMessage(obtainMessage);
                    throw th;
                }
                jVar.b = at.this.c;
                jVar.a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                at.this.d.sendMessage(obtainMessage);
            }
        }.start();
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.a = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.a;
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            o.a(this.b);
            if (!a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return (RoutePOISearchResult) new ad(this.b, this.a.clone()).c();
        } catch (AMapException e) {
            i.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    private boolean a() {
        if (this.a == null || this.a.getSearchType() == null) {
            return false;
        }
        if (this.a.getFrom() == null && this.a.getTo() == null && this.a.getPolylines() == null) {
            return false;
        }
        return true;
    }
}
