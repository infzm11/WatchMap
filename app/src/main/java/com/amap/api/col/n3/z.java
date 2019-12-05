package com.amap.api.col.n3;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: CameraUpdateFactoryDelegate */
public final class z {
    public static CameraUpdateMessage a() {
        aa aaVar = new aa();
        aaVar.nowType = CameraUpdateMessage.Type.zoomBy;
        aaVar.amount = 1.0f;
        return aaVar;
    }

    public static CameraUpdateMessage b() {
        aa aaVar = new aa();
        aaVar.nowType = CameraUpdateMessage.Type.zoomBy;
        aaVar.amount = -1.0f;
        return aaVar;
    }

    public static CameraUpdateMessage a(float f) {
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        xVar.zoom = f;
        return xVar;
    }

    public static CameraUpdateMessage a(float f, Point point) {
        aa aaVar = new aa();
        aaVar.nowType = CameraUpdateMessage.Type.zoomBy;
        aaVar.amount = f;
        aaVar.focus = point;
        return aaVar;
    }

    public static CameraUpdateMessage a(CameraPosition cameraPosition) {
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition == null || cameraPosition.target == null) {
            return xVar;
        }
        xVar.geoPoint = VirtualEarthProjection.LatLongToPixels(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
        xVar.zoom = cameraPosition.zoom;
        xVar.bearing = cameraPosition.bearing;
        xVar.tilt = cameraPosition.tilt;
        xVar.cameraPosition = cameraPosition;
        return xVar;
    }

    public static CameraUpdateMessage a(Point point) {
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        xVar.geoPoint = point;
        return xVar;
    }

    public static CameraUpdateMessage b(float f) {
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        xVar.tilt = f;
        return xVar;
    }

    public static CameraUpdateMessage c(float f) {
        x xVar = new x();
        xVar.nowType = CameraUpdateMessage.Type.newCameraPosition;
        xVar.bearing = f;
        return xVar;
    }

    public static CameraUpdateMessage a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static CameraUpdateMessage a(LatLngBounds latLngBounds, int i) {
        w wVar = new w();
        wVar.nowType = CameraUpdateMessage.Type.newLatLngBounds;
        wVar.bounds = latLngBounds;
        wVar.paddingLeft = i;
        wVar.paddingRight = i;
        wVar.paddingTop = i;
        wVar.paddingBottom = i;
        return wVar;
    }
}
