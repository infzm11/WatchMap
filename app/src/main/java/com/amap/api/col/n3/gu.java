package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Photo */
public final class gu implements Parcelable {
    public static final Parcelable.Creator<gu> a = new Parcelable.Creator<gu>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return null;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new gu(parcel);
        }
    };
    private String b;
    private String c;

    public final int describeContents() {
        return 0;
    }

    public gu() {
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public gu(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
