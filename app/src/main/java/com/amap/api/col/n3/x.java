package com.amap.api.col.n3;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.CameraUpdateMessage;

/* compiled from: CameraPositionMessage */
public final class x extends CameraUpdateMessage {
    public final void runCameraUpdate(GLMapState gLMapState) {
        normalChange(gLMapState);
    }

    public final void mergeCameraUpdateDelegate(CameraUpdateMessage cameraUpdateMessage) {
        cameraUpdateMessage.geoPoint = this.geoPoint == null ? cameraUpdateMessage.geoPoint : this.geoPoint;
        cameraUpdateMessage.zoom = Float.isNaN(this.zoom) ? cameraUpdateMessage.zoom : this.zoom;
        cameraUpdateMessage.bearing = Float.isNaN(this.bearing) ? cameraUpdateMessage.bearing : this.bearing;
        cameraUpdateMessage.tilt = Float.isNaN(this.tilt) ? cameraUpdateMessage.tilt : this.tilt;
    }
}
