package com.loc;

import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

/* compiled from: LocFilter */
public final class bx {
    AMapLocationServer a = null;
    long b = 0;
    long c = 0;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;
    private boolean h = true;

    private AMapLocationServer b(AMapLocationServer aMapLocationServer) {
        int i;
        if (da.a(aMapLocationServer)) {
            if (!this.h || !cr.b(aMapLocationServer.getTime())) {
                i = this.d;
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                i = 4;
            }
            aMapLocationServer.setLocationType(i);
        }
        return aMapLocationServer;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!da.a(aMapLocation)) {
            return aMapLocation;
        }
        long b2 = da.b() - this.g;
        this.g = da.b();
        if (b2 > 5000) {
            return aMapLocation;
        }
        if (this.f == null) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (1 != this.f.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.f.getTime());
            if (30000 < abs) {
                this.f = aMapLocation;
                return aMapLocation;
            } else if (da.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + (2.0f * (this.f.getAccuracy() + aMapLocation.getAccuracy())) + 3000.0f) {
                return this.f;
            } else {
                this.f = aMapLocation;
                return aMapLocation;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cd, code lost:
        if ((r9 - r0.c) > 30000) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011c, code lost:
        if (r11 < 30000) goto L_0x00d7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer a(com.autonavi.aps.amapapi.model.AMapLocationServer r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            long r2 = com.loc.da.b()
            long r4 = r0.e
            long r2 = r2 - r4
            r4 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001c
            r0.a = r1
            long r1 = com.loc.da.b()
            r0.e = r1
        L_0x0019:
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.a
            return r1
        L_0x001c:
            long r2 = com.loc.da.b()
            r0.e = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.a
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 == 0) goto L_0x0056
            boolean r2 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r19)
            if (r2 != 0) goto L_0x0031
            goto L_0x0056
        L_0x0031:
            long r2 = r19.getTime()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.a
            long r6 = r6.getTime()
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            r3 = 1133903872(0x43960000, float:300.0)
            if (r2 != 0) goto L_0x004a
            float r2 = r19.getAccuracy()
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.String r2 = r19.getProvider()
            java.lang.String r6 = "gps"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x005f
        L_0x0056:
            long r2 = com.loc.da.b()
            r0.b = r2
        L_0x005c:
            r0.a = r1
            goto L_0x0019
        L_0x005f:
            int r2 = r19.c()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.a
            int r6 = r6.c()
            if (r2 == r6) goto L_0x006c
            goto L_0x0056
        L_0x006c:
            java.lang.String r2 = r19.getBuildingId()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.a
            java.lang.String r6 = r6.getBuildingId()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = r19.getBuildingId()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0087
            goto L_0x0056
        L_0x0087:
            int r2 = r19.getLocationType()
            r0.d = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.a
            float r2 = com.loc.da.a((com.amap.api.location.AMapLocation) r1, (com.amap.api.location.AMapLocation) r2)
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.a
            float r6 = r6.getAccuracy()
            float r7 = r19.getAccuracy()
            float r8 = r7 - r6
            long r9 = com.loc.da.b()
            long r11 = r0.b
            long r11 = r9 - r11
            r13 = 1120534528(0x42ca0000, float:101.0)
            int r13 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            r14 = 0
            r16 = 1133871104(0x43958000, float:299.0)
            if (r13 >= 0) goto L_0x00b6
            int r13 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r13 > 0) goto L_0x00be
        L_0x00b6:
            int r13 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r13 <= 0) goto L_0x00df
            int r17 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r17 <= 0) goto L_0x00df
        L_0x00be:
            long r2 = r0.c
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x00c7
            r0.c = r9
            goto L_0x00d7
        L_0x00c7:
            long r2 = r0.c
            long r2 = r9 - r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d7
        L_0x00cf:
            r0.b = r9
            r0.a = r1
            r0.c = r14
            goto L_0x0019
        L_0x00d7:
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.a
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.b(r1)
            goto L_0x005c
        L_0x00df:
            r17 = 1120403456(0x42c80000, float:100.0)
            int r17 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r17 >= 0) goto L_0x00e8
            if (r13 <= 0) goto L_0x00e8
            goto L_0x00cf
        L_0x00e8:
            int r13 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r13 > 0) goto L_0x00ee
            r0.c = r14
        L_0x00ee:
            r13 = 1092616192(0x41200000, float:10.0)
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0116
            double r13 = (double) r2
            r15 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x0116
            r2 = 1084227584(0x40a00000, float:5.0)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0116
            r2 = -1013579776(0xffffffffc3960000, float:-300.0)
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x010b
            goto L_0x00d7
        L_0x010b:
            float r6 = r6 / r7
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x00d7
            r0.b = r9
            goto L_0x005c
        L_0x0116:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0056
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00d7
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bx.a(com.autonavi.aps.amapapi.model.AMapLocationServer):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void a() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.f = null;
        this.g = 0;
    }

    public final void a(boolean z) {
        this.h = z;
    }
}
