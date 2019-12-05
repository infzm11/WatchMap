package com.amap.api.col.n3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.LBSNaviView;
import com.android.hoinnet.highde.R;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NaviPage */
public final class ge extends fu implements AMapNaviListener {
    boolean j = false;
    private LBSNaviView k;
    private AMapNavi l;
    private AMap m;
    private RelativeLayout n;
    private kp o;
    private JSONObject p;
    private boolean q = false;
    private int r;
    private Dialog s;
    private boolean t = false;
    private List<NaviLatLng> u;

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    public final void hideCross() {
    }

    public final void hideLaneInfo() {
    }

    public final void notifyParallelRoad(int i) {
    }

    public final void onArrivedWayPoint(int i) {
    }

    public final void onGetNavigationText(String str) {
    }

    public final void onGpsOpenStatus(boolean z) {
    }

    public final void onInitNaviFailure() {
    }

    public final void onInitNaviSuccess() {
    }

    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public final void onPlayRing(int i) {
    }

    public final void onReCalculateRouteForTrafficJam() {
    }

    public final void onReCalculateRouteForYaw() {
    }

    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    public final void onTrafficStatusUpdate() {
    }

    public final void showCross(AMapNaviCross aMapNaviCross) {
    }

    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    public final void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    public final void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    public final void a(Bundle bundle) {
        NaviLatLng naviLatLng;
        super.a(bundle);
        this.q = false;
        this.i.setRequestedOrientation(4);
        this.k = (LBSNaviView) this.n.findViewById(2131296304);
        this.k.setService(this.i);
        this.k.onCreate(bundle);
        this.m = this.k.getMap();
        this.m.setMapType(4);
        this.l = AMapNavi.getInstance(this.i);
        this.l.addAMapNaviListener(this);
        this.r = 1;
        if (bundle != null) {
            this.r = bundle.getInt("navi_type", 1);
            this.j = bundle.getBoolean(AmapNaviPage.PAGE_TYPE, false);
        }
        if (this.r == 2) {
            this.k.setLockTilt(0);
        } else {
            this.k.setLockTilt(35);
        }
        try {
            if (this.r == 1) {
                this.o = new kp(this.i.getApplicationContext(), "navi", "5.4.0", "O001");
                this.p = new JSONObject();
                this.p.put("time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.j) {
            ArrayList arrayList = new ArrayList();
            Poi poi = (Poi) bundle.getParcelable(AmapNaviPage.POI_START);
            if (poi == null) {
                naviLatLng = en.a((Context) this.i);
            } else {
                this.i.getSearchResult().b(poi);
                naviLatLng = new NaviLatLng(poi.getCoordinate().latitude, poi.getCoordinate().longitude);
            }
            arrayList.add(naviLatLng);
            ArrayList arrayList2 = new ArrayList();
            Poi poi2 = (Poi) bundle.getParcelable(AmapNaviPage.POI_END);
            this.i.getSearchResult().f(poi2);
            arrayList2.add(new NaviLatLng(poi2.getCoordinate().latitude, poi2.getCoordinate().longitude));
            this.u = new ArrayList();
            Poi poi3 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY1);
            Poi poi4 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY2);
            Poi poi5 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY3);
            if (poi3 != null) {
                this.u.add(new NaviLatLng(poi3.getCoordinate().latitude, poi3.getCoordinate().longitude));
            }
            if (poi4 != null) {
                this.u.add(new NaviLatLng(poi4.getCoordinate().latitude, poi4.getCoordinate().longitude));
            }
            if (poi5 != null) {
                this.u.add(new NaviLatLng(poi5.getCoordinate().latitude, poi5.getCoordinate().longitude));
            }
            b();
            this.t = true;
            this.l.calculateDriveRoute(arrayList, arrayList2, this.u, 12);
            return;
        }
        this.l.startNavi(this.r);
    }

    public final void a(View view) {
        try {
            if (view.getId() == 2131296328 && this.i != null) {
                int strategyConvert = this.l.strategyConvert(hf.a((Context) this.i, "NAVI_STRATEGY_TAB1"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB2"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB3"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB4"), true);
                this.s.dismiss();
                ArrayList arrayList = new ArrayList();
                Poi f = this.i.getSearchResult().f();
                arrayList.add(new NaviLatLng(f.getCoordinate().latitude, f.getCoordinate().longitude));
                this.l.calculateDriveRoute(arrayList, this.u, strategyConvert);
            }
            if (view.getId() == 2131296327) {
                this.s.dismiss();
                this.i.closeScr();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean a() {
        if (this.k == null) {
            return false;
        }
        this.k.showExitDialog();
        return false;
    }

    private Dialog a(Context context, int i) {
        try {
            if (this.s == null) {
                this.s = new Dialog(context);
                this.s.requestWindowFeature(1);
                this.s.getWindow().setBackgroundDrawableResource(17170445);
            }
            View a = hs.a(this.i, R.attr.actionBarTheme, (ViewGroup) null);
            TextView textView = (TextView) a.findViewById(2131296327);
            TextView textView2 = (TextView) a.findViewById(2131296328);
            textView.setOnClickListener(this.i);
            textView2.setOnClickListener(this.i);
            this.s.setContentView(a);
            this.s.setCancelable(false);
            ((TextView) a.findViewById(2131296325)).setText(hf.a(i));
            textView.setText("退出");
            textView2.setText("重试");
            return this.s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final RelativeLayout d() {
        this.n = (RelativeLayout) hs.a(this.i, R.attr.actionBarStyle, (ViewGroup) null);
        return this.n;
    }

    public final void f() {
        super.f();
        this.k.onResume();
    }

    public final void h() {
        super.h();
        this.k.onPause();
    }

    public final void e() {
        this.k.onDestroy();
        this.l.removeAMapNaviListener(this);
        this.l.stopNavi();
        AMapNavi.setTtsPlaying(false);
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onStopSpeaking();
        }
        try {
            if (this.r == 1) {
                if (this.p != null) {
                    this.p.put("isnavi", this.q ? "1" : "0");
                }
                this.o.a(this.p.toString());
                kq.a(this.o, this.i.getApplicationContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onGetNavigationText(int i, String str) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onGetNavigationText(str);
        }
    }

    public final void onStartNavi(int i) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onStartNavi(i);
        }
    }

    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onLocationChange(aMapNaviLocation);
        }
    }

    public final void onEndEmulatorNavi() {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onArriveDestination(true);
        }
    }

    public final void onArriveDestination() {
        try {
            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
            if (callback != null) {
                callback.onArriveDestination(false);
            }
            if (this.r == 1) {
                this.q = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onCalculateRouteSuccess(int[] iArr) {
        if (this.j) {
            this.l.startNavi(this.r);
            c();
            this.t = false;
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onCalculateRouteSuccess(iArr);
        }
    }

    public final void onCalculateRouteFailure(int i) {
        if (this.j) {
            c();
            if (this.t) {
                Dialog a = a(this.i, i);
                if (a != null) {
                    a.show();
                }
            }
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onCalculateRouteFailure(i);
        }
    }
}
