package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.q;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: BusStationSearchCore */
public class am implements IBusStationSearch {
    private Context a;
    /* access modifiers changed from: private */
    public BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    /* access modifiers changed from: private */
    public Handler g;

    public am(Context context, BusStationQuery busStationQuery) {
        this.a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = q.a();
    }

    public BusStationResult searchBusStation() throws AMapException {
        try {
            o.a(this.a);
            if (!a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.clone();
                this.f = 0;
                if (this.e != null) {
                    this.e.clear();
                }
            }
            if (this.f == 0) {
                BusStationResult busStationResult = (BusStationResult) new d(this.a, this.c).c();
                this.f = busStationResult.getPageCount();
                a(busStationResult);
                return busStationResult;
            }
            BusStationResult b2 = b(this.c.getPageNumber());
            if (b2 != null) {
                return b2;
            }
            BusStationResult busStationResult2 = (BusStationResult) new d(this.a, this.c).c();
            this.e.set(this.c.getPageNumber(), busStationResult2);
            return busStationResult2;
        } catch (AMapException e2) {
            i.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    private void a(BusStationResult busStationResult) {
        this.e = new ArrayList<>();
        for (int i = 0; i <= this.f; i++) {
            this.e.add((Object) null);
        }
        if (this.f > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    public void searchBusStationAsyn() {
        try {
            new Thread(new Runnable() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        q.b bVar = new q.b();
                        bVar.b = am.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = am.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        am.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    am.this.g.sendMessage(obtainMessage);
                }
            }).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.c)) {
            this.c = busStationQuery;
        }
    }

    public BusStationQuery getQuery() {
        return this.c;
    }

    private boolean a() {
        if (this.c == null) {
            return false;
        }
        return !i.a(this.c.getQueryString());
    }
}
