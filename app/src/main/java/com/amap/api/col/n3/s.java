package com.amap.api.col.n3;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: ProjectionDelegateImp */
final class s implements m {
    private k a;

    public s(k kVar) {
        this.a = kVar;
    }

    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.a.b(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain.recycle();
        return latLng;
    }

    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.a.b(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(obtain.x, obtain.y);
        obtain.recycle();
        return point;
    }

    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.a.getMapWidth();
        int mapHeight = this.a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        VisibleRegion visibleRegion = new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
        return visibleRegion;
    }

    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.a.a(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(obtain.x, obtain.y);
        obtain.recycle();
        return pointF;
    }

    public final float toMapLenWithWin(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.a.f(i);
    }

    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        LatLngBounds latLngBounds2 = latLngBounds;
        int i3 = i;
        if (latLngBounds2 == null || i3 < 0 || i3 > 20 || i2 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        this.a.a(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude, obtain);
        this.a.a(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude, obtain2);
        int i4 = 20 - i3;
        int i5 = (obtain.x >> i4) / i2;
        int i6 = (obtain.y >> i4) / i2;
        int i7 = (obtain2.x >> i4) / i2;
        int i8 = (obtain2.y >> i4) / i2;
        int i9 = obtain.x;
        int i10 = obtain2.y;
        obtain.recycle();
        obtain2.recycle();
        TileProjection tileProjection = new TileProjection((i9 - ((i5 << i4) * i2)) >> i4, (i10 - ((i8 << i4) * i2)) >> i4, i5, i7, i8, i6);
        return tileProjection;
    }

    public final LatLngBounds getMapBounds(LatLng latLng, float f) throws RemoteException {
        if (this.a == null || latLng == null) {
            return null;
        }
        return this.a.a(latLng, f);
    }

    public final AMapCameraInfo getCameraInfo() {
        return this.a.getCamerInfo();
    }
}
