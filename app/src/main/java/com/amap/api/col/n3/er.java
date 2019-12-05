package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.route.model.RoutePoi;
import com.autonavi.ae.route.observer.HttpInterface;
import com.autonavi.ae.route.observer.PathRequestObserver;
import com.autonavi.ae.route.observer.RouteObserver;
import com.autonavi.ae.route.route.CalcRouteResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MyRouteObserver */
public final class er implements HttpInterface, PathRequestObserver, RouteObserver {
    /* access modifiers changed from: private */
    public em a;
    private CalcRouteResult b;
    private int[] c;
    private Map<Integer, NaviPath> d = new HashMap();
    private Map<Integer, Long> e = new HashMap();
    private int f = -1;
    private ep g;
    private Handler h = null;

    private static int a(int i, int i2) {
        if (i2 == 35) {
            return 10;
        }
        if (i == 13) {
            return 53;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return i + 1;
            case 9:
                return 51;
            case 10:
                return 52;
            default:
                return i;
        }
    }

    public final boolean requestHttpGet(int i, int i2, String str) {
        return false;
    }

    public final Map<Integer, Long> a() {
        return this.e;
    }

    public final Map<Integer, NaviPath> b() {
        return this.d;
    }

    public final int[] c() {
        return this.c;
    }

    public er(em emVar) {
        try {
            this.a = emVar;
            this.g = emVar.o();
            if (this.h == null) {
                this.h = new Handler(emVar.e().getMainLooper()) {
                    public final void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message.what == 1) {
                            try {
                                if (message.obj == null) {
                                    return;
                                }
                                if (er.this.a != null) {
                                    es esVar = (es) message.obj;
                                    if (esVar.b != null) {
                                        er.this.a.g().processHttpData(esVar.a, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, esVar.b);
                                    } else {
                                        er.this.a.g().processHttpError(esVar.a, -1);
                                    }
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                };
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void d() {
        if (this.b != null) {
            this.b.destroy();
        }
        if (this.d != null) {
            this.d.clear();
        }
        if (this.e != null) {
            this.e.clear();
        }
        this.h = null;
    }

    public final void onPathChanged(int i) {
        "MyRouteObserver-->onPathChanged,err=" + i;
    }

    private void a(CalcRouteResult calcRouteResult, RoutePoi[] routePoiArr, boolean z) {
        if (calcRouteResult != null) {
            try {
                List<NaviLatLng> a2 = eo.a(routePoiArr);
                int routeCount = calcRouteResult.getRouteCount();
                if (routeCount > 0) {
                    this.e.clear();
                    this.d.clear();
                    if (z) {
                        this.c = new int[routeCount];
                        for (int i = 0; i < routeCount; i++) {
                            NaviPath a3 = a(calcRouteResult.getRoute(i), a2);
                            int i2 = i + 12;
                            this.c[i] = i2;
                            this.e.put(Integer.valueOf(i2), Long.valueOf(a3.getId()));
                            this.d.put(Integer.valueOf(i2), a3);
                        }
                        return;
                    }
                    this.c = new int[1];
                    NaviPath a4 = a(calcRouteResult.getRoute(0), a2);
                    this.c[0] = 12;
                    this.e.put(12, Long.valueOf(a4.getId()));
                    this.d.put(12, a4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x030a A[Catch:{ Throwable -> 0x037a, Throwable -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[Catch:{ Throwable -> 0x037a, Throwable -> 0x03cf }, LOOP:1: B:19:0x0045->B:20:0x0047, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[Catch:{ Throwable -> 0x037a, Throwable -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[Catch:{ Throwable -> 0x037a, Throwable -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0110 A[Catch:{ Throwable -> 0x037a, Throwable -> 0x03cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.amap.api.navi.model.NaviPath a(com.autonavi.ae.route.route.Route r29, java.util.List<com.amap.api.navi.model.NaviLatLng> r30) {
        /*
            r1 = r29
            com.autonavi.ae.route.model.LabelInfo[] r2 = r29.getPathLabel()     // Catch:{ Throwable -> 0x03cf }
            java.lang.String r3 = ""
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0035 }
            r6.<init>()     // Catch:{ Throwable -> 0x0035 }
            int r7 = r2.length     // Catch:{ Throwable -> 0x0035 }
            r8 = r4
        L_0x0013:
            if (r8 >= r7) goto L_0x0024
            r9 = r2[r8]     // Catch:{ Throwable -> 0x0035 }
            java.lang.String r9 = r9.mContent     // Catch:{ Throwable -> 0x0035 }
            r6.append(r9)     // Catch:{ Throwable -> 0x0035 }
            java.lang.String r9 = ","
            r6.append(r9)     // Catch:{ Throwable -> 0x0035 }
            int r8 = r8 + 1
            goto L_0x0013
        L_0x0024:
            java.lang.String r2 = r6.toString()     // Catch:{ Throwable -> 0x0035 }
            int r3 = r2.length()     // Catch:{ Throwable -> 0x0032 }
            int r3 = r3 - r5
            java.lang.String r3 = r2.substring(r4, r3)     // Catch:{ Throwable -> 0x0032 }
            goto L_0x003a
        L_0x0032:
            r0 = move-exception
            r3 = r2
            goto L_0x0036
        L_0x0035:
            r0 = move-exception
        L_0x0036:
            r2 = r0
            r2.printStackTrace()     // Catch:{ Throwable -> 0x03cf }
        L_0x003a:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r2.<init>()     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.TmcBarItem[] r6 = r29.getTmcBarItem()     // Catch:{ Throwable -> 0x03cf }
            int r7 = r6.length     // Catch:{ Throwable -> 0x03cf }
            r8 = r4
        L_0x0045:
            if (r8 >= r7) goto L_0x0054
            r9 = r6[r8]     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.AMapTrafficStatus r10 = new com.amap.api.navi.model.AMapTrafficStatus     // Catch:{ Throwable -> 0x03cf }
            r10.<init>(r9)     // Catch:{ Throwable -> 0x03cf }
            r2.add(r10)     // Catch:{ Throwable -> 0x03cf }
            int r8 = r8 + 1
            goto L_0x0045
        L_0x0054:
            com.autonavi.ae.route.model.RouteCamera[] r6 = r29.getAllCamera()     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r7.<init>()     // Catch:{ Throwable -> 0x03cf }
            if (r6 == 0) goto L_0x0070
            r8 = r4
        L_0x0060:
            int r9 = r6.length     // Catch:{ Throwable -> 0x03cf }
            if (r8 >= r9) goto L_0x0070
            com.amap.api.navi.model.AMapNaviCameraInfo r9 = new com.amap.api.navi.model.AMapNaviCameraInfo     // Catch:{ Throwable -> 0x03cf }
            r10 = r6[r8]     // Catch:{ Throwable -> 0x03cf }
            r9.<init>((com.autonavi.ae.route.model.RouteCamera) r10)     // Catch:{ Throwable -> 0x03cf }
            r7.add(r9)     // Catch:{ Throwable -> 0x03cf }
            int r8 = r8 + 1
            goto L_0x0060
        L_0x0070:
            com.amap.api.navi.model.NaviPath r6 = new com.amap.api.navi.model.NaviPath     // Catch:{ Throwable -> 0x03cf }
            r6.<init>()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.AMapNaviPath r8 = r6.amapNaviPath     // Catch:{ Throwable -> 0x03cf }
            int r9 = r30.size()     // Catch:{ Throwable -> 0x03cf }
            int[] r9 = new int[r9]     // Catch:{ Throwable -> 0x03cf }
            r8.wayPointIndex = r9     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.GeoPoint r8 = r29.findCarToFootPoint()     // Catch:{ Throwable -> 0x03cf }
            if (r8 == 0) goto L_0x0095
            com.amap.api.navi.model.NaviLatLng r9 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            double r10 = r8.getLatitude()     // Catch:{ Throwable -> 0x03cf }
            double r12 = r8.getLongitude()     // Catch:{ Throwable -> 0x03cf }
            r9.<init>(r10, r12)     // Catch:{ Throwable -> 0x03cf }
            r6.setCarToFootPoint(r9)     // Catch:{ Throwable -> 0x03cf }
        L_0x0095:
            int r8 = r29.getDataVersion()     // Catch:{ Throwable -> 0x03cf }
            r6.setDataVersion(r8)     // Catch:{ Throwable -> 0x03cf }
            r6.setTrafficStatus(r2)     // Catch:{ Throwable -> 0x03cf }
            long r8 = r29.getRouteId()     // Catch:{ Throwable -> 0x03cf }
            r6.setId(r8)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getRouteLength()     // Catch:{ Throwable -> 0x03cf }
            r6.setAllLength(r2)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getRouteTime()     // Catch:{ Throwable -> 0x03cf }
            r6.setAllTime(r2)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getSegmentCount()     // Catch:{ Throwable -> 0x03cf }
            r6.setStepsCount(r2)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getTollCost()     // Catch:{ Throwable -> 0x03cf }
            r6.setTollCost(r2)     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.GeoPoint r2 = r29.getEndPoint()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r8 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            double r9 = r2.getLatitude()     // Catch:{ Throwable -> 0x03cf }
            double r11 = r2.getLongitude()     // Catch:{ Throwable -> 0x03cf }
            r8.<init>(r9, r11)     // Catch:{ Throwable -> 0x03cf }
            r6.setEndPoint(r8)     // Catch:{ Throwable -> 0x03cf }
            r2 = r30
            r6.setWayPoint(r2)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getRouteStrategy()     // Catch:{ Throwable -> 0x03cf }
            r6.setStrategy(r2)     // Catch:{ Throwable -> 0x03cf }
            r6.setLabels(r3)     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.RestrictionInfo r2 = r29.getRestrictionInfo()     // Catch:{ Throwable -> 0x03cf }
            r6.setRestrictionInfo(r2)     // Catch:{ Throwable -> 0x03cf }
            r6.setCameras(r7)     // Catch:{ Throwable -> 0x03cf }
            int[] r2 = r29.getCityAdcodeList()     // Catch:{ Throwable -> 0x03cf }
            r6.setCityAdcodeList(r2)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r29.getSegmentCount()     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r3.<init>()     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r7.<init>()     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r8.<init>()     // Catch:{ Throwable -> 0x03cf }
            r9 = -1
            r12 = r4
            r10 = r9
            r11 = r10
            r9 = r12
        L_0x010e:
            if (r9 >= r2) goto L_0x02d1
            com.amap.api.navi.model.AMapNaviStep r15 = new com.amap.api.navi.model.AMapNaviStep     // Catch:{ Throwable -> 0x03cf }
            r15.<init>()     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.route.RouteSegment r13 = r1.getSegment(r9)     // Catch:{ Throwable -> 0x03cf }
            int r4 = r13.getSegChargeLength()     // Catch:{ Throwable -> 0x03cf }
            r15.setChargeLength(r4)     // Catch:{ Throwable -> 0x03cf }
            int r4 = r13.getSegTime()     // Catch:{ Throwable -> 0x03cf }
            r15.setTime(r4)     // Catch:{ Throwable -> 0x03cf }
            int r4 = r13.getMainAction()     // Catch:{ Throwable -> 0x03cf }
            int r14 = r13.getAssistAction()     // Catch:{ Throwable -> 0x03cf }
            int r4 = a((int) r4, (int) r14)     // Catch:{ Throwable -> 0x03cf }
            r15.setIconType(r4)     // Catch:{ Throwable -> 0x03cf }
            double[] r4 = r13.getSegCoor()     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r14.<init>()     // Catch:{ Throwable -> 0x03cf }
            int r5 = r10 + 1
            r15.setStartIndex(r5)     // Catch:{ Throwable -> 0x03cf }
            if (r4 == 0) goto L_0x0173
            r17 = r2
            r5 = 0
        L_0x0149:
            int r2 = r4.length     // Catch:{ Throwable -> 0x03cf }
            r16 = 1
            int r2 = r2 + -1
            if (r5 >= r2) goto L_0x0175
            com.amap.api.navi.model.NaviLatLng r2 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            int r18 = r5 + 1
            r19 = r11
            r20 = r12
            r11 = r4[r18]     // Catch:{ Throwable -> 0x03cf }
            r21 = r6
            r22 = r7
            r6 = r4[r5]     // Catch:{ Throwable -> 0x03cf }
            r2.<init>(r11, r6)     // Catch:{ Throwable -> 0x03cf }
            r14.add(r2)     // Catch:{ Throwable -> 0x03cf }
            int r10 = r10 + 1
            int r5 = r5 + 2
            r11 = r19
            r12 = r20
            r6 = r21
            r7 = r22
            goto L_0x0149
        L_0x0173:
            r17 = r2
        L_0x0175:
            r21 = r6
            r22 = r7
            r19 = r11
            r20 = r12
            r15.setEndIndex(r10)     // Catch:{ Throwable -> 0x03cf }
            r15.setCoords(r14)     // Catch:{ Throwable -> 0x03cf }
            r8.addAll(r14)     // Catch:{ Throwable -> 0x03cf }
            int r2 = r13.getSegLength()     // Catch:{ Throwable -> 0x03cf }
            r15.setLength(r2)     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r2.<init>()     // Catch:{ Throwable -> 0x03cf }
            int r4 = r13.getLinkCount()     // Catch:{ Throwable -> 0x03cf }
            r11 = r19
            r5 = 0
        L_0x0199:
            if (r5 >= r4) goto L_0x028f
            int r11 = r11 + 1
            com.autonavi.ae.route.route.RouteLink r6 = r13.getLink(r5)     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.AMapNaviLink r7 = new com.amap.api.navi.model.AMapNaviLink     // Catch:{ Throwable -> 0x03cf }
            r7.<init>()     // Catch:{ Throwable -> 0x03cf }
            int r12 = r6.getLinkTime()     // Catch:{ Throwable -> 0x03cf }
            r7.setTime(r12)     // Catch:{ Throwable -> 0x03cf }
            int r12 = r6.getLinkRoadClass()     // Catch:{ Throwable -> 0x03cf }
            r7.setRoadClass(r12)     // Catch:{ Throwable -> 0x03cf }
            java.lang.String r12 = r6.getLinkRoadName()     // Catch:{ Throwable -> 0x03cf }
            r7.setRoadName(r12)     // Catch:{ Throwable -> 0x03cf }
            int r12 = r6.getLinkOwnership()     // Catch:{ Throwable -> 0x03cf }
            r7.setOwnership(r12)     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.FormWay r12 = r6.getLinkFormWay()     // Catch:{ Throwable -> 0x03cf }
            if (r12 != 0) goto L_0x01ca
        L_0x01c8:
            r12 = 1
            goto L_0x0208
        L_0x01ca:
            int[] r14 = com.amap.api.col.n3.er.AnonymousClass2.a     // Catch:{ Throwable -> 0x03cf }
            int r12 = r12.ordinal()     // Catch:{ Throwable -> 0x03cf }
            r12 = r14[r12]     // Catch:{ Throwable -> 0x03cf }
            switch(r12) {
                case 1: goto L_0x01c8;
                case 2: goto L_0x0207;
                case 3: goto L_0x0205;
                case 4: goto L_0x0203;
                case 5: goto L_0x0201;
                case 6: goto L_0x01ff;
                case 7: goto L_0x01fd;
                case 8: goto L_0x01fa;
                case 9: goto L_0x01f7;
                case 10: goto L_0x01f4;
                case 11: goto L_0x01f1;
                case 12: goto L_0x01ee;
                case 13: goto L_0x01eb;
                case 14: goto L_0x01e8;
                case 15: goto L_0x01e5;
                case 16: goto L_0x01e2;
                case 17: goto L_0x01df;
                case 18: goto L_0x01dc;
                case 19: goto L_0x01d9;
                case 20: goto L_0x01d6;
                default: goto L_0x01d5;
            }     // Catch:{ Throwable -> 0x03cf }
        L_0x01d5:
            goto L_0x01c8
        L_0x01d6:
            r12 = 58
            goto L_0x0208
        L_0x01d9:
            r12 = 56
            goto L_0x0208
        L_0x01dc:
            r12 = 53
            goto L_0x0208
        L_0x01df:
            r12 = 17
            goto L_0x0208
        L_0x01e2:
            r12 = 16
            goto L_0x0208
        L_0x01e5:
            r12 = 15
            goto L_0x0208
        L_0x01e8:
            r12 = 14
            goto L_0x0208
        L_0x01eb:
            r12 = 13
            goto L_0x0208
        L_0x01ee:
            r12 = 12
            goto L_0x0208
        L_0x01f1:
            r12 = 11
            goto L_0x0208
        L_0x01f4:
            r12 = 10
            goto L_0x0208
        L_0x01f7:
            r12 = 9
            goto L_0x0208
        L_0x01fa:
            r12 = 8
            goto L_0x0208
        L_0x01fd:
            r12 = 7
            goto L_0x0208
        L_0x01ff:
            r12 = 6
            goto L_0x0208
        L_0x0201:
            r12 = 5
            goto L_0x0208
        L_0x0203:
            r12 = 4
            goto L_0x0208
        L_0x0205:
            r12 = 3
            goto L_0x0208
        L_0x0207:
            r12 = 2
        L_0x0208:
            r7.setRoadType(r12)     // Catch:{ Throwable -> 0x03cf }
            boolean r12 = r6.haveTrafficLights()     // Catch:{ Throwable -> 0x03cf }
            r7.setTrafficLights(r12)     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.LinkStatus r12 = r6.getLinkTrafficStatus()     // Catch:{ Throwable -> 0x03cf }
            int r12 = r12.length     // Catch:{ Throwable -> 0x03cf }
            r7.setLength(r12)     // Catch:{ Throwable -> 0x03cf }
            double[] r12 = r6.getLinkCoor()     // Catch:{ Throwable -> 0x03cf }
            boolean r6 = r6.haveTrafficLights()     // Catch:{ Throwable -> 0x03cf }
            if (r6 == 0) goto L_0x0245
            int r6 = r12.length     // Catch:{ Throwable -> 0x03cf }
            r14 = 1
            if (r6 <= r14) goto L_0x0245
            int r6 = r12.length     // Catch:{ Throwable -> 0x03cf }
            int r6 = r6 - r14
            r23 = r10
            r24 = r11
            r10 = r12[r6]     // Catch:{ Throwable -> 0x03cf }
            int r6 = r12.length     // Catch:{ Throwable -> 0x03cf }
            r14 = 2
            int r6 = r6 - r14
            r25 = r8
            r26 = r9
            r8 = r12[r6]     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r6 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            r6.<init>(r10, r8)     // Catch:{ Throwable -> 0x03cf }
            r8 = r22
            r8.add(r6)     // Catch:{ Throwable -> 0x03cf }
            goto L_0x024f
        L_0x0245:
            r25 = r8
            r26 = r9
            r23 = r10
            r24 = r11
            r8 = r22
        L_0x024f:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r6.<init>()     // Catch:{ Throwable -> 0x03cf }
            r9 = 0
        L_0x0255:
            int r10 = r12.length     // Catch:{ Throwable -> 0x03cf }
            r11 = 1
            int r10 = r10 - r11
            if (r9 >= r10) goto L_0x0273
            int r10 = r9 + 1
            r10 = r12[r10]     // Catch:{ Throwable -> 0x03cf }
            r27 = r3
            r28 = r4
            r3 = r12[r9]     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r14 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            r14.<init>(r10, r3)     // Catch:{ Throwable -> 0x03cf }
            r6.add(r14)     // Catch:{ Throwable -> 0x03cf }
            int r9 = r9 + 2
            r3 = r27
            r4 = r28
            goto L_0x0255
        L_0x0273:
            r27 = r3
            r28 = r4
            r7.setCoords(r6)     // Catch:{ Throwable -> 0x03cf }
            r2.add(r7)     // Catch:{ Throwable -> 0x03cf }
            int r5 = r5 + 1
            r22 = r8
            r10 = r23
            r11 = r24
            r8 = r25
            r9 = r26
            r3 = r27
            r4 = r28
            goto L_0x0199
        L_0x028f:
            r27 = r3
            r25 = r8
            r26 = r9
            r23 = r10
            r8 = r22
            int r3 = r13.getAssistAction()     // Catch:{ Exception -> 0x02b1 }
            r4 = 35
            if (r3 != r4) goto L_0x02ae
            r3 = r21
            com.amap.api.navi.model.AMapNaviPath r4 = r3.amapNaviPath     // Catch:{ Exception -> 0x02ac }
            int[] r4 = r4.wayPointIndex     // Catch:{ Exception -> 0x02ac }
            r4[r20] = r11     // Catch:{ Exception -> 0x02ac }
            int r12 = r20 + 1
            goto L_0x02ba
        L_0x02ac:
            r0 = move-exception
            goto L_0x02b4
        L_0x02ae:
            r3 = r21
            goto L_0x02b8
        L_0x02b1:
            r0 = move-exception
            r3 = r21
        L_0x02b4:
            r4 = r0
            r4.printStackTrace()     // Catch:{ Throwable -> 0x03cf }
        L_0x02b8:
            r12 = r20
        L_0x02ba:
            r15.setLinks(r2)     // Catch:{ Throwable -> 0x03cf }
            r2 = r27
            r2.add(r15)     // Catch:{ Throwable -> 0x03cf }
            int r9 = r26 + 1
            r6 = r3
            r7 = r8
            r10 = r23
            r8 = r25
            r4 = 0
            r5 = 1
            r3 = r2
            r2 = r17
            goto L_0x010e
        L_0x02d1:
            r2 = r3
            r3 = r6
            r25 = r8
            r8 = r7
            com.amap.api.navi.model.NaviLatLng r4 = r3.getMinCoordForPath()     // Catch:{ Throwable -> 0x03cf }
            double r17 = r4.getLatitude()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r4 = r3.getMinCoordForPath()     // Catch:{ Throwable -> 0x03cf }
            double r19 = r4.getLongitude()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r4 = r3.getMaxCoordForPath()     // Catch:{ Throwable -> 0x03cf }
            double r21 = r4.getLatitude()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r4 = r3.getMaxCoordForPath()     // Catch:{ Throwable -> 0x03cf }
            double r23 = r4.getLongitude()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r4 = com.amap.api.col.n3.hq.a(r17, r19, r21, r23)     // Catch:{ Throwable -> 0x03cf }
            r3.setCenter(r4)     // Catch:{ Throwable -> 0x03cf }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Throwable -> 0x03cf }
            r4.<init>()     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.GroupSegment[] r5 = r29.getGroupSegmentList()     // Catch:{ Throwable -> 0x03cf }
            int r6 = r5.length     // Catch:{ Throwable -> 0x037a }
            r7 = 0
        L_0x0308:
            if (r7 >= r6) goto L_0x037f
            r9 = r5[r7]     // Catch:{ Throwable -> 0x037a }
            com.amap.api.navi.model.NaviGuide r10 = new com.amap.api.navi.model.NaviGuide     // Catch:{ Throwable -> 0x037a }
            r10.<init>()     // Catch:{ Throwable -> 0x037a }
            int r11 = r9.startSegId     // Catch:{ Throwable -> 0x037a }
            com.autonavi.ae.route.route.RouteSegment r11 = r1.getSegment(r11)     // Catch:{ Throwable -> 0x037a }
            java.lang.String r12 = r9.groupName     // Catch:{ Throwable -> 0x037a }
            r10.setName(r12)     // Catch:{ Throwable -> 0x037a }
            int r12 = r9.distance     // Catch:{ Throwable -> 0x037a }
            r10.setLength(r12)     // Catch:{ Throwable -> 0x037a }
            int r12 = r9.toll     // Catch:{ Throwable -> 0x037a }
            r10.setToll(r12)     // Catch:{ Throwable -> 0x037a }
            int r12 = r9.startSegId     // Catch:{ Throwable -> 0x037a }
            r10.setStartSegId(r12)     // Catch:{ Throwable -> 0x037a }
            int r12 = r9.segCount     // Catch:{ Throwable -> 0x037a }
            r10.setSegCount(r12)     // Catch:{ Throwable -> 0x037a }
            int r12 = r9.startSegId     // Catch:{ Throwable -> 0x037a }
            int r9 = r9.segCount     // Catch:{ Throwable -> 0x037a }
            r13 = r12
            r14 = 0
        L_0x0336:
            int r15 = r9 + r12
            if (r13 >= r15) goto L_0x0348
            java.lang.Object r15 = r2.get(r13)     // Catch:{ Throwable -> 0x037a }
            com.amap.api.navi.model.AMapNaviStep r15 = (com.amap.api.navi.model.AMapNaviStep) r15     // Catch:{ Throwable -> 0x037a }
            int r15 = r15.getTime()     // Catch:{ Throwable -> 0x037a }
            int r14 = r14 + r15
            int r13 = r13 + 1
            goto L_0x0336
        L_0x0348:
            r10.setTime(r14)     // Catch:{ Throwable -> 0x037a }
            com.amap.api.navi.model.NaviLatLng r9 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x037a }
            com.autonavi.ae.route.model.GeoPoint r12 = r11.getStartPoint()     // Catch:{ Throwable -> 0x037a }
            double r12 = r12.getLatitude()     // Catch:{ Throwable -> 0x037a }
            com.autonavi.ae.route.model.GeoPoint r14 = r11.getStartPoint()     // Catch:{ Throwable -> 0x037a }
            double r14 = r14.getLongitude()     // Catch:{ Throwable -> 0x037a }
            r9.<init>(r12, r14)     // Catch:{ Throwable -> 0x037a }
            r10.setCoord(r9)     // Catch:{ Throwable -> 0x037a }
            int r9 = r11.getMainAction()     // Catch:{ Throwable -> 0x037a }
            r11 = 0
            int r9 = a((int) r9, (int) r11)     // Catch:{ Throwable -> 0x037a }
            r10.setIconType(r9)     // Catch:{ Throwable -> 0x037a }
            com.amap.api.navi.model.AMapNaviGuide r9 = new com.amap.api.navi.model.AMapNaviGuide     // Catch:{ Throwable -> 0x037a }
            r9.<init>(r10)     // Catch:{ Throwable -> 0x037a }
            r4.add(r9)     // Catch:{ Throwable -> 0x037a }
            int r7 = r7 + 1
            goto L_0x0308
        L_0x037a:
            r0 = move-exception
            r5 = r0
            r5.printStackTrace()     // Catch:{ Throwable -> 0x03cf }
        L_0x037f:
            r3.setLightList(r8)     // Catch:{ Throwable -> 0x03cf }
            r3.setGuideList(r4)     // Catch:{ Throwable -> 0x03cf }
            r3.setListStep(r2)     // Catch:{ Throwable -> 0x03cf }
            com.autonavi.ae.route.model.GeoPoint r2 = r29.getStartPoint()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.navi.model.NaviLatLng r4 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x03cf }
            double r5 = r2.getLatitude()     // Catch:{ Throwable -> 0x03cf }
            double r7 = r2.getLongitude()     // Catch:{ Throwable -> 0x03cf }
            r4.<init>(r5, r7)     // Catch:{ Throwable -> 0x03cf }
            r3.setStartPoint(r4)     // Catch:{ Throwable -> 0x03cf }
            r2 = r25
            r3.setList(r2)     // Catch:{ Throwable -> 0x03cf }
            double[] r1 = r29.getRouteBound()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLngBounds$Builder r2 = com.amap.api.maps.model.LatLngBounds.builder()     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLng r4 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x03cf }
            r5 = 1
            r5 = r1[r5]     // Catch:{ Throwable -> 0x03cf }
            r7 = 0
            r7 = r1[r7]     // Catch:{ Throwable -> 0x03cf }
            r4.<init>(r5, r7)     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLngBounds$Builder r2 = r2.include(r4)     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLng r4 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x03cf }
            r5 = 3
            r5 = r1[r5]     // Catch:{ Throwable -> 0x03cf }
            r7 = 2
            r7 = r1[r7]     // Catch:{ Throwable -> 0x03cf }
            r4.<init>(r5, r7)     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLngBounds$Builder r1 = r2.include(r4)     // Catch:{ Throwable -> 0x03cf }
            com.amap.api.maps.model.LatLngBounds r1 = r1.build()     // Catch:{ Throwable -> 0x03cf }
            r3.setBounds(r1)     // Catch:{ Throwable -> 0x03cf }
            return r3
        L_0x03cf:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            java.lang.String r2 = "WTBTControl"
            java.lang.String r3 = "initNaviPath()"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.er.a(com.autonavi.ae.route.route.Route, java.util.List):com.amap.api.navi.model.NaviPath");
    }

    public final void onNewRoute(int i, CalcRouteResult calcRouteResult, Object obj, boolean z) {
        try {
            "MyRouteObserver-->onNewRoute(),type=" + i + ",count=" + calcRouteResult.getRouteCount();
            this.b = calcRouteResult;
            this.f = -1;
            switch (i) {
                case 1:
                    a(this.b, en.e(), this.a.d());
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    a(this.b, en.e(), false);
                    if (this.g != null) {
                        this.g.obtainMessage(30).sendToTarget();
                        break;
                    }
                    break;
                case 5:
                    a(this.b, en.e(), false);
                    if (this.g != null) {
                        this.g.obtainMessage(31).sendToTarget();
                        break;
                    }
                    break;
                case 6:
                    a(this.b, en.e(), false);
                    break;
            }
            if (this.g != null && this.c != null && this.c.length > 0) {
                this.a.c(this.c[0]);
                this.g.obtainMessage(28, this.c).sendToTarget();
            } else if (this.g != null) {
                this.g.obtainMessage(29, 19).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onNewRouteError(int i, int i2, Object obj, boolean z) {
        "MyRouteObserver-->onNewRouteError(),type=" + i + ",errorCode" + i2;
        if (i2 == 13) {
            i2 = this.f >= 0 ? this.f : 19;
        } else if (i2 == 16) {
            i2 = 2;
        } else if (i2 == 19) {
            i2 = 20;
        } else if (i2 == 23) {
            i2 = 27;
        }
        fk.a("v3/ae8/driving", i2);
        if (this.g != null && i2 != 27) {
            this.g.obtainMessage(29, Integer.valueOf(i2)).sendToTarget();
        }
    }

    public final boolean requestHttpPost(int i, int i2, String str, byte[] bArr) {
        es esVar;
        int i3 = i2;
        try {
            int[] iArr = new int[2];
            switch (en.g()) {
                case 0:
                    iArr[0] = 0;
                    iArr[1] = 266280;
                    break;
                case 1:
                    iArr[0] = 1;
                    iArr[1] = 790568;
                    break;
                case 2:
                    iArr[0] = 2;
                    iArr[1] = 266280;
                    break;
                case 3:
                    iArr[0] = 5;
                    iArr[1] = 266280;
                    break;
                case 4:
                    iArr[0] = 4;
                    iArr[1] = 266280;
                    break;
                case 5:
                    iArr[0] = 9;
                    iArr[1] = 266280;
                    break;
                case 6:
                    iArr[0] = 0;
                    iArr[1] = 2363432;
                    break;
                case 7:
                    iArr[0] = 1;
                    iArr[1] = 2363432;
                    break;
                case 8:
                    iArr[0] = 12;
                    iArr[1] = 266280;
                    break;
                case 9:
                    iArr[0] = 12;
                    iArr[1] = 2363432;
                    break;
                case 10:
                    iArr[0] = 13;
                    iArr[1] = 8786040;
                    break;
                case 11:
                    iArr[0] = 9;
                    iArr[1] = 8786040;
                    break;
                case 12:
                    iArr[0] = 4;
                    iArr[1] = 8786040;
                    break;
                case 13:
                    iArr[0] = 0;
                    iArr[1] = 10883192;
                    break;
                case 14:
                    iArr[0] = 1;
                    iArr[1] = 8786040;
                    break;
                case 15:
                    iArr[0] = 4;
                    iArr[1] = 10883192;
                    break;
                case 16:
                    iArr[0] = 1;
                    iArr[1] = 10883192;
                    break;
                case 17:
                    iArr[0] = 12;
                    iArr[1] = 8786040;
                    break;
                case 18:
                    iArr[0] = 12;
                    iArr[1] = 10883192;
                    break;
                case 19:
                    iArr[0] = 0;
                    iArr[1] = 8786042;
                    break;
                case 20:
                    iArr[0] = 4;
                    iArr[1] = 8786042;
                    break;
            }
            int i4 = iArr[0];
            int i5 = iArr[1];
            String str2 = new String(bArr, "UTF-8");
            String replaceAll = str2.replaceAll("Type=\"4\"", "Type=\"" + i4 + "\"");
            String replaceAll2 = replaceAll.replaceAll("Flag=\"135352\"", "Flag=\"" + i5 + "\"").replaceAll("Source=\"amap\"", "Source=\"amapapi\"");
            StringBuilder sb = new StringBuilder("MyRouteObserver-->requestHttpPost(请求参数)");
            sb.append(new String(replaceAll2.getBytes("UTF-8"), "UTF-8"));
            sb.toString();
            kl a2 = eo.a(this.a.e(), 1, eo.a("1.0", replaceAll2.getBytes("UTF-8")));
            this.f = fk.a(eo.a, a2);
            if (a2 == null || a2.a == null) {
                esVar = new es(i3, (byte[]) null);
            } else {
                esVar = new es(i3, a2.a);
            }
            if (this.h != null) {
                this.h.obtainMessage(1, esVar).sendToTarget();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            th2.printStackTrace();
            iu.b(th2, "rObserver", "rhp");
            if (this.h != null) {
                this.h.obtainMessage(1, new es(i3, (byte[]) null)).sendToTarget();
            }
        }
        return false;
    }
}
