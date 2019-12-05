package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.internal.view.SupportMenu;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.hs;
import com.amap.api.col.n3.iu;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.AMapNaviException;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.RouteOverlayOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class RouteOverLay {
    private AMap aMap;
    private int arrowColor;
    private BitmapDescriptor arrowOnRoute = null;
    private boolean emulateGPSLocationVisibility = true;
    private Bitmap endBitmap;
    private BitmapDescriptor endBitmapDescriptor;
    private Marker endMarker;
    private List<Circle> gpsCircles = null;
    private Polyline guideLink = null;
    private boolean isTrafficLine = true;
    private BitmapDescriptor jamTraffic = null;
    private AMapNaviPath mAMapNaviPath = null;
    private Context mContext;
    private List<Polyline> mCustomPolylines = new ArrayList();
    private Polyline mDefaultPolyline;
    private List<LatLng> mLatLngsOfPath;
    private RouteOverlayOptions mRouteOverlayOptions = null;
    private List<Polyline> mTrafficColorfulPolylines = new ArrayList();
    private float mWidth = 40.0f;
    private NavigateArrow naviArrow = null;
    private BitmapDescriptor normalRoute = null;
    private BitmapDescriptor slowTraffic = null;
    private BitmapDescriptor smoothTraffic = null;
    private Bitmap startBitmap;
    private BitmapDescriptor startBitmapDescriptor;
    private Marker startMarker;
    private BitmapDescriptor unknownTraffic = null;
    private BitmapDescriptor veryJamTraffic = null;
    private Bitmap wayBitmap;
    private List<Marker> wayMarkers;
    private BitmapDescriptor wayPointBitmapDescriptor;

    public RouteOverLay(AMap aMap2, AMapNaviPath aMapNaviPath, Context context) {
        try {
            this.arrowColor = Color.parseColor("#4DF6CC");
            this.mContext = context;
            this.mWidth = (float) hq.a(context, 22);
            init(aMap2, aMapNaviPath);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setWidth(float f) throws AMapNaviException {
        if (f > 0.0f) {
            this.mWidth = f;
        }
    }

    public RouteOverlayOptions getRouteOverlayOptions() {
        return this.mRouteOverlayOptions;
    }

    public void setRouteOverlayOptions(RouteOverlayOptions routeOverlayOptions) {
        try {
            this.mRouteOverlayOptions = routeOverlayOptions;
            if (!(routeOverlayOptions == null || routeOverlayOptions.getNormalRoute() == null)) {
                this.normalRoute = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getNormalRoute());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getArrowOnTrafficRoute() == null)) {
                this.arrowOnRoute = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getArrowOnTrafficRoute());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getUnknownTraffic() == null)) {
                this.unknownTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getUnknownTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getSmoothTraffic() == null)) {
                this.smoothTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getSmoothTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getSlowTraffic() == null)) {
                this.slowTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getSlowTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getJamTraffic() == null)) {
                this.jamTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getJamTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getVeryJamTraffic() == null)) {
                this.veryJamTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getVeryJamTraffic());
            }
            if (routeOverlayOptions != null && routeOverlayOptions.getLineWidth() > 0.0f) {
                this.mWidth = routeOverlayOptions.getLineWidth();
            }
            if (routeOverlayOptions != null && routeOverlayOptions.getArrowColor() != this.arrowColor) {
                this.arrowColor = routeOverlayOptions.getArrowColor();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviPath getAMapNaviPath() {
        return this.mAMapNaviPath;
    }

    public void setAMapNaviPath(AMapNaviPath aMapNaviPath) {
        this.mAMapNaviPath = aMapNaviPath;
    }

    @Deprecated
    public void setRouteInfo(AMapNaviPath aMapNaviPath) {
        this.mAMapNaviPath = aMapNaviPath;
    }

    private void init(AMap aMap2, AMapNaviPath aMapNaviPath) {
        try {
            this.aMap = aMap2;
            this.mAMapNaviPath = aMapNaviPath;
            this.normalRoute = BitmapDescriptorFactory.fromAsset("custtexture.png");
        } catch (Throwable th) {
            th.printStackTrace();
            return;
        }
        this.arrowOnRoute = BitmapDescriptorFactory.fromAsset("custtexture_aolr.png");
        this.smoothTraffic = BitmapDescriptorFactory.fromAsset("custtexture_green.png");
        this.unknownTraffic = BitmapDescriptorFactory.fromAsset("custtexture_no.png");
        this.slowTraffic = BitmapDescriptorFactory.fromAsset("custtexture_slow.png");
        this.jamTraffic = BitmapDescriptorFactory.fromAsset("custtexture_bad.png");
        this.veryJamTraffic = BitmapDescriptorFactory.fromAsset("custtexture_grayred.png");
    }

    public void addToMap() {
        List<NaviLatLng> list;
        LatLng latLng;
        LatLng latLng2;
        Marker marker;
        try {
            if (this.aMap != null) {
                if (this.mDefaultPolyline != null) {
                    this.mDefaultPolyline.remove();
                    this.mDefaultPolyline = null;
                }
                if (this.mWidth == 0.0f) {
                    return;
                }
                if (this.mAMapNaviPath != null) {
                    if (this.naviArrow != null) {
                        this.naviArrow.setVisible(false);
                    }
                    List<NaviLatLng> coordList = this.mAMapNaviPath.getCoordList();
                    if (coordList != null) {
                        this.mLatLngsOfPath = new ArrayList(coordList.size());
                        for (NaviLatLng next : coordList) {
                            LatLng latLng3 = new LatLng(next.getLatitude(), next.getLongitude(), false);
                            this.mLatLngsOfPath.add(latLng3);
                        }
                        if (this.mLatLngsOfPath.size() != 0) {
                            clearTrafficLineAndInvisibleOriginalLine();
                            this.mDefaultPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(this.mLatLngsOfPath).setCustomTexture(this.normalRoute).width(this.mWidth - 5.0f));
                            this.mDefaultPolyline.setVisible(true);
                            if (this.mAMapNaviPath.getStartPoint() == null || this.mAMapNaviPath.getEndPoint() == null) {
                                latLng2 = null;
                                latLng = null;
                                list = null;
                            } else {
                                latLng2 = new LatLng(this.mAMapNaviPath.getStartPoint().getLatitude(), this.mAMapNaviPath.getStartPoint().getLongitude());
                                latLng = new LatLng(this.mAMapNaviPath.getEndPoint().getLatitude(), this.mAMapNaviPath.getEndPoint().getLongitude());
                                list = this.mAMapNaviPath.getWayPoint();
                            }
                            if (this.startMarker != null) {
                                this.startMarker.remove();
                                this.startMarker = null;
                            }
                            if (this.endMarker != null) {
                                this.endMarker.remove();
                                this.endMarker = null;
                            }
                            if (this.wayMarkers != null && this.wayMarkers.size() > 0) {
                                for (int i = 0; i < this.wayMarkers.size(); i++) {
                                    Marker marker2 = this.wayMarkers.get(i);
                                    if (marker2 != null) {
                                        marker2.remove();
                                    }
                                }
                            }
                            if (this.startBitmap == null) {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837754))));
                            } else if (this.startBitmapDescriptor != null) {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(this.startBitmapDescriptor));
                            }
                            if (list != null && list.size() > 0) {
                                int size = list.size();
                                if (this.wayMarkers == null) {
                                    this.wayMarkers = new ArrayList(size);
                                }
                                for (NaviLatLng next2 : list) {
                                    LatLng latLng4 = new LatLng(next2.getLatitude(), next2.getLongitude());
                                    if (this.wayBitmap == null) {
                                        marker = this.aMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837764))));
                                    } else {
                                        marker = this.wayPointBitmapDescriptor != null ? this.aMap.addMarker(new MarkerOptions().position(latLng4).icon(this.wayPointBitmapDescriptor)) : null;
                                    }
                                    this.wayMarkers.add(marker);
                                }
                            }
                            if (this.endBitmap == null) {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837584))));
                            } else if (this.endBitmapDescriptor != null) {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(this.endBitmapDescriptor));
                            }
                            if (this.isTrafficLine) {
                                setTrafficLine(Boolean.valueOf(this.isTrafficLine));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "addToMap()");
        }
    }

    public void drawGuideLink(LatLng latLng, LatLng latLng2, boolean z) {
        if (z) {
            try {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(latLng);
                arrayList.add(latLng2);
                if (this.guideLink == null) {
                    this.guideLink = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth / 3.0f).setDottedLine(true));
                } else {
                    this.guideLink.setPoints(arrayList);
                }
                this.guideLink.setVisible(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (this.guideLink != null) {
            this.guideLink.setVisible(false);
        }
    }

    public void drawEmulateGPSLocation(Vector<String> vector) {
        try {
            if (this.gpsCircles == null) {
                this.gpsCircles = new ArrayList(vector.size());
            } else {
                for (Circle remove : this.gpsCircles) {
                    remove.remove();
                }
                this.gpsCircles.clear();
            }
            Iterator<String> it = vector.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(",");
                if (split != null && split.length >= 11) {
                    this.gpsCircles.add(this.aMap.addCircle(new CircleOptions().center(new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]))).radius(1.5d).strokeWidth(0.0f).fillColor(SupportMenu.CATEGORY_MASK)));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RouteOverLay", "drawEmulateGPSLocation(Vector<String> gpsData)");
        }
    }

    public void setEmulateGPSLocationVisible() {
        try {
            if (this.gpsCircles != null) {
                this.emulateGPSLocationVisibility = !this.emulateGPSLocationVisibility;
                for (Circle visible : this.gpsCircles) {
                    visible.setVisible(this.emulateGPSLocationVisibility);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        try {
            this.startBitmap = bitmap;
            if (this.startBitmap != null) {
                this.startBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.startBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWayPointBitmap(Bitmap bitmap) {
        try {
            this.wayBitmap = bitmap;
            if (this.wayBitmap != null) {
                this.wayPointBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.wayBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setEndPointBitmap(Bitmap bitmap) {
        try {
            this.endBitmap = bitmap;
            if (this.endBitmap != null) {
                this.endBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.endBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeFromMap() {
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.setVisible(false);
            }
            if (this.startMarker != null) {
                this.startMarker.setVisible(false);
            }
            if (this.wayMarkers != null) {
                for (Marker visible : this.wayMarkers) {
                    visible.setVisible(false);
                }
            }
            if (this.endMarker != null) {
                this.endMarker.setVisible(false);
            }
            if (this.naviArrow != null) {
                this.naviArrow.remove();
            }
            if (this.guideLink != null) {
                this.guideLink.setVisible(false);
            }
            if (this.gpsCircles != null) {
                for (Circle visible2 : this.gpsCircles) {
                    visible2.setVisible(false);
                }
            }
            clearTrafficLineAndInvisibleOriginalLine();
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "removeFromMap()");
        }
    }

    private void clearTrafficLineAndInvisibleOriginalLine() {
        if (this.mTrafficColorfulPolylines.size() > 0) {
            for (int i = 0; i < this.mTrafficColorfulPolylines.size(); i++) {
                if (this.mTrafficColorfulPolylines.get(i) != null) {
                    this.mTrafficColorfulPolylines.get(i).remove();
                }
            }
        }
        this.mTrafficColorfulPolylines.clear();
        if (this.mDefaultPolyline != null) {
            this.mDefaultPolyline.setVisible(false);
        }
        if (this.mCustomPolylines.size() > 0) {
            for (int i2 = 0; i2 < this.mCustomPolylines.size(); i2++) {
                if (this.mCustomPolylines.get(i2) != null) {
                    this.mCustomPolylines.get(i2).setVisible(false);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x014d, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014e, code lost:
        r1.mTrafficColorfulPolylines.add(r13);
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0156, code lost:
        if (r5 == null) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0158, code lost:
        r3.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015b, code lost:
        r9 = r9 + 1;
        r10 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void colorWayUpdate(java.util.List<com.amap.api.navi.model.AMapTrafficStatus> r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            com.amap.api.maps.AMap r3 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            if (r3 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r2 == 0) goto L_0x018f
            int r3 = r23.size()     // Catch:{ Throwable -> 0x0190 }
            if (r3 > 0) goto L_0x0013
            goto L_0x018f
        L_0x0013:
            r22.clearTrafficLineAndInvisibleOriginalLine()     // Catch:{ Throwable -> 0x0190 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0190 }
            r3.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.AMapNaviPath r4 = r1.mAMapNaviPath     // Catch:{ Throwable -> 0x0190 }
            java.util.List r4 = r4.getSteps()     // Catch:{ Throwable -> 0x0190 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0026:
            int r12 = r4.size()     // Catch:{ Throwable -> 0x0190 }
            if (r7 >= r12) goto L_0x016c
            java.lang.Object r12 = r4.get(r7)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.AMapNaviStep r12 = (com.amap.api.navi.model.AMapNaviStep) r12     // Catch:{ Throwable -> 0x0190 }
            java.util.List r12 = r12.getLinks()     // Catch:{ Throwable -> 0x0190 }
            r13 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = 0
        L_0x003b:
            int r14 = r12.size()     // Catch:{ Throwable -> 0x0190 }
            if (r8 >= r14) goto L_0x0164
            int r14 = r23.size()     // Catch:{ Throwable -> 0x0190 }
            if (r9 >= r14) goto L_0x004d
            java.lang.Object r11 = r2.get(r9)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.AMapTrafficStatus r11 = (com.amap.api.navi.model.AMapTrafficStatus) r11     // Catch:{ Throwable -> 0x0190 }
        L_0x004d:
            java.lang.Object r14 = r12.get(r8)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.AMapNaviLink r14 = (com.amap.api.navi.model.AMapNaviLink) r14     // Catch:{ Throwable -> 0x0190 }
            r5 = 0
            r15 = 0
        L_0x0055:
            java.util.List r6 = r14.getCoords()     // Catch:{ Throwable -> 0x0190 }
            int r6 = r6.size()     // Catch:{ Throwable -> 0x0190 }
            if (r15 >= r6) goto L_0x00a2
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0190 }
            java.util.List r6 = r14.getCoords()     // Catch:{ Throwable -> 0x0190 }
            java.lang.Object r6 = r6.get(r15)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.NaviLatLng r6 = (com.amap.api.navi.model.NaviLatLng) r6     // Catch:{ Throwable -> 0x0190 }
            double r17 = r6.getLatitude()     // Catch:{ Throwable -> 0x0190 }
            java.util.List r6 = r14.getCoords()     // Catch:{ Throwable -> 0x0190 }
            java.lang.Object r6 = r6.get(r15)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.navi.model.NaviLatLng r6 = (com.amap.api.navi.model.NaviLatLng) r6     // Catch:{ Throwable -> 0x0190 }
            double r19 = r6.getLongitude()     // Catch:{ Throwable -> 0x0190 }
            r21 = 0
            r16 = r5
            r16.<init>(r17, r19, r21)     // Catch:{ Throwable -> 0x0190 }
            int r6 = r3.size()     // Catch:{ Throwable -> 0x0190 }
            if (r6 == 0) goto L_0x009c
            int r6 = r3.size()     // Catch:{ Throwable -> 0x0190 }
            int r6 = r6 + -1
            java.lang.Object r6 = r3.get(r6)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.LatLng r6 = (com.amap.api.maps.model.LatLng) r6     // Catch:{ Throwable -> 0x0190 }
            boolean r6 = r6.equals(r5)     // Catch:{ Throwable -> 0x0190 }
            if (r6 != 0) goto L_0x009f
        L_0x009c:
            r3.add(r5)     // Catch:{ Throwable -> 0x0190 }
        L_0x009f:
            int r15 = r15 + 1
            goto L_0x0055
        L_0x00a2:
            int r6 = r14.getLength()     // Catch:{ Throwable -> 0x0190 }
            int r6 = r6 + r10
            int r10 = r11.getLength()     // Catch:{ Throwable -> 0x0190 }
            int r10 = r6 - r10
            int r10 = java.lang.Math.abs(r10)     // Catch:{ Throwable -> 0x0190 }
            if (r10 > 0) goto L_0x015f
            int r10 = r3.size()     // Catch:{ Throwable -> 0x0190 }
            if (r10 <= 0) goto L_0x015f
            int r6 = r11.getStatus()     // Catch:{ Throwable -> 0x0190 }
            switch(r6) {
                case 0: goto L_0x0132;
                case 1: goto L_0x0116;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00de;
                case 4: goto L_0x00c2;
                default: goto L_0x00c0;
            }     // Catch:{ Throwable -> 0x0190 }
        L_0x00c0:
            goto L_0x014e
        L_0x00c2:
            com.amap.api.maps.AMap r6 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r10.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.addAll(r3)     // Catch:{ Throwable -> 0x0190 }
            float r13 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.width(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r13 = r1.veryJamTraffic     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.setCustomTexture(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r6 = r6.addPolyline(r10)     // Catch:{ Throwable -> 0x0190 }
            goto L_0x014d
        L_0x00de:
            com.amap.api.maps.AMap r6 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r10.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.addAll(r3)     // Catch:{ Throwable -> 0x0190 }
            float r13 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.width(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r13 = r1.jamTraffic     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.setCustomTexture(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r6 = r6.addPolyline(r10)     // Catch:{ Throwable -> 0x0190 }
            goto L_0x014d
        L_0x00fa:
            com.amap.api.maps.AMap r6 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r10.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.addAll(r3)     // Catch:{ Throwable -> 0x0190 }
            float r13 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.width(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r13 = r1.slowTraffic     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.setCustomTexture(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r6 = r6.addPolyline(r10)     // Catch:{ Throwable -> 0x0190 }
            goto L_0x014d
        L_0x0116:
            com.amap.api.maps.AMap r6 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r10.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.addAll(r3)     // Catch:{ Throwable -> 0x0190 }
            float r13 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.width(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r13 = r1.smoothTraffic     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.setCustomTexture(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r6 = r6.addPolyline(r10)     // Catch:{ Throwable -> 0x0190 }
            goto L_0x014d
        L_0x0132:
            com.amap.api.maps.AMap r6 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r10.<init>()     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.addAll(r3)     // Catch:{ Throwable -> 0x0190 }
            float r13 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.width(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r13 = r1.unknownTraffic     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r10 = r10.setCustomTexture(r13)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r6 = r6.addPolyline(r10)     // Catch:{ Throwable -> 0x0190 }
        L_0x014d:
            r13 = r6
        L_0x014e:
            java.util.List<com.amap.api.maps.model.Polyline> r6 = r1.mTrafficColorfulPolylines     // Catch:{ Throwable -> 0x0190 }
            r6.add(r13)     // Catch:{ Throwable -> 0x0190 }
            r3.clear()     // Catch:{ Throwable -> 0x0190 }
            if (r5 == 0) goto L_0x015b
            r3.add(r5)     // Catch:{ Throwable -> 0x0190 }
        L_0x015b:
            int r9 = r9 + 1
            r10 = 0
            goto L_0x0160
        L_0x015f:
            r10 = r6
        L_0x0160:
            int r8 = r8 + 1
            goto L_0x003b
        L_0x0164:
            int r7 = r7 + 1
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            goto L_0x0026
        L_0x016c:
            com.amap.api.maps.AMap r2 = r1.aMap     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r3 = new com.amap.api.maps.model.PolylineOptions     // Catch:{ Throwable -> 0x0190 }
            r3.<init>()     // Catch:{ Throwable -> 0x0190 }
            java.util.List<com.amap.api.maps.model.LatLng> r4 = r1.mLatLngsOfPath     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r3 = r3.addAll(r4)     // Catch:{ Throwable -> 0x0190 }
            float r4 = r1.mWidth     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r3 = r3.width(r4)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.BitmapDescriptor r4 = r1.arrowOnRoute     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.PolylineOptions r3 = r3.setCustomTexture(r4)     // Catch:{ Throwable -> 0x0190 }
            com.amap.api.maps.model.Polyline r2 = r2.addPolyline(r3)     // Catch:{ Throwable -> 0x0190 }
            java.util.List<com.amap.api.maps.model.Polyline> r3 = r1.mTrafficColorfulPolylines     // Catch:{ Throwable -> 0x0190 }
            r3.add(r2)     // Catch:{ Throwable -> 0x0190 }
            return
        L_0x018f:
            return
        L_0x0190:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.RouteOverLay.colorWayUpdate(java.util.List):void");
    }

    public void zoomToSpan() {
        try {
            zoomToSpan(100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan(int i) {
        try {
            if (this.mAMapNaviPath != null) {
                this.aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(this.mAMapNaviPath.getBoundsForPath(), i), 1000, (AMap.CancelableCallback) null);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "zoomToSpan()");
        }
    }

    public void zoomToSpan(int i, AMapNaviPath aMapNaviPath) {
        if (aMapNaviPath != null) {
            try {
                this.aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(aMapNaviPath.getBoundsForPath(), i), 1000, (AMap.CancelableCallback) null);
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "RouteOverLay", "zoomToSpan()");
            }
        }
    }

    public void destroy() {
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.remove();
            }
            this.mAMapNaviPath = null;
            if (this.arrowOnRoute != null) {
                this.arrowOnRoute.recycle();
            }
            if (this.smoothTraffic != null) {
                this.smoothTraffic.recycle();
            }
            if (this.unknownTraffic != null) {
                this.unknownTraffic.recycle();
            }
            if (this.slowTraffic != null) {
                this.slowTraffic.recycle();
            }
            if (this.jamTraffic != null) {
                this.jamTraffic.recycle();
            }
            if (this.veryJamTraffic != null) {
                this.veryJamTraffic.recycle();
            }
            if (this.startBitmap != null) {
                this.startBitmap.recycle();
            }
            if (this.endBitmap != null) {
                this.endBitmap.recycle();
            }
            if (this.wayBitmap != null) {
                this.wayBitmap.recycle();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "RouteOverLay", "destroy()");
        }
    }

    public void drawArrow(List<NaviLatLng> list) {
        if (list == null) {
            try {
                this.naviArrow.setVisible(false);
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
            if (this.naviArrow == null) {
                this.naviArrow = this.aMap.addNavigateArrow(new NavigateArrowOptions().addAll(arrayList).topColor(this.arrowColor).width(this.mWidth * 0.4f));
            } else {
                this.naviArrow.setPoints(arrayList);
            }
            this.naviArrow.setZIndex(1.0f);
            this.naviArrow.setVisible(true);
        }
    }

    public List<NaviLatLng> getArrowPoints(int i) {
        if (this.mAMapNaviPath == null) {
            return null;
        }
        try {
            if (i >= this.mAMapNaviPath.getStepsCount()) {
                return null;
            }
            List<NaviLatLng> coordList = this.mAMapNaviPath.getCoordList();
            int size = coordList.size();
            int endIndex = this.mAMapNaviPath.getSteps().get(i).getEndIndex();
            NaviLatLng naviLatLng = coordList.get(endIndex);
            Vector vector = new Vector();
            int i2 = endIndex - 1;
            int i3 = 0;
            NaviLatLng naviLatLng2 = naviLatLng;
            int i4 = 0;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                NaviLatLng naviLatLng3 = coordList.get(i2);
                int a = hq.a(naviLatLng2, naviLatLng3);
                i4 += a;
                if (i4 >= 50) {
                    vector.add(hq.a(naviLatLng2, naviLatLng3, (double) ((a + 50) - i4)));
                    break;
                }
                vector.add(naviLatLng3);
                i2--;
                naviLatLng2 = naviLatLng3;
            }
            Collections.reverse(vector);
            vector.add(naviLatLng);
            int i5 = endIndex + 1;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                NaviLatLng naviLatLng4 = coordList.get(i5);
                int a2 = hq.a(naviLatLng, naviLatLng4);
                i3 += a2;
                if (i3 >= 50) {
                    vector.add(hq.a(naviLatLng, naviLatLng4, (double) ((50 + a2) - i3)));
                    break;
                }
                vector.add(naviLatLng4);
                i5++;
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

    public boolean isTrafficLine() {
        return this.isTrafficLine;
    }

    public void setTrafficLine(Boolean bool) {
        try {
            if (this.mContext != null) {
                this.isTrafficLine = bool.booleanValue();
                List<AMapTrafficStatus> list = null;
                clearTrafficLineAndInvisibleOriginalLine();
                if (this.isTrafficLine) {
                    if (this.mAMapNaviPath != null) {
                        list = this.mAMapNaviPath.getTrafficStatuses();
                    }
                    if (list != null) {
                        if (list.size() != 0) {
                            colorWayUpdate(list);
                            return;
                        }
                    }
                    NoTrafficStatusDisplay();
                    return;
                }
                NoTrafficStatusDisplay();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "RouteOverLay", "setTrafficLine(Boolean enabled)");
        }
    }

    private void NoTrafficStatusDisplay() {
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.setVisible(true);
            }
            if (this.mCustomPolylines.size() > 0) {
                for (int i = 0; i < this.mCustomPolylines.size(); i++) {
                    if (this.mCustomPolylines.get(i) != null) {
                        this.mCustomPolylines.get(i).setVisible(true);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addToMap(int[] iArr, int[] iArr2, BitmapDescriptor[] bitmapDescriptorArr) {
        int i;
        List<NaviLatLng> list;
        LatLng latLng;
        LatLng latLng2;
        Marker marker;
        Polyline polyline;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        BitmapDescriptor[] bitmapDescriptorArr2 = bitmapDescriptorArr;
        try {
            if (this.aMap != null) {
                if (this.mDefaultPolyline != null) {
                    this.mDefaultPolyline.remove();
                    this.mDefaultPolyline = null;
                }
                if (this.mWidth != 0.0f && this.mAMapNaviPath != null) {
                    if (this.normalRoute != null) {
                        if (this.naviArrow != null) {
                            this.naviArrow.setVisible(false);
                        }
                        List<NaviLatLng> coordList = this.mAMapNaviPath.getCoordList();
                        if (coordList != null) {
                            clearTrafficLineAndInvisibleOriginalLine();
                            this.mLatLngsOfPath = new ArrayList(coordList.size());
                            ArrayList arrayList = new ArrayList();
                            if (iArr3 == null) {
                                i = bitmapDescriptorArr2.length;
                            } else {
                                i = iArr3.length;
                            }
                            int i2 = 0;
                            for (int i3 = 0; i3 < i; i3++) {
                                if (iArr4 == null || i3 >= iArr4.length || iArr4[i3] > 0) {
                                    arrayList.clear();
                                    while (i2 < coordList.size()) {
                                        NaviLatLng naviLatLng = coordList.get(i2);
                                        LatLng latLng3 = r13;
                                        LatLng latLng4 = new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude(), false);
                                        this.mLatLngsOfPath.add(latLng3);
                                        arrayList.add(latLng3);
                                        if (iArr4 != null && i3 < iArr4.length && i2 == iArr4[i3]) {
                                            break;
                                        }
                                        i2++;
                                    }
                                    if (bitmapDescriptorArr2 != null) {
                                        if (bitmapDescriptorArr2.length != 0) {
                                            polyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).setCustomTexture(bitmapDescriptorArr2[i3]).width(this.mWidth));
                                            polyline.setVisible(true);
                                            this.mCustomPolylines.add(polyline);
                                        }
                                    }
                                    polyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).color(iArr3[i3]).width(this.mWidth));
                                    polyline.setVisible(true);
                                    this.mCustomPolylines.add(polyline);
                                }
                            }
                            this.mCustomPolylines.add(this.aMap.addPolyline(new PolylineOptions().addAll(this.mLatLngsOfPath).width(this.mWidth).setCustomTexture(this.arrowOnRoute)));
                            if (this.mAMapNaviPath.getStartPoint() == null || this.mAMapNaviPath.getEndPoint() == null) {
                                latLng2 = null;
                                latLng = null;
                                list = null;
                            } else {
                                latLng2 = new LatLng(this.mAMapNaviPath.getStartPoint().getLatitude(), this.mAMapNaviPath.getStartPoint().getLongitude());
                                latLng = new LatLng(this.mAMapNaviPath.getEndPoint().getLatitude(), this.mAMapNaviPath.getEndPoint().getLongitude());
                                list = this.mAMapNaviPath.getWayPoint();
                            }
                            if (this.startMarker != null) {
                                this.startMarker.remove();
                                this.startMarker = null;
                            }
                            if (this.endMarker != null) {
                                this.endMarker.remove();
                                this.endMarker = null;
                            }
                            if (this.wayMarkers != null && this.wayMarkers.size() > 0) {
                                for (int i4 = 0; i4 < this.wayMarkers.size(); i4++) {
                                    Marker marker2 = this.wayMarkers.get(i4);
                                    if (marker2 != null) {
                                        marker2.remove();
                                    }
                                }
                            }
                            if (this.startBitmap == null) {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837754))));
                            } else if (this.startBitmapDescriptor != null) {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(this.startBitmapDescriptor));
                            }
                            if (list != null && list.size() > 0) {
                                int size = list.size();
                                if (this.wayMarkers == null) {
                                    this.wayMarkers = new ArrayList(size);
                                }
                                for (NaviLatLng next : list) {
                                    LatLng latLng5 = new LatLng(next.getLatitude(), next.getLongitude());
                                    if (this.wayBitmap == null) {
                                        marker = this.aMap.addMarker(new MarkerOptions().position(latLng5).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837764))));
                                    } else {
                                        marker = this.wayPointBitmapDescriptor != null ? this.aMap.addMarker(new MarkerOptions().position(latLng5).icon(this.wayPointBitmapDescriptor)) : null;
                                    }
                                    this.wayMarkers.add(marker);
                                }
                            }
                            if (this.endBitmap == null) {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837584))));
                            } else if (this.endBitmapDescriptor != null) {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(this.endBitmapDescriptor));
                            }
                            if (this.isTrafficLine) {
                                setTrafficLine(Boolean.valueOf(this.isTrafficLine));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            hq.a(th2);
            iu.b(th2, "RouteOverLay", "addToMap(int[] color, int[] index, BitmapDescriptor[] resourceArray)");
        }
    }

    public void addToMap(int[] iArr, int[] iArr2) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    addToMap(iArr, iArr2, (BitmapDescriptor[]) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addToMap(BitmapDescriptor[] bitmapDescriptorArr, int[] iArr) {
        if (bitmapDescriptorArr != null) {
            try {
                if (bitmapDescriptorArr.length != 0) {
                    addToMap((int[]) null, iArr, bitmapDescriptorArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setTransparency(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.setTransparency(f);
            }
            for (Polyline transparency : this.mTrafficColorfulPolylines) {
                transparency.setTransparency(f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZindex(int i) {
        try {
            if (this.mTrafficColorfulPolylines != null) {
                for (int i2 = 0; i2 < this.mTrafficColorfulPolylines.size(); i2++) {
                    this.mTrafficColorfulPolylines.get(i2).setZIndex((float) i);
                }
            }
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.setZIndex((float) i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
