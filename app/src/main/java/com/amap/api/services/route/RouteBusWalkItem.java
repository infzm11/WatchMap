package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() {
        /* renamed from: a */
        public RouteBusWalkItem[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public RouteBusWalkItem createFromParcel(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }
    };
    private LatLonPoint a;
    private LatLonPoint b;

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getOrigin() {
        return this.a;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public LatLonPoint getDestination() {
        return this.b;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public RouteBusWalkItem() {
    }
}
