package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.navi.IGpsCallback;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: GpsAdapter */
public final class ey {
    private fd a;

    public ey(Context context) {
        this.a = new fd(context);
    }

    public final void a(IGpsCallback iGpsCallback) {
        this.a.a(iGpsCallback);
    }

    public final void a() {
        fd fdVar = this.a;
        if (fdVar.a != null) {
            Inner_3dMap_locationOption inner_3dMap_locationOption = new Inner_3dMap_locationOption();
            inner_3dMap_locationOption.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            inner_3dMap_locationOption.setNeedAddress(false);
            inner_3dMap_locationOption.setInterval(1000);
            inner_3dMap_locationOption.setOffset(true);
            fdVar.a.a(inner_3dMap_locationOption);
            fdVar.a.a((Inner_3dMap_locationListener) new Inner_3dMap_locationListener() {
                public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
                    if (inner_3dMap_location == null) {
                        return;
                    }
                    if (inner_3dMap_location.getErrorCode() == 0) {
                        if (inner_3dMap_location.getLocationType() == 1 && fd.this.b != null) {
                            fd.this.b.onLocationChanged(2, inner_3dMap_location);
                        }
                        en.a(new NaviLatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude()));
                        return;
                    }
                    "定位失败," + inner_3dMap_location.getErrorCode() + ": " + inner_3dMap_location.getErrorInfo();
                }
            });
            fdVar.a.a();
        }
    }

    public final void a(long j) {
        fd fdVar = this.a;
        if (fdVar.a != null) {
            Inner_3dMap_locationOption inner_3dMap_locationOption = new Inner_3dMap_locationOption();
            inner_3dMap_locationOption.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            inner_3dMap_locationOption.setNeedAddress(false);
            inner_3dMap_locationOption.setInterval(j);
            inner_3dMap_locationOption.setOffset(true);
            fdVar.a.a(inner_3dMap_locationOption);
            fdVar.a.a((Inner_3dMap_locationListener) new Inner_3dMap_locationListener() {
                public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
                    if (inner_3dMap_location == null) {
                        return;
                    }
                    if (inner_3dMap_location.getErrorCode() == 0) {
                        if (inner_3dMap_location.getLocationType() == 1 && fd.this.b != null) {
                            fd.this.b.onLocationChanged(2, inner_3dMap_location);
                        }
                        en.a(new NaviLatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude()));
                        return;
                    }
                    "定位失败," + inner_3dMap_location.getErrorCode() + ": " + inner_3dMap_location.getErrorInfo();
                }
            });
            fdVar.a.a();
        }
    }

    public final void b() {
        fd fdVar = this.a;
        if (fdVar.a != null) {
            fdVar.a.b();
        }
    }

    public final void c() {
        fd fdVar = this.a;
        if (fdVar.a != null) {
            fdVar.a.c();
        }
    }
}
