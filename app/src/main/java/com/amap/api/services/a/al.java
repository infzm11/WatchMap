package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.q;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: BusLineSearchCore */
public class al implements IBusLineSearch {
    private Context a;
    /* access modifiers changed from: private */
    public BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    /* access modifiers changed from: private */
    public Handler g = null;

    public al(Context context, BusLineQuery busLineQuery) {
        this.a = context.getApplicationContext();
        this.c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.clone();
        }
        this.g = q.a();
    }

    public BusLineResult searchBusLine() throws AMapException {
        try {
            o.a(this.a);
            if (this.d != null) {
                if (a()) {
                    if (!this.c.weakEquals(this.d)) {
                        this.d = this.c.clone();
                        this.e = 0;
                        if (this.f != null) {
                            this.f.clear();
                        }
                    }
                    if (this.e == 0) {
                        BusLineResult busLineResult = (BusLineResult) new d(this.a, this.c.clone()).c();
                        a(busLineResult);
                        return busLineResult;
                    }
                    BusLineResult b2 = b(this.c.getPageNumber());
                    if (b2 != null) {
                        return b2;
                    }
                    BusLineResult busLineResult2 = (BusLineResult) new d(this.a, this.c).c();
                    this.f.set(this.c.getPageNumber(), busLineResult2);
                    return busLineResult2;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            i.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    private void a(BusLineResult busLineResult) {
        this.f = new ArrayList<>();
        for (int i = 0; i < this.e; i++) {
            this.f.add((Object) null);
        }
        if (this.e >= 0 && a(this.c.getPageNumber())) {
            this.f.set(this.c.getPageNumber(), busLineResult);
        }
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    public void searchBusLineAsyn() {
        try {
            new Thread(new Runnable() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        q.a aVar = new q.a();
                        obtainMessage.obj = aVar;
                        aVar.b = al.this.b;
                        aVar.a = al.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        al.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    al.this.g.sendMessage(obtainMessage);
                }
            }).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.c.weakEquals(busLineQuery)) {
            this.c = busLineQuery;
            this.d = busLineQuery.clone();
        }
    }

    public BusLineQuery getQuery() {
        return this.c;
    }

    private boolean a() {
        if (this.c == null) {
            return false;
        }
        return !i.a(this.c.getQueryString());
    }
}
