package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() {
        /* renamed from: a */
        public RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        /* renamed from: a */
        public RailwaySpace[] newArray(int i) {
            return new RailwaySpace[i];
        }
    };
    private String a;
    private float b;

    public int describeContents() {
        return 0;
    }

    public RailwaySpace(String str, float f) {
        this.a = str;
        this.b = f;
    }

    public String getCode() {
        return this.a;
    }

    public float getCost() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFloat();
    }
}
