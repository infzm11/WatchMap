package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IndoorData */
public class gm implements Parcelable {
    public static final Parcelable.Creator<gm> a = new Parcelable.Creator<gm>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new gm(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new gm[i];
        }
    };
    private String b;
    private int c;
    private String d;

    public int describeContents() {
        return 0;
    }

    public gm(String str, int i, String str2) {
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    protected gm(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }
}
