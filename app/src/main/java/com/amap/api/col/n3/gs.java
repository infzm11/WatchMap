package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: LatLonPoint */
public class gs implements Parcelable {
    public static final Parcelable.Creator<gs> a = new Parcelable.Creator<gs>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new gs(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new gs[i];
        }
    };
    private double b;
    private double c;

    public int describeContents() {
        return 0;
    }

    public gs(double d, double d2) {
        this.b = d;
        this.c = d2;
    }

    public final double a() {
        return this.c;
    }

    public final double b() {
        return this.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.c);
        return (31 * (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31)) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gs gsVar = (gs) obj;
        return Double.doubleToLongBits(this.b) == Double.doubleToLongBits(gsVar.b) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(gsVar.c);
    }

    public String toString() {
        return this.b + "," + this.c;
    }

    protected gs(Parcel parcel) {
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
    }
}
