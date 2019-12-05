package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageDispather */
public final class ep extends Handler {
    private static ep a;
    private List<AMapNaviListener> b = new ArrayList();
    private String c = "MessageDispather";

    /* compiled from: MessageDispather */
    static class a {
        public Object a;
        public Object b;
        public Object c;

        a() {
        }
    }

    private ep(Context context) {
        super(context.getMainLooper());
    }

    public static ep a(Context context) {
        if (a == null) {
            a = new ep(context);
        }
        return a;
    }

    public final void a(AMapNaviListener aMapNaviListener) {
        if (!this.b.contains(aMapNaviListener)) {
            this.b.add(aMapNaviListener);
        }
    }

    public final void b(AMapNaviListener aMapNaviListener) {
        if (this.b != null) {
            this.b.remove(aMapNaviListener);
        }
    }

    public final void handleMessage(Message message) {
        try {
            int i = message.what;
            Object obj = message.obj;
            switch (i) {
                case 1:
                    String str = this.c;
                    NaviInfo naviInfo = (NaviInfo) obj;
                    for (AMapNaviListener next : this.b) {
                        next.onNaviInfoUpdate(naviInfo);
                        next.onNaviInfoUpdated(new AMapNaviInfo(naviInfo.getPathRetainDistance(), naviInfo.getPathRetainTime()));
                    }
                    return;
                case 2:
                    String str2 = this.c;
                    AMapNaviCross aMapNaviCross = (AMapNaviCross) obj;
                    for (AMapNaviListener showCross : this.b) {
                        showCross.showCross(aMapNaviCross);
                    }
                    return;
                case 3:
                    String str3 = this.c;
                    for (AMapNaviListener hideCross : this.b) {
                        hideCross.hideCross();
                    }
                    return;
                case 4:
                    String str4 = this.c;
                    a aVar = (a) obj;
                    byte[] bArr = (byte[]) aVar.a;
                    byte[] bArr2 = (byte[]) aVar.b;
                    AMapLaneInfo[] aMapLaneInfoArr = (AMapLaneInfo[]) aVar.c;
                    for (AMapNaviListener showLaneInfo : this.b) {
                        showLaneInfo.showLaneInfo(aMapLaneInfoArr, bArr, bArr2);
                    }
                    return;
                case 5:
                    String str5 = this.c;
                    for (AMapNaviListener hideLaneInfo : this.b) {
                        hideLaneInfo.hideLaneInfo();
                    }
                    return;
                case 6:
                    int intValue = ((Integer) obj).intValue();
                    for (AMapNaviListener notifyParallelRoad : this.b) {
                        notifyParallelRoad.notifyParallelRoad(intValue);
                    }
                    return;
                case 7:
                    String str6 = this.c;
                    for (AMapNaviListener onTrafficStatusUpdate : this.b) {
                        onTrafficStatusUpdate.onTrafficStatusUpdate();
                    }
                    return;
                case 8:
                    String str7 = this.c;
                    try {
                        AMapServiceAreaInfo[] aMapServiceAreaInfoArr = (AMapServiceAreaInfo[]) obj;
                        for (AMapNaviListener onServiceAreaUpdate : this.b) {
                            onServiceAreaUpdate.onServiceAreaUpdate(aMapServiceAreaInfoArr);
                        }
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                case 9:
                    String str8 = this.c;
                    int intValue2 = ((Integer) obj).intValue();
                    if (intValue2 == 2) {
                        for (AMapNaviListener onEndEmulatorNavi : this.b) {
                            onEndEmulatorNavi.onEndEmulatorNavi();
                        }
                    }
                    if (intValue2 == 1) {
                        for (AMapNaviListener onArriveDestination : this.b) {
                            onArriveDestination.onArriveDestination();
                        }
                        return;
                    }
                    return;
                case 10:
                    String str9 = this.c;
                    int intValue3 = ((Integer) obj).intValue();
                    for (AMapNaviListener onArrivedWayPoint : this.b) {
                        onArrivedWayPoint.onArrivedWayPoint(intValue3);
                    }
                    return;
                case 11:
                    String str10 = this.c;
                    AMapNaviCameraInfo[] aMapNaviCameraInfoArr = (AMapNaviCameraInfo[]) obj;
                    for (AMapNaviListener updateCameraInfo : this.b) {
                        updateCameraInfo.updateCameraInfo(aMapNaviCameraInfoArr);
                    }
                    return;
                case 17:
                    if (!hq.a) {
                        for (AMapNaviListener next2 : this.b) {
                            String str11 = (String) obj;
                            String str12 = this.c;
                            "语音播报:" + str11;
                            if (!TextUtils.isEmpty(str11)) {
                                next2.onGetNavigationText(str11);
                                next2.onGetNavigationText(1, str11);
                            }
                        }
                        return;
                    }
                    return;
                case 18:
                    String str13 = this.c;
                    AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr = (AMapNaviTrafficFacilityInfo[]) obj;
                    for (AMapNaviListener next3 : this.b) {
                        next3.OnUpdateTrafficFacility(aMapNaviTrafficFacilityInfoArr);
                        if (aMapNaviTrafficFacilityInfoArr != null && aMapNaviTrafficFacilityInfoArr.length > 0) {
                            next3.OnUpdateTrafficFacility(aMapNaviTrafficFacilityInfoArr[0]);
                            next3.OnUpdateTrafficFacility(new TrafficFacilityInfo(aMapNaviTrafficFacilityInfoArr[0]));
                        }
                    }
                    return;
                case 19:
                    String str14 = this.c;
                    AimLessModeStat aimLessModeStat = (AimLessModeStat) obj;
                    for (AMapNaviListener updateAimlessModeStatistics : this.b) {
                        updateAimlessModeStatistics.updateAimlessModeStatistics(aimLessModeStat);
                    }
                    return;
                case 20:
                    String str15 = this.c;
                    AimLessModeCongestionInfo aimLessModeCongestionInfo = (AimLessModeCongestionInfo) obj;
                    for (AMapNaviListener updateAimlessModeCongestionInfo : this.b) {
                        updateAimlessModeCongestionInfo.updateAimlessModeCongestionInfo(aimLessModeCongestionInfo);
                    }
                    return;
                case 22:
                    AMapNaviLocation aMapNaviLocation = (AMapNaviLocation) obj;
                    for (AMapNaviListener onLocationChange : this.b) {
                        onLocationChange.onLocationChange(aMapNaviLocation);
                    }
                    return;
                case 23:
                    String str16 = this.c;
                    int intValue4 = ((Integer) obj).intValue();
                    for (AMapNaviListener onPlayRing : this.b) {
                        onPlayRing.onPlayRing(intValue4);
                    }
                    return;
                case 24:
                    String str17 = this.c;
                    AMapModelCross aMapModelCross = (AMapModelCross) obj;
                    for (AMapNaviListener next4 : this.b) {
                        if (next4 instanceof MyNaviListener) {
                            ((MyNaviListener) next4).showModeCross(aMapModelCross);
                        }
                    }
                    return;
                case 25:
                    String str18 = this.c;
                    for (AMapNaviListener next5 : this.b) {
                        if (next5 instanceof MyNaviListener) {
                            ((MyNaviListener) next5).hideModeCross();
                        }
                    }
                    return;
                case 26:
                    String str19 = this.c;
                    int intValue5 = ((Integer) obj).intValue();
                    for (AMapNaviListener onStartNavi : this.b) {
                        onStartNavi.onStartNavi(intValue5);
                    }
                    return;
                case 27:
                    InnerNaviInfo innerNaviInfo = (InnerNaviInfo) obj;
                    for (AMapNaviListener next6 : this.b) {
                        if (next6 instanceof MyNaviListener) {
                            ((MyNaviListener) next6).onInnerNaviInfoUpdate(innerNaviInfo);
                        }
                    }
                    return;
                case 28:
                    String str20 = this.c;
                    int[] iArr = (int[]) obj;
                    for (AMapNaviListener next7 : this.b) {
                        if (next7 != null) {
                            next7.onCalculateRouteSuccess(iArr);
                        }
                    }
                    return;
                case 29:
                    String str21 = this.c;
                    int intValue6 = ((Integer) obj).intValue();
                    for (AMapNaviListener next8 : this.b) {
                        if (next8 != null) {
                            next8.onCalculateRouteFailure(intValue6);
                        }
                    }
                    return;
                case 30:
                    String str22 = this.c;
                    for (AMapNaviListener next9 : this.b) {
                        if (next9 != null) {
                            next9.onReCalculateRouteForYaw();
                        }
                    }
                    return;
                case 31:
                    String str23 = this.c;
                    for (AMapNaviListener next10 : this.b) {
                        if (next10 != null) {
                            next10.onReCalculateRouteForTrafficJam();
                        }
                    }
                    return;
                case 32:
                    String str24 = this.c;
                    for (AMapNaviListener next11 : this.b) {
                        if (next11 != null) {
                            next11.onInitNaviSuccess();
                        }
                    }
                    return;
                case 33:
                    String str25 = this.c;
                    AmapCarLocation amapCarLocation = (AmapCarLocation) obj;
                    for (AMapNaviListener next12 : this.b) {
                        if (next12 != null && (next12 instanceof MyNaviListener)) {
                            ((MyNaviListener) next12).carProjectionChange(amapCarLocation);
                        }
                    }
                    return;
                case 34:
                    String str26 = this.c;
                    for (AMapNaviListener next13 : this.b) {
                        if (next13 != null) {
                            next13.onInitNaviFailure();
                        }
                    }
                    return;
                case 35:
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    String str27 = this.c;
                    "GPS开关状态更新，status=" + booleanValue;
                    for (AMapNaviListener next14 : this.b) {
                        if (next14 != null) {
                            next14.onGpsOpenStatus(booleanValue);
                        }
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            iu.b(th2, "MessageDispather", "handleMessage()");
        }
        th2.printStackTrace();
        iu.b(th2, "MessageDispather", "handleMessage()");
    }

    public final void a() {
        try {
            if (this.b != null) {
                this.b.clear();
            }
            removeCallbacksAndMessages((Object) null);
            a = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
