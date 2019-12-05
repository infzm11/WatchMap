package com.amap.api.col.n3;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.ae.guide.GuideService;
import com.autonavi.ae.guide.model.GuideConfig;
import com.autonavi.ae.pos.GpsInfo;
import com.autonavi.ae.pos.LocManager;
import com.autonavi.ae.pos.LocObjectId;
import com.autonavi.ae.route.RouteService;
import com.autonavi.ae.route.model.RouteConfig;
import com.autonavi.ae.route.model.RoutePoi;
import com.autonavi.ae.route.observer.PathRequestObserver;
import com.autonavi.ae.route.observer.RouteObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: AE8Control */
public final class em extends ev {
    private Context a;
    private GuideService b;
    private RouteService c;
    private eq d;
    private er e;
    private NaviPath f;
    private int g = 12;
    private boolean h = false;
    private final int i = 50;
    private boolean j = false;
    private int k = 1;

    public final void a(int i2, double d2, double d3) {
    }

    public final void refreshTrafficStatuses() {
    }

    public final void setDetectedMode(int i2) {
    }

    public final void setReCalculateRouteForTrafficJam(boolean z) {
    }

    public final void setReCalculateRouteForYaw(boolean z) {
    }

    public em(Context context) {
        super(context);
        try {
            this.a = context.getApplicationContext();
            this.d = new eq(this);
            this.e = new er(this);
            String q = ih.q(this.a);
            q = TextUtils.isEmpty(q) ? "00000000" : q;
            GuideConfig guideConfig = new GuideConfig();
            guideConfig.userBatch = "0";
            guideConfig.userCode = "0";
            guideConfig.UUID = q;
            guideConfig.workPath = p();
            this.b = new GuideService(guideConfig, context);
            this.b.setNaviObserver(this.d);
            this.b.setSoundPlayObserver(this.d);
            this.b.addStatusObserver(this.d);
            this.b.setElecEyeObserver(this.d);
            this.b.registerHttpProcesser(this.d);
            LocManager.init();
            LocManager.setMatchMode(0);
            LocManager.addLocListener(this.d, 1);
            LocManager.addParallelRoadObserver(this.d);
            LocManager.setLogSwitch(1);
            RouteConfig routeConfig = new RouteConfig();
            routeConfig.mDeviceId = q;
            routeConfig.mVehicleId = "";
            routeConfig.mEtaRestrictionSet = 0;
            this.c = new RouteService(routeConfig, this.a);
            this.c.setPathRequestObserver(this.e);
            this.c.setRouteObserver(this.e);
            this.c.registerHttpProcesser(this.e);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "A8C", "constructor");
        }
    }

    public final void a() {
        super.n();
        en.b(this.a);
        LocManager.saveLocStorage();
        LocManager.uninit();
        if (this.c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.c.setPathRequestObserver((PathRequestObserver) null);
            this.c.setRouteObserver((RouteObserver) null);
            this.c.destroy();
            long currentTimeMillis2 = System.currentTimeMillis();
            "routeService destroy()-->" + (currentTimeMillis2 - currentTimeMillis);
            this.c = null;
        }
        if (this.b != null) {
            this.b.removeStatusObserver(this.d);
            this.b.stopNavi();
            long currentTimeMillis3 = System.currentTimeMillis();
            this.b.destroy();
            long currentTimeMillis4 = System.currentTimeMillis();
            "guideService destroy()-->" + (currentTimeMillis4 - currentTimeMillis3);
            this.b = null;
        }
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        if (this.e != null) {
            this.e.d();
            this.e = null;
        }
        this.a = null;
        this.f = null;
        this.j = false;
    }

    public final int b() {
        return this.k;
    }

    public final NaviInfo c() {
        if (this.d != null) {
            return this.d.a();
        }
        return null;
    }

    public final boolean d() {
        return this.h;
    }

    private String p() {
        try {
            File file = new File(hq.a(this.a).getAbsolutePath() + "/AmapSdk");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final Context e() {
        return this.a;
    }

    public final GuideService f() {
        return this.b;
    }

    public final RouteService g() {
        return this.c;
    }

    public final boolean a(int i2) {
        if (i2 != 2 && i2 != 1) {
            return false;
        }
        try {
            if (this.f == null) {
                c(this.g);
            }
            this.k = i2;
            if (i2 == 2) {
                this.b.startNavi(1);
            }
            if (i2 == 1) {
                this.b.startNavi(0);
            }
            o().obtainMessage(26, Integer.valueOf(i2)).sendToTarget();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    public final void h() {
        if (this.b != null) {
            this.b.pauseNavi();
        }
    }

    public final void i() {
        if (this.b != null) {
            this.b.stopNavi();
            this.f = null;
        }
    }

    public final void j() {
        if (this.b != null) {
            this.b.resumeNavi();
        }
    }

    public final boolean k() {
        if (this.b == null) {
            return true;
        }
        this.b.playNaviManual();
        return true;
    }

    public final boolean readTrafficInfo(int i2) {
        if (this.b == null) {
            return true;
        }
        this.b.playTrafficRadioManual(i2);
        return true;
    }

    public final void setCarNumber(String str, String str2) {
        if (this.b != null && this.c != null) {
            this.b.control("VehicleID", str.concat(str2));
            this.c.control("VehicleID", str.concat(str2));
            this.b.control("ETARestrictionOpen", "1");
            this.c.control("ETARestrictionOpen", "1");
        }
    }

    public final void setCarInfo(AMapCarInfo aMapCarInfo) {
        if (aMapCarInfo != null && this.b != null && this.c != null) {
            this.b.control("VehicleID", aMapCarInfo.getCarNumber());
            this.c.control("VehicleID", aMapCarInfo.getCarNumber());
            this.b.control("vehicleType", aMapCarInfo.getCarType());
            this.c.control("vehicleType", aMapCarInfo.getCarType());
            this.b.control("ETARestrictionOpen", aMapCarInfo.isRestriction() ? "1" : "0");
            this.c.control("ETARestrictionOpen", aMapCarInfo.isRestriction() ? "1" : "0");
            this.b.control("vehicleHeight", aMapCarInfo.getVehicleHeight());
            this.c.control("vehicleHeight", aMapCarInfo.getVehicleHeight());
            this.b.control("vehicleLoad", aMapCarInfo.getVehicleLoad());
            this.c.control("vehicleLoad", aMapCarInfo.getVehicleLoad());
            this.b.control("VehicleLoadSwitch", aMapCarInfo.isVehicleLoadSwitch() ? "1" : "0");
            this.c.control("VehicleLoadSwitch", aMapCarInfo.isVehicleLoadSwitch() ? "1" : "0");
        }
    }

    public final boolean reCalculateRoute(int i2) {
        if (this.c == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(en.a(this.a));
        "reCalculateRoute(" + i2 + ")";
        if (i2 == 6) {
            if (1 == this.b.reroute(i2, 4, 0, en.d(), (RoutePoi[]) null, (RoutePoi[]) null, 0.0d)) {
                return true;
            }
            return false;
        } else if (!this.j) {
            if (1 == this.b.reroute(i2, 4, 0, eo.a((List<NaviLatLng>) arrayList), (RoutePoi[]) null, (RoutePoi[]) null, 0.0d)) {
                return true;
            }
            return false;
        } else if (1 == this.b.reroute(i2, 4, 0, (RoutePoi[]) null, (RoutePoi[]) null, (RoutePoi[]) null, 0.0d)) {
            return true;
        } else {
            return false;
        }
    }

    public final List<AMapTrafficStatus> getTrafficStatuses(int i2, int i3) {
        try {
            if (this.d == null) {
                return null;
            }
            List<AMapTrafficStatus> b2 = this.d.b();
            return ((b2 == null || b2.size() <= 0) && l() != null) ? l().getTrafficStatuses() : b2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final AMapNaviPath l() {
        try {
            if (this.f != null) {
                return this.f.amapNaviPath;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final List<AMapNaviGuide> m() {
        try {
            if (this.f != null) {
                return this.f.getGuideList();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void b(int i2) {
        if (this.b != null && i2 > 9 && i2 < 121) {
            this.b.control(GuideControl.GC_EMULATOR_SPEED, String.valueOf(i2));
        }
    }

    public final int c(int i2) {
        try {
            if (!(this.b == null || this.e == null)) {
                this.b.setNaviPath(this.e.a().get(Integer.valueOf(i2)).longValue(), 1, en.d(), en.e(), en.f());
                this.f = this.e.b().get(Integer.valueOf(i2));
                this.g = i2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i2;
    }

    public final int[] getAllRouteID() {
        try {
            if (this.e != null) {
                return this.e.c();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final boolean setBroadcastMode(int i2) {
        if (this.c == null) {
            return true;
        }
        this.c.control("PlayStyle", String.valueOf(i2));
        return true;
    }

    public final void switchParallelRoad() {
        LocManager.switchParallelRoad((LocObjectId) null);
    }

    public final void startAimlessMode(int i2) {
        if (this.b != null) {
            this.b.control(GuideControl.GC_CRUISE, "1");
            this.b.control(GuideControl.GC_TRAFFIC_CAMERA_MODE, String.valueOf(i2));
        }
    }

    public final void stopAimlessMode() {
        if (this.b != null) {
            this.b.control(GuideControl.GC_CRUISE, "0");
        }
    }

    public final int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        try {
            int a2 = ht.a(z, z2, z3, z4);
            return !z5 ? a2 + 50 : a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final HashMap<Integer, AMapNaviPath> getMultipleNaviPathsCalculated() {
        HashMap<Integer, AMapNaviPath> hashMap = new HashMap<>();
        try {
            Map<Integer, NaviPath> b2 = this.e.b();
            for (Integer intValue : b2.keySet()) {
                int intValue2 = intValue.intValue();
                hashMap.put(Integer.valueOf(intValue2), b2.get(Integer.valueOf(intValue2)).amapNaviPath);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    public final void d(int i2) {
        if (this.b != null) {
            this.b.control("TTSTimeForOneWord", String.valueOf(i2));
        }
    }

    public final void a(int i2, Location location) {
        try {
            Calendar instance = Calendar.getInstance(Locale.CHINA);
            instance.setTimeInMillis(location.getTime());
            int i3 = instance.get(1);
            int i4 = instance.get(2) + 1;
            int i5 = instance.get(5);
            int i6 = instance.get(11);
            int i7 = instance.get(12);
            int i8 = instance.get(13);
            GpsInfo gpsInfo = new GpsInfo();
            gpsInfo.encrypted = (byte) (i2 == 2 ? 1 : 0);
            gpsInfo.accuracy = (double) location.getAccuracy();
            gpsInfo.alt = location.getAltitude();
            gpsInfo.angle = (double) location.getBearing();
            gpsInfo.lat = (int) (location.getLatitude() * 1000000.0d);
            gpsInfo.lon = (int) (location.getLongitude() * 1000000.0d);
            gpsInfo.speed = ((double) location.getSpeed()) * 3.6d;
            gpsInfo.hour = i6;
            gpsInfo.minute = i7;
            gpsInfo.second = i8;
            gpsInfo.year = i3;
            gpsInfo.month = i4;
            gpsInfo.day = i5;
            gpsInfo.ticktime = System.currentTimeMillis();
            gpsInfo.sourtype = 0;
            gpsInfo.status = 'A';
            gpsInfo.ew = 'E';
            gpsInfo.ns = 'N';
            gpsInfo.hdop = 0.9d;
            gpsInfo.pdop = 0.9d;
            gpsInfo.vdop = 0.9d;
            gpsInfo.satnum = 9;
            gpsInfo.mode = 'N';
            LocManager.setGpsInfo(gpsInfo);
            try {
                this.j = true;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                th2.printStackTrace();
                iu.b(th2, "A8C", "sgi");
            }
        } catch (Throwable th3) {
            th = th3;
            Throwable th22 = th;
            th22.printStackTrace();
            iu.b(th22, "A8C", "sgi");
        }
    }

    public final void setTrafficStatusUpdateEnabled(boolean z) {
        if (this.b != null) {
            this.b.control(GuideControl.GC_TMC_CONGESTION, z ? "1" : "0");
        }
    }

    public final void setTrafficInfoUpdateEnabled(boolean z) {
        if (this.b != null) {
            this.b.control(GuideControl.GC_TMC, z ? "1" : "0");
        }
    }

    public final void setCameraInfoUpdateEnabled(boolean z) {
        if (this.b != null) {
            this.b.control(GuideControl.GC_CAMERA_PLAY, z ? "1" : "0");
        }
    }

    public final boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i2) {
        ArrayList arrayList = new ArrayList();
        NaviLatLng a2 = en.a(this.a);
        if (a2 == null) {
            return false;
        }
        arrayList.add(a2);
        return calculateDriveRoute(arrayList, list, list2, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean calculateDriveRoute(java.util.List<com.amap.api.navi.model.NaviLatLng> r12, java.util.List<com.amap.api.navi.model.NaviLatLng> r13, java.util.List<com.amap.api.navi.model.NaviLatLng> r14, int r15) {
        /*
            r11 = this;
            r0 = 50
            r1 = 1
            r2 = 0
            if (r15 <= r0) goto L_0x000d
            r11.h = r2     // Catch:{ Throwable -> 0x000b }
            int r15 = r15 + -50
            goto L_0x000f
        L_0x000b:
            r12 = move-exception
            goto L_0x0045
        L_0x000d:
            r11.h = r1     // Catch:{ Throwable -> 0x000b }
        L_0x000f:
            com.amap.api.col.n3.en.a((int) r15)     // Catch:{ Throwable -> 0x000b }
            com.autonavi.ae.route.model.RoutePoi[] r12 = com.amap.api.col.n3.eo.a((java.util.List<com.amap.api.navi.model.NaviLatLng>) r12)     // Catch:{ Throwable -> 0x000b }
            com.amap.api.col.n3.en.a((com.autonavi.ae.route.model.RoutePoi[]) r12)     // Catch:{ Throwable -> 0x000b }
            com.autonavi.ae.route.model.RoutePoi[] r12 = com.amap.api.col.n3.eo.a((java.util.List<com.amap.api.navi.model.NaviLatLng>) r13)     // Catch:{ Throwable -> 0x000b }
            com.amap.api.col.n3.en.c((com.autonavi.ae.route.model.RoutePoi[]) r12)     // Catch:{ Throwable -> 0x000b }
            com.autonavi.ae.route.model.RoutePoi[] r12 = com.amap.api.col.n3.eo.a((java.util.List<com.amap.api.navi.model.NaviLatLng>) r14)     // Catch:{ Throwable -> 0x000b }
            com.amap.api.col.n3.en.b((com.autonavi.ae.route.model.RoutePoi[]) r12)     // Catch:{ Throwable -> 0x000b }
            boolean r12 = com.amap.api.col.n3.en.a()     // Catch:{ Throwable -> 0x000b }
            if (r12 == 0) goto L_0x004f
            com.autonavi.ae.route.RouteService r3 = r11.c     // Catch:{ Throwable -> 0x000b }
            r4 = 4
            r5 = 0
            com.autonavi.ae.route.model.RoutePoi[] r6 = com.amap.api.col.n3.en.d()     // Catch:{ Throwable -> 0x000b }
            com.autonavi.ae.route.model.RoutePoi[] r7 = com.amap.api.col.n3.en.e()     // Catch:{ Throwable -> 0x000b }
            com.autonavi.ae.route.model.RoutePoi[] r8 = com.amap.api.col.n3.en.f()     // Catch:{ Throwable -> 0x000b }
            r9 = 0
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = r3.requestRoute(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x000b }
            goto L_0x0050
        L_0x0045:
            r12.printStackTrace()
            java.lang.String r13 = "A8C"
            java.lang.String r14 = "cdr"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.String) r14)
        L_0x004f:
            r12 = r2
        L_0x0050:
            if (r12 != r1) goto L_0x0053
            return r1
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.em.calculateDriveRoute(java.util.List, java.util.List, java.util.List, int):boolean");
    }
}
