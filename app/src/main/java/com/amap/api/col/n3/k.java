package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.listener.MapWidgetListener;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.message.GestureMapMessage;

/* compiled from: IAMapDelegate */
public interface k extends IAMap {
    int a(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    r a(BitmapDescriptor bitmapDescriptor);

    LatLngBounds a(LatLng latLng, float f);

    GLMapEngine a();

    void a(double d, double d2, FPoint fPoint);

    void a(double d, double d2, IPoint iPoint);

    void a(float f, float f2, IPoint iPoint);

    void a(int i);

    void a(int i, float f);

    void a(int i, int i2);

    void a(int i, int i2, PointF pointF);

    void a(int i, int i2, DPoint dPoint);

    void a(int i, int i2, FPoint fPoint);

    void a(int i, int i2, IPoint iPoint);

    void a(int i, MotionEvent motionEvent);

    void a(int i, GestureMapMessage gestureMapMessage);

    void a(Location location) throws RemoteException;

    void a(cf cfVar) throws RemoteException;

    void a(r rVar);

    void a(MapWidgetListener mapWidgetListener);

    void a(CameraUpdateMessage cameraUpdateMessage) throws RemoteException;

    void a(boolean z);

    boolean a(MotionEvent motionEvent);

    boolean a(String str) throws RemoteException;

    float b(int i);

    void b(double d, double d2, IPoint iPoint);

    void b(int i, int i2, DPoint dPoint);

    void b(CameraUpdateMessage cameraUpdateMessage) throws RemoteException;

    void b(String str);

    void b(boolean z);

    boolean b();

    boolean b(int i, MotionEvent motionEvent);

    GLMapState c();

    String c(String str);

    void c(int i);

    void c(boolean z);

    int d();

    void d(boolean z);

    boolean d(int i);

    int e();

    void e(int i);

    void e(boolean z);

    float f(int i);

    int f();

    void f(boolean z);

    void g();

    void g(int i);

    float h();

    void h(int i);

    n i();

    void i(int i);

    float j(int i);

    void j();

    float k(int i);

    void k();

    float l(int i);

    Point l();

    View m();

    cv m(int i);

    boolean n();

    int o();

    int p();

    Point r();

    float t();

    Context u();

    float[] v();

    cw w();
}
