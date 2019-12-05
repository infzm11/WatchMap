package com.amap.api.navi;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.col.n3.et;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.hs;
import com.amap.api.col.n3.ie;
import com.amap.api.col.n3.iu;
import com.amap.api.col.n3.jp;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import java.util.HashMap;
import java.util.List;

public class AMapNavi implements INavi {
    public static int EmulatorNaviMode = 2;
    public static int GPSNaviMode = 1;
    private static AMapNavi singletonAMapNavi;
    private INavi mINavi;

    public static String getVersion() {
        return "5.4.0";
    }

    public void setReCalculateRouteForTrafficJam(boolean z) {
    }

    public void setReCalculateRouteForYaw(boolean z) {
    }

    static {
        System.loadLibrary("GNaviUtils");
        System.loadLibrary("GNaviData");
        System.loadLibrary("GNaviPos");
        System.loadLibrary("GNaviRoute");
        System.loadLibrary("GNaviGuide");
        System.loadLibrary("GNaviSearch");
        System.loadLibrary("RoadLineRebuildAPI");
    }

    protected AMapNavi() {
    }

    private AMapNavi(Context context) {
        if (context != null) {
            try {
                hs.a(context.getApplicationContext());
                Context context2 = context;
                this.mINavi = (INavi) jp.a(context2, hq.a(), "com.amap.api.navi.wrapper.AMapNaviWrapper", et.class, new Class[]{Context.class}, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                this.mINavi = new et(context);
            }
        }
    }

    public static synchronized AMapNavi getInstance(Context context) {
        AMapNavi aMapNavi;
        synchronized (AMapNavi.class) {
            try {
                if (singletonAMapNavi == null) {
                    singletonAMapNavi = new AMapNavi(context);
                }
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "AMapNavi", "getInstance(Context context)");
            }
            aMapNavi = singletonAMapNavi;
        }
        return aMapNavi;
    }

    public static void setApiKey(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ie.a(str);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setApiKey");
        }
    }

    public static void setTtsPlaying(boolean z) {
        hq.a = z;
    }

    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.strategyConvert(z, z2, z3, z4, z5);
            }
            return 0;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "strategyConvert");
            return 0;
        }
    }

    public synchronized void destroy() {
        try {
            if (this.mINavi != null) {
                this.mINavi.destroy();
                this.mINavi = null;
            }
            hq.a = false;
            singletonAMapNavi = null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "destroy");
        }
    }

    public boolean startNavi(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.startNavi(i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startNavi(naviType)");
            return false;
        }
    }

    public void pauseNavi() {
        try {
            if (this.mINavi != null) {
                this.mINavi.pauseNavi();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "pauseNavi()");
        }
    }

    public void stopNavi() {
        try {
            if (this.mINavi != null) {
                this.mINavi.stopNavi();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "stopNavi();");
        }
    }

    public void resumeNavi() {
        try {
            if (this.mINavi != null) {
                this.mINavi.resumeNavi();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "resumeNavi()");
        }
    }

    public boolean readNaviInfo() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.readNaviInfo();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "readNaviInfo() ");
            return false;
        }
    }

    public boolean readTrafficInfo(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.readTrafficInfo(i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "readTrafficInfo(int frontDistance)");
            return false;
        }
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(list, list2, list3, i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateDriveRoute(List<NaviLatLng> from, List<NaviLatLng> to,\n                                       List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    public void setCarNumber(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (this.mINavi != null && str2.length() < 7) {
                    this.mINavi.setCarNumber(str, str2);
                }
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setCarNumber(String province,String number)");
        }
    }

    public void setCarInfo(AMapCarInfo aMapCarInfo) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setCarInfo(aMapCarInfo);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setCarInfo");
        }
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(list, list2, i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateDriveRoute(java.util.List<NaviLatLng> to,\n                                       java.util.List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    public boolean reCalculateRoute(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.reCalculateRoute(i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "reCalculateRoute(int strategy)");
            return false;
        }
    }

    public List<AMapTrafficStatus> getTrafficStatuses(int i, int i2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getTrafficStatuses(i, i2);
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
            if (this.mINavi != null) {
                return this.mINavi.getNaviPath();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviPath()");
            return null;
        }
    }

    public HashMap<Integer, AMapNaviPath> getNaviPaths() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviPaths();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviPaths()");
            return null;
        }
    }

    public List<AMapNaviGuide> getNaviGuideList() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviGuideList();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviGuideList()");
            return null;
        }
    }

    public NaviSetting getNaviSetting() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviSetting();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviSetting");
            return null;
        }
    }

    public void setEmulatorNaviSpeed(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setEmulatorNaviSpeed(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setEmulatorNaviSpeed(int speed)");
        }
    }

    public void setTimeForOneWord(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setTimeForOneWord(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setTimeForOneWord(int time)");
        }
    }

    public void setAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.addAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setAMapNaviListener(AMapNaviListener naviListener) ");
        }
    }

    public void addAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.addAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "addAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    public void removeAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.removeAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "removeAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    public boolean startGPS() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.startGPS();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    public boolean startGPS(long j, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.startGPS(j, i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    public boolean stopGPS() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.stopGPS();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "stopGPS");
            return false;
        }
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateWalkRoute(naviLatLng);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateWalkRoute(naviLatLng, naviLatLng2);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    public boolean calculateRideRoute(NaviLatLng naviLatLng) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateRideRoute(naviLatLng);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    public boolean calculateRideRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateRideRoute(naviLatLng, naviLatLng2);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    public int getEngineType() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getEngineType();
            }
            return 0;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getEngineType");
            return 0;
        }
    }

    public int getNaviType() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviType();
            }
            return 0;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviType");
            return 0;
        }
    }

    public NaviInfo getNaviInfo() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviInfo();
            }
            return null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getNaviInfo");
            return null;
        }
    }

    public void setDetectedMode(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setDetectedMode(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setDetectedMode");
        }
    }

    public void startAimlessMode(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.startAimlessMode(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "startAimlessMode");
        }
    }

    public void stopAimlessMode() {
        try {
            if (this.mINavi != null) {
                this.mINavi.stopAimlessMode();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "stopAimlessMode");
        }
    }

    public void setConnectionTimeout(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setConnectionTimeout(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setConnectionTimeout");
        }
    }

    public void setSoTimeout(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setSoTimeout(i);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setSoTimeout");
        }
    }

    public boolean selectRouteId(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.selectRouteId(i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "selectRouteId");
            return false;
        }
    }

    public boolean isGpsReady() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.isGpsReady();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "isGpsReady");
            return false;
        }
    }

    public boolean setBroadcastMode(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.setBroadcastMode(i);
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setBroadcastMode");
            return false;
        }
    }

    public void switchParallelRoad() {
        try {
            if (this.mINavi != null) {
                this.mINavi.switchParallelRoad();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "switchParallelRoad");
        }
    }

    public boolean getIsUseExtraGPSData() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getIsUseExtraGPSData();
            }
            return false;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "getIsUseExtraGPSData");
            return false;
        }
    }

    public void setIsUseExtraGPSData(boolean z) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setIsUseExtraGPSData(z);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setIsUseExtraGPSData");
        }
    }

    public void setExtraGPSData(int i, Location location) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setExtraGPSData(i, location);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setExtraGPSData");
        }
    }

    public void setExtraGPSData(Location location) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setExtraGPSData(location);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNavi", "setExtraGPSData");
        }
    }
}
