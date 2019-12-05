package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() {
        /* renamed from: a */
        public CloudImage createFromParcel(Parcel parcel) {
            return new CloudImage(parcel);
        }

        /* renamed from: a */
        public CloudImage[] newArray(int i) {
            return new CloudImage[i];
        }
    };
    private String a;
    private String b;
    private String c;

    public int describeContents() {
        return 0;
    }

    public CloudImage(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public CloudImage(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public String getId() {
        return this.a;
    }

    public void setId(String str) {
        this.a = str;
    }

    public String getPreurl() {
        return this.b;
    }

    public void setPreurl(String str) {
        this.b = str;
    }

    public String getUrl() {
        return this.c;
    }

    public void setUrl(String str) {
        this.c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
