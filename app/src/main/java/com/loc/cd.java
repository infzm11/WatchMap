package com.loc;

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
public final class cd {
    int a = 0;
    ArrayList<cc> b = new ArrayList<>();
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
    private ArrayList<cc> n = new ArrayList<>();
    private int o = -113;
    private cb p = null;
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
                com.loc.cd r0 = com.loc.cd.this     // Catch:{ Throwable -> 0x0049 }
                java.lang.Object r0 = r0.u     // Catch:{ Throwable -> 0x0049 }
                monitor-enter(r0)     // Catch:{ Throwable -> 0x0049 }
                com.loc.cd r1 = com.loc.cd.this     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.t     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x0044
                com.loc.cd r1 = com.loc.cd.this     // Catch:{ all -> 0x0046 }
                com.loc.cd$1 r2 = new com.loc.cd$1     // Catch:{ all -> 0x0046 }
                r2.<init>()     // Catch:{ all -> 0x0046 }
                r1.g = r2     // Catch:{ all -> 0x0046 }
                java.lang.String r2 = "android.telephony.PhoneStateListener"
                r3 = 0
                int r4 = com.loc.da.c()     // Catch:{ all -> 0x0046 }
                r5 = 7
                if (r4 >= r5) goto L_0x002c
                java.lang.String r4 = "LISTEN_SIGNAL_STRENGTH"
            L_0x0027:
                int r2 = com.loc.cv.b(r2, r4)     // Catch:{ Throwable -> 0x002f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.a.onLooperPrepared():void");
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
                com.loc.cd r0 = com.loc.cd.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.TelephonyManager r0 = r0.c     // Catch:{ Throwable -> 0x0018 }
                com.loc.cd r1 = com.loc.cd.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.PhoneStateListener r1 = r1.g     // Catch:{ Throwable -> 0x0018 }
                r2 = 0
                r0.listen(r1, r2)     // Catch:{ Throwable -> 0x0018 }
                com.loc.cd r0 = com.loc.cd.this     // Catch:{ Throwable -> 0x0018 }
                r1 = 0
                r0.g = r1     // Catch:{ Throwable -> 0x0018 }
                r3.quit()     // Catch:{ Throwable -> 0x0018 }
            L_0x0018:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.a.run():void");
        }
    }

    public cd(Context context) {
        Context context2;
        String str;
        this.l = context;
        if (this.c == null) {
            this.c = (TelephonyManager) da.a(this.l, "phone");
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
                cs.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                this.r = q();
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
                this.q = da.a(context2, str);
            } catch (Throwable unused) {
            }
            if (this.k == null) {
                this.k = new a("listenerPhoneStateThread");
                this.k.start();
            }
        }
        this.p = new cb();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = cv.a(obj, str, objArr);
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
            com.loc.cc r2 = r10.a((android.telephony.CellInfoCdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
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
            com.loc.cc r2 = a((android.telephony.CellInfoGsm) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
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
            com.loc.cc r2 = a((android.telephony.CellInfoWcdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
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
            com.loc.cc r2 = a((android.telephony.CellInfoLte) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0075 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.a(java.util.List):android.telephony.CellLocation");
    }

    private static cc a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        cc ccVar = new cc(i2, z);
        ccVar.a = i3;
        ccVar.b = i4;
        ccVar.c = i5;
        ccVar.d = i6;
        ccVar.j = i7;
        return ccVar;
    }

    @SuppressLint({"NewApi"})
    private cc a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a2 = da.a(this.c);
        try {
            i3 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
            } catch (Throwable unused) {
                i2 = 0;
                cc a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
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
            cc a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a32.g = cellIdentity.getSystemId();
            a32.h = cellIdentity.getNetworkId();
            a32.i = cellIdentity.getBasestationId();
            a32.e = cellIdentity.getLatitude();
            a32.f = cellIdentity.getLongitude();
            return a32;
        }
        cc a322 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a322.g = cellIdentity.getSystemId();
        a322.h = cellIdentity.getNetworkId();
        a322.i = cellIdentity.getBasestationId();
        a322.e = cellIdentity.getLatitude();
        a322.f = cellIdentity.getLongitude();
        return a322;
    }

    @SuppressLint({"NewApi"})
    private static cc a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static cc a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        return a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static cc a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        return a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
    }

    private static cc a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            cc ccVar = new cc(1, false);
            ccVar.a = Integer.parseInt(strArr[0]);
            ccVar.b = Integer.parseInt(strArr[1]);
            ccVar.c = cv.b(neighboringCellInfo, "getLac", new Object[0]);
            ccVar.d = neighboringCellInfo.getCid();
            ccVar.j = da.a(neighboringCellInfo.getRssi());
            return ccVar;
        } catch (Throwable th) {
            cs.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void a(CellLocation cellLocation, String[] strArr, boolean z) {
        if (cellLocation != null && this.c != null) {
            this.b.clear();
            if (b(cellLocation)) {
                this.a = 1;
                ArrayList<cc> arrayList = this.b;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                cc ccVar = new cc(1, true);
                ccVar.a = Integer.parseInt(strArr[0]);
                ccVar.b = Integer.parseInt(strArr[1]);
                ccVar.c = gsmCellLocation.getLac();
                ccVar.d = gsmCellLocation.getCid();
                ccVar.j = this.o;
                arrayList.add(ccVar);
                if (!z) {
                    List<NeighboringCellInfo> neighboringCellInfo = this.c.getNeighboringCellInfo();
                    if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                        for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                            if (neighboringCellInfo2 != null && a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid())) {
                                cc a2 = a(neighboringCellInfo2, strArr);
                                if (a2 != null && !this.b.contains(a2)) {
                                    this.b.add(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(cd cdVar, int i2) {
        if (i2 == -113) {
            cdVar.o = -113;
            return;
        }
        cdVar.o = i2;
        switch (cdVar.a) {
            case 1:
            case 2:
                if (cdVar.b != null && !cdVar.b.isEmpty()) {
                    try {
                        cdVar.b.get(0).j = cdVar.o;
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
            cs.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private CellLocation m() {
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
                cs.a(th, "CgiManager", "getCellLocation");
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation n() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation m2 = m();
        if (b(m2)) {
            return m2;
        }
        if (da.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation a2 = a((Object) telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        CellLocation a3 = a((Object) telephonyManager, "getCellLocationGemini", 1);
        if (a3 != null) {
        }
        return a3;
    }

    private CellLocation o() {
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> p2 = p();
            if (p2.isInstance(obj)) {
                Object cast = p2.cast(obj);
                CellLocation a2 = a((Object) cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                try {
                    CellLocation a3 = a((Object) cast, "getCellLocation", 1);
                    if (a3 != null) {
                        return a3;
                    }
                    try {
                        a2 = a((Object) cast, "getCellLocationGemini", 1);
                        if (a2 != null) {
                            return a2;
                        }
                        cellLocation = a((Object) cast, "getAllCellInfo", 1);
                        if (cellLocation != null) {
                            return cellLocation;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cellLocation = a3;
                        cs.a(th, "CgiManager", "getSim2Cgi");
                        return cellLocation;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cellLocation = a2;
                    cs.a(th, "CgiManager", "getSim2Cgi");
                    return cellLocation;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cs.a(th, "CgiManager", "getSim2Cgi");
            return cellLocation;
        }
        return cellLocation;
    }

    private Class<?> p() {
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
            cs.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private int q() {
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

    public final ArrayList<cc> a() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:169:0x029f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02a0, code lost:
        com.loc.cs.a(r10, "CgiManager", "refresh");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02a7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02a8, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02a9, code lost:
        r9.h = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00df, code lost:
        if (r10 == false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0168, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        com.loc.cs.a(r10, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:148:0x0259 */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0259 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x025d A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x027d A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0281 A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02a8 A[ExcHandler: SecurityException (r10v1 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0087 A[EDGE_INSN: B:175:0x0087->B:40:0x0087 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046 A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091 A[Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r10, boolean r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.l     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r0 = com.loc.da.a((android.content.Context) r0)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r9.i = r0     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r0 = r9.i     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r0 = r2
            goto L_0x001f
        L_0x0010:
            long r3 = com.loc.da.b()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            long r5 = r9.d     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            long r3 = r3 - r5
            r5 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x001e
            goto L_0x000e
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 != 0) goto L_0x0029
            java.util.ArrayList<com.loc.cc> r0 = r9.b     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r0 = r0.isEmpty()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 == 0) goto L_0x0279
        L_0x0029:
            boolean r0 = r9.i     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r3 = 0
            if (r0 != 0) goto L_0x0069
            android.telephony.TelephonyManager r0 = r9.c     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 == 0) goto L_0x0069
            android.telephony.CellLocation r0 = r9.n()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r4 = r9.b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r4 != 0) goto L_0x0040
            android.telephony.CellLocation r0 = r9.o()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0040:
            boolean r4 = r9.b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r4 == 0) goto L_0x004f
            r9.e = r0     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            long r4 = com.loc.da.b()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r9.s = r4     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            goto L_0x0069
        L_0x004f:
            long r4 = com.loc.da.b()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            long r6 = r9.s     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            long r4 = r4 - r6
            r6 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0069
            r9.e = r3     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            java.util.ArrayList<com.loc.cc> r0 = r9.b     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r0.clear()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            java.util.ArrayList<com.loc.cc> r0 = r9.n     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r0.clear()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0069:
            boolean r0 = r9.f     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 != 0) goto L_0x0087
            android.telephony.CellLocation r0 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 != 0) goto L_0x0087
            if (r11 == 0) goto L_0x0087
            r11 = r2
        L_0x0074:
            r4 = 10
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x007e:
            int r11 = r11 + r1
            android.telephony.CellLocation r0 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 != 0) goto L_0x0087
            r0 = 50
            if (r11 < r0) goto L_0x0074
        L_0x0087:
            r9.f = r1     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            android.telephony.CellLocation r11 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r11 = r9.b((android.telephony.CellLocation) r11)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r11 == 0) goto L_0x0176
            android.telephony.TelephonyManager r11 = r9.c     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            java.lang.String[] r11 = com.loc.da.a((android.telephony.TelephonyManager) r11)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            android.telephony.CellLocation r0 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            android.content.Context r4 = r9.l     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            int r0 = r9.c(r0)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            switch(r0) {
                case 1: goto L_0x0171;
                case 2: goto L_0x00a4;
                default: goto L_0x00a2;
            }     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x00a2:
            goto L_0x0176
        L_0x00a4:
            android.telephony.CellLocation r0 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r0 == 0) goto L_0x0176
            java.util.ArrayList<com.loc.cc> r4 = r9.b     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r4.clear()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            int r4 = com.loc.da.c()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r5 = 5
            if (r4 < r5) goto L_0x0176
            java.lang.Object r4 = r9.q     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r4 == 0) goto L_0x00e3
            java.lang.Class r4 = r0.getClass()     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            java.lang.String r5 = "mGsmCellLoc"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            boolean r5 = r4.isAccessible()     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            if (r5 != 0) goto L_0x00cb
            r4.setAccessible(r1)     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
        L_0x00cb:
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            android.telephony.gsm.GsmCellLocation r4 = (android.telephony.gsm.GsmCellLocation) r4     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            if (r4 == 0) goto L_0x00de
            boolean r5 = r9.b((android.telephony.CellLocation) r4)     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            if (r5 == 0) goto L_0x00de
            r9.a((android.telephony.CellLocation) r4, (java.lang.String[]) r11, (boolean) r10)     // Catch:{ Throwable -> 0x00de, SecurityException -> 0x02a8 }
            r10 = r1
            goto L_0x00df
        L_0x00de:
            r10 = r2
        L_0x00df:
            if (r10 == 0) goto L_0x00e3
            goto L_0x0176
        L_0x00e3:
            boolean r10 = r9.b((android.telephony.CellLocation) r0)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 != 0) goto L_0x00eb
            goto L_0x0176
        L_0x00eb:
            r10 = 2
            r9.a = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            com.loc.cc r4 = new com.loc.cc     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.<init>(r10, r1)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r10 = r11[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.a = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r10 = r11[r1]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.b = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            java.lang.String r10 = "getSystemId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = com.loc.cv.b(r0, r10, r11)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.g = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            java.lang.String r10 = "getNetworkId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = com.loc.cv.b(r0, r10, r11)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.h = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            java.lang.String r10 = "getBaseStationId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = com.loc.cv.b(r0, r10, r11)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.i = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = r9.o     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.j = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            java.lang.String r10 = "getBaseStationLatitude"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = com.loc.cv.b(r0, r10, r11)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.e = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            java.lang.String r10 = "getBaseStationLongitude"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = com.loc.cv.b(r0, r10, r11)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.f = r10     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r10 = r4.e     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 < 0) goto L_0x0156
            int r10 = r4.f     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 < 0) goto L_0x0156
            int r10 = r4.e     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == r11) goto L_0x0156
            int r10 = r4.f     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 == r11) goto L_0x0156
            int r10 = r4.e     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            int r11 = r4.f     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 != r11) goto L_0x015a
            int r10 = r4.e     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 <= 0) goto L_0x015a
        L_0x0156:
            r4.e = r2     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r4.f = r2     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
        L_0x015a:
            java.util.ArrayList<com.loc.cc> r10 = r9.b     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            boolean r10 = r10.contains(r4)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            if (r10 != 0) goto L_0x0176
            java.util.ArrayList<com.loc.cc> r10 = r9.b     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0168, SecurityException -> 0x02a8 }
            goto L_0x0176
        L_0x0168:
            r10 = move-exception
            java.lang.String r11 = "CgiManager"
            java.lang.String r0 = "hdlCdmaLocChange"
            com.loc.cs.a(r10, r11, r0)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            goto L_0x0176
        L_0x0171:
            android.telephony.CellLocation r0 = r9.e     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r9.a((android.telephony.CellLocation) r0, (java.lang.String[]) r11, (boolean) r10)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0176:
            int r10 = com.loc.da.c()     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            r11 = 18
            if (r10 < r11) goto L_0x0259
            android.telephony.TelephonyManager r10 = r9.c     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            if (r10 == 0) goto L_0x0259
            java.util.ArrayList<com.loc.cc> r10 = r9.n     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            com.loc.cb r11 = r9.p     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            android.telephony.TelephonyManager r0 = r9.c     // Catch:{ SecurityException -> 0x0191, Throwable -> 0x0259 }
            java.util.List r0 = r0.getAllCellInfo()     // Catch:{ SecurityException -> 0x0191, Throwable -> 0x0259 }
            r9.h = r3     // Catch:{ SecurityException -> 0x018f, Throwable -> 0x0259 }
            goto L_0x0199
        L_0x018f:
            r1 = move-exception
            goto L_0x0193
        L_0x0191:
            r1 = move-exception
            r0 = r3
        L_0x0193:
            java.lang.String r1 = r1.getMessage()     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            r9.h = r1     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
        L_0x0199:
            if (r0 == 0) goto L_0x0248
            int r1 = r0.size()     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            if (r1 == 0) goto L_0x0248
            if (r10 == 0) goto L_0x01a6
            r10.clear()     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
        L_0x01a6:
            r3 = r2
        L_0x01a7:
            if (r3 >= r1) goto L_0x0248
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            if (r4 == 0) goto L_0x0244
            boolean r5 = r4.isRegistered()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            boolean r6 = r4 instanceof android.telephony.CellInfoCdma     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            r7 = 65535(0xffff, double:3.23786E-319)
            if (r6 == 0) goto L_0x01de
            android.telephony.CellInfoCdma r4 = (android.telephony.CellInfoCdma) r4     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            android.telephony.CellIdentityCdma r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            boolean r6 = a((android.telephony.CellIdentityCdma) r6)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 != 0) goto L_0x01ca
            goto L_0x0244
        L_0x01ca:
            com.loc.cc r4 = r9.a((android.telephony.CellInfoCdma) r4, (boolean) r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = r11.a((com.loc.cc) r4)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            r4.l = r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
        L_0x01da:
            r10.add(r4)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            goto L_0x0244
        L_0x01de:
            boolean r6 = r4 instanceof android.telephony.CellInfoGsm     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 == 0) goto L_0x0200
            android.telephony.CellInfoGsm r4 = (android.telephony.CellInfoGsm) r4     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            android.telephony.CellIdentityGsm r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            boolean r6 = a((android.telephony.CellIdentityGsm) r6)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 != 0) goto L_0x01ef
            goto L_0x0244
        L_0x01ef:
            com.loc.cc r4 = a((android.telephony.CellInfoGsm) r4, (boolean) r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = r11.a((com.loc.cc) r4)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            r4.l = r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            goto L_0x01da
        L_0x0200:
            boolean r6 = r4 instanceof android.telephony.CellInfoWcdma     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 == 0) goto L_0x0222
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            android.telephony.CellIdentityWcdma r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            boolean r6 = a((android.telephony.CellIdentityWcdma) r6)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 != 0) goto L_0x0211
            goto L_0x0244
        L_0x0211:
            com.loc.cc r4 = a((android.telephony.CellInfoWcdma) r4, (boolean) r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = r11.a((com.loc.cc) r4)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            r4.l = r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            goto L_0x01da
        L_0x0222:
            boolean r6 = r4 instanceof android.telephony.CellInfoLte     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 == 0) goto L_0x0244
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            android.telephony.CellIdentityLte r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            boolean r6 = a((android.telephony.CellIdentityLte) r6)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            if (r6 != 0) goto L_0x0233
            goto L_0x0244
        L_0x0233:
            com.loc.cc r4 = a((android.telephony.CellInfoLte) r4, (boolean) r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = r11.a((com.loc.cc) r4)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            r4.l = r5     // Catch:{ Throwable -> 0x0244, SecurityException -> 0x02a8 }
            goto L_0x01da
        L_0x0244:
            int r3 = r3 + 1
            goto L_0x01a7
        L_0x0248:
            if (r10 == 0) goto L_0x0259
            int r0 = r10.size()     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            if (r0 <= 0) goto L_0x0259
            int r0 = r9.a     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            r0 = r0 | 4
            r9.a = r0     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
            r11.a((java.util.ArrayList<? extends com.loc.cc>) r10)     // Catch:{ Throwable -> 0x0259, SecurityException -> 0x02a8 }
        L_0x0259:
            android.telephony.TelephonyManager r10 = r9.c     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r10 == 0) goto L_0x0273
            android.telephony.TelephonyManager r10 = r9.c     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            java.lang.String r10 = r10.getNetworkOperator()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r9.m = r10     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            java.lang.String r10 = r9.m     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r10 != 0) goto L_0x0273
            int r10 = r9.a     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r10 = r10 | 8
            r9.a = r10     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0273:
            long r10 = com.loc.da.b()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r9.d = r10     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0279:
            boolean r10 = r9.i     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r10 == 0) goto L_0x0281
            r9.h()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            return
        L_0x0281:
            int r10 = r9.a     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            r10 = r10 & 3
            switch(r10) {
                case 1: goto L_0x0294;
                case 2: goto L_0x0289;
                default: goto L_0x0288;
            }     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x0288:
            return
        L_0x0289:
            java.util.ArrayList<com.loc.cc> r10 = r9.b     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r10 = r10.isEmpty()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r10 == 0) goto L_0x029e
            r9.a = r2     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            return
        L_0x0294:
            java.util.ArrayList<com.loc.cc> r10 = r9.b     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            boolean r10 = r10.isEmpty()     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
            if (r10 == 0) goto L_0x029e
            r9.a = r2     // Catch:{ SecurityException -> 0x02a8, Throwable -> 0x029f }
        L_0x029e:
            return
        L_0x029f:
            r10 = move-exception
            java.lang.String r11 = "CgiManager"
            java.lang.String r0 = "refresh"
            com.loc.cs.a(r10, r11, r0)
            return
        L_0x02a8:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            r9.h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.a(boolean, boolean):void");
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
            int r2 = com.loc.cv.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
            if (r2 <= 0) goto L_0x002d
            java.lang.String r2 = "getNetworkId"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x002f }
            int r2 = com.loc.cv.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
            if (r2 < 0) goto L_0x002d
            java.lang.String r2 = "getBaseStationId"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x002f }
            int r5 = com.loc.cv.b(r5, r2, r3)     // Catch:{ Throwable -> 0x002f }
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
            com.loc.cs.a(r5, r0, r2)
        L_0x004d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.a(android.telephony.CellLocation):boolean");
    }

    public final ArrayList<cc> b() {
        return this.n;
    }

    public final cc c() {
        if (this.i) {
            return null;
        }
        ArrayList<cc> arrayList = this.b;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.a & 3;
    }

    public final TelephonyManager f() {
        return this.c;
    }

    public final void g() {
        this.p.a();
        this.s = 0;
        synchronized (this.u) {
            this.t = true;
        }
        if (!(this.c == null || this.g == null)) {
            try {
                this.c.listen(this.g, 0);
            } catch (Throwable th) {
                cs.a(th, "CgiManager", "destroy");
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
    public final void h() {
        this.h = null;
        this.e = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String i() {
        return this.h;
    }

    public final String j() {
        return this.m;
    }

    public final String k() {
        if (this.i) {
            h();
        }
        if (this.j == null) {
            this.j = new StringBuilder();
        } else {
            this.j.delete(0, this.j.length());
        }
        if ((this.a & 3) == 1) {
            for (int i2 = 1; i2 < this.b.size(); i2++) {
                StringBuilder sb = this.j;
                sb.append("#");
                sb.append(this.b.get(i2).b);
                StringBuilder sb2 = this.j;
                sb2.append("|");
                sb2.append(this.b.get(i2).c);
                StringBuilder sb3 = this.j;
                sb3.append("|");
                sb3.append(this.b.get(i2).d);
            }
        }
        if (this.j.length() > 0) {
            this.j.deleteCharAt(0);
        }
        return this.j.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l() {
        /*
            r3 = this;
            r0 = 1
            android.telephony.TelephonyManager r1 = r3.c     // Catch:{ Throwable -> 0x001f }
            if (r1 == 0) goto L_0x001f
            android.telephony.TelephonyManager r1 = r3.c     // Catch:{ Throwable -> 0x001f }
            java.lang.String r1 = r1.getSimOperator()     // Catch:{ Throwable -> 0x001f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x001f }
            if (r1 != 0) goto L_0x0012
            return r0
        L_0x0012:
            android.telephony.TelephonyManager r1 = r3.c     // Catch:{ Throwable -> 0x001f }
            java.lang.String r1 = r1.getSimCountryIso()     // Catch:{ Throwable -> 0x001f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x001f }
            if (r1 != 0) goto L_0x001f
            return r0
        L_0x001f:
            android.content.Context r1 = r3.l     // Catch:{ Throwable -> 0x0038 }
            android.net.NetworkInfo r1 = com.loc.da.c((android.content.Context) r1)     // Catch:{ Throwable -> 0x0038 }
            int r1 = com.loc.da.a((android.net.NetworkInfo) r1)     // Catch:{ Throwable -> 0x0038 }
            if (r1 == 0) goto L_0x0037
            r2 = 4
            if (r1 == r2) goto L_0x0037
            r2 = 2
            if (r1 == r2) goto L_0x0037
            r2 = 5
            if (r1 == r2) goto L_0x0037
            r2 = 3
            if (r1 != r2) goto L_0x0038
        L_0x0037:
            return r0
        L_0x0038:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cd.l():boolean");
    }
}
