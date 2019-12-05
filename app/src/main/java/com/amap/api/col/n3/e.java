package com.amap.api.col.n3;

import android.location.Location;
import com.amap.api.maps.LocationSource;

/* compiled from: AMapOnLocationChangedListener */
final class e implements LocationSource.OnLocationChangedListener {
    Location a;
    private k b;

    e(k kVar) {
        this.b = kVar;
    }

    public final void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.a(location);
            }
        } catch (Throwable th) {
            iu.b(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
