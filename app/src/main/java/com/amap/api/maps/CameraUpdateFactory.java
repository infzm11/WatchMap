package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.col.n3.w;
import com.amap.api.col.n3.x;
import com.amap.api.col.n3.y;
import com.amap.api.col.n3.z;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(z.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(z.b());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        y yVar = new y();
        yVar.nowType = CameraUpdateMessage.Type.scrollBy;
        yVar.xPixel = f;
        yVar.yPixel = f2;
        return new CameraUpdate(yVar);
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(z.a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(z.a(f, (Point) null));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(z.a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return new CameraUpdate(new x());
        }
        return new CameraUpdate(z.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(new x());
        }
        return new CameraUpdate(z.a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build()));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng == null) {
            return new CameraUpdate(new x());
        }
        return new CameraUpdate(z.a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds == null) {
            return new CameraUpdate(new x());
        }
        return new CameraUpdate(z.a(latLngBounds, i));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(new x());
        }
        return new CameraUpdate(z.a(VirtualEarthProjection.LatLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(z.c(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint == null) {
            return new CameraUpdate(new x());
        }
        Point point = new Point(iPoint.x, iPoint.y);
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        xVar.geoPoint = point;
        xVar.bearing = f % 360.0f;
        return new CameraUpdate(xVar);
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(z.b(f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds == null) {
            return new CameraUpdate(new x());
        }
        w wVar = new w();
        wVar.nowType = CameraUpdateMessage.Type.newLatLngBoundsWithSize;
        wVar.bounds = latLngBounds;
        wVar.paddingLeft = i3;
        wVar.paddingRight = i3;
        wVar.paddingTop = i3;
        wVar.paddingBottom = i3;
        wVar.width = i;
        wVar.height = i2;
        return new CameraUpdate(wVar);
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            return new CameraUpdate(new x());
        }
        w wVar = new w();
        wVar.nowType = CameraUpdateMessage.Type.newLatLngBounds;
        wVar.bounds = latLngBounds;
        wVar.paddingLeft = i;
        wVar.paddingRight = i2;
        wVar.paddingTop = i3;
        wVar.paddingBottom = i4;
        return new CameraUpdate(wVar);
    }
}
