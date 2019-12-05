package com.amap.api.col.n3;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapRouteActivity;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: LocationView */
public final class ft implements gc, Inner_3dMap_locationListener {
    private AmapRouteActivity a;
    private AMap b;
    private Marker c;
    private el d;
    private Inner_3dMap_locationOption e;
    private Circle f;
    private Circle g;
    private LatLng h;
    private boolean i;
    private gd j;
    private String k = "北京市";

    public ft(AmapRouteActivity amapRouteActivity) {
        this.a = amapRouteActivity;
        if (this.d == null) {
            this.d = new el(this.a);
            this.e = new Inner_3dMap_locationOption();
            this.e.setHttpTimeOut(4000);
            this.d.a((Inner_3dMap_locationListener) this);
            this.e.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.e.setInterval(4000);
            this.d.a(this.e);
        }
    }

    public final void a(AMap aMap) {
        this.b = aMap;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void a(gd gdVar) {
        this.j = gdVar;
    }

    public final void a() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.b();
        }
    }

    public final void c() {
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        if (this.c != null) {
            this.c.remove();
            this.c = null;
        }
        this.e = null;
        this.a = null;
    }

    public final LatLng d() {
        return this.h;
    }

    public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (inner_3dMap_location.getErrorCode() == 0) {
                    this.h = new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude());
                    LatLng latLng = new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude());
                    float accuracy = inner_3dMap_location.getAccuracy();
                    if (this.c == null) {
                        this.c = this.b.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837693))).anchor(0.5f, 0.5f));
                        this.f = this.b.addCircle(new CircleOptions().center(latLng).fillColor(Color.argb(100, 255, 218, 185)).radius(3.0d).strokeColor(Color.argb(255, 255, 228, 185)).strokeWidth(5.0f));
                        this.g = this.b.addCircle(new CircleOptions().center(latLng).fillColor(Color.argb(70, 255, 218, 185)).radius(3.0d).strokeColor(Color.argb(255, 255, 228, 185)).strokeWidth(0.0f));
                    } else {
                        this.c.setPosition(latLng);
                        this.f.setCenter(latLng);
                        double d2 = (double) accuracy;
                        this.f.setRadius(d2);
                        this.g.setCenter(latLng);
                        this.g.setRadius(d2);
                    }
                    this.k = inner_3dMap_location.getCity();
                    if (this.a != null) {
                        this.a.getSearchResult().a(new Poi("我的位置", this.h, ""));
                    }
                    if (this.i && this.j != null) {
                        this.j.a(inner_3dMap_location.getErrorCode(), new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude()));
                        this.i = false;
                        return;
                    }
                    return;
                }
                if (this.i) {
                    this.j.a(inner_3dMap_location.getErrorCode(), (LatLng) null);
                    this.i = false;
                }
                "定位失败," + inner_3dMap_location.getErrorCode() + ": " + inner_3dMap_location.getErrorInfo();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final String e() {
        return this.k;
    }
}
