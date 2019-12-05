package com.loc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AMapLocationManager */
public class d implements LocationManagerBase {
    private volatile boolean A = false;
    /* access modifiers changed from: private */
    public boolean B = true;
    private ServiceConnection C = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.i = new Messenger(iBinder);
                boolean unused = d.this.z = true;
                d.this.r = true;
            } catch (Throwable th) {
                cs.a(th, "AMapLocationManager", "onServiceConnected");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.i = null;
            boolean unused = d.this.z = false;
        }
    };
    AMapLocationClientOption a = new AMapLocationClientOption();
    public c b;
    g c = null;
    ArrayList<AMapLocationListener> d = new ArrayList<>();
    boolean e = false;
    public boolean f = true;
    public boolean g = true;
    h h;
    Messenger i = null;
    Messenger j = null;
    Intent k = null;
    int l = 0;
    b m = null;
    boolean n = false;
    AMapLocationClientOption.AMapLocationMode o = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object p = new Object();
    cx q = null;
    boolean r = false;
    e s = null;
    String t = null;
    boolean u = false;
    boolean v = false;
    a w = null;
    String x = null;
    private Context y;
    /* access modifiers changed from: private */
    public boolean z = false;

    /* compiled from: AMapLocationManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                switch (message.what) {
                    case 1002:
                        try {
                            d.a(d.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th) {
                            cs.a(th, "AMapLocationManage$MHandlerr", "handleMessage SET_LISTENER");
                            return;
                        }
                    case 1003:
                        try {
                            d.this.e();
                            return;
                        } catch (Throwable th2) {
                            cs.a(th2, "AMapLocationManager$MHandler", "handleMessage START_LOCATION");
                            return;
                        }
                    case 1004:
                        try {
                            d.this.f();
                            return;
                        } catch (Throwable th3) {
                            cs.a(th3, "AMapLocationManager$MHandler", "handleMessage STOP_LOCATION");
                            return;
                        }
                    case 1005:
                        try {
                            d.b(d.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th4) {
                            cs.a(th4, "AMapLocationManager$MHandler", "handleMessage REMOVE_LISTENER");
                            return;
                        }
                    case 1006:
                    case 1007:
                        return;
                    case 1008:
                        try {
                            d.i(d.this);
                            return;
                        } catch (Throwable th5) {
                            cs.a(th5, "AMapLocationManager$ActionHandler", "handleMessage START_SOCKET");
                            return;
                        }
                    case 1009:
                        try {
                            d.j(d.this);
                            return;
                        } catch (Throwable th6) {
                            cs.a(th6, "AMapLocationManager$ActionHandler", "handleMessage STOP_SOCKET");
                            return;
                        }
                    case 1010:
                        return;
                    case 1011:
                        try {
                            d.this.a();
                            return;
                        } catch (Throwable th7) {
                            cs.a(th7, "AMapLocationManager$MHandler", "handleMessage DESTROY");
                            return;
                        }
                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW:
                        d.b(d.this, message);
                        return;
                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW:
                        try {
                            d.this.c.a(d.this.a);
                            return;
                        } catch (Throwable th8) {
                            cs.a(th8, "AMapLocationManager$ActionHandler", "handleMessage START_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW:
                        try {
                            if (d.this.c.b()) {
                                d.this.a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, 1000);
                                return;
                            } else {
                                d.g(d.this);
                                return;
                            }
                        } catch (Throwable th9) {
                            cs.a(th9, "AMapLocationManager$ActionHandler", "handleMessage START_LBS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW:
                        try {
                            d.this.c.a();
                            return;
                        } catch (Throwable th10) {
                            cs.a(th10, "AMapLocationManager$ActionHandler", "handleMessage STOP_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_ZOOM_IN:
                        d.this.a = (AMapLocationClientOption) message.obj;
                        if (d.this.a != null) {
                            d.h(d.this);
                            return;
                        }
                        return;
                    case PointerIconCompat.TYPE_ZOOM_OUT:
                    case PointerIconCompat.TYPE_GRAB:
                    case 1021:
                    case GLMapStaticValue.AM_PARAMETERNAME_PROCESS_3DOBJECT:
                        return;
                    default:
                        return;
                }
            } catch (Throwable th11) {
                cs.a(th11, "AMapLocationManager$ActionHandler", "handleMessage");
            }
            cs.a(th11, "AMapLocationManager$ActionHandler", "handleMessage");
        }
    }

    /* compiled from: AMapLocationManager */
    static class b extends HandlerThread {
        d a = null;

        public b(String str, d dVar) {
            super(str);
            this.a = dVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.a.h.a();
                this.a.h();
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AMapLocationManager */
    public class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (!d.this.n || cs.c()) {
                    int i = message.what;
                    if (i != 100) {
                        switch (i) {
                            case 1:
                                try {
                                    d.a(d.this, message.getData());
                                    return;
                                } catch (Throwable th) {
                                    cs.a(th, "AMapLocationManager$ActionHandler", "handleMessage RESULT_LBS_LOCATIONSUCCESS");
                                    return;
                                }
                            case 2:
                                try {
                                    d.a(d.this, message);
                                    return;
                                } catch (Throwable th2) {
                                    cs.a(th2, "AMapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONSUCCESS");
                                    return;
                                }
                            case 3:
                                return;
                            default:
                                switch (i) {
                                    case 5:
                                        try {
                                            d.this.a(10, message.getData());
                                            return;
                                        } catch (Throwable th3) {
                                            cs.a(th3, "AMapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONCHANGE");
                                            return;
                                        }
                                    case 6:
                                        try {
                                            Bundle data = message.getData();
                                            if (d.this.c != null) {
                                                d.this.c.a(data);
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th4) {
                                            cs.a(th4, "AMapLocationManager$ActionHandler", "handleMessage RESULT_GPS_GEO_SUCCESS");
                                            return;
                                        }
                                    case 7:
                                        boolean unused = d.this.B = message.getData().getBoolean("ngpsAble");
                                        return;
                                    case 8:
                                        cx.a((String) null, 2141);
                                        break;
                                    default:
                                        return;
                                }
                                d.a(d.this, message);
                                return;
                        }
                        cs.a(th, "AMapLocationManager$MHandler", "handleMessage");
                    }
                    try {
                        d.a(d.this);
                    } catch (Throwable th5) {
                        cs.a(th5, "AMapLocationManager$ActionHandler", "handleMessage RESULT_FASTSKY");
                    }
                }
            } catch (Throwable th6) {
                cs.a(th6, "AMapLocationManager$MHandler", "handleMessage");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|(2:2|3)|4|5|(1:7)(1:9)|8|(2:12|13)|18|(2:21|22)|25|(2:27|28)(1:29)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007e, code lost:
        com.loc.cs.a(r4, "AMapLocationManager", "init 1");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0069 A[Catch:{ Throwable -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0077 A[Catch:{ Throwable -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            r3.<init>()
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r3.a = r0
            r0 = 0
            r3.c = r0
            r1 = 0
            r3.z = r1
            r3.A = r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.d = r2
            r3.e = r1
            r2 = 1
            r3.f = r2
            r3.g = r2
            r3.i = r0
            r3.j = r0
            r3.k = r0
            r3.l = r1
            r3.B = r2
            r3.m = r0
            r3.n = r1
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
            r3.o = r2
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            r3.p = r2
            r3.q = r0
            r3.r = r1
            r3.s = r0
            r3.t = r0
            com.loc.d$1 r2 = new com.loc.d$1
            r2.<init>()
            r3.C = r2
            r3.u = r1
            r3.v = r1
            r3.w = r0
            r3.x = r0
            r3.y = r4
            r3.k = r5
            boolean r4 = com.loc.cs.c()
            if (r4 == 0) goto L_0x0063
            com.loc.s r4 = com.loc.cs.b()     // Catch:{ Throwable -> 0x0063 }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x0063 }
            com.loc.cy.a((android.content.Context) r5, (com.loc.s) r4)     // Catch:{ Throwable -> 0x0063 }
        L_0x0063:
            android.os.Looper r4 = android.os.Looper.myLooper()     // Catch:{ Throwable -> 0x007d }
            if (r4 != 0) goto L_0x0077
            com.loc.d$c r4 = new com.loc.d$c     // Catch:{ Throwable -> 0x007d }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x007d }
            android.os.Looper r5 = r5.getMainLooper()     // Catch:{ Throwable -> 0x007d }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x007d }
        L_0x0074:
            r3.b = r4     // Catch:{ Throwable -> 0x007d }
            goto L_0x0085
        L_0x0077:
            com.loc.d$c r4 = new com.loc.d$c     // Catch:{ Throwable -> 0x007d }
            r4.<init>()     // Catch:{ Throwable -> 0x007d }
            goto L_0x0074
        L_0x007d:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "init 1"
            com.loc.cs.a(r4, r5, r0)
        L_0x0085:
            com.loc.h r4 = new com.loc.h     // Catch:{ Throwable -> 0x008f }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x008f }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x008f }
            r3.h = r4     // Catch:{ Throwable -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "init 2"
            com.loc.cs.a(r4, r5, r0)     // Catch:{ Throwable -> 0x00b8 }
        L_0x0097:
            com.loc.d$b r4 = new com.loc.d$b     // Catch:{ Throwable -> 0x00b8 }
            java.lang.String r5 = "amapLocManagerThread"
            r4.<init>(r5, r3)     // Catch:{ Throwable -> 0x00b8 }
            r3.m = r4     // Catch:{ Throwable -> 0x00b8 }
            com.loc.d$b r4 = r3.m     // Catch:{ Throwable -> 0x00b8 }
            r5 = 5
            r4.setPriority(r5)     // Catch:{ Throwable -> 0x00b8 }
            com.loc.d$b r4 = r3.m     // Catch:{ Throwable -> 0x00b8 }
            r4.start()     // Catch:{ Throwable -> 0x00b8 }
            com.loc.d$b r4 = r3.m     // Catch:{ Throwable -> 0x00b8 }
            android.os.Looper r4 = r4.getLooper()     // Catch:{ Throwable -> 0x00b8 }
            com.loc.d$a r4 = r3.a((android.os.Looper) r4)     // Catch:{ Throwable -> 0x00b8 }
            r3.w = r4     // Catch:{ Throwable -> 0x00b8 }
            goto L_0x00c0
        L_0x00b8:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "init 5"
            com.loc.cs.a(r4, r5, r0)
        L_0x00c0:
            com.loc.g r4 = new com.loc.g     // Catch:{ Throwable -> 0x00cc }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x00cc }
            com.loc.d$c r0 = r3.b     // Catch:{ Throwable -> 0x00cc }
            r4.<init>(r5, r0)     // Catch:{ Throwable -> 0x00cc }
            r3.c = r4     // Catch:{ Throwable -> 0x00cc }
            goto L_0x00d4
        L_0x00cc:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "init 3"
            com.loc.cs.a(r4, r5, r0)
        L_0x00d4:
            com.loc.cx r4 = r3.q
            if (r4 != 0) goto L_0x00df
            com.loc.cx r4 = new com.loc.cx
            r4.<init>()
            r3.q = r4
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.<init>(android.content.Context, android.content.Intent):void");
    }

    private AMapLocationServer a(bu buVar) {
        if (!this.a.isLocationCacheEnable()) {
            return null;
        }
        try {
            return buVar.j();
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "doFirstCacheLoc");
            return null;
        }
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.p) {
            this.w = new a(looper);
            aVar = this.w;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                if ((th instanceof RemoteException) || ((th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread"))) {
                    this.i = null;
                    this.z = false;
                }
                cs.a(th, "AMapLocationManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = cs.c(this.y);
        }
        bundle.putString("c", this.t);
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.setData(bundle);
        obtain.replyTo = this.j;
        if (this.i != null) {
            this.i.send(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object obj, long j2) {
        synchronized (this.p) {
            if (this.w != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.w.sendMessageDelayed(obtain, j2);
            }
        }
    }

    private void a(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (GeocodeSearch.GPS.equals(aMapLocation.getProvider()) || !this.c.b()) {
                aMapLocation.setAltitude(da.b(aMapLocation.getAltitude()));
                aMapLocation.setBearing(da.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(da.a(aMapLocation.getSpeed()));
                Iterator<AMapLocationListener> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.amap.api.location.AMapLocation r4, java.lang.Throwable r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.loc.cs.c()     // Catch:{ Throwable -> 0x00c4 }
            if (r0 == 0) goto L_0x0023
            if (r4 != 0) goto L_0x0023
            if (r5 == 0) goto L_0x0018
            android.content.Context r4 = r3.y     // Catch:{ Throwable -> 0x00c4 }
            java.lang.String r0 = "loc"
            java.lang.String r5 = r5.getMessage()     // Catch:{ Throwable -> 0x00c4 }
            com.loc.cy.a(r4, r0, r5)     // Catch:{ Throwable -> 0x00c4 }
            monitor-exit(r3)
            return
        L_0x0018:
            android.content.Context r4 = r3.y     // Catch:{ Throwable -> 0x00c4 }
            java.lang.String r5 = "loc"
            java.lang.String r0 = "amaplocation is null"
            com.loc.cy.a(r4, r5, r0)     // Catch:{ Throwable -> 0x00c4 }
            monitor-exit(r3)
            return
        L_0x0023:
            if (r4 != 0) goto L_0x0036
            com.amap.api.location.AMapLocation r4 = new com.amap.api.location.AMapLocation     // Catch:{ Throwable -> 0x00c4 }
            java.lang.String r5 = ""
            r4.<init>((java.lang.String) r5)     // Catch:{ Throwable -> 0x00c4 }
            r5 = 8
            r4.setErrorCode(r5)     // Catch:{ Throwable -> 0x00c4 }
            java.lang.String r5 = "amapLocation is null#0801"
            r4.setLocationDetail(r5)     // Catch:{ Throwable -> 0x00c4 }
        L_0x0036:
            java.lang.String r5 = "gps"
            java.lang.String r0 = r4.getProvider()     // Catch:{ Throwable -> 0x00c4 }
            boolean r5 = r5.equals(r0)     // Catch:{ Throwable -> 0x00c4 }
            if (r5 != 0) goto L_0x0047
            java.lang.String r5 = "lbs"
            r4.setProvider(r5)     // Catch:{ Throwable -> 0x00c4 }
        L_0x0047:
            com.amap.api.location.AMapLocationQualityReport r5 = new com.amap.api.location.AMapLocationQualityReport     // Catch:{ Throwable -> 0x00c4 }
            r5.<init>()     // Catch:{ Throwable -> 0x00c4 }
            com.loc.g r0 = r3.c     // Catch:{ Throwable -> 0x00c4 }
            if (r0 == 0) goto L_0x0062
            com.loc.g r0 = r3.c     // Catch:{ Throwable -> 0x00c4 }
            int r0 = r0.e()     // Catch:{ Throwable -> 0x00c4 }
            r5.setGPSSatellites(r0)     // Catch:{ Throwable -> 0x00c4 }
            com.loc.g r0 = r3.c     // Catch:{ Throwable -> 0x00c4 }
            int r0 = r0.d()     // Catch:{ Throwable -> 0x00c4 }
            r5.setGpsStatus(r0)     // Catch:{ Throwable -> 0x00c4 }
        L_0x0062:
            android.content.Context r0 = r3.y     // Catch:{ Throwable -> 0x00c4 }
            boolean r0 = com.loc.da.g(r0)     // Catch:{ Throwable -> 0x00c4 }
            r5.setWifiAble(r0)     // Catch:{ Throwable -> 0x00c4 }
            r4.setLocationQualityReport(r5)     // Catch:{ Throwable -> 0x00c4 }
            boolean r5 = r3.A     // Catch:{ Throwable -> 0x009c }
            if (r5 == 0) goto L_0x00a4
            java.lang.String r5 = r3.x     // Catch:{ Throwable -> 0x009c }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Throwable -> 0x009c }
            r0.<init>()     // Catch:{ Throwable -> 0x009c }
            java.lang.String r1 = "loc"
            r0.putParcelable(r1, r4)     // Catch:{ Throwable -> 0x009c }
            java.lang.String r1 = "lastLocNb"
            r0.putString(r1, r5)     // Catch:{ Throwable -> 0x009c }
            r5 = 1014(0x3f6, float:1.421E-42)
            r1 = 0
            r3.a(r5, r0, r1)     // Catch:{ Throwable -> 0x009c }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x009c }
            com.loc.cx.a((android.content.Context) r5, (com.amap.api.location.AMapLocation) r4)     // Catch:{ Throwable -> 0x009c }
            android.content.Context r5 = r3.y     // Catch:{ Throwable -> 0x009c }
            com.loc.cx.b(r5, r4)     // Catch:{ Throwable -> 0x009c }
            com.amap.api.location.AMapLocation r4 = r4.clone()     // Catch:{ Throwable -> 0x009c }
            r3.a((com.amap.api.location.AMapLocation) r4)     // Catch:{ Throwable -> 0x009c }
            goto L_0x00a4
        L_0x009c:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "handlerLocation part2"
            com.loc.cs.a(r4, r5, r0)     // Catch:{ Throwable -> 0x00c4 }
        L_0x00a4:
            boolean r4 = r3.n     // Catch:{ Throwable -> 0x00c4 }
            if (r4 == 0) goto L_0x00b0
            boolean r4 = com.loc.cs.c()     // Catch:{ Throwable -> 0x00c4 }
            if (r4 != 0) goto L_0x00b0
            monitor-exit(r3)
            return
        L_0x00b0:
            android.content.Context r4 = r3.y     // Catch:{ Throwable -> 0x00c4 }
            com.loc.cy.b(r4)     // Catch:{ Throwable -> 0x00c4 }
            com.amap.api.location.AMapLocationClientOption r4 = r3.a     // Catch:{ Throwable -> 0x00c4 }
            boolean r4 = r4.isOnceLocation()     // Catch:{ Throwable -> 0x00c4 }
            if (r4 == 0) goto L_0x00c0
            r3.f()     // Catch:{ Throwable -> 0x00c4 }
        L_0x00c0:
            monitor-exit(r3)
            return
        L_0x00c2:
            r4 = move-exception
            goto L_0x00ce
        L_0x00c4:
            r4 = move-exception
            java.lang.String r5 = "AMapLocationManager"
            java.lang.String r0 = "handlerLocation part3"
            com.loc.cs.a(r4, r5, r0)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r3)
            return
        L_0x00ce:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.a(com.amap.api.location.AMapLocation, java.lang.Throwable):void");
    }

    private static void a(bu buVar, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            try {
                if (aMapLocationServer.getErrorCode() == 0) {
                    buVar.a(aMapLocationServer);
                }
            } catch (Throwable th) {
                cs.a(th, "AMapLocationManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    static /* synthetic */ void a(d dVar) {
        boolean z2;
        try {
            boolean z3 = true;
            if (dVar.y.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                z2 = true;
            } else if (dVar.y instanceof Activity) {
                z2 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (z3) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dVar.y);
                builder.setMessage(cr.f());
                if (!"".equals(cr.g()) && cr.g() != null) {
                    builder.setPositiveButton(cr.g(), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            d.this.d();
                            dialogInterface.cancel();
                        }
                    });
                }
                builder.setNegativeButton(cr.h(), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog create = builder.create();
                if (z2) {
                    create.getWindow().setType(AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST);
                }
                create.setCanceledOnTouchOutside(false);
                create.show();
                return;
            }
            dVar.d();
        } catch (Throwable th) {
            dVar.d();
            cs.a(th, "AMapLocationManager", "showDialog");
        }
    }

    static /* synthetic */ void a(d dVar, Bundle bundle) {
        AMapLocation aMapLocation;
        AMapLocation aMapLocation2;
        Throwable th = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation2 = (AMapLocation) bundle.getParcelable("loc");
                dVar.x = bundle.getString("nb", (String) null);
                if (!(aMapLocation2 == null || aMapLocation2.getErrorCode() != 0 || dVar.c == null)) {
                    dVar.c.c();
                    if (!TextUtils.isEmpty(aMapLocation2.getAdCode())) {
                        dVar.c.s = aMapLocation2;
                    }
                }
            } catch (Throwable th2) {
                cs.a(th2, "AMapLocationManager", "doLbsLocationSuccess");
                th = th2;
                aMapLocation = null;
            }
        } else {
            aMapLocation2 = null;
        }
        aMapLocation = dVar.c != null ? dVar.c.b(aMapLocation2) : aMapLocation2;
        dVar.a(aMapLocation, th);
    }

    static /* synthetic */ void a(d dVar, Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (dVar.g && dVar.i != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", cs.b(dVar.a));
                dVar.a(0, bundle);
                dVar.g = false;
            }
            dVar.a(aMapLocation, (Throwable) null);
            if (dVar.B) {
                dVar.a(7, (Bundle) null);
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "doGpsLocationSuccess");
        }
    }

    static /* synthetic */ void a(d dVar, AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (dVar.d == null) {
            dVar.d = new ArrayList<>();
        }
        if (!dVar.d.contains(aMapLocationListener)) {
            dVar.d.add(aMapLocationListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
        if (r11 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r11.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00f9, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0108, code lost:
        if (r11 != null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x010b, code lost:
        return r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[Catch:{ Throwable -> 0x00a3, Throwable -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b3 A[Catch:{ Throwable -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.autonavi.aps.amapapi.model.AMapLocationServer b(com.loc.bu r11) {
        /*
            r10 = this;
            r0 = 0
            com.loc.cw r1 = new com.loc.cw     // Catch:{ Throwable -> 0x00fe }
            r1.<init>()     // Catch:{ Throwable -> 0x00fe }
            r2 = 0
            long r3 = com.loc.da.b()     // Catch:{ Throwable -> 0x00fe }
            r1.a((long) r3)     // Catch:{ Throwable -> 0x00fe }
            java.lang.String r3 = com.amap.api.location.AMapLocationClientOption.getAPIKEY()     // Catch:{ Throwable -> 0x001c }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x001c }
            if (r4 != 0) goto L_0x0024
            com.loc.l.a(r3)     // Catch:{ Throwable -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r3 = move-exception
            java.lang.String r4 = "AMapLocationManager"
            java.lang.String r5 = "apsLocation setAuthKey"
            com.loc.cs.a(r3, r4, r5)     // Catch:{ Throwable -> 0x00fe }
        L_0x0024:
            java.lang.String r3 = com.amap.api.location.UmidtokenInfo.getUmidtoken()     // Catch:{ Throwable -> 0x0032 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0032 }
            if (r4 != 0) goto L_0x003a
            com.loc.n.a((java.lang.String) r3)     // Catch:{ Throwable -> 0x0032 }
            goto L_0x003a
        L_0x0032:
            r3 = move-exception
            java.lang.String r4 = "AMapLocationManager"
            java.lang.String r5 = "apsLocation setUmidToken"
            com.loc.cs.a(r3, r4, r5)     // Catch:{ Throwable -> 0x00fe }
        L_0x003a:
            android.content.Context r3 = r10.y     // Catch:{ Throwable -> 0x004a }
            r11.a((android.content.Context) r3)     // Catch:{ Throwable -> 0x004a }
            com.amap.api.location.AMapLocationClientOption r3 = r10.a     // Catch:{ Throwable -> 0x004a }
            r11.a((com.amap.api.location.AMapLocationClientOption) r3)     // Catch:{ Throwable -> 0x004a }
            android.content.Context r3 = r10.y     // Catch:{ Throwable -> 0x004a }
            r11.i()     // Catch:{ Throwable -> 0x004a }
            goto L_0x0052
        L_0x004a:
            r3 = move-exception
            java.lang.String r4 = "AMapLocationManager"
            java.lang.String r5 = "initApsBase"
            com.loc.cs.a(r3, r4, r5)     // Catch:{ Throwable -> 0x00fe }
        L_0x0052:
            boolean r3 = com.loc.cr.D()     // Catch:{ Throwable -> 0x00fe }
            com.autonavi.aps.amapapi.model.AMapLocationServer r4 = r10.a((com.loc.bu) r11)     // Catch:{ Throwable -> 0x00fe }
            r5 = 1
            if (r4 != 0) goto L_0x007a
            r2 = r3 ^ 1
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r11.a((boolean) r2)     // Catch:{ Throwable -> 0x0071 }
            if (r3 != 0) goto L_0x006e
            a((com.loc.bu) r11, (com.autonavi.aps.amapapi.model.AMapLocationServer) r2)     // Catch:{ Throwable -> 0x0069 }
            goto L_0x006e
        L_0x0069:
            r4 = move-exception
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x0072
        L_0x006e:
            r4 = r2
        L_0x006f:
            r2 = r5
            goto L_0x007a
        L_0x0071:
            r2 = move-exception
        L_0x0072:
            java.lang.String r6 = "AMapLocationManager"
            java.lang.String r7 = "apsLocation:doFirstNetLocate"
            com.loc.cs.a(r2, r6, r7)     // Catch:{ Throwable -> 0x00fa }
            goto L_0x006f
        L_0x007a:
            long r6 = com.loc.da.b()     // Catch:{ Throwable -> 0x00fa }
            r1.b(r6)     // Catch:{ Throwable -> 0x00fa }
            r1.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r4)     // Catch:{ Throwable -> 0x00fa }
            if (r4 == 0) goto L_0x008a
            java.lang.String r0 = r4.k()     // Catch:{ Throwable -> 0x00fa }
        L_0x008a:
            com.amap.api.location.AMapLocationClientOption r6 = r10.a     // Catch:{ Throwable -> 0x00a3 }
            boolean r6 = r6.isLocationCacheEnable()     // Catch:{ Throwable -> 0x00a3 }
            if (r6 == 0) goto L_0x00ab
            com.loc.h r6 = r10.h     // Catch:{ Throwable -> 0x00a3 }
            if (r6 == 0) goto L_0x00ab
            com.loc.h r6 = r10.h     // Catch:{ Throwable -> 0x00a3 }
            com.amap.api.location.AMapLocationClientOption r7 = r10.a     // Catch:{ Throwable -> 0x00a3 }
            long r7 = r7.getLastLocationLifeCycle()     // Catch:{ Throwable -> 0x00a3 }
            com.amap.api.location.AMapLocation r0 = r6.a(r4, r0, r7)     // Catch:{ Throwable -> 0x00a3 }
            goto L_0x00ac
        L_0x00a3:
            r0 = move-exception
            java.lang.String r6 = "AMapLocationManager"
            java.lang.String r7 = "fixLastLocation"
            com.loc.cs.a(r0, r6, r7)     // Catch:{ Throwable -> 0x00fa }
        L_0x00ab:
            r0 = r4
        L_0x00ac:
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ Throwable -> 0x00d0 }
            r6.<init>()     // Catch:{ Throwable -> 0x00d0 }
            if (r4 == 0) goto L_0x00c1
            java.lang.String r7 = "loc"
            r6.putParcelable(r7, r0)     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r0 = "nb"
            java.lang.String r7 = r4.k()     // Catch:{ Throwable -> 0x00d0 }
            r6.putString(r0, r7)     // Catch:{ Throwable -> 0x00d0 }
        L_0x00c1:
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Throwable -> 0x00d0 }
            r0.setData(r6)     // Catch:{ Throwable -> 0x00d0 }
            r0.what = r5     // Catch:{ Throwable -> 0x00d0 }
            com.loc.d$c r6 = r10.b     // Catch:{ Throwable -> 0x00d0 }
            r6.sendMessage(r0)     // Catch:{ Throwable -> 0x00d0 }
            goto L_0x00d8
        L_0x00d0:
            r0 = move-exception
            java.lang.String r6 = "AMapLocationManager"
            java.lang.String r7 = "apsLocation:callback"
            com.loc.cs.a(r0, r6, r7)     // Catch:{ Throwable -> 0x00fa }
        L_0x00d8:
            android.content.Context r0 = r10.y     // Catch:{ Throwable -> 0x00fa }
            com.loc.cx.a((android.content.Context) r0, (com.loc.cw) r1)     // Catch:{ Throwable -> 0x00fa }
            if (r2 == 0) goto L_0x00f4
            if (r3 == 0) goto L_0x00f4
            r11.c()     // Catch:{ Throwable -> 0x00ec }
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r11.a((boolean) r5)     // Catch:{ Throwable -> 0x00ec }
            a((com.loc.bu) r11, (com.autonavi.aps.amapapi.model.AMapLocationServer) r0)     // Catch:{ Throwable -> 0x00ec }
            goto L_0x00f4
        L_0x00ec:
            r0 = move-exception
            java.lang.String r1 = "AMapLocationManager"
            java.lang.String r2 = "apsLocation:doFirstNetLocate 2"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x00fa }
        L_0x00f4:
            if (r11 == 0) goto L_0x010b
        L_0x00f6:
            r11.f()     // Catch:{ Throwable -> 0x010b }
            return r4
        L_0x00fa:
            r0 = move-exception
            goto L_0x0101
        L_0x00fc:
            r0 = move-exception
            goto L_0x010c
        L_0x00fe:
            r1 = move-exception
            r4 = r0
            r0 = r1
        L_0x0101:
            java.lang.String r1 = "AMapLocationManager"
            java.lang.String r2 = "apsLocation"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ all -> 0x00fc }
            if (r11 == 0) goto L_0x010b
            goto L_0x00f6
        L_0x010b:
            return r4
        L_0x010c:
            if (r11 == 0) goto L_0x0111
            r11.f()     // Catch:{ Throwable -> 0x0111 }
        L_0x0111:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.b(com.loc.bu):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    private void b() {
        synchronized (this.p) {
            if (this.w != null) {
                this.w.removeMessages(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035 A[Catch:{ Throwable -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.loc.d r3, android.os.Message r4) {
        /*
            android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x003b }
            java.lang.String r0 = "loc"
            android.os.Parcelable r0 = r4.getParcelable(r0)     // Catch:{ Throwable -> 0x003b }
            com.amap.api.location.AMapLocation r0 = (com.amap.api.location.AMapLocation) r0     // Catch:{ Throwable -> 0x003b }
            java.lang.String r1 = "lastLocNb"
            java.lang.String r4 = r4.getString(r1)     // Catch:{ Throwable -> 0x003b }
            if (r0 == 0) goto L_0x002d
            r1 = 0
            com.loc.cj r2 = com.loc.h.b     // Catch:{ Throwable -> 0x002d }
            if (r2 != 0) goto L_0x0024
            com.loc.h r2 = r3.h     // Catch:{ Throwable -> 0x002d }
            if (r2 == 0) goto L_0x002a
            com.loc.h r1 = r3.h     // Catch:{ Throwable -> 0x002d }
            com.amap.api.location.AMapLocation r1 = r1.b()     // Catch:{ Throwable -> 0x002d }
            goto L_0x002a
        L_0x0024:
            com.loc.cj r1 = com.loc.h.b     // Catch:{ Throwable -> 0x002d }
            com.amap.api.location.AMapLocation r1 = r1.a()     // Catch:{ Throwable -> 0x002d }
        L_0x002a:
            com.loc.cx.a((com.amap.api.location.AMapLocation) r1, (com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x002d }
        L_0x002d:
            com.loc.h r1 = r3.h     // Catch:{ Throwable -> 0x003b }
            boolean r4 = r1.a(r0, r4)     // Catch:{ Throwable -> 0x003b }
            if (r4 == 0) goto L_0x003a
            com.loc.h r3 = r3.h     // Catch:{ Throwable -> 0x003b }
            r3.d()     // Catch:{ Throwable -> 0x003b }
        L_0x003a:
            return
        L_0x003b:
            r3 = move-exception
            java.lang.String r4 = "AMapLocationManager"
            java.lang.String r0 = "doSaveLastLocation"
            com.loc.cs.a(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.b(com.loc.d, android.os.Message):void");
    }

    static /* synthetic */ void b(d dVar, AMapLocationListener aMapLocationListener) {
        if (!dVar.d.isEmpty() && dVar.d.contains(aMapLocationListener)) {
            dVar.d.remove(aMapLocationListener);
        }
        if (dVar.d.isEmpty()) {
            dVar.f();
        }
    }

    private boolean c() {
        boolean z2 = false;
        int i2 = 0;
        do {
            try {
                if (this.i != null) {
                    break;
                }
                Thread.sleep(100);
                i2++;
            } catch (Throwable th) {
                cs.a(th, "AMapLocationManager", "checkAPSManager");
            }
        } while (i2 < 50);
        if (this.i == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.b.sendMessage(obtain);
        } else {
            z2 = true;
        }
        if (!z2) {
            cx.a((String) null, (int) AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", cr.k()));
            intent.setFlags(268435456);
            intent.setData(Uri.parse(cr.i()));
            this.y.startActivity(intent);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "callAMap part2");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.amap.api.location.AMapLocationClientOption r0 = r6.a     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x000c
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption     // Catch:{ all -> 0x005b }
            r0.<init>()     // Catch:{ all -> 0x005b }
            r6.a = r0     // Catch:{ all -> 0x005b }
        L_0x000c:
            boolean r0 = r6.A     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r6)
            return
        L_0x0012:
            r0 = 1
            r6.A = r0     // Catch:{ all -> 0x005b }
            int[] r0 = com.loc.d.AnonymousClass4.a     // Catch:{ all -> 0x005b }
            com.amap.api.location.AMapLocationClientOption r1 = r6.a     // Catch:{ all -> 0x005b }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = r1.getLocationMode()     // Catch:{ all -> 0x005b }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x005b }
            r0 = r0[r1]     // Catch:{ all -> 0x005b }
            r1 = 1016(0x3f8, float:1.424E-42)
            r2 = 1015(0x3f7, float:1.422E-42)
            r3 = 0
            r4 = 0
            switch(r0) {
                case 1: goto L_0x004f;
                case 2: goto L_0x0047;
                case 3: goto L_0x002e;
                default: goto L_0x002d;
            }     // Catch:{ all -> 0x005b }
        L_0x002d:
            goto L_0x0059
        L_0x002e:
            r6.a(r2, r3, r4)     // Catch:{ all -> 0x005b }
            com.amap.api.location.AMapLocationClientOption r0 = r6.a     // Catch:{ all -> 0x005b }
            boolean r0 = r0.isGpsFirst()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0043
            com.amap.api.location.AMapLocationClientOption r0 = r6.a     // Catch:{ all -> 0x005b }
            boolean r0 = r0.isOnceLocation()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0043
            r4 = 30000(0x7530, double:1.4822E-319)
        L_0x0043:
            r6.a(r1, r3, r4)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0047:
            r6.b()     // Catch:{ all -> 0x005b }
            r6.a(r2, r3, r4)     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return
        L_0x004f:
            r0 = 1017(0x3f9, float:1.425E-42)
            r6.a(r0, r3, r4)     // Catch:{ all -> 0x005b }
            r6.a(r1, r3, r4)     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return
        L_0x0059:
            monitor-exit(r6)
            return
        L_0x005b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.e():void");
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            if (this.c != null) {
                this.c.a();
            }
            b();
            this.A = false;
            this.l = 0;
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "stopLocation");
        }
    }

    private void g() {
        if (this.a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j2 = 1000;
            if (this.a.getInterval() >= 1000) {
                j2 = this.a.getInterval();
            }
            a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, j2);
        }
    }

    static /* synthetic */ void g(d dVar) {
        try {
            if (dVar.f) {
                dVar.f = false;
                AMapLocationServer b2 = dVar.b(new bu());
                if (dVar.c()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (b2 != null && (b2.getLocationType() == 2 || b2.getLocationType() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", cs.b(dVar.a));
                    bundle.putString("isCacheLoc", str);
                    dVar.a(0, bundle);
                }
            } else {
                if (dVar.r && !dVar.isStarted() && !dVar.v) {
                    dVar.v = true;
                    dVar.h();
                }
                if (dVar.c()) {
                    dVar.v = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", cs.b(dVar.a));
                    bundle2.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!dVar.c.b()) {
                        dVar.a(1, bundle2);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                cs.a(th, "AMapLocationManager", "doLBSLocation");
                try {
                    if (!dVar.a.isOnceLocation()) {
                        dVar.g();
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        try {
            if (!dVar.a.isOnceLocation()) {
                dVar.g();
                return;
            }
            return;
        } catch (Throwable unused3) {
            return;
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            if (this.j == null) {
                this.j = new Messenger(this.b);
            }
            this.y.bindService(i(), this.C, 1);
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void h(d dVar) {
        cx cxVar;
        Context context;
        int i2;
        dVar.c.b(dVar.a);
        if (dVar.A && !dVar.a.getLocationMode().equals(dVar.o)) {
            dVar.f();
            dVar.e();
        }
        dVar.o = dVar.a.getLocationMode();
        if (dVar.q != null) {
            if (dVar.a.isOnceLocation()) {
                cxVar = dVar.q;
                context = dVar.y;
                i2 = 0;
            } else {
                cxVar = dVar.q;
                context = dVar.y;
                i2 = 1;
            }
            cxVar.a(context, i2);
            dVar.q.a(dVar.y, dVar.a);
        }
    }

    private Intent i() {
        String str;
        if (this.k == null) {
            this.k = new Intent(this.y, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : k.f(this.y);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "startServiceImpl p2");
            str = "";
        }
        this.k.putExtra("a", str);
        this.k.putExtra("b", k.c(this.y));
        this.k.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.k;
    }

    static /* synthetic */ void i(d dVar) {
        try {
            if (dVar.i != null) {
                dVar.l = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", cs.b(dVar.a));
                dVar.a(2, bundle);
                return;
            }
            dVar.l++;
            if (dVar.l < 10) {
                dVar.a(1008, (Object) null, 50);
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "startAssistantLocationImpl");
        }
    }

    static /* synthetic */ void j(d dVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", cs.b(dVar.a));
            dVar.a(3, bundle);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "stopAssistantLocationImpl");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a(12, (Bundle) null);
        this.f = true;
        this.g = true;
        this.z = false;
        this.r = false;
        f();
        if (this.q != null) {
            this.q.b(this.y);
        }
        cx.a(this.y);
        if (this.s != null) {
            this.s.b().sendEmptyMessage(11);
        } else if (this.C != null) {
            this.y.unbindService(this.C);
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        this.C = null;
        synchronized (this.p) {
            if (this.w != null) {
                this.w.removeCallbacksAndMessages((Object) null);
            }
            this.w = null;
        }
        if (this.m != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    cv.a((Object) this.m, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                }
            }
            this.m.quit();
        }
        this.m = null;
        if (this.b != null) {
            this.b.removeCallbacksAndMessages((Object) null);
        }
        if (this.h != null) {
            this.h.c();
            this.h = null;
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.h != null) {
                return this.h.b();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "getLastKnownLocation");
        }
        return null;
    }

    public boolean isStarted() {
        return this.z;
    }

    public void onDestroy() {
        try {
            a(1011, (Object) null, 0);
            this.n = true;
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "onDestroy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "setLocationListener");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            a(PointerIconCompat.TYPE_ZOOM_IN, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "setLocationOption");
        }
    }

    public void startAssistantLocation() {
        try {
            a(1008, (Object) null, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "startAssistantLocation");
        }
    }

    public void startLocation() {
        try {
            a(1003, (Object) null, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            a(1009, (Object) null, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            a(1004, (Object) null, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0);
        } catch (Throwable th) {
            cs.a(th, "AMapLocationManager", "unRegisterLocationListener");
        }
    }
}
