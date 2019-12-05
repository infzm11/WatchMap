package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.rtbt.CarLocation;
import com.autonavi.rtbt.DGNaviInfo;
import com.autonavi.rtbt.IFrameForRTBT;

/* compiled from: FrameForRTBT */
public final class ew implements IFrameForRTBT {
    private NaviInfo a;
    private int b;
    private fh c;
    private Context d;
    private ep e;

    public final int GetDialect() {
        return 0;
    }

    public final void PlayVoiceType(int i) {
    }

    public final int getPlayState() {
        return 0;
    }

    public final void lockScreenNaviTips(String str, int i, int i2) {
    }

    public final void routeDestroy() {
    }

    public final void vibratePhoneTips(int i, int i2) {
    }

    public ew(Context context, fh fhVar) {
        try {
            this.c = fhVar;
            this.d = context;
            this.e = fhVar.o();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4) {
        try {
            String str3 = "http://s.amap.com/" + str;
            if (this.c != null) {
                fm fmVar = new fm(this.c, this.d, str3, i3, str2, i, i2, bArr);
                ks.a(2).a((kt) fmVar);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            hq.a(th2);
            iu.b(th2, "FrameForWTBT", "requestHttp(int moduleID, int connectID, int type, String url,\n                            String head, byte[] data, int dataLength)");
        }
    }

    public final void updateNaviInfo(DGNaviInfo dGNaviInfo) {
        try {
            this.a = new NaviInfo(dGNaviInfo);
            this.a.setCurrentSpeed(this.b);
            if (this.e != null) {
                this.e.obtainMessage(1, this.a).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "FrameForWTBT", "updateNaviInfo(DGNaviInfo dgNaviInfo)");
        }
    }

    public final void playNaviSound(int i, String str) {
        if (i != 8) {
            try {
                if (!str.contains("行进方向有误")) {
                    if (this.e != null) {
                        this.e.obtainMessage(17, str).sendToTarget();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "FrameForWTBT", "playNaviSound(int soundType, String soundStr)");
            }
        }
    }

    public final void endEmulatorNavi() {
        try {
            if (this.e != null) {
                this.e.obtainMessage(9, 2).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "FrameForWTBT", "endEmulatorNavi()");
        }
    }

    public final void arriveWay(int i) {
        try {
            if (this.e != null && i >= 0) {
                if (i == 0) {
                    this.e.obtainMessage(9, 1).sendToTarget();
                } else {
                    this.e.obtainMessage(10, Integer.valueOf(i)).sendToTarget();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "FrameForWTBT", "arriveWay(int wayId)");
        }
    }

    public final void offRoute() {
        try {
            if (this.e != null) {
                this.e.obtainMessage(30).sendToTarget();
            }
            if (this.c != null) {
                this.c.d();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "FrameForWTBT", "offRoute()");
        }
    }

    public final void carLocationChange(CarLocation carLocation) {
        if (carLocation != null) {
            try {
                this.b = carLocation.m_Speed;
                AMapNaviLocation aMapNaviLocation = new AMapNaviLocation();
                aMapNaviLocation.setBearing((float) carLocation.m_CarDir);
                aMapNaviLocation.setSpeed((float) carLocation.m_Speed);
                aMapNaviLocation.setAccuracy(en.b());
                aMapNaviLocation.setAltitude(en.c());
                aMapNaviLocation.setMatchStatus(carLocation.m_MatchStatus);
                aMapNaviLocation.setCoord(new NaviLatLng(carLocation.m_Latitude, carLocation.m_Longitude));
                aMapNaviLocation.setTime(System.currentTimeMillis());
                if (this.e != null) {
                    this.e.obtainMessage(22, aMapNaviLocation).sendToTarget();
                    "FrameForWTBT carLocationChange(rtbt位置回调),Latitude=" + carLocation.m_Latitude + ",Longitude=" + carLocation.m_Longitude;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "FrameForWTBT", "carLocationChange(CarLocation carLocation)");
            }
        }
    }

    public final void carProjectionChange(CarLocation carLocation) {
        try {
            AmapCarLocation amapCarLocation = new AmapCarLocation(carLocation);
            if (this.e != null) {
                this.e.obtainMessage(33, amapCarLocation).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "FrameForWTBT", "carProjectionChange(CarLocation carLocation)");
        }
    }

    public final void setRouteRequestState(int i) {
        int i2;
        if (i == 1) {
            try {
                int c2 = this.c != null ? this.c.c(0) : -1;
                if (this.e == null) {
                    return;
                }
                if (c2 != -1) {
                    this.e.obtainMessage(28, new int[]{0}).sendToTarget();
                    return;
                }
                this.e.obtainMessage(29, -1).sendToTarget();
                fk.a("http://restapi.amap.com/v4/direction/bicycling".replace("http://restapi.amap.com/", ""), i);
            } catch (Throwable th) {
                th.printStackTrace();
                hq.a(th);
                iu.b(th, "FrameForWTBT", "setRouteRequestState(int requestRouteState)");
            }
        } else {
            switch (i) {
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 6;
                    break;
                default:
                    switch (i) {
                        case 9:
                            i2 = 9;
                            break;
                        case 10:
                            i2 = 10;
                            break;
                        case 11:
                            i2 = 11;
                            break;
                        case 12:
                            i2 = 12;
                            break;
                        case 13:
                            i2 = 20;
                            break;
                        default:
                            i2 = 19;
                            break;
                    }
            }
            if (this.e != null) {
                this.e.obtainMessage(29, Integer.valueOf(i2)).sendToTarget();
                fk.a("http://restapi.amap.com/v4/direction/bicycling".replace("http://restapi.amap.com/", ""), i2);
            }
        }
    }

    public final void a() {
        this.a = null;
        this.c = null;
        this.d = null;
    }

    public final void b() {
        try {
            if (this.e != null) {
                this.e.sendEmptyMessage(34);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "FrameForTBT", "initFailure()");
        }
    }

    public final void a(int i) {
        try {
            if (this.e != null) {
                this.e.obtainMessage(26, Integer.valueOf(i)).sendToTarget();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "FrameForTBT", "onStartNavi(int flag)");
        }
    }

    public final NaviInfo c() {
        return this.a;
    }
}
