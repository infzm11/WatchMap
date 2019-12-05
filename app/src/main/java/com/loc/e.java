package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/* compiled from: APSManager */
public final class e {
    static boolean g = false;
    /* access modifiers changed from: private */
    public h A = null;
    private boolean B = true;
    private String C = "";
    private String D = "jsonp1";
    String a = null;
    b b = null;
    AMapLocation c = null;
    a d = null;
    Context e = null;
    bu f = null;
    HashMap<Messenger, Long> h = new HashMap<>();
    cx i = null;
    long j = 0;
    long k = 0;
    String l = null;
    AMapLocationClientOption m = null;
    AMapLocationClientOption n = new AMapLocationClientOption();
    ServerSocket o = null;
    boolean p = false;
    Socket q = null;
    boolean r = false;
    c s = null;
    private boolean t = false;
    private boolean u = false;
    private long v = 0;
    private long w = 0;
    private AMapLocationServer x = null;
    private long y = 0;
    private int z = 0;

    /* compiled from: APSManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A[Catch:{ Throwable -> 0x00d8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                r0 = 0
                android.os.Bundle r1 = r7.getData()     // Catch:{ Throwable -> 0x003e }
                android.os.Messenger r2 = r7.replyTo     // Catch:{ Throwable -> 0x003b }
                if (r1 == 0) goto L_0x0048
                boolean r3 = r1.isEmpty()     // Catch:{ Throwable -> 0x0039 }
                if (r3 != 0) goto L_0x0048
                java.lang.String r3 = "c"
                java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.e r4 = com.loc.e.this     // Catch:{ Throwable -> 0x0039 }
                boolean r3 = r4.a((java.lang.String) r3)     // Catch:{ Throwable -> 0x0039 }
                if (r3 != 0) goto L_0x0048
                int r3 = r7.what     // Catch:{ Throwable -> 0x0039 }
                r4 = 1
                if (r3 != r4) goto L_0x0038
                r3 = 2102(0x836, float:2.946E-42)
                com.loc.cx.a((java.lang.String) r0, (int) r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.e r3 = com.loc.e.this     // Catch:{ Throwable -> 0x0039 }
                java.lang.String r3 = "invalid handlder scode!!!#1002"
                com.autonavi.aps.amapapi.model.AMapLocationServer r3 = com.loc.e.a(10, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.e r4 = com.loc.e.this     // Catch:{ Throwable -> 0x0039 }
                java.lang.String r5 = r3.k()     // Catch:{ Throwable -> 0x0039 }
                r4.a((android.os.Messenger) r2, (com.amap.api.location.AMapLocation) r3, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0039 }
            L_0x0038:
                return
            L_0x0039:
                r3 = move-exception
                goto L_0x0041
            L_0x003b:
                r3 = move-exception
                r2 = r0
                goto L_0x0041
            L_0x003e:
                r3 = move-exception
                r1 = r0
                r2 = r1
            L_0x0041:
                java.lang.String r4 = "APSServiceCore"
                java.lang.String r5 = "ActionHandler handlerMessage"
                com.loc.cs.a(r3, r4, r5)     // Catch:{ Throwable -> 0x00d8 }
            L_0x0048:
                int r3 = r7.what     // Catch:{ Throwable -> 0x00d8 }
                switch(r3) {
                    case 0: goto L_0x00ca;
                    case 1: goto L_0x00bf;
                    case 2: goto L_0x00aa;
                    case 3: goto L_0x0095;
                    case 4: goto L_0x008a;
                    case 5: goto L_0x007f;
                    case 6: goto L_0x004d;
                    case 7: goto L_0x0074;
                    case 8: goto L_0x004d;
                    case 9: goto L_0x0069;
                    case 10: goto L_0x005d;
                    case 11: goto L_0x0056;
                    case 12: goto L_0x004f;
                    default: goto L_0x004d;
                }     // Catch:{ Throwable -> 0x00d8 }
            L_0x004d:
                goto L_0x00d4
            L_0x004f:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.h.remove(r2)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0056:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.e()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x005d:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Messenger) r2, (android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0069:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.a((com.loc.e) r0, (android.os.Messenger) r2)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0074:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.c((com.loc.e) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x007f:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.b((com.loc.e) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x008a:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.a((com.loc.e) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0095:
                if (r1 == 0) goto L_0x00a9
                boolean r1 = r1.isEmpty()     // Catch:{ Throwable -> 0x00d8 }
                if (r1 == 0) goto L_0x009e
                return
            L_0x009e:
                com.loc.e r1 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r1.a((android.os.Bundle) r0)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.d()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00a9:
                return
            L_0x00aa:
                if (r1 == 0) goto L_0x00be
                boolean r1 = r1.isEmpty()     // Catch:{ Throwable -> 0x00d8 }
                if (r1 == 0) goto L_0x00b3
                return
            L_0x00b3:
                com.loc.e r1 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r1.a((android.os.Bundle) r0)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.c()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00be:
                return
            L_0x00bf:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.b(r0, r2, r1)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00ca:
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                r0.a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e r0 = com.loc.e.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.e.a((com.loc.e) r0, (android.os.Messenger) r2, (android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
            L_0x00d4:
                super.handleMessage(r7)     // Catch:{ Throwable -> 0x00d8 }
                return
            L_0x00d8:
                r7 = move-exception
                java.lang.String r0 = "actionHandler"
                java.lang.String r1 = "handleMessage"
                com.loc.cs.a(r7, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.e.a.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: APSManager */
    class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                h unused = e.this.A = new h(e.this.e);
            } catch (Throwable th) {
                cs.a(th, "actionHandler", "onLooperPrepared");
                return;
            }
            e.this.f = new bu();
            super.onLooperPrepared();
        }
    }

    /* compiled from: APSManager */
    class c extends Thread {
        c() {
        }

        public final void run() {
            try {
                if (!e.this.p) {
                    e.this.p = true;
                    e.this.o = new ServerSocket(43689);
                }
                while (e.this.p && e.this.o != null) {
                    e.this.q = e.this.o.accept();
                    e.a(e.this, e.this.q);
                }
            } catch (Throwable th) {
                cs.a(th, "APSServiceCore", "run");
            }
            super.run();
        }
    }

    public e(Context context) {
        this.e = context;
    }

    /* access modifiers changed from: private */
    public static AMapLocationServer a(int i2, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i2);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (!this.t) {
                cs.a(this.e);
                if (bundle != null) {
                    this.n = cs.a(bundle.getBundle("optBundle"));
                }
                this.t = true;
                this.f.a(this.e);
                this.f.a();
                a(this.n);
                this.f.b();
            }
        } catch (Throwable th) {
            this.B = false;
            this.C = th.getMessage();
            cs.a(th, "APSServiceCore", "init");
        }
    }

    private void a(Messenger messenger) {
        try {
            if (cr.d(this.e)) {
                a(messenger, 100, (Bundle) null);
            }
            this.d.removeMessages(4);
            if (cr.a()) {
                this.d.sendEmptyMessage(4);
            }
            this.d.removeMessages(5);
            if (cr.c() && cr.d() > 2) {
                this.d.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "checkConfig");
        }
    }

    private static void a(Messenger messenger, int i2, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i2;
                messenger.send(obtain);
            } catch (Throwable th) {
                cs.a(th, "APSServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Messenger messenger, AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        this.h.put(messenger, Long.valueOf(da.b()));
        a(messenger, 1, bundle);
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.f != null) {
                this.f.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (!(this.m == null || (aMapLocationClientOption.isOffset() == this.m.isOffset() && aMapLocationClientOption.isNeedAddress() == this.m.isNeedAddress() && aMapLocationClientOption.isLocationCacheEnable() == this.m.isLocationCacheEnable()))) {
                    this.w = 0;
                }
                this.m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "setExtra");
        }
    }

    static /* synthetic */ void a(e eVar) {
        try {
            if (eVar.z < cr.b()) {
                eVar.z++;
                eVar.f.e();
                eVar.d.sendEmptyMessageDelayed(4, 2000);
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "doGpsFusion");
        }
    }

    static /* synthetic */ void a(e eVar, Messenger messenger) {
        try {
            eVar.b(messenger);
            cr.f(eVar.e);
            try {
                bu buVar = eVar.f;
                Context context = eVar.e;
                buVar.h();
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "doCallOtherSer");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|(1:16)|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.loc.e r2, android.os.Messenger r3, android.os.Bundle r4) {
        /*
            if (r4 == 0) goto L_0x0050
            boolean r0 = r4.isEmpty()     // Catch:{ Throwable -> 0x0048 }
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            boolean r0 = r2.u     // Catch:{ Throwable -> 0x0048 }
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            r0 = 1
            r2.u = r0     // Catch:{ Throwable -> 0x0048 }
            r2.b((android.os.Messenger) r3)     // Catch:{ Throwable -> 0x0048 }
            android.content.Context r0 = r2.e     // Catch:{ Throwable -> 0x0048 }
            com.loc.cr.f(r0)     // Catch:{ Throwable -> 0x0048 }
            com.loc.bu r0 = r2.f     // Catch:{ Throwable -> 0x0020 }
            android.content.Context r1 = r2.e     // Catch:{ Throwable -> 0x0020 }
            r0.g()     // Catch:{ Throwable -> 0x0020 }
        L_0x0020:
            r2.a((android.os.Messenger) r3)     // Catch:{ Throwable -> 0x0048 }
            long r0 = r2.y     // Catch:{ Throwable -> 0x0048 }
            boolean r3 = com.loc.cr.a((long) r0)     // Catch:{ Throwable -> 0x0048 }
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = "1"
            java.lang.String r0 = "isCacheLoc"
            java.lang.String r4 = r4.getString(r0)     // Catch:{ Throwable -> 0x0048 }
            boolean r3 = r3.equals(r4)     // Catch:{ Throwable -> 0x0048 }
            if (r3 == 0) goto L_0x0044
            long r3 = com.loc.da.b()     // Catch:{ Throwable -> 0x0048 }
            r2.y = r3     // Catch:{ Throwable -> 0x0048 }
            com.loc.bu r3 = r2.f     // Catch:{ Throwable -> 0x0048 }
            r3.e()     // Catch:{ Throwable -> 0x0048 }
        L_0x0044:
            r2.h()     // Catch:{ Throwable -> 0x0048 }
            return
        L_0x0048:
            r2 = move-exception
            java.lang.String r3 = "APSServiceCore"
            java.lang.String r4 = "doInitAuth"
            com.loc.cs.a(r2, r3, r4)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.e.a(com.loc.e, android.os.Messenger, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0109, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        com.loc.cs.a(r7, "APSServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0112, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0113, code lost:
        com.loc.cs.a(r6, "APSServiceCore", "invokeSocketLocation part4");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x011a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.loc.cs.a(r6, "APSServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.loc.cs.a(r7, "APSServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a7, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        com.loc.cs.a(r7, "APSServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00ea, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:13:0x0022, B:24:0x0039, B:34:0x004c, B:46:0x0064, B:66:0x00ae, B:76:0x00c1, B:98:0x00f1, B:106:0x0102] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.loc.e r6, java.net.Socket r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = com.loc.cs.f     // Catch:{ Throwable -> 0x0112 }
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.io.InputStream r4 = r7.getInputStream()     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            r6.a((java.io.BufferedReader) r2)     // Catch:{ Throwable -> 0x005c }
            java.lang.String r3 = r6.g()     // Catch:{ Throwable -> 0x005c }
            com.loc.cs.f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.c((java.lang.String) r3)     // Catch:{ Throwable -> 0x0034 }
            r2.close()     // Catch:{ Throwable -> 0x0029 }
            r7.close()     // Catch:{ Throwable -> 0x0029 }
            return
        L_0x0029:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.cs.a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x0032:
            r6 = move-exception
            goto L_0x004c
        L_0x0034:
            r6 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.cs.a(r6, r0, r1)     // Catch:{ all -> 0x0032 }
            r2.close()     // Catch:{ Throwable -> 0x0043 }
            r7.close()     // Catch:{ Throwable -> 0x0043 }
            return
        L_0x0043:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.cs.a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x004c:
            r2.close()     // Catch:{ Throwable -> 0x0053 }
            r7.close()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r7 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.cs.a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x005b:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x005c:
            r3 = move-exception
            goto L_0x0064
        L_0x005e:
            r3 = move-exception
            r2 = r1
            goto L_0x00d5
        L_0x0062:
            r3 = move-exception
            r2 = r1
        L_0x0064:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r4.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.D     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "&&"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.D     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "({'package':'"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.a     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "','error_code':1,'error':'params error'})"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = "APSServiceCore"
            java.lang.String r5 = "invokeSocketLocation"
            com.loc.cs.a(r3, r1, r5)     // Catch:{ all -> 0x00d1 }
            com.loc.cs.f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.c((java.lang.String) r4)     // Catch:{ Throwable -> 0x00a9 }
            r2.close()     // Catch:{ Throwable -> 0x009e }
            r7.close()     // Catch:{ Throwable -> 0x009e }
            return
        L_0x009e:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.cs.a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x00a7:
            r6 = move-exception
            goto L_0x00c1
        L_0x00a9:
            r6 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.cs.a(r6, r0, r1)     // Catch:{ all -> 0x00a7 }
            r2.close()     // Catch:{ Throwable -> 0x00b8 }
            r7.close()     // Catch:{ Throwable -> 0x00b8 }
            return
        L_0x00b8:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.cs.a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x00c1:
            r2.close()     // Catch:{ Throwable -> 0x00c8 }
            r7.close()     // Catch:{ Throwable -> 0x00c8 }
            goto L_0x00d0
        L_0x00c8:
            r7 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.cs.a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x00d0:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x00d1:
            r3 = move-exception
            r1 = r4
            goto L_0x00d5
        L_0x00d4:
            r3 = move-exception
        L_0x00d5:
            com.loc.cs.f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.c((java.lang.String) r1)     // Catch:{ Throwable -> 0x00ec }
            r2.close()     // Catch:{ Throwable -> 0x00e1 }
            r7.close()     // Catch:{ Throwable -> 0x00e1 }
            goto L_0x0101
        L_0x00e1:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
        L_0x00e6:
            com.loc.cs.a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            goto L_0x0101
        L_0x00ea:
            r6 = move-exception
            goto L_0x0102
        L_0x00ec:
            r6 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.cs.a(r6, r0, r1)     // Catch:{ all -> 0x00ea }
            r2.close()     // Catch:{ Throwable -> 0x00fb }
            r7.close()     // Catch:{ Throwable -> 0x00fb }
            goto L_0x0101
        L_0x00fb:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            goto L_0x00e6
        L_0x0101:
            throw r3     // Catch:{ Throwable -> 0x0112 }
        L_0x0102:
            r2.close()     // Catch:{ Throwable -> 0x0109 }
            r7.close()     // Catch:{ Throwable -> 0x0109 }
            goto L_0x0111
        L_0x0109:
            r7 = move-exception
            java.lang.String r0 = "APSServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.cs.a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x0111:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x0112:
            r6 = move-exception
            java.lang.String r7 = "APSServiceCore"
            java.lang.String r0 = "invokeSocketLocation part4"
            com.loc.cs.a(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.e.a(com.loc.e, java.net.Socket):void");
    }

    private void a(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        int i2 = 30000;
        if (readLine != null && readLine.length() > 0) {
            String[] split = readLine.split(" ");
            if (split != null && split.length > 1) {
                String[] split2 = split[1].split("\\?");
                if (split2 != null && split2.length > 1) {
                    String[] split3 = split2[1].split("&");
                    if (split3 != null && split3.length > 0) {
                        int i3 = 30000;
                        for (String split4 : split3) {
                            String[] split5 = split4.split("=");
                            if (split5 != null && split5.length > 1) {
                                if ("to".equals(split5[0])) {
                                    i3 = Integer.parseInt(split5[1]);
                                }
                                if ("callback".equals(split5[0])) {
                                    this.D = split5[1];
                                }
                            }
                        }
                        i2 = i3;
                    }
                }
            }
        }
        cs.f = i2;
    }

    private AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption a2 = cs.a(bundle.getBundle("optBundle"));
        a(a2);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                n.a(string);
                return a2;
            }
        } catch (Throwable th) {
            cs.a(th, "APSManager", "parseBundle");
        }
        return a2;
    }

    private void b(Messenger messenger) {
        try {
            bu buVar = this.f;
            bu.b(this.e);
            if (cr.q()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("ngpsAble", cr.s());
                a(messenger, 7, bundle);
                cr.r();
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "initAuth");
        }
    }

    static /* synthetic */ void b(e eVar) {
        bu buVar;
        try {
            if (cr.e()) {
                buVar = eVar.f;
            } else {
                if (!da.e(eVar.e)) {
                    buVar = eVar.f;
                }
                eVar.d.sendEmptyMessageDelayed(5, (long) (cr.d() * 1000));
            }
            buVar.e();
            eVar.d.sendEmptyMessageDelayed(5, (long) (cr.d() * 1000));
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "doOffFusion");
        }
    }

    static /* synthetic */ void b(e eVar, Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    AMapLocationClientOption b2 = eVar.b(bundle);
                    if (eVar.h.containsKey(messenger) && !b2.isOnceLocation()) {
                        if (da.b() - eVar.h.get(messenger).longValue() < 800) {
                            return;
                        }
                    }
                    String str = null;
                    if (!eVar.B) {
                        eVar.x = a(9, "init error : " + eVar.C + "#0901");
                        eVar.a(messenger, (AMapLocation) eVar.x, eVar.x.k());
                        cx.a((String) null, 2091);
                        return;
                    }
                    long b3 = da.b();
                    if (eVar.x == null || eVar.x.getErrorCode() != 0 || b3 - eVar.w >= 600) {
                        cw cwVar = new cw();
                        cwVar.a(da.b());
                        eVar.x = eVar.f.d();
                        cwVar.a(eVar.x);
                        eVar.x = eVar.f.a(eVar.x, new String[0]);
                        cwVar.b(da.b());
                        if (eVar.x != null && eVar.x.getErrorCode() == 0) {
                            eVar.w = da.b();
                        }
                        if (eVar.x == null) {
                            eVar.x = a(8, "loc is null#0801");
                        }
                        if (eVar.x != null) {
                            str = eVar.x.k();
                        }
                        AMapLocation aMapLocation = eVar.x;
                        try {
                            if (b2.isLocationCacheEnable() && eVar.A != null) {
                                aMapLocation = eVar.A.a(eVar.x, str, b2.getLastLocationLifeCycle());
                            }
                        } catch (Throwable th) {
                            cs.a(th, "APSServiceCore", "fixLastLocation");
                        }
                        eVar.a(messenger, aMapLocation, str);
                        cx.a(eVar.e, cwVar);
                    } else {
                        eVar.a(messenger, (AMapLocation) eVar.x, eVar.x.k());
                    }
                    eVar.b(messenger);
                    if (cr.C()) {
                        eVar.a(messenger);
                    }
                    if (cr.a(eVar.y) && eVar.x != null && (eVar.x.getLocationType() == 2 || eVar.x.getLocationType() == 4 || eVar.x.getLocationType() == 9)) {
                        eVar.y = da.b();
                        eVar.f.e();
                    }
                    eVar.h();
                }
            } catch (Throwable th2) {
                cs.a(th2, "APSServiceCore", "doLocation");
            }
        }
    }

    static /* synthetic */ void c(e eVar) {
        try {
            if (cr.a(eVar.e, eVar.v)) {
                eVar.v = da.a();
                eVar.f.e();
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "doNGps");
        }
    }

    private void c(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.q.getOutputStream(), true, "UTF-8");
        printStream.println("HTTP/1.0 200 OK");
        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    public static void f() {
        g = false;
    }

    private String g() {
        StringBuilder sb;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (da.e(this.e)) {
            sb = new StringBuilder();
            sb.append(this.D);
            sb.append("&&");
            sb.append(this.D);
            sb.append("({'package':'");
            sb.append(this.a);
            str = "','error_code':36,'error':'app is background'})";
        } else {
            if (this.x == null || currentTimeMillis - this.x.getTime() > 5000) {
                try {
                    this.x = this.f.d();
                } catch (Throwable th) {
                    cs.a(th, "APSServiceCore", "getSocketLocResult");
                }
            }
            if (this.x == null) {
                sb = new StringBuilder();
                sb.append(this.D);
                sb.append("&&");
                sb.append(this.D);
                sb.append("({'package':'");
                sb.append(this.a);
                str = "','error_code':8,'error':'unknown error'})";
            } else if (this.x.getErrorCode() != 0) {
                sb = new StringBuilder();
                sb.append(this.D);
                sb.append("&&");
                sb.append(this.D);
                sb.append("({'package':'");
                sb.append(this.a);
                sb.append("','error_code':");
                sb.append(this.x.getErrorCode());
                sb.append(",'error':'");
                sb.append(this.x.getErrorInfo());
                str = "'})";
            } else {
                sb = new StringBuilder();
                sb.append(this.D);
                sb.append("&&");
                sb.append(this.D);
                sb.append("({'package':'");
                sb.append(this.a);
                sb.append("','error_code':0,'error':'','location':{'y':");
                sb.append(this.x.getLatitude());
                sb.append(",'precision':");
                sb.append(this.x.getAccuracy());
                sb.append(",'x':");
                sb.append(this.x.getLongitude());
                str = "},'version_code':'3.6.1','version':'3.6.1'})";
            }
        }
        sb.append(str);
        return sb.toString();
    }

    private void h() {
        try {
            if (this.f != null) {
                this.f.k();
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "startColl");
        }
    }

    public final void a() {
        try {
            this.i = new cx();
            this.b = new b("amapLocCoreThread");
            this.b.setPriority(5);
            this.b.start();
            this.d = new a(this.b.getLooper());
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "onCreate");
        }
    }

    public final void a(Intent intent) {
        if ("true".equals(intent.getStringExtra("as")) && this.d != null) {
            this.d.sendEmptyMessageDelayed(9, 100);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Messenger messenger, Bundle bundle) {
        float f2;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty() && cr.z()) {
                    double d2 = bundle.getDouble("lat");
                    double d3 = bundle.getDouble("lon");
                    if (this.c != null) {
                        f2 = da.a(new double[]{d2, d3, this.c.getLatitude(), this.c.getLongitude()});
                        if (f2 < ((float) (cr.A() * 3))) {
                            Bundle bundle2 = new Bundle();
                            bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                            bundle2.putInt("lMaxGeoDis", cr.A() * 3);
                            bundle2.putInt("lMinGeoDis", cr.A());
                            bundle2.putParcelable("loc", this.c);
                            a(messenger, 6, bundle2);
                        }
                    } else {
                        f2 = -1.0f;
                    }
                    if (f2 == -1.0f || f2 > ((float) cr.A())) {
                        a((Bundle) null);
                        this.c = this.f.a(d2, d3);
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "APSServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(this.l)) {
            this.l = cs.c(this.e);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.l);
    }

    public final Handler b() {
        return this.d;
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            l.a(stringExtra);
        }
        this.a = intent.getStringExtra("b");
        k.a(this.a);
        String stringExtra2 = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra2)) {
            n.a(stringExtra2);
        }
    }

    public final void c() {
        try {
            if (!this.r) {
                this.s = new c();
                this.s.start();
                this.r = true;
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "startSocket");
        }
    }

    public final void d() {
        try {
            if (this.q != null) {
                this.q.close();
            }
        } catch (Throwable th) {
            cs.a(th, "APSServiceCore", "doStopScocket 1");
        }
        try {
            if (this.o != null) {
                this.o.close();
            }
        } catch (Throwable th2) {
            cs.a(th2, "APSServiceCore", "doStopScocket 2");
        }
        try {
            if (this.s != null) {
                this.s.interrupt();
            }
        } catch (Throwable unused) {
        }
        this.s = null;
        this.o = null;
        this.p = false;
        this.r = false;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r11 = this;
            java.util.HashMap<android.os.Messenger, java.lang.Long> r0 = r11.h     // Catch:{ Throwable -> 0x00a3 }
            r0.clear()     // Catch:{ Throwable -> 0x00a3 }
            r0 = 0
            r11.h = r0     // Catch:{ Throwable -> 0x00a3 }
            com.loc.bu r1 = r11.f     // Catch:{ Throwable -> 0x00a3 }
            if (r1 == 0) goto L_0x0013
            com.loc.bu r1 = r11.f     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r1 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            com.loc.bu.b((android.content.Context) r1)     // Catch:{ Throwable -> 0x00a3 }
        L_0x0013:
            com.loc.e$a r1 = r11.d     // Catch:{ Throwable -> 0x00a3 }
            if (r1 == 0) goto L_0x001c
            com.loc.e$a r1 = r11.d     // Catch:{ Throwable -> 0x00a3 }
            r1.removeCallbacksAndMessages(r0)     // Catch:{ Throwable -> 0x00a3 }
        L_0x001c:
            com.loc.e$b r1 = r11.b     // Catch:{ Throwable -> 0x00a3 }
            r2 = 0
            if (r1 == 0) goto L_0x003c
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x00a3 }
            r3 = 18
            if (r1 < r3) goto L_0x0039
            com.loc.e$b r1 = r11.b     // Catch:{ Throwable -> 0x0033 }
            java.lang.Class<android.os.HandlerThread> r3 = android.os.HandlerThread.class
            java.lang.String r4 = "quitSafely"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0033 }
            com.loc.cv.a((java.lang.Object) r1, (java.lang.Class<?>) r3, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ Throwable -> 0x0033 }
            goto L_0x003c
        L_0x0033:
            com.loc.e$b r1 = r11.b     // Catch:{ Throwable -> 0x00a3 }
        L_0x0035:
            r1.quit()     // Catch:{ Throwable -> 0x00a3 }
            goto L_0x003c
        L_0x0039:
            com.loc.e$b r1 = r11.b     // Catch:{ Throwable -> 0x00a3 }
            goto L_0x0035
        L_0x003c:
            r11.b = r0     // Catch:{ Throwable -> 0x00a3 }
            r11.d = r0     // Catch:{ Throwable -> 0x00a3 }
            com.loc.h r1 = r11.A     // Catch:{ Throwable -> 0x00a3 }
            if (r1 == 0) goto L_0x004b
            com.loc.h r1 = r11.A     // Catch:{ Throwable -> 0x00a3 }
            r1.c()     // Catch:{ Throwable -> 0x00a3 }
            r11.A = r0     // Catch:{ Throwable -> 0x00a3 }
        L_0x004b:
            r11.d()     // Catch:{ Throwable -> 0x00a3 }
            r11.t = r2     // Catch:{ Throwable -> 0x00a3 }
            r11.u = r2     // Catch:{ Throwable -> 0x00a3 }
            com.loc.bu r0 = r11.f     // Catch:{ Throwable -> 0x00a3 }
            r0.f()     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r0 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            com.loc.cx.a((android.content.Context) r0)     // Catch:{ Throwable -> 0x00a3 }
            com.loc.cx r0 = r11.i     // Catch:{ Throwable -> 0x00a3 }
            if (r0 == 0) goto L_0x0094
            long r0 = r11.j     // Catch:{ Throwable -> 0x00a3 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            long r0 = r11.k     // Catch:{ Throwable -> 0x00a3 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            long r0 = com.loc.da.b()     // Catch:{ Throwable -> 0x00a3 }
            long r2 = r11.j     // Catch:{ Throwable -> 0x00a3 }
            long r9 = r0 - r2
            com.loc.cx r0 = r11.i     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r1 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            int r5 = r0.c(r1)     // Catch:{ Throwable -> 0x00a3 }
            com.loc.cx r0 = r11.i     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r1 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            int r6 = r0.d(r1)     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r4 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            long r7 = r11.k     // Catch:{ Throwable -> 0x00a3 }
            com.loc.cx.a(r4, r5, r6, r7, r9)     // Catch:{ Throwable -> 0x00a3 }
            com.loc.cx r0 = r11.i     // Catch:{ Throwable -> 0x00a3 }
            android.content.Context r1 = r11.e     // Catch:{ Throwable -> 0x00a3 }
            r0.e(r1)     // Catch:{ Throwable -> 0x00a3 }
        L_0x0094:
            com.loc.z.a()     // Catch:{ Throwable -> 0x00a3 }
            boolean r0 = g     // Catch:{ Throwable -> 0x00a3 }
            if (r0 == 0) goto L_0x00a2
            int r0 = android.os.Process.myPid()     // Catch:{ Throwable -> 0x00a3 }
            android.os.Process.killProcess(r0)     // Catch:{ Throwable -> 0x00a3 }
        L_0x00a2:
            return
        L_0x00a3:
            r0 = move-exception
            java.lang.String r1 = "APSServiceCore"
            java.lang.String r2 = "threadDestroy"
            com.loc.cs.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.e.e():void");
    }
}
