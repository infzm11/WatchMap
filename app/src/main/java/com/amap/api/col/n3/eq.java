package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.amap.api.col.n3.ep;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.autonavi.ae.guide.GuideService;
import com.autonavi.ae.guide.model.CongestionInfo;
import com.autonavi.ae.guide.model.GuideBoardInfo;
import com.autonavi.ae.guide.model.ManeuverIconConfig;
import com.autonavi.ae.guide.model.NaviCamera;
import com.autonavi.ae.guide.model.NoNaviCongestionInfo;
import com.autonavi.ae.guide.model.NoNaviInfor;
import com.autonavi.ae.guide.model.RouteTrafficEventInfo;
import com.autonavi.ae.guide.model.ServiceAreaInfo;
import com.autonavi.ae.guide.model.TrafficEventInfo;
import com.autonavi.ae.guide.model.TrafficFacilityInfo;
import com.autonavi.ae.guide.observer.GElecEyeObserver;
import com.autonavi.ae.guide.observer.GNaviObserver;
import com.autonavi.ae.guide.observer.GSoundPlayObserver;
import com.autonavi.ae.guide.observer.GStatusObserver;
import com.autonavi.ae.pos.LocListener;
import com.autonavi.ae.pos.LocParallelRoadObserver;
import com.autonavi.ae.pos.LocParallelRoads;
import com.autonavi.ae.route.model.TmcBarItem;
import com.autonavi.ae.route.observer.HttpInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: MyGuideObserver */
public final class eq implements GElecEyeObserver, GNaviObserver, GSoundPlayObserver, GStatusObserver, LocListener, LocParallelRoadObserver, HttpInterface {
    TmcBarItem[] a = null;
    /* access modifiers changed from: private */
    public em b;
    private ep c;
    private NaviInfo d;
    private List<AMapTrafficStatus> e;
    private int f = 0;
    private InnerNaviInfo g;
    private Handler h = null;

    public final void ThreeDLastPass() {
    }

    public final int get3DDataVersion(int i) {
        return 0;
    }

    public final void onCarOnGuideRouteAgain() {
    }

    public final int onCheckNaviVoiceCfg(int i) {
        return 0;
    }

    public final void onExitDirectionInfo(GuideBoardInfo guideBoardInfo) {
    }

    public final void onNaviEtaIncidentReport(int i, int i2, int i3) {
    }

    public final void onNaviEtaIncidentReportHide(int i) {
    }

    public final void onTbtStatusChanged(int i, int i2) {
    }

    public final void onfinishRecover3DPath(int i) {
    }

    public final boolean requestHttpGet(int i, int i2, String str) {
        return false;
    }

    public final void updateCongestion(CongestionInfo congestionInfo) {
    }

    public final void updateDataMiningTrafficEvent(TrafficEventInfo trafficEventInfo) {
    }

    public final void updateRouteTrafficEvent(RouteTrafficEventInfo routeTrafficEventInfo) {
    }

    public final void updateSoundFlag(int i, int i2) {
    }

    public final NaviInfo a() {
        return this.d;
    }

    public final List<AMapTrafficStatus> b() {
        return this.e;
    }

    public final void c() {
        this.b = null;
        this.d = null;
        this.g = null;
        this.e = null;
        this.h = null;
    }

