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
import com.autonavi.rtbt.IFrameForRTBT;
import com.autonavi.rtbt.NaviGuideItem;
import com.autonavi.rtbt.RTBT;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* compiled from: RTBTControl */
public final class fh extends ev {
    private RTBT a;
    private NaviPath b;
    private Context c;
    private IFrameForRTBT d;
    private NaviLatLng e;
    private List<AMapNaviGuide> f = new ArrayList();
    private int g = -1;

    public fh(Context context) {
        super(context);
        try {
            this.c = context;
            this.a = new RTBT();
            this.d = new ew(this.c, this);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RTBTControl", "RTBTControl()");
        }
    }

    public final void a() {
        try {
            if (this.c != null) {
                if (this.a == null) {
                    this.a = new RTBT();
                }
                this.a.setEmulatorSpeed(35);
                if (this.d == null) {
                    this.d = new ew(this.c, this);
                }
                String q = ih.q(this.c);
                if (TextUtils.isEmpty(q)) {
                    q = "00000000";
                }
                String str = q;
                RTBT rtbt = this.a;
                IFrameForRTBT iFrameForRTBT = this.d;
                int init = rtbt.init(iFrameForRTBT, hq.a(this.c).getAbsolutePath() + "/navigation", "AN_AmapSdk_ADR_FC", "0", str, "");
                int param = this.a.setParam("userid", "AN_AmapSdk_ADR_FC");
                int param2 = this.a.setParam("userpwd", "amapsdk");
                String f2 = id.f(this.c);
                if (!TextUtils.isEmpty(f2)) {
                    MapsInitializer.setApiKey(f2);
                }
                if (init == 0 || param == 0 || param2 == 0) {
                    this.d.b();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            super.n();
            if (this.a != null) {
                this.a.destroy();
                this.a = null;
            }
            if (this.d != null) {
                this.d.a();
                this.d = null;
            }
            if (this.f != null) {
                this.f.clear();
                this.f = null;
            }
            this.b = null;
            this.c = null;
            this.e = null;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RTBTControl", "destroy()");
        }
    }

    public final NaviInfo c() {
        if (this.d != null) {
            return this.d.c();
        }
        return null;
    }

    public final boolean k() {
        if (this.a == null || this.a.playNaviManual() != 1) {
            return false;
        }
        return true;
    }

    public final boolean a(int i) {
        try {
            this.g = i;
            boolean z = true;
            if (i == 1) {
                if (this.a.startGPSNavi() != 1) {
                    z = false;
                }
                if (z && this.d != null) {
                    this.d.a(i);
                }
                return z;
            }
            if (i == 2) {
                if (this.a.startEmulatorNavi() != 1) {
                    z = false;
                }
                if (z && this.d != null) {
                    this.d.a(i);
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

    public final boolean b(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        if (!(naviLatLng == null || naviLatLng2 == null)) {
            try {
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
                    this.e = naviLatLng2;
                    if (this.a.requestRouteWithStart(0, 0, 1, dArr, 1, dArr2, 0, (double[]) null) == 1) {
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "RTBTControl", "calculateRideRoute(from,to)");
            }
        }
        return false;
    }

    public final boolean b(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            try {
                if (!hq.a(naviLatLng)) {
                    ep o = o();
                    if (o != null) {
                        o.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                }
                NaviLatLng a2 = en.a(this.c);
                if (a2 != null) {
                    return b(a2, naviLatLng);
                }
                double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                this.e = naviLatLng;
                if (this.a.requestRoute(0, 0, 1, dArr, 0, (double[]) null) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "RTBTControl", "calculateRideRoute(to)");
            }
        }
        return false;
    }

    public final void d() {
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
            this.f.clear();
            for (NaviGuideItem naviGuide : naviGuideList) {
                this.f.add(new NaviGuide(naviGuide).aMapNaviGuide);
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RTBTControl", "getNaviGuideList()");
            return null;
        }
    }

    public final void b(int i) {
        if (this.a != null && i > 9 && i < 51) {
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
        fh fhVar;
        Throwable th;
        double d2;
        double d3;
        double d4;
        int i;
        fh fhVar2 = this;
        fhVar2.b = new NaviPath();
        try {
            fhVar2.b.setAllLength(fhVar2.a.getRouteLength());
            fhVar2.b.setAllTime(fhVar2.a.getRouteTime());
            fhVar2.b.setStepsCount(fhVar2.a.getSegNum());
            fhVar2.b.setEndPoint(fhVar2.e);
            fhVar2.b.setStrategy(3);
            int segNum = fhVar2.a.getSegNum();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (fhVar2.b.getWayPoint() != null) {
                fhVar2.b.amapNaviPath.wayPointIndex = new int[fhVar2.b.getWayPoint().size()];
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
                aMapNaviStep.setChargeLength(fhVar2.a.getSegChargeLength(i4));
                int segTollCost = i2 + fhVar2.a.getSegTollCost(i4);
                aMapNaviStep.setTime(fhVar2.a.getSegTime(i4));
                double[] segCoor = fhVar2.a.getSegCoor(i4);
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
                aMapNaviStep.setLength(fhVar2.a.getSegLength(i4));
                ArrayList arrayList4 = new ArrayList();
                int segLinkNum = fhVar2.a.getSegLinkNum(i4);
                aMapNaviStep.setStartIndex(i3 + 1);
                int i9 = i3;
                d6 = d4;
                d8 = d3;
                int i10 = 0;
                while (i10 < segLinkNum) {
                    AMapNaviLink aMapNaviLink = new AMapNaviLink();
                    aMapNaviLink.setLength(fhVar2.a.getLinkLength(i4, i10));
                    aMapNaviLink.setTime(fhVar2.a.getLinkTime(i4, i10));
                    aMapNaviLink.setRoadClass(fhVar2.a.getLinkRoadClass(i4, i10));
                    aMapNaviLink.setRoadType(fhVar2.a.getLinkFormWay(i4, i10));
                    aMapNaviLink.setRoadName(fhVar2.a.getLinkRoadName(i4, i10));
                    int i11 = segLinkNum;
                    aMapNaviLink.setTrafficLights(fhVar2.a.haveTrafficLights(i4, i10) == 1);
                    double[] linkCoor = fhVar2.a.getLinkCoor(i4, i10);
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
                            fhVar = this;
                            th.printStackTrace();
                            iu.b(th, "RTBTControl", "initNaviPath()");
                            return fhVar.b;
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
                    fhVar2 = this;
                    i10++;
                }
                AMapNaviStep aMapNaviStep4 = aMapNaviStep;
                try {
                    i = i10;
                    aMapNaviStep4.setEndIndex(i9);
                    fh fhVar3 = this;
                    i = fhVar3;
                    fhVar3.b.setWayPoint((List<NaviLatLng>) null);
                    aMapNaviStep4.setLinks(arrayList4);
                    arrayList.add(aMapNaviStep4);
                    i4++;
                    fhVar2 = fhVar3;
                    i3 = i9;
                    segNum = i5;
                    i2 = i6;
                    d7 = d9;
                    d5 = d2;
                } catch (Throwable th3) {
                    th = th3;
                    fhVar = i;
                    th = th;
                    th.printStackTrace();
                    iu.b(th, "RTBTControl", "initNaviPath()");
                    return fhVar.b;
                }
            }
            fhVar = fhVar2;
            fhVar.b.getMaxCoordForPath().setLatitude(d5);
            fhVar.b.getMaxCoordForPath().setLongitude(d8);
            fhVar.b.getMinCoordForPath().setLatitude(d6);
            fhVar.b.getMinCoordForPath().setLongitude(d7);
            fhVar.b.setTollCost(i2);
            fhVar.b.setListStep(arrayList);
            if (arrayList2.size() > 0) {
                fhVar.b.setStartPoint((NaviLatLng) arrayList2.get(0));
            }
            fhVar.b.setList(arrayList2);
            NaviLatLng a2 = hq.a(fhVar.b.getMinCoordForPath().getLatitude(), fhVar.b.getMinCoordForPath().getLongitude(), fhVar.b.getMaxCoordForPath().getLatitude(), fhVar.b.getMaxCoordForPath().getLongitude());
            fhVar.b.setBounds(new LatLngBounds(new LatLng(fhVar.b.getMinCoordForPath().getLatitude(), fhVar.b.getMinCoordForPath().getLongitude()), new LatLng(fhVar.b.getMaxCoordForPath().getLatitude(), fhVar.b.getMaxCoordForPath().getLongitude())));
            fhVar.b.setCenter(a2);
        } catch (Throwable th4) {
            th = th4;
            fhVar = fhVar2;
            th = th;
            th.printStackTrace();
            iu.b(th, "RTBTControl", "initNaviPath()");
            return fhVar.b;
        }
        return fhVar.b;
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
            if (this.g == 1) {
                this.a.setGPSInfo(i, (int) location.getAccuracy(), 0.0d, location.getLongitude(), location.getLatitude(), 3.6d * ((double) location.getSpeed()), (double) location.getBearing(), i2, i3, i4, i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final RTBT e() {
        return this.a;
    }

    public final IFrameForRTBT f() {
        return this.d;
    }
}
