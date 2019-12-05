package com.loc;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.fence.GeoFenceManagerBase;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.iflytek.cloud.SpeechEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: GeoFenceManager */
public class a implements GeoFenceManagerBase {
    cx a = null;
    Context b = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    volatile int f = 1;
    ArrayList<GeoFence> g = new ArrayList<>();
    c h = null;
    Object i = new Object();
    Object j = new Object();
    C0009a k = null;
    b l = null;
    volatile boolean m = false;
    volatile boolean n = false;
    volatile boolean o = false;
    b p = null;
    c q = null;
    AMapLocationClient r = null;
    volatile AMapLocation s = null;
    long t = 0;
    AMapLocationClientOption u = null;
    int v = 0;
    AMapLocationListener w = new AMapLocationListener() {
        /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A[Catch:{ Throwable -> 0x00a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A[Catch:{ Throwable -> 0x00a1 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLocationChanged(com.amap.api.location.AMapLocation r14) {
            /*
                r13 = this;
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                boolean r0 = r0.x     // Catch:{ Throwable -> 0x00a1 }
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                boolean r0 = r0.o     // Catch:{ Throwable -> 0x00a1 }
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r0.s = r14     // Catch:{ Throwable -> 0x00a1 }
                r0 = 0
                r2 = 0
                r3 = 8
                r4 = 1
                r5 = 0
                if (r14 == 0) goto L_0x005b
                int r6 = r14.getErrorCode()     // Catch:{ Throwable -> 0x00a1 }
                int r7 = r14.getErrorCode()     // Catch:{ Throwable -> 0x00a1 }
                if (r7 != 0) goto L_0x0035
                com.loc.a r14 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                long r7 = com.loc.da.b()     // Catch:{ Throwable -> 0x00a1 }
                r14.t = r7     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r14 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r7 = 5
                r14.a(r7, r2, r0)     // Catch:{ Throwable -> 0x00a1 }
                r14 = r4
                goto L_0x005d
            L_0x0035:
                com.loc.a r7 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r7 = "定位失败"
                int r8 = r14.getErrorCode()     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r9 = r14.getErrorInfo()     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String[] r10 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x00a1 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r12 = "locationDetail:"
                r11.<init>(r12)     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r14 = r14.getLocationDetail()     // Catch:{ Throwable -> 0x00a1 }
                r11.append(r14)     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r14 = r11.toString()     // Catch:{ Throwable -> 0x00a1 }
                r10[r5] = r14     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a.a(r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00a1 }
                goto L_0x005c
            L_0x005b:
                r6 = r3
            L_0x005c:
                r14 = r5
            L_0x005d:
                if (r14 == 0) goto L_0x006a
                com.loc.a r14 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r14.v = r5     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r14 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r3 = 6
                r14.a(r3, r2, r0)     // Catch:{ Throwable -> 0x00a1 }
                return
            L_0x006a:
                android.os.Bundle r14 = new android.os.Bundle     // Catch:{ Throwable -> 0x00a1 }
                r14.<init>()     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                boolean r0 = r0.m     // Catch:{ Throwable -> 0x00a1 }
                if (r0 != 0) goto L_0x0087
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r1 = 7
                r0.a((int) r1)     // Catch:{ Throwable -> 0x00a1 }
                java.lang.String r0 = "interval"
                r1 = 2000(0x7d0, double:9.88E-321)
                r14.putLong(r0, r1)     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r0.a(r3, r14, r1)     // Catch:{ Throwable -> 0x00a1 }
            L_0x0087:
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                int r1 = r0.v     // Catch:{ Throwable -> 0x00a1 }
                int r1 = r1 + r4
                r0.v = r1     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                int r0 = r0.v     // Catch:{ Throwable -> 0x00a1 }
                r1 = 3
                if (r0 < r1) goto L_0x00a1
                java.lang.String r0 = "location_errorcode"
                r14.putInt(r0, r6)     // Catch:{ Throwable -> 0x00a1 }
                com.loc.a r0 = com.loc.a.this     // Catch:{ Throwable -> 0x00a1 }
                r1 = 1002(0x3ea, float:1.404E-42)
                r0.a((int) r1, (android.os.Bundle) r14)     // Catch:{ Throwable -> 0x00a1 }
            L_0x00a1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.a.AnonymousClass1.onLocationChanged(com.amap.api.location.AMapLocation):void");
        }
    };
    volatile boolean x = false;

    /* renamed from: com.loc.a$a  reason: collision with other inner class name */
    /* compiled from: GeoFenceManager */
    class C0009a extends Handler {
        public C0009a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.b(message.getData());
                        return;
                    case 1:
                        a.this.c(message.getData());
                        return;
                    case 2:
                        a.this.e(message.getData());
                        return;
                    case 3:
                        a.this.d(message.getData());
                        return;
                    case 4:
                        a.this.f(message.getData());
                        return;
                    case 5:
                        a.this.c();
                        return;
                    case 6:
                        a.this.a(a.this.s);
                        return;
                    case 7:
                        a.this.b();
                        return;
                    case 8:
                        a.this.j(message.getData());
                        return;
                    case 9:
                        a.this.a(message.getData());
                        return;
                    case 10:
                        a.this.a();
                        return;
                    case 11:
                        a.this.h(message.getData());
                        return;
                    case 12:
                        a.this.g(message.getData());
                        return;
                    case 13:
                        a.this.d();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager */
    static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }
    }

    /* compiled from: GeoFenceManager */
    class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.i(data);
                        return;
                    case 1001:
                        try {
                            a.this.a((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        a.this.b(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        try {
            this.b = context.getApplicationContext();
            e();
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManger", "<init>");
        }
    }

    static float a(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint a2 : list) {
                f2 = Math.min(f2, da.a(dPoint, a2));
            }
        }
        return f2;
    }

    private int a(List<GeoFence> list) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            for (GeoFence b2 : list) {
                b(b2);
            }
            return 0;
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static Bundle a(GeoFence geoFence, String str, String str2, int i2, int i3) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i2);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i3);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.fence.GeoFence a(android.os.Bundle r6, boolean r7) {
        /*
            r5 = this;
            com.amap.api.fence.GeoFence r0 = new com.amap.api.fence.GeoFence
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.amap.api.location.DPoint r2 = new com.amap.api.location.DPoint
            r2.<init>()
            if (r7 == 0) goto L_0x0030
            r7 = 1
            r0.setType(r7)
            java.lang.String r7 = "points"
            java.util.ArrayList r1 = r6.getParcelableArrayList(r7)
            if (r1 == 0) goto L_0x0021
            com.amap.api.location.DPoint r2 = b((java.util.List<com.amap.api.location.DPoint>) r1)
        L_0x0021:
            float r7 = b((com.amap.api.location.DPoint) r2, (java.util.List<com.amap.api.location.DPoint>) r1)
            r0.setMaxDis2Center(r7)
            float r7 = a((com.amap.api.location.DPoint) r2, (java.util.List<com.amap.api.location.DPoint>) r1)
            r0.setMinDis2Center(r7)
            goto L_0x0059
        L_0x0030:
            r7 = 0
            r0.setType(r7)
            java.lang.String r7 = "point"
            android.os.Parcelable r7 = r6.getParcelable(r7)
            r2 = r7
            com.amap.api.location.DPoint r2 = (com.amap.api.location.DPoint) r2
            if (r2 == 0) goto L_0x0042
            r1.add(r2)
        L_0x0042:
            java.lang.String r7 = "radius"
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r7 = r6.getFloat(r7, r3)
            r4 = 0
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0050
            r7 = r3
        L_0x0050:
            r0.setRadius(r7)
            r0.setMinDis2Center(r7)
            r0.setMaxDis2Center(r7)
        L_0x0059:
            int r7 = r5.f
            r0.setActivatesAction(r7)
            java.lang.String r7 = "customId"
            java.lang.String r6 = r6.getString(r7)
            r0.setCustomId(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r1)
            r0.setPointList(r6)
            r0.setCenter(r2)
            java.lang.String r6 = r5.d
            r0.setPendingIntentAction(r6)
            r6 = -1
            r0.setExpiration(r6)
            android.app.PendingIntent r6 = r5.c
            r0.setPendingIntent(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r1 = com.loc.c.a()
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r0.setFenceId(r6)
            com.loc.cx r6 = r5.a
            if (r6 == 0) goto L_0x00a3
            com.loc.cx r6 = r5.a
            android.content.Context r7 = r5.b
            r1 = 2
            r6.a((android.content.Context) r7, (int) r1)
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.a(android.os.Bundle, boolean):com.amap.api.fence.GeoFence");
    }

    static void a(String str, int i2, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:" + i2);
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:" + str2);
        stringBuffer.append("\n");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuffer.append(append);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.abs(((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3))) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    private static boolean a(GeoFence geoFence, int i2) {
        boolean z = false;
        if ((1 & i2) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z = true;
                }
            } catch (Throwable th) {
                cs.a(th, "Utils", "remindStatus");
            }
        }
        if ((2 & i2) == 2 && geoFence.getStatus() == 2) {
            z = true;
        }
        if ((i2 & 4) == 4 && geoFence.getStatus() == 3) {
            return true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        if ((r25 % 2) != 0) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013b A[Catch:{ Throwable -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x002d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.amap.api.location.AMapLocation r37, com.amap.api.fence.GeoFence r38) {
        /*
            r1 = 0
            r2 = 1
            boolean r3 = com.loc.da.a((com.amap.api.location.AMapLocation) r37)     // Catch:{ Throwable -> 0x0185 }
            if (r3 == 0) goto L_0x0183
            if (r38 == 0) goto L_0x0183
            java.util.List r4 = r38.getPointList()     // Catch:{ Throwable -> 0x0185 }
            if (r4 == 0) goto L_0x0183
            java.util.List r4 = r38.getPointList()     // Catch:{ Throwable -> 0x0185 }
            boolean r4 = r4.isEmpty()     // Catch:{ Throwable -> 0x0185 }
            if (r4 != 0) goto L_0x0183
            int r4 = r38.getType()     // Catch:{ Throwable -> 0x0185 }
            r5 = 3
            switch(r4) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0024;
                case 2: goto L_0x0151;
                case 3: goto L_0x0024;
                default: goto L_0x0022;
            }     // Catch:{ Throwable -> 0x0185 }
        L_0x0022:
            goto L_0x0183
        L_0x0024:
            java.util.List r3 = r38.getPointList()     // Catch:{ Throwable -> 0x0185 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Throwable -> 0x0185 }
            r4 = r1
        L_0x002d:
            boolean r6 = r3.hasNext()     // Catch:{ Throwable -> 0x014d }
            if (r6 == 0) goto L_0x014b
            java.lang.Object r6 = r3.next()     // Catch:{ Throwable -> 0x014d }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Throwable -> 0x014d }
            double r19 = r37.getLongitude()     // Catch:{ Throwable -> 0x014d }
            double r21 = r37.getLatitude()     // Catch:{ Throwable -> 0x014d }
            double r23 = r37.getLatitude()     // Catch:{ Throwable -> 0x014d }
            int r7 = r6.size()     // Catch:{ Throwable -> 0x014d }
            if (r7 >= r5) goto L_0x004e
        L_0x004b:
            r6 = r1
            goto L_0x0146
        L_0x004e:
            java.lang.Object r7 = r6.get(r1)     // Catch:{ Throwable -> 0x014d }
            com.amap.api.location.DPoint r7 = (com.amap.api.location.DPoint) r7     // Catch:{ Throwable -> 0x014d }
            int r8 = r6.size()     // Catch:{ Throwable -> 0x014d }
            int r8 = r8 - r2
            java.lang.Object r8 = r6.get(r8)     // Catch:{ Throwable -> 0x014d }
            boolean r7 = r7.equals(r8)     // Catch:{ Throwable -> 0x014d }
            if (r7 != 0) goto L_0x006a
            java.lang.Object r7 = r6.get(r1)     // Catch:{ Throwable -> 0x014d }
            r6.add(r7)     // Catch:{ Throwable -> 0x014d }
        L_0x006a:
            r7 = r1
            r25 = r7
        L_0x006d:
            int r8 = r6.size()     // Catch:{ Throwable -> 0x014d }
            int r8 = r8 - r2
            if (r7 >= r8) goto L_0x0140
            java.lang.Object r8 = r6.get(r7)     // Catch:{ Throwable -> 0x014d }
            com.amap.api.location.DPoint r8 = (com.amap.api.location.DPoint) r8     // Catch:{ Throwable -> 0x014d }
            double r26 = r8.getLongitude()     // Catch:{ Throwable -> 0x014d }
            java.lang.Object r8 = r6.get(r7)     // Catch:{ Throwable -> 0x014d }
            com.amap.api.location.DPoint r8 = (com.amap.api.location.DPoint) r8     // Catch:{ Throwable -> 0x014d }
            double r28 = r8.getLatitude()     // Catch:{ Throwable -> 0x014d }
            int r15 = r7 + 1
            java.lang.Object r7 = r6.get(r15)     // Catch:{ Throwable -> 0x014d }
            com.amap.api.location.DPoint r7 = (com.amap.api.location.DPoint) r7     // Catch:{ Throwable -> 0x014d }
            double r30 = r7.getLongitude()     // Catch:{ Throwable -> 0x014d }
            java.lang.Object r7 = r6.get(r15)     // Catch:{ Throwable -> 0x014d }
            com.amap.api.location.DPoint r7 = (com.amap.api.location.DPoint) r7     // Catch:{ Throwable -> 0x014d }
            double r32 = r7.getLatitude()     // Catch:{ Throwable -> 0x014d }
            r7 = r19
            r9 = r21
            r11 = r26
            r13 = r28
            r34 = r15
            r15 = r30
            r17 = r32
            boolean r7 = a(r7, r9, r11, r13, r15, r17)     // Catch:{ Throwable -> 0x014d }
            if (r7 == 0) goto L_0x00b5
        L_0x00b2:
            r6 = r2
            goto L_0x0146
        L_0x00b5:
            double r13 = r32 - r28
            double r7 = java.lang.Math.abs(r13)     // Catch:{ Throwable -> 0x014d }
            r9 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x013c
            r15 = 4640537203540230144(0x4066800000000000, double:180.0)
            r7 = r26
            r9 = r28
            r11 = r19
            r35 = r13
            r13 = r21
            r17 = r23
            boolean r7 = a(r7, r9, r11, r13, r15, r17)     // Catch:{ Throwable -> 0x014d }
            if (r7 == 0) goto L_0x00e2
            int r7 = (r28 > r32 ? 1 : (r28 == r32 ? 0 : -1))
            if (r7 <= 0) goto L_0x013c
        L_0x00df:
            int r25 = r25 + 1
            goto L_0x013c
        L_0x00e2:
            r15 = 4640537203540230144(0x4066800000000000, double:180.0)
            r7 = r30
            r9 = r32
            r11 = r19
            r13 = r21
            r17 = r23
            boolean r7 = a(r7, r9, r11, r13, r15, r17)     // Catch:{ Throwable -> 0x014d }
            if (r7 == 0) goto L_0x00fc
            int r7 = (r32 > r28 ? 1 : (r32 == r28 ? 0 : -1))
            if (r7 <= 0) goto L_0x013c
            goto L_0x00df
        L_0x00fc:
            double r30 = r30 - r26
            double r7 = r23 - r21
            double r9 = r30 * r7
            r11 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r11 = r11 - r19
            double r13 = r35 * r11
            double r9 = r9 - r13
            r13 = 0
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x0138
            double r28 = r28 - r21
            double r11 = r11 * r28
            double r26 = r26 - r19
            double r7 = r7 * r26
            double r11 = r11 - r7
            double r11 = r11 / r9
            double r28 = r28 * r30
            double r26 = r26 * r35
            double r28 = r28 - r26
            double r28 = r28 / r9
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 < 0) goto L_0x0138
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r9 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0138
            int r9 = (r28 > r13 ? 1 : (r28 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x0138
            int r7 = (r28 > r7 ? 1 : (r28 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0138
            r7 = r2
            goto L_0x0139
        L_0x0138:
            r7 = r1
        L_0x0139:
            if (r7 == 0) goto L_0x013c
            goto L_0x00df
        L_0x013c:
            r7 = r34
            goto L_0x006d
        L_0x0140:
            int r25 = r25 % 2
            if (r25 == 0) goto L_0x004b
            goto L_0x00b2
        L_0x0146:
            if (r6 == 0) goto L_0x002d
            r4 = r2
            goto L_0x002d
        L_0x014b:
            r2 = r4
            return r2
        L_0x014d:
            r0 = move-exception
            r1 = r0
            r2 = r4
            goto L_0x0188
        L_0x0151:
            com.amap.api.location.DPoint r4 = r38.getCenter()     // Catch:{ Throwable -> 0x0185 }
            float r3 = r38.getRadius()     // Catch:{ Throwable -> 0x0185 }
            r6 = 4
            double[] r6 = new double[r6]     // Catch:{ Throwable -> 0x0185 }
            double r7 = r4.getLatitude()     // Catch:{ Throwable -> 0x0185 }
            r6[r1] = r7     // Catch:{ Throwable -> 0x0185 }
            double r7 = r4.getLongitude()     // Catch:{ Throwable -> 0x0185 }
            r6[r2] = r7     // Catch:{ Throwable -> 0x0185 }
            double r7 = r37.getLatitude()     // Catch:{ Throwable -> 0x0185 }
            r4 = 2
            r6[r4] = r7     // Catch:{ Throwable -> 0x0185 }
            double r7 = r37.getLongitude()     // Catch:{ Throwable -> 0x0185 }
            r6[r5] = r7     // Catch:{ Throwable -> 0x0185 }
            float r4 = com.loc.da.a((double[]) r6)     // Catch:{ Throwable -> 0x0185 }
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x017f
            r3 = r2
            goto L_0x0180
        L_0x017f:
            r3 = r1
        L_0x0180:
            if (r3 == 0) goto L_0x0183
            return r2
        L_0x0183:
            r2 = r1
            return r2
        L_0x0185:
            r0 = move-exception
            r2 = r1
            r1 = r0
        L_0x0188:
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "isInGeoFence"
            com.loc.cs.a(r1, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.a(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean");
    }

    static float b(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint a2 : list) {
                f2 = Math.max(f2, da.a(dPoint, a2));
            }
        }
        return f2;
    }

    private int b(GeoFence geoFence) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            if (this.g.contains(geoFence)) {
                return 17;
            }
            this.g.add(geoFence);
            return 0;
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static DPoint b(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (DPoint next : list) {
                    d2 += next.getLatitude();
                    d3 += next.getLongitude();
                }
                return new DPoint(da.c(d2 / ((double) list.size())), da.c(d3 / ((double) list.size())));
            } catch (Throwable th) {
                cs.a(th, "GeoFenceUtil", "getPolygonCenter");
            }
        }
        return dPoint;
    }

    private static boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = true;
        try {
            if (a(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(da.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && da.b() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    cs.a(th, "Utils", "isFenceStatusChanged");
                    return z;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            cs.a(th, "Utils", "isFenceStatusChanged");
            return z;
        }
    }

    private static int c(int i2) {
        if (!(i2 == 1 || i2 == 7)) {
            switch (i2) {
                case 4:
                case 5:
                    break;
                default:
                    switch (i2) {
                        case 16:
                        case 17:
                            break;
                        default:
                            switch (i2) {
                                case 10000:
                                    i2 = 0;
                                    break;
                                case 10001:
                                case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME:
                                case SpeechEvent.EVENT_IST_CACHE_LEFT:
                                case SpeechEvent.EVENT_IST_RESULT_TIME:
                                case SpeechEvent.EVENT_IST_SYNC_ID:
                                case SpeechEvent.EVENT_VOLUME:
                                case SpeechEvent.EVENT_VAD_EOS:
                                    i2 = 7;
                                    break;
                                case 10003:
                                case SpeechEvent.EVENT_IST_AUDIO_FILE:
                                case 10005:
                                case SpeechEvent.EVENT_IST_UPLOAD_BYTES:
                                case SpeechEvent.EVENT_SESSION_BEGIN:
                                case SpeechEvent.EVENT_SESSION_END:
                                case 10014:
                                case 10015:
                                case 10016:
                                case 10017:
                                    i2 = 4;
                                    break;
                                default:
                                    switch (i2) {
                                        case 20000:
                                        case 20001:
                                        case 20002:
                                            i2 = 1;
                                            break;
                                        default:
                                            i2 = 8;
                                            break;
                                    }
                            }
                    }
            }
        }
        if (i2 != 0) {
            a("添加围栏失败", i2, "searchErrCode is " + i2, new String[0]);
        }
        return i2;
    }

    private void e() {
        if (!this.o) {
            this.o = true;
        }
        if (!this.n) {
            try {
                this.h = Looper.myLooper() == null ? new c(this.b.getMainLooper()) : new c();
            } catch (Throwable th) {
                cs.a(th, "GeoFenceManger", "init 1");
            }
            try {
                this.l = new b("fenceActionThread");
                this.l.setPriority(5);
                this.l.start();
                this.k = new C0009a(this.l.getLooper());
            } catch (Throwable th2) {
                cs.a(th2, "GeoFenceManger", "init 2");
            }
            try {
                Context context = this.b;
                this.p = new b();
                this.q = new c();
                this.u = new AMapLocationClientOption();
                this.r = new AMapLocationClient(this.b);
                this.u.setLocationCacheEnable(true);
                this.r.setLocationListener(this.w);
                if (this.a == null) {
                    this.a = new cx();
                }
            } catch (Throwable th3) {
                cs.a(th3, "GeoFenceManger", "initBase");
            }
            this.n = true;
            try {
                if (this.d != null && this.c == null) {
                    createPendingIntent(this.d);
                }
            } catch (Throwable th4) {
                cs.a(th4, "GeoFenceManger", "init 4");
            }
        }
    }

    private void f() {
        if (!this.x && this.k != null) {
            boolean z = false;
            if (this.s != null && da.a(this.s) && da.b() - this.t < 10000) {
                z = true;
            }
            if (z) {
                a(6, (Bundle) null, 0);
                a(5, (Bundle) null, 0);
                return;
            }
            a(7);
            a(7, (Bundle) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        try {
            if (this.n) {
                if (this.g != null) {
                    this.g.clear();
                    this.g = null;
                }
                if (!this.o) {
                    try {
                        synchronized (this.i) {
                            if (this.k != null) {
                                this.k.removeCallbacksAndMessages((Object) null);
                            }
                            this.k = null;
                        }
                    } catch (Throwable th) {
                        cs.a(th, "GeoFenceManager", "destroyActionHandler");
                    }
                    if (this.r != null) {
                        this.r.stopLocation();
                        this.r.onDestroy();
                    }
                    this.r = null;
                    if (this.l != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.l.quitSafely();
                        } else {
                            this.l.quit();
                        }
                    }
                    this.l = null;
                    this.p = null;
                    if (this.c != null) {
                        this.c.cancel();
                    }
                    this.c = null;
                    try {
                        synchronized (this.j) {
                            if (this.h != null) {
                                this.h.removeCallbacksAndMessages((Object) null);
                            }
                            this.h = null;
                        }
                    } catch (Throwable th2) {
                        cs.a(th2, "GeoFenceManager", "destroyResultHandler");
                    }
                    if (this.a != null) {
                        this.a.b(this.b);
                    }
                    this.m = false;
                    this.n = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    this.k.removeMessages(i2);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Bundle bundle) {
        try {
            synchronized (this.j) {
                if (this.h != null) {
                    Message obtainMessage = this.h.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.h.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Bundle bundle, long j2) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    Message obtainMessage = this.k.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.k.sendMessageDelayed(obtainMessage, j2);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        int i2 = 1;
        if (bundle != null) {
            try {
                i2 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                cs.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f != i2) {
            if (this.g != null && !this.g.isEmpty()) {
                Iterator<GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1);
                }
            }
            f();
        }
        this.f = i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(GeoFence geoFence) {
        try {
            if (this.b == null) {
                return;
            }
            if (this.c != null || geoFence.getPendingIntent() != null) {
                Intent intent = new Intent();
                intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                if (this.d != null) {
                    intent.setAction(this.d);
                }
                intent.setPackage(k.c(this.b));
                if (geoFence.getPendingIntent() != null) {
                    geoFence.getPendingIntent().send(this.b, 0, intent);
                } else {
                    this.c.send(this.b, 0, intent);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapLocation aMapLocation) {
        try {
            if (!this.x && this.g != null && !this.g.isEmpty() && aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                Iterator<GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    if (next.isAble() && b(aMapLocation, next) && a(next, this.f)) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("geoFence", next);
                        a(1001, bundle);
                    }
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public synchronized void addDistrictGeoFence(String str, String str2) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public synchronized void addKeywordGeoFence(String str, String str2, String str3, int i2, String str4) {
        try {
            e();
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("size", i2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public synchronized void addNearbyGeoFence(String str, String str2, DPoint dPoint, float f2, int i2, String str3) {
        try {
            e();
            if (f2 <= 0.0f || f2 > 50000.0f) {
                f2 = 3000.0f;
            }
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f2);
            bundle.putInt("size", i2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            a(3, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public synchronized void addPolygonGeoFence(List<DPoint> list, String str) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("points", new ArrayList(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public synchronized void addRoundGeoFence(DPoint dPoint, float f2, String str) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putParcelable("point", dPoint);
            bundle.putFloat("radius", f2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            com.amap.api.location.AMapLocationClient r0 = r3.r     // Catch:{ Throwable -> 0x002c }
            if (r0 == 0) goto L_0x002b
            boolean r0 = r3.m     // Catch:{ Throwable -> 0x0019 }
            if (r0 == 0) goto L_0x000d
            r0 = 8
            r3.a((int) r0)     // Catch:{ Throwable -> 0x0019 }
        L_0x000d:
            com.amap.api.location.AMapLocationClient r0 = r3.r     // Catch:{ Throwable -> 0x0019 }
            if (r0 == 0) goto L_0x0016
            com.amap.api.location.AMapLocationClient r0 = r3.r     // Catch:{ Throwable -> 0x0019 }
            r0.stopLocation()     // Catch:{ Throwable -> 0x0019 }
        L_0x0016:
            r0 = 0
            r3.m = r0     // Catch:{ Throwable -> 0x0019 }
        L_0x0019:
            com.amap.api.location.AMapLocationClientOption r0 = r3.u     // Catch:{ Throwable -> 0x002c }
            r1 = 1
            r0.setOnceLocation(r1)     // Catch:{ Throwable -> 0x002c }
            com.amap.api.location.AMapLocationClient r0 = r3.r     // Catch:{ Throwable -> 0x002c }
            com.amap.api.location.AMapLocationClientOption r1 = r3.u     // Catch:{ Throwable -> 0x002c }
            r0.setLocationOption(r1)     // Catch:{ Throwable -> 0x002c }
            com.amap.api.location.AMapLocationClient r0 = r3.r     // Catch:{ Throwable -> 0x002c }
            r0.startLocation()     // Catch:{ Throwable -> 0x002c }
        L_0x002b:
            return
        L_0x002c:
            r0 = move-exception
            java.lang.String r1 = "GeoFenceManager"
            java.lang.String r2 = "doStartOnceLocation"
            com.loc.cs.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.b():void");
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        try {
            if (this.b != null && this.c != null) {
                Intent intent = new Intent();
                intent.putExtras(a((GeoFence) null, (String) null, (String) null, 4, i2));
                this.c.send(this.b, 0, intent);
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Bundle bundle) {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                DPoint dPoint = (DPoint) bundle.getParcelable("point");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d) {
                        if (dPoint.getLongitude() >= -180.0d) {
                            GeoFence a2 = a(bundle, false);
                            i2 = b(a2);
                            if (i2 == 0) {
                                arrayList.add(a2);
                            }
                        }
                    }
                    a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle2.putParcelableArrayList("resultList", arrayList);
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1000, bundle2);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doAddGeoFence_round");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        float f2;
        try {
            if (!this.x && da.a(this.s)) {
                AMapLocation aMapLocation = this.s;
                ArrayList<GeoFence> arrayList = this.g;
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && arrayList != null && !arrayList.isEmpty()) {
                    DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    Iterator<GeoFence> it = arrayList.iterator();
                    float f3 = Float.MAX_VALUE;
                    while (true) {
                        if (!it.hasNext()) {
                            f2 = f3;
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.isAble()) {
                            float a2 = da.a(dPoint, next.getCenter());
                            if (a2 > next.getMinDis2Center() && a2 < next.getMaxDis2Center()) {
                                f2 = 0.0f;
                                break;
                            }
                            if (a2 > next.getMaxDis2Center()) {
                                f3 = Math.min(f3, a2 - next.getMaxDis2Center());
                            }
                            if (a2 < next.getMinDis2Center()) {
                                f3 = Math.min(f3, next.getMinDis2Center() - a2);
                            }
                        }
                    }
                } else {
                    f2 = Float.MAX_VALUE;
                }
                if (f2 != Float.MAX_VALUE) {
                    if (f2 < 1000.0f) {
                        a(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong("interval", 2000);
                        a(8, bundle, 500);
                    } else if (f2 < 5000.0f) {
                        a(7);
                        a(7, (Bundle) null, 10000);
                    } else {
                        a(7);
                        a(7, (Bundle) null, (long) (((f2 - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Bundle bundle) {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("points");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null) {
                    if (parcelableArrayList.size() > 2) {
                        GeoFence a2 = a(bundle, true);
                        i2 = b(a2);
                        if (i2 == 0) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle2.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle2);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doAddGeoFence_polygon");
        }
    }

    public synchronized PendingIntent createPendingIntent(String str) {
        try {
            e();
            Intent intent = new Intent();
            intent.setPackage(k.c(this.b));
            intent.setAction(str);
            this.c = PendingIntent.getBroadcast(this.b, 0, intent, 0);
            this.d = str;
            if (this.g != null && !this.g.isEmpty()) {
                Iterator<GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setPendingIntent(this.c);
                    next.setPendingIntentAction(this.d);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "createPendingIntent");
        }
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        try {
            a(7);
            a(8);
            if (this.r != null) {
                this.r.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(Bundle bundle) {
        String str;
        int c2;
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                String string = bundle.getString("keyword");
                String string2 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                float f2 = bundle.getFloat("aroundRadius", 3000.0f);
                int i3 = bundle.getInt("size", 10);
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (!TextUtils.isEmpty(string)) {
                        if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d) {
                            if (dPoint.getLongitude() >= -180.0d) {
                                double c3 = da.c(dPoint.getLatitude());
                                double c4 = da.c(dPoint.getLongitude());
                                int intValue = Float.valueOf(f2).intValue();
                                b bVar = this.p;
                                Context context = this.b;
                                String valueOf = String.valueOf(i3);
                                String a2 = bVar.a(context, "http://restapi.amap.com/v3/place/around?", string, string2, valueOf, String.valueOf(c3), String.valueOf(c4), String.valueOf(intValue));
                                if (a2 != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                                    bundle2.putString("pendingIntentAction", this.d);
                                    bundle2.putLong("expiration", -1);
                                    bundle2.putInt("activatesAction", this.f);
                                    bundle2.putFloat("geoRadius", 200.0f);
                                    c cVar = this.q;
                                    int b2 = c.b(a2, arrayList2, bundle2);
                                    if (b2 != 10000) {
                                        c2 = c(b2);
                                    } else if (arrayList2.isEmpty()) {
                                        i2 = 16;
                                    } else {
                                        c2 = a((List<GeoFence>) arrayList2);
                                        if (c2 == 0) {
                                            arrayList.addAll(arrayList2);
                                        }
                                    }
                                    i2 = c2;
                                } else {
                                    i2 = 4;
                                }
                            }
                        }
                        a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    }
                }
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle3.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle3.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle3);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doAddGeoFence_nearby");
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(Bundle bundle) {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                String string = bundle.getString("keyword");
                String string2 = bundle.getString("poiType");
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                int i3 = bundle.getInt("size", 10);
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                Bundle bundle2 = new Bundle();
                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                bundle2.putString("pendingIntentAction", this.d);
                bundle2.putLong("expiration", -1);
                bundle2.putInt("activatesAction", this.f);
                bundle2.putFloat("geoRadius", 1000.0f);
                String a2 = this.p.a(this.b, "http://restapi.amap.com/v3/place/text?", string, string2, string3, String.valueOf(i3));
                if (!TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(string2)) {
                        if (a2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            c cVar = this.q;
                            int a3 = c.a(a2, arrayList2, bundle2);
                            if (a3 != 10000) {
                                i2 = c(a3);
                            } else if (arrayList2.isEmpty()) {
                                i2 = 16;
                            } else {
                                i2 = a((List<GeoFence>) arrayList2);
                                if (i2 == 0) {
                                    arrayList.addAll(arrayList2);
                                }
                            }
                        } else {
                            i2 = 4;
                        }
                    }
                }
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle3.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle3.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle3);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doAddGeoFence_Keyword");
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(Bundle bundle) {
        String str;
        int i2;
        try {
            ArrayList arrayList = new ArrayList();
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                String string = bundle.getString("keyword");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String a2 = this.p.a(this.b, "http://restapi.amap.com/v3/config/district?", string);
                if (!TextUtils.isEmpty(string)) {
                    if (a2 != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        bundle2.putString("pendingIntentAction", this.d);
                        bundle2.putLong("expiration", -1);
                        bundle2.putInt("activatesAction", this.f);
                        ArrayList arrayList2 = new ArrayList();
                        int c2 = this.q.c(a2, arrayList2, bundle2);
                        if (c2 != 10000) {
                            i2 = c(c2);
                        } else if (arrayList2.isEmpty()) {
                            i2 = 16;
                        } else {
                            i2 = a((List<GeoFence>) arrayList2);
                            if (i2 == 0) {
                                arrayList.addAll(arrayList2);
                            }
                        }
                    } else {
                        i2 = 4;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(MyLocationStyle.ERROR_CODE, i2);
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    bundle3.putParcelableArrayList("resultList", arrayList);
                    a(1000, bundle3);
                }
            }
            i2 = 1;
            Bundle bundle32 = new Bundle();
            bundle32.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle32.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle32.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle32);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doAddGeoFence_district");
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z = true;
                        boolean z2 = bundle.getBoolean("ab", true);
                        if (this.g != null && !this.g.isEmpty()) {
                            Iterator<GeoFence> it = this.g.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                GeoFence next = it.next();
                                if (next.getFenceId().equals(string)) {
                                    next.setAble(z2);
                                    break;
                                }
                            }
                        }
                        if (!z2) {
                            if (this.g != null) {
                                if (!this.g.isEmpty()) {
                                    Iterator<GeoFence> it2 = this.g.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (it2.next().isAble()) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (z) {
                                d();
                                return;
                            }
                            return;
                        }
                        f();
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public List<GeoFence> getAllGeoFence() {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            return (ArrayList) this.g.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void h(android.os.Bundle r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.ArrayList<com.amap.api.fence.GeoFence> r0 = r1.g     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = "fc"
            android.os.Parcelable r2 = r2.getParcelable(r0)     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            com.amap.api.fence.GeoFence r2 = (com.amap.api.fence.GeoFence) r2     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            java.util.ArrayList<com.amap.api.fence.GeoFence> r0 = r1.g     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            boolean r0 = r0.contains(r2)     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            if (r0 == 0) goto L_0x001a
            java.util.ArrayList<com.amap.api.fence.GeoFence> r0 = r1.g     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            r0.remove(r2)     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
        L_0x001a:
            java.util.ArrayList<com.amap.api.fence.GeoFence> r2 = r1.g     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            int r2 = r2.size()     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
            if (r2 != 0) goto L_0x0025
            r1.a()     // Catch:{ Throwable -> 0x002a, all -> 0x0027 }
        L_0x0025:
            monitor-exit(r1)
            return
        L_0x0027:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x002a:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.h(android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public final void i(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    int i2 = bundle.getInt(MyLocationStyle.ERROR_CODE);
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                    if (parcelableArrayList == null) {
                        parcelableArrayList = new ArrayList();
                    }
                    String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    if (string == null) {
                        string = "";
                    }
                    if (this.e != null) {
                        this.e.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i2, string);
                    }
                    if (i2 == 0) {
                        f();
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public boolean isPause() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public final void j(Bundle bundle) {
        try {
            if (this.r != null) {
                long j2 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j2 = bundle.getLong("interval", 2000);
                }
                this.u.setOnceLocation(false);
                this.u.setInterval(j2);
                this.r.setLocationOption(this.u);
                if (!this.m) {
                    this.r.stopLocation();
                    this.r.startLocation();
                    this.m = true;
                }
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public synchronized void pauseGeoFence() {
        try {
            e();
            this.x = true;
            a(13, (Bundle) null, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public synchronized void removeGeoFence() {
        try {
            this.o = false;
            a(10, (Bundle) null, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            if (this.g != null) {
                if (!this.g.isEmpty()) {
                    if (!this.g.contains(geoFence)) {
                        return false;
                    }
                    if (this.g.size() == 1) {
                        this.o = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    a(11, bundle, 0);
                    return true;
                }
            }
            this.o = false;
            a(10, (Bundle) null, 0);
            return true;
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public synchronized void resumeGeoFence() {
        try {
            e();
            if (this.x) {
                this.x = false;
                f();
            }
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public synchronized void setActivateAction(int i2) {
        try {
            e();
            if (i2 > 7 || i2 <= 0) {
                i2 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i2);
            a(9, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public synchronized void setGeoFenceAble(String str, boolean z) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            a(12, bundle, 0);
        } catch (Throwable th) {
            cs.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }
}