    public eq(em emVar) {
        try {
            this.b = emVar;
            this.d = new NaviInfo();
            this.g = new InnerNaviInfo();
            this.e = new ArrayList();
            this.c = emVar.o();
            if (this.h == null) {
                this.h = new Handler(emVar.e().getMainLooper()) {
                    public final void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message.what == 21) {
                            try {
                                if (message.obj == null) {
                                    return;
                                }
                                if (eq.this.b != null) {
                                    es esVar = (es) message.obj;
                                    if (esVar.b != null) {
                                        eq.this.b.f().processHttpData(esVar.a, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, esVar.b);
                                    } else {
                                        eq.this.b.f().processHttpError(esVar.a, 404);
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

    public final void updateCruiseInfo(String str) {
        "MyGuideObserver-->updateCruiseInfo(" + str + ")";
    }

    public final void updateNaviInfo(com.autonavi.ae.guide.model.NaviInfo naviInfo) {
        if (naviInfo != null) {
            try {
                this.d.m_CurRoadName = naviInfo.currentRoadName;
                this.d.m_NextRoadName = naviInfo.nextRoadName;
                this.d.m_RouteRemainDis = naviInfo.routeRemainDistance;
                this.d.m_RouteRemainTime = naviInfo.routeRemainTime;
                this.d.m_SegRemainDis = naviInfo.segmentRemainDistance;
                this.d.m_SegRemainTime = naviInfo.segmentRemainTime;
                this.d.m_CurSegNum = naviInfo.currentSegNumber;
                this.d.m_CurLinkNum = naviInfo.currentLinkNumber;
                this.d.m_Icon = naviInfo.iconId;
                if (this.b != null) {
                    this.d.m_Type = this.b.b();
                }
                if (this.c != null) {
                    this.c.obtainMessage(1, this.d).sendToTarget();
                    this.g.setInnerNaviInfo(this.d);
                    this.c.obtainMessage(27, this.g).sendToTarget();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void showCross(int i, byte[] bArr, byte[] bArr2) {
        try {
            this.f = i;
            if (i == 1) {
                "MyGuideObserver-->showCross(实景图),picFormat=" + i;
                this.c.obtainMessage(2, new AMapNaviCross(i, bArr, bArr2)).sendToTarget();
            }
            if (i == 3) {
                "MyGuideObserver-->showCross(模型图),picFormat=" + i;
                this.c.obtainMessage(24, new AMapModelCross(i, bArr, bArr2)).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void hideCross() {
        if (this.c != null) {
            if (this.f == 1) {
                this.c.obtainMessage(3).sendToTarget();
            }
            if (this.f == 3) {
                this.c.obtainMessage(25).sendToTarget();
            }
        }
    }

    public final void showLaneInfo(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            try {
                "MyGuideObserver-->showLaneInfo(),ThreadName=" + Thread.currentThread().getName();
                AMapLaneInfo[] a2 = a(bArr, bArr2);
                ep.a aVar = new ep.a();
                aVar.a = bArr;
                aVar.b = bArr2;
                aVar.c = a2;
                this.c.obtainMessage(4, aVar).sendToTarget();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void hideLaneInfo() {
        try {
            if (this.c != null) {
                this.c.obtainMessage(5).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static AMapLaneInfo[] a(byte[] bArr, byte[] bArr2) throws Throwable {
        int i;
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = 0;
                break;
            } else if (bArr[i2] == 15) {
                break;
            } else {
                i2++;
            }
        }
        AMapLaneInfo[] aMapLaneInfoArr = new AMapLaneInfo[i2];
        for (int i3 = 0; i3 < aMapLaneInfoArr.length; i3++) {
            aMapLaneInfoArr[i3] = new AMapLaneInfo();
        }
        for (int i4 = 0; i4 < i2; i4++) {
            byte b2 = bArr[i4];
            if (b2 == 14 || b2 == 2 || b2 == 4 || b2 == 9 || b2 == 10 || b2 == 11 || b2 == 12 || b2 == 6 || b2 == 7) {
                i = (bArr[i4] * 16) + bArr2[i4];
            } else {
                byte b3 = bArr[i4];
                byte b4 = bArr2[i4];
                i = b4 == 15 ? (b3 * 16) + b4 : (b3 * 16) + b3;
            }
            aMapLaneInfoArr[i4].setLaneTypeId(i);
        }
        return aMapLaneInfoArr;
    }

    public final void onNaviShowManeuver(int i, int i2, byte[] bArr, int i3) {
        try {
            GuideService f2 = this.b.f();
            ManeuverIconConfig maneuverIconConfig = new ManeuverIconConfig(255, 255, 2632759, 5790310, ViewCompat.MEASURED_SIZE_MASK, i2, i);
            f2.renderManeuverIcon(maneuverIconConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onNaviRenderManeuverIcon(byte[] bArr, ManeuverIconConfig maneuverIconConfig) {
        if (maneuverIconConfig != null) {
            try {
                "MyGuideObserver-->onNaviRenderManeuverIcon(),maneuverId=" + maneuverIconConfig.maneuverId;
                this.g.setIconData(bArr);
                if (maneuverIconConfig.maneuverId > 19) {
                    this.d.setIconType(9);
                } else {
                    this.d.setIconType(maneuverIconConfig.maneuverId);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void onTmcUpdate(TmcBarItem[] tmcBarItemArr, int i, int i2) {
        if (tmcBarItemArr != null && i2 != 0) {
            if (tmcBarItemArr != null) {
                try {
                    if (tmcBarItemArr.length > 0 && this.a != null && this.a.length > 0 && this.a.length == tmcBarItemArr.length) {
                        int i3 = 0;
                        while (i3 < tmcBarItemArr.length && tmcBarItemArr[i3].length == this.a[i3].length && tmcBarItemArr[i3].status == this.a[i3].status) {
                            i3++;
                        }
                        if (i3 == tmcBarItemArr.length) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.a = tmcBarItemArr;
            AMapNaviPath l = this.b.l();
            if (l != null) {
                List<AMapNaviStep> steps = l.getSteps();
                ArrayList arrayList = new ArrayList();
                for (AMapNaviStep links : steps) {
                    for (AMapNaviLink length : links.getLinks()) {
                        arrayList.add(Integer.valueOf(length.getLength()));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (TmcBarItem tmcBarItem : tmcBarItemArr) {
                    int i4 = tmcBarItem.segmentIndex;
                    int i5 = tmcBarItem.linkIndex;
                    int i6 = 0;
                    for (int i7 = 0; i7 < i4; i7++) {
                        i6 += steps.get(i7).getLinks().size();
                    }
                    AMapTrafficStatus aMapTrafficStatus = new AMapTrafficStatus(tmcBarItem);
                    aMapTrafficStatus.setLinkIndex(i6 + i5);
                    arrayList2.add(aMapTrafficStatus);
                }
                AMapTrafficStatus aMapTrafficStatus2 = new AMapTrafficStatus(new TmcBarItem());
                aMapTrafficStatus2.setLinkIndex(arrayList.size());
                arrayList2.add(aMapTrafficStatus2);
                "link=" + aMapTrafficStatus2.getLinkIndex() + ",length=" + aMapTrafficStatus2.getLength() + ",status=" + aMapTrafficStatus2.getStatus();
                int i8 = 0;
                int i9 = 1;
                int linkIndex = ((AMapTrafficStatus) arrayList2.get(1)).getLinkIndex();
                int i10 = 0;
                while (i10 < arrayList.size()) {
                    if (i10 >= linkIndex) {
                        i9++;
                        if (i9 > arrayList2.size() - 1) {
                            break;
                        }
                        linkIndex = ((AMapTrafficStatus) arrayList2.get(i9)).getLinkIndex();
                        i8 = 0;
                    } else {
                        i8 += ((Integer) arrayList.get(i10)).intValue();
                        ((AMapTrafficStatus) arrayList2.get(i9 - 1)).setLength(i8);
                        i10++;
                    }
                }
                arrayList2.remove(aMapTrafficStatus2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                this.e.clear();
                this.e.addAll(arrayList2);
                this.c.obtainMessage(7).sendToTarget();
            }
        }
    }

    public final void onServiceAreaUpdate(ServiceAreaInfo[] serviceAreaInfoArr) {
        if (serviceAreaInfoArr != null) {
            try {
                AMapServiceAreaInfo[] aMapServiceAreaInfoArr = new AMapServiceAreaInfo[serviceAreaInfoArr.length];
                for (int i = 0; i < serviceAreaInfoArr.length; i++) {
                    aMapServiceAreaInfoArr[i] = new AMapServiceAreaInfo(serviceAreaInfoArr[i]);
                }
                this.c.obtainMessage(8, aMapServiceAreaInfoArr).sendToTarget();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void navigationEnd(int i) {
        try {
            "MyGuideObserver-->navigationEnd(" + i + ")";
            if (this.c != null) {
                int i2 = 0;
                if (i == 1) {
                    i2 = 2;
                }
                if (i == 0) {
                    i2 = 1;
                }
                this.c.obtainMessage(9, Integer.valueOf(i2)).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void arrayViaPoint(int i) {
        try {
            "MyGuideObserver-->arrayViaPoint(" + i + ")";
            if (this.c != null) {
                this.c.obtainMessage(10, Integer.valueOf(i)).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void updateCameraInfo(NaviCamera[] naviCameraArr) {
        if (naviCameraArr == null) {
            try {
                this.c.obtainMessage(11, new AMapNaviCameraInfo[0]).sendToTarget();
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "gObserver", "uci");
            }
        } else {
            ArrayList arrayList = new ArrayList(Arrays.asList(naviCameraArr));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                NaviCamera naviCamera = (NaviCamera) it.next();
                if (naviCamera.cameraType == 0 && naviCamera.cameraSpeed == 0) {
                    it.remove();
                }
            }
            NaviCamera[] naviCameraArr2 = (NaviCamera[]) arrayList.toArray(new NaviCamera[0]);
            AMapNaviCameraInfo[] aMapNaviCameraInfoArr = new AMapNaviCameraInfo[naviCameraArr2.length];
            for (int i = 0; i < naviCameraArr2.length; i++) {
                aMapNaviCameraInfoArr[i] = new AMapNaviCameraInfo(naviCameraArr2[i]);
            }
            this.c.obtainMessage(11, aMapNaviCameraInfoArr).sendToTarget();
        }
    }

    public final void updateTrafficEvent(TrafficEventInfo[] trafficEventInfoArr, int i) {
        "MyGuideObserver-->updateTrafficEvent(" + i + ")";
    }

    public final void onReroute(int i) {
        try {
            "MyGuideObserver-->onReroute(" + i + ")";
            if (this.b != null) {
                this.b.reCalculateRoute(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPlayTTS(String str, int i) {
        try {
            "onPlayTTS=" + str;
            if (this.c != null) {
                this.c.obtainMessage(17, str).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPlayRing(int i) {
        "MyGuideObserver-->onPlayRing(" + i + ")";
        if (this.c != null) {
            this.c.obtainMessage(23, Integer.valueOf(i)).sendToTarget();
        }
    }

    public final boolean isNaviPlaying() {
        return hq.a;
    }

    public final void onTrafficFacilityUpdate(TrafficFacilityInfo[] trafficFacilityInfoArr) {
        try {
            AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr = new AMapNaviTrafficFacilityInfo[trafficFacilityInfoArr.length];
            for (int i = 0; i < aMapNaviTrafficFacilityInfoArr.length; i++) {
                aMapNaviTrafficFacilityInfoArr[i] = new AMapNaviTrafficFacilityInfo(trafficFacilityInfoArr[i]);
            }
            if (this.c != null) {
                this.c.obtainMessage(18, aMapNaviTrafficFacilityInfoArr).sendToTarget();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "gObserver", "updateTrafficFacility(TrafficFacilityInfo[] infoArray)");
        }
    }

    public final void onUpdateNoNaviInfor(NoNaviInfor noNaviInfor) {
        try {
            AimLessModeStat aimLessModeStat = new AimLessModeStat(noNaviInfor);
            if (this.c != null) {
                this.c.obtainMessage(19, aimLessModeStat).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onUpdateNoNaviCongestionInfo(NoNaviCongestionInfo noNaviCongestionInfo) {
        try {
            AimLessModeCongestionInfo aimLessModeCongestionInfo = new AimLessModeCongestionInfo(noNaviCongestionInfo);
            if (this.c != null) {
                this.c.obtainMessage(20, aimLessModeCongestionInfo).sendToTarget();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "gObserver", "updateNoNaviCongestionInfo(NoNaviCongestionInfo info)");
        }
    }

    public final boolean requestHttpPost(int i, int i2, String str, byte[] bArr) {
        es esVar;
        try {
            "MyGuideObserver-->requestHttpPost(),moduleId=" + i + ",TheadName=" + Thread.currentThread().getName() + ",reqId=" + i2 + ",data=" + new String(bArr, "UTF-8");
            kl a2 = eo.a(this.b.e(), i, eo.a("1.0", bArr));
            if (a2 == null || a2.a == null) {
                esVar = new es(i2, (byte[]) null);
            } else {
                esVar = new es(i2, a2.a);
            }
            if (this.h == null) {
                return false;
            }
            this.h.obtainMessage(21, esVar).sendToTarget();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "gObserver", "requestHttpPost(" + i + "," + i2 + ")");
            if (this.h == null) {
                return false;
            }
            this.h.obtainMessage(21, new es(i2, (byte[]) null)).sendToTarget();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0061 A[Catch:{ Throwable -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateNaviInfo(com.autonavi.ae.pos.LocInfo2D r11, com.autonavi.ae.pos.LocInfo3D r12) {
        /*
            r10 = this;
            com.autonavi.ae.pos.LocMapPoint r12 = r11.stPos     // Catch:{ Throwable -> 0x006d }
            int r12 = r12.lat     // Catch:{ Throwable -> 0x006d }
            double r0 = (double) r12     // Catch:{ Throwable -> 0x006d }
            r2 = 4704985352480227328(0x414b774000000000, double:3600000.0)
            double r0 = r0 / r2
            com.autonavi.ae.pos.LocMapPoint r12 = r11.stPos     // Catch:{ Throwable -> 0x006d }
            int r12 = r12.lon     // Catch:{ Throwable -> 0x006d }
            double r4 = (double) r12     // Catch:{ Throwable -> 0x006d }
            double r4 = r4 / r2
            double r2 = r11.posAcc     // Catch:{ Throwable -> 0x006d }
            float r12 = (float) r2     // Catch:{ Throwable -> 0x006d }
            double r2 = r11.alt     // Catch:{ Throwable -> 0x006d }
            float r2 = (float) r2     // Catch:{ Throwable -> 0x006d }
            double r6 = r11.course     // Catch:{ Throwable -> 0x006d }
            int r3 = (int) r6     // Catch:{ Throwable -> 0x006d }
            double r6 = r11.speed     // Catch:{ Throwable -> 0x006d }
            int r6 = (int) r6     // Catch:{ Throwable -> 0x006d }
            byte r7 = r11.isOnGuideRoad     // Catch:{ Throwable -> 0x006d }
            com.amap.api.navi.model.NaviInfo r8 = r10.d     // Catch:{ Throwable -> 0x006d }
            r8.setCurrentSpeed(r6)     // Catch:{ Throwable -> 0x006d }
            com.amap.api.navi.model.NaviInfo r8 = r10.d     // Catch:{ Throwable -> 0x006d }
            int r11 = r11.postCur     // Catch:{ Throwable -> 0x006d }
            r8.setCurPoint(r11)     // Catch:{ Throwable -> 0x006d }
            com.amap.api.navi.model.AMapNaviLocation r11 = new com.amap.api.navi.model.AMapNaviLocation     // Catch:{ Throwable -> 0x006d }
            r11.<init>()     // Catch:{ Throwable -> 0x006d }
            r11.setAccuracy(r12)     // Catch:{ Throwable -> 0x006d }
            double r8 = (double) r2     // Catch:{ Throwable -> 0x006d }
            r11.setAltitude(r8)     // Catch:{ Throwable -> 0x006d }
            float r12 = (float) r3     // Catch:{ Throwable -> 0x006d }
            r11.setBearing(r12)     // Catch:{ Throwable -> 0x006d }
            float r12 = (float) r6     // Catch:{ Throwable -> 0x006d }
            r11.setSpeed(r12)     // Catch:{ Throwable -> 0x006d }
            r12 = 1
            if (r7 == r12) goto L_0x004b
            r2 = 2
            if (r7 != r2) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            r12 = 0
            r11.setMatchStatus(r12)     // Catch:{ Throwable -> 0x006d }
            goto L_0x004e
        L_0x004b:
            r11.setMatchStatus(r12)     // Catch:{ Throwable -> 0x006d }
        L_0x004e:
            com.amap.api.navi.model.NaviLatLng r12 = new com.amap.api.navi.model.NaviLatLng     // Catch:{ Throwable -> 0x006d }
            r12.<init>(r0, r4)     // Catch:{ Throwable -> 0x006d }
            r11.setCoord(r12)     // Catch:{ Throwable -> 0x006d }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x006d }
            r11.setTime(r0)     // Catch:{ Throwable -> 0x006d }
            com.amap.api.col.n3.ep r12 = r10.c     // Catch:{ Throwable -> 0x006d }
            if (r12 == 0) goto L_0x006c
            com.amap.api.col.n3.ep r12 = r10.c     // Catch:{ Throwable -> 0x006d }
            r0 = 22
            android.os.Message r11 = r12.obtainMessage(r0, r11)     // Catch:{ Throwable -> 0x006d }
            r11.sendToTarget()     // Catch:{ Throwable -> 0x006d }
        L_0x006c:
            return
        L_0x006d:
            r11 = move-exception
            r11.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.eq.updateNaviInfo(com.autonavi.ae.pos.LocInfo2D, com.autonavi.ae.pos.LocInfo3D):void");
    }

    public final void updateParallelRoad(LocParallelRoads locParallelRoads) {
        if (locParallelRoads != null) {
            int i = locParallelRoads.nFlag;
            if (this.c != null) {
                this.c.obtainMessage(6, Integer.valueOf(i)).sendToTarget();
            }
        }
    }
}
