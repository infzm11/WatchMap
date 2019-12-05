package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() {
        /* renamed from: a */
        public RouteSearchCity[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public RouteSearchCity createFromParcel(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }
    };
    List<District> a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.a;
    }

    public void setDistricts(List<District> list) {
        this.a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(District.CREATOR);
    }

    public RouteSearchCity() {
    }
}
