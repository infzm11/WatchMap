package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiInfo implements Parcelable {
    public static final Parcelable.Creator<PoiInfo> CREATOR = new Parcelable.Creator<PoiInfo>() {
        public PoiInfo createFromParcel(Parcel parcel) {
            return new PoiInfo(parcel);
        }

        public PoiInfo[] newArray(int i) {
            return new PoiInfo[i];
        }
    };
    private int category = 0;
    private int distance = -1;
    private double latitude;
    private long locationTime;
    private double longitude;
    private String poiAddress;
    private String poiCity;
    private String poiName;
    private String spwResult;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.poiName);
        parcel.writeString(this.poiAddress);
        parcel.writeString(this.poiCity);
        parcel.writeInt(this.distance);
        parcel.writeInt(this.category);
        parcel.writeLong(this.locationTime);
        parcel.writeString(this.spwResult);
    }

    public PoiInfo() {
    }

    public PoiInfo(Parcel parcel) {
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.poiName = parcel.readString();
        this.poiAddress = parcel.readString();
        this.poiCity = parcel.readString();
        this.distance = parcel.readInt();
        this.category = parcel.readInt();
        this.locationTime = parcel.readLong();
        this.spwResult = parcel.readString();
    }

    public long getLocationTime() {
        return this.locationTime;
    }

    public void setLocationTime(long j) {
        this.locationTime = j;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public String getPoiAddress() {
        return this.poiAddress;
    }

    public void setPoiAddress(String str) {
        this.poiAddress = str;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public String getPoiCity() {
        return this.poiCity;
    }

    public void setPoiCity(String str) {
        this.poiCity = str;
    }

    public String getSpwResult() {
        return this.spwResult;
    }

    public void setSpwResult(String str) {
        this.spwResult = str;
    }
}
