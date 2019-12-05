package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.a.q;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: PoiSearchCore */
public class as implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;
    private PoiSearch.SearchBound a;
    private PoiSearch.Query b;
    private Context c;
    /* access modifiers changed from: private */
    public PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    /* access modifiers changed from: private */
    public Handler j = null;

    public as(Context context, PoiSearch.Query query) {
        this.c = context.getApplicationContext();
        setQuery(query);
        this.j = q.a();
    }

    public void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    public String getLanguage() {
        return this.e;
    }

    private boolean a() {
        if (this.b == null) {
            return false;
        }
        if (!i.a(this.b.getQueryString()) || !i.a(this.b.getCategory())) {
            return true;
        }
        return false;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null && bound.getShape().equals("Bound")) {
            return true;
        }
        return false;
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            if (bound.getCenter() == null) {
                return false;
            }
            return true;
        } else if (bound.getShape().equals("Polygon")) {
            List<LatLonPoint> polyGonList = bound.getPolyGonList();
            for (int i2 = 0; i2 < polyGonList.size(); i2++) {
                if (polyGonList.get(i2) == null) {
                    return false;
                }
            }
            return true;
        } else if (!bound.getShape().equals("Rectangle")) {
            return true;
        } else {
            LatLonPoint lowerLeft = bound.getLowerLeft();
            LatLonPoint upperRight = bound.getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
            return true;
        }
    }

    public PoiResult searchPOI() throws AMapException {
        try {
            o.a(this.c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (!c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (this.b == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                if ((!this.b.queryEquals(this.f) && this.a == null) || (!this.b.queryEquals(this.f) && !this.a.equals(this.g))) {
                    this.h = 0;
                    this.f = this.b.clone();
                    if (this.a != null) {
                        this.g = this.a.clone();
                    }
                    if (i != null) {
                        i.clear();
                    }
                }
                PoiSearch.SearchBound searchBound = null;
                if (this.a != null) {
                    searchBound = this.a.clone();
                }
                if (this.h == 0) {
                    PoiResult poiResult = (PoiResult) new w(this.c, new z(this.b.clone(), searchBound)).c();
                    a(poiResult);
                    return poiResult;
                }
                PoiResult a2 = a(this.b.getPageNum());
                if (a2 != null) {
                    return a2;
                }
                PoiResult poiResult2 = (PoiResult) new w(this.c, new z(this.b.clone(), searchBound)).c();
                i.put(Integer.valueOf(this.b.getPageNum()), poiResult2);
                return poiResult2;
            }
        } catch (AMapException e2) {
            i.a(e2, "PoiSearch", "searchPOI");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    public void searchPOIAsyn() {
        try {
            new Thread() {
                public void run() {
                    PoiResult poiResult;
                    AMapException e;
                    q.h hVar;
                    Message obtainMessage = as.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    try {
                        poiResult = as.this.searchPOI();
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            hVar = new q.h();
                        } catch (AMapException e2) {
                            e = e2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                hVar = new q.h();
                                hVar.b = as.this.d;
                                hVar.a = poiResult;
                                obtainMessage.obj = hVar;
                                obtainMessage.setData(bundle);
                                as.this.j.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                q.h hVar2 = new q.h();
                                hVar2.b = as.this.d;
                                hVar2.a = poiResult;
                                obtainMessage.obj = hVar2;
                                obtainMessage.setData(bundle);
                                as.this.j.sendMessage(obtainMessage);
                                throw th;
                            }
                        }
                    } catch (AMapException e3) {
                        AMapException aMapException = e3;
                        poiResult = null;
                        e = aMapException;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        hVar = new q.h();
                        hVar.b = as.this.d;
                        hVar.a = poiResult;
                        obtainMessage.obj = hVar;
                        obtainMessage.setData(bundle);
                        as.this.j.sendMessage(obtainMessage);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        poiResult = null;
                        th = th3;
                        q.h hVar22 = new q.h();
                        hVar22.b = as.this.d;
                        hVar22.a = poiResult;
                        obtainMessage.obj = hVar22;
                        obtainMessage.setData(bundle);
                        as.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                    hVar.b = as.this.d;
                    hVar.a = poiResult;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    as.this.j.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        o.a(this.c);
        return (PoiItem) new v(this.c, str).c();
    }

    public void searchPOIIdAsyn(final String str) {
        new Thread() {
            public void run() {
                Message obtainMessage = q.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    PoiItem searchPOIId = as.this.searchPOIId(str);
                    try {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                        q.g gVar = new q.g();
                        gVar.b = as.this.d;
                        gVar.a = searchPOIId;
                        obtainMessage.obj = gVar;
                    } catch (AMapException e) {
                        PoiItem poiItem2 = searchPOIId;
                        e = e;
                        poiItem = poiItem2;
                        try {
                            i.a(e, "PoiSearch", "searchPOIIdAsyn");
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            q.g gVar2 = new q.g();
                            gVar2.b = as.this.d;
                            gVar2.a = poiItem;
                            obtainMessage.obj = gVar2;
                            obtainMessage.setData(bundle);
                            as.this.j.sendMessage(obtainMessage);
                        } catch (Throwable th) {
                            th = th;
                            q.g gVar3 = new q.g();
                            gVar3.b = as.this.d;
                            gVar3.a = poiItem;
                            obtainMessage.obj = gVar3;
                            obtainMessage.setData(bundle);
                            as.this.j.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        PoiItem poiItem3 = searchPOIId;
                        th = th2;
                        poiItem = poiItem3;
                        q.g gVar32 = new q.g();
                        gVar32.b = as.this.d;
                        gVar32.a = poiItem;
                        obtainMessage.obj = gVar32;
                        obtainMessage.setData(bundle);
                        as.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                } catch (AMapException e2) {
                    e = e2;
                    i.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    q.g gVar22 = new q.g();
                    gVar22.b = as.this.d;
                    gVar22.a = poiItem;
                    obtainMessage.obj = gVar22;
                    obtainMessage.setData(bundle);
                    as.this.j.sendMessage(obtainMessage);
                }
                obtainMessage.setData(bundle);
                as.this.j.sendMessage(obtainMessage);
            }
        }.start();
    }

    public void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    public void setBound(PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    public PoiSearch.Query getQuery() {
        return this.b;
    }

    public PoiSearch.SearchBound getBound() {
        return this.a;
    }

    private void a(PoiResult poiResult) {
        i = new HashMap<>();
        if (this.b != null && poiResult != null && this.h > 0 && this.h > this.b.getPageNum()) {
            i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
        }
    }

    /* access modifiers changed from: protected */
    public PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }
}
