package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() {
        /* renamed from: a */
        public AoiItem createFromParcel(Parcel parcel) {
            return new AoiItem(parcel);
        }

        /* renamed from: a */
        public AoiItem[] newArray(int i) {
            return new AoiItem[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private Float e;

    public int describeContents() {
        return 0;
    }

    public AoiItem() {
    }

    public String getAoiId() {
        return this.a;
    }

    public String getAoiName() {
        return this.b;
    }

    public String getAdCode() {
        return this.c;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.d;
    }

    public Float getAoiArea() {
        return this.e;
    }

    public void setId(String str) {
        this.a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setAdcode(String str) {
        this.c = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setArea(Float f) {
        this.e = f;
    }

    public AoiItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = Float.valueOf(parcel.readFloat());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeFloat(this.e.floatValue());
    }
}
