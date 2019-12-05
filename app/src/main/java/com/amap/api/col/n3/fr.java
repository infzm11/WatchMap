package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.NaviLatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: LBSRouteLine */
public final class fr {
    List<NaviLatLng> a = new ArrayList();
    public boolean b = false;
    int c = 1;
    int d = 0;
    private Marker e;
    private Marker f;
    private List<Marker> g;
    private Marker h;
    private BitmapDescriptor[] i = new BitmapDescriptor[2];
    private BitmapDescriptor[] j = new BitmapDescriptor[2];
    private BitmapDescriptor[] k = new BitmapDescriptor[2];
    private BitmapDescriptor[] l = new BitmapDescriptor[2];
    private BitmapDescriptor[] m = new BitmapDescriptor[2];
    private List<Polyline> n = new ArrayList();
    private float o = 40.0f;
    private AMapNaviPath p = null;
    private Polyline q;
    private Polyline r;
    private AMap s;
    private Context t;
    private HashMap<Integer, BitmapDescriptor[]> u = new HashMap<>();
    private List<Integer> v = new ArrayList();

    public fr(AMap aMap, AMapNaviPath aMapNaviPath, Context context) {
        this.t = context;
        this.o = (float) hq.a(context, 22);
        try {
            this.s = aMap;
            this.p = aMapNaviPath;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "init(AMap amap, AMapNaviPath aMapNaviPath)");
        }
        this.j[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_green_unselected.png");
        this.j[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_green.png");
        this.i[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_no_unselected.png");
        this.i[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture.png");
        this.k[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_slow_unselected.png");
        this.k[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_slow.png");
        this.l[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_bad_unselected.png");
        this.l[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_bad.png");
        this.m[0] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_serious_unselected.png");
        this.m[1] = BitmapDescriptorFactory.fromAsset("lbs_custtexture_grayred.png");
        this.u.put(0, this.i);
        this.u.put(1, this.j);
        this.u.put(2, this.k);
        this.u.put(3, this.l);
        this.u.put(4, this.m);
    }

    private static LatLng a(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return null;
        }
        return new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
    }

    public final void a() {
        List<NaviLatLng> list;
        LatLng latLng;
        try {
            if (this.s != null) {
                if (this.o != 0.0f) {
                    if (this.p != null) {
                        AMap aMap = this.s;
                        AMapNaviPath aMapNaviPath = this.p;
                        NaviLatLng carToFootPoint = aMapNaviPath.getCarToFootPoint();
                        ArrayList<NaviLatLng> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        this.a = new ArrayList();
                        ArrayList<NaviLatLng> arrayList3 = new ArrayList<>();
                        ArrayList arrayList4 = new ArrayList();
                        int size = aMapNaviPath.getSteps().size();
                        for (int i2 = 0; i2 < size; i2++) {
                            arrayList4.addAll(aMapNaviPath.getSteps().get(i2).getLinks());
                        }
                        if (arrayList4.size() > 0) {
                            boolean z = false;
                            for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                                AMapNaviLink aMapNaviLink = (AMapNaviLink) arrayList4.get(i3);
                                int roadClass = aMapNaviLink.getRoadClass();
                                String roadName = aMapNaviLink.getRoadName();
                                if (z || ((!roadName.equals("内部道路") && !roadName.equals("无名道路")) || roadClass != 10)) {
                                    arrayList2.addAll(aMapNaviLink.getCoords());
                                    z = true;
                                } else {
                                    arrayList.addAll(aMapNaviLink.getCoords());
                                }
                            }
                        }
                        if (carToFootPoint != null) {
                            int i4 = -1;
                            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                                NaviLatLng naviLatLng = (NaviLatLng) arrayList2.get(i5);
                                if (Math.abs(naviLatLng.getLatitude() - carToFootPoint.getLatitude()) < 5.0E-6d && Math.abs(naviLatLng.getLongitude() - carToFootPoint.getLongitude()) < 5.0E-6d) {
                                    this.a.add(naviLatLng);
                                    i4 = i5;
                                }
                                if (i4 > 0) {
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
                        if (this.q != null) {
                            this.q.remove();
                        }
                        if (this.r != null) {
                            this.r.remove();
                        }
                        this.q = aMap.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList5).color(-1811939073).width(20.0f));
                        this.r = aMap.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList6).color(-1811939073).width(20.0f));
                        if (this.a != null) {
                            d();
                            if (this.e != null) {
                                this.e.remove();
                            }
                            if (this.h != null) {
                                this.h.remove();
                            }
                            if (this.g != null && this.g.size() > 0) {
                                for (int i6 = 0; i6 < this.g.size(); i6++) {
                                    Marker marker = this.g.get(i6);
                                    if (marker != null) {
                                        marker.remove();
                                    }
                                }
                            }
                            NaviLatLng carToFootPoint2 = this.p.getCarToFootPoint();
                            if (carToFootPoint2 != null && this.f == null) {
                                this.f = this.s.addMarker(new MarkerOptions().position(a(carToFootPoint2)).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837585))));
                            }
                            LatLng latLng2 = null;
                            if (this.p.getStartPoint() == null || this.p.getEndPoint() == null) {
                                latLng = null;
                                list = null;
                            } else {
                                latLng2 = new LatLng(this.p.getStartPoint().getLatitude(), this.p.getStartPoint().getLongitude());
                                latLng = new LatLng(this.p.getEndPoint().getLatitude(), this.p.getEndPoint().getLongitude());
                                list = this.p.getWayPoint();
                            }
                            this.e = this.s.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837547))));
                            if (list != null && list.size() > 0) {
                                int size2 = list.size();
                                if (this.g == null) {
                                    this.g = new ArrayList(size2);
                                }
                                for (NaviLatLng next : list) {
                                    this.g.add(this.s.addMarker(new MarkerOptions().position(new LatLng(next.getLatitude(), next.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837546)))));
                                }
                            }
                            this.h = this.s.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837545))));
                            a(this.p.getTrafficStatuses());
                            if (this.b) {
                                b();
                                return;
                            }
                            return;
                        } else if (this.b) {
                            b();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (this.b) {
                    b();
                }
            } else if (this.b) {
                b();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.b) {
                b();
            }
            throw th2;
        }
    }

    public final void b() {
        try {
            if (this.q != null) {
                this.q.setVisible(false);
            }
            if (this.r != null) {
                this.r.setVisible(false);
            }
            if (this.f != null) {
                this.f.setVisible(false);
                this.f.remove();
            }
            if (this.e != null) {
                this.e.setVisible(false);
                this.e.remove();
            }
            if (this.h != null) {
                this.h.setVisible(false);
                this.h.remove();
            }
            if (this.g != null) {
                for (Marker visible : this.g) {
                    visible.setVisible(false);
                }
            }
            d();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "removeFromMap()");
        }
    }

    private void d() {
        if (this.n.size() > 0) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                if (this.n.get(i2) != null) {
                    this.n.get(i2).remove();
                }
            }
        }
        this.n.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x015a A[Catch:{ Throwable -> 0x01f5, all -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0178 A[Catch:{ Throwable -> 0x01f5, all -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a9 A[SYNTHETIC, Splitter:B:67:0x01a9] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x019b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.List<com.amap.api.navi.model.AMapTrafficStatus> r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            if (r2 == 0) goto L_0x020a
            int r3 = r27.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r3 > 0) goto L_0x000e
            goto L_0x020a
        L_0x000e:
            com.amap.api.navi.model.AMapNaviPath r3 = r1.p     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.NaviLatLng r3 = r3.getCarToFootPoint()     // Catch:{ Throwable -> 0x01f5 }
            java.util.List<java.lang.Integer> r4 = r1.v     // Catch:{ Throwable -> 0x01f5 }
            if (r4 == 0) goto L_0x001d
            java.util.List<java.lang.Integer> r4 = r1.v     // Catch:{ Throwable -> 0x01f5 }
            r4.clear()     // Catch:{ Throwable -> 0x01f5 }
        L_0x001d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Throwable -> 0x01f5 }
            r4.<init>()     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.AMapNaviPath r5 = r1.p     // Catch:{ Throwable -> 0x01f5 }
            java.util.List r5 = r5.getSteps()     // Catch:{ Throwable -> 0x01f5 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x002e:
            int r14 = r5.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r8 >= r14) goto L_0x01ea
            java.lang.Object r14 = r5.get(r8)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.AMapNaviStep r14 = (com.amap.api.navi.model.AMapNaviStep) r14     // Catch:{ Throwable -> 0x01f5 }
            java.util.List r14 = r14.getLinks()     // Catch:{ Throwable -> 0x01f5 }
            r15 = r13
            r13 = r11
            r11 = r9
            r9 = 0
        L_0x0042:
            int r6 = r14.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r9 >= r6) goto L_0x01dc
            int r6 = r27.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r10 >= r6) goto L_0x0055
            java.lang.Object r6 = r2.get(r10)     // Catch:{ Throwable -> 0x01f5 }
            r13 = r6
            com.amap.api.navi.model.AMapTrafficStatus r13 = (com.amap.api.navi.model.AMapTrafficStatus) r13     // Catch:{ Throwable -> 0x01f5 }
        L_0x0055:
            java.lang.Object r6 = r14.get(r9)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.AMapNaviLink r6 = (com.amap.api.navi.model.AMapNaviLink) r6     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r6.getRoadClass()     // Catch:{ Throwable -> 0x01f5 }
            java.lang.String r2 = r6.getRoadName()     // Catch:{ Throwable -> 0x01f5 }
            r16 = 1
            if (r12 != 0) goto L_0x009b
            r17 = r5
            java.lang.String r5 = "内部道路"
            boolean r5 = r2.equals(r5)     // Catch:{ Throwable -> 0x01f5 }
            if (r5 != 0) goto L_0x0079
            java.lang.String r5 = "无名道路"
            boolean r2 = r2.equals(r5)     // Catch:{ Throwable -> 0x01f5 }
            if (r2 == 0) goto L_0x009d
        L_0x0079:
            r2 = 10
            if (r7 != r2) goto L_0x009d
            int r2 = r6.getLength()     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r11 + r2
            int r2 = r13.getLength()     // Catch:{ Throwable -> 0x01f5 }
            int r2 = r7 - r2
            int r2 = java.lang.Math.abs(r2)     // Catch:{ Throwable -> 0x01f5 }
            if (r2 > 0) goto L_0x0096
            int r10 = r10 + 1
            r24 = r14
        L_0x0093:
            r11 = 0
            goto L_0x01d2
        L_0x0096:
            r11 = r7
            r24 = r14
            goto L_0x01d2
        L_0x009b:
            r17 = r5
        L_0x009d:
            r2 = 0
            r5 = 0
        L_0x009f:
            if (r15 != 0) goto L_0x0128
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r7.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r2 >= r7) goto L_0x0128
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x01f5 }
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x01f5 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.NaviLatLng r7 = (com.amap.api.navi.model.NaviLatLng) r7     // Catch:{ Throwable -> 0x01f5 }
            double r19 = r7.getLatitude()     // Catch:{ Throwable -> 0x01f5 }
            java.util.List r7 = r6.getCoords()     // Catch:{ Throwable -> 0x01f5 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.navi.model.NaviLatLng r7 = (com.amap.api.navi.model.NaviLatLng) r7     // Catch:{ Throwable -> 0x01f5 }
            double r21 = r7.getLongitude()     // Catch:{ Throwable -> 0x01f5 }
            r23 = 0
            r18 = r5
            r18.<init>(r19, r21, r23)     // Catch:{ Throwable -> 0x01f5 }
            if (r3 == 0) goto L_0x0101
            r24 = r14
            r25 = r15
            double r14 = r5.latitude     // Catch:{ Throwable -> 0x01f5 }
            double r18 = r3.getLatitude()     // Catch:{ Throwable -> 0x01f5 }
            double r14 = r14 - r18
            double r14 = java.lang.Math.abs(r14)     // Catch:{ Throwable -> 0x01f5 }
            r18 = 4527516983983565041(0x3ed4f8b588e368f1, double:5.0E-6)
            int r7 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r7 >= 0) goto L_0x0105
            double r14 = r5.longitude     // Catch:{ Throwable -> 0x01f5 }
            double r20 = r3.getLongitude()     // Catch:{ Throwable -> 0x01f5 }
            double r14 = r14 - r20
            double r14 = java.lang.Math.abs(r14)     // Catch:{ Throwable -> 0x01f5 }
            int r7 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r7 >= 0) goto L_0x0105
            r4.add(r5)     // Catch:{ Throwable -> 0x01f5 }
            r15 = r16
            goto L_0x012e
        L_0x0101:
            r24 = r14
            r25 = r15
        L_0x0105:
            int r7 = r4.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r7 == 0) goto L_0x011d
            int r7 = r4.size()     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r7 + -1
            java.lang.Object r7 = r4.get(r7)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.LatLng r7 = (com.amap.api.maps.model.LatLng) r7     // Catch:{ Throwable -> 0x01f5 }
            boolean r7 = r7.equals(r5)     // Catch:{ Throwable -> 0x01f5 }
            if (r7 != 0) goto L_0x0120
        L_0x011d:
            r4.add(r5)     // Catch:{ Throwable -> 0x01f5 }
        L_0x0120:
            int r2 = r2 + 1
            r14 = r24
            r15 = r25
            goto L_0x009f
        L_0x0128:
            r24 = r14
            r25 = r15
            r15 = r25
        L_0x012e:
            int r2 = r6.getLength()     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r11 + r2
            if (r15 != 0) goto L_0x0142
            int r2 = r13.getLength()     // Catch:{ Throwable -> 0x01f5 }
            int r2 = r7 - r2
            int r2 = java.lang.Math.abs(r2)     // Catch:{ Throwable -> 0x01f5 }
            if (r2 > 0) goto L_0x01cf
        L_0x0142:
            int r2 = r4.size()     // Catch:{ Throwable -> 0x01f5 }
            if (r2 <= 0) goto L_0x01cf
            java.util.HashMap<java.lang.Integer, com.amap.api.maps.model.BitmapDescriptor[]> r2 = r1.u     // Catch:{ Throwable -> 0x01f5 }
            int r6 = r13.getStatus()     // Catch:{ Throwable -> 0x01f5 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x01f5 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.BitmapDescriptor[] r2 = (com.amap.api.maps.model.BitmapDescriptor[]) r2     // Catch:{ Throwable -> 0x01f5 }
            if (r2 == 0) goto L_0x0178
            com.amap.api.maps.AMap r6 = r1.s     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r7 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x01f5 }
            r7.<init>()     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r7 = r7.addAll(r4)     // Catch:{ Throwable -> 0x01f5 }
            float r11 = r1.o     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r7 = r7.width(r11)     // Catch:{ Throwable -> 0x01f5 }
            int r11 = r1.c     // Catch:{ Throwable -> 0x01f5 }
            r2 = r2[r11]     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r2 = r7.setCustomTexture(r2)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.Polyline r2 = r6.addPolyline(r2)     // Catch:{ Throwable -> 0x01f5 }
            goto L_0x0197
        L_0x0178:
            com.amap.api.maps.AMap r2 = r1.s     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r6 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x01f5 }
            r6.<init>()     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.addAll(r4)     // Catch:{ Throwable -> 0x01f5 }
            float r7 = r1.o     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.width(r7)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.BitmapDescriptor[] r7 = r1.i     // Catch:{ Throwable -> 0x01f5 }
            int r11 = r1.c     // Catch:{ Throwable -> 0x01f5 }
            r7 = r7[r11]     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.PolylineOptions r6 = r6.setCustomTexture(r7)     // Catch:{ Throwable -> 0x01f5 }
            com.amap.api.maps.model.Polyline r2 = r2.addPolyline(r6)     // Catch:{ Throwable -> 0x01f5 }
        L_0x0197:
            boolean r6 = r1.b     // Catch:{ Throwable -> 0x01f5 }
            if (r6 == 0) goto L_0x01a9
            r2.remove()     // Catch:{ Throwable -> 0x01f5 }
            r26.b()     // Catch:{ Throwable -> 0x01f5 }
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x01a8
            r26.b()
        L_0x01a8:
            return
        L_0x01a9:
            java.util.List<java.lang.Integer> r6 = r1.v     // Catch:{ Throwable -> 0x01f5 }
            int r7 = r13.getStatus()     // Catch:{ Throwable -> 0x01f5 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Throwable -> 0x01f5 }
            r6.add(r7)     // Catch:{ Throwable -> 0x01f5 }
            int r6 = r1.d     // Catch:{ Throwable -> 0x01f5 }
            float r6 = (float) r6     // Catch:{ Throwable -> 0x01f5 }
            r2.setZIndex(r6)     // Catch:{ Throwable -> 0x01f5 }
            java.util.List<com.amap.api.maps.model.Polyline> r6 = r1.n     // Catch:{ Throwable -> 0x01f5 }
            r6.add(r2)     // Catch:{ Throwable -> 0x01f5 }
            r4.clear()     // Catch:{ Throwable -> 0x01f5 }
            if (r5 == 0) goto L_0x01c9
            r4.add(r5)     // Catch:{ Throwable -> 0x01f5 }
        L_0x01c9:
            int r10 = r10 + 1
            r12 = r16
            goto L_0x0093
        L_0x01cf:
            r11 = r7
            r12 = r16
        L_0x01d2:
            int r9 = r9 + 1
            r5 = r17
            r14 = r24
            r2 = r27
            goto L_0x0042
        L_0x01dc:
            r17 = r5
            r25 = r15
            int r8 = r8 + 1
            r9 = r11
            r11 = r13
            r13 = r25
            r2 = r27
            goto L_0x002e
        L_0x01ea:
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x01f1
            r26.b()
        L_0x01f1:
            return
        L_0x01f2:
            r0 = move-exception
            r2 = r0
            goto L_0x0202
        L_0x01f5:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ all -> 0x01f2 }
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x0201
            r26.b()
        L_0x0201:
            return
        L_0x0202:
            boolean r3 = r1.b
            if (r3 == 0) goto L_0x0209
            r26.b()
        L_0x0209:
            throw r2
        L_0x020a:
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x0211
            r26.b()
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fr.a(java.util.List):void");
    }

    public final void c() {
        try {
            this.b = true;
            if (this.q != null) {
                this.q.remove();
            }
            if (this.r != null) {
                this.r.remove();
            }
            this.p = null;
            if (this.j != null && this.j.length > 1) {
                this.j[0].recycle();
                this.j[1].recycle();
            }
            if (this.i != null && this.i.length > 1) {
                this.i[0].recycle();
                this.i[1].recycle();
            }
            if (this.k != null && this.k.length > 1) {
                this.k[0].recycle();
                this.k[1].recycle();
            }
            if (this.l != null && this.l.length > 1) {
                this.l[0].recycle();
                this.l[1].recycle();
            }
            if (this.m != null && this.m.length > 1) {
                this.m[0].recycle();
                this.m[1].recycle();
            }
            if (this.u != null) {
                this.u.clear();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "destroy()");
        }
    }

    public final void a(int i2) {
        if (i2 <= 0) {
            i2 = 0;
        } else if (i2 > 0) {
            i2 = 1;
        }
        try {
            this.c = i2;
            int size = this.v.size();
            int size2 = this.n.size();
            int i3 = 0;
            while (size == size2 && i3 < size2) {
                BitmapDescriptor[] bitmapDescriptorArr = this.u.get(Integer.valueOf(this.v.get(i3).intValue()));
                if (!this.n.get(i3).getOptions().getCustomTexture().equals(bitmapDescriptorArr[this.c])) {
                    this.n.get(i3).setCustomTexture(bitmapDescriptorArr[this.c]);
                }
                i3++;
            }
            if (this.q != null && this.r != null) {
                if (i2 == 1) {
                    this.q.setVisible(true);
                    this.r.setVisible(true);
                    return;
                }
                this.q.setVisible(false);
                this.r.setVisible(false);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(int i2) {
        this.d = i2;
        try {
            if (this.n != null) {
                for (int i3 = 0; i3 < this.n.size(); i3++) {
                    this.n.get(i3).setZIndex((float) i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
