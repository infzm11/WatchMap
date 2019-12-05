package com.amap.api.col.n3;

import android.util.Pair;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: CameraBoundsMessage */
public final class w extends CameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(CameraUpdateMessage cameraUpdateMessage) {
    }

    public final void runCameraUpdate(GLMapState gLMapState) {
        Pair<Float, IPoint> a = dv.a((CameraUpdateMessage) this, this.mapConfig);
        gLMapState.setMapZoomer(((Float) a.first).floatValue());
        gLMapState.setMapGeoCenter(((IPoint) a.second).x, ((IPoint) a.second).y);
        gLMapState.setCameraDegree(0.0f);
        gLMapState.setMapAngle(0.0f);
    }
}
