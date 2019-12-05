package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.RouteOverlayOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/* compiled from: LBSRouteOverLay */
public final class fs {
    private List<Circle> A = null;
    private boolean B = true;
    private NavigateArrow C = null;
    private boolean D = true;
    private int E = Color.parseColor("#4DF6CC");
    private HashMap<Integer, BitmapDescriptor[]> F = new HashMap<>();
    private List<Integer> G = new ArrayList();
    List<NaviLatLng> a = new ArrayList();
    public boolean b = false;
    int c = 1;
    int d = 0;
    private Bitmap e;
    private Bitmap f;
    private BitmapDescriptor g;
    private BitmapDescriptor h;
    private Marker i;
    private List<Marker> j;
    private Marker k;
    private BitmapDescriptor[] l = new BitmapDescriptor[2];
    private BitmapDescriptor[] m = new BitmapDescriptor[2];
    private BitmapDescriptor[] n = new BitmapDescriptor[2];
    private BitmapDescriptor[] o = new BitmapDescriptor[2];
    private BitmapDescriptor[] p = new BitmapDescriptor[2];
    private List<Polyline> q = new ArrayList();
    private List<Marker> r = new ArrayList();
    private RouteOverlayOptions s = null;
    private float t = 40.0f;
    private AMapNaviPath u = null;
    private Polyline v;
    private Polyline w;
    private AMap x;
    private Context y;
    private Polyline z = null;

