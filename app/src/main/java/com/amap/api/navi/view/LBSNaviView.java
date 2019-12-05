package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.amap.api.col.n3.fq;
import com.amap.api.col.n3.gb;
import com.amap.api.maps.AMap;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.AmapRouteActivity;

public class LBSNaviView extends RelativeLayout {
    public static final int CAR_UP_MODE = 0;
    public static final int NORTH_UP_MODE = 1;
    private gb core;

    public LBSNaviView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init((AMapNaviViewOptions) null);
    }

    public LBSNaviView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init((AMapNaviViewOptions) null);
    }

    public LBSNaviView(Context context) {
        super(context);
        init((AMapNaviViewOptions) null);
    }

    public LBSNaviView(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        super(context);
        init(aMapNaviViewOptions);
    }

    public double getAnchorX() {
        return this.core.a();
    }

    public double getAnchorY() {
        return this.core.b();
    }

    public int getLockZoom() {
        return this.core.c();
    }

    public void setLockZoom(int i) {
        this.core.a(i);
    }

    public int getLockTilt() {
        return this.core.d();
    }

    public void setLockTilt(int i) {
        this.core.b(i);
    }

    public int getNaviMode() {
        return this.core.e();
    }

    public void setNaviMode(int i) {
        this.core.c(i);
    }

    public boolean isAutoChangeZoom() {
        return this.core.f();
    }

    public AMapNaviViewOptions getViewOptions() {
        return this.core.g();
    }

    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        this.core.a(aMapNaviViewOptions);
    }

    public AMap getMap() {
        return this.core.h();
    }

    private void init(AMapNaviViewOptions aMapNaviViewOptions) {
        this.core = new fq(this, aMapNaviViewOptions);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            this.core.j();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onCreate(Bundle bundle) {
        this.core.a(bundle);
    }

    public final void onResume() {
        this.core.l();
    }

    public final void onPause() {
        this.core.m();
    }

    public final void onDestroy() {
        this.core.n();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.core.b(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void displayOverview() {
        this.core.o();
    }

    public void openNorthMode() {
        this.core.p();
    }

    public void recoverLockMode() {
        this.core.s();
    }

    public boolean isTrafficLine() {
        return this.core.t();
    }

    public void setTrafficLine(boolean z) {
        this.core.b(z);
    }

    public boolean isShowRoadEnlarge() {
        return this.core.v();
    }

    public boolean isOrientationLandscape() {
        return this.core.w();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            this.core.x();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomIn() {
        this.core.y();
    }

    public void zoomOut() {
        this.core.z();
    }

    public boolean isRouteOverviewNow() {
        return this.core.A();
    }

    public void setService(AmapRouteActivity amapRouteActivity) {
        this.core.a(amapRouteActivity);
    }

    public void showExitDialog() {
        if (this.core != null) {
            this.core.B();
        }
    }
}
