package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import com.amap.api.location.AMapLocationClientOption;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* compiled from: CollectionManager */
public final class ce {
    public Object a = null;
    public String b = "com.data.carrier_v4.CollectorManager";
    private boolean c = false;
    private Timer d = null;
    private TimerTask e = null;
    private int f = 0;
    private boolean g = true;
    private cn h = null;
    /* access modifiers changed from: private */
    public cg i = null;
    /* access modifiers changed from: private */
    public ConnectivityManager j = null;
    /* access modifiers changed from: private */
    public long k = 0;
    private Context l = null;
    private JSONObject m = null;

    /* compiled from: CollectionManager */
    class a implements Runnable {
        a() {
        }

        public final void run() {
            try {
                cv.a(ce.this.a, "destroy", new Object[0]);
            } catch (Throwable th) {
                cs.a(th, "CollectionManager", "stop3rdCM");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:29|30|31|32) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[SYNTHETIC, Splitter:B:26:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af A[Catch:{ Throwable -> 0x0055, Throwable -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.loc.ce r7, int r8) {
        /*
            boolean r0 = r7.j()
            if (r0 == 0) goto L_0x00bb
            boolean r0 = com.loc.cr.v()
            if (r0 != 0) goto L_0x000e
            goto L_0x00bb
        L_0x000e:
            r0 = 674234367(0x282fffff, float:9.769962E-15)
            r1 = 70254591(0x42fffff, float:2.0688699E-36)
            switch(r8) {
                case 0: goto L_0x0017;
                case 1: goto L_0x002f;
                case 2: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            r0 = r1
            goto L_0x002f
        L_0x0019:
            com.loc.cg r8 = r7.i     // Catch:{ Throwable -> 0x002c }
            if (r8 == 0) goto L_0x0028
            com.loc.cg r8 = r7.i     // Catch:{ Throwable -> 0x002c }
            android.net.ConnectivityManager r1 = r7.j     // Catch:{ Throwable -> 0x002c }
            boolean r8 = r8.a((android.net.ConnectivityManager) r1)     // Catch:{ Throwable -> 0x002c }
            if (r8 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            r0 = 2083520511(0x7c2fffff, float:3.6553767E36)
            goto L_0x002f
        L_0x002c:
            r7 = move-exception
            goto L_0x00b3
        L_0x002f:
            r8 = 0
            r1 = 1
            java.lang.Object r2 = r7.a     // Catch:{ Throwable -> 0x0055 }
            java.lang.String r3 = "callBackWrapData"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0055 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0055 }
            r5.<init>()     // Catch:{ Throwable -> 0x0055 }
            java.lang.String r6 = "e"
            r5.put(r6, r1)     // Catch:{ Throwable -> 0x0055 }
            java.lang.String r6 = "d"
            r5.put(r6, r0)     // Catch:{ Throwable -> 0x0055 }
            java.lang.String r6 = "u"
            r5.put(r6, r1)     // Catch:{ Throwable -> 0x0055 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x0055 }
            r4[r8] = r5     // Catch:{ Throwable -> 0x0055 }
            com.loc.cv.a(r2, r3, r4)     // Catch:{ Throwable -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Throwable -> 0x002c }
        L_0x0059:
            java.lang.Object r2 = r7.a     // Catch:{ Throwable -> 0x0064 }
            java.lang.String r3 = "getReportDate"
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0064 }
            java.lang.Object r2 = com.loc.cv.a(r2, r3, r4)     // Catch:{ Throwable -> 0x0064 }
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            r3 = 3
            if (r2 == 0) goto L_0x0098
            byte[] r2 = (byte[]) r2     // Catch:{ Throwable -> 0x002c }
            com.loc.cn r4 = r7.h     // Catch:{ Throwable -> 0x002c }
            android.content.Context r5 = r7.l     // Catch:{ Throwable -> 0x002c }
            java.lang.String r6 = "http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&"
            java.lang.String r2 = r4.b(r2, r5, r6)     // Catch:{ Throwable -> 0x002c }
            boolean r4 = r7.j()     // Catch:{ Throwable -> 0x002c }
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r7.a     // Catch:{ Throwable -> 0x0096 }
            java.lang.String r5 = "setUploadResult"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Throwable -> 0x0096 }
            r6[r8] = r2     // Catch:{ Throwable -> 0x0096 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)     // Catch:{ Throwable -> 0x0096 }
            r6[r1] = r8     // Catch:{ Throwable -> 0x0096 }
            java.lang.Object r8 = com.loc.cv.a(r4, r5, r6)     // Catch:{ Throwable -> 0x0096 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Throwable -> 0x0096 }
            int r8 = r8.intValue()     // Catch:{ Throwable -> 0x0096 }
            r7.f = r8     // Catch:{ Throwable -> 0x0096 }
            goto L_0x0098
        L_0x0096:
            r7.f = r3     // Catch:{ Throwable -> 0x002c }
        L_0x0098:
            r7.e()     // Catch:{ Throwable -> 0x002c }
            boolean r8 = r7.j()     // Catch:{ Throwable -> 0x002c }
            if (r8 == 0) goto L_0x00ab
            int r8 = r7.k()     // Catch:{ Throwable -> 0x002c }
            if (r8 != 0) goto L_0x00ab
            r7.i()     // Catch:{ Throwable -> 0x002c }
            return
        L_0x00ab:
            int r8 = r7.f     // Catch:{ Throwable -> 0x002c }
            if (r8 < r3) goto L_0x00b2
            r7.i()     // Catch:{ Throwable -> 0x002c }
        L_0x00b2:
            return
        L_0x00b3:
            java.lang.String r8 = "CollectionManager"
            java.lang.String r0 = "up"
            com.loc.cs.a(r7, r8, r0)
            return
        L_0x00bb:
            r7.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ce.a(com.loc.ce, int):void");
    }

    private boolean g() {
        try {
            if (!j()) {
                return false;
            }
            return h();
        } catch (Throwable th) {
            cs.a(th, "CollectionManager", "collStarted");
            return false;
        }
    }

    private boolean h() {
        try {
            return ((Boolean) cv.a(this.a, "isStarted", new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
        if (this.d != null) {
            this.d.cancel();
            this.d.purge();
            this.d = null;
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        return this.a != null;
    }

    /* access modifiers changed from: private */
    public int k() {
        try {
            return ((Integer) cv.a(this.a, "getLeftUploadNum", new Object[0])).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void a() {
        if (j()) {
            try {
                cv.a(this.a, "getColUpHist", new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(Context context, cn cnVar, cg cgVar, AMapLocationClientOption aMapLocationClientOption, ConnectivityManager connectivityManager) {
        if (cr.v()) {
            JSONObject a2 = cs.a(aMapLocationClientOption);
            try {
                if (this.a == null) {
                    this.l = context;
                    this.h = cnVar;
                    this.i = cgVar;
                    this.m = a2;
                    this.j = connectivityManager;
                    if (!this.c) {
                        this.k = da.b();
                        s a3 = cs.a("Collection", "1.0.0");
                        this.c = cx.a(context, a3);
                        if (this.c) {
                            try {
                                this.a = au.a(context, a3, this.b, (Class) null, new Class[]{Context.class}, new Object[]{context});
                            } catch (Throwable unused) {
                            }
                        } else {
                            this.c = true;
                        }
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "CollectionManager", "initCollection");
            }
            if (this.g && !g() && j()) {
                if (!cr.v()) {
                    b();
                } else if (!g()) {
                    try {
                        e();
                        try {
                            cv.a(this.a, "start", new Object[0]);
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable th2) {
                        cs.a(th2, "CollectionManager", "start3rdCM");
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void b() {
        if (j() && g()) {
            try {
                cv.a(this.a, "destroy", new Object[0]);
            } catch (Throwable th) {
                cs.a(th, "CollectionManager", "stop3rdCM");
            }
            i();
        }
    }

    public final void c() {
        if (j() && g()) {
            z.b().submit(new a());
            i();
        }
    }

    public final void d() {
        if (!this.g || !j() || this.i == null || !this.i.a(this.j)) {
            return;
        }
        if (!cr.v()) {
            i();
            return;
        }
        if (this.e == null) {
            this.e = new TimerTask() {
                final /* synthetic */ int a = 2;

                public final void run() {
                    try {
                        Thread.currentThread().setPriority(1);
                        long b2 = da.b() - ce.this.k;
                        if (ce.this.j() && ce.this.k() == 0) {
                            ce.this.i();
                        }
                        if (b2 >= 10000) {
                            if (ce.this.i == null || !ce.this.i.a(ce.this.j)) {
                                ce.this.i();
                            } else {
                                ce.a(ce.this, this.a);
                            }
                        }
                    } catch (Throwable th) {
                        cs.a(th, "CollectionManager", "timerTaskU run");
                    }
                }
            };
        }
        if (this.d == null) {
            this.d = new Timer("T-U", false);
            this.d.schedule(this.e, 2000, 2000);
        }
    }

    public final void e() {
        if (j() && k() > 0) {
        }
    }

    public final String f() {
        try {
            if (this.a != null) {
                return (String) cv.a(this.a, "getInnerString", "version");
            }
        } catch (Throwable th) {
            cs.a(th, "CollectionManager", "getCollVer");
        }
        return null;
    }
}
