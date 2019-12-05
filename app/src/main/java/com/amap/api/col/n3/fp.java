package com.amap.api.col.n3;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.INavi;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.RouteOverlayOptions;
import com.amap.api.navi.view.AmapCameraOverlay;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.List;

/* compiled from: LBSNaviUIController */
public final class fp implements MyNaviListener {
    private Handler A = new Handler() {
        public final void handleMessage(Message message) {
            try {
                if (fp.this.p == null) {
                    return;
                }
                if (fp.this.p.I != null) {
                    super.handleMessage(message);
                    if (message.what == 1) {
                        fp.this.p.I.c(true);
                    }
                    if (message.what == 2) {
                        fp.this.p.I.c(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private NaviLatLng B;
    private final int C = 100;
    private final int D = 101;
    private final int E = 102;
    private final int F = 1;
    private final int G = 2;
    private LatLng H;
    private LatLng I;
    private long a = 0;
    private InnerNaviInfo b;
    private boolean c = false;
    private String d = "#222222";
    private String e = "#222222";
    private int f = 1;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private fs j;
    private fo k;
    private AmapCameraOverlay l;
    private INavi m = null;
    private AMap n;
    private Context o;
    /* access modifiers changed from: private */
    public fq p;
    private boolean q = false;
    private AMapNaviPath r;
    private int s = -1;
    private AMapNaviPath t;
    private int u;
    private boolean v;
    private float w = 0.0f;
    private boolean x = false;
    private boolean y = false;
    private SoundPool z;

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    public final void onGetNavigationText(String str) {
    }

    public final void onGpsOpenStatus(boolean z2) {
    }

    public final void onInitNaviFailure() {
    }

    public final void onInitNaviSuccess() {
    }

    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public final void onPlayRing(int i2) {
    }

    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    public final void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    public final void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    public fp(Context context, TextureMapView textureMapView, fq fqVar) {
        if (fqVar != null) {
            this.o = context.getApplicationContext();
            this.j = new fs(textureMapView.getMap(), this.o);
            this.k = new fo(textureMapView, fqVar);
            this.l = new AmapCameraOverlay(context);
            this.m = AMapNavi.getInstance(this.o);
            this.p = fqVar;
            this.n = textureMapView.getMap();
            AMap aMap = this.n;
        }
    }

    public final void onArriveDestination() {
        if (this.f != 2) {
            if (this.j != null) {
                this.j.c();
            }
            if (this.l != null) {
                this.l.destroy();
            }
            this.p.u();
            if (this.k != null) {
                this.k.e();
            }
            this.c = false;
            a(1);
            this.m.stopNavi();
        }
    }

    public final void onArrivedWayPoint(int i2) {
        "NaviUIControl-->onArrivedWayPoint(" + i2 + ")";
    }

    public final void onCalculateRouteFailure(int i2) {
        "NaviUIControl-->onCalculateRouteFailure(),errorCode=" + i2;
        i();
    }

    public final void onCalculateRouteSuccess(int[] iArr) {
        this.a = System.currentTimeMillis();
        if (this.p != null) {
            this.p.C();
        }
        i();
        if (this.n == null || this.m == null) {
            "NaviUIControl-->" + this.n;
            "NaviUIControl-->" + this.m;
            return;
        }
        AMapNaviPath naviPath = this.m.getNaviPath();
        if (naviPath != null) {
            this.r = naviPath;
            this.u = naviPath.getAllLength();
            a(naviPath);
            if (this.k != null) {
                this.k.a(this.m.getEngineType());
            }
            a();
            this.s = -1;
            hideCross();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.m.getTrafficStatuses(0, 0);
    }

    public final void a(boolean z2) {
        this.h = z2;
    }

    public final void b(boolean z2) {
        this.i = z2;
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapNaviPath aMapNaviPath) {
        if (aMapNaviPath != this.t && this.h && aMapNaviPath != null) {
            if (this.j != null) {
                this.j.a(aMapNaviPath);
                this.j.b();
            }
            LatLng latLng = null;
            if (!(aMapNaviPath.getStartPoint() == null || aMapNaviPath.getEndPoint() == null)) {
                latLng = new LatLng(aMapNaviPath.getStartPoint().getLatitude(), aMapNaviPath.getStartPoint().getLongitude());
            }
            float a2 = hq.a(latLng, new LatLng(aMapNaviPath.getCoordList().get(1).getLatitude(), aMapNaviPath.getCoordList().get(1).getLongitude()));
            if (latLng != null) {
                this.k.c();
                fo foVar = this.k;
                AMap aMap = this.n;
                this.I = latLng;
                foVar.a(aMap, latLng, a2);
                if (aMapNaviPath.getEndPoint() != null) {
                    this.k.a(new LatLng(aMapNaviPath.getEndPoint().getLatitude(), aMapNaviPath.getEndPoint().getLongitude()));
                }
            }
            if (this.p.t != null) {
                try {
                    Spanned fromHtml = Html.fromHtml(hq.a(aMapNaviPath.getAllLength(), this.d, this.e));
                    Spanned fromHtml2 = Html.fromHtml(hq.a(hq.b(aMapNaviPath.getAllTime()), this.d, this.e));
                    TextView textView = this.p.t;
                    textView.setText("剩余 " + fromHtml + " " + fromHtml2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.t = aMapNaviPath;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, int i5) {
        if (this.j == null) {
            return;
        }
        if (!this.h) {
            this.j.b(this.r);
            return;
        }
        this.j.a(this.r);
        this.j.a(i2, i3, i4, i5);
    }

    public final void onEndEmulatorNavi() {
        try {
            if (this.l != null) {
                this.l.destroy();
            }
            this.p.F = true;
            a(1);
            this.k.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void onGetNavigationText(int i2, String str) {
        "NaviUIControl-->onGetNavigationText(),msg=" + str;
    }

    public final NaviLatLng b() {
        return this.B;
    }

    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        if (aMapNaviLocation != null && this.m != null) {
            Message message = new Message();
            message.what = 1;
            this.A.removeMessages(1);
            this.A.sendMessageDelayed(message, 5000);
            this.A.sendEmptyMessage(2);
            if (this.H != null && this.m.getEngineType() == 1 && this.m.getNaviType() == 1) {
                LatLng latLng = new LatLng(aMapNaviLocation.getCoord().getLatitude(), aMapNaviLocation.getCoord().getLongitude());
                if (!aMapNaviLocation.isMatchNaviPath()) {
                    this.j.a(latLng, this.H, true);
                } else {
                    this.j.a(latLng, this.H, false);
                    this.H = null;
                }
            }
            this.B = aMapNaviLocation.getCoord();
            float bearing = aMapNaviLocation.getBearing();
            LatLng latLng2 = new LatLng(this.B.getLatitude(), this.B.getLongitude());
            if (this.m.getEngineType() == 1 || this.m.getEngineType() == 2) {
                if (!this.v || !this.x) {
                    this.k.a(this.n, latLng2, bearing);
                } else {
                    this.I = latLng2;
                }
            } else if (this.m.getEngineType() == 0) {
                this.k.a(this.n, latLng2, bearing);
                if (this.p != null && this.p.c != null) {
                    int speed = (int) aMapNaviLocation.getSpeed();
                    if (speed > 0) {
                        this.p.c.setText(String.valueOf(speed));
                    } else {
                        this.p.c.setText("0");
                    }
                }
            }
        }
    }

    public final InnerNaviInfo c() {
        return this.b;
    }

    private void a(int i2) {
        this.r = this.m.getNaviPath();
        this.p.e.setData(this.r.getTrafficStatuses(), this.r.getAllLength());
        if (this.p.e.getHeight() > 0) {
            this.p.e.setCarView(this.p.f);
            this.p.e.setCursorPos(i2);
            this.p.e.invalidate();
        }
    }

    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
        try {
            if (this.y) {
                RouteOverlayOptions a2 = this.j.a();
                if (a2 == null || a2.isShowCameOnRoute()) {
                    this.l.draw(this.n, aMapNaviCameraInfoArr);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void showCross(AMapNaviCross aMapNaviCross) {
        this.p.a(aMapNaviCross);
    }

    public final void hideCross() {
        this.p.q();
    }

    public final void showModeCross(AMapModelCross aMapModelCross) {
        this.p.a(aMapModelCross);
    }

    public final void hideModeCross() {
        this.p.r();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.amap.api.navi.model.NaviLatLng} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: com.amap.api.navi.model.NaviLatLng} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cc A[Catch:{ Exception -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ce A[Catch:{ Exception -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc A[Catch:{ Exception -> 0x023d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            if (r2 == 0) goto L_0x0243
            com.amap.api.navi.INavi r3 = r1.m
            if (r3 != 0) goto L_0x000c
            goto L_0x0243
        L_0x000c:
            com.amap.api.navi.INavi r3 = r1.m     // Catch:{ Exception -> 0x023d }
            int r3 = r3.getEngineType()     // Catch:{ Exception -> 0x023d }
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 == r6) goto L_0x001f
            com.amap.api.navi.INavi r3 = r1.m     // Catch:{ Exception -> 0x023d }
            int r3 = r3.getEngineType()     // Catch:{ Exception -> 0x023d }
            if (r3 != r5) goto L_0x00f3
        L_0x001f:
            int r3 = r18.getCurStep()     // Catch:{ Exception -> 0x023d }
            com.amap.api.navi.INavi r7 = r1.m     // Catch:{ Exception -> 0x023d }
            com.amap.api.navi.model.AMapNaviPath r7 = r7.getNaviPath()     // Catch:{ Exception -> 0x023d }
            java.util.List r7 = r7.getSteps()     // Catch:{ Exception -> 0x023d }
            java.lang.Object r3 = r7.get(r3)     // Catch:{ Exception -> 0x023d }
            com.amap.api.navi.model.AMapNaviStep r3 = (com.amap.api.navi.model.AMapNaviStep) r3     // Catch:{ Exception -> 0x023d }
            java.util.List r3 = r3.getLinks()     // Catch:{ Exception -> 0x023d }
            int r7 = r18.getCurLink()     // Catch:{ Exception -> 0x023d }
            java.lang.Object r3 = r3.get(r7)     // Catch:{ Exception -> 0x023d }
            com.amap.api.navi.model.AMapNaviLink r3 = (com.amap.api.navi.model.AMapNaviLink) r3     // Catch:{ Exception -> 0x023d }
            java.util.List r3 = r3.getCoords()     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fo r7 = r1.k     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x00ef
            int r8 = r3.size()     // Catch:{ Exception -> 0x023d }
            if (r8 >= r5) goto L_0x0051
            goto L_0x00ef
        L_0x0051:
            int r8 = r3.size()     // Catch:{ Exception -> 0x023d }
            r9 = 0
            if (r8 != r5) goto L_0x0066
            java.lang.Object r5 = r3.get(r4)     // Catch:{ Exception -> 0x023d }
            r9 = r5
            com.amap.api.navi.model.NaviLatLng r9 = (com.amap.api.navi.model.NaviLatLng) r9     // Catch:{ Exception -> 0x023d }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ Exception -> 0x023d }
        L_0x0063:
            com.amap.api.navi.model.NaviLatLng r3 = (com.amap.api.navi.model.NaviLatLng) r3     // Catch:{ Exception -> 0x023d }
            goto L_0x0076
        L_0x0066:
            if (r8 <= r5) goto L_0x0075
            java.lang.Object r5 = r3.get(r4)     // Catch:{ Exception -> 0x023d }
            r9 = r5
            com.amap.api.navi.model.NaviLatLng r9 = (com.amap.api.navi.model.NaviLatLng) r9     // Catch:{ Exception -> 0x023d }
            int r8 = r8 - r6
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x023d }
            goto L_0x0063
        L_0x0075:
            r3 = r9
        L_0x0076:
            com.autonavi.amap.mapcore.IPoint r5 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Exception -> 0x023d }
            r5.<init>()     // Catch:{ Exception -> 0x023d }
            com.autonavi.amap.mapcore.IPoint r8 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Exception -> 0x023d }
            r8.<init>()     // Catch:{ Exception -> 0x023d }
            double r10 = r9.getLongitude()     // Catch:{ Exception -> 0x023d }
            double r12 = r9.getLatitude()     // Catch:{ Exception -> 0x023d }
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r10, r12, r8)     // Catch:{ Exception -> 0x023d }
            double r9 = r3.getLongitude()     // Catch:{ Exception -> 0x023d }
            double r11 = r3.getLatitude()     // Catch:{ Exception -> 0x023d }
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r9, r11, r5)     // Catch:{ Exception -> 0x023d }
            int r3 = r5.x     // Catch:{ Exception -> 0x023d }
            double r9 = (double) r3     // Catch:{ Exception -> 0x023d }
            int r3 = r5.y     // Catch:{ Exception -> 0x023d }
            double r11 = (double) r3     // Catch:{ Exception -> 0x023d }
            int r3 = r8.x     // Catch:{ Exception -> 0x023d }
            double r13 = (double) r3     // Catch:{ Exception -> 0x023d }
            int r3 = r8.y     // Catch:{ Exception -> 0x023d }
            double r4 = (double) r3     // Catch:{ Exception -> 0x023d }
            double r13 = r13 - r9
            double r4 = r4 - r11
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r10 = java.lang.Math.pow(r13, r8)     // Catch:{ Exception -> 0x023d }
            double r8 = java.lang.Math.pow(r4, r8)     // Catch:{ Exception -> 0x023d }
            double r10 = r10 + r8
            double r8 = java.lang.Math.sqrt(r10)     // Catch:{ Exception -> 0x023d }
            double r8 = r13 / r8
            double r8 = java.lang.Math.acos(r8)     // Catch:{ Exception -> 0x023d }
            r10 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r10 = r10 / r8
            r8 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r10 = r8 / r10
            r15 = 0
            int r3 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ce
            double r8 = -r10
            goto L_0x00d8
        L_0x00ce:
            int r3 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x00d7
            int r3 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r8 = r10
        L_0x00d8:
            int r3 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x00e7
            r3 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r8 = java.lang.Math.abs(r8)     // Catch:{ Exception -> 0x023d }
            double r8 = r3 - r8
        L_0x00e7:
            r3 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r8 = r8 - r3
            float r3 = (float) r8     // Catch:{ Exception -> 0x023d }
            goto L_0x00f0
        L_0x00ef:
            r3 = 0
        L_0x00f0:
            r7.a((float) r3)     // Catch:{ Exception -> 0x023d }
        L_0x00f3:
            r1.b = r2     // Catch:{ Exception -> 0x023d }
            com.amap.api.navi.model.InnerNaviInfo r3 = r1.b     // Catch:{ Exception -> 0x023d }
            int r3 = r3.getPathRetainDistance()     // Catch:{ Exception -> 0x023d }
            r1.u = r3     // Catch:{ Exception -> 0x023d }
            boolean r3 = r1.h     // Catch:{ Exception -> 0x023d }
            if (r3 != 0) goto L_0x0109
            int r3 = r1.s     // Catch:{ Exception -> 0x023d }
            int r4 = r18.getCurStep()     // Catch:{ Exception -> 0x023d }
            if (r3 == r4) goto L_0x0133
        L_0x0109:
            com.amap.api.col.n3.fs r3 = r1.j     // Catch:{ Throwable -> 0x0127 }
            int r4 = r18.getCurStep()     // Catch:{ Throwable -> 0x0127 }
            java.util.List r3 = r3.a((int) r4)     // Catch:{ Throwable -> 0x0127 }
            if (r3 == 0) goto L_0x0133
            int r4 = r3.size()     // Catch:{ Throwable -> 0x0127 }
            if (r4 <= 0) goto L_0x0133
            com.amap.api.col.n3.fs r4 = r1.j     // Catch:{ Throwable -> 0x0127 }
            r4.a((java.util.List<com.amap.api.navi.model.NaviLatLng>) r3)     // Catch:{ Throwable -> 0x0127 }
            int r3 = r18.getCurStep()     // Catch:{ Throwable -> 0x0127 }
            r1.s = r3     // Catch:{ Throwable -> 0x0127 }
            goto L_0x0133
        L_0x0127:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = "NaviUIController"
            java.lang.String r5 = "drawArrow(NaviInfo naviInfo)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x023d }
        L_0x0133:
            com.amap.api.navi.INavi r3 = r1.m     // Catch:{ Exception -> 0x023d }
            int r3 = r3.getEngineType()     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x0166
            com.amap.api.navi.INavi r3 = r1.m     // Catch:{ Exception -> 0x023d }
            int r3 = r3.getNaviType()     // Catch:{ Exception -> 0x023d }
            if (r3 == r6) goto L_0x0166
            com.amap.api.navi.model.NaviLatLng r3 = r18.getCoord()     // Catch:{ Exception -> 0x023d }
            int r4 = r18.getDirection()     // Catch:{ Exception -> 0x023d }
            float r4 = (float) r4     // Catch:{ Exception -> 0x023d }
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Exception -> 0x023d }
            double r8 = r3.getLatitude()     // Catch:{ Exception -> 0x023d }
            double r10 = r3.getLongitude()     // Catch:{ Exception -> 0x023d }
            r12 = 0
            r7 = r5
            r7.<init>(r8, r10, r12)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fo r3 = r1.k     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x0166
            com.amap.api.col.n3.fo r3 = r1.k     // Catch:{ Exception -> 0x023d }
            com.amap.api.maps.AMap r7 = r1.n     // Catch:{ Exception -> 0x023d }
            r3.a(r7, r5, r4)     // Catch:{ Exception -> 0x023d }
        L_0x0166:
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            if (r3 != 0) goto L_0x016b
            return
        L_0x016b:
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            r3.E()     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            boolean r3 = r3.f()     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x01cb
            int r3 = r18.getCurStep()     // Catch:{ Exception -> 0x023d }
            if (r3 <= 0) goto L_0x01cb
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            boolean r3 = r3.A()     // Catch:{ Exception -> 0x023d }
            if (r3 != 0) goto L_0x01cb
            int r3 = r18.getCurStepRetainDistance()     // Catch:{ Exception -> 0x023d }
            r4 = 50
            if (r3 >= r4) goto L_0x01a9
            boolean r3 = r1.c     // Catch:{ Exception -> 0x023d }
            if (r3 != 0) goto L_0x01a9
            com.amap.api.maps.CameraUpdate r3 = com.amap.api.maps.CameraUpdateFactory.zoomIn()     // Catch:{ Exception -> 0x023d }
            com.amap.api.maps.AMap r5 = r1.n     // Catch:{ Exception -> 0x023d }
            r5.moveCamera(r3)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r5 = r1.p     // Catch:{ Exception -> 0x023d }
            int r5 = r5.c()     // Catch:{ Exception -> 0x023d }
            int r5 = r5 + r6
            r3.a((int) r5)     // Catch:{ Exception -> 0x023d }
            r1.c = r6     // Catch:{ Exception -> 0x023d }
        L_0x01a9:
            int r3 = r18.getCurStepRetainDistance()     // Catch:{ Exception -> 0x023d }
            if (r3 <= r4) goto L_0x01cb
            boolean r3 = r1.c     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x01cb
            com.amap.api.maps.CameraUpdate r3 = com.amap.api.maps.CameraUpdateFactory.zoomOut()     // Catch:{ Exception -> 0x023d }
            com.amap.api.maps.AMap r4 = r1.n     // Catch:{ Exception -> 0x023d }
            r4.moveCamera(r3)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r4 = r1.p     // Catch:{ Exception -> 0x023d }
            int r4 = r4.c()     // Catch:{ Exception -> 0x023d }
            int r4 = r4 - r6
            r3.a((int) r4)     // Catch:{ Exception -> 0x023d }
            r3 = 0
            r1.c = r3     // Catch:{ Exception -> 0x023d }
        L_0x01cb:
            int r3 = r18.getPathRetainTime()     // Catch:{ Exception -> 0x023d }
            java.lang.String r3 = com.amap.api.col.n3.hq.b((int) r3)     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = r1.d     // Catch:{ Exception -> 0x023d }
            java.lang.String r5 = r1.e     // Catch:{ Exception -> 0x023d }
            java.lang.String r3 = com.amap.api.col.n3.hq.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x023d }
            android.text.Spanned r3 = android.text.Html.fromHtml(r3)     // Catch:{ Exception -> 0x023d }
            int r4 = r18.getPathRetainDistance()     // Catch:{ Exception -> 0x023d }
            java.lang.String r5 = r1.d     // Catch:{ Exception -> 0x023d }
            java.lang.String r6 = r1.e     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = com.amap.api.col.n3.hq.a((int) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x023d }
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r5 = r1.p     // Catch:{ Exception -> 0x023d }
            android.widget.TextView r5 = r5.t     // Catch:{ Exception -> 0x023d }
            if (r5 == 0) goto L_0x0212
            com.amap.api.col.n3.fq r5 = r1.p     // Catch:{ Exception -> 0x023d }
            android.widget.TextView r5 = r5.t     // Catch:{ Exception -> 0x023d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023d }
            java.lang.String r7 = "剩余 "
            r6.<init>(r7)     // Catch:{ Exception -> 0x023d }
            r6.append(r4)     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = " "
            r6.append(r4)     // Catch:{ Exception -> 0x023d }
            r6.append(r3)     // Catch:{ Exception -> 0x023d }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x023d }
            r5.setText(r3)     // Catch:{ Exception -> 0x023d }
        L_0x0212:
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.hi r3 = r3.I     // Catch:{ Exception -> 0x023d }
            if (r3 == 0) goto L_0x021f
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.hi r3 = r3.I     // Catch:{ Exception -> 0x023d }
            r3.a((com.amap.api.navi.model.InnerNaviInfo) r2)     // Catch:{ Exception -> 0x023d }
        L_0x021f:
            int r3 = r18.getPathRetainDistance()     // Catch:{ Exception -> 0x023d }
            r1.a((int) r3)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            android.widget.TextView r3 = r3.p     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = r18.getCurrentRoadName()     // Catch:{ Exception -> 0x023d }
            r3.setText(r4)     // Catch:{ Exception -> 0x023d }
            com.amap.api.col.n3.fq r3 = r1.p     // Catch:{ Exception -> 0x023d }
            android.widget.TextView r3 = r3.q     // Catch:{ Exception -> 0x023d }
            java.lang.String r2 = r18.getCurrentRoadName()     // Catch:{ Exception -> 0x023d }
            r3.setText(r2)     // Catch:{ Exception -> 0x023d }
            return
        L_0x023d:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            return
        L_0x0243:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fp.onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo):void");
    }

    public final void onReCalculateRouteForTrafficJam() {
        this.b = null;
        this.s = -1;
        if (this.l != null) {
            this.l.removeAllCamera();
        }
    }

    public final void onReCalculateRouteForYaw() {
        this.b = null;
        this.s = -1;
        if (this.l != null) {
            this.l.removeAllCamera();
        }
    }

    private void i() {
        this.p.c(false);
    }

    public final void onStartNavi(int i2) {
        this.f = i2;
        this.p.F = false;
        this.p.a(true);
        this.p.D();
        this.p.k();
    }

    public final void onTrafficStatusUpdate() {
        a();
        if (this.q && System.currentTimeMillis() - this.a >= 10000) {
            List<AMapTrafficStatus> trafficStatuses = AMapNavi.getInstance(this.o).getTrafficStatuses(0, 0);
            this.q = this.q;
            if (this.j != null) {
                this.j.a(Boolean.valueOf(this.q), trafficStatuses);
            }
        }
    }

    public final void d() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public final void e() {
        if (this.k != null) {
            this.k.b();
        }
    }

    public final void c(boolean z2) {
        if (this.g != z2) {
            this.g = z2;
            if (this.k != null) {
                this.k.a(z2);
            }
        }
    }

    public final void f() {
        SoundPool soundPool = this.z;
        if (this.j != null) {
            this.j.d();
        }
        if (this.k != null) {
            this.k.d();
        }
        if (this.l != null) {
            this.l.destroy();
        }
        this.b = null;
    }

    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
        this.p.a(bArr, bArr2);
    }

    public final void hideLaneInfo() {
        this.p.i();
    }

    public final void notifyParallelRoad(int i2) {
        if (this.p != null) {
            this.p.d(i2);
        }
    }

    public final void carProjectionChange(AmapCarLocation amapCarLocation) {
        this.H = new LatLng(amapCarLocation.m_Latitude, amapCarLocation.m_Longitude);
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (this.k != null) {
            this.k.f();
        }
    }

    public final void h() {
        if (this.k != null) {
            this.k.g();
        }
    }

    public final void d(boolean z2) {
        this.v = z2;
    }

    public final void e(boolean z2) {
        this.y = z2;
    }

    public final void a(CameraPosition cameraPosition) {
        try {
            if (cameraPosition.zoom > 16.0f) {
                this.l.setAllCameraVisible(true);
                this.j.a(true);
                return;
            }
            this.l.setAllCameraVisible(false);
            this.j.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
