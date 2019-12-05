package com.amap.api.col.n3;

import android.graphics.Rect;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;

/* compiled from: IOverlayImageDelegate */
public interface ci extends IOverlayImage {
    void a(k kVar);

    void a(k kVar, float[] fArr, int i, float f);

    void b(boolean z);

    IMarkerAction getIMarkerAction();

    Rect h();

    boolean i();

    boolean isInfoWindowShown();

    boolean j();

    int k();

    boolean l();
}
