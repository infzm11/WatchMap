package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import com.amap.api.col.n3.ff;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
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
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.RouteOverlayOptions;
import com.amap.api.navi.view.AmapCameraOverlay;
import com.amap.api.navi.view.RouteOverLay;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.autonavi.tbt.TrafficFacilityInfo;

/* compiled from: NaviUIController */
public final class fg implements ff.a, MyNaviListener {
    private LatLng A;
    private LatLng B;
    private long a = 0;
    private NaviInfo b;
    private boolean c = false;
    private String d = "#ffffff";
    private String e = "#ffffff";
    private int f = 1;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private RouteOverLay j;
    private fe k;
    private AmapCameraOverlay l;
    private INavi m = null;
    private AMap n;
    private Context o;
    private eu p;
    private boolean q = false;
    private AMapNaviPath r;
    private int s = -1;
    private AMapNaviPath t;
    private int u;
    private ff v;
    private boolean w;
    private float x = 0.0f;
    private boolean y = false;
    private boolean z = false;

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    public final void notifyParallelRoad(int i2) {
    }

    public final void onGetNavigationText(String str) {
    }

    public final void onGpsOpenStatus(boolean z2) {
    }

    public final void onInitNaviFailure() {
    }

    public final void onInitNaviSuccess() {
    }

