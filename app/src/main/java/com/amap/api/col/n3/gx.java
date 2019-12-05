package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PoiItemExtension */
public class gx implements Parcelable {
    public static final Parcelable.Creator<gx> a = new Parcelable.Creator<gx>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new gx(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new gx[i];
        }
    };
    private String b;
    private String c;

    public int describeContents() {
        return 0;
    }

    public gx(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    protected gx(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
