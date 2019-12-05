package com.amap.api.col.n3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: CgiManager */
public final class ll {
    int a = 0;
    ArrayList<lk> b = new ArrayList<>();
    TelephonyManager c = null;
    long d = 0;
    CellLocation e;
    boolean f = false;
    PhoneStateListener g = null;
    String h = null;
    boolean i = false;
    StringBuilder j = null;
    HandlerThread k = null;
    private Context l;
    private String m = null;
    private ArrayList<lk> n = new ArrayList<>();
    private int o = -113;
    private lj p = null;
    private Object q;
    private int r = 0;
    /* access modifiers changed from: private */
    public long s = 0;
    /* access modifiers changed from: private */
    public boolean t = false;
    /* access modifiers changed from: private */
    public Object u = new Object();

    /* compiled from: CgiManager */
    class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(6:6|(1:8)(1:11)|9|10|14|(2:16|17)(1:18))|19|20) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLooperPrepared() {
            /*
                r6 = this;
                super.onLooperPrepared()     // Catch:{ Throwable -> 0x0049 }
                com.amap.api.col.n3.ll r0 = com.amap.api.col.n3.ll.this     // Catch:{ Throwable -> 0x0049 }
                java.lang.Object r0 = r0.u     // Catch:{ Throwable -> 0x0049 }
                monitor-enter(r0)     // Catch:{ Throwable -> 0x0049 }
                com.amap.api.col.n3.ll r1 = com.amap.api.col.n3.ll.this     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.t     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x0044
                com.amap.api.col.n3.ll r1 = com.amap.api.col.n3.ll.this     // Catch:{ all -> 0x0046 }
                com.amap.api.col.n3.ll$1 r2 = new com.amap.api.col.n3.ll$1     // Catch:{ all -> 0x0046 }
                r2.<init>()     // Catch:{ all -> 0x0046 }
                r1.g = r2     // Catch:{ all -> 0x0046 }
                java.lang.String r2 = "android.telephony.PhoneStateListener"
                r3 = 0
                int r4 = com.amap.api.col.n3.lu.c()     // Catch:{ all -> 0x0046 }
                r5 = 7
                if (r4 >= r5) goto L_0x002c
                java.lang.String r4 = "LISTEN_SIGNAL_STRENGTH"
            L_0x0027:
                int r2 = com.amap.api.col.n3.ls.b(r2, r4)     // Catch:{ Throwable -> 0x002f }
                goto L_0x0030
            L_0x002c:
                java.lang.String r4 = "LISTEN_SIGNAL_STRENGTHS"
                goto L_0x0027
            L_0x002f:
                r2 = r3
            L_0x0030:
                r3 = 16
                if (r2 != 0) goto L_0x003c
                android.telephony.TelephonyManager r2 = r1.c     // Catch:{ Throwable -> 0x0044 }
                android.telephony.PhoneStateListener r1 = r1.g     // Catch:{ Throwable -> 0x0044 }
                r2.listen(r1, r3)     // Catch:{ Throwable -> 0x0044 }
                goto L_0x0044
            L_0x003c:
                android.telephony.TelephonyManager r4 = r1.c     // Catch:{ Throwable -> 0x0044 }
                android.telephony.PhoneStateListener r1 = r1.g     // Catch:{ Throwable -> 0x0044 }
                r2 = r2 | r3
                r4.listen(r1, r2)     // Catch:{ Throwable -> 0x0044 }
            L_0x0044:
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return
            L_0x0046:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ Throwable -> 0x0049 }
                throw r1     // Catch:{ Throwable -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ll.a.onLooperPrepared():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r3.a.c.listen(r3.a.g, 0);
            r3.a.g = null;
            quit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                super.run()     // Catch:{ Throwable -> 0x0004 }
                return
            L_0x0004:
                com.amap.api.col.n3.ll r0 = com.amap.api.col.n3.ll.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.TelephonyManager r0 = r0.c     // Catch:{ Throwable -> 0x0018 }
                com.amap.api.col.n3.ll r1 = com.amap.api.col.n3.ll.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.PhoneStateListener r1 = r1.g     // Catch:{ Throwable -> 0x0018 }
                r2 = 0
                r0.listen(r1, r2)     // Catch:{ Throwable -> 0x0018 }
                com.amap.api.col.n3.ll r0 = com.amap.api.col.n3.ll.this     // Catch:{ Throwable -> 0x0018 }
                r1 = 0
                r0.g = r1     // Catch:{ Throwable -> 0x0018 }
                r3.quit()     // Catch:{ Throwable -> 0x0018 }
            L_0x0018:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ll.a.run():void");
        }
    }

    public ll(Context context) {
        Context context2;
        String str;
        this.l = context;
        if (this.c == null) {
            this.c = (TelephonyManager) lu.a(this.l, "phone");
        }
        if (this.c != null) {
            try {
                CellLocation cellLocation = this.c.getCellLocation();
                Context context3 = this.l;
                this.a = c(cellLocation);
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                lr.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                this.r = j();
                switch (this.r) {
                    case 1:
                        context2 = this.l;
                        str = "phone_msim";
                        break;
                    case 2:
                        context2 = this.l;
                        str = "phone2";
                        break;
                    default:
                        context2 = this.l;
                        str = "phone2";
                        break;
                }
                this.q = lu.a(context2, str);
            } catch (Throwable unused) {
            }
            if (this.k == null) {
                this.k = new a("listenerPhoneStateThread");
                this.k.start();
            }
        }
        this.p = new lj();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = ls.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
        r2 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa A[RETURN] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.telephony.CellLocation a(java.util.List<android.telephony.CellInfo> r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x00ab
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x000a
            return r0
        L_0x000a:
            r1 = 0
        L_0x000b:
            int r2 = r11.size()
            if (r1 >= r2) goto L_0x0078
            java.lang.Object r2 = r11.get(r1)
            android.telephony.CellInfo r2 = (android.telephony.CellInfo) r2
            if (r2 == 0) goto L_0x0075
            boolean r3 = r2.isRegistered()     // Catch:{ Throwable -> 0x0075 }
            boolean r4 = r2 instanceof android.telephony.CellInfoCdma     // Catch:{ Throwable -> 0x0075 }
            if (r4 == 0) goto L_0x0033
            android.telephony.CellInfoCdma r2 = (android.telephony.CellInfoCdma) r2     // Catch:{ Throwable -> 0x0075 }
            android.telephony.CellIdentityCdma r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0075 }
            boolean r4 = a((android.telephony.CellIdentityCdma) r4)     // Catch:{ Throwable -> 0x0075 }
            if (r4 != 0) goto L_0x002e
            goto L_0x0075
        L_0x002e:
            com.amap.api.col.n3.lk r2 = r10.a((android.telephony.CellInfoCdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0079
        L_0x0033:
            boolean r4 = r2 instanceof android.telephony.CellInfoGsm     // Catch:{ Throwable -> 0x0075 }
            if (r4 == 0) goto L_0x0049
            android.telephony.CellInfoGsm r2 = (android.telephony.CellInfoGsm) r2     // Catch:{ Throwable -> 0x0075 }
            android.telephony.CellIdentityGsm r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0075 }
            boolean r4 = a((android.telephony.CellIdentityGsm) r4)     // Catch:{ Throwable -> 0x0075 }
            if (r4 != 0) goto L_0x0044
            goto L_0x0075
        L_0x0044:
            com.amap.api.col.n3.lk r2 = a((android.telephony.CellInfoGsm) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0079
        L_0x0049:
            boolean r4 = r2 instanceof android.telephony.CellInfoWcdma     // Catch:{ Throwable -> 0x0075 }
            if (r4 == 0) goto L_0x005f
            android.telephony.CellInfoWcdma r2 = (android.telephony.CellInfoWcdma) r2     // Catch:{ Throwable -> 0x0075 }
            android.telephony.CellIdentityWcdma r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0075 }
            boolean r4 = a((android.telephony.CellIdentityWcdma) r4)     // Catch:{ Throwable -> 0x0075 }
            if (r4 != 0) goto L_0x005a
            goto L_0x0075
        L_0x005a:
            com.amap.api.col.n3.lk r2 = a((android.telephony.CellInfoWcdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0079
        L_0x005f:
            boolean r4 = r2 instanceof android.telephony.CellInfoLte     // Catch:{ Throwable -> 0x0075 }
            if (r4 == 0) goto L_0x0078
            android.telephony.CellInfoLte r2 = (android.telephony.CellInfoLte) r2     // Catch:{ Throwable -> 0x0075 }
            android.telephony.CellIdentityLte r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0075 }
            boolean r4 = a((android.telephony.CellIdentityLte) r4)     // Catch:{ Throwable -> 0x0075 }
            if (r4 != 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            com.amap.api.col.n3.lk r2 = a((android.telephony.CellInfoLte) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            int r1 = r1 + 1
            goto L_0x000b
        L_0x0078:
            r2 = r0
        L_0x0079:
            if (r2 == 0) goto L_0x00a3
            int r11 = r2.k     // Catch:{ Throwable -> 0x00a1 }
            r1 = 2
            if (r11 != r1) goto L_0x0094
            android.telephony.cdma.CdmaCellLocation r11 = new android.telephony.cdma.CdmaCellLocation     // Catch:{ Throwable -> 0x00a1 }
            r11.<init>()     // Catch:{ Throwable -> 0x00a1 }
            int r4 = r2.i     // Catch:{ Throwable -> 0x00a7 }
            int r5 = r2.e     // Catch:{ Throwable -> 0x00a7 }
            int r6 = r2.f     // Catch:{ Throwable -> 0x00a7 }
            int r7 = r2.g     // Catch:{ Throwable -> 0x00a7 }
            int r8 = r2.h     // Catch:{ Throwable -> 0x00a7 }
            r3 = r11
            r3.setCellLocationData(r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x00a7 }
            goto L_0x00a7
        L_0x0094:
            android.telephony.gsm.GsmCellLocation r11 = new android.telephony.gsm.GsmCellLocation     // Catch:{ Throwable -> 0x00a1 }
            r11.<init>()     // Catch:{ Throwable -> 0x00a1 }
            int r1 = r2.c     // Catch:{ Throwable -> 0x00a4 }
            int r2 = r2.d     // Catch:{ Throwable -> 0x00a4 }
            r11.setLacAndCid(r1, r2)     // Catch:{ Throwable -> 0x00a4 }
            goto L_0x00a4
        L_0x00a1:
            r11 = r0
            goto L_0x00a7
        L_0x00a3:
            r11 = r0
        L_0x00a4:
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x00a7:
            if (r11 != 0) goto L_0x00aa
            return r0
        L_0x00aa:
            return r11
        L_0x00ab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ll.a(java.util.List):android.telephony.CellLocation");
    }

    private static lk a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        lk lkVar = new lk(i2, z);
        lkVar.a = i3;
        lkVar.b = i4;
        lkVar.c = i5;
        lkVar.d = i6;
        lkVar.j = i7;
        return lkVar;
    }

    @SuppressLint({"NewApi"})
    private lk a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a2 = lu.a(this.c);
        try {
            i3 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
            } catch (Throwable unused) {
                i2 = 0;
                lk a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a3.g = cellIdentity.getSystemId();
                a3.h = cellIdentity.getNetworkId();
                a3.i = cellIdentity.getBasestationId();
                a3.e = cellIdentity.getLatitude();
                a3.f = cellIdentity.getLongitude();
                return a3;
            }
        } catch (Throwable unused2) {
            i3 = 0;
            i2 = 0;
            lk a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a32.g = cellIdentity.getSystemId();
            a32.h = cellIdentity.getNetworkId();
            a32.i = cellIdentity.getBasestationId();
            a32.e = cellIdentity.getLatitude();
            a32.f = cellIdentity.getLongitude();
            return a32;
        }
        lk a322 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a322.g = cellIdentity.getSystemId();
        a322.h = cellIdentity.getNetworkId();
        a322.i = cellIdentity.getBasestationId();
        a322.e = cellIdentity.getLatitude();
        a322.f = cellIdentity.getLongitude();
        return a322;
    }

    @SuppressLint({"NewApi"})
    private static lk a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static lk a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        return a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static lk a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        return a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
    }

    private static lk a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            lk lkVar = new lk(1, false);
            lkVar.a = Integer.parseInt(strArr[0]);
            lkVar.b = Integer.parseInt(strArr[1]);
            lkVar.c = ls.b(neighboringCellInfo, "getLac", new Object[0]);
            lkVar.d = neighboringCellInfo.getCid();
            lkVar.j = lu.a(neighboringCellInfo.getRssi());
            return lkVar;
        } catch (Throwable th) {
            lr.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void a(CellLocation cellLocation, String[] strArr) {
        if (cellLocation != null && this.c != null) {
            this.b.clear();
            if (b(cellLocation)) {
                this.a = 1;
                ArrayList<lk> arrayList = this.b;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                lk lkVar = new lk(1, true);
                lkVar.a = Integer.parseInt(strArr[0]);
                lkVar.b = Integer.parseInt(strArr[1]);
                lkVar.c = gsmCellLocation.getLac();
                lkVar.d = gsmCellLocation.getCid();
                lkVar.j = this.o;
                arrayList.add(lkVar);
                List<NeighboringCellInfo> neighboringCellInfo = this.c.getNeighboringCellInfo();
                if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (neighboringCellInfo2 != null && a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid())) {
                            lk a2 = a(neighboringCellInfo2, strArr);
                            if (a2 != null && !this.b.contains(a2)) {
                                this.b.add(a2);
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(ll llVar, int i2) {
        if (i2 == -113) {
            llVar.o = -113;
            return;
        }
        llVar.o = i2;
        switch (llVar.a) {
            case 1:
            case 2:
                if (llVar.b != null && !llVar.b.isEmpty()) {
                    try {
                        llVar.b.get(0).j = llVar.o;
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private static boolean a(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && a(cellIdentityGsm.getLac()) && b(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && a(cellIdentityLte.getTac()) && b(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && a(cellIdentityWcdma.getLac()) && b(cellIdentityWcdma.getCid());
    }

    private static boolean b(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.i || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            lr.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private CellLocation f() {
        if (this.c != null) {
            try {
                CellLocation cellLocation = this.c.getCellLocation();
                this.h = null;
                if (b(cellLocation)) {
                    this.e = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                lr.a(th, "CgiManager", "getCellLocation");
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation g() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation f2 = f();
        if (b(f2)) {
            return f2;
        }
        if (lu.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        CellLocation a3 = a(telephonyManager, "getCellLocationGemini", 1);
        if (a3 != null) {
        }
        return a3;
    }

    private CellLocation h() {
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> i2 = i();
            if (i2.isInstance(obj)) {
                Object cast = i2.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                try {
                    CellLocation a3 = a(cast, "getCellLocation", 1);
                    if (a3 != null) {
                        return a3;
                    }
                    try {
                        a2 = a(cast, "getCellLocationGemini", 1);
                        if (a2 != null) {
                            return a2;
                        }
                        cellLocation = a(cast, "getAllCellInfo", 1);
                        if (cellLocation != null) {
                            return cellLocation;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cellLocation = a3;
                        lr.a(th, "CgiManager", "getSim2Cgi");
                        return cellLocation;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cellLocation = a2;
                    lr.a(th, "CgiManager", "getSim2Cgi");
                    return cellLocation;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            lr.a(th, "CgiManager", "getSim2Cgi");
            return cellLocation;
        }
        return cellLocation;
    }

    private Class<?> i() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (this.r) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            lr.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private int j() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable unused) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.r;
    }

    public final ArrayList<lk> a() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.telephony.CellLocation r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            android.content.Context r2 = r4.l
            int r2 = r4.c(r5)
            switch(r2) {
                case 1: goto L_0x0035;
                case 2: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            return r1
        L_0x000f:
            java.lang.String r2 = "getSystemId"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x002f }
            int r2 = com.amap.api.col.n3.ls.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
            if (r2 <= 0) goto L_0x002d
            java.lang.String r2 = "getNetworkId"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x002f }
            int r2 = com.amap.api.col.n3.ls.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
            if (r2 < 0) goto L_0x002d
            java.lang.String r2 = "getBaseStationId"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x002f }
            int r5 = com.amap.api.col.n3.ls.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
            if (r5 >= 0) goto L_0x004d
        L_0x002d:
            r1 = r0
            return r1
        L_0x002f:
            r5 = move-exception
            java.lang.String r0 = "CgiManager"
            java.lang.String r2 = "cgiUseful Cgi.iCdmaT"
            goto L_0x004a
        L_0x0035:
            android.telephony.gsm.GsmCellLocation r5 = (android.telephony.gsm.GsmCellLocation) r5     // Catch:{ Throwable -> 0x0045 }
            int r0 = r5.getLac()     // Catch:{ Throwable -> 0x0045 }
            int r5 = r5.getCid()     // Catch:{ Throwable -> 0x0045 }
            boolean r5 = a((int) r0, (int) r5)     // Catch:{ Throwable -> 0x0045 }
            r1 = r5
            return r1
        L_0x0045:
            r5 = move-exception
            java.lang.String r0 = "CgiManager"
            java.lang.String r2 = "cgiUseful Cgi.iGsmT"
        L_0x004a:
            com.amap.api.col.n3.lr.a(r5, r0, r2)
        L_0x004d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ll.a(android.telephony.CellLocation):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0293, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0294, code lost:
        r12.h = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x029a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c7, code lost:
        if (r5 == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0150, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        com.amap.api.col.n3.lr.a(r0, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:136:0x0244 */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0235 A[SYNTHETIC, Splitter:B:132:0x0235] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0244 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0248 A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0268 A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x026c A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0293 A[ExcHandler: SecurityException (r0v0 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046 A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0186 A[Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r12 = this;
            android.content.Context r0 = r12.l     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = com.amap.api.col.n3.lu.a((android.content.Context) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r12.i = r0     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = r12.i     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r0 = r2
            goto L_0x001f
        L_0x0010:
            long r3 = com.amap.api.col.n3.lu.b()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            long r5 = r12.d     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            long r3 = r3 - r5
            r5 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x001e
            goto L_0x000e
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 != 0) goto L_0x0029
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = r0.isEmpty()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x0264
        L_0x0029:
            boolean r0 = r12.i     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r3 = 0
            if (r0 != 0) goto L_0x0069
            android.telephony.TelephonyManager r0 = r12.c     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x0069
            android.telephony.CellLocation r0 = r12.g()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r4 = r12.b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r4 != 0) goto L_0x0040
            android.telephony.CellLocation r0 = r12.h()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x0040:
            boolean r4 = r12.b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r4 == 0) goto L_0x004f
            r12.e = r0     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            long r4 = com.amap.api.col.n3.lu.b()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r12.s = r4     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            goto L_0x0069
        L_0x004f:
            long r4 = com.amap.api.col.n3.lu.b()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            long r6 = r12.s     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            long r4 = r4 - r6
            r6 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0069
            r12.e = r3     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r0.clear()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.n     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r0.clear()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x0069:
            boolean r0 = r12.f     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 != 0) goto L_0x006f
            android.telephony.CellLocation r0 = r12.e     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x006f:
            r12.f = r1     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            android.telephony.CellLocation r0 = r12.e     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = r12.b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x015e
            android.telephony.TelephonyManager r0 = r12.c     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            java.lang.String[] r0 = com.amap.api.col.n3.lu.a((android.telephony.TelephonyManager) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            android.telephony.CellLocation r4 = r12.e     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            android.content.Context r5 = r12.l     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            int r4 = r12.c(r4)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            switch(r4) {
                case 1: goto L_0x0159;
                case 2: goto L_0x008c;
                default: goto L_0x008a;
            }     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x008a:
            goto L_0x015e
        L_0x008c:
            android.telephony.CellLocation r4 = r12.e     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r4 == 0) goto L_0x015e
            java.util.ArrayList<com.amap.api.col.n3.lk> r5 = r12.b     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r5.clear()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            int r5 = com.amap.api.col.n3.lu.c()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r6 = 5
            if (r5 < r6) goto L_0x015e
            java.lang.Object r5 = r12.q     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r5 == 0) goto L_0x00cb
            java.lang.Class r5 = r4.getClass()     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            java.lang.String r6 = "mGsmCellLoc"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            boolean r6 = r5.isAccessible()     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            if (r6 != 0) goto L_0x00b3
            r5.setAccessible(r1)     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
        L_0x00b3:
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            android.telephony.gsm.GsmCellLocation r5 = (android.telephony.gsm.GsmCellLocation) r5     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            if (r5 == 0) goto L_0x00c6
            boolean r6 = r12.b((android.telephony.CellLocation) r5)     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            if (r6 == 0) goto L_0x00c6
            r12.a((android.telephony.CellLocation) r5, (java.lang.String[]) r0)     // Catch:{ Throwable -> 0x00c6, SecurityException -> 0x0293 }
            r5 = r1
            goto L_0x00c7
        L_0x00c6:
            r5 = r2
        L_0x00c7:
            if (r5 == 0) goto L_0x00cb
            goto L_0x015e
        L_0x00cb:
            boolean r5 = r12.b((android.telephony.CellLocation) r4)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r5 != 0) goto L_0x00d3
            goto L_0x015e
        L_0x00d3:
            r5 = 2
            r12.a = r5     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            com.amap.api.col.n3.lk r6 = new com.amap.api.col.n3.lk     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.<init>(r5, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r5 = r0[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.a = r5     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r0 = r0[r1]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.b = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            java.lang.String r0 = "getSystemId"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = com.amap.api.col.n3.ls.b(r4, r0, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.g = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            java.lang.String r0 = "getNetworkId"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = com.amap.api.col.n3.ls.b(r4, r0, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.h = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            java.lang.String r0 = "getBaseStationId"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = com.amap.api.col.n3.ls.b(r4, r0, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.i = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = r12.o     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.j = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            java.lang.String r0 = "getBaseStationLatitude"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = com.amap.api.col.n3.ls.b(r4, r0, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.e = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            java.lang.String r0 = "getBaseStationLongitude"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = com.amap.api.col.n3.ls.b(r4, r0, r1)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.f = r0     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r0 = r6.e     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 < 0) goto L_0x013e
            int r0 = r6.f     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 < 0) goto L_0x013e
            int r0 = r6.e     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x013e
            int r0 = r6.f     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 == r1) goto L_0x013e
            int r0 = r6.e     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            int r1 = r6.f     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 != r1) goto L_0x0142
            int r0 = r6.e     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 <= 0) goto L_0x0142
        L_0x013e:
            r6.e = r2     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r6.f = r2     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
        L_0x0142:
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            boolean r0 = r0.contains(r6)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            if (r0 != 0) goto L_0x015e
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            r0.add(r6)     // Catch:{ Throwable -> 0x0150, SecurityException -> 0x0293 }
            goto L_0x015e
        L_0x0150:
            r0 = move-exception
            java.lang.String r1 = "CgiManager"
            java.lang.String r4 = "hdlCdmaLocChange"
            com.amap.api.col.n3.lr.a(r0, r1, r4)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            goto L_0x015e
        L_0x0159:
            android.telephony.CellLocation r1 = r12.e     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r12.a((android.telephony.CellLocation) r1, (java.lang.String[]) r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x015e:
            int r0 = com.amap.api.col.n3.lu.c()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            r1 = 18
            if (r0 < r1) goto L_0x0244
            android.telephony.TelephonyManager r0 = r12.c     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            if (r0 == 0) goto L_0x0244
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.n     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            com.amap.api.col.n3.lj r1 = r12.p     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            android.telephony.TelephonyManager r4 = r12.c     // Catch:{ SecurityException -> 0x017d, Throwable -> 0x0244 }
            java.util.List r4 = r4.getAllCellInfo()     // Catch:{ SecurityException -> 0x017d, Throwable -> 0x0244 }
            r12.h = r3     // Catch:{ SecurityException -> 0x0178, Throwable -> 0x0244 }
            r3 = r4
            goto L_0x0184
        L_0x0178:
            r3 = move-exception
            r11 = r4
            r4 = r3
            r3 = r11
            goto L_0x017e
        L_0x017d:
            r4 = move-exception
        L_0x017e:
            java.lang.String r4 = r4.getMessage()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            r12.h = r4     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
        L_0x0184:
            if (r3 == 0) goto L_0x0233
            int r4 = r3.size()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            if (r4 == 0) goto L_0x0233
            if (r0 == 0) goto L_0x0191
            r0.clear()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
        L_0x0191:
            r5 = r2
        L_0x0192:
            if (r5 >= r4) goto L_0x0233
            java.lang.Object r6 = r3.get(r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            if (r6 == 0) goto L_0x022f
            boolean r7 = r6.isRegistered()     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            boolean r8 = r6 instanceof android.telephony.CellInfoCdma     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            r9 = 65535(0xffff, double:3.23786E-319)
            if (r8 == 0) goto L_0x01c9
            android.telephony.CellInfoCdma r6 = (android.telephony.CellInfoCdma) r6     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            android.telephony.CellIdentityCdma r8 = r6.getCellIdentity()     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            boolean r8 = a((android.telephony.CellIdentityCdma) r8)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 != 0) goto L_0x01b5
            goto L_0x022f
        L_0x01b5:
            com.amap.api.col.n3.lk r6 = r12.a((android.telephony.CellInfoCdma) r6, (boolean) r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = r1.a((com.amap.api.col.n3.lk) r6)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = java.lang.Math.min(r9, r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            int r7 = (int) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            short r7 = (short) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            r6.l = r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
        L_0x01c5:
            r0.add(r6)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            goto L_0x022f
        L_0x01c9:
            boolean r8 = r6 instanceof android.telephony.CellInfoGsm     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 == 0) goto L_0x01eb
            android.telephony.CellInfoGsm r6 = (android.telephony.CellInfoGsm) r6     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            android.telephony.CellIdentityGsm r8 = r6.getCellIdentity()     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            boolean r8 = a((android.telephony.CellIdentityGsm) r8)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 != 0) goto L_0x01da
            goto L_0x022f
        L_0x01da:
            com.amap.api.col.n3.lk r6 = a((android.telephony.CellInfoGsm) r6, (boolean) r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = r1.a((com.amap.api.col.n3.lk) r6)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = java.lang.Math.min(r9, r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            int r7 = (int) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            short r7 = (short) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            r6.l = r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            goto L_0x01c5
        L_0x01eb:
            boolean r8 = r6 instanceof android.telephony.CellInfoWcdma     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 == 0) goto L_0x020d
            android.telephony.CellInfoWcdma r6 = (android.telephony.CellInfoWcdma) r6     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            android.telephony.CellIdentityWcdma r8 = r6.getCellIdentity()     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            boolean r8 = a((android.telephony.CellIdentityWcdma) r8)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 != 0) goto L_0x01fc
            goto L_0x022f
        L_0x01fc:
            com.amap.api.col.n3.lk r6 = a((android.telephony.CellInfoWcdma) r6, (boolean) r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = r1.a((com.amap.api.col.n3.lk) r6)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = java.lang.Math.min(r9, r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            int r7 = (int) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            short r7 = (short) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            r6.l = r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            goto L_0x01c5
        L_0x020d:
            boolean r8 = r6 instanceof android.telephony.CellInfoLte     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 == 0) goto L_0x022f
            android.telephony.CellInfoLte r6 = (android.telephony.CellInfoLte) r6     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            android.telephony.CellIdentityLte r8 = r6.getCellIdentity()     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            boolean r8 = a((android.telephony.CellIdentityLte) r8)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            if (r8 != 0) goto L_0x021e
            goto L_0x022f
        L_0x021e:
            com.amap.api.col.n3.lk r6 = a((android.telephony.CellInfoLte) r6, (boolean) r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = r1.a((com.amap.api.col.n3.lk) r6)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            long r7 = java.lang.Math.min(r9, r7)     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            int r7 = (int) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            short r7 = (short) r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            r6.l = r7     // Catch:{ Throwable -> 0x022f, SecurityException -> 0x0293 }
            goto L_0x01c5
        L_0x022f:
            int r5 = r5 + 1
            goto L_0x0192
        L_0x0233:
            if (r0 == 0) goto L_0x0244
            int r3 = r0.size()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            if (r3 <= 0) goto L_0x0244
            int r3 = r12.a     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            r3 = r3 | 4
            r12.a = r3     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
            r1.a((java.util.ArrayList<? extends com.amap.api.col.n3.lk>) r0)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x0293 }
        L_0x0244:
            android.telephony.TelephonyManager r0 = r12.c     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x025e
            android.telephony.TelephonyManager r0 = r12.c     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            java.lang.String r0 = r0.getNetworkOperator()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r12.m = r0     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            java.lang.String r0 = r12.m     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 != 0) goto L_0x025e
            int r0 = r12.a     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r0 = r0 | 8
            r12.a = r0     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x025e:
            long r0 = com.amap.api.col.n3.lu.b()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r12.d = r0     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x0264:
            boolean r0 = r12.i     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x026c
            r12.d()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            return
        L_0x026c:
            int r0 = r12.a     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            r0 = r0 & 3
            switch(r0) {
                case 1: goto L_0x027f;
                case 2: goto L_0x0274;
                default: goto L_0x0273;
            }     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x0273:
            return
        L_0x0274:
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = r0.isEmpty()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x0289
            r12.a = r2     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            return
        L_0x027f:
            java.util.ArrayList<com.amap.api.col.n3.lk> r0 = r12.b     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            boolean r0 = r0.isEmpty()     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
            if (r0 == 0) goto L_0x0289
            r12.a = r2     // Catch:{ SecurityException -> 0x0293, Throwable -> 0x028a }
        L_0x0289:
            return
        L_0x028a:
            r0 = move-exception
            java.lang.String r1 = "CgiManager"
            java.lang.String r2 = "refresh"
            com.amap.api.col.n3.lr.a(r0, r1, r2)
            return
        L_0x0293:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r12.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ll.b():void");
    }

    public final void c() {
        this.p.a();
        this.s = 0;
        synchronized (this.u) {
            this.t = true;
        }
        if (!(this.c == null || this.g == null)) {
            try {
                this.c.listen(this.g, 0);
            } catch (Throwable th) {
                lr.a(th, "CgiManager", "destroy");
            }
        }
        this.g = null;
        if (this.k != null) {
            this.k.quit();
            this.k = null;
        }
        this.o = -113;
        this.c = null;
        this.q = null;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.h = null;
        this.e = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String e() {
        return this.m;
    }
}
