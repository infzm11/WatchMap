package com.amap.api.col.n3;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.NaviGuide;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.wtbt.IFrameForWTBT;
import com.autonavi.wtbt.NaviGuideItem;
import com.autonavi.wtbt.WTBT;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* compiled from: WTBTControl */
public final class fi extends ev {
    private WTBT a;
    private NaviPath b;
    private int c = -1;
    private Context d;
    private IFrameForWTBT e;
    private NaviLatLng f;
    private List<AMapNaviGuide> g = new ArrayList();

    public fi(Context context) {
        super(context);
        this.d = context;
        this.a = new WTBT();
        this.e = new ex(this.d, this);
    }

    public final IFrameForWTBT a() {
        return this.e;
    }

    public final void b() {
        try {
            if (this.d != null) {
                if (this.a == null) {
                    this.a = new WTBT();
                }
                this.a.setEmulatorSpeed(20);
                if (this.e == null) {
                    this.e = new ex(this.d, this);
                }
                String q = ih.q(this.d);
                if (TextUtils.isEmpty(q)) {
                    q = "00000000";
                }
                String str = q;
                WTBT wtbt = this.a;
                IFrameForWTBT iFrameForWTBT = this.e;
                int init = wtbt.init(iFrameForWTBT, hq.a(this.d).getAbsolutePath() + "/navigation", "AN_AmapSdk_ADR_FC", "0", str, "");
                int param = this.a.setParam("userid", "AN_AmapSdk_ADR_FC");
                int param2 = this.a.setParam("userpwd", "amapsdk");
                String f2 = id.f(this.d);
                if (!TextUtils.isEmpty(f2)) {
                    MapsInitializer.setApiKey(f2);
                }
                if (init == 0 || param == 0 || param2 == 0) {
                    this.e.b();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void d() {
        try {
            super.n();
            ks.a();
            if (this.a != null) {
                this.a.destroy();
                this.a = null;
            }
            if (this.e != null) {
                this.e.a();
                this.e = null;
            }
            if (this.g != null) {
                this.g.clear();
                this.g = null;
            }
            this.b = null;
            this.d = null;
            this.f = null;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "WTBTControl", "destroy()");
        }
    }

    public final boolean a(int i) {
        try {
            this.c = i;
            boolean z = true;
            if (i == 1) {
                if (this.a.startGPSNavi() != 1) {
                    z = false;
                }
                if (z && this.e != null) {
                    this.e.a(i);
                }
                return z;
            }
            if (i == 2) {
                if (this.a.startEmulatorNavi() != 1) {
                    z = false;
                }
                if (z && this.e != null) {
                    this.e.a(i);
                }
                return z;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void h() {
        if (this.a != null) {
            this.a.pauseNavi();
        }
    }

    public final void i() {
        if (this.a != null) {
            this.a.stopNavi();
        }
    }

    public final void j() {
        if (this.a != null) {
            this.a.resumeNavi();
        }
    }

    public final void a(int i, double d2, double d3) {
        if (this.a != null) {
            this.a.setCarLocation(i, d2, d3);
        }
    }

    public final boolean a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (!(this.a == null || naviLatLng == null || naviLatLng2 == null)) {
                if (!hq.a(naviLatLng)) {
                    ep o = o();
                    if (o != null) {
                        o.obtainMessage(29, 3).sendToTarget();
                    }
                    return false;
                } else if (!hq.a(naviLatLng2)) {
                    ep o2 = o();
                    if (o2 != null) {
                        o2.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                } else {
                    double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                    double[] dArr2 = {naviLatLng2.getLongitude(), naviLatLng2.getLatitude()};
                    this.f = naviLatLng2;
                    if (this.a.requestRouteWithStart(0, 0, 1, dArr, 1, dArr2, 0, (double[]) null) == 1) {
                        return true;
                    }
                    return false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "wtbt", "cwr");
        }
        return false;
    }

    public final boolean a(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            try {
                if (!hq.a(naviLatLng)) {
                    ep o = o();
                    if (o != null) {
                        o.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                }
                NaviLatLng a2 = en.a(this.d);
                if (a2 != null) {
                    return a(a2, naviLatLng);
                }
                double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                this.f = naviLatLng;
                if (this.a.requestRoute(0, 0, 1, dArr, 0, (double[]) null) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final void e() {
        if (this.a != null) {
            this.a.reroute(0, 0);
        }
    }

    public final AMapNaviPath l() {
        if (this.b != null) {
            return this.b.amapNaviPath;
        }
        return null;
    }

    public final List<AMapNaviGuide> m() {
        try {
            if (this.a == null) {
                return null;
            }
            NaviGuideItem[] naviGuideList = this.a.getNaviGuideList();
            if (naviGuideList == null || naviGuideList.length <= 0) {
                return null;
            }
            this.g.clear();
            for (NaviGuideItem naviGuide : naviGuideList) {
                this.g.add(new NaviGuide(naviGuide).aMapNaviGuide);
            }
            return this.g;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "wtbt", "gngl");
            return null;
        }
    }

    public final void b(int i) {
        if (this.a != null && i > 9 && i < 31) {
            this.a.setEmulatorSpeed(i);
        }
    }

    public final void d(int i) {
        if (this.a != null) {
            this.a.setTimeForOneWord(i);
        }
    }

    public final int c(int i) {
        try {
            if (this.a != null) {
                int selectRoute = this.a.selectRoute(i);
                if (!(selectRoute == -1)) {
                    g();
                }
                return selectRoute;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1;
    }

    private NaviPath g() {
        fi fiVar;
        Throwable th;
        double d2;
        double d3;
        double d4;
        int i;
        fi fiVar2 = this;
        fiVar2.b = new NaviPath();
        try {
            fiVar2.b.setAllLength(fiVar2.a.getRouteLength());
            fiVar2.b.setAllTime(fiVar2.a.getRouteTime());
            fiVar2.b.setStepsCount(fiVar2.a.getSegNum());
            fiVar2.b.setEndPoint(fiVar2.f);
            fiVar2.b.setStrategy(3);
            int segNum = fiVar2.a.getSegNum();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (fiVar2.b.getWayPoint() != null) {
                fiVar2.b.amapNaviPath.wayPointIndex = new int[fiVar2.b.getWayPoint().size()];
            }
            double d5 = Double.MIN_VALUE;
            double d6 = Double.MAX_VALUE;
            double d7 = Double.MAX_VALUE;
            double d8 = Double.MIN_VALUE;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < segNum) {
                AMapNaviStep aMapNaviStep = new AMapNaviStep();
                int i5 = segNum;
                aMapNaviStep.setChargeLength(fiVar2.a.getSegChargeLength(i4));
                int segTollCost = i2 + fiVar2.a.getSegTollCost(i4);
                aMapNaviStep.setTime(fiVar2.a.getSegTime(i4));
                double[] segCoor = fiVar2.a.getSegCoor(i4);
                int i6 = segTollCost;
                ArrayList arrayList3 = new ArrayList();
                double d9 = d7;
                if (segCoor != null) {
                    d4 = d6;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= segCoor.length - 1) {
                            break;
                        }
                        arrayList3.add(new NaviLatLng(segCoor[i8 + 1], segCoor[i8]));
                        i7 = i8 + 2;
                        d8 = d8;
                        d5 = d5;
                    }
                    d2 = d5;
                    d3 = d8;
                } else {
                    d2 = d5;
                    d3 = d8;
                    d4 = d6;
                }
                aMapNaviStep.setCoords(arrayList3);
                aMapNaviStep.setLength(fiVar2.a.getSegLength(i4));
                ArrayList arrayList4 = new ArrayList();
                int segLinkNum = fiVar2.a.getSegLinkNum(i4);
                aMapNaviStep.setStartIndex(i3 + 1);
                int i9 = i3;
                d6 = d4;
                d8 = d3;
                int i10 = 0;
                while (i10 < segLinkNum) {
                    AMapNaviLink aMapNaviLink = new AMapNaviLink();
                    aMapNaviLink.setLength(fiVar2.a.getLinkLength(i4, i10));
                    aMapNaviLink.setTime(fiVar2.a.getLinkTime(i4, i10));
                    aMapNaviLink.setRoadClass(fiVar2.a.getLinkRoadClass(i4, i10));
                    aMapNaviLink.setRoadType(fiVar2.a.getLinkFormWay(i4, i10));
                    aMapNaviLink.setRoadName(fiVar2.a.getLinkRoadName(i4, i10));
                    int i11 = segLinkNum;
                    aMapNaviLink.setTrafficLights(fiVar2.a.haveTrafficLights(i4, i10) == 1);
                    double[] linkCoor = fiVar2.a.getLinkCoor(i4, i10);
                    ArrayList arrayList5 = new ArrayList();
                    double d10 = d9;
                    double d11 = d8;
                    int i12 = i9;
                    int i13 = 0;
                    while (i13 < linkCoor.length - 1) {
                        ArrayList arrayList6 = arrayList4;
                        try {
                            double d12 = linkCoor[i13 + 1];
                            AMapNaviLink aMapNaviLink2 = aMapNaviLink;
                            AMapNaviStep aMapNaviStep2 = aMapNaviStep;
                            double d13 = linkCoor[i13];
                            if (d2 < d12) {
                                d2 = d12;
                            }
                            if (d11 < d13) {
                                d11 = d13;
                            }
                            if (d6 > d12) {
                                d6 = d12;
                            }
                            if (d10 > d13) {
                                d10 = d13;
                            }
                            NaviLatLng naviLatLng = new NaviLatLng(d12, d13);
                            arrayList5.add(naviLatLng);
                            arrayList2.add(naviLatLng);
                            i12++;
                            i13 += 2;
                            arrayList4 = arrayList6;
                            aMapNaviStep = aMapNaviStep2;
                            aMapNaviLink = aMapNaviLink2;
                        } catch (Throwable th2) {
                            th = th2;
                            fiVar = this;
                            th.printStackTrace();
                            iu.b(th, "WTBTControl", "initNaviPath()");
                            return fiVar.b;
                        }
                    }
                    ArrayList arrayList7 = arrayList4;
                    AMapNaviLink aMapNaviLink3 = aMapNaviLink;
                    AMapNaviStep aMapNaviStep3 = aMapNaviStep;
                    aMapNaviLink3.setCoords(arrayList5);
                    arrayList4.add(aMapNaviLink3);
                    i9 = i12;
                    d8 = d11;
                    d9 = d10;
                    segLinkNum = i11;
                    aMapNaviStep = aMapNaviStep3;
                    fiVar2 = this;
                    i10++;
                }
                AMapNaviStep aMapNaviStep4 = aMapNaviStep;
                try {
                    i = i10;
                    aMapNaviStep4.setEndIndex(i9);
                    fi fiVar3 = this;
                    i = fiVar3;
                    fiVar3.b.setWayPoint((List<NaviLatLng>) null);
                    aMapNaviStep4.setLinks(arrayList4);
                    arrayList.add(aMapNaviStep4);
                    i4++;
                    fiVar2 = fiVar3;
                    i3 = i9;
                    segNum = i5;
                    i2 = i6;
                    d7 = d9;
                    d5 = d2;
                } catch (Throwable th3) {
                    th = th3;
                    fiVar = i;
                    th = th;
                    th.printStackTrace();
                    iu.b(th, "WTBTControl", "initNaviPath()");
                    return fiVar.b;
                }
            }
            fiVar = fiVar2;
            fiVar.b.getMaxCoordForPath().setLatitude(d5);
            fiVar.b.getMaxCoordForPath().setLongitude(d8);
            fiVar.b.getMinCoordForPath().setLatitude(d6);
            fiVar.b.getMinCoordForPath().setLongitude(d7);
            fiVar.b.setTollCost(i2);
            fiVar.b.setListStep(arrayList);
            if (arrayList2.size() > 0) {
                fiVar.b.setStartPoint((NaviLatLng) arrayList2.get(0));
            }
            fiVar.b.setList(arrayList2);
            NaviLatLng a2 = hq.a(fiVar.b.getMinCoordForPath().getLatitude(), fiVar.b.getMinCoordForPath().getLongitude(), fiVar.b.getMaxCoordForPath().getLatitude(), fiVar.b.getMaxCoordForPath().getLongitude());
            fiVar.b.setBounds(new LatLngBounds(new LatLng(fiVar.b.getMinCoordForPath().getLatitude(), fiVar.b.getMinCoordForPath().getLongitude()), new LatLng(fiVar.b.getMaxCoordForPath().getLatitude(), fiVar.b.getMaxCoordForPath().getLongitude())));
            fiVar.b.setCenter(a2);
        } catch (Throwable th4) {
            th = th4;
            fiVar = fiVar2;
            th = th;
            th.printStackTrace();
            iu.b(th, "WTBTControl", "initNaviPath()");
            return fiVar.b;
        }
        return fiVar.b;
    }

    public final void a(int i, Location location) {
        try {
            Calendar instance = Calendar.getInstance(Locale.CHINA);
            instance.setTimeInMillis(location.getTime());
            int i2 = instance.get(1);
            int i3 = instance.get(2) + 1;
            int i4 = instance.get(5);
            int i5 = instance.get(11);
            int i6 = instance.get(12);
            int i7 = instance.get(13);
            if (this.c == 1) {
                this.a.setGPSInfo(i, (int) location.getAccuracy(), 0.0d, location.getLongitude(), location.getLatitude(), 3.6d * ((double) location.getSpeed()), (double) location.getBearing(), i2, i3, i4, i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final NaviInfo c() {
        if (this.e != null) {
            return this.e.c();
        }
        return null;
    }

    public final boolean k() {
        if (this.a == null || this.a.playNaviManual() != 1) {
            return false;
        }
        return true;
    }

    public final WTBT f() {
        return this.a;
    }
}
