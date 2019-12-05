package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.amap.api.services.a.q;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: GeocodeSearchCore */
public final class ap implements IGeocodeSearch {
    private Context a;
    /* access modifiers changed from: private */
    public GeocodeSearch.OnGeocodeSearchListener b;
    /* access modifiers changed from: private */
    public Handler c = q.a();

    public ap(Context context) {
        this.a = context.getApplicationContext();
    }

    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            o.a(this.a);
            if (a(regeocodeQuery)) {
                return (RegeocodeAddress) new aa(this.a, regeocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            o.a(this.a);
            if (geocodeQuery != null) {
                return (List) new l(this.a, geocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    public void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    public void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            new Thread(new Runnable() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        q.i iVar = new q.i();
                        iVar.b = ap.this.b;
                        obtainMessage.obj = iVar;
                        iVar.a = new RegeocodeResult(regeocodeQuery, ap.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ap.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ap.this.c.sendMessage(obtainMessage);
                }
            }).start();
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    public void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            new Thread(new Runnable() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.what = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        q.e eVar = new q.e();
                        eVar.b = ap.this.b;
                        obtainMessage.obj = eVar;
                        eVar.a = new GeocodeResult(geocodeQuery, ap.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ap.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ap.this.c.sendMessage(obtainMessage);
                }
            }).start();
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    private boolean a(RegeocodeQuery regeocodeQuery) {
        if (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) {
            return false;
        }
        return true;
    }
}
