package com.amap.api.location;

public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;
    private boolean a = false;
    private int b = 2;
    private int c = 0;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.location.AMapLocationQualityReport clone() {
        /*
            r4 = this;
            com.amap.api.location.AMapLocationQualityReport r0 = new com.amap.api.location.AMapLocationQualityReport
            r0.<init>()
            super.clone()     // Catch:{ Throwable -> 0x0008 }
        L_0x0008:
            int r1 = r4.b     // Catch:{ Throwable -> 0x0018 }
            r0.setGpsStatus(r1)     // Catch:{ Throwable -> 0x0018 }
            int r1 = r4.c     // Catch:{ Throwable -> 0x0018 }
            r0.setGPSSatellites(r1)     // Catch:{ Throwable -> 0x0018 }
            boolean r1 = r4.a     // Catch:{ Throwable -> 0x0018 }
            r0.setWifiAble(r1)     // Catch:{ Throwable -> 0x0018 }
            return r0
        L_0x0018:
            r1 = move-exception
            java.lang.String r2 = "AMapLocationQualityReport"
            java.lang.String r3 = "clone"
            com.loc.cs.a(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocationQualityReport.clone():com.amap.api.location.AMapLocationQualityReport");
    }

    public int getGPSSatellites() {
        return this.c;
    }

    public int getGPSStatus() {
        return this.b;
    }

    public boolean isWifiAble() {
        return this.a;
    }

    public void setGPSSatellites(int i) {
        this.c = i;
    }

    public void setGpsStatus(int i) {
        this.b = i;
    }

    public void setWifiAble(boolean z) {
        this.a = z;
    }
}
