package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng a = null;
    private double b = 0.0d;

    public int describeContents() {
        return 0;
    }

    public CircleHoleOptions() {
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public CircleHoleOptions radius(double d) {
        this.b = d;
        return this;
    }

    public LatLng getCenter() {
        return this.a;
    }

    public double getRadius() {
        return this.b;
    }

    protected CircleHoleOptions(Parcel parcel) {
        this.a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.b = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            bundle.putDouble("lat", this.a.latitude);
            bundle.putDouble("lng", this.a.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.b);
    }
}
