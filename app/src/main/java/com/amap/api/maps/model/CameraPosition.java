package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.n3.dq;
import com.amap.api.col.n3.dv;
import com.amap.api.col.n3.iu;

public final class CameraPosition implements Parcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public final Builder target(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public final Builder zoom(float f) {
            this.b = f;
            return this;
        }

        public final Builder tilt(float f) {
            this.c = f;
            return this;
        }

        public final Builder bearing(float f) {
            this.d = f;
            return this;
        }

        public final CameraPosition build() {
            try {
                if (this.a == null) {
                    return null;
                }
                return new CameraPosition(this.a, this.b, this.c, this.d);
            } catch (Throwable th) {
                iu.b(th, "CameraPosition", "build");
                return null;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !dq.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public final String toString() {
        return dv.a(dv.a("target", (Object) this.target), dv.a("zoom", (Object) Float.valueOf(this.zoom)), dv.a("tilt", (Object) Float.valueOf(this.tilt)), dv.a("bearing", (Object) Float.valueOf(this.bearing)));
    }
}
