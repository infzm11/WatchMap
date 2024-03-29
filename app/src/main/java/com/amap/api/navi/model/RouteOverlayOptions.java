package com.amap.api.navi.model;

import android.graphics.Bitmap;
import android.graphics.Color;

public class RouteOverlayOptions {
    private int arrowColor = Color.parseColor("#4DF6CC");
    private Bitmap arrowOnTrafficRoute = null;
    private boolean isShowCameOnRoute = true;
    private Bitmap jamTraffic = null;
    private float mLineWidth;
    private Bitmap normalRoute = null;
    private Bitmap slowTraffic = null;
    private Bitmap smoothTraffic = null;
    private Bitmap unknownTraffic = null;
    private Bitmap veryJamTraffic = null;

    public void setOnRouteCameShow(boolean z) {
        this.isShowCameOnRoute = z;
    }

    public boolean isShowCameOnRoute() {
        return this.isShowCameOnRoute;
    }

    public void setArrowColor(int i) {
        this.arrowColor = i;
    }

    public int getArrowColor() {
        return this.arrowColor;
    }

    public Bitmap getVeryJamTraffic() {
        return this.veryJamTraffic;
    }

    public void setVeryJamTraffic(Bitmap bitmap) {
        this.veryJamTraffic = bitmap;
    }

    public Bitmap getSmoothTraffic() {
        return this.smoothTraffic;
    }

    public void setSmoothTraffic(Bitmap bitmap) {
        this.smoothTraffic = bitmap;
    }

    public Bitmap getUnknownTraffic() {
        return this.unknownTraffic;
    }

    public void setUnknownTraffic(Bitmap bitmap) {
        this.unknownTraffic = bitmap;
    }

    public Bitmap getSlowTraffic() {
        return this.slowTraffic;
    }

    public void setSlowTraffic(Bitmap bitmap) {
        this.slowTraffic = bitmap;
    }

    public Bitmap getJamTraffic() {
        return this.jamTraffic;
    }

    public void setJamTraffic(Bitmap bitmap) {
        this.jamTraffic = bitmap;
    }

    public Bitmap getArrowOnTrafficRoute() {
        return this.arrowOnTrafficRoute;
    }

    public void setArrowOnTrafficRoute(Bitmap bitmap) {
        this.arrowOnTrafficRoute = bitmap;
    }

    public Bitmap getNormalRoute() {
        return this.normalRoute;
    }

    public void setNormalRoute(Bitmap bitmap) {
        this.normalRoute = bitmap;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }
}
