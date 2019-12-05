package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() {
        /* renamed from: a */
        public LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        /* renamed from: a */
        public LatLonSharePoint[] newArray(int i) {
            return new LatLonSharePoint[i];
        }
    };
    private String a;

    public int describeContents() {
        return 0;
    }

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.a = str;
    }

    public String getSharePointName() {
        return this.a;
    }

    public void setSharePointName(String str) {
        this.a = str;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
    }

    public int hashCode() {
        int i;
        int hashCode = 31 * super.hashCode();
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        if (this.a == null) {
            if (latLonSharePoint.a != null) {
                return false;
            }
        } else if (!this.a.equals(latLonSharePoint.a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return super.toString() + "," + this.a;
    }
}