    public final void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo) {
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

    public fg(Context context, MapView mapView, eu euVar) {
        if (euVar != null) {
            this.o = context.getApplicationContext();
            this.j = new RouteOverLay(mapView.getMap(), (AMapNaviPath) null, this.o);
            this.k = new fe(mapView, euVar);
            this.l = new AmapCameraOverlay(context);
            this.m = AMapNavi.getInstance(this.o);
            this.p = euVar;
            this.n = mapView.getMap();
            AMap aMap = this.n;
            this.v = new ff(this.o);
            this.v.a((ff.a) this);
        }
    }

    public final void onArriveDestination() {
        if (this.f != 2) {
            if (this.j != null) {
                this.j.removeFromMap();
            }
            if (this.l != null) {
                this.l.destroy();
            }
            c(false);
            this.p.d();
            this.b = null;
            if (this.k != null) {
                this.k.e();
            }
            this.c = false;
        }
    }

    public final void onArrivedWayPoint(int i2) {
        "NaviUIControl-->onArrivedWayPoint(" + i2 + ")";
    }

    public final void onCalculateRouteFailure(int i2) {
        "NaviUIControl-->onCalculateRouteFailure(),errorCode=" + i2;
    }

    public final void onCalculateRouteSuccess(int[] iArr) {
        this.a = System.currentTimeMillis();
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
                this.k.b(this.m.getEngineType());
            }
            a();
            this.s = -1;
            hideCross();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.m != null) {
            this.r = this.m.getNaviPath();
            if (this.p != null && this.m.getEngineType() == 0) {
                TrafficBarView lazyTrafficBarView = this.p.getLazyTrafficBarView();
                if (!(this.r == null || lazyTrafficBarView == null)) {
                    lazyTrafficBarView.update(this.m.getTrafficStatuses(this.r.getAllLength() - this.u, this.r.getAllLength()), this.u);
                }
                if (this.r != null) {
                    a(this.p.p, this.u == 0 ? this.r.getAllLength() : this.u);
                    a(this.p.f(), this.u == 0 ? this.r.getAllLength() : this.u);
                }
            }
        }
    }

    private void a(TrafficProgressBar trafficProgressBar, int i2) {
        if (this.r != null && trafficProgressBar != null) {
            trafficProgressBar.update(this.r.getAllLength(), i2, this.m.getTrafficStatuses(0, 0));
        }
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
                this.j.setAMapNaviPath(aMapNaviPath);
                this.j.addToMap();
            }
            LatLng latLng = null;
            if (!(aMapNaviPath.getStartPoint() == null || aMapNaviPath.getEndPoint() == null)) {
                latLng = new LatLng(aMapNaviPath.getStartPoint().getLatitude(), aMapNaviPath.getStartPoint().getLongitude());
            }
            float a2 = hq.a(latLng, new LatLng(aMapNaviPath.getCoordList().get(1).getLatitude(), aMapNaviPath.getCoordList().get(1).getLongitude()));
            if (latLng != null) {
                this.k.c();
                fe feVar = this.k;
                AMap aMap = this.n;
                this.B = latLng;
                feVar.a(aMap, latLng, a2);
                if (aMapNaviPath.getEndPoint() != null) {
                    this.k.a(new LatLng(aMapNaviPath.getEndPoint().getLatitude(), aMapNaviPath.getEndPoint().getLongitude()));
                }
            }
            if (this.p.u != null) {
                this.p.u.setText(Html.fromHtml(hq.a(aMapNaviPath.getAllLength(), this.d, this.e)));
            }
            if (this.p.v != null) {
                this.p.v.setText(Html.fromHtml(hq.a(hq.b(aMapNaviPath.getAllTime()), this.d, this.e)));
            }
            this.t = aMapNaviPath;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.j == null) {
            return;
        }
        if (!this.h) {
            this.j.zoomToSpan(100, this.r);
            return;
        }
        this.j.setAMapNaviPath(this.r);
        this.j.zoomToSpan(hq.a(this.o, 65));
    }

    public final void onEndEmulatorNavi() {
        if (this.l != null) {
            this.l.destroy();
        }
    }

    public final void onGetNavigationText(int i2, String str) {
        "NaviUIControl-->onGetNavigationText(),msg=" + str;
    }

    public final void c() {
        this.j.setEmulateGPSLocationVisible();
    }

    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        if (aMapNaviLocation != null && this.m != null) {
            if (this.A != null && this.m.getEngineType() == 1 && this.m.getNaviType() == 1) {
                LatLng latLng = new LatLng(aMapNaviLocation.getCoord().getLatitude(), aMapNaviLocation.getCoord().getLongitude());
                if (!aMapNaviLocation.isMatchNaviPath()) {
                    this.j.drawGuideLink(latLng, this.A, true);
                } else {
                    this.j.drawGuideLink(latLng, this.A, false);
                    this.A = null;
                }
            }
            NaviLatLng coord = aMapNaviLocation.getCoord();
            float bearing = aMapNaviLocation.getBearing();
            LatLng latLng2 = new LatLng(coord.getLatitude(), coord.getLongitude());
            if (this.m.getEngineType() == 1 || this.m.getEngineType() == 2) {
                if (!this.w || !this.y) {
                    this.k.a(this.n, latLng2, bearing);
                } else {
                    this.B = latLng2;
                }
            } else if (this.m.getEngineType() == 0) {
                this.k.a(this.n, latLng2, bearing);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amap.api.navi.model.NaviLatLng} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: com.amap.api.navi.model.NaviLatLng} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c8 A[Catch:{ Throwable -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ca A[Catch:{ Throwable -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d8 A[Catch:{ Throwable -> 0x00f0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNaviInfoUpdate(com.amap.api.navi.model.NaviInfo r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x02a9
            com.amap.api.navi.INavi r0 = r14.m
            if (r0 != 0) goto L_0x0008
            goto L_0x02a9
        L_0x0008:
            r0 = 0
            r1 = 1
            com.amap.api.navi.INavi r2 = r14.m     // Catch:{ Throwable -> 0x00f0 }
            int r2 = r2.getEngineType()     // Catch:{ Throwable -> 0x00f0 }
            r3 = 2
            if (r2 == r1) goto L_0x001b
            com.amap.api.navi.INavi r2 = r14.m     // Catch:{ Throwable -> 0x00f0 }
            int r2 = r2.getEngineType()     // Catch:{ Throwable -> 0x00f0 }
            if (r2 != r3) goto L_0x00f4
        L_0x001b:
            int r2 = r15.getCurStep()     // Catch:{ Throwable -> 0x00f0 }
            com.amap.api.navi.INavi r4 = r14.m     // Catch:{ Throwable -> 0x00f0 }
            com.amap.api.navi.model.AMapNaviPath r4 = r4.getNaviPath()     // Catch:{ Throwable -> 0x00f0 }
            java.util.List r4 = r4.getSteps()     // Catch:{ Throwable -> 0x00f0 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Throwable -> 0x00f0 }
            com.amap.api.navi.model.AMapNaviStep r2 = (com.amap.api.navi.model.AMapNaviStep) r2     // Catch:{ Throwable -> 0x00f0 }
            java.util.List r2 = r2.getLinks()     // Catch:{ Throwable -> 0x00f0 }
            int r4 = r15.getCurLink()     // Catch:{ Throwable -> 0x00f0 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Throwable -> 0x00f0 }
            com.amap.api.navi.model.AMapNaviLink r2 = (com.amap.api.navi.model.AMapNaviLink) r2     // Catch:{ Throwable -> 0x00f0 }
            java.util.List r2 = r2.getCoords()     // Catch:{ Throwable -> 0x00f0 }
            com.amap.api.col.n3.fe r4 = r14.k     // Catch:{ Throwable -> 0x00f0 }
            if (r2 == 0) goto L_0x00eb
            int r5 = r2.size()     // Catch:{ Throwable -> 0x00f0 }
            if (r5 >= r3) goto L_0x004d
            goto L_0x00eb
        L_0x004d:
            int r5 = r2.size()     // Catch:{ Throwable -> 0x00f0 }
            r6 = 0
            if (r5 != r3) goto L_0x0062
            java.lang.Object r3 = r2.get(r0)     // Catch:{ Throwable -> 0x00f0 }
            r6 = r3
            com.amap.api.navi.model.NaviLatLng r6 = (com.amap.api.navi.model.NaviLatLng) r6     // Catch:{ Throwable -> 0x00f0 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Throwable -> 0x00f0 }
        L_0x005f:
            com.amap.api.navi.model.NaviLatLng r2 = (com.amap.api.navi.model.NaviLatLng) r2     // Catch:{ Throwable -> 0x00f0 }
            goto L_0x0072
        L_0x0062:
            if (r5 <= r3) goto L_0x0071
            java.lang.Object r3 = r2.get(r0)     // Catch:{ Throwable -> 0x00f0 }
            r6 = r3
            com.amap.api.navi.model.NaviLatLng r6 = (com.amap.api.navi.model.NaviLatLng) r6     // Catch:{ Throwable -> 0x00f0 }
            int r5 = r5 - r1
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Throwable -> 0x00f0 }
            goto L_0x005f
        L_0x0071:
            r2 = r6
        L_0x0072:
            com.autonavi.amap.mapcore.IPoint r3 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Throwable -> 0x00f0 }
            r3.<init>()     // Catch:{ Throwable -> 0x00f0 }
            com.autonavi.amap.mapcore.IPoint r5 = new com.autonavi.amap.mapcore.IPoint     // Catch:{ Throwable -> 0x00f0 }
            r5.<init>()     // Catch:{ Throwable -> 0x00f0 }
            double r7 = r6.getLongitude()     // Catch:{ Throwable -> 0x00f0 }
            double r9 = r6.getLatitude()     // Catch:{ Throwable -> 0x00f0 }
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r7, r9, r5)     // Catch:{ Throwable -> 0x00f0 }
            double r6 = r2.getLongitude()     // Catch:{ Throwable -> 0x00f0 }
            double r8 = r2.getLatitude()     // Catch:{ Throwable -> 0x00f0 }
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r6, r8, r3)     // Catch:{ Throwable -> 0x00f0 }
            int r2 = r3.x     // Catch:{ Throwable -> 0x00f0 }
            double r6 = (double) r2     // Catch:{ Throwable -> 0x00f0 }
            int r2 = r3.y     // Catch:{ Throwable -> 0x00f0 }
            double r2 = (double) r2     // Catch:{ Throwable -> 0x00f0 }
            int r8 = r5.x     // Catch:{ Throwable -> 0x00f0 }
            double r8 = (double) r8     // Catch:{ Throwable -> 0x00f0 }
            int r5 = r5.y     // Catch:{ Throwable -> 0x00f0 }
            double r10 = (double) r5     // Catch:{ Throwable -> 0x00f0 }
            double r8 = r8 - r6
            double r10 = r10 - r2
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = java.lang.Math.pow(r8, r2)     // Catch:{ Throwable -> 0x00f0 }
            double r2 = java.lang.Math.pow(r10, r2)     // Catch:{ Throwable -> 0x00f0 }
            double r5 = r5 + r2
            double r2 = java.lang.Math.sqrt(r5)     // Catch:{ Throwable -> 0x00f0 }
            double r2 = r8 / r2
            double r2 = java.lang.Math.acos(r2)     // Catch:{ Throwable -> 0x00f0 }
            r5 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r5 = r5 / r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r5 = r2 / r5
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ca
            double r2 = -r5
            goto L_0x00d4
        L_0x00ca:
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x00d3
            int r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r2 = r5
        L_0x00d4:
            int r5 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e3
            r5 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r2 = java.lang.Math.abs(r2)     // Catch:{ Throwable -> 0x00f0 }
            double r2 = r5 - r2
        L_0x00e3:
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r2 = r2 - r5
            float r2 = (float) r2     // Catch:{ Throwable -> 0x00f0 }
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            r4.a((float) r2)     // Catch:{ Throwable -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00f4:
            r14.b = r15
            com.amap.api.navi.model.NaviInfo r2 = r14.b
            int r2 = r2.getPathRetainDistance()
            r14.u = r2
            boolean r2 = r14.h
            if (r2 != 0) goto L_0x010a
            int r2 = r14.s
            int r3 = r15.getCurStep()
            if (r2 == r3) goto L_0x0133
        L_0x010a:
            com.amap.api.navi.view.RouteOverLay r2 = r14.j     // Catch:{ Throwable -> 0x0128 }
            int r3 = r15.getCurStep()     // Catch:{ Throwable -> 0x0128 }
            java.util.List r2 = r2.getArrowPoints(r3)     // Catch:{ Throwable -> 0x0128 }
            if (r2 == 0) goto L_0x0133
            int r3 = r2.size()     // Catch:{ Throwable -> 0x0128 }
            if (r3 <= 0) goto L_0x0133
            com.amap.api.navi.view.RouteOverLay r3 = r14.j     // Catch:{ Throwable -> 0x0128 }
            r3.drawArrow(r2)     // Catch:{ Throwable -> 0x0128 }
            int r2 = r15.getCurStep()     // Catch:{ Throwable -> 0x0128 }
            r14.s = r2     // Catch:{ Throwable -> 0x0128 }
            goto L_0x0133
        L_0x0128:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r3 = "NaviUIController"
            java.lang.String r4 = "drawArrow(NaviInfo naviInfo)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x0133:
            com.amap.api.navi.INavi r2 = r14.m
            int r2 = r2.getEngineType()
            if (r2 == 0) goto L_0x0166
            com.amap.api.navi.INavi r2 = r14.m
            int r2 = r2.getNaviType()
            if (r2 == r1) goto L_0x0166
            com.amap.api.navi.model.NaviLatLng r2 = r15.getCoord()
            int r3 = r15.getDirection()
            float r3 = (float) r3
            com.amap.api.maps.model.LatLng r10 = new com.amap.api.maps.model.LatLng
            double r5 = r2.getLatitude()
            double r7 = r2.getLongitude()
            r9 = 0
            r4 = r10
            r4.<init>(r5, r7, r9)
            com.amap.api.col.n3.fe r2 = r14.k
            if (r2 == 0) goto L_0x0166
            com.amap.api.col.n3.fe r2 = r14.k
            com.amap.api.maps.AMap r4 = r14.n
            r2.a(r4, r10, r3)
        L_0x0166:
            com.amap.api.col.n3.eu r2 = r14.p
            if (r2 != 0) goto L_0x016b
            return
        L_0x016b:
            com.amap.api.col.n3.eu r2 = r14.p
            r2.g()
            com.amap.api.col.n3.eu r2 = r14.p
            boolean r2 = r2.isAutoChangeZoom()
            if (r2 == 0) goto L_0x01ca
            int r2 = r15.getCurStep()
            if (r2 <= 0) goto L_0x01ca
            com.amap.api.col.n3.eu r2 = r14.p
            boolean r2 = r2.isRouteOverviewNow()
            if (r2 != 0) goto L_0x01ca
            int r2 = r15.getCurStepRetainDistance()
            r3 = 50
            if (r2 >= r3) goto L_0x01a9
            boolean r2 = r14.c
            if (r2 != 0) goto L_0x01a9
            com.amap.api.maps.CameraUpdate r2 = com.amap.api.maps.CameraUpdateFactory.zoomIn()
            com.amap.api.maps.AMap r4 = r14.n
            r4.moveCamera(r2)
            com.amap.api.col.n3.eu r2 = r14.p
            com.amap.api.col.n3.eu r4 = r14.p
            int r4 = r4.getLockZoom()
            int r4 = r4 + r1
            r2.setLockZoom(r4)
            r14.c = r1
        L_0x01a9:
            int r2 = r15.getCurStepRetainDistance()
            if (r2 <= r3) goto L_0x01ca
            boolean r2 = r14.c
            if (r2 == 0) goto L_0x01ca
            com.amap.api.maps.CameraUpdate r2 = com.amap.api.maps.CameraUpdateFactory.zoomOut()
            com.amap.api.maps.AMap r3 = r14.n
            r3.moveCamera(r2)
            com.amap.api.col.n3.eu r2 = r14.p
            com.amap.api.col.n3.eu r3 = r14.p
            int r3 = r3.getLockZoom()
            int r3 = r3 - r1
            r2.setLockZoom(r3)
            r14.c = r0
        L_0x01ca:
            com.amap.api.col.n3.eu r0 = r14.p
            com.amap.api.navi.view.NextTurnTipView r0 = r0.c
            if (r0 == 0) goto L_0x01db
            com.amap.api.col.n3.eu r0 = r14.p
            com.amap.api.navi.view.NextTurnTipView r0 = r0.c
            int r1 = r15.getIconType()
            r0.setIconType(r1)
        L_0x01db:
            com.amap.api.col.n3.eu r0 = r14.p
            com.amap.api.navi.view.NextTurnTipView r0 = r0.getLazyNextTurnTipView()
            if (r0 == 0) goto L_0x01f0
            com.amap.api.col.n3.eu r0 = r14.p
            com.amap.api.navi.view.NextTurnTipView r0 = r0.getLazyNextTurnTipView()
            int r1 = r15.getIconType()
            r0.setIconType(r1)
        L_0x01f0:
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.d
            if (r0 == 0) goto L_0x0205
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.d
            int r1 = r15.getCurStepRetainDistance()
            java.lang.String r1 = com.amap.api.col.n3.hq.a((int) r1)
            r0.setText(r1)
        L_0x0205:
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.e
            if (r0 == 0) goto L_0x0216
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.e
            java.lang.String r1 = r15.getNextRoadName()
            r0.setText(r1)
        L_0x0216:
            int r0 = r15.getPathRetainTime()
            java.lang.String r0 = com.amap.api.col.n3.hq.b((int) r0)
            java.lang.String r1 = r14.d
            java.lang.String r2 = r14.e
            java.lang.String r1 = com.amap.api.col.n3.hq.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            int r2 = r15.getPathRetainDistance()
            java.lang.String r3 = r14.d
            java.lang.String r4 = r14.e
            java.lang.String r2 = com.amap.api.col.n3.hq.a((int) r2, (java.lang.String) r3, (java.lang.String) r4)
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "<big>距离终点:</big><big><big>"
            r3.<init>(r4)
            java.lang.String r0 = com.amap.api.col.n3.hq.a((java.lang.String) r0)
            r3.append(r0)
            java.lang.String r0 = " "
            r3.append(r0)
            int r15 = r15.getPathRetainDistance()
            java.lang.String r15 = com.amap.api.col.n3.hq.a((int) r15)
            r3.append(r15)
            java.lang.String r15 = "</big></big>"
            r3.append(r15)
            java.lang.String r15 = r3.toString()
            android.text.Spanned r15 = android.text.Html.fromHtml(r15)
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.f
            if (r0 == 0) goto L_0x0272
            com.amap.api.col.n3.eu r0 = r14.p
            android.widget.TextView r0 = r0.f
            r0.setText(r15)
        L_0x0272:
            com.amap.api.col.n3.eu r15 = r14.p
            android.widget.TextView r15 = r15.u
            if (r15 == 0) goto L_0x027f
            com.amap.api.col.n3.eu r15 = r14.p
            android.widget.TextView r15 = r15.u
            r15.setText(r2)
        L_0x027f:
            com.amap.api.col.n3.eu r15 = r14.p
            android.widget.TextView r15 = r15.v
            if (r15 == 0) goto L_0x028c
            com.amap.api.col.n3.eu r15 = r14.p
            android.widget.TextView r15 = r15.v
            r15.setText(r1)
        L_0x028c:
            com.amap.api.navi.INavi r15 = r14.m
            int r15 = r15.getEngineType()
            if (r15 != 0) goto L_0x02a8
            com.amap.api.col.n3.eu r15 = r14.p
            com.amap.api.navi.view.TrafficProgressBar r15 = r15.p
            int r0 = r14.u
            r14.a((com.amap.api.navi.view.TrafficProgressBar) r15, (int) r0)
            com.amap.api.col.n3.eu r15 = r14.p
            com.amap.api.navi.view.TrafficProgressBar r15 = r15.f()
            int r0 = r14.u
            r14.a((com.amap.api.navi.view.TrafficProgressBar) r15, (int) r0)
        L_0x02a8:
            return
        L_0x02a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fg.onNaviInfoUpdate(com.amap.api.navi.model.NaviInfo):void");
    }

    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
        try {
            if (this.z) {
                RouteOverlayOptions routeOverlayOptions = this.j.getRouteOverlayOptions();
                if (routeOverlayOptions == null || routeOverlayOptions.isShowCameOnRoute()) {
                    if (this.b != null) {
                        this.b.getCurrentSpeed();
                    }
                    this.l.draw(this.n, aMapNaviCameraInfoArr);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showCross(AMapNaviCross aMapNaviCross) {
        if (this.p.getLazyZoomInIntersectionView() != null) {
            this.p.getLazyZoomInIntersectionView().setImageBitmap(aMapNaviCross.getBitmap());
            this.p.getLazyZoomInIntersectionView().setVisibility(0);
        }
        this.p.a(aMapNaviCross);
    }

    public final void hideCross() {
        if (this.p.getLazyZoomInIntersectionView() != null) {
            this.p.getLazyZoomInIntersectionView().setVisibility(8);
        }
        this.p.b();
    }

    public final void showModeCross(AMapModelCross aMapModelCross) {
        this.p.a(aMapModelCross);
    }

    public final void hideModeCross() {
        this.p.c();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        this.d = str;
        this.e = str2;
        if (this.b != null) {
            if (this.p.u != null) {
                this.p.u.setText(Html.fromHtml(hq.a(this.b.getPathRetainDistance(), this.d, this.e)));
            }
            if (this.p.v != null) {
                this.p.v.setText(Html.fromHtml(hq.a(hq.b(this.b.getPathRetainTime()), this.d, this.e)));
            }
        }
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
        this.p.getViewOptions().isReCalculateRouteForYaw();
        if (this.l != null) {
            this.l.removeAllCamera();
        }
    }

    public final void onStartNavi(int i2) {
        this.f = i2;
        this.p.J = false;
        this.p.a(true);
        this.p.e();
        this.p.a();
        if (this.m != null && this.m.getEngineType() != 0 && 1 == this.f && this.w) {
            this.v.a();
        }
    }

    public final void onTrafficStatusUpdate() {
        a();
        if (this.q && System.currentTimeMillis() - this.a >= 10000 && this.j != null && this.m != null) {
            AMapNaviPath aMapNaviPath = this.j.getAMapNaviPath();
            "onTrafficStatusUpdate------>" + this.j.getAMapNaviPath().toString();
            if (aMapNaviPath != null) {
                aMapNaviPath.setTrafficStatus(this.m.getTrafficStatuses(0, 0));
                this.j.setTrafficLine(Boolean.valueOf(this.q));
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
        if (this.j != null) {
            this.j.destroy();
        }
        if (this.k != null) {
            this.k.d();
        }
        if (this.l != null) {
            this.l.destroy();
        }
        if (this.v != null) {
            this.v.b();
            this.v = null;
        }
    }

    public final void a(Bitmap bitmap) {
        if (this.j != null && bitmap != null) {
            this.j.setStartPointBitmap(bitmap);
        }
    }

    public final void b(Bitmap bitmap) {
        if (this.j != null && bitmap != null) {
            this.j.setEndPointBitmap(bitmap);
        }
    }

    public final void c(Bitmap bitmap) {
        if (this.j != null && bitmap != null) {
            this.j.setWayPointBitmap(bitmap);
        }
    }

    public final void d(Bitmap bitmap) {
        if (this.l != null && bitmap != null) {
            this.l.setCameraBitmap(bitmap);
        }
    }

    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
        if (this.p.getLazyDriveWayView() != null) {
            this.p.getLazyDriveWayView().loadDriveWayBitmap(bArr, bArr2);
            this.p.getLazyDriveWayView().setVisibility(0);
        }
        if (this.p.K && this.i && !this.p.L && bArr != null && bArr2 != null && this.p.B != null && this.p.a.getVisibility() != 0) {
            this.p.B.loadDriveWayBitmap(bArr, bArr2);
            this.p.B.setDefaultTopMargin(this.p.e.getHeight());
            this.p.B.setVisibility(0);
        }
    }

    public final void hideLaneInfo() {
        if (this.p.getLazyDriveWayView() != null) {
            this.p.getLazyDriveWayView().setVisibility(8);
            this.p.getLazyDriveWayView().recycleResource();
        }
        if (this.p.K && this.i && this.p.B != null) {
            this.p.B.setVisibility(8);
            this.p.B.recycleResource();
        }
    }

    public final void carProjectionChange(AmapCarLocation amapCarLocation) {
        this.A = new LatLng(amapCarLocation.m_Latitude, amapCarLocation.m_Longitude);
    }

    /* access modifiers changed from: package-private */
    public final void d(boolean z2) {
        this.q = z2;
        if (this.j != null && this.m != null) {
            this.j.setTrafficLine(Boolean.valueOf(this.q));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.k != null) {
            this.k.a(i2);
        }
    }

    public final void g() {
        if (this.k != null) {
            this.k.f();
        }
    }

    public final void e(Bitmap bitmap) {
        if (this.k != null && bitmap != null) {
            this.k.a(bitmap);
        }
    }

    public final void f(Bitmap bitmap) {
        boolean z2 = false;
        boolean z3 = this.k != null;
        if (bitmap != null) {
            z2 = true;
        }
        if (z3 && z2) {
            this.k.b(bitmap);
        }
    }

    public final void a(RouteOverlayOptions routeOverlayOptions) {
        if (this.j != null) {
            this.j.setRouteOverlayOptions(routeOverlayOptions);
        }
    }

    public final void e(boolean z2) {
        this.w = z2;
    }

    public final void f(boolean z2) {
        this.z = z2;
    }

    public final void a(boolean z2, float f2) {
        this.y = z2;
        if (this.k != null) {
            this.k.a(this.n, this.B, f2);
        }
    }
}
