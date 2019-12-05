package com.amap.api.col.n3;

import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class lj {
    private HashMap<Long, lk> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    public final long a(lk lkVar) {
        long j;
        int i;
        int i2;
        if (lkVar == null || !lkVar.o) {
            return 0;
        }
        HashMap<Long, lk> hashMap = this.a;
        switch (lkVar.k) {
            case 1:
            case 3:
            case 4:
                i2 = lkVar.a();
                i = lkVar.b();
                break;
            case 2:
                i2 = lkVar.c();
                i = lkVar.d();
                break;
            default:
                j = 0;
                break;
        }
        j = a(i2, i);
        lk lkVar2 = hashMap.get(Long.valueOf(j));
        if (lkVar2 == null) {
            lkVar.m = lu.b();
            hashMap.put(Long.valueOf(j), lkVar);
            return 0;
        } else if (lkVar2.e() != lkVar.e()) {
            lkVar.m = lu.b();
            hashMap.put(Long.valueOf(j), lkVar);
            return 0;
        } else {
            lkVar.m = lkVar2.m;
            hashMap.put(Long.valueOf(j), lkVar);
            return (lu.b() - lkVar2.m) / 1000;
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<? extends com.amap.api.col.n3.lk> r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x009c
            long r0 = com.amap.api.col.n3.lu.b()
            long r2 = r12.b
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            long r2 = r12.b
            long r2 = r0 - r2
            r6 = 60000(0xea60, double:2.9644E-319)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x001a
            return
        L_0x001a:
            java.util.HashMap<java.lang.Long, com.amap.api.col.n3.lk> r2 = r12.a
            int r3 = r13.size()
            r6 = 0
            r7 = r4
            r4 = r6
        L_0x0023:
            if (r4 >= r3) goto L_0x0062
            java.lang.Object r5 = r13.get(r4)
            com.amap.api.col.n3.lk r5 = (com.amap.api.col.n3.lk) r5
            boolean r9 = r5.o
            if (r9 == 0) goto L_0x005f
            int r9 = r5.k
            switch(r9) {
                case 1: goto L_0x003a;
                case 2: goto L_0x0035;
                case 3: goto L_0x003a;
                case 4: goto L_0x003a;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0042
        L_0x0035:
            int r7 = r5.h
            int r8 = r5.i
            goto L_0x003e
        L_0x003a:
            int r7 = r5.c
            int r8 = r5.d
        L_0x003e:
            long r7 = a(r7, r8)
        L_0x0042:
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
            java.lang.Object r9 = r2.get(r9)
            com.amap.api.col.n3.lk r9 = (com.amap.api.col.n3.lk) r9
            if (r9 == 0) goto L_0x005f
            int r10 = r9.e()
            int r11 = r5.e()
            if (r10 != r11) goto L_0x005d
            long r9 = r9.m
            r5.m = r9
            goto L_0x005f
        L_0x005d:
            r5.m = r0
        L_0x005f:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x0062:
            r2.clear()
            int r3 = r13.size()
        L_0x0069:
            if (r6 >= r3) goto L_0x009a
            java.lang.Object r4 = r13.get(r6)
            com.amap.api.col.n3.lk r4 = (com.amap.api.col.n3.lk) r4
            boolean r5 = r4.o
            if (r5 == 0) goto L_0x0097
            int r5 = r4.k
            switch(r5) {
                case 1: goto L_0x0084;
                case 2: goto L_0x007b;
                case 3: goto L_0x0084;
                case 4: goto L_0x0084;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x0090
        L_0x007b:
            int r5 = r4.c()
            int r7 = r4.d()
            goto L_0x008c
        L_0x0084:
            int r5 = r4.a()
            int r7 = r4.b()
        L_0x008c:
            long r7 = a(r5, r7)
        L_0x0090:
            java.lang.Long r5 = java.lang.Long.valueOf(r7)
            r2.put(r5, r4)
        L_0x0097:
            int r6 = r6 + 1
            goto L_0x0069
        L_0x009a:
            r12.b = r0
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lj.a(java.util.ArrayList):void");
    }
}
