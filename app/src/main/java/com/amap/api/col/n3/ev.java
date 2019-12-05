package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.rtbt.IAE8;
import java.util.HashMap;
import java.util.List;

/* compiled from: Engine */
public abstract class ev implements ez, fb, fc, IAE8 {
    private ep a;

    public boolean a(NaviLatLng naviLatLng) {
        return false;
    }

    public boolean a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        return false;
    }

    public boolean b(NaviLatLng naviLatLng) {
        return false;
    }

    public boolean b(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        return false;
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        return false;
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        return false;
    }

    public HashMap<Integer, AMapNaviPath> getMultipleNaviPathsCalculated() {
        return null;
    }

    public List<AMapTrafficStatus> getTrafficStatuses(int i, int i2) {
        return null;
    }

    public boolean reCalculateRoute(int i) {
        return false;
    }

    public boolean readTrafficInfo(int i) {
        return false;
    }

    public void refreshTrafficStatuses() {
    }

    public boolean setBroadcastMode(int i) {
        return false;
    }

    public void setCameraInfoUpdateEnabled(boolean z) {
    }

    public void setCarInfo(AMapCarInfo aMapCarInfo) {
    }

    public void setCarNumber(String str, String str2) {
    }

    public void setDetectedMode(int i) {
    }

    public void setReCalculateRouteForTrafficJam(boolean z) {
    }

    public void setReCalculateRouteForYaw(boolean z) {
    }

    public void setTrafficInfoUpdateEnabled(boolean z) {
    }

    public void setTrafficStatusUpdateEnabled(boolean z) {
    }

    public void startAimlessMode(int i) {
    }

    public void stopAimlessMode() {
    }

    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return 0;
    }

    public void switchParallelRoad() {
    }

    public ev(Context context) {
        if (context != null) {
            this.a = ep.a(context);
        }
    }

    public final void n() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    public final ep o() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final void a(AMapNaviListener aMapNaviListener) {
        this.a.a(aMapNaviListener);
    }

    /* access modifiers changed from: protected */
    public final void b(AMapNaviListener aMapNaviListener) {
        this.a.b(aMapNaviListener);
    }

    public int[] getAllRouteID() {
        return new int[0];
    }
}
