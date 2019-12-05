package com.amap.api.col.n3;

/* compiled from: MapLocFilter */
public final class la {
    private static la c;
    int a = 0;
    long b = 0;
    private kx d = null;
    private long e = 0;
    private long f = 0;

    private la() {
    }

    public static synchronized la a() {
        la laVar;
        synchronized (la.class) {
            if (c == null) {
                c = new la();
            }
            laVar = c;
        }
        return laVar;
    }

    public static kx b(kx kxVar) {
        return kxVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ee, code lost:
        if ((r9 - r0.f) > 30000) goto L_0x00f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.n3.kx a(com.amap.api.col.n3.kx r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            long r2 = com.amap.api.col.n3.lu.b()
            long r4 = r0.b
            long r2 = r2 - r4
            r4 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001c
            r0.d = r1
            long r1 = com.amap.api.col.n3.lu.b()
            r0.b = r1
        L_0x0019:
            com.amap.api.col.n3.kx r1 = r0.d
            return r1
        L_0x001c:
            long r2 = com.amap.api.col.n3.lu.b()
            r0.b = r2
            com.amap.api.col.n3.kx r2 = r0.d
            boolean r2 = com.amap.api.col.n3.lh.a(r2)
            if (r2 == 0) goto L_0x0056
            boolean r2 = com.amap.api.col.n3.lh.a(r19)
            if (r2 != 0) goto L_0x0031
            goto L_0x0056
        L_0x0031:
            long r2 = r19.getTime()
            com.amap.api.col.n3.kx r6 = r0.d
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
            boolean r2 = r2.equalsIgnoreCase(r6)
            if (r2 == 0) goto L_0x005f
        L_0x0056:
            long r2 = com.amap.api.col.n3.lu.b()
            r0.e = r2
        L_0x005c:
            r0.d = r1
            goto L_0x0019
        L_0x005f:
            int r2 = r19.c()
            com.amap.api.col.n3.kx r6 = r0.d
            int r6 = r6.c()
            if (r2 == r6) goto L_0x006c
            goto L_0x0056
        L_0x006c:
            java.lang.String r2 = r19.getBuildingId()
            com.amap.api.col.n3.kx r6 = r0.d
            java.lang.String r6 = r6.getBuildingId()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = r19.getBuildingId()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0087
            goto L_0x0056
        L_0x0087:
            int r2 = r19.getLocationType()
            r0.a = r2
            r2 = 4
            double[] r2 = new double[r2]
            r6 = 0
            double r7 = r19.getLatitude()
            r2[r6] = r7
            r6 = 1
            double r7 = r19.getLongitude()
            r2[r6] = r7
            r6 = 2
            com.amap.api.col.n3.kx r7 = r0.d
            double r7 = r7.getLatitude()
            r2[r6] = r7
            r6 = 3
            com.amap.api.col.n3.kx r7 = r0.d
            double r7 = r7.getLongitude()
            r2[r6] = r7
            float r2 = com.amap.api.col.n3.lu.a((double[]) r2)
            com.amap.api.col.n3.kx r6 = r0.d
            float r6 = r6.getAccuracy()
            float r7 = r19.getAccuracy()
            float r8 = r7 - r6
            long r9 = com.amap.api.col.n3.lu.b()
            long r11 = r0.e
            long r11 = r9 - r11
            r13 = 1120534528(0x42ca0000, float:101.0)
            int r13 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            r14 = 0
            r16 = 1133871104(0x43958000, float:299.0)
            if (r13 >= 0) goto L_0x00d7
            int r13 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r13 > 0) goto L_0x00df
        L_0x00d7:
            int r13 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r13 <= 0) goto L_0x00fb
            int r17 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r17 <= 0) goto L_0x00fb
        L_0x00df:
            long r2 = r0.f
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x00e8
            r0.f = r9
            goto L_0x00f8
        L_0x00e8:
            long r2 = r0.f
            long r2 = r9 - r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f8
        L_0x00f0:
            r0.e = r9
            r0.d = r1
            r0.f = r14
            goto L_0x0019
        L_0x00f8:
            com.amap.api.col.n3.kx r1 = r0.d
            return r1
        L_0x00fb:
            r17 = 1120403456(0x42c80000, float:100.0)
            int r17 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r17 >= 0) goto L_0x0104
            if (r13 <= 0) goto L_0x0104
            goto L_0x00f0
        L_0x0104:
            int r13 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r13 > 0) goto L_0x010a
            r0.f = r14
        L_0x010a:
            r13 = 1092616192(0x41200000, float:10.0)
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0137
            double r13 = (double) r2
            r15 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x0137
            r2 = 1084227584(0x40a00000, float:5.0)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0137
            r2 = -1013579776(0xffffffffc3960000, float:-300.0)
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0129
            com.amap.api.col.n3.kx r1 = r0.d
            return r1
        L_0x0129:
            float r6 = r6 / r7
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0134
            r0.e = r9
            goto L_0x005c
        L_0x0134:
            com.amap.api.col.n3.kx r1 = r0.d
            return r1
        L_0x0137:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0056
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0141
            goto L_0x0056
        L_0x0141:
            com.amap.api.col.n3.kx r1 = r0.d
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.la.a(com.amap.api.col.n3.kx):com.amap.api.col.n3.kx");
    }
}
