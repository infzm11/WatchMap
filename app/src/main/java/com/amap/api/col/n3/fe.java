package com.amap.api.col.n3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.AMapNaviViewOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: NaviCarOverlay */
public final class fe {
    private int A;
    private boolean a;
    private IPoint b;
    private int c;
    private int d;
    private float e;
    private int f;
    private float g;
    private boolean h;
    private Timer i;
    private float j;
    private int k;
    private eu l;
    private BitmapDescriptor m;
    private BitmapDescriptor n;
    private Marker o;
    private Marker p;
    private Marker q;
    private AMap r;
    private MapView s;
    private boolean t;
    private LatLng u;
    private Polyline v;
    private List<LatLng> w;
    private Bitmap x;
    private Bitmap y;
    private float z;

    static /* synthetic */ void a(fe feVar) {
        Marker marker;
        Marker marker2;
        if (feVar.h && feVar.o != null && feVar.r != null) {
            try {
                IPoint geoPoint = feVar.o.getGeoPoint();
                int i2 = feVar.f;
                feVar.f = i2 + 1;
                if (i2 < 20) {
                    int i3 = feVar.b.x + (feVar.c * feVar.f);
                    int i4 = feVar.b.y + (feVar.d * feVar.f);
                    feVar.j = feVar.g + (feVar.e * ((float) feVar.f));
                    feVar.j %= 1800.0f;
                    if (!(i3 == 0 && i4 == 0)) {
                        geoPoint = new IPoint(i3, i4);
                    }
                    AMapNaviViewOptions viewOptions = feVar.l.getViewOptions();
                    boolean isSensorEnable = viewOptions != null ? viewOptions.isSensorEnable() : true;
                    if (feVar.a) {
                        if (feVar.l.getNaviMode() == 1) {
                            int width = (int) (((double) feVar.s.getWidth()) * feVar.l.getAnchorX());
                            int height = (int) (((double) feVar.s.getHeight()) * feVar.l.getAnchorY());
                            feVar.o.setPositionByPixels(width, height);
                            feVar.o.setFlat(false);
                            if (!isSensorEnable || !(feVar.A == 1 || feVar.A == 2)) {
                                feVar.r.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(0.0f, geoPoint));
                                feVar.o.setRotateAngle(360.0f - feVar.j);
                            } else {
                                feVar.r.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(feVar.z, geoPoint));
                                feVar.o.setRotateAngle(((feVar.z - 360.0f) - feVar.j) % 360.0f);
                            }
                            if (feVar.q != null) {
                                feVar.q.setPositionByPixels(width, height);
                                if (feVar.t) {
                                    marker2 = feVar.q;
                                } else {
                                    marker = feVar.q;
                                    marker.setVisible(false);
                                }
                            }
                        } else {
                            feVar.r.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(feVar.j, geoPoint));
                            int width2 = (int) (((double) feVar.s.getWidth()) * feVar.l.getAnchorX());
                            int height2 = (int) (((double) feVar.s.getHeight()) * feVar.l.getAnchorY());
                            feVar.o.setPositionByPixels(width2, height2);
                            feVar.o.setRotateAngle(0.0f);
                            feVar.o.setFlat(false);
                            if (feVar.q != null) {
                                feVar.q.setPositionByPixels(width2, height2);
                                if (feVar.t) {
                                    marker2 = feVar.q;
                                } else {
                                    marker = feVar.q;
                                    marker.setVisible(false);
                                }
                            }
                        }
                        marker2.setVisible(true);
                    } else {
                        feVar.o.setGeoPoint(geoPoint);
                        feVar.o.setFlat(true);
                        feVar.o.setRotateAngle(360.0f - feVar.j);
                        if (feVar.q != null) {
                            feVar.q.setGeoPoint(geoPoint);
                        }
                    }
                    if (feVar.p != null) {
                        feVar.p.setGeoPoint(geoPoint);
                    }
                    if (feVar.p != null) {
                        feVar.p.setRotateAngle(360.0f - feVar.j);
                    }
                    if (feVar.k != -1) {
                        if (feVar.u != null) {
                            new DPoint();
                            DPoint a2 = hu.a((long) geoPoint.x, (long) geoPoint.y);
                            LatLng latLng = new LatLng(a2.y, a2.x, false);
                            feVar.w.clear();
                            feVar.w.add(latLng);
                            feVar.w.add(feVar.u);
                            if (feVar.v == null) {
                                feVar.v = feVar.r.addPolyline(new PolylineOptions().add(latLng).add(feVar.u).color(feVar.k).width(5.0f));
                            } else {
                                feVar.v.setPoints(feVar.w);
                            }
                        } else if (feVar.v != null) {
                            feVar.v.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "NaviCarOverlay", "drawLeaderLine(IPoint nowPoint");
            }
        }
    }

    public fe(MapView mapView, eu euVar) {
        this.a = true;
        this.b = null;
        this.g = 0.0f;
        this.h = false;
        this.j = 0.0f;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.r = null;
        this.t = true;
        this.u = null;
        this.v = null;
        this.w = new ArrayList();
        this.A = 0;
        this.m = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837549));
        this.n = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837686));
        this.s = mapView;
        this.l = euVar;
    }

    public final void a() {
        if (this.a && this.p != null) {
            this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.p.getPosition(), (float) this.l.getLockZoom(), 0.0f, 0.0f)));
            this.o.setRotateAngle(360.0f - this.j);
        }
    }

    public final void b() {
        if (this.a && this.p != null) {
            this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.p.getPosition(), (float) this.l.getLockZoom(), (float) this.l.getLockTilt(), this.j)));
            this.o.setRotateAngle(0.0f);
        }
    }

    public final void a(boolean z2) {
        this.a = z2;
        if (this.o != null && this.r != null && this.q != null && this.p != null) {
            if (!this.a) {
                this.o.setFlat(true);
                this.q.setGeoPoint(this.p.getGeoPoint());
                this.o.setGeoPoint(this.p.getGeoPoint());
                this.o.setRotateAngle(this.p.getRotateAngle());
            } else if (this.l.getNaviMode() == 1) {
                this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.p.getPosition()).bearing(0.0f).tilt(0.0f).zoom((float) this.l.getLockZoom()).build()));
                this.o.setPositionByPixels((int) (((double) this.s.getWidth()) * this.l.getAnchorX()), (int) (((double) this.s.getHeight()) * this.l.getAnchorY()));
                this.o.setRotateAngle(360.0f - this.j);
                this.o.setFlat(false);
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            } else {
                this.r.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.p.getPosition()).bearing(this.j).tilt((float) this.l.getLockTilt()).zoom((float) this.l.getLockZoom()).build()));
                this.o.setPositionByPixels((int) (((double) this.s.getWidth()) * this.l.getAnchorX()), (int) (((double) this.s.getHeight()) * this.l.getAnchorY()));
                this.o.setRotateAngle(0.0f);
                this.o.setFlat(false);
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            }
        }
    }

    public final void c() {
        if (this.o != null) {
            this.o.remove();
        }
        if (this.q != null) {
            this.q.remove();
        }
        if (this.p != null) {
            this.p.remove();
        }
        if (this.v != null) {
            this.v.remove();
        }
        this.v = null;
        this.o = null;
        this.q = null;
        this.p = null;
    }

    public final void a(AMap aMap, LatLng latLng, float f2) {
        if (aMap != null && latLng != null && this.m != null) {
            this.r = aMap;
            if (this.o == null) {
                this.o = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.m).position(latLng));
            }
            boolean z2 = false;
            if (this.p == null) {
                this.p = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.m).position(latLng));
                this.p.setRotateAngle(f2);
                this.p.setVisible(false);
            }
            if (this.q == null) {
                this.q = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.n).position(latLng));
                if (this.t) {
                    this.q.setVisible(true);
                } else {
                    this.q.setVisible(false);
                }
            }
            this.o.setVisible(true);
            new IPoint();
            IPoint a2 = hu.a(latLng.latitude, latLng.longitude);
            if (this.o != null) {
                IPoint geoPoint = this.p.getGeoPoint();
                if (geoPoint == null || geoPoint.x == 0 || geoPoint.y == 0) {
                    geoPoint = a2;
                }
                this.f = 0;
                this.b = geoPoint;
                this.c = (a2.x - geoPoint.x) / 20;
                this.d = (a2.y - geoPoint.y) / 20;
                this.g = this.p.getRotateAngle();
                if (Float.compare(this.g, f2) == 0) {
                    z2 = true;
                } else {
                    this.g = 360.0f - this.g;
                }
                float f3 = f2 - this.g;
                if (z2) {
                    f3 = 0.0f;
                }
                if (f3 > 180.0f) {
                    f3 -= 360.0f;
                } else if (f3 < -180.0f) {
                    f3 += 360.0f;
                }
                this.e = f3 / 20.0f;
                this.h = true;
            }
            if (this.i == null) {
                this.i = new Timer();
                this.i.schedule(new TimerTask() {
                    public final void run() {
                        try {
                            fe.a(fe.this);
                        } catch (Throwable unused) {
                        }
                    }
                }, 0, 50);
            }
        }
    }

    public final void a(LatLng latLng) {
        this.u = latLng;
    }

    public final void d() {
        if (this.o != null) {
            this.o.remove();
        }
        if (this.p != null) {
            this.p.remove();
        }
        if (this.q != null) {
            this.q.remove();
        }
        this.m = null;
        if (this.i != null) {
            this.i.cancel();
        }
    }

    public final void e() {
        if (this.v != null) {
            this.v.remove();
        }
    }

    public final void a(int i2) {
        if (i2 == -1 && this.v != null) {
            this.v.remove();
        }
        this.k = i2;
    }

    public final void f() {
        if (this.o != null) {
            int width = (int) (((double) this.s.getWidth()) * this.l.getAnchorX());
            int height = (int) (((double) this.s.getHeight()) * this.l.getAnchorY());
            if (this.a) {
                LatLng position = this.p.getPosition();
                if (this.l.getNaviMode() == 1) {
                    int width2 = (int) (((double) this.s.getWidth()) * this.l.getAnchorX());
                    int height2 = (int) (((double) this.s.getHeight()) * this.l.getAnchorY());
                    this.o.setPositionByPixels(width2, height2);
                    this.o.setFlat(false);
                    this.r.moveCamera(CameraUpdateFactory.changeBearing(0.0f));
                    this.o.setRotateAngle(360.0f - this.j);
                    if (this.q != null) {
                        this.q.setPositionByPixels(width2, height2);
                        if (this.t) {
                            this.q.setVisible(true);
                        } else {
                            this.q.setVisible(false);
                        }
                    }
                } else {
                    this.r.moveCamera(CameraUpdateFactory.changeBearing(this.j));
                    this.r.moveCamera(CameraUpdateFactory.changeLatLng(position));
                    this.o.setPositionByPixels(width, height);
                    if (this.q != null) {
                        this.q.setPositionByPixels(width, height);
                        if (!this.t || !this.a) {
                            this.q.setVisible(false);
                        } else {
                            this.q.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    public final void a(Bitmap bitmap) {
        this.x = bitmap;
        this.m = BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public final void b(Bitmap bitmap) {
        this.y = bitmap;
        this.n = BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public final void a(float f2) {
        this.z = f2;
    }

    public final void b(int i2) {
        this.A = i2;
    }
}
