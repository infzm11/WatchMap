package com.amap.api.col.n3;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Message;
import com.amap.api.col.n3.ie;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.IGpsCallback;
import com.amap.api.navi.INavi;
import com.amap.api.navi.NaviSetting;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AMapNaviCore */
public class et implements IGpsCallback, INavi {
    private int a = -1;
    private int b = -1;
    private NaviSetting c;
    private boolean d = false;
    private boolean e = false;
    private ey f;
    /* access modifiers changed from: private */
    public Context g;
    private int h = 40;
    private ev i;
    private fh j;
    private fi k;
    private em l;
    private boolean m = false;
    private CoordinateConverter n;

    public et(Context context) {
        try {
            this.g = context.getApplicationContext();
            AnonymousClass1 r0 = new Thread() {
                public final void run() {
                    try {
                        if (!hq.b) {
                            im a2 = hq.a();
                            ie.a a3 = ie.a(et.this.g, a2, "11K;001", (Map<String, String>) null);
                            if (a3 != null) {
                                ie.a.C0001a aVar = a3.w;
                                if (aVar != null) {
                                    a2.a(aVar.a);
                                }
                                ie.a.d dVar = a3.x;
                                if (dVar != null) {
                                    String str = dVar.b;
                                    String str2 = dVar.a;
                                    String str3 = dVar.c;
                                    jp.a(et.this.g, new jo(str2, str), a2);
                                }
                            }
                            iu.a(et.this.g, a2);
                            hq.b = true;
                        }
                    } catch (ic e) {
                        e.printStackTrace();
                        iu.b((Throwable) e, "WTBTControl", "initAuth().run()");
                    }
                }
            };
            r0.setName("AuthThread");
            r0.start();
        } catch (Throwable th) {
            iu.b(th, "AMapNavi", "init()");
            return;
        }
        hs.a(context.getApplicationContext());
        this.l = new em(this.g);
        this.c = new NaviSetting(this.g, this.l);
        if (this.i == null) {
            this.i = this.l;
        }
        this.f = new ey(this.g);
        this.f.a((IGpsCallback) this);
        this.f.a();
        Message message = new Message();
        message.what = 32;
        this.i.o().sendMessageDelayed(message, 150);
    }

    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.i != null) {
            return this.i.strategyConvert(z, z2, z3, z4, z5);
        }
        return 0;
    }

    public synchronized void destroy() {
        try {
            if (this.f != null) {
                this.f.b();
                this.f.c();
                this.f = null;
            }
            this.c.destroy();
            if (this.j != null) {
                this.j.b();
                this.j = null;
            }
            if (this.k != null) {
                this.k.d();
                this.k = null;
            }
            if (this.l != null) {
                this.l.a();
                this.l = null;
            }
            this.i = null;
            this.m = false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "destroy()");
        }
    }

    public boolean startNavi(int i2) {
        this.b = i2;
        try {
            if (this.m) {
                return true;
            }
            this.i.o().obtainMessage(35, Boolean.valueOf(((LocationManager) this.g.getSystemService("location")).isProviderEnabled(GeocodeSearch.GPS))).sendToTarget();
            switch (i2) {
                case 1:
                    this.i.a(i2);
                    this.m = true;
                    if (!this.d) {
                        startGPS();
                        break;
                    }
                    break;
                case 2:
                    this.i.b(this.h);
                    this.i.a(i2);
                    this.m = true;
                    break;
            }
            return true;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviCore", "startNavi(int naviType)");
        }
    }

    public void pauseNavi() {
        try {
            if (this.i != null) {
                this.i.h();
                this.m = false;
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "pauseNavi()");
        }
    }

    public void stopNavi() {
        try {
            if (this.i != null) {
                this.i.i();
                this.m = false;
            }
            stopGPS();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "stopNavi()");
        }
    }

    public void resumeNavi() {
        try {
            if (this.i != null) {
                this.i.j();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "resumeNavi()");
        }
    }

    public boolean readNaviInfo() {
        try {
            if (this.i != null) {
                return this.i.k();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "readNaviInfo() ");
            return false;
        }
    }

    public boolean readTrafficInfo(int i2) {
        try {
            if (this.i != null) {
                return this.i.readTrafficInfo(i2);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "readTrafficInfo(int frontDistance)");
            return false;
        }
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i2) {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            return this.i.calculateDriveRoute(list, list2, list3, i2);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateDriveRoute(List<NaviLatLng> from, List<NaviLatLng> to,\n                                       List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    public void setCarNumber(String str, String str2) {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            if (this.i != null) {
                this.i.setCarNumber(str, str2);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setCarNumber(String province, String number)");
        }
    }

    public void setCarInfo(AMapCarInfo aMapCarInfo) {
        if (this.l == null) {
            this.l = new em(this.g);
        }
        this.i = this.l;
        this.a = 0;
        if (this.i != null) {
            this.i.setCarInfo(aMapCarInfo);
        }
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i2) {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            return this.i.calculateDriveRoute(list, list2, i2);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateDriveRoute(java.util.List<NaviLatLng> to,\n                                       java.util.List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    public boolean reCalculateRoute(int i2) {
        try {
            if (this.i == null) {
                return false;
            }
            en.a(i2);
            return this.i.reCalculateRoute(3);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "reCalculateRoute(int strategy)");
            return false;
        }
    }

    public List<AMapTrafficStatus> getTrafficStatuses(int i2, int i3) {
        try {
            if (this.i != null) {
                return this.i.getTrafficStatuses(i2, i3);
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getTrafficStatuses(int startPos, int distance) ");
            return null;
        }
    }

    public AMapNaviPath getNaviPath() {
        try {
            return this.i.l();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviPath()");
            return null;
        }
    }

    public HashMap<Integer, AMapNaviPath> getNaviPaths() {
        try {
            if (this.a != 0 || this.i == null) {
                return null;
            }
            return this.i.getMultipleNaviPathsCalculated();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviPaths()");
            return null;
        }
    }

    public List<AMapNaviGuide> getNaviGuideList() {
        try {
            return this.i.m();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviGuideList()");
            return null;
        }
    }

    public NaviSetting getNaviSetting() {
        return this.c;
    }

    public void setEmulatorNaviSpeed(int i2) {
        try {
            this.h = i2;
            if (this.i != null) {
                this.i.b(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTimeForOneWord(int i2) {
        try {
            if (this.i != null) {
                this.i.d(i2);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setTimeForOneWord(int time)");
        }
    }

    public void addAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.i != null) {
                this.i.a(aMapNaviListener);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "addAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    public void removeAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.i != null) {
                this.i.b(aMapNaviListener);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "removeAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    public boolean startGPS() {
        try {
            if (this.f == null) {
                return true;
            }
            this.f.a();
            return true;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startGPS()");
            return false;
        }
    }

    public boolean startGPS(long j2, int i2) {
        try {
            if (this.f == null) {
                return true;
            }
            this.f.a(j2);
            return true;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startGPS(long time, int dis)");
            return false;
        }
    }

    public boolean stopGPS() {
        try {
            if (this.f == null) {
                return false;
            }
            this.f.b();
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "stopGPS() ");
            return false;
        }
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng) {
        try {
            if (this.k == null) {
                this.k = new fi(this.g);
                this.k.b();
            }
            this.i = this.k;
            this.a = 1;
            return this.i.a(naviLatLng);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateWalkRoute(NaviLatLng to)");
            return false;
        }
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.k == null) {
                this.k = new fi(this.g);
                this.k.b();
            }
            this.i = this.k;
            this.a = 1;
            return this.i.a(naviLatLng, naviLatLng2);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateWalkRoute(NaviLatLng from, NaviLatLng to) ");
            return false;
        }
    }

    public boolean calculateRideRoute(NaviLatLng naviLatLng) {
        try {
            if (this.j == null) {
                this.j = new fh(this.g);
                this.j.a();
            }
            this.i = this.j;
            this.a = 2;
            return this.i.b(naviLatLng);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateRideRoute(NaviLatLng to)");
            return false;
        }
    }

    public boolean calculateRideRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.j == null) {
                this.j = new fh(this.g);
                this.j.a();
            }
            this.i = this.j;
            this.a = 2;
            return this.i.b(naviLatLng, naviLatLng2);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateRideRoute(NaviLatLng from, NaviLatLng to) ");
            return false;
        }
    }

    public void setReCalculateRouteForYaw(boolean z) {
        try {
            if (this.i != null) {
                this.i.setReCalculateRouteForYaw(z);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setReCalculateRouteForYaw(boolean isReroute)");
        }
    }

    public void setReCalculateRouteForTrafficJam(boolean z) {
        try {
            if (this.i != null) {
                this.i.setReCalculateRouteForTrafficJam(z);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setReCalculateRouteForTrafficJam(boolean isReroute)");
        }
    }

    public int getEngineType() {
        return this.a;
    }

    public int getNaviType() {
        return this.b;
    }

    public NaviInfo getNaviInfo() {
        try {
            if (this.i != null) {
                return this.i.c();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviCore", "getNaviInfo()");
            return null;
        }
    }

    public void setDetectedMode(int i2) {
        try {
            if (this.i != null) {
                this.i.setDetectedMode(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startAimlessMode(int i2) {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            this.i.startAimlessMode(i2);
            startGPS();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void stopAimlessMode() {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            this.i.stopAimlessMode();
            stopGPS();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setConnectionTimeout(int i2) {
        if (i2 < 3000) {
            i2 = 3000;
        }
        try {
            fj.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSoTimeout(int i2) {
        if (i2 < 3000) {
            i2 = 3000;
        }
        try {
            fj.a(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean selectRouteId(int i2) {
        try {
            if (this.a != 0 || this.i == null || this.i.c(i2) == -1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "selectRouteId(int id)");
        }
        return false;
    }

    public boolean isGpsReady() {
        return this.e;
    }

    public boolean setBroadcastMode(int i2) {
        try {
            if (this.l == null) {
                this.l = new em(this.g);
            }
            this.i = this.l;
            this.a = 0;
            if (this.i == null || !this.i.setBroadcastMode(i2)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void switchParallelRoad() {
        try {
            if (this.i != null) {
                this.i.switchParallelRoad();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean getIsUseExtraGPSData() {
        return this.d;
    }

    public void setIsUseExtraGPSData(boolean z) {
        this.d = z;
        if (z) {
            stopGPS();
        } else {
            startGPS();
        }
    }

    public void setExtraGPSData(int i2, Location location) {
        if (this.d && location != null) {
            try {
                a(i2, location);
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "AMapNavi", "setExtraGPSData(int type,Location location)");
            }
        }
    }

    public void setExtraGPSData(Location location) {
        setExtraGPSData(1, location);
    }

    public void onLocationChanged(int i2, Location location) {
        "AmapNaviCore-->onLocationChanged(int type, Location location),mIsUseExtraGPSData=" + this.d + ",mEngineType=" + this.a;
        if (!this.d) {
            this.e = true;
            a(i2, location);
        }
    }

    private void a(int i2, Location location) {
        try {
            this.i.a(i2, location.getLongitude(), location.getLatitude());
            this.i.a(i2, location);
            if (i2 == 1) {
                if (this.n == null) {
                    this.n = new CoordinateConverter(this.g);
                    this.n.from(CoordinateConverter.CoordType.GPS);
                }
                this.n.coord(new LatLng(location.getLatitude(), location.getLongitude()));
                LatLng convert = this.n.convert();
                en.a(new NaviLatLng(convert.latitude, convert.longitude));
            } else {
                en.a(new NaviLatLng(location.getLatitude(), location.getLongitude()));
            }
            en.a(location.getAccuracy(), location.getAltitude());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
