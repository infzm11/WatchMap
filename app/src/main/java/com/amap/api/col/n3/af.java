package com.amap.api.col.n3;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: AMapLocationSource */
public final class af implements LocationSource, Inner_3dMap_locationListener {
    boolean a = false;
    long b = 2000;
    private Bundle c = null;
    private LocationSource.OnLocationChangedListener d;
    private el e;
    private Inner_3dMap_locationOption f;
    private Context g;

    public af(Context context) {
        this.g = context;
    }

    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.d = onLocationChangedListener;
        if (this.e == null) {
            this.e = new el(this.g);
            this.f = new Inner_3dMap_locationOption();
            this.e.a((Inner_3dMap_locationListener) this);
            this.f.setInterval(this.b);
            this.f.setOnceLocation(this.a);
            this.f.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.e.a(this.f);
            this.e.a();
        }
    }

    public final void deactivate() {
        this.d = null;
        if (this.e != null) {
            this.e.b();
            this.e.c();
        }
        this.e = null;
    }

    public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.d != null && inner_3dMap_location != null && inner_3dMap_location != null) {
                this.c = inner_3dMap_location.getExtras();
                if (this.c == null) {
                    this.c = new Bundle();
                }
                this.c.putInt(MyLocationStyle.ERROR_CODE, inner_3dMap_location.getErrorCode());
                this.c.putString(MyLocationStyle.ERROR_INFO, inner_3dMap_location.getErrorInfo());
                this.c.putInt(MyLocationStyle.LOCATION_TYPE, inner_3dMap_location.getLocationType());
                this.c.putFloat("Accuracy", inner_3dMap_location.getAccuracy());
                this.c.putString("AdCode", inner_3dMap_location.getAdCode());
                this.c.putString("Address", inner_3dMap_location.getAddress());
                this.c.putString("AoiName", inner_3dMap_location.getAoiName());
                this.c.putString("City", inner_3dMap_location.getCity());
                this.c.putString("CityCode", inner_3dMap_location.getCityCode());
                this.c.putString("Country", inner_3dMap_location.getCountry());
                this.c.putString("District", inner_3dMap_location.getDistrict());
                this.c.putString("Street", inner_3dMap_location.getStreet());
                this.c.putString("StreetNum", inner_3dMap_location.getStreetNum());
                this.c.putString("PoiName", inner_3dMap_location.getPoiName());
                this.c.putString("Province", inner_3dMap_location.getProvince());
                this.c.putFloat("Speed", inner_3dMap_location.getSpeed());
                this.c.putString("Floor", inner_3dMap_location.getFloor());
                this.c.putFloat("Bearing", inner_3dMap_location.getBearing());
                this.c.putString("BuildingId", inner_3dMap_location.getBuildingId());
                this.c.putDouble("Altitude", inner_3dMap_location.getAltitude());
                inner_3dMap_location.setExtras(this.c);
                this.d.onLocationChanged(inner_3dMap_location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(long j) {
        if (!(this.f == null || this.e == null || this.f.getInterval() == j)) {
            this.f.setInterval(j);
            this.e.a(this.f);
        }
        this.b = j;
    }

    public final void a(int i) {
        if (i == 1 || i == 0) {
            a(true);
        } else {
            a(false);
        }
    }

    private void a(boolean z) {
        if (!(this.f == null || this.e == null)) {
            this.e.c();
            this.e = new el(this.g);
            this.e.a((Inner_3dMap_locationListener) this);
            this.f.setOnceLocation(z);
            if (!z) {
                this.f.setInterval(this.b);
            }
            this.e.a(this.f);
            this.e.a();
        }
        this.a = z;
    }
}
