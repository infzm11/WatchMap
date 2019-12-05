package com.amap.api.navi.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.hs;
import com.amap.api.col.n3.iu;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;

public class CameraOverlay {
    private BitmapDescriptor mBitmapDescriptor = null;
    private Marker mCameraMarker;
    private LatLng mLastLatLng = null;

    public CameraOverlay() {
        try {
            this.mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837548));
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "CameraOverlay", "CameraOverlay()");
        }
    }

    public CameraOverlay(BitmapDescriptor bitmapDescriptor) {
        this.mBitmapDescriptor = bitmapDescriptor;
    }

    public void draw(AMap aMap, LatLng latLng) {
        if (aMap != null) {
            try {
                if (this.mCameraMarker == null) {
                    this.mCameraMarker = aMap.addMarker(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).icon(this.mBitmapDescriptor));
                } else if (!latLng.equals(this.mLastLatLng)) {
                    this.mCameraMarker.setPosition(latLng);
                    this.mCameraMarker.setVisible(true);
                } else {
                    return;
                }
                this.mLastLatLng = latLng;
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "CameraOverlay", "draw(AMap aMap, LatLng latLng)");
            }
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.mCameraMarker != null) {
                this.mCameraMarker.setVisible(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.mCameraMarker != null) {
                this.mCameraMarker.remove();
            }
            if (this.mBitmapDescriptor != null) {
                this.mBitmapDescriptor.recycle();
            }
            this.mBitmapDescriptor = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCameraBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
