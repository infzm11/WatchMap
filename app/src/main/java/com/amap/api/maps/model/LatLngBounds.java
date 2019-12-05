package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.n3.dv;

public final class LatLngBounds implements Parcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.a = Math.min(this.a, latLng.latitude);
            this.b = Math.max(this.b, latLng.latitude);
            double d2 = latLng.longitude;
            if (Double.isNaN(this.c)) {
                this.c = d2;
            } else {
                boolean z = false;
                if (this.c > this.d ? this.c <= d2 || d2 <= this.d : this.c <= d2 && d2 <= this.d) {
                    z = true;
                }
                if (!z) {
                    if (LatLngBounds.c(this.c, d2) < LatLngBounds.d(this.d, d2)) {
                        this.c = d2;
                    }
                }
                return this;
            }
            this.d = d2;
            return this;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.c)) {
                return null;
            }
            if (this.c > this.d) {
                double d2 = this.c;
                this.c = this.d;
                this.d = d2;
            }
            if (this.a > this.b) {
                double d3 = this.a;
                this.a = this.b;
                this.b = d3;
            }
            LatLng latLng = new LatLng(this.a, this.c, false);
            LatLng latLng2 = new LatLng(this.b, this.d, false);
            return new LatLngBounds(latLng, latLng2);
        }
    }

    /* access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final int describeContents() {
        return 0;
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        boolean z;
        if (latLng == null) {
            try {
                throw new RuntimeRemoteException("null southwest");
            } catch (Throwable th) {
                th.printStackTrace();
                z = false;
            }
        } else if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        } else if (latLng2.latitude < latLng.latitude) {
            throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
        } else {
            z = true;
            this.a = !z ? 0 : i;
            LatLng latLng3 = null;
            this.southwest = !z ? null : latLng;
            this.northeast = z ? latLng2 : latLng3;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.a;
    }

    public static Builder builder() {
        return new Builder();
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double d = latLng.latitude;
        if (!(this.southwest.latitude <= d && d <= this.northeast.latitude) || !a(latLng.longitude)) {
            return false;
        }
        return true;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        if (a(latLngBounds) || latLngBounds.a(this)) {
            return true;
        }
        return false;
    }

    private boolean a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) {
            return false;
        }
        double d = ((latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude;
        double d2 = ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude;
        double d3 = ((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude;
        double d4 = ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        if (Math.abs(d) >= d2 || Math.abs(d3) >= d4) {
            return false;
        }
        return true;
    }

    public final LatLngBounds including(LatLng latLng) {
        double d;
        LatLng latLng2 = latLng;
        if (latLng2 == null || this.northeast == null || this.southwest == null) {
            return this;
        }
        double min = Math.min(this.southwest.latitude, latLng2.latitude);
        double max = Math.max(this.northeast.latitude, latLng2.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng2.longitude;
        if (!a(d4)) {
            if (c(d3, d4) < d(d2, d4)) {
                d3 = d4;
            } else {
                d = d4;
                LatLng latLng3 = new LatLng(min, d3, false);
                LatLng latLng4 = new LatLng(max, d, false);
                return new LatLngBounds(latLng3, latLng4);
            }
        }
        d = d2;
        try {
            LatLng latLng32 = new LatLng(min, d3, false);
            LatLng latLng42 = new LatLng(max, d, false);
            return new LatLngBounds(latLng32, latLng42);
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    private boolean a(double d) {
        return this.southwest.longitude <= this.northeast.longitude ? this.southwest.longitude <= d && d <= this.northeast.longitude : this.southwest.longitude <= d || d <= this.northeast.longitude;
    }

    public final int hashCode() {
        return dv.a(new Object[]{this.southwest, this.northeast});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final String toString() {
        return dv.a(dv.a("southwest", (Object) this.southwest), dv.a("northeast", (Object) this.northeast));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.a(this, parcel, i);
    }
}
