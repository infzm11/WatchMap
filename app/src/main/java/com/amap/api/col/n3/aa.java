package com.amap.api.col.n3;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.CameraUpdateMessage;

/* compiled from: CameraZoomMessage */
public final class aa extends CameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(CameraUpdateMessage cameraUpdateMessage) {
    }

    public final void runCameraUpdate(GLMapState gLMapState) {
        this.zoom = gLMapState.getMapZoomer() + this.amount;
        this.zoom = dv.a(this.mapConfig, this.zoom);
        normalChange(gLMapState);
    }
}
