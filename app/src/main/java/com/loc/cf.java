package com.loc;

import android.content.Context;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: OffLineManager */
public final class cf {
    private String a = "com.autonavi.aps.amapapi.offline.Off";
    private Object b = null;
    private boolean c = false;
    private boolean d = false;
    private Context e = null;

    private AMapLocationServer a(String str, String str2, JSONObject jSONObject, String str3) {
        Object obj;
        try {
            if (d()) {
                try {
                    obj = cv.a(this.b, "getPureOfflineLocation", str, str2, jSONObject, str3);
                } catch (Throwable unused) {
                    obj = null;
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.b(new JSONObject((String) obj));
                return aMapLocationServer;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000e */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012 A[Catch:{ Throwable -> 0x0022 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = r3.d()     // Catch:{ Throwable -> 0x0022 }
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.Object r0 = r3.b     // Catch:{ Throwable -> 0x000e }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x000e }
            com.loc.cv.a(r0, r4, r1)     // Catch:{ Throwable -> 0x000e }
        L_0x000e:
            android.content.Context r4 = r3.e     // Catch:{ Throwable -> 0x0022 }
            if (r4 != 0) goto L_0x0022
            return
        L_0x0013:
            java.lang.Object r4 = r3.b     // Catch:{ Throwable -> 0x0022 }
            if (r4 == 0) goto L_0x0022
            java.lang.Object r4 = r3.b     // Catch:{ Throwable -> 0x0022 }
            java.lang.String r0 = "stopOff"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0022 }
            com.loc.cv.a(r4, r0, r2)     // Catch:{ Throwable -> 0x0022 }
            r3.d = r1     // Catch:{ Throwable -> 0x0022 }
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cf.a(java.lang.String):void");
    }

    private boolean d() {
        return this.b != null && cr.w();
    }

    public final AMapLocationServer a(ci ciVar, String str, String str2, AMapLocationClientOption aMapLocationClientOption, String str3, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 7) {
            return aMapLocationServer;
        }
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        AMapLocationServer a2 = a(str, str2, cs.a(aMapLocationClientOption), str3);
        if (!da.a(a2)) {
            return aMapLocationServer;
        }
        ciVar.a(str2);
        a2.e("file");
        a2.setLocationType(8);
        a2.setLocationDetail("离线定位，在线定位失败原因:" + aMapLocationServer.getErrorInfo());
        a(a2.toJson(1));
        return a2;
    }

    public final void a() {
        try {
            if (d()) {
                cv.a(this.b, "getOffDlHist", new Object[0]);
            } else if (this.b != null) {
                cv.a(this.b, "stopOff", new Object[0]);
                this.d = false;
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Context context) {
        try {
            this.e = context;
            if (cr.w() && this.b == null && !this.c) {
                s a2 = cs.a("OfflineLocation", "1.0.0");
                this.c = cx.a(context, a2);
                if (this.c) {
                    try {
                        this.b = au.a(context, a2, this.a, (Class) null, new Class[]{Context.class}, new Object[]{context});
                    } catch (Throwable unused) {
                    }
                } else {
                    this.c = true;
                }
            }
        } catch (Throwable th) {
            cs.a(th, "OffLineLocManager", "initOffLocation");
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption, String str) {
        try {
            if (d() && !this.d) {
                if (aMapLocationClientOption == null) {
                    aMapLocationClientOption = new AMapLocationClientOption();
                }
                JSONObject a2 = cs.a(aMapLocationClientOption);
                cv.a(this.b, "startOff", a2, str);
                this.d = true;
            }
        } catch (Throwable th) {
            cs.a(th, "OffLineLocManager", "getLocation:isOffLineLoc");
        }
    }

    public final void a(cd cdVar) {
        ArrayList<cc> arrayList = cdVar.b;
        int i = cdVar.a & 3;
        if (!arrayList.isEmpty()) {
            switch (i) {
                case 1:
                    a("resetCdmaData");
                    return;
                case 2:
                    cc ccVar = arrayList.get(0);
                    if (ccVar.f <= 0 || ccVar.e <= 0) {
                        a("resetCdmaData");
                        return;
                    } else if (d()) {
                        cv.a(this.b, "setCdmaLatLon", Integer.valueOf(ccVar.e), Integer.valueOf(ccVar.f));
                        return;
                    } else {
                        return;
                    }
                default:
                    a("resetCdmaData");
                    return;
            }
        }
    }

    public final void a(String str, AMapLocationServer aMapLocationServer) {
        try {
            if (da.a(aMapLocationServer) && this.e != null) {
                double latitude = aMapLocationServer.getLatitude();
                double longitude = aMapLocationServer.getLongitude();
                if (d()) {
                    cv.a(this.b, "updateHM", this.e, str, Double.valueOf(latitude), Double.valueOf(longitude));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (d()) {
                cv.a(this.b, "setLastLoc", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        a("stopOff");
        a("destroy");
        c();
        this.d = false;
        this.b = null;
    }

    public final void c() {
        try {
            if (d()) {
                cv.a(this.b, "resetPureOfflineCache", new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
