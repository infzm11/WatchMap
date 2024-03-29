package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() {
        /* renamed from: a */
        public LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        /* renamed from: a */
        public LatLonPoint[] newArray(int i) {
            return new LatLonPoint[i];
        }
    };
    private double a;
    private double b;

    public int describeContents() {
        return 0;
    }

    public LatLonPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public double getLatitude() {
        return this.a;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.a, this.b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (31 * (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31)) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.a) == Double.doubleToLongBits(latLonPoint.a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
    }

    public String toString() {
        return "" + this.a + "," + this.b;
    }

    protected LatLonPoint(Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