    public fs(AMap aMap, Context context) {
        this.y = context;
        this.t = (float) hq.a(context, 22);
        try {
            this.x = aMap;
            this.u = null;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "init(AMap amap, AMapNaviPath aMapNaviPath)");
        }
        this.m[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_green_unselected.png");
        this.m[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_green.png");
        this.l[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_no_unselected.png");
        this.l[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture.png");
        this.n[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_slow_unselected.png");
        this.n[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_slow.png");
        this.o[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_bad_unselected.png");
        this.o[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_bad.png");
        this.p[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_serious_unselected.png");
        this.p[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_grayred.png");
        this.F.put(0, this.l);
        this.F.put(1, this.m);
        this.F.put(2, this.n);
        this.F.put(3, this.o);
        this.F.put(4, this.p);
    }

    public final RouteOverlayOptions a() {
        return this.s;
    }

    public final void a(AMapNaviPath aMapNaviPath) {
        this.u = aMapNaviPath;
    }

    private static LatLng a(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return null;
        }
        return new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
    }

    public final void b() {
        List<NaviLatLng> list;
        LatLng latLng;
        Marker marker;
        try {
            if (this.x != null) {
                if (this.t != 0.0f) {
                    if (this.u != null) {
                        if (this.r != null && this.r.size() > 0) {
                            for (int i2 = 0; i2 < this.r.size(); i2++) {
                                if (this.r.get(i2) != null) {
                                    this.r.get(i2).remove();
                                }
                            }
                            this.r.clear();
                        }
                        List<NaviLatLng> lightList = this.u.getLightList();
                        if (lightList != null && lightList.size() > 0) {
                            for (NaviLatLng next : lightList) {
                                this.r.add(this.x.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).position(new LatLng(next.getLatitude(), next.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837538)))));
                            }
                        }
                        if (this.C != null) {
                            this.C.setVisible(false);
                        }
                        this.u.getCoordList();
                        AMap aMap = this.x;
                        AMapNaviPath aMapNaviPath = this.u;
                        NaviLatLng carToFootPoint = aMapNaviPath.getCarToFootPoint();
                        ArrayList<NaviLatLng> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        this.a = new ArrayList();
                        ArrayList<NaviLatLng> arrayList3 = new ArrayList<>();
                        ArrayList arrayList4 = new ArrayList();
                        int size = aMapNaviPath.getSteps().size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList4.addAll(aMapNaviPath.getSteps().get(i3).getLinks());
                        }
                        if (arrayList4.size() > 0) {
                            boolean z2 = false;
                            for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                                AMapNaviLink aMapNaviLink = (AMapNaviLink) arrayList4.get(i4);
                                int roadClass = aMapNaviLink.getRoadClass();
                                String roadName = aMapNaviLink.getRoadName();
                                if (z2 || ((!roadName.equals("内部道路") && !roadName.equals("无名道路")) || roadClass != 10)) {
                                    arrayList2.addAll(aMapNaviLink.getCoords());
                                    z2 = true;
                                } else {
                                    arrayList.addAll(aMapNaviLink.getCoords());
                                }
                            }
                        }
                        if (carToFootPoint != null) {
                            int i5 = -1;
                            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                NaviLatLng naviLatLng = (NaviLatLng) arrayList2.get(i6);
                                if (Math.abs(naviLatLng.getLatitude() - carToFootPoint.getLatitude()) < 5.0E-6d && Math.abs(naviLatLng.getLongitude() - carToFootPoint.getLongitude()) < 5.0E-6d) {
                                    this.a.add(naviLatLng);
                                    i5 = i6;
                                }
                                if (i5 > 0) {
                                    arrayList3.add(naviLatLng);
                                } else {
                                    this.a.add(naviLatLng);
                                }
                            }
                        } else {
                            this.a.addAll(arrayList2);
                        }
                        ArrayList arrayList5 = new ArrayList();
                        ArrayList arrayList6 = new ArrayList();
                        for (NaviLatLng a2 : arrayList) {
                            arrayList5.add(a(a2));
                        }
                        for (NaviLatLng a3 : arrayList3) {
                            arrayList6.add(a(a3));
                        }
                        if (this.v != null) {
                            this.v.remove();
                        }
                        if (this.w != null) {
                            this.w.remove();
                        }
                        this.v = aMap.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList5).color(-1811939073).width(20.0f));
                        this.w = aMap.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList6).color(-1811939073).width(20.0f));
                        List<NaviLatLng> list2 = this.a;
                        if (list2 != null) {
                            list2.size();
                            e();
                            if (this.u.getStartPoint() == null || this.u.getEndPoint() == null) {
                                latLng = null;
                                list = null;
                            } else {
                                latLng = new LatLng(this.u.getEndPoint().getLatitude(), this.u.getEndPoint().getLongitude());
                                list = this.u.getWayPoint();
                            }
                            if (this.k != null) {
                                this.k.remove();
                            }
                            if (this.j != null && this.j.size() > 0) {
                                for (int i7 = 0; i7 < this.j.size(); i7++) {
                                    Marker marker2 = this.j.get(i7);
                                    if (marker2 != null) {
                                        marker2.remove();
                                    }
                                }
                            }
                            NaviLatLng carToFootPoint2 = this.u.getCarToFootPoint();
                            if (carToFootPoint2 != null && this.i == null) {
                                this.i = this.x.addMarker(new MarkerOptions().position(a(carToFootPoint2)).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837585))));
                            }
                            if (list != null && list.size() > 0) {
                                int size2 = list.size();
                                if (this.j == null) {
                                    this.j = new ArrayList(size2);
                                }
                                for (NaviLatLng next2 : list) {
                                    LatLng latLng2 = new LatLng(next2.getLatitude(), next2.getLongitude());
                                    if (this.f == null) {
                                        marker = this.x.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837546))));
                                    } else {
                                        marker = this.h != null ? this.x.addMarker(new MarkerOptions().position(latLng2).icon(this.h)) : null;
                                    }
                                    this.j.add(marker);
                                }
                            }
                            if (this.e == null) {
                                this.k = this.x.addMarker(new MarkerOptions().position(latLng).anchor(0.2f, 1.0f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837687))));
                            } else if (this.g != null) {
                                this.k = this.x.addMarker(new MarkerOptions().position(latLng).icon(this.g));
                            }
                            if (this.D) {
                                a(Boolean.valueOf(this.D), this.u.getTrafficStatuses());
                            }
                            if (this.b) {
                                c();
                                return;
                            }
                            return;
                        } else if (this.b) {
                            c();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (this.b) {
                    c();
                }
            } else if (this.b) {
                c();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.b) {
                c();
            }
            throw th2;
        }
    }

    public final void a(LatLng latLng, LatLng latLng2, boolean z2) {
        if (z2) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(latLng);
            arrayList.add(latLng2);
            if (this.z == null) {
                this.z = this.x.addPolyline(new PolylineOptions().addAll(arrayList).width(this.t / 3.0f).setDottedLine(true));
            } else {
                this.z.setPoints(arrayList);
            }
            this.z.setVisible(true);
        } else if (this.z != null) {
            this.z.setVisible(false);
        }
    }

    public final void c() {
        try {
            if (this.v != null) {
                this.v.setVisible(false);
            }
            if (this.w != null) {
                this.w.setVisible(false);
            }
            if (this.i != null) {
                this.i.setVisible(false);
                this.i.remove();
            }
            if (this.k != null) {
                this.k.setVisible(false);
                this.k.remove();
            }
            if (this.C != null) {
                this.C.remove();
            }
            if (this.z != null) {
                this.z.setVisible(false);
            }
            if (this.A != null) {
                for (Circle visible : this.A) {
                    visible.setVisible(false);
                }
            }
            if (this.j != null) {
                for (Marker visible2 : this.j) {
                    visible2.setVisible(false);
                }
            }
            e();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "removeFromMap()");
        }
    }

    private void e() {
        if (this.q.size() > 0) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                if (this.q.get(i2) != null) {
                    this.q.get(i2).remove();
                }
            }
        }
        this.q.clear();
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.u != null) {
                this.x.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(this.u.getBoundsForPath(), i2, i3, i4, i5), 1000, (AMap.CancelableCallback) null);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "zoomToSpan()");
        }
    }

    public final void b(AMapNaviPath aMapNaviPath) {
        if (aMapNaviPath != null) {
            try {
                this.x.animateCamera(CameraUpdateFactory.newLatLngBounds(aMapNaviPath.getBoundsForPath(), 100), 1000, (AMap.CancelableCallback) null);
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "RouteOverLay", "zoomToSpan()");
            }
        }
    }

    public final void a(boolean z2) {
        if (this.r != null && this.r.size() > 0) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                if (this.r.get(i2) != null) {
                    this.r.get(i2).setVisible(z2);
                }
            }
        }
    }

    public final void d() {
        try {
            if (this.r.size() > 0) {
                for (int i2 = 0; i2 < this.r.size(); i2++) {
                    if (this.r.get(i2) != null) {
                        this.r.get(i2).remove();
                    }
                }
            }
            this.r.clear();
            this.b = true;
            if (this.v != null) {
                this.v.remove();
            }
            if (this.w != null) {
                this.w.remove();
            }
            this.u = null;
            if (this.m != null && this.m.length > 1) {
                this.m[0].recycle();
                this.m[1].recycle();
            }
            if (this.l != null && this.l.length > 1) {
                this.l[0].recycle();
                this.l[1].recycle();
            }
            if (this.n != null && this.n.length > 1) {
                this.n[0].recycle();
                this.n[1].recycle();
            }
            if (this.o != null && this.o.length > 1) {
                this.o[0].recycle();
                this.o[1].recycle();
            }
            if (this.p != null && this.p.length > 1) {
                this.p[0].recycle();
                this.p[1].recycle();
            }
            if (this.e != null) {
                this.e.recycle();
            }
            if (this.f != null) {
                this.f.recycle();
            }
            if (this.F != null) {
                this.F.clear();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "destroy()");
        }
    }

    public final void a(List<NaviLatLng> list) {
        if (list == null) {
            try {
                this.C.setVisible(false);
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "RouteOverLay", "drawArrow(List<NaviLatLng> list) ");
            }
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            for (NaviLatLng next : list) {
                LatLng latLng = new LatLng(next.getLatitude(), next.getLongitude(), false);
                arrayList.add(latLng);
            }
            if (this.C == null) {
                this.C = this.x.addNavigateArrow(new NavigateArrowOptions().addAll(arrayList).topColor(this.E).width(this.t * 0.4f));
            } else {
                this.C.setPoints(arrayList);
            }
            this.C.setZIndex(1.0f);
            this.C.setVisible(true);
        }
    }

    public final List<NaviLatLng> a(int i2) {
        if (this.u == null) {
            return null;
        }
        try {
            if (i2 >= this.u.getStepsCount()) {
                return null;
            }
            List<NaviLatLng> coordList = this.u.getCoordList();
            int size = coordList.size();
            int endIndex = this.u.getSteps().get(i2).getEndIndex();
            NaviLatLng naviLatLng = coordList.get(endIndex);
            Vector vector = new Vector();
            int i3 = endIndex - 1;
            int i4 = 0;
            NaviLatLng naviLatLng2 = naviLatLng;
            int i5 = 0;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                NaviLatLng naviLatLng3 = coordList.get(i3);
                int a2 = hq.a(naviLatLng2, naviLatLng3);
                i5 += a2;
                if (i5 >= 50) {
                    vector.add(hq.a(naviLatLng2, naviLatLng3, (double) ((a2 + 50) - i5)));
                    break;
                }
                vector.add(naviLatLng3);
                i3--;
                naviLatLng2 = naviLatLng3;
            }
            Collections.reverse(vector);
            vector.add(naviLatLng);
            int i6 = endIndex + 1;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                NaviLatLng naviLatLng4 = coordList.get(i6);
                int a3 = hq.a(naviLatLng, naviLatLng4);
                i4 += a3;
                if (i4 >= 50) {
                    vector.add(hq.a(naviLatLng, naviLatLng4, (double) ((50 + a3) - i4)));
                    break;
                }
                vector.add(naviLatLng4);
                i6++;
                naviLatLng = naviLatLng4;
            }
            if (vector.size() > 2) {
                return vector;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RouteOverLay", "getArrowPoints(int roadIndex)");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022b, code lost:
        if (r1.b != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r1.b != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01de, code lost:
        if (r1.b != false) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0195 A[Catch:{ Throwable -> 0x0232 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b3 A[Catch:{ Throwable -> 0x0232 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e2 A[SYNTHETIC, Splitter:B:89:0x01e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Boolean r28, java.util.List<com.amap.api.navi.model.AMapTrafficStatus> r29) {
        /*
            r27 = this;
            r1 = r27
            android.content.Context r2 = r1.y     // Catch:{ Throwable -> 0x0250 }
            if (r2 != 0) goto L_0x000e
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x000d
            r27.c()
        L_0x000d:
            return
        L_0x000e:
            boolean r2 = r28.booleanValue()     // Catch:{ Throwable -> 0x0250 }
            r1.D = r2     // Catch:{ Throwable -> 0x0250 }
            r27.e()     // Catch:{ Throwable -> 0x0250 }
            boolean r2 = r1.D     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
            if (r29 == 0) goto L_0x0027
            int r3 = r29.size()     // Catch:{ Throwable -> 0x0250 }
            if (r3 != 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            r2 = r29
            goto L_0x002d
        L_0x0027:
            com.amap.api.navi.model.AMapNaviPath r2 = r1.u     // Catch:{ Throwable -> 0x0250 }
            java.util.List r2 = r2.getTrafficStatuses()     // Catch:{ Throwable -> 0x0250 }
        L_0x002d:
            com.amap.api.maps.AMap r3 = r1.x     // Catch:{ Throwable -> 0x0232 }
            if (r3 != 0) goto L_0x003a
            boolean r2 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
        L_0x0035:
            r27.c()     // Catch:{ Throwable -> 0x0250 }
            goto L_0x0245
        L_0x003a:
            if (r2 == 0) goto L_0x0229
            int r3 = r2.size()     // Catch:{ Throwable -> 0x0232 }
            if (r3 > 0) goto L_0x0044
            goto L_0x0229
        L_0x0044:
            com.amap.api.navi.model.AMapNaviPath r3 = r1.u     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.NaviLatLng r3 = r3.getCarToFootPoint()     // Catch:{ Throwable -> 0x0232 }
            java.util.List<java.lang.Integer> r4 = r1.G     // Catch:{ Throwable -> 0x0232 }
            if (r4 == 0) goto L_0x0053
            java.util.List<java.lang.Integer> r4 = r1.G     // Catch:{ Throwable -> 0x0232 }
            r4.clear()     // Catch:{ Throwable -> 0x0232 }
        L_0x0053:
            r27.e()     // Catch:{ Throwable -> 0x0232 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0232 }
            r4.<init>()     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.AMapNaviPath r5 = r1.u     // Catch:{ Throwable -> 0x0232 }
            java.util.List r5 = r5.getSteps()     // Catch:{ Throwable -> 0x0232 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0067:
            int r14 = r5.size()     // Catch:{ Throwable -> 0x0232 }
            if (r8 >= r14) goto L_0x0223
            java.lang.Object r14 = r5.get(r8)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.AMapNaviStep r14 = (com.amap.api.navi.model.AMapNaviStep) r14     // Catch:{ Throwable -> 0x0232 }
            java.util.List r14 = r14.getLinks()     // Catch:{ Throwable -> 0x0232 }
            r15 = r13
            r13 = r10
            r10 = r9
            r9 = 0
        L_0x007b:
            int r6 = r14.size()     // Catch:{ Throwable -> 0x0232 }
            if (r9 >= r6) goto L_0x0215
            int r6 = r2.size()     // Catch:{ Throwable -> 0x0232 }
            if (r11 >= r6) goto L_0x008e
            java.lang.Object r6 = r2.get(r11)     // Catch:{ Throwable -> 0x0232 }
            r13 = r6
            com.amap.api.navi.model.AMapTrafficStatus r13 = (com.amap.api.navi.model.AMapTrafficStatus) r13     // Catch:{ Throwable -> 0x0232 }
        L_0x008e:
            java.lang.Object r6 = r14.get(r9)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.AMapNaviLink r6 = (com.amap.api.navi.model.AMapNaviLink) r6     // Catch:{ Throwable -> 0x0232 }
            int r7 = r6.getRoadClass()     // Catch:{ Throwable -> 0x0232 }
            r16 = r2
            java.lang.String r2 = r6.getRoadName()     // Catch:{ Throwable -> 0x0232 }
            r17 = 1
            if (r12 != 0) goto L_0x00d6
            r18 = r5
            java.lang.String r5 = "内部道路"
            boolean r5 = r2.equals(r5)     // Catch:{ Throwable -> 0x0232 }
            if (r5 != 0) goto L_0x00b4
            java.lang.String r5 = "无名道路"
            boolean r2 = r2.equals(r5)     // Catch:{ Throwable -> 0x0232 }
            if (r2 == 0) goto L_0x00d8
        L_0x00b4:
            r2 = 10
            if (r7 != r2) goto L_0x00d8
            int r2 = r6.getLength()     // Catch:{ Throwable -> 0x0232 }
            int r7 = r10 + r2
            int r2 = r13.getLength()     // Catch:{ Throwable -> 0x0232 }
            int r2 = r7 - r2
            int r2 = java.lang.Math.abs(r2)     // Catch:{ Throwable -> 0x0232 }
            if (r2 > 0) goto L_0x00d1
            int r11 = r11 + 1
            r25 = r14
        L_0x00ce:
            r10 = 0
            goto L_0x020b
        L_0x00d1:
            r10 = r7
            r25 = r14
            goto L_0x020b
        L_0x00d6:
            r18 = r5
        L_0x00d8:
            r2 = 0
            r5 = 0
        L_0x00da:
            if (r15 != 0) goto L_0x0163
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x0232 }
            int r7 = r7.size()     // Catch:{ Throwable -> 0x0232 }
            if (r2 >= r7) goto L_0x0163
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0232 }
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x0232 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.NaviLatLng r7 = (com.amap.api.navi.model.NaviLatLng) r7     // Catch:{ Throwable -> 0x0232 }
            double r20 = r7.getLatitude()     // Catch:{ Throwable -> 0x0232 }
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x0232 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.navi.model.NaviLatLng r7 = (com.amap.api.navi.model.NaviLatLng) r7     // Catch:{ Throwable -> 0x0232 }
            double r22 = r7.getLongitude()     // Catch:{ Throwable -> 0x0232 }
            r24 = 0
            r19 = r5
            r19.<init>(r20, r22, r24)     // Catch:{ Throwable -> 0x0232 }
            if (r3 == 0) goto L_0x013c
            r25 = r14
            r26 = r15
            double r14 = r5.latitude     // Catch:{ Throwable -> 0x0232 }
            double r19 = r3.getLatitude()     // Catch:{ Throwable -> 0x0232 }
            double r14 = r14 - r19
            double r14 = java.lang.Math.abs(r14)     // Catch:{ Throwable -> 0x0232 }
            r19 = 4527516983983565041(0x3ed4f8b588e368f1, double:5.0E-6)
            int r7 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r7 >= 0) goto L_0x0140
            double r14 = r5.longitude     // Catch:{ Throwable -> 0x0232 }
            double r21 = r3.getLongitude()     // Catch:{ Throwable -> 0x0232 }
            double r14 = r14 - r21
            double r14 = java.lang.Math.abs(r14)     // Catch:{ Throwable -> 0x0232 }
            int r7 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r7 >= 0) goto L_0x0140
            r4.add(r5)     // Catch:{ Throwable -> 0x0232 }
            r15 = r17
            goto L_0x0169
        L_0x013c:
            r25 = r14
            r26 = r15
        L_0x0140:
            int r7 = r4.size()     // Catch:{ Throwable -> 0x0232 }
            if (r7 == 0) goto L_0x0158
            int r7 = r4.size()     // Catch:{ Throwable -> 0x0232 }
            int r7 = r7 + -1
            java.lang.Object r7 = r4.get(r7)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.LatLng r7 = (com.amap.api.maps.model.LatLng) r7     // Catch:{ Throwable -> 0x0232 }
            boolean r7 = r7.equals(r5)     // Catch:{ Throwable -> 0x0232 }
            if (r7 != 0) goto L_0x015b
        L_0x0158:
            r4.add(r5)     // Catch:{ Throwable -> 0x0232 }
        L_0x015b:
            int r2 = r2 + 1
            r14 = r25
            r15 = r26
            goto L_0x00da
        L_0x0163:
            r25 = r14
            r26 = r15
            r15 = r26
        L_0x0169:
            int r2 = r6.getLength()     // Catch:{ Throwable -> 0x0232 }
            int r7 = r10 + r2
            if (r15 != 0) goto L_0x017d
            int r2 = r13.getLength()     // Catch:{ Throwable -> 0x0232 }
            int r2 = r7 - r2
            int r2 = java.lang.Math.abs(r2)     // Catch:{ Throwable -> 0x0232 }
            if (r2 > 0) goto L_0x0208
        L_0x017d:
            int r2 = r4.size()     // Catch:{ Throwable -> 0x0232 }
            if (r2 <= 0) goto L_0x0208
            java.util.HashMap<java.lang.Integer, com.amap.api.maps.model.BitmapDescriptor[]> r2 = r1.F     // Catch:{ Throwable -> 0x0232 }
            int r6 = r13.getStatus()     // Catch:{ Throwable -> 0x0232 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0232 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.BitmapDescriptor[] r2 = (com.amap.api.maps.model.BitmapDescriptor[]) r2     // Catch:{ Throwable -> 0x0232 }
            if (r2 == 0) goto L_0x01b3
            com.amap.api.maps.AMap r6 = r1.x     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r7 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0232 }
            r7.<init>()     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r7 = r7.addAll(r4)     // Catch:{ Throwable -> 0x0232 }
            float r10 = r1.t     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r7 = r7.width(r10)     // Catch:{ Throwable -> 0x0232 }
            int r10 = r1.c     // Catch:{ Throwable -> 0x0232 }
            r2 = r2[r10]     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r2 = r7.setCustomTexture(r2)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.Polyline r2 = r6.addPolyline(r2)     // Catch:{ Throwable -> 0x0232 }
            goto L_0x01d2
        L_0x01b3:
            com.amap.api.maps.AMap r2 = r1.x     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r6 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0232 }
            r6.<init>()     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.addAll(r4)     // Catch:{ Throwable -> 0x0232 }
            float r7 = r1.t     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.width(r7)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.BitmapDescriptor[] r7 = r1.l     // Catch:{ Throwable -> 0x0232 }
            int r10 = r1.c     // Catch:{ Throwable -> 0x0232 }
            r7 = r7[r10]     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.setCustomTexture(r7)     // Catch:{ Throwable -> 0x0232 }
            com.amap.api.maps.model.Polyline r2 = r2.addPolyline(r6)     // Catch:{ Throwable -> 0x0232 }
        L_0x01d2:
            boolean r6 = r1.b     // Catch:{ Throwable -> 0x0232 }
            if (r6 == 0) goto L_0x01e2
            r2.remove()     // Catch:{ Throwable -> 0x0232 }
            r27.c()     // Catch:{ Throwable -> 0x0232 }
            boolean r2 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
            goto L_0x0035
        L_0x01e2:
            java.util.List<java.lang.Integer> r6 = r1.G     // Catch:{ Throwable -> 0x0232 }
            int r7 = r13.getStatus()     // Catch:{ Throwable -> 0x0232 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Throwable -> 0x0232 }
            r6.add(r7)     // Catch:{ Throwable -> 0x0232 }
            int r6 = r1.d     // Catch:{ Throwable -> 0x0232 }
            float r6 = (float) r6     // Catch:{ Throwable -> 0x0232 }
            r2.setZIndex(r6)     // Catch:{ Throwable -> 0x0232 }
            java.util.List<com.amap.api.maps.model.Polyline> r6 = r1.q     // Catch:{ Throwable -> 0x0232 }
            r6.add(r2)     // Catch:{ Throwable -> 0x0232 }
            r4.clear()     // Catch:{ Throwable -> 0x0232 }
            if (r5 == 0) goto L_0x0202
            r4.add(r5)     // Catch:{ Throwable -> 0x0232 }
        L_0x0202:
            int r11 = r11 + 1
            r12 = r17
            goto L_0x00ce
        L_0x0208:
            r10 = r7
            r12 = r17
        L_0x020b:
            int r9 = r9 + 1
            r2 = r16
            r5 = r18
            r14 = r25
            goto L_0x007b
        L_0x0215:
            r16 = r2
            r18 = r5
            r26 = r15
            int r8 = r8 + 1
            r9 = r10
            r10 = r13
            r13 = r26
            goto L_0x0067
        L_0x0223:
            boolean r2 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
            goto L_0x0035
        L_0x0229:
            boolean r2 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
            goto L_0x0035
        L_0x022f:
            r0 = move-exception
            r2 = r0
            goto L_0x023d
        L_0x0232:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ all -> 0x022f }
            boolean r2 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r2 == 0) goto L_0x0245
            goto L_0x0035
        L_0x023d:
            boolean r3 = r1.b     // Catch:{ Throwable -> 0x0250 }
            if (r3 == 0) goto L_0x0244
            r27.c()     // Catch:{ Throwable -> 0x0250 }
        L_0x0244:
            throw r2     // Catch:{ Throwable -> 0x0250 }
        L_0x0245:
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x024c
            r27.c()
        L_0x024c:
            return
        L_0x024d:
            r0 = move-exception
            r2 = r0
            goto L_0x0264
        L_0x0250:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ all -> 0x024d }
            java.lang.String r3 = "RouteOverLay"
            java.lang.String r4 = "setRouteTrafficLine(Boolean enabled)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x024d }
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x0263
            r27.c()
        L_0x0263:
            return
        L_0x0264:
            boolean r3 = r1.b
            if (r3 == 0) goto L_0x026b
            r27.c()
        L_0x026b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fs.a(java.lang.Boolean, java.util.List):void");
    }
}
