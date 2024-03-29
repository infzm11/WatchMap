package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        /* renamed from: a */
        public Photo[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }
    };
    private String a;
    private String b;

    public int describeContents() {
        return 0;
    }

    public Photo() {
    }

    public Photo(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String getTitle() {
        return this.a;
    }

    public void setTitle(String str) {
        this.a = str;
    }

    public String getUrl() {
        return this.b;
    }

    public void setUrl(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public Photo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
