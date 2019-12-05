package com.amap.api.col.n3;

import android.graphics.Point;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.CameraUpdateMessage;

/* compiled from: CameraScrollMessage */
public final class y extends CameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(CameraUpdateMessage cameraUpdateMessage) {
    }

    public final void runCameraUpdate(GLMapState gLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = (((float) this.width) / 2.0f) + f;
        float f4 = (((float) this.height) / 2.0f) + f2;
        Point point = new Point();
        gLMapState.screenToP20Point((float) ((int) f3), (float) ((int) f4), point);
        gLMapState.setMapGeoCenter(point.x, point.y);
    }
}
